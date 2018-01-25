package cweModel;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *       &lt;sequence>
 *         &lt;element name="Alternate_Term" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Term" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Alternate_Term_Description" type="{}Structured_Text_Type" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
    "alternateTerm"
})
@XmlRootElement(name = "Alternate_Terms")
public class AlternateTerms {

    @XmlElement(name = "Alternate_Term", required = true)
    protected List<AlternateTerms.AlternateTerm> alternateTerm;

    /**
     * Gets the value of the alternateTerm property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the alternateTerm property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAlternateTerm().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AlternateTerms.AlternateTerm }
     * 
     * 
     */
    public List<AlternateTerms.AlternateTerm> getAlternateTerm() {
        if (alternateTerm == null) {
            alternateTerm = new ArrayList<AlternateTerms.AlternateTerm>();
        }
        return this.alternateTerm;
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
     *       &lt;sequence>
     *         &lt;element name="Term" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Alternate_Term_Description" type="{}Structured_Text_Type" minOccurs="0"/>
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
        "term",
        "alternateTermDescription"
    })
    public static class AlternateTerm {

        @XmlElement(name = "Term", required = true)
        protected String term;
        @XmlElement(name = "Alternate_Term_Description")
        protected StructuredTextType alternateTermDescription;

        /**
         * Obtient la valeur de la propriété term.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTerm() {
            return term;
        }

        /**
         * Définit la valeur de la propriété term.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTerm(String value) {
            this.term = value;
        }

        /**
         * Obtient la valeur de la propriété alternateTermDescription.
         * 
         * @return
         *     possible object is
         *     {@link StructuredTextType }
         *     
         */
        public StructuredTextType getAlternateTermDescription() {
            return alternateTermDescription;
        }

        /**
         * Définit la valeur de la propriété alternateTermDescription.
         * 
         * @param value
         *     allowed object is
         *     {@link StructuredTextType }
         *     
         */
        public void setAlternateTermDescription(StructuredTextType value) {
            this.alternateTermDescription = value;
        }

    }

}
