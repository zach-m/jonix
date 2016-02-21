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
import com.tectonica.jonix.codelist.SupplierOwnCodeTypes;
import com.tectonica.jonix.struct.JonixSupplierOwnCoding;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <h1>Supplier own coding composite</h1>
 * <p>
 * An optional and repeatable group of data elements which together allow a supplier to send coded data of a specified
 * type, using its own coding schemes.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;SupplierOwnCoding&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;supplierowncoding&gt;</td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 */
public class SupplierOwnCoding implements OnixDataComposite, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "SupplierOwnCoding";
	public static final String shortname = "supplierowncoding";

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
	public SupplierCodeType supplierCodeType;

	/**
	 * (this field is optional)
	 */
	public SupplierCodeTypeName supplierCodeTypeName;

	/**
	 * (this field is required)
	 */
	public SupplierCodeValue supplierCodeValue;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public SupplierOwnCoding()
	{}

	public SupplierOwnCoding(org.w3c.dom.Element element)
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

	/**
	 * Raw Format: Variable-length text, suggested maximum length 50 characters
	 */
	public String getSupplierCodeTypeNameValue()
	{
		return (supplierCodeTypeName == null) ? null : supplierCodeTypeName.value;
	}

	/**
	 * Raw Format: According to the supplier's own format for the code type specified in &lt;SupplierCodeType&gt;
	 */
	public String getSupplierCodeValueValue()
	{
		return (supplierCodeValue == null) ? null : supplierCodeValue.value;
	}

	public JonixSupplierOwnCoding asJonixSupplierOwnCoding()
	{
		JonixSupplierOwnCoding x = new JonixSupplierOwnCoding();
		x.supplierCodeType = getSupplierCodeTypeValue();
		x.supplierCodeTypeName = getSupplierCodeTypeNameValue();
		x.supplierCodeValue = getSupplierCodeValueValue();
		return x;
	}
}
