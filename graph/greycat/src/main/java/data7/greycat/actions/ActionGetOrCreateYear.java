package data7.greycat.actions;

import data7.greycat.Utils;
import data7.greycatmodel.YearNode;
import data7.greycatmodel.Years;
import greycat.Action;
import greycat.TaskContext;
import greycat.struct.Buffer;

import java.text.ParseException;
import java.util.regex.Matcher;

import static data7.greycat.Utils.handleTraverseOneResult;
import static greycat.Constants.BEGINNING_OF_TIME;

public class ActionGetOrCreateYear implements Action {

    private final String _cve;

    public ActionGetOrCreateYear(String p_cve) {
        this._cve = p_cve;
    }

    @Override
    public void eval(TaskContext ctx) {
        String cve = ctx.template(_cve);
        Matcher m = Utils.vulnerabilityMatch(cve);
        if (m.find()) {
            String year = m.group(1);
            Years.find(ctx.graph(), ctx.world(), ctx.time(), year,
                    yearNodes ->
                            handleTraverseOneResult(ctx,
                                    yearNodes,
                                    () -> {
                                        YearNode node = YearNode.create(0, BEGINNING_OF_TIME, ctx.graph());
                                        node.setYear(Integer.valueOf(year));
                                        Years.update(node, aBoolean -> ctx.continueWith(ctx.wrap(node)));
                                    },
                                    () -> ctx.continueWith(ctx.wrap(yearNodes[0]))));
        } else {
            ctx.endTask(ctx.newResult(), new ParseException(_cve + " is not a cve", 0));
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
