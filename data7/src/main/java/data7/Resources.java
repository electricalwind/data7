package data7;

public class Resources {
    public static final String FILE_START = "nvdcve-2.0-";
    public static final String CVE_URL = "https://static.nvd.nist.gov/feeds/xml/cve/2.0/" + FILE_START;
    public static final String META = ".meta";
    public static final String XML = ".xml.zip";

    public static final String FILE_EXTENSION = ".*";

    public static final String PATH_TO_SAVE = "/Users/matthieu/Desktop/data7/";
    public static final String PATH_TO_BINARY = PATH_TO_SAVE + "binary/";
    public static final String PATH_TO_GIT = PATH_TO_SAVE + "git/";
    public static final String PATH_TO_XML = PATH_TO_SAVE + "xml/";
    public static final String PATH_TO_CVE = PATH_TO_SAVE + "cve/";

    public static final int NB_THREADS = 4;


    public static final String CWE_URL = "https://cwe.mitre.org/data/xml/cwec_v2.12.xml.zip";
    public static final String CWE_XML_FILE = "cwec_v2.12.xml";
    public static final String CWE_OBJ = "cwe.obj";

    public static final String DATA7_OBJ = "-data7.obj";

}
