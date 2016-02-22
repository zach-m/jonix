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
import java.util.ArrayList;
import java.util.List;

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.OnixComposite.OnixDataComposite;
import com.tectonica.jonix.codelist.ProductFormFeatureTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixProductFormFeature;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <h1>Product form feature composite (product part)</h1>
 * <p>
 * A repeatable group of data elements which together describe an aspect of product form that is too specific to be
 * covered in the &lt;ProductForm&gt; and &lt;ProductFormDetail&gt; elements. Optional, and not normally expected to be
 * used in the description of a product part. The composite is included here so that it can if necessary be used in the
 * US to carry consumer protection data related to a product part.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;ProductFormFeature&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;productformfeature&gt;</td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 */
public class ProductFormFeature implements OnixDataComposite, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "ProductFormFeature";
	public static final String shortname = "productformfeature";

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
	// MEMBERS
	// ///////////////////////////////////////////////////////////////////////////////

	/**
	 * (this field is required)
	 */
	public ProductFormFeatureType productFormFeatureType;

	/**
	 * (this field is optional)
	 */
	public ProductFormFeatureValue productFormFeatureValue;

	/**
	 * (this list may be empty)
	 */
	public List<ProductFormFeatureDescription> productFormFeatureDescriptions;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public ProductFormFeature()
	{}

	public ProductFormFeature(org.w3c.dom.Element element)
	{
		datestamp = JPU.getAttribute(element, "datestamp");
		sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
		sourcename = JPU.getAttribute(element, "sourcename");

		JPU.forElementsOf(element, new JPU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(ProductFormFeatureType.refname) || name.equals(ProductFormFeatureType.shortname))
					productFormFeatureType = new ProductFormFeatureType(element);
				else if (name.equals(ProductFormFeatureValue.refname) || name.equals(ProductFormFeatureValue.shortname))
					productFormFeatureValue = new ProductFormFeatureValue(element);
				else if (name.equals(ProductFormFeatureDescription.refname)
						|| name.equals(ProductFormFeatureDescription.shortname))
					productFormFeatureDescriptions = JPU.addToList(productFormFeatureDescriptions,
							new ProductFormFeatureDescription(element));
			}
		});
	}

	public ProductFormFeatureTypes getProductFormFeatureTypeValue()
	{
		return (productFormFeatureType == null) ? null : productFormFeatureType.value;
	}

	/**
	 * Raw Format: Dependent on the scheme specified in &lt;ProductFormFeatureType&gt;
	 */
	public String getProductFormFeatureValueValue()
	{
		return (productFormFeatureValue == null) ? null : productFormFeatureValue.value;
	}

	/**
	 * Raw Format: Variable-length text, suggested maximum length 500 characters
	 */
	public List<String> getProductFormFeatureDescriptionValues()
	{
		if (productFormFeatureDescriptions != null)
		{
			List<String> list = new ArrayList<>();
			for (ProductFormFeatureDescription i : productFormFeatureDescriptions)
				list.add(i.value);
			return list;
		}
		return null;
	}

	public JonixProductFormFeature asJonixProductFormFeature()
	{
		JonixProductFormFeature x = new JonixProductFormFeature();
		x.productFormFeatureType = getProductFormFeatureTypeValue();
		x.productFormFeatureDescriptions = getProductFormFeatureDescriptionValues();
		x.productFormFeatureValue = getProductFormFeatureValueValue();
		return x;
	}
}
