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
import com.tectonica.jonix.codelist.DateFormats;
import com.tectonica.jonix.codelist.PersonOrganizationDateRoles;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixContributorDate;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <h1>Contributor date composite</h1>
 * <p>
 * A repeatable group of data elements which together specify a date associated with the person or organization
 * identified in an occurrence of the &lt;Contributor&gt; composite, <i>eg</i> birth or death. Optional.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;ContributorDate&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;contributordate&gt;</td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 */
public class ContributorDate implements OnixDataComposite, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "ContributorDate";
	public static final String shortname = "contributordate";

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
	public ContributorDateRole contributorDateRole;

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

	public ContributorDate()
	{}

	public ContributorDate(org.w3c.dom.Element element)
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
				if (name.equals(ContributorDateRole.refname) || name.equals(ContributorDateRole.shortname))
					contributorDateRole = new ContributorDateRole(element);
				else if (name.equals(DateFormat.refname) || name.equals(DateFormat.shortname))
					dateFormat = new DateFormat(element);
				else if (name.equals(Date.refname) || name.equals(Date.shortname))
					date = new Date(element);
			}
		});
	}

	public PersonOrganizationDateRoles getContributorDateRoleValue()
	{
		return (contributorDateRole == null) ? null : contributorDateRole.value;
	}

	public DateFormats getDateFormatValue()
	{
		return (dateFormat == null) ? null : dateFormat.value;
	}

	public String getDateValue()
	{
		return (date == null) ? null : date.value;
	}

	public JonixContributorDate asJonixContributorDate()
	{
		JonixContributorDate x = new JonixContributorDate();
		x.contributorDateRole = getContributorDateRoleValue();
		x.dateFormat = getDateFormatValue();
		x.date = getDateValue();
		return x;
	}
}
