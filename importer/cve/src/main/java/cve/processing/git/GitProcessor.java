package cve.processing.git;

import cve.model.*;
import gitUtilitaries.GitActions;
import greycat.Graph;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.revwalk.RevCommit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

import static cve.Resources.*;

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

    public void process() {

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
            //Matching
            List<String> cves = dataset.getBugToCve().get(result.getBugId());
            for (String cve : cves) {
                Vulnerability vulnerability = dataset.getVulnerabilitySet().getVulnerabilityDataset().get(cve);
                if (!vulnerability.getBugId().contains(result.getBugId())) {
                    Commit commit = generateCommitOfInterest(result.getCommit());
                    vulnerability.getPatchingCommits().put(result.getCommit().getName(), commit);
                    vulnerability.getBugId().add(result.getBugId());
                }
            }
            if (graph != null) {
                //TODO
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
            Commit commit = generateCommitOfInterest(result.getCommit());
            vulnerability.getPatchingCommits().put(result.getCommit().getName(), commit);
            if (result.getBugId() != null) {
                vulnerability.getBugId().add(result.getBugId());
            }
            if (graph != null) {
                //todo
            }
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


    private Commit generateCommitOfInterest(RevCommit commit) {
        try {
            String hash = commit.getName();
            String commitMessage = commit.getFullMessage();
            int timestamp = commit.getCommitTime();
            List<String> modifiedFiles = git.getListOfModifiedFile(commit.getName(), FILE_EXTENSION);
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
            return new Commit(hash, commitMessage, timestamp, fixes);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}
