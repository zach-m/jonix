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
import com.tectonica.jonix.codelist.ProductFormDetailsList175;
import com.tectonica.jonix.codelist.ProductIdentifierTypes;
import com.tectonica.jonix.codelist.ProductRelations;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixProductIdentifier;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Related product composite</h1><p>An optional and repeatable group of data elements which together describe a
 * product which has a specified relationship to the product described in the ONIX record.</p><table border='1'
 * cellpadding='3'><tr><td>Reference name</td><td>&lt;RelatedProduct&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;relatedproduct&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;n</td></tr></table>
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

    @Override
    public boolean exists() {
        return exists;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private ListOfOnixElement<ProductRelationCode, ProductRelations> productRelationCodes = ListOfOnixElement.empty();

    /**
     * (this list is required to contain at least one item)
     */
    public ListOfOnixElement<ProductRelationCode, ProductRelations> productRelationCodes() {
        _initialize();
        return productRelationCodes;
    }

    private ListOfOnixDataCompositeWithKey<ProductIdentifier, JonixProductIdentifier, ProductIdentifierTypes>
        productIdentifiers = ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * (this list is required to contain at least one item)
     */
    public ListOfOnixDataCompositeWithKey<ProductIdentifier, JonixProductIdentifier, ProductIdentifierTypes> productIdentifiers() {
        _initialize();
        return productIdentifiers;
    }

    private ProductForm productForm = ProductForm.EMPTY;

    /**
     * (this field is optional)
     */
    public ProductForm productForm() {
        _initialize();
        return productForm;
    }

    private ListOfOnixElement<ProductFormDetail, ProductFormDetailsList175> productFormDetails =
        ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<ProductFormDetail, ProductFormDetailsList175> productFormDetails() {
        _initialize();
        return productFormDetails;
    }
}
