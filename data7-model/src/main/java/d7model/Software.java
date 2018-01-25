package d7model;

import java.io.Serializable;
import java.util.Map;

/**
 * Software
 * A class gathering the required intel on a software project to create the dataset
 * it contains:
 * the name of the software
 * the url of the git remote repository
 * and A list of all versions of the software and their corresponding commit
 */
public class Software implements Serializable {
    private final String name;
    private final String gitUrl;
    private final Map<String, String> versions;

    public Software(String name, String gitUrl, Map<String, String> versions) {
        this.name = name;
        this.gitUrl = gitUrl;
        this.versions = versions;
    }

    public Map<String, String> getVersions() {
        return versions;
    }

    public String getGitUrl() {
        return gitUrl;
    }

    public String getName() {
        return name;
    }
}
