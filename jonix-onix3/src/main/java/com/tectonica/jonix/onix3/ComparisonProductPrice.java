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
import com.tectonica.jonix.codelist.CurrencyCodes;
import com.tectonica.jonix.codelist.PriceTypes;
import com.tectonica.jonix.codelist.ProductIdentifierTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixProductIdentifier;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <h1>Comparison product price composite</h1>
 * <p>
 * Optional and repeatable group of data elements that together define a price for a directly comparable product, to
 * facilitate supply of price data to retailers who do not receive a full ONIX record for that comparable product. This
 * is primarily intended for use within a &lt;Product&gt; record for a digital product, to provide a price for a
 * comparable physical product.
 * </p>
 * <p>
 * Those using this composite should be wary of the volatile nature of product prices: special note should be taken of
 * the risk of stale data being stored in data recipients’ systems when prices for the comparison product are updated,
 * as those updates to the comparison product may occur outside the context of the main product being described in the
 * &lt;Product&gt; record. Because of this, ONIX suppliers are cautioned of the risk of contradictory data in separate
 * data feeds. <em>This composite should not be supplied unless specifically requested by a particular recipient.</em>
 * </p>
 * <p>
 * The inclusion of a comparison price in itself implies nothing about the availability or status of the comparable
 * product. However, there may be legal requirements in particular territories relating to the use of comparison prices
 * in promotion that users of this data must comply with.
 * </p>
 * <p>
 * Note that the comparison product price composite does not include all the features of the &lt;Price&gt; composite:
 * for example, &lt;PriceQualifier&gt; is not included. Thus data providers should ensure that any conditions attached
 * to the comparison product price are such that it is directly comparable to the price of the main product being
 * described.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;ComparisonProductPrice&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;comparisonproductprice&gt;</td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 */
public class ComparisonProductPrice implements OnixSuperComposite, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "ComparisonProductPrice";
	public static final String shortname = "comparisonproductprice";

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
	 * (this list is required to contain at least one item)
	 */
	public List<ProductIdentifier> productIdentifiers;

	/**
	 * (this field is optional)
	 */
	public PriceType priceType;

	/**
	 * (this field is required)
	 */
	public PriceAmount priceAmount;

	/**
	 * (this field is optional)
	 */
	public CurrencyCode currencyCode;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public ComparisonProductPrice()
	{}

	public ComparisonProductPrice(org.w3c.dom.Element element)
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
				if (name.equals(ProductIdentifier.refname) || name.equals(ProductIdentifier.shortname))
					productIdentifiers = JPU.addToList(productIdentifiers, new ProductIdentifier(element));
				else if (name.equals(PriceType.refname) || name.equals(PriceType.shortname))
					priceType = new PriceType(element);
				else if (name.equals(PriceAmount.refname) || name.equals(PriceAmount.shortname))
					priceAmount = new PriceAmount(element);
				else if (name.equals(CurrencyCode.refname) || name.equals(CurrencyCode.shortname))
					currencyCode = new CurrencyCode(element);
			}
		});
	}

	public PriceTypes getPriceTypeValue()
	{
		return (priceType == null) ? null : priceType.value;
	}

	/**
	 * Raw Format: Variable length real number, with explicit decimal point when required, suggested maximum length 12
	 * characters
	 */
	public Double getPriceAmountValue()
	{
		return (priceAmount == null) ? null : priceAmount.value;
	}

	public CurrencyCodes getCurrencyCodeValue()
	{
		return (currencyCode == null) ? null : currencyCode.value;
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
