package data7.importer;

import data7.Data7UpdateListener;
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
import java.util.stream.Collectors;

import static data7.Resources.*;
import static data7.Resources.FILE_START;
import static data7.Resources.XML;
import static data7.Utils.checkFolderDestination;
import static data7.Utils.dateToLongWoM;

public class Data7Importer {

    private final ResourcesPath path;
    private final Project project;
    private final Data7UpdateListener[] listeners;
    private final LinkedList<Data7Source> sources;

    public Data7Importer(ResourcesPath path, Project project, Data7UpdateListener... listeners) {
        this.path = path;
        if (project != null) {
            this.project = project;
        } else {
            throw new RuntimeException("Project is null");
        }
        if (listeners == null) {
            this.listeners = new Data7UpdateListener[0];
        } else {
            this.listeners = listeners;
        }
        sources = new LinkedList<>();
    }

    public void addSource(Data7Source source, int position) {
        if (!source.sourceName().equals(CVEAnalysis.NAME) && !source.sourceName().equals(GitAnalysis.NAME) && position > 0 && position < sources.size()) {
            sources.add(source);
        }
    }

    public void addSource(Data7Source source) {
        if (!source.sourceName().equals(CVEAnalysis.NAME) && !source.sourceName().equals(GitAnalysis.NAME)) {
            sources.add(source);
        }
    }

    public List<String> getSources() {
        return sources.stream().map(Data7Source::sourceName).collect(Collectors.toList());
    }

    public Data7 updateOrCreateDataset() throws ParseException, IOException, ClassNotFoundException {
        Data7 data7 = loadDataset();
        List<String> pathOfXMLFiles;
        if (data7 == null) {
            pathOfXMLFiles = downloadAllXML();
            data7 = new Data7(project);
        } else {
            long currentTime = System.currentTimeMillis();
            pathOfXMLFiles = dowloadRecentXML(data7.getVulnerabilitySet().getLastUpdated(), currentTime);
            data7.getVulnerabilitySet().setLastUpdated(currentTime);
        }
        List<CVE> cves = listOfNewCVE(pathOfXMLFiles);
        Map<String, GitActions> git = new HashMap<>();
        data7.getProject().getSubProjects().forEach((component, metainf) -> {
            git.put(component, new GitActions(metainf.getOnlineRepository(), path.getGitPath() + component));
        });

        sources.addFirst(new CVEAnalysis(cves));
        sources.addLast(new GitAnalysis());

        Data7 finalData = data7;

        sources.forEach((source) -> {
            source.setDataset(finalData);
            source.setListeners(listeners);
            source.setGitmap(git);
            source.process();
        });

        Exporter exporter = new Exporter(path);
        exporter.saveDataset(data7);
        return finalData;
    }

    /**
     * Method that will download all cve xml files
     *
     * @return
     * @throws IOException
     */
    private List<String> downloadAllXML() throws IOException {
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
    private List<String> dowloadRecentXML(long lastUpdated, long currentTime) throws IOException, ParseException {
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
    private boolean checkMetaIfNewerThan(String year, long lastUpdate) throws IOException, ParseException {
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
    private String downloadCVEXML(String year) throws IOException {
        checkFolderDestination(path.getCvePath());
        Misc.downloadFromURL(CVE_URL + year + XML, path.getCvePath());
        String fpath = path.getCvePath() + FILE_START + year + XML;
        File zip = new File(fpath);
        Misc.unzipping(fpath, path.getCvePath());
        Files.delete(zip.toPath());
        return fpath.replace(".zip", "");
    }

    /**
     * @param pathOfXMLFiles
     * @return
     */
    private List<CVE> listOfNewCVE(List<String> pathOfXMLFiles) {
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
     * Method to load the data7 of a given project that have been save in its binary form
     *
     * @return Data7
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public Data7 loadDataset() throws IOException, ClassNotFoundException {
        File file = new File(path.getBinaryPath() + project + "-data7.obj");
        if (file.exists()) {
            FileInputStream fileIn = new FileInputStream(file);
            ObjectInputStream read = new ObjectInputStream(fileIn);
            Data7 data = (Data7) read.readObject();
            read.close();
            fileIn.close();
            return data;
        } else {
            return null;
        }
    }

}
