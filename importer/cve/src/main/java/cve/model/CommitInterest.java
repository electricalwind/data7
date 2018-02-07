package cve.model;

import java.io.Serializable;
import java.util.List;

public class CommitInterest implements Serializable {
    private final String message;
    private final long timestamp;
    private final List<Fix> fixes;
    private final String hash;

    public CommitInterest( String hash, String message, long timestamp, List<Fix> fixes) {
        this.hash = hash;
        this.message = message;
        this.timestamp = timestamp;
        this.fixes = fixes;

    }

    public String getMessage() {
        return message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public List<Fix> getFixes() {
        return fixes;
    }

    public String getHash() {
        return hash;
    }
}
