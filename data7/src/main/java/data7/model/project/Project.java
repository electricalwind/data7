package data7.model.project;

import java.io.Serializable;

public class Project implements Serializable {
    private final String name;
    private final String onlineRepository;
    private final String regexpOnlineRepo;
    private final int indexOfHashInRegexp;
    private final String patchInCommitessageRegexp;
    private final int indexOfBugIdinCommitMessage;
    private final String bugTracker;
    private final String bugTrackerRegexp;
    private final int indexOfBugIdInBugTracker;


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

    public String getName() {
        return name;
    }

    public String getOnlineRepository() {
        return onlineRepository;
    }

    public String getRegexpOnlineRepo() {
        return regexpOnlineRepo;
    }

    public int getIndexOfHashInRegexp() {
        return indexOfHashInRegexp;
    }

    public String getPatchInCommitessageRegexp() {
        return patchInCommitessageRegexp;
    }

    public int getIndexOfBugIdinCommitMessage() {
        return indexOfBugIdinCommitMessage;
    }

    public String getBugTracker() {
        return bugTracker;
    }

    public String getBugTrackerRegexp() {
        return bugTrackerRegexp;
    }

    public int getIndexOfBugIdInBugTracker() {
        return indexOfBugIdInBugTracker;
    }
}
