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

import java.math.BigInteger;
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
 *       &lt;group ref="{}Common_Attributes"/>
 *       &lt;attribute name="ID" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="Name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Compound_Element_Abstraction" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="Class"/>
 *             &lt;enumeration value="Base"/>
 *             &lt;enumeration value="Variant"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="Compound_Element_Structure" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="Composite"/>
 *             &lt;enumeration value="Chain"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
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
    "description",
    "relationships",
    "relationshipNotes",
    "weaknessOrdinalities",
    "applicablePlatforms",
    "maintenanceNotes",
    "backgroundDetails",
    "otherNotes",
    "alternateTerms",
    "terminologyNotes",
    "timeOfIntroduction",
    "modesOfIntroduction",
    "enablingFactorsForExploitation",
    "likelihoodOfExploit",
    "commonConsequences",
    "detectionMethods",
    "potentialMitigations",
    "causalNature",
    "demonstrativeExamples",
    "observedExamples",
    "theoreticalNotes",
    "functionalAreas",
    "relevantProperties",
    "affectedResources",
    "researchGaps",
    "references",
    "taxonomyMappings",
    "whiteBoxDefinitions",
    "blackBoxDefinitions",
    "relatedAttackPatterns",
    "contentHistory"
})
@XmlRootElement(name = "Compound_Element")
public class CompoundElement {

    @XmlElement(name = "Description", required = true)
    protected data7.importer.cwe.model.Category.Description description;
    @XmlElement(name = "Relationships")
    protected Relationships relationships;
    @XmlElement(name = "Relationship_Notes")
    protected RelationshipNotes relationshipNotes;
    @XmlElement(name = "Weakness_Ordinalities")
    protected data7.importer.cwe.model.Category.WeaknessOrdinalities weaknessOrdinalities;
    @XmlElement(name = "Applicable_Platforms")
    protected data7.importer.cwe.model.Category.ApplicablePlatforms applicablePlatforms;
    @XmlElement(name = "Maintenance_Notes")
    protected MaintenanceNotes maintenanceNotes;
    @XmlElement(name = "Background_Details")
    protected data7.importer.cwe.model.Category.BackgroundDetails backgroundDetails;
    @XmlElement(name = "Other_Notes")
    protected OtherNotes otherNotes;
    @XmlElement(name = "Alternate_Terms")
    protected AlternateTerms alternateTerms;
    @XmlElement(name = "Terminology_Notes")
    protected data7.importer.cwe.model.Category.TerminologyNotes terminologyNotes;
    @XmlElement(name = "Time_of_Introduction")
    protected data7.importer.cwe.model.Category.TimeOfIntroduction timeOfIntroduction;
    @XmlElement(name = "Modes_of_Introduction")
    protected data7.importer.cwe.model.Category.ModesOfIntroduction modesOfIntroduction;
    @XmlElement(name = "Enabling_Factors_for_Exploitation")
    protected data7.importer.cwe.model.Category.EnablingFactorsForExploitation enablingFactorsForExploitation;
    @XmlElement(name = "Likelihood_of_Exploit")
    protected String likelihoodOfExploit;
    @XmlElement(name = "Common_Consequences")
    protected data7.importer.cwe.model.Category.CommonConsequences commonConsequences;
    @XmlElement(name = "Detection_Methods")
    protected data7.importer.cwe.model.Category.DetectionMethods detectionMethods;
    @XmlElement(name = "Potential_Mitigations")
    protected data7.importer.cwe.model.Category.PotentialMitigations potentialMitigations;
    @XmlElement(name = "Causal_Nature")
    protected String causalNature;
    @XmlElement(name = "Demonstrative_Examples")
    protected data7.importer.cwe.model.Category.DemonstrativeExamples demonstrativeExamples;
    @XmlElement(name = "Observed_Examples")
    protected data7.importer.cwe.model.Category.ObservedExamples observedExamples;
    @XmlElement(name = "Theoretical_Notes")
    protected data7.importer.cwe.model.Category.TheoreticalNotes theoreticalNotes;
    @XmlElement(name = "Functional_Areas")
    protected data7.importer.cwe.model.Category.FunctionalAreas functionalAreas;
    @XmlElement(name = "Relevant_Properties")
    protected data7.importer.cwe.model.Category.RelevantProperties relevantProperties;
    @XmlElement(name = "Affected_Resources")
    protected data7.importer.cwe.model.Category.AffectedResources affectedResources;
    @XmlElement(name = "Research_Gaps")
    protected ResearchGaps researchGaps;
    @XmlElement(name = "References")
    protected ReferenceListType references;
    @XmlElement(name = "Taxonomy_Mappings")
    protected data7.importer.cwe.model.Category.TaxonomyMappings taxonomyMappings;
    @XmlElement(name = "White_Box_Definitions")
    protected data7.importer.cwe.model.Category.WhiteBoxDefinitions whiteBoxDefinitions;
    @XmlElement(name = "Black_Box_Definitions")
    protected data7.importer.cwe.model.Category.BlackBoxDefinitions blackBoxDefinitions;
    @XmlElement(name = "Related_Attack_Patterns")
    protected data7.importer.cwe.model.Category.RelatedAttackPatterns relatedAttackPatterns;
    @XmlElement(name = "Content_History", required = true)
    protected ContentHistory contentHistory;
    @XmlAttribute(name = "ID", required = true)
    protected BigInteger id;
    @XmlAttribute(name = "Name", required = true)
    protected String name;
    @XmlAttribute(name = "Compound_Element_Abstraction", required = true)
    protected String compoundElementAbstraction;
    @XmlAttribute(name = "Compound_Element_Structure", required = true)
    protected String compoundElementStructure;
    @XmlAttribute(name = "Status", required = true)
    protected StatusType status;

    /**
     * Obtient la valeur de la propriété description.
     * 
     * @return
     *     possible object is
     *     {@link data7.importer.cwe.model.Category.Description }
     *     
     */
    public data7.importer.cwe.model.Category.Description getDescription() {
        return description;
    }

    /**
     * Définit la valeur de la propriété description.
     * 
     * @param value
     *     allowed object is
     *     {@link data7.importer.cwe.model.Category.Description }
     *     
     */
    public void setDescription(data7.importer.cwe.model.Category.Description value) {
        this.description = value;
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
     * Obtient la valeur de la propriété weaknessOrdinalities.
     * 
     * @return
     *     possible object is
     *     {@link data7.importer.cwe.model.Category.WeaknessOrdinalities }
     *     
     */
    public data7.importer.cwe.model.Category.WeaknessOrdinalities getWeaknessOrdinalities() {
        return weaknessOrdinalities;
    }

    /**
     * Définit la valeur de la propriété weaknessOrdinalities.
     * 
     * @param value
     *     allowed object is
     *     {@link data7.importer.cwe.model.Category.WeaknessOrdinalities }
     *     
     */
    public void setWeaknessOrdinalities(data7.importer.cwe.model.Category.WeaknessOrdinalities value) {
        this.weaknessOrdinalities = value;
    }

    /**
     * Obtient la valeur de la propriété applicablePlatforms.
     * 
     * @return
     *     possible object is
     *     {@link data7.importer.cwe.model.Category.ApplicablePlatforms }
     *     
     */
    public data7.importer.cwe.model.Category.ApplicablePlatforms getApplicablePlatforms() {
        return applicablePlatforms;
    }

    /**
     * Définit la valeur de la propriété applicablePlatforms.
     * 
     * @param value
     *     allowed object is
     *     {@link data7.importer.cwe.model.Category.ApplicablePlatforms }
     *     
     */
    public void setApplicablePlatforms(data7.importer.cwe.model.Category.ApplicablePlatforms value) {
        this.applicablePlatforms = value;
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
     * Obtient la valeur de la propriété backgroundDetails.
     * 
     * @return
     *     possible object is
     *     {@link data7.importer.cwe.model.Category.BackgroundDetails }
     *     
     */
    public data7.importer.cwe.model.Category.BackgroundDetails getBackgroundDetails() {
        return backgroundDetails;
    }

    /**
     * Définit la valeur de la propriété backgroundDetails.
     * 
     * @param value
     *     allowed object is
     *     {@link data7.importer.cwe.model.Category.BackgroundDetails }
     *     
     */
    public void setBackgroundDetails(data7.importer.cwe.model.Category.BackgroundDetails value) {
        this.backgroundDetails = value;
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
     * Obtient la valeur de la propriété terminologyNotes.
     * 
     * @return
     *     possible object is
     *     {@link data7.importer.cwe.model.Category.TerminologyNotes }
     *     
     */
    public data7.importer.cwe.model.Category.TerminologyNotes getTerminologyNotes() {
        return terminologyNotes;
    }

    /**
     * Définit la valeur de la propriété terminologyNotes.
     * 
     * @param value
     *     allowed object is
     *     {@link data7.importer.cwe.model.Category.TerminologyNotes }
     *     
     */
    public void setTerminologyNotes(data7.importer.cwe.model.Category.TerminologyNotes value) {
        this.terminologyNotes = value;
    }

    /**
     * Obtient la valeur de la propriété timeOfIntroduction.
     * 
     * @return
     *     possible object is
     *     {@link data7.importer.cwe.model.Category.TimeOfIntroduction }
     *     
     */
    public data7.importer.cwe.model.Category.TimeOfIntroduction getTimeOfIntroduction() {
        return timeOfIntroduction;
    }

    /**
     * Définit la valeur de la propriété timeOfIntroduction.
     * 
     * @param value
     *     allowed object is
     *     {@link data7.importer.cwe.model.Category.TimeOfIntroduction }
     *     
     */
    public void setTimeOfIntroduction(data7.importer.cwe.model.Category.TimeOfIntroduction value) {
        this.timeOfIntroduction = value;
    }

    /**
     * Obtient la valeur de la propriété modesOfIntroduction.
     * 
     * @return
     *     possible object is
     *     {@link data7.importer.cwe.model.Category.ModesOfIntroduction }
     *     
     */
    public data7.importer.cwe.model.Category.ModesOfIntroduction getModesOfIntroduction() {
        return modesOfIntroduction;
    }

    /**
     * Définit la valeur de la propriété modesOfIntroduction.
     * 
     * @param value
     *     allowed object is
     *     {@link data7.importer.cwe.model.Category.ModesOfIntroduction }
     *     
     */
    public void setModesOfIntroduction(data7.importer.cwe.model.Category.ModesOfIntroduction value) {
        this.modesOfIntroduction = value;
    }

    /**
     * Obtient la valeur de la propriété enablingFactorsForExploitation.
     * 
     * @return
     *     possible object is
     *     {@link data7.importer.cwe.model.Category.EnablingFactorsForExploitation }
     *     
     */
    public data7.importer.cwe.model.Category.EnablingFactorsForExploitation getEnablingFactorsForExploitation() {
        return enablingFactorsForExploitation;
    }

    /**
     * Définit la valeur de la propriété enablingFactorsForExploitation.
     * 
     * @param value
     *     allowed object is
     *     {@link data7.importer.cwe.model.Category.EnablingFactorsForExploitation }
     *     
     */
    public void setEnablingFactorsForExploitation(data7.importer.cwe.model.Category.EnablingFactorsForExploitation value) {
        this.enablingFactorsForExploitation = value;
    }

    /**
     * Obtient la valeur de la propriété likelihoodOfExploit.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLikelihoodOfExploit() {
        return likelihoodOfExploit;
    }

    /**
     * Définit la valeur de la propriété likelihoodOfExploit.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLikelihoodOfExploit(String value) {
        this.likelihoodOfExploit = value;
    }

    /**
     * Obtient la valeur de la propriété commonConsequences.
     * 
     * @return
     *     possible object is
     *     {@link data7.importer.cwe.model.Category.CommonConsequences }
     *     
     */
    public data7.importer.cwe.model.Category.CommonConsequences getCommonConsequences() {
        return commonConsequences;
    }

    /**
     * Définit la valeur de la propriété commonConsequences.
     * 
     * @param value
     *     allowed object is
     *     {@link data7.importer.cwe.model.Category.CommonConsequences }
     *     
     */
    public void setCommonConsequences(data7.importer.cwe.model.Category.CommonConsequences value) {
        this.commonConsequences = value;
    }

    /**
     * Obtient la valeur de la propriété detectionMethods.
     * 
     * @return
     *     possible object is
     *     {@link data7.importer.cwe.model.Category.DetectionMethods }
     *     
     */
    public data7.importer.cwe.model.Category.DetectionMethods getDetectionMethods() {
        return detectionMethods;
    }

    /**
     * Définit la valeur de la propriété detectionMethods.
     * 
     * @param value
     *     allowed object is
     *     {@link data7.importer.cwe.model.Category.DetectionMethods }
     *     
     */
    public void setDetectionMethods(data7.importer.cwe.model.Category.DetectionMethods value) {
        this.detectionMethods = value;
    }

    /**
     * Obtient la valeur de la propriété potentialMitigations.
     * 
     * @return
     *     possible object is
     *     {@link data7.importer.cwe.model.Category.PotentialMitigations }
     *     
     */
    public data7.importer.cwe.model.Category.PotentialMitigations getPotentialMitigations() {
        return potentialMitigations;
    }

    /**
     * Définit la valeur de la propriété potentialMitigations.
     * 
     * @param value
     *     allowed object is
     *     {@link data7.importer.cwe.model.Category.PotentialMitigations }
     *     
     */
    public void setPotentialMitigations(data7.importer.cwe.model.Category.PotentialMitigations value) {
        this.potentialMitigations = value;
    }

    /**
     * Obtient la valeur de la propriété causalNature.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCausalNature() {
        return causalNature;
    }

    /**
     * Définit la valeur de la propriété causalNature.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCausalNature(String value) {
        this.causalNature = value;
    }

    /**
     * Obtient la valeur de la propriété demonstrativeExamples.
     * 
     * @return
     *     possible object is
     *     {@link data7.importer.cwe.model.Category.DemonstrativeExamples }
     *     
     */
    public data7.importer.cwe.model.Category.DemonstrativeExamples getDemonstrativeExamples() {
        return demonstrativeExamples;
    }

    /**
     * Définit la valeur de la propriété demonstrativeExamples.
     * 
     * @param value
     *     allowed object is
     *     {@link data7.importer.cwe.model.Category.DemonstrativeExamples }
     *     
     */
    public void setDemonstrativeExamples(data7.importer.cwe.model.Category.DemonstrativeExamples value) {
        this.demonstrativeExamples = value;
    }

    /**
     * Obtient la valeur de la propriété observedExamples.
     * 
     * @return
     *     possible object is
     *     {@link data7.importer.cwe.model.Category.ObservedExamples }
     *     
     */
    public data7.importer.cwe.model.Category.ObservedExamples getObservedExamples() {
        return observedExamples;
    }

    /**
     * Définit la valeur de la propriété observedExamples.
     * 
     * @param value
     *     allowed object is
     *     {@link data7.importer.cwe.model.Category.ObservedExamples }
     *     
     */
    public void setObservedExamples(data7.importer.cwe.model.Category.ObservedExamples value) {
        this.observedExamples = value;
    }

    /**
     * Obtient la valeur de la propriété theoreticalNotes.
     * 
     * @return
     *     possible object is
     *     {@link data7.importer.cwe.model.Category.TheoreticalNotes }
     *     
     */
    public data7.importer.cwe.model.Category.TheoreticalNotes getTheoreticalNotes() {
        return theoreticalNotes;
    }

    /**
     * Définit la valeur de la propriété theoreticalNotes.
     * 
     * @param value
     *     allowed object is
     *     {@link data7.importer.cwe.model.Category.TheoreticalNotes }
     *     
     */
    public void setTheoreticalNotes(data7.importer.cwe.model.Category.TheoreticalNotes value) {
        this.theoreticalNotes = value;
    }

    /**
     * Obtient la valeur de la propriété functionalAreas.
     * 
     * @return
     *     possible object is
     *     {@link data7.importer.cwe.model.Category.FunctionalAreas }
     *     
     */
    public data7.importer.cwe.model.Category.FunctionalAreas getFunctionalAreas() {
        return functionalAreas;
    }

    /**
     * Définit la valeur de la propriété functionalAreas.
     * 
     * @param value
     *     allowed object is
     *     {@link data7.importer.cwe.model.Category.FunctionalAreas }
     *     
     */
    public void setFunctionalAreas(data7.importer.cwe.model.Category.FunctionalAreas value) {
        this.functionalAreas = value;
    }

    /**
     * Obtient la valeur de la propriété relevantProperties.
     * 
     * @return
     *     possible object is
     *     {@link data7.importer.cwe.model.Category.RelevantProperties }
     *     
     */
    public data7.importer.cwe.model.Category.RelevantProperties getRelevantProperties() {
        return relevantProperties;
    }

    /**
     * Définit la valeur de la propriété relevantProperties.
     * 
     * @param value
     *     allowed object is
     *     {@link data7.importer.cwe.model.Category.RelevantProperties }
     *     
     */
    public void setRelevantProperties(data7.importer.cwe.model.Category.RelevantProperties value) {
        this.relevantProperties = value;
    }

    /**
     * Obtient la valeur de la propriété affectedResources.
     * 
     * @return
     *     possible object is
     *     {@link data7.importer.cwe.model.Category.AffectedResources }
     *     
     */
    public data7.importer.cwe.model.Category.AffectedResources getAffectedResources() {
        return affectedResources;
    }

    /**
     * Définit la valeur de la propriété affectedResources.
     * 
     * @param value
     *     allowed object is
     *     {@link data7.importer.cwe.model.Category.AffectedResources }
     *     
     */
    public void setAffectedResources(data7.importer.cwe.model.Category.AffectedResources value) {
        this.affectedResources = value;
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
     * Obtient la valeur de la propriété taxonomyMappings.
     * 
     * @return
     *     possible object is
     *     {@link data7.importer.cwe.model.Category.TaxonomyMappings }
     *     
     */
    public data7.importer.cwe.model.Category.TaxonomyMappings getTaxonomyMappings() {
        return taxonomyMappings;
    }

    /**
     * Définit la valeur de la propriété taxonomyMappings.
     * 
     * @param value
     *     allowed object is
     *     {@link data7.importer.cwe.model.Category.TaxonomyMappings }
     *     
     */
    public void setTaxonomyMappings(data7.importer.cwe.model.Category.TaxonomyMappings value) {
        this.taxonomyMappings = value;
    }

    /**
     * Obtient la valeur de la propriété whiteBoxDefinitions.
     * 
     * @return
     *     possible object is
     *     {@link data7.importer.cwe.model.Category.WhiteBoxDefinitions }
     *     
     */
    public data7.importer.cwe.model.Category.WhiteBoxDefinitions getWhiteBoxDefinitions() {
        return whiteBoxDefinitions;
    }

    /**
     * Définit la valeur de la propriété whiteBoxDefinitions.
     * 
     * @param value
     *     allowed object is
     *     {@link data7.importer.cwe.model.Category.WhiteBoxDefinitions }
     *     
     */
    public void setWhiteBoxDefinitions(data7.importer.cwe.model.Category.WhiteBoxDefinitions value) {
        this.whiteBoxDefinitions = value;
    }

    /**
     * Obtient la valeur de la propriété blackBoxDefinitions.
     * 
     * @return
     *     possible object is
     *     {@link data7.importer.cwe.model.Category.BlackBoxDefinitions }
     *     
     */
    public data7.importer.cwe.model.Category.BlackBoxDefinitions getBlackBoxDefinitions() {
        return blackBoxDefinitions;
    }

    /**
     * Définit la valeur de la propriété blackBoxDefinitions.
     * 
     * @param value
     *     allowed object is
     *     {@link data7.importer.cwe.model.Category.BlackBoxDefinitions }
     *     
     */
    public void setBlackBoxDefinitions(data7.importer.cwe.model.Category.BlackBoxDefinitions value) {
        this.blackBoxDefinitions = value;
    }

    /**
     * Obtient la valeur de la propriété relatedAttackPatterns.
     * 
     * @return
     *     possible object is
     *     {@link data7.importer.cwe.model.Category.RelatedAttackPatterns }
     *     
     */
    public data7.importer.cwe.model.Category.RelatedAttackPatterns getRelatedAttackPatterns() {
        return relatedAttackPatterns;
    }

    /**
     * Définit la valeur de la propriété relatedAttackPatterns.
     * 
     * @param value
     *     allowed object is
     *     {@link data7.importer.cwe.model.Category.RelatedAttackPatterns }
     *     
     */
    public void setRelatedAttackPatterns(data7.importer.cwe.model.Category.RelatedAttackPatterns value) {
        this.relatedAttackPatterns = value;
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
     * Obtient la valeur de la propriété compoundElementAbstraction.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompoundElementAbstraction() {
        return compoundElementAbstraction;
    }

    /**
     * Définit la valeur de la propriété compoundElementAbstraction.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompoundElementAbstraction(String value) {
        this.compoundElementAbstraction = value;
    }

    /**
     * Obtient la valeur de la propriété compoundElementStructure.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompoundElementStructure() {
        return compoundElementStructure;
    }

    /**
     * Définit la valeur de la propriété compoundElementStructure.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompoundElementStructure(String value) {
        this.compoundElementStructure = value;
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

}
