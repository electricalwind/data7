package data7.importer.cwe.model;

import javax.xml.bind.annotation.*;
import java.math.BigInteger;
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
 *       &lt;group ref="{}Common_Attributes"/>
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
@XmlRootElement(name = "Category")
public class Category {

    @XmlElement(name = "Description", required = true)
    protected Category.Description description;
    @XmlElement(name = "Relationships")
    protected Relationships relationships;
    @XmlElement(name = "Relationship_Notes")
    protected RelationshipNotes relationshipNotes;
    @XmlElement(name = "Weakness_Ordinalities")
    protected Category.WeaknessOrdinalities weaknessOrdinalities;
    @XmlElement(name = "Applicable_Platforms")
    protected Category.ApplicablePlatforms applicablePlatforms;
    @XmlElement(name = "Maintenance_Notes")
    protected MaintenanceNotes maintenanceNotes;
    @XmlElement(name = "Background_Details")
    protected Category.BackgroundDetails backgroundDetails;
    @XmlElement(name = "Other_Notes")
    protected OtherNotes otherNotes;
    @XmlElement(name = "Alternate_Terms")
    protected AlternateTerms alternateTerms;
    @XmlElement(name = "Terminology_Notes")
    protected Category.TerminologyNotes terminologyNotes;
    @XmlElement(name = "Time_of_Introduction")
    protected Category.TimeOfIntroduction timeOfIntroduction;
    @XmlElement(name = "Modes_of_Introduction")
    protected Category.ModesOfIntroduction modesOfIntroduction;
    @XmlElement(name = "Enabling_Factors_for_Exploitation")
    protected Category.EnablingFactorsForExploitation enablingFactorsForExploitation;
    @XmlElement(name = "Likelihood_of_Exploit")
    protected String likelihoodOfExploit;
    @XmlElement(name = "Common_Consequences")
    protected Category.CommonConsequences commonConsequences;
    @XmlElement(name = "Detection_Methods")
    protected Category.DetectionMethods detectionMethods;
    @XmlElement(name = "Potential_Mitigations")
    protected Category.PotentialMitigations potentialMitigations;
    @XmlElement(name = "Causal_Nature")
    protected String causalNature;
    @XmlElement(name = "Demonstrative_Examples")
    protected Category.DemonstrativeExamples demonstrativeExamples;
    @XmlElement(name = "Observed_Examples")
    protected Category.ObservedExamples observedExamples;
    @XmlElement(name = "Theoretical_Notes")
    protected Category.TheoreticalNotes theoreticalNotes;
    @XmlElement(name = "Functional_Areas")
    protected Category.FunctionalAreas functionalAreas;
    @XmlElement(name = "Relevant_Properties")
    protected Category.RelevantProperties relevantProperties;
    @XmlElement(name = "Affected_Resources")
    protected Category.AffectedResources affectedResources;
    @XmlElement(name = "Research_Gaps")
    protected ResearchGaps researchGaps;
    @XmlElement(name = "References")
    protected ReferenceListType references;
    @XmlElement(name = "Taxonomy_Mappings")
    protected Category.TaxonomyMappings taxonomyMappings;
    @XmlElement(name = "White_Box_Definitions")
    protected Category.WhiteBoxDefinitions whiteBoxDefinitions;
    @XmlElement(name = "Black_Box_Definitions")
    protected Category.BlackBoxDefinitions blackBoxDefinitions;
    @XmlElement(name = "Related_Attack_Patterns")
    protected Category.RelatedAttackPatterns relatedAttackPatterns;
    @XmlElement(name = "Content_History", required = true)
    protected ContentHistory contentHistory;
    @XmlAttribute(name = "ID", required = true)
    protected BigInteger id;
    @XmlAttribute(name = "Name", required = true)
    protected String name;
    @XmlAttribute(name = "Status", required = true)
    protected StatusType status;

    /**
     * Obtient la valeur de la propriété description.
     * 
     * @return
     *     possible object is
     *     {@link Category.Description }
     *     
     */
    public Category.Description getDescription() {
        return description;
    }

    /**
     * Définit la valeur de la propriété description.
     * 
     * @param value
     *     allowed object is
     *     {@link Category.Description }
     *     
     */
    public void setDescription(Category.Description value) {
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
     *     {@link Category.WeaknessOrdinalities }
     *     
     */
    public Category.WeaknessOrdinalities getWeaknessOrdinalities() {
        return weaknessOrdinalities;
    }

    /**
     * Définit la valeur de la propriété weaknessOrdinalities.
     * 
     * @param value
     *     allowed object is
     *     {@link Category.WeaknessOrdinalities }
     *     
     */
    public void setWeaknessOrdinalities(Category.WeaknessOrdinalities value) {
        this.weaknessOrdinalities = value;
    }

    /**
     * Obtient la valeur de la propriété applicablePlatforms.
     * 
     * @return
     *     possible object is
     *     {@link Category.ApplicablePlatforms }
     *     
     */
    public Category.ApplicablePlatforms getApplicablePlatforms() {
        return applicablePlatforms;
    }

    /**
     * Définit la valeur de la propriété applicablePlatforms.
     * 
     * @param value
     *     allowed object is
     *     {@link Category.ApplicablePlatforms }
     *     
     */
    public void setApplicablePlatforms(Category.ApplicablePlatforms value) {
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
     *     {@link Category.BackgroundDetails }
     *     
     */
    public Category.BackgroundDetails getBackgroundDetails() {
        return backgroundDetails;
    }

    /**
     * Définit la valeur de la propriété backgroundDetails.
     * 
     * @param value
     *     allowed object is
     *     {@link Category.BackgroundDetails }
     *     
     */
    public void setBackgroundDetails(Category.BackgroundDetails value) {
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
     *     {@link Category.TerminologyNotes }
     *     
     */
    public Category.TerminologyNotes getTerminologyNotes() {
        return terminologyNotes;
    }

    /**
     * Définit la valeur de la propriété terminologyNotes.
     * 
     * @param value
     *     allowed object is
     *     {@link Category.TerminologyNotes }
     *     
     */
    public void setTerminologyNotes(Category.TerminologyNotes value) {
        this.terminologyNotes = value;
    }

    /**
     * Obtient la valeur de la propriété timeOfIntroduction.
     * 
     * @return
     *     possible object is
     *     {@link Category.TimeOfIntroduction }
     *     
     */
    public Category.TimeOfIntroduction getTimeOfIntroduction() {
        return timeOfIntroduction;
    }

    /**
     * Définit la valeur de la propriété timeOfIntroduction.
     * 
     * @param value
     *     allowed object is
     *     {@link Category.TimeOfIntroduction }
     *     
     */
    public void setTimeOfIntroduction(Category.TimeOfIntroduction value) {
        this.timeOfIntroduction = value;
    }

    /**
     * Obtient la valeur de la propriété modesOfIntroduction.
     * 
     * @return
     *     possible object is
     *     {@link Category.ModesOfIntroduction }
     *     
     */
    public Category.ModesOfIntroduction getModesOfIntroduction() {
        return modesOfIntroduction;
    }

    /**
     * Définit la valeur de la propriété modesOfIntroduction.
     * 
     * @param value
     *     allowed object is
     *     {@link Category.ModesOfIntroduction }
     *     
     */
    public void setModesOfIntroduction(Category.ModesOfIntroduction value) {
        this.modesOfIntroduction = value;
    }

    /**
     * Obtient la valeur de la propriété enablingFactorsForExploitation.
     * 
     * @return
     *     possible object is
     *     {@link Category.EnablingFactorsForExploitation }
     *     
     */
    public Category.EnablingFactorsForExploitation getEnablingFactorsForExploitation() {
        return enablingFactorsForExploitation;
    }

    /**
     * Définit la valeur de la propriété enablingFactorsForExploitation.
     * 
     * @param value
     *     allowed object is
     *     {@link Category.EnablingFactorsForExploitation }
     *     
     */
    public void setEnablingFactorsForExploitation(Category.EnablingFactorsForExploitation value) {
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
     *     {@link Category.CommonConsequences }
     *     
     */
    public Category.CommonConsequences getCommonConsequences() {
        return commonConsequences;
    }

    /**
     * Définit la valeur de la propriété commonConsequences.
     * 
     * @param value
     *     allowed object is
     *     {@link Category.CommonConsequences }
     *     
     */
    public void setCommonConsequences(Category.CommonConsequences value) {
        this.commonConsequences = value;
    }

    /**
     * Obtient la valeur de la propriété detectionMethods.
     * 
     * @return
     *     possible object is
     *     {@link Category.DetectionMethods }
     *     
     */
    public Category.DetectionMethods getDetectionMethods() {
        return detectionMethods;
    }

    /**
     * Définit la valeur de la propriété detectionMethods.
     * 
     * @param value
     *     allowed object is
     *     {@link Category.DetectionMethods }
     *     
     */
    public void setDetectionMethods(Category.DetectionMethods value) {
        this.detectionMethods = value;
    }

    /**
     * Obtient la valeur de la propriété potentialMitigations.
     * 
     * @return
     *     possible object is
     *     {@link Category.PotentialMitigations }
     *     
     */
    public Category.PotentialMitigations getPotentialMitigations() {
        return potentialMitigations;
    }

    /**
     * Définit la valeur de la propriété potentialMitigations.
     * 
     * @param value
     *     allowed object is
     *     {@link Category.PotentialMitigations }
     *     
     */
    public void setPotentialMitigations(Category.PotentialMitigations value) {
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
     *     {@link Category.DemonstrativeExamples }
     *     
     */
    public Category.DemonstrativeExamples getDemonstrativeExamples() {
        return demonstrativeExamples;
    }

    /**
     * Définit la valeur de la propriété demonstrativeExamples.
     * 
     * @param value
     *     allowed object is
     *     {@link Category.DemonstrativeExamples }
     *     
     */
    public void setDemonstrativeExamples(Category.DemonstrativeExamples value) {
        this.demonstrativeExamples = value;
    }

    /**
     * Obtient la valeur de la propriété observedExamples.
     * 
     * @return
     *     possible object is
     *     {@link Category.ObservedExamples }
     *     
     */
    public Category.ObservedExamples getObservedExamples() {
        return observedExamples;
    }

    /**
     * Définit la valeur de la propriété observedExamples.
     * 
     * @param value
     *     allowed object is
     *     {@link Category.ObservedExamples }
     *     
     */
    public void setObservedExamples(Category.ObservedExamples value) {
        this.observedExamples = value;
    }

    /**
     * Obtient la valeur de la propriété theoreticalNotes.
     * 
     * @return
     *     possible object is
     *     {@link Category.TheoreticalNotes }
     *     
     */
    public Category.TheoreticalNotes getTheoreticalNotes() {
        return theoreticalNotes;
    }

    /**
     * Définit la valeur de la propriété theoreticalNotes.
     * 
     * @param value
     *     allowed object is
     *     {@link Category.TheoreticalNotes }
     *     
     */
    public void setTheoreticalNotes(Category.TheoreticalNotes value) {
        this.theoreticalNotes = value;
    }

    /**
     * Obtient la valeur de la propriété functionalAreas.
     * 
     * @return
     *     possible object is
     *     {@link Category.FunctionalAreas }
     *     
     */
    public Category.FunctionalAreas getFunctionalAreas() {
        return functionalAreas;
    }

    /**
     * Définit la valeur de la propriété functionalAreas.
     * 
     * @param value
     *     allowed object is
     *     {@link Category.FunctionalAreas }
     *     
     */
    public void setFunctionalAreas(Category.FunctionalAreas value) {
        this.functionalAreas = value;
    }

    /**
     * Obtient la valeur de la propriété relevantProperties.
     * 
     * @return
     *     possible object is
     *     {@link Category.RelevantProperties }
     *     
     */
    public Category.RelevantProperties getRelevantProperties() {
        return relevantProperties;
    }

    /**
     * Définit la valeur de la propriété relevantProperties.
     * 
     * @param value
     *     allowed object is
     *     {@link Category.RelevantProperties }
     *     
     */
    public void setRelevantProperties(Category.RelevantProperties value) {
        this.relevantProperties = value;
    }

    /**
     * Obtient la valeur de la propriété affectedResources.
     * 
     * @return
     *     possible object is
     *     {@link Category.AffectedResources }
     *     
     */
    public Category.AffectedResources getAffectedResources() {
        return affectedResources;
    }

    /**
     * Définit la valeur de la propriété affectedResources.
     * 
     * @param value
     *     allowed object is
     *     {@link Category.AffectedResources }
     *     
     */
    public void setAffectedResources(Category.AffectedResources value) {
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
     *     {@link Category.TaxonomyMappings }
     *     
     */
    public Category.TaxonomyMappings getTaxonomyMappings() {
        return taxonomyMappings;
    }

    /**
     * Définit la valeur de la propriété taxonomyMappings.
     * 
     * @param value
     *     allowed object is
     *     {@link Category.TaxonomyMappings }
     *     
     */
    public void setTaxonomyMappings(Category.TaxonomyMappings value) {
        this.taxonomyMappings = value;
    }

    /**
     * Obtient la valeur de la propriété whiteBoxDefinitions.
     * 
     * @return
     *     possible object is
     *     {@link Category.WhiteBoxDefinitions }
     *     
     */
    public Category.WhiteBoxDefinitions getWhiteBoxDefinitions() {
        return whiteBoxDefinitions;
    }

    /**
     * Définit la valeur de la propriété whiteBoxDefinitions.
     * 
     * @param value
     *     allowed object is
     *     {@link Category.WhiteBoxDefinitions }
     *     
     */
    public void setWhiteBoxDefinitions(Category.WhiteBoxDefinitions value) {
        this.whiteBoxDefinitions = value;
    }

    /**
     * Obtient la valeur de la propriété blackBoxDefinitions.
     * 
     * @return
     *     possible object is
     *     {@link Category.BlackBoxDefinitions }
     *     
     */
    public Category.BlackBoxDefinitions getBlackBoxDefinitions() {
        return blackBoxDefinitions;
    }

    /**
     * Définit la valeur de la propriété blackBoxDefinitions.
     * 
     * @param value
     *     allowed object is
     *     {@link Category.BlackBoxDefinitions }
     *     
     */
    public void setBlackBoxDefinitions(Category.BlackBoxDefinitions value) {
        this.blackBoxDefinitions = value;
    }

    /**
     * Obtient la valeur de la propriété relatedAttackPatterns.
     * 
     * @return
     *     possible object is
     *     {@link Category.RelatedAttackPatterns }
     *     
     */
    public Category.RelatedAttackPatterns getRelatedAttackPatterns() {
        return relatedAttackPatterns;
    }

    /**
     * Définit la valeur de la propriété relatedAttackPatterns.
     * 
     * @param value
     *     allowed object is
     *     {@link Category.RelatedAttackPatterns }
     *     
     */
    public void setRelatedAttackPatterns(Category.RelatedAttackPatterns value) {
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
     *         &lt;element name="Affected_Resource" maxOccurs="unbounded">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;whiteSpace value="collapse"/>
     *               &lt;enumeration value="System Process"/>
     *               &lt;enumeration value="Memory"/>
     *               &lt;enumeration value="File/Directory"/>
     *               &lt;enumeration value="CPU"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
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
        "affectedResource"
    })
    public static class AffectedResources {

        @XmlElement(name = "Affected_Resource", required = true)
        protected List<String> affectedResource;

        /**
         * Gets the value of the affectedResource property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the affectedResource property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAffectedResource().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getAffectedResource() {
            if (affectedResource == null) {
                affectedResource = new ArrayList<String>();
            }
            return this.affectedResource;
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
     *         &lt;element name="Languages" type="{}Languages_List_Type" minOccurs="0"/>
     *         &lt;element name="Operating_Systems" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Operating_System" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;attribute name="Operating_System_Name">
     *                             &lt;simpleType>
     *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                 &lt;whiteSpace value="collapse"/>
     *                                 &lt;enumeration value="Windows Vista"/>
     *                                 &lt;enumeration value="Windows XP"/>
     *                                 &lt;enumeration value="Windows 2000"/>
     *                                 &lt;enumeration value="Solaris"/>
     *                                 &lt;enumeration value="Red Hat Linux"/>
     *                                 &lt;enumeration value="SUSE Linux"/>
     *                                 &lt;enumeration value="Ubuntu Linux"/>
     *                                 &lt;enumeration value="Mac OS X"/>
     *                                 &lt;enumeration value="OpenBSD"/>
     *                                 &lt;enumeration value="FreeBSD"/>
     *                                 &lt;enumeration value="NetBSD"/>
     *                               &lt;/restriction>
     *                             &lt;/simpleType>
     *                           &lt;/attribute>
     *                           &lt;attribute name="Prevalence" type="{}Frequency_Type" />
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="Operating_System_Class" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;attribute name="Operating_System_Class_Description" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="Prevalence" type="{}Frequency_Type" />
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Hardware_Architectures" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Hardware_Architecture" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;attribute name="Hardware_Architecture_Name">
     *                             &lt;simpleType>
     *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                 &lt;enumeration value="x86"/>
     *                                 &lt;enumeration value="SPARC"/>
     *                                 &lt;enumeration value="PowerPC"/>
     *                               &lt;/restriction>
     *                             &lt;/simpleType>
     *                           &lt;/attribute>
     *                           &lt;attribute name="Prevalence" type="{}Frequency_Type" />
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="Hardware_Architecture_Class" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;attribute name="Hardware_Architecture_Class_Name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="Prevalence" type="{}Frequency_Type" />
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Architectural_Paradigms" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Architectural_Paradigm" maxOccurs="unbounded">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;attribute name="Architectural_Paradigm_Name">
     *                             &lt;simpleType>
     *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                 &lt;enumeration value="Mainframe"/>
     *                                 &lt;enumeration value="Client-Server"/>
     *                                 &lt;enumeration value="n-Tier"/>
     *                                 &lt;enumeration value="Web-based"/>
     *                                 &lt;enumeration value="Mobile Application"/>
     *                                 &lt;enumeration value="SOA"/>
     *                                 &lt;enumeration value="Concurrent Systems Operating on Shared Resources"/>
     *                               &lt;/restriction>
     *                             &lt;/simpleType>
     *                           &lt;/attribute>
     *                           &lt;attribute name="Prevalence" type="{}Frequency_Type" />
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Environments" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Environment" maxOccurs="unbounded">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;attribute name="Environment_Name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="Prevalence" type="{}Frequency_Type" />
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Technology_Classes" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Technology_Class" maxOccurs="unbounded">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;attribute name="Technology_Name">
     *                             &lt;simpleType>
     *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                 &lt;enumeration value="Web-Server"/>
     *                                 &lt;enumeration value="Web-Client"/>
     *                                 &lt;enumeration value="Database-Server"/>
     *                                 &lt;enumeration value="Database-Client"/>
     *                               &lt;/restriction>
     *                             &lt;/simpleType>
     *                           &lt;/attribute>
     *                           &lt;attribute name="Prevalence" type="{}Frequency_Type" />
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Common_Platform_References" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Common_Platform_Reference" maxOccurs="unbounded">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="CPE_ID" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Platform_Notes" type="{}Structured_Text_Type" minOccurs="0"/>
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
        "languages",
        "operatingSystems",
        "hardwareArchitectures",
        "architecturalParadigms",
        "environments",
        "technologyClasses",
        "commonPlatformReferences",
        "platformNotes"
    })
    public static class ApplicablePlatforms {

        @XmlElement(name = "Languages")
        protected LanguagesListType languages;
        @XmlElement(name = "Operating_Systems")
        protected Category.ApplicablePlatforms.OperatingSystems operatingSystems;
        @XmlElement(name = "Hardware_Architectures")
        protected Category.ApplicablePlatforms.HardwareArchitectures hardwareArchitectures;
        @XmlElement(name = "Architectural_Paradigms")
        protected Category.ApplicablePlatforms.ArchitecturalParadigms architecturalParadigms;
        @XmlElement(name = "Environments")
        protected Category.ApplicablePlatforms.Environments environments;
        @XmlElement(name = "Technology_Classes")
        protected Category.ApplicablePlatforms.TechnologyClasses technologyClasses;
        @XmlElement(name = "Common_Platform_References")
        protected Category.ApplicablePlatforms.CommonPlatformReferences commonPlatformReferences;
        @XmlElement(name = "Platform_Notes")
        protected StructuredTextType platformNotes;

        /**
         * Obtient la valeur de la propriété languages.
         * 
         * @return
         *     possible object is
         *     {@link LanguagesListType }
         *     
         */
        public LanguagesListType getLanguages() {
            return languages;
        }

        /**
         * Définit la valeur de la propriété languages.
         * 
         * @param value
         *     allowed object is
         *     {@link LanguagesListType }
         *     
         */
        public void setLanguages(LanguagesListType value) {
            this.languages = value;
        }

        /**
         * Obtient la valeur de la propriété operatingSystems.
         * 
         * @return
         *     possible object is
         *     {@link Category.ApplicablePlatforms.OperatingSystems }
         *     
         */
        public Category.ApplicablePlatforms.OperatingSystems getOperatingSystems() {
            return operatingSystems;
        }

        /**
         * Définit la valeur de la propriété operatingSystems.
         * 
         * @param value
         *     allowed object is
         *     {@link Category.ApplicablePlatforms.OperatingSystems }
         *     
         */
        public void setOperatingSystems(Category.ApplicablePlatforms.OperatingSystems value) {
            this.operatingSystems = value;
        }

        /**
         * Obtient la valeur de la propriété hardwareArchitectures.
         * 
         * @return
         *     possible object is
         *     {@link Category.ApplicablePlatforms.HardwareArchitectures }
         *     
         */
        public Category.ApplicablePlatforms.HardwareArchitectures getHardwareArchitectures() {
            return hardwareArchitectures;
        }

        /**
         * Définit la valeur de la propriété hardwareArchitectures.
         * 
         * @param value
         *     allowed object is
         *     {@link Category.ApplicablePlatforms.HardwareArchitectures }
         *     
         */
        public void setHardwareArchitectures(Category.ApplicablePlatforms.HardwareArchitectures value) {
            this.hardwareArchitectures = value;
        }

        /**
         * Obtient la valeur de la propriété architecturalParadigms.
         * 
         * @return
         *     possible object is
         *     {@link Category.ApplicablePlatforms.ArchitecturalParadigms }
         *     
         */
        public Category.ApplicablePlatforms.ArchitecturalParadigms getArchitecturalParadigms() {
            return architecturalParadigms;
        }

        /**
         * Définit la valeur de la propriété architecturalParadigms.
         * 
         * @param value
         *     allowed object is
         *     {@link Category.ApplicablePlatforms.ArchitecturalParadigms }
         *     
         */
        public void setArchitecturalParadigms(Category.ApplicablePlatforms.ArchitecturalParadigms value) {
            this.architecturalParadigms = value;
        }

        /**
         * Obtient la valeur de la propriété environments.
         * 
         * @return
         *     possible object is
         *     {@link Category.ApplicablePlatforms.Environments }
         *     
         */
        public Category.ApplicablePlatforms.Environments getEnvironments() {
            return environments;
        }

        /**
         * Définit la valeur de la propriété environments.
         * 
         * @param value
         *     allowed object is
         *     {@link Category.ApplicablePlatforms.Environments }
         *     
         */
        public void setEnvironments(Category.ApplicablePlatforms.Environments value) {
            this.environments = value;
        }

        /**
         * Obtient la valeur de la propriété technologyClasses.
         * 
         * @return
         *     possible object is
         *     {@link Category.ApplicablePlatforms.TechnologyClasses }
         *     
         */
        public Category.ApplicablePlatforms.TechnologyClasses getTechnologyClasses() {
            return technologyClasses;
        }

        /**
         * Définit la valeur de la propriété technologyClasses.
         * 
         * @param value
         *     allowed object is
         *     {@link Category.ApplicablePlatforms.TechnologyClasses }
         *     
         */
        public void setTechnologyClasses(Category.ApplicablePlatforms.TechnologyClasses value) {
            this.technologyClasses = value;
        }

        /**
         * Obtient la valeur de la propriété commonPlatformReferences.
         * 
         * @return
         *     possible object is
         *     {@link Category.ApplicablePlatforms.CommonPlatformReferences }
         *     
         */
        public Category.ApplicablePlatforms.CommonPlatformReferences getCommonPlatformReferences() {
            return commonPlatformReferences;
        }

        /**
         * Définit la valeur de la propriété commonPlatformReferences.
         * 
         * @param value
         *     allowed object is
         *     {@link Category.ApplicablePlatforms.CommonPlatformReferences }
         *     
         */
        public void setCommonPlatformReferences(Category.ApplicablePlatforms.CommonPlatformReferences value) {
            this.commonPlatformReferences = value;
        }

        /**
         * Obtient la valeur de la propriété platformNotes.
         * 
         * @return
         *     possible object is
         *     {@link StructuredTextType }
         *     
         */
        public StructuredTextType getPlatformNotes() {
            return platformNotes;
        }

        /**
         * Définit la valeur de la propriété platformNotes.
         * 
         * @param value
         *     allowed object is
         *     {@link StructuredTextType }
         *     
         */
        public void setPlatformNotes(StructuredTextType value) {
            this.platformNotes = value;
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
         *         &lt;element name="Architectural_Paradigm" maxOccurs="unbounded">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;attribute name="Architectural_Paradigm_Name">
         *                   &lt;simpleType>
         *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                       &lt;enumeration value="Mainframe"/>
         *                       &lt;enumeration value="Client-Server"/>
         *                       &lt;enumeration value="n-Tier"/>
         *                       &lt;enumeration value="Web-based"/>
         *                       &lt;enumeration value="Mobile Application"/>
         *                       &lt;enumeration value="SOA"/>
         *                       &lt;enumeration value="Concurrent Systems Operating on Shared Resources"/>
         *                     &lt;/restriction>
         *                   &lt;/simpleType>
         *                 &lt;/attribute>
         *                 &lt;attribute name="Prevalence" type="{}Frequency_Type" />
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
            "architecturalParadigm"
        })
        public static class ArchitecturalParadigms {

            @XmlElement(name = "Architectural_Paradigm", required = true)
            protected List<Category.ApplicablePlatforms.ArchitecturalParadigms.ArchitecturalParadigm> architecturalParadigm;

            /**
             * Gets the value of the architecturalParadigm property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the architecturalParadigm property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getArchitecturalParadigm().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Category.ApplicablePlatforms.ArchitecturalParadigms.ArchitecturalParadigm }
             * 
             * 
             */
            public List<Category.ApplicablePlatforms.ArchitecturalParadigms.ArchitecturalParadigm> getArchitecturalParadigm() {
                if (architecturalParadigm == null) {
                    architecturalParadigm = new ArrayList<Category.ApplicablePlatforms.ArchitecturalParadigms.ArchitecturalParadigm>();
                }
                return this.architecturalParadigm;
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
             *       &lt;attribute name="Architectural_Paradigm_Name">
             *         &lt;simpleType>
             *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *             &lt;enumeration value="Mainframe"/>
             *             &lt;enumeration value="Client-Server"/>
             *             &lt;enumeration value="n-Tier"/>
             *             &lt;enumeration value="Web-based"/>
             *             &lt;enumeration value="Mobile Application"/>
             *             &lt;enumeration value="SOA"/>
             *             &lt;enumeration value="Concurrent Systems Operating on Shared Resources"/>
             *           &lt;/restriction>
             *         &lt;/simpleType>
             *       &lt;/attribute>
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
            public static class ArchitecturalParadigm {

                @XmlAttribute(name = "Architectural_Paradigm_Name")
                protected String architecturalParadigmName;
                @XmlAttribute(name = "Prevalence")
                protected FrequencyType prevalence;

                /**
                 * Obtient la valeur de la propriété architecturalParadigmName.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getArchitecturalParadigmName() {
                    return architecturalParadigmName;
                }

                /**
                 * Définit la valeur de la propriété architecturalParadigmName.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setArchitecturalParadigmName(String value) {
                    this.architecturalParadigmName = value;
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
         *         &lt;element name="Common_Platform_Reference" maxOccurs="unbounded">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="CPE_ID" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
            "commonPlatformReference"
        })
        public static class CommonPlatformReferences {

            @XmlElement(name = "Common_Platform_Reference", required = true)
            protected List<Category.ApplicablePlatforms.CommonPlatformReferences.CommonPlatformReference> commonPlatformReference;

            /**
             * Gets the value of the commonPlatformReference property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the commonPlatformReference property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getCommonPlatformReference().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Category.ApplicablePlatforms.CommonPlatformReferences.CommonPlatformReference }
             * 
             * 
             */
            public List<Category.ApplicablePlatforms.CommonPlatformReferences.CommonPlatformReference> getCommonPlatformReference() {
                if (commonPlatformReference == null) {
                    commonPlatformReference = new ArrayList<Category.ApplicablePlatforms.CommonPlatformReferences.CommonPlatformReference>();
                }
                return this.commonPlatformReference;
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
             *         &lt;element name="CPE_ID" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
                "cpeid"
            })
            public static class CommonPlatformReference {

                @XmlElement(name = "CPE_ID", required = true)
                protected String cpeid;

                /**
                 * Obtient la valeur de la propriété cpeid.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getCPEID() {
                    return cpeid;
                }

                /**
                 * Définit la valeur de la propriété cpeid.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setCPEID(String value) {
                    this.cpeid = value;
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
         *         &lt;element name="Environment" maxOccurs="unbounded">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;attribute name="Environment_Name" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="Prevalence" type="{}Frequency_Type" />
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
            "environment"
        })
        public static class Environments {

            @XmlElement(name = "Environment", required = true)
            protected List<Category.ApplicablePlatforms.Environments.Environment> environment;

            /**
             * Gets the value of the environment property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the environment property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getEnvironment().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Category.ApplicablePlatforms.Environments.Environment }
             * 
             * 
             */
            public List<Category.ApplicablePlatforms.Environments.Environment> getEnvironment() {
                if (environment == null) {
                    environment = new ArrayList<Category.ApplicablePlatforms.Environments.Environment>();
                }
                return this.environment;
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
             *       &lt;attribute name="Environment_Name" type="{http://www.w3.org/2001/XMLSchema}string" />
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
            public static class Environment {

                @XmlAttribute(name = "Environment_Name")
                protected String environmentName;
                @XmlAttribute(name = "Prevalence")
                protected FrequencyType prevalence;

                /**
                 * Obtient la valeur de la propriété environmentName.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getEnvironmentName() {
                    return environmentName;
                }

                /**
                 * Définit la valeur de la propriété environmentName.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setEnvironmentName(String value) {
                    this.environmentName = value;
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
         *         &lt;element name="Hardware_Architecture" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;attribute name="Hardware_Architecture_Name">
         *                   &lt;simpleType>
         *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                       &lt;enumeration value="x86"/>
         *                       &lt;enumeration value="SPARC"/>
         *                       &lt;enumeration value="PowerPC"/>
         *                     &lt;/restriction>
         *                   &lt;/simpleType>
         *                 &lt;/attribute>
         *                 &lt;attribute name="Prevalence" type="{}Frequency_Type" />
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="Hardware_Architecture_Class" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;attribute name="Hardware_Architecture_Class_Name" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="Prevalence" type="{}Frequency_Type" />
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
            "hardwareArchitecture",
            "hardwareArchitectureClass"
        })
        public static class HardwareArchitectures {

            @XmlElement(name = "Hardware_Architecture")
            protected List<Category.ApplicablePlatforms.HardwareArchitectures.HardwareArchitecture> hardwareArchitecture;
            @XmlElement(name = "Hardware_Architecture_Class")
            protected List<Category.ApplicablePlatforms.HardwareArchitectures.HardwareArchitectureClass> hardwareArchitectureClass;

            /**
             * Gets the value of the hardwareArchitecture property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the hardwareArchitecture property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getHardwareArchitecture().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Category.ApplicablePlatforms.HardwareArchitectures.HardwareArchitecture }
             * 
             * 
             */
            public List<Category.ApplicablePlatforms.HardwareArchitectures.HardwareArchitecture> getHardwareArchitecture() {
                if (hardwareArchitecture == null) {
                    hardwareArchitecture = new ArrayList<Category.ApplicablePlatforms.HardwareArchitectures.HardwareArchitecture>();
                }
                return this.hardwareArchitecture;
            }

            /**
             * Gets the value of the hardwareArchitectureClass property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the hardwareArchitectureClass property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getHardwareArchitectureClass().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Category.ApplicablePlatforms.HardwareArchitectures.HardwareArchitectureClass }
             * 
             * 
             */
            public List<Category.ApplicablePlatforms.HardwareArchitectures.HardwareArchitectureClass> getHardwareArchitectureClass() {
                if (hardwareArchitectureClass == null) {
                    hardwareArchitectureClass = new ArrayList<Category.ApplicablePlatforms.HardwareArchitectures.HardwareArchitectureClass>();
                }
                return this.hardwareArchitectureClass;
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
             *       &lt;attribute name="Hardware_Architecture_Name">
             *         &lt;simpleType>
             *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *             &lt;enumeration value="x86"/>
             *             &lt;enumeration value="SPARC"/>
             *             &lt;enumeration value="PowerPC"/>
             *           &lt;/restriction>
             *         &lt;/simpleType>
             *       &lt;/attribute>
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
            public static class HardwareArchitecture {

                @XmlAttribute(name = "Hardware_Architecture_Name")
                protected String hardwareArchitectureName;
                @XmlAttribute(name = "Prevalence")
                protected FrequencyType prevalence;

                /**
                 * Obtient la valeur de la propriété hardwareArchitectureName.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getHardwareArchitectureName() {
                    return hardwareArchitectureName;
                }

                /**
                 * Définit la valeur de la propriété hardwareArchitectureName.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setHardwareArchitectureName(String value) {
                    this.hardwareArchitectureName = value;
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
             *       &lt;attribute name="Hardware_Architecture_Class_Name" type="{http://www.w3.org/2001/XMLSchema}string" />
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
            public static class HardwareArchitectureClass {

                @XmlAttribute(name = "Hardware_Architecture_Class_Name")
                protected String hardwareArchitectureClassName;
                @XmlAttribute(name = "Prevalence")
                protected FrequencyType prevalence;

                /**
                 * Obtient la valeur de la propriété hardwareArchitectureClassName.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getHardwareArchitectureClassName() {
                    return hardwareArchitectureClassName;
                }

                /**
                 * Définit la valeur de la propriété hardwareArchitectureClassName.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setHardwareArchitectureClassName(String value) {
                    this.hardwareArchitectureClassName = value;
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
         *         &lt;element name="Operating_System" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;attribute name="Operating_System_Name">
         *                   &lt;simpleType>
         *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                       &lt;whiteSpace value="collapse"/>
         *                       &lt;enumeration value="Windows Vista"/>
         *                       &lt;enumeration value="Windows XP"/>
         *                       &lt;enumeration value="Windows 2000"/>
         *                       &lt;enumeration value="Solaris"/>
         *                       &lt;enumeration value="Red Hat Linux"/>
         *                       &lt;enumeration value="SUSE Linux"/>
         *                       &lt;enumeration value="Ubuntu Linux"/>
         *                       &lt;enumeration value="Mac OS X"/>
         *                       &lt;enumeration value="OpenBSD"/>
         *                       &lt;enumeration value="FreeBSD"/>
         *                       &lt;enumeration value="NetBSD"/>
         *                     &lt;/restriction>
         *                   &lt;/simpleType>
         *                 &lt;/attribute>
         *                 &lt;attribute name="Prevalence" type="{}Frequency_Type" />
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="Operating_System_Class" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;attribute name="Operating_System_Class_Description" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="Prevalence" type="{}Frequency_Type" />
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
            "operatingSystem",
            "operatingSystemClass"
        })
        public static class OperatingSystems {

            @XmlElement(name = "Operating_System")
            protected List<Category.ApplicablePlatforms.OperatingSystems.OperatingSystem> operatingSystem;
            @XmlElement(name = "Operating_System_Class")
            protected List<Category.ApplicablePlatforms.OperatingSystems.OperatingSystemClass> operatingSystemClass;

            /**
             * Gets the value of the operatingSystem property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the operatingSystem property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getOperatingSystem().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Category.ApplicablePlatforms.OperatingSystems.OperatingSystem }
             * 
             * 
             */
            public List<Category.ApplicablePlatforms.OperatingSystems.OperatingSystem> getOperatingSystem() {
                if (operatingSystem == null) {
                    operatingSystem = new ArrayList<Category.ApplicablePlatforms.OperatingSystems.OperatingSystem>();
                }
                return this.operatingSystem;
            }

            /**
             * Gets the value of the operatingSystemClass property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the operatingSystemClass property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getOperatingSystemClass().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Category.ApplicablePlatforms.OperatingSystems.OperatingSystemClass }
             * 
             * 
             */
            public List<Category.ApplicablePlatforms.OperatingSystems.OperatingSystemClass> getOperatingSystemClass() {
                if (operatingSystemClass == null) {
                    operatingSystemClass = new ArrayList<Category.ApplicablePlatforms.OperatingSystems.OperatingSystemClass>();
                }
                return this.operatingSystemClass;
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
             *       &lt;attribute name="Operating_System_Name">
             *         &lt;simpleType>
             *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *             &lt;whiteSpace value="collapse"/>
             *             &lt;enumeration value="Windows Vista"/>
             *             &lt;enumeration value="Windows XP"/>
             *             &lt;enumeration value="Windows 2000"/>
             *             &lt;enumeration value="Solaris"/>
             *             &lt;enumeration value="Red Hat Linux"/>
             *             &lt;enumeration value="SUSE Linux"/>
             *             &lt;enumeration value="Ubuntu Linux"/>
             *             &lt;enumeration value="Mac OS X"/>
             *             &lt;enumeration value="OpenBSD"/>
             *             &lt;enumeration value="FreeBSD"/>
             *             &lt;enumeration value="NetBSD"/>
             *           &lt;/restriction>
             *         &lt;/simpleType>
             *       &lt;/attribute>
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
            public static class OperatingSystem {

                @XmlAttribute(name = "Operating_System_Name")
                protected String operatingSystemName;
                @XmlAttribute(name = "Prevalence")
                protected FrequencyType prevalence;

                /**
                 * Obtient la valeur de la propriété operatingSystemName.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getOperatingSystemName() {
                    return operatingSystemName;
                }

                /**
                 * Définit la valeur de la propriété operatingSystemName.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setOperatingSystemName(String value) {
                    this.operatingSystemName = value;
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
             *       &lt;attribute name="Operating_System_Class_Description" type="{http://www.w3.org/2001/XMLSchema}string" />
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
            public static class OperatingSystemClass {

                @XmlAttribute(name = "Operating_System_Class_Description")
                protected String operatingSystemClassDescription;
                @XmlAttribute(name = "Prevalence")
                protected FrequencyType prevalence;

                /**
                 * Obtient la valeur de la propriété operatingSystemClassDescription.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getOperatingSystemClassDescription() {
                    return operatingSystemClassDescription;
                }

                /**
                 * Définit la valeur de la propriété operatingSystemClassDescription.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setOperatingSystemClassDescription(String value) {
                    this.operatingSystemClassDescription = value;
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
         *         &lt;element name="Technology_Class" maxOccurs="unbounded">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;attribute name="Technology_Name">
         *                   &lt;simpleType>
         *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                       &lt;enumeration value="Web-Server"/>
         *                       &lt;enumeration value="Web-Client"/>
         *                       &lt;enumeration value="Database-Server"/>
         *                       &lt;enumeration value="Database-Client"/>
         *                     &lt;/restriction>
         *                   &lt;/simpleType>
         *                 &lt;/attribute>
         *                 &lt;attribute name="Prevalence" type="{}Frequency_Type" />
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
            "technologyClass"
        })
        public static class TechnologyClasses {

            @XmlElement(name = "Technology_Class", required = true)
            protected List<Category.ApplicablePlatforms.TechnologyClasses.TechnologyClass> technologyClass;

            /**
             * Gets the value of the technologyClass property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the technologyClass property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getTechnologyClass().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Category.ApplicablePlatforms.TechnologyClasses.TechnologyClass }
             * 
             * 
             */
            public List<Category.ApplicablePlatforms.TechnologyClasses.TechnologyClass> getTechnologyClass() {
                if (technologyClass == null) {
                    technologyClass = new ArrayList<Category.ApplicablePlatforms.TechnologyClasses.TechnologyClass>();
                }
                return this.technologyClass;
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
             *       &lt;attribute name="Technology_Name">
             *         &lt;simpleType>
             *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *             &lt;enumeration value="Web-Server"/>
             *             &lt;enumeration value="Web-Client"/>
             *             &lt;enumeration value="Database-Server"/>
             *             &lt;enumeration value="Database-Client"/>
             *           &lt;/restriction>
             *         &lt;/simpleType>
             *       &lt;/attribute>
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
            public static class TechnologyClass {

                @XmlAttribute(name = "Technology_Name")
                protected String technologyName;
                @XmlAttribute(name = "Prevalence")
                protected FrequencyType prevalence;

                /**
                 * Obtient la valeur de la propriété technologyName.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getTechnologyName() {
                    return technologyName;
                }

                /**
                 * Définit la valeur de la propriété technologyName.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setTechnologyName(String value) {
                    this.technologyName = value;
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
     *         &lt;element name="Background_Detail" type="{}Structured_Text_Type" maxOccurs="unbounded"/>
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
        "backgroundDetail"
    })
    public static class BackgroundDetails {

        @XmlElement(name = "Background_Detail", required = true)
        protected List<StructuredTextType> backgroundDetail;

        /**
         * Gets the value of the backgroundDetail property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the backgroundDetail property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getBackgroundDetail().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link StructuredTextType }
         * 
         * 
         */
        public List<StructuredTextType> getBackgroundDetail() {
            if (backgroundDetail == null) {
                backgroundDetail = new ArrayList<StructuredTextType>();
            }
            return this.backgroundDetail;
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
     *         &lt;element name="Black_Box_Definition" type="{}Structured_Text_Type" maxOccurs="unbounded"/>
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
        "blackBoxDefinition"
    })
    public static class BlackBoxDefinitions {

        @XmlElement(name = "Black_Box_Definition", required = true)
        protected List<StructuredTextType> blackBoxDefinition;

        /**
         * Gets the value of the blackBoxDefinition property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the blackBoxDefinition property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getBlackBoxDefinition().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link StructuredTextType }
         * 
         * 
         */
        public List<StructuredTextType> getBlackBoxDefinition() {
            if (blackBoxDefinition == null) {
                blackBoxDefinition = new ArrayList<StructuredTextType>();
            }
            return this.blackBoxDefinition;
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
     *         &lt;element ref="{}Common_Consequence" maxOccurs="unbounded"/>
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
        "commonConsequence"
    })
    public static class CommonConsequences {

        @XmlElement(name = "Common_Consequence", required = true)
        protected List<CommonConsequence> commonConsequence;

        /**
         * Gets the value of the commonConsequence property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the commonConsequence property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCommonConsequence().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link CommonConsequence }
         * 
         * 
         */
        public List<CommonConsequence> getCommonConsequence() {
            if (commonConsequence == null) {
                commonConsequence = new ArrayList<CommonConsequence>();
            }
            return this.commonConsequence;
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
     *         &lt;element name="Demonstrative_Example" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Intro_Text" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="Example_Body" type="{}Structured_Text_Type" minOccurs="0"/>
     *                   &lt;element name="Demonstrative_Example_References" type="{}Reference_List_Type" minOccurs="0"/>
     *                 &lt;/sequence>
     *                 &lt;attribute name="Demonstrative_Example_ID" type="{http://www.w3.org/2001/XMLSchema}string" />
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
        "demonstrativeExample"
    })
    public static class DemonstrativeExamples {

        @XmlElement(name = "Demonstrative_Example", required = true)
        protected List<Category.DemonstrativeExamples.DemonstrativeExample> demonstrativeExample;

        /**
         * Gets the value of the demonstrativeExample property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the demonstrativeExample property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDemonstrativeExample().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Category.DemonstrativeExamples.DemonstrativeExample }
         * 
         * 
         */
        public List<Category.DemonstrativeExamples.DemonstrativeExample> getDemonstrativeExample() {
            if (demonstrativeExample == null) {
                demonstrativeExample = new ArrayList<Category.DemonstrativeExamples.DemonstrativeExample>();
            }
            return this.demonstrativeExample;
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
         *         &lt;element name="Intro_Text" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="Example_Body" type="{}Structured_Text_Type" minOccurs="0"/>
         *         &lt;element name="Demonstrative_Example_References" type="{}Reference_List_Type" minOccurs="0"/>
         *       &lt;/sequence>
         *       &lt;attribute name="Demonstrative_Example_ID" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "introText",
            "exampleBody",
            "demonstrativeExampleReferences"
        })
        public static class DemonstrativeExample {

            @XmlElement(name = "Intro_Text", required = true)
            protected String introText;
            @XmlElement(name = "Example_Body")
            protected StructuredTextType exampleBody;
            @XmlElement(name = "Demonstrative_Example_References")
            protected ReferenceListType demonstrativeExampleReferences;
            @XmlAttribute(name = "Demonstrative_Example_ID")
            protected String demonstrativeExampleID;

            /**
             * Obtient la valeur de la propriété introText.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getIntroText() {
                return introText;
            }

            /**
             * Définit la valeur de la propriété introText.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setIntroText(String value) {
                this.introText = value;
            }

            /**
             * Obtient la valeur de la propriété exampleBody.
             * 
             * @return
             *     possible object is
             *     {@link StructuredTextType }
             *     
             */
            public StructuredTextType getExampleBody() {
                return exampleBody;
            }

            /**
             * Définit la valeur de la propriété exampleBody.
             * 
             * @param value
             *     allowed object is
             *     {@link StructuredTextType }
             *     
             */
            public void setExampleBody(StructuredTextType value) {
                this.exampleBody = value;
            }

            /**
             * Obtient la valeur de la propriété demonstrativeExampleReferences.
             * 
             * @return
             *     possible object is
             *     {@link ReferenceListType }
             *     
             */
            public ReferenceListType getDemonstrativeExampleReferences() {
                return demonstrativeExampleReferences;
            }

            /**
             * Définit la valeur de la propriété demonstrativeExampleReferences.
             * 
             * @param value
             *     allowed object is
             *     {@link ReferenceListType }
             *     
             */
            public void setDemonstrativeExampleReferences(ReferenceListType value) {
                this.demonstrativeExampleReferences = value;
            }

            /**
             * Obtient la valeur de la propriété demonstrativeExampleID.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDemonstrativeExampleID() {
                return demonstrativeExampleID;
            }

            /**
             * Définit la valeur de la propriété demonstrativeExampleID.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDemonstrativeExampleID(String value) {
                this.demonstrativeExampleID = value;
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
     *         &lt;element name="Description_Summary" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Extended_Description" type="{}Structured_Text_Type" minOccurs="0"/>
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
        "descriptionSummary",
        "extendedDescription"
    })
    public static class Description {

        @XmlElement(name = "Description_Summary", required = true)
        protected String descriptionSummary;
        @XmlElement(name = "Extended_Description")
        protected StructuredTextType extendedDescription;

        /**
         * Obtient la valeur de la propriété descriptionSummary.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDescriptionSummary() {
            return descriptionSummary;
        }

        /**
         * Définit la valeur de la propriété descriptionSummary.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDescriptionSummary(String value) {
            this.descriptionSummary = value;
        }

        /**
         * Obtient la valeur de la propriété extendedDescription.
         * 
         * @return
         *     possible object is
         *     {@link StructuredTextType }
         *     
         */
        public StructuredTextType getExtendedDescription() {
            return extendedDescription;
        }

        /**
         * Définit la valeur de la propriété extendedDescription.
         * 
         * @param value
         *     allowed object is
         *     {@link StructuredTextType }
         *     
         */
        public void setExtendedDescription(StructuredTextType value) {
            this.extendedDescription = value;
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
     *         &lt;element name="Detection_Method" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Method_Name">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;whiteSpace value="collapse"/>
     *                         &lt;enumeration value="Automated Analysis"/>
     *                         &lt;enumeration value="Automated Dynamic Analysis"/>
     *                         &lt;enumeration value="Automated Static Analysis"/>
     *                         &lt;enumeration value="Fuzzing"/>
     *                         &lt;enumeration value="Manual Analysis"/>
     *                         &lt;enumeration value="Manual Dynamic Analysis"/>
     *                         &lt;enumeration value="Manual Static Analysis"/>
     *                         &lt;enumeration value="Other"/>
     *                         &lt;enumeration value="White Box"/>
     *                         &lt;enumeration value="Black Box"/>
     *                         &lt;enumeration value="Architecture / Design Review"/>
     *                         &lt;enumeration value="Automated Static Analysis - Source Code"/>
     *                         &lt;enumeration value="Automated Static Analysis - Binary / Bytecode"/>
     *                         &lt;enumeration value="Dynamic Analysis with manual results interpretation"/>
     *                         &lt;enumeration value="Dynamic Analysis with automated results interpretation"/>
     *                         &lt;enumeration value="Manual Static Analysis - Source Code"/>
     *                         &lt;enumeration value="Manual Static Analysis - Binary / Bytecode"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="Method_Description" type="{}Structured_Text_Type" minOccurs="0"/>
     *                   &lt;element name="Method_Effectiveness" minOccurs="0">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;enumeration value="None/Rare"/>
     *                         &lt;enumeration value="Limited"/>
     *                         &lt;enumeration value="Opportunistic"/>
     *                         &lt;enumeration value="Moderate"/>
     *                         &lt;enumeration value="High"/>
     *                         &lt;enumeration value="SOAR High"/>
     *                         &lt;enumeration value="SOAR Partial"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="Method_Effectiveness_Notes" type="{}Structured_Text_Type" minOccurs="0"/>
     *                 &lt;/sequence>
     *                 &lt;attribute name="Detection_Method_ID" type="{http://www.w3.org/2001/XMLSchema}string" />
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
        "detectionMethod"
    })
    public static class DetectionMethods {

        @XmlElement(name = "Detection_Method", required = true)
        protected List<Category.DetectionMethods.DetectionMethod> detectionMethod;

        /**
         * Gets the value of the detectionMethod property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the detectionMethod property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDetectionMethod().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Category.DetectionMethods.DetectionMethod }
         * 
         * 
         */
        public List<Category.DetectionMethods.DetectionMethod> getDetectionMethod() {
            if (detectionMethod == null) {
                detectionMethod = new ArrayList<Category.DetectionMethods.DetectionMethod>();
            }
            return this.detectionMethod;
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
         *         &lt;element name="Method_Name">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;whiteSpace value="collapse"/>
         *               &lt;enumeration value="Automated Analysis"/>
         *               &lt;enumeration value="Automated Dynamic Analysis"/>
         *               &lt;enumeration value="Automated Static Analysis"/>
         *               &lt;enumeration value="Fuzzing"/>
         *               &lt;enumeration value="Manual Analysis"/>
         *               &lt;enumeration value="Manual Dynamic Analysis"/>
         *               &lt;enumeration value="Manual Static Analysis"/>
         *               &lt;enumeration value="Other"/>
         *               &lt;enumeration value="White Box"/>
         *               &lt;enumeration value="Black Box"/>
         *               &lt;enumeration value="Architecture / Design Review"/>
         *               &lt;enumeration value="Automated Static Analysis - Source Code"/>
         *               &lt;enumeration value="Automated Static Analysis - Binary / Bytecode"/>
         *               &lt;enumeration value="Dynamic Analysis with manual results interpretation"/>
         *               &lt;enumeration value="Dynamic Analysis with automated results interpretation"/>
         *               &lt;enumeration value="Manual Static Analysis - Source Code"/>
         *               &lt;enumeration value="Manual Static Analysis - Binary / Bytecode"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="Method_Description" type="{}Structured_Text_Type" minOccurs="0"/>
         *         &lt;element name="Method_Effectiveness" minOccurs="0">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;enumeration value="None/Rare"/>
         *               &lt;enumeration value="Limited"/>
         *               &lt;enumeration value="Opportunistic"/>
         *               &lt;enumeration value="Moderate"/>
         *               &lt;enumeration value="High"/>
         *               &lt;enumeration value="SOAR High"/>
         *               &lt;enumeration value="SOAR Partial"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="Method_Effectiveness_Notes" type="{}Structured_Text_Type" minOccurs="0"/>
         *       &lt;/sequence>
         *       &lt;attribute name="Detection_Method_ID" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "methodName",
            "methodDescription",
            "methodEffectiveness",
            "methodEffectivenessNotes"
        })
        public static class DetectionMethod {

            @XmlElement(name = "Method_Name", required = true)
            protected String methodName;
            @XmlElement(name = "Method_Description")
            protected StructuredTextType methodDescription;
            @XmlElement(name = "Method_Effectiveness")
            protected String methodEffectiveness;
            @XmlElement(name = "Method_Effectiveness_Notes")
            protected StructuredTextType methodEffectivenessNotes;
            @XmlAttribute(name = "Detection_Method_ID")
            protected String detectionMethodID;

            /**
             * Obtient la valeur de la propriété methodName.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getMethodName() {
                return methodName;
            }

            /**
             * Définit la valeur de la propriété methodName.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setMethodName(String value) {
                this.methodName = value;
            }

            /**
             * Obtient la valeur de la propriété methodDescription.
             * 
             * @return
             *     possible object is
             *     {@link StructuredTextType }
             *     
             */
            public StructuredTextType getMethodDescription() {
                return methodDescription;
            }

            /**
             * Définit la valeur de la propriété methodDescription.
             * 
             * @param value
             *     allowed object is
             *     {@link StructuredTextType }
             *     
             */
            public void setMethodDescription(StructuredTextType value) {
                this.methodDescription = value;
            }

            /**
             * Obtient la valeur de la propriété methodEffectiveness.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getMethodEffectiveness() {
                return methodEffectiveness;
            }

            /**
             * Définit la valeur de la propriété methodEffectiveness.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setMethodEffectiveness(String value) {
                this.methodEffectiveness = value;
            }

            /**
             * Obtient la valeur de la propriété methodEffectivenessNotes.
             * 
             * @return
             *     possible object is
             *     {@link StructuredTextType }
             *     
             */
            public StructuredTextType getMethodEffectivenessNotes() {
                return methodEffectivenessNotes;
            }

            /**
             * Définit la valeur de la propriété methodEffectivenessNotes.
             * 
             * @param value
             *     allowed object is
             *     {@link StructuredTextType }
             *     
             */
            public void setMethodEffectivenessNotes(StructuredTextType value) {
                this.methodEffectivenessNotes = value;
            }

            /**
             * Obtient la valeur de la propriété detectionMethodID.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDetectionMethodID() {
                return detectionMethodID;
            }

            /**
             * Définit la valeur de la propriété detectionMethodID.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDetectionMethodID(String value) {
                this.detectionMethodID = value;
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
     *         &lt;element name="Enabling_Factor_for_Exploitation" type="{}Structured_Text_Type" maxOccurs="unbounded"/>
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
        "enablingFactorForExploitation"
    })
    public static class EnablingFactorsForExploitation {

        @XmlElement(name = "Enabling_Factor_for_Exploitation", required = true)
        protected List<StructuredTextType> enablingFactorForExploitation;

        /**
         * Gets the value of the enablingFactorForExploitation property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the enablingFactorForExploitation property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getEnablingFactorForExploitation().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link StructuredTextType }
         * 
         * 
         */
        public List<StructuredTextType> getEnablingFactorForExploitation() {
            if (enablingFactorForExploitation == null) {
                enablingFactorForExploitation = new ArrayList<StructuredTextType>();
            }
            return this.enablingFactorForExploitation;
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
     *         &lt;element name="Functional_Area" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
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
        "functionalArea"
    })
    public static class FunctionalAreas {

        @XmlElement(name = "Functional_Area", required = true)
        protected List<String> functionalArea;

        /**
         * Gets the value of the functionalArea property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the functionalArea property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getFunctionalArea().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getFunctionalArea() {
            if (functionalArea == null) {
                functionalArea = new ArrayList<String>();
            }
            return this.functionalArea;
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
     *         &lt;element name="Mode_of_Introduction" type="{}Structured_Text_Type" maxOccurs="unbounded" minOccurs="0"/>
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
        "modeOfIntroduction"
    })
    public static class ModesOfIntroduction {

        @XmlElement(name = "Mode_of_Introduction")
        protected List<StructuredTextType> modeOfIntroduction;

        /**
         * Gets the value of the modeOfIntroduction property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the modeOfIntroduction property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getModeOfIntroduction().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link StructuredTextType }
         * 
         * 
         */
        public List<StructuredTextType> getModeOfIntroduction() {
            if (modeOfIntroduction == null) {
                modeOfIntroduction = new ArrayList<StructuredTextType>();
            }
            return this.modeOfIntroduction;
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
     *         &lt;element name="Observed_Example" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Observed_Example_Reference" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *                   &lt;element name="Observed_Example_Description" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="Observed_Example_Link" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "observedExample"
    })
    public static class ObservedExamples {

        @XmlElement(name = "Observed_Example", required = true)
        protected List<Category.ObservedExamples.ObservedExample> observedExample;

        /**
         * Gets the value of the observedExample property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the observedExample property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getObservedExample().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Category.ObservedExamples.ObservedExample }
         * 
         * 
         */
        public List<Category.ObservedExamples.ObservedExample> getObservedExample() {
            if (observedExample == null) {
                observedExample = new ArrayList<Category.ObservedExamples.ObservedExample>();
            }
            return this.observedExample;
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
         *         &lt;element name="Observed_Example_Reference" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
         *         &lt;element name="Observed_Example_Description" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="Observed_Example_Link" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
            "observedExampleReference",
            "observedExampleDescription",
            "observedExampleLink"
        })
        public static class ObservedExample {

            @XmlElement(name = "Observed_Example_Reference")
            protected List<String> observedExampleReference;
            @XmlElement(name = "Observed_Example_Description", required = true)
            protected String observedExampleDescription;
            @XmlElement(name = "Observed_Example_Link")
            protected List<String> observedExampleLink;

            /**
             * Gets the value of the observedExampleReference property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the observedExampleReference property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getObservedExampleReference().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link String }
             * 
             * 
             */
            public List<String> getObservedExampleReference() {
                if (observedExampleReference == null) {
                    observedExampleReference = new ArrayList<String>();
                }
                return this.observedExampleReference;
            }

            /**
             * Obtient la valeur de la propriété observedExampleDescription.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getObservedExampleDescription() {
                return observedExampleDescription;
            }

            /**
             * Définit la valeur de la propriété observedExampleDescription.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setObservedExampleDescription(String value) {
                this.observedExampleDescription = value;
            }

            /**
             * Gets the value of the observedExampleLink property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the observedExampleLink property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getObservedExampleLink().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link String }
             * 
             * 
             */
            public List<String> getObservedExampleLink() {
                if (observedExampleLink == null) {
                    observedExampleLink = new ArrayList<String>();
                }
                return this.observedExampleLink;
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
    public static class PotentialMitigations {

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
     *         &lt;element name="Related_Attack_Pattern" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="CAPEC_ID" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *                 &lt;attribute name="CAPEC_Version" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
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
        "relatedAttackPattern"
    })
    public static class RelatedAttackPatterns {

        @XmlElement(name = "Related_Attack_Pattern", required = true)
        protected List<Category.RelatedAttackPatterns.RelatedAttackPattern> relatedAttackPattern;

        /**
         * Gets the value of the relatedAttackPattern property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the relatedAttackPattern property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getRelatedAttackPattern().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Category.RelatedAttackPatterns.RelatedAttackPattern }
         * 
         * 
         */
        public List<Category.RelatedAttackPatterns.RelatedAttackPattern> getRelatedAttackPattern() {
            if (relatedAttackPattern == null) {
                relatedAttackPattern = new ArrayList<Category.RelatedAttackPatterns.RelatedAttackPattern>();
            }
            return this.relatedAttackPattern;
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
         *         &lt;element name="CAPEC_ID" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *       &lt;/sequence>
         *       &lt;attribute name="CAPEC_Version" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "capecid"
        })
        public static class RelatedAttackPattern {

            @XmlElement(name = "CAPEC_ID", required = true)
            protected String capecid;
            @XmlAttribute(name = "CAPEC_Version", required = true)
            @XmlSchemaType(name = "anySimpleType")
            protected String capecVersion;

            /**
             * Obtient la valeur de la propriété capecid.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCAPECID() {
                return capecid;
            }

            /**
             * Définit la valeur de la propriété capecid.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCAPECID(String value) {
                this.capecid = value;
            }

            /**
             * Obtient la valeur de la propriété capecVersion.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCAPECVersion() {
                return capecVersion;
            }

            /**
             * Définit la valeur de la propriété capecVersion.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCAPECVersion(String value) {
                this.capecVersion = value;
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
     *         &lt;element name="Relevant_Property" maxOccurs="unbounded">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;enumeration value="Accessibility"/>
     *               &lt;enumeration value="Mutability"/>
     *               &lt;enumeration value="Trustability"/>
     *               &lt;enumeration value="Validity"/>
     *               &lt;enumeration value="Equivalence"/>
     *               &lt;enumeration value="Uniqueness"/>
     *               &lt;enumeration value="Predictability"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
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
        "relevantProperty"
    })
    public static class RelevantProperties {

        @XmlElement(name = "Relevant_Property", required = true)
        protected List<String> relevantProperty;

        /**
         * Gets the value of the relevantProperty property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the relevantProperty property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getRelevantProperty().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getRelevantProperty() {
            if (relevantProperty == null) {
                relevantProperty = new ArrayList<String>();
            }
            return this.relevantProperty;
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
     *         &lt;element name="Taxonomy_Mapping" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Mapped_Node_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="Mapped_Node_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="Mapping_Fit" minOccurs="0">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;enumeration value="Exact"/>
     *                         &lt;enumeration value="CWE_More_Abstract"/>
     *                         &lt;enumeration value="CWE_More_Specific"/>
     *                         &lt;enumeration value="Imprecise"/>
     *                         &lt;enumeration value="Perspective"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *                 &lt;attribute name="Mapped_Taxonomy_Name" use="required">
     *                   &lt;simpleType>
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                       &lt;whiteSpace value="collapse"/>
     *                       &lt;enumeration value="7 Pernicious Kingdoms"/>
     *                       &lt;enumeration value="19 Deadly Sins"/>
     *                       &lt;enumeration value="Anonymous Tool Vendor (under NDA)"/>
     *                       &lt;enumeration value="Aslam"/>
     *                       &lt;enumeration value="Bishop"/>
     *                       &lt;enumeration value="CLASP"/>
     *                       &lt;enumeration value="Landwehr"/>
     *                       &lt;enumeration value="OWASP Top Ten 2004"/>
     *                       &lt;enumeration value="OWASP Top Ten 2007"/>
     *                       &lt;enumeration value="PLOVER"/>
     *                       &lt;enumeration value="Protection Analysis"/>
     *                       &lt;enumeration value="RISOS"/>
     *                       &lt;enumeration value="Weber, Karger, Paradkar"/>
     *                       &lt;enumeration value="WASC"/>
     *                       &lt;enumeration value="CERT C Secure Coding"/>
     *                       &lt;enumeration value="CERT Java Secure Coding"/>
     *                       &lt;enumeration value="CERT C++ Secure Coding"/>
     *                       &lt;enumeration value="Software Fault Patterns"/>
     *                     &lt;/restriction>
     *                   &lt;/simpleType>
     *                 &lt;/attribute>
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
        "taxonomyMapping"
    })
    public static class TaxonomyMappings {

        @XmlElement(name = "Taxonomy_Mapping", required = true)
        protected List<Category.TaxonomyMappings.TaxonomyMapping> taxonomyMapping;

        /**
         * Gets the value of the taxonomyMapping property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the taxonomyMapping property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getTaxonomyMapping().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Category.TaxonomyMappings.TaxonomyMapping }
         * 
         * 
         */
        public List<Category.TaxonomyMappings.TaxonomyMapping> getTaxonomyMapping() {
            if (taxonomyMapping == null) {
                taxonomyMapping = new ArrayList<Category.TaxonomyMappings.TaxonomyMapping>();
            }
            return this.taxonomyMapping;
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
         *         &lt;element name="Mapped_Node_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="Mapped_Node_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="Mapping_Fit" minOccurs="0">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;enumeration value="Exact"/>
         *               &lt;enumeration value="CWE_More_Abstract"/>
         *               &lt;enumeration value="CWE_More_Specific"/>
         *               &lt;enumeration value="Imprecise"/>
         *               &lt;enumeration value="Perspective"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *       &lt;/sequence>
         *       &lt;attribute name="Mapped_Taxonomy_Name" use="required">
         *         &lt;simpleType>
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *             &lt;whiteSpace value="collapse"/>
         *             &lt;enumeration value="7 Pernicious Kingdoms"/>
         *             &lt;enumeration value="19 Deadly Sins"/>
         *             &lt;enumeration value="Anonymous Tool Vendor (under NDA)"/>
         *             &lt;enumeration value="Aslam"/>
         *             &lt;enumeration value="Bishop"/>
         *             &lt;enumeration value="CLASP"/>
         *             &lt;enumeration value="Landwehr"/>
         *             &lt;enumeration value="OWASP Top Ten 2004"/>
         *             &lt;enumeration value="OWASP Top Ten 2007"/>
         *             &lt;enumeration value="PLOVER"/>
         *             &lt;enumeration value="Protection Analysis"/>
         *             &lt;enumeration value="RISOS"/>
         *             &lt;enumeration value="Weber, Karger, Paradkar"/>
         *             &lt;enumeration value="WASC"/>
         *             &lt;enumeration value="CERT C Secure Coding"/>
         *             &lt;enumeration value="CERT Java Secure Coding"/>
         *             &lt;enumeration value="CERT C++ Secure Coding"/>
         *             &lt;enumeration value="Software Fault Patterns"/>
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
            "mappedNodeName",
            "mappedNodeID",
            "mappingFit"
        })
        public static class TaxonomyMapping {

            @XmlElement(name = "Mapped_Node_Name")
            protected String mappedNodeName;
            @XmlElement(name = "Mapped_Node_ID")
            protected String mappedNodeID;
            @XmlElement(name = "Mapping_Fit")
            protected String mappingFit;
            @XmlAttribute(name = "Mapped_Taxonomy_Name", required = true)
            protected String mappedTaxonomyName;

            /**
             * Obtient la valeur de la propriété mappedNodeName.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getMappedNodeName() {
                return mappedNodeName;
            }

            /**
             * Définit la valeur de la propriété mappedNodeName.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setMappedNodeName(String value) {
                this.mappedNodeName = value;
            }

            /**
             * Obtient la valeur de la propriété mappedNodeID.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getMappedNodeID() {
                return mappedNodeID;
            }

            /**
             * Définit la valeur de la propriété mappedNodeID.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setMappedNodeID(String value) {
                this.mappedNodeID = value;
            }

            /**
             * Obtient la valeur de la propriété mappingFit.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getMappingFit() {
                return mappingFit;
            }

            /**
             * Définit la valeur de la propriété mappingFit.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setMappingFit(String value) {
                this.mappingFit = value;
            }

            /**
             * Obtient la valeur de la propriété mappedTaxonomyName.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getMappedTaxonomyName() {
                return mappedTaxonomyName;
            }

            /**
             * Définit la valeur de la propriété mappedTaxonomyName.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setMappedTaxonomyName(String value) {
                this.mappedTaxonomyName = value;
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
     *         &lt;element name="Terminology_Note" type="{}Structured_Text_Type" maxOccurs="unbounded"/>
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
        "terminologyNote"
    })
    public static class TerminologyNotes {

        @XmlElement(name = "Terminology_Note", required = true)
        protected List<StructuredTextType> terminologyNote;

        /**
         * Gets the value of the terminologyNote property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the terminologyNote property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getTerminologyNote().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link StructuredTextType }
         * 
         * 
         */
        public List<StructuredTextType> getTerminologyNote() {
            if (terminologyNote == null) {
                terminologyNote = new ArrayList<StructuredTextType>();
            }
            return this.terminologyNote;
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
     *         &lt;element name="Theoretical_Note" type="{}Structured_Text_Type" maxOccurs="unbounded"/>
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
        "theoreticalNote"
    })
    public static class TheoreticalNotes {

        @XmlElement(name = "Theoretical_Note", required = true)
        protected List<StructuredTextType> theoreticalNote;

        /**
         * Gets the value of the theoreticalNote property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the theoreticalNote property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getTheoreticalNote().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link StructuredTextType }
         * 
         * 
         */
        public List<StructuredTextType> getTheoreticalNote() {
            if (theoreticalNote == null) {
                theoreticalNote = new ArrayList<StructuredTextType>();
            }
            return this.theoreticalNote;
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
     *         &lt;element name="Introductory_Phase" type="{}SDLC_Phase_Type" maxOccurs="unbounded" minOccurs="0"/>
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
        "introductoryPhase"
    })
    public static class TimeOfIntroduction {

        @XmlElement(name = "Introductory_Phase")
        @XmlSchemaType(name = "string")
        protected List<SDLCPhaseType> introductoryPhase;

        /**
         * Gets the value of the introductoryPhase property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the introductoryPhase property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getIntroductoryPhase().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link SDLCPhaseType }
         * 
         * 
         */
        public List<SDLCPhaseType> getIntroductoryPhase() {
            if (introductoryPhase == null) {
                introductoryPhase = new ArrayList<SDLCPhaseType>();
            }
            return this.introductoryPhase;
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
     *         &lt;element name="Weakness_Ordinality" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Ordinality">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;enumeration value="Primary"/>
     *                         &lt;enumeration value="Resultant"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="Ordinality_Description" type="{}Structured_Text_Type" minOccurs="0"/>
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
        "weaknessOrdinality"
    })
    public static class WeaknessOrdinalities {

        @XmlElement(name = "Weakness_Ordinality", required = true)
        protected List<Category.WeaknessOrdinalities.WeaknessOrdinality> weaknessOrdinality;

        /**
         * Gets the value of the weaknessOrdinality property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the weaknessOrdinality property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getWeaknessOrdinality().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Category.WeaknessOrdinalities.WeaknessOrdinality }
         * 
         * 
         */
        public List<Category.WeaknessOrdinalities.WeaknessOrdinality> getWeaknessOrdinality() {
            if (weaknessOrdinality == null) {
                weaknessOrdinality = new ArrayList<Category.WeaknessOrdinalities.WeaknessOrdinality>();
            }
            return this.weaknessOrdinality;
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
         *         &lt;element name="Ordinality">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;enumeration value="Primary"/>
         *               &lt;enumeration value="Resultant"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="Ordinality_Description" type="{}Structured_Text_Type" minOccurs="0"/>
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
            "ordinality",
            "ordinalityDescription"
        })
        public static class WeaknessOrdinality {

            @XmlElement(name = "Ordinality", required = true)
            protected String ordinality;
            @XmlElement(name = "Ordinality_Description")
            protected StructuredTextType ordinalityDescription;

            /**
             * Obtient la valeur de la propriété ordinality.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getOrdinality() {
                return ordinality;
            }

            /**
             * Définit la valeur de la propriété ordinality.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setOrdinality(String value) {
                this.ordinality = value;
            }

            /**
             * Obtient la valeur de la propriété ordinalityDescription.
             * 
             * @return
             *     possible object is
             *     {@link StructuredTextType }
             *     
             */
            public StructuredTextType getOrdinalityDescription() {
                return ordinalityDescription;
            }

            /**
             * Définit la valeur de la propriété ordinalityDescription.
             * 
             * @param value
             *     allowed object is
             *     {@link StructuredTextType }
             *     
             */
            public void setOrdinalityDescription(StructuredTextType value) {
                this.ordinalityDescription = value;
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
     *         &lt;element name="White_Box_Definition" type="{}Structured_Text_Type" maxOccurs="unbounded"/>
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
        "whiteBoxDefinition"
    })
    public static class WhiteBoxDefinitions {

        @XmlElement(name = "White_Box_Definition", required = true)
        protected List<StructuredTextType> whiteBoxDefinition;

        /**
         * Gets the value of the whiteBoxDefinition property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the whiteBoxDefinition property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getWhiteBoxDefinition().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link StructuredTextType }
         * 
         * 
         */
        public List<StructuredTextType> getWhiteBoxDefinition() {
            if (whiteBoxDefinition == null) {
                whiteBoxDefinition = new ArrayList<StructuredTextType>();
            }
            return this.whiteBoxDefinition;
        }

    }

}
