package cve.processing.cve;

import cve.model.*;
import cve.projects.Project;
import gitUtilitaries.GitActions;
import greycat.Graph;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static cve.Resources.FILE_EXTENSION;
import static cve.Resources.PATH_TO_GIT;

/**
 *
 */
public class CVEAnalysis {

    private final List<CVE> cveList;
    private final Data7 dataset;
    private Graph graph;
    private final GitActions git;


    public CVEAnalysis(List<CVE> cveList, Data7 dataset) {
        this.cveList = cveList;
        this.dataset = dataset;
        git = new GitActions(dataset.getProject().getOnlineRepository(), PATH_TO_GIT + dataset.getVulnerabilitySet().getProjectName());
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    public void close() {
        git.close();
    }

    /**
     * Main function to be called
     */
    public Data7 process() {
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
        return dataset;
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
        if (graph != null) {
            //TODO
        }
        return vulnerability;
    }

    private void handleHashAndBugIds(CVE cve, Vulnerability vulnerability, boolean newEntry) {
        //for each hash check whether it's already been handled
        for (String hash : cve.getPatchingCommits()) {
            if (newEntry || !vulnerability.getPatchingCommits().containsKey(hash)) {
                addCommitOfInterest(vulnerability, hash);
            }
        }
        //For each bug add it to the vuln
        for (String bugId : cve.getBugsId()) {
            if (newEntry || !dataset.getBugToCve().containsKey(bugId)) {
                addBugToVuln(vulnerability, bugId);
            }
        }
    }


    private void updateCWE(Vulnerability vulnerability, String cwe) {
        vulnerability.setCwe(cwe);
        if (graph != null) {
            //TODO
        }
    }

    private void updateScore(Vulnerability vulnerability, String score) {
        vulnerability.setScore(score);
        if (graph != null) {
            //TODO
        }
    }

    private void addCommitOfInterest(Vulnerability vulnerability, String hash) {
        Commit commit = generateCommitOfInterest(hash);
        if (commit != null) {
            vulnerability.getPatchingCommits().put(hash, commit);
            String bugId = checkCommitForBugId(commit.getMessage());
            if (bugId != null) {
                vulnerability.getBugId().add(bugId);
                if (dataset.getBugToCve().containsKey(bugId)) {
                    dataset.getBugToCve().get(bugId).add(vulnerability.getCve());
                } else {
                    List<String> cve = new ArrayList<>();
                    cve.add(vulnerability.getCve());
                    dataset.getBugToCve().put(bugId, cve);
                }
                if (dataset.getBugToHash().containsKey(bugId)) {
                    dataset.getBugToHash().get(bugId).add(hash);
                } else {
                    List<String> hashes = new ArrayList<>();
                    hashes.add(hash);
                    dataset.getBugToHash().put(bugId, hashes);
                }
            }
            if (graph != null) {
                //TODO
            }
        }
    }


    private void addBugToVuln(Vulnerability vulnerability, String bugId) {
        if (dataset.getBugToHash().containsKey(bugId)) {
            for (String hash : dataset.getBugToHash().get(bugId)) {
                vulnerability.getPatchingCommits().put(hash, generateCommitOfInterest(hash));
            }
            vulnerability.getBugId().add(bugId);
            if (graph != null) {
                //TODO
            }
        }
        if (dataset.getBugToCve().containsKey(bugId)) {
            dataset.getBugToCve().get(bugId).add(vulnerability.getCve());
        } else {
            List<String> cve = new ArrayList<>();
            cve.add(vulnerability.getCve());
            dataset.getBugToCve().put(bugId, cve);
        }

    }

    private String checkCommitForBugId(String message) {
        Project project = dataset.getProject();
        if (project.getIndexOfBugIdinCommitMessage() != 0) {
            Pattern pattern = Pattern.compile("[.|\\r|\\n]*" + project.getPatchInCommitessageRegexp());
            Matcher m = pattern.matcher(message);
            if (m.find()) {
                return m.group(project.getIndexOfBugIdinCommitMessage());
            }
        }
        return null;
    }


    private Commit generateCommitOfInterest(String hash) {
        try {
            String commitMessage = git.getCommitMessage(hash);
            int timestamp = git.getTimeCommit(hash);
            List<String> modifiedFiles = git.getListOfModifiedFile(hash, FILE_EXTENSION);
            List<FileFix> fixes = new ArrayList<>();
            for (String modifiedFile : modifiedFiles) {
                String newName = modifiedFile;
                GitActions.NamedCommit previousCommit = git.previousCommitImpactingAFile(modifiedFile, hash);
                String oldname = previousCommit.getFilePath();
                String oldHash = previousCommit.getRevCommit().getName();
                String oldContent = git.retrievingFileFromSpecificCommit(oldHash, oldname);
                String newContent = git.retrievingFileFromSpecificCommit(hash, newName);
                FileInterest old = new FileInterest(oldContent, oldname);
                FileInterest newer = new FileInterest(newContent, newName);
                fixes.add(new FileFix(old, newer, oldHash));
            }
            dataset.getAlreadyProcessedHash().add(hash);
            return new Commit(hash, commitMessage, timestamp, fixes);
        } catch (IOException | NullPointerException e) {
            System.err.println(hash);
            System.err.println(e.getMessage());
            return null;
        }

    }
}
