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

/**
 * <h1>Sales rights composite</h1>
 * <p>
 * A repeatable group of data elements which together identify territorial sales rights which a publisher chooses to
 * exercise in a product. The &lt;SalesRights&gt; composite may occur once for each value of &lt;b089&gt;. See examples
 * at the end of Group&nbsp;PR.21.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;SalesRights&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;salesrights&gt;</td>
 * </tr>
 * </table>
 */
public class SalesRights implements OnixDataComposite, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "SalesRights";
	public static final String shortname = "salesrights";

	// ///////////////////////////////////////////////////////////////////////////////
	// ATTRIBUTES
	// ///////////////////////////////////////////////////////////////////////////////

	public TextFormats textformat;

	public TextCaseFlags textcase;

	public LanguageCodes language;

	public TransliterationSchemes transliteration;

	/**
	 * (type: DateOrDateTime)
	 */
	public String datestamp;

	public RecordSourceTypes sourcetype;

	public String sourcename;

	// ///////////////////////////////////////////////////////////////////////////////
	// MEMBERS
	// ///////////////////////////////////////////////////////////////////////////////

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

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public SalesRights()
	{}

	public SalesRights(org.w3c.dom.Element element)
	{
		textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));
		textcase = TextCaseFlags.byCode(JPU.getAttribute(element, "textcase"));
		language = LanguageCodes.byCode(JPU.getAttribute(element, "language"));
		transliteration = TransliterationSchemes.byCode(JPU.getAttribute(element, "transliteration"));
		datestamp = JPU.getAttribute(element, "datestamp");
		sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
		sourcename = JPU.getAttribute(element, "sourcename");

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
