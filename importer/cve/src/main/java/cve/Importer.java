package cve;

import cve.model.Data7;
import cve.processing.cve.CVE;
import cve.processing.cve.CVEAnalysis;
import cve.processing.cve.CVEParser;
import cve.processing.git.GitProcessor;
import cve.projects.CProjects;
import cve.projects.Project;
import miscUtils.Misc;

import java.io.*;
import java.nio.file.Files;
import java.text.ParseException;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import static cve.Resources.*;
import static cve.Utils.dateToLong;

public class Importer {

    /**
     * Method to load a previously saved dataset
     *
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static Data7 loadBinary() throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream(PATH_TO_BINARY + "data7.obj");
        ObjectInputStream read = new ObjectInputStream(fileIn);
        Data7 data = (Data7) read.readObject();
        read.close();
        fileIn.close();
        return data;
    }


    public static Data7 createDataset(Project project) throws IOException {
        List<String> pathOfXMLFiles = new ArrayList<>();
        for (int i = 2002; i <= Year.now().getValue(); i++) {
            String year = String.valueOf(i);
            pathOfXMLFiles.add(downloadCVEXML(year));
            //pathOfXMLFiles.add(PATH_TO_CVE + FILE_START + year + ".xml");
        }

        Data7 dataset = new Data7(project);
        return updateDataset(dataset, pathOfXMLFiles);
    }

    public static Data7 updateDataset(Data7 dataset) throws IOException, ParseException {
        List<String> pathOfXMLFiles = new ArrayList<>();
        if (System.currentTimeMillis() - dataset.getVulnerabilitySet().getLastUpdated() < 691200000) {
            pathOfXMLFiles.add(downloadCVEXML("modified"));
            pathOfXMLFiles.add(downloadCVEXML("recent"));
        } else {
            for (int i = 2002; i <= Year.now().getValue(); i++) {
                String year = String.valueOf(i);
                if (checkMetaIfNewerThan(year, dataset.getVulnerabilitySet().getLastUpdated())) {
                    pathOfXMLFiles.add(downloadCVEXML(year));
                }
            }
        }
        return updateDataset(dataset, pathOfXMLFiles);
    }

    private static Data7 updateDataset(Data7 dataset, List<String> pathOfXMLFiles) {
        List<CVE> cves = listOfNewCVE(dataset.getProject(), pathOfXMLFiles);
        CVEAnalysis cvep = new CVEAnalysis(cves, dataset);
        cvep.process();
        GitProcessor gitp = new GitProcessor(dataset);
        gitp.process();
        return dataset;

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


    public static void main(String[] args) throws IOException{
        Data7 data7 = createDataset(CProjects.LINUX_KERNEL);
        Exporter.toXml(data7.getVulnerabilitySet());
        Exporter.toBinary(data7);
        data7 = createDataset(CProjects.WIRESHARK);
        Exporter.toXml(data7.getVulnerabilitySet());
        Exporter.toBinary(data7);
        data7 = createDataset(CProjects.OPEN_SSL);
        Exporter.toXml(data7.getVulnerabilitySet());
        Exporter.toBinary(data7);
        data7 = createDataset(CProjects.SYSTEMD);
        Exporter.toXml(data7.getVulnerabilitySet());
        Exporter.toBinary(data7);
    }


}
