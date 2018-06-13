package data7;

import java.io.File;

public class ResourcesPath {

    private final String savingPath;
    private final String binaryPath;
    private final String gitPath;
    private final String xmlPath;
    private final String cvePath;

    public ResourcesPath(String path) {
        File f = new File(path);
        if (f.exists() && f.isDirectory()) {
            savingPath = path;
            binaryPath = savingPath + "binary/";
            gitPath = savingPath + "git/";
            xmlPath = savingPath + "xml/";
            cvePath = savingPath + "cve/";
        } else throw new RuntimeException("Path is incorrect or inexisting");
    }

    public String getSavingPath() {
        return savingPath;
    }

    public String getBinaryPath() {
        return binaryPath;
    }

    public String getGitPath() {
        return gitPath;
    }

    public String getXmlPath() {
        return xmlPath;
    }

    public String getCvePath() {
        return cvePath;
    }
}
