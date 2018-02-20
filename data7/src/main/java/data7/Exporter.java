package data7;

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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import static data7.Resources.*;

public class Exporter {
    /**
     * Function to export the vulnerability dataset in a xml file.
     * Note : Only vulnerability with patches will be exported
     *
     * @param data7
     */
    public static void exportDatasetToXML(Data7 data7) {
        VulnerabilitySet dataset = data7.getVulnerabilitySet();
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

                    Element bugsId = doc.createElement("bugs");
                    for (String id : vuln.getValue().getBugId()) {
                        Element bugId = doc.createElement("id");
                        bugId.appendChild(doc.createTextNode(id));
                        bugsId.appendChild(bugId);
                    }
                    cve.appendChild(bugsId);

                    Element patchs = doc.createElement("patches");
                    for (Map.Entry<String, Commit> fix : vuln.getValue().getPatchingCommits().entrySet()) {
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
                        patchs.appendChild(patch);

                    }
                    cve.appendChild(patchs);


                }
            }
            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(PATH_TO_XML + dataset.getProjectName() + "-data7.xml");

            transformer.setOutputProperty(OutputKeys.VERSION, "1.0");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");

            //formatage
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");


            transformer.transform(source, result);

            System.out.println("File saved!");

        } catch (ParserConfigurationException | TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to save the current data7 in an object file that will appear in the selected folder
     *
     * @throws IOException
     */
    public static void saveDataset(Data7 data7) throws IOException {
        FileOutputStream fos = new FileOutputStream(PATH_TO_BINARY + data7.getVulnerabilitySet().getProjectName() + "-data7.obj");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(data7);
        oos.close();
        fos.close();
    }

    public static void saveCWEList(List<CWE> cweList) throws IOException {
        FileOutputStream fos = new FileOutputStream(PATH_TO_BINARY + CWE_OBJ);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(cweList);
        oos.close();
        fos.close();
    }
}
