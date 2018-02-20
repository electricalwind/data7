package data7.importer.cve;

import data7.model.vulnerability.Vulnerability;

import java.util.EventListener;

public interface DatasetUpdateListener extends EventListener {

    void bugAddedTo(Vulnerability vulnerability, String bugId);

    void commitAddedTo(Vulnerability vulnerability, String hash);

    void scoreUpdatedFor(Vulnerability vulnerability);

    void cweUpdatedFor(Vulnerability vulnerability);

    void addVulnerability(Vulnerability vulnerability);

    void updatefinished();
}
