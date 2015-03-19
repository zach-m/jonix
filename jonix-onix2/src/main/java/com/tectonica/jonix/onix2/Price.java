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

import java.util.ArrayList;
import java.util.List;

import com.tectonica.jonix.DU;
import com.tectonica.jonix.codelist.CountryCodeIso31661s;
import com.tectonica.jonix.codelist.CurrencyCodeIso4217s;
import com.tectonica.jonix.codelist.LanguageCodeIso6392Bs;
import com.tectonica.jonix.codelist.PriceStatuss;
import com.tectonica.jonix.codelist.PriceTypeQualifiers;
import com.tectonica.jonix.codelist.PriceTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.Regions;
import com.tectonica.jonix.codelist.TaxRateCodeds;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;
import com.tectonica.jonix.codelist.UnitOfPricings;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

public class Price
{
	public static final String refname = "Price";
	public static final String shortname = "price";

	public TextFormats textformat;
	public TextCaseFlags textcase;
	public LanguageCodeIso6392Bs language;
	public TransliterationSchemes transliteration;
	public String datestamp; // DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public PriceTypeCode priceTypeCode; // Optional
	public PriceQualifier priceQualifier; // Optional
	public PriceTypeDescription priceTypeDescription; // Optional
	public PricePer pricePer; // Optional
	public MinimumOrderQuantity minimumOrderQuantity; // Optional
	public List<BatchBonus> batchBonuss; // ZeroOrMore
	public ClassOfTrade classOfTrade; // Optional
	public BICDiscountGroupCode bicDiscountGroupCode; // Optional
	public List<DiscountCoded> discountCodeds; // ZeroOrMore
	public DiscountPercent discountPercent; // Optional
	public PriceStatus priceStatus; // Optional
	public PriceAmount priceAmount; // Required
	public CurrencyCode currencyCode; // Optional
	public List<CountryCode> countryCodes; // OneOrMore
	public Territory territory; // Optional
	public CountryExcluded countryExcluded; // Optional
	public TerritoryExcluded territoryExcluded; // Optional
	public TaxRateCode1 taxRateCode1; // Optional
	public TaxRatePercent1 taxRatePercent1; // Optional
	public TaxableAmount1 taxableAmount1; // Optional
	public TaxAmount1 taxAmount1; // Optional
	public TaxRateCode2 taxRateCode2; // Optional
	public TaxRatePercent2 taxRatePercent2; // Optional
	public TaxableAmount2 taxableAmount2; // Optional
	public TaxAmount2 taxAmount2; // Optional
	public PriceEffectiveFrom priceEffectiveFrom; // Optional
	public PriceEffectiveUntil priceEffectiveUntil; // Optional

	public static Price fromDoc(org.w3c.dom.Element element)
	{
		final Price x = new Price();

		x.textformat = TextFormats.byValue(DU.getAttribute(element, "textformat"));
		x.textcase = TextCaseFlags.byValue(DU.getAttribute(element, "textcase"));
		x.language = LanguageCodeIso6392Bs.byValue(DU.getAttribute(element, "language"));
		x.transliteration = TransliterationSchemes.byValue(DU.getAttribute(element, "transliteration"));
		x.datestamp = DU.getAttribute(element, "datestamp");
		x.sourcetype = RecordSourceTypes.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		DU.forElementsOf(element, new DU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(PriceTypeCode.refname) || name.equals(PriceTypeCode.shortname))
					x.priceTypeCode = PriceTypeCode.fromDoc(element);
				else if (name.equals(PriceQualifier.refname) || name.equals(PriceQualifier.shortname))
					x.priceQualifier = PriceQualifier.fromDoc(element);
				else if (name.equals(PriceTypeDescription.refname) || name.equals(PriceTypeDescription.shortname))
					x.priceTypeDescription = PriceTypeDescription.fromDoc(element);
				else if (name.equals(PricePer.refname) || name.equals(PricePer.shortname))
					x.pricePer = PricePer.fromDoc(element);
				else if (name.equals(MinimumOrderQuantity.refname) || name.equals(MinimumOrderQuantity.shortname))
					x.minimumOrderQuantity = MinimumOrderQuantity.fromDoc(element);
				else if (name.equals(BatchBonus.refname) || name.equals(BatchBonus.shortname))
					x.batchBonuss = DU.addToList(x.batchBonuss, BatchBonus.fromDoc(element));
				else if (name.equals(ClassOfTrade.refname) || name.equals(ClassOfTrade.shortname))
					x.classOfTrade = ClassOfTrade.fromDoc(element);
				else if (name.equals(BICDiscountGroupCode.refname) || name.equals(BICDiscountGroupCode.shortname))
					x.bicDiscountGroupCode = BICDiscountGroupCode.fromDoc(element);
				else if (name.equals(DiscountCoded.refname) || name.equals(DiscountCoded.shortname))
					x.discountCodeds = DU.addToList(x.discountCodeds, DiscountCoded.fromDoc(element));
				else if (name.equals(DiscountPercent.refname) || name.equals(DiscountPercent.shortname))
					x.discountPercent = DiscountPercent.fromDoc(element);
				else if (name.equals(PriceStatus.refname) || name.equals(PriceStatus.shortname))
					x.priceStatus = PriceStatus.fromDoc(element);
				else if (name.equals(PriceAmount.refname) || name.equals(PriceAmount.shortname))
					x.priceAmount = PriceAmount.fromDoc(element);
				else if (name.equals(CurrencyCode.refname) || name.equals(CurrencyCode.shortname))
					x.currencyCode = CurrencyCode.fromDoc(element);
				else if (name.equals(CountryCode.refname) || name.equals(CountryCode.shortname))
					x.countryCodes = DU.addToList(x.countryCodes, CountryCode.fromDoc(element));
				else if (name.equals(Territory.refname) || name.equals(Territory.shortname))
					x.territory = Territory.fromDoc(element);
				else if (name.equals(CountryExcluded.refname) || name.equals(CountryExcluded.shortname))
					x.countryExcluded = CountryExcluded.fromDoc(element);
				else if (name.equals(TerritoryExcluded.refname) || name.equals(TerritoryExcluded.shortname))
					x.territoryExcluded = TerritoryExcluded.fromDoc(element);
				else if (name.equals(TaxRateCode1.refname) || name.equals(TaxRateCode1.shortname))
					x.taxRateCode1 = TaxRateCode1.fromDoc(element);
				else if (name.equals(TaxRatePercent1.refname) || name.equals(TaxRatePercent1.shortname))
					x.taxRatePercent1 = TaxRatePercent1.fromDoc(element);
				else if (name.equals(TaxableAmount1.refname) || name.equals(TaxableAmount1.shortname))
					x.taxableAmount1 = TaxableAmount1.fromDoc(element);
				else if (name.equals(TaxAmount1.refname) || name.equals(TaxAmount1.shortname))
					x.taxAmount1 = TaxAmount1.fromDoc(element);
				else if (name.equals(TaxRateCode2.refname) || name.equals(TaxRateCode2.shortname))
					x.taxRateCode2 = TaxRateCode2.fromDoc(element);
				else if (name.equals(TaxRatePercent2.refname) || name.equals(TaxRatePercent2.shortname))
					x.taxRatePercent2 = TaxRatePercent2.fromDoc(element);
				else if (name.equals(TaxableAmount2.refname) || name.equals(TaxableAmount2.shortname))
					x.taxableAmount2 = TaxableAmount2.fromDoc(element);
				else if (name.equals(TaxAmount2.refname) || name.equals(TaxAmount2.shortname))
					x.taxAmount2 = TaxAmount2.fromDoc(element);
				else if (name.equals(PriceEffectiveFrom.refname) || name.equals(PriceEffectiveFrom.shortname))
					x.priceEffectiveFrom = PriceEffectiveFrom.fromDoc(element);
				else if (name.equals(PriceEffectiveUntil.refname) || name.equals(PriceEffectiveUntil.shortname))
					x.priceEffectiveUntil = PriceEffectiveUntil.fromDoc(element);
			}
		});

		return x;
	}

	public PriceTypes getPriceTypeCodeValue()
	{
		return (priceTypeCode == null) ? null : priceTypeCode.value;
	}

	public PriceTypeQualifiers getPriceQualifierValue()
	{
		return (priceQualifier == null) ? null : priceQualifier.value;
	}

	public String getPriceTypeDescriptionValue()
	{
		return (priceTypeDescription == null) ? null : priceTypeDescription.value;
	}

	public UnitOfPricings getPricePerValue()
	{
		return (pricePer == null) ? null : pricePer.value;
	}

	public String getMinimumOrderQuantityValue()
	{
		return (minimumOrderQuantity == null) ? null : minimumOrderQuantity.value;
	}

	public String getClassOfTradeValue()
	{
		return (classOfTrade == null) ? null : classOfTrade.value;
	}

	public String getBICDiscountGroupCodeValue()
	{
		return (bicDiscountGroupCode == null) ? null : bicDiscountGroupCode.value;
	}

	public String getDiscountPercentValue()
	{
		return (discountPercent == null) ? null : discountPercent.value;
	}

	public PriceStatuss getPriceStatusValue()
	{
		return (priceStatus == null) ? null : priceStatus.value;
	}

	public String getPriceAmountValue()
	{
		return (priceAmount == null) ? null : priceAmount.value;
	}

	public CurrencyCodeIso4217s getCurrencyCodeValue()
	{
		return (currencyCode == null) ? null : currencyCode.value;
	}

	public List<CountryCodeIso31661s> getCountryCodeValues()
	{
		if (countryCodes != null)
		{
			List<CountryCodeIso31661s> list = new ArrayList<>();
			for (CountryCode i : countryCodes)
				list.add(i.value);
			return list;
		}
		return null;
	}

	public Regions getTerritoryValue()
	{
		return (territory == null) ? null : territory.value;
	}

	public CountryCodeIso31661s getCountryExcludedValue()
	{
		return (countryExcluded == null) ? null : countryExcluded.value;
	}

	public Regions getTerritoryExcludedValue()
	{
		return (territoryExcluded == null) ? null : territoryExcluded.value;
	}

	public TaxRateCodeds getTaxRateCode1Value()
	{
		return (taxRateCode1 == null) ? null : taxRateCode1.value;
	}

	public String getTaxRatePercent1Value()
	{
		return (taxRatePercent1 == null) ? null : taxRatePercent1.value;
	}

	public String getTaxableAmount1Value()
	{
		return (taxableAmount1 == null) ? null : taxableAmount1.value;
	}

	public String getTaxAmount1Value()
	{
		return (taxAmount1 == null) ? null : taxAmount1.value;
	}

	public TaxRateCodeds getTaxRateCode2Value()
	{
		return (taxRateCode2 == null) ? null : taxRateCode2.value;
	}

	public String getTaxRatePercent2Value()
	{
		return (taxRatePercent2 == null) ? null : taxRatePercent2.value;
	}

	public String getTaxableAmount2Value()
	{
		return (taxableAmount2 == null) ? null : taxableAmount2.value;
	}

	public String getTaxAmount2Value()
	{
		return (taxAmount2 == null) ? null : taxAmount2.value;
	}

	public String getPriceEffectiveFromValue()
	{
		return (priceEffectiveFrom == null) ? null : priceEffectiveFrom.value;
	}

	public String getPriceEffectiveUntilValue()
	{
		return (priceEffectiveUntil == null) ? null : priceEffectiveUntil.value;
	}
}
