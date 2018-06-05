package data7.importer.cve.processing.git;

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



import org.eclipse.jgit.revwalk.RevCommit;

public class MatchingCommit {
    private final RevCommit commit;
    private final String cve;
    private final String bugId;


    MatchingCommit(RevCommit commit, String cve, String bugId) {
        this.commit = commit;
        this.cve = cve;
        this.bugId = bugId;
    }

    RevCommit getCommit() {
        return commit;
    }

    String getCve() {
        return cve;
    }

    String getBugId() {
        return bugId;
    }
}
