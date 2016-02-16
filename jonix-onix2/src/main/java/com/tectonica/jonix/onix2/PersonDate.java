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

package com.tectonica.jonix.onix2;

import java.io.Serializable;

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.OnixComposite.OnixDataComposite;
import com.tectonica.jonix.codelist.DateFormats;
import com.tectonica.jonix.codelist.LanguageCodes;
import com.tectonica.jonix.codelist.PersonDateRoles;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;
import com.tectonica.jonix.struct.JonixPersonDate;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <h1>Person date composite</h1>
 * <p>
 * A repeatable group of data elements which together specify a date associated with the person identified in an
 * occurrence of the &lt;Contributor&gt; composite, <em>eg</em> birth or death.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;PersonDate&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;persondate&gt;</td>
 * </tr>
 * </table>
 */
public class PersonDate implements OnixDataComposite, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "PersonDate";
	public static final String shortname = "persondate";

	// ///////////////////////////////////////////////////////////////////////////////
	// ATTRIBUTES
	// ///////////////////////////////////////////////////////////////////////////////

	public TextFormats textformat;

	public TextCaseFlags textcase;

	public LanguageCodes language;

	public TransliterationSchemes transliteration;

	/**
	 * (type: DateOrDateTime)
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
	public PersonDateRole personDateRole;

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

	public PersonDate()
	{}

	public PersonDate(org.w3c.dom.Element element)
	{
		textformat = TextFormats.byValue(JPU.getAttribute(element, "textformat"));
		textcase = TextCaseFlags.byValue(JPU.getAttribute(element, "textcase"));
		language = LanguageCodes.byValue(JPU.getAttribute(element, "language"));
		transliteration = TransliterationSchemes.byValue(JPU.getAttribute(element, "transliteration"));
		datestamp = JPU.getAttribute(element, "datestamp");
		sourcetype = RecordSourceTypes.byValue(JPU.getAttribute(element, "sourcetype"));
		sourcename = JPU.getAttribute(element, "sourcename");

		JPU.forElementsOf(element, new JPU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(PersonDateRole.refname) || name.equals(PersonDateRole.shortname))
					personDateRole = new PersonDateRole(element);
				else if (name.equals(DateFormat.refname) || name.equals(DateFormat.shortname))
					dateFormat = new DateFormat(element);
				else if (name.equals(Date.refname) || name.equals(Date.shortname))
					date = new Date(element);
			}
		});
	}

	public PersonDateRoles getPersonDateRoleValue()
	{
		return (personDateRole == null) ? null : personDateRole.value;
	}

	public DateFormats getDateFormatValue()
	{
		return (dateFormat == null) ? null : dateFormat.value;
	}

	public String getDateValue()
	{
		return (date == null) ? null : date.value;
	}

	public JonixPersonDate asJonixPersonDate()
	{
		JonixPersonDate x = new JonixPersonDate();
		x.personDateRole = getPersonDateRoleValue();
		x.dateFormat = getDateFormatValue();
		x.date = getDateValue();
		return x;
	}
}
