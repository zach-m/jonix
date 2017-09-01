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
import com.tectonica.jonix.codelist.SubjectSchemeIdentifiers;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Subject scheme identifier</h1>
 * <p>
 * An ONIX code which identifies the category scheme which is used in an occurrence of the &lt;Subject&gt; composite.
 * Mandatory in each occurrence of the composite, and non-repeating.
 * </p>
 * <p>
 * For category schemes that use code values, use the associated &lt;SubjectCode&gt; element to carry the value (if so
 * required, the &lt;SubjectHeadingText&gt; element can be used simultaneously to carry the text equivalent of the
 * code). For schemes that use text headings, use the &lt;SubjectHeadingText&gt; element to carry the text of the
 * category heading.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Fixed-length, two alphanumeric characters</td>
 * </tr>
 * <tr>
 * <td>Codelist</td>
 * <td>List 27</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;SubjectSchemeIdentifier&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;b067&gt;</td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>1</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td>&lt;b067&gt;03&lt;/b067&gt; (US Library of Congress classification)</td>
 * </tr>
 * </table>
 */
public class SubjectSchemeIdentifier implements OnixElement<SubjectSchemeIdentifiers>, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "SubjectSchemeIdentifier";
	public static final String shortname = "b067";

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

	public SubjectSchemeIdentifiers value;

	/**
	 * Internal API, use the {@link #value} field instead
	 */
	@Override
	public SubjectSchemeIdentifiers _value()
	{
		return value;
	}

	/////////////////////////////////////////////////////////////////////////////////
	// SERVICES
	/////////////////////////////////////////////////////////////////////////////////

	private final boolean exists;
	public static final SubjectSchemeIdentifier EMPTY = new SubjectSchemeIdentifier();

	public SubjectSchemeIdentifier()
	{
		exists = false;
	}

	public SubjectSchemeIdentifier(org.w3c.dom.Element element)
	{
		exists = true;
		datestamp = JPU.getAttribute(element, "datestamp");
		sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
		sourcename = JPU.getAttribute(element, "sourcename");

		value = SubjectSchemeIdentifiers.byCode(JPU.getContentAsString(element));
	}

	@Override
	public boolean exists()
	{
		return exists;
	}
}
