package cve.projects;

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


}
