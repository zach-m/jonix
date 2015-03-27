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
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextItemIdentifierTypes;
import com.tectonica.jonix.codelist.TextItemTypes;
import com.tectonica.jonix.struct.JonixTextItemIdentifier;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

@SuppressWarnings("serial")
public class TextItem implements Serializable
{
	public static final String refname = "TextItem";
	public static final String shortname = "textitem";

	public String datestamp; // dt.DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public TextItemType textItemType; // Required
	public List<TextItemIdentifier> textItemIdentifiers; // ZeroOrMore
	public List<PageRun> pageRuns; // ZeroOrMore
	public NumberOfPages numberOfPages; // Optional

	public TextItem()
	{}

	public TextItem(org.w3c.dom.Element element)
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
				if (name.equals(TextItemType.refname) || name.equals(TextItemType.shortname))
					textItemType = new TextItemType(element);
				else if (name.equals(TextItemIdentifier.refname) || name.equals(TextItemIdentifier.shortname))
					textItemIdentifiers = JPU.addToList(textItemIdentifiers, new TextItemIdentifier(element));
				else if (name.equals(PageRun.refname) || name.equals(PageRun.shortname))
					pageRuns = JPU.addToList(pageRuns, new PageRun(element));
				else if (name.equals(NumberOfPages.refname) || name.equals(NumberOfPages.shortname))
					numberOfPages = new NumberOfPages(element);
			}
		});
	}

	public TextItemTypes getTextItemTypeValue()
	{
		return (textItemType == null) ? null : textItemType.value;
	}

	public Integer getNumberOfPagesValue()
	{
		return (numberOfPages == null) ? null : numberOfPages.value;
	}

	public JonixTextItemIdentifier findTextItemIdentifier(TextItemIdentifierTypes textItemIDType)
	{
		if (textItemIdentifiers != null)
		{
			for (TextItemIdentifier x : textItemIdentifiers)
			{
				if (x.getTextItemIDTypeValue() == textItemIDType)
					return x.asStruct();
			}
		}
		return null;
	}

	public List<JonixTextItemIdentifier> findTextItemIdentifiers(java.util.Set<TextItemIdentifierTypes> textItemIDTypes)
	{
		if (textItemIdentifiers != null)
		{
			List<JonixTextItemIdentifier> matches = new ArrayList<>();
			for (TextItemIdentifier x : textItemIdentifiers)
			{
				if (textItemIDTypes == null || textItemIDTypes.contains(x.getTextItemIDTypeValue()))
					matches.add(x.asStruct());
			}
			return matches;
		}
		return null;
	}
}
