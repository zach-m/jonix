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
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Measurement</h1>
 * <p>
 * The number which represents the dimension specified in &lt;MeasureType&gt; in the measure units specified in
 * &lt;MeasureUnitCode&gt;. Mandatory in each occurrence of the &lt;Measure&gt; composite, and non-repeating.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Variable length real number, with an explicit decimal point when required, suggested maximum length 6 characters
 * including a decimal point</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;Measurement&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;c094&gt;</td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>1</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td>&lt;c094&gt;8.25&lt;/c094&gt;</td>
 * </tr>
 * </table>
 */
public class Measurement implements OnixElement<Double>, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "Measurement";
	public static final String shortname = "c094";

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

	/**
	 * Raw Format: Variable length real number, with an explicit decimal point when required, suggested maximum length 6
	 * characters including a decimal point
	 * <p>
	 * (type: dt.StrictPositiveDecimal)
	 */
	public Double value;

	/**
	 * Internal API, use the {@link #value} field instead
	 */
	@Override
	public Double _value()
	{
		return value;
	}

	/////////////////////////////////////////////////////////////////////////////////
	// SERVICES
	/////////////////////////////////////////////////////////////////////////////////

	private final boolean exists;
	public static final Measurement EMPTY = new Measurement();

	public Measurement()
	{
		exists = false;
	}

	public Measurement(org.w3c.dom.Element element)
	{
		exists = true;
		datestamp = JPU.getAttribute(element, "datestamp");
		sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
		sourcename = JPU.getAttribute(element, "sourcename");

		value = JPU.getContentAsDouble(element);
	}

	@Override
	public boolean exists()
	{
		return exists;
	}
}
