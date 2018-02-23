package data7.greycat.actions;


import data7.greycat.Utils;
import data7.greycatmodel.CVENode;
import data7.greycatmodel.YearNode;
import data7.greycatmodel.Years;
import greycat.Action;
import greycat.Constants;
import greycat.TaskContext;
import greycat.struct.Buffer;

import java.util.regex.Matcher;

import static data7.greycat.Utils.handleTraverseOneResult;
import static greycat.Constants.BEGINNING_OF_TIME;

public class ActionSetYear implements Action {
    public static final String NAME = "setYear";

    @Override
    public void eval(TaskContext ctx) {
        if (ctx.result().size() > 0 && ctx.result().get(0) instanceof CVENode) {
            CVENode cveNode = (CVENode) ctx.result().get(0);
            Matcher matcher = Utils.vulnerabilityMatch(cveNode.getIdentifier());
            if (!matcher.find()) {
                ctx.endTask(ctx.result(), new IllegalArgumentException("Invalid cve " + cveNode.getIdentifier()));
            }
            String year = matcher.group(1);
            Years.find(ctx.graph(), ctx.world(), ctx.time(), year, result -> {
                handleTraverseOneResult(ctx,
                        result,
                        () -> {
                            YearNode node = YearNode.create(0, BEGINNING_OF_TIME, ctx.graph());
                            node.setYear(Integer.valueOf(year));
                            node.indexCves(cveNode);
                            Years.update(node, res -> {
                                node.free();
                                ctx.continueTask();
                            });
                        },
                        () -> {
                            result[0].indexCves(cveNode);
                            result[0].free();
                            ctx.continueTask();
                        });
            });

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
