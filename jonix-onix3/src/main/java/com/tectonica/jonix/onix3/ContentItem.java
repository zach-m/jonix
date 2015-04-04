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

import java.io.Serializable;
import java.util.List;

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.codelist.RecordSourceTypes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

@SuppressWarnings("serial")
public class ContentItem implements OnixSuperComposite, Serializable
{
	public static final String refname = "ContentItem";
	public static final String shortname = "contentitem";

	public String datestamp; // dt.DateOrDateTime
	public RecordSourceTypes sourcetype;
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

	public ContentItem()
	{}

	public ContentItem(org.w3c.dom.Element element)
	{
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
				else if (name.equals(ComponentTypeName.refname) || name.equals(ComponentTypeName.shortname))
					componentTypeName = new ComponentTypeName(element);
				else if (name.equals(ComponentNumber.refname) || name.equals(ComponentNumber.shortname))
					componentNumber = new ComponentNumber(element);
				else if (name.equals(TitleDetail.refname) || name.equals(TitleDetail.shortname))
					titleDetails = JPU.addToList(titleDetails, new TitleDetail(element));
				else if (name.equals(Contributor.refname) || name.equals(Contributor.shortname))
					contributors = JPU.addToList(contributors, new Contributor(element));
				else if (name.equals(Subject.refname) || name.equals(Subject.shortname))
					subjects = JPU.addToList(subjects, new Subject(element));
				else if (name.equals(NameAsSubject.refname) || name.equals(NameAsSubject.shortname))
					nameAsSubjects = JPU.addToList(nameAsSubjects, new NameAsSubject(element));
				else if (name.equals(TextContent.refname) || name.equals(TextContent.shortname))
					textContents = JPU.addToList(textContents, new TextContent(element));
				else if (name.equals(CitedContent.refname) || name.equals(CitedContent.shortname))
					citedContents = JPU.addToList(citedContents, new CitedContent(element));
				else if (name.equals(SupportingResource.refname) || name.equals(SupportingResource.shortname))
					supportingResources = JPU.addToList(supportingResources, new SupportingResource(element));
				else if (name.equals(RelatedWork.refname) || name.equals(RelatedWork.shortname))
					relatedWorks = JPU.addToList(relatedWorks, new RelatedWork(element));
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
}
