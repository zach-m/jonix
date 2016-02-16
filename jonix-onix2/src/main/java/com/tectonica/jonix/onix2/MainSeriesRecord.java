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
import com.tectonica.jonix.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.codelist.LanguageCodes;
import com.tectonica.jonix.codelist.NameCodeTypes;
import com.tectonica.jonix.codelist.NotificationOrUpdateTypes;
import com.tectonica.jonix.codelist.OtherTextTypes;
import com.tectonica.jonix.codelist.ProductCompositions;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.SeriesIdentifierTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TitleTypes;
import com.tectonica.jonix.codelist.TransliterationSchemes;
import com.tectonica.jonix.struct.JonixOtherText;
import com.tectonica.jonix.struct.JonixSeriesIdentifier;
import com.tectonica.jonix.struct.JonixTitle;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

public class MainSeriesRecord implements OnixSuperComposite, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "MainSeriesRecord";
	public static final String shortname = "mainseriesrecord";

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
	public RecordReference recordReference;

	/**
	 * (this field is required)
	 */
	public NotificationType notificationType;

	/**
	 * (this field is optional)
	 */
	public DeletionCode deletionCode;

	/**
	 * (this field is optional)
	 */
	public DeletionText deletionText;

	/**
	 * (this field is optional)
	 */
	public RecordSourceType recordSourceType;

	/**
	 * (this field is optional)
	 */
	public RecordSourceIdentifierType recordSourceIdentifierType;

	/**
	 * (this field is optional)
	 */
	public RecordSourceIdentifier recordSourceIdentifier;

	/**
	 * (this field is optional)
	 */
	public RecordSourceName recordSourceName;

	/**
	 * (this list is required to contain at least one item)
	 */
	public List<SeriesIdentifier> seriesIdentifiers;

	/**
	 * (this list is required to contain at least one item)
	 */
	public List<Title> titles;

	/**
	 * (this list may be empty)
	 */
	public List<Contributor> contributors;

	/**
	 * (this list may be empty)
	 */
	public List<OtherText> otherTexts;

	/**
	 * (this list may be empty)
	 */
	public List<Publisher> publishers;

	/**
	 * (this field is optional)
	 */
	public SubordinateEntries subordinateEntries;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public MainSeriesRecord()
	{}

	public MainSeriesRecord(org.w3c.dom.Element element)
	{
		textformat = TextFormats.byValue(JPU.getAttribute(element, "textformat"));
		textcase = TextCaseFlags.byValue(JPU.getAttribute(element, "textcase"));
		language = LanguageCodes.byValue(JPU.getAttribute(element, "language"));
		transliteration = TransliterationSchemes.byValue(JPU.getAttribute(element, "transliteration"));
		datestamp = JPU.getAttribute(element, "datestamp");
		sourcetype = RecordSourceTypes.byValue(JPU.getAttribute(element, "sourcetype"));
		sourcename = JPU.getAttribute(element, "sourcename");

		JPU.forElementsOf(element, new JPU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(RecordReference.refname) || name.equals(RecordReference.shortname))
					recordReference = new RecordReference(element);
				else if (name.equals(NotificationType.refname) || name.equals(NotificationType.shortname))
					notificationType = new NotificationType(element);
				else if (name.equals(DeletionCode.refname) || name.equals(DeletionCode.shortname))
					deletionCode = new DeletionCode(element);
				else if (name.equals(DeletionText.refname) || name.equals(DeletionText.shortname))
					deletionText = new DeletionText(element);
				else if (name.equals(RecordSourceType.refname) || name.equals(RecordSourceType.shortname))
					recordSourceType = new RecordSourceType(element);
				else if (name.equals(RecordSourceIdentifierType.refname)
						|| name.equals(RecordSourceIdentifierType.shortname))
					recordSourceIdentifierType = new RecordSourceIdentifierType(element);
				else if (name.equals(RecordSourceIdentifier.refname) || name.equals(RecordSourceIdentifier.shortname))
					recordSourceIdentifier = new RecordSourceIdentifier(element);
				else if (name.equals(RecordSourceName.refname) || name.equals(RecordSourceName.shortname))
					recordSourceName = new RecordSourceName(element);
				else if (name.equals(SeriesIdentifier.refname) || name.equals(SeriesIdentifier.shortname))
					seriesIdentifiers = JPU.addToList(seriesIdentifiers, new SeriesIdentifier(element));
				else if (name.equals(Title.refname) || name.equals(Title.shortname))
					titles = JPU.addToList(titles, new Title(element));
				else if (name.equals(Contributor.refname) || name.equals(Contributor.shortname))
					contributors = JPU.addToList(contributors, new Contributor(element));
				else if (name.equals(OtherText.refname) || name.equals(OtherText.shortname))
					otherTexts = JPU.addToList(otherTexts, new OtherText(element));
				else if (name.equals(Publisher.refname) || name.equals(Publisher.shortname))
					publishers = JPU.addToList(publishers, new Publisher(element));
				else if (name.equals(SubordinateEntries.refname) || name.equals(SubordinateEntries.shortname))
					subordinateEntries = new SubordinateEntries(element);
			}
		});
	}

	public String getRecordReferenceValue()
	{
		return (recordReference == null) ? null : recordReference.value;
	}

	public NotificationOrUpdateTypes getNotificationTypeValue()
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

	public RecordSourceTypes getRecordSourceTypeValue()
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

	public JonixSeriesIdentifier findSeriesIdentifier(SeriesIdentifierTypes seriesIDType)
	{
		if (seriesIdentifiers != null)
		{
			for (SeriesIdentifier x : seriesIdentifiers)
			{
				if (x.getSeriesIDTypeValue() == seriesIDType)
					return x.asJonixSeriesIdentifier();
			}
		}
		return null;
	}

	public List<JonixSeriesIdentifier> findSeriesIdentifiers(java.util.Set<SeriesIdentifierTypes> seriesIDTypes)
	{
		if (seriesIdentifiers != null)
		{
			List<JonixSeriesIdentifier> matches = new ArrayList<>();
			for (SeriesIdentifier x : seriesIdentifiers)
			{
				if (seriesIDTypes == null || seriesIDTypes.contains(x.getSeriesIDTypeValue()))
					matches.add(x.asJonixSeriesIdentifier());
			}
			return matches;
		}
		return null;
	}

	public JonixTitle findTitle(TitleTypes titleType)
	{
		if (titles != null)
		{
			for (Title x : titles)
			{
				if (x.getTitleTypeValue() == titleType)
					return x.asJonixTitle();
			}
		}
		return null;
	}

	public List<JonixTitle> findTitles(java.util.Set<TitleTypes> titleTypes)
	{
		if (titles != null)
		{
			List<JonixTitle> matches = new ArrayList<>();
			for (Title x : titles)
			{
				if (titleTypes == null || titleTypes.contains(x.getTitleTypeValue()))
					matches.add(x.asJonixTitle());
			}
			return matches;
		}
		return null;
	}

	public JonixOtherText findOtherText(OtherTextTypes textTypeCode)
	{
		if (otherTexts != null)
		{
			for (OtherText x : otherTexts)
			{
				if (x.getTextTypeCodeValue() == textTypeCode)
					return x.asJonixOtherText();
			}
		}
		return null;
	}

	public List<JonixOtherText> findOtherTexts(java.util.Set<OtherTextTypes> textTypeCodes)
	{
		if (otherTexts != null)
		{
			List<JonixOtherText> matches = new ArrayList<>();
			for (OtherText x : otherTexts)
			{
				if (textTypeCodes == null || textTypeCodes.contains(x.getTextTypeCodeValue()))
					matches.add(x.asJonixOtherText());
			}
			return matches;
		}
		return null;
	}
}
