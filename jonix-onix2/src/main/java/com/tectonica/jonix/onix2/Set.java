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

import java.util.List;

import com.tectonica.jonix.DU;
import com.tectonica.jonix.codelist.LanguageCodeIso6392Bs;
import com.tectonica.jonix.codelist.RecordSourceTypeCodes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormatCodes;
import com.tectonica.jonix.codelist.TransliterationSchemeCodes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

public class Set
{
	public static final String refname = "Set";
	public static final String shortname = "set";

	public TextFormatCodes textformat;
	public TextCaseFlags textcase;
	public LanguageCodeIso6392Bs language;
	public TransliterationSchemeCodes transliteration;
	public String datestamp; // DateOrDateTime
	public RecordSourceTypeCodes sourcetype;
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

	public static Set fromDoc(org.w3c.dom.Element element)
	{
		final Set x = new Set();

		x.textformat = TextFormatCodes.byValue(DU.getAttribute(element, "textformat"));
		x.textcase = TextCaseFlags.byValue(DU.getAttribute(element, "textcase"));
		x.language = LanguageCodeIso6392Bs.byValue(DU.getAttribute(element, "language"));
		x.transliteration = TransliterationSchemeCodes.byValue(DU.getAttribute(element, "transliteration"));
		x.datestamp = DU.getAttribute(element, "datestamp");
		x.sourcetype = RecordSourceTypeCodes.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		DU.forElementsOf(element, new DU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(ISBNOfSet.refname) || name.equals(ISBNOfSet.shortname))
					x.isbnOfSet = ISBNOfSet.fromDoc(element);
				else if (name.equals(EAN13OfSet.refname) || name.equals(EAN13OfSet.shortname))
					x.ean13OfSet = EAN13OfSet.fromDoc(element);
				else if (name.equals(ProductIdentifier.refname) || name.equals(ProductIdentifier.shortname))
					x.productIdentifiers = DU.addToList(x.productIdentifiers, ProductIdentifier.fromDoc(element));
				else if (name.equals(TitleOfSet.refname) || name.equals(TitleOfSet.shortname))
					x.titleOfSet = TitleOfSet.fromDoc(element);
				else if (name.equals(Title.refname) || name.equals(Title.shortname))
					x.titles = DU.addToList(x.titles, Title.fromDoc(element));
				else if (name.equals(SetPartNumber.refname) || name.equals(SetPartNumber.shortname))
					x.setPartNumber = SetPartNumber.fromDoc(element);
				else if (name.equals(SetPartTitle.refname) || name.equals(SetPartTitle.shortname))
					x.setPartTitle = SetPartTitle.fromDoc(element);
				else if (name.equals(ItemNumberWithinSet.refname) || name.equals(ItemNumberWithinSet.shortname))
					x.itemNumberWithinSet = ItemNumberWithinSet.fromDoc(element);
				else if (name.equals(LevelSequenceNumber.refname) || name.equals(LevelSequenceNumber.shortname))
					x.levelSequenceNumber = LevelSequenceNumber.fromDoc(element);
				else if (name.equals(SetItemTitle.refname) || name.equals(SetItemTitle.shortname))
					x.setItemTitle = SetItemTitle.fromDoc(element);
			}
		});

		return x;
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
}
