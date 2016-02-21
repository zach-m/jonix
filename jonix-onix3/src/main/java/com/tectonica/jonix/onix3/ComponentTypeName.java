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
 * <h1>Component type name</h1>
 * <p>
 * The generic name (if any) which is given in the product to the type of section which the content item represents,
 * <i>eg</i> Chapter, Part, Track. Optional and non-repeating; but either this field or a title (in the
 * &lt;TitleDetail&gt; composite), or both, must be present in each occurrence of the &lt;ContentItem&gt;.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Variable-length alphanumeric, suggested maximum length 20 characters</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;ComponentTypeName&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;b288&gt;</td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;1</td>
 * </tr>
 * <tr>
 * <td>Attributes</td>
 * <td>language</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td>&lt;b288&gt;Chapter&lt;/b288&gt;</td>
 * </tr>
 * </table>
 */
public class ComponentTypeName implements OnixElement, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "ComponentTypeName";
	public static final String shortname = "b288";

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
	 * Raw Format: Variable-length alphanumeric, suggested maximum length 20 characters
	 * <p>
	 * (type: dt.NonEmptyString)
	 */
	public String value;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public ComponentTypeName()
	{}

	public ComponentTypeName(org.w3c.dom.Element element)
	{
		datestamp = JPU.getAttribute(element, "datestamp");
		sourcetype = RecordSourceTypes.byValue(JPU.getAttribute(element, "sourcetype"));
		sourcename = JPU.getAttribute(element, "sourcename");
		language = LanguageCodes.byValue(JPU.getAttribute(element, "language"));

		value = JPU.getContentAsString(element);
	}
}
