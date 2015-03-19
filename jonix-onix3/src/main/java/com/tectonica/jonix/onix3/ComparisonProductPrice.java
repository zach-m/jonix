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

import java.util.List;

import com.tectonica.jonix.DU;
import com.tectonica.jonix.codelist.CurrencyCodeIso4217s;
import com.tectonica.jonix.codelist.PriceTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

public class ComparisonProductPrice
{
	public static final String refname = "ComparisonProductPrice";
	public static final String shortname = "comparisonproductprice";

	public String datestamp; // dt.DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public List<ProductIdentifier> productIdentifiers; // OneOrMore
	public PriceType priceType; // Optional
	public PriceAmount priceAmount; // Required
	public CurrencyCode currencyCode; // Optional

	public static ComparisonProductPrice fromDoc(org.w3c.dom.Element element)
	{
		final ComparisonProductPrice x = new ComparisonProductPrice();

		x.datestamp = DU.getAttribute(element, "datestamp");
		x.sourcetype = RecordSourceTypes.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		DU.forElementsOf(element, new DU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(ProductIdentifier.refname) || name.equals(ProductIdentifier.shortname))
					x.productIdentifiers = DU.addToList(x.productIdentifiers, ProductIdentifier.fromDoc(element));
				else if (name.equals(PriceType.refname) || name.equals(PriceType.shortname))
					x.priceType = PriceType.fromDoc(element);
				else if (name.equals(PriceAmount.refname) || name.equals(PriceAmount.shortname))
					x.priceAmount = PriceAmount.fromDoc(element);
				else if (name.equals(CurrencyCode.refname) || name.equals(CurrencyCode.shortname))
					x.currencyCode = CurrencyCode.fromDoc(element);
			}
		});

		return x;
	}

	public PriceTypes getPriceTypeValue()
	{
		return (priceType == null) ? null : priceType.value;
	}

	public Double getPriceAmountValue()
	{
		return (priceAmount == null) ? null : priceAmount.value;
	}

	public CurrencyCodeIso4217s getCurrencyCodeValue()
	{
		return (currencyCode == null) ? null : currencyCode.value;
	}
}
