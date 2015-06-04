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
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.tectonica.jonix.BasicColumn;
import com.tectonica.jonix.JPU;
import com.tectonica.jonix.JonixColumn;
import com.tectonica.jonix.codelist.ContributorRoles;
import com.tectonica.jonix.codelist.CountryCodeIso31661s;
import com.tectonica.jonix.codelist.EditionTypes;
import com.tectonica.jonix.codelist.ExtentTypes;
import com.tectonica.jonix.codelist.LanguageCodeIso6392Bs;
import com.tectonica.jonix.codelist.LanguageRoles;
import com.tectonica.jonix.codelist.NotificationOrUpdateTypes;
import com.tectonica.jonix.codelist.PriceTypes;
import com.tectonica.jonix.codelist.ProductForms;
import com.tectonica.jonix.codelist.ProductFormsList150;
import com.tectonica.jonix.codelist.ProductIdentifierTypes;
import com.tectonica.jonix.codelist.PublishingDateRoles;
import com.tectonica.jonix.codelist.SalesRightsTypes;
import com.tectonica.jonix.codelist.SubjectSchemeIdentifiers;
import com.tectonica.jonix.codelist.TextTypes;
import com.tectonica.jonix.codelist.TitleTypes;
import com.tectonica.jonix.struct.JonixAudience;
import com.tectonica.jonix.struct.JonixExtent;
import com.tectonica.jonix.struct.JonixLanguage;
import com.tectonica.jonix.struct.JonixProductIdentifier;
import com.tectonica.jonix.struct.JonixPublishingDate;

@SuppressWarnings("serial")
public class BasicProduct implements Serializable
{
	// basic
	public final String recordReference;
	public final NotificationOrUpdateTypes notificationType;
	public final List<JonixProductIdentifier> productIds;

	// descriptive
	public final EditionTypes editionType;
	public final Integer editionNumber;
	public final String productForm;
	public final List<JonixLanguage> languages;
	public final List<JonixAudience> audiences;

	// publication
	public final String publicationDate;
	public final CountryCodeIso31661s countryOfPublication;
	public final String cityOfPublication;
	public final String numberOfPages;

	// others
	public final List<BasicTitle> titles;
	public final List<BasicContributor> contributors;
	public final List<BasicCollection> collections;
	public final Map<SubjectSchemeIdentifiers, List<BasicSubject>> subjects;
	public final List<BasicText> texts;
	public final List<BasicPublisher> publishers;
	public final List<BasicImprint> imprints;
	public final List<BasicSupplyDetail> supplyDetails;
	public final List<BasicSalesRights> salesRights;

	private final Object productObject;

	public BasicProduct(com.tectonica.jonix.onix3.Product product)
	{
		productObject = product;

		recordReference = product.getRecordReferenceValue();
		notificationType = product.getNotificationTypeValue();
		productIds = product.findProductIdentifiers(null);

		com.tectonica.jonix.onix3.DescriptiveDetail dd = product.descriptiveDetail;
		if (dd != null)
		{
			List<EditionTypes> editionTypes = dd.getEditionTypeValues();
			editionType = (editionTypes == null) ? null : editionTypes.get(0);
			editionNumber = dd.getEditionNumberValue();
			ProductFormsList150 productFormValue = dd.getProductFormValue();
			productForm = (productFormValue == null) ? null : productFormValue.name();
			languages = dd.findLanguages(null);
			audiences = dd.findAudiences(null);
		}
		else
		{
			editionType = null;
			editionNumber = null;
			productForm = null;
			languages = Collections.emptyList();
			audiences = Collections.emptyList();

		}

		com.tectonica.jonix.onix3.PublishingDetail pd = product.publishingDetail;
		if (pd != null)
		{
			JonixPublishingDate jPublicationDate = pd.findPublishingDate(PublishingDateRoles.Publication_date);
			publicationDate = (jPublicationDate == null) ? null : jPublicationDate.date;
			countryOfPublication = pd.getCountryOfPublicationValue();
			cityOfPublication = pickCityOfPublication(product, LanguageCodeIso6392Bs.English);
			JonixExtent jNumberOfPages = dd.findExtent(ExtentTypes.Main_content_page_count);
			numberOfPages = (jNumberOfPages == null) ? null : jNumberOfPages.extentValue.toString();
		}
		else
		{
			publicationDate = null;
			countryOfPublication = null;
			cityOfPublication = null;
			numberOfPages = null;
		}

		titles = BasicTitle.extractFrom(product);
		contributors = BasicContributor.extractFrom(product);
		collections = BasicCollection.extractFrom(product); // series and collections are composites, not structs
		subjects = BasicSubject.extractFrom(product); // not struct due to Onix2's BASICMainSubject and BICMainSubject
		texts = BasicText.extractFrom(product);
		publishers = BasicPublisher.extractFrom(product);
		imprints = BasicImprint.extractFrom(product); // publishers are composites, not structs
		supplyDetails = BasicSupplyDetail.extractFrom(product);
		salesRights = BasicSalesRights.extractFrom(product); // non-struct
	}

	public BasicProduct(com.tectonica.jonix.onix2.Product product)
	{
		productObject = product;

		recordReference = product.getRecordReferenceValue();
		notificationType = product.getNotificationTypeValue();
		productIds = product.findProductIdentifiers(null);

		editionType = (product.editionTypeCodes == null) ? null : product.editionTypeCodes.get(0).value;
		editionNumber = JPU.convertStringToInteger(product.getEditionNumberValue());
		ProductForms productFormValue = product.getProductFormValue();
		productForm = (productFormValue == null) ? null : productFormValue.name();
		languages = product.findLanguages(null);
		audiences = product.findAudiences(null);

		publicationDate = product.getPublicationDateValue();
		countryOfPublication = product.getCountryOfPublicationValue();
		cityOfPublication = pickCityOfPublication(product, LanguageCodeIso6392Bs.English);
		numberOfPages = product.getNumberOfPagesValue();

		titles = BasicTitle.extractFrom(product);
		contributors = BasicContributor.extractFrom(product); // TODO: use intf
		collections = BasicCollection.extractFrom(product); // onix2-only
		subjects = BasicSubject.extractFrom(product); // TODO: use struct
		texts = BasicText.extractFrom(product); // TODO: use struct - although not complete
		publishers = BasicPublisher.extractFrom(product); // TODO: use intf
		imprints = BasicImprint.extractFrom(product); // non-struct
		supplyDetails = BasicSupplyDetail.extractFrom(product); // TODO: use intf
		salesRights = BasicSalesRights.extractFrom(product); // non-struct
	}

	private String pickCityOfPublication(com.tectonica.jonix.onix3.Product product,
			LanguageCodeIso6392Bs preferredLanguage)
	{
		if (product.publishingDetail == null)
			return null;

		List<com.tectonica.jonix.onix3.CityOfPublication> cops = product.publishingDetail.cityOfPublications;
		if (cops == null)
			return null;

		for (com.tectonica.jonix.onix3.CityOfPublication cop : cops)
		{
			if (cop.language == null || cop.language == preferredLanguage)
				return cop.value;
		}
		return cops.get(0).value; // return whatever language we have
	}

	private String pickCityOfPublication(com.tectonica.jonix.onix2.Product product,
			LanguageCodeIso6392Bs preferredLanguage)
	{
		if (product.cityOfPublications != null)
		{
			for (com.tectonica.jonix.onix2.CityOfPublication cop : product.cityOfPublications)
			{
				if (cop.language == null || cop.language == preferredLanguage)
					return cop.value;
			}
			return product.cityOfPublications.get(0).value; // return whatever language we have
		}
		return null;
	}

	public Object getProductObject()
	{
		return productObject;
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
		for (JonixProductIdentifier pid : productIds)
		{
			if (pid.productIDType == requestedType)
				return pid;
		}
		return null;
	}

	public JonixLanguage findLanguage(LanguageRoles requestedType)
	{
		for (JonixLanguage lang : languages)
		{
			if (lang.languageRole == requestedType)
				return lang;
		}
		return null;
	}

	public BasicTitle findTitle(TitleTypes requestedType)
	{
		for (BasicTitle title : titles)
		{
			if (title.titleType == requestedType)
				return title;
		}
		return null;
	}

	public List<BasicContributor> findContributors(ContributorRoles requestedRole)
	{
		List<BasicContributor> matches = new ArrayList<BasicContributor>();
		for (BasicContributor contributor : contributors)
		{
			if (contributor.contributorRoles.contains(requestedRole))
				matches.add(contributor);
		}
		return matches;
	}

	public List<BasicSubject> findSubjects(SubjectSchemeIdentifiers requestedScheme)
	{
		List<BasicSubject> list = subjects.get(requestedScheme);
		if (list == null)
			return Collections.emptyList();
		return list;
	}

	public BasicText findOtherText(TextTypes requestedType)
	{
		// we don't use product.findOtherText() because we need the 'textFormat' attribute, not just the value
		for (BasicText otherText : texts)
		{
			if (otherText.textType == requestedType)
				return otherText;
		}
		return null;
	}

	public List<BasicPrice> findPrices(Set<PriceTypes> requestedTypes)
	{
		List<BasicPrice> matches = new ArrayList<BasicPrice>();
		for (BasicSupplyDetail supplyDetail : supplyDetails)
		{
			for (BasicPrice price : supplyDetail.prices)
			{
				if (requestedTypes.contains(price.priceType))
					matches.add(price);
			}
		}
		return matches;
	}

	public List<BasicSalesRights> findSalesRightss(Set<SalesRightsTypes> requestedTypes)
	{
//		return product.findSalesRightss(requestedTypes);
		List<BasicSalesRights> matches = new ArrayList<BasicSalesRights>();
		for (BasicSalesRights salesRights : salesRights)
		{
			if (requestedTypes.contains(salesRights.salesRightsType))
				matches.add(salesRights);
		}
		return matches;
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("------------------------------------------------------------------------").append("\n");
		sb.append("recordReference=      ").append(recordReference).append("\n");
		sb.append("notificationType=     ").append(notificationType).append("\n");
		sb.append("productIds=           ").append(productIds).append("\n");
		sb.append("editionType=          ").append(editionType).append("\n");
		sb.append("editionNumber=        ").append(editionNumber).append("\n");
		sb.append("productForm=          ").append(productForm).append("\n");
		sb.append("languages=            ").append(languages).append("\n");
		sb.append("audiences=            ").append(audiences).append("\n");
		sb.append("publicationDate=      ").append(publicationDate).append("\n");
		sb.append("countryOfPublication= ").append(countryOfPublication).append("\n");
		sb.append("cityOfPublication=    ").append(cityOfPublication).append("\n");
		sb.append("numberOfPages=        ").append(numberOfPages).append("\n");
		sb.append("titles=               ").append(titles).append("\n");
		sb.append("contributors=         ").append(contributors).append("\n");
		sb.append("seriess=              ").append(collections).append("\n");
		sb.append("subjects=             ").append(subjects).append("\n");
		sb.append("otherTexts=           ").append(texts).append("\n");
		sb.append("publishers=           ").append(publishers).append("\n");
		sb.append("imprints=             ").append(imprints).append("\n");
		sb.append("supplyDetails=        ").append(supplyDetails).append("\n");
		sb.append("salesRightss=         ").append(salesRights).append("\n");
		return sb.toString();
	}
}
