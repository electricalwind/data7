package data7.greycat.actions;

import greycat.Action;
import greycat.Graph;
import greycat.Type;
import greycat.plugin.ActionFactory;
import greycat.plugin.Plugin;

import static data7.greycat.actions.Data7Actions.retrieveVulnerability;
import static data7.greycat.actions.Data7Actions.setCWE;

public class Data7Plugin implements Plugin {
    @Override
    public void start(Graph graph) {
        graph.actionRegistry()
                .getOrCreateDeclaration(ActionRetrieveVulnerability.NAME)
                .setParams(Type.STRING)
                .setDescription("Retrieve the node corresponding to a vulnerability")
                .setFactory(new ActionFactory() {
                                public Action create(Object[] params) {
                                    return retrieveVulnerability((String) params[0]);
                                }
                            }
                );

        graph.actionRegistry()
                .getOrCreateDeclaration(ActionSetCWE.NAME)
                .setParams(Type.STRING)
                .setDescription("Set the CWE of a vulnerability Node")
                .setFactory(new ActionFactory() {
                    @Override
                    public Action create(Object[] params) {
                        return setCWE((String) params[0]);
                    }
                });

    }

    @Override
    public void stop() {

    }
}
