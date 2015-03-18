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

package com.tectonica.jonix.onix3.model;

import java.util.List;

import com.tectonica.jonix.onix3.DU;
import com.tectonica.jonix.onix3.codelist.List3;

public class ContentItem
{
	public static final String refname = "ContentItem";
	public static final String shortname = "contentitem";

	public String datestamp; // dt.DateOrDateTime
	public List3 sourcetype;
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
				else if (name.equalsIgnoreCase(ComponentTypeName.refname) || name.equalsIgnoreCase(ComponentTypeName.shortname))
					x.componentTypeName = ComponentTypeName.fromDoc(element);
				else if (name.equalsIgnoreCase(ComponentNumber.refname) || name.equalsIgnoreCase(ComponentNumber.shortname))
					x.componentNumber = ComponentNumber.fromDoc(element);
				else if (name.equalsIgnoreCase(TitleDetail.refname) || name.equalsIgnoreCase(TitleDetail.shortname))
					x.titleDetails = DU.addToList(x.titleDetails, TitleDetail.fromDoc(element));
				else if (name.equalsIgnoreCase(Contributor.refname) || name.equalsIgnoreCase(Contributor.shortname))
					x.contributors = DU.addToList(x.contributors, Contributor.fromDoc(element));
				else if (name.equalsIgnoreCase(Subject.refname) || name.equalsIgnoreCase(Subject.shortname))
					x.subjects = DU.addToList(x.subjects, Subject.fromDoc(element));
				else if (name.equalsIgnoreCase(NameAsSubject.refname) || name.equalsIgnoreCase(NameAsSubject.shortname))
					x.nameAsSubjects = DU.addToList(x.nameAsSubjects, NameAsSubject.fromDoc(element));
				else if (name.equalsIgnoreCase(TextContent.refname) || name.equalsIgnoreCase(TextContent.shortname))
					x.textContents = DU.addToList(x.textContents, TextContent.fromDoc(element));
				else if (name.equalsIgnoreCase(CitedContent.refname) || name.equalsIgnoreCase(CitedContent.shortname))
					x.citedContents = DU.addToList(x.citedContents, CitedContent.fromDoc(element));
				else if (name.equalsIgnoreCase(SupportingResource.refname) || name.equalsIgnoreCase(SupportingResource.shortname))
					x.supportingResources = DU.addToList(x.supportingResources, SupportingResource.fromDoc(element));
				else if (name.equalsIgnoreCase(RelatedWork.refname) || name.equalsIgnoreCase(RelatedWork.shortname))
					x.relatedWorks = DU.addToList(x.relatedWorks, RelatedWork.fromDoc(element));
			}
		});

		return x;
	}
}
