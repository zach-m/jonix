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

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import com.tectonica.jonix.codelist.CountryCodeIso31661s;
import com.tectonica.jonix.codelist.Regions;
import com.tectonica.jonix.codelist.RightsRegions;
import com.tectonica.jonix.codelist.SalesRightsTypes;
import com.tectonica.jonix.onix3.Territory;

@SuppressWarnings("serial")
public class BasicSalesRights implements Serializable
{
	public SalesRightsTypes salesRightsType;
	public List<Set<CountryCodeIso31661s>> countries;
	public Set<Regions> regions;
	public List<RightsRegions> rightRegions; // only in Onix2
	public Set<CountryCodeIso31661s> countriesExcluded; // only in Onix3
	public Set<Regions> regionsExcluded; // only in Onix3

	public BasicSalesRights extractFrom(com.tectonica.jonix.onix2.SalesRights sr)
	{
		salesRightsType = sr.getSalesRightsTypeValue();
		countries = sr.getRightsCountrySets();
		regions = sr.getRightsTerritorySet();
		rightRegions = sr.getRightsRegionValues();
		countriesExcluded = null;
		regionsExcluded = null;
		return this;
	}

	public BasicSalesRights extractFrom(com.tectonica.jonix.onix3.SalesRights sr)
	{
		Territory territory = sr.territory;
		salesRightsType = sr.getSalesRightsTypeValue();
		countries = Arrays.asList(territory.getCountriesIncludedSet());
		regions = territory.getRegionsIncludedSet();
		rightRegions = null;
		countriesExcluded = territory.getCountriesExcludedSet();
		regionsExcluded = territory.getRegionsExcludedSet();
		return this;
	}
}