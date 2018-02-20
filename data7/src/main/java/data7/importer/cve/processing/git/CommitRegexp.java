package data7.importer.cve.processing.git;


import data7.model.project.Project;
import org.eclipse.jgit.revwalk.RevCommit;

import java.util.concurrent.Callable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommitRegexp implements Callable<MatchingCommit> {

    private final Project project;
    private final RevCommit revCommit;

    CommitRegexp(Project project, RevCommit revCommit) {
        this.project = project;
        this.revCommit = revCommit;
    }

    @Override
    public MatchingCommit call() {
        return new MatchingCommit(revCommit,
                testForCVE(),
                testForBugId()
        );
    }


    private String testForBugId() {
        if (project.getIndexOfBugIdinCommitMessage() != 0) {
            Pattern pattern = Pattern.compile("[.|\\r|\\n]*" + project.getPatchInCommitessageRegexp());
            Matcher m = pattern.matcher(revCommit.getFullMessage());
            if (m.find() && !revCommit.getFullMessage().contains("Merge") && !revCommit.getFullMessage().contains("Revert")) {
                return m.group(project.getIndexOfBugIdinCommitMessage());
            }
        }
        return null;
    }

    private String testForCVE() {
        Pattern pattern = Pattern.compile("[.|\\r|\\n]*(CVE[ ]?-[ ]?[0-9][0-9][0-9][0-9][ ]?-[ ]?[0-9]+)[.|\\r|\\n]*");
        Matcher m = pattern.matcher(revCommit.getFullMessage());
        if (m.find() && !revCommit.getFullMessage().contains("Merge") && !revCommit.getFullMessage().contains("Revert")) {
            return m.group(1);
        }
        return null;
    }

}
