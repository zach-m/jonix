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
 * <h1>Number of items of a specified form (product part)</h1>
 * <p>
 * When product parts are listed as a specified number of <em>different</em> items in a specified form, without
 * identifying the individual items, &lt;NumberOfItemsOfThisForm&gt; must be used to carry the quantity, even if the
 * number is ‘1’. Consequently the element is mandatory and non-repeating in an occurrence of the &lt;ProductPart&gt;
 * composite if &lt;NumberOfCopies&gt; is not present; and it must not be used if &lt;ProductIdentifier&gt; is present.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Variable-length integer, maximum four digits</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;NumberOfItemsOfThisForm&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;x322&gt;</td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;1</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td>&lt;x322&gt;3&lt;/x322&gt;</td>
 * </tr>
 * </table>
 */
public class NumberOfItemsOfThisForm implements OnixElement, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "NumberOfItemsOfThisForm";
	public static final String shortname = "x322";

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
	 * Format: Variable-length integer, maximum four digits
	 * <p>
	 * (type: dt.StrictPositiveInteger)
	 */
	public Integer value;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public NumberOfItemsOfThisForm()
	{}

	public NumberOfItemsOfThisForm(org.w3c.dom.Element element)
	{
		datestamp = JPU.getAttribute(element, "datestamp");
		sourcetype = RecordSourceTypes.byValue(JPU.getAttribute(element, "sourcetype"));
		sourcename = JPU.getAttribute(element, "sourcename");

		value = JPU.getContentAsInteger(element);
	}
}
