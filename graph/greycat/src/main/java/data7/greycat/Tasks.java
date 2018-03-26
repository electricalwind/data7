package data7.greycat;

import data7.greycatmodel.*;
import data7.model.change.Commit;
import data7.model.change.FileFix;
import data7.model.vulnerability.Vulnerability;
import greycat.Task;
import greycat.TaskResult;
import greycat.plugin.SchedulerAffinity;
import greycat.struct.Relation;

import java.util.ArrayList;
import java.util.List;

import static data7.greycat.actions.Data7Actions.*;
import static greycat.Tasks.newTask;
import static greycat.Tasks.then;

public class Tasks {


    protected static Task createVulnerability(Vulnerability vulnerability, String project) {
        List<Commit> commits = new ArrayList<>(vulnerability.getPatchingCommits().values());
        return
                then(getOrCreateYearFor(vulnerability.getCve()))
                        .then(createBasicVulnerability(vulnerability))
                        .setAsVar("Vulnerability")
                        .then(setProject(project))
                        .then(getProjectNode(project))
                        .setAsVar("PROJECT")
                        .loop("0", String.valueOf(commits.size() - 1),
                                newTask()
                                        .thenDo(ctx -> {
                                            int i = ctx.intVar("i");
                                            Commit commit = commits.get(i);
                                            CommitNode node = CommitNode.create(ctx.world(), commit.getTimestamp(), ctx.graph());
                                            node.setHash(commit.getHash());
                                            node.setDescription(commit.getMessage());
                                            ctx.defineVariable("currentTime", ctx.time());
                                            node.addToVulnerability((CVENode) ctx.variable("Vulnerability").get(0),
                                                    commitNode -> {
                                                        TaskResult taskResult = ctx.newResult();
                                                        taskResult.allocate(commit.getFixes().size());
                                                        for (FileFix fileFix : commit.getFixes()) {
                                                            taskResult.add(fileFix);
                                                        }
                                                        ctx.continueWith(taskResult);
                                                    });
                                        })
                                        .forEach(
                                                newTask()
                                                        .setAsVar("fileFix")
                                                        .thenDo(ctx -> {
                                                            FileFix fileFix = (FileFix) ctx.result().get(0);
                                                            ctx.setTime(fileFix.getLastModified());
                                                            ctx.setVariable("filename", fileFix.getFileBefore().getFilePath());
                                                            ctx.continueTask();
                                                        })
                                                        .readVar("PROJECT")
                                                        .then(getOrCreateFile("{{filename}}"))
                                                        .thenDo(ctx -> {
                                                            FileNode node = (FileNode) ctx.result().get(0);
                                                            FileFix fileFix = (FileFix) ctx.variable("fileFix").get(0);
                                                            node.setContent(fileFix.getFileBefore().getFileContent());
                                                            long time = ctx.longVar("currentTime");
                                                            node.travelInTime(time, modifiedNode -> {
                                                                ((FileNode) modifiedNode).setContent(fileFix.getFileAfter().getFileContent());
                                                                if (!fileFix.getFileAfter().getFilePath().equals(fileFix.getFileBefore().getFilePath())) {
                                                                    String[] pathbe = fileFix.getFileBefore().getFilePath().split("/");
                                                                    String[] pathaf = fileFix.getFileAfter().getFilePath().split("/");
                                                                    if (!pathbe[pathbe.length - 1].equals(pathaf[pathaf.length - 1])) {
                                                                        ((FileNode) modifiedNode).setName(pathaf[pathaf.length - 1]);
                                                                    }

                                                                    Task traverse = newTask().readVar("PROJECT");
                                                                    for (int i = 0; i < pathaf.length - 1; i++) {
                                                                        traverse.then(traverseOrCreateDirectory(pathaf[i]));
                                                                    }

                                                                    traverse
                                                                            .thenDo(ctxn -> {
                                                                                Relation rel = modifiedNode.getRelation(ContentNode.PARENT.name);
                                                                                long previousId = rel.get(0);
                                                                                long newId = ctxn.resultAsNodes().get(0).id();
                                                                                if (previousId != newId) {
                                                                                    DirectoryNode dn = (DirectoryNode) ctxn.resultAsNodes().get(0);
                                                                                    dn.addToContents((ContentNode) modifiedNode);
                                                                                    rel.set(0, newId);
                                                                                }
                                                                                ctxn.continueTask();
                                                                            }).clearResult()
                                                                            .executeFrom(ctx, ctx.newResult(), SchedulerAffinity.SAME_THREAD, callback -> ctx.continueTask());
                                                                } else {
                                                                    ctx.continueTask();
                                                                }
                                                            });
                                                        })

                                        )
                        );
    }
}
