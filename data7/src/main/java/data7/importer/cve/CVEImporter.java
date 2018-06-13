package data7.importer.cve;

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


import data7.Exporter;
import data7.ResourcesPath;
import data7.importer.cve.processing.cve.CVE;
import data7.importer.cve.processing.cve.CVEAnalysis;
import data7.importer.cve.processing.cve.CVEParser;
import data7.importer.cve.processing.git.GitAnalysis;
import data7.model.Data7;

import data7.project.Project;
import gitUtilitaries.GitActions;
import miscUtils.Misc;

import java.io.*;
import java.nio.file.Files;
import java.text.ParseException;
import java.time.Year;
import java.util.*;
import java.util.concurrent.*;



import static data7.Resources.*;

import static data7.Utils.dateToLongWoM;

/**
 * Class use to import the dataset
 */
public class CVEImporter {

    private final ResourcesPath path;
    private final Exporter exporter;

    public CVEImporter(ResourcesPath path){
        this.path = path;
        this.exporter = new Exporter(path);
    }

    /**
     * Method to create a data7 for a given project
     *
     * @param project   to create the dataset for
     * @param listeners in case of connectors to feed a database
     * @return data7 object
     * @throws IOException
     */
    public  Data7 createDataset(Project project, DatasetUpdateListener[] listeners) throws IOException {
        List<String> pathOfXMLFiles = downloadAllXML();
        Data7 data7 = new Data7(project);
        return updatingDataset(data7, pathOfXMLFiles, listeners);
    }

    /**
     * Method to load and update a data7
     *
     * @param project   to update the dataset for
     * @param listeners in case of connector to feed a database
     * @return data7 object
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws ParseException
     */
    public  Data7 updateDataset(String project, DatasetUpdateListener[] listeners) throws IOException, ClassNotFoundException, ParseException {
        Data7 data7 = exporter.loadDataset(project);
        long currentTime = System.currentTimeMillis();
        List<String> pathOfXMLFiles = dowloadRecentXML(data7.getVulnerabilitySet().getLastUpdated(), currentTime);
        data7.getVulnerabilitySet().setLastUpdated(currentTime);
        return updatingDataset(data7, pathOfXMLFiles, listeners);
    }


    /**
     * Method that will download all cve xml files
     *
     * @return
     * @throws IOException
     */
    private  List<String> downloadAllXML() throws IOException {
        List<String> pathOfXMLFiles = new ArrayList<>();
        for (int i = 2002; i <= Year.now().getValue(); i++) {
            String year = String.valueOf(i);
            pathOfXMLFiles.add(downloadCVEXML(year));
        }
        return pathOfXMLFiles;
    }

    /**
     * @param lastUpdated
     * @param currentTime
     * @return
     * @throws IOException
     * @throws ParseException
     */
    private  List<String> dowloadRecentXML(long lastUpdated, long currentTime) throws IOException, ParseException {
        List<String> pathOfXMLFiles = new ArrayList<>();
        if (currentTime - lastUpdated < 691200000) {
            pathOfXMLFiles.add(downloadCVEXML("modified"));
            pathOfXMLFiles.add(downloadCVEXML("recent"));
        } else {
            for (int i = 2002; i <= Year.now().getValue(); i++) {
                String year = String.valueOf(i);
                if (checkMetaIfNewerThan(year, lastUpdated)) {
                    pathOfXMLFiles.add(downloadCVEXML(year));
                }
            }
        }
        return pathOfXMLFiles;
    }

    /**
     * @param year
     * @param lastUpdate
     * @return
     * @throws IOException
     * @throws ParseException
     */
    private  boolean checkMetaIfNewerThan(String year, long lastUpdate) throws IOException, ParseException {
        Misc.downloadFromURL(CVE_URL + year + META, path.getCvePath());
        File meta = new File(path.getCvePath() + FILE_START + year + META);
        BufferedReader brTest = new BufferedReader(new FileReader(meta));
        String date = brTest.readLine();
        date = date.replace("lastModifiedDate:", "");
        long newUpdate = dateToLongWoM(date);
        Files.delete(meta.toPath());
        return newUpdate > lastUpdate;
    }

    /**
     * @param year
     * @return
     * @throws IOException
     */
    private  String downloadCVEXML(String year) throws IOException {
        Misc.downloadFromURL(CVE_URL + year + XML, path.getCvePath());
        String fpath = path.getCvePath() + FILE_START + year + XML;
        File zip = new File(fpath);
        Misc.unzipping(fpath, path.getCvePath());
        Files.delete(zip.toPath());
        return fpath.replace(".zip", "");
    }

    /**
     * @param data7
     * @param pathOfXMLFiles
     * @param listeners
     * @return
     * @throws IOException
     */
    private  Data7 updatingDataset(Data7 data7, List<String> pathOfXMLFiles, DatasetUpdateListener[] listeners) throws IOException {
        List<CVE> cves = listOfNewCVE(data7.getProject(), pathOfXMLFiles);
        GitActions git = new GitActions(data7.getProject().getOnlineRepository(), path.getGitPath() + data7.getVulnerabilitySet().getProjectName());
        CVEAnalysis.proceedWithAnalysis(cves, data7, listeners, git);
        GitAnalysis.proceedWithAnalysis(data7, listeners, git);
        git.close();
        updateFinishedEvent(listeners);
        exporter.saveDataset(data7);
        return data7;
    }

    /**
     * @param listeners
     */
    private  void updateFinishedEvent(DatasetUpdateListener[] listeners) {
        if (listeners != null) {
            for (DatasetUpdateListener listener : listeners) {
                listener.updatefinished();
            }
        }
    }

    /**
     * @param project
     * @param pathOfXMLFiles
     * @return
     */
    private  List<CVE> listOfNewCVE(Project project, List<String> pathOfXMLFiles) {
        ExecutorService executor = Executors.newFixedThreadPool(NB_THREADS);
        int errornb = 0;
        List<CVE> cves = new ArrayList<>();
        try {
            CompletionService<List<CVE>> completionService = new ExecutorCompletionService(executor);
            int count = 0;
            for (String xml : pathOfXMLFiles) {
                completionService.submit(new CVEParser(project, xml));
                count++;
            }
            int received = 0;
            while (received < count) {
                Future<List<CVE>> fut = completionService.take();
                try {
                    List<CVE> result = fut.get();
                    if (result != null) {
                        cves.addAll(result);
                    }
                } catch (ExecutionException e) {
                    e.printStackTrace();
                    errornb++;
                } finally {
                    received++;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.err.println("error : " + errornb);
            executor.shutdown();
            return cves;
        }
    }

    /**
     * @param args
     * @throws IOException
     * @throws ClassNotFoundException
     */

    /**public static void main(String[] args) throws IOException, ClassNotFoundException {
        Data7 data7 = loadDataset(CProjects.SYSTEMD.getName());
        int novf = 0;
        float cvssSum = 0;
        float cvssSumf = 0;
        final int[] filefixes = {0};
        Set<String> commits = new HashSet<>();
        Map<String, Integer> cwes = new HashMap<>();
        Map<String, Integer> cwesf = new HashMap<>();
        Map<String, Integer> files = new HashMap<>();
        for (Map.Entry<String, Vulnerability> vuln : data7.getVulnerabilitySet().getVulnerabilityDataset().entrySet()) {
            float cvss = Float.parseFloat(vuln.getValue().getScore());
            String cwe = vuln.getValue().getCwe();
            if (cwe != null) {
                cwes.merge(cwe, 1, Integer::sum);
            }
            cvssSum += cvss;

            if (vuln.getValue().getPatchingCommits().size() > 0) {
                if (cwe != null) {
                    cwesf.merge(cwe, 1, Integer::sum);
                }
                novf++;
                cvssSumf += cvss;
                for (Map.Entry<String, Commit> comm : vuln.getValue().getPatchingCommits().entrySet()) {
                    if (commits.add(comm.getKey())) {
                        comm.getValue().getFixes().forEach(fileFix -> {
                                    files.merge(fileFix.getFileAfter().getFilePath(), 1, Integer::sum);
                                    filefixes[0]++;
                                }
                        );
                    }

                }

            }
        }

        cvssSum /= data7.getVulnerabilitySet().getVulnerabilityDataset().size();
        cvssSumf /= novf;


        Map<String, Integer> topTencwes =
                cwes.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .limit(20)
                        .collect(Collectors.toMap(
                                Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));


        Map<String, Integer> topTencwesf =
                cwesf.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .limit(20)
                        .collect(Collectors.toMap(
                                Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        topTencwesf.entrySet().stream().forEach(
                stringIntegerEntry -> {
                    System.out.println("cwe: " + stringIntegerEntry.getKey() + " -> " + stringIntegerEntry.getValue().floatValue() / cwes.get(stringIntegerEntry.getKey()).floatValue());
                }
        );

        Map<String, Integer> topTenfiles =
                files.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .limit(12)
                        .collect(Collectors.toMap(
                                Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        int i = 0;
    }

    /**public static void main(String[] args) throws IOException {
     long time = System.currentTimeMillis();
     System.out.println("Start Linux");
     //createDataset(CProjects.LINUX_KERNEL, null);
     //Exporter.exportDatasetToXML(data7);
     //Exporter.toBinary(data7);
     System.out.println("End Linux : " + (System.currentTimeMillis() - time));
     time = System.currentTimeMillis();
     System.out.println("Start Wireshark");
     createDataset(CProjects.WIRESHARK, null);
     //Exporter.toXml(data7.getVulnerabilitySet());
     //Exporter.toBinary(data7);
     System.out.println("End Wireshark : " + (System.currentTimeMillis() - time));
     time = System.currentTimeMillis();
     System.out.println("Start SSL");
     createDataset(CProjects.OPEN_SSL, null);
     //Exporter.toXml(data7.getVulnerabilitySet());
     //Exporter.toBinary(data7);
     System.out.println("End SSL : " + (System.currentTimeMillis() - time));
     time = System.currentTimeMillis();
     System.out.println("Start SystemD");
     createDataset(CProjects.SYSTEMD, null);
     //Exporter.toXml(data7.getVulnerabilitySet());
     //Exporter.toBinary(data7);
     System.out.println("End SystemD : " + (System.currentTimeMillis() - time));
     }*/


}
