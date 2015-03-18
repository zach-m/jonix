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

package com.tectonica.jonix.onix2.model;

import java.util.List;

import com.tectonica.jonix.onix2.DU;
import com.tectonica.jonix.onix2.codelist.List138;
import com.tectonica.jonix.onix2.codelist.List14;
import com.tectonica.jonix.onix2.codelist.List3;
import com.tectonica.jonix.onix2.codelist.List34;
import com.tectonica.jonix.onix2.codelist.List74;

public class Stock
{
	public static final String refname = "Stock";
	public static final String shortname = "stock";

	public List34 textformat;
	public List14 textcase;
	public List74 language;
	public List138 transliteration;
	public String datestamp; // DateOrDateTime
	public List3 sourcetype;
	public String sourcename;

	public LocationIdentifier locationIdentifier; // Optional
	public LocationName locationName; // Optional
	public StockQuantityCoded stockQuantityCoded; // Required
	public OnHand onHand; // Optional
	public OnOrder onOrder; // Optional
	public CBO cbO; // Optional
	public List<OnOrderDetail> onOrderDetails; // ZeroOrMore

	public static Stock fromDoc(org.w3c.dom.Element element)
	{
		final Stock x = new Stock();

		x.textformat = List34.byValue(DU.getAttribute(element, "textformat"));
		x.textcase = List14.byValue(DU.getAttribute(element, "textcase"));
		x.language = List74.byValue(DU.getAttribute(element, "language"));
		x.transliteration = List138.byValue(DU.getAttribute(element, "transliteration"));
		x.datestamp = DU.getAttribute(element, "datestamp");
		x.sourcetype = List3.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		DU.forElementsOf(element, new DU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equalsIgnoreCase(LocationIdentifier.refname) || name.equalsIgnoreCase(LocationIdentifier.shortname))
					x.locationIdentifier = LocationIdentifier.fromDoc(element);
				else if (name.equalsIgnoreCase(LocationName.refname) || name.equalsIgnoreCase(LocationName.shortname))
					x.locationName = LocationName.fromDoc(element);
				else if (name.equalsIgnoreCase(StockQuantityCoded.refname) || name.equalsIgnoreCase(StockQuantityCoded.shortname))
					x.stockQuantityCoded = StockQuantityCoded.fromDoc(element);
				else if (name.equalsIgnoreCase(OnHand.refname) || name.equalsIgnoreCase(OnHand.shortname))
					x.onHand = OnHand.fromDoc(element);
				else if (name.equalsIgnoreCase(OnOrder.refname) || name.equalsIgnoreCase(OnOrder.shortname))
					x.onOrder = OnOrder.fromDoc(element);
				else if (name.equalsIgnoreCase(CBO.refname) || name.equalsIgnoreCase(CBO.shortname))
					x.cbO = CBO.fromDoc(element);
				else if (name.equalsIgnoreCase(OnOrderDetail.refname) || name.equalsIgnoreCase(OnOrderDetail.shortname))
					x.onOrderDetails = DU.addToList(x.onOrderDetails, OnOrderDetail.fromDoc(element));
			}
		});

		return x;
	}
}
