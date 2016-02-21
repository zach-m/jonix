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
import com.tectonica.jonix.codelist.DateFormats;
import com.tectonica.jonix.codelist.RecordSourceTypes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <h1>Copyright year</h1>
 * <p>
 * The copyright year as it appears in a copyright statement on the product. Mandatory in each occurrence of the
 * &lt;CopyrightStatement&gt; composite, and repeatable if several years are listed.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>As specified by the value in the dateformat attribute, or the default of YYYY if the attribute is missing)</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;CopyrightYear&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;b087&gt;</td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>1&#8230;n</td>
 * </tr>
 * <tr>
 * <td>Attributes</td>
 * <td>dateformat</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td>&lt;b087 dateformat=&quot;11&quot;&gt;20032008&lt;/b087&gt; (2003-2008)</td>
 * </tr>
 * </table>
 */
public class CopyrightYear implements OnixElement, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "CopyrightYear";
	public static final String shortname = "b087";

	// ///////////////////////////////////////////////////////////////////////////////
	// ATTRIBUTES
	// ///////////////////////////////////////////////////////////////////////////////

	/**
	 * (type: dt.DateOrDateTime)
	 */
	public String datestamp;

	public RecordSourceTypes sourcetype;

	public String sourcename;

	public DateFormats dateformat;

	// ///////////////////////////////////////////////////////////////////////////////
	// VALUE MEMBER
	// ///////////////////////////////////////////////////////////////////////////////

	/**
	 * Raw Format: As specified by the value in the dateformat attribute, or the default of YYYY if the attribute is
	 * missing)
	 * <p>
	 * (type: dt.NonEmptyString)
	 */
	public String value;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public CopyrightYear()
	{}

	public CopyrightYear(org.w3c.dom.Element element)
	{
		datestamp = JPU.getAttribute(element, "datestamp");
		sourcetype = RecordSourceTypes.byValue(JPU.getAttribute(element, "sourcetype"));
		sourcename = JPU.getAttribute(element, "sourcename");
		dateformat = DateFormats.byValue(JPU.getAttribute(element, "dateformat"));

		value = JPU.getContentAsString(element);
	}
}
