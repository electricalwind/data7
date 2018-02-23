package data7.greycat;

import data7.Importer;
import data7.greycatmodel.*;
import data7.importer.cve.DatasetUpdateListener;
import data7.model.CWE;
import data7.model.Data7;
import data7.model.vulnerability.Vulnerability;
import greycat.*;
import greycat.rocksdb.RocksDBStorage;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import data7.greycatmodel.Projects;

import static data7.greycat.Resources.PROJECT_VAR;
import static data7.greycat.actions.Data7Actions.retrieveVulnerability;
import static greycat.Constants.BEGINNING_OF_TIME;
import static greycat.Tasks.newTask;

public class GraphConnector {

    private final Graph graph;

    public GraphConnector() {

        GraphBuilder builder = new GraphBuilder().withPlugin(new Data7GraphModelPlugin()).withStorage(new RocksDBStorage(Resources.PATH_TO_GRAPH));
        File folder = new File(Resources.PATH_TO_GRAPH);
        boolean importCwe = !(folder.exists() && folder.isDirectory() && folder.list().length > 0);
        graph = builder.build();
        graph.connect(connected -> {
            if (importCwe) {
                try {
                    fillGraphWithCWE();
                    graph.save(result -> System.out.println("graph is fill with cwe information and saved"));
                } catch (JAXBException | IOException | ClassNotFoundException e) {
                    System.err.println("could not fill graph with CWE");
                    e.printStackTrace();
                }
            }
        });
    }

    private void fillGraphWithCWE() throws JAXBException, IOException, ClassNotFoundException {
        List<CWE> cweList = Importer.getListOfCWE();
        for (CWE cwe : cweList) {
            CWENode[] cweNode = new CWENode[1];
            Cwes.find(graph, 0, BEGINNING_OF_TIME, String.valueOf(cwe.getId()), cweNodes -> {
                if (cweNodes.length > 0) {
                    cweNode[0] = cweNodes[0];
                } else {
                    cweNode[0] = CWENode.create(0, BEGINNING_OF_TIME, graph);
                    cweNode[0].setId(cwe.getId());
                    Cwes.update(cweNode[0], null);
                }
            });
            cweNode[0].setName(cwe.getName());
            cweNode[0].setDescription(cwe.getDescription());

            for (Integer id : cwe.getChildOf()) {
                Cwes.find(graph, 0, BEGINNING_OF_TIME, String.valueOf(id), cweNodes -> {
                    CWENode child;
                    if (cweNodes.length > 0) {
                        child = cweNodes[0];
                    } else {
                        child = CWENode.create(0, BEGINNING_OF_TIME, graph);
                        child.setId(cwe.getId());
                        Cwes.update(child, null);
                    }
                    cweNode[0].addToChildOf(child);
                    child.free();
                });
            }
            cweNode[0].free();
        }
    }

    public DatasetUpdateListener getGreycatListener() {
        return new GreycatUpdateListener(graph);
    }

    public void updateGraphWith(Data7 data7) {
        Task task = newTask()
                .readIndex(Projects.META.name, data7.getProject().getName())
                .ifThen(ctx -> ctx.result().size() == 0,
                        newTask().thenDo(new ActionFunction() {
                            @Override
                            public void eval(TaskContext ctx) {
                                ProjectNode project = ProjectNode.create(0, BEGINNING_OF_TIME, graph);
                                project.setName(data7.getProject().getName());
                                Projects.update(project, new Callback<Boolean>() {
                                    @Override
                                    public void on(Boolean result) {
                                        ctx.continueWith(ctx.wrap(project));
                                    }
                                });
                            }
                        }))
                .defineAsGlobalVar(PROJECT_VAR);
        for (Map.Entry<String, Vulnerability> vulnerabilityEntry : data7.getVulnerabilitySet().getVulnerabilityDataset().entrySet()) {
            task = task
                    .then(retrieveVulnerability(vulnerabilityEntry.getKey()))
                    .ifThenElse(ctx -> ctx.result().size() > 0,
                            updateVulnerability(vulnerabilityEntry.getValue()),
                            createVulnerability(vulnerabilityEntry.getValue())
                    );

        }

        task.execute(graph, new Callback<TaskResult>() {
            @Override
            public void on(TaskResult result) {

            }
        });

    }


}
