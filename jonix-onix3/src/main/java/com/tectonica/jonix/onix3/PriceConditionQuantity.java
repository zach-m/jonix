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

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.OnixComposite.OnixDataComposite;
import com.tectonica.jonix.codelist.PriceConditionQuantityTypes;
import com.tectonica.jonix.codelist.QuantityUnits;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixPriceConditionQuantity;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <h1>Price condition quantity composite</h1>
 * <p>
 * An optional and repeatable group of data elements which together specify a price condition quantity, for example a
 * minimum number of copies, or a period of time for which updates are supplied or must be purchased.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;PriceConditionQuantity&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;priceconditionquantity&gt;</td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 */
public class PriceConditionQuantity implements OnixDataComposite, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "PriceConditionQuantity";
	public static final String shortname = "priceconditionquantity";

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
	public PriceConditionQuantityType priceConditionQuantityType;

	/**
	 * (this field is required)
	 */
	public Quantity quantity;

	/**
	 * (this field is required)
	 */
	public QuantityUnit quantityUnit;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public PriceConditionQuantity()
	{}

	public PriceConditionQuantity(org.w3c.dom.Element element)
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
				if (name.equals(PriceConditionQuantityType.refname)
						|| name.equals(PriceConditionQuantityType.shortname))
					priceConditionQuantityType = new PriceConditionQuantityType(element);
				else if (name.equals(Quantity.refname) || name.equals(Quantity.shortname))
					quantity = new Quantity(element);
				else if (name.equals(QuantityUnit.refname) || name.equals(QuantityUnit.shortname))
					quantityUnit = new QuantityUnit(element);
			}
		});
	}

	public PriceConditionQuantityTypes getPriceConditionQuantityTypeValue()
	{
		return (priceConditionQuantityType == null) ? null : priceConditionQuantityType.value;
	}

	/**
	 * Format: Variable-length decimal number, here necessarily an integer
	 */
	public Double getQuantityValue()
	{
		return (quantity == null) ? null : quantity.value;
	}

	public QuantityUnits getQuantityUnitValue()
	{
		return (quantityUnit == null) ? null : quantityUnit.value;
	}

	public JonixPriceConditionQuantity asJonixPriceConditionQuantity()
	{
		JonixPriceConditionQuantity x = new JonixPriceConditionQuantity();
		x.priceConditionQuantityType = getPriceConditionQuantityTypeValue();
		x.quantity = getQuantityValue();
		x.quantityUnit = getQuantityUnitValue();
		return x;
	}
}
