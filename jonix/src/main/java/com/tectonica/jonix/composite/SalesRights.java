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
import java.util.Set;

import com.tectonica.jonix.codelist.CountryCodeIso31661s;
import com.tectonica.jonix.codelist.Regions;
import com.tectonica.jonix.codelist.RightsRegions;
import com.tectonica.jonix.codelist.SalesRightsTypes;

@SuppressWarnings("serial")
public class SalesRights implements Serializable
{
	public final SalesRightsTypes salesRightsType;
	public final Set<Regions> rightsTerritory;
	public final List<Set<CountryCodeIso31661s>> rightsCountries;
	public final List<RightsRegions> rightsRegions;

	public SalesRights(SalesRightsTypes salesRightsType, Set<Regions> rightsTerritory, List<Set<CountryCodeIso31661s>> rightsCountries,
			List<RightsRegions> rightsRegions)
	{
		this.salesRightsType = salesRightsType;
		this.rightsTerritory = rightsTerritory;
		this.rightsCountries = rightsCountries;
		this.rightsRegions = rightsRegions;
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		String salesRightsTypeStr = (salesRightsType == null) ? null : salesRightsType.name();
		sb.append("SalesRights [").append(salesRightsTypeStr).append("]:");
		if (rightsTerritory != null)
			sb.append("\n    > Territory: ").append(rightsTerritory.toString());
		if (rightsCountries != null)
			sb.append("\n    > Countries: ").append(rightsCountries.toString());
		if (rightsRegions != null)
			sb.append("\n    > Regions: ").append(rightsRegions.toString());
		return sb.toString();
	}

	public static List<SalesRights> listFrom(com.tectonica.jonix.onix2.Product product)
	{
		if (product.salesRightss != null)
		{
			List<SalesRights> result = new ArrayList<>();
			for (com.tectonica.jonix.onix2.SalesRights i : product.salesRightss)
				result.add(new SalesRights(i.getSalesRightsTypeValue(), i.getRightsTerritorySet(), i.getRightsCountrySets(), i
						.getRightsRegionValues()));
			return result;
		}
		return Collections.emptyList();
	}
}