package data7.importer.cwe.model;

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
