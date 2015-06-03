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

import com.tectonica.jonix.JonixColumn;
import com.tectonica.jonix.codelist.ContributorRoles;
import com.tectonica.jonix.codelist.CountryCodeIso31661s;
import com.tectonica.jonix.codelist.EditionTypes;
import com.tectonica.jonix.codelist.LanguageCodeIso6392Bs;
import com.tectonica.jonix.codelist.LanguageRoles;
import com.tectonica.jonix.codelist.NotificationOrUpdateTypes;
import com.tectonica.jonix.codelist.PriceTypes;
import com.tectonica.jonix.codelist.ProductIdentifierTypes;
import com.tectonica.jonix.codelist.SalesRightsTypes;
import com.tectonica.jonix.codelist.SubjectSchemeIdentifiers;
import com.tectonica.jonix.codelist.TextTypes;
import com.tectonica.jonix.codelist.TitleTypes;
import com.tectonica.jonix.composite.Contributor;
import com.tectonica.jonix.composite.Imprint;
import com.tectonica.jonix.composite.OtherText;
import com.tectonica.jonix.composite.Price;
import com.tectonica.jonix.composite.Publisher;
import com.tectonica.jonix.composite.SalesRights;
import com.tectonica.jonix.composite.Series;
import com.tectonica.jonix.composite.Subject;
import com.tectonica.jonix.composite.SupplyDetail;
import com.tectonica.jonix.composite.Title;
import com.tectonica.jonix.struct.JonixAudience;
import com.tectonica.jonix.struct.JonixLanguage;
import com.tectonica.jonix.struct.JonixProductIdentifier;

@SuppressWarnings("serial")
public abstract class BasicProduct implements Serializable
{
	// basic
	public String recordReference;
	public NotificationOrUpdateTypes notificationType;

	// descriptive
	public EditionTypes editionType;
	public Integer editionNumber;
	public String productForm;
	public List<JonixAudience> audiences;

	// publication
	public String publicationDate;
	public CountryCodeIso31661s countryOfPublication;
	public String cityOfPublication;
	public String numberOfPages;

	// others
	// TODO: maybe return productIdentifiers languages
//	public List<ProductIdentifier> productIdentifiers;
//	public List<Title> titles;
	public List<Title> titles;
	public List<Contributor> contributors;
	public List<Series> seriess;
	public Map<SubjectSchemeIdentifiers, List<Subject>> subjects;
	public List<OtherText> otherTexts;
	public List<Publisher> publishers;
	public List<Imprint> imprints;
	public List<SupplyDetail> supplyDetails;
	public List<SalesRights> salesRightss;
	
	public abstract Object getProductObject();

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

	public Title findTitle(TitleTypes requestedType)
	{
		for (Title title : titles)
		{
			if (title.titleType == requestedType)
				return title;
		}
		return null;
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

	public List<Subject> findSubjects(SubjectSchemeIdentifiers requestedScheme)
	{
		List<Subject> list = subjects.get(requestedScheme);
		if (list == null)
			return Collections.emptyList();
		return list;
	}

	public OtherText findOtherText(TextTypes requestedType)
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

	public abstract JonixProductIdentifier findProductId(ProductIdentifierTypes requestedType);

	public abstract JonixLanguage findLanguage(LanguageRoles requestedType);

	public abstract String findCityOfPublication(LanguageCodeIso6392Bs preferredLanguage);
}
