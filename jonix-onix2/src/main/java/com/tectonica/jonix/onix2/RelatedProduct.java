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
import com.tectonica.jonix.common.ListOfOnixDataComposite;
import com.tectonica.jonix.common.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.common.ListOfOnixElement;
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
import com.tectonica.jonix.common.struct.JonixWebsite;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Related product composite</h1>
 * <p>
 * A repeatable group of data elements which together describe a product which has a specified relationship to the
 * product which is described in the ONIX record. Although for reasons of upwards compatibility the composite includes
 * individual fields for ISBN and EAN-13 number, use of the nested &lt;ProductIdentifier&gt; composite is to be
 * preferred, since it allows any recognized identifier scheme (<em>eg</em> DOI) to be used.
 * </p>
 * <p>
 * The minimum required content of an occurrence of the &lt;RelatedProduct&gt; composite is a &lt;RelationCode&gt; and
 * either a product identifier or a &lt;ProductForm&gt; value. In other words, it is valid to list related products by
 * relationship and identifier only, or by relationship and form only.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;RelatedProduct&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;relatedproduct&gt;</tt></td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;Product&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>ONIXMessage ⯈ Product ⯈ RelatedProduct</li>
 * </ul>
 */
public class RelatedProduct implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "RelatedProduct";
    public static final String shortname = "relatedproduct";

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
    public static final RelatedProduct EMPTY = new RelatedProduct();

    public RelatedProduct() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public RelatedProduct(org.w3c.dom.Element element) {
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
                case RelationCode.refname:
                case RelationCode.shortname:
                    relationCode = new RelationCode(e);
                    break;
                case ISBN.refname:
                case ISBN.shortname:
                    isbn = new ISBN(e);
                    break;
                case EAN13.refname:
                case EAN13.shortname:
                    ean13 = new EAN13(e);
                    break;
                case ProductIdentifier.refname:
                case ProductIdentifier.shortname:
                    productIdentifiers = JPU.addToList(productIdentifiers, new ProductIdentifier(e));
                    break;
                case Website.refname:
                case Website.shortname:
                    websites = JPU.addToList(websites, new Website(e));
                    break;
                case ProductForm.refname:
                case ProductForm.shortname:
                    productForm = new ProductForm(e);
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
                case ProductContentType.refname:
                case ProductContentType.shortname:
                    productContentTypes = JPU.addToList(productContentTypes, new ProductContentType(e));
                    break;
                case EpubType.refname:
                case EpubType.shortname:
                    epubType = new EpubType(e);
                    break;
                case EpubTypeVersion.refname:
                case EpubTypeVersion.shortname:
                    epubTypeVersion = new EpubTypeVersion(e);
                    break;
                case EpubTypeDescription.refname:
                case EpubTypeDescription.shortname:
                    epubTypeDescription = new EpubTypeDescription(e);
                    break;
                case EpubFormat.refname:
                case EpubFormat.shortname:
                    epubFormat = new EpubFormat(e);
                    break;
                case EpubFormatVersion.refname:
                case EpubFormatVersion.shortname:
                    epubFormatVersion = new EpubFormatVersion(e);
                    break;
                case EpubFormatDescription.refname:
                case EpubFormatDescription.shortname:
                    epubFormatDescription = new EpubFormatDescription(e);
                    break;
                case EpubTypeNote.refname:
                case EpubTypeNote.shortname:
                    epubTypeNote = new EpubTypeNote(e);
                    break;
                case Publisher.refname:
                case Publisher.shortname:
                    publishers = JPU.addToList(publishers, new Publisher(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;RelatedProduct&gt; or &lt;relatedproduct&gt;) is explicitly provided in the ONIX
     * XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private RelationCode relationCode = RelationCode.EMPTY;

    /**
     * <p>
     * An ONIX code which identifies the nature of the relationship between two products, <em>eg</em> “replaced-by”.
     * Mandatory in each occurrence of the &lt;RelatedProduct&gt; composite, and non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public RelationCode relationCode() {
        _initialize();
        return relationCode;
    }

    private ISBN isbn = ISBN.EMPTY;

    /**
     * <p>
     * 10-character ISBN of the related product. Optional and non-repeating. <strong>The &lt;ProductIdentifier&gt;
     * composite provides a more general method of handling identifiers, and is to be preferred. The &lt;ISBN&gt;
     * element is on no account to be used to carry a 13-digit ISBN.</strong>
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
     * EAN.UCC-13 number of the related product. Optional and non-repeating. <strong>The &lt;ProductIdentifier&gt;
     * composite provides a more general method of handling identifiers, and is to be preferred.</strong>
     * </p>
     * Jonix-Comment: this field is optional
     */
    public EAN13 ean13() {
        _initialize();
        return ean13;
    }

    private ListOfOnixDataCompositeWithKey<ProductIdentifier, JonixProductIdentifier, ProductIdentifierTypes>
        productIdentifiers = ListOfOnixDataCompositeWithKey
        .emptyKeyed();

    /**
     * <p>
     * A repeatable group of data elements which together define the identifier of a product in accordance with a
     * specified scheme, and allowing other types of product identifier for a related product to be included without
     * defining additional data elements. <strong>See notes on the &lt;ProductIdentifier&gt; composite in
     * section&nbsp;PR.2 for details of the handling of ISBN-13.</strong>
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<ProductIdentifier, JonixProductIdentifier, ProductIdentifierTypes> productIdentifiers() {
        _initialize();
        return productIdentifiers;
    }

    private ListOfOnixDataComposite<Website, JonixWebsite> websites = ListOfOnixDataComposite.empty();

    /**
     * <p>
     * An optional and repeatable group of data elements which together identify and provide pointers to a website which
     * is relevant to the product identified in an occurrence of the &lt;RelatedProduct&gt; composite.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataComposite<Website, JonixWebsite> websites() {
        _initialize();
        return websites;
    }

    private ProductForm productForm = ProductForm.EMPTY;

    /**
     * <p>
     * An ONIX code which indicates the primary form of the product. Optional and non-repeating; required in any
     * occurrence of the &lt;RelatedProduct&gt; composite that does not carry a product identifier.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public ProductForm productForm() {
        _initialize();
        return productForm;
    }

    private ListOfOnixElement<ProductFormDetail, ProductFormDetailsList78> productFormDetails = ListOfOnixElement
        .empty();

    /**
     * <p>
     * An ONIX code which provides added detail of the medium and/or format of the product. Optional and repeatable.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<ProductFormDetail, ProductFormDetailsList78> productFormDetails() {
        _initialize();
        return productFormDetails;
    }

    private ListOfOnixDataCompositeWithKey<ProductFormFeature, JonixProductFormFeature, ProductFormFeatureTypes>
        productFormFeatures = ListOfOnixDataCompositeWithKey
        .emptyKeyed();

    /**
     * <p>
     * A repeatable group of data elements which together describe an aspect of product form that is too specific to be
     * covered in the &lt;ProductForm&gt; and &lt;ProductFormDetail&gt; elements. Optional.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<ProductFormFeature, JonixProductFormFeature, ProductFormFeatureTypes> productFormFeatures() {
        _initialize();
        return productFormFeatures;
    }

    private ListOfOnixElement<BookFormDetail, BookFormDetails> bookFormDetails = ListOfOnixElement.empty();

    /**
     * <p>
     * An ONIX code specifying more detail of the product format when the product is a book. Repeatable when two or more
     * coded characteristics apply. This field is optional, but must only be included when the code in the
     * &lt;ProductForm&gt; element begins with letter B. <strong>Note that this field has been superseded by the new
     * element &lt;ProductFormDetail&gt;, and the code list will not be further developed. The field is retained only
     * for purposes of upwards compatibility, and its use is now to be deprecated.</strong>
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<BookFormDetail, BookFormDetails> bookFormDetails() {
        _initialize();
        return bookFormDetails;
    }

    private ProductPackaging productPackaging = ProductPackaging.EMPTY;

    /**
     * <p>
     * An ONIX code which indicates the type of packaging used for the product. Optional and non-repeating.
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
     * If product form codes do not adequately describe the product, a short text description may be added. The text may
     * include the number and type of pieces contained in a multiple product, and/or a more detailed specification of
     * the product form. The field is optional and non-repeating.
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
     * If the product is homogeneous (<em>ie</em> all items or pieces which constitute the product have the same form),
     * the number of items or pieces may be included here. If the product consists of a number of items or pieces of
     * different forms (<em>eg</em> books and audio cassettes), the &lt;ContainedItem&gt; composite should be used – see
     * below. This field is optional and non-repeating.
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

    private ListOfOnixElement<ProductContentType, ProductContentTypes> productContentTypes = ListOfOnixElement.empty();

    /**
     * <p>
     * An ONIX code which indicates certain types of content which are closely related to but not strictly an attribute
     * of product form, <em>eg</em> audiobook. Optional and repeatable. The element is intended to be used with products
     * where content is delivered in the form of a digital or analogue recording. It is not expected to be used for
     * books.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<ProductContentType, ProductContentTypes> productContentTypes() {
        _initialize();
        return productContentTypes;
    }

    private EpubType epubType = EpubType.EMPTY;

    /**
     * <p>
     * An ONIX code identifying the type of an epublication. This element is mandatory if and only if the
     * &lt;ProductForm&gt; code for the product is DG.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public EpubType epubType() {
        _initialize();
        return epubType;
    }

    private EpubTypeVersion epubTypeVersion = EpubTypeVersion.EMPTY;

    /**
     * <p>
     * A version number which applies to a specific epublication type. Optional and non-repeating, and can occur only if
     * the &lt;EpubType&gt; field is present.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public EpubTypeVersion epubTypeVersion() {
        _initialize();
        return epubTypeVersion;
    }

    private EpubTypeDescription epubTypeDescription = EpubTypeDescription.EMPTY;

    /**
     * <p>
     * A free text description of an epublication type. Optional and non-repeating, and can occur only if the
     * &lt;EpubType&gt; field is present.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public EpubTypeDescription epubTypeDescription() {
        _initialize();
        return epubTypeDescription;
    }

    private EpubFormat epubFormat = EpubFormat.EMPTY;

    /**
     * <p>
     * An ONIX code identifying the underlying format of an epublication. Optional and non-repeating, and can occur only
     * if the &lt;EpubType&gt; field is present. Note that where the epublication type is wholly defined by the delivery
     * format, this element effectively duplicates the &lt;EpubType&gt; field.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public EpubFormat epubFormat() {
        _initialize();
        return epubFormat;
    }

    private EpubFormatVersion epubFormatVersion = EpubFormatVersion.EMPTY;

    /**
     * <p>
     * A version number which applies to an epublication format. Optional and non-repeating, and can occur only if the
     * &lt;EpubFormat&gt; field is present.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public EpubFormatVersion epubFormatVersion() {
        _initialize();
        return epubFormatVersion;
    }

    private EpubFormatDescription epubFormatDescription = EpubFormatDescription.EMPTY;

    /**
     * <p>
     * A free text description of an epublication format. Optional and non-repeating, and can occur only if the
     * &lt;EpubType&gt; field is present, but it does not require the presence of the &lt;EpubFormat&gt; field.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public EpubFormatDescription epubFormatDescription() {
        _initialize();
        return epubFormatDescription;
    }

    private EpubTypeNote epubTypeNote = EpubTypeNote.EMPTY;

    /**
     * <p>
     * A free text description of features of a product which are specific to its appearance as a particular
     * epublication type. Optional and non-repeatable, and can occur only if the &lt;EpubType&gt; field is present.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public EpubTypeNote epubTypeNote() {
        _initialize();
        return epubTypeNote;
    }

    private List<Publisher> publishers = Collections.emptyList();

    /**
     * <p>
     * A repeatable group of data elements which together identify an entity which is associated with the publishing of
     * a related product. The composite will allow additional publishing roles to be introduced without adding new
     * fields. Each occurrence of the composite must carry a publishing role code and either a name code or a name or
     * both. <strong>Please see Group&nbsp;PR.19 for details.</strong>
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public List<Publisher> publishers() {
        _initialize();
        return publishers;
    }
}
