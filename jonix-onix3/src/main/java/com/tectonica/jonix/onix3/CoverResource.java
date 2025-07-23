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
 * <h1>Cover resource composite</h1>
 * <p>
 * A group of data elements that together provide details of a single file or resource of which the cover is composed.
 * At least one resource is required in each &lt;CoverManifest&gt;, and the &lt;CoverResource&gt; composite is
 * repeatable to describe multiple resources.
 * </p>
 * <p>
 * The composite must contain <em>either</em> a Resource file link <em>or</em> a No resource indicator.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;CoverResource&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;coverresource&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>1&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;CoverResource&gt; from the schema author:
 *
 * Details of a resource file needed to manufacture or package the cover of a product &#9679; Added at revision 3.0.8
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link CoverManifest}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link SupplementManifest} ⯈
 * {@link CoverManifest} ⯈ {@link CoverResource}</li>
 * <li>{@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link CoverManifest} ⯈
 * {@link CoverResource}</li>
 * </ul>
 *
 * @since Onix-3.08
 */
public class CoverResource implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "CoverResource";
    public static final String shortname = "coverresource";

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
    public static final CoverResource EMPTY = new CoverResource();

    public CoverResource() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public CoverResource(org.w3c.dom.Element element) {
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
     * @return whether this tag (&lt;CoverResource&gt; or &lt;coverresource&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<CoverResource> action) {
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
     * A URL which provides a link to a resource. Mandatory in each occurrence of the &lt;CoverResource&gt; composite
     * unless &lt;NoResource/&gt; is present, and repeatable if the resource can be linked in more than one way,
     * <i>eg</i>&nbsp;by HTTP, FTP and DOI URLs.
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
     * A number which (in combination with any &lt;SalesOutlet&gt; composite) specifies a single overall sequence of
     * cover resources. Optional and non-repeating. It is strongly recommended that each occurrence of the
     * &lt;CoverResource&gt; composite should carry a &lt;SequenceNumber&gt;.
     * </p>
     * <p>
     * Note that with &lt;SalesOutlet&gt; below, the provision of vendor-specific resources can require the use of
     * duplicate sequence numbers.
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
     * &lt;ResourceFileLink&gt;. Optional and non-repeating, and may only be used when &lt;ResourceFileLink&gt; is
     * present.
     * </p>
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
     * <p>
     * A group of data elements which together identify a specific retail outlet. Optional in each occurrence of the
     * &lt;CoverResource&gt; composite, and repeatable with multiple outlets.
     * </p>
     * <p>
     * Normally omitted, but for vendor-specific resources, the &lt;SalesOutlet&gt; composite lists an outlet for which
     * the resource is relevant. The &lt;SalesOutlet&gt; composite may be repeated where a single resource is relevant
     * for multiple outlets. Where &lt;SalesOutlet&gt; is omitted, the resource is appropriate for all&nbsp;– or all
     * <em>other</em>&nbsp;– outlets, depending on the use of the resource’s Sequence number.
     * </p>
     * <table>
     * <thead>
     * <tr>
     * <td style="width: 45%">Manifest consisting of three resources:</td>
     * <td>Manifest consisting of two <em>or</em> three resources:</td>
     * </tr>
     * </thead> <tbody>
     * <tr>
     * <td style="border-style: none">
     * <ul style="margin-top: 0">
     * <li>sequence number 1&nbsp;– no sales outlet</li>
     * <li>sequence number 2&nbsp;– exclusive to Amazon</li>
     * <li>sequence number 2&nbsp;– no sales outlet (<i>ie</i>&nbsp;alternative resource for third parties other than
     * Amazon)</li>
     * <li>sequence number 3&nbsp;– no sales outlet</li>
     * </ul>
     * </td>
     * <td style="border-style: none">
     * <ul style="margin-top: 0; margin-bottom: 0">
     * <li>sequence number 1&nbsp;– no sales outlet</li>
     * <li>sequence number 2&nbsp;– exclusive to Amazon/Kobo</li>
     * <li>sequence number 2&nbsp;– exclusive to publisher’s direct sales</li>
     * <li>sequence number 2&nbsp;– no sales outlet and &lt;NoResource/&gt; (<i>ie</i>&nbsp;no alternative resource for
     * third parties <em>other than</em> Amazon, Kobo and the publisher’s direct sales)</li>
     * <li>sequence number 3&nbsp;– no sales outlet</li>
     * </ul>
     * </td>
     * </tr>
     * </tbody>
     * </table>
     * <p>
     * In the first example, the insert always consists of three resources. Resources #1 and #3 are used for all
     * vendors, with the vendor-specific resource #2 for Amazon <em>replacing</em> resource #2 used for all other
     * vendors. In the second example, the same vendor-specific resource #2 is used for Amazon and Kobo, a different #2
     * resource is used for the publisher’s own direct sales, whereas the cover for other vendors consists of only two
     * resources (#1 and #3).
     * </p>
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
     * <p>
     * A group of data elements which together specify an identifier of the resource, in accordance with the specified
     * scheme. The composite is optional, and repeatable to specify multiple identifiers for the resource, but may only
     * be used when &lt;ResourceFileLink&gt; is present.
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
     * details, but may only be used when &lt;ResourceFileLink&gt; is present.
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
     * &lt;ResourceFileLink&gt; that is too specific to be covered in the &lt;ResourceFileDetail&gt; element. It may
     * only be used when &lt;ResourceFileLink&gt; is present, and is repeatable in order to describe different aspects
     * of the resource file.
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
     * be added to give a more detailed description. The field is optional but may only be used when
     * &lt;ResourceFileLink&gt; is present, and is repeatable to provide parallel specifications in multiple languages.
     * The <i>language</i> attribute is optional for a single instance of &lt;ResourceFileDescription&gt;, but must be
     * included in each instance if &lt;ResourceFileDescription&gt; is repeated to provide parallel descriptions in
     * multiple languages.
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
     * The content contained in the resource may be described, for manual confirmation&nbsp;– for example ‘Foil block
     * overlay’ or ‘CMYK separations of rear cover’.
     * </p>
     * <p>
     * Note that individual resources do not need to be aligned with the physical organization of the book
     * (<i>eg</i>&nbsp;with the folded signatures of a print-on-demand product), nor with the logical organization
     * (<i>eg</i>&nbsp;with the chapters in the work).
     * </p>
     * <p>
     * The field is optional but may only be used when &lt;ResourceFileLink&gt; is present, and is repeatable to provide
     * parallel descriptions in multiple languages. The <i>language</i> attribute is optional for a single instance of
     * &lt;ResourceFileContentDescription&gt;, but must be included in each instance if
     * &lt;ResourceFileContentDescription&gt; is repeated to provide parallel descriptions in multiple languages.
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
     * dates with their various roles, but may only be used when &lt;ResourceFileLink&gt; is present.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<ResourceFileDate, JonixResourceFileDate, ResourceFileDateRoles>
        resourceFileDates() {
        _initialize();
        return resourceFileDates;
    }
}
