package data7.greycat.actions;

import greycat.Action;
import greycat.TaskContext;
import greycat.struct.Buffer;

public class ActionGetOrCreateFile implements Action {

    private final boolean _createIfNotExisting;
    private final String _file;
    private final String _project;

    public ActionGetOrCreateFile(String p_file, boolean createIfNotExisting, String p_project) {
        this._file = p_file;
        this._createIfNotExisting = createIfNotExisting;
        this._project = p_project;
    }

    @Override
    public void eval(TaskContext ctx) {
       /** String file = ctx.template(_file);
        if (ctx.variable(file).size() > 0 && ctx.variable(file).get(0) instanceof String) {
            file = (String) ctx.variable(file).get(0);
        }
        String[] path = file.split("/");



        ctx.setVariable(PROJECT_VAR, projectNode[0]);
        newTask()
                .readVar(PROJECT_VAR)
                .traverse(ProjectNode.ROOT.name)
                .ifThen(taskContext -> taskContext.result().size() == 0,
                        newTask()
                                .thenDo(taskContext -> {
                                    if(_createIfNotExisting){
                                        taskContext.endTask();
                                    }
                                    DirectoryNode node = DirectoryNode.create(0, BEGINNING_OF_TIME, taskContext.graph());
                                    node.setName("/");
                                    ((ProjectNode) taskContext.variable(PROJECT_VAR)).addToRoot(node);
                                    taskContext.continueWith(taskContext.wrap(node));
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
                });*/

    }

    @Override
    public void serialize(Buffer builder) {

    }

    @Override
    public String name() {
        return null;
    }
}
