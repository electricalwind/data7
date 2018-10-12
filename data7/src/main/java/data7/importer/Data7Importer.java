package data7.importer;

import data7.Data7UpdateListener;
import data7.Exporter;
import data7.ResourcesPath;
import data7.importer.sources.cve.CVE;
import data7.importer.sources.cve.CVEAnalysis;
import data7.importer.sources.cve.CVEParser;
import data7.importer.sources.git.GitAnalysis;
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

    // Ressource Path
    private final ResourcesPath path;
    // Project Information
    private final Project project;
    // Listeners
    private final Data7UpdateListener[] listeners;
    // Source of Informations
    private final LinkedList<Data7Source> sources;

    /**
     * Constructor of the importer
     * @param path to use
     * @param project considered
     * @param listeners to apply
     */
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
        sources.add(new GitAnalysis());

    }

    /**
     * Add a source of information
     * @param source
     */
    public void addSource(Data7Source source) {
        if (!source.sourceName().equals(CVEAnalysis.NAME) && !source.sourceName().equals(GitAnalysis.NAME)) {
            sources.add(sources.size()-1,source);
        }
    }

    /**
     * @return the list of All additional sources
     */
    public List<String> getAdditionalSources() {
        return sources.stream().map(Data7Source::sourceName).collect(Collectors.toList());
    }

    /**
     *
     * @return
     * @throws ParseException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public Data7 updateOrCreateDataset() throws ParseException, IOException, ClassNotFoundException {
        //Load Data7 object
        Data7 data7 = loadDataset();
        List<String> pathOfXMLFiles;
        //if no existing dataset
        if (data7 == null) {
            //download all cves feed
            pathOfXMLFiles = downloadAllXML();
            data7 = new Data7(project);
        } else {
            //download only necessary feed
            long currentTime = System.currentTimeMillis();
            pathOfXMLFiles = dowloadRecentXML(data7.getVulnerabilitySet().getLastUpdated(), currentTime);
            data7.getVulnerabilitySet().setLastUpdated(currentTime);
        }
        //parse the feed
        List<CVE> cves = listOfNewCVE(pathOfXMLFiles);

        //clone the git
        Map<String, GitActions> git = new HashMap<>();
        data7.getProject().getSubProjects().forEach((component, metainf) -> {
            git.put(component, new GitActions(metainf.getOnlineRepository(), path.getGitPath() + component));
        });

        //Source To proceed with
        LinkedList<Data7Source> listOfSources = new LinkedList<>();
        //Mandatory
        listOfSources.add(new CVEAnalysis(cves));
        //Optional ones except git analysis
        listOfSources.addAll(sources);

        //Lambda ...
        Data7 finalData = data7;

        //Setting up each source and proceed with the analysis
        listOfSources.forEach((source) -> {
            source.setDataset(finalData);
            source.setListeners(listeners);
            source.setGitmap(git);
            source.process();
        });

        //Exporting the result
        Exporter exporter = new Exporter(path);
        exporter.saveDataset(data7);
        git.values().forEach(GitActions::close);
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
     * Method that download only required files, if less than 7 days since last update then only modified and recent feed
     * are downloaded, otherwise the last update of each year feed is checked against the last update of the dataset
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
     * Check the last update of a year feed against the last update of the dataset
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
     * Download the feed for a given year
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
     * Retrieve the list of cve from all considered feed
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
