package data7.greycat.actions;

import data7.greycatmodel.ProjectNode;
import greycat.Action;
import greycat.Constants;
import greycat.Task;
import greycat.TaskContext;
import greycat.internal.task.TaskHelper;
import greycat.plugin.SchedulerAffinity;
import greycat.struct.Buffer;

import static data7.greycat.actions.Data7Actions.*;
import static greycat.Tasks.newTask;

public class ActionGetOrCreateFile implements Action {
    public final static String NAME = "getFileNode";
    public final static String NAMEC = "getOrCreateFileNode";
    private final boolean _createIfNotExisting;
    private final String _file;

    public ActionGetOrCreateFile(String p_file, boolean createIfNotExisting) {
        this._file = p_file;
        this._createIfNotExisting = createIfNotExisting;
    }

    @Override
    public void eval(TaskContext ctx) {
        if (ctx.result().size() > 0 && ctx.result().get(0) instanceof ProjectNode) {
            String file = ctx.template(_file);
            String[] path = file.split("/");

            Task traverse = newTask();

            for (int i = 0; i < path.length - 1; i++) {
                if (_createIfNotExisting) {
                    traverse = traverse.then(traverseOrCreateDirectory(path[i]));
                } else {
                    traverse = traverse.then(traverseDirectoryNode(path[i]));
                }
            }
            if (_createIfNotExisting) {
                traverse = traverse.then(traverseOrCreateFile(path[path.length - 1]));
            } else {
                traverse = traverse.then(traverseDirectoryNode(path[path.length - 1]));
            }

            traverse.travelInTime(String.valueOf(ctx.time()))
                    .executeFrom(ctx, ctx.result(), SchedulerAffinity.SAME_THREAD, res -> {
                        Exception exceptionDuringTask = null;
                        if (res != null) {
                            if (res.output() != null) {
                                ctx.append(res.output());
                            }
                            if (res.exception() != null) {
                                exceptionDuringTask = res.exception();
                            }
                        }
                        if (exceptionDuringTask != null) {
                            ctx.endTask(res, exceptionDuringTask);
                        } else {
                            ctx.continueWith(res);
                        }
                    });
        } else

        {
            ctx.endTask(ctx.result(), new IllegalArgumentException("Invalid current result to call this action"));
        }

    }

    @Override
    public void serialize(Buffer builder) {
        if (_createIfNotExisting) {
            builder.writeString(NAMEC);
        } else {
            builder.writeString(NAME);
        }
        builder.writeChar(Constants.TASK_PARAM_OPEN);
        TaskHelper.serializeString(_file, builder, false);
        builder.writeChar(Constants.TASK_PARAM_CLOSE);
    }

    @Override
    public String name() {
        return NAMEC;
    }
}
