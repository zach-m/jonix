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

package com.tectonica.jonix.onix2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.codelist.AudienceRestrictionFlags;
import com.tectonica.jonix.codelist.AvailabilityStatuss;
import com.tectonica.jonix.codelist.CountryCodes;
import com.tectonica.jonix.codelist.DateFormats;
import com.tectonica.jonix.codelist.LanguageCodes;
import com.tectonica.jonix.codelist.ProductAvailabilitys;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.Regions;
import com.tectonica.jonix.codelist.ReturnsConditionsCodeTypes;
import com.tectonica.jonix.codelist.SupplierIdentifierTypes;
import com.tectonica.jonix.codelist.SupplierRoles;
import com.tectonica.jonix.codelist.SupplytoRegions;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;
import com.tectonica.jonix.codelist.UnpricedItemTypes;
import com.tectonica.jonix.struct.JonixSupplierIdentifier;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <h1>Supplier and trade data composite</h1>
 * <p>
 * A repeatable group of data elements which together give details of a trade supply source and the product price and
 * availability from that source.
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
 * </table>
 */
public class SupplyDetail implements OnixSuperComposite, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "SupplyDetail";
	public static final String shortname = "supplydetail";

	// ///////////////////////////////////////////////////////////////////////////////
	// ATTRIBUTES
	// ///////////////////////////////////////////////////////////////////////////////

	public TextFormats textformat;

	public TextCaseFlags textcase;

	public LanguageCodes language;

	public TransliterationSchemes transliteration;

	/**
	 * (type: DateOrDateTime)
	 */
	public String datestamp;

	public RecordSourceTypes sourcetype;

	public String sourcename;

	// ///////////////////////////////////////////////////////////////////////////////
	// MEMBERS
	// ///////////////////////////////////////////////////////////////////////////////

	/**
	 * (this list may be empty)
	 */
	public List<SupplierIdentifier> supplierIdentifiers;

	/**
	 * (this field is optional)
	 */
	public SupplierSAN supplierSAN;

	/**
	 * (this field is required)
	 */
	public SupplierEANLocationNumber supplierEANLocationNumber;

	/**
	 * (this field is optional)
	 */
	public SupplierName supplierName;

	/**
	 * (this list may be empty)
	 */
	public List<TelephoneNumber> telephoneNumbers;

	/**
	 * (this list may be empty)
	 */
	public List<FaxNumber> faxNumbers;

	/**
	 * (this list may be empty)
	 */
	public List<EmailAddress> emailAddresss;

	/**
	 * (this list may be empty)
	 */
	public List<Website> websites;

	/**
	 * (this field is optional)
	 */
	public SupplierRole supplierRole;

	/**
	 * (this list is required to contain at least one item)
	 */
	public List<SupplyToCountry> supplyToCountrys;

	/**
	 * (this field is optional)
	 */
	public SupplyToTerritory supplyToTerritory;

	/**
	 * (this list may be empty)
	 */
	public List<SupplyToRegion> supplyToRegions;

	/**
	 * (this list may be empty)
	 */
	public List<SupplyToCountryExcluded> supplyToCountryExcludeds;

	/**
	 * (this field is optional)
	 */
	public SupplyRestrictionDetail supplyRestrictionDetail;

	/**
	 * (this field is optional)
	 */
	public ReturnsCodeType returnsCodeType;

	/**
	 * (this field is optional)
	 */
	public ReturnsCode returnsCode;

	/**
	 * (this field is optional)
	 */
	public LastDateForReturns lastDateForReturns;

	/**
	 * (this field is required)
	 */
	public AvailabilityCode availabilityCode;

	/**
	 * (this field is optional)
	 */
	public ProductAvailability productAvailability;

	/**
	 * (this field is optional)
	 */
	public IntermediaryAvailabilityCode intermediaryAvailabilityCode;

	/**
	 * (this field is optional)
	 */
	public NewSupplier newSupplier;

	/**
	 * (this field is optional)
	 */
	public DateFormat dateFormat;

	/**
	 * (this field is optional)
	 */
	public ExpectedShipDate expectedShipDate;

	/**
	 * (this field is optional)
	 */
	public OnSaleDate onSaleDate;

	/**
	 * (this field is optional)
	 */
	public OrderTime orderTime;

	/**
	 * (this list may be empty)
	 */
	public List<Stock> stocks;

	/**
	 * (this field is optional)
	 */
	public PackQuantity packQuantity;

	/**
	 * (this field is optional)
	 */
	public AudienceRestrictionFlag audienceRestrictionFlag;

	/**
	 * (this field is optional)
	 */
	public AudienceRestrictionNote audienceRestrictionNote;

	/**
	 * (this field is optional)
	 */
	public PriceAmount priceAmount;

	/**
	 * (this field is optional)
	 */
	public UnpricedItemType unpricedItemType;

	/**
	 * (this list may be empty)
	 */
	public List<Price> prices;

	/**
	 * (this field is optional)
	 */
	public Reissue reissue;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public SupplyDetail()
	{}

	public SupplyDetail(org.w3c.dom.Element element)
	{
		textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));
		textcase = TextCaseFlags.byCode(JPU.getAttribute(element, "textcase"));
		language = LanguageCodes.byCode(JPU.getAttribute(element, "language"));
		transliteration = TransliterationSchemes.byCode(JPU.getAttribute(element, "transliteration"));
		datestamp = JPU.getAttribute(element, "datestamp");
		sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
		sourcename = JPU.getAttribute(element, "sourcename");

		JPU.forElementsOf(element, new JPU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(SupplierIdentifier.refname) || name.equals(SupplierIdentifier.shortname))
					supplierIdentifiers = JPU.addToList(supplierIdentifiers, new SupplierIdentifier(element));
				else if (name.equals(SupplierSAN.refname) || name.equals(SupplierSAN.shortname))
					supplierSAN = new SupplierSAN(element);
				else if (name.equals(SupplierEANLocationNumber.refname)
						|| name.equals(SupplierEANLocationNumber.shortname))
					supplierEANLocationNumber = new SupplierEANLocationNumber(element);
				else if (name.equals(SupplierName.refname) || name.equals(SupplierName.shortname))
					supplierName = new SupplierName(element);
				else if (name.equals(TelephoneNumber.refname) || name.equals(TelephoneNumber.shortname))
					telephoneNumbers = JPU.addToList(telephoneNumbers, new TelephoneNumber(element));
				else if (name.equals(FaxNumber.refname) || name.equals(FaxNumber.shortname))
					faxNumbers = JPU.addToList(faxNumbers, new FaxNumber(element));
				else if (name.equals(EmailAddress.refname) || name.equals(EmailAddress.shortname))
					emailAddresss = JPU.addToList(emailAddresss, new EmailAddress(element));
				else if (name.equals(Website.refname) || name.equals(Website.shortname))
					websites = JPU.addToList(websites, new Website(element));
				else if (name.equals(SupplierRole.refname) || name.equals(SupplierRole.shortname))
					supplierRole = new SupplierRole(element);
				else if (name.equals(SupplyToCountry.refname) || name.equals(SupplyToCountry.shortname))
					supplyToCountrys = JPU.addToList(supplyToCountrys, new SupplyToCountry(element));
				else if (name.equals(SupplyToTerritory.refname) || name.equals(SupplyToTerritory.shortname))
					supplyToTerritory = new SupplyToTerritory(element);
				else if (name.equals(SupplyToRegion.refname) || name.equals(SupplyToRegion.shortname))
					supplyToRegions = JPU.addToList(supplyToRegions, new SupplyToRegion(element));
				else if (name.equals(SupplyToCountryExcluded.refname) || name.equals(SupplyToCountryExcluded.shortname))
					supplyToCountryExcludeds = JPU.addToList(supplyToCountryExcludeds, new SupplyToCountryExcluded(
							element));
				else if (name.equals(SupplyRestrictionDetail.refname) || name.equals(SupplyRestrictionDetail.shortname))
					supplyRestrictionDetail = new SupplyRestrictionDetail(element);
				else if (name.equals(ReturnsCodeType.refname) || name.equals(ReturnsCodeType.shortname))
					returnsCodeType = new ReturnsCodeType(element);
				else if (name.equals(ReturnsCode.refname) || name.equals(ReturnsCode.shortname))
					returnsCode = new ReturnsCode(element);
				else if (name.equals(LastDateForReturns.refname) || name.equals(LastDateForReturns.shortname))
					lastDateForReturns = new LastDateForReturns(element);
				else if (name.equals(AvailabilityCode.refname) || name.equals(AvailabilityCode.shortname))
					availabilityCode = new AvailabilityCode(element);
				else if (name.equals(ProductAvailability.refname) || name.equals(ProductAvailability.shortname))
					productAvailability = new ProductAvailability(element);
				else if (name.equals(IntermediaryAvailabilityCode.refname)
						|| name.equals(IntermediaryAvailabilityCode.shortname))
					intermediaryAvailabilityCode = new IntermediaryAvailabilityCode(element);
				else if (name.equals(NewSupplier.refname) || name.equals(NewSupplier.shortname))
					newSupplier = new NewSupplier(element);
				else if (name.equals(DateFormat.refname) || name.equals(DateFormat.shortname))
					dateFormat = new DateFormat(element);
				else if (name.equals(ExpectedShipDate.refname) || name.equals(ExpectedShipDate.shortname))
					expectedShipDate = new ExpectedShipDate(element);
				else if (name.equals(OnSaleDate.refname) || name.equals(OnSaleDate.shortname))
					onSaleDate = new OnSaleDate(element);
				else if (name.equals(OrderTime.refname) || name.equals(OrderTime.shortname))
					orderTime = new OrderTime(element);
				else if (name.equals(Stock.refname) || name.equals(Stock.shortname))
					stocks = JPU.addToList(stocks, new Stock(element));
				else if (name.equals(PackQuantity.refname) || name.equals(PackQuantity.shortname))
					packQuantity = new PackQuantity(element);
				else if (name.equals(AudienceRestrictionFlag.refname) || name.equals(AudienceRestrictionFlag.shortname))
					audienceRestrictionFlag = new AudienceRestrictionFlag(element);
				else if (name.equals(AudienceRestrictionNote.refname) || name.equals(AudienceRestrictionNote.shortname))
					audienceRestrictionNote = new AudienceRestrictionNote(element);
				else if (name.equals(PriceAmount.refname) || name.equals(PriceAmount.shortname))
					priceAmount = new PriceAmount(element);
				else if (name.equals(UnpricedItemType.refname) || name.equals(UnpricedItemType.shortname))
					unpricedItemType = new UnpricedItemType(element);
				else if (name.equals(Price.refname) || name.equals(Price.shortname))
					prices = JPU.addToList(prices, new Price(element));
				else if (name.equals(Reissue.refname) || name.equals(Reissue.shortname))
					reissue = new Reissue(element);
			}
		});
	}

	/**
	 * Raw Format: Fixed-length, seven characters. The first six are numeric digits, and the seventh is a check
	 * character which may be a numeric digit or letter X.
	 */
	public String getSupplierSANValue()
	{
		return (supplierSAN == null) ? null : supplierSAN.value;
	}

	/**
	 * Raw Format: Fixed-length, thirteen numeric digits, of which the last is a check digit.
	 */
	public String getSupplierEANLocationNumberValue()
	{
		return (supplierEANLocationNumber == null) ? null : supplierEANLocationNumber.value;
	}

	/**
	 * Raw Format: Variable-length text, suggested maximum length 100 characters
	 */
	public String getSupplierNameValue()
	{
		return (supplierName == null) ? null : supplierName.value;
	}

	/**
	 * Raw Format: Variable-length text, suggested maximum length 20 characters
	 */
	public List<String> getTelephoneNumberValues()
	{
		if (telephoneNumbers != null)
		{
			List<String> list = new ArrayList<>();
			for (TelephoneNumber i : telephoneNumbers)
				list.add(i.value);
			return list;
		}
		return null;
	}

	/**
	 * Raw Format: Variable-length text, suggested maximum length 20 characters
	 */
	public List<String> getFaxNumberValues()
	{
		if (faxNumbers != null)
		{
			List<String> list = new ArrayList<>();
			for (FaxNumber i : faxNumbers)
				list.add(i.value);
			return list;
		}
		return null;
	}

	/**
	 * Raw Format: Variable-length text, suggested maximum length 100 characters
	 */
	public List<String> getEmailAddressValues()
	{
		if (emailAddresss != null)
		{
			List<String> list = new ArrayList<>();
			for (EmailAddress i : emailAddresss)
				list.add(i.value);
			return list;
		}
		return null;
	}

	public SupplierRoles getSupplierRoleValue()
	{
		return (supplierRole == null) ? null : supplierRole.value;
	}

	public List<java.util.Set<CountryCodes>> getSupplyToCountrySets()
	{
		if (supplyToCountrys != null)
		{
			List<java.util.Set<CountryCodes>> list = new ArrayList<>();
			for (SupplyToCountry i : supplyToCountrys)
				list.add(i.value);
			return list;
		}
		return null;
	}

	public java.util.Set<Regions> getSupplyToTerritorySet()
	{
		return (supplyToTerritory == null) ? null : supplyToTerritory.value;
	}

	public List<SupplytoRegions> getSupplyToRegionValues()
	{
		if (supplyToRegions != null)
		{
			List<SupplytoRegions> list = new ArrayList<>();
			for (SupplyToRegion i : supplyToRegions)
				list.add(i.value);
			return list;
		}
		return null;
	}

	public List<java.util.Set<CountryCodes>> getSupplyToCountryExcludedSets()
	{
		if (supplyToCountryExcludeds != null)
		{
			List<java.util.Set<CountryCodes>> list = new ArrayList<>();
			for (SupplyToCountryExcluded i : supplyToCountryExcludeds)
				list.add(i.value);
			return list;
		}
		return null;
	}

	/**
	 * Raw Format: Variable-length text, suggested maximum length 300 characters
	 */
	public String getSupplyRestrictionDetailValue()
	{
		return (supplyRestrictionDetail == null) ? null : supplyRestrictionDetail.value;
	}

	public ReturnsConditionsCodeTypes getReturnsCodeTypeValue()
	{
		return (returnsCodeType == null) ? null : returnsCodeType.value;
	}

	/**
	 * Raw Format: According to the scheme specified in &lt;ReturnsCodeType&gt;: for values defined by BISAC for US use,
	 * see List 66
	 */
	public String getReturnsCodeValue()
	{
		return (returnsCode == null) ? null : returnsCode.value;
	}

	/**
	 * Raw Format: Date as year, month, day (YYYYMMDD)
	 */
	public String getLastDateForReturnsValue()
	{
		return (lastDateForReturns == null) ? null : lastDateForReturns.value;
	}

	public AvailabilityStatuss getAvailabilityCodeValue()
	{
		return (availabilityCode == null) ? null : availabilityCode.value;
	}

	public ProductAvailabilitys getProductAvailabilityValue()
	{
		return (productAvailability == null) ? null : productAvailability.value;
	}

	/**
	 * Raw Format: Fixed-length, two numeric digits
	 */
	public String getIntermediaryAvailabilityCodeValue()
	{
		return (intermediaryAvailabilityCode == null) ? null : intermediaryAvailabilityCode.value;
	}

	public DateFormats getDateFormatValue()
	{
		return (dateFormat == null) ? null : dateFormat.value;
	}

	/**
	 * Raw Format: Date as year, month, day (YYYYMMDD) or as specified in &lt;DateFormat&gt;
	 */
	public String getExpectedShipDateValue()
	{
		return (expectedShipDate == null) ? null : expectedShipDate.value;
	}

	/**
	 * Raw Format: Date as year, month, day (YYYYMMDD)
	 */
	public String getOnSaleDateValue()
	{
		return (onSaleDate == null) ? null : onSaleDate.value;
	}

	/**
	 * Raw Format: Variable-length integer, one or two digits only
	 */
	public String getOrderTimeValue()
	{
		return (orderTime == null) ? null : orderTime.value;
	}

	/**
	 * Raw Format: Variable-length integer, suggested maximum length four digits
	 */
	public String getPackQuantityValue()
	{
		return (packQuantity == null) ? null : packQuantity.value;
	}

	public AudienceRestrictionFlags getAudienceRestrictionFlagValue()
	{
		return (audienceRestrictionFlag == null) ? null : audienceRestrictionFlag.value;
	}

	/**
	 * Raw Format: Variable-length text, maximum 300 characters
	 */
	public String getAudienceRestrictionNoteValue()
	{
		return (audienceRestrictionNote == null) ? null : audienceRestrictionNote.value;
	}

	/**
	 * Raw Format: Variable length real number, with explicit decimal point when required, suggested maximum length 12
	 * characters
	 */
	public String getPriceAmountValue()
	{
		return (priceAmount == null) ? null : priceAmount.value;
	}

	public UnpricedItemTypes getUnpricedItemTypeValue()
	{
		return (unpricedItemType == null) ? null : unpricedItemType.value;
	}

	public JonixSupplierIdentifier findSupplierIdentifier(SupplierIdentifierTypes supplierIDType)
	{
		if (supplierIdentifiers != null)
		{
			for (SupplierIdentifier x : supplierIdentifiers)
			{
				if (x.getSupplierIDTypeValue() == supplierIDType)
					return x.asJonixSupplierIdentifier();
			}
		}
		return null;
	}

	public List<JonixSupplierIdentifier> findSupplierIdentifiers(java.util.Set<SupplierIdentifierTypes> supplierIDTypes)
	{
		if (supplierIdentifiers != null)
		{
			List<JonixSupplierIdentifier> matches = new ArrayList<>();
			for (SupplierIdentifier x : supplierIdentifiers)
			{
				if (supplierIDTypes == null || supplierIDTypes.contains(x.getSupplierIDTypeValue()))
					matches.add(x.asJonixSupplierIdentifier());
			}
			return matches;
		}
		return null;
	}
}
