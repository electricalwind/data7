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


import data7.importer.cve.CVEImporter;
import data7.importer.cve.DatasetUpdateListener;
import data7.importer.cwe.CWEImporter;
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


public class Importer {

    private final ResourcesPath path;

    public Importer(ResourcesPath path) {
        this.path = path;
    }

    /**
     * Function to retrieve the list of CWE either from a previous import or from internet
     *
     * @return List of CWE
     * @throws IOException
     * @throws JAXBException
     * @throws ClassNotFoundException
     */
    public List<CWE> getListOfCWE() throws IOException, JAXBException, ClassNotFoundException {
        File cweBinary = new File(path.getBinaryPath() + CWE_OBJ);
        if (cweBinary.exists()) {
            return new Exporter(path).loadCWEMist();
        } else {
            return new CWEImporter(path).retrieveCWEOnline();
        }
    }

    /**
     * Function to create or update a data7 for a given project
     *
     * @param project   to update or create the dataset from
     * @param listeners for additional access to the dataset
     * @return Data7 that was retrieved
     * @throws ParseException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public Data7 updateOrCreateDatasetFor(Project project, DatasetUpdateListener... listeners) throws ParseException, IOException, ClassNotFoundException {
        if (project != null) {
            File data7Binary = new File(path.getBinaryPath() + project.getName() + DATA7_OBJ);
            if (data7Binary.exists()) {
                return new CVEImporter(path).updateDataset(project.getName(), listeners);
            } else {
                return new CVEImporter(path).createDataset(project, listeners);
            }
        } else {
            throw new RuntimeException("Project is null");
        }
    }

    /**
     * Main to generate the dataset
     *
     * @param args
     * @throws ParseException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void main(String[] args) throws ParseException, IOException, ClassNotFoundException {
        ResourcesPath path = new ResourcesPath("/Users/matthieu/Desktop/data7/");
        Importer importer = new Importer(path);
        importer.updateOrCreateDatasetFor(CProjects.LINUX_KERNEL);
        importer.updateOrCreateDatasetFor(CProjects.OPEN_SSL);
        importer.updateOrCreateDatasetFor(CProjects.WIRESHARK);
        importer.updateOrCreateDatasetFor(CProjects.SYSTEMD);
    }

}
