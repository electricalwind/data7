package data7.greycat;

import greycat.Node;
import greycat.TaskContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    public static Matcher vulnerabilityMatch(String cve) {
        Pattern pattern = Pattern.compile("CVE[ ]?-[ ]?([0-9][0-9][0-9][0-9])[ ]?-[ ]?([0-9]+)");
        return pattern.matcher(cve);
    }


    public static void handleTraverseOneResult(TaskContext ctx, Node[] nodes, Runnable case0, Runnable case1) {
        switch (nodes.length) {
            case 0:
                case0.run();
            case 1:
                case1.run();
            default:
                ctx.endTask(ctx.wrap(nodes), new IllegalStateException("More than one Node as result of Index of unique relation traversal, graph is likely corrupted"));
        }
    }
}
