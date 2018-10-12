package data7.importer;

import data7.Data7UpdateListener;
import data7.model.Data7;
import data7.model.vulnerability.Vulnerability;
import gitUtilitaries.GitActions;

import java.util.Map;

public abstract class Data7Source {

    protected  Data7 dataset;
    private  Data7UpdateListener[] listeners;
    protected  Map<String, GitActions> gitmap;


    protected Data7Source(){}


    public abstract void process();


    public abstract String sourceName();

    public Data7 getDataset() {
        return dataset;
    }

    private Map<String, GitActions> getGitmap() {
        return gitmap;
    }

    void setDataset(Data7 dataset) {
        this.dataset = dataset;
    }

    void setListeners(Data7UpdateListener[] listeners) {
        this.listeners = listeners;
    }

    void setGitmap(Map<String, GitActions> gitmap) {
        this.gitmap = gitmap;
    }

    protected void newVulnerabilityEvent(Vulnerability vulnerability) {
        for (Data7UpdateListener listener : listeners) {
            listener.addVulnerability(vulnerability);
        }
    }

    protected void bugAddedToVulnerabilityEvent(Vulnerability vulnerability, String bugId,String component) {
        for (Data7UpdateListener listener : listeners) {
            listener.bugAddedTo(vulnerability, bugId, component);
        }
    }

    protected void commitAddedToVulnerabilityEvent(Vulnerability vulnerability, String hash, String component) {
        for (Data7UpdateListener listener : listeners) {
            listener.commitAddedTo(vulnerability, hash,component);
        }
    }

    protected void scoreUpdatedForVulnerabilityEvent(Vulnerability vulnerability) {
        for (Data7UpdateListener listener : listeners) {
            listener.scoreUpdatedFor(vulnerability);
        }
    }

    protected void cweUpdatedForVulnerabilityEvent(Vulnerability vulnerability) {
        for (Data7UpdateListener listener : listeners) {
            listener.cweUpdatedFor(vulnerability);
        }
    }
}
