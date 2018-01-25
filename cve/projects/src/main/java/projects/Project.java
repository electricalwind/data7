package projects;

public class Project {
    private final String name;
    private final String regexpOnlineRepo;
    private final int indexOfHashInRegexp;
    private final String patchInCommitessageRegexp;
    private final int indexOfBugIdinCommitMessage;
    private final String bugTrackerRegexp;
    private final int indexOfBugIdInBugTracker;


    public Project(String name, String regexpOnlineRepo, int indexOfHashInRegexp, String patchInCommitessageRegexp, int indexOfBugIdinCommitMessage, String bugTrackerRegexp, int indexOfBugIdInBugTracker) {
        this.name = name;
        this.regexpOnlineRepo = regexpOnlineRepo;
        this.indexOfHashInRegexp = indexOfHashInRegexp;
        this.patchInCommitessageRegexp = patchInCommitessageRegexp;
        this.indexOfBugIdinCommitMessage = indexOfBugIdinCommitMessage;
        this.bugTrackerRegexp = bugTrackerRegexp;
        this.indexOfBugIdInBugTracker = indexOfBugIdInBugTracker;
    }

    public String getName() {
        return name;
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

    public String getBugTrackerRegexp() {
        return bugTrackerRegexp;
    }

    public int getIndexOfBugIdInBugTracker() {
        return indexOfBugIdInBugTracker;
    }
}
