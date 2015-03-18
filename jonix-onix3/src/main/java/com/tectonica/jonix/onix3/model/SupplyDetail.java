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

package com.tectonica.jonix.onix3.model;

import java.util.List;

import com.tectonica.jonix.onix3.DU;
import com.tectonica.jonix.onix3.codelist.List3;

public class SupplyDetail
{
	public static final String refname = "SupplyDetail";
	public static final String shortname = "supplydetail";

	public String datestamp; // dt.DateOrDateTime
	public List3 sourcetype;
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

	public static SupplyDetail fromDoc(org.w3c.dom.Element element)
	{
		final SupplyDetail x = new SupplyDetail();

		x.datestamp = DU.getAttribute(element, "datestamp");
		x.sourcetype = List3.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		DU.forElementsOf(element, new DU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equalsIgnoreCase(Supplier.refname) || name.equalsIgnoreCase(Supplier.shortname))
					x.supplier = Supplier.fromDoc(element);
				else if (name.equalsIgnoreCase(SupplierOwnCoding.refname) || name.equalsIgnoreCase(SupplierOwnCoding.shortname))
					x.supplierOwnCodings = DU.addToList(x.supplierOwnCodings, SupplierOwnCoding.fromDoc(element));
				else if (name.equalsIgnoreCase(ReturnsConditions.refname) || name.equalsIgnoreCase(ReturnsConditions.shortname))
					x.returnsConditionss = DU.addToList(x.returnsConditionss, ReturnsConditions.fromDoc(element));
				else if (name.equalsIgnoreCase(ProductAvailability.refname) || name.equalsIgnoreCase(ProductAvailability.shortname))
					x.productAvailability = ProductAvailability.fromDoc(element);
				else if (name.equalsIgnoreCase(SupplyDate.refname) || name.equalsIgnoreCase(SupplyDate.shortname))
					x.supplyDates = DU.addToList(x.supplyDates, SupplyDate.fromDoc(element));
				else if (name.equalsIgnoreCase(OrderTime.refname) || name.equalsIgnoreCase(OrderTime.shortname))
					x.orderTime = OrderTime.fromDoc(element);
				else if (name.equalsIgnoreCase(NewSupplier.refname) || name.equalsIgnoreCase(NewSupplier.shortname))
					x.newSupplier = NewSupplier.fromDoc(element);
				else if (name.equalsIgnoreCase(Stock.refname) || name.equalsIgnoreCase(Stock.shortname))
					x.stocks = DU.addToList(x.stocks, Stock.fromDoc(element));
				else if (name.equalsIgnoreCase(PackQuantity.refname) || name.equalsIgnoreCase(PackQuantity.shortname))
					x.packQuantity = PackQuantity.fromDoc(element);
				else if (name.equalsIgnoreCase(UnpricedItemType.refname) || name.equalsIgnoreCase(UnpricedItemType.shortname))
					x.unpricedItemType = UnpricedItemType.fromDoc(element);
				else if (name.equalsIgnoreCase(Price.refname) || name.equalsIgnoreCase(Price.shortname))
					x.prices = DU.addToList(x.prices, Price.fromDoc(element));
				else if (name.equalsIgnoreCase(Reissue.refname) || name.equalsIgnoreCase(Reissue.shortname))
					x.reissue = Reissue.fromDoc(element);
			}
		});

		return x;
	}
}
