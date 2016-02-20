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
import com.tectonica.jonix.codelist.AudienceCodeTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixAudience;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <h1>Audience composite</h1>
 * <p>
 * A repeatable group of data elements which together describe an audience to which the product is directed.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;Audience&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;audience&gt;</td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 */
public class Audience implements OnixDataComposite, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "Audience";
	public static final String shortname = "audience";

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
	public AudienceCodeType audienceCodeType;

	/**
	 * (this field is optional)
	 */
	public AudienceCodeTypeName audienceCodeTypeName;

	/**
	 * (this field is required)
	 */
	public AudienceCodeValue audienceCodeValue;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public Audience()
	{}

	public Audience(org.w3c.dom.Element element)
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
				if (name.equals(AudienceCodeType.refname) || name.equals(AudienceCodeType.shortname))
					audienceCodeType = new AudienceCodeType(element);
				else if (name.equals(AudienceCodeTypeName.refname) || name.equals(AudienceCodeTypeName.shortname))
					audienceCodeTypeName = new AudienceCodeTypeName(element);
				else if (name.equals(AudienceCodeValue.refname) || name.equals(AudienceCodeValue.shortname))
					audienceCodeValue = new AudienceCodeValue(element);
			}
		});
	}

	public AudienceCodeTypes getAudienceCodeTypeValue()
	{
		return (audienceCodeType == null) ? null : audienceCodeType.value;
	}

	/**
	 * Format: Variable-length text, suggested maximum length 50 characters
	 */
	public String getAudienceCodeTypeNameValue()
	{
		return (audienceCodeTypeName == null) ? null : audienceCodeTypeName.value;
	}

	/**
	 * Format: Determined by the scheme specified in &lt;AudienceCodeType&gt;
	 */
	public String getAudienceCodeValueValue()
	{
		return (audienceCodeValue == null) ? null : audienceCodeValue.value;
	}

	public JonixAudience asJonixAudience()
	{
		JonixAudience x = new JonixAudience();
		x.audienceCodeType = getAudienceCodeTypeValue();
		x.audienceCodeTypeName = getAudienceCodeTypeNameValue();
		x.audienceCodeValue = getAudienceCodeValueValue();
		return x;
	}
}
