package data7.importer.cwe;

/*-
 * #%L
 * Data7
 * %%
 * Copyright (C) 2018 Matthieu Jimenez
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


import data7.importer.cwe.model.Category;
import data7.importer.cwe.model.Weakness;
import data7.importer.cwe.model.WeaknessCatalog;
import data7.model.CWE;

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
