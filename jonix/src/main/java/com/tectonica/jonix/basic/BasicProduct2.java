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

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.codelist.LanguageCodeIso6392Bs;
import com.tectonica.jonix.codelist.LanguageRoles;
import com.tectonica.jonix.codelist.ProductForms;
import com.tectonica.jonix.codelist.ProductIdentifierTypes;
import com.tectonica.jonix.composite.Contributor;
import com.tectonica.jonix.composite.Imprint;
import com.tectonica.jonix.composite.OtherText;
import com.tectonica.jonix.composite.Publisher;
import com.tectonica.jonix.composite.SalesRights;
import com.tectonica.jonix.composite.Series;
import com.tectonica.jonix.composite.Subject;
import com.tectonica.jonix.composite.SupplyDetail;
import com.tectonica.jonix.composite.Title;
import com.tectonica.jonix.onix2.CityOfPublication;
import com.tectonica.jonix.struct.JonixLanguage;
import com.tectonica.jonix.struct.JonixProductIdentifier;

@SuppressWarnings("serial")
public class BasicProduct2 extends BasicProduct
{
	private final com.tectonica.jonix.onix2.Product product;

	public BasicProduct2(com.tectonica.jonix.onix2.Product product)
	{
		this.product = product;

		recordReference = product.getRecordReferenceValue();
		notificationType = product.getNotificationTypeValue();

		editionType = (product.editionTypeCodes == null) ? null : product.editionTypeCodes.get(0).value;
		editionNumber = JPU.convertStringToInteger(product.getEditionNumberValue());
		ProductForms productFormValue = product.getProductFormValue();
		productForm = (productFormValue == null) ? null : productFormValue.name();
		audiences = product.findAudiences(null);

		publicationDate = product.getPublicationDateValue();
		countryOfPublication = product.getCountryOfPublicationValue();
		cityOfPublication = findCityOfPublication(LanguageCodeIso6392Bs.English);
		numberOfPages = product.getNumberOfPagesValue();

		titles = Title.listFrom(product);
		contributors = Contributor.listFrom(product); // TODO: use intf
		seriess = Series.listFrom(product); // onix2-only
		subjects = Subject.listFrom(product); // TODO: use struct
		otherTexts = OtherText.listFrom(product); // TODO: use struct - although not complete
		publishers = Publisher.listFrom(product); // TODO: use intf
		imprints = Imprint.listFrom(product); // non-struct
		supplyDetails = SupplyDetail.listFrom(product); // TODO: use intf
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
		return product.findLanguage(requestedType);
	}

	@Override
	public String findCityOfPublication(LanguageCodeIso6392Bs preferredLanguage)
	{
		if (product.cityOfPublications != null)
		{
			for (CityOfPublication cop : product.cityOfPublications)
			{
				if (cop.language == null || cop.language == preferredLanguage)
					return cop.value;
			}
			return product.cityOfPublications.get(0).value; // return whatever language we have
		}
		return null;
	}
}
