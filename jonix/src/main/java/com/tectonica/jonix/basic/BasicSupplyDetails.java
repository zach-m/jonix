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

package com.tectonica.jonix.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.tectonica.jonix.codelist.PriceTypes;
import com.tectonica.jonix.onix3.ProductSupply;

/**
 * A {@link List} containing the multiple instances of ONIX &lt;SupplyDetail&gt; that may exist in an ONIX product
 * 
 * @author Zach Melamed
 */
public class BasicSupplyDetails extends ArrayList<BasicSupplyDetail>
{
	private static final long serialVersionUID = 1L;

	public BasicSupplyDetails(com.tectonica.jonix.onix2.Product product)
	{
		if (product.supplyDetails != null)
		{
			for (com.tectonica.jonix.onix2.SupplyDetail supplyDetail : product.supplyDetails)
				add(new BasicSupplyDetail(supplyDetail));
		}
	}

	public BasicSupplyDetails(com.tectonica.jonix.onix3.Product product)
	{
		if (product.productSupplys != null)
		{
			for (ProductSupply ps : product.productSupplys) // scanning all markets, maybe not good idea
			{
				for (com.tectonica.jonix.onix3.SupplyDetail supplyDetail : ps.supplyDetails)
					add(new BasicSupplyDetail(supplyDetail));
			}
		}
	}

	public List<BasicPrice> findPrices(Set<PriceTypes> requestedTypes)
	{
		List<BasicPrice> matches = new ArrayList<BasicPrice>();
		for (BasicSupplyDetail supplyDetail : this)
		{
			for (BasicPrice price : supplyDetail.prices)
			{
				if (requestedTypes.contains(price.priceType))
					matches.add(price);
			}
		}
		return matches;
	}
}
