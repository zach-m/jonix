/*
 * Copyright (C) 2012 Zach Melamed
 * 
 * Latest version available online at https://github.com/zach-m/jonix
 * Contact me at zach@tectonica.co.il
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tectonica.jonix.onix3;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.ListOfOnixDataComposite;
import com.tectonica.jonix.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.ListOfOnixElement;
import com.tectonica.jonix.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.codelist.AudienceCodeTypes;
import com.tectonica.jonix.codelist.Audiences;
import com.tectonica.jonix.codelist.EditionTypes;
import com.tectonica.jonix.codelist.EpublicationTechnicalProtections;
import com.tectonica.jonix.codelist.ExtentTypes;
import com.tectonica.jonix.codelist.IllustrationAndOtherContentTypes;
import com.tectonica.jonix.codelist.LanguageRoles;
import com.tectonica.jonix.codelist.MeasureTypes;
import com.tectonica.jonix.codelist.ProductClassificationTypes;
import com.tectonica.jonix.codelist.ProductContentTypes;
import com.tectonica.jonix.codelist.ProductFormDetailsList175;
import com.tectonica.jonix.codelist.ProductFormFeatureTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixAncillaryContent;
import com.tectonica.jonix.struct.JonixAudience;
import com.tectonica.jonix.struct.JonixAudienceRange;
import com.tectonica.jonix.struct.JonixComplexity;
import com.tectonica.jonix.struct.JonixExtent;
import com.tectonica.jonix.struct.JonixLanguage;
import com.tectonica.jonix.struct.JonixMeasure;
import com.tectonica.jonix.struct.JonixProductClassification;
import com.tectonica.jonix.struct.JonixProductFormFeature;
import com.tectonica.jonix.struct.JonixSubject;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>null</h1>
 * <h4 class="nobreak">Descriptive detail composite</h4>
 * <p>
 * The descriptive detail block covers data element Groups P.3 to P.13, all of which are essentially part of the factual
 * description of the form and content of a product. The block as a whole is non-repeating. It is mandatory in any
 * &lt;Product&gt; record unless the &lt;NotificationType&gt; in Group&nbsp;P.1 indicates that the record is an update
 * notice which carries only those blocks in which changes have occurred.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;DescriptiveDetail&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;descriptivedetail&gt;</td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;1</td>
 * </tr>
 * </table>
 */
public class DescriptiveDetail implements OnixSuperComposite, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "DescriptiveDetail";
	public static final String shortname = "descriptivedetail";

	/////////////////////////////////////////////////////////////////////////////////
	// ATTRIBUTES
	/////////////////////////////////////////////////////////////////////////////////

	/**
	 * (type: dt.DateOrDateTime)
	 */
	public String datestamp;

	public RecordSourceTypes sourcetype;

	public String sourcename;

	/////////////////////////////////////////////////////////////////////////////////
	// CONSTRUCTION
	/////////////////////////////////////////////////////////////////////////////////

	private boolean initialized;
	private final boolean exists;
	private final org.w3c.dom.Element element;
	public static final DescriptiveDetail EMPTY = new DescriptiveDetail();

	public DescriptiveDetail()
	{
		exists = false;
		element = null;
		initialized = true; // so that no further processing will be done on this intentionally-empty object
	}

	public DescriptiveDetail(org.w3c.dom.Element element)
	{
		exists = true;
		initialized = false;
		this.element = element;
	}

	private void initialize()
	{
		if (initialized)
			return;
		initialized = true;

		datestamp = JPU.getAttribute(element, "datestamp");
		sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
		sourcename = JPU.getAttribute(element, "sourcename");

		JPU.forElementsOf(element, e -> {
			final String name = e.getNodeName();
			if (name.equals(ProductComposition.refname) || name.equals(ProductComposition.shortname))
				productComposition = new ProductComposition(e);
			else if (name.equals(ProductForm.refname) || name.equals(ProductForm.shortname))
				productForm = new ProductForm(e);
			else if (name.equals(ProductFormDetail.refname) || name.equals(ProductFormDetail.shortname))
				productFormDetails = JPU.addToList(productFormDetails, new ProductFormDetail(e));
			else if (name.equals(ProductFormFeature.refname) || name.equals(ProductFormFeature.shortname))
				productFormFeatures = JPU.addToList(productFormFeatures, new ProductFormFeature(e));
			else if (name.equals(ProductPackaging.refname) || name.equals(ProductPackaging.shortname))
				productPackaging = new ProductPackaging(e);
			else if (name.equals(ProductFormDescription.refname) || name.equals(ProductFormDescription.shortname))
				productFormDescriptions = JPU.addToList(productFormDescriptions, new ProductFormDescription(e));
			else if (name.equals(TradeCategory.refname) || name.equals(TradeCategory.shortname))
				tradeCategory = new TradeCategory(e);
			else if (name.equals(PrimaryContentType.refname) || name.equals(PrimaryContentType.shortname))
				primaryContentType = new PrimaryContentType(e);
			else if (name.equals(ProductContentType.refname) || name.equals(ProductContentType.shortname))
				productContentTypes = JPU.addToList(productContentTypes, new ProductContentType(e));
			else if (name.equals(Measure.refname) || name.equals(Measure.shortname))
				measures = JPU.addToList(measures, new Measure(e));
			else if (name.equals(CountryOfManufacture.refname) || name.equals(CountryOfManufacture.shortname))
				countryOfManufacture = new CountryOfManufacture(e);
			else if (name.equals(EpubTechnicalProtection.refname) || name.equals(EpubTechnicalProtection.shortname))
				epubTechnicalProtections = JPU.addToList(epubTechnicalProtections, new EpubTechnicalProtection(e));
			else if (name.equals(EpubUsageConstraint.refname) || name.equals(EpubUsageConstraint.shortname))
				epubUsageConstraints = JPU.addToList(epubUsageConstraints, new EpubUsageConstraint(e));
			else if (name.equals(EpubLicense.refname) || name.equals(EpubLicense.shortname))
				epubLicense = new EpubLicense(e);
			else if (name.equals(MapScale.refname) || name.equals(MapScale.shortname))
				mapScales = JPU.addToList(mapScales, new MapScale(e));
			else if (name.equals(ProductClassification.refname) || name.equals(ProductClassification.shortname))
				productClassifications = JPU.addToList(productClassifications, new ProductClassification(e));
			else if (name.equals(ProductPart.refname) || name.equals(ProductPart.shortname))
				productParts = JPU.addToList(productParts, new ProductPart(e));
			else if (name.equals(Collection.refname) || name.equals(Collection.shortname))
				collections = JPU.addToList(collections, new Collection(e));
			else if (name.equals(NoCollection.refname) || name.equals(NoCollection.shortname))
				noCollection = new NoCollection(e);
			else if (name.equals(TitleDetail.refname) || name.equals(TitleDetail.shortname))
				titleDetails = JPU.addToList(titleDetails, new TitleDetail(e));
			else if (name.equals(ThesisType.refname) || name.equals(ThesisType.shortname))
				thesisType = new ThesisType(e);
			else if (name.equals(ThesisPresentedTo.refname) || name.equals(ThesisPresentedTo.shortname))
				thesisPresentedTo = new ThesisPresentedTo(e);
			else if (name.equals(ThesisYear.refname) || name.equals(ThesisYear.shortname))
				thesisYear = new ThesisYear(e);
			else if (name.equals(Contributor.refname) || name.equals(Contributor.shortname))
				contributors = JPU.addToList(contributors, new Contributor(e));
			else if (name.equals(ContributorStatement.refname) || name.equals(ContributorStatement.shortname))
				contributorStatements = JPU.addToList(contributorStatements, new ContributorStatement(e));
			else if (name.equals(NoContributor.refname) || name.equals(NoContributor.shortname))
				noContributor = new NoContributor(e);
			else if (name.equals(Conference.refname) || name.equals(Conference.shortname))
				conferences = JPU.addToList(conferences, new Conference(e));
			else if (name.equals(EditionType.refname) || name.equals(EditionType.shortname))
				editionTypes = JPU.addToList(editionTypes, new EditionType(e));
			else if (name.equals(EditionNumber.refname) || name.equals(EditionNumber.shortname))
				editionNumber = new EditionNumber(e);
			else if (name.equals(EditionVersionNumber.refname) || name.equals(EditionVersionNumber.shortname))
				editionVersionNumber = new EditionVersionNumber(e);
			else if (name.equals(EditionStatement.refname) || name.equals(EditionStatement.shortname))
				editionStatements = JPU.addToList(editionStatements, new EditionStatement(e));
			else if (name.equals(NoEdition.refname) || name.equals(NoEdition.shortname))
				noEdition = new NoEdition(e);
			else if (name.equals(ReligiousText.refname) || name.equals(ReligiousText.shortname))
				religiousText = new ReligiousText(e);
			else if (name.equals(Language.refname) || name.equals(Language.shortname))
				languages = JPU.addToList(languages, new Language(e));
			else if (name.equals(Extent.refname) || name.equals(Extent.shortname))
				extents = JPU.addToList(extents, new Extent(e));
			else if (name.equals(Illustrated.refname) || name.equals(Illustrated.shortname))
				illustrated = new Illustrated(e);
			else if (name.equals(NumberOfIllustrations.refname) || name.equals(NumberOfIllustrations.shortname))
				numberOfIllustrations = new NumberOfIllustrations(e);
			else if (name.equals(IllustrationsNote.refname) || name.equals(IllustrationsNote.shortname))
				illustrationsNotes = JPU.addToList(illustrationsNotes, new IllustrationsNote(e));
			else if (name.equals(AncillaryContent.refname) || name.equals(AncillaryContent.shortname))
				ancillaryContents = JPU.addToList(ancillaryContents, new AncillaryContent(e));
			else if (name.equals(Subject.refname) || name.equals(Subject.shortname))
				subjects = JPU.addToList(subjects, new Subject(e));
			else if (name.equals(NameAsSubject.refname) || name.equals(NameAsSubject.shortname))
				nameAsSubjects = JPU.addToList(nameAsSubjects, new NameAsSubject(e));
			else if (name.equals(AudienceCode.refname) || name.equals(AudienceCode.shortname))
				audienceCodes = JPU.addToList(audienceCodes, new AudienceCode(e));
			else if (name.equals(Audience.refname) || name.equals(Audience.shortname))
				audiences = JPU.addToList(audiences, new Audience(e));
			else if (name.equals(AudienceRange.refname) || name.equals(AudienceRange.shortname))
				audienceRanges = JPU.addToList(audienceRanges, new AudienceRange(e));
			else if (name.equals(AudienceDescription.refname) || name.equals(AudienceDescription.shortname))
				audienceDescriptions = JPU.addToList(audienceDescriptions, new AudienceDescription(e));
			else if (name.equals(Complexity.refname) || name.equals(Complexity.shortname))
				complexitys = JPU.addToList(complexitys, new Complexity(e));
		});
	}

	@Override
	public boolean exists()
	{
		return exists;
	}

	/////////////////////////////////////////////////////////////////////////////////
	// MEMBERS
	/////////////////////////////////////////////////////////////////////////////////

	private ProductComposition productComposition = ProductComposition.EMPTY;

	/**
	 * (this field is required)
	 */
	public ProductComposition productComposition()
	{
		initialize();
		return productComposition;
	}

	private ProductForm productForm = ProductForm.EMPTY;

	/**
	 * (this field is required)
	 */
	public ProductForm productForm()
	{
		initialize();
		return productForm;
	}

	private ListOfOnixElement<ProductFormDetail, ProductFormDetailsList175> productFormDetails = ListOfOnixElement
			.empty();

	/**
	 * (this list may be empty)
	 */
	public ListOfOnixElement<ProductFormDetail, ProductFormDetailsList175> productFormDetails()
	{
		initialize();
		return productFormDetails;
	}

	private ListOfOnixDataCompositeWithKey<ProductFormFeature, JonixProductFormFeature, ProductFormFeatureTypes> productFormFeatures = ListOfOnixDataCompositeWithKey
			.emptyKeyed();

	/**
	 * (this list may be empty)
	 */
	public ListOfOnixDataCompositeWithKey<ProductFormFeature, JonixProductFormFeature, ProductFormFeatureTypes> productFormFeatures()
	{
		initialize();
		return productFormFeatures;
	}

	private ProductPackaging productPackaging = ProductPackaging.EMPTY;

	/**
	 * (this field is optional)
	 */
	public ProductPackaging productPackaging()
	{
		initialize();
		return productPackaging;
	}

	private ListOfOnixElement<ProductFormDescription, String> productFormDescriptions = ListOfOnixElement.empty();

	/**
	 * (this list may be empty)
	 */
	public ListOfOnixElement<ProductFormDescription, String> productFormDescriptions()
	{
		initialize();
		return productFormDescriptions;
	}

	private TradeCategory tradeCategory = TradeCategory.EMPTY;

	/**
	 * (this field is optional)
	 */
	public TradeCategory tradeCategory()
	{
		initialize();
		return tradeCategory;
	}

	private PrimaryContentType primaryContentType = PrimaryContentType.EMPTY;

	/**
	 * (this field is optional)
	 */
	public PrimaryContentType primaryContentType()
	{
		initialize();
		return primaryContentType;
	}

	private ListOfOnixElement<ProductContentType, ProductContentTypes> productContentTypes = ListOfOnixElement.empty();

	/**
	 * (this list may be empty)
	 */
	public ListOfOnixElement<ProductContentType, ProductContentTypes> productContentTypes()
	{
		initialize();
		return productContentTypes;
	}

	private ListOfOnixDataCompositeWithKey<Measure, JonixMeasure, MeasureTypes> measures = ListOfOnixDataCompositeWithKey
			.emptyKeyed();

	/**
	 * (this list may be empty)
	 */
	public ListOfOnixDataCompositeWithKey<Measure, JonixMeasure, MeasureTypes> measures()
	{
		initialize();
		return measures;
	}

	private CountryOfManufacture countryOfManufacture = CountryOfManufacture.EMPTY;

	/**
	 * (this field is optional)
	 */
	public CountryOfManufacture countryOfManufacture()
	{
		initialize();
		return countryOfManufacture;
	}

	private ListOfOnixElement<EpubTechnicalProtection, EpublicationTechnicalProtections> epubTechnicalProtections = ListOfOnixElement
			.empty();

	/**
	 * (this list may be empty)
	 */
	public ListOfOnixElement<EpubTechnicalProtection, EpublicationTechnicalProtections> epubTechnicalProtections()
	{
		initialize();
		return epubTechnicalProtections;
	}

	private List<EpubUsageConstraint> epubUsageConstraints = Collections.emptyList();

	/**
	 * (this list may be empty)
	 */
	public List<EpubUsageConstraint> epubUsageConstraints()
	{
		initialize();
		return epubUsageConstraints;
	}

	private EpubLicense epubLicense = EpubLicense.EMPTY;

	/**
	 * (this field is optional)
	 */
	public EpubLicense epubLicense()
	{
		initialize();
		return epubLicense;
	}

	private ListOfOnixElement<MapScale, Integer> mapScales = ListOfOnixElement.empty();

	/**
	 * (this list may be empty)
	 */
	public ListOfOnixElement<MapScale, Integer> mapScales()
	{
		initialize();
		return mapScales;
	}

	private ListOfOnixDataCompositeWithKey<ProductClassification, JonixProductClassification, ProductClassificationTypes> productClassifications = ListOfOnixDataCompositeWithKey
			.emptyKeyed();

	/**
	 * (this list may be empty)
	 */
	public ListOfOnixDataCompositeWithKey<ProductClassification, JonixProductClassification, ProductClassificationTypes> productClassifications()
	{
		initialize();
		return productClassifications;
	}

	private List<ProductPart> productParts = Collections.emptyList();

	/**
	 * (this list may be empty)
	 */
	public List<ProductPart> productParts()
	{
		initialize();
		return productParts;
	}

	private List<Collection> collections = Collections.emptyList();

	/**
	 * (this list may be empty)
	 */
	public List<Collection> collections()
	{
		initialize();
		return collections;
	}

	private NoCollection noCollection = NoCollection.EMPTY;

	/**
	 * (this field is optional)
	 */
	public NoCollection noCollection()
	{
		initialize();
		return noCollection;
	}

	public boolean isNoCollection()
	{
		return (noCollection().exists());
	}

	private List<TitleDetail> titleDetails = Collections.emptyList();

	/**
	 * (this list is required to contain at least one item)
	 */
	public List<TitleDetail> titleDetails()
	{
		initialize();
		return titleDetails;
	}

	private ThesisType thesisType = ThesisType.EMPTY;

	/**
	 * (this field is optional)
	 */
	public ThesisType thesisType()
	{
		initialize();
		return thesisType;
	}

	private ThesisPresentedTo thesisPresentedTo = ThesisPresentedTo.EMPTY;

	/**
	 * (this field is optional)
	 */
	public ThesisPresentedTo thesisPresentedTo()
	{
		initialize();
		return thesisPresentedTo;
	}

	private ThesisYear thesisYear = ThesisYear.EMPTY;

	/**
	 * (this field is optional)
	 */
	public ThesisYear thesisYear()
	{
		initialize();
		return thesisYear;
	}

	private List<Contributor> contributors = Collections.emptyList();

	/**
	 * (this list is required to contain at least one item)
	 */
	public List<Contributor> contributors()
	{
		initialize();
		return contributors;
	}

	private ListOfOnixElement<ContributorStatement, String> contributorStatements = ListOfOnixElement.empty();

	/**
	 * (this list may be empty)
	 */
	public ListOfOnixElement<ContributorStatement, String> contributorStatements()
	{
		initialize();
		return contributorStatements;
	}

	private NoContributor noContributor = NoContributor.EMPTY;

	/**
	 * (this field is optional)
	 */
	public NoContributor noContributor()
	{
		initialize();
		return noContributor;
	}

	public boolean isNoContributor()
	{
		return (noContributor().exists());
	}

	private List<Conference> conferences = Collections.emptyList();

	/**
	 * (this list may be empty)
	 */
	public List<Conference> conferences()
	{
		initialize();
		return conferences;
	}

	private ListOfOnixElement<EditionType, EditionTypes> editionTypes = ListOfOnixElement.empty();

	/**
	 * (this list may be empty)
	 */
	public ListOfOnixElement<EditionType, EditionTypes> editionTypes()
	{
		initialize();
		return editionTypes;
	}

	private EditionNumber editionNumber = EditionNumber.EMPTY;

	/**
	 * (this field is optional)
	 */
	public EditionNumber editionNumber()
	{
		initialize();
		return editionNumber;
	}

	private EditionVersionNumber editionVersionNumber = EditionVersionNumber.EMPTY;

	/**
	 * (this field is optional)
	 */
	public EditionVersionNumber editionVersionNumber()
	{
		initialize();
		return editionVersionNumber;
	}

	private ListOfOnixElement<EditionStatement, String> editionStatements = ListOfOnixElement.empty();

	/**
	 * (this list may be empty)
	 */
	public ListOfOnixElement<EditionStatement, String> editionStatements()
	{
		initialize();
		return editionStatements;
	}

	private NoEdition noEdition = NoEdition.EMPTY;

	/**
	 * (this field is optional)
	 */
	public NoEdition noEdition()
	{
		initialize();
		return noEdition;
	}

	public boolean isNoEdition()
	{
		return (noEdition().exists());
	}

	private ReligiousText religiousText = ReligiousText.EMPTY;

	/**
	 * (this field is optional)
	 */
	public ReligiousText religiousText()
	{
		initialize();
		return religiousText;
	}

	private ListOfOnixDataCompositeWithKey<Language, JonixLanguage, LanguageRoles> languages = ListOfOnixDataCompositeWithKey
			.emptyKeyed();

	/**
	 * (this list may be empty)
	 */
	public ListOfOnixDataCompositeWithKey<Language, JonixLanguage, LanguageRoles> languages()
	{
		initialize();
		return languages;
	}

	private ListOfOnixDataCompositeWithKey<Extent, JonixExtent, ExtentTypes> extents = ListOfOnixDataCompositeWithKey
			.emptyKeyed();

	/**
	 * (this list may be empty)
	 */
	public ListOfOnixDataCompositeWithKey<Extent, JonixExtent, ExtentTypes> extents()
	{
		initialize();
		return extents;
	}

	private Illustrated illustrated = Illustrated.EMPTY;

	/**
	 * (this field is optional)
	 */
	public Illustrated illustrated()
	{
		initialize();
		return illustrated;
	}

	private NumberOfIllustrations numberOfIllustrations = NumberOfIllustrations.EMPTY;

	/**
	 * (this field is optional)
	 */
	public NumberOfIllustrations numberOfIllustrations()
	{
		initialize();
		return numberOfIllustrations;
	}

	private ListOfOnixElement<IllustrationsNote, String> illustrationsNotes = ListOfOnixElement.empty();

	/**
	 * (this list may be empty)
	 */
	public ListOfOnixElement<IllustrationsNote, String> illustrationsNotes()
	{
		initialize();
		return illustrationsNotes;
	}

	private ListOfOnixDataCompositeWithKey<AncillaryContent, JonixAncillaryContent, IllustrationAndOtherContentTypes> ancillaryContents = ListOfOnixDataCompositeWithKey
			.emptyKeyed();

	/**
	 * (this list may be empty)
	 */
	public ListOfOnixDataCompositeWithKey<AncillaryContent, JonixAncillaryContent, IllustrationAndOtherContentTypes> ancillaryContents()
	{
		initialize();
		return ancillaryContents;
	}

	private ListOfOnixDataComposite<Subject, JonixSubject> subjects = ListOfOnixDataComposite.empty();

	/**
	 * (this list may be empty)
	 */
	public ListOfOnixDataComposite<Subject, JonixSubject> subjects()
	{
		initialize();
		return subjects;
	}

	private List<NameAsSubject> nameAsSubjects = Collections.emptyList();

	/**
	 * (this list may be empty)
	 */
	public List<NameAsSubject> nameAsSubjects()
	{
		initialize();
		return nameAsSubjects;
	}

	private ListOfOnixElement<AudienceCode, Audiences> audienceCodes = ListOfOnixElement.empty();

	/**
	 * (this list may be empty)
	 */
	public ListOfOnixElement<AudienceCode, Audiences> audienceCodes()
	{
		initialize();
		return audienceCodes;
	}

	private ListOfOnixDataCompositeWithKey<Audience, JonixAudience, AudienceCodeTypes> audiences = ListOfOnixDataCompositeWithKey
			.emptyKeyed();

	/**
	 * (this list may be empty)
	 */
	public ListOfOnixDataCompositeWithKey<Audience, JonixAudience, AudienceCodeTypes> audiences()
	{
		initialize();
		return audiences;
	}

	private ListOfOnixDataComposite<AudienceRange, JonixAudienceRange> audienceRanges = ListOfOnixDataComposite.empty();

	/**
	 * (this list may be empty)
	 */
	public ListOfOnixDataComposite<AudienceRange, JonixAudienceRange> audienceRanges()
	{
		initialize();
		return audienceRanges;
	}

	private ListOfOnixElement<AudienceDescription, String> audienceDescriptions = ListOfOnixElement.empty();

	/**
	 * (this list may be empty)
	 */
	public ListOfOnixElement<AudienceDescription, String> audienceDescriptions()
	{
		initialize();
		return audienceDescriptions;
	}

	private ListOfOnixDataComposite<Complexity, JonixComplexity> complexitys = ListOfOnixDataComposite.empty();

	/**
	 * (this list may be empty)
	 */
	public ListOfOnixDataComposite<Complexity, JonixComplexity> complexitys()
	{
		initialize();
		return complexitys;
	}
}
