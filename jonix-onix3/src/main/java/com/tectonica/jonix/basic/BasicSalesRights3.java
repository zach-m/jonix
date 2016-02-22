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

import java.util.Arrays;

import com.tectonica.jonix.basic.BasicSalesRights;
import com.tectonica.jonix.onix3.SalesRights;
import com.tectonica.jonix.onix3.Territory;

/**
 * ONIX3 concrete implementation for {@link BasicSalesRights}
 * 
 * @author Zach Melamed
 */
public class BasicSalesRights3 extends BasicSalesRights
{
	private static final long serialVersionUID = 1L;

	public BasicSalesRights3(SalesRights salesRights)
	{
		Territory territory = salesRights.territory;
		salesRightsType = salesRights.getSalesRightsTypeValue();
		countries = Arrays.asList(territory.getCountriesIncludedSet());
		regions = territory.getRegionsIncludedSet();
		rightRegions = null;
		countriesExcluded = territory.getCountriesExcludedSet();
		regionsExcluded = territory.getRegionsExcludedSet();
	}
}