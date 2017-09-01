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
import com.tectonica.jonix.OnixComposite.OnixDataCompositeWithKey;
import com.tectonica.jonix.codelist.LanguageRoles;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixLanguage;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Language composite</h1>
 * <p>
 * An optional and repeatable group of data elements which together represent a language, and specify its role and,
 * where required, whether it is a country variant.
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
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 */
public class Language implements OnixDataCompositeWithKey<JonixLanguage, LanguageRoles>, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "Language";
	public static final String shortname = "language";

	/////////////////////////////////////////////////////////////////////////////////
	// ATTRIBUTES
	/////////////////////////////////////////////////////////////////////////////////

	/**
	 * (type: dt.DateOrDateTime)
	 */
	public String datestamp;

	public RecordSourceTypes sourcetype;

	public String sourcename;

	/////////////////////////////////////////////////////////////////////////////////
	// CONSTRUCTION
	/////////////////////////////////////////////////////////////////////////////////

	private boolean initialized;
	private final boolean exists;
	private final org.w3c.dom.Element element;
	public static final Language EMPTY = new Language();

	public Language()
	{
		exists = false;
		element = null;
		initialized = true; // so that no further processing will be done on this intentionally-empty object
	}

	public Language(org.w3c.dom.Element element)
	{
		exists = true;
		initialized = false;
		this.element = element;
	}

	private void initialize()
	{
		if (initialized)
			return;
		initialized = true;

		datestamp = JPU.getAttribute(element, "datestamp");
		sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
		sourcename = JPU.getAttribute(element, "sourcename");

		JPU.forElementsOf(element, e -> {
			final String name = e.getNodeName();
			if (name.equals(LanguageRole.refname) || name.equals(LanguageRole.shortname))
				languageRole = new LanguageRole(e);
			else if (name.equals(LanguageCode.refname) || name.equals(LanguageCode.shortname))
				languageCode = new LanguageCode(e);
			else if (name.equals(CountryCode.refname) || name.equals(CountryCode.shortname))
				countryCode = new CountryCode(e);
			else if (name.equals(ScriptCode.refname) || name.equals(ScriptCode.shortname))
				scriptCode = new ScriptCode(e);
		});
	}

	@Override
	public boolean exists()
	{
		return exists;
	}

	/////////////////////////////////////////////////////////////////////////////////
	// MEMBERS
	/////////////////////////////////////////////////////////////////////////////////

	private LanguageRole languageRole = LanguageRole.EMPTY;

	/**
	 * (this field is required)
	 */
	public LanguageRole languageRole()
	{
		initialize();
		return languageRole;
	}

	private LanguageCode languageCode = LanguageCode.EMPTY;

	/**
	 * (this field is required)
	 */
	public LanguageCode languageCode()
	{
		initialize();
		return languageCode;
	}

	private CountryCode countryCode = CountryCode.EMPTY;

	/**
	 * (this field is optional)
	 */
	public CountryCode countryCode()
	{
		initialize();
		return countryCode;
	}

	private ScriptCode scriptCode = ScriptCode.EMPTY;

	/**
	 * (this field is optional)
	 */
	public ScriptCode scriptCode()
	{
		initialize();
		return scriptCode;
	}

	@Override
	public JonixLanguage asStruct()
	{
		initialize();
		JonixLanguage struct = new JonixLanguage();
		struct.languageRole = languageRole.value;
		struct.countryCode = countryCode.value;
		struct.languageCode = languageCode.value;
		return struct;
	}

	@Override
	public LanguageRoles structKey()
	{
		return languageRole().value;
	}
}
