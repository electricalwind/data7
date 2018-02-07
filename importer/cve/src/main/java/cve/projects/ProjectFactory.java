package cve.projects;

import static cve.projects.CProjects.*;

public class ProjectFactory {

    public static Project retrieveProjectInfo(String name) {
        switch (name) {
            case "linux_kernel":
                return LINUX_KERNEL;
            case "openssl":
                return OPEN_SSL;
            case "wireshark":
                return WIRESHARK;
            case "Systemd":
                return SYSTEMD;
            default:
                return null;
        }
    }
}
