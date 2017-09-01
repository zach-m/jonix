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
import com.tectonica.jonix.codelist.EditionTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Edition type code</h1>
 * <p>
 * An ONIX code, indicating the type of a version or edition. Optional, and repeatable if the product has
 * characteristics of two or more types (<i>eg</i> ‘revised’ and ‘annotated’).
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Fixed-length, three upper-case letters</td>
 * </tr>
 * <tr>
 * <td>Codelist</td>
 * <td>List 21</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;EditionType&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;x419&gt;</td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td>&lt;EditionType&gt;ILL&lt;/EditionType&gt; (Illustrated edition)</td>
 * </tr>
 * </table>
 */
public class EditionType implements OnixElement<EditionTypes>, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "EditionType";
	public static final String shortname = "x419";

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

	public EditionTypes value;

	/**
	 * Internal API, use the {@link #value} field instead
	 */
	@Override
	public EditionTypes _value()
	{
		return value;
	}

	/////////////////////////////////////////////////////////////////////////////////
	// SERVICES
	/////////////////////////////////////////////////////////////////////////////////

	private final boolean exists;
	public static final EditionType EMPTY = new EditionType();

	public EditionType()
	{
		exists = false;
	}

	public EditionType(org.w3c.dom.Element element)
	{
		exists = true;
		datestamp = JPU.getAttribute(element, "datestamp");
		sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
		sourcename = JPU.getAttribute(element, "sourcename");

		value = EditionTypes.byCode(JPU.getContentAsString(element));
	}

	@Override
	public boolean exists()
	{
		return exists;
	}
}
