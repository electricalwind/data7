package data7.importer.cwe.model;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The Languages_List_Type contains one or more Language elements, each
 * 				of which provide further reading and insight into the item. This should be filled
 * 				out as appropriate.
 * 
 * <p>Classe Java pour Languages_List_Type complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="Languages_List_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;sequence>
 *             &lt;element name="Language" maxOccurs="unbounded" minOccurs="0">
 *               &lt;complexType>
 *                 &lt;complexContent>
 *                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                     &lt;attribute name="Language_Name" type="{}Language_Type" />
 *                     &lt;attribute name="Prevalence" type="{}Frequency_Type" />
 *                   &lt;/restriction>
 *                 &lt;/complexContent>
 *               &lt;/complexType>
 *             &lt;/element>
 *             &lt;element name="Language_Class" maxOccurs="unbounded" minOccurs="0">
 *               &lt;complexType>
 *                 &lt;complexContent>
 *                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                     &lt;attribute name="Language_Class_Description" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                     &lt;attribute name="Prevalence" type="{}Frequency_Type" />
 *                   &lt;/restriction>
 *                 &lt;/complexContent>
 *               &lt;/complexType>
 *             &lt;/element>
 *           &lt;/sequence>
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
@XmlType(name = "Languages_List_Type", propOrder = {
    "language",
    "languageClass"
})
public class LanguagesListType {

    @XmlElement(name = "Language")
    protected List<LanguagesListType.Language> language;
    @XmlElement(name = "Language_Class")
    protected List<LanguagesListType.LanguageClass> languageClass;

    /**
     * Gets the value of the language property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the language property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLanguage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LanguagesListType.Language }
     * 
     * 
     */
    public List<LanguagesListType.Language> getLanguage() {
        if (language == null) {
            language = new ArrayList<LanguagesListType.Language>();
        }
        return this.language;
    }

    /**
     * Gets the value of the languageClass property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the languageClass property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLanguageClass().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LanguagesListType.LanguageClass }
     * 
     * 
     */
    public List<LanguagesListType.LanguageClass> getLanguageClass() {
        if (languageClass == null) {
            languageClass = new ArrayList<LanguagesListType.LanguageClass>();
        }
        return this.languageClass;
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
     *       &lt;attribute name="Language_Name" type="{}Language_Type" />
     *       &lt;attribute name="Prevalence" type="{}Frequency_Type" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Language {

        @XmlAttribute(name = "Language_Name")
        protected String languageName;
        @XmlAttribute(name = "Prevalence")
        protected FrequencyType prevalence;

        /**
         * Obtient la valeur de la propriété languageName.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLanguageName() {
            return languageName;
        }

        /**
         * Définit la valeur de la propriété languageName.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLanguageName(String value) {
            this.languageName = value;
        }

        /**
         * Obtient la valeur de la propriété prevalence.
         * 
         * @return
         *     possible object is
         *     {@link FrequencyType }
         *     
         */
        public FrequencyType getPrevalence() {
            return prevalence;
        }

        /**
         * Définit la valeur de la propriété prevalence.
         * 
         * @param value
         *     allowed object is
         *     {@link FrequencyType }
         *     
         */
        public void setPrevalence(FrequencyType value) {
            this.prevalence = value;
        }

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
     *       &lt;attribute name="Language_Class_Description" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="Prevalence" type="{}Frequency_Type" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class LanguageClass {

        @XmlAttribute(name = "Language_Class_Description")
        protected String languageClassDescription;
        @XmlAttribute(name = "Prevalence")
        protected FrequencyType prevalence;

        /**
         * Obtient la valeur de la propriété languageClassDescription.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLanguageClassDescription() {
            return languageClassDescription;
        }

        /**
         * Définit la valeur de la propriété languageClassDescription.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLanguageClassDescription(String value) {
            this.languageClassDescription = value;
        }

        /**
         * Obtient la valeur de la propriété prevalence.
         * 
         * @return
         *     possible object is
         *     {@link FrequencyType }
         *     
         */
        public FrequencyType getPrevalence() {
            return prevalence;
        }

        /**
         * Définit la valeur de la propriété prevalence.
         * 
         * @param value
         *     allowed object is
         *     {@link FrequencyType }
         *     
         */
        public void setPrevalence(FrequencyType value) {
            this.prevalence = value;
        }

    }

}
