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
import com.tectonica.jonix.JonixComposite;
import com.tectonica.jonix.codelist.DateFormats;
import com.tectonica.jonix.codelist.LanguageCodeIso6392Bs;
import com.tectonica.jonix.codelist.PersonDateRoles;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;
import com.tectonica.jonix.struct.JonixPersonDate;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

@SuppressWarnings("serial")
public class PersonDate implements JonixComposite, Serializable
{
	public static final String refname = "PersonDate";
	public static final String shortname = "persondate";

	public TextFormats textformat;
	public TextCaseFlags textcase;
	public LanguageCodeIso6392Bs language;
	public TransliterationSchemes transliteration;
	public String datestamp; // DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public PersonDateRole personDateRole; // Required
	public DateFormat dateFormat; // Optional
	public Date date; // Required

	public PersonDate()
	{}

	public PersonDate(org.w3c.dom.Element element)
	{
		this.textformat = TextFormats.byValue(JPU.getAttribute(element, "textformat"));
		this.textcase = TextCaseFlags.byValue(JPU.getAttribute(element, "textcase"));
		this.language = LanguageCodeIso6392Bs.byValue(JPU.getAttribute(element, "language"));
		this.transliteration = TransliterationSchemes.byValue(JPU.getAttribute(element, "transliteration"));
		this.datestamp = JPU.getAttribute(element, "datestamp");
		this.sourcetype = RecordSourceTypes.byValue(JPU.getAttribute(element, "sourcetype"));
		this.sourcename = JPU.getAttribute(element, "sourcename");

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
		x.dateFormat = getDateFormatValue();
		x.date = getDateValue();
		return x;
	}
}
