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

package com.tectonica.jonix.onix3.model;

import java.util.List;

import com.tectonica.jonix.onix3.DU;
import com.tectonica.jonix.onix3.codelist.List3;

public class PriceCondition
{
	public static final String refname = "PriceCondition";
	public static final String shortname = "pricecondition";

	public String datestamp; // dt.DateOrDateTime
	public List3 sourcetype;
	public String sourcename;

	public PriceConditionType priceConditionType; // Required
	public List<PriceConditionQuantity> priceConditionQuantitys; // ZeroOrMore
	public List<ProductIdentifier> productIdentifiers; // ZeroOrMore

	public static PriceCondition fromDoc(org.w3c.dom.Element element)
	{
		final PriceCondition x = new PriceCondition();

		x.datestamp = DU.getAttribute(element, "datestamp");
		x.sourcetype = List3.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		DU.forElementsOf(element, new DU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equalsIgnoreCase(PriceConditionType.refname) || name.equalsIgnoreCase(PriceConditionType.shortname))
					x.priceConditionType = PriceConditionType.fromDoc(element);
				else if (name.equalsIgnoreCase(PriceConditionQuantity.refname) || name.equalsIgnoreCase(PriceConditionQuantity.shortname))
					x.priceConditionQuantitys = DU.addToList(x.priceConditionQuantitys, PriceConditionQuantity.fromDoc(element));
				else if (name.equalsIgnoreCase(ProductIdentifier.refname) || name.equalsIgnoreCase(ProductIdentifier.shortname))
					x.productIdentifiers = DU.addToList(x.productIdentifiers, ProductIdentifier.fromDoc(element));
			}
		});

		return x;
	}
}
