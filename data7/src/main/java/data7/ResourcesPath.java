package data7;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ResourcesPath {

    private final Path savingPath;
    private final Path binaryPath;
    private final Path gitPath;
    private final Path xmlPath;
    private final Path cvePath;

    public ResourcesPath(String path) {
        savingPath = Paths.get(path);
        File f = savingPath.toFile();
        if (f.exists() && f.isDirectory()) {
            binaryPath = savingPath.resolve("binary");
            gitPath = savingPath.resolve("git");
            xmlPath = savingPath.resolve("xml");
            cvePath = savingPath.resolve("cve");
        } else throw new RuntimeException("Path is incorrect or inexisting");
    }

    public Path getSavingPath() {
        return savingPath;
    }

    public Path getBinaryPath() {
        return binaryPath;
    }

    public Path getGitPath() {
        return gitPath;
    }

    public Path getXmlPath() {
        return xmlPath;
    }

    public Path getCvePath() {
        return cvePath;
    }
}
