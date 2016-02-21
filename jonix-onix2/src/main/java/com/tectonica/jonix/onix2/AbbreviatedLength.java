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
 * <h1>Abbreviated title length</h1>
 * <p>
 * If the &lt;Title&gt; composite is used to carry an abbreviated title, the length to which the title is abbreviated
 * may be indicated by giving the maximum number of characters (regardless of whether in each specific instance
 * abbreviation has been required in order to meet this limit). The &lt;TitleType&gt; code should indicate the form of
 * the title that has been abbreviated. Optional and non-repeating. If this element is present, the &lt;TitleText&gt;
 * element must be used to carry the abbreviated form. [The option also exists to send an abbreviated title as a
 * separate &lt;TitleType&gt; without using &lt;AbbreviatedLength&gt;, which is simpler, but less informative.]
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Variable-length integer, suggested maximum 3 digits</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;AbbreviatedLength&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;b276&gt;</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td>&lt;b276&gt;40&lt;/b276&gt;</td>
 * </tr>
 * </table>
 */
public class AbbreviatedLength implements OnixElement, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "AbbreviatedLength";
	public static final String shortname = "b276";

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
	 * Raw Format: Variable-length integer, suggested maximum 3 digits
	 * <p>
	 * (type: NonEmptyString)
	 */
	public String value;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public AbbreviatedLength()
	{}

	public AbbreviatedLength(org.w3c.dom.Element element)
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
