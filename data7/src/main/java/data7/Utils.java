package data7;

import data7.model.change.Commit;
import data7.model.change.FileFix;
import data7.model.change.FileInterest;
import gitUtilitaries.GitActions;
import org.eclipse.jgit.revwalk.RevCommit;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static data7.Resources.FILE_EXTENSION;

@SuppressWarnings("Duplicates")
public class Utils {

    /**
     * Function to get the epoc time from a date encoded under the format yyyy-MM-dd'T'HH:mm:ss.SSSXXX
     * @param str date
     * @return long epoc time
     * @throws ParseException
     */
    public static long dateToLong(String str) throws ParseException {
        DateFormat formatter;
        Date date;
        formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        date = (Date) formatter.parse(str);
        return date.getTime();
    }


    public static long dateToLongWoM(String str) throws ParseException {
        DateFormat formatter;
        Date date;
        formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
        date = (Date) formatter.parse(str);
        return date.getTime();
    }

    /**
     * Function to generate a commit Object from a hash
     * @param git git repository
     * @param hash to generate the commit object from
     * @param filter whether of not files should be filtered
     * @return a commit object
     * @see Commit
     */
    public static Commit generateCommitOfInterest(GitActions git, String hash, boolean filter) {
        try {
            String commitMessage = git.getCommitMessage(hash);
            int timestamp = git.getTimeCommit(hash);
            List<String> modifiedFiles = git.getListOfModifiedFile(hash, FILE_EXTENSION);
            List<FileFix> fixes = new ArrayList<>();
            for (String modifiedFile : modifiedFiles) {
                if (!filter || !modifiedFile.toLowerCase().contains("test")) {
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
            }
            return new Commit(hash, commitMessage, timestamp, fixes);
        } catch (IOException | NullPointerException e) {
            System.err.println(hash);
            System.err.println(e.getMessage());
            return null;
        }
    }

    /**
     * Function to generate a commit Object from a revcommit object
     * @param git git repository
     * @param commit to generate the commit object from
     * @param filter whether of not files should be filtered
     * @return a commit object
     * @see Commit
     */
    public static Commit generateCommitOfInterest(GitActions git, RevCommit commit,boolean filter) {
        try {
            String hash = commit.getName();
            String commitMessage = commit.getFullMessage();
            int timestamp = commit.getCommitTime();
            List<String> modifiedFiles = git.getListOfModifiedFile(commit.getName(), FILE_EXTENSION);
            List<FileFix> fixes = new ArrayList<>();
            for (String modifiedFile : modifiedFiles) {
                if (!filter || !modifiedFile.toLowerCase().contains("test")) {
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
            }
            return new Commit(hash, commitMessage, timestamp, fixes);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }


    /**
     * Will create the folder of destination if not existing
     *
     * @param dest folder
     */
    public static void checkFolderDestination(String dest) {
        File f = new File(dest);
        if (!(f.exists() && f.isDirectory())) {
            f.mkdirs();
        }
        return ;
    }
}
