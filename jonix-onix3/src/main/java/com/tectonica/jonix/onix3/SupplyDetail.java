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
import com.tectonica.jonix.codelist.ProductAvailabilitys;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.UnpricedItemTypes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

@SuppressWarnings("serial")
public class SupplyDetail implements Serializable
{
	public static final String refname = "SupplyDetail";
	public static final String shortname = "supplydetail";

	public String datestamp; // dt.DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public Supplier supplier; // Required
	public List<SupplierOwnCoding> supplierOwnCodings; // ZeroOrMore
	public List<ReturnsConditions> returnsConditionss; // ZeroOrMore
	public ProductAvailability productAvailability; // Required
	public List<SupplyDate> supplyDates; // ZeroOrMore
	public OrderTime orderTime; // Optional
	public NewSupplier newSupplier; // Optional
	public List<Stock> stocks; // ZeroOrMore
	public PackQuantity packQuantity; // Optional
	public UnpricedItemType unpricedItemType; // Optional
	public List<Price> prices; // ZeroOrMore
	public Reissue reissue; // Optional

	public SupplyDetail()
	{}

	public SupplyDetail(org.w3c.dom.Element element)
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
				if (name.equals(Supplier.refname) || name.equals(Supplier.shortname))
					supplier = new Supplier(element);
				else if (name.equals(SupplierOwnCoding.refname) || name.equals(SupplierOwnCoding.shortname))
					supplierOwnCodings = JPU.addToList(supplierOwnCodings, new SupplierOwnCoding(element));
				else if (name.equals(ReturnsConditions.refname) || name.equals(ReturnsConditions.shortname))
					returnsConditionss = JPU.addToList(returnsConditionss, new ReturnsConditions(element));
				else if (name.equals(ProductAvailability.refname) || name.equals(ProductAvailability.shortname))
					productAvailability = new ProductAvailability(element);
				else if (name.equals(SupplyDate.refname) || name.equals(SupplyDate.shortname))
					supplyDates = JPU.addToList(supplyDates, new SupplyDate(element));
				else if (name.equals(OrderTime.refname) || name.equals(OrderTime.shortname))
					orderTime = new OrderTime(element);
				else if (name.equals(NewSupplier.refname) || name.equals(NewSupplier.shortname))
					newSupplier = new NewSupplier(element);
				else if (name.equals(Stock.refname) || name.equals(Stock.shortname))
					stocks = JPU.addToList(stocks, new Stock(element));
				else if (name.equals(PackQuantity.refname) || name.equals(PackQuantity.shortname))
					packQuantity = new PackQuantity(element);
				else if (name.equals(UnpricedItemType.refname) || name.equals(UnpricedItemType.shortname))
					unpricedItemType = new UnpricedItemType(element);
				else if (name.equals(Price.refname) || name.equals(Price.shortname))
					prices = JPU.addToList(prices, new Price(element));
				else if (name.equals(Reissue.refname) || name.equals(Reissue.shortname))
					reissue = new Reissue(element);
			}
		});
	}

	public ProductAvailabilitys getProductAvailabilityValue()
	{
		return (productAvailability == null) ? null : productAvailability.value;
	}

	public Integer getOrderTimeValue()
	{
		return (orderTime == null) ? null : orderTime.value;
	}

	public Integer getPackQuantityValue()
	{
		return (packQuantity == null) ? null : packQuantity.value;
	}

	public UnpricedItemTypes getUnpricedItemTypeValue()
	{
		return (unpricedItemType == null) ? null : unpricedItemType.value;
	}
}
