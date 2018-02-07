package cve.parser;

import java.util.List;

public class CVE {

    public final String CVE;
    public String CWE;
    public final String score;
    public final String description;
    public final long lastModified;
    public List<String> patchingCommits;
    public List<String> bugsId;


    public CVE(String cve, String score, String description, long lastModified) {
        CVE = cve;
        this.score = score;
        this.description = description;
        this.lastModified = lastModified;
        this.patchingCommits = null;
        this.bugsId = null;
        this.CWE = "";
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

    public void setCWE(String CWE) {
        this.CWE = CWE;
    }

    public void setPatchingCommits(List<String> patchingCommits) {
        this.patchingCommits = patchingCommits;
    }

    public void setBugsId(List<String> bugsId) {
        this.bugsId = bugsId;
    }
}
