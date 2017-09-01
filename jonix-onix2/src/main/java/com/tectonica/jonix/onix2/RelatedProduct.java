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
import com.tectonica.jonix.ListOfOnixDataComposite;
import com.tectonica.jonix.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.ListOfOnixElement;
import com.tectonica.jonix.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.codelist.BookFormDetails;
import com.tectonica.jonix.codelist.LanguageCodes;
import com.tectonica.jonix.codelist.ProductContentTypes;
import com.tectonica.jonix.codelist.ProductFormDetails;
import com.tectonica.jonix.codelist.ProductFormFeatureTypes;
import com.tectonica.jonix.codelist.ProductIdentifierTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;
import com.tectonica.jonix.struct.JonixProductFormFeature;
import com.tectonica.jonix.struct.JonixProductIdentifier;
import com.tectonica.jonix.struct.JonixWebsite;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Related product composite</h1><p>A repeatable group of data elements which together describe a product which has
 * a specified relationship to the product which is described in the ONIX record. Although for reasons of upwards
 * compatibility the composite includes individual fields for ISBN and EAN-13 number, use of the nested
 * &lt;ProductIdentifier&gt; composite is to be preferred, since it allows any recognized identifier scheme (<em>eg</em>
 * DOI) to be used.</p><p>The minimum required content of an occurrence of the &lt;RelatedProduct&gt; composite is a
 * &lt;RelationCode&gt; and either a product identifier or a &lt;ProductForm&gt; value. In other words, it is valid to
 * list related products by relationship and identifier only, or by relationship and form only.</p><table border='1'
 * cellpadding='3'><tr><td>Reference name</td><td>&lt;RelatedProduct&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;relatedproduct&gt;</td></tr></table>
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
    }

    private void initialize() {
        if (initialized) {
            return;
        }
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
            if (name.equals(RelationCode.refname) || name.equals(RelationCode.shortname)) {
                relationCode = new RelationCode(e);
            } else if (name.equals(ISBN.refname) || name.equals(ISBN.shortname)) {
                isbn = new ISBN(e);
            } else if (name.equals(EAN13.refname) || name.equals(EAN13.shortname)) {
                ean13 = new EAN13(e);
            } else if (name.equals(ProductIdentifier.refname) || name.equals(ProductIdentifier.shortname)) {
                productIdentifiers = JPU.addToList(productIdentifiers, new ProductIdentifier(e));
            } else if (name.equals(Website.refname) || name.equals(Website.shortname)) {
                websites = JPU.addToList(websites, new Website(e));
            } else if (name.equals(ProductForm.refname) || name.equals(ProductForm.shortname)) {
                productForm = new ProductForm(e);
            } else if (name.equals(ProductFormDetail.refname) || name.equals(ProductFormDetail.shortname)) {
                productFormDetails = JPU.addToList(productFormDetails, new ProductFormDetail(e));
            } else if (name.equals(ProductFormFeature.refname) || name.equals(ProductFormFeature.shortname)) {
                productFormFeatures = JPU.addToList(productFormFeatures, new ProductFormFeature(e));
            } else if (name.equals(BookFormDetail.refname) || name.equals(BookFormDetail.shortname)) {
                bookFormDetails = JPU.addToList(bookFormDetails, new BookFormDetail(e));
            } else if (name.equals(ProductPackaging.refname) || name.equals(ProductPackaging.shortname)) {
                productPackaging = new ProductPackaging(e);
            } else if (name.equals(ProductFormDescription.refname) || name.equals(ProductFormDescription.shortname)) {
                productFormDescription = new ProductFormDescription(e);
            } else if (name.equals(NumberOfPieces.refname) || name.equals(NumberOfPieces.shortname)) {
                numberOfPieces = new NumberOfPieces(e);
            } else if (name.equals(TradeCategory.refname) || name.equals(TradeCategory.shortname)) {
                tradeCategory = new TradeCategory(e);
            } else if (name.equals(ProductContentType.refname) || name.equals(ProductContentType.shortname)) {
                productContentTypes = JPU.addToList(productContentTypes, new ProductContentType(e));
            } else if (name.equals(EpubType.refname) || name.equals(EpubType.shortname)) {
                epubType = new EpubType(e);
            } else if (name.equals(EpubTypeVersion.refname) || name.equals(EpubTypeVersion.shortname)) {
                epubTypeVersion = new EpubTypeVersion(e);
            } else if (name.equals(EpubTypeDescription.refname) || name.equals(EpubTypeDescription.shortname)) {
                epubTypeDescription = new EpubTypeDescription(e);
            } else if (name.equals(EpubFormat.refname) || name.equals(EpubFormat.shortname)) {
                epubFormat = new EpubFormat(e);
            } else if (name.equals(EpubFormatVersion.refname) || name.equals(EpubFormatVersion.shortname)) {
                epubFormatVersion = new EpubFormatVersion(e);
            } else if (name.equals(EpubFormatDescription.refname) || name.equals(EpubFormatDescription.shortname)) {
                epubFormatDescription = new EpubFormatDescription(e);
            } else if (name.equals(EpubTypeNote.refname) || name.equals(EpubTypeNote.shortname)) {
                epubTypeNote = new EpubTypeNote(e);
            } else if (name.equals(Publisher.refname) || name.equals(Publisher.shortname)) {
                publishers = JPU.addToList(publishers, new Publisher(e));
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

    private RelationCode relationCode = RelationCode.EMPTY;

    /**
     * (this field is required)
     */
    public RelationCode relationCode() {
        initialize();
        return relationCode;
    }

    private ISBN isbn = ISBN.EMPTY;

    /**
     * (this field is required)
     */
    public ISBN isbn() {
        initialize();
        return isbn;
    }

    private EAN13 ean13 = EAN13.EMPTY;

    /**
     * (this field is optional)
     */
    public EAN13 ean13() {
        initialize();
        return ean13;
    }

    private ListOfOnixDataCompositeWithKey<ProductIdentifier, JonixProductIdentifier, ProductIdentifierTypes>
        productIdentifiers = ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataCompositeWithKey<ProductIdentifier, JonixProductIdentifier, ProductIdentifierTypes> productIdentifiers() {
        initialize();
        return productIdentifiers;
    }

    private ListOfOnixDataComposite<Website, JonixWebsite> websites = ListOfOnixDataComposite.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataComposite<Website, JonixWebsite> websites() {
        initialize();
        return websites;
    }

    private ProductForm productForm = ProductForm.EMPTY;

    /**
     * (this field is optional)
     */
    public ProductForm productForm() {
        initialize();
        return productForm;
    }

    private ListOfOnixElement<ProductFormDetail, ProductFormDetails> productFormDetails = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<ProductFormDetail, ProductFormDetails> productFormDetails() {
        initialize();
        return productFormDetails;
    }

    private ListOfOnixDataCompositeWithKey<ProductFormFeature, JonixProductFormFeature, ProductFormFeatureTypes>
        productFormFeatures = ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataCompositeWithKey<ProductFormFeature, JonixProductFormFeature, ProductFormFeatureTypes> productFormFeatures() {
        initialize();
        return productFormFeatures;
    }

    private ListOfOnixElement<BookFormDetail, BookFormDetails> bookFormDetails = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<BookFormDetail, BookFormDetails> bookFormDetails() {
        initialize();
        return bookFormDetails;
    }

    private ProductPackaging productPackaging = ProductPackaging.EMPTY;

    /**
     * (this field is optional)
     */
    public ProductPackaging productPackaging() {
        initialize();
        return productPackaging;
    }

    private ProductFormDescription productFormDescription = ProductFormDescription.EMPTY;

    /**
     * (this field is optional)
     */
    public ProductFormDescription productFormDescription() {
        initialize();
        return productFormDescription;
    }

    private NumberOfPieces numberOfPieces = NumberOfPieces.EMPTY;

    /**
     * (this field is optional)
     */
    public NumberOfPieces numberOfPieces() {
        initialize();
        return numberOfPieces;
    }

    private TradeCategory tradeCategory = TradeCategory.EMPTY;

    /**
     * (this field is optional)
     */
    public TradeCategory tradeCategory() {
        initialize();
        return tradeCategory;
    }

    private ListOfOnixElement<ProductContentType, ProductContentTypes> productContentTypes = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<ProductContentType, ProductContentTypes> productContentTypes() {
        initialize();
        return productContentTypes;
    }

    private EpubType epubType = EpubType.EMPTY;

    /**
     * (this field is optional)
     */
    public EpubType epubType() {
        initialize();
        return epubType;
    }

    private EpubTypeVersion epubTypeVersion = EpubTypeVersion.EMPTY;

    /**
     * (this field is optional)
     */
    public EpubTypeVersion epubTypeVersion() {
        initialize();
        return epubTypeVersion;
    }

    private EpubTypeDescription epubTypeDescription = EpubTypeDescription.EMPTY;

    /**
     * (this field is optional)
     */
    public EpubTypeDescription epubTypeDescription() {
        initialize();
        return epubTypeDescription;
    }

    private EpubFormat epubFormat = EpubFormat.EMPTY;

    /**
     * (this field is optional)
     */
    public EpubFormat epubFormat() {
        initialize();
        return epubFormat;
    }

    private EpubFormatVersion epubFormatVersion = EpubFormatVersion.EMPTY;

    /**
     * (this field is optional)
     */
    public EpubFormatVersion epubFormatVersion() {
        initialize();
        return epubFormatVersion;
    }

    private EpubFormatDescription epubFormatDescription = EpubFormatDescription.EMPTY;

    /**
     * (this field is optional)
     */
    public EpubFormatDescription epubFormatDescription() {
        initialize();
        return epubFormatDescription;
    }

    private EpubTypeNote epubTypeNote = EpubTypeNote.EMPTY;

    /**
     * (this field is optional)
     */
    public EpubTypeNote epubTypeNote() {
        initialize();
        return epubTypeNote;
    }

    private List<Publisher> publishers = Collections.emptyList();

    /**
     * (this list may be empty)
     */
    public List<Publisher> publishers() {
        initialize();
        return publishers;
    }
}
