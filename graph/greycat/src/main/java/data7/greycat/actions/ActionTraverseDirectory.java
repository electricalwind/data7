package data7.greycat.actions;

import data7.greycatmodel.ContentNode;
import data7.greycatmodel.DirectoryNode;
import data7.greycatmodel.FileNode;
import data7.greycatmodel.ProjectNode;
import greycat.Action;
import greycat.Constants;
import greycat.Node;
import greycat.TaskContext;
import greycat.internal.task.TaskHelper;
import greycat.struct.Buffer;

import static greycat.Constants.BEGINNING_OF_TIME;

public class ActionTraverseDirectory implements Action {

    //Name declared for the Plugin
    public static final String NAME = "traverseDirectoryNode";

    private final int _creationChoice;
    private final String _directory;

    public static final int DONT_CREATE = 0;
    public static final int CREATE_DIRECTORY = 1;
    public static final int CREATE_FILE = 2;

    public ActionTraverseDirectory(String directory, int creationChoice) {
        this._directory = directory;
        this._creationChoice = creationChoice;
    }

    @Override
    public void eval(TaskContext ctx) {
        String directory = ctx.template(_directory);
        if (ctx.result().size() > 0 && ctx.result().get(0) instanceof Node) {

            //current result
            Node result = ctx.resultAsNodes().get(0);
            DirectoryNode[] directoryNode = new DirectoryNode[1];
            if (result instanceof ProjectNode) {
                ((ProjectNode) result).getRoot(directoryNodes -> directoryNode[0] = directoryNodes[0]);
            } else if (result instanceof DirectoryNode) {
                directoryNode[0] = (DirectoryNode) result;
            } else {
                ctx.endTask(ctx.result(), new IllegalArgumentException("Invalid current result to call this action"));
            }

            directoryNode[0].getContents(
                    contents -> {
                        ContentNode goodOne = null;
                        for (ContentNode content : contents) {
                            if (content.getName().equals(directory)) {
                                goodOne = content;
                            } else {
                                content.free();
                            }
                        }
                        if (goodOne == null) {
                            ctx.continueWith(ctx.wrap(goodOne));
                        } else {
                            ContentNode node = null;
                            switch (_creationChoice) {
                                case CREATE_DIRECTORY:
                                    node = DirectoryNode.create(0, BEGINNING_OF_TIME, ctx.graph());
                                    break;
                                case CREATE_FILE:
                                    node = FileNode.create(0, BEGINNING_OF_TIME, ctx.graph());
                                    break;
                                case DONT_CREATE:
                                default://DONT_CREATE
                                    ctx.continueWith(ctx.newResult());
                                    break;
                            }
                            node.setName(directory);
                            directoryNode[0].addToContents(node);
                            node.addToParent(directoryNode[0]);
                            ctx.continueWith(ctx.wrap(node));
                        }
                    });
        } else {
            ctx.endTask(ctx.result(), new IllegalArgumentException("Invalid current result to call this action"));
        }
    }

    @Override
    public void serialize(Buffer builder) {
        builder.writeString(NAME);
        builder.writeChar(Constants.TASK_PARAM_OPEN);
        TaskHelper.serializeString(_directory, builder, false);
        builder.writeChar(Constants.TASK_PARAM_CLOSE);
    }

    @Override
    public String name() {
        return NAME;
    }
}
