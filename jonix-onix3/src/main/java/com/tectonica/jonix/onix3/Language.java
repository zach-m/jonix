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
import com.tectonica.jonix.codelist.CountryCodeIso31661s;
import com.tectonica.jonix.codelist.LanguageCodeIso6392Bs;
import com.tectonica.jonix.codelist.LanguageRoles;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextScriptCodeIso15924s;
import com.tectonica.jonix.struct.JonixLanguage;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

@SuppressWarnings("serial")
public class Language implements Serializable
{
	public static final String refname = "Language";
	public static final String shortname = "language";

	public String datestamp; // dt.DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public LanguageRole languageRole; // Required
	public LanguageCode languageCode; // Required
	public CountryCode countryCode; // Optional
	public ScriptCode scriptCode; // Optional

	public Language()
	{}

	public Language(org.w3c.dom.Element element)
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
				if (name.equals(LanguageRole.refname) || name.equals(LanguageRole.shortname))
					languageRole = new LanguageRole(element);
				else if (name.equals(LanguageCode.refname) || name.equals(LanguageCode.shortname))
					languageCode = new LanguageCode(element);
				else if (name.equals(CountryCode.refname) || name.equals(CountryCode.shortname))
					countryCode = new CountryCode(element);
				else if (name.equals(ScriptCode.refname) || name.equals(ScriptCode.shortname))
					scriptCode = new ScriptCode(element);
			}
		});
	}

	public LanguageRoles getLanguageRoleValue()
	{
		return (languageRole == null) ? null : languageRole.value;
	}

	public LanguageCodeIso6392Bs getLanguageCodeValue()
	{
		return (languageCode == null) ? null : languageCode.value;
	}

	public CountryCodeIso31661s getCountryCodeValue()
	{
		return (countryCode == null) ? null : countryCode.value;
	}

	public TextScriptCodeIso15924s getScriptCodeValue()
	{
		return (scriptCode == null) ? null : scriptCode.value;
	}

	public JonixLanguage asJonixLanguage()
	{
		JonixLanguage x = new JonixLanguage();
		x.languageCode = getLanguageCodeValue();
		x.countryCode = getCountryCodeValue();
		x.scriptCode = getScriptCodeValue();
		return x;
	}
}
