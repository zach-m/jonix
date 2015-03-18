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

public class ContentItem
{
	public static final String refname = "ContentItem";
	public static final String shortname = "contentitem";

	public List34 textformat;
	public List14 textcase;
	public List74 language;
	public List138 transliteration;
	public String datestamp; // DateOrDateTime
	public List3 sourcetype;
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

	public static ContentItem fromDoc(org.w3c.dom.Element element)
	{
		final ContentItem x = new ContentItem();

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
				if (name.equalsIgnoreCase(LevelSequenceNumber.refname) || name.equalsIgnoreCase(LevelSequenceNumber.shortname))
					x.levelSequenceNumber = LevelSequenceNumber.fromDoc(element);
				else if (name.equalsIgnoreCase(TextItem.refname) || name.equalsIgnoreCase(TextItem.shortname))
					x.textItem = TextItem.fromDoc(element);
				else if (name.equalsIgnoreCase(Website.refname) || name.equalsIgnoreCase(Website.shortname))
					x.websites = DU.addToList(x.websites, Website.fromDoc(element));
				else if (name.equalsIgnoreCase(ComponentTypeName.refname) || name.equalsIgnoreCase(ComponentTypeName.shortname))
					x.componentTypeName = ComponentTypeName.fromDoc(element);
				else if (name.equalsIgnoreCase(ComponentNumber.refname) || name.equalsIgnoreCase(ComponentNumber.shortname))
					x.componentNumber = ComponentNumber.fromDoc(element);
				else if (name.equalsIgnoreCase(DistinctiveTitle.refname) || name.equalsIgnoreCase(DistinctiveTitle.shortname))
					x.distinctiveTitle = DistinctiveTitle.fromDoc(element);
				else if (name.equalsIgnoreCase(Title.refname) || name.equalsIgnoreCase(Title.shortname))
					x.titles = DU.addToList(x.titles, Title.fromDoc(element));
				else if (name.equalsIgnoreCase(WorkIdentifier.refname) || name.equalsIgnoreCase(WorkIdentifier.shortname))
					x.workIdentifiers = DU.addToList(x.workIdentifiers, WorkIdentifier.fromDoc(element));
				else if (name.equalsIgnoreCase(Contributor.refname) || name.equalsIgnoreCase(Contributor.shortname))
					x.contributors = DU.addToList(x.contributors, Contributor.fromDoc(element));
				else if (name.equalsIgnoreCase(ContributorStatement.refname) || name.equalsIgnoreCase(ContributorStatement.shortname))
					x.contributorStatement = ContributorStatement.fromDoc(element);
				else if (name.equalsIgnoreCase(Subject.refname) || name.equalsIgnoreCase(Subject.shortname))
					x.subjects = DU.addToList(x.subjects, Subject.fromDoc(element));
				else if (name.equalsIgnoreCase(PersonAsSubject.refname) || name.equalsIgnoreCase(PersonAsSubject.shortname))
					x.personAsSubjects = DU.addToList(x.personAsSubjects, PersonAsSubject.fromDoc(element));
				else if (name.equalsIgnoreCase(CorporateBodyAsSubject.refname) || name.equalsIgnoreCase(CorporateBodyAsSubject.shortname))
					x.corporateBodyAsSubjects = DU.addToList(x.corporateBodyAsSubjects, CorporateBodyAsSubject.fromDoc(element));
				else if (name.equalsIgnoreCase(PlaceAsSubject.refname) || name.equalsIgnoreCase(PlaceAsSubject.shortname))
					x.placeAsSubjects = DU.addToList(x.placeAsSubjects, PlaceAsSubject.fromDoc(element));
				else if (name.equalsIgnoreCase(OtherText.refname) || name.equalsIgnoreCase(OtherText.shortname))
					x.otherTexts = DU.addToList(x.otherTexts, OtherText.fromDoc(element));
				else if (name.equalsIgnoreCase(MediaFile.refname) || name.equalsIgnoreCase(MediaFile.shortname))
					x.mediaFiles = DU.addToList(x.mediaFiles, MediaFile.fromDoc(element));
			}
		});

		return x;
	}
}
