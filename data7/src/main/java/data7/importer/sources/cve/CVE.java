package data7.importer.sources.cve;

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



import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * CVE class to use as intermediate representation (after parsing, before integration into data7)
 */
public class CVE {

    // cve identifier
    private final String CVE;

    // type of vulnerability
    private String CWE;

    // severity of the vulnerability (CVSS)
    private final String score;

    // description of the vulnerability as reported in the NVD
    private final String description;

    // timestamp of the last vulnerability modification
    private final long lastModified;

    // map of the commit hash that patched the vulnerability per components
    private  Map<String,Set<String>> patchingCommits;

    // map of the bug identifier that correspond to the vulnerability per components
    private Map<String,List<String>> bugsId;

    // timestamp of the  vulnerability report creation
    private final long creationTime;

    // version of the project impacted by the vulnerability
    private final Set<String> versions;


    /**
     *
     * @param cve
     * @param score
     * @param description
     * @param lastModified
     * @param creationTime
     * @param versions
     */
    public CVE(String cve, String score, String description, long lastModified, long creationTime, Set<String> versions) {
        CVE = cve;
        this.score = score;
        this.description = description;
        this.lastModified = lastModified;
        this.versions = versions;
        this.patchingCommits = null;
        this.bugsId = null;
        this.CWE = "";
        this.creationTime = creationTime;
    }

    public String getCVE() {
        return CVE;
    }

    public String getCWE() {
        return CWE;
    }

    public String getScore() {
        return score;
    }

    public String getDescription() {
        return description;
    }

    public long getLastModified() {
        return lastModified;
    }

    public Map<String, Set<String>> getPatchingCommits() {
        return patchingCommits;
    }

    public Map<String, List<String>> getBugsId() {
        return bugsId;
    }

    public void setCWE(String CWE) {
        this.CWE = CWE;
    }

    public void setPatchingCommits(Map<String,Set<String>> patchingCommits) {
        this.patchingCommits = patchingCommits;
    }

    public void setBugsId(Map<String,List<String>> bugsId) {
        this.bugsId = bugsId;
    }

    public long getCreationTime() {
        return creationTime;
    }

    public Set<String> getImpactedVersions() {
        return versions;
    }
}
