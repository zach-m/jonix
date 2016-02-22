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
import com.tectonica.jonix.OnixElement;
import com.tectonica.jonix.codelist.LanguageCodes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <h1>Region code</h1>
 * <p>
 * An ONIX code identifying a region with which a contributor is particularly associated, when this is significant for
 * the marketing of a product. Optional and repeatable.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Variable-length code, consisting of upper case letters with or without a hyphen, successive codes being separated
 * by spaces. Suggested maximum length 8 characters.</td>
 * </tr>
 * <tr>
 * <td>Codelist</td>
 * <td>List 49 Where possible and appropriate, country subdivision codes are derived from the UN LOCODE scheme based on
 * ISO 3166.</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;RegionCode&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;b398&gt;</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td>&lt;b398&gt;CA-BC&lt;/b398&gt;&#160;&#160;&#160;&#160;British Columbia</td>
 * </tr>
 * </table>
 */
public class RegionCode implements OnixElement, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "RegionCode";
	public static final String shortname = "b398";

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
	// VALUE MEMBER
	// ///////////////////////////////////////////////////////////////////////////////

	/**
	 * Raw Format: Variable-length code, consisting of upper case letters with or without a hyphen, successive codes
	 * being separated by spaces. Suggested maximum length 8 characters.
	 * <p>
	 * (type: NonEmptyString)
	 */
	public java.util.Set<String> value;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public RegionCode()
	{}

	public RegionCode(org.w3c.dom.Element element)
	{
		textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));
		textcase = TextCaseFlags.byCode(JPU.getAttribute(element, "textcase"));
		language = LanguageCodes.byCode(JPU.getAttribute(element, "language"));
		transliteration = TransliterationSchemes.byCode(JPU.getAttribute(element, "transliteration"));
		datestamp = JPU.getAttribute(element, "datestamp");
		sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
		sourcename = JPU.getAttribute(element, "sourcename");

		value = new java.util.HashSet<>();
		for (String split : JPU.getContentAsString(element).trim().split(" +"))
			value.add(String.valueOf(split));
	}
}
