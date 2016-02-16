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
import com.tectonica.jonix.codelist.CountryCodes;
import com.tectonica.jonix.codelist.LanguageCodes;
import com.tectonica.jonix.codelist.LanguageRoles;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;
import com.tectonica.jonix.struct.JonixLanguage;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <h1>Language composite</h1>
 * <p>
 * A repeatable group of data elements which together represent a language, and specify its role and, where required,
 * whether it is a country variant.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;Language&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;language&gt;</td>
 * </tr>
 * </table>
 */
public class Language implements OnixDataComposite, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "Language";
	public static final String shortname = "language";

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
	public LanguageRole languageRole;

	/**
	 * (this field is required)
	 */
	public LanguageCode languageCode;

	/**
	 * (this field is optional)
	 */
	public CountryCode countryCode;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public Language()
	{}

	public Language(org.w3c.dom.Element element)
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
				if (name.equals(LanguageRole.refname) || name.equals(LanguageRole.shortname))
					languageRole = new LanguageRole(element);
				else if (name.equals(LanguageCode.refname) || name.equals(LanguageCode.shortname))
					languageCode = new LanguageCode(element);
				else if (name.equals(CountryCode.refname) || name.equals(CountryCode.shortname))
					countryCode = new CountryCode(element);
			}
		});
	}

	public LanguageRoles getLanguageRoleValue()
	{
		return (languageRole == null) ? null : languageRole.value;
	}

	public LanguageCodes getLanguageCodeValue()
	{
		return (languageCode == null) ? null : languageCode.value;
	}

	public CountryCodes getCountryCodeValue()
	{
		return (countryCode == null) ? null : countryCode.value;
	}

	public JonixLanguage asJonixLanguage()
	{
		JonixLanguage x = new JonixLanguage();
		x.languageRole = getLanguageRoleValue();
		x.countryCode = getCountryCodeValue();
		x.languageCode = getLanguageCodeValue();
		return x;
	}
}
