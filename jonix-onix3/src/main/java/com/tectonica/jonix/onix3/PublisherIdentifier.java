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
import com.tectonica.jonix.codelist.NameCodeTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixPublisherIdentifier;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Publisher identifier composite</h1><p>A group of data elements which together define the identifier of a
 * publisher name. Optional and repeatable, but mandatory if the &lt;Publisher&gt; composite does not carry a
 * &lt;PublisherName&gt;.</p><table border='1' cellpadding='3'><tr><td>Reference name</td><td>&lt;PublisherIdentifier&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;publisheridentifier&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;n</td></tr></table>
 */
public class PublisherIdentifier
    implements OnixDataCompositeWithKey<JonixPublisherIdentifier, NameCodeTypes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "PublisherIdentifier";
    public static final String shortname = "publisheridentifier";

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
    public static final PublisherIdentifier EMPTY = new PublisherIdentifier();

    public PublisherIdentifier() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public PublisherIdentifier(org.w3c.dom.Element element) {
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
                case PublisherIDType.refname:
                case PublisherIDType.shortname:
                    publisherIDType = new PublisherIDType(e);
                    break;
                case IDTypeName.refname:
                case IDTypeName.shortname:
                    idTypeName = new IDTypeName(e);
                    break;
                case IDValue.refname:
                case IDValue.shortname:
                    idValue = new IDValue(e);
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

    private PublisherIDType publisherIDType = PublisherIDType.EMPTY;

    /**
     * (this field is required)
     */
    public PublisherIDType publisherIDType() {
        initialize();
        return publisherIDType;
    }

    private IDTypeName idTypeName = IDTypeName.EMPTY;

    /**
     * (this field is optional)
     */
    public IDTypeName idTypeName() {
        initialize();
        return idTypeName;
    }

    private IDValue idValue = IDValue.EMPTY;

    /**
     * (this field is required)
     */
    public IDValue idValue() {
        initialize();
        return idValue;
    }

    @Override
    public JonixPublisherIdentifier asStruct() {
        initialize();
        JonixPublisherIdentifier struct = new JonixPublisherIdentifier();
        struct.publisherIDType = publisherIDType.value;
        struct.idTypeName = idTypeName.value;
        struct.idValue = idValue.value;
        return struct;
    }

    @Override
    public NameCodeTypes structKey() {
        return publisherIDType().value;
    }
}
