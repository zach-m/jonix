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

import com.tectonica.jonix.DU;
import com.tectonica.jonix.codelist.CountryCodeIso31661s;
import com.tectonica.jonix.codelist.LanguageCodeIso6392Bs;
import com.tectonica.jonix.codelist.LanguageRoleCodes;
import com.tectonica.jonix.codelist.RecordSourceTypeCodes;
import com.tectonica.jonix.codelist.TextScriptCodeIso15924s;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

public class Language
{
	public static final String refname = "Language";
	public static final String shortname = "language";

	public String datestamp; // dt.DateOrDateTime
	public RecordSourceTypeCodes sourcetype;
	public String sourcename;

	public LanguageRole languageRole; // Required
	public LanguageCode languageCode; // Required
	public CountryCode countryCode; // Optional
	public ScriptCode scriptCode; // Optional

	public static Language fromDoc(org.w3c.dom.Element element)
	{
		final Language x = new Language();

		x.datestamp = DU.getAttribute(element, "datestamp");
		x.sourcetype = RecordSourceTypeCodes.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		DU.forElementsOf(element, new DU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(LanguageRole.refname) || name.equals(LanguageRole.shortname))
					x.languageRole = LanguageRole.fromDoc(element);
				else if (name.equals(LanguageCode.refname) || name.equals(LanguageCode.shortname))
					x.languageCode = LanguageCode.fromDoc(element);
				else if (name.equals(CountryCode.refname) || name.equals(CountryCode.shortname))
					x.countryCode = CountryCode.fromDoc(element);
				else if (name.equals(ScriptCode.refname) || name.equals(ScriptCode.shortname))
					x.scriptCode = ScriptCode.fromDoc(element);
			}
		});

		return x;
	}

	public LanguageRoleCodes getLanguageRoleValue()
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
}
