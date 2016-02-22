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

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <h1>Prize statement</h1>
 * <p>
 * A short free-text description of the prize or award, intended primarily for display. Optional, and repeatable if the
 * text is provided in more than one language. The <i>language</i> attribute is optional for a single instance of
 * &lt;PrizeStatement&gt;, but must be included in each instance if &lt;PrizeStatement&gt; is repeated.
 * </p>
 * <p>
 * &lt;PrizeStatement&gt; is intended for display purposes only. When used, a &lt;PrizeStatement&gt; must be complete in
 * itself, <i>ie</i> it should not be treated as merely supplementary to other elements within the &lt;Prize&gt;
 * composite. Nor should &lt;PrizeStatement&gt; be supplied <em>instead</em> of those other elements – at minimum, the
 * &lt;PrizeCode&gt; element, and whenever appropriate the &lt;PrizeYear&gt; element should be supplied.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Variable-length text, suggested maximum length 100 characters</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;PrizeStatement&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;x503&gt;</td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * <tr>
 * <td>Attributes</td>
 * <td>language</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td>&lt;PrizeStatement language=&quot;eng&quot;&gt;Joint winner of the Mao Dun Literature Prize,
 * 2000&lt;/PrizeStatement&gt;</td>
 * </tr>
 * </table>
 */
public class PrizeStatement implements OnixElement, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "PrizeStatement";
	public static final String shortname = "x503";

	// ///////////////////////////////////////////////////////////////////////////////
	// ATTRIBUTES
	// ///////////////////////////////////////////////////////////////////////////////

	/**
	 * (type: dt.DateOrDateTime)
	 */
	public String datestamp;

	public RecordSourceTypes sourcetype;

	public String sourcename;

	public LanguageCodes language;

	// ///////////////////////////////////////////////////////////////////////////////
	// VALUE MEMBER
	// ///////////////////////////////////////////////////////////////////////////////

	/**
	 * Raw Format: Variable-length text, suggested maximum length 100 characters
	 * <p>
	 * (type: dt.NonEmptyString)
	 */
	public String value;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public PrizeStatement()
	{}

	public PrizeStatement(org.w3c.dom.Element element)
	{
		datestamp = JPU.getAttribute(element, "datestamp");
		sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
		sourcename = JPU.getAttribute(element, "sourcename");
		language = LanguageCodes.byCode(JPU.getAttribute(element, "language"));

		value = JPU.getContentAsString(element);
	}
}
