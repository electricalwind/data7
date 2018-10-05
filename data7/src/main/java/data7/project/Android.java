package data7.project;



public class Android {


    public static final Project[] getAndroid() {
        String[] repo = new String[]{
                "kernel/arm64",
                "kernel/bcm",
                "kernel/build",
                "kernel/common",
                "kernel/configs",
                "kernel/exynos",
                "kernel/goldfish",
                "kernel/hikey-linaro",
                "kernel/lk",
                "kernel/manifest",
                "kernel/mediatek",
                "kernel/msm",
                "kernel/omap",
                "kernel/samsung",
                "kernel/tegra",
                "kernel/tests",
                "kernel/x86",
                "kernel/x86_64",
                };
        Project[] projects = new Project[repo.length];
        for (int i = 0; i < repo.length; i++) {
            projects[i] = new Project(
                    repo[i].replaceAll("/", "-"),
                    "android",
                    "https://android.googlesource.com/" + repo[i],
                    ".*?(android\\.googlesource\\.com/" + repo[i] + ").*?(\\+/)([a-f0-9]+)",
                    3,
                    ".*?[Bb]ug[ a-zA-Z]*:[ ]*([0-9]+)",
                    1,
                    "https://issuetracker.google.com/",
                    ".*(issuetracker\\.google\\.com).*?(issues\\/)([0-9]+)",
                    3
            );
        }
        return projects;

    }
}
