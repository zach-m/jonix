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
import com.tectonica.jonix.codelist.ProductForms;
import com.tectonica.jonix.onix2.AudienceRange;
import com.tectonica.jonix.onix2.Product;

/**
 * ONIX2 concrete implementation for {@link BasicDescription}
 * 
 * @author Zach Melamed
 */
public class BasicDescription2 extends BasicDescription
{
	private static final long serialVersionUID = 1L;

	private transient final AudienceRange audienceRange;

	public BasicDescription2(Product product)
	{
		editionType = product.editionTypeCodes().firstValue().orElse(null);
		editionNumber = JPU.convertStringToInteger(product.editionNumber().value);
		productForm = product.productForm().value().map(fv -> fv.description).orElse(null);
		numberOfPages = product.numberOfPages().value;
		languages = product.languages().asStructs(); // TODO: lazify
		audiences = product.audiences().asStructs(); // TODO: lazify
		audienceCodes = product.audienceCodes().values();
		audienceRange = product.audienceRanges().first().orElse(null);
	}

	@Override
	public Integer[] getFirstAudienceAgeRange()
	{
		if (audienceRange != null)
			return getAudienceAgeRange(audienceRange.asStruct());
		return new Integer[] { null, null };
	}
}
