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

package com.tectonica.jonix.onix3;

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.ListOfOnixElement;
import com.tectonica.jonix.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.codelist.MeasureTypes;
import com.tectonica.jonix.codelist.ProductContentTypes;
import com.tectonica.jonix.codelist.ProductFormDetails;
import com.tectonica.jonix.codelist.ProductFormFeatureTypes;
import com.tectonica.jonix.codelist.ProductIdentifierTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixMeasure;
import com.tectonica.jonix.struct.JonixProductFormFeature;
import com.tectonica.jonix.struct.JonixProductIdentifier;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Product part composite</h1><p>A group of data elements which together describe an item which is part of or
 * contained within a multiple-component or multiple-item product or a trade pack. The composite must be used with all
 * multi-component or multi-item products and packs to specify (for example) the item(s) and item quantities included in
 * a combined book plus audiobook product, a multi-volume set, a filled dumpbin, or a classroom pack. In other cases,
 * where parts are not individually identified, it is used to state the product form(s) and the quantity or quantities
 * of each form contained within the product. The composite must be repeated for each item or component.</p><p>Each
 * instance of the &lt;ProductPart&gt; composite must carry a &lt;ProductForm&gt; code and a quantity, even if the
 * quantity is ‘1’. If the composite refers to a number of copies of a single item, the quantity must be sent as
 * &lt;NumberOfCopies&gt;, normally accompanied by a &lt;ProductIdentifier&gt;. If the composite refers to a number of
 * <em>different</em> items of the same form, without identifying them individually, the quantity must be sent as
 * &lt;NumberOfItemsOfThisForm&gt;.</p><table border='1' cellpadding='3'><tr><td>Reference
 * name</td><td>&lt;ProductPart&gt;</td></tr><tr><td>Short tag</td><td>&lt;productpart&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;n</td></tr></table>
 */
public class ProductPart implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "ProductPart";
    public static final String shortname = "productpart";

    /////////////////////////////////////////////////////////////////////////////////
    // ATTRIBUTES
    /////////////////////////////////////////////////////////////////////////////////

    /**
     * (type: dt.DateOrDateTime)
     */
    public String datestamp;

    public RecordSourceTypes sourcetype;

    /**
     * (type: dt.NonEmptyString)
     */
    public String sourcename;

    /////////////////////////////////////////////////////////////////////////////////
    // CONSTRUCTION
    /////////////////////////////////////////////////////////////////////////////////

    private boolean initialized;
    private final boolean exists;
    private final org.w3c.dom.Element element;
    public static final ProductPart EMPTY = new ProductPart();

    public ProductPart() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public ProductPart(org.w3c.dom.Element element) {
        exists = true;
        initialized = false;
        this.element = element;
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
                case PrimaryPart.refname:
                case PrimaryPart.shortname:
                    primaryPart = new PrimaryPart(e);
                    break;
                case ProductIdentifier.refname:
                case ProductIdentifier.shortname:
                    productIdentifiers = JPU.addToList(productIdentifiers, new ProductIdentifier(e));
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
                case ProductPackaging.refname:
                case ProductPackaging.shortname:
                    productPackaging = new ProductPackaging(e);
                    break;
                case ProductFormDescription.refname:
                case ProductFormDescription.shortname:
                    productFormDescriptions = JPU.addToList(productFormDescriptions, new ProductFormDescription(e));
                    break;
                case ProductContentType.refname:
                case ProductContentType.shortname:
                    productContentTypes = JPU.addToList(productContentTypes, new ProductContentType(e));
                    break;
                case Measure.refname:
                case Measure.shortname:
                    measures = JPU.addToList(measures, new Measure(e));
                    break;
                case NumberOfItemsOfThisForm.refname:
                case NumberOfItemsOfThisForm.shortname:
                    numberOfItemsOfThisForm = new NumberOfItemsOfThisForm(e);
                    break;
                case NumberOfCopies.refname:
                case NumberOfCopies.shortname:
                    numberOfCopies = new NumberOfCopies(e);
                    break;
                case CountryOfManufacture.refname:
                case CountryOfManufacture.shortname:
                    countryOfManufacture = new CountryOfManufacture(e);
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

    private PrimaryPart primaryPart = PrimaryPart.EMPTY;

    /**
     * (this field is optional)
     */
    public PrimaryPart primaryPart() {
        _initialize();
        return primaryPart;
    }

    public boolean isPrimaryPart() {
        return (primaryPart().exists());
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

    private ProductForm productForm = ProductForm.EMPTY;

    /**
     * (this field is required)
     */
    public ProductForm productForm() {
        _initialize();
        return productForm;
    }

    private ListOfOnixElement<ProductFormDetail, ProductFormDetails> productFormDetails = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<ProductFormDetail, ProductFormDetails> productFormDetails() {
        _initialize();
        return productFormDetails;
    }

    private ListOfOnixDataCompositeWithKey<ProductFormFeature, JonixProductFormFeature, ProductFormFeatureTypes>
        productFormFeatures = ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataCompositeWithKey<ProductFormFeature, JonixProductFormFeature, ProductFormFeatureTypes> productFormFeatures() {
        _initialize();
        return productFormFeatures;
    }

    private ProductPackaging productPackaging = ProductPackaging.EMPTY;

    /**
     * (this field is optional)
     */
    public ProductPackaging productPackaging() {
        _initialize();
        return productPackaging;
    }

    private ListOfOnixElement<ProductFormDescription, String> productFormDescriptions = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<ProductFormDescription, String> productFormDescriptions() {
        _initialize();
        return productFormDescriptions;
    }

    private ListOfOnixElement<ProductContentType, ProductContentTypes> productContentTypes = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<ProductContentType, ProductContentTypes> productContentTypes() {
        _initialize();
        return productContentTypes;
    }

    private ListOfOnixDataCompositeWithKey<Measure, JonixMeasure, MeasureTypes> measures =
        ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataCompositeWithKey<Measure, JonixMeasure, MeasureTypes> measures() {
        _initialize();
        return measures;
    }

    private NumberOfItemsOfThisForm numberOfItemsOfThisForm = NumberOfItemsOfThisForm.EMPTY;

    /**
     * (this field is required)
     */
    public NumberOfItemsOfThisForm numberOfItemsOfThisForm() {
        _initialize();
        return numberOfItemsOfThisForm;
    }

    private NumberOfCopies numberOfCopies = NumberOfCopies.EMPTY;

    /**
     * (this field is optional)
     */
    public NumberOfCopies numberOfCopies() {
        _initialize();
        return numberOfCopies;
    }

    private CountryOfManufacture countryOfManufacture = CountryOfManufacture.EMPTY;

    /**
     * (this field is optional)
     */
    public CountryOfManufacture countryOfManufacture() {
        _initialize();
        return countryOfManufacture;
    }
}
