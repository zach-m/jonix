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
import java.util.List;

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.codelist.RecordSourceTypes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

@SuppressWarnings("serial")
public class ProductSupply implements Serializable
{
	public static final String refname = "ProductSupply";
	public static final String shortname = "productsupply";

	public String datestamp; // dt.DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public List<Market> markets; // ZeroOrMore
	public MarketPublishingDetail marketPublishingDetail; // Optional
	public List<SupplyDetail> supplyDetails; // OneOrMore

	public ProductSupply()
	{}

	public ProductSupply(org.w3c.dom.Element element)
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
				if (name.equals(Market.refname) || name.equals(Market.shortname))
					markets = JPU.addToList(markets, new Market(element));
				else if (name.equals(MarketPublishingDetail.refname) || name.equals(MarketPublishingDetail.shortname))
					marketPublishingDetail = new MarketPublishingDetail(element);
				else if (name.equals(SupplyDetail.refname) || name.equals(SupplyDetail.shortname))
					supplyDetails = JPU.addToList(supplyDetails, new SupplyDetail(element));
			}
		});
	}
}
