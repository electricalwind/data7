package data7.importer.cwe.model;

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



import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour Structured_Text_Type complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="Structured_Text_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice maxOccurs="unbounded">
 *           &lt;group ref="{}Structured_Text_Group"/>
 *           &lt;element ref="{}Block"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Structured_Text_Type", propOrder = {
    "textTitleOrTextOrCodeExampleLanguage"
})
public class StructuredTextType {

    @XmlElementRefs({
        @XmlElementRef(name = "Image", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Text", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Comment", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Code", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Block", type = Block.class, required = false),
        @XmlElementRef(name = "Text_Title", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Code_Example_Language", type = JAXBElement.class, required = false)
    })
    protected List<Object> textTitleOrTextOrCodeExampleLanguage;

    /**
     * Gets the value of the textTitleOrTextOrCodeExampleLanguage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the textTitleOrTextOrCodeExampleLanguage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTextTitleOrTextOrCodeExampleLanguage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link Block.Image }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link Block }
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * 
     */
    public List<Object> getTextTitleOrTextOrCodeExampleLanguage() {
        if (textTitleOrTextOrCodeExampleLanguage == null) {
            textTitleOrTextOrCodeExampleLanguage = new ArrayList<Object>();
        }
        return this.textTitleOrTextOrCodeExampleLanguage;
    }

}
