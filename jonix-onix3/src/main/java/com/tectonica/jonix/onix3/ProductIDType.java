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

package com.tectonica.jonix.onix3;

import com.tectonica.jonix.common.JPU;
import com.tectonica.jonix.common.OnixElement;
import com.tectonica.jonix.common.codelist.ProductIdentifierTypes;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Product identifier type code</h1>
 * <p>
 * An ONIX code identifying the scheme from which the identifier in the &lt;IDValue&gt; element is taken. Mandatory in
 * each occurrence of the &lt;ProductIdentifier&gt; composite, and non-repeating.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Fixed-length text, two digits</td>
 * </tr>
 * <tr>
 * <td>Codelist</td>
 * <td>List 5</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;ProductIDType&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;b221&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>1</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td><tt>&lt;ProductIDType&gt;03&lt;/ProductIDType&gt;</tt> (GTIN-13)</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;ProductIDType&gt; from the schema author:
 *
 * Type of identifier which uniquely identifies the product, eg an ISBN, GTIN etc
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link ProductIdentifier}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link ProductIdentifier} ⯈ {@link ProductIDType}</li>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link ProductPart} ⯈ {@link ProductIdentifier} ⯈
 * {@link ProductIDType}</li>
 * <li>{@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link SupplementManifest} ⯈
 * {@link ProductIdentifier} ⯈ {@link ProductIDType}</li>
 * <li>{@link Product} ⯈ {@link RelatedMaterial} ⯈ {@link RelatedProduct} ⯈ {@link ProductIdentifier} ⯈
 * {@link ProductIDType}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link RelatedProduct} ⯈
 * {@link ProductIdentifier} ⯈ {@link ProductIDType}</li>
 * <li>{@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link ProductIdentifier} ⯈
 * {@link ProductIDType}</li>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Price} ⯈ {@link Tax} ⯈
 * {@link ProductIdentifier} ⯈ {@link ProductIDType}</li>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Price} ⯈ {@link ComparisonProductPrice} ⯈
 * {@link ProductIdentifier} ⯈ {@link ProductIDType}</li>
 * <li>{@link Product} ⯈ {@link PublishingDetail} ⯈ {@link SalesRights} ⯈ {@link ProductIdentifier} ⯈
 * {@link ProductIDType}</li>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Price} ⯈ {@link PriceCondition} ⯈
 * {@link ProductIdentifier} ⯈ {@link ProductIDType}</li>
 * </ul>
 */
public class ProductIDType implements OnixElement<ProductIdentifierTypes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "ProductIDType";
    public static final String shortname = "b221";

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
    // VALUE MEMBER
    /////////////////////////////////////////////////////////////////////////////////

    public ProductIdentifierTypes value;

    /**
     * Internal API, use the {@link #value()} method or the {@link #value} field instead
     */
    @Override
    public ProductIdentifierTypes __v() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final ProductIDType EMPTY = new ProductIDType();

    public ProductIDType() {
        exists = false;
    }

    public ProductIDType(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcename = JPU.getAttribute(element, "sourcename");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));

        value = ProductIdentifierTypes.byCode(JPU.getContentAsString(element));
    }

    /**
     * @return whether this tag (&lt;ProductIDType&gt; or &lt;b221&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<ProductIDType> action) {
        if (exists) {
            action.accept(this);
        }
    }

    public String codeOrNull() {
        return value == null ? null : value.code;
    }

    public String descriptionOrNull() {
        return value == null ? null : value.description;
    }
}
