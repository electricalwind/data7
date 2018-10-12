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


import data7.model.CWE;
import data7.model.Data7;
import data7.model.change.Commit;
import data7.model.change.FileFix;
import data7.model.vulnerability.Vulnerability;
import data7.model.vulnerability.VulnerabilitySet;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import static data7.Resources.*;

public class Exporter {

    private final ResourcesPath path;

    public Exporter(ResourcesPath path) {
        this.path = path;
    }

    /**
     * Method to save the current data7 in an object file that will appear in the selected folder
     *
     * @param data7 to save as binary
     * @throws IOException
     */
    public void saveDataset(Data7 data7) throws IOException {
        Utils.checkFolderDestination(path.getBinaryPath());
        FileOutputStream fos = new FileOutputStream(path.getBinaryPath() + data7.getProject().getName() + "-data7.obj", false);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(data7);
        oos.close();
        fos.close();
    }


    /**
     * Function to export the vulnerability dataset in a xml file.
     * Note : Only vulnerability with patches will be exported
     *
     * @param data7 to export to xml
     */
    public void exportDatasetToXML(Data7 data7) {
        VulnerabilitySet dataset = data7.getVulnerabilitySet();
        Utils.checkFolderDestination(path.getXmlPath());
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("data7");

            Date d = new Date(dataset.getLastUpdated());
            SimpleDateFormat jdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
            jdf.setTimeZone(TimeZone.getTimeZone("CET"));
            String java_date = jdf.format(d);
            rootElement.setAttribute("last_updated", java_date);

            rootElement.setAttribute("project", dataset.getProjectName());

            doc.appendChild(rootElement);

            for (Map.Entry<String, Vulnerability> vuln :
                    dataset.getVulnerabilityDataset().entrySet()
            ) {
                if (vuln.getValue().getPatchingCommits().size() > 0) {

                    Element cve = doc.createElement("cve");
                    cve.setAttribute("id", vuln.getKey());
                    cve.setAttribute("last_modified", String.valueOf(vuln.getValue().getLastModified() / 1000));
                    rootElement.appendChild(cve);

                    Element cwe = doc.createElement("cwe");
                    if (vuln.getValue().getCwe() != null) {
                        cwe.appendChild(doc.createTextNode(vuln.getValue().getCwe()));
                    } else {
                        cwe.appendChild(doc.createTextNode("UNK"));
                    }
                    cve.appendChild(cwe);

                    Element score = doc.createElement("score");
                    score.appendChild(doc.createTextNode(vuln.getValue().getScore()));
                    cve.appendChild(score);

                    Element description = doc.createElement("description");
                    description.appendChild(doc.createTextNode(vuln.getValue().getDescription()));
                    cve.appendChild(description);

                    Element versions = doc.createElement("affectedVersions");
                    for (String version : vuln.getValue().getVersions()) {
                        Element v = doc.createElement("version");
                        v.appendChild(doc.createTextNode(version));
                        versions.appendChild(v);
                    }
                    cve.appendChild(versions);

                    Element bugsId = doc.createElement("bugs");
                    vuln.getValue().getBugIds().forEach((component, listid) -> {
                        Element componentel = doc.createElement(component);
                        for (String id : listid) {
                            Element bugId = doc.createElement("id");
                            bugId.appendChild(doc.createTextNode(id));
                            componentel.appendChild(bugId);
                        }
                        bugsId.appendChild(componentel);
                    });

                    cve.appendChild(bugsId);

                    Element patchs = doc.createElement("patches");
                    vuln.getValue().getPatchingCommits().forEach((component, listpatches) -> {
                        Element componentel = doc.createElement(component);
                        for (Map.Entry<String, Commit> fix : listpatches.entrySet()) {
                            Element patch = doc.createElement("commit");
                            patch.setAttribute("hash", fix.getKey());
                            patch.setAttribute("timestamp", String.valueOf(fix.getValue().getTimestamp()));

                            Element message = doc.createElement("message");
                            message.appendChild(doc.createTextNode(fix.getValue().getMessage()));
                            patch.appendChild(message);

                            Element files = doc.createElement("files");
                            for (FileFix fileFix : fix.getValue().getFixes()) {
                                Element file = doc.createElement("file");
                                Element before = doc.createElement("before");
                                before.setAttribute("path", fileFix.getFileBefore().getFilePath());
                                before.setAttribute("hash", fileFix.getOldHash());
                                before.appendChild(doc.createTextNode(fileFix.getFileBefore().getFileContent()));
                                file.appendChild(before);

                                Element after = doc.createElement("after");
                                after.setAttribute("path", fileFix.getFileAfter().getFilePath());
                                after.appendChild(doc.createTextNode(fileFix.getFileAfter().getFileContent()));
                                file.appendChild(after);
                                files.appendChild(file);
                            }
                            patch.appendChild(files);
                            componentel.appendChild(patch);
                        }
                        patchs.appendChild(componentel);
                    });
                    cve.appendChild(patchs);


                }
            }
            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(path.getXmlPath() + data7.getProject().getName() + "-data7.xml");

            transformer.setOutputProperty(OutputKeys.VERSION, "1.0");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");

            //formatage
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");


            transformer.transform(source, result);

            System.out.println("File saved!");

        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }


    /**
     * Method to save the cwe list in an object file that will appear in the selected folder
     *
     * @param cweList
     * @throws IOException
     */
    public void saveCWEList(List<CWE> cweList) throws IOException {
        FileOutputStream fos = new FileOutputStream(path.getBinaryPath() + CWE_OBJ, false);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(cweList);
        oos.close();
        fos.close();
    }

    /**
     * Method to load the CWE list  that have been save in its binary form
     *
     * @return Data7
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public List<CWE> loadCWEMist() throws IOException, ClassNotFoundException {
        File file = new File(path.getBinaryPath() + CWE_OBJ);
        if (file.exists()) {
            FileInputStream fileIn = new FileInputStream(file);
            ObjectInputStream read = new ObjectInputStream(fileIn);
            List<CWE> data = (List<CWE>) read.readObject();
            read.close();
            fileIn.close();
            return data;
        } else {
            return null;
        }
    }
}
