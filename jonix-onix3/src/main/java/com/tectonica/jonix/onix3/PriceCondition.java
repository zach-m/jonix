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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.codelist.PriceConditionQuantityTypes;
import com.tectonica.jonix.codelist.PriceConditionTypes;
import com.tectonica.jonix.codelist.ProductIdentifierTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixPriceConditionQuantity;
import com.tectonica.jonix.struct.JonixProductIdentifier;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

@SuppressWarnings("serial")
public class PriceCondition implements Serializable
{
	public static final String refname = "PriceCondition";
	public static final String shortname = "pricecondition";

	public String datestamp; // dt.DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public PriceConditionType priceConditionType; // Required
	public List<PriceConditionQuantity> priceConditionQuantitys; // ZeroOrMore
	public List<ProductIdentifier> productIdentifiers; // ZeroOrMore

	public PriceCondition()
	{}

	public PriceCondition(org.w3c.dom.Element element)
	{
		this.datestamp = JPU.getAttribute(element, "datestamp");
		this.sourcetype = RecordSourceTypes.byValue(JPU.getAttribute(element, "sourcetype"));
		this.sourcename = JPU.getAttribute(element, "sourcename");

		JPU.forElementsOf(element, new JPU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(PriceConditionType.refname) || name.equals(PriceConditionType.shortname))
					priceConditionType = new PriceConditionType(element);
				else if (name.equals(PriceConditionQuantity.refname) || name.equals(PriceConditionQuantity.shortname))
					priceConditionQuantitys = JPU.addToList(priceConditionQuantitys, new PriceConditionQuantity(element));
				else if (name.equals(ProductIdentifier.refname) || name.equals(ProductIdentifier.shortname))
					productIdentifiers = JPU.addToList(productIdentifiers, new ProductIdentifier(element));
			}
		});
	}

	public PriceConditionTypes getPriceConditionTypeValue()
	{
		return (priceConditionType == null) ? null : priceConditionType.value;
	}

	public JonixPriceConditionQuantity findPriceConditionQuantity(PriceConditionQuantityTypes priceConditionQuantityType)
	{
		if (priceConditionQuantitys != null)
		{
			for (PriceConditionQuantity x : priceConditionQuantitys)
			{
				if (x.getPriceConditionQuantityTypeValue() == priceConditionQuantityType)
					return x.asStruct();
			}
		}
		return null;
	}

	public List<JonixPriceConditionQuantity> findPriceConditionQuantitys(
			java.util.Set<PriceConditionQuantityTypes> priceConditionQuantityTypes)
	{
		if (priceConditionQuantitys != null)
		{
			List<JonixPriceConditionQuantity> matches = new ArrayList<>();
			for (PriceConditionQuantity x : priceConditionQuantitys)
			{
				if (priceConditionQuantityTypes == null || priceConditionQuantityTypes.contains(x.getPriceConditionQuantityTypeValue()))
					matches.add(x.asStruct());
			}
			return matches;
		}
		return null;
	}

	public JonixProductIdentifier findProductIdentifier(ProductIdentifierTypes productIDType)
	{
		if (productIdentifiers != null)
		{
			for (ProductIdentifier x : productIdentifiers)
			{
				if (x.getProductIDTypeValue() == productIDType)
					return x.asStruct();
			}
		}
		return null;
	}

	public List<JonixProductIdentifier> findProductIdentifiers(java.util.Set<ProductIdentifierTypes> productIDTypes)
	{
		if (productIdentifiers != null)
		{
			List<JonixProductIdentifier> matches = new ArrayList<>();
			for (ProductIdentifier x : productIdentifiers)
			{
				if (productIDTypes == null || productIDTypes.contains(x.getProductIDTypeValue()))
					matches.add(x.asStruct());
			}
			return matches;
		}
		return null;
	}
}
