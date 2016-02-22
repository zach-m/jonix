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
import java.util.ArrayList;
import java.util.List;

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.codelist.CitedContentTypes;
import com.tectonica.jonix.codelist.ContentAudiences;
import com.tectonica.jonix.codelist.ContentDateRoles;
import com.tectonica.jonix.codelist.ContentSourceTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixContentDate;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <h1>Cited content composite</h1>
 * <p>
 * A group of data elements which together describe a piece of cited content. Optional and repeatable.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;CitedContent&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;citedcontent&gt;</td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 */
public class CitedContent implements OnixSuperComposite, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "CitedContent";
	public static final String shortname = "citedcontent";

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
	 * (this field is required)
	 */
	public CitedContentType citedContentType;

	/**
	 * (this list may be empty)
	 */
	public List<ContentAudience> contentAudiences;

	/**
	 * (this field is optional)
	 */
	public SourceType sourceType;

	/**
	 * (this list is required to contain at least one item)
	 */
	public List<SourceTitle> sourceTitles;

	/**
	 * (this list may be empty)
	 */
	public List<ListName> listNames;

	/**
	 * (this field is optional)
	 */
	public PositionOnList positionOnList;

	/**
	 * (this list may be empty)
	 */
	public List<CitationNote> citationNotes;

	/**
	 * (this list may be empty)
	 */
	public List<ResourceLink> resourceLinks;

	/**
	 * (this list may be empty)
	 */
	public List<ContentDate> contentDates;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public CitedContent()
	{}

	public CitedContent(org.w3c.dom.Element element)
	{
		datestamp = JPU.getAttribute(element, "datestamp");
		sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
		sourcename = JPU.getAttribute(element, "sourcename");

		JPU.forElementsOf(element, new JPU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(CitedContentType.refname) || name.equals(CitedContentType.shortname))
					citedContentType = new CitedContentType(element);
				else if (name.equals(ContentAudience.refname) || name.equals(ContentAudience.shortname))
					contentAudiences = JPU.addToList(contentAudiences, new ContentAudience(element));
				else if (name.equals(SourceType.refname) || name.equals(SourceType.shortname))
					sourceType = new SourceType(element);
				else if (name.equals(SourceTitle.refname) || name.equals(SourceTitle.shortname))
					sourceTitles = JPU.addToList(sourceTitles, new SourceTitle(element));
				else if (name.equals(ListName.refname) || name.equals(ListName.shortname))
					listNames = JPU.addToList(listNames, new ListName(element));
				else if (name.equals(PositionOnList.refname) || name.equals(PositionOnList.shortname))
					positionOnList = new PositionOnList(element);
				else if (name.equals(CitationNote.refname) || name.equals(CitationNote.shortname))
					citationNotes = JPU.addToList(citationNotes, new CitationNote(element));
				else if (name.equals(ResourceLink.refname) || name.equals(ResourceLink.shortname))
					resourceLinks = JPU.addToList(resourceLinks, new ResourceLink(element));
				else if (name.equals(ContentDate.refname) || name.equals(ContentDate.shortname))
					contentDates = JPU.addToList(contentDates, new ContentDate(element));
			}
		});
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

	/**
	 * Raw Format: Variable-length text, suggested maximum length 300 characters
	 */
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

	/**
	 * Raw Format: Variable-length text, suggested maximum length 100 characters
	 */
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

	/**
	 * Raw Format: Variable-length integer, suggested maximum 3 characters
	 */
	public Integer getPositionOnListValue()
	{
		return (positionOnList == null) ? null : positionOnList.value;
	}

	/**
	 * Raw Format: Variable-length text, suggested maximum length 300 characters. XHTML is enabled in this element - see
	 * Using XHTML, HTML or XML with ONIX text fields
	 */
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

	/**
	 * Raw Format: Uniform Resource Identifier, expressed in full URI syntax in accordance with W3C standards
	 */
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

	public JonixContentDate findContentDate(ContentDateRoles contentDateRole)
	{
		if (contentDates != null)
		{
			for (ContentDate x : contentDates)
			{
				if (x.getContentDateRoleValue() == contentDateRole)
					return x.asJonixContentDate();
			}
		}
		return null;
	}

	public List<JonixContentDate> findContentDates(java.util.Set<ContentDateRoles> contentDateRoles)
	{
		if (contentDates != null)
		{
			List<JonixContentDate> matches = new ArrayList<>();
			for (ContentDate x : contentDates)
			{
				if (contentDateRoles == null || contentDateRoles.contains(x.getContentDateRoleValue()))
					matches.add(x.asJonixContentDate());
			}
			return matches;
		}
		return null;
	}
}
