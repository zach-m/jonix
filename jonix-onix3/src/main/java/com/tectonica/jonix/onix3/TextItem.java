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
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextItemIdentifierTypes;
import com.tectonica.jonix.codelist.TextItemTypes;
import com.tectonica.jonix.struct.JonixTextItemIdentifier;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <h1>Text item composite</h1>
 * <p>
 * A group of data elements which are specific to text content. The composite must occur once and only once in a
 * &lt;ContentItem&gt; composite which describes a text content item. (Similar composites may be defined for other
 * media, and the occurrence of one of them will be mandatory in any &lt;ContentItem&gt; composite.)
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;TextItem&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;textitem&gt;</td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>1</td>
 * </tr>
 * </table>
 */
public class TextItem implements OnixSuperComposite, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "TextItem";
	public static final String shortname = "textitem";

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
	public TextItemType textItemType;

	/**
	 * (this list may be empty)
	 */
	public List<TextItemIdentifier> textItemIdentifiers;

	/**
	 * (this list may be empty)
	 */
	public List<PageRun> pageRuns;

	/**
	 * (this field is optional)
	 */
	public NumberOfPages numberOfPages;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public TextItem()
	{}

	public TextItem(org.w3c.dom.Element element)
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

	/**
	 * Raw Format: Variable length integer, suggested maximum length 6 digits
	 */
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
					return x.asJonixTextItemIdentifier();
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
					matches.add(x.asJonixTextItemIdentifier());
			}
			return matches;
		}
		return null;
	}
}
