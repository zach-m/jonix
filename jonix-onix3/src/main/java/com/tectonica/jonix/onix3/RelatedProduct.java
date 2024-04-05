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
import com.tectonica.jonix.common.ListOfOnixCodelist;
import com.tectonica.jonix.common.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.common.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.common.codelist.ProductFormDetails;
import com.tectonica.jonix.common.codelist.ProductIdentifierTypes;
import com.tectonica.jonix.common.codelist.ProductRelations;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixProductIdentifier;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Related product composite (content item)</h1>
 * <p>
 * A group of data elements which together describe a product which has a specified relationship to a content item.
 * Optional and repeatable.
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
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;RelatedProduct&gt; from the schema author:
 * 
 * <pre>
 * Details of another product related in some way to the product
 * &#9679; Added &lt;ProductForm&gt;, &lt;ProductFormDetail&gt; at revision 3.0 (2010)
 * &#9679; Modified cardinality of &lt;ProductRelationCode&gt; at revision 3.0 (2010)
 * </pre>
 * 
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link RelatedMaterial}&gt;</li>
 * <li>&lt;{@link ContentItem}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link RelatedMaterial} ⯈ {@link RelatedProduct}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link RelatedProduct}</li>
 * </ul>
 *
 * @since Onix-3.03
 */
public class RelatedProduct implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "RelatedProduct";
    public static final String shortname = "relatedproduct";

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
                case ProductRelationCode.refname:
                case ProductRelationCode.shortname:
                    productRelationCodes = JPU.addToList(productRelationCodes, new ProductRelationCode(e));
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
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;RelatedProduct&gt; or &lt;relatedproduct&gt;) is explicitly provided in the ONIX
     *         XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<RelatedProduct> action) {
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

    private ListOfOnixCodelist<ProductRelationCode, ProductRelations> productRelationCodes =
        ListOfOnixCodelist.emptyList();

    /**
     * <p>
     * An ONIX code which identifies the nature of the relationship between two products, <i>eg</i> ‘replaced-by’.
     * Mandatory in each occurrence of the &lt;RelatedProduct&gt; composite, and repeatable where the related product
     * has multiple types of relationship to the product described.
     * </p>
     * JONIX adds: this list is required to contain at least one item
     */
    public ListOfOnixCodelist<ProductRelationCode, ProductRelations> productRelationCodes() {
        _initialize();
        return productRelationCodes;
    }

    private ListOfOnixDataCompositeWithKey<ProductIdentifier, JonixProductIdentifier,
        ProductIdentifierTypes> productIdentifiers = JPU.emptyListOfOnixDataCompositeWithKey(ProductIdentifier.class);

    /**
     * <p>
     * A group of data elements which together define an identifier of a product in accordance with a specified scheme.
     * Mandatory in each occurrence of the &lt;RelatedProduct&gt; composite. Repeatable only if two or more identifiers
     * for the same product are sent using different identifier schemes.
     * </p>
     * JONIX adds: this list is required to contain at least one item
     */
    public ListOfOnixDataCompositeWithKey<ProductIdentifier, JonixProductIdentifier, ProductIdentifierTypes>
        productIdentifiers() {
        _initialize();
        return productIdentifiers;
    }

    private ProductForm productForm = ProductForm.EMPTY;

    /**
     * <p>
     * An ONIX code which indicates the primary form of a related product. Optional in an occurrence of
     * &lt;RelatedProduct&gt;, and non-repeating. If supplied, should be identical to the &lt;ProductForm&gt; element
     * supplied in the &lt;DescriptiveDetail&gt; block of the full ONIX record describing the related product itself.
     * </p>
     * <p>
     * Since this and the following element provide data about a related product, ONIX suppliers are cautioned of the
     * risk of contradictory data in separate data feeds. <em>This and the following element should not be supplied
     * unless specifically requested by a particular recipient.</em>
     * </p>
     * JONIX adds: this field is optional
     */
    public ProductForm productForm() {
        _initialize();
        return productForm;
    }

    private ListOfOnixCodelist<ProductFormDetail, ProductFormDetails> productFormDetails =
        ListOfOnixCodelist.emptyList();

    /**
     * <p>
     * An ONIX code which provides added detail of the medium and/or format of a related product. Optional and
     * repeatable.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixCodelist<ProductFormDetail, ProductFormDetails> productFormDetails() {
        _initialize();
        return productFormDetails;
    }
}
