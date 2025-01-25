/*
 * Copyright (C) 2012-2025 Zach Melamed
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
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.Consumer;

import com.tectonica.jonix.common.*;
import com.tectonica.jonix.common.OnixComposite.*;
import com.tectonica.jonix.common.codelist.*;
import com.tectonica.jonix.common.struct.*;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Product form feature composite</h1>
 * <p>
 * A repeatable group of data elements which together describe an aspect of product form that is too specific to be
 * covered in the &lt;ProductForm&gt; and &lt;ProductFormDetail&gt; elements. Optional.
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
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Product}&gt;</li>
 * <li>&lt;{@link ContainedItem}&gt;</li>
 * <li>&lt;{@link RelatedProduct}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link ProductFormFeature}</li>
 * <li>{@link Product} ⯈ {@link ContainedItem} ⯈ {@link ProductFormFeature}</li>
 * <li>{@link Product} ⯈ {@link RelatedProduct} ⯈ {@link ProductFormFeature}</li>
 * </ul>
 *
 * @since Onix-2.1
 */
public class ProductFormFeature
    implements OnixDataCompositeWithKey<JonixProductFormFeature, ProductFormFeatureTypes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "ProductFormFeature";
    public static final String shortname = "productformfeature";

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
                    productFormFeatureDescription = new ProductFormFeatureDescription(e);
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

    public void ifExists(Consumer<ProductFormFeature> action) {
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

    private ProductFormFeatureType productFormFeatureType = ProductFormFeatureType.EMPTY;

    /**
     * <p>
     * An ONIX code which specifies the feature described by an instance of the &lt;ProductFormFeature&gt; composite,
     * <em>eg</em> binding color. Mandatory in each occurrence of the composite, and non-repeating.
     * </p>
     * JONIX adds: this field is required
     */
    public ProductFormFeatureType productFormFeatureType() {
        _initialize();
        return productFormFeatureType;
    }

    private ProductFormFeatureValue productFormFeatureValue = ProductFormFeatureValue.EMPTY;

    /**
     * <p>
     * A controlled value that describes a product form feature. Presence or absence of this element depends on the
     * &lt;ProductFormFeatureType&gt;, since some product form features (<em>eg</em> thumb index) do not require an
     * accompanying value, while others (<em>eg</em> text font) require free text in
     * &lt;ProductFormFeatureDescription&gt;. Non-repeating.
     * </p>
     * JONIX adds: this field is optional
     */
    public ProductFormFeatureValue productFormFeatureValue() {
        _initialize();
        return productFormFeatureValue;
    }

    private ProductFormFeatureDescription productFormFeatureDescription = ProductFormFeatureDescription.EMPTY;

    /**
     * <p>
     * If the &lt;ProductFormFeatureType&gt; requires free text rather than a code value, or if the code in
     * &lt;ProductFormFeatureValue&gt; does not adequately describe the feature, a short text description may be added.
     * Optional and non-repeating.
     * </p>
     * JONIX adds: this field is optional
     */
    public ProductFormFeatureDescription productFormFeatureDescription() {
        _initialize();
        return productFormFeatureDescription;
    }

    @Override
    public JonixProductFormFeature asStruct() {
        _initialize();
        JonixProductFormFeature struct = new JonixProductFormFeature();
        struct.productFormFeatureType = productFormFeatureType.value;
        struct.productFormFeatureDescriptions =
            productFormFeatureDescription.exists() ? Collections.singletonList(productFormFeatureDescription.value)
                : Collections.emptyList();
        struct.productFormFeatureValue = productFormFeatureValue.value;
        return struct;
    }

    @Override
    public ProductFormFeatureTypes structKey() {
        return productFormFeatureType().value;
    }
}
