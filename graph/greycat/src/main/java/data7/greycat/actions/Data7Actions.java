package data7.greycat.actions;

import data7.model.vulnerability.Vulnerability;
import greycat.Action;

public class Data7Actions {

    public static Action retrieveVulnerability(String cve) {
        return new ActionRetrieveVulnerability(cve);
    }

    public static Action setCWE(String cwe) {
        return new ActionSetCWE(cwe);
    }

    public static Action createBasicVulnerability(Vulnerability vulnerability) {
        return new ActionCreateVulnerabilityNode(vulnerability);
    }

    public static Action setYear() {
        return new ActionSetYear();
    }

}
