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
import com.tectonica.jonix.common.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.common.ListOfOnixElement;
import com.tectonica.jonix.common.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.ResourceFileDateRoles;
import com.tectonica.jonix.common.codelist.ResourceFileDetails;
import com.tectonica.jonix.common.codelist.ResourceFileFeatureTypes;
import com.tectonica.jonix.common.codelist.ResourceIdentifierTypes;
import com.tectonica.jonix.common.struct.JonixResourceFileDate;
import com.tectonica.jonix.common.struct.JonixResourceFileFeature;
import com.tectonica.jonix.common.struct.JonixResourceIdentifier;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Insert resource composite</h1>
 * <p>
 * A group of data elements that together provide details of a single file or resource of which the insert is composed.
 * At least one &lt;InsertResource&gt; composite is required in each &lt;InsertManifest&gt;, and the
 * &lt;InsertResource&gt; composite is repeatable to describe multiple resources.
 * </p>
 * <p>
 * The composite must contain <em>either</em> a Resource file link <em>or</em> a No resource indicator.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;InsertResource&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;insertresource&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>1&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;InsertResource&gt; from the schema author:
 *
 * Details of a resource file needed to manufacture or package an insert &#9679; Added at revision 3.0.8
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link InsertManifest}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link SupplementManifest} ⯈
 * {@link InsertManifest} ⯈ {@link InsertResource}</li>
 * <li>{@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link InsertManifest} ⯈
 * {@link InsertResource}</li>
 * </ul>
 *
 * @since Onix-3.08
 */
public class InsertResource implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "InsertResource";
    public static final String shortname = "insertresource";

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
    public static final InsertResource EMPTY = new InsertResource();

    public InsertResource() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public InsertResource(org.w3c.dom.Element element) {
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
                case ResourceFileLink.refname:
                case ResourceFileLink.shortname:
                    resourceFileLinks = JPU.addToList(resourceFileLinks, new ResourceFileLink(e));
                    break;
                case SequenceNumber.refname:
                case SequenceNumber.shortname:
                    sequenceNumber = new SequenceNumber(e);
                    break;
                case ResourceRole.refname:
                case ResourceRole.shortname:
                    resourceRole = new ResourceRole(e);
                    break;
                case NoResource.refname:
                case NoResource.shortname:
                    noResource = new NoResource(e);
                    break;
                case SalesOutlet.refname:
                case SalesOutlet.shortname:
                    salesOutlets = JPU.addToList(salesOutlets, new SalesOutlet(e));
                    break;
                case ResourceIdentifier.refname:
                case ResourceIdentifier.shortname:
                    resourceIdentifiers = JPU.addToList(resourceIdentifiers, new ResourceIdentifier(e));
                    break;
                case ResourceFileDetail.refname:
                case ResourceFileDetail.shortname:
                    resourceFileDetails = JPU.addToList(resourceFileDetails, new ResourceFileDetail(e));
                    break;
                case ResourceFileFeature.refname:
                case ResourceFileFeature.shortname:
                    resourceFileFeatures = JPU.addToList(resourceFileFeatures, new ResourceFileFeature(e));
                    break;
                case ResourceFileDescription.refname:
                case ResourceFileDescription.shortname:
                    resourceFileDescriptions = JPU.addToList(resourceFileDescriptions, new ResourceFileDescription(e));
                    break;
                case ResourceFileContentDescription.refname:
                case ResourceFileContentDescription.shortname:
                    resourceFileContentDescriptions =
                        JPU.addToList(resourceFileContentDescriptions, new ResourceFileContentDescription(e));
                    break;
                case ResourceFileDate.refname:
                case ResourceFileDate.shortname:
                    resourceFileDates = JPU.addToList(resourceFileDates, new ResourceFileDate(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;InsertResource&gt; or &lt;insertresource&gt;) is explicitly provided in the ONIX
     *         XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<InsertResource> action) {
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

    private ListOfOnixElement<ResourceFileLink, String> resourceFileLinks = ListOfOnixElement.empty();

    /**
     * JONIX adds: this list is required to contain at least one item
     */
    public ListOfOnixElement<ResourceFileLink, String> resourceFileLinks() {
        _initialize();
        return resourceFileLinks;
    }

    private SequenceNumber sequenceNumber = SequenceNumber.EMPTY;

    /**
     * JONIX adds: this field is optional
     */
    public SequenceNumber sequenceNumber() {
        _initialize();
        return sequenceNumber;
    }

    private ResourceRole resourceRole = ResourceRole.EMPTY;

    /**
     * JONIX adds: this field is optional
     */
    public ResourceRole resourceRole() {
        _initialize();
        return resourceRole;
    }

    private NoResource noResource = NoResource.EMPTY;

    /**
     * <p>
     * An empty element that provides a positive indication that there is no alternative ‘generic’ resource to be used
     * in cases where there is a vendor-specific resource (indicated using &lt;SalesOutlet&gt;) with the same
     * &lt;SequenceNumber&gt; specified within the manifest. The empty &lt;NoResource/&gt; must be used&nbsp;– and must
     * only be used&nbsp;– when no &lt;ResourceFileLink&gt; is present.
     * </p>
     * JONIX adds: this field is optional
     */
    public NoResource noResource() {
        _initialize();
        return noResource;
    }

    public boolean isNoResource() {
        return (noResource().exists());
    }

    private ListOfOnixComposite<SalesOutlet> salesOutlets = JPU.emptyListOfOnixComposite(SalesOutlet.class);

    /**
     * JONIX adds: this list may be empty
     */
    public ListOfOnixComposite<SalesOutlet> salesOutlets() {
        _initialize();
        return salesOutlets;
    }

    private ListOfOnixDataCompositeWithKey<ResourceIdentifier, JonixResourceIdentifier,
        ResourceIdentifierTypes> resourceIdentifiers =
            JPU.emptyListOfOnixDataCompositeWithKey(ResourceIdentifier.class);

    /**
     * JONIX adds: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<ResourceIdentifier, JonixResourceIdentifier, ResourceIdentifierTypes>
        resourceIdentifiers() {
        _initialize();
        return resourceIdentifiers;
    }

    private ListOfOnixCodelist<ResourceFileDetail, ResourceFileDetails> resourceFileDetails =
        ListOfOnixCodelist.emptyList();

    /**
     * JONIX adds: this list may be empty
     */
    public ListOfOnixCodelist<ResourceFileDetail, ResourceFileDetails> resourceFileDetails() {
        _initialize();
        return resourceFileDetails;
    }

    private ListOfOnixDataCompositeWithKey<ResourceFileFeature, JonixResourceFileFeature,
        ResourceFileFeatureTypes> resourceFileFeatures =
            JPU.emptyListOfOnixDataCompositeWithKey(ResourceFileFeature.class);

    /**
     * JONIX adds: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<ResourceFileFeature, JonixResourceFileFeature, ResourceFileFeatureTypes>
        resourceFileFeatures() {
        _initialize();
        return resourceFileFeatures;
    }

    private ListOfOnixElement<ResourceFileDescription, String> resourceFileDescriptions = ListOfOnixElement.empty();

    /**
     * JONIX adds: this list may be empty
     */
    public ListOfOnixElement<ResourceFileDescription, String> resourceFileDescriptions() {
        _initialize();
        return resourceFileDescriptions;
    }

    private ListOfOnixElement<ResourceFileContentDescription, String> resourceFileContentDescriptions =
        ListOfOnixElement.empty();

    /**
     * JONIX adds: this list may be empty
     */
    public ListOfOnixElement<ResourceFileContentDescription, String> resourceFileContentDescriptions() {
        _initialize();
        return resourceFileContentDescriptions;
    }

    private ListOfOnixDataCompositeWithKey<ResourceFileDate, JonixResourceFileDate,
        ResourceFileDateRoles> resourceFileDates = JPU.emptyListOfOnixDataCompositeWithKey(ResourceFileDate.class);

    /**
     * JONIX adds: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<ResourceFileDate, JonixResourceFileDate, ResourceFileDateRoles>
        resourceFileDates() {
        _initialize();
        return resourceFileDates;
    }
}
