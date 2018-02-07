package cve.processing;

import cve.model.Data7;
import cve.model.CommitInterest;
import cve.model.FileInterest;
import cve.model.Fix;
import cve.model.Vulnerability;
import cve.projects.Project;
import gitUtilitaries.GitActions;
import greycat.Graph;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.revwalk.RevCommit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static cve.Resources.FILE_EXTENSION;
import static cve.Resources.PATH_TO_GIT;

public class GitProcessor {

    private final Data7 dataset;
    private Graph graph;
    private final GitActions git;

    public GitProcessor(Data7 dataset) {
        this.dataset = dataset;
        this.git = new GitActions(dataset.getProject().getOnlineRepository(), PATH_TO_GIT + dataset.getVulnerabilitySet().getProjectName());
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    public void process() throws IOException, GitAPIException {
        Set<String> alreadyProcessed = dataset.getAlreadyProcessedHash();
        git.getGit().log().all().call().forEach(revCommit -> {
            String hash = revCommit.getName();
            if (!alreadyProcessed.contains(hash)) {
                alreadyProcessed.add(hash);
                boolean found = testForCVE(revCommit);
                testForBugId(revCommit, found);
            }
        });
    }

    private void testForBugId(RevCommit revCommit, boolean found) {
        Project project = dataset.getProject();
        if (project.getIndexOfBugIdinCommitMessage() != 0) {
            Pattern pattern = Pattern.compile("[.|\\r|\\n]*" + project.getPatchInCommitessageRegexp());
            Matcher m = pattern.matcher(revCommit.getFullMessage());
            if (m.find() && !revCommit.getFullMessage().contains("Merge") && !revCommit.getFullMessage().contains("Revert")) {
                String bugId = m.group(project.getIndexOfBugIdinCommitMessage());
                if (dataset.getBugToCve().containsKey(bugId)) {
                    //Matching
                    String cve = dataset.getBugToCve().get(bugId);
                    Vulnerability vulnerability = dataset.getVulnerabilitySet().getVulnerabilityDataset().get(cve);
                    if (!found) {
                        CommitInterest commitInterest = generateCommitOfInterest(revCommit);
                        vulnerability.getPatchingCommits().put(revCommit.getName(), commitInterest);
                    }
                    vulnerability.getBugId().add(bugId);
                    if (graph != null) {
                        //TODO
                    }
                }
                if (dataset.getBugToHash().containsKey(bugId)) {
                    dataset.getBugToHash().get(bugId).add(revCommit.getName());
                } else {
                    List<String> hashes = new ArrayList<>();
                    hashes.add(revCommit.getName());
                    dataset.getBugToHash().put(bugId, hashes);
                }
            }
        }
    }

    private boolean testForCVE(RevCommit revCommit) {
        Pattern pattern = Pattern.compile("[.|\\r|\\n]*(CVE[ ]?-[ ]?[0-9][0-9][0-9][0-9][ ]?-[ ]?[0-9][0-9][0-9][0-9])[.|\\r|\\n]*");
        Matcher m = pattern.matcher(revCommit.getFullMessage());
        if (m.find() && !revCommit.getFullMessage().contains("Merge") && !revCommit.getFullMessage().contains("Revert")) {
            String cve = m.group(1);
            if (dataset.getVulnerabilitySet().getVulnerabilityDataset().containsKey(cve)) {
                Vulnerability vulnerability = dataset.getVulnerabilitySet().getVulnerabilityDataset().get(cve);
                CommitInterest commitInterest = generateCommitOfInterest(revCommit);
                vulnerability.getPatchingCommits().put(revCommit.getName(), commitInterest);
                if (graph != null) {
                    //todo
                }
            } else {
                System.err.println(cve + " is not existing");
            }
            return true;
        }
        return false;
    }


    private CommitInterest generateCommitOfInterest(RevCommit commit) {
        String hash = commit.getName();
        String commitMessage = commit.getFullMessage();
        int timestamp = commit.getCommitTime();
        List<String> modifiedFiles = git.getListOfModifiedFile(commit.getName(), FILE_EXTENSION);
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
        return new CommitInterest(hash, commitMessage, timestamp, fixes);
    }
}
