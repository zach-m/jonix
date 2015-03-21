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
import com.tectonica.jonix.codelist.LanguageCodeIso6392Bs;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.SeriesIdentifierTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TitleTypes;
import com.tectonica.jonix.codelist.TransliterationSchemes;
import com.tectonica.jonix.struct.SeriesIdentifierStruct;
import com.tectonica.jonix.struct.TitleStruct;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

@SuppressWarnings("serial")
public class Series implements Serializable
{
	public static final String refname = "Series";
	public static final String shortname = "series";

	public TextFormats textformat;
	public TextCaseFlags textcase;
	public LanguageCodeIso6392Bs language;
	public TransliterationSchemes transliteration;
	public String datestamp; // DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public SeriesISSN seriesISSN; // Optional
	public PublisherSeriesCode publisherSeriesCode; // Optional
	public List<SeriesIdentifier> seriesIdentifiers; // ZeroOrMore
	public TitleOfSeries titleOfSeries; // Required
	public List<Title> titles; // ZeroOrMore
	public List<Contributor> contributors; // ZeroOrMore
	public NumberWithinSeries numberWithinSeries; // Optional
	public YearOfAnnual yearOfAnnual; // Optional

	public Series()
	{}

	public Series(org.w3c.dom.Element element)
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
				if (name.equals(SeriesISSN.refname) || name.equals(SeriesISSN.shortname))
					seriesISSN = new SeriesISSN(element);
				else if (name.equals(PublisherSeriesCode.refname) || name.equals(PublisherSeriesCode.shortname))
					publisherSeriesCode = new PublisherSeriesCode(element);
				else if (name.equals(SeriesIdentifier.refname) || name.equals(SeriesIdentifier.shortname))
					seriesIdentifiers = JPU.addToList(seriesIdentifiers, new SeriesIdentifier(element));
				else if (name.equals(TitleOfSeries.refname) || name.equals(TitleOfSeries.shortname))
					titleOfSeries = new TitleOfSeries(element);
				else if (name.equals(Title.refname) || name.equals(Title.shortname))
					titles = JPU.addToList(titles, new Title(element));
				else if (name.equals(Contributor.refname) || name.equals(Contributor.shortname))
					contributors = JPU.addToList(contributors, new Contributor(element));
				else if (name.equals(NumberWithinSeries.refname) || name.equals(NumberWithinSeries.shortname))
					numberWithinSeries = new NumberWithinSeries(element);
				else if (name.equals(YearOfAnnual.refname) || name.equals(YearOfAnnual.shortname))
					yearOfAnnual = new YearOfAnnual(element);
			}
		});
	}

	public String getSeriesISSNValue()
	{
		return (seriesISSN == null) ? null : seriesISSN.value;
	}

	public String getPublisherSeriesCodeValue()
	{
		return (publisherSeriesCode == null) ? null : publisherSeriesCode.value;
	}

	public String getTitleOfSeriesValue()
	{
		return (titleOfSeries == null) ? null : titleOfSeries.value;
	}

	public String getNumberWithinSeriesValue()
	{
		return (numberWithinSeries == null) ? null : numberWithinSeries.value;
	}

	public String getYearOfAnnualValue()
	{
		return (yearOfAnnual == null) ? null : yearOfAnnual.value;
	}

	public SeriesIdentifierStruct findSeriesIdentifier(SeriesIdentifierTypes seriesIDType)
	{
		if (seriesIdentifiers != null)
		{
			for (SeriesIdentifier x : seriesIdentifiers)
			{
				if (x.getSeriesIDTypeValue() == seriesIDType)
					return x.asStruct();
			}
		}
		return null;
	}

	public List<SeriesIdentifierStruct> findSeriesIdentifiers(java.util.Set<SeriesIdentifierTypes> seriesIDTypes)
	{
		if (seriesIdentifiers != null)
		{
			List<SeriesIdentifierStruct> matches = new ArrayList<>();
			for (SeriesIdentifier x : seriesIdentifiers)
			{
				if (seriesIDTypes.contains(x.getSeriesIDTypeValue()))
					matches.add(x.asStruct());
			}
			return matches;
		}
		return null;
	}

	public TitleStruct findTitle(TitleTypes titleType)
	{
		if (titles != null)
		{
			for (Title x : titles)
			{
				if (x.getTitleTypeValue() == titleType)
					return x.asStruct();
			}
		}
		return null;
	}

	public List<TitleStruct> findTitles(java.util.Set<TitleTypes> titleTypes)
	{
		if (titles != null)
		{
			List<TitleStruct> matches = new ArrayList<>();
			for (Title x : titles)
			{
				if (titleTypes.contains(x.getTitleTypeValue()))
					matches.add(x.asStruct());
			}
			return matches;
		}
		return null;
	}
}
