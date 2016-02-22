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
 * <h1>Review quote (complete)</h1>
 * <p>
 * A free text excerpt from a review. Optional and repeatable. At the end of the text of the quote, the authorship,
 * source title, and date (if known) should always be included.
 * </p>
 * <p>
 * <strong>The &lt;OtherText&gt; composite on preceding pages provides a more general method of handling review quotes,
 * and is to be preferred.</strong>
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Variable-length text, suggested maximum length 500 characters (XHTML is enabled in this element - see ONIX for
 * Books - Product Information Message - XML Message Specification, Section 7)</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;ReviewQuote&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;e110&gt;</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td>&lt;ReviewQuote&gt;Norman Schur is without doubt the outstanding authority on the similarities and differences
 * between British and American English. BRITISH ENGLISH, A TO ZED attests not only to his expertise, but also to his
 * undiminished powers to inform, amuse and entertain. - Laurence Urdang, Editor, VERBATIM, The Language Quarterly,
 * Spring 1992&lt;/ReviewQuote&gt;</td>
 * </tr>
 * </table>
 */
public class ReviewQuote implements OnixElement, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "ReviewQuote";
	public static final String shortname = "e110";

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
	 * Raw Format: Variable-length text, suggested maximum length 500 characters (XHTML is enabled in this element - see
	 * ONIX for Books - Product Information Message - XML Message Specification, Section 7)
	 * <p>
	 * (type: XHTML)
	 */
	public String value;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public ReviewQuote()
	{}

	public ReviewQuote(org.w3c.dom.Element element)
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
