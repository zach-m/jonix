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

import com.tectonica.jonix.DU;
import com.tectonica.jonix.codelist.CountryCodeIso31661s;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.Regions;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

public class Territory
{
	public static final String refname = "Territory";
	public static final String shortname = "territory";

	public String datestamp; // dt.DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public CountriesIncluded countriesIncluded; // Required
	public RegionsIncluded regionsIncluded; // Optional
	public CountriesExcluded countriesExcluded; // Optional
	public RegionsExcluded regionsExcluded; // Optional

	public static Territory fromDoc(org.w3c.dom.Element element)
	{
		final Territory x = new Territory();

		x.datestamp = DU.getAttribute(element, "datestamp");
		x.sourcetype = RecordSourceTypes.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		DU.forElementsOf(element, new DU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(CountriesIncluded.refname) || name.equals(CountriesIncluded.shortname))
					x.countriesIncluded = CountriesIncluded.fromDoc(element);
				else if (name.equals(RegionsIncluded.refname) || name.equals(RegionsIncluded.shortname))
					x.regionsIncluded = RegionsIncluded.fromDoc(element);
				else if (name.equals(CountriesExcluded.refname) || name.equals(CountriesExcluded.shortname))
					x.countriesExcluded = CountriesExcluded.fromDoc(element);
				else if (name.equals(RegionsExcluded.refname) || name.equals(RegionsExcluded.shortname))
					x.regionsExcluded = RegionsExcluded.fromDoc(element);
			}
		});

		return x;
	}

	public java.util.Set<CountryCodeIso31661s> getCountriesIncludedSet()
	{
		return (countriesIncluded == null) ? null : countriesIncluded.value;
	}

	public java.util.Set<Regions> getRegionsIncludedSet()
	{
		return (regionsIncluded == null) ? null : regionsIncluded.value;
	}

	public java.util.Set<CountryCodeIso31661s> getCountriesExcludedSet()
	{
		return (countriesExcluded == null) ? null : countriesExcluded.value;
	}

	public java.util.Set<Regions> getRegionsExcludedSet()
	{
		return (regionsExcluded == null) ? null : regionsExcluded.value;
	}
}
