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
import com.tectonica.jonix.common.ListOfOnixCodelist;
import com.tectonica.jonix.common.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.common.ListOfOnixElement;
import com.tectonica.jonix.common.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.common.codelist.MeasureTypes;
import com.tectonica.jonix.common.codelist.ProductContentTypes;
import com.tectonica.jonix.common.codelist.ProductFormDetails;
import com.tectonica.jonix.common.codelist.ProductFormFeatureTypes;
import com.tectonica.jonix.common.codelist.ProductIdentifierTypes;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixMeasure;
import com.tectonica.jonix.common.struct.JonixProductFormFeature;
import com.tectonica.jonix.common.struct.JonixProductIdentifier;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Product part composite</h1>
 * <p>
 * A group of data elements which together describe an item which is part of or contained within a multiple-component or
 * multiple-item product or a trade pack. The composite must be used with all multi-component or multi-item products and
 * packs to specify (for example) the item(s) and item quantities included in a combined book plus audiobook product, a
 * multi-volume set, a filled dumpbin, or a classroom pack. In other cases, where parts are not individually identified,
 * it is used to state the product form(s) and the quantity or quantities of each form contained within the product. The
 * composite must be repeated for each item or component.
 * </p>
 * <p>
 * Each instance of the &lt;ProductPart&gt; composite must carry a &lt;ProductForm&gt; code and a quantity, even if the
 * quantity is ‘1’. If the composite refers to a number of copies of a single item, the quantity must be sent as
 * &lt;NumberOfCopies&gt;, normally accompanied by a &lt;ProductIdentifier&gt;. If the composite refers to a number of
 * <em>different</em> items of the same form, without identifying them individually, the quantity must be sent as
 * &lt;NumberOfItemsOfThisForm&gt;.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;ProductPart&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;productpart&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;ProductPart&gt; from the schema author:
 *
 * Details of a component which comprises part of the product. Note that components may also be product items in their
 * own right &#9679; Added &lt;Measure&gt; at revision 3.0.6 &#9679; Added &lt;ProductPckaging&gt; at revision 3.0.3
 * &#9679; Modified cardinality of &lt;ProductFormDescription&gt; at revision 3.0.1
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link DescriptiveDetail}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link ProductPart}</li>
 * </ul>
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
                case ProductForm.refname:
                case ProductForm.shortname:
                    productForm = new ProductForm(e);
                    break;
                case NumberOfItemsOfThisForm.refname:
                case NumberOfItemsOfThisForm.shortname:
                    numberOfItemsOfThisForm = new NumberOfItemsOfThisForm(e);
                    break;
                case PrimaryPart.refname:
                case PrimaryPart.shortname:
                    primaryPart = new PrimaryPart(e);
                    break;
                case ProductPackaging.refname:
                case ProductPackaging.shortname:
                    productPackaging = new ProductPackaging(e);
                    break;
                case NumberOfCopies.refname:
                case NumberOfCopies.shortname:
                    numberOfCopies = new NumberOfCopies(e);
                    break;
                case CountryOfManufacture.refname:
                case CountryOfManufacture.shortname:
                    countryOfManufacture = new CountryOfManufacture(e);
                    break;
                case ProductIdentifier.refname:
                case ProductIdentifier.shortname:
                    productIdentifiers = JPU.addToList(productIdentifiers, new ProductIdentifier(e));
                    break;
                case ProductFormDetail.refname:
                case ProductFormDetail.shortname:
                    productFormDetails = JPU.addToList(productFormDetails, new ProductFormDetail(e));
                    break;
                case ProductFormFeature.refname:
                case ProductFormFeature.shortname:
                    productFormFeatures = JPU.addToList(productFormFeatures, new ProductFormFeature(e));
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
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;ProductPart&gt; or &lt;productpart&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<ProductPart> action) {
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

    private ProductForm productForm = ProductForm.EMPTY;

    /**
     * <p>
     * An ONIX code which indicates the primary form of a product part. Mandatory in each occurrence of
     * &lt;ProductPart&gt;, and non-repeating.
     * </p>
     * JONIX adds: this field is required
     */
    public ProductForm productForm() {
        _initialize();
        return productForm;
    }

    private NumberOfItemsOfThisForm numberOfItemsOfThisForm = NumberOfItemsOfThisForm.EMPTY;

    /**
     * <p>
     * When product parts are listed as a specified number of <em>different</em> items in a specified form, without
     * identifying the individual items, &lt;NumberOfItemsOfThisForm&gt; must be used to carry the quantity, even if the
     * number is ‘1’. Consequently the element is mandatory and non-repeating in an occurrence of the
     * &lt;ProductPart&gt; composite if &lt;NumberOfCopies&gt; is not present; and it must not be used if
     * &lt;ProductIdentifier&gt; is present.
     * </p>
     * JONIX adds: this field is required
     */
    public NumberOfItemsOfThisForm numberOfItemsOfThisForm() {
        _initialize();
        return numberOfItemsOfThisForm;
    }

    private PrimaryPart primaryPart = PrimaryPart.EMPTY;

    /**
     * <p>
     * An empty element that allows a sender to identify a product part as the ‘primary’ part of a multiple-item
     * product. For example, in a ‘book and toy’ or ‘book and DVD’ product, the book may be regarded as the primary
     * part. Optional and non-repeating.
     * </p>
     * JONIX adds: this field is optional
     */
    public PrimaryPart primaryPart() {
        _initialize();
        return primaryPart;
    }

    public boolean isPrimaryPart() {
        return (primaryPart().exists());
    }

    private ProductPackaging productPackaging = ProductPackaging.EMPTY;

    /**
     * <p>
     * An ONIX code which indicates the type of packaging used for the product part. Optional, and not repeatable.
     * </p>
     * JONIX adds: this field is optional
     */
    public ProductPackaging productPackaging() {
        _initialize();
        return productPackaging;
    }

    private NumberOfCopies numberOfCopies = NumberOfCopies.EMPTY;

    /**
     * <p>
     * When product parts are listed as a specified number of copies of a single item, usually identified by a
     * &lt;ProductIdentifier&gt;, &lt;NumberOfCopies&gt; must be used to specify the quantity, even if the number is
     * ‘1’. It must be used when a multiple-item product or pack contains (a) a quantity of a single item; or (b) one of
     * each of several different items (as in a multi-volume set); or (c) one or more of each of several different items
     * (as in a dumpbin carrying copies of two different books, or a classroom pack containing a teacher’s text and
     * twenty student texts). Consequently the element is mandatory, and non-repeating, in an occurrence of the
     * &lt;ProductPart&gt; composite if &lt;NumberOfItemsOfThisForm&gt; is not present. It is normally accompanied by a
     * &lt;ProductIdentifier&gt;; but in exceptional circumstances, if the sender’s system is unable to provide an
     * identifier at this level, it may be sent with product form coding and without an ID.
     * </p>
     * JONIX adds: this field is optional
     */
    public NumberOfCopies numberOfCopies() {
        _initialize();
        return numberOfCopies;
    }

    private CountryOfManufacture countryOfManufacture = CountryOfManufacture.EMPTY;

    /**
     * <p>
     * A code identifying the country in which a product part was manufactured, if different product parts were
     * manufactured in different countries. This information is needed in some countries to meet regulatory
     * requirements. Optional and non-repeating.
     * </p>
     * JONIX adds: this field is optional
     */
    public CountryOfManufacture countryOfManufacture() {
        _initialize();
        return countryOfManufacture;
    }

    private ListOfOnixDataCompositeWithKey<ProductIdentifier, JonixProductIdentifier,
        ProductIdentifierTypes> productIdentifiers = JPU.emptyListOfOnixDataCompositeWithKey(ProductIdentifier.class);

    /**
     * <p>
     * A group of data elements which together define an identifier of a product in accordance with a specified scheme,
     * used here to carry the product identifier of a product part. Optional, but required when an occurrence of
     * &lt;ProductPart&gt; specifies an individual item with its own identifier, and repeatable with different
     * identifiers for the same product part.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<ProductIdentifier, JonixProductIdentifier, ProductIdentifierTypes>
        productIdentifiers() {
        _initialize();
        return productIdentifiers;
    }

    private ListOfOnixCodelist<ProductFormDetail, ProductFormDetails> productFormDetails =
        ListOfOnixCodelist.emptyList();

    /**
     * <p>
     * An ONIX code which provides added detail of the medium and/or format of a product part. Optional, and repeatable
     * in order to provide multiple additional details.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixCodelist<ProductFormDetail, ProductFormDetails> productFormDetails() {
        _initialize();
        return productFormDetails;
    }

    private ListOfOnixDataCompositeWithKey<ProductFormFeature, JonixProductFormFeature,
        ProductFormFeatureTypes> productFormFeatures =
            JPU.emptyListOfOnixDataCompositeWithKey(ProductFormFeature.class);

    /**
     * <p>
     * An optional group of data elements which together describe an aspect of product form that is too specific to be
     * covered in the &lt;ProductForm&gt; and &lt;ProductFormDetail&gt; elements. Repeatable in order to describe
     * different aspects of the form of the product part. The composite is included here so that it can for example be
     * used to carry consumer protection data related to a product part.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<ProductFormFeature, JonixProductFormFeature, ProductFormFeatureTypes>
        productFormFeatures() {
        _initialize();
        return productFormFeatures;
    }

    private ListOfOnixElement<ProductFormDescription, String> productFormDescriptions = ListOfOnixElement.empty();

    /**
     * <p>
     * If product form codes do not adequately describe the contained item, a short text description may be added.
     * Optional and repeatable. The <i>language</i> attribute is optional for a single instance of
     * &lt;ProductFormDescription&gt;, but must be included in each instance if &lt;ProductFormDescription&gt; is
     * repeated.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixElement<ProductFormDescription, String> productFormDescriptions() {
        _initialize();
        return productFormDescriptions;
    }

    private ListOfOnixCodelist<ProductContentType, ProductContentTypes> productContentTypes =
        ListOfOnixCodelist.emptyList();

    /**
     * <p>
     * An ONIX code which indicates certain types of content which are closely related to but not strictly an attribute
     * of product form, <i>eg</i>&nbsp;audiobook. Optional and repeatable.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixCodelist<ProductContentType, ProductContentTypes> productContentTypes() {
        _initialize();
        return productContentTypes;
    }

    private ListOfOnixDataCompositeWithKey<Measure, JonixMeasure, MeasureTypes> measures =
        JPU.emptyListOfOnixDataCompositeWithKey(Measure.class);

    /**
     * <p>
     * An optional group of data elements which together identify a measurement and the units in which it is expressed;
     * used to specify the overall dimensions of a physical product part including its inner packaging (if any).
     * Repeatable to provide multiple combinations of dimension and unit.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<Measure, JonixMeasure, MeasureTypes> measures() {
        _initialize();
        return measures;
    }
}
