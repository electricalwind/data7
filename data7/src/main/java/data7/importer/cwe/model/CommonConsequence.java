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

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


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
 *         &lt;element name="Consequence_Scope" maxOccurs="unbounded" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Confidentiality"/>
 *               &lt;enumeration value="Integrity"/>
 *               &lt;enumeration value="Availability"/>
 *               &lt;enumeration value="Access_Control"/>
 *               &lt;enumeration value="Non-Repudiation"/>
 *               &lt;enumeration value="Accountability"/>
 *               &lt;enumeration value="Authentication"/>
 *               &lt;enumeration value="Authorization"/>
 *               &lt;enumeration value="Non-Repudiation"/>
 *               &lt;enumeration value="Other"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Consequence_Technical_Impact" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;>Impact_Type">
 *                 &lt;attribute name="Likelihood">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;enumeration value="Low"/>
 *                       &lt;enumeration value="Medium"/>
 *                       &lt;enumeration value="High"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Consequence_Note" type="{}Structured_Text_Type" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Common_Consequence_ID" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "consequenceScope",
    "consequenceTechnicalImpact",
    "consequenceNote"
})
@XmlRootElement(name = "Common_Consequence")
public class CommonConsequence {

    @XmlElement(name = "Consequence_Scope")
    protected List<String> consequenceScope;
    @XmlElement(name = "Consequence_Technical_Impact")
    protected List<CommonConsequence.ConsequenceTechnicalImpact> consequenceTechnicalImpact;
    @XmlElement(name = "Consequence_Note")
    protected StructuredTextType consequenceNote;
    @XmlAttribute(name = "Common_Consequence_ID")
    protected String commonConsequenceID;

    /**
     * Gets the value of the consequenceScope property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the consequenceScope property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConsequenceScope().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getConsequenceScope() {
        if (consequenceScope == null) {
            consequenceScope = new ArrayList<String>();
        }
        return this.consequenceScope;
    }

    /**
     * Gets the value of the consequenceTechnicalImpact property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the consequenceTechnicalImpact property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConsequenceTechnicalImpact().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CommonConsequence.ConsequenceTechnicalImpact }
     * 
     * 
     */
    public List<CommonConsequence.ConsequenceTechnicalImpact> getConsequenceTechnicalImpact() {
        if (consequenceTechnicalImpact == null) {
            consequenceTechnicalImpact = new ArrayList<CommonConsequence.ConsequenceTechnicalImpact>();
        }
        return this.consequenceTechnicalImpact;
    }

    /**
     * Obtient la valeur de la propriété consequenceNote.
     * 
     * @return
     *     possible object is
     *     {@link StructuredTextType }
     *     
     */
    public StructuredTextType getConsequenceNote() {
        return consequenceNote;
    }

    /**
     * Définit la valeur de la propriété consequenceNote.
     * 
     * @param value
     *     allowed object is
     *     {@link StructuredTextType }
     *     
     */
    public void setConsequenceNote(StructuredTextType value) {
        this.consequenceNote = value;
    }

    /**
     * Obtient la valeur de la propriété commonConsequenceID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommonConsequenceID() {
        return commonConsequenceID;
    }

    /**
     * Définit la valeur de la propriété commonConsequenceID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommonConsequenceID(String value) {
        this.commonConsequenceID = value;
    }


    /**
     * <p>Classe Java pour anonymous complex type.
     * 
     * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;>Impact_Type">
     *       &lt;attribute name="Likelihood">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *             &lt;enumeration value="Low"/>
     *             &lt;enumeration value="Medium"/>
     *             &lt;enumeration value="High"/>
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
    public static class ConsequenceTechnicalImpact {

        @XmlValue
        protected ImpactType value;
        @XmlAttribute(name = "Likelihood")
        protected String likelihood;

        /**
         * Obtient la valeur de la propriété value.
         * 
         * @return
         *     possible object is
         *     {@link ImpactType }
         *     
         */
        public ImpactType getValue() {
            return value;
        }

        /**
         * Définit la valeur de la propriété value.
         * 
         * @param value
         *     allowed object is
         *     {@link ImpactType }
         *     
         */
        public void setValue(ImpactType value) {
            this.value = value;
        }

        /**
         * Obtient la valeur de la propriété likelihood.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLikelihood() {
            return likelihood;
        }

        /**
         * Définit la valeur de la propriété likelihood.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLikelihood(String value) {
            this.likelihood = value;
        }

    }

}
