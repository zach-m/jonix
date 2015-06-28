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

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.OnixComposite.OnixDataComposite;
import com.tectonica.jonix.codelist.CountryCodes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.Regions;
import com.tectonica.jonix.struct.JonixTerritory;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

@SuppressWarnings("serial")
public class Territory implements OnixDataComposite, Serializable
{
	public static final String refname = "Territory";
	public static final String shortname = "territory";

	/**
	 * (type: dt.DateOrDateTime)
	 */
	public String datestamp;

	public RecordSourceTypes sourcetype;

	public String sourcename;

	/**
	 * (this field is required)
	 */
	public CountriesIncluded countriesIncluded;

	/**
	 * (this field is optional)
	 */
	public RegionsIncluded regionsIncluded;

	/**
	 * (this field is optional)
	 */
	public CountriesExcluded countriesExcluded;

	/**
	 * (this field is optional)
	 */
	public RegionsExcluded regionsExcluded;

	public Territory()
	{}

	public Territory(org.w3c.dom.Element element)
	{
		datestamp = JPU.getAttribute(element, "datestamp");
		sourcetype = RecordSourceTypes.byValue(JPU.getAttribute(element, "sourcetype"));
		sourcename = JPU.getAttribute(element, "sourcename");

		JPU.forElementsOf(element, new JPU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(CountriesIncluded.refname) || name.equals(CountriesIncluded.shortname))
					countriesIncluded = new CountriesIncluded(element);
				else if (name.equals(RegionsIncluded.refname) || name.equals(RegionsIncluded.shortname))
					regionsIncluded = new RegionsIncluded(element);
				else if (name.equals(CountriesExcluded.refname) || name.equals(CountriesExcluded.shortname))
					countriesExcluded = new CountriesExcluded(element);
				else if (name.equals(RegionsExcluded.refname) || name.equals(RegionsExcluded.shortname))
					regionsExcluded = new RegionsExcluded(element);
			}
		});
	}

	public java.util.Set<CountryCodes> getCountriesIncludedSet()
	{
		return (countriesIncluded == null) ? null : countriesIncluded.value;
	}

	public java.util.Set<Regions> getRegionsIncludedSet()
	{
		return (regionsIncluded == null) ? null : regionsIncluded.value;
	}

	public java.util.Set<CountryCodes> getCountriesExcludedSet()
	{
		return (countriesExcluded == null) ? null : countriesExcluded.value;
	}

	public java.util.Set<Regions> getRegionsExcludedSet()
	{
		return (regionsExcluded == null) ? null : regionsExcluded.value;
	}

	public JonixTerritory asJonixTerritory()
	{
		JonixTerritory x = new JonixTerritory();
		x.countriesIncluded = getCountriesIncludedSet();
		x.regionsIncluded = getRegionsIncludedSet();
		x.countriesExcluded = getCountriesExcludedSet();
		x.regionsExcluded = getRegionsExcludedSet();
		return x;
	}
}
