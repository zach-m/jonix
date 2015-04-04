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
import com.tectonica.jonix.OnixComposite;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.SupplierOwnCodeTypes;
import com.tectonica.jonix.struct.JonixSupplierOwnCoding;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

@SuppressWarnings("serial")
public class SupplierOwnCoding implements OnixComposite, Serializable
{
	public static final String refname = "SupplierOwnCoding";
	public static final String shortname = "supplierowncoding";

	public String datestamp; // dt.DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public SupplierCodeType supplierCodeType; // Required
	public SupplierCodeTypeName supplierCodeTypeName; // Optional
	public SupplierCodeValue supplierCodeValue; // Required

	public SupplierOwnCoding()
	{}

	public SupplierOwnCoding(org.w3c.dom.Element element)
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
				if (name.equals(SupplierCodeType.refname) || name.equals(SupplierCodeType.shortname))
					supplierCodeType = new SupplierCodeType(element);
				else if (name.equals(SupplierCodeTypeName.refname) || name.equals(SupplierCodeTypeName.shortname))
					supplierCodeTypeName = new SupplierCodeTypeName(element);
				else if (name.equals(SupplierCodeValue.refname) || name.equals(SupplierCodeValue.shortname))
					supplierCodeValue = new SupplierCodeValue(element);
			}
		});
	}

	public SupplierOwnCodeTypes getSupplierCodeTypeValue()
	{
		return (supplierCodeType == null) ? null : supplierCodeType.value;
	}

	public String getSupplierCodeTypeNameValue()
	{
		return (supplierCodeTypeName == null) ? null : supplierCodeTypeName.value;
	}

	public String getSupplierCodeValueValue()
	{
		return (supplierCodeValue == null) ? null : supplierCodeValue.value;
	}

	public JonixSupplierOwnCoding asJonixSupplierOwnCoding()
	{
		JonixSupplierOwnCoding x = new JonixSupplierOwnCoding();
		x.supplierCodeTypeName = getSupplierCodeTypeNameValue();
		x.supplierCodeValue = getSupplierCodeValueValue();
		return x;
	}
}
