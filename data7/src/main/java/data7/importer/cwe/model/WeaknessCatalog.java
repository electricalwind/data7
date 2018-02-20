package data7.importer.cwe.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="Views">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{}View" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Categories">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{}Category" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Weaknesses">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{}Weakness" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Compound_Elements">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{}Compound_Element" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="Catalog_Name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Catalog_Version" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Catalog_Date" type="{http://www.w3.org/2001/XMLSchema}date" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "views",
    "categories",
    "weaknesses",
    "compoundElements"
})
@XmlRootElement(name = "Weakness_Catalog")
public class WeaknessCatalog {

    @XmlElement(name = "Views", required = true)
    protected WeaknessCatalog.Views views;
    @XmlElement(name = "Categories", required = true)
    protected WeaknessCatalog.Categories categories;
    @XmlElement(name = "Weaknesses", required = true)
    protected WeaknessCatalog.Weaknesses weaknesses;
    @XmlElement(name = "Compound_Elements", required = true)
    protected WeaknessCatalog.CompoundElements compoundElements;
    @XmlAttribute(name = "Catalog_Name", required = true)
    protected String catalogName;
    @XmlAttribute(name = "Catalog_Version", required = true)
    protected String catalogVersion;
    @XmlAttribute(name = "Catalog_Date")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar catalogDate;

    /**
     * Obtient la valeur de la propriété views.
     * 
     * @return
     *     possible object is
     *     {@link WeaknessCatalog.Views }
     *     
     */
    public WeaknessCatalog.Views getViews() {
        return views;
    }

    /**
     * Définit la valeur de la propriété views.
     * 
     * @param value
     *     allowed object is
     *     {@link WeaknessCatalog.Views }
     *     
     */
    public void setViews(WeaknessCatalog.Views value) {
        this.views = value;
    }

    /**
     * Obtient la valeur de la propriété categories.
     * 
     * @return
     *     possible object is
     *     {@link WeaknessCatalog.Categories }
     *     
     */
    public WeaknessCatalog.Categories getCategories() {
        return categories;
    }

    /**
     * Définit la valeur de la propriété categories.
     * 
     * @param value
     *     allowed object is
     *     {@link WeaknessCatalog.Categories }
     *     
     */
    public void setCategories(WeaknessCatalog.Categories value) {
        this.categories = value;
    }

    /**
     * Obtient la valeur de la propriété weaknesses.
     * 
     * @return
     *     possible object is
     *     {@link WeaknessCatalog.Weaknesses }
     *     
     */
    public WeaknessCatalog.Weaknesses getWeaknesses() {
        return weaknesses;
    }

    /**
     * Définit la valeur de la propriété weaknesses.
     * 
     * @param value
     *     allowed object is
     *     {@link WeaknessCatalog.Weaknesses }
     *     
     */
    public void setWeaknesses(WeaknessCatalog.Weaknesses value) {
        this.weaknesses = value;
    }

    /**
     * Obtient la valeur de la propriété compoundElements.
     * 
     * @return
     *     possible object is
     *     {@link WeaknessCatalog.CompoundElements }
     *     
     */
    public WeaknessCatalog.CompoundElements getCompoundElements() {
        return compoundElements;
    }

    /**
     * Définit la valeur de la propriété compoundElements.
     * 
     * @param value
     *     allowed object is
     *     {@link WeaknessCatalog.CompoundElements }
     *     
     */
    public void setCompoundElements(WeaknessCatalog.CompoundElements value) {
        this.compoundElements = value;
    }

    /**
     * Obtient la valeur de la propriété catalogName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCatalogName() {
        return catalogName;
    }

    /**
     * Définit la valeur de la propriété catalogName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCatalogName(String value) {
        this.catalogName = value;
    }

    /**
     * Obtient la valeur de la propriété catalogVersion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCatalogVersion() {
        return catalogVersion;
    }

    /**
     * Définit la valeur de la propriété catalogVersion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCatalogVersion(String value) {
        this.catalogVersion = value;
    }

    /**
     * Obtient la valeur de la propriété catalogDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCatalogDate() {
        return catalogDate;
    }

    /**
     * Définit la valeur de la propriété catalogDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCatalogDate(XMLGregorianCalendar value) {
        this.catalogDate = value;
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
     *         &lt;element ref="{}Category" maxOccurs="unbounded" minOccurs="0"/>
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
        "category"
    })
    public static class Categories {

        @XmlElement(name = "Category")
        protected List<Category> category;

        /**
         * Gets the value of the category property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the category property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCategory().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Category }
         * 
         * 
         */
        public List<Category> getCategory() {
            if (category == null) {
                category = new ArrayList<Category>();
            }
            return this.category;
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
     *       &lt;sequence>
     *         &lt;element ref="{}Compound_Element" maxOccurs="unbounded" minOccurs="0"/>
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
        "compoundElement"
    })
    public static class CompoundElements {

        @XmlElement(name = "Compound_Element")
        protected List<CompoundElement> compoundElement;

        /**
         * Gets the value of the compoundElement property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the compoundElement property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCompoundElement().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link CompoundElement }
         * 
         * 
         */
        public List<CompoundElement> getCompoundElement() {
            if (compoundElement == null) {
                compoundElement = new ArrayList<CompoundElement>();
            }
            return this.compoundElement;
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
     *       &lt;sequence>
     *         &lt;element ref="{}View" maxOccurs="unbounded" minOccurs="0"/>
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
        "view"
    })
    public static class Views {

        @XmlElement(name = "View")
        protected List<View> view;

        /**
         * Gets the value of the view property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the view property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getView().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link View }
         * 
         * 
         */
        public List<View> getView() {
            if (view == null) {
                view = new ArrayList<View>();
            }
            return this.view;
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
     *       &lt;sequence>
     *         &lt;element ref="{}Weakness" maxOccurs="unbounded" minOccurs="0"/>
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
        "weakness"
    })
    public static class Weaknesses {

        @XmlElement(name = "Weakness")
        protected List<Weakness> weakness;

        /**
         * Gets the value of the weakness property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the weakness property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getWeakness().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Weakness }
         * 
         * 
         */
        public List<Weakness> getWeakness() {
            if (weakness == null) {
                weakness = new ArrayList<Weakness>();
            }
            return this.weakness;
        }

    }

}
