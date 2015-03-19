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
import com.tectonica.jonix.codelist.ProductAvailabilitys;
import com.tectonica.jonix.codelist.RecordSourceTypeCodes;
import com.tectonica.jonix.codelist.UnpricedItemTypeCodes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

public class SupplyDetail
{
	public static final String refname = "SupplyDetail";
	public static final String shortname = "supplydetail";

	public String datestamp; // dt.DateOrDateTime
	public RecordSourceTypeCodes sourcetype;
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
		x.sourcetype = RecordSourceTypeCodes.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		DU.forElementsOf(element, new DU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(Supplier.refname) || name.equals(Supplier.shortname))
					x.supplier = Supplier.fromDoc(element);
				else if (name.equals(SupplierOwnCoding.refname) || name.equals(SupplierOwnCoding.shortname))
					x.supplierOwnCodings = DU.addToList(x.supplierOwnCodings, SupplierOwnCoding.fromDoc(element));
				else if (name.equals(ReturnsConditions.refname) || name.equals(ReturnsConditions.shortname))
					x.returnsConditionss = DU.addToList(x.returnsConditionss, ReturnsConditions.fromDoc(element));
				else if (name.equals(ProductAvailability.refname) || name.equals(ProductAvailability.shortname))
					x.productAvailability = ProductAvailability.fromDoc(element);
				else if (name.equals(SupplyDate.refname) || name.equals(SupplyDate.shortname))
					x.supplyDates = DU.addToList(x.supplyDates, SupplyDate.fromDoc(element));
				else if (name.equals(OrderTime.refname) || name.equals(OrderTime.shortname))
					x.orderTime = OrderTime.fromDoc(element);
				else if (name.equals(NewSupplier.refname) || name.equals(NewSupplier.shortname))
					x.newSupplier = NewSupplier.fromDoc(element);
				else if (name.equals(Stock.refname) || name.equals(Stock.shortname))
					x.stocks = DU.addToList(x.stocks, Stock.fromDoc(element));
				else if (name.equals(PackQuantity.refname) || name.equals(PackQuantity.shortname))
					x.packQuantity = PackQuantity.fromDoc(element);
				else if (name.equals(UnpricedItemType.refname) || name.equals(UnpricedItemType.shortname))
					x.unpricedItemType = UnpricedItemType.fromDoc(element);
				else if (name.equals(Price.refname) || name.equals(Price.shortname))
					x.prices = DU.addToList(x.prices, Price.fromDoc(element));
				else if (name.equals(Reissue.refname) || name.equals(Reissue.shortname))
					x.reissue = Reissue.fromDoc(element);
			}
		});

		return x;
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

	public UnpricedItemTypeCodes getUnpricedItemTypeValue()
	{
		return (unpricedItemType == null) ? null : unpricedItemType.value;
	}
}
