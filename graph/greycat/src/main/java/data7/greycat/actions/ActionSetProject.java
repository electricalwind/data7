package data7.greycat.actions;


import data7.greycatmodel.CVENode;
import data7.greycatmodel.Projects;
import greycat.Action;
import greycat.Callback;
import greycat.Constants;
import greycat.TaskContext;
import greycat.struct.Buffer;

import static data7.greycat.Utils.handleTraverseOneResult;

public class ActionSetProject implements Action {
    public static final String NAME = "setProject";
    private final String _project;

    public ActionSetProject(String p_project) {
        this._project = p_project;
    }

    @Override
    public void eval(TaskContext ctx) {
        String project = ctx.template(_project);
        if (ctx.result().size() > 0 && ctx.result().get(0) instanceof CVENode) {
            CVENode cveNode = (CVENode) ctx.result().get(0);
            if (cveNode.getRelation(CVENode.PROJECT.name) == null) {
                Projects.find(ctx.graph(), ctx.world(), ctx.time(), project, result ->
                        handleTraverseOneResult(ctx,
                                result,
                                () -> ctx.endTask(ctx.newResult(), new IllegalArgumentException("project does'nt exist"))
                                ,
                                () ->
                                        cveNode.addToProject(result[0], (Callback<CVENode>) result1 -> {
                                            result[0].free();
                                            ctx.continueTask();
                                        })

                        ));
            } else {
                ctx.endTask(ctx.result(), new IllegalArgumentException("Project already set"));
            }
        } else {
            ctx.endTask(ctx.result(), new IllegalArgumentException("Invalid current result to call this action"));
        }
    }


    @Override
    public void serialize(Buffer builder) {
        builder.writeString(NAME);
        builder.writeChar(Constants.TASK_PARAM_OPEN);
        builder.writeChar(Constants.TASK_PARAM_CLOSE);
    }

    @Override
    public String name() {
        return NAME;
    }
}
