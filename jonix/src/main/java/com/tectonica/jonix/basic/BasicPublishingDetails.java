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
import java.util.List;

import com.tectonica.jonix.codelist.CountryCodeIso31661s;
import com.tectonica.jonix.codelist.LanguageCodeIso6392Bs;
import com.tectonica.jonix.codelist.PublishingDateRoles;
import com.tectonica.jonix.struct.JonixPublishingDate;

/**
 * Bundles together some publishing-related information included in an ONIX product
 * <p>
 * NOTE: to access the information, read the (public final) fields directly. No getters() are included..
 * <p>
 * May be constructed from either a {@link com.tectonica.jonix.onix2.Product} or a
 * {@link com.tectonica.jonix.onix3.Product}.
 * 
 * @author Zach Melamed
 */
public class BasicPublishingDetails implements Serializable
{
	private static final long serialVersionUID = 1L;

	public final String publicationDate;
	public final CountryCodeIso31661s countryOfPublication;
	public final String cityOfPublication;

	public BasicPublishingDetails(com.tectonica.jonix.onix2.Product product)
	{
		publicationDate = product.getPublicationDateValue();
		countryOfPublication = product.getCountryOfPublicationValue();
		cityOfPublication = pickCityOfPublication(product, LanguageCodeIso6392Bs.English);
	}

	public BasicPublishingDetails(com.tectonica.jonix.onix3.Product product)
	{
		com.tectonica.jonix.onix3.PublishingDetail pd = product.publishingDetail;
		if (pd != null)
		{
			JonixPublishingDate jPublicationDate = pd.findPublishingDate(PublishingDateRoles.Publication_date);
			publicationDate = (jPublicationDate == null) ? null : jPublicationDate.date;
			countryOfPublication = pd.getCountryOfPublicationValue();
			cityOfPublication = pickCityOfPublication(product, LanguageCodeIso6392Bs.English);
		}
		else
		{
			publicationDate = null;
			countryOfPublication = null;
			cityOfPublication = null;
		}
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
}
