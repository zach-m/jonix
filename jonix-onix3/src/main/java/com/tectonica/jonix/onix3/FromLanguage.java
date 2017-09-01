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
import com.tectonica.jonix.OnixElement;
import com.tectonica.jonix.codelist.LanguageCodes;
import com.tectonica.jonix.codelist.RecordSourceTypes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Source language of a translation</h1>
 * <p>
 * Used only when the &lt;ContributorRole&gt; code value is B06, B08 or B10 indicating a translator, to specify the
 * source language from which the translation was made. This element makes it possible to specify a translator’s exact
 * responsibility when a work involves translation from two or more languages. Optional, and repeatable in the event
 * that a single person has been responsible for translation from two or more languages.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Fixed-length, three lower-case letters. Note that ISO 639 specifies that these codes should always be in
 * lower-case</td>
 * </tr>
 * <tr>
 * <td>Codelist</td>
 * <td>ISO 639-2/B List 74</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;FromLanguage&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;x412&gt;</td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td>&lt;FromLanguage&gt;eng&lt;/FromLanguage&gt;</td>
 * </tr>
 * </table>
 */
public class FromLanguage implements OnixElement<LanguageCodes>, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "FromLanguage";
	public static final String shortname = "x412";

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
	// VALUE MEMBER
	/////////////////////////////////////////////////////////////////////////////////

	public LanguageCodes value;

	/**
	 * Internal API, use the {@link #value} field instead
	 */
	@Override
	public LanguageCodes _value()
	{
		return value;
	}

	/////////////////////////////////////////////////////////////////////////////////
	// SERVICES
	/////////////////////////////////////////////////////////////////////////////////

	private final boolean exists;
	public static final FromLanguage EMPTY = new FromLanguage();

	public FromLanguage()
	{
		exists = false;
	}

	public FromLanguage(org.w3c.dom.Element element)
	{
		exists = true;
		datestamp = JPU.getAttribute(element, "datestamp");
		sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
		sourcename = JPU.getAttribute(element, "sourcename");

		value = LanguageCodes.byCode(JPU.getContentAsString(element));
	}

	@Override
	public boolean exists()
	{
		return exists;
	}
}
