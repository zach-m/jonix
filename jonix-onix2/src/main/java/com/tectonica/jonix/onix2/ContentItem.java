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
import com.tectonica.jonix.JonixComposite;
import com.tectonica.jonix.codelist.ImageAudioVideoFileTypes;
import com.tectonica.jonix.codelist.LanguageCodeIso6392Bs;
import com.tectonica.jonix.codelist.OtherTextTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TitleTypes;
import com.tectonica.jonix.codelist.TransliterationSchemes;
import com.tectonica.jonix.codelist.WorkIdentifierTypes;
import com.tectonica.jonix.struct.JonixMediaFile;
import com.tectonica.jonix.struct.JonixOtherText;
import com.tectonica.jonix.struct.JonixTitle;
import com.tectonica.jonix.struct.JonixWorkIdentifier;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

@SuppressWarnings("serial")
public class ContentItem implements JonixComposite, Serializable
{
	public static final String refname = "ContentItem";
	public static final String shortname = "contentitem";

	public TextFormats textformat;
	public TextCaseFlags textcase;
	public LanguageCodeIso6392Bs language;
	public TransliterationSchemes transliteration;
	public String datestamp; // DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public LevelSequenceNumber levelSequenceNumber; // Optional
	public TextItem textItem; // Required
	public List<Website> websites; // ZeroOrMore
	public ComponentTypeName componentTypeName; // Required
	public ComponentNumber componentNumber; // Optional
	public DistinctiveTitle distinctiveTitle; // Optional
	public List<Title> titles; // ZeroOrMore
	public List<WorkIdentifier> workIdentifiers; // ZeroOrMore
	public List<Contributor> contributors; // ZeroOrMore
	public ContributorStatement contributorStatement; // Optional
	public List<Subject> subjects; // ZeroOrMore
	public List<PersonAsSubject> personAsSubjects; // ZeroOrMore
	public List<CorporateBodyAsSubject> corporateBodyAsSubjects; // ZeroOrMore
	public List<PlaceAsSubject> placeAsSubjects; // ZeroOrMore
	public List<OtherText> otherTexts; // ZeroOrMore
	public List<MediaFile> mediaFiles; // ZeroOrMore

	public ContentItem()
	{}

	public ContentItem(org.w3c.dom.Element element)
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
				if (name.equals(LevelSequenceNumber.refname) || name.equals(LevelSequenceNumber.shortname))
					levelSequenceNumber = new LevelSequenceNumber(element);
				else if (name.equals(TextItem.refname) || name.equals(TextItem.shortname))
					textItem = new TextItem(element);
				else if (name.equals(Website.refname) || name.equals(Website.shortname))
					websites = JPU.addToList(websites, new Website(element));
				else if (name.equals(ComponentTypeName.refname) || name.equals(ComponentTypeName.shortname))
					componentTypeName = new ComponentTypeName(element);
				else if (name.equals(ComponentNumber.refname) || name.equals(ComponentNumber.shortname))
					componentNumber = new ComponentNumber(element);
				else if (name.equals(DistinctiveTitle.refname) || name.equals(DistinctiveTitle.shortname))
					distinctiveTitle = new DistinctiveTitle(element);
				else if (name.equals(Title.refname) || name.equals(Title.shortname))
					titles = JPU.addToList(titles, new Title(element));
				else if (name.equals(WorkIdentifier.refname) || name.equals(WorkIdentifier.shortname))
					workIdentifiers = JPU.addToList(workIdentifiers, new WorkIdentifier(element));
				else if (name.equals(Contributor.refname) || name.equals(Contributor.shortname))
					contributors = JPU.addToList(contributors, new Contributor(element));
				else if (name.equals(ContributorStatement.refname) || name.equals(ContributorStatement.shortname))
					contributorStatement = new ContributorStatement(element);
				else if (name.equals(Subject.refname) || name.equals(Subject.shortname))
					subjects = JPU.addToList(subjects, new Subject(element));
				else if (name.equals(PersonAsSubject.refname) || name.equals(PersonAsSubject.shortname))
					personAsSubjects = JPU.addToList(personAsSubjects, new PersonAsSubject(element));
				else if (name.equals(CorporateBodyAsSubject.refname) || name.equals(CorporateBodyAsSubject.shortname))
					corporateBodyAsSubjects = JPU.addToList(corporateBodyAsSubjects, new CorporateBodyAsSubject(element));
				else if (name.equals(PlaceAsSubject.refname) || name.equals(PlaceAsSubject.shortname))
					placeAsSubjects = JPU.addToList(placeAsSubjects, new PlaceAsSubject(element));
				else if (name.equals(OtherText.refname) || name.equals(OtherText.shortname))
					otherTexts = JPU.addToList(otherTexts, new OtherText(element));
				else if (name.equals(MediaFile.refname) || name.equals(MediaFile.shortname))
					mediaFiles = JPU.addToList(mediaFiles, new MediaFile(element));
			}
		});
	}

	public String getLevelSequenceNumberValue()
	{
		return (levelSequenceNumber == null) ? null : levelSequenceNumber.value;
	}

	public String getComponentTypeNameValue()
	{
		return (componentTypeName == null) ? null : componentTypeName.value;
	}

	public String getComponentNumberValue()
	{
		return (componentNumber == null) ? null : componentNumber.value;
	}

	public String getDistinctiveTitleValue()
	{
		return (distinctiveTitle == null) ? null : distinctiveTitle.value;
	}

	public String getContributorStatementValue()
	{
		return (contributorStatement == null) ? null : contributorStatement.value;
	}

	public List<String> getCorporateBodyAsSubjectValues()
	{
		if (corporateBodyAsSubjects != null)
		{
			List<String> list = new ArrayList<>();
			for (CorporateBodyAsSubject i : corporateBodyAsSubjects)
				list.add(i.value);
			return list;
		}
		return null;
	}

	public List<String> getPlaceAsSubjectValues()
	{
		if (placeAsSubjects != null)
		{
			List<String> list = new ArrayList<>();
			for (PlaceAsSubject i : placeAsSubjects)
				list.add(i.value);
			return list;
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

	public JonixWorkIdentifier findWorkIdentifier(WorkIdentifierTypes workIDType)
	{
		if (workIdentifiers != null)
		{
			for (WorkIdentifier x : workIdentifiers)
			{
				if (x.getWorkIDTypeValue() == workIDType)
					return x.asJonixWorkIdentifier();
			}
		}
		return null;
	}

	public List<JonixWorkIdentifier> findWorkIdentifiers(java.util.Set<WorkIdentifierTypes> workIDTypes)
	{
		if (workIdentifiers != null)
		{
			List<JonixWorkIdentifier> matches = new ArrayList<>();
			for (WorkIdentifier x : workIdentifiers)
			{
				if (workIDTypes == null || workIDTypes.contains(x.getWorkIDTypeValue()))
					matches.add(x.asJonixWorkIdentifier());
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

	public JonixMediaFile findMediaFile(ImageAudioVideoFileTypes mediaFileTypeCode)
	{
		if (mediaFiles != null)
		{
			for (MediaFile x : mediaFiles)
			{
				if (x.getMediaFileTypeCodeValue() == mediaFileTypeCode)
					return x.asJonixMediaFile();
			}
		}
		return null;
	}

	public List<JonixMediaFile> findMediaFiles(java.util.Set<ImageAudioVideoFileTypes> mediaFileTypeCodes)
	{
		if (mediaFiles != null)
		{
			List<JonixMediaFile> matches = new ArrayList<>();
			for (MediaFile x : mediaFiles)
			{
				if (mediaFileTypeCodes == null || mediaFileTypeCodes.contains(x.getMediaFileTypeCodeValue()))
					matches.add(x.asJonixMediaFile());
			}
			return matches;
		}
		return null;
	}
}
