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
import com.tectonica.jonix.common.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.common.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.common.codelist.ProductIdentifierTypes;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixProductIdentifier;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Production manifest composite</h1>
 * <p>
 * A group of data elements which together carry manifest details for a single Product or Product part.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;ProductionManifest&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;productionmanifest&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link ProductionDetail}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest}</li>
 * </ul>
 *
 * @since Onix-3.08
 */
public class ProductionManifest implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "ProductionManifest";
    public static final String shortname = "productionmanifest";

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
    public static final ProductionManifest EMPTY = new ProductionManifest();

    public ProductionManifest() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public ProductionManifest(org.w3c.dom.Element element) {
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
                case BodyManifest.refname:
                case BodyManifest.shortname:
                    bodyManifest = new BodyManifest(e);
                    break;
                case CoverManifest.refname:
                case CoverManifest.shortname:
                    coverManifest = new CoverManifest(e);
                    break;
                case ProductIdentifier.refname:
                case ProductIdentifier.shortname:
                    productIdentifiers = JPU.addToList(productIdentifiers, new ProductIdentifier(e));
                    break;
                case InsertManifest.refname:
                case InsertManifest.shortname:
                    insertManifests = JPU.addToList(insertManifests, new InsertManifest(e));
                    break;
                case SupplementManifest.refname:
                case SupplementManifest.shortname:
                    supplementManifests = JPU.addToList(supplementManifests, new SupplementManifest(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;ProductionManifest&gt; or &lt;productionmanifest&gt;) is explicitly provided in the
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

    private BodyManifest bodyManifest = BodyManifest.EMPTY;

    /**
     * <p>
     * A group of data elements which together provide manifest details for the body of a Product or Product part. These
     * details include:
     * </p>
     * <ul>
     * <li>technical specifications for the body;</li>
     * <li>details of the file resources required to create the body.</li>
     * </ul>
     * <p>
     * Note that the high-level specifications such as the Product form and size are carried in
     * <a href="#onix_product_descriptivedetail">Block 1</a> – the manifest specifications are more detailed in nature,
     * and must be consistent with the high-level specifications.
     * </p>
     * <p>
     * Technical specifications in the manifest can be provided either as a pre-defined and named ‘bundle’ encompassing
     * all the required technical details, and/or as a set of individually-specified details. Bundle names are
     * inevitably proprietary. It is possible to provide two or more bundle names if, for example, a physical book is
     * set up for on-demand manufacturing by multiple POD suppliers, and a supplier who does not pre-define bundles can
     * use the individually-specified details.
     * </p>
     * <p>
     * The composite is mandatory and is not repeatable.
     * </p>
     * Jonix-Comment: this field is required
     */
    public BodyManifest bodyManifest() {
        _initialize();
        return bodyManifest;
    }

    private CoverManifest coverManifest = CoverManifest.EMPTY;

    /**
     * <p>
     * A group of data elements which together provide manifest details for the cover of a Product or Product part.
     * These details include:
     * </p>
     * <ul>
     * <li>technical specifications for the cover;</li>
     * <li>details of the file resources required to create the cover.</li>
     * </ul>
     * <p>
     * Note that the high-level specifications such as the Product form or overall size are carried in
     * <a href="#onix_product_descriptivedetail">Block 1</a> – the manifest specifications are more detailed in nature,
     * and must be consistent with the high-level specifications.
     * </p>
     * <p>
     * Technical specifications in the manifest can be provided either as a pre-defined and named ‘bundle’ encompassing
     * all the required technical details, and/or as a set of individually-specified details. Bundle names are
     * inevitably proprietary. It is possible to provide two or more bundle names if, for example, a physical book is
     * set up for on-demand manufacturing by multiple POD suppliers, and a supplier who does not pre-define bundles can
     * use the individually-specified details.
     * </p>
     * <p>
     * The composite is optional – it may be omitted where the Product or Product part has no cover – and is not
     * repeatable.
     * </p>
     * <p>
     * </p>
     * Jonix-Comment: this field is optional
     */
    public CoverManifest coverManifest() {
        _initialize();
        return coverManifest;
    }

    private ListOfOnixDataCompositeWithKey<ProductIdentifier, JonixProductIdentifier,
        ProductIdentifierTypes> productIdentifiers = ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * <p>
     * A group of data elements which together specify a product identifier, used here to carry an identifier which must
     * match a product identifier in an instance of the &lt;ProductPart&gt; composite within Group&nbsp;P.4. The
     * composite is mandatory and repeatable when &lt;ProductPart&gt; is present within the Product record, but must be
     * omitted if there are no product parts. Where multiple product identifiers are provided in any one occurrence of
     * the &lt;ProductionManifest&gt; composite, they must all identify the same product part.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<ProductIdentifier, JonixProductIdentifier, ProductIdentifierTypes>
        productIdentifiers() {
        _initialize();
        return productIdentifiers;
    }

    private List<InsertManifest> insertManifests = Collections.emptyList();

    /**
     * <p>
     * A group of data elements which together provide manifest details for a single insert within the Product or
     * Product part. These details include:
     * </p>
     * <ul>
     * <li>technical specifications for the insert within the final product;</li>
     * <li>details of the file resources required to create the insert;</li>
     * </ul>
     * <p>
     * Note that the high-level specifications such as the Product form, trimmed page size or file type for final
     * delivery are carried in <a href="#onix_product_descriptivedetail">Block&nbsp;1</a> – the manifest specifications
     * are more detailed in nature, and must be consistent with the high-level specifications.
     * </p>
     * <p>
     * Technical specifications in the manifest can be provided either as a pre-defined and named ‘bundle’ encompassing
     * all the required technical details, and/or as a set of individually-specified details. Bundle names are
     * inevitably proprietary. It is possible to provide two or more bundle names if, for example, a physical book is
     * set up for on-demand manufacturing by multiple POD suppliers, and a supplier who does not pre-define bundles can
     * use the individually-specified details.
     * </p>
     * <p>
     * The composite is optional – it may be omitted where the Product or Product part has no inserts – and is
     * repeatable to provide manifest details for multiple inserts.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public List<InsertManifest> insertManifests() {
        _initialize();
        return insertManifests;
    }

    private List<SupplementManifest> supplementManifests = Collections.emptyList();

    /**
     * <p>
     * An optional group of data elements detailing a simple subset of Group&nbsp;P.1 to specify the Product form, an
     * optional cover, mandatory body and optionally one or more insert manifests for a single Supplement – an
     * additional item supplied with the product at retail that is NOT considered a &lt;ProductPart&gt;, for example a
     * booklet supplied in PDF form that accompanies a downloadable audio product. Each of these cover, body and insert
     * sections within &lt;SupplementManifest&gt; mirrors the structure of the parts of a &lt;ProductionManifest&gt;.
     * </p>
     * <p>
     * These manifests may be preceded by a &lt;SequenceNumber&gt; and one or more &lt;SalesOutlet&gt; composites to
     * enable vendor-specific supplements, and a simple &lt;NoSupplement/&gt; indicator may replace the Product form and
     * cover, body and insert manifests to provide a positive indication that a vendor-specific supplement has no
     * ‘generic’ alternative.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public List<SupplementManifest> supplementManifests() {
        _initialize();
        return supplementManifests;
    }
}
