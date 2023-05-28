/*
 * Copyright (C) 2012-2023 Zach Melamed
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
import com.tectonica.jonix.common.ListOfOnixComposite;
import com.tectonica.jonix.common.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.common.ListOfOnixElement;
import com.tectonica.jonix.common.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.common.codelist.MeasureTypes;
import com.tectonica.jonix.common.codelist.ProductFormDetails;
import com.tectonica.jonix.common.codelist.ProductIdentifierTypes;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixMeasure;
import com.tectonica.jonix.common.struct.JonixProductIdentifier;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Supplement manifest composite</h1>
 * <p>
 * An optional group of data elements detailing a simple subset of Group&nbsp;P.1 to specify the Product form, an
 * optional cover, mandatory body and optionally one or more insert manifests for a single Supplement – an additional
 * item supplied with the product at retail that is NOT considered a &lt;ProductPart&gt;, for example a booklet supplied
 * in PDF form that accompanies a downloadable audio product. Each of these cover, body and insert sections within
 * &lt;SupplementManifest&gt; mirrors the structure of the parts of a &lt;ProductionManifest&gt;.
 * </p>
 * <p>
 * These manifests may be preceded by a &lt;SequenceNumber&gt; and one or more &lt;SalesOutlet&gt; composites to enable
 * vendor-specific supplements, and a simple &lt;NoSupplement/&gt; indicator may replace the Product form and cover,
 * body and insert manifests to provide a positive indication that a vendor-specific supplement has no ‘generic’
 * alternative.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;SupplementManifest&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;supplementmanifest&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link ProductionManifest}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link SupplementManifest}</li>
 * </ul>
 *
 * @since Onix-3.08
 */
public class SupplementManifest implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "SupplementManifest";
    public static final String shortname = "supplementmanifest";

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
    public static final SupplementManifest EMPTY = new SupplementManifest();

    public SupplementManifest() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public SupplementManifest(org.w3c.dom.Element element) {
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
                case BodyManifest.refname:
                case BodyManifest.shortname:
                    bodyManifest = new BodyManifest(e);
                    break;
                case SequenceNumber.refname:
                case SequenceNumber.shortname:
                    sequenceNumber = new SequenceNumber(e);
                    break;
                case CoverManifest.refname:
                case CoverManifest.shortname:
                    coverManifest = new CoverManifest(e);
                    break;
                case NoSupplement.refname:
                case NoSupplement.shortname:
                    noSupplement = new NoSupplement(e);
                    break;
                case SalesOutlet.refname:
                case SalesOutlet.shortname:
                    salesOutlets = JPU.addToList(salesOutlets, new SalesOutlet(e));
                    break;
                case ProductIdentifier.refname:
                case ProductIdentifier.shortname:
                    productIdentifiers = JPU.addToList(productIdentifiers, new ProductIdentifier(e));
                    break;
                case ProductFormDetail.refname:
                case ProductFormDetail.shortname:
                    productFormDetails = JPU.addToList(productFormDetails, new ProductFormDetail(e));
                    break;
                case ProductFormDescription.refname:
                case ProductFormDescription.shortname:
                    productFormDescriptions = JPU.addToList(productFormDescriptions, new ProductFormDescription(e));
                    break;
                case Measure.refname:
                case Measure.shortname:
                    measures = JPU.addToList(measures, new Measure(e));
                    break;
                case InsertManifest.refname:
                case InsertManifest.shortname:
                    insertManifests = JPU.addToList(insertManifests, new InsertManifest(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;SupplementManifest&gt; or &lt;supplementmanifest&gt;) is explicitly provided in the
     *         ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<SupplementManifest> action) {
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
     * An ONIX code which indicates the primary form of a supplement. Mandatory in an occurrence of
     * &lt;SupplementManifest&gt;, and non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public ProductForm productForm() {
        _initialize();
        return productForm;
    }

    private BodyManifest bodyManifest = BodyManifest.EMPTY;

    /**
     * <p>
     * A group of data elements which together provide manifest details for the body of a supplement. These details
     * include:
     * </p>
     * <ul>
     * <li>technical specifications of the body of the supplement;</li>
     * <li>details of the file resources required to create the body.</li>
     * </ul>
     * <p>
     * The Body manifest for the supplement has the same structure as the Body manifest for a Product or Product part.
     * However, relevant high-level specifications such as the Product form or overall size of the supplement are
     * carried within the &lt;SupplementManifest&gt; itself, rather than within Block&nbsp;1.
     * </p>
     * Jonix-Comment: this field is required
     */
    public BodyManifest bodyManifest() {
        _initialize();
        return bodyManifest;
    }

    private SequenceNumber sequenceNumber = SequenceNumber.EMPTY;

    /**
     * <p>
     * A number which (in combination with any &lt;SalesOutlet&gt; composite) specifies a single overall sequence of
     * supplements. Optional and non-repeating. It is strongly recommended that each occurrence of the
     * &lt;SupplementManifest&gt; composite should carry a &lt;SequenceNumber&gt;.
     * </p>
     * <p>
     * Note that with &lt;SalesOutlet&gt; below the provision of vendor-specific supplements can require the use of
     * duplicate sequence numbers.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public SequenceNumber sequenceNumber() {
        _initialize();
        return sequenceNumber;
    }

    private CoverManifest coverManifest = CoverManifest.EMPTY;

    /**
     * <p>
     * An optional group of data elements which together provide manifest details for the cover of a supplement. These
     * details include:
     * </p>
     * <ul>
     * <li>technical specifications of the cover of the supplement;</li>
     * <li>details of the file resources required to create the cover.</li>
     * </ul>
     * <p>
     * The Cover manifest for the supplement has the same structure as the Cover manifest for a Product or Product Part.
     * However, relevant high-level specifications such as the Product form or overall size of the supplement are
     * carried within the &lt;SupplementManifest&gt; itself, rather than within Block&nbsp;1.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public CoverManifest coverManifest() {
        _initialize();
        return coverManifest;
    }

    private NoSupplement noSupplement = NoSupplement.EMPTY;

    /**
     * <p>
     * An empty element that provides a positive indication there is no alternative ‘generic’ supplement to be used in
     * cases where there is a vendor-specific supplement (indicated using &lt;SalesOutlet&gt; with the same
     * &lt;SequenceNumber&gt; specified within the Supplement manifest). The empty &lt;NoSupplement/&gt; must be used –
     * and must only be used – when no &lt;BodyManifest&gt; is present within the Supplement manifest.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public NoSupplement noSupplement() {
        _initialize();
        return noSupplement;
    }

    public boolean isNoSupplement() {
        return (noSupplement().exists());
    }

    private ListOfOnixComposite<SalesOutlet> salesOutlets = JPU.emptyListOfOnixComposite(SalesOutlet.class);

    /**
     * <p>
     * A group of data elements which together identify a specific sales outlet. Optional in each occurrence of the
     * &lt;SupplementManifest&gt; composite, and repeatable with multiple outlets.
     * </p>
     * <p>
     * Normally omitted, but for vendor-specific supplements, the &lt;SalesOutlet&gt; composite lists an outlet for
     * which the supplement is relevant. The &lt;SalesOutlet&gt; composite may be repeated where a single supplement is
     * relevant for multiple outlets. Where &lt;SalesOutlet&gt; is omitted, the supplement is appropriate for all – or
     * all other – outlets, depending on the use of the supplement’s Sequence number. See the use of
     * &lt;SequenceNumber&gt; and &lt;SalesOutlet&gt; within the Cover resource composite.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixComposite<SalesOutlet> salesOutlets() {
        _initialize();
        return salesOutlets;
    }

    private ListOfOnixDataCompositeWithKey<ProductIdentifier, JonixProductIdentifier,
        ProductIdentifierTypes> productIdentifiers = JPU.emptyListOfOnixDataCompositeWithKey(ProductIdentifier.class);

    /**
     * <p>
     * A group of data elements which together specify a product identifier, used here to carry an identifier for the
     * supplement which must <em>not</em> match a product identifier within Group&nbsp;P.2 or in an instance of the
     * &lt;ProductPart&gt; composite within Group&nbsp;P.4. The composite is optional, but at least a proprietary
     * idenfifier for the supplement is recommended.
     * </p>
     * Jonix-Comment: this list may be empty
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
     * An ONIX code which provides added detail of the medium and/or format of a supplement. Optional, and repeatable in
     * order to provide multiple additional details.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixCodelist<ProductFormDetail, ProductFormDetails> productFormDetails() {
        _initialize();
        return productFormDetails;
    }

    private ListOfOnixElement<ProductFormDescription, String> productFormDescriptions = ListOfOnixElement.empty();

    /**
     * <p>
     * If product form codes do not adequately describe the supplement, a short text description may be added to give a
     * more detailed specification of the product form. The field is optional, and repeatable to provide parallel
     * descriptions in multiple languages. The <i>language</i> attribute is optional for a single instance of
     * &lt;ProductFormDescription&gt;, but must be included in each instance if &lt;ProductFormDescription&gt; is
     * repeated to provide parallel descriptions in multiple languages.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<ProductFormDescription, String> productFormDescriptions() {
        _initialize();
        return productFormDescriptions;
    }

    private ListOfOnixDataCompositeWithKey<Measure, JonixMeasure, MeasureTypes> measures =
        JPU.emptyListOfOnixDataCompositeWithKey(Measure.class);

    /**
     * <p>
     * An optional group of data elements which together identify a measurement and the units in which it is expressed;
     * used to specify the overall dimensions of a physical supplement. Repeatable to provide multiple combinations of
     * dimension and unit.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<Measure, JonixMeasure, MeasureTypes> measures() {
        _initialize();
        return measures;
    }

    private ListOfOnixComposite<InsertManifest> insertManifests = JPU.emptyListOfOnixComposite(InsertManifest.class);

    /**
     * <p>
     * An optional and repeatable group of data elements which together provide manifest details for any inserts in a
     * supplement. These details include:
     * </p>
     * <ul>
     * <li>technical specifications for an insert within the final supplement;</li>
     * <li>details of the file resources required to create the insert.</li>
     * </ul>
     * <p>
     * The Insert manifest for the supplement has the same structure as the Insert manifest for a Product or Product
     * Part. However, relevant high-level specifications such as the Product form or overall size of the supplement are
     * carried within the &lt;SupplementManifest&gt; itself, rather than within Block 1.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixComposite<InsertManifest> insertManifests() {
        _initialize();
        return insertManifests;
    }
}
