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
 * <h1>Biographical note</h1>
 * <p>
 * A biographical note about a contributor to the product. (See the &lt;OtherText&gt; composite in Group&nbsp;PR.15 for
 * a biographical note covering all contributors to a product in a single text.) Optional and non-repeating. May occur
 * with a person name or with a corporate name. A biographical note in ONIX should always contain the name of the person
 * or body concerned, and it should always be presented as a piece of continuous text consisting of full sentences. Some
 * recipients of ONIX data feeds will not accept text which has embedded URLs. A contributor website link can be sent
 * using the &lt;Website&gt; composite on the next page.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Variable-length text, suggested maximum length 500 characters</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;BiographicalNote&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;b044&gt;</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td>&lt;BiographicalNote&gt;Umberto Eco, professor of semiotics at the University of Bologna, and author of
 * &#8220;The Name Of The Rose&#8221; and &#8220;Foucault's Pendulum&#8221;, is one of the world's bestselling
 * novelists.&lt;/BiographicalNote&gt;</td>
 * </tr>
 * </table>
 */
public class BiographicalNote implements OnixElement, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "BiographicalNote";
	public static final String shortname = "b044";

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
	 * Raw Format: Variable-length text, suggested maximum length 500 characters
	 * <p>
	 * (type: XHTML)
	 */
	public String value;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public BiographicalNote()
	{}

	public BiographicalNote(org.w3c.dom.Element element)
	{
		textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));
		textcase = TextCaseFlags.byCode(JPU.getAttribute(element, "textcase"));
		language = LanguageCodes.byCode(JPU.getAttribute(element, "language"));
		transliteration = TransliterationSchemes.byCode(JPU.getAttribute(element, "transliteration"));
		datestamp = JPU.getAttribute(element, "datestamp");
		sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
		sourcename = JPU.getAttribute(element, "sourcename");

		value = JPU.getChildXHTML(element, true);
	}
}
