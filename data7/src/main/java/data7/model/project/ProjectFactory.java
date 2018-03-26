package data7.model.project;

import java.util.TreeMap;

import static data7.model.project.CProjects.*;

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


    public static TreeMap<Long, String> retrieveProjectRelease(String name) {
        switch (name) {
            case "linux_kernel":
                return LINUX_VERSIONS();
            case "openssl":
                return OPENSSL_VERSION();
            case "wireshark":
                return WIRESHARK_VERSION();
            case "Systemd":
                return SYSTEMD_VERSION();
            default:
                return null;
        }
    }
}
