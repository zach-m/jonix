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

package com.tectonica.jonix.onix2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.codelist.LanguageCodeIso6392Bs;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TextItemIdentifierTypes;
import com.tectonica.jonix.codelist.TextItemTypes;
import com.tectonica.jonix.codelist.TransliterationSchemes;
import com.tectonica.jonix.struct.TextItemIdentifierStruct;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

@SuppressWarnings("serial")
public class TextItem implements Serializable
{
	public static final String refname = "TextItem";
	public static final String shortname = "textitem";

	public TextFormats textformat;
	public TextCaseFlags textcase;
	public LanguageCodeIso6392Bs language;
	public TransliterationSchemes transliteration;
	public String datestamp; // DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public TextItemType textItemType; // Required
	public List<TextItemIdentifier> textItemIdentifiers; // ZeroOrMore
	public FirstPageNumber firstPageNumber; // Required
	public LastPageNumber lastPageNumber; // Optional
	public List<PageRun> pageRuns; // ZeroOrMore
	public NumberOfPages numberOfPages; // Optional

	public TextItem()
	{}

	public TextItem(org.w3c.dom.Element element)
	{
		this.textformat = TextFormats.byValue(JPU.getAttribute(element, "textformat"));
		this.textcase = TextCaseFlags.byValue(JPU.getAttribute(element, "textcase"));
		this.language = LanguageCodeIso6392Bs.byValue(JPU.getAttribute(element, "language"));
		this.transliteration = TransliterationSchemes.byValue(JPU.getAttribute(element, "transliteration"));
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
				else if (name.equals(FirstPageNumber.refname) || name.equals(FirstPageNumber.shortname))
					firstPageNumber = new FirstPageNumber(element);
				else if (name.equals(LastPageNumber.refname) || name.equals(LastPageNumber.shortname))
					lastPageNumber = new LastPageNumber(element);
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

	public String getFirstPageNumberValue()
	{
		return (firstPageNumber == null) ? null : firstPageNumber.value;
	}

	public String getLastPageNumberValue()
	{
		return (lastPageNumber == null) ? null : lastPageNumber.value;
	}

	public String getNumberOfPagesValue()
	{
		return (numberOfPages == null) ? null : numberOfPages.value;
	}

	public TextItemIdentifierStruct findTextItemIdentifier(TextItemIdentifierTypes textItemIDType)
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

	public List<TextItemIdentifierStruct> findTextItemIdentifiers(java.util.Set<TextItemIdentifierTypes> textItemIDTypes)
	{
		if (textItemIdentifiers != null)
		{
			List<TextItemIdentifierStruct> matches = new ArrayList<>();
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
