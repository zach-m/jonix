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

import java.util.List;

import com.tectonica.jonix.DU;
import com.tectonica.jonix.codelist.RecordSourceTypeCodes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

public class ContentItem
{
	public static final String refname = "ContentItem";
	public static final String shortname = "contentitem";

	public String datestamp; // dt.DateOrDateTime
	public RecordSourceTypeCodes sourcetype;
	public String sourcename;

	public LevelSequenceNumber levelSequenceNumber; // Optional
	public TextItem textItem; // Required
	public ComponentTypeName componentTypeName; // Required
	public ComponentNumber componentNumber; // Optional
	public List<TitleDetail> titleDetails; // ZeroOrMore
	public List<Contributor> contributors; // ZeroOrMore
	public List<Subject> subjects; // ZeroOrMore
	public List<NameAsSubject> nameAsSubjects; // ZeroOrMore
	public List<TextContent> textContents; // ZeroOrMore
	public List<CitedContent> citedContents; // ZeroOrMore
	public List<SupportingResource> supportingResources; // ZeroOrMore
	public List<RelatedWork> relatedWorks; // ZeroOrMore

	public static ContentItem fromDoc(org.w3c.dom.Element element)
	{
		final ContentItem x = new ContentItem();

		x.datestamp = DU.getAttribute(element, "datestamp");
		x.sourcetype = RecordSourceTypeCodes.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		DU.forElementsOf(element, new DU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(LevelSequenceNumber.refname) || name.equals(LevelSequenceNumber.shortname))
					x.levelSequenceNumber = LevelSequenceNumber.fromDoc(element);
				else if (name.equals(TextItem.refname) || name.equals(TextItem.shortname))
					x.textItem = TextItem.fromDoc(element);
				else if (name.equals(ComponentTypeName.refname) || name.equals(ComponentTypeName.shortname))
					x.componentTypeName = ComponentTypeName.fromDoc(element);
				else if (name.equals(ComponentNumber.refname) || name.equals(ComponentNumber.shortname))
					x.componentNumber = ComponentNumber.fromDoc(element);
				else if (name.equals(TitleDetail.refname) || name.equals(TitleDetail.shortname))
					x.titleDetails = DU.addToList(x.titleDetails, TitleDetail.fromDoc(element));
				else if (name.equals(Contributor.refname) || name.equals(Contributor.shortname))
					x.contributors = DU.addToList(x.contributors, Contributor.fromDoc(element));
				else if (name.equals(Subject.refname) || name.equals(Subject.shortname))
					x.subjects = DU.addToList(x.subjects, Subject.fromDoc(element));
				else if (name.equals(NameAsSubject.refname) || name.equals(NameAsSubject.shortname))
					x.nameAsSubjects = DU.addToList(x.nameAsSubjects, NameAsSubject.fromDoc(element));
				else if (name.equals(TextContent.refname) || name.equals(TextContent.shortname))
					x.textContents = DU.addToList(x.textContents, TextContent.fromDoc(element));
				else if (name.equals(CitedContent.refname) || name.equals(CitedContent.shortname))
					x.citedContents = DU.addToList(x.citedContents, CitedContent.fromDoc(element));
				else if (name.equals(SupportingResource.refname) || name.equals(SupportingResource.shortname))
					x.supportingResources = DU.addToList(x.supportingResources, SupportingResource.fromDoc(element));
				else if (name.equals(RelatedWork.refname) || name.equals(RelatedWork.shortname))
					x.relatedWorks = DU.addToList(x.relatedWorks, RelatedWork.fromDoc(element));
			}
		});

		return x;
	}
}
