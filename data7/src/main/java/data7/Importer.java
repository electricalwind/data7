package data7;

import data7.importer.cve.CVEImporter;
import data7.importer.cve.DatasetUpdateListener;
import data7.model.CWE;
import data7.model.Data7;
import data7.model.project.CProjects;
import data7.model.project.Project;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import static data7.Resources.*;
import static data7.importer.cwe.CWEImporter.loadCWEFromBinary;
import static data7.importer.cwe.CWEImporter.retrieveCWEOnline;

public class Importer {

    public static List<CWE> getListOfCWE() throws IOException, JAXBException, ClassNotFoundException {
        File cweBinary = new File(PATH_TO_BINARY + CWE_OBJ);
        if (cweBinary.exists()) {
            return loadCWEFromBinary(cweBinary);
        } else {
            return retrieveCWEOnline();
        }
    }


    public static Data7 updateOrCreateDatasetFor(Project project, DatasetUpdateListener... listeners) throws ParseException, IOException, ClassNotFoundException {
        File data7Binary = new File(PATH_TO_BINARY + project.getName() + DATA7_OBJ);
        if (data7Binary.exists()) {
            return CVEImporter.updateDataset(data7Binary, listeners);
        } else {
            return CVEImporter.createDataset(project, listeners);
        }
    }

    public static void main(String[] args) throws ParseException, IOException, ClassNotFoundException {
        Exporter.saveDataset(updateOrCreateDatasetFor(CProjects.SYSTEMD));
    }

}
