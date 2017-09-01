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
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextScriptCodes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Script code</h1>
 * <p>
 * A code identifying the script in which the language is represented. Optional and non-repeating.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Fixed-length, four letters. Note that ISO 15924 specifies that script codes shall be sent as one upper case
 * followed by three lower case letters</td>
 * </tr>
 * <tr>
 * <td>Codelist</td>
 * <td>ISO 15924 four-letter script codes List 121</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;ScriptCode&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;x420&gt;</td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;1</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td>&lt;ScriptCode&gt;Cyrl&lt;/ScriptCode&gt; (Cyrillic)</td>
 * </tr>
 * </table>
 */
public class ScriptCode implements OnixElement<TextScriptCodes>, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "ScriptCode";
	public static final String shortname = "x420";

	/////////////////////////////////////////////////////////////////////////////////
	// ATTRIBUTES
	/////////////////////////////////////////////////////////////////////////////////

	/**
	 * (type: dt.DateOrDateTime)
	 */
	public String datestamp;

	public RecordSourceTypes sourcetype;

	public String sourcename;

	/////////////////////////////////////////////////////////////////////////////////
	// VALUE MEMBER
	/////////////////////////////////////////////////////////////////////////////////

	public TextScriptCodes value;

	/**
	 * Internal API, use the {@link #value} field instead
	 */
	@Override
	public TextScriptCodes _value()
	{
		return value;
	}

	/////////////////////////////////////////////////////////////////////////////////
	// SERVICES
	/////////////////////////////////////////////////////////////////////////////////

	private final boolean exists;
	public static final ScriptCode EMPTY = new ScriptCode();

	public ScriptCode()
	{
		exists = false;
	}

	public ScriptCode(org.w3c.dom.Element element)
	{
		exists = true;
		datestamp = JPU.getAttribute(element, "datestamp");
		sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
		sourcename = JPU.getAttribute(element, "sourcename");

		value = TextScriptCodes.byCode(JPU.getContentAsString(element));
	}

	@Override
	public boolean exists()
	{
		return exists;
	}
}
