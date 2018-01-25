package cweimporter;

import miscUtils.Misc;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.List;

public class Importer {
    public static List<CWE> importCWE() throws FileNotFoundException, JAXBException {
        String temp = Importer.class.getClass().getResource("/").getPath();
        Misc.downloadFromURL(Ressources.CWE_URL, temp);
        Misc.unzipping(temp + Ressources.XML_FILE+".zip",temp);
        return new Parser(temp + Ressources.XML_FILE).cweList();
    }

    public static void main(String[] args) throws FileNotFoundException, JAXBException {
        List<CWE> cwe = importCWE();
    }
}
