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
import com.tectonica.jonix.codelist.ProductFormsList150;
import com.tectonica.jonix.codelist.RecordSourceTypes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Related product form code</h1>
 * <p>
 * An ONIX code which indicates the primary form of a related product. Optional in an occurrence of
 * &lt;RelatedProduct&gt;, and non-repeating. If supplied, should be identical to the &lt;ProductForm&gt; element
 * supplied in the &lt;DescriptiveDetail&gt; block of the full ONIX record describing the related product itself.
 * </p>
 * <p>
 * Since this and the following element provide data about a related product, ONIX suppliers are cautioned of the risk
 * of contradictory data in separate data feeds. <em>This and the following element should not be supplied unless
 * specifically requested by a particular recipient.</em>
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Fixed-length, two letters</td>
 * </tr>
 * <tr>
 * <td>Codelist</td>
 * <td>List 150</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;ProductForm&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;b012&gt;</td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;1</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td>&lt;ProductForm&gt;BC&lt;/ProductForm&gt; (Paperback book)</td>
 * </tr>
 * </table>
 */
public class ProductForm implements OnixElement<ProductFormsList150>, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "ProductForm";
	public static final String shortname = "b012";

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

	public ProductFormsList150 value;

	/**
	 * Internal API, use the {@link #value} field instead
	 */
	@Override
	public ProductFormsList150 _value()
	{
		return value;
	}

	/////////////////////////////////////////////////////////////////////////////////
	// SERVICES
	/////////////////////////////////////////////////////////////////////////////////

	private final boolean exists;
	public static final ProductForm EMPTY = new ProductForm();

	public ProductForm()
	{
		exists = false;
	}

	public ProductForm(org.w3c.dom.Element element)
	{
		exists = true;
		datestamp = JPU.getAttribute(element, "datestamp");
		sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
		sourcename = JPU.getAttribute(element, "sourcename");

		value = ProductFormsList150.byCode(JPU.getContentAsString(element));
	}

	@Override
	public boolean exists()
	{
		return exists;
	}
}
