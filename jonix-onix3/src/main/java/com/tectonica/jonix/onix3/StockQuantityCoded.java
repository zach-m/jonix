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
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.StockQuantityCodeTypes;
import com.tectonica.jonix.struct.JonixStockQuantityCoded;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <h1>Stock quantity coded composite</h1>
 * <p>
 * A group of data elements which together specify coded stock level without stating the exact quantity of stock. Either
 * &lt;StockQuantityCoded&gt; or &lt;OnHand&gt; is mandatory in each occurrence of the &lt;Stock&gt; composite, even if
 * the quantity on hand is zero. Repeatable, so that it is possible to provide quantities on hand, quantities on order
 * <i>etc</i> separately.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;StockQuantityCoded&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;stockquantitycoded&gt;</td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 */
public class StockQuantityCoded implements OnixDataComposite, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "StockQuantityCoded";
	public static final String shortname = "stockquantitycoded";

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
	public StockQuantityCodeType stockQuantityCodeType;

	/**
	 * (this field is optional)
	 */
	public StockQuantityCodeTypeName stockQuantityCodeTypeName;

	/**
	 * (this field is required)
	 */
	public StockQuantityCode stockQuantityCode;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public StockQuantityCoded()
	{}

	public StockQuantityCoded(org.w3c.dom.Element element)
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
				if (name.equals(StockQuantityCodeType.refname) || name.equals(StockQuantityCodeType.shortname))
					stockQuantityCodeType = new StockQuantityCodeType(element);
				else if (name.equals(StockQuantityCodeTypeName.refname)
						|| name.equals(StockQuantityCodeTypeName.shortname))
					stockQuantityCodeTypeName = new StockQuantityCodeTypeName(element);
				else if (name.equals(StockQuantityCode.refname) || name.equals(StockQuantityCode.shortname))
					stockQuantityCode = new StockQuantityCode(element);
			}
		});
	}

	public StockQuantityCodeTypes getStockQuantityCodeTypeValue()
	{
		return (stockQuantityCodeType == null) ? null : stockQuantityCodeType.value;
	}

	/**
	 * Raw Format: Variable-length text, suggested maximum length 50 characters
	 */
	public String getStockQuantityCodeTypeNameValue()
	{
		return (stockQuantityCodeTypeName == null) ? null : stockQuantityCodeTypeName.value;
	}

	/**
	 * Raw Format: According to the scheme specified in &lt;StockQuantityCodeType&gt;
	 */
	public String getStockQuantityCodeValue()
	{
		return (stockQuantityCode == null) ? null : stockQuantityCode.value;
	}

	public JonixStockQuantityCoded asJonixStockQuantityCoded()
	{
		JonixStockQuantityCoded x = new JonixStockQuantityCoded();
		x.stockQuantityCodeType = getStockQuantityCodeTypeValue();
		x.stockQuantityCode = getStockQuantityCodeValue();
		x.stockQuantityCodeTypeName = getStockQuantityCodeTypeNameValue();
		return x;
	}
}
