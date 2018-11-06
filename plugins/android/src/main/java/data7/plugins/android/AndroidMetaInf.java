package data7.plugins.android;

import data7.project.MetaInformation;

import java.util.HashMap;
import java.util.Map;

public class AndroidMetaInf {
    public static final String ANDROID_NVD = "android";


    public static final Map<String, MetaInformation> getAndroid() {
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
        }; //Todo to complete

        Map<String,MetaInformation> projects = new HashMap<>();
        for (String aRepo : repo) {
            projects.put(aRepo, new MetaInformation(
                    "https://android.googlesource.com/" + aRepo,
                    ".*?(android\\.googlesource\\.com/" + aRepo + ").*?(\\+/)([a-f0-9]+)",
                    3,
                    ".*?[Bb]ug[ a-zA-Z]*:[ ]*([0-9]+)",
                    1,
                    "https://issuetracker.google.com/",
                    ".*(issuetracker\\.google\\.com).*?(issues\\/)([0-9]+)",
                    3
            ));
        }
        return projects;

    }

}
