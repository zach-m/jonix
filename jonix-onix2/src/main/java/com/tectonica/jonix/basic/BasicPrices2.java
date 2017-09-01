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

import com.tectonica.jonix.onix2.Price;
import com.tectonica.jonix.onix2.SupplyDetail;

/**
 * ONIX2 concrete implementation for {@link BasicPrices}
 * 
 * @author Zach Melamed
 */
public class BasicPrices2 extends BasicPrices
{
	private static final long serialVersionUID = 1L;

	private transient final SupplyDetail supplyDetail;

	public BasicPrices2(SupplyDetail supplyDetail)
	{
		this.supplyDetail = supplyDetail;
	}

	@Override
	protected List<BasicPrice> initialize()
	{
		List<BasicPrice> list = new ArrayList<>();
		for (Price price : supplyDetail.prices())
			list.add(new BasicPrice2(price));
		return list;
	}
}
