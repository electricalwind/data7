package data7.importer.cve.processing.cve;

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
import data7.project.MetaInformation;
import data7.model.vulnerability.Vulnerability;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static data7.Utils.generateCommitOfInterest;


/**
 *
 */
public class CVEAnalysis extends Data7Source {

    public static String NAME = "CVE ANALYSIS";

    private  final List<CVE> cveList;

    public CVEAnalysis(List<CVE> cveList) {
        super();
        this.cveList = cveList;
    }


    /**
     * Main function to be called
     */
    public void process() {

        Map<String, Vulnerability> vd = dataset.getVulnerabilitySet().getVulnerabilityDataset();
        //For each of the cve found in the parsing step
        for (CVE cve : cveList) {
            //if the vulnerability exist then update the entry
            if (vd.containsKey(cve.getCVE())) {
                updateVulnerability(cve, vd);
            } else { //otherwise create a new vulnerability entry
                createVulnerability(cve, vd);
            }
        }
    }

    @Override
    public String sourceName() {
        return NAME;
    }

    /**
     * Function to update a vulnerability entry
     *
     * @param cve object
     * @param vd  corresponding to the cve
     */
    private void updateVulnerability(CVE cve, Map<String, Vulnerability> vd) {
        Vulnerability vulnerability = vd.get(cve.getCVE());
        //if the latest modification is not more recent than the previous one just do nothing
        if (cve.getLastModified() > vulnerability.getLastModified()) {
            vulnerability.setLastModified(cve.getLastModified());
            //updating the cwe if needed
            if (!cve.getCWE().equals(vulnerability.getCwe())) {
                updateCWE(vulnerability, cve.getCWE());
            }
            //updating the score if needed
            if (!cve.getScore().equals(vulnerability.getScore())) {
                updateScore(vulnerability, cve.getScore());
            }
            handleHashAndBugIds(cve, vulnerability, false);
        }
    }

    /**
     * Function to create a vulnerability entry from a CVE object
     *
     * @param cve
     */
    private void createVulnerability(CVE cve, Map<String, Vulnerability> vd) {
        //Create the vulnerability object
        Vulnerability vulnerability = createVulnerabilityEntry(cve);
        //For each hash retrieve the fixes
        handleHashAndBugIds(cve, vulnerability, true);
        vd.put(cve.getCVE(), vulnerability);
    }

    private Vulnerability createVulnerabilityEntry(CVE cve) {
        Vulnerability vulnerability = new Vulnerability(cve);
        newVulnerabilityEvent(vulnerability);
        return vulnerability;
    }


    private void handleHashAndBugIds(CVE cve, Vulnerability vulnerability, boolean newEntry) {
        if(dataset.getUnknownCVEToHash().containsKey(cve.getCVE())){
            dataset.getUnknownCVEToHash().get(cve.getCVE()).forEach((component,listhash)->{
                Set<String> strings = cve.getPatchingCommits().getOrDefault(component,new HashSet<>());
                strings.addAll(listhash);
                cve.getPatchingCommits().put(component,strings);
            });
        }

        //for each hash check whether it's already been handled
        cve.getPatchingCommits().forEach((component, commitList) -> {
            Map<String, Commit> patching = vulnerability.getPatchingCommits().getOrDefault(component, new HashMap<>());
            for (String hash : commitList) {
                if (newEntry || !vulnerability.getPatchingCommits().containsKey(hash)) {
                    Commit commit = addCommitOfInterest(vulnerability, hash, component);
                    if (commit != null)
                        patching.put(hash, commit);
                }
            }
            vulnerability.getPatchingCommits().put(component, patching);
        });

        cve.getBugsId().forEach((component, bugList) -> {
            Set<String> bids = vulnerability.getBugIds().getOrDefault(component, new HashSet<>());
            Map<String, Commit> patching = vulnerability.getPatchingCommits().getOrDefault(component, new HashMap<>());
            Map<String, List<String>> btc = dataset.getBugToCve().getOrDefault(component, new HashMap<>());
            Map<String, List<String>> bth = dataset.getBugToHash().getOrDefault(component, new HashMap<>());
            for (String bugId : bugList) {
                if (newEntry || !btc.containsKey(bugId)) {

                    if (bth.containsKey(bugId)) {
                        for (String hash : bth.get(bugId)) {
                            patching.put(hash, generateCommitOfInterest(gitmap.get(component), hash, true));
                        }
                        bids.add(bugId);
                        bugAddedToVulnerabilityEvent(vulnerability, bugId,component);
                    }
                    if (btc.containsKey(bugId)) {
                        btc.get(bugId).add(vulnerability.getCve());
                    } else {
                        List<String> cves = new ArrayList<>();
                        cves.add(vulnerability.getCve());
                        btc.put(bugId, cves);
                    }
                }
            }
            vulnerability.getBugIds().put(component, bids);
            vulnerability.getPatchingCommits().put(component, patching);
            dataset.getBugToCve().put(component, btc);
            dataset.getBugToHash().put(component, bth);
        });


        //For each bug add it to the vuln

    }


    private void updateCWE(Vulnerability vulnerability, String cwe) {
        vulnerability.setCwe(cwe);
        cweUpdatedForVulnerabilityEvent(vulnerability);
    }

    private void updateScore(Vulnerability vulnerability, String score) {
        vulnerability.setScore(score);
        scoreUpdatedForVulnerabilityEvent(vulnerability);
    }


    private Commit addCommitOfInterest(Vulnerability vulnerability, String hash, String component) {
        Commit commit = generateCommitOfInterest(gitmap.get(component), hash, true);
        if (commit != null) {
            String bugId = checkCommitForBugId(component, commit.getMessage());
            if (bugId != null) {
                Set<String> bid = vulnerability.getBugIds().getOrDefault(component, new HashSet<>());
                bid.add(bugId);
                vulnerability.getBugIds().put(component, bid);

                Map<String, List<String>> mapbtc = dataset.getBugToCve().getOrDefault(component, new HashMap<>());

                if (mapbtc.containsKey(bugId)) {
                    mapbtc.get(bugId).add(vulnerability.getCve());
                } else {
                    List<String> cve = new ArrayList<>();
                    cve.add(vulnerability.getCve());
                    mapbtc.put(bugId, cve);
                }
                dataset.getBugToCve().put(component, mapbtc);


                Map<String, List<String>> mapbth = dataset.getBugToHash().getOrDefault(component, new HashMap<>());

                if (mapbth.containsKey(bugId)) {
                    mapbth.get(bugId).add(hash);
                } else {
                    List<String> hashes = new ArrayList<>();
                    hashes.add(hash);
                    mapbth.put(bugId, hashes);
                }
            }
            commitAddedToVulnerabilityEvent(vulnerability, hash, component);
            return commit;
        }
        return null;
    }


    private String checkCommitForBugId(String component, String message) {
        MetaInformation project = dataset.getProject().getSubProjects().get(component);
        if (project.getIndexOfBugIdinCommitMessage() != 0) {
            Pattern pattern = Pattern.compile("[.|\\r|\\n]*" + project.getPatchInCommitessageRegexp());
            Matcher m = pattern.matcher(message);
            if (m.find()) {
                return m.group(project.getIndexOfBugIdinCommitMessage());
            }
        }
        return null;
    }
}
