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
import com.tectonica.jonix.OnixComposite;
import com.tectonica.jonix.codelist.ProductAvailabilitys;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.ReturnsConditionsCodeTypes;
import com.tectonica.jonix.codelist.SupplierOwnCodeTypes;
import com.tectonica.jonix.codelist.SupplyDateRoles;
import com.tectonica.jonix.codelist.UnpricedItemTypes;
import com.tectonica.jonix.struct.JonixReturnsConditions;
import com.tectonica.jonix.struct.JonixSupplierOwnCoding;
import com.tectonica.jonix.struct.JonixSupplyDate;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

@SuppressWarnings("serial")
public class SupplyDetail implements OnixComposite, Serializable
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

	public JonixSupplierOwnCoding findSupplierOwnCoding(SupplierOwnCodeTypes supplierCodeType)
	{
		if (supplierOwnCodings != null)
		{
			for (SupplierOwnCoding x : supplierOwnCodings)
			{
				if (x.getSupplierCodeTypeValue() == supplierCodeType)
					return x.asJonixSupplierOwnCoding();
			}
		}
		return null;
	}

	public List<JonixSupplierOwnCoding> findSupplierOwnCodings(java.util.Set<SupplierOwnCodeTypes> supplierCodeTypes)
	{
		if (supplierOwnCodings != null)
		{
			List<JonixSupplierOwnCoding> matches = new ArrayList<>();
			for (SupplierOwnCoding x : supplierOwnCodings)
			{
				if (supplierCodeTypes == null || supplierCodeTypes.contains(x.getSupplierCodeTypeValue()))
					matches.add(x.asJonixSupplierOwnCoding());
			}
			return matches;
		}
		return null;
	}

	public JonixReturnsConditions findReturnsConditions(ReturnsConditionsCodeTypes returnsCodeType)
	{
		if (returnsConditionss != null)
		{
			for (ReturnsConditions x : returnsConditionss)
			{
				if (x.getReturnsCodeTypeValue() == returnsCodeType)
					return x.asJonixReturnsConditions();
			}
		}
		return null;
	}

	public List<JonixReturnsConditions> findReturnsConditionss(java.util.Set<ReturnsConditionsCodeTypes> returnsCodeTypes)
	{
		if (returnsConditionss != null)
		{
			List<JonixReturnsConditions> matches = new ArrayList<>();
			for (ReturnsConditions x : returnsConditionss)
			{
				if (returnsCodeTypes == null || returnsCodeTypes.contains(x.getReturnsCodeTypeValue()))
					matches.add(x.asJonixReturnsConditions());
			}
			return matches;
		}
		return null;
	}

	public JonixSupplyDate findSupplyDate(SupplyDateRoles supplyDateRole)
	{
		if (supplyDates != null)
		{
			for (SupplyDate x : supplyDates)
			{
				if (x.getSupplyDateRoleValue() == supplyDateRole)
					return x.asJonixSupplyDate();
			}
		}
		return null;
	}

	public List<JonixSupplyDate> findSupplyDates(java.util.Set<SupplyDateRoles> supplyDateRoles)
	{
		if (supplyDates != null)
		{
			List<JonixSupplyDate> matches = new ArrayList<>();
			for (SupplyDate x : supplyDates)
			{
				if (supplyDateRoles == null || supplyDateRoles.contains(x.getSupplyDateRoleValue()))
					matches.add(x.asJonixSupplyDate());
			}
			return matches;
		}
		return null;
	}
}
