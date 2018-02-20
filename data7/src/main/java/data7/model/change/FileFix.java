package data7.model.change;

import java.io.Serializable;

/**
 * FileFix
 * A class that gather information on a file that was modified by a commit
 * it contains the information on the file before and after the commit as well as the commit corresponding to the last modification of the file
 */
public class FileFix implements Serializable {
    //File in its previous state
    private final FileInterest fileBefore;
    //File in its new state
    private final FileInterest fileAfter;
    //commit from which the previous file was retrieved
    private final String oldHash;
    //last time file was modified
    private final long lastModified;

    /**
     * Constructor of the File fix class
     * @param fileBefore
     * @param fileAfter
     * @param oldHash
     * @param lastModified
     */
    public FileFix(FileInterest fileBefore, FileInterest fileAfter, String oldHash, long lastModified) {
        this.fileBefore = fileBefore;
        this.fileAfter = fileAfter;
        this.oldHash = oldHash;
        this.lastModified = lastModified;
    }

    /**
     * @return the file in its version before the fix
     * @see FileInterest
     */
    public FileInterest getFileBefore() {
        return fileBefore;
    }

    /**
     * @return the file in its fix version
     * @see FileInterest
     */
    public FileInterest getFileAfter() {
        return fileAfter;
    }

    /**
     * @return the hash of the commit that modified last the file
     */
    public String getOldHash() {
        return oldHash;
    }

    public long getLastModified() {
        return lastModified;
    }
}