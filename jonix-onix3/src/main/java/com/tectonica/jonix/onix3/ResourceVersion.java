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
import com.tectonica.jonix.codelist.ContentDateRoles;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.ResourceVersionFeatureTypes;
import com.tectonica.jonix.struct.JonixContentDate;
import com.tectonica.jonix.struct.JonixResourceVersionFeature;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Resource version composite</h1><p>A repeatable group of data elements which together describe a version of a
 * supporting resource, for example a particular format of a cover image. At least one instance is mandatory in each
 * occurrence of the &lt;SupportingResource&gt; composite.</p><table border='1' cellpadding='3'><tr><td>Reference
 * name</td><td>&lt;ResourceVersion&gt;</td></tr><tr><td>Short tag</td><td>&lt;resourceversion&gt;</td></tr><tr><td>Cardinality</td><td>1&#8230;n</td></tr></table>
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

    public RecordSourceTypes sourcetype;

    public String sourcename;

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
    }

    private void initialize() {
        if (initialized) {
            return;
        }
        initialized = true;

        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        JPU.forElementsOf(element, e -> {
            final String name = e.getNodeName();
            switch (name) {
                case ResourceForm.refname:
                case ResourceForm.shortname:
                    resourceForm = new ResourceForm(e);
                    break;
                case ResourceVersionFeature.refname:
                case ResourceVersionFeature.shortname:
                    resourceVersionFeatures = JPU.addToList(resourceVersionFeatures, new ResourceVersionFeature(e));
                    break;
                case ResourceLink.refname:
                case ResourceLink.shortname:
                    resourceLinks = JPU.addToList(resourceLinks, new ResourceLink(e));
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

    @Override
    public boolean exists() {
        return exists;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private ResourceForm resourceForm = ResourceForm.EMPTY;

    /**
     * (this field is required)
     */
    public ResourceForm resourceForm() {
        initialize();
        return resourceForm;
    }

    private ListOfOnixDataCompositeWithKey<ResourceVersionFeature, JonixResourceVersionFeature, ResourceVersionFeatureTypes>
        resourceVersionFeatures = ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataCompositeWithKey<ResourceVersionFeature, JonixResourceVersionFeature, ResourceVersionFeatureTypes> resourceVersionFeatures() {
        initialize();
        return resourceVersionFeatures;
    }

    private ListOfOnixElement<ResourceLink, String> resourceLinks = ListOfOnixElement.empty();

    /**
     * (this list is required to contain at least one item)
     */
    public ListOfOnixElement<ResourceLink, String> resourceLinks() {
        initialize();
        return resourceLinks;
    }

    private ListOfOnixDataCompositeWithKey<ContentDate, JonixContentDate, ContentDateRoles> contentDates =
        ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataCompositeWithKey<ContentDate, JonixContentDate, ContentDateRoles> contentDates() {
        initialize();
        return contentDates;
    }
}
