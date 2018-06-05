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



import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 *       &lt;group ref="{}View_Attributes"/>
 *       &lt;attribute name="ID" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="Name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Status" use="required" type="{}Status_Type" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "viewStructure",
    "viewObjective",
    "viewAudience",
    "relationships",
    "relationshipNotes",
    "maintenanceNotes",
    "otherNotes",
    "alternateTerms",
    "researchGaps",
    "references",
    "viewFilter",
    "contentHistory"
})
@XmlRootElement(name = "View")
public class View {

    @XmlElement(name = "View_Structure", required = true)
    protected String viewStructure;
    @XmlElement(name = "View_Objective", required = true)
    protected StructuredTextType viewObjective;
    @XmlElement(name = "View_Audience")
    protected View.ViewAudience viewAudience;
    @XmlElement(name = "Relationships")
    protected Relationships relationships;
    @XmlElement(name = "Relationship_Notes")
    protected RelationshipNotes relationshipNotes;
    @XmlElement(name = "Maintenance_Notes")
    protected MaintenanceNotes maintenanceNotes;
    @XmlElement(name = "Other_Notes")
    protected OtherNotes otherNotes;
    @XmlElement(name = "Alternate_Terms")
    protected AlternateTerms alternateTerms;
    @XmlElement(name = "Research_Gaps")
    protected ResearchGaps researchGaps;
    @XmlElement(name = "References")
    protected ReferenceListType references;
    @XmlElement(name = "View_Filter")
    protected String viewFilter;
    @XmlElement(name = "Content_History", required = true)
    protected ContentHistory contentHistory;
    @XmlAttribute(name = "ID", required = true)
    protected BigInteger id;
    @XmlAttribute(name = "Name", required = true)
    protected String name;
    @XmlAttribute(name = "Status", required = true)
    protected StatusType status;

    /**
     * Obtient la valeur de la propriété viewStructure.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getViewStructure() {
        return viewStructure;
    }

    /**
     * Définit la valeur de la propriété viewStructure.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setViewStructure(String value) {
        this.viewStructure = value;
    }

    /**
     * Obtient la valeur de la propriété viewObjective.
     * 
     * @return
     *     possible object is
     *     {@link StructuredTextType }
     *     
     */
    public StructuredTextType getViewObjective() {
        return viewObjective;
    }

    /**
     * Définit la valeur de la propriété viewObjective.
     * 
     * @param value
     *     allowed object is
     *     {@link StructuredTextType }
     *     
     */
    public void setViewObjective(StructuredTextType value) {
        this.viewObjective = value;
    }

    /**
     * Obtient la valeur de la propriété viewAudience.
     * 
     * @return
     *     possible object is
     *     {@link View.ViewAudience }
     *     
     */
    public View.ViewAudience getViewAudience() {
        return viewAudience;
    }

    /**
     * Définit la valeur de la propriété viewAudience.
     * 
     * @param value
     *     allowed object is
     *     {@link View.ViewAudience }
     *     
     */
    public void setViewAudience(View.ViewAudience value) {
        this.viewAudience = value;
    }

    /**
     * Obtient la valeur de la propriété relationships.
     * 
     * @return
     *     possible object is
     *     {@link Relationships }
     *     
     */
    public Relationships getRelationships() {
        return relationships;
    }

    /**
     * Définit la valeur de la propriété relationships.
     * 
     * @param value
     *     allowed object is
     *     {@link Relationships }
     *     
     */
    public void setRelationships(Relationships value) {
        this.relationships = value;
    }

    /**
     * Obtient la valeur de la propriété relationshipNotes.
     * 
     * @return
     *     possible object is
     *     {@link RelationshipNotes }
     *     
     */
    public RelationshipNotes getRelationshipNotes() {
        return relationshipNotes;
    }

    /**
     * Définit la valeur de la propriété relationshipNotes.
     * 
     * @param value
     *     allowed object is
     *     {@link RelationshipNotes }
     *     
     */
    public void setRelationshipNotes(RelationshipNotes value) {
        this.relationshipNotes = value;
    }

    /**
     * Obtient la valeur de la propriété maintenanceNotes.
     * 
     * @return
     *     possible object is
     *     {@link MaintenanceNotes }
     *     
     */
    public MaintenanceNotes getMaintenanceNotes() {
        return maintenanceNotes;
    }

    /**
     * Définit la valeur de la propriété maintenanceNotes.
     * 
     * @param value
     *     allowed object is
     *     {@link MaintenanceNotes }
     *     
     */
    public void setMaintenanceNotes(MaintenanceNotes value) {
        this.maintenanceNotes = value;
    }

    /**
     * Obtient la valeur de la propriété otherNotes.
     * 
     * @return
     *     possible object is
     *     {@link OtherNotes }
     *     
     */
    public OtherNotes getOtherNotes() {
        return otherNotes;
    }

    /**
     * Définit la valeur de la propriété otherNotes.
     * 
     * @param value
     *     allowed object is
     *     {@link OtherNotes }
     *     
     */
    public void setOtherNotes(OtherNotes value) {
        this.otherNotes = value;
    }

    /**
     * Obtient la valeur de la propriété alternateTerms.
     * 
     * @return
     *     possible object is
     *     {@link AlternateTerms }
     *     
     */
    public AlternateTerms getAlternateTerms() {
        return alternateTerms;
    }

    /**
     * Définit la valeur de la propriété alternateTerms.
     * 
     * @param value
     *     allowed object is
     *     {@link AlternateTerms }
     *     
     */
    public void setAlternateTerms(AlternateTerms value) {
        this.alternateTerms = value;
    }

    /**
     * Obtient la valeur de la propriété researchGaps.
     * 
     * @return
     *     possible object is
     *     {@link ResearchGaps }
     *     
     */
    public ResearchGaps getResearchGaps() {
        return researchGaps;
    }

    /**
     * Définit la valeur de la propriété researchGaps.
     * 
     * @param value
     *     allowed object is
     *     {@link ResearchGaps }
     *     
     */
    public void setResearchGaps(ResearchGaps value) {
        this.researchGaps = value;
    }

    /**
     * Obtient la valeur de la propriété references.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceListType }
     *     
     */
    public ReferenceListType getReferences() {
        return references;
    }

    /**
     * Définit la valeur de la propriété references.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceListType }
     *     
     */
    public void setReferences(ReferenceListType value) {
        this.references = value;
    }

    /**
     * Obtient la valeur de la propriété viewFilter.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getViewFilter() {
        return viewFilter;
    }

    /**
     * Définit la valeur de la propriété viewFilter.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setViewFilter(String value) {
        this.viewFilter = value;
    }

    /**
     * Obtient la valeur de la propriété contentHistory.
     * 
     * @return
     *     possible object is
     *     {@link ContentHistory }
     *     
     */
    public ContentHistory getContentHistory() {
        return contentHistory;
    }

    /**
     * Définit la valeur de la propriété contentHistory.
     * 
     * @param value
     *     allowed object is
     *     {@link ContentHistory }
     *     
     */
    public void setContentHistory(ContentHistory value) {
        this.contentHistory = value;
    }

    /**
     * Obtient la valeur de la propriété id.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getID() {
        return id;
    }

    /**
     * Définit la valeur de la propriété id.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setID(BigInteger value) {
        this.id = value;
    }

    /**
     * Obtient la valeur de la propriété name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Définit la valeur de la propriété name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Obtient la valeur de la propriété status.
     * 
     * @return
     *     possible object is
     *     {@link StatusType }
     *     
     */
    public StatusType getStatus() {
        return status;
    }

    /**
     * Définit la valeur de la propriété status.
     * 
     * @param value
     *     allowed object is
     *     {@link StatusType }
     *     
     */
    public void setStatus(StatusType value) {
        this.status = value;
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
     *         &lt;element name="Audience" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Stakeholder">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;enumeration value="Developers"/>
     *                         &lt;enumeration value="Software_Vendors"/>
     *                         &lt;enumeration value="Assessment_Vendors"/>
     *                         &lt;enumeration value="Educators"/>
     *                         &lt;enumeration value="OWGV"/>
     *                         &lt;enumeration value="SAMATE"/>
     *                         &lt;enumeration value="CWE_Formalization"/>
     *                         &lt;enumeration value="CWE_Team"/>
     *                         &lt;enumeration value="Software_Customers"/>
     *                         &lt;enumeration value="Assessment_Customers"/>
     *                         &lt;enumeration value="Academic_Researchers"/>
     *                         &lt;enumeration value="Applied_Researchers"/>
     *                         &lt;enumeration value="Information_Providers"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="Stakeholder_Description" type="{}Structured_Text_Type" minOccurs="0"/>
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
        "audience"
    })
    public static class ViewAudience {

        @XmlElement(name = "Audience", required = true)
        protected List<View.ViewAudience.Audience> audience;

        /**
         * Gets the value of the audience property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the audience property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAudience().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link View.ViewAudience.Audience }
         * 
         * 
         */
        public List<View.ViewAudience.Audience> getAudience() {
            if (audience == null) {
                audience = new ArrayList<View.ViewAudience.Audience>();
            }
            return this.audience;
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
         *         &lt;element name="Stakeholder">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;enumeration value="Developers"/>
         *               &lt;enumeration value="Software_Vendors"/>
         *               &lt;enumeration value="Assessment_Vendors"/>
         *               &lt;enumeration value="Educators"/>
         *               &lt;enumeration value="OWGV"/>
         *               &lt;enumeration value="SAMATE"/>
         *               &lt;enumeration value="CWE_Formalization"/>
         *               &lt;enumeration value="CWE_Team"/>
         *               &lt;enumeration value="Software_Customers"/>
         *               &lt;enumeration value="Assessment_Customers"/>
         *               &lt;enumeration value="Academic_Researchers"/>
         *               &lt;enumeration value="Applied_Researchers"/>
         *               &lt;enumeration value="Information_Providers"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="Stakeholder_Description" type="{}Structured_Text_Type" minOccurs="0"/>
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
            "stakeholder",
            "stakeholderDescription"
        })
        public static class Audience {

            @XmlElement(name = "Stakeholder", required = true)
            protected String stakeholder;
            @XmlElement(name = "Stakeholder_Description")
            protected StructuredTextType stakeholderDescription;

            /**
             * Obtient la valeur de la propriété stakeholder.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getStakeholder() {
                return stakeholder;
            }

            /**
             * Définit la valeur de la propriété stakeholder.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setStakeholder(String value) {
                this.stakeholder = value;
            }

            /**
             * Obtient la valeur de la propriété stakeholderDescription.
             * 
             * @return
             *     possible object is
             *     {@link StructuredTextType }
             *     
             */
            public StructuredTextType getStakeholderDescription() {
                return stakeholderDescription;
            }

            /**
             * Définit la valeur de la propriété stakeholderDescription.
             * 
             * @param value
             *     allowed object is
             *     {@link StructuredTextType }
             *     
             */
            public void setStakeholderDescription(StructuredTextType value) {
                this.stakeholderDescription = value;
            }

        }

    }

}
