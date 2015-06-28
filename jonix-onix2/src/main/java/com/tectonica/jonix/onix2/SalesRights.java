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

package com.tectonica.jonix.onix2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.OnixComposite.OnixDataComposite;
import com.tectonica.jonix.codelist.CountryCodes;
import com.tectonica.jonix.codelist.LanguageCodes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.Regions;
import com.tectonica.jonix.codelist.RightsRegions;
import com.tectonica.jonix.codelist.SalesRightsTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

@SuppressWarnings("serial")
public class SalesRights implements OnixDataComposite, Serializable
{
	public static final String refname = "SalesRights";
	public static final String shortname = "salesrights";

	public TextFormats textformat;
	public TextCaseFlags textcase;
	public LanguageCodes language;
	public TransliterationSchemes transliteration;
	public String datestamp; // DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	/**
	 * (this field is required)
	 */
	public SalesRightsType salesRightsType;

	/**
	 * (this list is required to contain at least one item)
	 */
	public List<RightsCountry> rightsCountrys;

	/**
	 * (this field is optional)
	 */
	public RightsTerritory rightsTerritory;

	/**
	 * (this list may be empty)
	 */
	public List<RightsRegion> rightsRegions;

	public SalesRights()
	{}

	public SalesRights(org.w3c.dom.Element element)
	{
		this.textformat = TextFormats.byValue(JPU.getAttribute(element, "textformat"));
		this.textcase = TextCaseFlags.byValue(JPU.getAttribute(element, "textcase"));
		this.language = LanguageCodes.byValue(JPU.getAttribute(element, "language"));
		this.transliteration = TransliterationSchemes.byValue(JPU.getAttribute(element, "transliteration"));
		this.datestamp = JPU.getAttribute(element, "datestamp");
		this.sourcetype = RecordSourceTypes.byValue(JPU.getAttribute(element, "sourcetype"));
		this.sourcename = JPU.getAttribute(element, "sourcename");

		JPU.forElementsOf(element, new JPU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(SalesRightsType.refname) || name.equals(SalesRightsType.shortname))
					salesRightsType = new SalesRightsType(element);
				else if (name.equals(RightsCountry.refname) || name.equals(RightsCountry.shortname))
					rightsCountrys = JPU.addToList(rightsCountrys, new RightsCountry(element));
				else if (name.equals(RightsTerritory.refname) || name.equals(RightsTerritory.shortname))
					rightsTerritory = new RightsTerritory(element);
				else if (name.equals(RightsRegion.refname) || name.equals(RightsRegion.shortname))
					rightsRegions = JPU.addToList(rightsRegions, new RightsRegion(element));
			}
		});
	}

	public SalesRightsTypes getSalesRightsTypeValue()
	{
		return (salesRightsType == null) ? null : salesRightsType.value;
	}

	public List<java.util.Set<CountryCodes>> getRightsCountrySets()
	{
		if (rightsCountrys != null)
		{
			List<java.util.Set<CountryCodes>> list = new ArrayList<>();
			for (RightsCountry i : rightsCountrys)
				list.add(i.value);
			return list;
		}
		return null;
	}

	public java.util.Set<Regions> getRightsTerritorySet()
	{
		return (rightsTerritory == null) ? null : rightsTerritory.value;
	}

	public List<RightsRegions> getRightsRegionValues()
	{
		if (rightsRegions != null)
		{
			List<RightsRegions> list = new ArrayList<>();
			for (RightsRegion i : rightsRegions)
				list.add(i.value);
			return list;
		}
		return null;
	}
}
