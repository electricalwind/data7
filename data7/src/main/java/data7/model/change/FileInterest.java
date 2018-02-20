package data7.model.change;

import java.io.Serializable;

/**
 * FileInterest
 * A class that represent a source code file with its path and content
 */
public class FileInterest implements Serializable {

    //file content
    private final String fileContent;
    //file path
    private final String filePath;

    /**
     * Constructor
     * @param fileContent
     * @param filePath
     */
    public FileInterest(String fileContent, String filePath) {
        this.fileContent = fileContent;
        this.filePath = filePath;
    }

    /**
     * @return the content of the file
     */
    public String getFileContent() {
        return fileContent;
    }

    /**
     * @return the file path
     */
    public String getFilePath() {
        return filePath;
    }
}
