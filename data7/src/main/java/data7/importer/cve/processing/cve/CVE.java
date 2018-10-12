package data7.importer.cve.processing.cve;

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
 *
 */
public class CVE {

    //
    private final String CVE;

    //
    private String CWE;

    //
    private final String score;

    //
    private final String description;

    //
    private final long lastModified;

    //
    private  Map<String,Set<String>> patchingCommits;

    //
    private Map<String,List<String>> bugsId;

    private final long creationTime;

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
