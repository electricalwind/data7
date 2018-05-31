package data7.model.change;

import java.io.Serializable;
import java.util.List;

/**
 * Data class representing a commit
 */
public class Commit implements Serializable {
    private static final long serialVersionUID = 20180531L;

    //commit full message
    private final String message;
    //commit timestamp
    private final long timestamp;
    //list of all the file that were modified by the commit
    private final List<FileFix> fixes;
    //commit hash
    private final String hash;

    /**
     * Constructor of the commit class
     * @param hash
     * @param message
     * @param timestamp
     * @param fixes list of modified files
     */
    public Commit(String hash, String message, long timestamp, List<FileFix> fixes) {
        this.hash = hash;
        this.message = message;
        this.timestamp = timestamp;
        this.fixes = fixes;

    }

    /**
     * @return the full message of the commit
     */
    public String getMessage() {
        return message;
    }

    /**
     * @return the timestamp of the commit
     */
    public long getTimestamp() {
        return timestamp;
    }

    /**
     * @return the list of the files that were modified by the commit
     * @see FileFix
     */
    public List<FileFix> getFixes() {
        return fixes;
    }

    /**
     * @return the hash of the commit
     */
    public String getHash() {
        return hash;
    }
}
