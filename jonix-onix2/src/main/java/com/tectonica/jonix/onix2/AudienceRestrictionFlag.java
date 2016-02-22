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
import com.tectonica.jonix.codelist.AudienceRestrictionFlags;
import com.tectonica.jonix.codelist.LanguageCodes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <h1>Audience restriction flag</h1>
 * <p>
 * Used with &lt;AudienceRestrictionNote&gt; where within a particular market there is an additional restriction on
 * sale, imposed either by the publisher (<em>eg</em> an answer book to be sold only to bona fide teachers) or by
 * another agency (<em>eg</em> “indexing” in the German market). Optional and non-repeating.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Provisional: fixed-length, single letter</td>
 * </tr>
 * <tr>
 * <td>Codelist</td>
 * <td>List 56</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;AudienceRestrictionFlag&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;j146&gt;</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td>&lt;AudienceRestrictionFlag&gt;R&lt;/AudienceRestrictionFlag&gt;&#160;&#160;&#160;&#160;Restrictions apply</td>
 * </tr>
 * </table>
 */
public class AudienceRestrictionFlag implements OnixElement, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "AudienceRestrictionFlag";
	public static final String shortname = "j146";

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

	public AudienceRestrictionFlags value;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public AudienceRestrictionFlag()
	{}

	public AudienceRestrictionFlag(org.w3c.dom.Element element)
	{
		textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));
		textcase = TextCaseFlags.byCode(JPU.getAttribute(element, "textcase"));
		language = LanguageCodes.byCode(JPU.getAttribute(element, "language"));
		transliteration = TransliterationSchemes.byCode(JPU.getAttribute(element, "transliteration"));
		datestamp = JPU.getAttribute(element, "datestamp");
		sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
		sourcename = JPU.getAttribute(element, "sourcename");

		value = AudienceRestrictionFlags.byCode(JPU.getContentAsString(element));
	}
}
