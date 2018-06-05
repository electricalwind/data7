package data7.importer.cve;

import data7.Exporter;
import data7.importer.cve.processing.cve.CVE;
import data7.importer.cve.processing.cve.CVEAnalysis;
import data7.importer.cve.processing.cve.CVEParser;
import data7.importer.cve.processing.git.GitAnalysis;
import data7.model.Data7;

import data7.project.CProjects;
import data7.project.Project;
import gitUtilitaries.GitActions;
import miscUtils.Misc;

import java.io.*;
import java.nio.file.Files;
import java.text.ParseException;
import java.time.Year;
import java.util.*;
import java.util.concurrent.*;

import static data7.Exporter.loadDataset;
import static data7.Resources.*;

import static data7.Utils.dateToLongWoM;

/**
 * Class use to import the dataset
 */
public class CVEImporter {

    /**
     * Method to create a data7 for a given project
     *
     * @param project   to create the dataset for
     * @param listeners in case of connectors to feed a database
     * @return data7 object
     * @throws IOException
     */
    public static Data7 createDataset(Project project, DatasetUpdateListener[] listeners) throws IOException {
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
    public static Data7 updateDataset(String project, DatasetUpdateListener[] listeners) throws IOException, ClassNotFoundException, ParseException {
        Data7 data7 = loadDataset(project);
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
    private static List<String> downloadAllXML() throws IOException {
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
    private static List<String> dowloadRecentXML(long lastUpdated, long currentTime) throws IOException, ParseException {
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
    private static boolean checkMetaIfNewerThan(String year, long lastUpdate) throws IOException, ParseException {
        Misc.downloadFromURL(CVE_URL + year + META, PATH_TO_CVE);
        File meta = new File(PATH_TO_CVE + FILE_START + year + META);
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
    private static String downloadCVEXML(String year) throws IOException {
        Misc.downloadFromURL(CVE_URL + year + XML, PATH_TO_CVE);
        String path = PATH_TO_CVE + FILE_START + year + XML;
        File zip = new File(path);
        Misc.unzipping(path, PATH_TO_CVE);
        Files.delete(zip.toPath());
        return path.replace(".zip", "");
    }

    /**
     * @param data7
     * @param pathOfXMLFiles
     * @param listeners
     * @return
     * @throws IOException
     */
    private static Data7 updatingDataset(Data7 data7, List<String> pathOfXMLFiles, DatasetUpdateListener[] listeners) throws IOException {
        List<CVE> cves = listOfNewCVE(data7.getProject(), pathOfXMLFiles);
        GitActions git = new GitActions(data7.getProject().getOnlineRepository(), PATH_TO_GIT + data7.getVulnerabilitySet().getProjectName());
        CVEAnalysis.proceedWithAnalysis(cves, data7, listeners, git);
        GitAnalysis.proceedWithAnalysis(data7, listeners, git);
        git.close();
        updateFinishedEvent(listeners);
        Exporter.saveDataset(data7);
        return data7;
    }

    /**
     * @param listeners
     */
    private static void updateFinishedEvent(DatasetUpdateListener[] listeners) {
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
    private static List<CVE> listOfNewCVE(Project project, List<String> pathOfXMLFiles) {
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
     *
     * @param args
     * @throws IOException
     * @throws ClassNotFoundException
     */
    /**
     * public static void main(String[] args) throws IOException, ClassNotFoundException {
     * Data7 data7 = loadDataset(CProjects.OPEN_SSL.getName());
     * Set<String> files = new HashSet<>();
     * Set<Map.Entry<String, Commit>> k =data7
     * .getVulnerabilitySet()
     * .getVulnerabilityDataset()
     * .entrySet()
     * .stream()
     * .map(entry -> entry.getValue().getPatchingCommits().entrySet())
     * .flatMap(Collection::stream)
     * .collect(Collectors.toSet());
     * int i =0;
     * }
     */
    public static void main(String[] args) throws IOException {
        long time = System.currentTimeMillis();
        System.out.println("Start Linux");
        createDataset(CProjects.LINUX_KERNEL, null);
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
    }


}
