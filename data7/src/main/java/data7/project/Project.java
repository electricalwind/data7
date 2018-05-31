package data7.project;

import java.io.Serializable;

/**
 * Project class
 * This class contains all information required to generate a data7
 */
public class Project implements Serializable {
    private static final long serialVersionUID = 20180531L;

    private final String name;
    private final String onlineRepository;
    private final String regexpOnlineRepo;
    private final int indexOfHashInRegexp;
    private final String patchInCommitessageRegexp;
    private final int indexOfBugIdinCommitMessage;
    private final String bugTracker;
    private final String bugTrackerRegexp;
    private final int indexOfBugIdInBugTracker;

    /**
     * Constructor of the class
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
    public Project(String name, String onlineRepository, String regexpOnlineRepo, int indexOfHashInRegexp, String patchInCommitessageRegexp, int indexOfBugIdinCommitMessage, String bugTracker, String bugTrackerRegexp, int indexOfBugIdInBugTracker) {
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
