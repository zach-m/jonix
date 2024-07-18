/*
 * Copyright (C) 2012-2024 Zach Melamed
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
import com.tectonica.jonix.common.OnixComposite.OnixDataCompositeWithKey;
import com.tectonica.jonix.common.codelist.ProductClassificationTypes;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixProductClassification;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Product classification composite</h1>
 * <p>
 * An optional group of data elements which together define a product classification (<em>not</em> to be confused with a
 * subject classification). The intended use is to enable national or international trade classifications (also known as
 * commodity codes) to be carried in an ONIX record. The composite is repeatable if parts of the product are classified
 * differently within a single product classification scheme, or to provide classification codes from multiple
 * classification schemes.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;ProductClassification&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;productclassification&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;ProductClassification&gt; from the schema author:
 *
 * Details of a national or international trade classification (eg HMRC customs code, TARIC code, Schedule B code)
 * &#9679; Added &lt;ProductClassificationTypeName&gt; at revision 3.0.7
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link DescriptiveDetail}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link ProductClassification}</li>
 * </ul>
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
                case ProductClassificationType.refname:
                case ProductClassificationType.shortname:
                    productClassificationType = new ProductClassificationType(e);
                    break;
                case ProductClassificationCode.refname:
                case ProductClassificationCode.shortname:
                    productClassificationCode = new ProductClassificationCode(e);
                    break;
                case ProductClassificationTypeName.refname:
                case ProductClassificationTypeName.shortname:
                    productClassificationTypeName = new ProductClassificationTypeName(e);
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

    /**
     * @return whether this tag (&lt;ProductClassification&gt; or &lt;productclassification&gt;) is explicitly provided
     *         in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<ProductClassification> action) {
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

    private ProductClassificationType productClassificationType = ProductClassificationType.EMPTY;

    /**
     * <p>
     * An ONIX code identifying the scheme from which the identifier in &lt;ProductClassificationCode&gt; is taken.
     * Mandatory in each occurrence of the &lt;ProductClassification&gt; composite, and non-repeating.
     * </p>
     * JONIX adds: this field is required
     */
    public ProductClassificationType productClassificationType() {
        _initialize();
        return productClassificationType;
    }

    private ProductClassificationCode productClassificationCode = ProductClassificationCode.EMPTY;

    /**
     * <p>
     * A classification code from the scheme specified in &lt;ProductClassificationType&gt;. Mandatory in each
     * occurrence of the &lt;ProductClassification&gt; composite, and non-repeating.
     * </p>
     * JONIX adds: this field is required
     */
    public ProductClassificationCode productClassificationCode() {
        _initialize();
        return productClassificationCode;
    }

    private ProductClassificationTypeName productClassificationTypeName = ProductClassificationTypeName.EMPTY;

    /**
     * <p>
     * A name which identifies a proprietary classification scheme (<i>ie</i> a scheme which is not a standard and for
     * which there is no individual scheme type code). Should be included when, and only when, the code in the
     * &lt;ProductClassificationType&gt; element indicates a proprietary scheme, <i>ie</i> the sender’s own category
     * scheme. Optional and non-repeating.
     * </p>
     * JONIX adds: this field is optional
     */
    public ProductClassificationTypeName productClassificationTypeName() {
        _initialize();
        return productClassificationTypeName;
    }

    private Percent percent = Percent.EMPTY;

    /**
     * <p>
     * The percentage of the unit value of the product that is assignable to a designated product classification.
     * Optional and non-repeating. Used when a mixed product (<i>eg</i> book and CD) belongs partly to two or more
     * product classes within a particular scheme. If omitted, the product classification code applies to 100% of the
     * product.
     * </p>
     * JONIX adds: this field is optional
     */
    public Percent percent() {
        _initialize();
        return percent;
    }

    @Override
    public JonixProductClassification asStruct() {
        _initialize();
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
