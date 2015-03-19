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
import com.tectonica.jonix.codelist.NameCodeTypes;
import com.tectonica.jonix.codelist.NotificationOrUpdateTypeCodes;
import com.tectonica.jonix.codelist.ProductCompositions;
import com.tectonica.jonix.codelist.RecordSourceTypeCodes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormatCodes;
import com.tectonica.jonix.codelist.TransliterationSchemeCodes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

public class MainSeriesRecord
{
	public static final String refname = "MainSeriesRecord";
	public static final String shortname = "mainseriesrecord";

	public TextFormatCodes textformat;
	public TextCaseFlags textcase;
	public LanguageCodeIso6392Bs language;
	public TransliterationSchemeCodes transliteration;
	public String datestamp; // DateOrDateTime
	public RecordSourceTypeCodes sourcetype;
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
	public List<Title> titles; // OneOrMore
	public List<Contributor> contributors; // ZeroOrMore
	public List<OtherText> otherTexts; // ZeroOrMore
	public List<Publisher> publishers; // ZeroOrMore
	public SubordinateEntries subordinateEntries; // Optional

	public static MainSeriesRecord fromDoc(org.w3c.dom.Element element)
	{
		final MainSeriesRecord x = new MainSeriesRecord();

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
				if (name.equals(RecordReference.refname) || name.equals(RecordReference.shortname))
					x.recordReference = RecordReference.fromDoc(element);
				else if (name.equals(NotificationType.refname) || name.equals(NotificationType.shortname))
					x.notificationType = NotificationType.fromDoc(element);
				else if (name.equals(DeletionCode.refname) || name.equals(DeletionCode.shortname))
					x.deletionCode = DeletionCode.fromDoc(element);
				else if (name.equals(DeletionText.refname) || name.equals(DeletionText.shortname))
					x.deletionText = DeletionText.fromDoc(element);
				else if (name.equals(RecordSourceType.refname) || name.equals(RecordSourceType.shortname))
					x.recordSourceType = RecordSourceType.fromDoc(element);
				else if (name.equals(RecordSourceIdentifierType.refname) || name.equals(RecordSourceIdentifierType.shortname))
					x.recordSourceIdentifierType = RecordSourceIdentifierType.fromDoc(element);
				else if (name.equals(RecordSourceIdentifier.refname) || name.equals(RecordSourceIdentifier.shortname))
					x.recordSourceIdentifier = RecordSourceIdentifier.fromDoc(element);
				else if (name.equals(RecordSourceName.refname) || name.equals(RecordSourceName.shortname))
					x.recordSourceName = RecordSourceName.fromDoc(element);
				else if (name.equals(SeriesIdentifier.refname) || name.equals(SeriesIdentifier.shortname))
					x.seriesIdentifiers = DU.addToList(x.seriesIdentifiers, SeriesIdentifier.fromDoc(element));
				else if (name.equals(Title.refname) || name.equals(Title.shortname))
					x.titles = DU.addToList(x.titles, Title.fromDoc(element));
				else if (name.equals(Contributor.refname) || name.equals(Contributor.shortname))
					x.contributors = DU.addToList(x.contributors, Contributor.fromDoc(element));
				else if (name.equals(OtherText.refname) || name.equals(OtherText.shortname))
					x.otherTexts = DU.addToList(x.otherTexts, OtherText.fromDoc(element));
				else if (name.equals(Publisher.refname) || name.equals(Publisher.shortname))
					x.publishers = DU.addToList(x.publishers, Publisher.fromDoc(element));
				else if (name.equals(SubordinateEntries.refname) || name.equals(SubordinateEntries.shortname))
					x.subordinateEntries = SubordinateEntries.fromDoc(element);
			}
		});

		return x;
	}

	public String getRecordReferenceValue()
	{
		return (recordReference == null) ? null : recordReference.value;
	}

	public NotificationOrUpdateTypeCodes getNotificationTypeValue()
	{
		return (notificationType == null) ? null : notificationType.value;
	}

	public ProductCompositions getDeletionCodeValue()
	{
		return (deletionCode == null) ? null : deletionCode.value;
	}

	public String getDeletionTextValue()
	{
		return (deletionText == null) ? null : deletionText.value;
	}

	public RecordSourceTypeCodes getRecordSourceTypeValue()
	{
		return (recordSourceType == null) ? null : recordSourceType.value;
	}

	public NameCodeTypes getRecordSourceIdentifierTypeValue()
	{
		return (recordSourceIdentifierType == null) ? null : recordSourceIdentifierType.value;
	}

	public String getRecordSourceIdentifierValue()
	{
		return (recordSourceIdentifier == null) ? null : recordSourceIdentifier.value;
	}

	public String getRecordSourceNameValue()
	{
		return (recordSourceName == null) ? null : recordSourceName.value;
	}

	public String getSubordinateEntriesValue()
	{
		return (subordinateEntries == null) ? null : subordinateEntries.value;
	}
}
