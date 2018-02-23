package data7.greycat.actions;

import data7.greycatmodel.DirectoryNode;
import data7.greycatmodel.ProjectNode;
import data7.greycatmodel.Projects;
import greycat.Action;
import greycat.TaskContext;
import greycat.struct.Buffer;

import static data7.greycat.Utils.handleTraverseOneResult;
import static greycat.Constants.BEGINNING_OF_TIME;

public class ActionGetOrCreateProject implements Action {

    public final static String NAME = "getOrCreateProject";

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
                                () -> createVulnerability(ctx, _createIfNotExist, project),
                                () -> ctx.continueWith(ctx.wrap(result[0]))));
    }

    @Override
    public void serialize(Buffer builder) {


    }

    @Override
    public String name() {
        return null;
    }

    private static void createVulnerability(TaskContext ctx, boolean createIfNotExist, String project) {
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
