package data7.greycat;

import data7.greycatmodel.*;
import data7.model.change.Commit;
import data7.model.change.FileFix;
import data7.model.vulnerability.Vulnerability;
import greycat.*;
import greycat.struct.StringArray;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;

import static data7.greycat.Resources.PROJECT_VAR;
import static data7.greycat.actions.Data7Actions.*;
import static greycat.Constants.BEGINNING_OF_TIME;
import static greycat.Tasks.newTask;

public class Tasks {

    private static Task getYear(String cve) {
        Matcher matcher = Utils.vulnerabilityMatch(cve);
        matcher.find();
        String year = matcher.group(1);
        return newTask()
                .readIndex(Years.META.name, year)
                .ifThen(ctx -> ctx.result().size() == 0,
                        newTask()
                                .thenDo(ctx -> {
                                    YearNode node = YearNode.create(0, BEGINNING_OF_TIME, ctx.graph());
                                    node.setYear(Integer.valueOf(year));
                                    Years.update(node, aBoolean -> ctx.continueWith(ctx.wrap(node)));
                                })
                );
    }



    private static Task findFile() {
        //String[] path = file.split("/");
        return newTask()
                .setAsVar("File")
                .readVar(PROJECT_VAR)
                .traverse(ProjectNode.ROOT.name)
                .ifThen(ctx -> ctx.result().size() == 0,
                        newTask().thenDo(ctx -> {
                            DirectoryNode node = DirectoryNode.create(0, BEGINNING_OF_TIME, ctx.graph());
                            node.setName("/");
                            ((ProjectNode) ctx.variable(PROJECT_VAR)).addToRoot(node);
                            ctx.continueWith(ctx.wrap(node));
                        }))
                .defineAsVar("CurrentDirectory")
                .loop("0", String.valueOf(path.length - 2),
                        newTask()
                                .readVar("CurrentDirectory")
                                .traverse(DirectoryNode.CONTENTS.name)
                                .thenDo(ctx -> {
                                    int i = ctx.intVar("i");
                                    String part = path[i];
                                    TaskResult<Node> res = ctx.resultAsNodes();
                                    DirectoryNode nextNode = null;
                                    for (int k = 0; k < res.size(); k++) {
                                        DirectoryNode directoryNode = (DirectoryNode) res.get(k);
                                        if (directoryNode.getName().equals(part)) {
                                            nextNode = directoryNode;
                                        }
                                    }
                                    if (nextNode == null) {
                                        DirectoryNode currentNode = (DirectoryNode) ctx.variable("CurrentDirectory");
                                        nextNode = DirectoryNode.create(0, BEGINNING_OF_TIME, ctx.graph());
                                        nextNode.setName(path[i]);
                                        nextNode.addToParent(currentNode);
                                        currentNode.addToContents(nextNode);
                                    }
                                    ctx.continueWith(ctx.wrap(nextNode));
                                })
                                .setAsVar("CurrentDirectory")
                ).readVar("CurrentDirectory")
                .travelInTime(String.valueOf(time))
                .traverse(DirectoryNode.CONTENTS.name)
                .thenDo(ctx -> {
                    String filepart = path[path.length - 1];
                    TaskResult<Node> res = ctx.resultAsNodes();
                    FileNode fnode = null;
                    for (int k = 0; k < res.size(); k++) {
                        ContentNode cNode = (ContentNode) res.get(k);
                        if (cNode.getName().equals(filepart)) {
                            fnode = (FileNode) cNode;
                        }
                    }
                    if (fnode == null) {
                        DirectoryNode currentNode = (DirectoryNode) ctx.variable("CurrentDirectory");
                        fnode = FileNode.create(0, ctx.time(), ctx.graph());
                        fnode.setName(filepart);
                        fnode.addToParent(currentNode);
                        currentNode.addToContents(fnode);
                    }
                    ctx.continueWith(ctx.wrap(fnode));
                });
    }

    protected static Task createVulnerability(Vulnerability vulnerability) {
        List<Commit> commits = new ArrayList<>(vulnerability.getPatchingCommits().values());
        return getYear(vulnerability.getCve())
                .setAsVar("YEAR")
                .then(createBasicVulnerability(vulnerability))
                .setAsVar("Vulnerability")
                .then(setCWE(vulnerability.getCwe()))
                .then(setProject())
                .then(setYear())
                .loop("0", String.valueOf(commits.size()),
                        newTask()
                                .thenDo(ctx -> {
                                    int i = ctx.intVar("i");
                                    Commit commit = commits.get(i);
                                    CommitNode node = CommitNode.create(ctx.world(), commit.getTimestamp(), ctx.graph());
                                    node.setHash(commit.getHash());
                                    node.setDescription(commit.getMessage());
                                    ctx.defineVariable("commit", node);
                                    node.addToVulnerability((CVENode) ctx.variable("Vulnerability").get(0), new Callback<CommitNode>() {
                                        @Override
                                        public void on(CommitNode commitNode) {
                                            TaskResult taskResult = ctx.newResult();
                                            taskResult.allocate(commit.getFixes().size());
                                            for (FileFix fileFix : commit.getFixes()) {
                                                taskResult.add(fileFix);
                                            }
                                            ctx.continueWith(taskResult);
                                        }
                                    });
                                })
                                .forEach(
                                        newTask()
                                                .setAsVar("fileFix")
                                                .thenDo(ctx -> {
                                                    FileFix fileFix = (FileFix) ctx.result().get(0);
                                                    ctx.setTime(fileFix.getLastModified());
                                                    ctx.continueWith(ctx.wrap(fileFix.getFileBefore().getFileContent()));
                                                })

                                )
                )

    }
}
