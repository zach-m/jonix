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

import java.util.List;

import com.tectonica.jonix.DU;
import com.tectonica.jonix.codelist.Proximitys;
import com.tectonica.jonix.codelist.RecordSourceTypeCodes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

public class Stock
{
	public static final String refname = "Stock";
	public static final String shortname = "stock";

	public String datestamp; // dt.DateOrDateTime
	public RecordSourceTypeCodes sourcetype;
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

	public static Stock fromDoc(org.w3c.dom.Element element)
	{
		final Stock x = new Stock();

		x.datestamp = DU.getAttribute(element, "datestamp");
		x.sourcetype = RecordSourceTypeCodes.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		DU.forElementsOf(element, new DU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(LocationIdentifier.refname) || name.equals(LocationIdentifier.shortname))
					x.locationIdentifier = LocationIdentifier.fromDoc(element);
				else if (name.equals(LocationName.refname) || name.equals(LocationName.shortname))
					x.locationName = LocationName.fromDoc(element);
				else if (name.equals(StockQuantityCoded.refname) || name.equals(StockQuantityCoded.shortname))
					x.stockQuantityCodeds = DU.addToList(x.stockQuantityCodeds, StockQuantityCoded.fromDoc(element));
				else if (name.equals(OnHand.refname) || name.equals(OnHand.shortname))
					x.onHand = OnHand.fromDoc(element);
				else if (name.equals(Proximity.refname) || name.equals(Proximity.shortname))
					x.proximity = Proximity.fromDoc(element);
				else if (name.equals(OnOrder.refname) || name.equals(OnOrder.shortname))
					x.onOrder = OnOrder.fromDoc(element);
				else if (name.equals(CBO.refname) || name.equals(CBO.shortname))
					x.cbo = CBO.fromDoc(element);
				else if (name.equals(OnOrderDetail.refname) || name.equals(OnOrderDetail.shortname))
					x.onOrderDetails = DU.addToList(x.onOrderDetails, OnOrderDetail.fromDoc(element));
				else if (name.equals(Velocity.refname) || name.equals(Velocity.shortname))
					x.velocitys = DU.addToList(x.velocitys, Velocity.fromDoc(element));
			}
		});

		return x;
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
}
