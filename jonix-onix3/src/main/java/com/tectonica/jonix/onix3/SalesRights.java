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
import com.tectonica.jonix.codelist.ProductIdentifierTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.SalesRightsTypes;
import com.tectonica.jonix.struct.JonixProductIdentifier;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <h1>Sales rights composite</h1>
 * <p>
 * An optional and repeatable group of data elements which together identify territorial sales rights which a publisher
 * chooses to exercise in a product. When specifying a territory in which the product is not for sale, the publisher and
 * product ID for an edition which is available in the specified territory can optionally be included. (In previous
 * releases, this functionality was provided in a &lt;NotForSale&gt; composite, which is now redundant and has been
 * deleted.) See examples at the end of the sales rights composite.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;SalesRights&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;salesrights&gt;</td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 */
public class SalesRights implements OnixSuperComposite, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "SalesRights";
	public static final String shortname = "salesrights";

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
	public SalesRightsType salesRightsType;

	/**
	 * (this field is required)
	 */
	public Territory territory;

	/**
	 * (this list may be empty)
	 */
	public List<SalesRestriction> salesRestrictions;

	/**
	 * (this list may be empty)
	 */
	public List<ProductIdentifier> productIdentifiers;

	/**
	 * (this field is optional)
	 */
	public PublisherName publisherName;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public SalesRights()
	{}

	public SalesRights(org.w3c.dom.Element element)
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
				if (name.equals(SalesRightsType.refname) || name.equals(SalesRightsType.shortname))
					salesRightsType = new SalesRightsType(element);
				else if (name.equals(Territory.refname) || name.equals(Territory.shortname))
					territory = new Territory(element);
				else if (name.equals(SalesRestriction.refname) || name.equals(SalesRestriction.shortname))
					salesRestrictions = JPU.addToList(salesRestrictions, new SalesRestriction(element));
				else if (name.equals(ProductIdentifier.refname) || name.equals(ProductIdentifier.shortname))
					productIdentifiers = JPU.addToList(productIdentifiers, new ProductIdentifier(element));
				else if (name.equals(PublisherName.refname) || name.equals(PublisherName.shortname))
					publisherName = new PublisherName(element);
			}
		});
	}

	public SalesRightsTypes getSalesRightsTypeValue()
	{
		return (salesRightsType == null) ? null : salesRightsType.value;
	}

	/**
	 * Raw Format: Variable length text, suggested maximum length 100 characters
	 */
	public String getPublisherNameValue()
	{
		return (publisherName == null) ? null : publisherName.value;
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
