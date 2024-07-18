/*
 * Copyright (C) 2012-2024 Zach Melamed
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
import com.tectonica.jonix.common.ListOfOnixComposite;
import com.tectonica.jonix.common.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.common.ListOfOnixElement;
import com.tectonica.jonix.common.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.common.codelist.CollectionIdentifierTypes;
import com.tectonica.jonix.common.codelist.CollectionSequenceTypes;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixCollectionIdentifier;
import com.tectonica.jonix.common.struct.JonixCollectionSequence;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Collection composite</h1>
 * <p>
 * An optional group of data elements which carry attributes of a collection of which the product is part. (For a
 * publisher collection, these attributes may or may not include the collection title.) The composite is repeatable, to
 * provide details when the product belongs to multiple collections.
 * </p>
 * <p>
 * Collection-related data elements within a &lt;Collection&gt; composite that does not carry collection title
 * information must relate to a publisher collection whose title is included in Group&nbsp;P.6.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;Collection&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;collection&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;Collection&gt; from the schema author:
 *
 * Details of a collection (eg a set or series, or a curated grouping of products) &#9679; Added
 * &lt;CollectionFrequency&gt; at release 3.1 &#9679; Added &lt;NoContributor&gt; (in gp.authorship) at revision 3.0.4
 * &#9679; Added &lt;CollectionSequence&gt; and &lt;ContributorStatement&gt; (in gp.authorship) at revision 3.0.1
 * &#9679; Modified cardinality of &lt;ContributorStatement&gt; at revision 3.0.1
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link DescriptiveDetail}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Collection}</li>
 * </ul>
 */
public class Collection implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Collection";
    public static final String shortname = "collection";

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
    public static final Collection EMPTY = new Collection();

    public Collection() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public Collection(org.w3c.dom.Element element) {
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
                case CollectionType.refname:
                case CollectionType.shortname:
                    collectionType = new CollectionType(e);
                    break;
                case Contributor.refname:
                case Contributor.shortname:
                    contributors = JPU.addToList(contributors, new Contributor(e));
                    break;
                case CollectionFrequency.refname:
                case CollectionFrequency.shortname:
                    collectionFrequency = new CollectionFrequency(e);
                    break;
                case SourceName.refname:
                case SourceName.shortname:
                    sourceName = new SourceName(e);
                    break;
                case NoContributor.refname:
                case NoContributor.shortname:
                    noContributor = new NoContributor(e);
                    break;
                case CollectionIdentifier.refname:
                case CollectionIdentifier.shortname:
                    collectionIdentifiers = JPU.addToList(collectionIdentifiers, new CollectionIdentifier(e));
                    break;
                case CollectionSequence.refname:
                case CollectionSequence.shortname:
                    collectionSequences = JPU.addToList(collectionSequences, new CollectionSequence(e));
                    break;
                case TitleDetail.refname:
                case TitleDetail.shortname:
                    titleDetails = JPU.addToList(titleDetails, new TitleDetail(e));
                    break;
                case ContributorStatement.refname:
                case ContributorStatement.shortname:
                    contributorStatements = JPU.addToList(contributorStatements, new ContributorStatement(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;Collection&gt; or &lt;collection&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<Collection> action) {
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

    private CollectionType collectionType = CollectionType.EMPTY;

    /**
     * <p>
     * An ONIX code indicating the type of a collection: publisher collection, ascribed collection, or unspecified.
     * Mandatory in each occurrence of the &lt;Collection&gt; composite, and non-repeating.
     * </p>
     * JONIX adds: this field is required
     */
    public CollectionType collectionType() {
        _initialize();
        return collectionType;
    }

    private ListOfOnixComposite<Contributor> contributors = JPU.emptyListOfOnixComposite(Contributor.class);

    /**
     * <p>
     * A group of data elements which together describe a personal or corporate contributor to a collection. Optional,
     * and repeatable to describe multiple contributors. <strong>The &lt;Contributor&gt; composite is included here for
     * use only by those ONIX communities whose national practice requires contributors to the collection as a whole
     * (<i>eg</i> Series editors) to be identified at collection level. In many countries, including the UK, USA, Canada
     * and Spain, the required practice is to identify all contributors at product level in Group&nbsp;P.7.</strong>
     * </p>
     * JONIX adds: this list is required to contain at least one item
     */
    public ListOfOnixComposite<Contributor> contributors() {
        _initialize();
        return contributors;
    }

    private CollectionFrequency collectionFrequency = CollectionFrequency.EMPTY;

    /**
     * <p>
     * An ONIX code specifying the approximate or expected publication frequency for addition of new products to the
     * collection. Optional, and non-repeating.
     * </p>
     * JONIX adds: this field is optional
     */
    public CollectionFrequency collectionFrequency() {
        _initialize();
        return collectionFrequency;
    }

    private SourceName sourceName = SourceName.EMPTY;

    /**
     * <p>
     * If the &lt;CollectionType&gt; code indicates an ascribed collection (<i>ie</i> a collection which has been
     * identified and described by a supply chain organization other than the publisher), this element may be used to
     * carry the name of the organization responsible. Optional and non-repeating.
     * </p>
     * JONIX adds: this field is optional
     */
    public SourceName sourceName() {
        _initialize();
        return sourceName;
    }

    private NoContributor noContributor = NoContributor.EMPTY;

    /**
     * <p>
     * An empty element that provides a positive indication that a collection has no stated authorship. Optional and
     * non-repeating. Must only be sent in a record that has no &lt;Contributor&gt; data in Group P.5.
     * </p>
     * <p>
     * <strong>The &lt;NoContributor/&gt; element is provided here for use only by those ONIX communities whose national
     * practice requires contributors to the collection to be identified at collection level.</strong> It should not be
     * sent in a context where collection contributors are normally identified in Group&nbsp;P.6.
     * </p>
     * JONIX adds: this field is optional
     */
    public NoContributor noContributor() {
        _initialize();
        return noContributor;
    }

    public boolean isNoContributor() {
        return (noContributor().exists());
    }

    private ListOfOnixDataCompositeWithKey<CollectionIdentifier, JonixCollectionIdentifier,
        CollectionIdentifierTypes> collectionIdentifiers =
            JPU.emptyListOfOnixDataCompositeWithKey(CollectionIdentifier.class);

    /**
     * <p>
     * A repeatable group of data elements which together specify an identifier of a bibliographic collection. The
     * composite is optional, and may only repeat if two or more identifiers of different types are sent for the same
     * collection. It is not permissible to have two identifiers of the same type.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<CollectionIdentifier, JonixCollectionIdentifier, CollectionIdentifierTypes>
        collectionIdentifiers() {
        _initialize();
        return collectionIdentifiers;
    }

    private ListOfOnixDataCompositeWithKey<CollectionSequence, JonixCollectionSequence,
        CollectionSequenceTypes> collectionSequences =
            JPU.emptyListOfOnixDataCompositeWithKey(CollectionSequence.class);

    /**
     * <p>
     * An optional and repeatable group of data elements which indicates some ordinal position of a product within a
     * collection. Different ordinal positions may be specified using separate repeats of the composite – for example, a
     * product may be published first while also being third in narrative order within a collection.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<CollectionSequence, JonixCollectionSequence, CollectionSequenceTypes>
        collectionSequences() {
        _initialize();
        return collectionSequences;
    }

    private ListOfOnixComposite<TitleDetail> titleDetails = JPU.emptyListOfOnixComposite(TitleDetail.class);

    /**
     * <p>
     * A group of data elements which together give the text of a collection title and specify its type. Optional, but
     * the composite is required unless the only collection title is carried in full, and word-for-word, as an integral
     * part of the product title in P.6, in which case it should not be repeated in&nbsp;P.5. The composite is
     * repeatable with different title types.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixComposite<TitleDetail> titleDetails() {
        _initialize();
        return titleDetails;
    }

    private ListOfOnixElement<ContributorStatement, String> contributorStatements = ListOfOnixElement.empty();

    /**
     * <p>
     * Free text showing how the collection authorship should be described in an online display, when a standard
     * concatenation of individual collection contributor elements would not give a satisfactory presentation. Optional
     * but must only be used if one or more instances of &lt;Contributor&gt; are present within &lt;Collection&gt;, and
     * repeatable where parallel text is provided in multiple languages. The <i>language</i> attribute is optional for a
     * single instance of &lt;ContributorStatement&gt;, but must be included in each instance if
     * &lt;ContributorStatement&gt; is repeated. When the &lt;ContributorStatement&gt; element is sent, the recipient
     * should use it to replace all name detail sent in the &lt;Contributor&gt; composites within &lt;Collection&gt;
     * <em>for display purposes only</em>. It does not replace the &lt;Contributor&gt; composite (or any element within
     * it) for individual contributors. The individual name detail <em>must</em> also be sent in one or more
     * &lt;Contributor&gt; composites for indexing and retrieval purposes.
     * </p>
     * <p>
     * <strong>The &lt;ContributorStatement&gt; element is provided here for use only by those ONIX communities whose
     * national practice requires contributors to the collection to be identified at collection level.</strong> It
     * should not be sent in a context where collection contributors are normally identified in Group&nbsp;P.6.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixElement<ContributorStatement, String> contributorStatements() {
        _initialize();
        return contributorStatements;
    }
}
