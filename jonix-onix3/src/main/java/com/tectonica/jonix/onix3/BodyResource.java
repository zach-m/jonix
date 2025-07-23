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
 * <h1>Body resource composite</h1>
 * <p>
 * A group of data elements that together provide details of a single file or resource of which the body is composed. At
 * least one resource is required in each &lt;BodyManifest&gt;, and the &lt;BodyResource&gt; composite is repeatable to
 * describe multiple resources.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;BodyResource&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;bodyresource&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>1&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;BodyResource&gt; from the schema author:
 *
 * Details of a resource file needed to manufacture or package the main body of a product &#9679; Added at revision
 * 3.0.8
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link BodyManifest}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link SupplementManifest} ⯈
 * {@link BodyManifest} ⯈ {@link BodyResource}</li>
 * <li>{@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link BodyManifest} ⯈
 * {@link BodyResource}</li>
 * </ul>
 *
 * @since Onix-3.08
 */
public class BodyResource implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "BodyResource";
    public static final String shortname = "bodyresource";

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
    public static final BodyResource EMPTY = new BodyResource();

    public BodyResource() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public BodyResource(org.w3c.dom.Element element) {
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
     * @return whether this tag (&lt;BodyResource&gt; or &lt;bodyresource&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<BodyResource> action) {
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
     * <p>
     * A URL which provides a link to a resource. Mandatory in each occurrence of the &lt;BodyResource&gt; composite,
     * and repeatable if the resource can be linked in more than one way, <i>eg</i>&nbsp;by HTTP, FTP and DOI URLs.
     * </p>
     * JONIX adds: this list is required to contain at least one item
     */
    public ListOfOnixElement<ResourceFileLink, String> resourceFileLinks() {
        _initialize();
        return resourceFileLinks;
    }

    private SequenceNumber sequenceNumber = SequenceNumber.EMPTY;

    /**
     * <p>
     * A number which specifies a single overall sequence of body resources. Optional and non-repeating. It is strongly
     * recommended that each occurrence of the &lt;BodyResource&gt; composite should carry a &lt;SequenceNumber&gt;, and
     * that primary resources are numbered in ‘spine order’. Ancillary resources (<i>eg</i>&nbsp;an image file
     * referenced by a primary HTML file) should be numbered after the primary resources.
     * </p>
     * JONIX adds: this field is optional
     */
    public SequenceNumber sequenceNumber() {
        _initialize();
        return sequenceNumber;
    }

    private ResourceRole resourceRole = ResourceRole.EMPTY;

    /**
     * <p>
     * An ONIX code which identifies the role or purpose of the resource file which is specified in
     * &lt;ResourceFileLink&gt;. Optional and non-repeating.
     * </p>
     * JONIX adds: this field is optional
     */
    public ResourceRole resourceRole() {
        _initialize();
        return resourceRole;
    }

    private ListOfOnixDataCompositeWithKey<ResourceIdentifier, JonixResourceIdentifier,
        ResourceIdentifierTypes> resourceIdentifiers =
            JPU.emptyListOfOnixDataCompositeWithKey(ResourceIdentifier.class);

    /**
     * <p>
     * A group of data elements which together specify an identifier of the resource, in accordance with the specified
     * scheme. The composite is optional, and repeatable to specify multiple identifiers for the resource.
     * </p>
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
     * <p>
     * An ONIX code which provides added detail of the resource file which is specified in &lt;ResourceFileLink&gt;,
     * <i>eg</i>&nbsp;the file type of the resource. Optional, and repeatable in order to provide multiple additional
     * details.
     * </p>
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
     * <p>
     * An optional group of data elements which together describe an aspect of a resource file specified in
     * &lt;ResourceFileLink&gt; that is too specific to be covered in the &lt;ResourceFileDetail&gt; element. The
     * composite is repeatable in order to describe different aspects of the resource file.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<ResourceFileFeature, JonixResourceFileFeature, ResourceFileFeatureTypes>
        resourceFileFeatures() {
        _initialize();
        return resourceFileFeatures;
    }

    private ListOfOnixElement<ResourceFileDescription, String> resourceFileDescriptions = ListOfOnixElement.empty();

    /**
     * <p>
     * If the Resource file details and features do not adequately describe the resource, a short text description may
     * be added to give a more detailed description. The field is optional, and is repeatable to provide parallel
     * specifications in multiple languages. The <i>language</i> attribute is optional for a single instance of
     * &lt;ResourceFileDescription&gt;, but must be included in each instance if &lt;ResourceFileDescription&gt; is
     * repeated to provide parallel descriptions in multiple languages.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixElement<ResourceFileDescription, String> resourceFileDescriptions() {
        _initialize();
        return resourceFileDescriptions;
    }

    private ListOfOnixElement<ResourceFileContentDescription, String> resourceFileContentDescriptions =
        ListOfOnixElement.empty();

    /**
     * <p>
     * The content contained in the resource may be described, for manual confirmation – for example ‘Chapters 2 and 3’
     * or ‘CMYK separations pages 16-31’.
     * </p>
     * <p>
     * Note that individual resources do not need to be aligned with the physical organization of the book
     * (<i>eg</i>&nbsp;with the folded signatures of a print-on-demand product), nor with the logical organization
     * (<i>eg</i>&nbsp;with the chapters in the work).
     * </p>
     * <p>
     * The field is optional, and is repeatable to provide parallel descriptions in multiple languages. The
     * <i>language</i> attribute is optional for a single instance of &lt;ResourceFileContentDescription&gt;, but must
     * be included in each instance if &lt;ResourceFileContentDescription&gt; is repeated to provide parallel
     * descriptions in multiple languages.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixElement<ResourceFileContentDescription, String> resourceFileContentDescriptions() {
        _initialize();
        return resourceFileContentDescriptions;
    }

    private ListOfOnixDataCompositeWithKey<ResourceFileDate, JonixResourceFileDate,
        ResourceFileDateRoles> resourceFileDates = JPU.emptyListOfOnixDataCompositeWithKey(ResourceFileDate.class);

    /**
     * <p>
     * An optional group of data elements which together specify a date associated with the resource file specified in
     * &lt;ResourceFileLink&gt;, <i>eg</i>&nbsp;date when the resource was last updated. Repeatable to specify different
     * dates with their various roles.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<ResourceFileDate, JonixResourceFileDate, ResourceFileDateRoles>
        resourceFileDates() {
        _initialize();
        return resourceFileDates;
    }
}
