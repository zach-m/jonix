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

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.Consumer;

import com.tectonica.jonix.common.*;
import com.tectonica.jonix.common.OnixComposite.*;
import com.tectonica.jonix.common.codelist.*;
import com.tectonica.jonix.common.struct.*;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Supporting resource composite</h1>
 * <p>
 * An optional group of data elements which together describe a supporting resource. The composite is repeatable to
 * describe and link to multiple resources. Note that different forms of the <em>same</em> resource (for example a cover
 * image in separate low and high resolution versions) should be specified in a single instance of the composite.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;SupportingResource&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;supportingresource&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;SupportingResource&gt; from the schema author:
 *
 * Details of a supporting resource used for marketing and promotional purposes, eg a cover image, author photo, sample
 * of the content &#9679; Added &lt;Territory&gt; at revision 3.0.3
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link ContentItem}&gt;</li>
 * <li>&lt;{@link CollateralDetail}&gt;</li>
 * <li>&lt;{@link Reissue}&gt;</li>
 * <li>&lt;{@link EventOccurrence}&gt;</li>
 * <li>&lt;{@link PromotionalEvent}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link SupportingResource}</li>
 * <li>{@link Product} ⯈ {@link CollateralDetail} ⯈ {@link SupportingResource}</li>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Reissue} ⯈
 * {@link SupportingResource}</li>
 * <li>{@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈ {@link EventOccurrence} ⯈
 * {@link SupportingResource}</li>
 * <li>{@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈ {@link SupportingResource}</li>
 * </ul>
 */
public class SupportingResource implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "SupportingResource";
    public static final String shortname = "supportingresource";

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
    public static final SupportingResource EMPTY = new SupportingResource();

    public SupportingResource() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public SupportingResource(org.w3c.dom.Element element) {
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
                case ResourceContentType.refname:
                case ResourceContentType.shortname:
                    resourceContentType = new ResourceContentType(e);
                    break;
                case ResourceMode.refname:
                case ResourceMode.shortname:
                    resourceMode = new ResourceMode(e);
                    break;
                case ContentAudience.refname:
                case ContentAudience.shortname:
                    contentAudiences = JPU.addToList(contentAudiences, new ContentAudience(e));
                    break;
                case ResourceVersion.refname:
                case ResourceVersion.shortname:
                    resourceVersions = JPU.addToList(resourceVersions, new ResourceVersion(e));
                    break;
                case Territory.refname:
                case Territory.shortname:
                    territory = new Territory(e);
                    break;
                case ResourceFeature.refname:
                case ResourceFeature.shortname:
                    resourceFeatures = JPU.addToList(resourceFeatures, new ResourceFeature(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;SupportingResource&gt; or &lt;supportingresource&gt;) is explicitly provided in the
     *         ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<SupportingResource> action) {
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

    private ResourceContentType resourceContentType = ResourceContentType.EMPTY;

    /**
     * <p>
     * An ONIX code indicating the type of content carried in a supporting resource. Mandatory in each occurrence of the
     * &lt;SupportingResource&gt; composite, and non-repeating.
     * </p>
     * JONIX adds: this field is required
     */
    public ResourceContentType resourceContentType() {
        _initialize();
        return resourceContentType;
    }

    private ResourceMode resourceMode = ResourceMode.EMPTY;

    /**
     * <p>
     * An ONIX code indicating the mode of the supporting resource, <i>eg</i> audio, video. Mandatory in each occurrence
     * of the &lt;SupportingResource&gt; composite, and non-repeating.
     * </p>
     * JONIX adds: this field is required
     */
    public ResourceMode resourceMode() {
        _initialize();
        return resourceMode;
    }

    private ListOfOnixCodelist<ContentAudience, ContentAudiences> contentAudiences = ListOfOnixCodelist.emptyList();

    /**
     * <p>
     * An ONIX code which identifies the audience for which the supporting resource is intended. Mandatory in each
     * occurrence of the &lt;SupportingResource&gt; composite, and repeatable.
     * </p>
     * JONIX adds: this list is required to contain at least one item
     */
    public ListOfOnixCodelist<ContentAudience, ContentAudiences> contentAudiences() {
        _initialize();
        return contentAudiences;
    }

    private ListOfOnixComposite<ResourceVersion> resourceVersions = JPU.emptyListOfOnixComposite(ResourceVersion.class);

    /**
     * <p>
     * A group of data elements which together describe a single version of a supporting resource, for example a
     * particular format of a cover image. At least one instance is mandatory in each occurrence of the
     * &lt;SupportingResource&gt; composite, and the composite should be repeated as necessary if the resource is
     * offered in multiple versions.
     * </p>
     * JONIX adds: this list is required to contain at least one item
     */
    public ListOfOnixComposite<ResourceVersion> resourceVersions() {
        _initialize();
        return resourceVersions;
    }

    private Territory territory = Territory.EMPTY;

    /**
     * <p>
     * A group of data elements which together define a territory for which the supporting resource is specifically
     * intended. Optional in each occurrence of the &lt;SupportingResource&gt; composite, and non-repeating. If omitted,
     * the supporting resource is intended for use wherever the product may be sold (see
     * <a href="#onixmessage_product_publishingdetail_p21">Group&nbsp;P.21</a>). If included, the resource should be
     * used by recipients in the specified territory in preference to any supporting resource that lacks a specified
     * territory.
     * </p>
     * <p>
     * Care should be taken to avoid ambiguities (for example two different cover images marked for use in the same
     * country or region), and to ensure that appropriate resources are supplied for all countries and regions where the
     * product may be sold. The simplest way to accomplish the latter is to ensure at least one version of the resource
     * does not have a territory specified. Where multiple resources of the same type are provided, those without
     * specific &lt;Territory&gt; composites are intended for use only where no appropriate targeted resource is
     * present.
     * </p>
     * JONIX adds: this field is optional
     */
    public Territory territory() {
        _initialize();
        return territory;
    }

    private ListOfOnixDataCompositeWithKey<ResourceFeature, JonixResourceFeature,
        ResourceFeatureTypes> resourceFeatures = JPU.emptyListOfOnixDataCompositeWithKey(ResourceFeature.class);

    /**
     * <p>
     * A group of data elements which together describe a feature of a supporting resource which is common to all
     * versions in which the resource is offered. Optional, and repeatable in order to describe multiple features of the
     * resource.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<ResourceFeature, JonixResourceFeature, ResourceFeatureTypes>
        resourceFeatures() {
        _initialize();
        return resourceFeatures;
    }
}
