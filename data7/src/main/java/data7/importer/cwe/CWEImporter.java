package data7.importer.cwe;

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



import data7.Resources;
import data7.Exporter;
import data7.ResourcesPath;
import data7.model.CWE;
import miscUtils.Misc;

import javax.xml.bind.JAXBException;
import java.io.*;
import java.util.List;

import static data7.Resources.CWE_XML_FILE;

public class CWEImporter {

    private final ResourcesPath path;

    public CWEImporter(ResourcesPath path){
        this.path = path;
    }


    public List<CWE> retrieveCWEOnline() throws IOException, JAXBException {
        Misc.downloadFromURL(Resources.CWE_URL, path.getCvePath());
        Misc.unzipping(path.getCvePath() + CWE_XML_FILE + ".zip", path.getCvePath());
        List<CWE> cweList = new Parser(path.getCvePath() + CWE_XML_FILE).cweList();
        new Exporter(path).saveCWEList(cweList);
        return cweList;
    }

}
