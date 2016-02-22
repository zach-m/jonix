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
 * <h1>Level sequence number</h1>
 * <p>
 * A number which specifies the position of a content item in a multi-level hierarchy of such items. Numbering starts at
 * the top level in the hierarchy, which may represent (eg) chapters in a printed book, and the first item at the top
 * level is numbered 1. Numbers should be assigned solely with a view to the logic of the ONIX description and not in
 * relation to any other characteristics of the items being numbered (such as their typographical layout in a printed
 * table of contents). &lt;LevelSequenceNumber&gt; is not a required field, but it is strongly recommended for
 * structured tables of contents. If used, it must occur once and only once in each occurrence of the
 * &lt;ContentItem&gt; composite.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Variable-length string of integers, each successive integer being separated by a full stop, suggested maximum
 * length 100 characters</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;LevelSequenceNumber&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;b284&gt;</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td>&lt;LevelSequenceNumber&gt;2.24.1.7&lt;/LevelSequenceNumber&gt;</td>
 * </tr>
 * </table>
 */
public class LevelSequenceNumber implements OnixElement, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "LevelSequenceNumber";
	public static final String shortname = "b284";

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
	 * Raw Format: Variable-length string of integers, each successive integer being separated by a full stop, suggested
	 * maximum length 100 characters
	 * <p>
	 * (type: NonEmptyString)
	 */
	public String value;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public LevelSequenceNumber()
	{}

	public LevelSequenceNumber(org.w3c.dom.Element element)
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
