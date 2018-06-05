package data7.model;

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



import data7.project.Project;
import data7.model.vulnerability.VulnerabilitySet;

import java.io.Serializable;
import java.util.*;

/**
 * The Data7 (pronounce dataset) class
 */
public class Data7 implements Serializable {
    private static final long serialVersionUID = 20180531L;

    //Built Vulnerability dataSet
    private final VulnerabilitySet vulnerabilitySet;

    //Meta Information on the project under study
    private final Project project;

    //Map that link bug id from the bug tracker to  CVE vulnerability Numbers
    private final Map<String, List<String>> bugToCve;

    //Map that link a bug id from the bug tracker to a commit hash
    private final Map<String, List<String>> bugToHash;

    //Map that link a cve number that have yet to be declared to a commit hash
    private final Map<String, List<String>> unknownCVEToHash;

    //Set of All commit that have been processed
    private final Set<String> alreadyProcessedHash;

    /**
     * Constructor for the data7 only the project is required
     */
    public Data7(Project project) {
        this.project = project;
        vulnerabilitySet = new VulnerabilitySet(project.getName());
        bugToCve = new HashMap<>();
        bugToHash = new HashMap<>();
        alreadyProcessedHash = new HashSet<>();
        unknownCVEToHash = new HashMap<>();
    }

    /**
     * @return the vulnerability dataset in its current state
     * @see VulnerabilitySet
     */
    public VulnerabilitySet getVulnerabilitySet() {
        return vulnerabilitySet;
    }

    /**
     * @return the project object used to built the dataset
     * @see Project
     */
    public Project getProject() {
        return project;
    }

    /**
     * @return a map that link bug id as identified in the bug tracker to cve identifiers
     */
    public Map<String, List<String>> getBugToCve() {
        return bugToCve;
    }

    /**
     * @return a map that link bug id as identified in the bug tracker to the commit hashes that fix it
     */
    public Map<String, List<String>> getBugToHash() {
        return bugToHash;
    }

    /**
     * @return the list of all commits that already have been processed
     */
    public Set<String> getAlreadyProcessedHash() {
        return alreadyProcessedHash;
    }

    /**
     * @return a map of all CVE that were not detected by the cve parser but were found in a commit message (e.g., cve that have not been disclosed yet)
     */
    public Map<String, List<String>> getUnknownCVEToHash() {
        return unknownCVEToHash;
    }






}
