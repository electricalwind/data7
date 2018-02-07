package cve.model;

import cve.projects.Project;

import java.io.Serializable;
import java.util.*;

public class Data7 implements Serializable{
    private final VulnerabilitySet vulnerabilitySet;
    private final Project project;

    private final Map<String, String> bugToCve;
    private final Map<String, List<String>> bugToHash;

    private final Set<String> alreadyProcessedHash;


    public Data7(Project project) {
        this.project = project;
        vulnerabilitySet = new VulnerabilitySet(project.getName());
        bugToCve = new HashMap<>();
        bugToHash = new HashMap<>();
        alreadyProcessedHash = new HashSet<>();
    }

    public VulnerabilitySet getVulnerabilitySet() {
        return vulnerabilitySet;
    }

    public Project getProject() {
        return project;
    }


    public Map<String, String> getBugToCve() {
        return bugToCve;
    }

    public Map<String, List<String>> getBugToHash() {
        return bugToHash;
    }

    public Set<String> getAlreadyProcessedHash() {
        return alreadyProcessedHash;
    }


}
