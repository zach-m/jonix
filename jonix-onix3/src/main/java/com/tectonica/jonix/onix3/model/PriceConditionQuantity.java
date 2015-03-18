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

import com.tectonica.jonix.onix3.DU;
import com.tectonica.jonix.onix3.codelist.List3;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

public class PriceConditionQuantity
{
	public static final String refname = "PriceConditionQuantity";
	public static final String shortname = "priceconditionquantity";

	public String datestamp; // dt.DateOrDateTime
	public List3 sourcetype;
	public String sourcename;

	public PriceConditionQuantityType priceConditionQuantityType; // Required
	public Quantity quantity; // Required
	public QuantityUnit quantityUnit; // Required

	public static PriceConditionQuantity fromDoc(org.w3c.dom.Element element)
	{
		final PriceConditionQuantity x = new PriceConditionQuantity();

		x.datestamp = DU.getAttribute(element, "datestamp");
		x.sourcetype = List3.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		DU.forElementsOf(element, new DU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(PriceConditionQuantityType.refname) || name.equals(PriceConditionQuantityType.shortname))
					x.priceConditionQuantityType = PriceConditionQuantityType.fromDoc(element);
				else if (name.equals(Quantity.refname) || name.equals(Quantity.shortname))
					x.quantity = Quantity.fromDoc(element);
				else if (name.equals(QuantityUnit.refname) || name.equals(QuantityUnit.shortname))
					x.quantityUnit = QuantityUnit.fromDoc(element);
			}
		});

		return x;
	}
}
