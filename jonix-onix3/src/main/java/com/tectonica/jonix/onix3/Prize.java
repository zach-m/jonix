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
import com.tectonica.jonix.OnixComposite.OnixDataComposite;
import com.tectonica.jonix.codelist.CountryCodes;
import com.tectonica.jonix.codelist.PrizeOrAwardAchievements;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixPrize;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <h1>Prize or award composite</h1>
 * <p>
 * An optional and repeatable group of data elements which together describe a prize or award won by the product.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;Prize&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;prize&gt;</td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 */
public class Prize implements OnixDataComposite, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "Prize";
	public static final String shortname = "prize";

	// ///////////////////////////////////////////////////////////////////////////////
	// ATTRIBUTES
	// ///////////////////////////////////////////////////////////////////////////////

	/**
	 * (type: dt.DateOrDateTime)
	 */
	public String datestamp;

	public RecordSourceTypes sourcetype;

	public String sourcename;

	// ///////////////////////////////////////////////////////////////////////////////
	// MEMBERS
	// ///////////////////////////////////////////////////////////////////////////////

	/**
	 * (this list is required to contain at least one item)
	 */
	public List<PrizeName> prizeNames;

	/**
	 * (this field is optional)
	 */
	public PrizeYear prizeYear;

	/**
	 * (this field is optional)
	 */
	public PrizeCountry prizeCountry;

	/**
	 * (this field is optional)
	 */
	public PrizeCode prizeCode;

	/**
	 * (this list may be empty)
	 */
	public List<PrizeStatement> prizeStatements;

	/**
	 * (this list may be empty)
	 */
	public List<PrizeJury> prizeJurys;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public Prize()
	{}

	public Prize(org.w3c.dom.Element element)
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
				if (name.equals(PrizeName.refname) || name.equals(PrizeName.shortname))
					prizeNames = JPU.addToList(prizeNames, new PrizeName(element));
				else if (name.equals(PrizeYear.refname) || name.equals(PrizeYear.shortname))
					prizeYear = new PrizeYear(element);
				else if (name.equals(PrizeCountry.refname) || name.equals(PrizeCountry.shortname))
					prizeCountry = new PrizeCountry(element);
				else if (name.equals(PrizeCode.refname) || name.equals(PrizeCode.shortname))
					prizeCode = new PrizeCode(element);
				else if (name.equals(PrizeStatement.refname) || name.equals(PrizeStatement.shortname))
					prizeStatements = JPU.addToList(prizeStatements, new PrizeStatement(element));
				else if (name.equals(PrizeJury.refname) || name.equals(PrizeJury.shortname))
					prizeJurys = JPU.addToList(prizeJurys, new PrizeJury(element));
			}
		});
	}

	public List<String> getPrizeNameValues()
	{
		if (prizeNames != null)
		{
			List<String> list = new ArrayList<>();
			for (PrizeName i : prizeNames)
				list.add(i.value);
			return list;
		}
		return null;
	}

	public String getPrizeYearValue()
	{
		return (prizeYear == null) ? null : prizeYear.value;
	}

	public CountryCodes getPrizeCountryValue()
	{
		return (prizeCountry == null) ? null : prizeCountry.value;
	}

	public PrizeOrAwardAchievements getPrizeCodeValue()
	{
		return (prizeCode == null) ? null : prizeCode.value;
	}

	public List<String> getPrizeStatementValues()
	{
		if (prizeStatements != null)
		{
			List<String> list = new ArrayList<>();
			for (PrizeStatement i : prizeStatements)
				list.add(i.value);
			return list;
		}
		return null;
	}

	public List<String> getPrizeJuryValues()
	{
		if (prizeJurys != null)
		{
			List<String> list = new ArrayList<>();
			for (PrizeJury i : prizeJurys)
				list.add(i.value);
			return list;
		}
		return null;
	}

	public JonixPrize asJonixPrize()
	{
		JonixPrize x = new JonixPrize();
		x.prizeCode = getPrizeCodeValue();
		x.prizeCountry = getPrizeCountryValue();
		x.prizeJurys = getPrizeJuryValues();
		x.prizeNames = getPrizeNameValues();
		x.prizeYear = getPrizeYearValue();
		return x;
	}
}
