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

public class SupplyDetail
{
	public static final String refname = "SupplyDetail";
	public static final String shortname = "supplydetail";

	public List34 textformat;
	public List14 textcase;
	public List74 language;
	public List138 transliteration;
	public String datestamp; // DateOrDateTime
	public List3 sourcetype;
	public String sourcename;

	public List<SupplierIdentifier> supplierIdentifiers; // ZeroOrMore
	public SupplierSAN supplierSAN; // Optional
	public SupplierEANLocationNumber supplierEANLocationNumber; // Required
	public SupplierName supplierName; // Optional
	public List<TelephoneNumber> telephoneNumbers; // ZeroOrMore
	public List<FaxNumber> faxNumbers; // ZeroOrMore
	public List<EmailAddress> emailAddresss; // ZeroOrMore
	public List<Website> websites; // ZeroOrMore
	public SupplierRole supplierRole; // Optional
	public List<SupplyToCountry> supplyToCountrys; // OneOrMore
	public SupplyToTerritory supplyToTerritory; // Optional
	public List<SupplyToRegion> supplyToRegions; // ZeroOrMore
	public List<SupplyToCountryExcluded> supplyToCountryExcludeds; // ZeroOrMore
	public SupplyRestrictionDetail supplyRestrictionDetail; // Optional
	public ReturnsCodeType returnsCodeType; // Optional
	public ReturnsCode returnsCode; // Optional
	public LastDateForReturns lastDateForReturns; // Optional
	public AvailabilityCode availabilityCode; // Required
	public ProductAvailability productAvailability; // Optional
	public IntermediaryAvailabilityCode intermediaryAvailabilityCode; // Optional
	public NewSupplier newSupplier; // Optional
	public DateFormat dateFormat; // Optional
	public ExpectedShipDate expectedShipDate; // Optional
	public OnSaleDate onSaleDate; // Optional
	public OrderTime orderTime; // Optional
	public List<Stock> stocks; // ZeroOrMore
	public PackQuantity packQuantity; // Optional
	public AudienceRestrictionFlag audienceRestrictionFlag; // Optional
	public AudienceRestrictionNote audienceRestrictionNote; // Optional
	public PriceAmount priceAmount; // Optional
	public UnpricedItemType unpricedItemType; // Optional
	public List<Price> prices; // ZeroOrMore
	public Reissue reissue; // Optional

	public static SupplyDetail fromDoc(org.w3c.dom.Element element)
	{
		final SupplyDetail x = new SupplyDetail();

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
				if (name.equalsIgnoreCase(SupplierIdentifier.refname) || name.equalsIgnoreCase(SupplierIdentifier.shortname))
					x.supplierIdentifiers = DU.addToList(x.supplierIdentifiers, SupplierIdentifier.fromDoc(element));
				else if (name.equalsIgnoreCase(SupplierSAN.refname) || name.equalsIgnoreCase(SupplierSAN.shortname))
					x.supplierSAN = SupplierSAN.fromDoc(element);
				else if (name.equalsIgnoreCase(SupplierEANLocationNumber.refname)
						|| name.equalsIgnoreCase(SupplierEANLocationNumber.shortname))
					x.supplierEANLocationNumber = SupplierEANLocationNumber.fromDoc(element);
				else if (name.equalsIgnoreCase(SupplierName.refname) || name.equalsIgnoreCase(SupplierName.shortname))
					x.supplierName = SupplierName.fromDoc(element);
				else if (name.equalsIgnoreCase(TelephoneNumber.refname) || name.equalsIgnoreCase(TelephoneNumber.shortname))
					x.telephoneNumbers = DU.addToList(x.telephoneNumbers, TelephoneNumber.fromDoc(element));
				else if (name.equalsIgnoreCase(FaxNumber.refname) || name.equalsIgnoreCase(FaxNumber.shortname))
					x.faxNumbers = DU.addToList(x.faxNumbers, FaxNumber.fromDoc(element));
				else if (name.equalsIgnoreCase(EmailAddress.refname) || name.equalsIgnoreCase(EmailAddress.shortname))
					x.emailAddresss = DU.addToList(x.emailAddresss, EmailAddress.fromDoc(element));
				else if (name.equalsIgnoreCase(Website.refname) || name.equalsIgnoreCase(Website.shortname))
					x.websites = DU.addToList(x.websites, Website.fromDoc(element));
				else if (name.equalsIgnoreCase(SupplierRole.refname) || name.equalsIgnoreCase(SupplierRole.shortname))
					x.supplierRole = SupplierRole.fromDoc(element);
				else if (name.equalsIgnoreCase(SupplyToCountry.refname) || name.equalsIgnoreCase(SupplyToCountry.shortname))
					x.supplyToCountrys = DU.addToList(x.supplyToCountrys, SupplyToCountry.fromDoc(element));
				else if (name.equalsIgnoreCase(SupplyToTerritory.refname) || name.equalsIgnoreCase(SupplyToTerritory.shortname))
					x.supplyToTerritory = SupplyToTerritory.fromDoc(element);
				else if (name.equalsIgnoreCase(SupplyToRegion.refname) || name.equalsIgnoreCase(SupplyToRegion.shortname))
					x.supplyToRegions = DU.addToList(x.supplyToRegions, SupplyToRegion.fromDoc(element));
				else if (name.equalsIgnoreCase(SupplyToCountryExcluded.refname) || name.equalsIgnoreCase(SupplyToCountryExcluded.shortname))
					x.supplyToCountryExcludeds = DU.addToList(x.supplyToCountryExcludeds, SupplyToCountryExcluded.fromDoc(element));
				else if (name.equalsIgnoreCase(SupplyRestrictionDetail.refname) || name.equalsIgnoreCase(SupplyRestrictionDetail.shortname))
					x.supplyRestrictionDetail = SupplyRestrictionDetail.fromDoc(element);
				else if (name.equalsIgnoreCase(ReturnsCodeType.refname) || name.equalsIgnoreCase(ReturnsCodeType.shortname))
					x.returnsCodeType = ReturnsCodeType.fromDoc(element);
				else if (name.equalsIgnoreCase(ReturnsCode.refname) || name.equalsIgnoreCase(ReturnsCode.shortname))
					x.returnsCode = ReturnsCode.fromDoc(element);
				else if (name.equalsIgnoreCase(LastDateForReturns.refname) || name.equalsIgnoreCase(LastDateForReturns.shortname))
					x.lastDateForReturns = LastDateForReturns.fromDoc(element);
				else if (name.equalsIgnoreCase(AvailabilityCode.refname) || name.equalsIgnoreCase(AvailabilityCode.shortname))
					x.availabilityCode = AvailabilityCode.fromDoc(element);
				else if (name.equalsIgnoreCase(ProductAvailability.refname) || name.equalsIgnoreCase(ProductAvailability.shortname))
					x.productAvailability = ProductAvailability.fromDoc(element);
				else if (name.equalsIgnoreCase(IntermediaryAvailabilityCode.refname)
						|| name.equalsIgnoreCase(IntermediaryAvailabilityCode.shortname))
					x.intermediaryAvailabilityCode = IntermediaryAvailabilityCode.fromDoc(element);
				else if (name.equalsIgnoreCase(NewSupplier.refname) || name.equalsIgnoreCase(NewSupplier.shortname))
					x.newSupplier = NewSupplier.fromDoc(element);
				else if (name.equalsIgnoreCase(DateFormat.refname) || name.equalsIgnoreCase(DateFormat.shortname))
					x.dateFormat = DateFormat.fromDoc(element);
				else if (name.equalsIgnoreCase(ExpectedShipDate.refname) || name.equalsIgnoreCase(ExpectedShipDate.shortname))
					x.expectedShipDate = ExpectedShipDate.fromDoc(element);
				else if (name.equalsIgnoreCase(OnSaleDate.refname) || name.equalsIgnoreCase(OnSaleDate.shortname))
					x.onSaleDate = OnSaleDate.fromDoc(element);
				else if (name.equalsIgnoreCase(OrderTime.refname) || name.equalsIgnoreCase(OrderTime.shortname))
					x.orderTime = OrderTime.fromDoc(element);
				else if (name.equalsIgnoreCase(Stock.refname) || name.equalsIgnoreCase(Stock.shortname))
					x.stocks = DU.addToList(x.stocks, Stock.fromDoc(element));
				else if (name.equalsIgnoreCase(PackQuantity.refname) || name.equalsIgnoreCase(PackQuantity.shortname))
					x.packQuantity = PackQuantity.fromDoc(element);
				else if (name.equalsIgnoreCase(AudienceRestrictionFlag.refname) || name.equalsIgnoreCase(AudienceRestrictionFlag.shortname))
					x.audienceRestrictionFlag = AudienceRestrictionFlag.fromDoc(element);
				else if (name.equalsIgnoreCase(AudienceRestrictionNote.refname) || name.equalsIgnoreCase(AudienceRestrictionNote.shortname))
					x.audienceRestrictionNote = AudienceRestrictionNote.fromDoc(element);
				else if (name.equalsIgnoreCase(PriceAmount.refname) || name.equalsIgnoreCase(PriceAmount.shortname))
					x.priceAmount = PriceAmount.fromDoc(element);
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
