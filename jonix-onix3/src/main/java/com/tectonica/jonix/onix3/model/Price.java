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

public class Price
{
	public static final String refname = "Price";
	public static final String shortname = "price";

	public String datestamp; // dt.DateOrDateTime
	public List3 sourcetype;
	public String sourcename;

	public List<PriceIdentifier> priceIdentifiers; // ZeroOrMore
	public PriceType priceType; // Optional
	public PriceQualifier priceQualifier; // Optional
	public List<PriceTypeDescription> priceTypeDescriptions; // ZeroOrMore
	public PricePer pricePer; // Optional
	public List<PriceCondition> priceConditions; // ZeroOrMore
	public MinimumOrderQuantity minimumOrderQuantity; // Optional
	public List<BatchBonus> batchBonuss; // ZeroOrMore
	public List<DiscountCoded> discountCodeds; // ZeroOrMore
	public List<Discount> discounts; // ZeroOrMore
	public PriceStatus priceStatus; // Optional
	public PriceAmount priceAmount; // Optional
	public PriceCoded priceCoded; // Optional
	public List<Tax> taxs; // ZeroOrMore
	public CurrencyCode currencyCode; // Optional
	public Territory territory; // Optional
	public CurrencyZone currencyZone; // Optional
	public List<ComparisonProductPrice> comparisonProductPrices; // ZeroOrMore
	public List<PriceDate> priceDates; // ZeroOrMore
	public PrintedOnProduct printedOnProduct; // Optional
	public PositionOnProduct positionOnProduct; // Optional

	public static Price fromDoc(org.w3c.dom.Element element)
	{
		final Price x = new Price();

		x.datestamp = DU.getAttribute(element, "datestamp");
		x.sourcetype = List3.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		DU.forElementsOf(element, new DU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equalsIgnoreCase(PriceIdentifier.refname) || name.equalsIgnoreCase(PriceIdentifier.shortname))
					x.priceIdentifiers = DU.addToList(x.priceIdentifiers, PriceIdentifier.fromDoc(element));
				else if (name.equalsIgnoreCase(PriceType.refname) || name.equalsIgnoreCase(PriceType.shortname))
					x.priceType = PriceType.fromDoc(element);
				else if (name.equalsIgnoreCase(PriceQualifier.refname) || name.equalsIgnoreCase(PriceQualifier.shortname))
					x.priceQualifier = PriceQualifier.fromDoc(element);
				else if (name.equalsIgnoreCase(PriceTypeDescription.refname) || name.equalsIgnoreCase(PriceTypeDescription.shortname))
					x.priceTypeDescriptions = DU.addToList(x.priceTypeDescriptions, PriceTypeDescription.fromDoc(element));
				else if (name.equalsIgnoreCase(PricePer.refname) || name.equalsIgnoreCase(PricePer.shortname))
					x.pricePer = PricePer.fromDoc(element);
				else if (name.equalsIgnoreCase(PriceCondition.refname) || name.equalsIgnoreCase(PriceCondition.shortname))
					x.priceConditions = DU.addToList(x.priceConditions, PriceCondition.fromDoc(element));
				else if (name.equalsIgnoreCase(MinimumOrderQuantity.refname) || name.equalsIgnoreCase(MinimumOrderQuantity.shortname))
					x.minimumOrderQuantity = MinimumOrderQuantity.fromDoc(element);
				else if (name.equalsIgnoreCase(BatchBonus.refname) || name.equalsIgnoreCase(BatchBonus.shortname))
					x.batchBonuss = DU.addToList(x.batchBonuss, BatchBonus.fromDoc(element));
				else if (name.equalsIgnoreCase(DiscountCoded.refname) || name.equalsIgnoreCase(DiscountCoded.shortname))
					x.discountCodeds = DU.addToList(x.discountCodeds, DiscountCoded.fromDoc(element));
				else if (name.equalsIgnoreCase(Discount.refname) || name.equalsIgnoreCase(Discount.shortname))
					x.discounts = DU.addToList(x.discounts, Discount.fromDoc(element));
				else if (name.equalsIgnoreCase(PriceStatus.refname) || name.equalsIgnoreCase(PriceStatus.shortname))
					x.priceStatus = PriceStatus.fromDoc(element);
				else if (name.equalsIgnoreCase(PriceAmount.refname) || name.equalsIgnoreCase(PriceAmount.shortname))
					x.priceAmount = PriceAmount.fromDoc(element);
				else if (name.equalsIgnoreCase(PriceCoded.refname) || name.equalsIgnoreCase(PriceCoded.shortname))
					x.priceCoded = PriceCoded.fromDoc(element);
				else if (name.equalsIgnoreCase(Tax.refname) || name.equalsIgnoreCase(Tax.shortname))
					x.taxs = DU.addToList(x.taxs, Tax.fromDoc(element));
				else if (name.equalsIgnoreCase(CurrencyCode.refname) || name.equalsIgnoreCase(CurrencyCode.shortname))
					x.currencyCode = CurrencyCode.fromDoc(element);
				else if (name.equalsIgnoreCase(Territory.refname) || name.equalsIgnoreCase(Territory.shortname))
					x.territory = Territory.fromDoc(element);
				else if (name.equalsIgnoreCase(CurrencyZone.refname) || name.equalsIgnoreCase(CurrencyZone.shortname))
					x.currencyZone = CurrencyZone.fromDoc(element);
				else if (name.equalsIgnoreCase(ComparisonProductPrice.refname) || name.equalsIgnoreCase(ComparisonProductPrice.shortname))
					x.comparisonProductPrices = DU.addToList(x.comparisonProductPrices, ComparisonProductPrice.fromDoc(element));
				else if (name.equalsIgnoreCase(PriceDate.refname) || name.equalsIgnoreCase(PriceDate.shortname))
					x.priceDates = DU.addToList(x.priceDates, PriceDate.fromDoc(element));
				else if (name.equalsIgnoreCase(PrintedOnProduct.refname) || name.equalsIgnoreCase(PrintedOnProduct.shortname))
					x.printedOnProduct = PrintedOnProduct.fromDoc(element);
				else if (name.equalsIgnoreCase(PositionOnProduct.refname) || name.equalsIgnoreCase(PositionOnProduct.shortname))
					x.positionOnProduct = PositionOnProduct.fromDoc(element);
			}
		});

		return x;
	}
}
