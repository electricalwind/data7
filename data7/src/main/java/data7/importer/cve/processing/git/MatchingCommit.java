package data7.importer.cve.processing.git;

import org.eclipse.jgit.revwalk.RevCommit;

public class MatchingCommit {
    private final RevCommit commit;
    private final String cve;
    private final String bugId;


    MatchingCommit(RevCommit commit, String cve, String bugId) {
        this.commit = commit;
        this.cve = cve;
        this.bugId = bugId;
    }

    RevCommit getCommit() {
        return commit;
    }

    String getCve() {
        return cve;
    }

    String getBugId() {
        return bugId;
    }
}
