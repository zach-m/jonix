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
import com.tectonica.jonix.codelist.CountryCodeIso31661s;
import com.tectonica.jonix.codelist.PrizeOrAwardAchievements;
import com.tectonica.jonix.codelist.RecordSourceTypes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

@SuppressWarnings("serial")
public class Prize implements OnixDataComposite, Serializable
{
	public static final String refname = "Prize";
	public static final String shortname = "prize";

	public String datestamp; // dt.DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public List<PrizeName> prizeNames; // OneOrMore
	public PrizeYear prizeYear; // Optional
	public PrizeCountry prizeCountry; // Optional
	public PrizeCode prizeCode; // Optional
	public List<PrizeStatement> prizeStatements; // ZeroOrMore
	public List<PrizeJury> prizeJurys; // ZeroOrMore

	public Prize()
	{}

	public Prize(org.w3c.dom.Element element)
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

	public CountryCodeIso31661s getPrizeCountryValue()
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
}
