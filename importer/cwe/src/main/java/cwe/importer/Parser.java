package cwe.importer;

import cwe.CWE;
import cwe.model.Category;
import cwe.model.Weakness;
import cwe.model.WeaknessCatalog;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {
    private WeaknessCatalog weaknessCatalog;

    /**
     * Parser class
     * <p>
     * This class unmarshall a xml file conform to the xsd in its 5.4.2 version
     *
     * @param xmlFile Path to the xml File
     */
    public Parser(String xmlFile) throws FileNotFoundException, JAXBException {
        String[] filesplit = xmlFile.split("\\.");
        if (!filesplit[filesplit.length - 1].equals("xml")) {
            throw new FileNotFoundException("This is not a xml file");
        }
        File file = new File(xmlFile);
        if (!file.exists() || !file.isFile()) {
            throw new FileNotFoundException("This is not a file");
        }
        JAXBContext jaxbContext = JAXBContext.newInstance(WeaknessCatalog.class);
        Unmarshaller jacbUnmarshaller = jaxbContext.createUnmarshaller();
        weaknessCatalog = (WeaknessCatalog) jacbUnmarshaller.unmarshal(file);
    }


    /**
     * return all the categories of the file
     */
    public List<Category> categoryList() {
        return weaknessCatalog.getCategories().getCategory();
    }

    /**
     * return all weaknesses present in the file
     */
    public List<Weakness> weaknessList() {
        return weaknessCatalog.getWeaknesses().getWeakness();
    }

    /**
     * return the list of all cwe present in the file
     */
    List<CWE> cweList() {
        List<CWE> listCWE = new ArrayList<>();

        for (Category cat : categoryList()) {
            List<Integer> childOf = new ArrayList<>();
            if (cat.getRelationships() != null) {
                childOf = cat.getRelationships().getRelationship().stream().filter(relationship ->
                        relationship.getRelationshipNature().equals("ChildOf")
                ).map(relationship -> relationship.getRelationshipTargetID().intValue()).collect(Collectors.toList());
            }
            listCWE.add(new CWE(
                    cat.getID().intValue(),
                    cat.getName(),
                    cat.getDescription().getDescriptionSummary(),
                    childOf
            ));
        }
        for (Weakness weakness : weaknessList()) {
            List<Integer> childOf = new ArrayList<>();
            if (weakness.getRelationships() != null) {
                childOf = weakness.getRelationships().getRelationship().stream().filter(relationship ->
                        relationship.getRelationshipNature().equals("ChildOf")
                ).map(relationship -> relationship.getRelationshipTargetID().intValue()).collect(Collectors.toList());
            }
            listCWE.add(
                    new CWE(
                            weakness.getID().intValue(),
                            weakness.getName(),
                            weakness.getDescription().getDescriptionSummary(),
                            childOf
                    ));
        }
        return listCWE;
    }
}
