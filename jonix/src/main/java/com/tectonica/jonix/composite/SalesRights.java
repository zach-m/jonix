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
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import com.tectonica.jonix.codelist.CountryCodeIso31661s;
import com.tectonica.jonix.codelist.Regions;
import com.tectonica.jonix.codelist.RightsRegions;
import com.tectonica.jonix.codelist.SalesRightsTypes;
import com.tectonica.jonix.onix3.Territory;

@SuppressWarnings("serial")
public class SalesRights implements Serializable
{
	public final SalesRightsTypes salesRightsType;
	public final List<Set<CountryCodeIso31661s>> countries;
	public final Set<Regions> regions;
	public final List<RightsRegions> rightRegions; // only in Onix2
	public final Set<CountryCodeIso31661s> countriesExcluded; // only in Onix3
	public final Set<Regions> regionsExcluded; // only in Onix3

	public SalesRights(SalesRightsTypes salesRightsType, List<Set<CountryCodeIso31661s>> countries,
			Set<Regions> regions, List<RightsRegions> rightRegions)
	{
		this.salesRightsType = salesRightsType;
		this.countries = countries;
		this.regions = regions;
		this.rightRegions = rightRegions;
		this.countriesExcluded = null;
		this.regionsExcluded = null;
	}

	public SalesRights(SalesRightsTypes salesRightsType, Set<CountryCodeIso31661s> countries, Set<Regions> regions,
			Set<CountryCodeIso31661s> countriesExcluded, Set<Regions> regionsExcluded)
	{
		this.salesRightsType = salesRightsType;
		this.countries = Arrays.asList(countries);
		this.regions = regions;
		this.rightRegions = null;
		this.countriesExcluded = countriesExcluded;
		this.regionsExcluded = regionsExcluded;
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		String salesRightsTypeStr = (salesRightsType == null) ? null : salesRightsType.name();
		sb.append("SalesRights [").append(salesRightsTypeStr).append("]:");
		if (countries != null)
			sb.append("\n    > Countries: ").append(countries.toString());
		if (regions != null)
			sb.append("\n    > Regions: ").append(regions.toString());
		if (rightRegions != null)
			sb.append("\n    > RightRegions: ").append(rightRegions.toString());
		if (countriesExcluded != null)
			sb.append("\n    > Countries-Excluded: ").append(countriesExcluded.toString());
		if (regionsExcluded != null)
			sb.append("\n    > Regions-Excluded: ").append(regionsExcluded.toString());
		return sb.toString();
	}

	public static List<SalesRights> listFrom(com.tectonica.jonix.onix2.Product product)
	{
		if (product.salesRightss != null)
		{
			List<SalesRights> result = new ArrayList<>();
			for (com.tectonica.jonix.onix2.SalesRights sri : product.salesRightss)
				result.add(new SalesRights(sri.getSalesRightsTypeValue(), sri.getRightsCountrySets(), sri
						.getRightsTerritorySet(), sri.getRightsRegionValues()));
			return result;
		}
		return Collections.emptyList();
	}

	public static List<SalesRights> listFrom(com.tectonica.jonix.onix3.Product product)
	{
		if (product.publishingDetail != null && product.publishingDetail.salesRightss != null)
		{
			List<SalesRights> result = new ArrayList<>();
			for (com.tectonica.jonix.onix3.SalesRights sr : product.publishingDetail.salesRightss)
			{
				Territory territory = sr.territory;
				result.add(new SalesRights(sr.getSalesRightsTypeValue(), territory.getCountriesIncludedSet(), territory
						.getRegionsIncludedSet(), territory.getCountriesExcludedSet(), territory
						.getRegionsExcludedSet()));
			}
			return result;
		}
		return Collections.emptyList();
	}
}