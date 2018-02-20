package data7.importer.cve;

import data7.Exporter;
import data7.importer.cve.processing.cve.CVE;
import data7.importer.cve.processing.cve.CVEAnalysis;
import data7.importer.cve.processing.cve.CVEParser;
import data7.importer.cve.processing.git.GitAnalysis;
import data7.model.Data7;
import data7.model.project.Project;
import gitUtilitaries.GitActions;
import miscUtils.Misc;

import java.io.*;
import java.nio.file.Files;
import java.text.ParseException;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import static data7.Resources.*;
import static data7.Utils.dateToLong;


public class CVEImporter {

    private static Data7 loadDataset(File data7File) throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream(data7File);
        ObjectInputStream read = new ObjectInputStream(fileIn);
        Data7 data = (Data7) read.readObject();
        read.close();
        fileIn.close();
        return data;
    }


    public static Data7 createDataset(Project project, DatasetUpdateListener[] listeners) throws IOException {
        List<String> pathOfXMLFiles = downloadAllXML();
        Data7 data7 = new Data7(project);
        return updatingDataset(data7, pathOfXMLFiles, listeners);
    }

    public static Data7 updateDataset(File data7File, DatasetUpdateListener[] listeners) throws IOException, ClassNotFoundException, ParseException {
        Data7 data7 = loadDataset(data7File);
        long currentTime = System.currentTimeMillis();
        List<String> pathOfXMLFiles = dowloadRecentXML(data7.getVulnerabilitySet().getLastUpdated(), currentTime);
        data7.getVulnerabilitySet().setLastUpdated(currentTime);
        return updatingDataset(data7, pathOfXMLFiles, listeners);
    }


    private static List<String> downloadAllXML() throws IOException {
        List<String> pathOfXMLFiles = new ArrayList<>();
        for (int i = 2002; i <= Year.now().getValue(); i++) {
            String year = String.valueOf(i);
            pathOfXMLFiles.add(downloadCVEXML(year));
        }
        return pathOfXMLFiles;
    }

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

    private static boolean checkMetaIfNewerThan(String year, long lastUpdate) throws IOException, ParseException {
        Misc.downloadFromURL(CVE_URL + year + META, PATH_TO_CVE);
        File meta = new File(PATH_TO_CVE + FILE_START + year + META);
        BufferedReader brTest = new BufferedReader(new FileReader(meta));
        String date = brTest.readLine();
        date = date.replace("lastModifiedDate:", "");
        long newUpdate = dateToLong(date);
        Files.delete(meta.toPath());
        return newUpdate > lastUpdate;
    }

    private static String downloadCVEXML(String year) throws IOException {
        Misc.downloadFromURL(CVE_URL + year + XML, PATH_TO_CVE);
        String path = PATH_TO_CVE + FILE_START + year + XML;
        File zip = new File(path);
        Misc.unzipping(path, PATH_TO_CVE);
        Files.delete(zip.toPath());
        return path.replace(".zip", "");
    }

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


    private static void updateFinishedEvent(DatasetUpdateListener[] listeners) {
        for (DatasetUpdateListener listener : listeners) {
            listener.updatefinished();
        }
    }

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


/**    public static void main(String[] args) throws IOException{
 long time = System.currentTimeMillis();
 System.out.println("Start Linux");
 Data7 data7 = createDataset(CProjects.LINUX_KERNEL);
 Exporter.toXml(data7.getVulnerabilitySet());
 Exporter.toBinary(data7);
 System.out.println("End Linux : "+ (System.currentTimeMillis() - time));
 time = System.currentTimeMillis();
 System.out.println("Start Wireshark");
 data7 = createDataset(CProjects.WIRESHARK);
 Exporter.toXml(data7.getVulnerabilitySet());
 Exporter.toBinary(data7);
 System.out.println("End Wireshark : "+ (System.currentTimeMillis() - time));
 time = System.currentTimeMillis();
 System.out.println("Start SSL");
 data7 = createDataset(CProjects.OPEN_SSL);
 Exporter.toXml(data7.getVulnerabilitySet());
 Exporter.toBinary(data7);
 System.out.println("End SSL : "+ (System.currentTimeMillis() - time));
 time = System.currentTimeMillis();
 System.out.println("Start SystemD");
 data7 = createDataset(CProjects.SYSTEMD);
 Exporter.toXml(data7.getVulnerabilitySet());
 Exporter.toBinary(data7);
 System.out.println("End SystemD : "+ (System.currentTimeMillis() - time));
 }*/


}
