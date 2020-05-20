/*
 * Copyright (C) 2012-2020 Zach Melamed
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
import com.tectonica.jonix.common.codelist.ProductIdentifierTypes;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixProductIdentifier;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Product identifier composite</h1>
 * <p>
 * A group of data elements which together specify an identifier of a product in accordance with a particular scheme.
 * Mandatory within &lt;Product&gt;, and repeatable with different identifiers for the same product. As well as standard
 * identifiers, the composite allows proprietary identifiers (for example SKUs assigned by wholesalers or vendors) to be
 * sent as part of the ONIX record.
 * </p>
 * <p>
 * ISBN-13 numbers in their unhyphenated form constitute a range of EAN.UCC&nbsp;GTIN-13 numbers that has been reserved
 * for the international book trade. Effective from 1 January 2007, it was agreed by ONIX national groups that it should
 * be <em>mandatory</em> in an ONIX &lt;Product&gt; record for any item carrying an ISBN-13 to include the ISBN-13
 * labelled as an EAN.UCC GTIN-13 number (ProductIDType code 03), since this is how the ISBN-13 will be used in book
 * trade transactions. For many ONIX applications this will also be sufficient.
 * </p>
 * <p>
 * For some ONIX applications, however, particularly when data is to be supplied to the library sector, there may be
 * reasons why the ISBN-13 must <em>also</em> be sent labelled distinctively as an ISBN-13 (ProductIDType code 15).
 * Users should consult ‘good practice’ guidelines and/or discuss with their trading partners.
 * </p>
 * <p>
 * Note that for some identifiers such as ISBN, punctuation (typically hyphens or spaces for ISBNs) is used to enhance
 * readability when printed, but the punctuation is dropped when carried in ONIX data. But for other identifiers – for
 * example DOI – the punctuation is an integral part of the identifier and must always be included.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;ProductIdentifier&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;productidentifier&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>1&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Product}&gt;</li>
 * <li>&lt;{@link ProductPart}&gt;</li>
 * <li>&lt;{@link RelatedProduct}&gt;</li>
 * <li>&lt;{@link Tax}&gt;</li>
 * <li>&lt;{@link ComparisonProductPrice}&gt;</li>
 * <li>&lt;{@link SalesRights}&gt;</li>
 * <li>&lt;{@link PriceCondition}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductIdentifier}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link ProductPart} ⯈
 * {@link ProductIdentifier}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link RelatedMaterial} ⯈ {@link RelatedProduct} ⯈
 * {@link ProductIdentifier}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link RelatedProduct} ⯈
 * {@link ProductIdentifier}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Reissue} ⯈
 * {@link Price} ⯈ {@link Tax} ⯈ {@link ProductIdentifier}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Price} ⯈
 * {@link Tax} ⯈ {@link ProductIdentifier}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Reissue} ⯈
 * {@link Price} ⯈ {@link ComparisonProductPrice} ⯈ {@link ProductIdentifier}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Price} ⯈
 * {@link ComparisonProductPrice} ⯈ {@link ProductIdentifier}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link PublishingDetail} ⯈ {@link SalesRights} ⯈
 * {@link ProductIdentifier}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Reissue} ⯈
 * {@link Price} ⯈ {@link PriceCondition} ⯈ {@link ProductIdentifier}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Price} ⯈
 * {@link PriceCondition} ⯈ {@link ProductIdentifier}</li>
 * </ul>
 */
public class ProductIdentifier
    implements OnixDataCompositeWithKey<JonixProductIdentifier, ProductIdentifierTypes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "ProductIdentifier";
    public static final String shortname = "productidentifier";

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
    public static final ProductIdentifier EMPTY = new ProductIdentifier();

    public ProductIdentifier() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public ProductIdentifier(org.w3c.dom.Element element) {
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
                case ProductIDType.refname:
                case ProductIDType.shortname:
                    productIDType = new ProductIDType(e);
                    break;
                case IDValue.refname:
                case IDValue.shortname:
                    idValue = new IDValue(e);
                    break;
                case IDTypeName.refname:
                case IDTypeName.shortname:
                    idTypeName = new IDTypeName(e);
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;ProductIdentifier&gt; or &lt;productidentifier&gt;) is explicitly provided in the
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

    private ProductIDType productIDType = ProductIDType.EMPTY;

    /**
     * <p>
     * An ONIX code identifying the scheme from which the identifier in the &lt;IDValue&gt; element is taken. Mandatory
     * in each occurrence of the &lt;ProductIdentifier&gt; composite, and non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public ProductIDType productIDType() {
        _initialize();
        return productIDType;
    }

    private IDValue idValue = IDValue.EMPTY;

    /**
     * <p>
     * An identifier of the type specified in the &lt;ProductIDType&gt; element. Mandatory in each occurrence of the
     * &lt;ProductIdentifier&gt; composite, and non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public IDValue idValue() {
        _initialize();
        return idValue;
    }

    private IDTypeName idTypeName = IDTypeName.EMPTY;

    /**
     * <p>
     * A name which identifies a proprietary identifier scheme (<i>ie</i> a scheme which is not a standard and for which
     * there is no individual ID type code). Must be included when, and only when, the code in the &lt;ProductIDType&gt;
     * element indicates a proprietary scheme, <i>eg</i> a wholesaler’s own code. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public IDTypeName idTypeName() {
        _initialize();
        return idTypeName;
    }

    @Override
    public JonixProductIdentifier asStruct() {
        _initialize();
        JonixProductIdentifier struct = new JonixProductIdentifier();
        struct.productIDType = productIDType.value;
        struct.idTypeName = idTypeName.value;
        struct.idValue = idValue.value;
        return struct;
    }

    @Override
    public ProductIdentifierTypes structKey() {
        return productIDType().value;
    }
}
