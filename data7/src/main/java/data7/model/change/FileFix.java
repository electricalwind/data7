package data7.model.change;

/*-
 * #%L
 * Data7
 * %%
 * Copyright (C) 2018 University of Luxembourg, Matthieu Jimenez
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */



import java.io.Serializable;

/**
 * FileFix
 * A class that gather information on a file that was modified by a commit
 * it contains the information on the file before and after the commit as well as the commit corresponding to the last modification of the file
 */
public class FileFix implements Serializable {

    private static final long serialVersionUID = 20180531L;

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
