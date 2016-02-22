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

import com.tectonica.jonix.basic.BasicPublishingDetails;
import com.tectonica.jonix.codelist.LanguageCodes;
import com.tectonica.jonix.codelist.PublishingDateRoles;
import com.tectonica.jonix.onix3.CityOfPublication;
import com.tectonica.jonix.onix3.Product;
import com.tectonica.jonix.onix3.PublishingDetail;
import com.tectonica.jonix.struct.JonixPublishingDate;

/**
 * ONIX3 concrete implementation for {@link BasicPublishingDetails}
 * 
 * @author Zach Melamed
 */
public class BasicPublishingDetails3 extends BasicPublishingDetails
{
	private static final long serialVersionUID = 1L;

	public BasicPublishingDetails3(Product product)
	{
		PublishingDetail pd = product.publishingDetail;
		if (pd != null)
		{
			JonixPublishingDate jPublicationDate = pd.findPublishingDate(PublishingDateRoles.Publication_date);
			publicationDate = (jPublicationDate == null) ? null : jPublicationDate.date;
			countryOfPublication = pd.getCountryOfPublicationValue();
			cityOfPublication = pickCityOfPublication(product, LanguageCodes.English);
		}
		else
		{
			publicationDate = null;
			countryOfPublication = null;
			cityOfPublication = null;
		}
	}

	private String pickCityOfPublication(Product product, LanguageCodes preferredLanguage)
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
