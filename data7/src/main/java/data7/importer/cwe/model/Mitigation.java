package data7.importer.cwe.model;

/*-
 * #%L
 * Data7
 * %%
 * Copyright (C) 2018 Matthieu Jimenez
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
 *         &lt;element name="Mitigation_Phase" type="{}SDLC_Phase_Type" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Mitigation_Strategy" maxOccurs="unbounded" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;whiteSpace value="collapse"/>
 *               &lt;enumeration value="Compilation or Build Hardening"/>
 *               &lt;enumeration value="Enforcement by Conversion"/>
 *               &lt;enumeration value="Environment Hardening"/>
 *               &lt;enumeration value="Firewall"/>
 *               &lt;enumeration value="Identify and Reduce Attack Surface"/>
 *               &lt;enumeration value="Input Validation"/>
 *               &lt;enumeration value="Language Selection"/>
 *               &lt;enumeration value="Libraries or Frameworks"/>
 *               &lt;enumeration value="Limit Resource Consumption"/>
 *               &lt;enumeration value="Output Encoding"/>
 *               &lt;enumeration value="Parameterization"/>
 *               &lt;enumeration value="Refactoring"/>
 *               &lt;enumeration value="Sandbox or Jail"/>
 *               &lt;enumeration value="Separation of Privilege"/>
 *               &lt;enumeration value="Threat Modeling"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Applicable_Languages" type="{}Languages_List_Type" minOccurs="0"/>
 *         &lt;element name="Mitigation_Description" type="{}Structured_Text_Type" minOccurs="0"/>
 *         &lt;element name="Mitigation_Effectiveness" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="None"/>
 *               &lt;enumeration value="Defense in Depth"/>
 *               &lt;enumeration value="Limited"/>
 *               &lt;enumeration value="Incidental"/>
 *               &lt;enumeration value="Moderate"/>
 *               &lt;enumeration value="High"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Mitigation_Effectiveness_Notes" type="{}Structured_Text_Type" minOccurs="0"/>
 *         &lt;element name="SubMitigations" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{}Mitigation" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="References" type="{}Reference_List_Type" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Mitigation_ID" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "mitigationPhase",
    "mitigationStrategy",
    "applicableLanguages",
    "mitigationDescription",
    "mitigationEffectiveness",
    "mitigationEffectivenessNotes",
    "subMitigations",
    "references"
})
@XmlRootElement(name = "Mitigation")
public class Mitigation {

    @XmlElement(name = "Mitigation_Phase")
    @XmlSchemaType(name = "string")
    protected List<SDLCPhaseType> mitigationPhase;
    @XmlElement(name = "Mitigation_Strategy")
    protected List<String> mitigationStrategy;
    @XmlElement(name = "Applicable_Languages")
    protected LanguagesListType applicableLanguages;
    @XmlElement(name = "Mitigation_Description")
    protected StructuredTextType mitigationDescription;
    @XmlElement(name = "Mitigation_Effectiveness")
    protected String mitigationEffectiveness;
    @XmlElement(name = "Mitigation_Effectiveness_Notes")
    protected StructuredTextType mitigationEffectivenessNotes;
    @XmlElement(name = "SubMitigations")
    protected Mitigation.SubMitigations subMitigations;
    @XmlElement(name = "References")
    protected ReferenceListType references;
    @XmlAttribute(name = "Mitigation_ID")
    protected String mitigationID;

    /**
     * Gets the value of the mitigationPhase property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mitigationPhase property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMitigationPhase().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SDLCPhaseType }
     * 
     * 
     */
    public List<SDLCPhaseType> getMitigationPhase() {
        if (mitigationPhase == null) {
            mitigationPhase = new ArrayList<SDLCPhaseType>();
        }
        return this.mitigationPhase;
    }

    /**
     * Gets the value of the mitigationStrategy property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mitigationStrategy property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMitigationStrategy().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getMitigationStrategy() {
        if (mitigationStrategy == null) {
            mitigationStrategy = new ArrayList<String>();
        }
        return this.mitigationStrategy;
    }

    /**
     * Obtient la valeur de la propriété applicableLanguages.
     * 
     * @return
     *     possible object is
     *     {@link LanguagesListType }
     *     
     */
    public LanguagesListType getApplicableLanguages() {
        return applicableLanguages;
    }

    /**
     * Définit la valeur de la propriété applicableLanguages.
     * 
     * @param value
     *     allowed object is
     *     {@link LanguagesListType }
     *     
     */
    public void setApplicableLanguages(LanguagesListType value) {
        this.applicableLanguages = value;
    }

    /**
     * Obtient la valeur de la propriété mitigationDescription.
     * 
     * @return
     *     possible object is
     *     {@link StructuredTextType }
     *     
     */
    public StructuredTextType getMitigationDescription() {
        return mitigationDescription;
    }

    /**
     * Définit la valeur de la propriété mitigationDescription.
     * 
     * @param value
     *     allowed object is
     *     {@link StructuredTextType }
     *     
     */
    public void setMitigationDescription(StructuredTextType value) {
        this.mitigationDescription = value;
    }

    /**
     * Obtient la valeur de la propriété mitigationEffectiveness.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMitigationEffectiveness() {
        return mitigationEffectiveness;
    }

    /**
     * Définit la valeur de la propriété mitigationEffectiveness.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMitigationEffectiveness(String value) {
        this.mitigationEffectiveness = value;
    }

    /**
     * Obtient la valeur de la propriété mitigationEffectivenessNotes.
     * 
     * @return
     *     possible object is
     *     {@link StructuredTextType }
     *     
     */
    public StructuredTextType getMitigationEffectivenessNotes() {
        return mitigationEffectivenessNotes;
    }

    /**
     * Définit la valeur de la propriété mitigationEffectivenessNotes.
     * 
     * @param value
     *     allowed object is
     *     {@link StructuredTextType }
     *     
     */
    public void setMitigationEffectivenessNotes(StructuredTextType value) {
        this.mitigationEffectivenessNotes = value;
    }

    /**
     * Obtient la valeur de la propriété subMitigations.
     * 
     * @return
     *     possible object is
     *     {@link Mitigation.SubMitigations }
     *     
     */
    public Mitigation.SubMitigations getSubMitigations() {
        return subMitigations;
    }

    /**
     * Définit la valeur de la propriété subMitigations.
     * 
     * @param value
     *     allowed object is
     *     {@link Mitigation.SubMitigations }
     *     
     */
    public void setSubMitigations(Mitigation.SubMitigations value) {
        this.subMitigations = value;
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
     * Obtient la valeur de la propriété mitigationID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMitigationID() {
        return mitigationID;
    }

    /**
     * Définit la valeur de la propriété mitigationID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMitigationID(String value) {
        this.mitigationID = value;
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
     *         &lt;element ref="{}Mitigation" maxOccurs="unbounded"/>
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
        "mitigation"
    })
    public static class SubMitigations {

        @XmlElement(name = "Mitigation", required = true)
        protected List<Mitigation> mitigation;

        /**
         * Gets the value of the mitigation property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the mitigation property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMitigation().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Mitigation }
         * 
         * 
         */
        public List<Mitigation> getMitigation() {
            if (mitigation == null) {
                mitigation = new ArrayList<Mitigation>();
            }
            return this.mitigation;
        }

    }

}
