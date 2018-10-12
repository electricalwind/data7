package data7.importer;

import data7.Data7UpdateListener;
import data7.model.Data7;
import data7.model.vulnerability.Vulnerability;
import gitUtilitaries.GitActions;

import java.util.Map;

public abstract class Data7Source {

    // Data7 object
    protected  Data7 dataset;
    // Listeners
    private  Data7UpdateListener[] listeners;
    // Git per Component
    protected  Map<String, GitActions> gitmap;


    public abstract void process();

    public abstract String sourceName();

    /**
     * Setters
     */

    final void setDataset(Data7 dataset) {
        this.dataset = dataset;
    }

    final void setListeners(Data7UpdateListener[] listeners) {
        this.listeners = listeners;
    }

    final void setGitmap(Map<String, GitActions> gitmap) {
        this.gitmap = gitmap;
    }


    /**
     * Listeners Handling
     */

    protected final void newVulnerabilityEvent(Vulnerability vulnerability) {
        for (Data7UpdateListener listener : listeners) {
            listener.addVulnerability(vulnerability);
        }
    }

    protected final void bugAddedToVulnerabilityEvent(Vulnerability vulnerability, String bugId,String component) {
        for (Data7UpdateListener listener : listeners) {
            listener.bugAddedTo(vulnerability, bugId, component);
        }
    }

    protected final void commitAddedToVulnerabilityEvent(Vulnerability vulnerability, String hash, String component) {
        for (Data7UpdateListener listener : listeners) {
            listener.commitAddedTo(vulnerability, hash,component);
        }
    }

    protected final void scoreUpdatedForVulnerabilityEvent(Vulnerability vulnerability) {
        for (Data7UpdateListener listener : listeners) {
            listener.scoreUpdatedFor(vulnerability);
        }
    }

    protected final void cweUpdatedForVulnerabilityEvent(Vulnerability vulnerability) {
        for (Data7UpdateListener listener : listeners) {
            listener.cweUpdatedFor(vulnerability);
        }
    }
}
