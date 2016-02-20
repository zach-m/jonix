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
import com.tectonica.jonix.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.codelist.Proximitys;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.StockQuantityCodeTypes;
import com.tectonica.jonix.struct.JonixStockQuantityCoded;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <h1>Stock quantity composite</h1>
 * <p>
 * A repeatable group of data elements which together specify a quantity of stock and, where a supplier has more than
 * one warehouse, a supplier location. Optional.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;Stock&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;stock&gt;</td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 */
public class Stock implements OnixSuperComposite, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "Stock";
	public static final String shortname = "stock";

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
	 * (this field is optional)
	 */
	public LocationIdentifier locationIdentifier;

	/**
	 * (this field is optional)
	 */
	public LocationName locationName;

	/**
	 * (this list may be empty)
	 */
	public List<StockQuantityCoded> stockQuantityCodeds;

	/**
	 * (this field is required)
	 */
	public OnHand onHand;

	/**
	 * (this field is optional)
	 */
	public Proximity proximity;

	/**
	 * (this field is optional)
	 */
	public OnOrder onOrder;

	/**
	 * (this field is optional)
	 */
	public CBO cbo;

	/**
	 * (this list may be empty)
	 */
	public List<OnOrderDetail> onOrderDetails;

	/**
	 * (this list may be empty)
	 */
	public List<Velocity> velocitys;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public Stock()
	{}

	public Stock(org.w3c.dom.Element element)
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
				if (name.equals(LocationIdentifier.refname) || name.equals(LocationIdentifier.shortname))
					locationIdentifier = new LocationIdentifier(element);
				else if (name.equals(LocationName.refname) || name.equals(LocationName.shortname))
					locationName = new LocationName(element);
				else if (name.equals(StockQuantityCoded.refname) || name.equals(StockQuantityCoded.shortname))
					stockQuantityCodeds = JPU.addToList(stockQuantityCodeds, new StockQuantityCoded(element));
				else if (name.equals(OnHand.refname) || name.equals(OnHand.shortname))
					onHand = new OnHand(element);
				else if (name.equals(Proximity.refname) || name.equals(Proximity.shortname))
					proximity = new Proximity(element);
				else if (name.equals(OnOrder.refname) || name.equals(OnOrder.shortname))
					onOrder = new OnOrder(element);
				else if (name.equals(CBO.refname) || name.equals(CBO.shortname))
					cbo = new CBO(element);
				else if (name.equals(OnOrderDetail.refname) || name.equals(OnOrderDetail.shortname))
					onOrderDetails = JPU.addToList(onOrderDetails, new OnOrderDetail(element));
				else if (name.equals(Velocity.refname) || name.equals(Velocity.shortname))
					velocitys = JPU.addToList(velocitys, new Velocity(element));
			}
		});
	}

	/**
	 * Format: Variable-length text, suggested maximum length 100 characters
	 */
	public String getLocationNameValue()
	{
		return (locationName == null) ? null : locationName.value;
	}

	/**
	 * Format: Variable-length integer, suggested maximum length 7 digits
	 */
	public Integer getOnHandValue()
	{
		return (onHand == null) ? null : onHand.value;
	}

	public Proximitys getProximityValue()
	{
		return (proximity == null) ? null : proximity.value;
	}

	/**
	 * Format: Variable-length integer, suggested maximum length 7 digits
	 */
	public Integer getOnOrderValue()
	{
		return (onOrder == null) ? null : onOrder.value;
	}

	/**
	 * Format: Variable-length integer, suggested maximum length 7 digits
	 */
	public Integer getCBOValue()
	{
		return (cbo == null) ? null : cbo.value;
	}

	public JonixStockQuantityCoded findStockQuantityCoded(StockQuantityCodeTypes stockQuantityCodeType)
	{
		if (stockQuantityCodeds != null)
		{
			for (StockQuantityCoded x : stockQuantityCodeds)
			{
				if (x.getStockQuantityCodeTypeValue() == stockQuantityCodeType)
					return x.asJonixStockQuantityCoded();
			}
		}
		return null;
	}

	public List<JonixStockQuantityCoded> findStockQuantityCodeds(
			java.util.Set<StockQuantityCodeTypes> stockQuantityCodeTypes)
	{
		if (stockQuantityCodeds != null)
		{
			List<JonixStockQuantityCoded> matches = new ArrayList<>();
			for (StockQuantityCoded x : stockQuantityCodeds)
			{
				if (stockQuantityCodeTypes == null
						|| stockQuantityCodeTypes.contains(x.getStockQuantityCodeTypeValue()))
					matches.add(x.asJonixStockQuantityCoded());
			}
			return matches;
		}
		return null;
	}
}
