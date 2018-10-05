package data7.project;

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



import java.io.Serializable;

/**
 * Project class
 * This class contains all information required to generate a data7
 */
public class Project implements Serializable {
    private static final long serialVersionUID = 20181004L;

    private final String name;
    private final String onlineRepository;
    private final String regexpOnlineRepo;
    private final int indexOfHashInRegexp;
    private final String patchInCommitessageRegexp;
    private final int indexOfBugIdinCommitMessage;
    private final String bugTracker;
    private final String bugTrackerRegexp;
    private final int indexOfBugIdInBugTracker;
    private final String savingName;

    /**
     * Constructor of the class
     * @param savingName name of the project to save
     * @param name of the project as reported in the nvd
     * @param onlineRepository url of an available remote git
     * @param regexpOnlineRepo regexp to recognize the hash from an url of remote git
     * @param indexOfHashInRegexp position of the hash in the previous regexp
     * @param patchInCommitessageRegexp how to
     * @param indexOfBugIdinCommitMessage
     * @param bugTracker
     * @param bugTrackerRegexp
     * @param indexOfBugIdInBugTracker
     */
    public Project(String savingName,String name, String onlineRepository, String regexpOnlineRepo, int indexOfHashInRegexp, String patchInCommitessageRegexp, int indexOfBugIdinCommitMessage, String bugTracker, String bugTrackerRegexp, int indexOfBugIdInBugTracker) {
        this.savingName =savingName;
        this.name = name;
        this.onlineRepository = onlineRepository;
        this.regexpOnlineRepo = regexpOnlineRepo;
        this.indexOfHashInRegexp = indexOfHashInRegexp;
        this.patchInCommitessageRegexp = patchInCommitessageRegexp;
        this.indexOfBugIdinCommitMessage = indexOfBugIdinCommitMessage;
        this.bugTracker = bugTracker;
        this.bugTrackerRegexp = bugTrackerRegexp;
        this.indexOfBugIdInBugTracker = indexOfBugIdInBugTracker;
    }

    public String getSavingName() {
        return savingName;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return
     */
    public String getOnlineRepository() {
        return onlineRepository;
    }

    /**
     *
     * @return
     */
    public String getRegexpOnlineRepo() {
        return regexpOnlineRepo;
    }

    /**
     *
     * @return
     */
    public int getIndexOfHashInRegexp() {
        return indexOfHashInRegexp;
    }

    /**
     *
     * @return
     */
    public String getPatchInCommitessageRegexp() {
        return patchInCommitessageRegexp;
    }

    /**
     *
     * @return
     */
    public int getIndexOfBugIdinCommitMessage() {
        return indexOfBugIdinCommitMessage;
    }

    /**
     *
     * @return
     */
    public String getBugTracker() {
        return bugTracker;
    }

    /**
     *
     * @return
     */
    public String getBugTrackerRegexp() {
        return bugTrackerRegexp;
    }

    /**
     *
     * @return
     */
    public int getIndexOfBugIdInBugTracker() {
        return indexOfBugIdInBugTracker;
    }
}
