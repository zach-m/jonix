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
import com.tectonica.jonix.struct.JonixAddresseeIdentifier;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Addressee identifier composite</h1><p>A group of data elements which together define an identifier of the
 * addressee. The composite is optional, and repeatable if more than one identifier of different types is sent; but
 * <em>either</em> an &lt;AddresseeName&gt; <em>or</em> an &lt;AddresseeIdentifier&gt; <em>must</em> be
 * included.</p><table border='1' cellpadding='3'><tr><td>Reference name</td><td>&lt;AddresseeIdentifier&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;addresseeidentifier&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;n</td></tr></table>
 */
public class AddresseeIdentifier
    implements OnixDataCompositeWithKey<JonixAddresseeIdentifier, NameCodeTypes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "AddresseeIdentifier";
    public static final String shortname = "addresseeidentifier";

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
    public static final AddresseeIdentifier EMPTY = new AddresseeIdentifier();

    public AddresseeIdentifier() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public AddresseeIdentifier(org.w3c.dom.Element element) {
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
            if (name.equals(AddresseeIDType.refname) || name.equals(AddresseeIDType.shortname)) {
                addresseeIDType = new AddresseeIDType(e);
            } else if (name.equals(IDTypeName.refname) || name.equals(IDTypeName.shortname)) {
                idTypeName = new IDTypeName(e);
            } else if (name.equals(IDValue.refname) || name.equals(IDValue.shortname)) {
                idValue = new IDValue(e);
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

    private AddresseeIDType addresseeIDType = AddresseeIDType.EMPTY;

    /**
     * (this field is required)
     */
    public AddresseeIDType addresseeIDType() {
        initialize();
        return addresseeIDType;
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
    public JonixAddresseeIdentifier asStruct() {
        initialize();
        JonixAddresseeIdentifier struct = new JonixAddresseeIdentifier();
        struct.addresseeIDType = addresseeIDType.value;
        struct.idTypeName = idTypeName.value;
        struct.idValue = idValue.value;
        return struct;
    }

    @Override
    public NameCodeTypes structKey() {
        return addresseeIDType().value;
    }
}
