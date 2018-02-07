package cve;

import cve.model.Data7;
import cve.parser.CVE;
import cve.parser.CVEParser;
import cve.processing.CVEProcessor;
import cve.processing.GitProcessor;
import cve.projects.CProjects;
import cve.projects.Project;
import miscUtils.Misc;
import org.eclipse.jgit.api.errors.GitAPIException;

import javax.xml.stream.XMLStreamException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.text.ParseException;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import static cve.Resources.*;
import static cve.Utils.dateToLong;

public class Importer {

    public static Data7 createDataset(Project project) throws IOException, XMLStreamException, ParseException, GitAPIException {
        List<String> pathOfXMLFiles = new ArrayList<>();
        for (int i = 2002; i <= Year.now().getValue(); i++) {
            String year = String.valueOf(i);
            pathOfXMLFiles.add(downloadCVEXML(year));
        }
        Data7 dataset = new Data7(project);
        return updateDataset(dataset, pathOfXMLFiles);
    }

    public static Data7 updateDataset(Data7 dataset) throws IOException, ParseException, XMLStreamException, GitAPIException {
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

    private static Data7 updateDataset(Data7 dataset, List<String> pathOfXMLFiles) throws IOException, XMLStreamException, ParseException, GitAPIException {
        List<CVE> cves = new ArrayList<>();
        for (String xml : pathOfXMLFiles) {
            cves.addAll(CVEParser.XMLparse(dataset.getProject(), xml));
        }
        CVEProcessor cvep = new CVEProcessor(cves, dataset);
        cvep.process();
        GitProcessor gitp = new GitProcessor(dataset);
        gitp.process();
        return dataset;

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


    public static void main(String[] args) throws IOException, XMLStreamException, ParseException, GitAPIException {
        Data7 data7 = createDataset(CProjects.LINUX_KERNEL);
        int i = 0;
    }


}
