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

package com.tectonica.jonix.composite;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.codelist.CurrencyCodeIso4217s;
import com.tectonica.jonix.codelist.PriceTypes;

@SuppressWarnings("serial")
public class Price implements Serializable
{
	public final PriceTypes priceType;
	public final Double priceAmount;
	public final String priceAmountAsStr;
	public final CurrencyCodeIso4217s currencyCode;

	public Price(PriceTypes priceType, Double priceAmount, CurrencyCodeIso4217s currencyCode)
	{
		this.priceType = priceType;
		this.priceAmount = priceAmount;
		this.priceAmountAsStr = (priceAmount == null) ? "" : priceAmount.toString();
		this.currencyCode = currencyCode;
	}

	@Override
	public String toString()
	{
		String priceTypeAsStr = (priceType == null) ? "" : priceType.name();
		return String.format("Price [%s]: %s %s", priceTypeAsStr, priceAmountAsStr, currencyCode.name());
	}

	public static List<Price> listFrom(com.tectonica.jonix.onix2.SupplyDetail supplyDetail)
	{
		if (supplyDetail.prices != null)
		{
			List<Price> result = new ArrayList<>();
			for (com.tectonica.jonix.onix2.Price i : supplyDetail.prices)
				result.add(new Price(i.getPriceTypeCodeValue(), JPU.convertStringToDouble(i.getPriceAmountValue()), i
						.getCurrencyCodeValue()));
			return result;
		}
		return Collections.emptyList();
	}

	public static List<Price> listFrom(com.tectonica.jonix.onix3.SupplyDetail supplyDetail)
	{
		if (supplyDetail.prices != null)
		{
			List<Price> result = new ArrayList<>();
			for (com.tectonica.jonix.onix3.Price i : supplyDetail.prices)
				result.add(new Price(i.getPriceTypeValue(), i.getPriceAmountValue(), i.getCurrencyCodeValue()));
			return result;
		}
		return Collections.emptyList();
	}
}