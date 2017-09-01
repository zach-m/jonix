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
import com.tectonica.jonix.OnixComposite.OnixDataCompositeWithKey;
import com.tectonica.jonix.codelist.ProductClassificationTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixProductClassification;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Product classification composite</h1><p>A repeatable group of data elements which together define a product
 * classification (<em>not</em> to be confused with a subject classification). The intended use is to enable national or
 * international trade classifications (also known as commodity codes) to be carried in an ONIX record.
 * Optional.</p><table border='1' cellpadding='3'><tr><td>Reference name</td><td>&lt;ProductClassification&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;productclassification&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;n</td></tr></table>
 */
public class ProductClassification
    implements OnixDataCompositeWithKey<JonixProductClassification, ProductClassificationTypes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "ProductClassification";
    public static final String shortname = "productclassification";

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
    public static final ProductClassification EMPTY = new ProductClassification();

    public ProductClassification() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public ProductClassification(org.w3c.dom.Element element) {
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
                case ProductClassificationType.refname:
                case ProductClassificationType.shortname:
                    productClassificationType = new ProductClassificationType(e);
                    break;
                case ProductClassificationCode.refname:
                case ProductClassificationCode.shortname:
                    productClassificationCode = new ProductClassificationCode(e);
                    break;
                case Percent.refname:
                case Percent.shortname:
                    percent = new Percent(e);
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

    private ProductClassificationType productClassificationType = ProductClassificationType.EMPTY;

    /**
     * (this field is required)
     */
    public ProductClassificationType productClassificationType() {
        initialize();
        return productClassificationType;
    }

    private ProductClassificationCode productClassificationCode = ProductClassificationCode.EMPTY;

    /**
     * (this field is required)
     */
    public ProductClassificationCode productClassificationCode() {
        initialize();
        return productClassificationCode;
    }

    private Percent percent = Percent.EMPTY;

    /**
     * (this field is optional)
     */
    public Percent percent() {
        initialize();
        return percent;
    }

    @Override
    public JonixProductClassification asStruct() {
        initialize();
        JonixProductClassification struct = new JonixProductClassification();
        struct.productClassificationType = productClassificationType.value;
        struct.percent = percent.value;
        struct.productClassificationCode = productClassificationCode.value;
        return struct;
    }

    @Override
    public ProductClassificationTypes structKey() {
        return productClassificationType().value;
    }
}
