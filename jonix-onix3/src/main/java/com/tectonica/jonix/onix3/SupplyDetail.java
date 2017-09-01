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
import java.util.Collections;
import java.util.List;

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.ReturnsConditionsCodeTypes;
import com.tectonica.jonix.codelist.SupplierOwnCodeTypes;
import com.tectonica.jonix.codelist.SupplyDateRoles;
import com.tectonica.jonix.struct.JonixReturnsConditions;
import com.tectonica.jonix.struct.JonixSupplierOwnCoding;
import com.tectonica.jonix.struct.JonixSupplyDate;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Supply detail composite</h1>
 * <p>
 * A group of data elements which together give details of a supply source, and price and availability from that source.
 * Mandatory in each occurrence of the &lt;ProductSupply&gt; block and repeatable.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;SupplyDetail&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;supplydetail&gt;</td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>1&#8230;n</td>
 * </tr>
 * </table>
 */
public class SupplyDetail implements OnixSuperComposite, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "SupplyDetail";
	public static final String shortname = "supplydetail";

	/////////////////////////////////////////////////////////////////////////////////
	// ATTRIBUTES
	/////////////////////////////////////////////////////////////////////////////////

	/**
	 * (type: dt.DateOrDateTime)
	 */
	public String datestamp;

	public RecordSourceTypes sourcetype;

	public String sourcename;

	/////////////////////////////////////////////////////////////////////////////////
	// CONSTRUCTION
	/////////////////////////////////////////////////////////////////////////////////

	private boolean initialized;
	private final boolean exists;
	private final org.w3c.dom.Element element;
	public static final SupplyDetail EMPTY = new SupplyDetail();

	public SupplyDetail()
	{
		exists = false;
		element = null;
		initialized = true; // so that no further processing will be done on this intentionally-empty object
	}

	public SupplyDetail(org.w3c.dom.Element element)
	{
		exists = true;
		initialized = false;
		this.element = element;
	}

	private void initialize()
	{
		if (initialized)
			return;
		initialized = true;

		datestamp = JPU.getAttribute(element, "datestamp");
		sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
		sourcename = JPU.getAttribute(element, "sourcename");

		JPU.forElementsOf(element, e -> {
			final String name = e.getNodeName();
			if (name.equals(Supplier.refname) || name.equals(Supplier.shortname))
				supplier = new Supplier(e);
			else if (name.equals(SupplierOwnCoding.refname) || name.equals(SupplierOwnCoding.shortname))
				supplierOwnCodings = JPU.addToList(supplierOwnCodings, new SupplierOwnCoding(e));
			else if (name.equals(ReturnsConditions.refname) || name.equals(ReturnsConditions.shortname))
				returnsConditionss = JPU.addToList(returnsConditionss, new ReturnsConditions(e));
			else if (name.equals(ProductAvailability.refname) || name.equals(ProductAvailability.shortname))
				productAvailability = new ProductAvailability(e);
			else if (name.equals(SupplyDate.refname) || name.equals(SupplyDate.shortname))
				supplyDates = JPU.addToList(supplyDates, new SupplyDate(e));
			else if (name.equals(OrderTime.refname) || name.equals(OrderTime.shortname))
				orderTime = new OrderTime(e);
			else if (name.equals(NewSupplier.refname) || name.equals(NewSupplier.shortname))
				newSupplier = new NewSupplier(e);
			else if (name.equals(Stock.refname) || name.equals(Stock.shortname))
				stocks = JPU.addToList(stocks, new Stock(e));
			else if (name.equals(PackQuantity.refname) || name.equals(PackQuantity.shortname))
				packQuantity = new PackQuantity(e);
			else if (name.equals(UnpricedItemType.refname) || name.equals(UnpricedItemType.shortname))
				unpricedItemType = new UnpricedItemType(e);
			else if (name.equals(Price.refname) || name.equals(Price.shortname))
				prices = JPU.addToList(prices, new Price(e));
			else if (name.equals(Reissue.refname) || name.equals(Reissue.shortname))
				reissue = new Reissue(e);
		});
	}

	@Override
	public boolean exists()
	{
		return exists;
	}

	/////////////////////////////////////////////////////////////////////////////////
	// MEMBERS
	/////////////////////////////////////////////////////////////////////////////////

	private Supplier supplier = Supplier.EMPTY;

	/**
	 * (this field is required)
	 */
	public Supplier supplier()
	{
		initialize();
		return supplier;
	}

	private ListOfOnixDataCompositeWithKey<SupplierOwnCoding, JonixSupplierOwnCoding, SupplierOwnCodeTypes> supplierOwnCodings = ListOfOnixDataCompositeWithKey
			.emptyKeyed();

	/**
	 * (this list may be empty)
	 */
	public ListOfOnixDataCompositeWithKey<SupplierOwnCoding, JonixSupplierOwnCoding, SupplierOwnCodeTypes> supplierOwnCodings()
	{
		initialize();
		return supplierOwnCodings;
	}

	private ListOfOnixDataCompositeWithKey<ReturnsConditions, JonixReturnsConditions, ReturnsConditionsCodeTypes> returnsConditionss = ListOfOnixDataCompositeWithKey
			.emptyKeyed();

	/**
	 * (this list may be empty)
	 */
	public ListOfOnixDataCompositeWithKey<ReturnsConditions, JonixReturnsConditions, ReturnsConditionsCodeTypes> returnsConditionss()
	{
		initialize();
		return returnsConditionss;
	}

	private ProductAvailability productAvailability = ProductAvailability.EMPTY;

	/**
	 * (this field is required)
	 */
	public ProductAvailability productAvailability()
	{
		initialize();
		return productAvailability;
	}

	private ListOfOnixDataCompositeWithKey<SupplyDate, JonixSupplyDate, SupplyDateRoles> supplyDates = ListOfOnixDataCompositeWithKey
			.emptyKeyed();

	/**
	 * (this list may be empty)
	 */
	public ListOfOnixDataCompositeWithKey<SupplyDate, JonixSupplyDate, SupplyDateRoles> supplyDates()
	{
		initialize();
		return supplyDates;
	}

	private OrderTime orderTime = OrderTime.EMPTY;

	/**
	 * (this field is optional)
	 */
	public OrderTime orderTime()
	{
		initialize();
		return orderTime;
	}

	private NewSupplier newSupplier = NewSupplier.EMPTY;

	/**
	 * (this field is optional)
	 */
	public NewSupplier newSupplier()
	{
		initialize();
		return newSupplier;
	}

	private List<Stock> stocks = Collections.emptyList();

	/**
	 * (this list may be empty)
	 */
	public List<Stock> stocks()
	{
		initialize();
		return stocks;
	}

	private PackQuantity packQuantity = PackQuantity.EMPTY;

	/**
	 * (this field is optional)
	 */
	public PackQuantity packQuantity()
	{
		initialize();
		return packQuantity;
	}

	private UnpricedItemType unpricedItemType = UnpricedItemType.EMPTY;

	/**
	 * (this field is optional)
	 */
	public UnpricedItemType unpricedItemType()
	{
		initialize();
		return unpricedItemType;
	}

	private List<Price> prices = Collections.emptyList();

	/**
	 * (this list may be empty)
	 */
	public List<Price> prices()
	{
		initialize();
		return prices;
	}

	private Reissue reissue = Reissue.EMPTY;

	/**
	 * (this field is optional)
	 */
	public Reissue reissue()
	{
		initialize();
		return reissue;
	}
}
