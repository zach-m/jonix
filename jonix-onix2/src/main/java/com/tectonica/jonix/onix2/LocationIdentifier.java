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

package com.tectonica.jonix.onix2;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.Consumer;

import com.tectonica.jonix.common.*;
import com.tectonica.jonix.common.OnixComposite.*;
import com.tectonica.jonix.common.codelist.*;
import com.tectonica.jonix.common.struct.*;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Location identifier composite</h1>
 * <p>
 * A group of data elements which together define the identifier of a stock location in accordance with a specified
 * scheme, and allowing different types of location identifier to be supported without defining additional data
 * elements. Optional and non-repeating.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;LocationIdentifier&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;locationidentifier&gt;</tt></td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Stock}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link SupplyDetail} ⯈ {@link Stock} ⯈ {@link LocationIdentifier}</li>
 * </ul>
 *
 * @since Onix-2.1
 */
public class LocationIdentifier
    implements OnixDataCompositeWithKey<JonixLocationIdentifier, SupplierIdentifierTypes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "LocationIdentifier";
    public static final String shortname = "locationidentifier";

    /////////////////////////////////////////////////////////////////////////////////
    // ATTRIBUTES
    /////////////////////////////////////////////////////////////////////////////////

    public TextFormats textformat;

    public TextCaseFlags textcase;

    public Languages language;

    public TransliterationSchemes transliteration;

    /**
     * (type: DateOrDateTime)
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
    public static final LocationIdentifier EMPTY = new LocationIdentifier();

    public LocationIdentifier() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public LocationIdentifier(org.w3c.dom.Element element) {
        exists = true;
        initialized = false;
        this.element = element;
        textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));
        textcase = TextCaseFlags.byCode(JPU.getAttribute(element, "textcase"));
        language = Languages.byCode(JPU.getAttribute(element, "language"));
        transliteration = TransliterationSchemes.byCode(JPU.getAttribute(element, "transliteration"));
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
                case LocationIDType.refname:
                case LocationIDType.shortname:
                    locationIDType = new LocationIDType(e);
                    break;
                case IDValue.refname:
                case IDValue.shortname:
                    idValue = new IDValue(e);
                    break;
                case IDTypeName.refname:
                case IDTypeName.shortname:
                    idTypeName = new IDTypeName(e);
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;LocationIdentifier&gt; or &lt;locationidentifier&gt;) is explicitly provided in the
     *         ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<LocationIdentifier> action) {
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

    private LocationIDType locationIDType = LocationIDType.EMPTY;

    /**
     * <p>
     * An ONIX code identifying the scheme from which the identifier in the &lt;IDValue&gt; element is taken. Mandatory
     * in each occurrence of the &lt;LocationIdentifier&gt; composite, and non-repeating.
     * </p>
     * JONIX adds: this field is required
     */
    public LocationIDType locationIDType() {
        _initialize();
        return locationIDType;
    }

    private IDValue idValue = IDValue.EMPTY;

    /**
     * <p>
     * An identifier of the type specified in the &lt;LocationIDType&gt; element. Mandatory in each occurrence of the
     * &lt;LocationIdentifier&gt; composite, and non-repeating.
     * </p>
     * JONIX adds: this field is required
     */
    public IDValue idValue() {
        _initialize();
        return idValue;
    }

    private IDTypeName idTypeName = IDTypeName.EMPTY;

    /**
     * <p>
     * A name which identifies a proprietary identifier scheme when the code in the &lt;LocationIDType&gt; element
     * indicates a proprietary scheme, <em>eg</em> a wholesaler’s own code. Optional and non-repeating.
     * </p>
     * JONIX adds: this field is optional
     */
    public IDTypeName idTypeName() {
        _initialize();
        return idTypeName;
    }

    @Override
    public JonixLocationIdentifier asStruct() {
        _initialize();
        JonixLocationIdentifier struct = new JonixLocationIdentifier();
        struct.locationIDType = locationIDType.value;
        struct.idTypeName = idTypeName.value;
        struct.idValue = idValue.value;
        return struct;
    }

    @Override
    public SupplierIdentifierTypes structKey() {
        return locationIDType().value;
    }
}
