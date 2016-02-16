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
 * <h1>Date</h1>
 * <p>
 * The date specified in the &lt;PriceDateRole&gt; field. Mandatory in each occurrence of the &lt;PriceDate&gt;
 * composite, and non-repeating. &lt;Date&gt; may carry a <i>dateformat</i> attribute: if the attribute is missing, then
 * &lt;DateFormat&gt; indicates the format of the date; if both <i>dateformat</i> attribute and &lt;DateFormat&gt;
 * element are missing, the default format is YYYYMMDD.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>As specified by the value in the dateformat attribute, in &lt;DateFormat&gt;, or the default YYYYMMDD</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;Date&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;b306&gt;</td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>1</td>
 * </tr>
 * <tr>
 * <td>Attributes</td>
 * <td>dateformat</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td>&lt;Date&gt;20100106&lt;/Date&gt;</td>
 * </tr>
 * <tr>
 * <td>Notes</td>
 * <td>Note that all dates are inclusive, so 'Date from' is the first date on which the price is effective, and 'Date
 * until' is the last date on which it is effective.</td>
 * </tr>
 * </table>
 */
public class Date implements OnixElement, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "Date";
	public static final String shortname = "b306";

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
	 * Format: As specified by the value in the dateformat attribute, in &lt;DateFormat&gt;, or the default YYYYMMDD
	 * <p>
	 * (type: dt.NonEmptyString)
	 */
	public String value;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public Date()
	{}

	public Date(org.w3c.dom.Element element)
	{
		datestamp = JPU.getAttribute(element, "datestamp");
		sourcetype = RecordSourceTypes.byValue(JPU.getAttribute(element, "sourcetype"));
		sourcename = JPU.getAttribute(element, "sourcename");
		dateformat = DateFormats.byValue(JPU.getAttribute(element, "dateformat"));

		value = JPU.getContentAsString(element);
	}
}
