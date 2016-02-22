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

import com.tectonica.jonix.basic.BasicPrice;
import com.tectonica.jonix.basic.BasicPrices;
import com.tectonica.jonix.onix3.Price;
import com.tectonica.jonix.onix3.SupplyDetail;

/**
 * ONIX3 concrete implementation for {@link BasicPrices}
 * 
 * @author Zach Melamed
 */
public class BasicPrices3 extends BasicPrices
{
	private static final long serialVersionUID = 1L;

	private transient final SupplyDetail supplyDetail;

	public BasicPrices3(SupplyDetail supplyDetail)
	{
		this.supplyDetail = supplyDetail;
	}

	@Override
	protected List<BasicPrice> initialize()
	{
		List<BasicPrice> list = new ArrayList<>();
		if (supplyDetail.prices != null)
		{
			for (Price price : supplyDetail.prices)
				list.add(new BasicPrice3(price));
		}
		return list;
	}
}
