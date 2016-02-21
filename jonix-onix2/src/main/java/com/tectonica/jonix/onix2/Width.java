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
 * <h1>Overall width</h1>
 * <p>
 * The overall width of the product: in the case of a book, the cover or case width, in the units specified in the
 * message header, &lt;DefaultLinearUnit&gt; field, defined in the <cite>ONIX for Books – Product Information Message –
 * XML Message Specification</cite>. Optional and non-repeating. <strong>The &lt;Measure&gt; composite on a previous
 * page provides a more general method of handling measurements, and is to be preferred.</strong>
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Variable length real number, with an explicit decimal point when required, suggested maximum length 6 characters
 * including a decimal point.</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;Width&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;c097&gt;</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td>&lt;Width&gt;5.5&lt;/Width&gt;</td>
 * </tr>
 * </table>
 */
public class Width implements OnixElement, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "Width";
	public static final String shortname = "c097";

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
	 * Raw Format: Variable length real number, with an explicit decimal point when required, suggested maximum length 6
	 * characters including a decimal point.
	 * <p>
	 * (type: NonEmptyString)
	 */
	public String value;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public Width()
	{}

	public Width(org.w3c.dom.Element element)
	{
		textformat = TextFormats.byValue(JPU.getAttribute(element, "textformat"));
		textcase = TextCaseFlags.byValue(JPU.getAttribute(element, "textcase"));
		language = LanguageCodes.byValue(JPU.getAttribute(element, "language"));
		transliteration = TransliterationSchemes.byValue(JPU.getAttribute(element, "transliteration"));
		datestamp = JPU.getAttribute(element, "datestamp");
		sourcetype = RecordSourceTypes.byValue(JPU.getAttribute(element, "sourcetype"));
		sourcename = JPU.getAttribute(element, "sourcename");

		value = JPU.getContentAsString(element);
	}
}
