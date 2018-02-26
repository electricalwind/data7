package data7.greycat.actions;

import data7.greycatmodel.DirectoryNode;
import data7.greycatmodel.ProjectNode;
import data7.greycatmodel.Projects;
import greycat.Action;
import greycat.Constants;
import greycat.TaskContext;
import greycat.internal.task.TaskHelper;
import greycat.struct.Buffer;

import static data7.greycat.Utils.handleTraverseOneResult;
import static greycat.Constants.BEGINNING_OF_TIME;

public class ActionGetOrCreateProject implements Action {

    public final static String NAME = "getProjectNode";
    public final static String NAMEC = "getOrCreateProjectNode";

    private final boolean _createIfNotExist;
    private final String _projectName;

    public ActionGetOrCreateProject(String projectName, boolean createIfNotExist) {
        this._projectName = projectName;
        this._createIfNotExist = createIfNotExist;
    }

    @Override
    public void eval(TaskContext ctx) {
        String project = ctx.template(_projectName);
        Projects.find(
                ctx.graph(),
                ctx.world(),
                ctx.time(),
                project,
                result ->
                        handleTraverseOneResult(
                                ctx,
                                result,
                                () -> createProjectNode(ctx, _createIfNotExist, project),
                                () -> ctx.continueWith(ctx.wrap(result[0]))));
    }

    @Override
    public void serialize(Buffer builder) {
        if(_createIfNotExist){
            builder.writeString(NAMEC);
        }else{
            builder.writeString(NAME);
        }
        builder.writeChar(Constants.TASK_PARAM_OPEN);
        TaskHelper.serializeString(_projectName, builder, false);
        builder.writeChar(Constants.TASK_PARAM_CLOSE);
    }

    @Override
    public String name() {
        return NAMEC;
    }

    private static void createProjectNode(TaskContext ctx, boolean createIfNotExist, String project) {
        if (createIfNotExist) {
            ProjectNode projectN = ProjectNode.create(0, BEGINNING_OF_TIME, ctx.graph());
            projectN.setName(project);
            DirectoryNode root = DirectoryNode.create(0, BEGINNING_OF_TIME, ctx.graph());
            root.setName("/");
            projectN.addToRoot(root);
            root.free();
            Projects.update(projectN, result1 -> ctx.continueWith(ctx.wrap(projectN)));
        } else {
            ctx.continueWith(ctx.newResult());
        }
    }
}
