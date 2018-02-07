package cve.processing;

import cve.model.*;
import cve.parser.CVE;
import cve.projects.Project;
import gitUtilitaries.GitActions;
import greycat.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static cve.Resources.FILE_EXTENSION;
import static cve.Resources.PATH_TO_GIT;

public class CVEProcessor {

    private final List<CVE> cveList;
    private final Data7 dataset;
    private Graph graph;
    private final GitActions git;


    public CVEProcessor(List<CVE> cveList, Data7 dataset) {
        this.cveList = cveList;
        this.dataset = dataset;
        git = new GitActions(dataset.getProject().getOnlineRepository(), PATH_TO_GIT + dataset.getVulnerabilitySet().getProjectName());
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    /**
     * Main function to be called
     */
    public void process() {
        VulnerabilitySet vulnerabilitySet = dataset.getVulnerabilitySet();
        //For each of the cve found in the parsing step
        for (CVE cve : cveList) {
            //if the vulnerability exist then update the entry
            if (vulnerabilitySet.getVulnerabilityDataset().containsKey(cve.CVE)) {
                updateVulnerability(cve, vulnerabilitySet.getVulnerabilityDataset().get(cve.CVE));
            } else { //otherwise create a new vulnerability entry
                createVulnerability(cve);
            }
        }
    }

    /**
     * Function to update a vulnerability entry
     *
     * @param cve           object
     * @param vulnerability corresponding to the cve
     */
    private void updateVulnerability(CVE cve, Vulnerability vulnerability) {
        //if the latest modification is not more recent than the previous one just do nothing
        if (cve.lastModified > vulnerability.getLastModified()) {
            //updating the cwe if needed
            if (!cve.CWE.equals(vulnerability.getCwe())) {
                updateCWE(vulnerability, cve.CWE);
            }
            //updating the score if needed
            if (!cve.score.equals(vulnerability.getScore())) {
                updateScore(vulnerability, cve.score);
            }
            handleHashAndBugIds(cve, vulnerability, false);
        }
    }

    /**
     * Function to create a vulnerability entry from a CVE object
     *
     * @param cve
     */
    private void createVulnerability(CVE cve) {
        //Create the vulnerability object
        Vulnerability vulnerability = createVulnerabilityEntry(cve);
        //For each hash retrieve the fixes
        handleHashAndBugIds(cve, vulnerability, true);
        dataset.getVulnerabilitySet().getVulnerabilityDataset().put(cve.CVE,vulnerability);
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
        for (String hash : cve.patchingCommits) {
            if (newEntry || !vulnerability.getPatchingCommits().containsKey(hash)) {
                addCommitOfInterest(vulnerability, hash);
            }
        }
        //For each bug add it to the vuln
        for (String bugId : cve.bugsId) {
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
        CommitInterest commitInterest = generateCommitOfInterest(hash);
        vulnerability.getPatchingCommits().put(hash, commitInterest);
        String bugId = checkCommitForBugId(hash);
        if (bugId != null) {
            vulnerability.getBugId().add(bugId);
            dataset.getBugToCve().put(bugId, vulnerability.getCve());
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


    private void addBugToVuln(Vulnerability vulnerability, String bugId) {
        if (dataset.getBugToHash().containsKey(bugId)) {
            for (String hash : dataset.getBugToHash().get(bugId)) {
                vulnerability.getPatchingCommits().put(hash, generateCommitOfInterest(hash));
            }
            vulnerability.getBugId().add(bugId);
        }
        dataset.getBugToCve().put(bugId, vulnerability.getCve());
        if (graph != null) {
            //TODO
        }
    }

    private String checkCommitForBugId(String hash) {
        Project project = dataset.getProject();
        if (project.getIndexOfBugIdinCommitMessage() != 0) {
            Pattern pattern = Pattern.compile("[.|\\r|\\n]*" + project.getPatchInCommitessageRegexp());
            Matcher m = pattern.matcher(git.getCommitMessage(hash));
            if (m.find()) {
                return m.group(project.getIndexOfBugIdinCommitMessage());
            }
        }
        return null;
    }


    private CommitInterest generateCommitOfInterest(String hash) {
        String commitMessage = git.getCommitMessage(hash);
        int timestamp = git.getTimeCommit(hash);
        List<String> modifiedFiles = git.getListOfModifiedFile(hash, FILE_EXTENSION);
        List<Fix> fixes = new ArrayList<>();
        for (String modifiedFile : modifiedFiles) {
            String newName = modifiedFile;
            GitActions.NamedCommit previousCommit = git.previousCommitImpactingAFile(modifiedFile, hash);
            String oldname = previousCommit.getFilePath();
            String oldHash = previousCommit.getRevCommit().getName();
            String oldContent = git.retrievingFileFromSpecificCommit(oldHash, oldname);
            String newContent = git.retrievingFileFromSpecificCommit(hash, newName);
            FileInterest old = new FileInterest(oldContent, oldname);
            FileInterest newer = new FileInterest(newContent, newName);
            fixes.add(new Fix(old, newer, oldHash));
        }
        dataset.getAlreadyProcessedHash().add(hash);
        return new CommitInterest(hash, commitMessage, timestamp, fixes);
    }
}
