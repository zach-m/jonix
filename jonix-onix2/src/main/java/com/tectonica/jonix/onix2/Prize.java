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

import com.tectonica.jonix.DU;
import com.tectonica.jonix.codelist.CountryCodeIso31661s;
import com.tectonica.jonix.codelist.LanguageCodeIso6392Bs;
import com.tectonica.jonix.codelist.PrizeOrAwardAchievements;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

public class Prize
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

	public static Prize fromDoc(org.w3c.dom.Element element)
	{
		final Prize x = new Prize();

		x.textformat = TextFormats.byValue(DU.getAttribute(element, "textformat"));
		x.textcase = TextCaseFlags.byValue(DU.getAttribute(element, "textcase"));
		x.language = LanguageCodeIso6392Bs.byValue(DU.getAttribute(element, "language"));
		x.transliteration = TransliterationSchemes.byValue(DU.getAttribute(element, "transliteration"));
		x.datestamp = DU.getAttribute(element, "datestamp");
		x.sourcetype = RecordSourceTypes.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		DU.forElementsOf(element, new DU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(PrizeName.refname) || name.equals(PrizeName.shortname))
					x.prizeName = PrizeName.fromDoc(element);
				else if (name.equals(PrizeYear.refname) || name.equals(PrizeYear.shortname))
					x.prizeYear = PrizeYear.fromDoc(element);
				else if (name.equals(PrizeCountry.refname) || name.equals(PrizeCountry.shortname))
					x.prizeCountry = PrizeCountry.fromDoc(element);
				else if (name.equals(PrizeCode.refname) || name.equals(PrizeCode.shortname))
					x.prizeCode = PrizeCode.fromDoc(element);
				else if (name.equals(PrizeJury.refname) || name.equals(PrizeJury.shortname))
					x.prizeJury = PrizeJury.fromDoc(element);
			}
		});

		return x;
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
}
