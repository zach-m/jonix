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

import java.util.List;

import com.tectonica.jonix.DU;
import com.tectonica.jonix.codelist.LanguageCodeIso6392Bs;
import com.tectonica.jonix.codelist.RecordSourceTypeCodes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormatCodes;
import com.tectonica.jonix.codelist.TransliterationSchemeCodes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

public class Series
{
	public static final String refname = "Series";
	public static final String shortname = "series";

	public TextFormatCodes textformat;
	public TextCaseFlags textcase;
	public LanguageCodeIso6392Bs language;
	public TransliterationSchemeCodes transliteration;
	public String datestamp; // DateOrDateTime
	public RecordSourceTypeCodes sourcetype;
	public String sourcename;

	public SeriesISSN seriesISSN; // Optional
	public PublisherSeriesCode publisherSeriesCode; // Optional
	public List<SeriesIdentifier> seriesIdentifiers; // ZeroOrMore
	public TitleOfSeries titleOfSeries; // Required
	public List<Title> titles; // ZeroOrMore
	public List<Contributor> contributors; // ZeroOrMore
	public NumberWithinSeries numberWithinSeries; // Optional
	public YearOfAnnual yearOfAnnual; // Optional

	public static Series fromDoc(org.w3c.dom.Element element)
	{
		final Series x = new Series();

		x.textformat = TextFormatCodes.byValue(DU.getAttribute(element, "textformat"));
		x.textcase = TextCaseFlags.byValue(DU.getAttribute(element, "textcase"));
		x.language = LanguageCodeIso6392Bs.byValue(DU.getAttribute(element, "language"));
		x.transliteration = TransliterationSchemeCodes.byValue(DU.getAttribute(element, "transliteration"));
		x.datestamp = DU.getAttribute(element, "datestamp");
		x.sourcetype = RecordSourceTypeCodes.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		DU.forElementsOf(element, new DU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(SeriesISSN.refname) || name.equals(SeriesISSN.shortname))
					x.seriesISSN = SeriesISSN.fromDoc(element);
				else if (name.equals(PublisherSeriesCode.refname) || name.equals(PublisherSeriesCode.shortname))
					x.publisherSeriesCode = PublisherSeriesCode.fromDoc(element);
				else if (name.equals(SeriesIdentifier.refname) || name.equals(SeriesIdentifier.shortname))
					x.seriesIdentifiers = DU.addToList(x.seriesIdentifiers, SeriesIdentifier.fromDoc(element));
				else if (name.equals(TitleOfSeries.refname) || name.equals(TitleOfSeries.shortname))
					x.titleOfSeries = TitleOfSeries.fromDoc(element);
				else if (name.equals(Title.refname) || name.equals(Title.shortname))
					x.titles = DU.addToList(x.titles, Title.fromDoc(element));
				else if (name.equals(Contributor.refname) || name.equals(Contributor.shortname))
					x.contributors = DU.addToList(x.contributors, Contributor.fromDoc(element));
				else if (name.equals(NumberWithinSeries.refname) || name.equals(NumberWithinSeries.shortname))
					x.numberWithinSeries = NumberWithinSeries.fromDoc(element);
				else if (name.equals(YearOfAnnual.refname) || name.equals(YearOfAnnual.shortname))
					x.yearOfAnnual = YearOfAnnual.fromDoc(element);
			}
		});

		return x;
	}
}
