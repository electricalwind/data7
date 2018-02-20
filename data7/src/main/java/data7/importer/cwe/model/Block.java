package data7.importer.cwe.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded">
 *         &lt;group ref="{}Structured_Text_Group"/>
 *         &lt;element ref="{}Block"/>
 *       &lt;/choice>
 *       &lt;attribute name="Block_Nature">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="Good_Code"/>
 *             &lt;enumeration value="Bad_Code"/>
 *             &lt;enumeration value="Mitigation_Code"/>
 *             &lt;enumeration value="Attack"/>
 *             &lt;enumeration value="Result"/>
 *             &lt;enumeration value="List"/>
 *             &lt;enumeration value="Numeric_List"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "textTitleOrTextOrCodeExampleLanguage"
})
@XmlRootElement(name = "Block")
public class Block {

    @XmlElementRefs({
        @XmlElementRef(name = "Image", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Text", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Code_Example_Language", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Text_Title", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Comment", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Block", type = Block.class, required = false),
        @XmlElementRef(name = "Code", type = JAXBElement.class, required = false)
    })
    protected List<Object> textTitleOrTextOrCodeExampleLanguage;
    @XmlAttribute(name = "Block_Nature")
    protected String blockNature;

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
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link Block }
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

    /**
     * Obtient la valeur de la propriété blockNature.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBlockNature() {
        return blockNature;
    }

    /**
     * Définit la valeur de la propriété blockNature.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBlockNature(String value) {
        this.blockNature = value;
    }


    /**
     * <p>Classe Java pour anonymous complex type.
     * 
     * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence maxOccurs="unbounded">
     *         &lt;element name="Image_Location" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Image_Title" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "imageLocationAndImageTitle"
    })
    public static class Image {

        @XmlElementRefs({
            @XmlElementRef(name = "Image_Location", type = JAXBElement.class),
            @XmlElementRef(name = "Image_Title", type = JAXBElement.class)
        })
        protected List<JAXBElement<String>> imageLocationAndImageTitle;

        /**
         * Gets the value of the imageLocationAndImageTitle property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the imageLocationAndImageTitle property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getImageLocationAndImageTitle().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link JAXBElement }{@code <}{@link String }{@code >}
         * {@link JAXBElement }{@code <}{@link String }{@code >}
         * 
         * 
         */
        public List<JAXBElement<String>> getImageLocationAndImageTitle() {
            if (imageLocationAndImageTitle == null) {
                imageLocationAndImageTitle = new ArrayList<JAXBElement<String>>();
            }
            return this.imageLocationAndImageTitle;
        }

    }

}
