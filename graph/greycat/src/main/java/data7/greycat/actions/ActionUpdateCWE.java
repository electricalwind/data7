package data7.greycat.actions;

import data7.greycatmodel.CVENode;
import data7.greycatmodel.Cwes;
import greycat.Action;
import greycat.Constants;
import greycat.TaskContext;
import greycat.internal.task.TaskHelper;
import greycat.struct.Buffer;

import static data7.greycat.Utils.handleTraverseOneResult;

public class ActionUpdateCWE implements Action {
    public static final String NAME = "updateCWE";
    private final String _cwe;

    public ActionUpdateCWE(String p_cwe) {
        this._cwe = p_cwe;
    }

    @Override
    public void eval(TaskContext ctx) {
        String cwe = ctx.template(_cwe);
        if (ctx.result().size() > 0 && ctx.result().get(0) instanceof CVENode) {
            CVENode node = (CVENode) ctx.result().get(0);
            node.getCategory(result -> {
                handleTraverseOneResult(ctx,
                        result,
                        () -> {},
                        () -> {
                            if (result[0].getName().equals(cwe)) {
                                result[0].free();
                                ctx.continueTask();
                            } else {
                                result[0].unindexCves(node);
                                result[0].free();
                            }
                        });
                Cwes.find(ctx.graph(), ctx.world(), ctx.time(), cwe,
                        cweNodes ->
                            handleTraverseOneResult(ctx, cweNodes,
                                    ctx::continueTask,
                                    () -> cweNodes[0].indexCves(node,
                                            cweNode -> {
                                                cweNode.free();
                                                ctx.continueTask();
                                            })
                            )
                        );
            });

        } else {
            ctx.endTask(ctx.result(), new IllegalArgumentException("Invalid current result to call this action"));
        }
    }

    @Override
    public void serialize(Buffer builder) {
        builder.writeString(NAME);
        builder.writeChar(Constants.TASK_PARAM_OPEN);
        TaskHelper.serializeString(_cwe, builder, false);
        builder.writeChar(Constants.TASK_PARAM_CLOSE);
    }

    @Override
    public String name() {
        return NAME;
    }
}
