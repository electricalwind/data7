package data7.importer.sources.git;

/*-
 * #%L
 * Data7
 * %%
 * Copyright (C) 2018 University of Luxembourg, Matthieu Jimenez
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */


import data7.importer.Data7Source;
import data7.model.change.Commit;
import data7.model.vulnerability.Vulnerability;
import gitUtilitaries.GitActions;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.revwalk.RevCommit;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.*;

import static data7.Resources.NB_THREADS;
import static data7.Utils.generateCommitOfInterest;


public class GitAnalysis extends Data7Source {

    public static String NAME = "GIT ANALYSIS";

    public GitAnalysis() {
        super();
    }

    public void process() {

        Map<String, Set<String>> componentAlreadyProcessedHash = dataset.getAlreadyProcessedHash();
        dataset.getProject().getSubProjects().forEach((component, metaInf) -> {
            GitActions git = gitmap.get(component);
            Set<String> alreadyProcessed = componentAlreadyProcessedHash.getOrDefault(component, new HashSet<>());
            ExecutorService executor = Executors.newFixedThreadPool(NB_THREADS);
            int errornb = 0;
            try {
                CompletionService<MatchingCommit> completionService = new ExecutorCompletionService(executor);
                int count = 0;
                for (RevCommit revCommit : git.getGit().log().all().call()) {
                    String hash = revCommit.getName();
                    if (!alreadyProcessed.contains(hash)) {
                        alreadyProcessed.add(hash);
                        CommitRegexp commitRegexp = new CommitRegexp(metaInf, revCommit);
                        completionService.submit(commitRegexp);
                        count++;
                    }
                }
                int received = 0;
                while (received < count) {
                    Future<MatchingCommit> fut = completionService.take();
                    try {
                        MatchingCommit result = fut.get();
                        if (result.getCve() != null) {
                            handleCVEMatch(git, result, component);
                        }
                        if (result.getBugId() != null) {
                            handleBugIdMatch(git, result, component);
                        }
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                        errornb++;
                    } finally {
                        received++;
                    }
                }
            } catch (InterruptedException | GitAPIException | IOException e) {
                e.printStackTrace();
            } finally {
                System.err.println("error for component" + component + " : " + errornb);
                executor.shutdown();
                componentAlreadyProcessedHash.put(component, alreadyProcessed);
            }
        });


    }

    @Override
    public String sourceName() {
        return NAME;
    }

    private void handleBugIdMatch(GitActions git, MatchingCommit result, String component) {
        Map<String, List<String>> btc = dataset.getBugToCve().getOrDefault(component, new HashMap<>());
        Map<String, List<String>> bth = dataset.getBugToCve().getOrDefault(component, new HashMap<>());

        if (dataset.getBugToCve().containsKey(result.getBugId())) {
            List<String> cves = btc.getOrDefault(result.getBugId(), new ArrayList<>());
            for (String cve : cves) {
                Vulnerability vulnerability = dataset.getVulnerabilitySet().getVulnerabilityDataset().get(cve);
                if (!vulnerability.getPatchingCommits().containsKey(result.getCommit().getName())) {
                    Commit commit = generateCommitOfInterest(git, result.getCommit(), true);
                    Map<String, Commit> patchmap = vulnerability.getPatchingCommits().getOrDefault(component, new HashMap<>());
                    patchmap.put(result.getCommit().getName(), commit);
                    vulnerability.getPatchingCommits().put(component, patchmap);
                    commitAddedToVulnerabilityEvent(vulnerability, result.getCommit().getName(), component);
                }
                Set<String> bugset = vulnerability.getBugIds().getOrDefault(component, new HashSet<>());
                if (bugset.add(result.getBugId())) {
                    bugAddedToVulnerabilityEvent(vulnerability, result.getBugId(), component);
                }
                vulnerability.getBugIds().put(component, bugset);
            }
        }
        if (bth.containsKey(result.getBugId())) {
            bth.get(result.getBugId()).add(result.getCommit().getName());
        } else {
            List<String> hashes = new ArrayList<>();
            hashes.add(result.getCommit().getName());
            bth.put(result.getBugId(), hashes);
        }
        dataset.getBugToCve().put(component, btc);
        dataset.getBugToHash().put(component, bth);
    }

    private void handleCVEMatch(GitActions git, MatchingCommit result, String component) {

        if (dataset.getVulnerabilitySet().getVulnerabilityDataset().containsKey(result.getCve())) {
            Vulnerability vulnerability = dataset.getVulnerabilitySet().getVulnerabilityDataset().get(result.getCve());

            Commit commit = generateCommitOfInterest(git, result.getCommit(), true);
            Map<String, Commit> patchmap = vulnerability.getPatchingCommits().getOrDefault(component, new HashMap<>());
            patchmap.put(result.getCommit().getName(), commit);
            vulnerability.getPatchingCommits().put(component, patchmap);

            if (result.getBugId() != null) {

                Set<String> bugset = vulnerability.getBugIds().getOrDefault(component, new HashSet<>());
                if (bugset.add(result.getBugId())) {
                    bugAddedToVulnerabilityEvent(vulnerability, result.getBugId(), component);
                }
                vulnerability.getBugIds().put(component, bugset);
            }
            commitAddedToVulnerabilityEvent(vulnerability, result.getCommit().getName(), component);
        } else {
            if (dataset.getUnknownCVEToHash().containsKey(result.getCve())) {
                List<String> hashList = dataset.getUnknownCVEToHash().get(result.getCve()).getOrDefault(component, new ArrayList<>());
                hashList.add(result.getCommit().getName());
                dataset.getUnknownCVEToHash().get(result.getCve()).put(component, hashList);
            } else {

                List<String> hashes = new ArrayList<>();
                hashes.add(result.getCommit().getName());
                HashMap<String, List<String>> mapcomponent = new HashMap<>();
                mapcomponent.put(component, hashes);
                dataset.getUnknownCVEToHash().put(result.getCve(), mapcomponent);
            }
        }
    }


}
