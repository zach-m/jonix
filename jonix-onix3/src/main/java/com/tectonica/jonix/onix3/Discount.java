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
import com.tectonica.jonix.codelist.DiscountTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixDiscount;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <h1>Discount composite</h1>
 * <p>
 * A repeatable group of data elements which together define a discount either as a percentage or as an absolute amount.
 * Optional. Used only when an ONIX message is sent within the context of a specific trading relationship.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;Discount&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;discount&gt;</td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 */
public class Discount implements OnixDataComposite, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "Discount";
	public static final String shortname = "discount";

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
	 * (this field is optional)
	 */
	public DiscountType discountType;

	/**
	 * (this field is optional)
	 */
	public Quantity quantity;

	/**
	 * (this field is optional)
	 */
	public ToQuantity toQuantity;

	/**
	 * (this field is required)
	 */
	public DiscountPercent discountPercent;

	/**
	 * (this field is optional)
	 */
	public DiscountAmount discountAmount;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public Discount()
	{}

	public Discount(org.w3c.dom.Element element)
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
				if (name.equals(DiscountType.refname) || name.equals(DiscountType.shortname))
					discountType = new DiscountType(element);
				else if (name.equals(Quantity.refname) || name.equals(Quantity.shortname))
					quantity = new Quantity(element);
				else if (name.equals(ToQuantity.refname) || name.equals(ToQuantity.shortname))
					toQuantity = new ToQuantity(element);
				else if (name.equals(DiscountPercent.refname) || name.equals(DiscountPercent.shortname))
					discountPercent = new DiscountPercent(element);
				else if (name.equals(DiscountAmount.refname) || name.equals(DiscountAmount.shortname))
					discountAmount = new DiscountAmount(element);
			}
		});
	}

	public DiscountTypes getDiscountTypeValue()
	{
		return (discountType == null) ? null : discountType.value;
	}

	public Double getQuantityValue()
	{
		return (quantity == null) ? null : quantity.value;
	}

	public Double getToQuantityValue()
	{
		return (toQuantity == null) ? null : toQuantity.value;
	}

	public Double getDiscountPercentValue()
	{
		return (discountPercent == null) ? null : discountPercent.value;
	}

	public Double getDiscountAmountValue()
	{
		return (discountAmount == null) ? null : discountAmount.value;
	}

	public JonixDiscount asJonixDiscount()
	{
		JonixDiscount x = new JonixDiscount();
		x.discountType = getDiscountTypeValue();
		x.quantity = getQuantityValue();
		x.toQuantity = getToQuantityValue();
		x.discountPercent = getDiscountPercentValue();
		x.discountAmount = getDiscountAmountValue();
		return x;
	}
}
