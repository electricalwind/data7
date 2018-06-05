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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
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
 *         &lt;element name="Submission" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Submitter" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Submitter_Organization" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Submission_Date" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                   &lt;element name="Submission_Comment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="Submission_Source" use="required">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;enumeration value="Externally_Mined"/>
 *                       &lt;enumeration value="NDA"/>
 *                       &lt;enumeration value="Internal_CWE_Team"/>
 *                       &lt;enumeration value="External_Submission"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Contribution" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Contributor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Contribution_Organization" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Contribution_Date" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                   &lt;element name="Contribution_Comment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="Contribution_Mode" use="required">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;enumeration value="Content"/>
 *                       &lt;enumeration value="Feedback"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Modification" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Modifier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Modifier_Organization" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Modification_Date" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                   &lt;element name="Modification_Comment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="Modification_Importance">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;enumeration value="Normal"/>
 *                       &lt;enumeration value="Critical"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *                 &lt;attribute name="Modification_Source" use="required">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;enumeration value="Internal"/>
 *                       &lt;enumeration value="External"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Previous_Entry_Names" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Previous_Entry_Name" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                           &lt;attribute name="Name_Change_Date" use="required" type="{http://www.w3.org/2001/XMLSchema}date" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
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
    "submission",
    "contribution",
    "modification",
    "previousEntryNames"
})
@XmlRootElement(name = "Content_History")
public class ContentHistory {

    @XmlElement(name = "Submission")
    protected List<ContentHistory.Submission> submission;
    @XmlElement(name = "Contribution")
    protected List<ContentHistory.Contribution> contribution;
    @XmlElement(name = "Modification")
    protected List<ContentHistory.Modification> modification;
    @XmlElement(name = "Previous_Entry_Names")
    protected ContentHistory.PreviousEntryNames previousEntryNames;

    /**
     * Gets the value of the submission property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the submission property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubmission().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ContentHistory.Submission }
     * 
     * 
     */
    public List<ContentHistory.Submission> getSubmission() {
        if (submission == null) {
            submission = new ArrayList<ContentHistory.Submission>();
        }
        return this.submission;
    }

    /**
     * Gets the value of the contribution property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contribution property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContribution().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ContentHistory.Contribution }
     * 
     * 
     */
    public List<ContentHistory.Contribution> getContribution() {
        if (contribution == null) {
            contribution = new ArrayList<ContentHistory.Contribution>();
        }
        return this.contribution;
    }

    /**
     * Gets the value of the modification property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the modification property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getModification().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ContentHistory.Modification }
     * 
     * 
     */
    public List<ContentHistory.Modification> getModification() {
        if (modification == null) {
            modification = new ArrayList<ContentHistory.Modification>();
        }
        return this.modification;
    }

    /**
     * Obtient la valeur de la propriété previousEntryNames.
     * 
     * @return
     *     possible object is
     *     {@link ContentHistory.PreviousEntryNames }
     *     
     */
    public ContentHistory.PreviousEntryNames getPreviousEntryNames() {
        return previousEntryNames;
    }

    /**
     * Définit la valeur de la propriété previousEntryNames.
     * 
     * @param value
     *     allowed object is
     *     {@link ContentHistory.PreviousEntryNames }
     *     
     */
    public void setPreviousEntryNames(ContentHistory.PreviousEntryNames value) {
        this.previousEntryNames = value;
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
     *         &lt;element name="Contributor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Contribution_Organization" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Contribution_Date" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *         &lt;element name="Contribution_Comment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *       &lt;/sequence>
     *       &lt;attribute name="Contribution_Mode" use="required">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *             &lt;enumeration value="Content"/>
     *             &lt;enumeration value="Feedback"/>
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
        "contributor",
        "contributionOrganization",
        "contributionDate",
        "contributionComment"
    })
    public static class Contribution {

        @XmlElement(name = "Contributor")
        protected String contributor;
        @XmlElement(name = "Contribution_Organization")
        protected String contributionOrganization;
        @XmlElement(name = "Contribution_Date")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar contributionDate;
        @XmlElement(name = "Contribution_Comment")
        protected String contributionComment;
        @XmlAttribute(name = "Contribution_Mode", required = true)
        protected String contributionMode;

        /**
         * Obtient la valeur de la propriété contributor.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getContributor() {
            return contributor;
        }

        /**
         * Définit la valeur de la propriété contributor.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setContributor(String value) {
            this.contributor = value;
        }

        /**
         * Obtient la valeur de la propriété contributionOrganization.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getContributionOrganization() {
            return contributionOrganization;
        }

        /**
         * Définit la valeur de la propriété contributionOrganization.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setContributionOrganization(String value) {
            this.contributionOrganization = value;
        }

        /**
         * Obtient la valeur de la propriété contributionDate.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getContributionDate() {
            return contributionDate;
        }

        /**
         * Définit la valeur de la propriété contributionDate.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setContributionDate(XMLGregorianCalendar value) {
            this.contributionDate = value;
        }

        /**
         * Obtient la valeur de la propriété contributionComment.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getContributionComment() {
            return contributionComment;
        }

        /**
         * Définit la valeur de la propriété contributionComment.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setContributionComment(String value) {
            this.contributionComment = value;
        }

        /**
         * Obtient la valeur de la propriété contributionMode.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getContributionMode() {
            return contributionMode;
        }

        /**
         * Définit la valeur de la propriété contributionMode.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setContributionMode(String value) {
            this.contributionMode = value;
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
     *         &lt;element name="Modifier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Modifier_Organization" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Modification_Date" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *         &lt;element name="Modification_Comment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *       &lt;/sequence>
     *       &lt;attribute name="Modification_Importance">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *             &lt;enumeration value="Normal"/>
     *             &lt;enumeration value="Critical"/>
     *           &lt;/restriction>
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *       &lt;attribute name="Modification_Source" use="required">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *             &lt;enumeration value="Internal"/>
     *             &lt;enumeration value="External"/>
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
        "modifier",
        "modifierOrganization",
        "modificationDate",
        "modificationComment"
    })
    public static class Modification {

        @XmlElement(name = "Modifier")
        protected String modifier;
        @XmlElement(name = "Modifier_Organization")
        protected String modifierOrganization;
        @XmlElement(name = "Modification_Date")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar modificationDate;
        @XmlElement(name = "Modification_Comment")
        protected String modificationComment;
        @XmlAttribute(name = "Modification_Importance")
        protected String modificationImportance;
        @XmlAttribute(name = "Modification_Source", required = true)
        protected String modificationSource;

        /**
         * Obtient la valeur de la propriété modifier.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getModifier() {
            return modifier;
        }

        /**
         * Définit la valeur de la propriété modifier.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setModifier(String value) {
            this.modifier = value;
        }

        /**
         * Obtient la valeur de la propriété modifierOrganization.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getModifierOrganization() {
            return modifierOrganization;
        }

        /**
         * Définit la valeur de la propriété modifierOrganization.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setModifierOrganization(String value) {
            this.modifierOrganization = value;
        }

        /**
         * Obtient la valeur de la propriété modificationDate.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getModificationDate() {
            return modificationDate;
        }

        /**
         * Définit la valeur de la propriété modificationDate.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setModificationDate(XMLGregorianCalendar value) {
            this.modificationDate = value;
        }

        /**
         * Obtient la valeur de la propriété modificationComment.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getModificationComment() {
            return modificationComment;
        }

        /**
         * Définit la valeur de la propriété modificationComment.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setModificationComment(String value) {
            this.modificationComment = value;
        }

        /**
         * Obtient la valeur de la propriété modificationImportance.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getModificationImportance() {
            return modificationImportance;
        }

        /**
         * Définit la valeur de la propriété modificationImportance.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setModificationImportance(String value) {
            this.modificationImportance = value;
        }

        /**
         * Obtient la valeur de la propriété modificationSource.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getModificationSource() {
            return modificationSource;
        }

        /**
         * Définit la valeur de la propriété modificationSource.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setModificationSource(String value) {
            this.modificationSource = value;
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
     *         &lt;element name="Previous_Entry_Name" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="Name_Change_Date" use="required" type="{http://www.w3.org/2001/XMLSchema}date" />
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
        "previousEntryName"
    })
    public static class PreviousEntryNames {

        @XmlElement(name = "Previous_Entry_Name", required = true)
        protected List<ContentHistory.PreviousEntryNames.PreviousEntryName> previousEntryName;

        /**
         * Gets the value of the previousEntryName property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the previousEntryName property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPreviousEntryName().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ContentHistory.PreviousEntryNames.PreviousEntryName }
         * 
         * 
         */
        public List<ContentHistory.PreviousEntryNames.PreviousEntryName> getPreviousEntryName() {
            if (previousEntryName == null) {
                previousEntryName = new ArrayList<ContentHistory.PreviousEntryNames.PreviousEntryName>();
            }
            return this.previousEntryName;
        }


        /**
         * <p>Classe Java pour anonymous complex type.
         * 
         * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *       &lt;attribute name="Name_Change_Date" use="required" type="{http://www.w3.org/2001/XMLSchema}date" />
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
        public static class PreviousEntryName {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "Name_Change_Date", required = true)
            @XmlSchemaType(name = "date")
            protected XMLGregorianCalendar nameChangeDate;

            /**
             * Obtient la valeur de la propriété value.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Définit la valeur de la propriété value.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * Obtient la valeur de la propriété nameChangeDate.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getNameChangeDate() {
                return nameChangeDate;
            }

            /**
             * Définit la valeur de la propriété nameChangeDate.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setNameChangeDate(XMLGregorianCalendar value) {
                this.nameChangeDate = value;
            }

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
     *         &lt;element name="Submitter" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Submitter_Organization" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Submission_Date" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *         &lt;element name="Submission_Comment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *       &lt;/sequence>
     *       &lt;attribute name="Submission_Source" use="required">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *             &lt;enumeration value="Externally_Mined"/>
     *             &lt;enumeration value="NDA"/>
     *             &lt;enumeration value="Internal_CWE_Team"/>
     *             &lt;enumeration value="External_Submission"/>
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
        "submitter",
        "submitterOrganization",
        "submissionDate",
        "submissionComment"
    })
    public static class Submission {

        @XmlElement(name = "Submitter")
        protected String submitter;
        @XmlElement(name = "Submitter_Organization")
        protected String submitterOrganization;
        @XmlElement(name = "Submission_Date")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar submissionDate;
        @XmlElement(name = "Submission_Comment")
        protected String submissionComment;
        @XmlAttribute(name = "Submission_Source", required = true)
        protected String submissionSource;

        /**
         * Obtient la valeur de la propriété submitter.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSubmitter() {
            return submitter;
        }

        /**
         * Définit la valeur de la propriété submitter.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSubmitter(String value) {
            this.submitter = value;
        }

        /**
         * Obtient la valeur de la propriété submitterOrganization.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSubmitterOrganization() {
            return submitterOrganization;
        }

        /**
         * Définit la valeur de la propriété submitterOrganization.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSubmitterOrganization(String value) {
            this.submitterOrganization = value;
        }

        /**
         * Obtient la valeur de la propriété submissionDate.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getSubmissionDate() {
            return submissionDate;
        }

        /**
         * Définit la valeur de la propriété submissionDate.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setSubmissionDate(XMLGregorianCalendar value) {
            this.submissionDate = value;
        }

        /**
         * Obtient la valeur de la propriété submissionComment.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSubmissionComment() {
            return submissionComment;
        }

        /**
         * Définit la valeur de la propriété submissionComment.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSubmissionComment(String value) {
            this.submissionComment = value;
        }

        /**
         * Obtient la valeur de la propriété submissionSource.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSubmissionSource() {
            return submissionSource;
        }

        /**
         * Définit la valeur de la propriété submissionSource.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSubmissionSource(String value) {
            this.submissionSource = value;
        }

    }

}
