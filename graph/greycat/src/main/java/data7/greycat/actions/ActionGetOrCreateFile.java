package data7.greycat.actions;

import data7.greycatmodel.ProjectNode;
import greycat.*;
import greycat.plugin.SchedulerAffinity;
import greycat.struct.Buffer;

import java.util.Arrays;
import java.util.Iterator;

import static data7.greycat.actions.Data7Actions.*;
import static greycat.Tasks.*;

public class ActionGetOrCreateFile implements Action {

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
            Iterator<String> itera = Arrays.asList(path).iterator();
            Task traverse;

            if (_createIfNotExisting) {
                traverse = loop(
                        "0",
                        String.valueOf(path.length - 2),
                        then(traverseOrCreateDirectory(itera.next()))
                ).then(traverseOrCreateFile(itera.next()));
            } else {
                traverse = loop("0", String.valueOf(path.length - 1),
                        then(traverseDirectoryNode(itera.next())));
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
        } else {
            ctx.endTask(ctx.result(), new IllegalArgumentException("Invalid current result to call this action"));
        }
    }

    @Override
    public void serialize(Buffer builder) {

    }

    @Override
    public String name() {
        return null;
    }
}
