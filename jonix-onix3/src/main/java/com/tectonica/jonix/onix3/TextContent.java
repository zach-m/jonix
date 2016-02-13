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
import com.tectonica.jonix.codelist.ContentAudiences;
import com.tectonica.jonix.codelist.ContentDateRoles;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextTypes;
import com.tectonica.jonix.struct.JonixContentDate;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

@SuppressWarnings("serial")
public class TextContent implements OnixSuperComposite, Serializable
{
	public static final String refname = "TextContent";
	public static final String shortname = "textcontent";

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
	public TextType textType;

	/**
	 * (this list is required to contain at least one item)
	 */
	public List<ContentAudience> contentAudiences;

	/**
	 * (this list is required to contain at least one item)
	 */
	public List<Text> texts;

	/**
	 * (this list may be empty)
	 */
	public List<TextAuthor> textAuthors;

	/**
	 * (this field is optional)
	 */
	public TextSourceCorporate textSourceCorporate;

	/**
	 * (this list may be empty)
	 */
	public List<SourceTitle> sourceTitles;

	/**
	 * (this list may be empty)
	 */
	public List<ContentDate> contentDates;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public TextContent()
	{}

	public TextContent(org.w3c.dom.Element element)
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
				if (name.equals(TextType.refname) || name.equals(TextType.shortname))
					textType = new TextType(element);
				else if (name.equals(ContentAudience.refname) || name.equals(ContentAudience.shortname))
					contentAudiences = JPU.addToList(contentAudiences, new ContentAudience(element));
				else if (name.equals(Text.refname) || name.equals(Text.shortname))
					texts = JPU.addToList(texts, new Text(element));
				else if (name.equals(TextAuthor.refname) || name.equals(TextAuthor.shortname))
					textAuthors = JPU.addToList(textAuthors, new TextAuthor(element));
				else if (name.equals(TextSourceCorporate.refname) || name.equals(TextSourceCorporate.shortname))
					textSourceCorporate = new TextSourceCorporate(element);
				else if (name.equals(SourceTitle.refname) || name.equals(SourceTitle.shortname))
					sourceTitles = JPU.addToList(sourceTitles, new SourceTitle(element));
				else if (name.equals(ContentDate.refname) || name.equals(ContentDate.shortname))
					contentDates = JPU.addToList(contentDates, new ContentDate(element));
			}
		});
	}

	public TextTypes getTextTypeValue()
	{
		return (textType == null) ? null : textType.value;
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

	public List<String> getTextValues()
	{
		if (texts != null)
		{
			List<String> list = new ArrayList<>();
			for (Text i : texts)
				list.add(i.value);
			return list;
		}
		return null;
	}

	public List<String> getTextAuthorValues()
	{
		if (textAuthors != null)
		{
			List<String> list = new ArrayList<>();
			for (TextAuthor i : textAuthors)
				list.add(i.value);
			return list;
		}
		return null;
	}

	public String getTextSourceCorporateValue()
	{
		return (textSourceCorporate == null) ? null : textSourceCorporate.value;
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
