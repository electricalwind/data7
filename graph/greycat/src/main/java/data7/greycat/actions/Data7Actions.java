package data7.greycat.actions;

import data7.model.vulnerability.Vulnerability;
import greycat.Action;

public class Data7Actions {

    public static Action createBasicVulnerability(Vulnerability vulnerability) {
        return new ActionCreateVulnerabilityNode(vulnerability);
    }

    public static Action getProjectNode(String project){
        return new ActionGetOrCreateProject(project,false);
    }

    public static Action getOrCreateProjectNode(String project){
        return new ActionGetOrCreateProject(project,true);
    }


    public static Action getVulnerabilityNode(String cve) {
        return new ActionGetVulnerability(cve);
    }

    public static Action setCWE(String cwe) {
        return new ActionSetCWE(cwe);
    }


    public static Action setYear() {
        return new ActionSetYear();
    }


    public static Action traverseDirectoryNode(String next){
        return new ActionTraverseDirectory(next,ActionTraverseDirectory.DONT_CREATE);
    }

    public static Action traverseOrCreateFile(String next){
        return new ActionTraverseDirectory(next,ActionTraverseDirectory.CREATE_FILE);
    }

    public static Action traverseOrCreateDirectory(String next){
        return new ActionTraverseDirectory(next,ActionTraverseDirectory.CREATE_DIRECTORY);
    }

}
