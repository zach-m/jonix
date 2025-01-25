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
import com.tectonica.jonix.common.ListOfOnixComposite;
import com.tectonica.jonix.common.ListOfOnixDataComposite;
import com.tectonica.jonix.common.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.common.ListOfOnixElement;
import com.tectonica.jonix.common.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.SpecificationDetails;
import com.tectonica.jonix.common.codelist.SpecificationFeatureTypes;
import com.tectonica.jonix.common.struct.JonixSpecificationBundleName;
import com.tectonica.jonix.common.struct.JonixSpecificationFeature;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Cover manifest composite</h1>
 * <p>
 * A group of data elements which together provide manifest details for the cover of a Product or Product part. These
 * details include:
 * </p>
 * <ul>
 * <li>technical specifications for the cover;</li>
 * <li>details of the file resources required to create the cover.</li>
 * </ul>
 * <p>
 * Note that the high-level specifications such as the Product form or overall size are carried in
 * <a href="#onixmessage_product_b1">Block 1</a>&nbsp;– the manifest specifications are more detailed in nature, and
 * must be consistent with the high-level specifications.
 * </p>
 * <p>
 * Technical specifications in the manifest can be provided either as a pre-defined and named ‘bundle’ encompassing all
 * the required technical details, and/or as a set of individually-specified details. Bundle names are inevitably
 * proprietary. It is possible to provide two or more bundle names if, for example, a physical book is set up for
 * on-demand manufacturing by multiple POD suppliers, and a supplier who does not pre-define bundles can use the
 * individually-specified details.
 * </p>
 * <p>
 * The composite is optional&nbsp;– it may be omitted where the Product or Product part has no cover&nbsp;– and is not
 * repeatable.
 * </p>
 * <p>
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;CoverManifest&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;covermanifest&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;1</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;CoverManifest&gt; from the schema author:
 *
 * Details of the resource files needed to manufacture or package the cover of a product &#9679; Added at revision 3.0.8
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link SupplementManifest}&gt;</li>
 * <li>&lt;{@link ProductionManifest}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link SupplementManifest} ⯈
 * {@link CoverManifest}</li>
 * <li>{@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link CoverManifest}</li>
 * </ul>
 *
 * @since Onix-3.08
 */
public class CoverManifest implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "CoverManifest";
    public static final String shortname = "covermanifest";

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
    public static final CoverManifest EMPTY = new CoverManifest();

    public CoverManifest() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public CoverManifest(org.w3c.dom.Element element) {
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
                case CoverResource.refname:
                case CoverResource.shortname:
                    coverResources = JPU.addToList(coverResources, new CoverResource(e));
                    break;
                case SpecificationBundleName.refname:
                case SpecificationBundleName.shortname:
                    specificationBundleNames = JPU.addToList(specificationBundleNames, new SpecificationBundleName(e));
                    break;
                case SpecificationDetail.refname:
                case SpecificationDetail.shortname:
                    specificationDetails = JPU.addToList(specificationDetails, new SpecificationDetail(e));
                    break;
                case SpecificationFeature.refname:
                case SpecificationFeature.shortname:
                    specificationFeatures = JPU.addToList(specificationFeatures, new SpecificationFeature(e));
                    break;
                case SpecificationDescription.refname:
                case SpecificationDescription.shortname:
                    specificationDescriptions =
                        JPU.addToList(specificationDescriptions, new SpecificationDescription(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;CoverManifest&gt; or &lt;covermanifest&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<CoverManifest> action) {
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

    private ListOfOnixComposite<CoverResource> coverResources = JPU.emptyListOfOnixComposite(CoverResource.class);

    /**
     * <p>
     * A group of data elements that together provide details of a single file or resource of which the cover is
     * composed. At least one resource is required in each &lt;CoverManifest&gt;, and the &lt;CoverResource&gt;
     * composite is repeatable to describe multiple resources.
     * </p>
     * <p>
     * The composite must contain <em>either</em> a Resource file link <em>or</em> a No resource indicator.
     * </p>
     * JONIX adds: this list is required to contain at least one item
     */
    public ListOfOnixComposite<CoverResource> coverResources() {
        _initialize();
        return coverResources;
    }

    private ListOfOnixDataComposite<SpecificationBundleName, JonixSpecificationBundleName> specificationBundleNames =
        JPU.emptyListOfOnixDataComposite(SpecificationBundleName.class);

    /**
     * <p>
     * A group of data elements that together identify a named ‘bundle’ of detailed technical specifications necessary
     * for creation of the body of the final Product or Product part. Bundle names are inevitably proprietary, so both a
     * Name type name and the Name value must be included.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixDataComposite<SpecificationBundleName, JonixSpecificationBundleName> specificationBundleNames() {
        _initialize();
        return specificationBundleNames;
    }

    private ListOfOnixCodelist<SpecificationDetail, SpecificationDetails> specificationDetails =
        ListOfOnixCodelist.emptyList();

    /**
     * <p>
     * An ONIX code which specifies added detail of the medium and/or format of the body of the Product or Product part.
     * Optional, and repeatable in order to provide multiple additional details.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixCodelist<SpecificationDetail, SpecificationDetails> specificationDetails() {
        _initialize();
        return specificationDetails;
    }

    private ListOfOnixDataCompositeWithKey<SpecificationFeature, JonixSpecificationFeature,
        SpecificationFeatureTypes> specificationFeatures =
            JPU.emptyListOfOnixDataCompositeWithKey(SpecificationFeature.class);

    /**
     * <p>
     * An optional group of data elements which together specify an aspect of the body of the Product or Product part
     * that is too specific to be covered in the &lt;SpecificationDetail&gt; element. Repeatable in order to describe
     * different aspects of the product form.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<SpecificationFeature, JonixSpecificationFeature, SpecificationFeatureTypes>
        specificationFeatures() {
        _initialize();
        return specificationFeatures;
    }

    private ListOfOnixElement<SpecificationDescription, String> specificationDescriptions = ListOfOnixElement.empty();

    /**
     * <p>
     * If Specification details and features do not adequately specify the body of the product, a short text description
     * may be added to give a more detailed specification. The field is optional, and repeatable to provide parallel
     * specifications in multiple languages. The <i>language</i> attribute is optional for a single instance of
     * &lt;SpecificationDescription&gt;, but must be included in each instance if &lt;SpecificationDescription&gt; is
     * repeated to provide parallel descriptions in multiple languages.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixElement<SpecificationDescription, String> specificationDescriptions() {
        _initialize();
        return specificationDescriptions;
    }
}
