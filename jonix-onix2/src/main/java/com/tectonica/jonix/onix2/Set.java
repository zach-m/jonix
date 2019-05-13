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

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.codelist.Languages;
import com.tectonica.jonix.codelist.ProductIdentifierTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TitleTypes;
import com.tectonica.jonix.codelist.TransliterationSchemes;
import com.tectonica.jonix.struct.JonixProductIdentifier;
import com.tectonica.jonix.struct.JonixTitle;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Set composite</h1><p>A repeatable group of data elements which together describe a set of which the product is
 * part.</p><table border='1' cellpadding='3'><tr><td>Reference name</td><td>&lt;Set&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;set&gt;</td></tr></table>
 */
public class Set implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Set";
    public static final String shortname = "set";

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
    public static final Set EMPTY = new Set();

    public Set() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public Set(org.w3c.dom.Element element) {
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
                case ISBNOfSet.refname:
                case ISBNOfSet.shortname:
                    isbnOfSet = new ISBNOfSet(e);
                    break;
                case EAN13OfSet.refname:
                case EAN13OfSet.shortname:
                    ean13OfSet = new EAN13OfSet(e);
                    break;
                case ProductIdentifier.refname:
                case ProductIdentifier.shortname:
                    productIdentifiers = JPU.addToList(productIdentifiers, new ProductIdentifier(e));
                    break;
                case TitleOfSet.refname:
                case TitleOfSet.shortname:
                    titleOfSet = new TitleOfSet(e);
                    break;
                case Title.refname:
                case Title.shortname:
                    titles = JPU.addToList(titles, new Title(e));
                    break;
                case SetPartNumber.refname:
                case SetPartNumber.shortname:
                    setPartNumber = new SetPartNumber(e);
                    break;
                case SetPartTitle.refname:
                case SetPartTitle.shortname:
                    setPartTitle = new SetPartTitle(e);
                    break;
                case ItemNumberWithinSet.refname:
                case ItemNumberWithinSet.shortname:
                    itemNumberWithinSet = new ItemNumberWithinSet(e);
                    break;
                case LevelSequenceNumber.refname:
                case LevelSequenceNumber.shortname:
                    levelSequenceNumber = new LevelSequenceNumber(e);
                    break;
                case SetItemTitle.refname:
                case SetItemTitle.shortname:
                    setItemTitle = new SetItemTitle(e);
                    break;
                default:
                    break;
            }
        });
    }

    @Override
    public boolean exists() {
        return exists;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private ISBNOfSet isbnOfSet = ISBNOfSet.EMPTY;

    /**
     * (this field is optional)
     */
    public ISBNOfSet isbnOfSet() {
        _initialize();
        return isbnOfSet;
    }

    private EAN13OfSet ean13OfSet = EAN13OfSet.EMPTY;

    /**
     * (this field is optional)
     */
    public EAN13OfSet ean13OfSet() {
        _initialize();
        return ean13OfSet;
    }

    private ListOfOnixDataCompositeWithKey<ProductIdentifier, JonixProductIdentifier, ProductIdentifierTypes>
        productIdentifiers = ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataCompositeWithKey<ProductIdentifier, JonixProductIdentifier, ProductIdentifierTypes> productIdentifiers() {
        _initialize();
        return productIdentifiers;
    }

    private TitleOfSet titleOfSet = TitleOfSet.EMPTY;

    /**
     * (this field is required)
     */
    public TitleOfSet titleOfSet() {
        _initialize();
        return titleOfSet;
    }

    private ListOfOnixDataCompositeWithKey<Title, JonixTitle, TitleTypes> titles =
        ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataCompositeWithKey<Title, JonixTitle, TitleTypes> titles() {
        _initialize();
        return titles;
    }

    private SetPartNumber setPartNumber = SetPartNumber.EMPTY;

    /**
     * (this field is optional)
     */
    public SetPartNumber setPartNumber() {
        _initialize();
        return setPartNumber;
    }

    private SetPartTitle setPartTitle = SetPartTitle.EMPTY;

    /**
     * (this field is optional)
     */
    public SetPartTitle setPartTitle() {
        _initialize();
        return setPartTitle;
    }

    private ItemNumberWithinSet itemNumberWithinSet = ItemNumberWithinSet.EMPTY;

    /**
     * (this field is optional)
     */
    public ItemNumberWithinSet itemNumberWithinSet() {
        _initialize();
        return itemNumberWithinSet;
    }

    private LevelSequenceNumber levelSequenceNumber = LevelSequenceNumber.EMPTY;

    /**
     * (this field is optional)
     */
    public LevelSequenceNumber levelSequenceNumber() {
        _initialize();
        return levelSequenceNumber;
    }

    private SetItemTitle setItemTitle = SetItemTitle.EMPTY;

    /**
     * (this field is optional)
     */
    public SetItemTitle setItemTitle() {
        _initialize();
        return setItemTitle;
    }
}
