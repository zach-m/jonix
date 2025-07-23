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
import com.tectonica.jonix.common.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.common.ListOfOnixElement;
import com.tectonica.jonix.common.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.common.codelist.ContentDateRoles;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.ResourceVersionFeatureTypes;
import com.tectonica.jonix.common.struct.JonixContentDate;
import com.tectonica.jonix.common.struct.JonixResourceVersionFeature;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Resource version composite</h1>
 * <p>
 * A group of data elements which together describe a single version of a supporting resource, for example a particular
 * format of a cover image. At least one instance is mandatory in each occurrence of the &lt;SupportingResource&gt;
 * composite, and the composite should be repeated as necessary if the resource is offered in multiple versions.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;ResourceVersion&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;resourceversion&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>1&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;ResourceVersion&gt; from the schema author:
 *
 * Details of a specific version of a supporting resource used for marketing and promotional purposes, eg when the
 * resource is an audio extract, the mp3 version of that extract, and when the resource is an image, the 200-pixel JPEG
 * version of that image
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link SupportingResource}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link SupportingResource} ⯈
 * {@link ResourceVersion}</li>
 * <li>{@link Product} ⯈ {@link CollateralDetail} ⯈ {@link SupportingResource} ⯈ {@link ResourceVersion}</li>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Reissue} ⯈ {@link SupportingResource} ⯈
 * {@link ResourceVersion}</li>
 * <li>{@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈ {@link EventOccurrence} ⯈
 * {@link SupportingResource} ⯈ {@link ResourceVersion}</li>
 * <li>{@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈ {@link SupportingResource} ⯈
 * {@link ResourceVersion}</li>
 * </ul>
 */
public class ResourceVersion implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "ResourceVersion";
    public static final String shortname = "resourceversion";

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
    public static final ResourceVersion EMPTY = new ResourceVersion();

    public ResourceVersion() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public ResourceVersion(org.w3c.dom.Element element) {
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
                case ResourceForm.refname:
                case ResourceForm.shortname:
                    resourceForm = new ResourceForm(e);
                    break;
                case ResourceLink.refname:
                case ResourceLink.shortname:
                    resourceLinks = JPU.addToList(resourceLinks, new ResourceLink(e));
                    break;
                case ResourceVersionFeature.refname:
                case ResourceVersionFeature.shortname:
                    resourceVersionFeatures = JPU.addToList(resourceVersionFeatures, new ResourceVersionFeature(e));
                    break;
                case ContentDate.refname:
                case ContentDate.shortname:
                    contentDates = JPU.addToList(contentDates, new ContentDate(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;ResourceVersion&gt; or &lt;resourceversion&gt;) is explicitly provided in the ONIX
     *         XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<ResourceVersion> action) {
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

    private ResourceForm resourceForm = ResourceForm.EMPTY;

    /**
     * <p>
     * An ONIX code indicating the form of a version of a supporting resource. Mandatory in each occurrence of the
     * &lt;ResourceVersion&gt; composite, and non-repeating.
     * </p>
     * JONIX adds: this field is required
     */
    public ResourceForm resourceForm() {
        _initialize();
        return resourceForm;
    }

    private ListOfOnixElement<ResourceLink, String> resourceLinks = ListOfOnixElement.empty();

    /**
     * <p>
     * A URL which provides a link to a supporting resource. Mandatory in each occurrence of the &lt;ResourceVersion&gt;
     * composite, and repeatable if the resource can be linked in more than one way, <i>eg</i>&nbsp;by URL or DOI, or
     * where a supporting resource is available in multiple parallel languages. Where multiple languages are used, all
     * repeats must carry the <i>language</i> attribute.
     * </p>
     * JONIX adds: this list is required to contain at least one item
     */
    public ListOfOnixElement<ResourceLink, String> resourceLinks() {
        _initialize();
        return resourceLinks;
    }

    private ListOfOnixDataCompositeWithKey<ResourceVersionFeature, JonixResourceVersionFeature,
        ResourceVersionFeatureTypes> resourceVersionFeatures =
            JPU.emptyListOfOnixDataCompositeWithKey(ResourceVersionFeature.class);

    /**
     * <p>
     * A group of data elements which together describe a feature of a supporting resource which is specific to a
     * particular version in which the resource is offered. Formally optional, but it is unlikely that a supporting
     * resource version could be adequately described without specifying some of its features. Repeatable in order to
     * specify multiple features of the version of the resource.
     * </p>
     * JONIX adds: this list may be empty
     */
    public
        ListOfOnixDataCompositeWithKey<ResourceVersionFeature, JonixResourceVersionFeature, ResourceVersionFeatureTypes>
        resourceVersionFeatures() {
        _initialize();
        return resourceVersionFeatures;
    }

    private ListOfOnixDataCompositeWithKey<ContentDate, JonixContentDate, ContentDateRoles> contentDates =
        JPU.emptyListOfOnixDataCompositeWithKey(ContentDate.class);

    /**
     * <p>
     * An optional group of data elements which together specify a date associated with a supporting resource version,
     * <i>eg</i>&nbsp;the date until which the resource version will be available for download. Repeatable to specify
     * different dates with their various roles.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<ContentDate, JonixContentDate, ContentDateRoles> contentDates() {
        _initialize();
        return contentDates;
    }
}
