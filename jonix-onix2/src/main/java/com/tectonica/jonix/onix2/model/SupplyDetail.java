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

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

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
				if (name.equals(SupplierIdentifier.refname) || name.equals(SupplierIdentifier.shortname))
					x.supplierIdentifiers = DU.addToList(x.supplierIdentifiers, SupplierIdentifier.fromDoc(element));
				else if (name.equals(SupplierSAN.refname) || name.equals(SupplierSAN.shortname))
					x.supplierSAN = SupplierSAN.fromDoc(element);
				else if (name.equals(SupplierEANLocationNumber.refname) || name.equals(SupplierEANLocationNumber.shortname))
					x.supplierEANLocationNumber = SupplierEANLocationNumber.fromDoc(element);
				else if (name.equals(SupplierName.refname) || name.equals(SupplierName.shortname))
					x.supplierName = SupplierName.fromDoc(element);
				else if (name.equals(TelephoneNumber.refname) || name.equals(TelephoneNumber.shortname))
					x.telephoneNumbers = DU.addToList(x.telephoneNumbers, TelephoneNumber.fromDoc(element));
				else if (name.equals(FaxNumber.refname) || name.equals(FaxNumber.shortname))
					x.faxNumbers = DU.addToList(x.faxNumbers, FaxNumber.fromDoc(element));
				else if (name.equals(EmailAddress.refname) || name.equals(EmailAddress.shortname))
					x.emailAddresss = DU.addToList(x.emailAddresss, EmailAddress.fromDoc(element));
				else if (name.equals(Website.refname) || name.equals(Website.shortname))
					x.websites = DU.addToList(x.websites, Website.fromDoc(element));
				else if (name.equals(SupplierRole.refname) || name.equals(SupplierRole.shortname))
					x.supplierRole = SupplierRole.fromDoc(element);
				else if (name.equals(SupplyToCountry.refname) || name.equals(SupplyToCountry.shortname))
					x.supplyToCountrys = DU.addToList(x.supplyToCountrys, SupplyToCountry.fromDoc(element));
				else if (name.equals(SupplyToTerritory.refname) || name.equals(SupplyToTerritory.shortname))
					x.supplyToTerritory = SupplyToTerritory.fromDoc(element);
				else if (name.equals(SupplyToRegion.refname) || name.equals(SupplyToRegion.shortname))
					x.supplyToRegions = DU.addToList(x.supplyToRegions, SupplyToRegion.fromDoc(element));
				else if (name.equals(SupplyToCountryExcluded.refname) || name.equals(SupplyToCountryExcluded.shortname))
					x.supplyToCountryExcludeds = DU.addToList(x.supplyToCountryExcludeds, SupplyToCountryExcluded.fromDoc(element));
				else if (name.equals(SupplyRestrictionDetail.refname) || name.equals(SupplyRestrictionDetail.shortname))
					x.supplyRestrictionDetail = SupplyRestrictionDetail.fromDoc(element);
				else if (name.equals(ReturnsCodeType.refname) || name.equals(ReturnsCodeType.shortname))
					x.returnsCodeType = ReturnsCodeType.fromDoc(element);
				else if (name.equals(ReturnsCode.refname) || name.equals(ReturnsCode.shortname))
					x.returnsCode = ReturnsCode.fromDoc(element);
				else if (name.equals(LastDateForReturns.refname) || name.equals(LastDateForReturns.shortname))
					x.lastDateForReturns = LastDateForReturns.fromDoc(element);
				else if (name.equals(AvailabilityCode.refname) || name.equals(AvailabilityCode.shortname))
					x.availabilityCode = AvailabilityCode.fromDoc(element);
				else if (name.equals(ProductAvailability.refname) || name.equals(ProductAvailability.shortname))
					x.productAvailability = ProductAvailability.fromDoc(element);
				else if (name.equals(IntermediaryAvailabilityCode.refname) || name.equals(IntermediaryAvailabilityCode.shortname))
					x.intermediaryAvailabilityCode = IntermediaryAvailabilityCode.fromDoc(element);
				else if (name.equals(NewSupplier.refname) || name.equals(NewSupplier.shortname))
					x.newSupplier = NewSupplier.fromDoc(element);
				else if (name.equals(DateFormat.refname) || name.equals(DateFormat.shortname))
					x.dateFormat = DateFormat.fromDoc(element);
				else if (name.equals(ExpectedShipDate.refname) || name.equals(ExpectedShipDate.shortname))
					x.expectedShipDate = ExpectedShipDate.fromDoc(element);
				else if (name.equals(OnSaleDate.refname) || name.equals(OnSaleDate.shortname))
					x.onSaleDate = OnSaleDate.fromDoc(element);
				else if (name.equals(OrderTime.refname) || name.equals(OrderTime.shortname))
					x.orderTime = OrderTime.fromDoc(element);
				else if (name.equals(Stock.refname) || name.equals(Stock.shortname))
					x.stocks = DU.addToList(x.stocks, Stock.fromDoc(element));
				else if (name.equals(PackQuantity.refname) || name.equals(PackQuantity.shortname))
					x.packQuantity = PackQuantity.fromDoc(element);
				else if (name.equals(AudienceRestrictionFlag.refname) || name.equals(AudienceRestrictionFlag.shortname))
					x.audienceRestrictionFlag = AudienceRestrictionFlag.fromDoc(element);
				else if (name.equals(AudienceRestrictionNote.refname) || name.equals(AudienceRestrictionNote.shortname))
					x.audienceRestrictionNote = AudienceRestrictionNote.fromDoc(element);
				else if (name.equals(PriceAmount.refname) || name.equals(PriceAmount.shortname))
					x.priceAmount = PriceAmount.fromDoc(element);
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
}
