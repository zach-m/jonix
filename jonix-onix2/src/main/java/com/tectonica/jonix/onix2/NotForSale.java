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

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.ListOfOnixElement;
import com.tectonica.jonix.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.codelist.CountryCodes;
import com.tectonica.jonix.codelist.LanguageCodes;
import com.tectonica.jonix.codelist.ProductIdentifierTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;
import com.tectonica.jonix.struct.JonixProductIdentifier;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Not for sale composite</h1>
 * <p>
 * A repeatable group of data elements which together identify a country or countries in which the product is not for
 * sale, together with the ISBN and/or other product identifier and/or the name of the publisher of the same work in the
 * specified country/ies.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;NotForSale&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;notforsale&gt;</td>
 * </tr>
 * </table>
 */
public class NotForSale implements OnixSuperComposite, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "NotForSale";
	public static final String shortname = "notforsale";

	/////////////////////////////////////////////////////////////////////////////////
	// ATTRIBUTES
	/////////////////////////////////////////////////////////////////////////////////

	public TextFormats textformat;

	public TextCaseFlags textcase;

	public LanguageCodes language;

	public TransliterationSchemes transliteration;

	/**
	 * (type: DateOrDateTime)
	 */
	public String datestamp;

	public RecordSourceTypes sourcetype;

	public String sourcename;

	/////////////////////////////////////////////////////////////////////////////////
	// CONSTRUCTION
	/////////////////////////////////////////////////////////////////////////////////

	private boolean initialized;
	private final boolean exists;
	private final org.w3c.dom.Element element;
	public static final NotForSale EMPTY = new NotForSale();

	public NotForSale()
	{
		exists = false;
		element = null;
		initialized = true; // so that no further processing will be done on this intentionally-empty object
	}

	public NotForSale(org.w3c.dom.Element element)
	{
		exists = true;
		initialized = false;
		this.element = element;
	}

	private void initialize()
	{
		if (initialized)
			return;
		initialized = true;

		textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));
		textcase = TextCaseFlags.byCode(JPU.getAttribute(element, "textcase"));
		language = LanguageCodes.byCode(JPU.getAttribute(element, "language"));
		transliteration = TransliterationSchemes.byCode(JPU.getAttribute(element, "transliteration"));
		datestamp = JPU.getAttribute(element, "datestamp");
		sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
		sourcename = JPU.getAttribute(element, "sourcename");

		JPU.forElementsOf(element, e -> {
			final String name = e.getNodeName();
			if (name.equals(RightsCountry.refname) || name.equals(RightsCountry.shortname))
				rightsCountrys = JPU.addToList(rightsCountrys, new RightsCountry(e));
			else if (name.equals(RightsTerritory.refname) || name.equals(RightsTerritory.shortname))
				rightsTerritory = new RightsTerritory(e);
			else if (name.equals(ISBN.refname) || name.equals(ISBN.shortname))
				isbn = new ISBN(e);
			else if (name.equals(EAN13.refname) || name.equals(EAN13.shortname))
				ean13 = new EAN13(e);
			else if (name.equals(ProductIdentifier.refname) || name.equals(ProductIdentifier.shortname))
				productIdentifiers = JPU.addToList(productIdentifiers, new ProductIdentifier(e));
			else if (name.equals(PublisherName.refname) || name.equals(PublisherName.shortname))
				publisherName = new PublisherName(e);
		});
	}

	@Override
	public boolean exists()
	{
		return exists;
	}

	/////////////////////////////////////////////////////////////////////////////////
	// MEMBERS
	/////////////////////////////////////////////////////////////////////////////////

	private ListOfOnixElement<RightsCountry, java.util.Set<CountryCodes>> rightsCountrys = ListOfOnixElement.empty();

	/**
	 * (this list is required to contain at least one item)
	 */
	public ListOfOnixElement<RightsCountry, java.util.Set<CountryCodes>> rightsCountrys()
	{
		initialize();
		return rightsCountrys;
	}

	private RightsTerritory rightsTerritory = RightsTerritory.EMPTY;

	/**
	 * (this field is optional)
	 */
	public RightsTerritory rightsTerritory()
	{
		initialize();
		return rightsTerritory;
	}

	private ISBN isbn = ISBN.EMPTY;

	/**
	 * (this field is optional)
	 */
	public ISBN isbn()
	{
		initialize();
		return isbn;
	}

	private EAN13 ean13 = EAN13.EMPTY;

	/**
	 * (this field is optional)
	 */
	public EAN13 ean13()
	{
		initialize();
		return ean13;
	}

	private ListOfOnixDataCompositeWithKey<ProductIdentifier, JonixProductIdentifier, ProductIdentifierTypes> productIdentifiers = ListOfOnixDataCompositeWithKey
			.emptyKeyed();

	/**
	 * (this list may be empty)
	 */
	public ListOfOnixDataCompositeWithKey<ProductIdentifier, JonixProductIdentifier, ProductIdentifierTypes> productIdentifiers()
	{
		initialize();
		return productIdentifiers;
	}

	private PublisherName publisherName = PublisherName.EMPTY;

	/**
	 * (this field is optional)
	 */
	public PublisherName publisherName()
	{
		initialize();
		return publisherName;
	}
}
