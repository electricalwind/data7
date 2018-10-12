package data7;

import data7.model.CWE;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static data7.Resources.CWE_OBJ;

public class CWEImporter {

    private final ResourcesPath path;

    public CWEImporter(ResourcesPath path) {
        this.path = path;
    }

    /**
     * Function to retrieve the list of CWE either from a previous import or from internet
     *
     * @return List of CWE
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public List<CWE> getListOfCWE() throws IOException, ClassNotFoundException {
        File cweBinary = new File(path.getBinaryPath() + CWE_OBJ);
        if (cweBinary.exists()) {
            return new Exporter(path).loadCWEMist();
        } else {
            return new data7.importer.cwe.CWEImporter(path).retrieveCWEOnline();
        }
    }
}
