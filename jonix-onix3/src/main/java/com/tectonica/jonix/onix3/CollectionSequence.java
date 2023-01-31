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
import com.tectonica.jonix.common.OnixComposite.OnixDataCompositeWithKey;
import com.tectonica.jonix.common.codelist.CollectionSequenceTypes;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixCollectionSequence;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Collection sequence composite</h1>
 * <p>
 * An optional and repeatable group of data elements which indicates some ordinal position of a product within a
 * collection. Different ordinal positions may be specified using separate repeats of the composite – for example, a
 * product may be published first while also being third in narrative order within a collection.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;CollectionSequence&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;collectionsequence&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Collection}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Collection} ⯈
 * {@link CollectionSequence}</li>
 * </ul>
 *
 * @since Onix-3.01
 */
public class CollectionSequence
    implements OnixDataCompositeWithKey<JonixCollectionSequence, CollectionSequenceTypes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "CollectionSequence";
    public static final String shortname = "collectionsequence";

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
    public static final CollectionSequence EMPTY = new CollectionSequence();

    public CollectionSequence() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public CollectionSequence(org.w3c.dom.Element element) {
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
                case CollectionSequenceType.refname:
                case CollectionSequenceType.shortname:
                    collectionSequenceType = new CollectionSequenceType(e);
                    break;
                case CollectionSequenceNumber.refname:
                case CollectionSequenceNumber.shortname:
                    collectionSequenceNumber = new CollectionSequenceNumber(e);
                    break;
                case CollectionSequenceTypeName.refname:
                case CollectionSequenceTypeName.shortname:
                    collectionSequenceTypeName = new CollectionSequenceTypeName(e);
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;CollectionSequence&gt; or &lt;collectionsequence&gt;) is explicitly provided in the
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

    private CollectionSequenceType collectionSequenceType = CollectionSequenceType.EMPTY;

    /**
     * <p>
     * An ONIX code identifying the type of ordering used for the product’s sequence number within the collection.
     * Mandatory and non-repeating within the &lt;CollectionSequence&gt; composite.
     * </p>
     * Jonix-Comment: this field is required
     */
    public CollectionSequenceType collectionSequenceType() {
        _initialize();
        return collectionSequenceType;
    }

    private CollectionSequenceNumber collectionSequenceNumber = CollectionSequenceNumber.EMPTY;

    /**
     * <p>
     * A number which specifies the ordinal position of the product in a collection. The ordinal position may be a
     * simple number (1st, 2nd, 3rd <i>etc</i>) or may be multi-level (<i>eg</i> 3.2) if the collection has a
     * multi-level structure (<i>ie</i> there are both collection and sub-collection title elements). Mandatory and
     * non-repeating within the &lt;CollectionSequence&gt; composite.
     * </p>
     * <p>
     * <span style="color: deeppink; font-weight: bold">New in 3.0.4</span> A hyphen may be used in place of an integer
     * within a multi-level number, where a particular level of the hierarchy is unnumbered, for example -.3 where a
     * product is the third in a sub-collection, and the sub-collection is unnumbered within the collection.
     * </p>
     * Jonix-Comment: this field is required
     */
    public CollectionSequenceNumber collectionSequenceNumber() {
        _initialize();
        return collectionSequenceNumber;
    }

    private CollectionSequenceTypeName collectionSequenceTypeName = CollectionSequenceTypeName.EMPTY;

    /**
     * <p>
     * A name which describes a proprietary order used for the product’s sequence number within the collection. Must be
     * included when, and only when, the code in the &lt;CollectionSequenceType&gt; field indicates a proprietary
     * scheme. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public CollectionSequenceTypeName collectionSequenceTypeName() {
        _initialize();
        return collectionSequenceTypeName;
    }

    @Override
    public JonixCollectionSequence asStruct() {
        _initialize();
        JonixCollectionSequence struct = new JonixCollectionSequence();
        struct.collectionSequenceType = collectionSequenceType.value;
        struct.collectionSequenceTypeName = collectionSequenceTypeName.value;
        struct.collectionSequenceNumber = collectionSequenceNumber.value;
        return struct;
    }

    @Override
    public CollectionSequenceTypes structKey() {
        return collectionSequenceType().value;
    }
}
