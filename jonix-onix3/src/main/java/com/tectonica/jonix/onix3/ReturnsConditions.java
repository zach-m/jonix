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
import com.tectonica.jonix.codelist.ReturnsConditionsCodeTypes;
import com.tectonica.jonix.struct.JonixReturnsConditions;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <h1>Returns conditions composite</h1>
 * <p>
 * An optional and repeatable group of data elements which together allow returns conditions to be specified in coded
 * form.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;ReturnsConditions&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;returnsconditions&gt;</td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 */
public class ReturnsConditions implements OnixDataComposite, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "ReturnsConditions";
	public static final String shortname = "returnsconditions";

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
	public ReturnsCodeType returnsCodeType;

	/**
	 * (this field is optional)
	 */
	public ReturnsCodeTypeName returnsCodeTypeName;

	/**
	 * (this field is required)
	 */
	public ReturnsCode returnsCode;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public ReturnsConditions()
	{}

	public ReturnsConditions(org.w3c.dom.Element element)
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
				if (name.equals(ReturnsCodeType.refname) || name.equals(ReturnsCodeType.shortname))
					returnsCodeType = new ReturnsCodeType(element);
				else if (name.equals(ReturnsCodeTypeName.refname) || name.equals(ReturnsCodeTypeName.shortname))
					returnsCodeTypeName = new ReturnsCodeTypeName(element);
				else if (name.equals(ReturnsCode.refname) || name.equals(ReturnsCode.shortname))
					returnsCode = new ReturnsCode(element);
			}
		});
	}

	public ReturnsConditionsCodeTypes getReturnsCodeTypeValue()
	{
		return (returnsCodeType == null) ? null : returnsCodeType.value;
	}

	/**
	 * Format: Variable-length text, suggested maximum length 50 characters
	 */
	public String getReturnsCodeTypeNameValue()
	{
		return (returnsCodeTypeName == null) ? null : returnsCodeTypeName.value;
	}

	/**
	 * Format: According to the scheme specified in &lt;ReturnsCodeType&gt;
	 */
	public String getReturnsCodeValue()
	{
		return (returnsCode == null) ? null : returnsCode.value;
	}

	public JonixReturnsConditions asJonixReturnsConditions()
	{
		JonixReturnsConditions x = new JonixReturnsConditions();
		x.returnsCodeType = getReturnsCodeTypeValue();
		x.returnsCodeTypeName = getReturnsCodeTypeNameValue();
		x.returnsCode = getReturnsCodeValue();
		return x;
	}
}
