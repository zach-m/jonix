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
import com.tectonica.jonix.codelist.ContentDateRoles;
import com.tectonica.jonix.codelist.DateFormats;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixContentDate;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <h1>Content date composite</h1>
 * <p>
 * An optional and repeatable group of data elements which together specify a date associated with a supporting resource
 * version, <i>eg</i> the date until which the resource version will be available for download.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;ContentDate&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;contentdate&gt;</td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 */
public class ContentDate implements OnixDataComposite, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "ContentDate";
	public static final String shortname = "contentdate";

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
	public ContentDateRole contentDateRole;

	/**
	 * (this field is optional)
	 */
	public DateFormat dateFormat;

	/**
	 * (this field is required)
	 */
	public Date date;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public ContentDate()
	{}

	public ContentDate(org.w3c.dom.Element element)
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
				if (name.equals(ContentDateRole.refname) || name.equals(ContentDateRole.shortname))
					contentDateRole = new ContentDateRole(element);
				else if (name.equals(DateFormat.refname) || name.equals(DateFormat.shortname))
					dateFormat = new DateFormat(element);
				else if (name.equals(Date.refname) || name.equals(Date.shortname))
					date = new Date(element);
			}
		});
	}

	public ContentDateRoles getContentDateRoleValue()
	{
		return (contentDateRole == null) ? null : contentDateRole.value;
	}

	public DateFormats getDateFormatValue()
	{
		return (dateFormat == null) ? null : dateFormat.value;
	}

	/**
	 * Raw Format: As specified by the value in the dateformat attribute, in &lt;DateFormat&gt;, or the default YYYYMMDD
	 */
	public String getDateValue()
	{
		return (date == null) ? null : date.value;
	}

	public JonixContentDate asJonixContentDate()
	{
		JonixContentDate x = new JonixContentDate();
		x.contentDateRole = getContentDateRoleValue();
		x.dateFormat = getDateFormatValue();
		x.date = getDateValue();
		return x;
	}
}
