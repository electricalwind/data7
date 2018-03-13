package data7;

import data7.model.change.Commit;
import data7.model.change.FileFix;
import data7.model.change.FileInterest;
import gitUtilitaries.GitActions;
import org.eclipse.jgit.revwalk.RevCommit;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static data7.Resources.FILE_EXTENSION;

public class Utils {

    public static long dateToLong(String str) throws ParseException {
        DateFormat formatter;
        Date date;
        formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        date = (Date) formatter.parse(str);
        return date.getTime();
    }

    public static Commit generateCommitOfInterest(GitActions git, String hash) {
        try {
            String commitMessage = git.getCommitMessage(hash);
            int timestamp = git.getTimeCommit(hash);
            List<String> modifiedFiles = git.getListOfModifiedFile(hash, FILE_EXTENSION);
            List<FileFix> fixes = new ArrayList<>();
            for (String modifiedFile : modifiedFiles) {
                String newName = modifiedFile;
                GitActions.NamedCommit previousCommit = git.previousCommitImpactingAFile(modifiedFile, hash);
                String oldname = previousCommit.getFilePath();
                String oldHash = previousCommit.getRevCommit().getName();
                String oldContent = git.retrievingFileFromSpecificCommit(oldHash, oldname);
                String newContent = git.retrievingFileFromSpecificCommit(hash, newName);
                FileInterest old = new FileInterest(oldContent, oldname);
                FileInterest newer = new FileInterest(newContent, newName);
                fixes.add(new FileFix(old, newer, oldHash, git.getTimeCommit(oldHash)));
            }
            return new Commit(hash, commitMessage, timestamp, fixes);
        } catch (IOException | NullPointerException e) {
            System.err.println(hash);
            System.err.println(e.getMessage());
            return null;
        }
    }

    public static Commit generateCommitOfInterest(GitActions git, RevCommit commit) {
        try {
            String hash = commit.getName();
            String commitMessage = commit.getFullMessage();
            int timestamp = commit.getCommitTime();
            List<String> modifiedFiles = git.getListOfModifiedFile(commit.getName(), FILE_EXTENSION);
            List<FileFix> fixes = new ArrayList<>();
            for (String modifiedFile : modifiedFiles) {
                String newName = modifiedFile;
                GitActions.NamedCommit previousCommit = git.previousCommitImpactingAFile(modifiedFile, hash);
                String oldname = previousCommit.getFilePath();
                String oldHash = previousCommit.getRevCommit().getName();
                String oldContent = git.retrievingFileFromSpecificCommit(oldHash, oldname);
                String newContent = git.retrievingFileFromSpecificCommit(hash, newName);
                FileInterest old = new FileInterest(oldContent, oldname);
                FileInterest newer = new FileInterest(newContent, newName);
                fixes.add(new FileFix(old, newer, oldHash, git.getTimeCommit(oldHash)));
            }
            return new Commit(hash, commitMessage, timestamp, fixes);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

}
