/*
 * Copyright (C) 2012-2023 Zach Melamed
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
import com.tectonica.jonix.common.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.common.codelist.Languages;
import com.tectonica.jonix.common.codelist.ProductIdentifierTypes;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.TextCaseFlags;
import com.tectonica.jonix.common.codelist.TextFormats;
import com.tectonica.jonix.common.codelist.TitleTypes;
import com.tectonica.jonix.common.codelist.TransliterationSchemes;
import com.tectonica.jonix.common.struct.JonixProductIdentifier;
import com.tectonica.jonix.common.struct.JonixTitle;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Set composite</h1>
 * <p>
 * A repeatable group of data elements which together describe a set of which the product is part.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;Set&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;set&gt;</tt></td>
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
 * <li>{@link Product} ⯈ {@link Set}</li>
 * </ul>
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
                case TitleOfSet.refname:
                case TitleOfSet.shortname:
                    titleOfSet = new TitleOfSet(e);
                    break;
                case ISBNOfSet.refname:
                case ISBNOfSet.shortname:
                    isbnOfSet = new ISBNOfSet(e);
                    break;
                case EAN13OfSet.refname:
                case EAN13OfSet.shortname:
                    ean13OfSet = new EAN13OfSet(e);
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
                case ProductIdentifier.refname:
                case ProductIdentifier.shortname:
                    productIdentifiers = JPU.addToList(productIdentifiers, new ProductIdentifier(e));
                    break;
                case Title.refname:
                case Title.shortname:
                    titles = JPU.addToList(titles, new Title(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;Set&gt; or &lt;set&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<Set> action) {
        if (exists) {
            action.accept(this);
        }
    }

    @Override
    public org.w3c.dom.Element getXmlElement() {
        return element;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private TitleOfSet titleOfSet = TitleOfSet.EMPTY;

    /**
     * <p>
     * The full title of the set, without abbreviation or abridgement. Non-repeating. Either the &lt;TitleOfSet&gt;
     * element or at least one occurrence of the &lt;Title&gt; composite must occur in each occurrence of the
     * &lt;Set&gt; composite. The &lt;Title&gt; composite provides a more comprehensive representation of a set title,
     * and allows alternative forms to be sent.
     * </p>
     * Jonix-Comment: this field is required
     */
    public TitleOfSet titleOfSet() {
        _initialize();
        return titleOfSet;
    }

    private ISBNOfSet isbnOfSet = ISBNOfSet.EMPTY;

    /**
     * <p>
     * A 10-character ISBN identifying a set of which the product forms part. Optional and non-repeating. <strong>The
     * &lt;ProductIdentifier&gt; composite on the next page provides a more general method of handling this and other
     * product codes, and is to be preferred.</strong>
     * </p>
     * Jonix-Comment: this field is optional
     */
    public ISBNOfSet isbnOfSet() {
        _initialize();
        return isbnOfSet;
    }

    private EAN13OfSet ean13OfSet = EAN13OfSet.EMPTY;

    /**
     * <p>
     * EAN.UCC-13 article number identifying a set of which the product forms part. Optional and non-repeating.
     * <strong>The &lt;ProductIdentifier&gt; composite on the next page provides a more general method of handling this
     * and other product codes, and is to be preferred.</strong>
     * </p>
     * Jonix-Comment: this field is optional
     */
    public EAN13OfSet ean13OfSet() {
        _initialize();
        return ean13OfSet;
    }

    private SetPartNumber setPartNumber = SetPartNumber.EMPTY;

    /**
     * <p>
     * The distinctive enumeration of a “subset” of which the product is a member, used only when a set is itself
     * divided into two levels, <em>eg</em> A History of Western Europe, Part II: The Dark Ages, Volume I: After Rome.
     * Optional and non-repeating. Note that this element is used for the first subdivision of a set which has two
     * levels, regardless of the nomenclature (part, volume, <em>etc</em>) which the publisher uses at each level.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public SetPartNumber setPartNumber() {
        _initialize();
        return setPartNumber;
    }

    private SetPartTitle setPartTitle = SetPartTitle.EMPTY;

    /**
     * <p>
     * The title of a “subset” of which the product is a member, used only when a set is itself divided into two levels,
     * <em>eg</em> A History of Western Europe, Part II: The Dark Ages, Volume I: After Rome. Use this field only for
     * the section of the whole title which is shared by, and only by, the members of the subset. Optional and
     * non-repeating. Note that this element is used for the first subdivision of a set which has two levels, regardless
     * of the nomenclature (part, volume, <em>etc</em>) which the publisher uses at each level.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public SetPartTitle setPartTitle() {
        _initialize();
        return setPartTitle;
    }

    private ItemNumberWithinSet itemNumberWithinSet = ItemNumberWithinSet.EMPTY;

    /**
     * <p>
     * The distinctive enumeration of the product as an item within a set (or within a part of a set). Optional and
     * non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public ItemNumberWithinSet itemNumberWithinSet() {
        _initialize();
        return itemNumberWithinSet;
    }

    private LevelSequenceNumber levelSequenceNumber = LevelSequenceNumber.EMPTY;

    /**
     * <p>
     * A number which specifies the position of an item in a set within a multi-level hierarchy of such items. Numbering
     * starts at the top level in the hierarchy, and the first item at the top level is numbered 1. Optional and
     * non-repeating. The purpose of this element is to make it possible to describe structured sets in a normalized
     * way, since enumeration carried as &lt;ItemNumberWithinSet&gt; may take a wide variety of forms.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public LevelSequenceNumber levelSequenceNumber() {
        _initialize();
        return levelSequenceNumber;
    }

    private SetItemTitle setItemTitle = SetItemTitle.EMPTY;

    /**
     * <p>
     * The title which the product carries as an item within a set, <em>eg</em> <cite>After Rome in A History of Western
     * Europe, Part II: The Dark Ages, Volume I: After Rome</cite>. This will invariably duplicate at least part of the
     * product title in Group&nbsp;PR.7, but by entering it in this group it is possible to assure a correctly
     * structured entry for the set. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public SetItemTitle setItemTitle() {
        _initialize();
        return setItemTitle;
    }

    private ListOfOnixDataCompositeWithKey<ProductIdentifier, JonixProductIdentifier,
        ProductIdentifierTypes> productIdentifiers = JPU.emptyListOfOnixDataCompositeWithKey(ProductIdentifier.class);

    /**
     * <p>
     * A repeatable group of data elements which together define the identifier of a product in accordance with a
     * specified scheme, used here to carry the product identifier for a set. <strong>See notes on the
     * &lt;ProductIdentifier&gt; composite in section PR.2 for details of the handling of ISBN-13.</strong>
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<ProductIdentifier, JonixProductIdentifier, ProductIdentifierTypes>
        productIdentifiers() {
        _initialize();
        return productIdentifiers;
    }

    private ListOfOnixDataCompositeWithKey<Title, JonixTitle, TitleTypes> titles =
        JPU.emptyListOfOnixDataCompositeWithKey(Title.class);

    /**
     * <p>
     * A repeatable group of data elements which together give the text of a title, including a subtitle where
     * applicable, and specify its type. <strong>Please see Group&nbsp;PR.7 for details.</strong>
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<Title, JonixTitle, TitleTypes> titles() {
        _initialize();
        return titles;
    }
}
