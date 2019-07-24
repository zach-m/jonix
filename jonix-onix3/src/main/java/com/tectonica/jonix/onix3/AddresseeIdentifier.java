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

import com.tectonica.jonix.common.JPU;
import com.tectonica.jonix.common.OnixComposite.OnixDataCompositeWithKey;
import com.tectonica.jonix.common.codelist.NameIdentifierTypes;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixAddresseeIdentifier;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Addressee identifier composite</h1>
 * <p>
 * A group of data elements which together define an identifier of the addressee. The composite is optional, and
 * repeatable if more than one identifier of different types for the same addressee is sent; but <em>either</em> an
 * &lt;AddresseeName&gt; <em>or</em> an &lt;AddresseeIdentifier&gt; <em>must</em> be included.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;AddresseeIdentifier&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;addresseeidentifier&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Addressee}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Header} ⯈ {@link Addressee} ⯈ {@link AddresseeIdentifier}</li>
 * </ul>
 */
public class AddresseeIdentifier
    implements OnixDataCompositeWithKey<JonixAddresseeIdentifier, NameIdentifierTypes>, Serializable {
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

    /**
     * (type: dt.NonEmptyString)
     */
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
                case AddresseeIDType.refname:
                case AddresseeIDType.shortname:
                    addresseeIDType = new AddresseeIDType(e);
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
     * @return whether this tag (&lt;AddresseeIdentifier&gt; or &lt;addresseeidentifier&gt;) is explicitly provided in
     *         the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private AddresseeIDType addresseeIDType = AddresseeIDType.EMPTY;

    /**
     * <p>
     * An ONIX code identifying a scheme from which an identifier in the &lt;IDValue&gt; element is taken. Mandatory in
     * each occurrence of the &lt;AddresseeIdentifier&gt; composite, and non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public AddresseeIDType addresseeIDType() {
        _initialize();
        return addresseeIDType;
    }

    private IDValue idValue = IDValue.EMPTY;

    /**
     * <p>
     * An identifier of the type specified in the &lt;AddresseeIDType&gt; element. Mandatory in each occurrence of the
     * &lt;AddresseeIdentifier&gt; composite, and non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public IDValue idValue() {
        _initialize();
        return idValue;
    }

    private IDTypeName idTypeName = IDTypeName.EMPTY;

    /**
     * <p>
     * A name which identifies a proprietary identifier scheme (<i>ie</i> a scheme which is not a standard and for which
     * there is no individual ID type code). Must be included when, and only when, the code in the
     * &lt;AddresseeIDType&gt; element indicates a proprietary scheme. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public IDTypeName idTypeName() {
        _initialize();
        return idTypeName;
    }

    @Override
    public JonixAddresseeIdentifier asStruct() {
        _initialize();
        JonixAddresseeIdentifier struct = new JonixAddresseeIdentifier();
        struct.addresseeIDType = addresseeIDType.value;
        struct.idTypeName = idTypeName.value;
        struct.idValue = idValue.value;
        return struct;
    }

    @Override
    public NameIdentifierTypes structKey() {
        return addresseeIDType().value;
    }
}
