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
import com.tectonica.jonix.ListOfOnixElement;
import com.tectonica.jonix.OnixComposite.OnixDataCompositeWithKey;
import com.tectonica.jonix.codelist.ProductFormFeatureTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixProductFormFeature;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Product form feature composite (product part)</h1><p>A repeatable group of data elements which together describe
 * an aspect of product form that is too specific to be covered in the &lt;ProductForm&gt; and &lt;ProductFormDetail&gt;
 * elements. Optional, and not normally expected to be used in the description of a product part. The composite is
 * included here so that it can if necessary be used in the US to carry consumer protection data related to a product
 * part.</p><table border='1' cellpadding='3'><tr><td>Reference name</td><td>&lt;ProductFormFeature&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;productformfeature&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;n</td></tr></table>
 */
public class ProductFormFeature
    implements OnixDataCompositeWithKey<JonixProductFormFeature, ProductFormFeatureTypes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "ProductFormFeature";
    public static final String shortname = "productformfeature";

    /////////////////////////////////////////////////////////////////////////////////
    // ATTRIBUTES
    /////////////////////////////////////////////////////////////////////////////////

    /**
     * (type: dt.DateOrDateTime)
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
    public static final ProductFormFeature EMPTY = new ProductFormFeature();

    public ProductFormFeature() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public ProductFormFeature(org.w3c.dom.Element element) {
        exists = true;
        initialized = false;
        this.element = element;
    }

    private void initialize() {
        if (initialized) {
            return;
        }
        initialized = true;

        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        JPU.forElementsOf(element, e -> {
            final String name = e.getNodeName();
            switch (name) {
                case ProductFormFeatureType.refname:
                case ProductFormFeatureType.shortname:
                    productFormFeatureType = new ProductFormFeatureType(e);
                    break;
                case ProductFormFeatureValue.refname:
                case ProductFormFeatureValue.shortname:
                    productFormFeatureValue = new ProductFormFeatureValue(e);
                    break;
                case ProductFormFeatureDescription.refname:
                case ProductFormFeatureDescription.shortname:
                    productFormFeatureDescriptions =
                        JPU.addToList(productFormFeatureDescriptions, new ProductFormFeatureDescription(e));
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

    private ProductFormFeatureType productFormFeatureType = ProductFormFeatureType.EMPTY;

    /**
     * (this field is required)
     */
    public ProductFormFeatureType productFormFeatureType() {
        initialize();
        return productFormFeatureType;
    }

    private ProductFormFeatureValue productFormFeatureValue = ProductFormFeatureValue.EMPTY;

    /**
     * (this field is optional)
     */
    public ProductFormFeatureValue productFormFeatureValue() {
        initialize();
        return productFormFeatureValue;
    }

    private ListOfOnixElement<ProductFormFeatureDescription, String> productFormFeatureDescriptions =
        ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<ProductFormFeatureDescription, String> productFormFeatureDescriptions() {
        initialize();
        return productFormFeatureDescriptions;
    }

    @Override
    public JonixProductFormFeature asStruct() {
        initialize();
        JonixProductFormFeature struct = new JonixProductFormFeature();
        struct.productFormFeatureType = productFormFeatureType.value;
        struct.productFormFeatureDescriptions = productFormFeatureDescriptions.values();
        struct.productFormFeatureValue = productFormFeatureValue.value;
        return struct;
    }

    @Override
    public ProductFormFeatureTypes structKey() {
        return productFormFeatureType().value;
    }
}
