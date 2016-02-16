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
import com.tectonica.jonix.codelist.PublishingStatuss;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <h1>Publishing status</h1>
 * <p>
 * An ONIX code which identifies the status of a published product. Optional and non-repeating, <strong>but it is very
 * strongly recommended that this element should be included in all ONIX Books Product records, and it is possible that
 * it may be made mandatory in a future release, or that it will be treated as mandatory in national ONIX accreditation
 * schemes.</strong>
 * </p>
 * <p>
 * Where the element is sent by a sender who is not the publisher, based on information that has been previously
 * supplied by the publisher, it is strongly recommended that the element should carry a datestamp attribute to indicate
 * its likely reliability. See <cite>ONIX for Books – Product Information Message – XML Message Specification</cite>,
 * Section 4, for details of the datestamp attribute.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Fixed-length, two numeric digits.</td>
 * </tr>
 * <tr>
 * <td>Codelist</td>
 * <td>List 64</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;PublishingStatus&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;b394&gt;</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td>&lt;PublishingStatus&gt;02&lt;/PublishingStatus&gt;&#160;&#160;&#160;&#160;Forthcoming</td>
 * </tr>
 * </table>
 */
public class PublishingStatus implements OnixElement, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "PublishingStatus";
	public static final String shortname = "b394";

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

	public PublishingStatuss value;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public PublishingStatus()
	{}

	public PublishingStatus(org.w3c.dom.Element element)
	{
		textformat = TextFormats.byValue(JPU.getAttribute(element, "textformat"));
		textcase = TextCaseFlags.byValue(JPU.getAttribute(element, "textcase"));
		language = LanguageCodes.byValue(JPU.getAttribute(element, "language"));
		transliteration = TransliterationSchemes.byValue(JPU.getAttribute(element, "transliteration"));
		datestamp = JPU.getAttribute(element, "datestamp");
		sourcetype = RecordSourceTypes.byValue(JPU.getAttribute(element, "sourcetype"));
		sourcename = JPU.getAttribute(element, "sourcename");

		value = PublishingStatuss.byValue(JPU.getContentAsString(element));
	}
}
