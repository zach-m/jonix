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
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.Regions;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

public class NotForSale
{
	public static final String refname = "NotForSale";
	public static final String shortname = "notforsale";

	public TextFormats textformat;
	public TextCaseFlags textcase;
	public LanguageCodeIso6392Bs language;
	public TransliterationSchemes transliteration;
	public String datestamp; // DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public List<RightsCountry> rightsCountrys; // OneOrMore
	public RightsTerritory rightsTerritory; // Optional
	public ISBN isbn; // Optional
	public EAN13 ean13; // Optional
	public List<ProductIdentifier> productIdentifiers; // ZeroOrMore
	public PublisherName publisherName; // Optional

	public static NotForSale fromDoc(org.w3c.dom.Element element)
	{
		final NotForSale x = new NotForSale();

		x.textformat = TextFormats.byValue(DU.getAttribute(element, "textformat"));
		x.textcase = TextCaseFlags.byValue(DU.getAttribute(element, "textcase"));
		x.language = LanguageCodeIso6392Bs.byValue(DU.getAttribute(element, "language"));
		x.transliteration = TransliterationSchemes.byValue(DU.getAttribute(element, "transliteration"));
		x.datestamp = DU.getAttribute(element, "datestamp");
		x.sourcetype = RecordSourceTypes.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		DU.forElementsOf(element, new DU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(RightsCountry.refname) || name.equals(RightsCountry.shortname))
					x.rightsCountrys = DU.addToList(x.rightsCountrys, RightsCountry.fromDoc(element));
				else if (name.equals(RightsTerritory.refname) || name.equals(RightsTerritory.shortname))
					x.rightsTerritory = RightsTerritory.fromDoc(element);
				else if (name.equals(ISBN.refname) || name.equals(ISBN.shortname))
					x.isbn = ISBN.fromDoc(element);
				else if (name.equals(EAN13.refname) || name.equals(EAN13.shortname))
					x.ean13 = EAN13.fromDoc(element);
				else if (name.equals(ProductIdentifier.refname) || name.equals(ProductIdentifier.shortname))
					x.productIdentifiers = DU.addToList(x.productIdentifiers, ProductIdentifier.fromDoc(element));
				else if (name.equals(PublisherName.refname) || name.equals(PublisherName.shortname))
					x.publisherName = PublisherName.fromDoc(element);
			}
		});

		return x;
	}

	public Regions getRightsTerritoryValue()
	{
		return (rightsTerritory == null) ? null : rightsTerritory.value;
	}

	public String getISBNValue()
	{
		return (isbn == null) ? null : isbn.value;
	}

	public String getEAN13Value()
	{
		return (ean13 == null) ? null : ean13.value;
	}

	public String getPublisherNameValue()
	{
		return (publisherName == null) ? null : publisherName.value;
	}
}
