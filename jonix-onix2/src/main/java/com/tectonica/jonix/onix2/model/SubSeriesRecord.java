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

package com.tectonica.jonix.onix2.model;

import java.util.List;

import com.tectonica.jonix.onix2.DU;
import com.tectonica.jonix.onix2.codelist.List138;
import com.tectonica.jonix.onix2.codelist.List14;
import com.tectonica.jonix.onix2.codelist.List3;
import com.tectonica.jonix.onix2.codelist.List34;
import com.tectonica.jonix.onix2.codelist.List74;

public class SubSeriesRecord
{
	public static final String refname = "SubSeriesRecord";
	public static final String shortname = "subseriesrecord";

	public List34 textformat;
	public List14 textcase;
	public List74 language;
	public List138 transliteration;
	public String datestamp; // DateOrDateTime
	public List3 sourcetype;
	public String sourcename;

	public RecordReference recordReference; // Required
	public NotificationType notificationType; // Required
	public DeletionCode deletionCode; // Optional
	public DeletionText deletionText; // Optional
	public RecordSourceType recordSourceType; // Optional
	public RecordSourceIdentifierType recordSourceIdentifierType; // Optional
	public RecordSourceIdentifier recordSourceIdentifier; // Optional
	public RecordSourceName recordSourceName; // Optional
	public List<SeriesIdentifier> seriesIdentifiers; // OneOrMore
	public ParentIdentifier parentIdentifier; // Required
	public LevelSequenceNumber levelSequenceNumber; // Required
	public SeriesPartName seriesPartName; // Optional
	public NumberWithinSeries numberWithinSeries; // Optional
	public List<Title> titles; // OneOrMore
	public List<Contributor> contributors; // ZeroOrMore
	public List<OtherText> otherTexts; // ZeroOrMore
	public List<Publisher> publishers; // ZeroOrMore
	public SubordinateEntries subordinateEntries; // Optional

	public static SubSeriesRecord fromDoc(org.w3c.dom.Element element)
	{
		final SubSeriesRecord x = new SubSeriesRecord();

		x.textformat = List34.byValue(DU.getAttribute(element, "textformat"));
		x.textcase = List14.byValue(DU.getAttribute(element, "textcase"));
		x.language = List74.byValue(DU.getAttribute(element, "language"));
		x.transliteration = List138.byValue(DU.getAttribute(element, "transliteration"));
		x.datestamp = DU.getAttribute(element, "datestamp");
		x.sourcetype = List3.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		DU.forElementsOf(element, new DU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equalsIgnoreCase(RecordReference.refname) || name.equalsIgnoreCase(RecordReference.shortname))
					x.recordReference = RecordReference.fromDoc(element);
				else if (name.equalsIgnoreCase(NotificationType.refname) || name.equalsIgnoreCase(NotificationType.shortname))
					x.notificationType = NotificationType.fromDoc(element);
				else if (name.equalsIgnoreCase(DeletionCode.refname) || name.equalsIgnoreCase(DeletionCode.shortname))
					x.deletionCode = DeletionCode.fromDoc(element);
				else if (name.equalsIgnoreCase(DeletionText.refname) || name.equalsIgnoreCase(DeletionText.shortname))
					x.deletionText = DeletionText.fromDoc(element);
				else if (name.equalsIgnoreCase(RecordSourceType.refname) || name.equalsIgnoreCase(RecordSourceType.shortname))
					x.recordSourceType = RecordSourceType.fromDoc(element);
				else if (name.equalsIgnoreCase(RecordSourceIdentifierType.refname)
						|| name.equalsIgnoreCase(RecordSourceIdentifierType.shortname))
					x.recordSourceIdentifierType = RecordSourceIdentifierType.fromDoc(element);
				else if (name.equalsIgnoreCase(RecordSourceIdentifier.refname) || name.equalsIgnoreCase(RecordSourceIdentifier.shortname))
					x.recordSourceIdentifier = RecordSourceIdentifier.fromDoc(element);
				else if (name.equalsIgnoreCase(RecordSourceName.refname) || name.equalsIgnoreCase(RecordSourceName.shortname))
					x.recordSourceName = RecordSourceName.fromDoc(element);
				else if (name.equalsIgnoreCase(SeriesIdentifier.refname) || name.equalsIgnoreCase(SeriesIdentifier.shortname))
					x.seriesIdentifiers = DU.addToList(x.seriesIdentifiers, SeriesIdentifier.fromDoc(element));
				else if (name.equalsIgnoreCase(ParentIdentifier.refname) || name.equalsIgnoreCase(ParentIdentifier.shortname))
					x.parentIdentifier = ParentIdentifier.fromDoc(element);
				else if (name.equalsIgnoreCase(LevelSequenceNumber.refname) || name.equalsIgnoreCase(LevelSequenceNumber.shortname))
					x.levelSequenceNumber = LevelSequenceNumber.fromDoc(element);
				else if (name.equalsIgnoreCase(SeriesPartName.refname) || name.equalsIgnoreCase(SeriesPartName.shortname))
					x.seriesPartName = SeriesPartName.fromDoc(element);
				else if (name.equalsIgnoreCase(NumberWithinSeries.refname) || name.equalsIgnoreCase(NumberWithinSeries.shortname))
					x.numberWithinSeries = NumberWithinSeries.fromDoc(element);
				else if (name.equalsIgnoreCase(Title.refname) || name.equalsIgnoreCase(Title.shortname))
					x.titles = DU.addToList(x.titles, Title.fromDoc(element));
				else if (name.equalsIgnoreCase(Contributor.refname) || name.equalsIgnoreCase(Contributor.shortname))
					x.contributors = DU.addToList(x.contributors, Contributor.fromDoc(element));
				else if (name.equalsIgnoreCase(OtherText.refname) || name.equalsIgnoreCase(OtherText.shortname))
					x.otherTexts = DU.addToList(x.otherTexts, OtherText.fromDoc(element));
				else if (name.equalsIgnoreCase(Publisher.refname) || name.equalsIgnoreCase(Publisher.shortname))
					x.publishers = DU.addToList(x.publishers, Publisher.fromDoc(element));
				else if (name.equalsIgnoreCase(SubordinateEntries.refname) || name.equalsIgnoreCase(SubordinateEntries.shortname))
					x.subordinateEntries = SubordinateEntries.fromDoc(element);
			}
		});

		return x;
	}
}
