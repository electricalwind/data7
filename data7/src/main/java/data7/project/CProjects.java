package data7.project;

/*-
 * #%L
 * Data7
 * %%
 * Copyright (C) 2018 University of Luxembourg, Matthieu Jimenez
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */



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

    public static final TreeMap<Long, String> SYSTEMD_VERSION() {
        TreeMap<Long, String> versions = new TreeMap<>();
        versions.put(1278453600L, "v1");
        versions.put(1284415200L, "v10");
        versions.put(1299538800L, "v20");
        versions.put(1310508000L, "v30");
        versions.put(1328569200L, "v40");
        versions.put(1348092000L, "v190");
        versions.put(1364511600L, "v200");
        versions.put(1393196400L, "v210");
        versions.put(1432159200L, "v220");
        versions.put(1463868000L, "v230");
        versions.put(1507240800L, "v235");
        return versions;
    }


    public static final TreeMap<Long, String> WIRESHARK_VERSION() {
        TreeMap<Long, String> versions = new TreeMap<>();
        versions.put(905909955L, "ethereal-0.3.15");
        versions.put(911433534L, "ethereal-0.5.0");
        versions.put(925500716L, "ethereal-0.6.0");
        versions.put(933717600L, "ethereal-0.7.0");
        versions.put(946508400L, "ethereal-0.8.0");
        versions.put(1009148400L, "ethereal-0.9.0");
        versions.put(1071270000L, "ethereal-0.10.0");
        versions.put(1145829600L, "ethereal-0.99.0");
        versions.put(1206745200L, "wireshark-1.0.0");
        versions.put(1245103200L, "wireshark-1.2.0");
        versions.put(1283119200L, "wireshark-1.4.0");
        versions.put(1307397600L, "wireshark-1.6.0");
        versions.put(1340229600L, "wireshark-1.8.0");
        versions.put(1370383200L, "wireshark-1.10.0");
        versions.put(1392159600L, "v1.11.0");
        versions.put(1406757600L, "v1.12.0");
        versions.put(1412632800L, "v1.99.0");
        versions.put(1447801200L, "v2.0.0");
        versions.put(1465336800L, "v2.1.0");
        versions.put(1473199200L, "v2.2.0");
        versions.put(1500415200L, "v2.4.0");
        versions.put(1517871600L, "v2.5.0");

        return versions;
    }

    public static final TreeMap<Long, String> OPENSSL_VERSION() {
        TreeMap<Long, String> versions = new TreeMap<>();
        versions.put(927496800L, "OpenSSL_0_9_3");
        versions.put(934149600L, "OpenSSL_0_9_4");
        versions.put(959205600L, "OpenSSL_0_9_5");
        versions.put(971128800L, "OpenSSL_0_9_6");
        versions.put(1041289200L, "OpenSSL_0_9_7");
        versions.put(1120514400L, "OpenSSL_0_9_8");
        versions.put(1269813600L, "OpenSSL_1_0_0");
        versions.put(1331679600L, "OpenSSL_1_0_1");
        versions.put(1421881200L, "OpenSSL_1_0_2");
        versions.put(1472076000L, "OpenSSL_1_1_0");
        return versions;
    }
}
