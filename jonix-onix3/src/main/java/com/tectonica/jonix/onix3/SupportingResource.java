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
import com.tectonica.jonix.codelist.ContentAudiences;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.ResourceFeatureTypes;
import com.tectonica.jonix.struct.JonixResourceFeature;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Supporting resource composite</h1><p>An optional and repeatable group of data elements which together specify a
 * supporting resource, used here to indicate that there is a new cover or jacket image, or other supporting resource,
 * for a forthcoming reissue. Deprecated in this context.</p><table border='1' cellpadding='3'><tr><td>Reference
 * name</td><td>&lt;SupportingResource&gt;</td></tr><tr><td>Short tag</td><td>&lt;supportingresource&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;n</td></tr></table>
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

    public RecordSourceTypes sourcetype;

    public String sourcename;

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
                case ResourceContentType.refname:
                case ResourceContentType.shortname:
                    resourceContentType = new ResourceContentType(e);
                    break;
                case ContentAudience.refname:
                case ContentAudience.shortname:
                    contentAudiences = JPU.addToList(contentAudiences, new ContentAudience(e));
                    break;
                case ResourceMode.refname:
                case ResourceMode.shortname:
                    resourceMode = new ResourceMode(e);
                    break;
                case ResourceFeature.refname:
                case ResourceFeature.shortname:
                    resourceFeatures = JPU.addToList(resourceFeatures, new ResourceFeature(e));
                    break;
                case ResourceVersion.refname:
                case ResourceVersion.shortname:
                    resourceVersions = JPU.addToList(resourceVersions, new ResourceVersion(e));
                    break;
                case ResourceLink.refname:
                case ResourceLink.shortname:
                    resourceLink = new ResourceLink(e);
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

    private ResourceContentType resourceContentType = ResourceContentType.EMPTY;

    /**
     * (this field is required)
     */
    public ResourceContentType resourceContentType() {
        _initialize();
        return resourceContentType;
    }

    private ListOfOnixElement<ContentAudience, ContentAudiences> contentAudiences = ListOfOnixElement.empty();

    /**
     * (this list is required to contain at least one item)
     */
    public ListOfOnixElement<ContentAudience, ContentAudiences> contentAudiences() {
        _initialize();
        return contentAudiences;
    }

    private ResourceMode resourceMode = ResourceMode.EMPTY;

    /**
     * (this field is required)
     */
    public ResourceMode resourceMode() {
        _initialize();
        return resourceMode;
    }

    private ListOfOnixDataCompositeWithKey<ResourceFeature, JonixResourceFeature, ResourceFeatureTypes>
        resourceFeatures = ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataCompositeWithKey<ResourceFeature, JonixResourceFeature, ResourceFeatureTypes> resourceFeatures() {
        _initialize();
        return resourceFeatures;
    }

    private List<ResourceVersion> resourceVersions = Collections.emptyList();

    /**
     * (this list is required to contain at least one item)
     */
    public List<ResourceVersion> resourceVersions() {
        _initialize();
        return resourceVersions;
    }

    private ResourceLink resourceLink = ResourceLink.EMPTY;

    /**
     * (this field is required)
     */
    public ResourceLink resourceLink() {
        _initialize();
        return resourceLink;
    }
}
