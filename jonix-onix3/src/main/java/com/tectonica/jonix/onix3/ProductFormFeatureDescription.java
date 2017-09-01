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
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Product form feature description</h1>
 * <p>
 * If the &lt;ProductFormFeatureType&gt; requires free text rather than a code value, or if the code in
 * &lt;ProductFormFeatureValue&gt; does not adequately describe the feature, a short text description may be added.
 * Optional, and repeatable to provide parallel descriptive text in multiple languages. The <i>language</i> attribute is
 * optional for a single instance of &lt;ProductFormFeatureDescription&gt;, but must be included in each instance if
 * &lt;ProductFormFeatureDescription&gt; is repeated to provide parallel text in multiple languages.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Variable-length text, suggested maximum length 500 characters</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;ProductFormFeatureDescription&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;b336&gt;</td>
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
 * <td>&lt;b336&gt;11pt Helvetica&lt;/b336&gt;</td>
 * </tr>
 * </table>
 */
public class ProductFormFeatureDescription implements OnixElement<String>, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "ProductFormFeatureDescription";
	public static final String shortname = "b336";

	/////////////////////////////////////////////////////////////////////////////////
	// ATTRIBUTES
	/////////////////////////////////////////////////////////////////////////////////

	/**
	 * (type: dt.DateOrDateTime)
	 */
	public String datestamp;

	public RecordSourceTypes sourcetype;

	public String sourcename;

	public LanguageCodes language;

	/////////////////////////////////////////////////////////////////////////////////
	// VALUE MEMBER
	/////////////////////////////////////////////////////////////////////////////////

	/**
	 * Raw Format: Variable-length text, suggested maximum length 500 characters
	 * <p>
	 * (type: dt.NonEmptyString)
	 */
	public String value;

	/**
	 * Internal API, use the {@link #value} field instead
	 */
	@Override
	public String _value()
	{
		return value;
	}

	/////////////////////////////////////////////////////////////////////////////////
	// SERVICES
	/////////////////////////////////////////////////////////////////////////////////

	private final boolean exists;
	public static final ProductFormFeatureDescription EMPTY = new ProductFormFeatureDescription();

	public ProductFormFeatureDescription()
	{
		exists = false;
	}

	public ProductFormFeatureDescription(org.w3c.dom.Element element)
	{
		exists = true;
		datestamp = JPU.getAttribute(element, "datestamp");
		sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
		sourcename = JPU.getAttribute(element, "sourcename");
		language = LanguageCodes.byCode(JPU.getAttribute(element, "language"));

		value = JPU.getContentAsString(element);
	}

	@Override
	public boolean exists()
	{
		return exists;
	}
}
