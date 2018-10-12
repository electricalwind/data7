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




import data7.project.MetaInformation;
import data7.project.Project;
import org.eclipse.jgit.revwalk.RevCommit;

import java.util.concurrent.Callable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommitRegexp implements Callable<MatchingCommit> {

    private final MetaInformation project;
    private final RevCommit revCommit;

    CommitRegexp(MetaInformation project, RevCommit revCommit) {
        this.project = project;
        this.revCommit = revCommit;
    }

    @Override
    public MatchingCommit call() {
        return new MatchingCommit(revCommit,
                testForCVE(),
                testForBugId()
        );
    }


    private String testForBugId() {
        if (project.getIndexOfBugIdinCommitMessage() != 0) {
            Pattern pattern = Pattern.compile("[.|\\r|\\n]*" + project.getPatchInCommitessageRegexp());
            Matcher m = pattern.matcher(revCommit.getFullMessage());
            if (m.find() && !revCommit.getFullMessage().contains("Merge") && !revCommit.getFullMessage().contains("Revert")) {
                return m.group(project.getIndexOfBugIdinCommitMessage());
            }
        }
        return null;
    }

    private String testForCVE() {
        Pattern pattern = Pattern.compile("[.|\\r|\\n]*(CVE[ ]?-[ ]?[0-9][0-9][0-9][0-9][ ]?-[ ]?[0-9]+)[.|\\r|\\n]*");
        Matcher m = pattern.matcher(revCommit.getFullMessage());
        if (m.find() && !revCommit.getFullMessage().contains("Merge") && !revCommit.getFullMessage().contains("Revert")) {
            return m.group(1);
        }
        return null;
    }

}
