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
import java.util.ArrayList;
import java.util.List;

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.codelist.AudienceCodeTypes;
import com.tectonica.jonix.codelist.Audiences;
import com.tectonica.jonix.codelist.CountryCodeIso31661s;
import com.tectonica.jonix.codelist.EditionTypes;
import com.tectonica.jonix.codelist.EpublicationTechnicalProtections;
import com.tectonica.jonix.codelist.IllustratedNotIllustrateds;
import com.tectonica.jonix.codelist.IllustrationAndOtherContentTypes;
import com.tectonica.jonix.codelist.LanguageRoles;
import com.tectonica.jonix.codelist.ProductCompositions;
import com.tectonica.jonix.codelist.ProductContentTypes;
import com.tectonica.jonix.codelist.ProductFormDetailsList175;
import com.tectonica.jonix.codelist.ProductFormsList150;
import com.tectonica.jonix.codelist.ProductPackagingTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.ThesisTypes;
import com.tectonica.jonix.codelist.TradeCategorys;
import com.tectonica.jonix.struct.JonixAncillaryContent;
import com.tectonica.jonix.struct.JonixAudience;
import com.tectonica.jonix.struct.JonixLanguage;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

@SuppressWarnings("serial")
public class DescriptiveDetail implements Serializable
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

	public DescriptiveDetail()
	{}

	public DescriptiveDetail(org.w3c.dom.Element element)
	{
		this.datestamp = JPU.getAttribute(element, "datestamp");
		this.sourcetype = RecordSourceTypes.byValue(JPU.getAttribute(element, "sourcetype"));
		this.sourcename = JPU.getAttribute(element, "sourcename");

		JPU.forElementsOf(element, new JPU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(ProductComposition.refname) || name.equals(ProductComposition.shortname))
					productComposition = new ProductComposition(element);
				else if (name.equals(ProductForm.refname) || name.equals(ProductForm.shortname))
					productForm = new ProductForm(element);
				else if (name.equals(ProductFormDetail.refname) || name.equals(ProductFormDetail.shortname))
					productFormDetails = JPU.addToList(productFormDetails, new ProductFormDetail(element));
				else if (name.equals(ProductFormFeature.refname) || name.equals(ProductFormFeature.shortname))
					productFormFeatures = JPU.addToList(productFormFeatures, new ProductFormFeature(element));
				else if (name.equals(ProductPackaging.refname) || name.equals(ProductPackaging.shortname))
					productPackaging = new ProductPackaging(element);
				else if (name.equals(ProductFormDescription.refname) || name.equals(ProductFormDescription.shortname))
					productFormDescriptions = JPU.addToList(productFormDescriptions, new ProductFormDescription(element));
				else if (name.equals(TradeCategory.refname) || name.equals(TradeCategory.shortname))
					tradeCategory = new TradeCategory(element);
				else if (name.equals(PrimaryContentType.refname) || name.equals(PrimaryContentType.shortname))
					primaryContentType = new PrimaryContentType(element);
				else if (name.equals(ProductContentType.refname) || name.equals(ProductContentType.shortname))
					productContentTypes = JPU.addToList(productContentTypes, new ProductContentType(element));
				else if (name.equals(Measure.refname) || name.equals(Measure.shortname))
					measures = JPU.addToList(measures, new Measure(element));
				else if (name.equals(CountryOfManufacture.refname) || name.equals(CountryOfManufacture.shortname))
					countryOfManufacture = new CountryOfManufacture(element);
				else if (name.equals(EpubTechnicalProtection.refname) || name.equals(EpubTechnicalProtection.shortname))
					epubTechnicalProtections = JPU.addToList(epubTechnicalProtections, new EpubTechnicalProtection(element));
				else if (name.equals(EpubUsageConstraint.refname) || name.equals(EpubUsageConstraint.shortname))
					epubUsageConstraints = JPU.addToList(epubUsageConstraints, new EpubUsageConstraint(element));
				else if (name.equals(EpubLicense.refname) || name.equals(EpubLicense.shortname))
					epubLicense = new EpubLicense(element);
				else if (name.equals(MapScale.refname) || name.equals(MapScale.shortname))
					mapScales = JPU.addToList(mapScales, new MapScale(element));
				else if (name.equals(ProductClassification.refname) || name.equals(ProductClassification.shortname))
					productClassifications = JPU.addToList(productClassifications, new ProductClassification(element));
				else if (name.equals(ProductPart.refname) || name.equals(ProductPart.shortname))
					productParts = JPU.addToList(productParts, new ProductPart(element));
				else if (name.equals(Collection.refname) || name.equals(Collection.shortname))
					collections = JPU.addToList(collections, new Collection(element));
				else if (name.equals(NoCollection.refname) || name.equals(NoCollection.shortname))
					noCollection = new NoCollection(element);
				else if (name.equals(TitleDetail.refname) || name.equals(TitleDetail.shortname))
					titleDetails = JPU.addToList(titleDetails, new TitleDetail(element));
				else if (name.equals(ThesisType.refname) || name.equals(ThesisType.shortname))
					thesisType = new ThesisType(element);
				else if (name.equals(ThesisPresentedTo.refname) || name.equals(ThesisPresentedTo.shortname))
					thesisPresentedTo = new ThesisPresentedTo(element);
				else if (name.equals(ThesisYear.refname) || name.equals(ThesisYear.shortname))
					thesisYear = new ThesisYear(element);
				else if (name.equals(Contributor.refname) || name.equals(Contributor.shortname))
					contributors = JPU.addToList(contributors, new Contributor(element));
				else if (name.equals(ContributorStatement.refname) || name.equals(ContributorStatement.shortname))
					contributorStatements = JPU.addToList(contributorStatements, new ContributorStatement(element));
				else if (name.equals(NoContributor.refname) || name.equals(NoContributor.shortname))
					noContributor = new NoContributor(element);
				else if (name.equals(Conference.refname) || name.equals(Conference.shortname))
					conferences = JPU.addToList(conferences, new Conference(element));
				else if (name.equals(EditionType.refname) || name.equals(EditionType.shortname))
					editionTypes = JPU.addToList(editionTypes, new EditionType(element));
				else if (name.equals(EditionNumber.refname) || name.equals(EditionNumber.shortname))
					editionNumber = new EditionNumber(element);
				else if (name.equals(EditionVersionNumber.refname) || name.equals(EditionVersionNumber.shortname))
					editionVersionNumber = new EditionVersionNumber(element);
				else if (name.equals(EditionStatement.refname) || name.equals(EditionStatement.shortname))
					editionStatements = JPU.addToList(editionStatements, new EditionStatement(element));
				else if (name.equals(NoEdition.refname) || name.equals(NoEdition.shortname))
					noEdition = new NoEdition(element);
				else if (name.equals(ReligiousText.refname) || name.equals(ReligiousText.shortname))
					religiousText = new ReligiousText(element);
				else if (name.equals(Language.refname) || name.equals(Language.shortname))
					languages = JPU.addToList(languages, new Language(element));
				else if (name.equals(Extent.refname) || name.equals(Extent.shortname))
					extents = JPU.addToList(extents, new Extent(element));
				else if (name.equals(Illustrated.refname) || name.equals(Illustrated.shortname))
					illustrated = new Illustrated(element);
				else if (name.equals(NumberOfIllustrations.refname) || name.equals(NumberOfIllustrations.shortname))
					numberOfIllustrations = new NumberOfIllustrations(element);
				else if (name.equals(IllustrationsNote.refname) || name.equals(IllustrationsNote.shortname))
					illustrationsNotes = JPU.addToList(illustrationsNotes, new IllustrationsNote(element));
				else if (name.equals(AncillaryContent.refname) || name.equals(AncillaryContent.shortname))
					ancillaryContents = JPU.addToList(ancillaryContents, new AncillaryContent(element));
				else if (name.equals(Subject.refname) || name.equals(Subject.shortname))
					subjects = JPU.addToList(subjects, new Subject(element));
				else if (name.equals(NameAsSubject.refname) || name.equals(NameAsSubject.shortname))
					nameAsSubjects = JPU.addToList(nameAsSubjects, new NameAsSubject(element));
				else if (name.equals(AudienceCode.refname) || name.equals(AudienceCode.shortname))
					audienceCodes = JPU.addToList(audienceCodes, new AudienceCode(element));
				else if (name.equals(Audience.refname) || name.equals(Audience.shortname))
					audiences = JPU.addToList(audiences, new Audience(element));
				else if (name.equals(AudienceRange.refname) || name.equals(AudienceRange.shortname))
					audienceRanges = JPU.addToList(audienceRanges, new AudienceRange(element));
				else if (name.equals(AudienceDescription.refname) || name.equals(AudienceDescription.shortname))
					audienceDescriptions = JPU.addToList(audienceDescriptions, new AudienceDescription(element));
				else if (name.equals(Complexity.refname) || name.equals(Complexity.shortname))
					complexitys = JPU.addToList(complexitys, new Complexity(element));
			}
		});
	}

	public ProductCompositions getProductCompositionValue()
	{
		return (productComposition == null) ? null : productComposition.value;
	}

	public ProductFormsList150 getProductFormValue()
	{
		return (productForm == null) ? null : productForm.value;
	}

	public List<ProductFormDetailsList175> getProductFormDetailValues()
	{
		if (productFormDetails != null)
		{
			List<ProductFormDetailsList175> list = new ArrayList<>();
			for (ProductFormDetail i : productFormDetails)
				list.add(i.value);
			return list;
		}
		return null;
	}

	public ProductPackagingTypes getProductPackagingValue()
	{
		return (productPackaging == null) ? null : productPackaging.value;
	}

	public List<String> getProductFormDescriptionValues()
	{
		if (productFormDescriptions != null)
		{
			List<String> list = new ArrayList<>();
			for (ProductFormDescription i : productFormDescriptions)
				list.add(i.value);
			return list;
		}
		return null;
	}

	public TradeCategorys getTradeCategoryValue()
	{
		return (tradeCategory == null) ? null : tradeCategory.value;
	}

	public ProductContentTypes getPrimaryContentTypeValue()
	{
		return (primaryContentType == null) ? null : primaryContentType.value;
	}

	public List<ProductContentTypes> getProductContentTypeValues()
	{
		if (productContentTypes != null)
		{
			List<ProductContentTypes> list = new ArrayList<>();
			for (ProductContentType i : productContentTypes)
				list.add(i.value);
			return list;
		}
		return null;
	}

	public CountryCodeIso31661s getCountryOfManufactureValue()
	{
		return (countryOfManufacture == null) ? null : countryOfManufacture.value;
	}

	public List<EpublicationTechnicalProtections> getEpubTechnicalProtectionValues()
	{
		if (epubTechnicalProtections != null)
		{
			List<EpublicationTechnicalProtections> list = new ArrayList<>();
			for (EpubTechnicalProtection i : epubTechnicalProtections)
				list.add(i.value);
			return list;
		}
		return null;
	}

	public List<Integer> getMapScaleValues()
	{
		if (mapScales != null)
		{
			List<Integer> list = new ArrayList<>();
			for (MapScale i : mapScales)
				list.add(i.value);
			return list;
		}
		return null;
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

	public List<String> getContributorStatementValues()
	{
		if (contributorStatements != null)
		{
			List<String> list = new ArrayList<>();
			for (ContributorStatement i : contributorStatements)
				list.add(i.value);
			return list;
		}
		return null;
	}

	public List<EditionTypes> getEditionTypeValues()
	{
		if (editionTypes != null)
		{
			List<EditionTypes> list = new ArrayList<>();
			for (EditionType i : editionTypes)
				list.add(i.value);
			return list;
		}
		return null;
	}

	public Integer getEditionNumberValue()
	{
		return (editionNumber == null) ? null : editionNumber.value;
	}

	public String getEditionVersionNumberValue()
	{
		return (editionVersionNumber == null) ? null : editionVersionNumber.value;
	}

	public List<String> getEditionStatementValues()
	{
		if (editionStatements != null)
		{
			List<String> list = new ArrayList<>();
			for (EditionStatement i : editionStatements)
				list.add(i.value);
			return list;
		}
		return null;
	}

	public IllustratedNotIllustrateds getIllustratedValue()
	{
		return (illustrated == null) ? null : illustrated.value;
	}

	public Integer getNumberOfIllustrationsValue()
	{
		return (numberOfIllustrations == null) ? null : numberOfIllustrations.value;
	}

	public List<String> getIllustrationsNoteValues()
	{
		if (illustrationsNotes != null)
		{
			List<String> list = new ArrayList<>();
			for (IllustrationsNote i : illustrationsNotes)
				list.add(i.value);
			return list;
		}
		return null;
	}

	public List<Audiences> getAudienceCodeValues()
	{
		if (audienceCodes != null)
		{
			List<Audiences> list = new ArrayList<>();
			for (AudienceCode i : audienceCodes)
				list.add(i.value);
			return list;
		}
		return null;
	}

	public List<String> getAudienceDescriptionValues()
	{
		if (audienceDescriptions != null)
		{
			List<String> list = new ArrayList<>();
			for (AudienceDescription i : audienceDescriptions)
				list.add(i.value);
			return list;
		}
		return null;
	}

	public JonixLanguage findLanguage(LanguageRoles languageRole)
	{
		if (languages != null)
		{
			for (Language x : languages)
			{
				if (x.getLanguageRoleValue() == languageRole)
					return x.asJonixLanguage();
			}
		}
		return null;
	}

	public List<JonixLanguage> findLanguages(java.util.Set<LanguageRoles> languageRoles)
	{
		if (languages != null)
		{
			List<JonixLanguage> matches = new ArrayList<>();
			for (Language x : languages)
			{
				if (languageRoles == null || languageRoles.contains(x.getLanguageRoleValue()))
					matches.add(x.asJonixLanguage());
			}
			return matches;
		}
		return null;
	}

	public JonixAncillaryContent findAncillaryContent(IllustrationAndOtherContentTypes ancillaryContentType)
	{
		if (ancillaryContents != null)
		{
			for (AncillaryContent x : ancillaryContents)
			{
				if (x.getAncillaryContentTypeValue() == ancillaryContentType)
					return x.asJonixAncillaryContent();
			}
		}
		return null;
	}

	public List<JonixAncillaryContent> findAncillaryContents(java.util.Set<IllustrationAndOtherContentTypes> ancillaryContentTypes)
	{
		if (ancillaryContents != null)
		{
			List<JonixAncillaryContent> matches = new ArrayList<>();
			for (AncillaryContent x : ancillaryContents)
			{
				if (ancillaryContentTypes == null || ancillaryContentTypes.contains(x.getAncillaryContentTypeValue()))
					matches.add(x.asJonixAncillaryContent());
			}
			return matches;
		}
		return null;
	}

	public JonixAudience findAudience(AudienceCodeTypes audienceCodeType)
	{
		if (audiences != null)
		{
			for (Audience x : audiences)
			{
				if (x.getAudienceCodeTypeValue() == audienceCodeType)
					return x.asJonixAudience();
			}
		}
		return null;
	}

	public List<JonixAudience> findAudiences(java.util.Set<AudienceCodeTypes> audienceCodeTypes)
	{
		if (audiences != null)
		{
			List<JonixAudience> matches = new ArrayList<>();
			for (Audience x : audiences)
			{
				if (audienceCodeTypes == null || audienceCodeTypes.contains(x.getAudienceCodeTypeValue()))
					matches.add(x.asJonixAudience());
			}
			return matches;
		}
		return null;
	}
}
