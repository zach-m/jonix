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
 * <h1>Record reference number</h1>
 * <p>
 * For every product, you must choose a single number which will uniquely identify the Information record which you send
 * out about that product, and which will remain as its permanent identifier every time you send an update. It doesn’t
 * matter what number you choose, provided that it is unique and permanent. This number doesn’t really identify the
 * product – even though you may choose to use the ISBN or another product identifier – it identifies your information
 * record about the product, so that the person to whom you are sending an update can match it with what you have
 * previously sent. A good way of generating numbers which are not part of a recognized product identification scheme
 * but which can be guaranteed to be unique is to preface the number with an Internet domain name which is registered to
 * your organisation.
 * </p>
 * <p>
 * This field is mandatory and non-repeating.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Variable-length, alphanumeric, suggested maximum length 32 characters.</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;RecordReference&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;a001&gt;</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td>&lt;RecordReference&gt;8474339790&lt;/RecordReference&gt;</td>
 * </tr>
 * </table>
 */
public class RecordReference implements OnixElement, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "RecordReference";
	public static final String shortname = "a001";

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
	 * Raw Format: Variable-length, alphanumeric, suggested maximum length 32 characters.
	 * <p>
	 * (type: NonEmptyString)
	 */
	public String value;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public RecordReference()
	{}

	public RecordReference(org.w3c.dom.Element element)
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
