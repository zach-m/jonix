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

import com.tectonica.jonix.common.JPU;
import com.tectonica.jonix.common.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.common.ListOfOnixElement;
import com.tectonica.jonix.common.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.common.codelist.Countrys;
import com.tectonica.jonix.common.codelist.Languages;
import com.tectonica.jonix.common.codelist.ProductIdentifierTypes;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.TextCaseFlags;
import com.tectonica.jonix.common.codelist.TextFormats;
import com.tectonica.jonix.common.codelist.TransliterationSchemes;
import com.tectonica.jonix.common.struct.JonixProductIdentifier;

import java.io.Serializable;

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
 * <td><tt>&lt;NotForSale&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;notforsale&gt;</tt></td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Product}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link NotForSale}</li>
 * </ul>
 */
public class NotForSale implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "NotForSale";
    public static final String shortname = "notforsale";

    /////////////////////////////////////////////////////////////////////////////////
    // ATTRIBUTES
    /////////////////////////////////////////////////////////////////////////////////

    public TextFormats textformat;

    public TextCaseFlags textcase;

    public Languages language;

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

    public NotForSale() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public NotForSale(org.w3c.dom.Element element) {
        exists = true;
        initialized = false;
        this.element = element;
        textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));
        textcase = TextCaseFlags.byCode(JPU.getAttribute(element, "textcase"));
        language = Languages.byCode(JPU.getAttribute(element, "language"));
        transliteration = TransliterationSchemes.byCode(JPU.getAttribute(element, "transliteration"));
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");
    }

    @Override
    public void _initialize() {
        if (initialized) {
            return;
        }
        initialized = true;

        JPU.forElementsOf(element, e -> {
            final String name = e.getNodeName();
            switch (name) {
                case RightsCountry.refname:
                case RightsCountry.shortname:
                    rightsCountrys = JPU.addToList(rightsCountrys, new RightsCountry(e));
                    break;
                case RightsTerritory.refname:
                case RightsTerritory.shortname:
                    rightsTerritory = new RightsTerritory(e);
                    break;
                case ISBN.refname:
                case ISBN.shortname:
                    isbn = new ISBN(e);
                    break;
                case EAN13.refname:
                case EAN13.shortname:
                    ean13 = new EAN13(e);
                    break;
                case PublisherName.refname:
                case PublisherName.shortname:
                    publisherName = new PublisherName(e);
                    break;
                case ProductIdentifier.refname:
                case ProductIdentifier.shortname:
                    productIdentifiers = JPU.addToList(productIdentifiers, new ProductIdentifier(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;NotForSale&gt; or &lt;notforsale&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private ListOfOnixElement<RightsCountry, java.util.Set<Countrys>> rightsCountrys = ListOfOnixElement.empty();

    /**
     * <p>
     * One or more ISO standard codes identifying a country. Successive codes may be separated by spaces. Thus, a single
     * occurrence of the element can carry an unlimited number of country codes, for countries for which details of
     * another publisher’s product are given. For upwards compatibility, the element remains repeatable, so that
     * multiple countries can also be listed as multiple occurrences of the whole element. At least one occurrence of
     * &lt;RightsCountry&gt; or &lt;RightsTerritory&gt; is mandatory in each occurrence of the&lt;NotForSale&gt;
     * composite.
     * </p>
     * Jonix-Comment: this list is required to contain at least one item
     */
    public ListOfOnixElement<RightsCountry, java.util.Set<Countrys>> rightsCountrys() {
        _initialize();
        return rightsCountrys;
    }

    private RightsTerritory rightsTerritory = RightsTerritory.EMPTY;

    /**
     * <p>
     * One or more ONIX codes identifying a territory which is not a country, but which is precisely defined in
     * geographical terms, <em>eg</em> World, Northern Ireland, Australian National Territory. Successive codes are
     * separated by spaces, so that the element can carry an unlimited number of territory codes, for territories for
     * which details of another publisher’s product are given. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public RightsTerritory rightsTerritory() {
        _initialize();
        return rightsTerritory;
    }

    private ISBN isbn = ISBN.EMPTY;

    /**
     * <p>
     * 10-character ISBN of the equivalent product which is available in the country/ies specified in
     * &lt;RightsCountry&gt;. Optional and non-repeating. <strong>The &lt;ProductIdentifier&gt; composite provides a
     * more general method of handling this and other product codes, and is to be preferred. The &lt;ISBN&gt; element is
     * on no account to be used to carry a 13-digit ISBN.</strong>
     * </p>
     * Jonix-Comment: this field is optional
     */
    public ISBN isbn() {
        _initialize();
        return isbn;
    }

    private EAN13 ean13 = EAN13.EMPTY;

    /**
     * <p>
     * EAN.UCC-13 number of the equivalent product available in the country/ies specified in &lt;RightsCountry&gt;.
     * Optional and non-repeating. <strong>The &lt;ProductIdentifier&gt; composite provides a more general method of
     * handling this and other product codes, and is to be preferred.</strong>
     * </p>
     * Jonix-Comment: this field is optional
     */
    public EAN13 ean13() {
        _initialize();
        return ean13;
    }

    private PublisherName publisherName = PublisherName.EMPTY;

    /**
     * <p>
     * The full name of the publisher of the equivalent product which is available in the country/ies specified in
     * &lt;RightsCountry&gt;. Optional and non-repeating. Except where they are essential to the recognized form of the
     * name, it is recommended that suffixes denoting incorporation (“Co”, “Inc”, “Ltd”, “SA”, “GmbH”) should be
     * omitted.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public PublisherName publisherName() {
        _initialize();
        return publisherName;
    }

    private ListOfOnixDataCompositeWithKey<ProductIdentifier, JonixProductIdentifier, ProductIdentifierTypes> productIdentifiers = ListOfOnixDataCompositeWithKey
        .emptyKeyed();

    /**
     * <p>
     * A repeatable group of data elements which together define the identifier of a product in accordance with a
     * specified scheme, and allowing new types of product identifier to be included without defining additional data
     * elements. <strong>See notes on the &lt;ProductIdentifier&gt; composite in section PR.2 for details of the
     * handling of ISBN-13.</strong>
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<ProductIdentifier, JonixProductIdentifier, ProductIdentifierTypes> productIdentifiers() {
        _initialize();
        return productIdentifiers;
    }
}
