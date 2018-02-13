package gitUtilitaries

import diff.DeltaHistory
import diff.DiffComputing
import org.eclipse.jgit.api.BlameCommand
import org.eclipse.jgit.api.Git
import org.eclipse.jgit.blame.BlameResult
import org.eclipse.jgit.diff.DiffEntry
import org.eclipse.jgit.diff.DiffFormatter
import org.eclipse.jgit.diff.RenameDetector
import org.eclipse.jgit.errors.MissingObjectException
import org.eclipse.jgit.lib.ObjectId
import org.eclipse.jgit.lib.Repository
import org.eclipse.jgit.revwalk.RevCommit
import org.eclipse.jgit.revwalk.RevWalk
import org.eclipse.jgit.treewalk.CanonicalTreeParser
import org.eclipse.jgit.treewalk.TreeWalk
import org.eclipse.jgit.treewalk.filter.PathFilter
import org.eclipse.jgit.util.io.DisabledOutputStream
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileNotFoundException
import java.io.IOException

/**
 * Git Utilitary class
 *
 * This class contains some useful Method some are just adaption from [jgit Cookbook][https://github.com/centic9/jgit-cookbook]
 *
 * @property pathToRepo path to the git repository to study
 *
 * @author Matthieu Jimenez
 */
class GitActions {
    val repo: Repository
    val git: Git
    val pathToRepo: String

    /**
     * init open the git repository
     * should always be followed by a call to close when not needed anymore
     *
     * @throws [FileNotFoundException] if no git directory was found
     */
    constructor(destinationFolder: String) {
        pathToRepo = destinationFolder
        git = Git.open(File(pathToRepo)) ?: throw FileNotFoundException("Can't manage to find the .git file")
        repo = git.repository
    }

    constructor(gitURL: String, destinationFolder: String) {
        pathToRepo = destinationFolder
        git = GitClonePull(gitURL, destinationFolder).updateRepo()
        repo = git.repository
    }


    /**
     * Function to retrieve a file from a specific commit
     *
     * @param commit hash of the commit
     * @param path    path of the file
     *
     * @return content of the file (String)
     * @throws FileNotFoundException
     * @throws NoSuchElementException
     */
    @Throws(IOException::class)
    fun retrievingFileFromSpecificCommit(commit: String, path: String): String? {
        val treeId = repo.resolve("$commit^{tree}") ?: throw NoSuchElementException("the hash commit can not be resolved")

        val treeWalk = TreeWalk(repo)
        treeWalk.addTree(treeId)
        treeWalk.isRecursive = true
        treeWalk.filter = PathFilter.create(path)
        if (!treeWalk.next()) {
            return null
        }
        val objectId = treeWalk.getObjectId(0)
        val loader = repo.open(objectId)
        val baos = ByteArrayOutputStream()
        loader?.copyTo(baos)
        return baos.toString("UTF-8")
    }

    /**
     * Function to retrieve the list of commit that impacted a given file before a given commit
     *
     * @param filePath file to study (path in the git repository)
     * @param beforeThisCommit hash of the commit from which we should start (default HEAD)
     *
     * @return list of commit that impacted the file (RevCommit)
     * @throws NoSuchElementException
     */
    fun listOfCommitImpactingAFile(filePath: String, beforeThisCommit: String = "HEAD"): List<NamedCommit>? {
        val listOfCommits = ArrayList<NamedCommit>()
        try {

            var head: ObjectId? = repo.resolve(beforeThisCommit)
            var path: String? = filePath
            var start = RevWalk(repo).parseCommit(head)
            do {
                val log = git.log()?.add(head)?.addPath(path)?.call() ?: return listOfCommits
                for (revcom in log) {
                    var alreadyExisting = false
                    listOfCommits.forEach { commit -> if (commit.revCommit == revcom) alreadyExisting = true }
                    if (alreadyExisting) {
                        start = null

                    } else {
                        start = revcom;
                        head = start.id
                        listOfCommits.add(NamedCommit(path!!, start));
                    }
                }

                if (start == null) return listOfCommits
                path = getRenamedPath(start, path)
            } while (path != null)
            return listOfCommits
        } catch (e: MissingObjectException) {
            return listOfCommits
        }
    }

    /**
     * Function to retrieve the rename of file in previous commit
     * This function has a timeout of 10s to avoid blocking for too long in large git repository
     */
    fun getRenamedPath(start: RevCommit, path: String?): String? {
        val endTimeMillis = System.currentTimeMillis() + 10000;
        git.log()?.add(start)?.call()?.forEach { commit ->
            if (System.currentTimeMillis() > endTimeMillis) {
                return null;
            }
            val tw = TreeWalk(repo)
            tw.addTree(commit.tree)
            tw.addTree(start.tree)
            tw.isRecursive = true
            val renameDetector = RenameDetector(repo)
            renameDetector.addAll(DiffEntry.scan(tw));
            val files = renameDetector.compute()
            for (diffEntry in files) {
                if ((diffEntry.changeType == DiffEntry.ChangeType.RENAME || diffEntry.changeType == DiffEntry.ChangeType.COPY) && diffEntry.newPath.contains(path!!)) {
                    System.out.println("Found: " + diffEntry.toString() + " return " + diffEntry.oldPath);
                    return diffEntry.oldPath;
                }

            }
        }
        return null
    }

    /**
     * Function to retrieve the list of commit that impacted a given file before a given commit
     *
     * @param filePath file to study (path in the git repository)
     * @param beforeThisCommit hash of the commit from which we should start (default HEAD)
     *
     * @return list of commit that impacted the file (RevCommit)
     * @throws NoSuchElementException
     */
    fun previousCommitImpactingAFile(filePath: String, beforeThisCommit: String = "HEAD"): NamedCommit? {
        try {
            val revWalk = RevWalk(repo)
            val commitId = repo.resolve(beforeThisCommit)
            val commit = revWalk.parseCommit(commitId)
            val listOfCommits = ArrayList<NamedCommit>()
            var head: ObjectId = commitId!!
            var path: String? = filePath
            var start = RevWalk(repo).parseCommit(head)
            listOfCommits.add(NamedCommit(filePath, commit))
            do {
                val log = git.log()?.add(head)?.addPath(path)?.call() ?: return null
                for (revcom in log) {
                    var alreadyExisting = false
                    listOfCommits.forEach { commitI -> if (commitI.revCommit == revcom) alreadyExisting = true }
                    if (alreadyExisting) {
                        start = null
                    } else {
                        start = revcom
                        return NamedCommit(path!!, start);
                    }
                }
                if (start == null) return null
                path = getRenamedPath(start, path)
            } while (path != null)
            return null
        } catch (e: MissingObjectException) {
            return null
        }
    }


    /**
     * Function to retrieve the list of commit present in a git blame for a file in a given commit
     * the order of the list correspond to the order of line
     * e.g. :(element 1) -> line 1 commit
     *
     * @param filePath file to study (path in the git repository)
     * @param commitID hash of the commit (default HEAD)
     *
     * @return list of the commit (RevCommit)
     * @throws NoSuchElementException
     */
    fun gitBlame(filePath: String, commitID: ObjectId): List<RevCommit> {
        val listCommit = ArrayList<RevCommit>()
        val blamer = BlameCommand(repo)
        blamer.setStartCommit(commitID);
        blamer.setFilePath(filePath);
        val blame: BlameResult = blamer.call() ?: throw UnknownError("The Blamer call failed");
        val lines: Int = retrievingFileFromSpecificCommit(commitID.name, filePath)?.split("\n")?.size ?: 0
        for (i in 0..(lines - 1)) {
            try {
                listCommit.add(blame.getSourceCommit(i))
            } catch (e: ArrayIndexOutOfBoundsException) {
                return listCommit
            }
        }
        return listCommit
    }

    /**
     * Function to get the Number of Developer present on a git blame result
     *
     * @param filePath file to study (path in the git repository)
     * @param commit hash of the commit (default HEAD)
     *
     * @return number of distinct developer present on the git blame result
     */
    fun gitBlameNbDev(filePath: String, commit: RevCommit): Int {
        val listofBlamedAuthor = HashSet<String>()
        gitBlame(filePath, commit.id).forEach { blamedCommit -> listofBlamedAuthor.add(blamedCommit.authorIdent.emailAddress) }
        return listofBlamedAuthor.size

    }

    /**
     * Function to get the Developer History of a File before a given commit
     *
     * @param filePath file to study
     * @param commit hash of the commit (Default : HEAD)
     * @return [DeveloperHistory]
     */
    fun getDevHistoryOfAFile(filePath: String, commit: String = "HEAD"): DeveloperHistory? {
        val listofCommit = listOfCommitImpactingAFile(filePath, commit) ?: return null
        return getDevHistoryOfAFileFromList(listofCommit)
    }

    /**
     * Function to get the Developer History of a File before a given commit and for
     * given list of commit
     *
     * @param listofCommit list of RevCommit to study
     *
     * @return [DeveloperHistory]
     */
    fun getDevHistoryOfAFileFromList(listofCommit: List<NamedCommit> = ArrayList()): DeveloperHistory {
        val numberOfChange = listofCommit.size
        val numberOfCurrentDev = gitBlameNbDev(listofCommit[0].filePath, listofCommit[0].revCommit)
        val listofAuthor = HashSet<String>()
        listofCommit.forEach { commit -> listofAuthor.add(commit.revCommit.authorIdent.emailAddress) }
        val numberOfDevTotal = listofAuthor.size
        return DeveloperHistory(numberOfDevTotal, numberOfCurrentDev, numberOfChange)
    }

    /**
     * Function to get the Delta history of a file before a given commit
     *
     * @param filePath file to study
     * @param commit hash of the commit (Default : HEAD)
     *
     * @return [DeltaHistory]
     */
    fun getDeltaFile(filePath: String, commit: String = "HEAD"): DeltaHistory? {
        val listofCommit = listOfCommitImpactingAFile(filePath, commit) ?: return null
        return getDeltaFileFromList(listofCommit)
    }

    /**
     * Function to get the Delta history of a file through a given list of commit
     *
     * @param listofCommit list of RevCommit to study
     *
     * @return [DeltaHistory]
     */
    fun getDeltaFileFromList(listofCommit: List<NamedCommit>): DeltaHistory {
        var sumDeltaFile: DeltaHistory = DeltaHistory()
        try {
            if (listofCommit.size > 1) {
                var newFile = retrievingFileFromSpecificCommit(listofCommit[0].revCommit.id.name, listofCommit[0].filePath)?.split("\n") ?: listOf()
                for (i in 1..(listofCommit.size - 1)) {
                    val oldFile = retrievingFileFromSpecificCommit(listofCommit[i].revCommit.id.name, listofCommit[i].filePath)?.split("\n") ?: listOf()
                    if (oldFile.size != 0) {
                        sumDeltaFile.sum(DiffComputing.computeDelta(oldFile, newFile))
                        newFile = oldFile;
                    }
                }
                val oldFile = listOf<String>()
                sumDeltaFile.sum(DiffComputing.computeDelta(oldFile, newFile))
            }
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        }
        return sumDeltaFile
    }

    /**
     * Method to get the list of all file corresponding to a given pattern modified by a specific commit
     *
     * @param hash of the commit to study
     * @param pattern can be null
     *
     * @return [List<String>] of the files
     */
    @Throws(IOException::class)
    fun getListOfModifiedFile(hash: String, pattern: String? = null): List<String> {
        val listOfModifiedFile = ArrayList<String>()

        try {
            val oldTreeIter = CanonicalTreeParser()
            val newTreeIter = CanonicalTreeParser()
            val treeIDnew = repo.resolve(hash + "^{tree}")
            val treeIDold = repo.resolve(hash + "~1^{tree}")
            val reader = repo.newObjectReader()

            oldTreeIter.reset(reader, treeIDold)
            newTreeIter.reset(reader, treeIDnew)

            val diffFormatter: DiffFormatter = DiffFormatter(DisabledOutputStream.INSTANCE)
            diffFormatter.setRepository(repo)
            val entries: List<DiffEntry> = diffFormatter.scan(oldTreeIter, newTreeIter)
            for (entry in entries) {
                if (entry.changeType.toString().equals("MODIFY")) {
                    if (pattern != null) {
                        if (Regex(pattern).matches(entry.newPath))
                            listOfModifiedFile.add(entry.newPath)
                    } else listOfModifiedFile.add(entry.newPath)
                }
            }

        } catch (e: IOException) {
            e.printStackTrace()
        }
        return listOfModifiedFile
    }

    /**
     * Method to retireve the message of a given commit
     */
    @Throws(IOException::class)
    fun getCommitMessage(hash: String): String{
        val revWalk = RevWalk(repo)
        val commitId = repo.resolve(hash)
        val commit = revWalk.parseCommit(commitId)
        return commit.fullMessage
    }

    /**
     * Method to retrieve the time of a commit
     */
    @Throws(IOException::class)
    fun getTimeCommit(hash: String): Int {
        val revWalk = RevWalk(repo)
        val commitId = repo.resolve(hash)
        val commit = revWalk.parseCommit(commitId)
        return commit.commitTime
    }

    /**
     * Method to be called when work on git has been done
     */
    fun close() {
        repo.close()
        git.close()
    }

    data class NamedCommit(val filePath: String, val revCommit: RevCommit)
    data class DeveloperHistory(val totalNumberOfDeveloper: Int = 0, val currentNumberOfDeveloper: Int = 0, val numberOfChanges: Int = 0)

}