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

package com.tectonica.jonix.onix3;

import java.io.Serializable;

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.OnixElement;
import com.tectonica.jonix.codelist.LanguageCodes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextScriptCodes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <h1>Subtitle</h1>
 * <p>
 * The text of a subtitle, if any. ‘Subtitle’ means any added words which appear with the title element given in an
 * occurrence of the &lt;TitleElement&gt; composite, and which amplify and explain the title element, but which are not
 * considered to be part of the title element itself. Optional and non-repeating.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Variable-length text, suggested maximum 300 characters</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;Subtitle&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;b029&gt;</td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;1</td>
 * </tr>
 * <tr>
 * <td>Attributes</td>
 * <td>collationkey, language, textscript, textcase</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td>&lt;b029 textcase=&quot;02&quot;&gt;The Russian Revolution 1891-1924&lt;/b029&gt; (text is in title case)</td>
 * </tr>
 * </table>
 */
public class Subtitle implements OnixElement, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "Subtitle";
	public static final String shortname = "b029";

	// ///////////////////////////////////////////////////////////////////////////////
	// ATTRIBUTES
	// ///////////////////////////////////////////////////////////////////////////////

	/**
	 * (type: dt.DateOrDateTime)
	 */
	public String datestamp;

	public RecordSourceTypes sourcetype;

	public String sourcename;

	public String collationkey;

	public LanguageCodes language;

	public TextScriptCodes textscript;

	public TextCaseFlags textcase;

	// ///////////////////////////////////////////////////////////////////////////////
	// VALUE MEMBER
	// ///////////////////////////////////////////////////////////////////////////////

	/**
	 * Raw Format: Variable-length text, suggested maximum 300 characters
	 * <p>
	 * (type: dt.NonEmptyString)
	 */
	public String value;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public Subtitle()
	{}

	public Subtitle(org.w3c.dom.Element element)
	{
		datestamp = JPU.getAttribute(element, "datestamp");
		sourcetype = RecordSourceTypes.byValue(JPU.getAttribute(element, "sourcetype"));
		sourcename = JPU.getAttribute(element, "sourcename");
		collationkey = JPU.getAttribute(element, "collationkey");
		language = LanguageCodes.byValue(JPU.getAttribute(element, "language"));
		textscript = TextScriptCodes.byValue(JPU.getAttribute(element, "textscript"));
		textcase = TextCaseFlags.byValue(JPU.getAttribute(element, "textcase"));

		value = JPU.getContentAsString(element);
	}
}
