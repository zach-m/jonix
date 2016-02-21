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
 * <h1>Amount of price taxable</h1>
 * <p>
 * The amount of the unit price of the product, excluding tax, which is taxable at the rate specified in an occurrence
 * of the &lt;Tax&gt; composite. Optional and non-repeating; but required if tax is charged on part of the price.
 * Omission of this element implies that tax is charged on the full amount of the price.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Variable length real number, with explicit decimal point when required, suggested maximum length 12 characters</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;TaxableAmount&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;x473&gt;</td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;1</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td>&lt;x473&gt;10.64&lt;/x473&gt;</td>
 * </tr>
 * </table>
 */
public class TaxableAmount implements OnixElement, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "TaxableAmount";
	public static final String shortname = "x473";

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
	 * Raw Format: Variable length real number, with explicit decimal point when required, suggested maximum length 12
	 * characters
	 * <p>
	 * (type: dt.StrictPositiveDecimal)
	 */
	public Double value;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public TaxableAmount()
	{}

	public TaxableAmount(org.w3c.dom.Element element)
	{
		datestamp = JPU.getAttribute(element, "datestamp");
		sourcetype = RecordSourceTypes.byValue(JPU.getAttribute(element, "sourcetype"));
		sourcename = JPU.getAttribute(element, "sourcename");

		value = JPU.getContentAsDouble(element);
	}
}
