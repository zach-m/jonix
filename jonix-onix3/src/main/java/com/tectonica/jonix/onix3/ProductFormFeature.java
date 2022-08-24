/*
 * Copyright (C) 2012-2022 Zach Melamed
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

import com.tectonica.jonix.common.JPU;
import com.tectonica.jonix.common.ListOfOnixElement;
import com.tectonica.jonix.common.OnixComposite.OnixDataCompositeWithKey;
import com.tectonica.jonix.common.codelist.ProductFormFeatureTypes;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixProductFormFeature;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Product form feature composite</h1>
 * <p>
 * An optional group of data elements which together describe an aspect of product form that is too specific to be
 * covered in the &lt;ProductForm&gt; and &lt;ProductFormDetail&gt; elements. Repeatable in order to describe different
 * aspects of the product form.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;ProductFormFeature&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;productformfeature&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link DescriptiveDetail}&gt;</li>
 * <li>&lt;{@link ProductPart}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link ProductFormFeature}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link ProductPart} ⯈
 * {@link ProductFormFeature}</li>
 * </ul>
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

    /**
     * (type: dt.NonEmptyString)
     */
    public String sourcename;

    public RecordSourceTypes sourcetype;

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
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcename = JPU.getAttribute(element, "sourcename");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
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

    /**
     * @return whether this tag (&lt;ProductFormFeature&gt; or &lt;productformfeature&gt;) is explicitly provided in the
     *         ONIX XML
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

    private ProductFormFeatureType productFormFeatureType = ProductFormFeatureType.EMPTY;

    /**
     * <p>
     * An ONIX code which specifies the feature described by an instance of the &lt;ProductFormFeature&gt; composite,
     * <i>eg</i> binding color. Mandatory in each occurrence of the composite, and non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public ProductFormFeatureType productFormFeatureType() {
        _initialize();
        return productFormFeatureType;
    }

    private ProductFormFeatureValue productFormFeatureValue = ProductFormFeatureValue.EMPTY;

    /**
     * <p>
     * A controlled value that describes a product form feature. Presence or absence of this element depends on the
     * &lt;ProductFormFeatureType&gt;, since some product form features (<i>eg</i> thumb index) do not require an
     * accompanying value, while others (<i>eg</i> text font) require free text in
     * &lt;ProductFormFeatureDescription&gt;; and others may have both code and free text. Non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public ProductFormFeatureValue productFormFeatureValue() {
        _initialize();
        return productFormFeatureValue;
    }

    private ListOfOnixElement<ProductFormFeatureDescription, String> productFormFeatureDescriptions =
        ListOfOnixElement.empty();

    /**
     * <p>
     * If the &lt;ProductFormFeatureType&gt; requires free text rather than a code value, or if the code in
     * &lt;ProductFormFeatureValue&gt; does not adequately describe the feature, a short text description may be added.
     * Optional, and repeatable to provide parallel descriptive text in multiple languages. The <i>language</i>
     * attribute is optional for a single instance of &lt;ProductFormFeatureDescription&gt;, but must be included in
     * each instance if &lt;ProductFormFeatureDescription&gt; is repeated.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<ProductFormFeatureDescription, String> productFormFeatureDescriptions() {
        _initialize();
        return productFormFeatureDescriptions;
    }

    @Override
    public JonixProductFormFeature asStruct() {
        _initialize();
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
