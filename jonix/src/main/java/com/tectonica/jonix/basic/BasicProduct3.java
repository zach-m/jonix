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

import java.util.List;

import com.tectonica.jonix.codelist.EditionTypes;
import com.tectonica.jonix.codelist.ExtentTypes;
import com.tectonica.jonix.codelist.LanguageCodeIso6392Bs;
import com.tectonica.jonix.codelist.LanguageRoles;
import com.tectonica.jonix.codelist.ProductFormsList150;
import com.tectonica.jonix.codelist.ProductIdentifierTypes;
import com.tectonica.jonix.codelist.PublishingDateRoles;
import com.tectonica.jonix.composite.Contributor;
import com.tectonica.jonix.composite.Imprint;
import com.tectonica.jonix.composite.OtherText;
import com.tectonica.jonix.composite.Publisher;
import com.tectonica.jonix.composite.SalesRights;
import com.tectonica.jonix.composite.Series;
import com.tectonica.jonix.composite.Subject;
import com.tectonica.jonix.composite.SupplyDetail;
import com.tectonica.jonix.composite.Title;
import com.tectonica.jonix.onix3.CityOfPublication;
import com.tectonica.jonix.onix3.DescriptiveDetail;
import com.tectonica.jonix.onix3.PublishingDetail;
import com.tectonica.jonix.struct.JonixExtent;
import com.tectonica.jonix.struct.JonixLanguage;
import com.tectonica.jonix.struct.JonixProductIdentifier;
import com.tectonica.jonix.struct.JonixPublishingDate;

@SuppressWarnings("serial")
public class BasicProduct3 extends BasicProduct
{
	private final com.tectonica.jonix.onix3.Product product;

	public BasicProduct3(com.tectonica.jonix.onix3.Product product)
	{
		this.product = product;

		recordReference = product.getRecordReferenceValue();
		notificationType = product.getNotificationTypeValue();

		DescriptiveDetail dd = product.descriptiveDetail;
		if (dd != null)
		{
			List<EditionTypes> editionTypes = dd.getEditionTypeValues();
			editionType = (editionTypes == null) ? null : editionTypes.get(0);
			editionNumber = dd.getEditionNumberValue();
			ProductFormsList150 productFormValue = dd.getProductFormValue();
			productForm = (productFormValue == null) ? null : productFormValue.name();
			audiences = dd.findAudiences(null);
		}

		PublishingDetail pd = product.publishingDetail;
		if (pd != null)
		{
			JonixPublishingDate jPublicationDate = pd.findPublishingDate(PublishingDateRoles.Publication_date);
			publicationDate = (jPublicationDate == null) ? null : jPublicationDate.date;
			countryOfPublication = pd.getCountryOfPublicationValue();
			cityOfPublication = findCityOfPublication(LanguageCodeIso6392Bs.English);
			JonixExtent jNumberOfPages = dd.findExtent(ExtentTypes.Main_content_page_count);
			numberOfPages = (jNumberOfPages == null) ? null : jNumberOfPages.extentValue.toString();
		}

		titles = Title.listFrom(product);
		contributors = Contributor.listFrom(product);
		seriess = Series.listFrom(product); // series and collections are composites, not structs
		subjects = Subject.listFrom(product); // not struct due to Onix2's BASICMainSubject and BICMainSubject
		otherTexts = OtherText.listFrom(product);
		publishers = Publisher.listFrom(product);
		imprints = Imprint.listFrom(product); // publishers are composites, not structs
		supplyDetails = SupplyDetail.listFrom(product);
		salesRightss = SalesRights.listFrom(product); // non-struct
	}

	@Override
	public Object getProductObject()
	{
		return product;
	}

	@Override
	public JonixProductIdentifier findProductId(ProductIdentifierTypes requestedType)
	{
		return product.findProductIdentifier(requestedType);
	}

	@Override
	public JonixLanguage findLanguage(LanguageRoles requestedType)
	{
		if (product.descriptiveDetail == null)
			return null;

		return product.descriptiveDetail.findLanguage(requestedType);
	}

	@Override
	public String findCityOfPublication(LanguageCodeIso6392Bs preferredLanguage)
	{
		if (product.publishingDetail == null)
			return null;

		List<CityOfPublication> cops = product.publishingDetail.cityOfPublications;
		if (cops == null)
			return null;

		for (CityOfPublication cop : cops)
		{
			if (cop.language == null || cop.language == preferredLanguage)
				return cop.value;
		}
		return cops.get(0).value; // return whatever language we have
	}
}
