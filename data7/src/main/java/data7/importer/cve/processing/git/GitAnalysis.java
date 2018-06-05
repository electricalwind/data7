package data7.importer.cve.processing.git;

/*-
 * #%L
 * Data7
 * %%
 * Copyright (C) 2018 Matthieu Jimenez
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

import data7.importer.cve.DatasetUpdateListener;
import data7.model.Data7;
import data7.model.change.Commit;
import data7.model.change.FileFix;
import data7.model.change.FileInterest;
import data7.model.vulnerability.Vulnerability;
import gitUtilitaries.GitActions;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.revwalk.RevCommit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

import static data7.Resources.FILE_EXTENSION;
import static data7.Resources.NB_THREADS;
import static data7.Utils.generateCommitOfInterest;


public class GitAnalysis {

    private final Data7 dataset;
    private final DatasetUpdateListener[] listeners;
    private final GitActions git;

    private GitAnalysis(Data7 dataset, DatasetUpdateListener[] listeners, GitActions git) {
        this.dataset = dataset;
        this.git = git;
        if (listeners == null){
            this.listeners = new DatasetUpdateListener[0];
        }else{
            this.listeners = listeners;}
    }

    private void process() {

        Set<String> alreadyProcessed = dataset.getAlreadyProcessedHash();
        ExecutorService executor = Executors.newFixedThreadPool(NB_THREADS);
        int errornb = 0;
        try {
            CompletionService<MatchingCommit> completionService = new ExecutorCompletionService(executor);
            int count = 0;
            Iterator<RevCommit> revCommitIterator = git.getGit().log().all().call().iterator();
            while (revCommitIterator.hasNext()) {
                RevCommit revCommit = revCommitIterator.next();
                String hash = revCommit.getName();
                if (!alreadyProcessed.contains(hash)) {
                    alreadyProcessed.add(hash);
                    CommitRegexp commitRegexp = new CommitRegexp(dataset.getProject(), revCommit);
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
                        handleCVEMatch(result);
                    }
                    if (result.getBugId() != null) {
                        handleBugIdMatch(result);
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
            System.err.println("error : " + errornb);
            executor.shutdown();
        }


    }

    private void handleBugIdMatch(MatchingCommit result) {
        if (dataset.getBugToCve().containsKey(result.getBugId())) {
            List<String> cves = dataset.getBugToCve().get(result.getBugId());
            for (String cve : cves) {
                Vulnerability vulnerability = dataset.getVulnerabilitySet().getVulnerabilityDataset().get(cve);
                if (!vulnerability.getPatchingCommits().containsKey(result.getCommit().getName())) {
                    Commit commit = generateCommitOfInterest(git, result.getCommit(),true);
                    vulnerability.getPatchingCommits().put(result.getCommit().getName(), commit);
                    commitAddedToVulnerabilityEvent(vulnerability, result.getCommit().getName());
                }
                if (vulnerability.getBugIds().add(result.getBugId())) {
                    bugAddedToVulnerabilityEvent(vulnerability, result.getBugId());
                }
            }
        }
        if (dataset.getBugToHash().containsKey(result.getBugId())) {
            dataset.getBugToHash().get(result.getBugId()).add(result.getCommit().getName());
        } else {
            List<String> hashes = new ArrayList<>();
            hashes.add(result.getCommit().getName());
            dataset.getBugToHash().put(result.getBugId(), hashes);
        }
    }

    private void handleCVEMatch(MatchingCommit result) {
        if (dataset.getVulnerabilitySet().getVulnerabilityDataset().containsKey(result.getCve())) {
            Vulnerability vulnerability = dataset.getVulnerabilitySet().getVulnerabilityDataset().get(result.getCve());
            Commit commit = generateCommitOfInterest(git, result.getCommit(),true);
            vulnerability.getPatchingCommits().put(result.getCommit().getName(), commit);
            if (result.getBugId() != null) {
                vulnerability.getBugIds().add(result.getBugId());
                bugAddedToVulnerabilityEvent(vulnerability, result.getBugId());
            }
            commitAddedToVulnerabilityEvent(vulnerability, result.getCommit().getName());
        } else {
            if (dataset.getUnknownCVEToHash().containsKey(result.getCve())) {
                dataset.getUnknownCVEToHash().get(result.getCve()).add(result.getCommit().getName());
            } else {
                List<String> hashes = new ArrayList<>();
                hashes.add(result.getCommit().getName());
                dataset.getUnknownCVEToHash().put(result.getCve(), hashes);
            }
        }
    }


    private void bugAddedToVulnerabilityEvent(Vulnerability vulnerability, String bugId) {
        for (DatasetUpdateListener listener : listeners) {
            listener.bugAddedTo(vulnerability, bugId);
        }
    }

    private void commitAddedToVulnerabilityEvent(Vulnerability vulnerability, String hash) {
        for (DatasetUpdateListener listener : listeners) {
            listener.commitAddedTo(vulnerability, hash);
        }
    }

    public static void proceedWithAnalysis(Data7 dataset, DatasetUpdateListener[] listeners, GitActions git) {
        new GitAnalysis(dataset, listeners, git).process();
    }

}
