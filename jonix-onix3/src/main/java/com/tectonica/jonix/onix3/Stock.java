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
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

@SuppressWarnings("serial")
public class Stock implements OnixSuperComposite, Serializable
{
	public static final String refname = "Stock";
	public static final String shortname = "stock";

	public String datestamp; // dt.DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public LocationIdentifier locationIdentifier; // Optional
	public LocationName locationName; // Optional
	public List<StockQuantityCoded> stockQuantityCodeds; // ZeroOrMore
	public OnHand onHand; // Required
	public Proximity proximity; // Optional
	public OnOrder onOrder; // Optional
	public CBO cbo; // Optional
	public List<OnOrderDetail> onOrderDetails; // ZeroOrMore
	public List<Velocity> velocitys; // ZeroOrMore

	public Stock()
	{}

	public Stock(org.w3c.dom.Element element)
	{
		this.datestamp = JPU.getAttribute(element, "datestamp");
		this.sourcetype = RecordSourceTypes.byValue(JPU.getAttribute(element, "sourcetype"));
		this.sourcename = JPU.getAttribute(element, "sourcename");

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

	public String getLocationNameValue()
	{
		return (locationName == null) ? null : locationName.value;
	}

	public Integer getOnHandValue()
	{
		return (onHand == null) ? null : onHand.value;
	}

	public Proximitys getProximityValue()
	{
		return (proximity == null) ? null : proximity.value;
	}

	public Integer getOnOrderValue()
	{
		return (onOrder == null) ? null : onOrder.value;
	}

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
