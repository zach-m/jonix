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
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.SalesOutletIdentifierTypes;
import com.tectonica.jonix.struct.JonixSalesOutletIdentifier;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <h1>Sales outlet composite</h1>
 * <p>
 * An optional and repeatable group of data elements which together identify a sales outlet to which a restriction is
 * linked. Each occurrence of the composite must include a &lt;SalesOutletIdentifier&gt; composite of a
 * &lt;SalesOutletName&gt; or both.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;SalesOutlet&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;salesoutlet&gt;</td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 */
public class SalesOutlet implements OnixSuperComposite, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "SalesOutlet";
	public static final String shortname = "salesoutlet";

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
	public List<SalesOutletIdentifier> salesOutletIdentifiers;

	/**
	 * (this field is optional)
	 */
	public SalesOutletName salesOutletName;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public SalesOutlet()
	{}

	public SalesOutlet(org.w3c.dom.Element element)
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
				if (name.equals(SalesOutletIdentifier.refname) || name.equals(SalesOutletIdentifier.shortname))
					salesOutletIdentifiers = JPU.addToList(salesOutletIdentifiers, new SalesOutletIdentifier(element));
				else if (name.equals(SalesOutletName.refname) || name.equals(SalesOutletName.shortname))
					salesOutletName = new SalesOutletName(element);
			}
		});
	}

	/**
	 * Format: Variable-length text, suggested maximum length 200 characters
	 */
	public String getSalesOutletNameValue()
	{
		return (salesOutletName == null) ? null : salesOutletName.value;
	}

	public JonixSalesOutletIdentifier findSalesOutletIdentifier(SalesOutletIdentifierTypes salesOutletIDType)
	{
		if (salesOutletIdentifiers != null)
		{
			for (SalesOutletIdentifier x : salesOutletIdentifiers)
			{
				if (x.getSalesOutletIDTypeValue() == salesOutletIDType)
					return x.asJonixSalesOutletIdentifier();
			}
		}
		return null;
	}

	public List<JonixSalesOutletIdentifier> findSalesOutletIdentifiers(
			java.util.Set<SalesOutletIdentifierTypes> salesOutletIDTypes)
	{
		if (salesOutletIdentifiers != null)
		{
			List<JonixSalesOutletIdentifier> matches = new ArrayList<>();
			for (SalesOutletIdentifier x : salesOutletIdentifiers)
			{
				if (salesOutletIDTypes == null || salesOutletIDTypes.contains(x.getSalesOutletIDTypeValue()))
					matches.add(x.asJonixSalesOutletIdentifier());
			}
			return matches;
		}
		return null;
	}
}
