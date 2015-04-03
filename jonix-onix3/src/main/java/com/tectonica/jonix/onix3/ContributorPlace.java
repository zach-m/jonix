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

package com.tectonica.jonix.onix3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.OnixContent;
import com.tectonica.jonix.codelist.ContributorPlaceRelators;
import com.tectonica.jonix.codelist.CountryCodeIso31661s;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.Regions;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

@SuppressWarnings("serial")
public class ContributorPlace implements OnixContent, Serializable
{
	public static final String refname = "ContributorPlace";
	public static final String shortname = "contributorplace";

	public String datestamp; // dt.DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public ContributorPlaceRelator contributorPlaceRelator; // Required
	public CountryCode countryCode; // Required
	public RegionCode regionCode; // Optional
	public List<LocationName> locationNames; // ZeroOrMore

	public ContributorPlace()
	{}

	public ContributorPlace(org.w3c.dom.Element element)
	{
		this.datestamp = JPU.getAttribute(element, "datestamp");
		this.sourcetype = RecordSourceTypes.byValue(JPU.getAttribute(element, "sourcetype"));
		this.sourcename = JPU.getAttribute(element, "sourcename");

		JPU.forElementsOf(element, new JPU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(ContributorPlaceRelator.refname) || name.equals(ContributorPlaceRelator.shortname))
					contributorPlaceRelator = new ContributorPlaceRelator(element);
				else if (name.equals(CountryCode.refname) || name.equals(CountryCode.shortname))
					countryCode = new CountryCode(element);
				else if (name.equals(RegionCode.refname) || name.equals(RegionCode.shortname))
					regionCode = new RegionCode(element);
				else if (name.equals(LocationName.refname) || name.equals(LocationName.shortname))
					locationNames = JPU.addToList(locationNames, new LocationName(element));
			}
		});
	}

	public ContributorPlaceRelators getContributorPlaceRelatorValue()
	{
		return (contributorPlaceRelator == null) ? null : contributorPlaceRelator.value;
	}

	public CountryCodeIso31661s getCountryCodeValue()
	{
		return (countryCode == null) ? null : countryCode.value;
	}

	public Regions getRegionCodeValue()
	{
		return (regionCode == null) ? null : regionCode.value;
	}

	public List<String> getLocationNameValues()
	{
		if (locationNames != null)
		{
			List<String> list = new ArrayList<>();
			for (LocationName i : locationNames)
				list.add(i.value);
			return list;
		}
		return null;
	}
}
