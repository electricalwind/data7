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


import data7.importer.Data7Importer;
import data7.model.Data7;
import data7.project.AndroidMetaInf;
import data7.project.Project;
import data7.project.ProjectFactory;


import java.io.IOException;
import java.text.ParseException;


public class Importer {

    private final ResourcesPath path;

    public Importer(ResourcesPath path) {
        this.path = path;
    }


    public Data7 generateGenericProject(String projectName, Data7UpdateListener... listeners) throws ParseException, IOException, ClassNotFoundException {
        Project project = ProjectFactory.retrieveProjectInfo(projectName);
        Data7Importer data7Importer = new Data7Importer(path, project, listeners);
        return data7Importer.updateOrCreateDataset();
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
        ResourcesPath path = new ResourcesPath("/Users/matthieu/Desktop/data3/");
        Importer importer = new Importer(path);


        Data7 data7 = importer.generateGenericProject(AndroidMetaInf.ANDROID_NVD);
        Exporter exporter = new Exporter(path);
        exporter.exportDatasetToXML(data7);
    }

}
