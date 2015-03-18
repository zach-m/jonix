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

package com.tectonica.jonix.onix3.model;

import java.util.List;

import com.tectonica.jonix.onix3.DU;
import com.tectonica.jonix.onix3.codelist.List3;

public class DescriptiveDetail
{
	public static final String refname = "DescriptiveDetail";
	public static final String shortname = "descriptivedetail";

	public String datestamp; // dt.DateOrDateTime
	public List3 sourcetype;
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
		x.sourcetype = List3.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		DU.forElementsOf(element, new DU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equalsIgnoreCase(ProductComposition.refname) || name.equalsIgnoreCase(ProductComposition.shortname))
					x.productComposition = ProductComposition.fromDoc(element);
				else if (name.equalsIgnoreCase(ProductForm.refname) || name.equalsIgnoreCase(ProductForm.shortname))
					x.productForm = ProductForm.fromDoc(element);
				else if (name.equalsIgnoreCase(ProductFormDetail.refname) || name.equalsIgnoreCase(ProductFormDetail.shortname))
					x.productFormDetails = DU.addToList(x.productFormDetails, ProductFormDetail.fromDoc(element));
				else if (name.equalsIgnoreCase(ProductFormFeature.refname) || name.equalsIgnoreCase(ProductFormFeature.shortname))
					x.productFormFeatures = DU.addToList(x.productFormFeatures, ProductFormFeature.fromDoc(element));
				else if (name.equalsIgnoreCase(ProductPackaging.refname) || name.equalsIgnoreCase(ProductPackaging.shortname))
					x.productPackaging = ProductPackaging.fromDoc(element);
				else if (name.equalsIgnoreCase(ProductFormDescription.refname) || name.equalsIgnoreCase(ProductFormDescription.shortname))
					x.productFormDescriptions = DU.addToList(x.productFormDescriptions, ProductFormDescription.fromDoc(element));
				else if (name.equalsIgnoreCase(TradeCategory.refname) || name.equalsIgnoreCase(TradeCategory.shortname))
					x.tradeCategory = TradeCategory.fromDoc(element);
				else if (name.equalsIgnoreCase(PrimaryContentType.refname) || name.equalsIgnoreCase(PrimaryContentType.shortname))
					x.primaryContentType = PrimaryContentType.fromDoc(element);
				else if (name.equalsIgnoreCase(ProductContentType.refname) || name.equalsIgnoreCase(ProductContentType.shortname))
					x.productContentTypes = DU.addToList(x.productContentTypes, ProductContentType.fromDoc(element));
				else if (name.equalsIgnoreCase(Measure.refname) || name.equalsIgnoreCase(Measure.shortname))
					x.measures = DU.addToList(x.measures, Measure.fromDoc(element));
				else if (name.equalsIgnoreCase(CountryOfManufacture.refname) || name.equalsIgnoreCase(CountryOfManufacture.shortname))
					x.countryOfManufacture = CountryOfManufacture.fromDoc(element);
				else if (name.equalsIgnoreCase(EpubTechnicalProtection.refname) || name.equalsIgnoreCase(EpubTechnicalProtection.shortname))
					x.epubTechnicalProtections = DU.addToList(x.epubTechnicalProtections, EpubTechnicalProtection.fromDoc(element));
				else if (name.equalsIgnoreCase(EpubUsageConstraint.refname) || name.equalsIgnoreCase(EpubUsageConstraint.shortname))
					x.epubUsageConstraints = DU.addToList(x.epubUsageConstraints, EpubUsageConstraint.fromDoc(element));
				else if (name.equalsIgnoreCase(EpubLicense.refname) || name.equalsIgnoreCase(EpubLicense.shortname))
					x.epubLicense = EpubLicense.fromDoc(element);
				else if (name.equalsIgnoreCase(MapScale.refname) || name.equalsIgnoreCase(MapScale.shortname))
					x.mapScales = DU.addToList(x.mapScales, MapScale.fromDoc(element));
				else if (name.equalsIgnoreCase(ProductClassification.refname) || name.equalsIgnoreCase(ProductClassification.shortname))
					x.productClassifications = DU.addToList(x.productClassifications, ProductClassification.fromDoc(element));
				else if (name.equalsIgnoreCase(ProductPart.refname) || name.equalsIgnoreCase(ProductPart.shortname))
					x.productParts = DU.addToList(x.productParts, ProductPart.fromDoc(element));
				else if (name.equalsIgnoreCase(Collection.refname) || name.equalsIgnoreCase(Collection.shortname))
					x.collections = DU.addToList(x.collections, Collection.fromDoc(element));
				else if (name.equalsIgnoreCase(NoCollection.refname) || name.equalsIgnoreCase(NoCollection.shortname))
					x.noCollection = NoCollection.fromDoc(element);
				else if (name.equalsIgnoreCase(TitleDetail.refname) || name.equalsIgnoreCase(TitleDetail.shortname))
					x.titleDetails = DU.addToList(x.titleDetails, TitleDetail.fromDoc(element));
				else if (name.equalsIgnoreCase(ThesisType.refname) || name.equalsIgnoreCase(ThesisType.shortname))
					x.thesisType = ThesisType.fromDoc(element);
				else if (name.equalsIgnoreCase(ThesisPresentedTo.refname) || name.equalsIgnoreCase(ThesisPresentedTo.shortname))
					x.thesisPresentedTo = ThesisPresentedTo.fromDoc(element);
				else if (name.equalsIgnoreCase(ThesisYear.refname) || name.equalsIgnoreCase(ThesisYear.shortname))
					x.thesisYear = ThesisYear.fromDoc(element);
				else if (name.equalsIgnoreCase(Contributor.refname) || name.equalsIgnoreCase(Contributor.shortname))
					x.contributors = DU.addToList(x.contributors, Contributor.fromDoc(element));
				else if (name.equalsIgnoreCase(ContributorStatement.refname) || name.equalsIgnoreCase(ContributorStatement.shortname))
					x.contributorStatements = DU.addToList(x.contributorStatements, ContributorStatement.fromDoc(element));
				else if (name.equalsIgnoreCase(NoContributor.refname) || name.equalsIgnoreCase(NoContributor.shortname))
					x.noContributor = NoContributor.fromDoc(element);
				else if (name.equalsIgnoreCase(Conference.refname) || name.equalsIgnoreCase(Conference.shortname))
					x.conferences = DU.addToList(x.conferences, Conference.fromDoc(element));
				else if (name.equalsIgnoreCase(EditionType.refname) || name.equalsIgnoreCase(EditionType.shortname))
					x.editionTypes = DU.addToList(x.editionTypes, EditionType.fromDoc(element));
				else if (name.equalsIgnoreCase(EditionNumber.refname) || name.equalsIgnoreCase(EditionNumber.shortname))
					x.editionNumber = EditionNumber.fromDoc(element);
				else if (name.equalsIgnoreCase(EditionVersionNumber.refname) || name.equalsIgnoreCase(EditionVersionNumber.shortname))
					x.editionVersionNumber = EditionVersionNumber.fromDoc(element);
				else if (name.equalsIgnoreCase(EditionStatement.refname) || name.equalsIgnoreCase(EditionStatement.shortname))
					x.editionStatements = DU.addToList(x.editionStatements, EditionStatement.fromDoc(element));
				else if (name.equalsIgnoreCase(NoEdition.refname) || name.equalsIgnoreCase(NoEdition.shortname))
					x.noEdition = NoEdition.fromDoc(element);
				else if (name.equalsIgnoreCase(ReligiousText.refname) || name.equalsIgnoreCase(ReligiousText.shortname))
					x.religiousText = ReligiousText.fromDoc(element);
				else if (name.equalsIgnoreCase(Language.refname) || name.equalsIgnoreCase(Language.shortname))
					x.languages = DU.addToList(x.languages, Language.fromDoc(element));
				else if (name.equalsIgnoreCase(Extent.refname) || name.equalsIgnoreCase(Extent.shortname))
					x.extents = DU.addToList(x.extents, Extent.fromDoc(element));
				else if (name.equalsIgnoreCase(Illustrated.refname) || name.equalsIgnoreCase(Illustrated.shortname))
					x.illustrated = Illustrated.fromDoc(element);
				else if (name.equalsIgnoreCase(NumberOfIllustrations.refname) || name.equalsIgnoreCase(NumberOfIllustrations.shortname))
					x.numberOfIllustrations = NumberOfIllustrations.fromDoc(element);
				else if (name.equalsIgnoreCase(IllustrationsNote.refname) || name.equalsIgnoreCase(IllustrationsNote.shortname))
					x.illustrationsNotes = DU.addToList(x.illustrationsNotes, IllustrationsNote.fromDoc(element));
				else if (name.equalsIgnoreCase(AncillaryContent.refname) || name.equalsIgnoreCase(AncillaryContent.shortname))
					x.ancillaryContents = DU.addToList(x.ancillaryContents, AncillaryContent.fromDoc(element));
				else if (name.equalsIgnoreCase(Subject.refname) || name.equalsIgnoreCase(Subject.shortname))
					x.subjects = DU.addToList(x.subjects, Subject.fromDoc(element));
				else if (name.equalsIgnoreCase(NameAsSubject.refname) || name.equalsIgnoreCase(NameAsSubject.shortname))
					x.nameAsSubjects = DU.addToList(x.nameAsSubjects, NameAsSubject.fromDoc(element));
				else if (name.equalsIgnoreCase(AudienceCode.refname) || name.equalsIgnoreCase(AudienceCode.shortname))
					x.audienceCodes = DU.addToList(x.audienceCodes, AudienceCode.fromDoc(element));
				else if (name.equalsIgnoreCase(Audience.refname) || name.equalsIgnoreCase(Audience.shortname))
					x.audiences = DU.addToList(x.audiences, Audience.fromDoc(element));
				else if (name.equalsIgnoreCase(AudienceRange.refname) || name.equalsIgnoreCase(AudienceRange.shortname))
					x.audienceRanges = DU.addToList(x.audienceRanges, AudienceRange.fromDoc(element));
				else if (name.equalsIgnoreCase(AudienceDescription.refname) || name.equalsIgnoreCase(AudienceDescription.shortname))
					x.audienceDescriptions = DU.addToList(x.audienceDescriptions, AudienceDescription.fromDoc(element));
				else if (name.equalsIgnoreCase(Complexity.refname) || name.equalsIgnoreCase(Complexity.shortname))
					x.complexitys = DU.addToList(x.complexitys, Complexity.fromDoc(element));
			}
		});

		return x;
	}
}
