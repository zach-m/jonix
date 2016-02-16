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
import com.tectonica.jonix.codelist.TextScriptCodes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <h1>Corporate name</h1>
 * <p>
 * The name of a corporate body, used here for a corporate copyright owner. Optional and non- repeating. Each occurrence
 * of the &lt;CopyrightOwner&gt; composite may carry a single name (personal or corporate), or an identifier, or both a
 * name and an identifier.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Variable-length text, suggested maximum length 200 characters</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;CorporateName&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;b047&gt;</td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;1</td>
 * </tr>
 * <tr>
 * <td>Attributes</td>
 * <td>collationkey, language, textscript</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td>&lt;CorporateName&gt;Johnson &amp;amp; Johnson Inc&lt;/CorporateName&gt; (note this is represented as 'Johnson
 * &amp;amp; Johnson Inc', since &amp; is a reserved character in XML)</td>
 * </tr>
 * </table>
 */
public class CorporateName implements OnixElement, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "CorporateName";
	public static final String shortname = "b047";

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

	public TextScriptCodes textscript;

	public LanguageCodes language;

	// ///////////////////////////////////////////////////////////////////////////////
	// VALUE MEMBER
	// ///////////////////////////////////////////////////////////////////////////////

	/**
	 * Format: Variable-length text, suggested maximum length 200 characters
	 * <p>
	 * (type: dt.NonEmptyString)
	 */
	public String value;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public CorporateName()
	{}

	public CorporateName(org.w3c.dom.Element element)
	{
		datestamp = JPU.getAttribute(element, "datestamp");
		sourcetype = RecordSourceTypes.byValue(JPU.getAttribute(element, "sourcetype"));
		sourcename = JPU.getAttribute(element, "sourcename");
		collationkey = JPU.getAttribute(element, "collationkey");
		textscript = TextScriptCodes.byValue(JPU.getAttribute(element, "textscript"));
		language = LanguageCodes.byValue(JPU.getAttribute(element, "language"));

		value = JPU.getContentAsString(element);
	}
}
