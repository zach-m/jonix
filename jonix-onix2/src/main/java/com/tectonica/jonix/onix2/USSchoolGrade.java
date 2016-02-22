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
 * <h1>US school grades</h1>
 * <p>
 * A text element specifying a US school Grade or range of Grades, which should be entered strictly according to the
 * conventions defined below. Optional and non-repeating. <strong>The &lt;AudienceRange&gt; composite on the next page
 * provides a more general method of handling grade and other ranges, and is to be preferred.</strong>
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Variable length text, maximum 15 characters.</td>
 * </tr>
 * <tr>
 * <td></td>
 * <td>from n1 to n2&#160;&#160;&#160;&#160;Grade range from n1 to n2 from n&#160;&#160;&#160;&#160;From Grade n upwards
 * to n&#160;&#160;&#160;&#160;Up to Grade n n&#160;&#160;&#160;&#160;Grade n only where n is a grade number or one of
 * the words Pre-school or Kindergarten, which may be abbreviated to letters P or K</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;USSchoolGrade&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;b189&gt;</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td>&lt;USSchoolGrade&gt;from 6 to 8&lt;/USSchoolGrade&gt;</td>
 * </tr>
 * <tr>
 * <td></td>
 * <td>&lt;b189&gt;P&lt;/b189&gt;&#160;&#160;&#160;&#160;Pre-school</td>
 * </tr>
 * </table>
 */
public class USSchoolGrade implements OnixElement, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "USSchoolGrade";
	public static final String shortname = "b189";

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
	 * Raw Format: Variable length text, maximum 15 characters.
	 * <p>
	 * (type: NonEmptyString)
	 */
	public String value;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public USSchoolGrade()
	{}

	public USSchoolGrade(org.w3c.dom.Element element)
	{
		textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));
		textcase = TextCaseFlags.byCode(JPU.getAttribute(element, "textcase"));
		language = LanguageCodes.byCode(JPU.getAttribute(element, "language"));
		transliteration = TransliterationSchemes.byCode(JPU.getAttribute(element, "transliteration"));
		datestamp = JPU.getAttribute(element, "datestamp");
		sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
		sourcename = JPU.getAttribute(element, "sourcename");

		value = JPU.getContentAsString(element);
	}
}
