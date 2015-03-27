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
import com.tectonica.jonix.codelist.ProductIdentifierTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TitleTypes;
import com.tectonica.jonix.codelist.TransliterationSchemes;
import com.tectonica.jonix.struct.ProductIdentifierStruct;
import com.tectonica.jonix.struct.TitleStruct;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

@SuppressWarnings("serial")
public class Set implements Serializable
{
	public static final String refname = "Set";
	public static final String shortname = "set";

	public TextFormats textformat;
	public TextCaseFlags textcase;
	public LanguageCodeIso6392Bs language;
	public TransliterationSchemes transliteration;
	public String datestamp; // DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public ISBNOfSet isbnOfSet; // Optional
	public EAN13OfSet ean13OfSet; // Optional
	public List<ProductIdentifier> productIdentifiers; // ZeroOrMore
	public TitleOfSet titleOfSet; // Required
	public List<Title> titles; // ZeroOrMore
	public SetPartNumber setPartNumber; // Optional
	public SetPartTitle setPartTitle; // Optional
	public ItemNumberWithinSet itemNumberWithinSet; // Optional
	public LevelSequenceNumber levelSequenceNumber; // Optional
	public SetItemTitle setItemTitle; // Optional

	public Set()
	{}

	public Set(org.w3c.dom.Element element)
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
				if (name.equals(ISBNOfSet.refname) || name.equals(ISBNOfSet.shortname))
					isbnOfSet = new ISBNOfSet(element);
				else if (name.equals(EAN13OfSet.refname) || name.equals(EAN13OfSet.shortname))
					ean13OfSet = new EAN13OfSet(element);
				else if (name.equals(ProductIdentifier.refname) || name.equals(ProductIdentifier.shortname))
					productIdentifiers = JPU.addToList(productIdentifiers, new ProductIdentifier(element));
				else if (name.equals(TitleOfSet.refname) || name.equals(TitleOfSet.shortname))
					titleOfSet = new TitleOfSet(element);
				else if (name.equals(Title.refname) || name.equals(Title.shortname))
					titles = JPU.addToList(titles, new Title(element));
				else if (name.equals(SetPartNumber.refname) || name.equals(SetPartNumber.shortname))
					setPartNumber = new SetPartNumber(element);
				else if (name.equals(SetPartTitle.refname) || name.equals(SetPartTitle.shortname))
					setPartTitle = new SetPartTitle(element);
				else if (name.equals(ItemNumberWithinSet.refname) || name.equals(ItemNumberWithinSet.shortname))
					itemNumberWithinSet = new ItemNumberWithinSet(element);
				else if (name.equals(LevelSequenceNumber.refname) || name.equals(LevelSequenceNumber.shortname))
					levelSequenceNumber = new LevelSequenceNumber(element);
				else if (name.equals(SetItemTitle.refname) || name.equals(SetItemTitle.shortname))
					setItemTitle = new SetItemTitle(element);
			}
		});
	}

	public String getISBNOfSetValue()
	{
		return (isbnOfSet == null) ? null : isbnOfSet.value;
	}

	public String getEAN13OfSetValue()
	{
		return (ean13OfSet == null) ? null : ean13OfSet.value;
	}

	public String getTitleOfSetValue()
	{
		return (titleOfSet == null) ? null : titleOfSet.value;
	}

	public String getSetPartNumberValue()
	{
		return (setPartNumber == null) ? null : setPartNumber.value;
	}

	public String getSetPartTitleValue()
	{
		return (setPartTitle == null) ? null : setPartTitle.value;
	}

	public String getItemNumberWithinSetValue()
	{
		return (itemNumberWithinSet == null) ? null : itemNumberWithinSet.value;
	}

	public String getLevelSequenceNumberValue()
	{
		return (levelSequenceNumber == null) ? null : levelSequenceNumber.value;
	}

	public String getSetItemTitleValue()
	{
		return (setItemTitle == null) ? null : setItemTitle.value;
	}

	public ProductIdentifierStruct findProductIdentifier(ProductIdentifierTypes productIDType)
	{
		if (productIdentifiers != null)
		{
			for (ProductIdentifier x : productIdentifiers)
			{
				if (x.getProductIDTypeValue() == productIDType)
					return x.asStruct();
			}
		}
		return null;
	}

	public List<ProductIdentifierStruct> findProductIdentifiers(java.util.Set<ProductIdentifierTypes> productIDTypes)
	{
		if (productIdentifiers != null)
		{
			List<ProductIdentifierStruct> matches = new ArrayList<>();
			for (ProductIdentifier x : productIdentifiers)
			{
				if (productIDTypes == null || productIDTypes.contains(x.getProductIDTypeValue()))
					matches.add(x.asStruct());
			}
			return matches;
		}
		return null;
	}

	public TitleStruct findTitle(TitleTypes titleType)
	{
		if (titles != null)
		{
			for (Title x : titles)
			{
				if (x.getTitleTypeValue() == titleType)
					return x.asStruct();
			}
		}
		return null;
	}

	public List<TitleStruct> findTitles(java.util.Set<TitleTypes> titleTypes)
	{
		if (titles != null)
		{
			List<TitleStruct> matches = new ArrayList<>();
			for (Title x : titles)
			{
				if (titleTypes == null || titleTypes.contains(x.getTitleTypeValue()))
					matches.add(x.asStruct());
			}
			return matches;
		}
		return null;
	}
}
