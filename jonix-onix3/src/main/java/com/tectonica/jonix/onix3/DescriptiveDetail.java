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

import java.util.List;

import com.tectonica.jonix.DU;
import com.tectonica.jonix.codelist.CountryCodeIso31661s;
import com.tectonica.jonix.codelist.IllustratedNotIllustrateds;
import com.tectonica.jonix.codelist.ProductCompositions;
import com.tectonica.jonix.codelist.ProductContentTypes;
import com.tectonica.jonix.codelist.ProductFormsList150;
import com.tectonica.jonix.codelist.ProductPackagingTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.ThesisTypes;
import com.tectonica.jonix.codelist.TradeCategorys;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

public class DescriptiveDetail
{
	public static final String refname = "DescriptiveDetail";
	public static final String shortname = "descriptivedetail";

	public String datestamp; // dt.DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public ProductComposition productComposition; // Required
	public ProductForm productForm; // Required
	public List<ProductFormDetail> productFormDetails; // ZeroOrMore
	public List<ProductFormFeature> productFormFeatures; // ZeroOrMore
	public ProductPackaging productPackaging; // Optional
	public List<ProductFormDescription> productFormDescriptions; // ZeroOrMore
	public TradeCategory tradeCategory; // Optional
	public PrimaryContentType primaryContentType; // Optional
	public List<ProductContentType> productContentTypes; // ZeroOrMore
	public List<Measure> measures; // ZeroOrMore
	public CountryOfManufacture countryOfManufacture; // Optional
	public List<EpubTechnicalProtection> epubTechnicalProtections; // ZeroOrMore
	public List<EpubUsageConstraint> epubUsageConstraints; // ZeroOrMore
	public EpubLicense epubLicense; // Optional
	public List<MapScale> mapScales; // ZeroOrMore
	public List<ProductClassification> productClassifications; // ZeroOrMore
	public List<ProductPart> productParts; // ZeroOrMore
	public List<Collection> collections; // ZeroOrMore
	public NoCollection noCollection; // Optional
	public List<TitleDetail> titleDetails; // OneOrMore
	public ThesisType thesisType; // Optional
	public ThesisPresentedTo thesisPresentedTo; // Optional
	public ThesisYear thesisYear; // Optional
	public List<Contributor> contributors; // OneOrMore
	public List<ContributorStatement> contributorStatements; // ZeroOrMore
	public NoContributor noContributor; // Optional
	public List<Conference> conferences; // ZeroOrMore
	public List<EditionType> editionTypes; // ZeroOrMore
	public EditionNumber editionNumber; // Optional
	public EditionVersionNumber editionVersionNumber; // Optional
	public List<EditionStatement> editionStatements; // ZeroOrMore
	public NoEdition noEdition; // Optional
	public ReligiousText religiousText; // Optional
	public List<Language> languages; // ZeroOrMore
	public List<Extent> extents; // ZeroOrMore
	public Illustrated illustrated; // Optional
	public NumberOfIllustrations numberOfIllustrations; // Optional
	public List<IllustrationsNote> illustrationsNotes; // ZeroOrMore
	public List<AncillaryContent> ancillaryContents; // ZeroOrMore
	public List<Subject> subjects; // ZeroOrMore
	public List<NameAsSubject> nameAsSubjects; // ZeroOrMore
	public List<AudienceCode> audienceCodes; // ZeroOrMore
	public List<Audience> audiences; // ZeroOrMore
	public List<AudienceRange> audienceRanges; // ZeroOrMore
	public List<AudienceDescription> audienceDescriptions; // ZeroOrMore
	public List<Complexity> complexitys; // ZeroOrMore

	public static DescriptiveDetail fromDoc(org.w3c.dom.Element element)
	{
		final DescriptiveDetail x = new DescriptiveDetail();

		x.datestamp = DU.getAttribute(element, "datestamp");
		x.sourcetype = RecordSourceTypes.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		DU.forElementsOf(element, new DU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(ProductComposition.refname) || name.equals(ProductComposition.shortname))
					x.productComposition = ProductComposition.fromDoc(element);
				else if (name.equals(ProductForm.refname) || name.equals(ProductForm.shortname))
					x.productForm = ProductForm.fromDoc(element);
				else if (name.equals(ProductFormDetail.refname) || name.equals(ProductFormDetail.shortname))
					x.productFormDetails = DU.addToList(x.productFormDetails, ProductFormDetail.fromDoc(element));
				else if (name.equals(ProductFormFeature.refname) || name.equals(ProductFormFeature.shortname))
					x.productFormFeatures = DU.addToList(x.productFormFeatures, ProductFormFeature.fromDoc(element));
				else if (name.equals(ProductPackaging.refname) || name.equals(ProductPackaging.shortname))
					x.productPackaging = ProductPackaging.fromDoc(element);
				else if (name.equals(ProductFormDescription.refname) || name.equals(ProductFormDescription.shortname))
					x.productFormDescriptions = DU.addToList(x.productFormDescriptions, ProductFormDescription.fromDoc(element));
				else if (name.equals(TradeCategory.refname) || name.equals(TradeCategory.shortname))
					x.tradeCategory = TradeCategory.fromDoc(element);
				else if (name.equals(PrimaryContentType.refname) || name.equals(PrimaryContentType.shortname))
					x.primaryContentType = PrimaryContentType.fromDoc(element);
				else if (name.equals(ProductContentType.refname) || name.equals(ProductContentType.shortname))
					x.productContentTypes = DU.addToList(x.productContentTypes, ProductContentType.fromDoc(element));
				else if (name.equals(Measure.refname) || name.equals(Measure.shortname))
					x.measures = DU.addToList(x.measures, Measure.fromDoc(element));
				else if (name.equals(CountryOfManufacture.refname) || name.equals(CountryOfManufacture.shortname))
					x.countryOfManufacture = CountryOfManufacture.fromDoc(element);
				else if (name.equals(EpubTechnicalProtection.refname) || name.equals(EpubTechnicalProtection.shortname))
					x.epubTechnicalProtections = DU.addToList(x.epubTechnicalProtections, EpubTechnicalProtection.fromDoc(element));
				else if (name.equals(EpubUsageConstraint.refname) || name.equals(EpubUsageConstraint.shortname))
					x.epubUsageConstraints = DU.addToList(x.epubUsageConstraints, EpubUsageConstraint.fromDoc(element));
				else if (name.equals(EpubLicense.refname) || name.equals(EpubLicense.shortname))
					x.epubLicense = EpubLicense.fromDoc(element);
				else if (name.equals(MapScale.refname) || name.equals(MapScale.shortname))
					x.mapScales = DU.addToList(x.mapScales, MapScale.fromDoc(element));
				else if (name.equals(ProductClassification.refname) || name.equals(ProductClassification.shortname))
					x.productClassifications = DU.addToList(x.productClassifications, ProductClassification.fromDoc(element));
				else if (name.equals(ProductPart.refname) || name.equals(ProductPart.shortname))
					x.productParts = DU.addToList(x.productParts, ProductPart.fromDoc(element));
				else if (name.equals(Collection.refname) || name.equals(Collection.shortname))
					x.collections = DU.addToList(x.collections, Collection.fromDoc(element));
				else if (name.equals(NoCollection.refname) || name.equals(NoCollection.shortname))
					x.noCollection = NoCollection.fromDoc(element);
				else if (name.equals(TitleDetail.refname) || name.equals(TitleDetail.shortname))
					x.titleDetails = DU.addToList(x.titleDetails, TitleDetail.fromDoc(element));
				else if (name.equals(ThesisType.refname) || name.equals(ThesisType.shortname))
					x.thesisType = ThesisType.fromDoc(element);
				else if (name.equals(ThesisPresentedTo.refname) || name.equals(ThesisPresentedTo.shortname))
					x.thesisPresentedTo = ThesisPresentedTo.fromDoc(element);
				else if (name.equals(ThesisYear.refname) || name.equals(ThesisYear.shortname))
					x.thesisYear = ThesisYear.fromDoc(element);
				else if (name.equals(Contributor.refname) || name.equals(Contributor.shortname))
					x.contributors = DU.addToList(x.contributors, Contributor.fromDoc(element));
				else if (name.equals(ContributorStatement.refname) || name.equals(ContributorStatement.shortname))
					x.contributorStatements = DU.addToList(x.contributorStatements, ContributorStatement.fromDoc(element));
				else if (name.equals(NoContributor.refname) || name.equals(NoContributor.shortname))
					x.noContributor = NoContributor.fromDoc(element);
				else if (name.equals(Conference.refname) || name.equals(Conference.shortname))
					x.conferences = DU.addToList(x.conferences, Conference.fromDoc(element));
				else if (name.equals(EditionType.refname) || name.equals(EditionType.shortname))
					x.editionTypes = DU.addToList(x.editionTypes, EditionType.fromDoc(element));
				else if (name.equals(EditionNumber.refname) || name.equals(EditionNumber.shortname))
					x.editionNumber = EditionNumber.fromDoc(element);
				else if (name.equals(EditionVersionNumber.refname) || name.equals(EditionVersionNumber.shortname))
					x.editionVersionNumber = EditionVersionNumber.fromDoc(element);
				else if (name.equals(EditionStatement.refname) || name.equals(EditionStatement.shortname))
					x.editionStatements = DU.addToList(x.editionStatements, EditionStatement.fromDoc(element));
				else if (name.equals(NoEdition.refname) || name.equals(NoEdition.shortname))
					x.noEdition = NoEdition.fromDoc(element);
				else if (name.equals(ReligiousText.refname) || name.equals(ReligiousText.shortname))
					x.religiousText = ReligiousText.fromDoc(element);
				else if (name.equals(Language.refname) || name.equals(Language.shortname))
					x.languages = DU.addToList(x.languages, Language.fromDoc(element));
				else if (name.equals(Extent.refname) || name.equals(Extent.shortname))
					x.extents = DU.addToList(x.extents, Extent.fromDoc(element));
				else if (name.equals(Illustrated.refname) || name.equals(Illustrated.shortname))
					x.illustrated = Illustrated.fromDoc(element);
				else if (name.equals(NumberOfIllustrations.refname) || name.equals(NumberOfIllustrations.shortname))
					x.numberOfIllustrations = NumberOfIllustrations.fromDoc(element);
				else if (name.equals(IllustrationsNote.refname) || name.equals(IllustrationsNote.shortname))
					x.illustrationsNotes = DU.addToList(x.illustrationsNotes, IllustrationsNote.fromDoc(element));
				else if (name.equals(AncillaryContent.refname) || name.equals(AncillaryContent.shortname))
					x.ancillaryContents = DU.addToList(x.ancillaryContents, AncillaryContent.fromDoc(element));
				else if (name.equals(Subject.refname) || name.equals(Subject.shortname))
					x.subjects = DU.addToList(x.subjects, Subject.fromDoc(element));
				else if (name.equals(NameAsSubject.refname) || name.equals(NameAsSubject.shortname))
					x.nameAsSubjects = DU.addToList(x.nameAsSubjects, NameAsSubject.fromDoc(element));
				else if (name.equals(AudienceCode.refname) || name.equals(AudienceCode.shortname))
					x.audienceCodes = DU.addToList(x.audienceCodes, AudienceCode.fromDoc(element));
				else if (name.equals(Audience.refname) || name.equals(Audience.shortname))
					x.audiences = DU.addToList(x.audiences, Audience.fromDoc(element));
				else if (name.equals(AudienceRange.refname) || name.equals(AudienceRange.shortname))
					x.audienceRanges = DU.addToList(x.audienceRanges, AudienceRange.fromDoc(element));
				else if (name.equals(AudienceDescription.refname) || name.equals(AudienceDescription.shortname))
					x.audienceDescriptions = DU.addToList(x.audienceDescriptions, AudienceDescription.fromDoc(element));
				else if (name.equals(Complexity.refname) || name.equals(Complexity.shortname))
					x.complexitys = DU.addToList(x.complexitys, Complexity.fromDoc(element));
			}
		});

		return x;
	}

	public ProductCompositions getProductCompositionValue()
	{
		return (productComposition == null) ? null : productComposition.value;
	}

	public ProductFormsList150 getProductFormValue()
	{
		return (productForm == null) ? null : productForm.value;
	}

	public ProductPackagingTypes getProductPackagingValue()
	{
		return (productPackaging == null) ? null : productPackaging.value;
	}

	public TradeCategorys getTradeCategoryValue()
	{
		return (tradeCategory == null) ? null : tradeCategory.value;
	}

	public ProductContentTypes getPrimaryContentTypeValue()
	{
		return (primaryContentType == null) ? null : primaryContentType.value;
	}

	public CountryCodeIso31661s getCountryOfManufactureValue()
	{
		return (countryOfManufacture == null) ? null : countryOfManufacture.value;
	}

	public ThesisTypes getThesisTypeValue()
	{
		return (thesisType == null) ? null : thesisType.value;
	}

	public String getThesisPresentedToValue()
	{
		return (thesisPresentedTo == null) ? null : thesisPresentedTo.value;
	}

	public String getThesisYearValue()
	{
		return (thesisYear == null) ? null : thesisYear.value;
	}

	public Integer getEditionNumberValue()
	{
		return (editionNumber == null) ? null : editionNumber.value;
	}

	public String getEditionVersionNumberValue()
	{
		return (editionVersionNumber == null) ? null : editionVersionNumber.value;
	}

	public IllustratedNotIllustrateds getIllustratedValue()
	{
		return (illustrated == null) ? null : illustrated.value;
	}

	public Integer getNumberOfIllustrationsValue()
	{
		return (numberOfIllustrations == null) ? null : numberOfIllustrations.value;
	}
}
