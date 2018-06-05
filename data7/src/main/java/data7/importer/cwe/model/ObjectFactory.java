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

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the lu.jimenez.research.cweparser.generatedObject package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and data7.importer.cwe.model
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _BlockImageImageTitle_QNAME = new QName("", "Image_Title");
    private final static QName _BlockImageImageLocation_QNAME = new QName("", "Image_Location");
    private final static QName _StructuredTextTypeTextTitle_QNAME = new QName("", "Text_Title");
    private final static QName _StructuredTextTypeComment_QNAME = new QName("", "Comment");
    private final static QName _StructuredTextTypeCodeExampleLanguage_QNAME = new QName("", "Code_Example_Language");
    private final static QName _StructuredTextTypeText_QNAME = new QName("", "Text");
    private final static QName _StructuredTextTypeImage_QNAME = new QName("", "Image");
    private final static QName _StructuredTextTypeCode_QNAME = new QName("", "Code");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: lu.jimenez.research.cweparser.generatedObject
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Category }
     * 
     */
    public Category createCategory() {
        return new Category();
    }

    /**
     * Create an instance of {@link Relationship }
     * 
     */
    public Relationship createRelationship() {
        return new Relationship();
    }

    /**
     * Create an instance of {@link AlternateTerms }
     * 
     */
    public AlternateTerms createAlternateTerms() {
        return new AlternateTerms();
    }

    /**
     * Create an instance of {@link ContentHistory }
     * 
     */
    public ContentHistory createContentHistory() {
        return new ContentHistory();
    }

    /**
     * Create an instance of {@link CommonConsequence }
     * 
     */
    public CommonConsequence createCommonConsequence() {
        return new CommonConsequence();
    }

    /**
     * Create an instance of {@link WeaknessCatalog }
     * 
     */
    public WeaknessCatalog createWeaknessCatalog() {
        return new WeaknessCatalog();
    }

    /**
     * Create an instance of {@link View }
     * 
     */
    public View createView() {
        return new View();
    }

    /**
     * Create an instance of {@link Mitigation }
     * 
     */
    public Mitigation createMitigation() {
        return new Mitigation();
    }

    /**
     * Create an instance of {@link Block }
     * 
     */
    public Block createBlock() {
        return new Block();
    }

    /**
     * Create an instance of {@link LanguagesListType }
     * 
     */
    public LanguagesListType createLanguagesListType() {
        return new LanguagesListType();
    }

    /**
     * Create an instance of {@link View.ViewAudience }
     * 
     */
    public View.ViewAudience createViewViewAudience() {
        return new View.ViewAudience();
    }

    /**
     * Create an instance of {@link ContentHistory.PreviousEntryNames }
     * 
     */
    public ContentHistory.PreviousEntryNames createContentHistoryPreviousEntryNames() {
        return new ContentHistory.PreviousEntryNames();
    }

    /**
     * Create an instance of {@link Category.RelatedAttackPatterns }
     * 
     */
    public Category.RelatedAttackPatterns createCategoryRelatedAttackPatterns() {
        return new Category.RelatedAttackPatterns();
    }

    /**
     * Create an instance of {@link Category.TaxonomyMappings }
     * 
     */
    public Category.TaxonomyMappings createCategoryTaxonomyMappings() {
        return new Category.TaxonomyMappings();
    }

    /**
     * Create an instance of {@link Category.ObservedExamples }
     * 
     */
    public Category.ObservedExamples createCategoryObservedExamples() {
        return new Category.ObservedExamples();
    }

    /**
     * Create an instance of {@link Category.DemonstrativeExamples }
     * 
     */
    public Category.DemonstrativeExamples createCategoryDemonstrativeExamples() {
        return new Category.DemonstrativeExamples();
    }

    /**
     * Create an instance of {@link Category.DetectionMethods }
     * 
     */
    public Category.DetectionMethods createCategoryDetectionMethods() {
        return new Category.DetectionMethods();
    }

    /**
     * Create an instance of {@link Category.ApplicablePlatforms }
     * 
     */
    public Category.ApplicablePlatforms createCategoryApplicablePlatforms() {
        return new Category.ApplicablePlatforms();
    }

    /**
     * Create an instance of {@link Category.ApplicablePlatforms.CommonPlatformReferences }
     * 
     */
    public Category.ApplicablePlatforms.CommonPlatformReferences createCategoryApplicablePlatformsCommonPlatformReferences() {
        return new Category.ApplicablePlatforms.CommonPlatformReferences();
    }

    /**
     * Create an instance of {@link Category.ApplicablePlatforms.TechnologyClasses }
     * 
     */
    public Category.ApplicablePlatforms.TechnologyClasses createCategoryApplicablePlatformsTechnologyClasses() {
        return new Category.ApplicablePlatforms.TechnologyClasses();
    }

    /**
     * Create an instance of {@link Category.ApplicablePlatforms.Environments }
     * 
     */
    public Category.ApplicablePlatforms.Environments createCategoryApplicablePlatformsEnvironments() {
        return new Category.ApplicablePlatforms.Environments();
    }

    /**
     * Create an instance of {@link Category.ApplicablePlatforms.ArchitecturalParadigms }
     * 
     */
    public Category.ApplicablePlatforms.ArchitecturalParadigms createCategoryApplicablePlatformsArchitecturalParadigms() {
        return new Category.ApplicablePlatforms.ArchitecturalParadigms();
    }

    /**
     * Create an instance of {@link Category.ApplicablePlatforms.HardwareArchitectures }
     * 
     */
    public Category.ApplicablePlatforms.HardwareArchitectures createCategoryApplicablePlatformsHardwareArchitectures() {
        return new Category.ApplicablePlatforms.HardwareArchitectures();
    }

    /**
     * Create an instance of {@link Category.ApplicablePlatforms.OperatingSystems }
     * 
     */
    public Category.ApplicablePlatforms.OperatingSystems createCategoryApplicablePlatformsOperatingSystems() {
        return new Category.ApplicablePlatforms.OperatingSystems();
    }

    /**
     * Create an instance of {@link Category.WeaknessOrdinalities }
     * 
     */
    public Category.WeaknessOrdinalities createCategoryWeaknessOrdinalities() {
        return new Category.WeaknessOrdinalities();
    }

    /**
     * Create an instance of {@link Relationship.RelationshipViews }
     * 
     */
    public Relationship.RelationshipViews createRelationshipRelationshipViews() {
        return new Relationship.RelationshipViews();
    }

    /**
     * Create an instance of {@link Category.Description }
     * 
     */
    public Category.Description createCategoryDescription() {
        return new Category.Description();
    }

    /**
     * Create an instance of {@link Relationships }
     * 
     */
    public Relationships createRelationships() {
        return new Relationships();
    }

    /**
     * Create an instance of {@link Relationship.RelationshipChains }
     * 
     */
    public Relationship.RelationshipChains createRelationshipRelationshipChains() {
        return new Relationship.RelationshipChains();
    }

    /**
     * Create an instance of {@link RelationshipNotes }
     * 
     */
    public RelationshipNotes createRelationshipNotes() {
        return new RelationshipNotes();
    }

    /**
     * Create an instance of {@link StructuredTextType }
     * 
     */
    public StructuredTextType createStructuredTextType() {
        return new StructuredTextType();
    }

    /**
     * Create an instance of {@link MaintenanceNotes }
     * 
     */
    public MaintenanceNotes createMaintenanceNotes() {
        return new MaintenanceNotes();
    }

    /**
     * Create an instance of {@link Category.BackgroundDetails }
     * 
     */
    public Category.BackgroundDetails createCategoryBackgroundDetails() {
        return new Category.BackgroundDetails();
    }

    /**
     * Create an instance of {@link OtherNotes }
     * 
     */
    public OtherNotes createOtherNotes() {
        return new OtherNotes();
    }

    /**
     * Create an instance of {@link AlternateTerms.AlternateTerm }
     * 
     */
    public AlternateTerms.AlternateTerm createAlternateTermsAlternateTerm() {
        return new AlternateTerms.AlternateTerm();
    }

    /**
     * Create an instance of {@link Category.TerminologyNotes }
     * 
     */
    public Category.TerminologyNotes createCategoryTerminologyNotes() {
        return new Category.TerminologyNotes();
    }

    /**
     * Create an instance of {@link Category.TimeOfIntroduction }
     * 
     */
    public Category.TimeOfIntroduction createCategoryTimeOfIntroduction() {
        return new Category.TimeOfIntroduction();
    }

    /**
     * Create an instance of {@link Category.ModesOfIntroduction }
     * 
     */
    public Category.ModesOfIntroduction createCategoryModesOfIntroduction() {
        return new Category.ModesOfIntroduction();
    }

    /**
     * Create an instance of {@link Category.EnablingFactorsForExploitation }
     * 
     */
    public Category.EnablingFactorsForExploitation createCategoryEnablingFactorsForExploitation() {
        return new Category.EnablingFactorsForExploitation();
    }

    /**
     * Create an instance of {@link Category.CommonConsequences }
     * 
     */
    public Category.CommonConsequences createCategoryCommonConsequences() {
        return new Category.CommonConsequences();
    }

    /**
     * Create an instance of {@link Category.PotentialMitigations }
     * 
     */
    public Category.PotentialMitigations createCategoryPotentialMitigations() {
        return new Category.PotentialMitigations();
    }

    /**
     * Create an instance of {@link Category.TheoreticalNotes }
     * 
     */
    public Category.TheoreticalNotes createCategoryTheoreticalNotes() {
        return new Category.TheoreticalNotes();
    }

    /**
     * Create an instance of {@link Category.FunctionalAreas }
     * 
     */
    public Category.FunctionalAreas createCategoryFunctionalAreas() {
        return new Category.FunctionalAreas();
    }

    /**
     * Create an instance of {@link Category.RelevantProperties }
     * 
     */
    public Category.RelevantProperties createCategoryRelevantProperties() {
        return new Category.RelevantProperties();
    }

    /**
     * Create an instance of {@link Category.AffectedResources }
     * 
     */
    public Category.AffectedResources createCategoryAffectedResources() {
        return new Category.AffectedResources();
    }

    /**
     * Create an instance of {@link ResearchGaps }
     * 
     */
    public ResearchGaps createResearchGaps() {
        return new ResearchGaps();
    }

    /**
     * Create an instance of {@link ReferenceListType }
     * 
     */
    public ReferenceListType createReferenceListType() {
        return new ReferenceListType();
    }

    /**
     * Create an instance of {@link Category.WhiteBoxDefinitions }
     * 
     */
    public Category.WhiteBoxDefinitions createCategoryWhiteBoxDefinitions() {
        return new Category.WhiteBoxDefinitions();
    }

    /**
     * Create an instance of {@link Category.BlackBoxDefinitions }
     * 
     */
    public Category.BlackBoxDefinitions createCategoryBlackBoxDefinitions() {
        return new Category.BlackBoxDefinitions();
    }

    /**
     * Create an instance of {@link ContentHistory.Submission }
     * 
     */
    public ContentHistory.Submission createContentHistorySubmission() {
        return new ContentHistory.Submission();
    }

    /**
     * Create an instance of {@link ContentHistory.Contribution }
     * 
     */
    public ContentHistory.Contribution createContentHistoryContribution() {
        return new ContentHistory.Contribution();
    }

    /**
     * Create an instance of {@link ContentHistory.Modification }
     * 
     */
    public ContentHistory.Modification createContentHistoryModification() {
        return new ContentHistory.Modification();
    }

    /**
     * Create an instance of {@link CommonConsequence.ConsequenceTechnicalImpact }
     * 
     */
    public CommonConsequence.ConsequenceTechnicalImpact createCommonConsequenceConsequenceTechnicalImpact() {
        return new CommonConsequence.ConsequenceTechnicalImpact();
    }

    /**
     * Create an instance of {@link WeaknessCatalog.Views }
     * 
     */
    public WeaknessCatalog.Views createWeaknessCatalogViews() {
        return new WeaknessCatalog.Views();
    }

    /**
     * Create an instance of {@link WeaknessCatalog.Categories }
     * 
     */
    public WeaknessCatalog.Categories createWeaknessCatalogCategories() {
        return new WeaknessCatalog.Categories();
    }

    /**
     * Create an instance of {@link WeaknessCatalog.Weaknesses }
     * 
     */
    public WeaknessCatalog.Weaknesses createWeaknessCatalogWeaknesses() {
        return new WeaknessCatalog.Weaknesses();
    }

    /**
     * Create an instance of {@link WeaknessCatalog.CompoundElements }
     * 
     */
    public WeaknessCatalog.CompoundElements createWeaknessCatalogCompoundElements() {
        return new WeaknessCatalog.CompoundElements();
    }

    /**
     * Create an instance of {@link Mitigation.SubMitigations }
     * 
     */
    public Mitigation.SubMitigations createMitigationSubMitigations() {
        return new Mitigation.SubMitigations();
    }

    /**
     * Create an instance of {@link Weakness }
     * 
     */
    public Weakness createWeakness() {
        return new Weakness();
    }

    /**
     * Create an instance of {@link Block.Image }
     * 
     */
    public Block.Image createBlockImage() {
        return new Block.Image();
    }

    /**
     * Create an instance of {@link CompoundElement }
     * 
     */
    public CompoundElement createCompoundElement() {
        return new CompoundElement();
    }

    /**
     * Create an instance of {@link ReferenceType }
     * 
     */
    public ReferenceType createReferenceType() {
        return new ReferenceType();
    }

    /**
     * Create an instance of {@link LanguagesListType.Language }
     * 
     */
    public LanguagesListType.Language createLanguagesListTypeLanguage() {
        return new LanguagesListType.Language();
    }

    /**
     * Create an instance of {@link LanguagesListType.LanguageClass }
     * 
     */
    public LanguagesListType.LanguageClass createLanguagesListTypeLanguageClass() {
        return new LanguagesListType.LanguageClass();
    }

    /**
     * Create an instance of {@link View.ViewAudience.Audience }
     * 
     */
    public View.ViewAudience.Audience createViewViewAudienceAudience() {
        return new View.ViewAudience.Audience();
    }

    /**
     * Create an instance of {@link ContentHistory.PreviousEntryNames.PreviousEntryName }
     * 
     */
    public ContentHistory.PreviousEntryNames.PreviousEntryName createContentHistoryPreviousEntryNamesPreviousEntryName() {
        return new ContentHistory.PreviousEntryNames.PreviousEntryName();
    }

    /**
     * Create an instance of {@link Category.RelatedAttackPatterns.RelatedAttackPattern }
     * 
     */
    public Category.RelatedAttackPatterns.RelatedAttackPattern createCategoryRelatedAttackPatternsRelatedAttackPattern() {
        return new Category.RelatedAttackPatterns.RelatedAttackPattern();
    }

    /**
     * Create an instance of {@link Category.TaxonomyMappings.TaxonomyMapping }
     * 
     */
    public Category.TaxonomyMappings.TaxonomyMapping createCategoryTaxonomyMappingsTaxonomyMapping() {
        return new Category.TaxonomyMappings.TaxonomyMapping();
    }

    /**
     * Create an instance of {@link Category.ObservedExamples.ObservedExample }
     * 
     */
    public Category.ObservedExamples.ObservedExample createCategoryObservedExamplesObservedExample() {
        return new Category.ObservedExamples.ObservedExample();
    }

    /**
     * Create an instance of {@link Category.DemonstrativeExamples.DemonstrativeExample }
     * 
     */
    public Category.DemonstrativeExamples.DemonstrativeExample createCategoryDemonstrativeExamplesDemonstrativeExample() {
        return new Category.DemonstrativeExamples.DemonstrativeExample();
    }

    /**
     * Create an instance of {@link Category.DetectionMethods.DetectionMethod }
     * 
     */
    public Category.DetectionMethods.DetectionMethod createCategoryDetectionMethodsDetectionMethod() {
        return new Category.DetectionMethods.DetectionMethod();
    }

    /**
     * Create an instance of {@link Category.ApplicablePlatforms.CommonPlatformReferences.CommonPlatformReference }
     * 
     */
    public Category.ApplicablePlatforms.CommonPlatformReferences.CommonPlatformReference createCategoryApplicablePlatformsCommonPlatformReferencesCommonPlatformReference() {
        return new Category.ApplicablePlatforms.CommonPlatformReferences.CommonPlatformReference();
    }

    /**
     * Create an instance of {@link Category.ApplicablePlatforms.TechnologyClasses.TechnologyClass }
     * 
     */
    public Category.ApplicablePlatforms.TechnologyClasses.TechnologyClass createCategoryApplicablePlatformsTechnologyClassesTechnologyClass() {
        return new Category.ApplicablePlatforms.TechnologyClasses.TechnologyClass();
    }

    /**
     * Create an instance of {@link Category.ApplicablePlatforms.Environments.Environment }
     * 
     */
    public Category.ApplicablePlatforms.Environments.Environment createCategoryApplicablePlatformsEnvironmentsEnvironment() {
        return new Category.ApplicablePlatforms.Environments.Environment();
    }

    /**
     * Create an instance of {@link Category.ApplicablePlatforms.ArchitecturalParadigms.ArchitecturalParadigm }
     * 
     */
    public Category.ApplicablePlatforms.ArchitecturalParadigms.ArchitecturalParadigm createCategoryApplicablePlatformsArchitecturalParadigmsArchitecturalParadigm() {
        return new Category.ApplicablePlatforms.ArchitecturalParadigms.ArchitecturalParadigm();
    }

    /**
     * Create an instance of {@link Category.ApplicablePlatforms.HardwareArchitectures.HardwareArchitecture }
     * 
     */
    public Category.ApplicablePlatforms.HardwareArchitectures.HardwareArchitecture createCategoryApplicablePlatformsHardwareArchitecturesHardwareArchitecture() {
        return new Category.ApplicablePlatforms.HardwareArchitectures.HardwareArchitecture();
    }

    /**
     * Create an instance of {@link Category.ApplicablePlatforms.HardwareArchitectures.HardwareArchitectureClass }
     * 
     */
    public Category.ApplicablePlatforms.HardwareArchitectures.HardwareArchitectureClass createCategoryApplicablePlatformsHardwareArchitecturesHardwareArchitectureClass() {
        return new Category.ApplicablePlatforms.HardwareArchitectures.HardwareArchitectureClass();
    }

    /**
     * Create an instance of {@link Category.ApplicablePlatforms.OperatingSystems.OperatingSystem }
     * 
     */
    public Category.ApplicablePlatforms.OperatingSystems.OperatingSystem createCategoryApplicablePlatformsOperatingSystemsOperatingSystem() {
        return new Category.ApplicablePlatforms.OperatingSystems.OperatingSystem();
    }

    /**
     * Create an instance of {@link Category.ApplicablePlatforms.OperatingSystems.OperatingSystemClass }
     * 
     */
    public Category.ApplicablePlatforms.OperatingSystems.OperatingSystemClass createCategoryApplicablePlatformsOperatingSystemsOperatingSystemClass() {
        return new Category.ApplicablePlatforms.OperatingSystems.OperatingSystemClass();
    }

    /**
     * Create an instance of {@link Category.WeaknessOrdinalities.WeaknessOrdinality }
     * 
     */
    public Category.WeaknessOrdinalities.WeaknessOrdinality createCategoryWeaknessOrdinalitiesWeaknessOrdinality() {
        return new Category.WeaknessOrdinalities.WeaknessOrdinality();
    }

    /**
     * Create an instance of {@link Relationship.RelationshipViews.RelationshipViewID }
     * 
     */
    public Relationship.RelationshipViews.RelationshipViewID createRelationshipRelationshipViewsRelationshipViewID() {
        return new Relationship.RelationshipViews.RelationshipViewID();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Image_Title", scope = Block.Image.class)
    public JAXBElement<String> createBlockImageImageTitle(String value) {
        return new JAXBElement<String>(_BlockImageImageTitle_QNAME, String.class, Block.Image.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Image_Location", scope = Block.Image.class)
    public JAXBElement<String> createBlockImageImageLocation(String value) {
        return new JAXBElement<String>(_BlockImageImageLocation_QNAME, String.class, Block.Image.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Text_Title", scope = StructuredTextType.class)
    public JAXBElement<String> createStructuredTextTypeTextTitle(String value) {
        return new JAXBElement<String>(_StructuredTextTypeTextTitle_QNAME, String.class, StructuredTextType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Comment", scope = StructuredTextType.class)
    public JAXBElement<String> createStructuredTextTypeComment(String value) {
        return new JAXBElement<String>(_StructuredTextTypeComment_QNAME, String.class, StructuredTextType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Code_Example_Language", scope = StructuredTextType.class)
    public JAXBElement<String> createStructuredTextTypeCodeExampleLanguage(String value) {
        return new JAXBElement<String>(_StructuredTextTypeCodeExampleLanguage_QNAME, String.class, StructuredTextType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Text", scope = StructuredTextType.class)
    public JAXBElement<String> createStructuredTextTypeText(String value) {
        return new JAXBElement<String>(_StructuredTextTypeText_QNAME, String.class, StructuredTextType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Block.Image }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Image", scope = StructuredTextType.class)
    public JAXBElement<Block.Image> createStructuredTextTypeImage(Block.Image value) {
        return new JAXBElement<Block.Image>(_StructuredTextTypeImage_QNAME, Block.Image.class, StructuredTextType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Code", scope = StructuredTextType.class)
    public JAXBElement<String> createStructuredTextTypeCode(String value) {
        return new JAXBElement<String>(_StructuredTextTypeCode_QNAME, String.class, StructuredTextType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Text_Title", scope = Block.class)
    public JAXBElement<String> createBlockTextTitle(String value) {
        return new JAXBElement<String>(_StructuredTextTypeTextTitle_QNAME, String.class, Block.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Comment", scope = Block.class)
    public JAXBElement<String> createBlockComment(String value) {
        return new JAXBElement<String>(_StructuredTextTypeComment_QNAME, String.class, Block.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Code_Example_Language", scope = Block.class)
    public JAXBElement<String> createBlockCodeExampleLanguage(String value) {
        return new JAXBElement<String>(_StructuredTextTypeCodeExampleLanguage_QNAME, String.class, Block.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Text", scope = Block.class)
    public JAXBElement<String> createBlockText(String value) {
        return new JAXBElement<String>(_StructuredTextTypeText_QNAME, String.class, Block.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Block.Image }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Image", scope = Block.class)
    public JAXBElement<Block.Image> createBlockImage(Block.Image value) {
        return new JAXBElement<Block.Image>(_StructuredTextTypeImage_QNAME, Block.Image.class, Block.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Code", scope = Block.class)
    public JAXBElement<String> createBlockCode(String value) {
        return new JAXBElement<String>(_StructuredTextTypeCode_QNAME, String.class, Block.class, value);
    }

}
