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
import com.tectonica.jonix.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.codelist.PriceConditionQuantityTypes;
import com.tectonica.jonix.codelist.PriceConditionTypes;
import com.tectonica.jonix.codelist.ProductIdentifierTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixPriceConditionQuantity;
import com.tectonica.jonix.struct.JonixProductIdentifier;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <h1>Price condition composite</h1>
 * <p>
 * A repeatable group of data elements which together specify a condition relating to a price.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;PriceCondition&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;pricecondition&gt;</td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 */
public class PriceCondition implements OnixSuperComposite, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "PriceCondition";
	public static final String shortname = "pricecondition";

	// ///////////////////////////////////////////////////////////////////////////////
	// ATTRIBUTES
	// ///////////////////////////////////////////////////////////////////////////////

	/**
	 * (type: dt.DateOrDateTime)
	 */
	public String datestamp;

	public RecordSourceTypes sourcetype;

	public String sourcename;

	// ///////////////////////////////////////////////////////////////////////////////
	// MEMBERS
	// ///////////////////////////////////////////////////////////////////////////////

	/**
	 * (this field is required)
	 */
	public PriceConditionType priceConditionType;

	/**
	 * (this list may be empty)
	 */
	public List<PriceConditionQuantity> priceConditionQuantitys;

	/**
	 * (this list may be empty)
	 */
	public List<ProductIdentifier> productIdentifiers;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public PriceCondition()
	{}

	public PriceCondition(org.w3c.dom.Element element)
	{
		datestamp = JPU.getAttribute(element, "datestamp");
		sourcetype = RecordSourceTypes.byValue(JPU.getAttribute(element, "sourcetype"));
		sourcename = JPU.getAttribute(element, "sourcename");

		JPU.forElementsOf(element, new JPU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(PriceConditionType.refname) || name.equals(PriceConditionType.shortname))
					priceConditionType = new PriceConditionType(element);
				else if (name.equals(PriceConditionQuantity.refname) || name.equals(PriceConditionQuantity.shortname))
					priceConditionQuantitys = JPU.addToList(priceConditionQuantitys,
							new PriceConditionQuantity(element));
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
					return x.asJonixPriceConditionQuantity();
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
				if (priceConditionQuantityTypes == null
						|| priceConditionQuantityTypes.contains(x.getPriceConditionQuantityTypeValue()))
					matches.add(x.asJonixPriceConditionQuantity());
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
					return x.asJonixProductIdentifier();
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
					matches.add(x.asJonixProductIdentifier());
			}
			return matches;
		}
		return null;
	}
}
