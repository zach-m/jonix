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

package com.tectonica.jonix.onix2.model;

import java.util.List;

import com.tectonica.jonix.onix2.DU;
import com.tectonica.jonix.onix2.codelist.List138;
import com.tectonica.jonix.onix2.codelist.List14;
import com.tectonica.jonix.onix2.codelist.List3;
import com.tectonica.jonix.onix2.codelist.List34;
import com.tectonica.jonix.onix2.codelist.List74;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

public class Set
{
	public static final String refname = "Set";
	public static final String shortname = "set";

	public List34 textformat;
	public List14 textcase;
	public List74 language;
	public List138 transliteration;
	public String datestamp; // DateOrDateTime
	public List3 sourcetype;
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

		x.textformat = List34.byValue(DU.getAttribute(element, "textformat"));
		x.textcase = List14.byValue(DU.getAttribute(element, "textcase"));
		x.language = List74.byValue(DU.getAttribute(element, "language"));
		x.transliteration = List138.byValue(DU.getAttribute(element, "transliteration"));
		x.datestamp = DU.getAttribute(element, "datestamp");
		x.sourcetype = List3.byValue(DU.getAttribute(element, "sourcetype"));
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
}
