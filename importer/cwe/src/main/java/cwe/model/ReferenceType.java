package cwe.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour Reference_Type complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="Reference_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Reference_Author" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Reference_Title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Reference_Section" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Reference_Edition" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Reference_Publication" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Reference_Publisher" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Reference_Date" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="Reference_PubDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Reference_Link" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Reference_ID" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Local_Reference_ID" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Reference_Type", propOrder = {
    "referenceAuthor",
    "referenceTitle",
    "referenceSection",
    "referenceEdition",
    "referencePublication",
    "referencePublisher",
    "referenceDate",
    "referencePubDate",
    "referenceLink"
})
public class ReferenceType {

    @XmlElement(name = "Reference_Author")
    protected List<String> referenceAuthor;
    @XmlElement(name = "Reference_Title")
    protected String referenceTitle;
    @XmlElement(name = "Reference_Section")
    protected String referenceSection;
    @XmlElement(name = "Reference_Edition")
    protected String referenceEdition;
    @XmlElement(name = "Reference_Publication")
    protected String referencePublication;
    @XmlElement(name = "Reference_Publisher")
    protected String referencePublisher;
    @XmlElement(name = "Reference_Date")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar referenceDate;
    @XmlElement(name = "Reference_PubDate")
    protected String referencePubDate;
    @XmlElement(name = "Reference_Link")
    protected String referenceLink;
    @XmlAttribute(name = "Reference_ID")
    protected String referenceID;
    @XmlAttribute(name = "Local_Reference_ID")
    protected String localReferenceID;

    /**
     * Gets the value of the referenceAuthor property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the referenceAuthor property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReferenceAuthor().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getReferenceAuthor() {
        if (referenceAuthor == null) {
            referenceAuthor = new ArrayList<String>();
        }
        return this.referenceAuthor;
    }

    /**
     * Obtient la valeur de la propriété referenceTitle.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferenceTitle() {
        return referenceTitle;
    }

    /**
     * Définit la valeur de la propriété referenceTitle.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferenceTitle(String value) {
        this.referenceTitle = value;
    }

    /**
     * Obtient la valeur de la propriété referenceSection.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferenceSection() {
        return referenceSection;
    }

    /**
     * Définit la valeur de la propriété referenceSection.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferenceSection(String value) {
        this.referenceSection = value;
    }

    /**
     * Obtient la valeur de la propriété referenceEdition.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferenceEdition() {
        return referenceEdition;
    }

    /**
     * Définit la valeur de la propriété referenceEdition.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferenceEdition(String value) {
        this.referenceEdition = value;
    }

    /**
     * Obtient la valeur de la propriété referencePublication.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferencePublication() {
        return referencePublication;
    }

    /**
     * Définit la valeur de la propriété referencePublication.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferencePublication(String value) {
        this.referencePublication = value;
    }

    /**
     * Obtient la valeur de la propriété referencePublisher.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferencePublisher() {
        return referencePublisher;
    }

    /**
     * Définit la valeur de la propriété referencePublisher.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferencePublisher(String value) {
        this.referencePublisher = value;
    }

    /**
     * Obtient la valeur de la propriété referenceDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getReferenceDate() {
        return referenceDate;
    }

    /**
     * Définit la valeur de la propriété referenceDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setReferenceDate(XMLGregorianCalendar value) {
        this.referenceDate = value;
    }

    /**
     * Obtient la valeur de la propriété referencePubDate.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferencePubDate() {
        return referencePubDate;
    }

    /**
     * Définit la valeur de la propriété referencePubDate.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferencePubDate(String value) {
        this.referencePubDate = value;
    }

    /**
     * Obtient la valeur de la propriété referenceLink.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferenceLink() {
        return referenceLink;
    }

    /**
     * Définit la valeur de la propriété referenceLink.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferenceLink(String value) {
        this.referenceLink = value;
    }

    /**
     * Obtient la valeur de la propriété referenceID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferenceID() {
        return referenceID;
    }

    /**
     * Définit la valeur de la propriété referenceID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferenceID(String value) {
        this.referenceID = value;
    }

    /**
     * Obtient la valeur de la propriété localReferenceID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocalReferenceID() {
        return localReferenceID;
    }

    /**
     * Définit la valeur de la propriété localReferenceID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocalReferenceID(String value) {
        this.localReferenceID = value;
    }

}
