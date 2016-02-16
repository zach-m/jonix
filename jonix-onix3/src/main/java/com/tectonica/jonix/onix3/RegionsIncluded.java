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
import com.tectonica.jonix.codelist.Regions;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <h1>Regions included</h1>
 * <p>
 * One or more ONIX codes identifying regions included in the territory. A region is an area which is not a country, but
 * which is precisely defined in geographical terms, <i>eg</i> World, Northern Ireland, Australian Capital Territory.
 * Successive codes must be separated by spaces. Optional and non-repeating, but <em>either</em>
 * &lt;CountriesIncluded&gt; <em>or</em> &lt;RegionsIncluded&gt; is mandatory in each occurrence of the
 * &lt;Territory&gt; composite. Note that US States have region codes, while US overseas territories have distinct ISO
 * Country Codes.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>One or more variable-length codes, each consisting of upper case letters with or without a hyphen, successive
 * codes being separated by spaces. Suggested maximum length 100 characters</td>
 * </tr>
 * <tr>
 * <td>Codelist</td>
 * <td>List 49 Where possible and appropriate, country subdivision codes are derived from the UN LOCODE scheme based on
 * ISO 3166</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;RegionsIncluded&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;x450&gt;</td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;1</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td>&lt;x450&gt;WORLD&lt;/x450&gt; (Whole world)</td>
 * </tr>
 * <tr>
 * <td></td>
 * <td>&lt;x450&gt;US-CA&lt;/x450&gt; (California)</td>
 * </tr>
 * </table>
 */
public class RegionsIncluded implements OnixElement, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "RegionsIncluded";
	public static final String shortname = "x450";

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

	public java.util.Set<Regions> value;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public RegionsIncluded()
	{}

	public RegionsIncluded(org.w3c.dom.Element element)
	{
		datestamp = JPU.getAttribute(element, "datestamp");
		sourcetype = RecordSourceTypes.byValue(JPU.getAttribute(element, "sourcetype"));
		sourcename = JPU.getAttribute(element, "sourcename");

		value = new java.util.HashSet<>();
		for (String split : JPU.getContentAsString(element).trim().split(" +"))
			value.add(Regions.byValue(split));
	}
}
