package cve.processing.git;

import org.eclipse.jgit.revwalk.RevCommit;

public class MatchingCommit {
    private final RevCommit commit;
    private final String cve;
    private final String bugId;


    public MatchingCommit(RevCommit commit, String cve, String bugId) {
        this.commit = commit;
        this.cve = cve;
        this.bugId = bugId;
    }

    public RevCommit getCommit() {
        return commit;
    }

    public String getCve() {
        return cve;
    }

    public String getBugId() {
        return bugId;
    }
}
