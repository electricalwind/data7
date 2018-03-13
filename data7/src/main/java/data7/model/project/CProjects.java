package data7.model.project;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class CProjects {

    public static final Project LINUX_KERNEL = new Project(
            "linux_kernel",
            "https://github.com/torvalds/linux",
            ".*?(github\\.com|git\\.kernel\\.org).*?(commit)+.*?(h\\=|/)+([a-f0-9]+)",
            4,
            ".*(bugzilla\\.kernel\\.org).*?(id\\=)([0-9]+)",
            3,
            "https://bugzilla.kernel.org/",
            ".*(bugzilla\\.kernel\\.org).*?(id\\=)([0-9]+)",
            3
    );


    public static final Project OPEN_SSL = new Project(
            "openssl",
            "https://github.com/openssl/openssl",
            ".*?(git\\.openssl\\.org).*?(commit).*?(h\\=)([a-f0-9]+)",
            4,
            "fix",
            0,
            "https://github.com/openssl/openssl/issues/",
            ".*?(\\/github\\.com\\/openssl\\/openssl\\/issues\\/)([0-9]+)",
            2
    );

    public static final Project WIRESHARK = new Project(
            "wireshark",
            "https://github.com/wireshark/wireshark",
            ".*?(github\\.com|code\\.wireshark\\.org).*?(wireshark/commit/|a=commit;h\\=)([a-f0-9]+)",
            3,
            ".*?Bug: ([0-9]+)",
            1,
            "https://bugs.wireshark.org/bugzilla/",
            ".*(bugs\\.wireshark\\.org).*?(id\\=)([0-9]+)",
            3
    );

    public static final Project SYSTEMD = new Project(
            "systemd",
            "https://github.com/systemd/systemd",
            ".*?(github\\.com).*?(commit)+.*?(/)+([a-f0-9]+)",
            4,
            ".*?(\\(#)([0-9]+)",
            2,
            "https://github.com/systemd/systemd/issues",
            ".*?(\\/github\\.com\\/systemd\\/systemd\\/issues\\/)([0-9]+)",
            2
    );

    public static final TreeMap<Long, String> LINUX_VERSIONS() {
        TreeMap<Long, String> versions = new TreeMap<>();
        versions.put(1119005309L, "v2.6.12");
        versions.put(1125240148L, "v2.6.13");
        versions.put(1130425353L, "v2.6.14");
        versions.put(1136226087L, "v2.6.15");
        versions.put(1142801623L, "v2.6.16");
        versions.put(1150562984L, "v2.6.17");
        versions.put(1158691335L, "v2.6.18");
        versions.put(1164805065L, "v2.6.19");
        versions.put(1170582305L, "v2.6.20");
        versions.put(1177524520L, "v2.6.21");
        versions.put(1183905146L, "v2.6.22");
        versions.put(1191929512L, "v2.6.23");
        versions.put(1201183133L, "v2.6.24");
        versions.put(1208368197L, "v2.6.25");
        versions.put(1215953498L, "v2.6.26");
        versions.put(1223558041L, "v2.6.27");
        versions.put(1230128818L, "v2.6.28");
        versions.put(1237821147L, "v2.6.29");
        versions.put(1244570737L, "v2.6.30");
        versions.put(1252502047L, "v2.6.31");
        versions.put(1259779889L, "v2.6.32");
        versions.put(1267005144L, "v2.6.33");
        versions.put(1274012264L, "v2.6.34");
        versions.put(1280668283L, "v2.6.35");
        versions.put(1287574278L, "v2.6.36");
        versions.put(1294156226L, "v2.6.37");
        versions.put(1300123239L, "v2.6.38");
        versions.put(1305745602L, "v2.6.39");
        versions.put(1311268649L, "v3.0");
        versions.put(1319440251L, "v3.1");
        versions.put(1325688950L, "v3.2");
        versions.put(1332083742L, "v3.3");
        versions.put(1337520565L, "v3.4");
        versions.put(1342871923L, "v3.5");
        versions.put(1349016490L, "v3.6");
        versions.put(1355164261L, "v3.7");
        versions.put(1361199545L, "v3.8");
        versions.put(1367163369L, "v3.9");
        versions.put(1372598022L, "v3.10");
        versions.put(1378122378L, "v3.11");
        versions.put(1383489719L, "v3.12");
        versions.put(1390153223L, "v3.13");
        versions.put(1396204823L, "v3.14");
        versions.put(1402219202L, "v3.15");
        versions.put(1407072325L, "v3.16");
        versions.put(1412504600L, "v3.17");
        versions.put(1417958473L, "v3.18");
        versions.put(1423418078L, "v3.19");
        versions.put(1428844383L, "v4.0");
        versions.put(1434917160L, "v4.1");
        versions.put(1440927257L, "v4.2");
        versions.put(1446390339L, "v4.3");
        versions.put(1452434514L, "v4.4");
        versions.put(1457900945L, "v4.5");
        versions.put(1463319803L, "v4.6");
        versions.put(1469355842L, "v4.7");
        versions.put(1475418280L, "v4.8");
        versions.put(1481451482L, "v4.9");
        versions.put(1487511248L, "v4.10");
        versions.put(1493574480L, "v4.11");
        versions.put(1499004431L, "v4.12");
        versions.put(1504439788L, "v4.13");
        versions.put(1510479981L, "v4.14");
        versions.put(1517142041L, "v4.15");
        return versions;
    }




}
