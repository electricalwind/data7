package data7.importer.cwe;

import data7.Resources;
import data7.Exporter;
import data7.model.CWE;
import miscUtils.Misc;

import javax.xml.bind.JAXBException;
import java.io.*;
import java.util.List;

import static data7.Resources.CWE_XML_FILE;

public class CWEImporter {


    public static List<CWE> retrieveCWEOnline() throws IOException, JAXBException {
        String temp = CWEImporter.class.getClass().getResource("/").getPath();
        Misc.downloadFromURL(Resources.CWE_URL, temp);
        Misc.unzipping(temp + CWE_XML_FILE + ".zip", temp);
        List<CWE> cweList = new Parser(temp + CWE_XML_FILE).cweList();
        Exporter.saveCWEList(cweList);
        return cweList;
    }

    public static List<CWE> loadCWEFromBinary(File binaryFile) throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream(binaryFile);
        ObjectInputStream read = new ObjectInputStream(fileIn);
        List<CWE> data = (List<CWE>) read.readObject();
        read.close();
        fileIn.close();
        return data;
    }

}
