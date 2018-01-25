package gitUtilitaries;

import java.io.File;
import java.io.IOException;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;

/**
 * Git cweimporter class
 */
public class GitClonePull {

    private final String GitURL;
    private File destinationFolder;

    /**
     * Constructor
     *
     * @param GitURL         of the project to import
     * @param destinationFolder to clone in
     */
    public GitClonePull(String GitURL, String destinationFolder) {
        this.GitURL = GitURL;
        checkFolderDestination(destinationFolder);
    }

    /**
     * Will create the folder of destination if not existing
     *
     * @param dest folder
     */
    private void checkFolderDestination(String dest) {
        File f = new File(dest);
        if (!(f.exists() && f.isDirectory())) {
            f.mkdirs();
        }
        this.destinationFolder = f;
    }

    /**
     * Function that clone or pull the remote repository
     *
     * @throws GitAPIException
     * @throws IOException
     */
    public Git updateRepo() throws GitAPIException, IOException {
        File git = new File(destinationFolder, ".git");
        Git result;
        if (!git.exists()) {
            result = Git.cloneRepository()
                    .setURI(GitURL)
                    .setDirectory(destinationFolder)
                    .call();
        } else {
            result = Git.open(git);
            result.pull().call();
        }
        return result;
    }


}
