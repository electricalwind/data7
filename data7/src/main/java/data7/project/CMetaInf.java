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


public class CMetaInf {

    public static final String LINUX_NVD = "linux_kernel";
    public static final String OPENSSL_NVD = "openssl";
    public static final String WIRESHARK_NVD = "wireshark";
    public static final String SYSTEMD_NVD = "systemd";


    public static final MetaInformation LINUX_KERNEL = new MetaInformation(
            "https://github.com/torvalds/linux",
            ".*?(github\\.com|git\\.kernel\\.org).*?(commit)+.*?(h\\=|/)+([a-f0-9]+)",
            4,
            ".*(bugzilla\\.kernel\\.org).*?(id\\=)([0-9]+)",
            3,
            "https://bugzilla.kernel.org/",
            ".*(bugzilla\\.kernel\\.org).*?(id\\=)([0-9]+)",
            3
    );


    public static final MetaInformation OPEN_SSL = new MetaInformation(
            "https://github.com/openssl/openssl",
            ".*?(git\\.openssl\\.org).*?(commit).*?(h\\=)([a-f0-9]+)",
            4,
            "fix",
            0,
            "https://github.com/openssl/openssl/issues/",
            ".*?(\\/github\\.com\\/openssl\\/openssl\\/issues\\/)([0-9]+)",
            2
    );

    public static final MetaInformation WIRESHARK = new MetaInformation(
            "https://github.com/wireshark/wireshark",
            ".*?(github\\.com|code\\.wireshark\\.org).*?(wireshark/commit/|a=commit;h\\=)([a-f0-9]+)",
            3,
            ".*?Bug: ([0-9]+)",
            1,
            "https://bugs.wireshark.org/bugzilla/",
            ".*(bugs\\.wireshark\\.org).*?(id\\=)([0-9]+)",
            3
    );

    public static final MetaInformation SYSTEMD = new MetaInformation(
            "https://github.com/systemd/systemd",
            ".*?(github\\.com).*?(commit)+.*?(/)+([a-f0-9]+)",
            4,
            ".*?(\\(#)([0-9]+)",
            2,
            "https://github.com/systemd/systemd/issues",
            ".*?(\\/github\\.com\\/systemd\\/systemd\\/issues\\/)([0-9]+)",
            2
    );


}
