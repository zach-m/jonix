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

import java.util.ArrayList;
import java.util.List;

import com.tectonica.jonix.DU;
import com.tectonica.jonix.codelist.CitedContentTypes;
import com.tectonica.jonix.codelist.ContentAudiences;
import com.tectonica.jonix.codelist.ContentSourceTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

public class CitedContent
{
	public static final String refname = "CitedContent";
	public static final String shortname = "citedcontent";

	public String datestamp; // dt.DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public CitedContentType citedContentType; // Required
	public List<ContentAudience> contentAudiences; // ZeroOrMore
	public SourceType sourceType; // Optional
	public List<SourceTitle> sourceTitles; // OneOrMore
	public List<ListName> listNames; // ZeroOrMore
	public PositionOnList positionOnList; // Optional
	public List<CitationNote> citationNotes; // ZeroOrMore
	public List<ResourceLink> resourceLinks; // ZeroOrMore
	public List<ContentDate> contentDates; // ZeroOrMore

	public static CitedContent fromDoc(org.w3c.dom.Element element)
	{
		final CitedContent x = new CitedContent();

		x.datestamp = DU.getAttribute(element, "datestamp");
		x.sourcetype = RecordSourceTypes.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		DU.forElementsOf(element, new DU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(CitedContentType.refname) || name.equals(CitedContentType.shortname))
					x.citedContentType = CitedContentType.fromDoc(element);
				else if (name.equals(ContentAudience.refname) || name.equals(ContentAudience.shortname))
					x.contentAudiences = DU.addToList(x.contentAudiences, ContentAudience.fromDoc(element));
				else if (name.equals(SourceType.refname) || name.equals(SourceType.shortname))
					x.sourceType = SourceType.fromDoc(element);
				else if (name.equals(SourceTitle.refname) || name.equals(SourceTitle.shortname))
					x.sourceTitles = DU.addToList(x.sourceTitles, SourceTitle.fromDoc(element));
				else if (name.equals(ListName.refname) || name.equals(ListName.shortname))
					x.listNames = DU.addToList(x.listNames, ListName.fromDoc(element));
				else if (name.equals(PositionOnList.refname) || name.equals(PositionOnList.shortname))
					x.positionOnList = PositionOnList.fromDoc(element);
				else if (name.equals(CitationNote.refname) || name.equals(CitationNote.shortname))
					x.citationNotes = DU.addToList(x.citationNotes, CitationNote.fromDoc(element));
				else if (name.equals(ResourceLink.refname) || name.equals(ResourceLink.shortname))
					x.resourceLinks = DU.addToList(x.resourceLinks, ResourceLink.fromDoc(element));
				else if (name.equals(ContentDate.refname) || name.equals(ContentDate.shortname))
					x.contentDates = DU.addToList(x.contentDates, ContentDate.fromDoc(element));
			}
		});

		return x;
	}

	public CitedContentTypes getCitedContentTypeValue()
	{
		return (citedContentType == null) ? null : citedContentType.value;
	}

	public List<ContentAudiences> getContentAudienceValues()
	{
		if (contentAudiences != null)
		{
			List<ContentAudiences> list = new ArrayList<>();
			for (ContentAudience i : contentAudiences)
				list.add(i.value);
			return list;
		}
		return null;
	}

	public ContentSourceTypes getSourceTypeValue()
	{
		return (sourceType == null) ? null : sourceType.value;
	}

	public List<String> getSourceTitleValues()
	{
		if (sourceTitles != null)
		{
			List<String> list = new ArrayList<>();
			for (SourceTitle i : sourceTitles)
				list.add(i.value);
			return list;
		}
		return null;
	}

	public List<String> getListNameValues()
	{
		if (listNames != null)
		{
			List<String> list = new ArrayList<>();
			for (ListName i : listNames)
				list.add(i.value);
			return list;
		}
		return null;
	}

	public Integer getPositionOnListValue()
	{
		return (positionOnList == null) ? null : positionOnList.value;
	}

	public List<String> getCitationNoteValues()
	{
		if (citationNotes != null)
		{
			List<String> list = new ArrayList<>();
			for (CitationNote i : citationNotes)
				list.add(i.value);
			return list;
		}
		return null;
	}

	public List<String> getResourceLinkValues()
	{
		if (resourceLinks != null)
		{
			List<String> list = new ArrayList<>();
			for (ResourceLink i : resourceLinks)
				list.add(i.value);
			return list;
		}
		return null;
	}
}
