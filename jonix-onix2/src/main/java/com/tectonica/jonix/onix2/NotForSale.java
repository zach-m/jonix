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
import com.tectonica.jonix.JonixComposite;
import com.tectonica.jonix.codelist.CountryCodeIso31661s;
import com.tectonica.jonix.codelist.LanguageCodeIso6392Bs;
import com.tectonica.jonix.codelist.ProductIdentifierTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.Regions;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;
import com.tectonica.jonix.struct.JonixProductIdentifier;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

@SuppressWarnings("serial")
public class NotForSale implements JonixComposite, Serializable
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

	public NotForSale()
	{}

	public NotForSale(org.w3c.dom.Element element)
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
				if (name.equals(RightsCountry.refname) || name.equals(RightsCountry.shortname))
					rightsCountrys = JPU.addToList(rightsCountrys, new RightsCountry(element));
				else if (name.equals(RightsTerritory.refname) || name.equals(RightsTerritory.shortname))
					rightsTerritory = new RightsTerritory(element);
				else if (name.equals(ISBN.refname) || name.equals(ISBN.shortname))
					isbn = new ISBN(element);
				else if (name.equals(EAN13.refname) || name.equals(EAN13.shortname))
					ean13 = new EAN13(element);
				else if (name.equals(ProductIdentifier.refname) || name.equals(ProductIdentifier.shortname))
					productIdentifiers = JPU.addToList(productIdentifiers, new ProductIdentifier(element));
				else if (name.equals(PublisherName.refname) || name.equals(PublisherName.shortname))
					publisherName = new PublisherName(element);
			}
		});
	}

	public List<java.util.Set<CountryCodeIso31661s>> getRightsCountrySets()
	{
		if (rightsCountrys != null)
		{
			List<java.util.Set<CountryCodeIso31661s>> list = new ArrayList<>();
			for (RightsCountry i : rightsCountrys)
				list.add(i.value);
			return list;
		}
		return null;
	}

	public java.util.Set<Regions> getRightsTerritorySet()
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

	public JonixProductIdentifier findProductIdentifier(ProductIdentifierTypes productIDType)
	{
		if (productIdentifiers != null)
		{
			for (ProductIdentifier x : productIdentifiers)
			{
				if (x.getProductIDTypeValue() == productIDType)
					return x.asJonixProductIdentifier();
			}
		}
		return null;
	}

	public List<JonixProductIdentifier> findProductIdentifiers(java.util.Set<ProductIdentifierTypes> productIDTypes)
	{
		if (productIdentifiers != null)
		{
			List<JonixProductIdentifier> matches = new ArrayList<>();
			for (ProductIdentifier x : productIdentifiers)
			{
				if (productIDTypes == null || productIDTypes.contains(x.getProductIDTypeValue()))
					matches.add(x.asJonixProductIdentifier());
			}
			return matches;
		}
		return null;
	}
}
