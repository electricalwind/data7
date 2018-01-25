package d7model;

import java.io.Serializable;

/**
 * Fix
 * A class that gather information on a fix that occured on a specific file
 * it contains the information on the file before and after the fix as well as the commit corresponding to the old version of the file(lat time it was modified before)
 */
public class Fix implements Serializable {
    private final FileInterest fileBefore;
    private final FileInterest fileAfter;
    private final String oldHash;

    public Fix(FileInterest fileBefore, FileInterest fileAfter, String oldHash) {
        this.fileBefore = fileBefore;
        this.fileAfter = fileAfter;

        this.oldHash = oldHash;
    }

    public FileInterest getFileBefore() {
        return fileBefore;
    }

    public FileInterest getFileAfter() {
        return fileAfter;
    }

    public String getOldHash() {
        return oldHash;
    }
}