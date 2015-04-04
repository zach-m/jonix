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
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

@SuppressWarnings("serial")
public class SalesOutlet implements OnixSuperComposite, Serializable
{
	public static final String refname = "SalesOutlet";
	public static final String shortname = "salesoutlet";

	public String datestamp; // dt.DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public List<SalesOutletIdentifier> salesOutletIdentifiers; // OneOrMore
	public SalesOutletName salesOutletName; // Optional

	public SalesOutlet()
	{}

	public SalesOutlet(org.w3c.dom.Element element)
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
				if (name.equals(SalesOutletIdentifier.refname) || name.equals(SalesOutletIdentifier.shortname))
					salesOutletIdentifiers = JPU.addToList(salesOutletIdentifiers, new SalesOutletIdentifier(element));
				else if (name.equals(SalesOutletName.refname) || name.equals(SalesOutletName.shortname))
					salesOutletName = new SalesOutletName(element);
			}
		});
	}

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

	public List<JonixSalesOutletIdentifier> findSalesOutletIdentifiers(java.util.Set<SalesOutletIdentifierTypes> salesOutletIDTypes)
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
