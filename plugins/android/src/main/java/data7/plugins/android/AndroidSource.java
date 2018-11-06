package data7.plugins.android;

import data7.importer.Data7Source;
import data7.model.change.Commit;
import data7.model.vulnerability.Vulnerability;
import data7.project.MetaInformation;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static data7.Utils.generateCommitOfInterest;

public class AndroidSource extends Data7Source {
    public static String NAME = "ANDROID ANALYSIS";


    private Map<String, Map<String, List<String>>> getCommitFromBulletin() {
        //TODO Tim
        return null;
    }

    @Override
    public void process() {
        addToData7(getCommitFromBulletin());
    }

    @Override
    public String sourceName() {
        return NAME;
    }

    //Utils Can be refactored

    private void addToData7(Map<String, Map<String, List<String>>> mapCveToComponentListHash) {
        mapCveToComponentListHash.forEach((cve, componenthashes) -> {
            Vulnerability vulnerability = dataset.getVulnerabilitySet().getVulnerabilityDataset().get(cve);
            if (vulnerability != null) {
                componenthashes.forEach((component, hashes) -> {
                    Map<String, Commit> componentFixes = vulnerability.getPatchingCommits().getOrDefault(component, new HashMap<>());
                    for(String hash:hashes){
                        if(!componentFixes.containsKey(hash)){
                            componentFixes.put(hash,addCommitOfInterest(vulnerability,hash,component));
                        }
                    }
                    vulnerability.getPatchingCommits().put(component,componentFixes);
                });
            }
        });
    }

    private Commit addCommitOfInterest(Vulnerability vulnerability, String hash, String component) {
        Commit commit = generateCommitOfInterest(gitmap.get(component), hash, true);
        if (commit != null) {
            String bugId = checkCommitForBugId(component, commit.getMessage());
            if (bugId != null) {
                Set<String> bid = vulnerability.getBugIds().getOrDefault(component, new HashSet<>());
                bid.add(bugId);
                vulnerability.getBugIds().put(component, bid);

                Map<String, List<String>> mapbtc = dataset.getBugToCve().getOrDefault(component, new HashMap<>());

                if (mapbtc.containsKey(bugId)) {
                    mapbtc.get(bugId).add(vulnerability.getCve());
                } else {
                    List<String> cve = new ArrayList<>();
                    cve.add(vulnerability.getCve());
                    mapbtc.put(bugId, cve);
                }
                dataset.getBugToCve().put(component, mapbtc);


                Map<String, List<String>> mapbth = dataset.getBugToHash().getOrDefault(component, new HashMap<>());

                if (mapbth.containsKey(bugId)) {
                    mapbth.get(bugId).add(hash);
                } else {
                    List<String> hashes = new ArrayList<>();
                    hashes.add(hash);
                    mapbth.put(bugId, hashes);
                }
            }
            commitAddedToVulnerabilityEvent(vulnerability, hash, component);
            return commit;
        }
        return null;
    }

    private String checkCommitForBugId(String component, String message) {
        MetaInformation project = dataset.getProject().getSubProjects().get(component);
        if (project.getIndexOfBugIdinCommitMessage() != 0) {
            Pattern pattern = Pattern.compile("[.|\\r|\\n]*" + project.getPatchInCommitessageRegexp());
            Matcher m = pattern.matcher(message);
            if (m.find()) {
                return m.group(project.getIndexOfBugIdinCommitMessage());
            }
        }
        return null;
    }
}
