package data7.greycat;

import data7.importer.cve.DatasetUpdateListener;
import data7.model.vulnerability.Vulnerability;
import greycat.Callback;
import greycat.Graph;
import greycat.Task;
import greycat.TaskResult;

import static greycat.Tasks.newTask;

public class GreycatUpdateListener implements DatasetUpdateListener{

    private final Graph graph;
    private Task task;

    GreycatUpdateListener(Graph graph){
        this.graph = graph;
        this.task = newTask();
    }

    @Override
    public void bugAddedTo(Vulnerability vulnerability,String bugId) {
        task = task.then(retrieveVulnerability(vulnerability.getCve()))
                .then(addBugToVulnerability(bugId));
    }

    @Override
    public void commitAddedTo(Vulnerability vulnerability, String hash) {

    }

    @Override
    public void scoreUpdatedFor(Vulnerability vulnerability) {
        task = task.then(retrieveVulnerability(vulnerability.getCve()))
                .then(updateScoreVulnerability(vulnerability.getScore()));
    }

    @Override
    public void cweUpdatedFor(Vulnerability vulnerability) {
        task = task.then(retrieveVulnerability(vulnerability.getCve()))
                .then(updateCWEVulnerability(vulnerability.getCwe()));
    }

    @Override
    public void addVulnerability(Vulnerability vulnerability) {
        task = task
                .then(createVulnerability(vulnerability));
    }

    @Override
    public void updatefinished() {
    task.execute(graph, new Callback<TaskResult>() {
        @Override
        public void on(TaskResult taskResult) {
            System.out.println("Greycat update Done");
        }
    });
    }
}
