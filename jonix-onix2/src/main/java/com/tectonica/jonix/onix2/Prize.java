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

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.OnixComposite.OnixDataComposite;
import com.tectonica.jonix.codelist.CountryCodeIso31661s;
import com.tectonica.jonix.codelist.LanguageCodeIso6392Bs;
import com.tectonica.jonix.codelist.PrizeOrAwardAchievements;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;
import com.tectonica.jonix.struct.JonixPrize;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

@SuppressWarnings("serial")
public class Prize implements OnixDataComposite, Serializable
{
	public static final String refname = "Prize";
	public static final String shortname = "prize";

	public TextFormats textformat;
	public TextCaseFlags textcase;
	public LanguageCodeIso6392Bs language;
	public TransliterationSchemes transliteration;
	public String datestamp; // DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public PrizeName prizeName; // Required
	public PrizeYear prizeYear; // Optional
	public PrizeCountry prizeCountry; // Optional
	public PrizeCode prizeCode; // Optional
	public PrizeJury prizeJury; // Optional

	public Prize()
	{}

	public Prize(org.w3c.dom.Element element)
	{
		this.textformat = TextFormats.byValue(JPU.getAttribute(element, "textformat"));
		this.textcase = TextCaseFlags.byValue(JPU.getAttribute(element, "textcase"));
		this.language = LanguageCodeIso6392Bs.byValue(JPU.getAttribute(element, "language"));
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
				if (name.equals(PrizeName.refname) || name.equals(PrizeName.shortname))
					prizeName = new PrizeName(element);
				else if (name.equals(PrizeYear.refname) || name.equals(PrizeYear.shortname))
					prizeYear = new PrizeYear(element);
				else if (name.equals(PrizeCountry.refname) || name.equals(PrizeCountry.shortname))
					prizeCountry = new PrizeCountry(element);
				else if (name.equals(PrizeCode.refname) || name.equals(PrizeCode.shortname))
					prizeCode = new PrizeCode(element);
				else if (name.equals(PrizeJury.refname) || name.equals(PrizeJury.shortname))
					prizeJury = new PrizeJury(element);
			}
		});
	}

	public String getPrizeNameValue()
	{
		return (prizeName == null) ? null : prizeName.value;
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

	public String getPrizeJuryValue()
	{
		return (prizeJury == null) ? null : prizeJury.value;
	}

	public JonixPrize asJonixPrize()
	{
		JonixPrize x = new JonixPrize();
		x.prizeCode = getPrizeCodeValue();
		x.prizeCountry = getPrizeCountryValue();
		x.prizeJurys = java.util.Arrays.asList(getPrizeJuryValue());
		x.prizeNames = java.util.Arrays.asList(getPrizeNameValue());
		x.prizeYear = getPrizeYearValue();
		return x;
	}
}
