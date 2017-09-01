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
 * <h1>Product form feature value</h1>
 * <p>
 * A controlled value that describes a product form feature. Presence or absence of this element depends on the
 * &lt;ProductFormFeatureType&gt;, since some product form features (<i>eg</i> thumb index) do not require an
 * accompanying value, while others (<i>eg</i> text font) require free text in &lt;ProductFormFeatureDescription&gt;;
 * and others may have both code and free text. Non-repeating.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Dependent on the scheme specified in &lt;ProductFormFeatureType&gt;</td>
 * </tr>
 * <tr>
 * <td>Codelist</td>
 * <td>Dependent on the scheme specified in &lt;ProductFormFeatureType&gt;</td>
 * </tr>
 * <tr>
 * <td></td>
 * <td>For cover binding color, see List 98</td>
 * </tr>
 * <tr>
 * <td></td>
 * <td>For page edge color, see List 98</td>
 * </tr>
 * <tr>
 * <td></td>
 * <td>For special cover material, see List 99</td>
 * </tr>
 * <tr>
 * <td></td>
 * <td>For text font, use free text in &lt;ProductFormFeatureDescription&gt;, which may include font name and/or
 * size</td>
 * </tr>
 * <tr>
 * <td></td>
 * <td>For DVD region codes, see List 76</td>
 * </tr>
 * <tr>
 * <td></td>
 * <td>For CPSIA choking hazard warning, see List 143</td>
 * </tr>
 * <tr>
 * <td></td>
 * <td>For EU Toy Safety hazard warnings, see List 184</td>
 * </tr>
 * <tr>
 * <td></td>
 * <td>For various paper certification schemes (FSC, PEFC etc), see List 79. &lt;ProductFormFeatureType&gt; identifies
 * the certification scheme, and &lt;ProductFormFeatureValue&gt; may carry a Chain of Custody (COC) number. For
 * certified recycled paper, a separate repeat of the &lt;ProductFormFeature&gt; composite may carry the percent
 * post-consumer waste used in a product</td>
 * </tr>
 * <tr>
 * <td></td>
 * <td>For specific versions of common e-publication file formats, (eg the IDPF's EPUB 2.0.1), use
 * &lt;ProductFormFeatureType&gt; code 15 and a value from List 220. For e-publication formats not covered in List 220,
 * use &lt;ProductFormFeatureType&gt; code 10 and a period-separated list of numbers (eg '7', '1.5' or '3.10.7') in
 * &lt;ProductFormFeatureValue&gt;</td>
 * </tr>
 * <tr>
 * <td></td>
 * <td>For required operating system for a digital product, see List 176. You should in addition include operating
 * system version information (major and minor version numbers as necessary, eg '10.6.4 or later' for Mac OS 10.6.4, '7
 * SP1 or later' for Windows 7 Service Pack 1) in &lt;ProductFormFeatureDescription&gt;. For other system requirements
 * for a digital product (eg specific memory, storage or other hardware requirements), use free text in
 * &lt;ProductFormFeatureDescription&gt; within a separate repeat of the &lt;ProductFormFeature&gt; composite</td>
 * </tr>
 * <tr>
 * <td></td>
 * <td>For e-publication accessibility features for print-impaired readers, see List 196</td>
 * </tr>
 * <tr>
 * <td></td>
 * <td>Further features with corresponding code lists may be added from time to time without a re-issue of this document
 * - see the latest release of Code List 79</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;ProductFormFeatureValue&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;b335&gt;</td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;1</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td>&lt;b335&gt;BLK&lt;/b335&gt; (Black color)</td>
 * </tr>
 * </table>
 */
public class ProductFormFeatureValue implements OnixElement<String>, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "ProductFormFeatureValue";
	public static final String shortname = "b335";

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
	 * Raw Format: Dependent on the scheme specified in &lt;ProductFormFeatureType&gt;
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
	public static final ProductFormFeatureValue EMPTY = new ProductFormFeatureValue();

	public ProductFormFeatureValue()
	{
		exists = false;
	}

	public ProductFormFeatureValue(org.w3c.dom.Element element)
	{
		exists = true;
		datestamp = JPU.getAttribute(element, "datestamp");
		sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
		sourcename = JPU.getAttribute(element, "sourcename");

		value = JPU.getContentAsString(element);
	}

	@Override
	public boolean exists()
	{
		return exists;
	}
}
