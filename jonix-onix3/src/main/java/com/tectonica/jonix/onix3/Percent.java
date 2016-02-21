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

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <h1>Percentage</h1>
 * <p>
 * The percentage of the unit value of the product that is assignable to a designated product classification. Optional
 * and non-repeating. Used when a mixed product (<i>eg</i> book and CD) belongs partly to two or more product
 * classifications. If omitted, the product classification code applies to 100% of the product.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Real decimal number in the range 0 to 100</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;Percent&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;b337&gt;</td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;1</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td>&lt;Percent&gt;66.67&lt;/Percent&gt;</td>
 * </tr>
 * </table>
 */
public class Percent implements OnixElement, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "Percent";
	public static final String shortname = "b337";

	// ///////////////////////////////////////////////////////////////////////////////
	// ATTRIBUTES
	// ///////////////////////////////////////////////////////////////////////////////

	/**
	 * (type: dt.DateOrDateTime)
	 */
	public String datestamp;

	public RecordSourceTypes sourcetype;

	public String sourcename;

	// ///////////////////////////////////////////////////////////////////////////////
	// VALUE MEMBER
	// ///////////////////////////////////////////////////////////////////////////////

	/**
	 * Raw Format: Real decimal number in the range 0 to 100
	 * <p>
	 * (type: dt.PercentDecimal)
	 */
	public Double value;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public Percent()
	{}

	public Percent(org.w3c.dom.Element element)
	{
		datestamp = JPU.getAttribute(element, "datestamp");
		sourcetype = RecordSourceTypes.byValue(JPU.getAttribute(element, "sourcetype"));
		sourcename = JPU.getAttribute(element, "sourcename");

		value = JPU.getContentAsDouble(element);
	}
}
