package data7.importer.cve.processing.cve;

import java.util.List;

/**
 *
 */
public class CVE {

    //
    private final String CVE;
    //
    private String CWE;
    //
    private final String score;
    //
    private final String description;
    //
    private final long lastModified;
    //
    private List<String> patchingCommits;
    //
    private List<String> bugsId;

    private final long creationTime;


    CVE(String cve, String score, String description, long lastModified, long creationTime) {
        CVE = cve;
        this.score = score;
        this.description = description;
        this.lastModified = lastModified;
        this.patchingCommits = null;
        this.bugsId = null;
        this.CWE = "";
        this.creationTime = creationTime;
    }

    public String getCVE() {
        return CVE;
    }

    public String getCWE() {
        return CWE;
    }

    public String getScore() {
        return score;
    }

    public String getDescription() {
        return description;
    }

    public long getLastModified() {
        return lastModified;
    }

    public List<String> getPatchingCommits() {
        return patchingCommits;
    }

    public List<String> getBugsId() {
        return bugsId;
    }

    void setCWE(String CWE) {
        this.CWE = CWE;
    }

    void setPatchingCommits(List<String> patchingCommits) {
        this.patchingCommits = patchingCommits;
    }

    void setBugsId(List<String> bugsId) {
        this.bugsId = bugsId;
    }

    public long getCreationTime() {
        return creationTime;
    }
}
