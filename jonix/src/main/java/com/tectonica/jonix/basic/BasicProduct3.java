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

package com.tectonica.jonix.basic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.tectonica.jonix.JonixColumn;
import com.tectonica.jonix.codelist.ContributorRoles;
import com.tectonica.jonix.codelist.CountryCodeIso31661s;
import com.tectonica.jonix.codelist.EditionTypes;
import com.tectonica.jonix.codelist.EpublicationTypes;
import com.tectonica.jonix.codelist.ExtentTypes;
import com.tectonica.jonix.codelist.LanguageRoles;
import com.tectonica.jonix.codelist.NotificationOrUpdateTypes;
import com.tectonica.jonix.codelist.OtherTextTypes;
import com.tectonica.jonix.codelist.PriceTypes;
import com.tectonica.jonix.codelist.ProductForms;
import com.tectonica.jonix.codelist.ProductFormsList150;
import com.tectonica.jonix.codelist.ProductIdentifierTypes;
import com.tectonica.jonix.codelist.PublishingDateRoles;
import com.tectonica.jonix.codelist.SalesRightsTypes;
import com.tectonica.jonix.codelist.SubjectSchemeIdentifiers;
import com.tectonica.jonix.codelist.TitleTypes;
import com.tectonica.jonix.composite.Audience;
import com.tectonica.jonix.composite.Contributor;
import com.tectonica.jonix.composite.Imprint;
import com.tectonica.jonix.composite.MainSubject;
import com.tectonica.jonix.composite.OtherText;
import com.tectonica.jonix.composite.Price;
import com.tectonica.jonix.composite.Publisher;
import com.tectonica.jonix.composite.SalesRights;
import com.tectonica.jonix.composite.Series;
import com.tectonica.jonix.composite.Subject;
import com.tectonica.jonix.composite.SupplyDetail;
import com.tectonica.jonix.onix3.CollateralDetail;
import com.tectonica.jonix.onix3.ContentDetail;
import com.tectonica.jonix.onix3.DescriptiveDetail;
import com.tectonica.jonix.onix3.PublishingDetail;
import com.tectonica.jonix.struct.JonixExtent;
import com.tectonica.jonix.struct.JonixLanguage;
import com.tectonica.jonix.struct.JonixProductIdentifier;
import com.tectonica.jonix.struct.JonixPublishingDate;
import com.tectonica.jonix.struct.JonixTitle;

@SuppressWarnings("serial")
public class BasicProduct3 implements Serializable
{
	public final String recordReference;
	public final Integer editionNumber;
	public final String cityOfPublication;
	public final String publicationDate;
	public final String numberOfPages;
	public final String bisacMainSubject;
	public final String bicMainSubject;

	public final NotificationOrUpdateTypes notificationType;
	public final ProductFormsList150 productForm; // compared to 'ProductForms' in Onix 2 
	public final EpublicationTypes epubType;
	public final EditionTypes editionType;
	public final CountryCodeIso31661s countryOfPublication;

//	public final List<ProductIdentifier> productIdentifiers;
//	public final List<Title> titles;
	public final List<JonixTitle> titles;
	public final List<Contributor> contributors;
	public final List<Series> seriess;
//	public final List<Language> languages;
	public final List<MainSubject> mainSubjects;
	public final List<Subject> subjects;
	public final List<Audience> audiences;
	public final List<OtherText> otherTexts;
	public final List<Publisher> publishers;
	public final List<Imprint> imprints;
	public final List<SupplyDetail> supplyDetails;
	public final List<SalesRights> salesRightss;

	public final com.tectonica.jonix.onix3.Product product;

	public BasicProduct3(com.tectonica.jonix.onix3.Product product)
	{
		this.product = product;

		DescriptiveDetail d = product.descriptiveDetail;
		CollateralDetail c = product.collateralDetail;
		PublishingDetail p = product.publishingDetail;
		ContentDetail content = product.contentDetail;

		JonixPublishingDate jPublicationDate = p.findPublishingDate(PublishingDateRoles.Publication_date);
		JonixExtent jNumberOfPages = d.findExtent(ExtentTypes.Main_content_page_count);

		// singles
		recordReference = product.getRecordReferenceValue();
		editionNumber = d.getEditionNumberValue();
		publicationDate = (jPublicationDate == null) ? null : jPublicationDate.date;
		numberOfPages = (jNumberOfPages == null) ? null : jNumberOfPages.extentValue.toString();
		
		for (com.tectonica.jonix.onix3.Subject s : d.subjects)
		{
			boolean isMain = s.isMainSubject();
			SubjectSchemeIdentifiers scheme = s.getSubjectSchemeIdentifierValue();
			if (scheme == SubjectSchemeIdentifiers.BISAC_Subject_Heading)
				bisacMainSubject = s.getSubjectCodeValue();
			else if (scheme == SubjectSchemeIdentifiers.BIC_subject_category)
				bicMainSubject = s.getSubjectCodeValue();
		}
		
		notificationType = product.getNotificationTypeValue();
		productForm = d.getProductFormValue();
		epubType = product.getEpubTypeValue();
		countryOfPublication = product.getCountryOfPublicationValue();

		// retrieve first values
		cityOfPublication = (product.cityOfPublications == null) ? null : product.cityOfPublications.get(0).value;
		editionType = (product.editionTypeCodes == null) ? null : product.editionTypeCodes.get(0).value;

		// composites
//		productIdentifiers = ProductIdentifier.listFrom(product);
//		titles = Title.listFrom(product);
		titles = product.findTitles(null); // null = find-all
		contributors = Contributor.listFrom(product); // TODO: use intf
		seriess = Series.listFrom(product); // onix2-only
//		languages = Language.listFrom(product);
		mainSubjects = MainSubject.listFrom(product); // ?
		subjects = Subject.listFrom(product); // TODO: use struct
		audiences = Audience.listFrom(product); // TODO: use struct
		otherTexts = OtherText.listFrom(product); // TODO: use struct - although not complete
		publishers = Publisher.listFrom(product); // TODO: use intf
		imprints = Imprint.listFrom(product); // non-struct
		supplyDetails = SupplyDetail.listFrom(product); // TODO: use intf
		salesRightss = SalesRights.listFrom(product); // non-struct
	}

	public String getLabel()
	{
		return (titles.size() > 0) ? titles.get(0).titleText : recordReference;
	}

	public static JonixColumn[] getDefaultColumns()
	{
		return BasicColumn.all;
	}

	public static JonixColumn getDefaultIdColumn()
	{
		return BasicColumn.ISBN13;
	}

	// LOOKUP CONVENIENCE SERVICES

	public JonixProductIdentifier findProductId(ProductIdentifierTypes requestedType)
	{
		return product.findProductIdentifier(requestedType);
	}

	public JonixTitle findTitle(TitleTypes requestedType)
	{
		return product.findTitle(requestedType);
	}

	public List<Contributor> findContributors(ContributorRoles requestedRole)
	{
		List<Contributor> matches = new ArrayList<Contributor>();
		for (Contributor contributor : contributors)
		{
			if (contributor.contributorRoles.contains(requestedRole))
				matches.add(contributor);
		}
		return matches;
	}

	public JonixLanguage findLanguage(LanguageRoles requestedType)
	{
		return product.findLanguage(requestedType);
	}

	public List<Subject> findSubjects(SubjectSchemeIdentifiers requestedScheme)
	{
		List<Subject> matches = new ArrayList<Subject>();

		if (requestedScheme == SubjectSchemeIdentifiers.BISAC_Subject_Heading)
		{
			if (bisacMainSubject != null && !bisacMainSubject.isEmpty())
				matches.add(new Subject(SubjectSchemeIdentifiers.BISAC_Subject_Heading, bisacMainSubject, null));
		}
		else if (requestedScheme == SubjectSchemeIdentifiers.BIC_subject_category)
		{
			if (bicMainSubject != null && !bicMainSubject.isEmpty())
				matches.add(new Subject(SubjectSchemeIdentifiers.BIC_subject_category, bicMainSubject, null));
		}

		for (MainSubject subject : mainSubjects)
		{
			if (subject.mainSubjectSchemeIdentifier.value.equals(requestedScheme.value))
				matches.add(new Subject(requestedScheme, subject.subjectCode, subject.subjectHeadingText));
		}
		for (Subject subject : subjects)
		{
			if (subject.subjectSchemeIdentifier == requestedScheme)
				matches.add(subject);
		}
		return matches;
	}

	public OtherText findOtherText(OtherTextTypes requestedType)
	{
		// we don't use product.findOtherText() because we need the 'textFormat' attribute, not just the value
		for (OtherText otherText : otherTexts)
		{
			if (otherText.textType == requestedType)
				return otherText;
		}
		return null;
	}

	public List<Price> findPrices(Set<PriceTypes> requestedTypes)
	{
		List<Price> matches = new ArrayList<Price>();
		for (SupplyDetail supplyDetail : supplyDetails)
		{
			for (Price price : supplyDetail.prices)
			{
				if (requestedTypes.contains(price.priceType))
					matches.add(price);
			}
		}
		return matches;
	}

	public List<SalesRights> findSalesRightss(Set<SalesRightsTypes> requestedTypes)
	{
//		return product.findSalesRightss(requestedTypes);
		List<SalesRights> matches = new ArrayList<SalesRights>();
		for (SalesRights salesRights : salesRightss)
		{
			if (requestedTypes.contains(salesRights.salesRightsType))
				matches.add(salesRights);
		}
		return matches;
	}
}
