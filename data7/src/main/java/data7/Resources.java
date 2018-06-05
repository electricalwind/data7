package data7;

/*-
 * #%L
 * Data7
 * %%
 * Copyright (C) 2018 University of Luxembourg, Matthieu Jimenez
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */



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
