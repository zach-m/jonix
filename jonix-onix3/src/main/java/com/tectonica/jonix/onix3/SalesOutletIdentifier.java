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
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.SalesOutletIdentifierTypes;
import com.tectonica.jonix.struct.JonixSalesOutletIdentifier;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

@SuppressWarnings("serial")
public class SalesOutletIdentifier implements OnixDataComposite, Serializable
{
	public static final String refname = "SalesOutletIdentifier";
	public static final String shortname = "salesoutletidentifier";

	public String datestamp; // dt.DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public SalesOutletIDType salesOutletIDType; // Required
	public IDTypeName idTypeName; // Optional
	public IDValue idValue; // Required

	public SalesOutletIdentifier()
	{}

	public SalesOutletIdentifier(org.w3c.dom.Element element)
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
				if (name.equals(SalesOutletIDType.refname) || name.equals(SalesOutletIDType.shortname))
					salesOutletIDType = new SalesOutletIDType(element);
				else if (name.equals(IDTypeName.refname) || name.equals(IDTypeName.shortname))
					idTypeName = new IDTypeName(element);
				else if (name.equals(IDValue.refname) || name.equals(IDValue.shortname))
					idValue = new IDValue(element);
			}
		});
	}

	public SalesOutletIdentifierTypes getSalesOutletIDTypeValue()
	{
		return (salesOutletIDType == null) ? null : salesOutletIDType.value;
	}

	public String getIDTypeNameValue()
	{
		return (idTypeName == null) ? null : idTypeName.value;
	}

	public String getIDValueValue()
	{
		return (idValue == null) ? null : idValue.value;
	}

	public JonixSalesOutletIdentifier asJonixSalesOutletIdentifier()
	{
		JonixSalesOutletIdentifier x = new JonixSalesOutletIdentifier();
		x.salesOutletIDType = getSalesOutletIDTypeValue();
		x.idTypeName = getIDTypeNameValue();
		x.idValue = getIDValueValue();
		return x;
	}
}
