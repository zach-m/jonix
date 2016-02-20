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
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <h1>Content item composite</h1>
 * <p>
 * A repeatable group of data elements which together describe a content item within a product. Mandatory in any
 * occurrence of the &lt;ContentDetail&gt; composite.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;ContentItem&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;contentitem&gt;</td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>1&#8230;n</td>
 * </tr>
 * </table>
 */
public class ContentItem implements OnixSuperComposite, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "ContentItem";
	public static final String shortname = "contentitem";

	// ///////////////////////////////////////////////////////////////////////////////
	// ATTRIBUTES
	// ///////////////////////////////////////////////////////////////////////////////

	/**
	 * (type: dt.DateOrDateTime)
	 */
	public String datestamp;

	public RecordSourceTypes sourcetype;

	public String sourcename;

	// ///////////////////////////////////////////////////////////////////////////////
	// MEMBERS
	// ///////////////////////////////////////////////////////////////////////////////

	/**
	 * (this field is optional)
	 */
	public LevelSequenceNumber levelSequenceNumber;

	/**
	 * (this field is required)
	 */
	public TextItem textItem;

	/**
	 * (this field is required)
	 */
	public ComponentTypeName componentTypeName;

	/**
	 * (this field is optional)
	 */
	public ComponentNumber componentNumber;

	/**
	 * (this list may be empty)
	 */
	public List<TitleDetail> titleDetails;

	/**
	 * (this list may be empty)
	 */
	public List<Contributor> contributors;

	/**
	 * (this list may be empty)
	 */
	public List<Subject> subjects;

	/**
	 * (this list may be empty)
	 */
	public List<NameAsSubject> nameAsSubjects;

	/**
	 * (this list may be empty)
	 */
	public List<TextContent> textContents;

	/**
	 * (this list may be empty)
	 */
	public List<CitedContent> citedContents;

	/**
	 * (this list may be empty)
	 */
	public List<SupportingResource> supportingResources;

	/**
	 * (this list may be empty)
	 */
	public List<RelatedWork> relatedWorks;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public ContentItem()
	{}

	public ContentItem(org.w3c.dom.Element element)
	{
		datestamp = JPU.getAttribute(element, "datestamp");
		sourcetype = RecordSourceTypes.byValue(JPU.getAttribute(element, "sourcetype"));
		sourcename = JPU.getAttribute(element, "sourcename");

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

	/**
	 * Format: Variable-length string of integers, each successive integer being separated by a full stop, suggested
	 * maximum length 100 characters
	 */
	public String getLevelSequenceNumberValue()
	{
		return (levelSequenceNumber == null) ? null : levelSequenceNumber.value;
	}

	/**
	 * Format: Variable-length alphanumeric, suggested maximum length 20 characters
	 */
	public String getComponentTypeNameValue()
	{
		return (componentTypeName == null) ? null : componentTypeName.value;
	}

	/**
	 * Format: Variable-length alphanumeric, suggested maximum length 20 characters
	 */
	public String getComponentNumberValue()
	{
		return (componentNumber == null) ? null : componentNumber.value;
	}
}
