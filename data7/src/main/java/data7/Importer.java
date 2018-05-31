package data7;

import data7.importer.cve.CVEImporter;
import data7.importer.cve.DatasetUpdateListener;
import data7.model.CWE;
import data7.model.Data7;
import data7.project.CProjects;
import data7.project.Project;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import static data7.Resources.*;
import static data7.importer.cwe.CWEImporter.loadCWEFromBinary;
import static data7.importer.cwe.CWEImporter.retrieveCWEOnline;

public class Importer {

    /**
     * Function to retrieve the list of CWE either from a previous import or from internet
     * @return List of CWE
     * @throws IOException
     * @throws JAXBException
     * @throws ClassNotFoundException
     */
    public static List<CWE> getListOfCWE() throws IOException, JAXBException, ClassNotFoundException {
        File cweBinary = new File(PATH_TO_BINARY + CWE_OBJ);
        if (cweBinary.exists()) {
            return loadCWEFromBinary(cweBinary);
        } else {
            return retrieveCWEOnline();
        }
    }

    /**
     * Function to create or update a data7 for a given project
     * @param project to update or create the dataset from
     * @param listeners for additional access to the dataset
     * @return Data7 that was retrieved
     * @throws ParseException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static Data7 updateOrCreateDatasetFor(Project project, DatasetUpdateListener... listeners) throws ParseException, IOException, ClassNotFoundException {
        if (project != null) {
            File data7Binary = new File(PATH_TO_BINARY + project.getName() + DATA7_OBJ);
            if (data7Binary.exists()) {
                return CVEImporter.updateDataset(project.getName(), listeners);
            } else {
                return CVEImporter.createDataset(project, listeners);
            }
        } else {
            throw new RuntimeException("Project is null");
        }
    }

    /**
     * Main to generate the dataset
     * @param args
     * @throws ParseException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void main(String[] args) throws ParseException, IOException, ClassNotFoundException {
        Exporter.saveDataset(updateOrCreateDatasetFor(CProjects.LINUX_KERNEL));
        Exporter.saveDataset(updateOrCreateDatasetFor(CProjects.OPEN_SSL));
        Exporter.saveDataset(updateOrCreateDatasetFor(CProjects.WIRESHARK));
        Exporter.saveDataset(updateOrCreateDatasetFor(CProjects.SYSTEMD));
    }

}
