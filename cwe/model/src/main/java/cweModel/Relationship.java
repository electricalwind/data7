package cweModel;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


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
 *         &lt;element name="Relationship_Views">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Relationship_View_ID" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>integer">
 *                           &lt;attribute name="Ordinal">
 *                             &lt;simpleType>
 *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                 &lt;enumeration value="Primary"/>
 *                               &lt;/restriction>
 *                             &lt;/simpleType>
 *                           &lt;/attribute>
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Relationship_Chains" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Relationship_Chain_ID" type="{http://www.w3.org/2001/XMLSchema}integer" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Relationship_Target_Form">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Category"/>
 *               &lt;enumeration value="Weakness"/>
 *               &lt;enumeration value="View"/>
 *               &lt;enumeration value="Compound_Element"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Relationship_Nature">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="HasMember"/>
 *               &lt;enumeration value="MemberOf"/>
 *               &lt;enumeration value="ChildOf"/>
 *               &lt;enumeration value="ParentOf"/>
 *               &lt;enumeration value="PeerOf"/>
 *               &lt;enumeration value="Requires"/>
 *               &lt;enumeration value="RequiredBy"/>
 *               &lt;enumeration value="StartsWith"/>
 *               &lt;enumeration value="StartsChain"/>
 *               &lt;enumeration value="CanPrecede"/>
 *               &lt;enumeration value="CanFollow"/>
 *               &lt;enumeration value="CanAlsoBe"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Relationship_Target_ID" type="{http://www.w3.org/2001/XMLSchema}integer"/>
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
    "relationshipViews",
    "relationshipChains",
    "relationshipTargetForm",
    "relationshipNature",
    "relationshipTargetID"
})
@XmlRootElement(name = "Relationship")
public class Relationship {

    @XmlElement(name = "Relationship_Views", required = true)
    protected Relationship.RelationshipViews relationshipViews;
    @XmlElement(name = "Relationship_Chains")
    protected Relationship.RelationshipChains relationshipChains;
    @XmlElement(name = "Relationship_Target_Form", required = true)
    protected String relationshipTargetForm;
    @XmlElement(name = "Relationship_Nature", required = true)
    protected String relationshipNature;
    @XmlElement(name = "Relationship_Target_ID", required = true)
    protected BigInteger relationshipTargetID;

    /**
     * Obtient la valeur de la propriété relationshipViews.
     * 
     * @return
     *     possible object is
     *     {@link Relationship.RelationshipViews }
     *     
     */
    public Relationship.RelationshipViews getRelationshipViews() {
        return relationshipViews;
    }

    /**
     * Définit la valeur de la propriété relationshipViews.
     * 
     * @param value
     *     allowed object is
     *     {@link Relationship.RelationshipViews }
     *     
     */
    public void setRelationshipViews(Relationship.RelationshipViews value) {
        this.relationshipViews = value;
    }

    /**
     * Obtient la valeur de la propriété relationshipChains.
     * 
     * @return
     *     possible object is
     *     {@link Relationship.RelationshipChains }
     *     
     */
    public Relationship.RelationshipChains getRelationshipChains() {
        return relationshipChains;
    }

    /**
     * Définit la valeur de la propriété relationshipChains.
     * 
     * @param value
     *     allowed object is
     *     {@link Relationship.RelationshipChains }
     *     
     */
    public void setRelationshipChains(Relationship.RelationshipChains value) {
        this.relationshipChains = value;
    }

    /**
     * Obtient la valeur de la propriété relationshipTargetForm.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRelationshipTargetForm() {
        return relationshipTargetForm;
    }

    /**
     * Définit la valeur de la propriété relationshipTargetForm.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRelationshipTargetForm(String value) {
        this.relationshipTargetForm = value;
    }

    /**
     * Obtient la valeur de la propriété relationshipNature.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRelationshipNature() {
        return relationshipNature;
    }

    /**
     * Définit la valeur de la propriété relationshipNature.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRelationshipNature(String value) {
        this.relationshipNature = value;
    }

    /**
     * Obtient la valeur de la propriété relationshipTargetID.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getRelationshipTargetID() {
        return relationshipTargetID;
    }

    /**
     * Définit la valeur de la propriété relationshipTargetID.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setRelationshipTargetID(BigInteger value) {
        this.relationshipTargetID = value;
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
     *         &lt;element name="Relationship_Chain_ID" type="{http://www.w3.org/2001/XMLSchema}integer" maxOccurs="unbounded" minOccurs="0"/>
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
        "relationshipChainID"
    })
    public static class RelationshipChains {

        @XmlElement(name = "Relationship_Chain_ID")
        protected List<BigInteger> relationshipChainID;

        /**
         * Gets the value of the relationshipChainID property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the relationshipChainID property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getRelationshipChainID().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link BigInteger }
         * 
         * 
         */
        public List<BigInteger> getRelationshipChainID() {
            if (relationshipChainID == null) {
                relationshipChainID = new ArrayList<BigInteger>();
            }
            return this.relationshipChainID;
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
     *         &lt;element name="Relationship_View_ID" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>integer">
     *                 &lt;attribute name="Ordinal">
     *                   &lt;simpleType>
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                       &lt;enumeration value="Primary"/>
     *                     &lt;/restriction>
     *                   &lt;/simpleType>
     *                 &lt;/attribute>
     *               &lt;/extension>
     *             &lt;/simpleContent>
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
        "relationshipViewID"
    })
    public static class RelationshipViews {

        @XmlElement(name = "Relationship_View_ID", required = true)
        protected List<Relationship.RelationshipViews.RelationshipViewID> relationshipViewID;

        /**
         * Gets the value of the relationshipViewID property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the relationshipViewID property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getRelationshipViewID().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Relationship.RelationshipViews.RelationshipViewID }
         * 
         * 
         */
        public List<Relationship.RelationshipViews.RelationshipViewID> getRelationshipViewID() {
            if (relationshipViewID == null) {
                relationshipViewID = new ArrayList<Relationship.RelationshipViews.RelationshipViewID>();
            }
            return this.relationshipViewID;
        }


        /**
         * <p>Classe Java pour anonymous complex type.
         * 
         * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>integer">
         *       &lt;attribute name="Ordinal">
         *         &lt;simpleType>
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *             &lt;enumeration value="Primary"/>
         *           &lt;/restriction>
         *         &lt;/simpleType>
         *       &lt;/attribute>
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class RelationshipViewID {

            @XmlValue
            protected BigInteger value;
            @XmlAttribute(name = "Ordinal")
            protected String ordinal;

            /**
             * Obtient la valeur de la propriété value.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getValue() {
                return value;
            }

            /**
             * Définit la valeur de la propriété value.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setValue(BigInteger value) {
                this.value = value;
            }

            /**
             * Obtient la valeur de la propriété ordinal.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getOrdinal() {
                return ordinal;
            }

            /**
             * Définit la valeur de la propriété ordinal.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setOrdinal(String value) {
                this.ordinal = value;
            }

        }

    }

}
