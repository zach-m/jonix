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
import com.tectonica.jonix.OnixComposite.OnixDataCompositeWithKey;
import com.tectonica.jonix.codelist.CollectionSequenceTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixCollectionSequence;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Collection sequence composite</h1><p>An optional and repeatable group of data elements which indicates some
 * ordinal position of a product within a collection. Different ordinal positions may be specified using separate
 * repeats of the composite – for example, a product may be published first while also being third in narrative order
 * within a collection.</p><table border='1' cellpadding='3'><tr><td>Reference name</td><td>&lt;CollectionSequence&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;collectionsequence&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;n</td></tr></table>
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

    public RecordSourceTypes sourcetype;

    public String sourcename;

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
                case CollectionSequenceType.refname:
                case CollectionSequenceType.shortname:
                    collectionSequenceType = new CollectionSequenceType(e);
                    break;
                case CollectionSequenceTypeName.refname:
                case CollectionSequenceTypeName.shortname:
                    collectionSequenceTypeName = new CollectionSequenceTypeName(e);
                    break;
                case CollectionSequenceNumber.refname:
                case CollectionSequenceNumber.shortname:
                    collectionSequenceNumber = new CollectionSequenceNumber(e);
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

    private CollectionSequenceType collectionSequenceType = CollectionSequenceType.EMPTY;

    /**
     * (this field is required)
     */
    public CollectionSequenceType collectionSequenceType() {
        _initialize();
        return collectionSequenceType;
    }

    private CollectionSequenceTypeName collectionSequenceTypeName = CollectionSequenceTypeName.EMPTY;

    /**
     * (this field is optional)
     */
    public CollectionSequenceTypeName collectionSequenceTypeName() {
        _initialize();
        return collectionSequenceTypeName;
    }

    private CollectionSequenceNumber collectionSequenceNumber = CollectionSequenceNumber.EMPTY;

    /**
     * (this field is required)
     */
    public CollectionSequenceNumber collectionSequenceNumber() {
        _initialize();
        return collectionSequenceNumber;
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
