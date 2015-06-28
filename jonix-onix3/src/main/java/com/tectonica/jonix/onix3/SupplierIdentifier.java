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
import com.tectonica.jonix.codelist.SupplierIdentifierTypes;
import com.tectonica.jonix.struct.JonixSupplierIdentifier;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

@SuppressWarnings("serial")
public class SupplierIdentifier implements OnixDataComposite, Serializable
{
	public static final String refname = "SupplierIdentifier";
	public static final String shortname = "supplieridentifier";

	public String datestamp; // dt.DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	/**
	 * (this field is required)
	 */
	public SupplierIDType supplierIDType;

	/**
	 * (this field is optional)
	 */
	public IDTypeName idTypeName;

	/**
	 * (this field is required)
	 */
	public IDValue idValue;

	public SupplierIdentifier()
	{}

	public SupplierIdentifier(org.w3c.dom.Element element)
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
				if (name.equals(SupplierIDType.refname) || name.equals(SupplierIDType.shortname))
					supplierIDType = new SupplierIDType(element);
				else if (name.equals(IDTypeName.refname) || name.equals(IDTypeName.shortname))
					idTypeName = new IDTypeName(element);
				else if (name.equals(IDValue.refname) || name.equals(IDValue.shortname))
					idValue = new IDValue(element);
			}
		});
	}

	public SupplierIdentifierTypes getSupplierIDTypeValue()
	{
		return (supplierIDType == null) ? null : supplierIDType.value;
	}

	public String getIDTypeNameValue()
	{
		return (idTypeName == null) ? null : idTypeName.value;
	}

	public String getIDValueValue()
	{
		return (idValue == null) ? null : idValue.value;
	}

	public JonixSupplierIdentifier asJonixSupplierIdentifier()
	{
		JonixSupplierIdentifier x = new JonixSupplierIdentifier();
		x.supplierIDType = getSupplierIDTypeValue();
		x.idTypeName = getIDTypeNameValue();
		x.idValue = getIDValueValue();
		return x;
	}
}
