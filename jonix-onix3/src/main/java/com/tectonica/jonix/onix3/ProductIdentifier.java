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
import com.tectonica.jonix.OnixComposite.OnixDataComposite;
import com.tectonica.jonix.codelist.ProductIdentifierTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixProductIdentifier;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <h1>Product identifier composite</h1>
 * <p>
 * A repeatable group of data elements which together define an identifier for a comparison product in accordance with a
 * specified scheme. At least one &lt;ProductIdentifier&gt; composite is mandatory within an occurrence of
 * &lt;ComparisonProductPrice&gt;, to identify the product to which the comparison price applies.
 * </p>
 * <p>
 * It is strongly advised that the relationship between the comparison product and the product described in the
 * &lt;Product&gt; record is defined in a &lt;RelatedProduct&gt; composite in P.23 – typically this might be
 * &lt;ProductRelationCode&gt; 06 (related product is alternative format with same content as product) and may in many
 * circumstances also be 13 (product is e-publication based on related product).
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;ProductIdentifier&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;productidentifier&gt;</td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>1&#8230;n</td>
 * </tr>
 * </table>
 */
public class ProductIdentifier implements OnixDataComposite, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "ProductIdentifier";
	public static final String shortname = "productidentifier";

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
	public ProductIDType productIDType;

	/**
	 * (this field is optional)
	 */
	public IDTypeName idTypeName;

	/**
	 * (this field is required)
	 */
	public IDValue idValue;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public ProductIdentifier()
	{}

	public ProductIdentifier(org.w3c.dom.Element element)
	{
		datestamp = JPU.getAttribute(element, "datestamp");
		sourcetype = RecordSourceTypes.byValue(JPU.getAttribute(element, "sourcetype"));
		sourcename = JPU.getAttribute(element, "sourcename");

		JPU.forElementsOf(element, new JPU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(ProductIDType.refname) || name.equals(ProductIDType.shortname))
					productIDType = new ProductIDType(element);
				else if (name.equals(IDTypeName.refname) || name.equals(IDTypeName.shortname))
					idTypeName = new IDTypeName(element);
				else if (name.equals(IDValue.refname) || name.equals(IDValue.shortname))
					idValue = new IDValue(element);
			}
		});
	}

	public ProductIdentifierTypes getProductIDTypeValue()
	{
		return (productIDType == null) ? null : productIDType.value;
	}

	/**
	 * Raw Format: Variable-length text, suggested maximum length 50 characters
	 */
	public String getIDTypeNameValue()
	{
		return (idTypeName == null) ? null : idTypeName.value;
	}

	/**
	 * Raw Format: According to the identifier type specified in &lt;PriceIDType&gt;
	 */
	public String getIDValueValue()
	{
		return (idValue == null) ? null : idValue.value;
	}

	public JonixProductIdentifier asJonixProductIdentifier()
	{
		JonixProductIdentifier x = new JonixProductIdentifier();
		x.productIDType = getProductIDTypeValue();
		x.idTypeName = getIDTypeNameValue();
		x.idValue = getIDValueValue();
		return x;
	}
}
