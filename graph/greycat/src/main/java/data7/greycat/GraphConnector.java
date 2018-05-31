package data7.greycat;

import data7.Importer;
import data7.greycatmodel.CWENode;
import data7.greycatmodel.Cwes;
import data7.greycatmodel.Data7GraphModelPlugin;
import data7.importer.cve.DatasetUpdateListener;
import data7.model.CWE;
import data7.model.Data7;
import data7.model.vulnerability.Vulnerability;
import greycat.*;
import greycat.rocksdb.RocksDBStorage;
import greycat.scheduler.NoopScheduler;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import static data7.greycat.Tasks.createVulnerability;
import static data7.greycat.Utils.handleTraverseOneResult;
import static data7.greycat.actions.Data7Actions.getOrCreateProjectNode;
import static data7.greycat.actions.Data7Actions.getVulnerabilityNode;
import static greycat.Constants.BEGINNING_OF_TIME;
import static greycat.Tasks.newTask;

public class GraphConnector {

    private final Graph graph;

    public GraphConnector() {

        GraphBuilder builder = new GraphBuilder()
                .withPlugin(new Data7GraphModelPlugin())
                .withScheduler(new NoopScheduler())
                .withMemorySize(1000000)
                .withStorage(new RocksDBStorage(Resources.PATH_TO_GRAPH));


        File folder = new File(Resources.PATH_TO_GRAPH);
        boolean importCwe = !(folder.exists() && folder.isDirectory());
        graph = builder.build();
        graph.connect(connected -> {
            if (importCwe) {
                try {
                    fillGraphWithCWE(result -> System.out.println("done"));
                } catch (JAXBException | IOException | ClassNotFoundException e) {
                    System.err.println("could not fill graph with CWE");
                    e.printStackTrace();
                }
            } else {
                Cwes.findAll(graph, 0, BEGINNING_OF_TIME, nodes -> {
                    int k = 0;
                    graph.freeNodes(nodes);
                });
            }
        });
    }

    private void fillGraphWithCWE(Callback<Boolean> resultOfFilling) throws JAXBException, IOException, ClassNotFoundException {
        List<CWE> cweList = Importer.getListOfCWE();
        Task fillTask = newTask();
        for (CWE cwe : cweList) {
            fillTask = fillTask
                    .clearResult()
                    .thenDo(
                            ctx -> Cwes.find(ctx.graph(), 0, BEGINNING_OF_TIME, String.valueOf(cwe.getId()), cweNodes ->
                                    handleTraverseOneResult(ctx, cweNodes,
                                            () -> {
                                                CWENode node = CWENode.create(0, BEGINNING_OF_TIME, graph);
                                                node.setIdentifier(String.valueOf(cwe.getId()));
                                                Cwes.update(node, result -> ctx.continueWith(ctx.wrap(node)));
                                            },
                                            () -> ctx.continueWith(ctx.wrap(cweNodes[0]))
                                    )
                            )
                    )
                    .thenDo(ctx -> {
                        CWENode node = (CWENode) ctx.result().get(0);
                        node.setName(cwe.getName());
                        node.setDescription(cwe.getDescription());
                        ctx.continueTask();
                    });
            for (Integer id : cwe.getChildOf()) {
                fillTask = fillTask
                        .thenDo(ctx -> {
                            CWENode node = (CWENode) ctx.result().get(0);
                            Cwes.find(graph, 0, BEGINNING_OF_TIME, String.valueOf(id), cweNodes ->
                                    handleTraverseOneResult(ctx, cweNodes,
                                            () -> {
                                                CWENode child = CWENode.create(0, BEGINNING_OF_TIME, graph);
                                                child.setIdentifier(String.valueOf(id));
                                                node.addToChildOf(child);
                                                Cwes.update(child, result -> {
                                                    child.free();
                                                    ctx.continueTask();
                                                });
                                            },
                                            () -> {
                                                node.addToChildOf(cweNodes[0]);
                                                cweNodes[0].free();
                                                ctx.continueTask();
                                            })
                            );
                        });
            }
            fillTask = fillTask.thenDo(ctx -> {
                System.out.println(ctx.graph().space().available());
                ctx.continueTask();
            });
        }
        TaskResult tr = fillTask.executeSync(graph);

        System.out.println(graph.space().available());
        if (tr != null) {
            if (tr.exception() != null) {
                tr.exception().printStackTrace();
            } else {
                System.out.println("CWE correctly imported in the graph");
                tr.free();
            }
        }
        graph.save(result -> {
            System.out.println("saved");
            resultOfFilling.on(true);
        });


    }


    public DatasetUpdateListener getGreycatListener() {
        return new GreycatUpdateListener(graph);
    }

    public void updateGraphWith(Data7 data7, Callback<Boolean> callback) {
        Task task = newTask()
                .then(getOrCreateProjectNode(data7.getProject().getName()));
        for (Map.Entry<String, Vulnerability> vulnerabilityEntry : data7.getVulnerabilitySet().getVulnerabilityDataset().entrySet()) {
            task = task
                    .then(getVulnerabilityNode(vulnerabilityEntry.getKey()))
                    .ifThenElse(ctx -> ctx.result().size() > 0,
                            updateVulnerability(vulnerabilityEntry.getValue()),
                            createVulnerability(vulnerabilityEntry.getValue(), data7.getProject().getName())
                    );

        }

        task.save()
                .execute(graph, new Callback<TaskResult>() {
                    @Override
                    public void on(TaskResult result) {
                        int k = 0;
                        result.clear();
                        callback.on(true);
                    }
                });

    }

    private Task updateVulnerability(Vulnerability value) {
        return newTask().thenDo(ctx ->
        {
            ctx.continueTask();
        });
    }

    public static void main(String[] args) throws ParseException, IOException, ClassNotFoundException {
        new GraphConnector();
        /**.updateGraphWith(updateOrCreateDatasetFor(CProjects.SYSTEMD), new Callback<Boolean>() {
        @Override public void on(Boolean result) {
        System.out.println("done");
        }
        });*/
    }
}
