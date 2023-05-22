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
import com.tectonica.jonix.common.ListOfOnixCodelist;
import com.tectonica.jonix.common.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.common.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.common.codelist.BookFormDetails;
import com.tectonica.jonix.common.codelist.Languages;
import com.tectonica.jonix.common.codelist.ProductContentTypes;
import com.tectonica.jonix.common.codelist.ProductFormDetailsList78;
import com.tectonica.jonix.common.codelist.ProductFormFeatureTypes;
import com.tectonica.jonix.common.codelist.ProductIdentifierTypes;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.TextCaseFlags;
import com.tectonica.jonix.common.codelist.TextFormats;
import com.tectonica.jonix.common.codelist.TransliterationSchemes;
import com.tectonica.jonix.common.struct.JonixProductFormFeature;
import com.tectonica.jonix.common.struct.JonixProductIdentifier;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Contained item composite</h1>
 * <p>
 * A repeatable group of data elements which together describe an item which is part of or contained within the current
 * product. The composite may be used to specify the item(s) and item quantity/ies carried in a dumpbin, or included in
 * (eg) a classroom pack, or simply to state the product forms contained within a mixed media product, without
 * specifying their identifiers or quantity. The composite is used only when the product form coding for the product as
 * a whole indicates that the product includes two or more different items, or multiple copies of the same item.
 * </p>
 * <p>
 * Each instance of the &lt;ContainedItem&gt; composite must carry at least either a product identifier, or a product
 * form code, or both. In other words, it is valid to send an instance of the composite with an identifier and no
 * product form code, or with a product form code and no identifier.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;ContainedItem&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;containeditem&gt;</tt></td>
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
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ContainedItem}</li>
 * </ul>
 */
public class ContainedItem implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "ContainedItem";
    public static final String shortname = "containeditem";

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
    public static final ContainedItem EMPTY = new ContainedItem();

    public ContainedItem() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public ContainedItem(org.w3c.dom.Element element) {
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
                case ISBN.refname:
                case ISBN.shortname:
                    isbn = new ISBN(e);
                    break;
                case EAN13.refname:
                case EAN13.shortname:
                    ean13 = new EAN13(e);
                    break;
                case ProductForm.refname:
                case ProductForm.shortname:
                    productForm = new ProductForm(e);
                    break;
                case ProductPackaging.refname:
                case ProductPackaging.shortname:
                    productPackaging = new ProductPackaging(e);
                    break;
                case ProductFormDescription.refname:
                case ProductFormDescription.shortname:
                    productFormDescription = new ProductFormDescription(e);
                    break;
                case NumberOfPieces.refname:
                case NumberOfPieces.shortname:
                    numberOfPieces = new NumberOfPieces(e);
                    break;
                case TradeCategory.refname:
                case TradeCategory.shortname:
                    tradeCategory = new TradeCategory(e);
                    break;
                case ItemQuantity.refname:
                case ItemQuantity.shortname:
                    itemQuantity = new ItemQuantity(e);
                    break;
                case ProductIdentifier.refname:
                case ProductIdentifier.shortname:
                    productIdentifiers = JPU.addToList(productIdentifiers, new ProductIdentifier(e));
                    break;
                case ProductFormDetail.refname:
                case ProductFormDetail.shortname:
                    productFormDetails = JPU.addToList(productFormDetails, new ProductFormDetail(e));
                    break;
                case ProductFormFeature.refname:
                case ProductFormFeature.shortname:
                    productFormFeatures = JPU.addToList(productFormFeatures, new ProductFormFeature(e));
                    break;
                case BookFormDetail.refname:
                case BookFormDetail.shortname:
                    bookFormDetails = JPU.addToList(bookFormDetails, new BookFormDetail(e));
                    break;
                case ProductContentType.refname:
                case ProductContentType.shortname:
                    productContentTypes = JPU.addToList(productContentTypes, new ProductContentType(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;ContainedItem&gt; or &lt;containeditem&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    @Override
    public org.w3c.dom.Element getXmlElement() {
        return element;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private ISBN isbn = ISBN.EMPTY;

    /**
     * <p>
     * 10-character ISBN of the contained item. Optional and non-repeating. <strong>The &lt;ProductIdentifier&gt;
     * composite provides a more general method of handling product codes, and is preferred. The &lt;ISBN&gt; element is
     * on no account to be used to carry a 13-digit ISBN.</strong>
     * </p>
     * Jonix-Comment: this field is required
     */
    public ISBN isbn() {
        _initialize();
        return isbn;
    }

    private EAN13 ean13 = EAN13.EMPTY;

    /**
     * <p>
     * EAN.UCC-13 number of the contained item. Optional and non-repeating. <strong>The &lt;ProductIdentifier&gt;
     * composite provides a more general method of handling product codes, and is preferred.</strong>
     * </p>
     * Jonix-Comment: this field is optional
     */
    public EAN13 ean13() {
        _initialize();
        return ean13;
    }

    private ProductForm productForm = ProductForm.EMPTY;

    /**
     * <p>
     * An ONIX code which indicates the primary form of the contained item. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public ProductForm productForm() {
        _initialize();
        return productForm;
    }

    private ProductPackaging productPackaging = ProductPackaging.EMPTY;

    /**
     * <p>
     * An ONIX code which indicates the type of packaging used for the contained item. Optional and non-repeating. This
     * field can only occur if the &lt;ContainedItem&gt; composite has a &lt;ProductForm&gt; code.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public ProductPackaging productPackaging() {
        _initialize();
        return productPackaging;
    }

    private ProductFormDescription productFormDescription = ProductFormDescription.EMPTY;

    /**
     * <p>
     * If product form codes do not adequately describe the contained item, a short text description may be added.
     * Optional and non-repeating. This field can only occur if the &lt;ContainedItem&gt; composite has a
     * &lt;ProductForm&gt; code.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public ProductFormDescription productFormDescription() {
        _initialize();
        return productFormDescription;
    }

    private NumberOfPieces numberOfPieces = NumberOfPieces.EMPTY;

    /**
     * <p>
     * If the contained item consists of a number of different pieces of the same form, the number may be included here.
     * Optional and non-repeating. This field can only occur if the &lt;ContainedItem&gt; composite has a
     * &lt;ProductForm&gt; code.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public NumberOfPieces numberOfPieces() {
        _initialize();
        return numberOfPieces;
    }

    private TradeCategory tradeCategory = TradeCategory.EMPTY;

    /**
     * <p>
     * An ONIX code which indicates a trade category which is somewhat related to but not properly an attribute of
     * product form. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public TradeCategory tradeCategory() {
        _initialize();
        return tradeCategory;
    }

    private ItemQuantity itemQuantity = ItemQuantity.EMPTY;

    /**
     * <p>
     * For filled dumpbins and counter packs, and for retail packs containing a number of copies of the same item, the
     * number of copies of the specified item contained in the pack. &lt;ItemQuantity&gt; is used to state a quantity of
     * identical items, when a pack contains either a quantity of a single item, or a quantity of each of two or more
     * different items (<em>eg</em> a dumpbin carrying copies of two different books, or a classroom pack containing a
     * teacher’s text and twenty student texts). Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public ItemQuantity itemQuantity() {
        _initialize();
        return itemQuantity;
    }

    private ListOfOnixDataCompositeWithKey<ProductIdentifier, JonixProductIdentifier,
        ProductIdentifierTypes> productIdentifiers = JPU.emptyListOfOnixDataCompositeWithKey(ProductIdentifier.class);

    /**
     * <p>
     * A repeatable group of data elements which together define the identifier of a product in accordance with a
     * specified scheme, used here to carry the product identifier of a contained item. <strong>See notes on the
     * &lt;ProductIdentifier&gt; composite in section PR.2 for details of the handling of ISBN-13.</strong>
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<ProductIdentifier, JonixProductIdentifier, ProductIdentifierTypes>
        productIdentifiers() {
        _initialize();
        return productIdentifiers;
    }

    private ListOfOnixCodelist<ProductFormDetail, ProductFormDetailsList78> productFormDetails =
        JPU.emptyListOfOnixCodelist(ProductFormDetail.class);

    /**
     * <p>
     * An ONIX code which provides added detail of the medium and/or format of the contained item. Optional and
     * repeatable. This field can only occur if the &lt;ContainedItem&gt; composite has a &lt;ProductForm&gt; code.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixCodelist<ProductFormDetail, ProductFormDetailsList78> productFormDetails() {
        _initialize();
        return productFormDetails;
    }

    private ListOfOnixDataCompositeWithKey<ProductFormFeature, JonixProductFormFeature,
        ProductFormFeatureTypes> productFormFeatures =
            JPU.emptyListOfOnixDataCompositeWithKey(ProductFormFeature.class);

    /**
     * <p>
     * A repeatable group of data elements which together describe an aspect of product form that is too specific to be
     * covered in the &lt;ProductForm&gt; and &lt;ProductFormDetail&gt; elements. Optional. The
     * &lt;ProductFormFeature&gt; composite can only occur if the &lt;ContainedItem&gt; composite has a
     * &lt;ProductForm&gt; code.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<ProductFormFeature, JonixProductFormFeature, ProductFormFeatureTypes>
        productFormFeatures() {
        _initialize();
        return productFormFeatures;
    }

    private ListOfOnixCodelist<BookFormDetail, BookFormDetails> bookFormDetails =
        JPU.emptyListOfOnixCodelist(BookFormDetail.class);

    /**
     * <p>
     * An ONIX code specifying more detail of the contained item when the item is a book. Optional and repeatable, and
     * must only be included when the &lt;ProductForm&gt; code for the contained item begins with letter B. <strong>This
     * field will be superseded by the new element &lt;ProductFormDetail&gt;, and the code list will not be further
     * developed. The field is retained only for purposes of upwards compatibility, and its use is now to be
     * deprecated.</strong>
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixCodelist<BookFormDetail, BookFormDetails> bookFormDetails() {
        _initialize();
        return bookFormDetails;
    }

    private ListOfOnixCodelist<ProductContentType, ProductContentTypes> productContentTypes =
        JPU.emptyListOfOnixCodelist(ProductContentType.class);

    /**
     * <p>
     * An ONIX code which indicates certain types of content which are closely related to but not strictly an attribute
     * of product form, <em>eg</em> audiobook. Optional and repeatable. The element is intended to be used with products
     * where content is delivered in the form of a digital or analogue recording. It is not expected to be used for
     * books.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixCodelist<ProductContentType, ProductContentTypes> productContentTypes() {
        _initialize();
        return productContentTypes;
    }
}
