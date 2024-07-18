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
import com.tectonica.jonix.common.OnixElement;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.SupplierIdentifierTypes;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Supplier identifier type code</h1>
 * <p>
 * An ONIX code identifying the scheme from which the identifier in the &lt;IDValue&gt; element is taken. Mandatory in
 * each occurrence of the &lt;SupplierIdentifier&gt; composite, and non-repeating.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Fixed length, two digits</td>
 * </tr>
 * <tr>
 * <td>Codelist</td>
 * <td>List 92</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;SupplierIDType&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;j345&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>1</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td><tt>&lt;j345&gt;12&lt;/j345&gt;</tt> (Distributeurscode Boekenbank, Flemish supplier code)</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;SupplierIDType&gt; from the schema author:
 *
 * Type of identifier for a supplier organization
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link SupplierIdentifier}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link NewSupplier} ⯈ {@link SupplierIdentifier}
 * ⯈ {@link SupplierIDType}</li>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Supplier} ⯈ {@link SupplierIdentifier} ⯈
 * {@link SupplierIDType}</li>
 * </ul>
 */
public class SupplierIDType implements OnixElement<SupplierIdentifierTypes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "SupplierIDType";
    public static final String shortname = "j345";

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
    // VALUE MEMBER
    /////////////////////////////////////////////////////////////////////////////////

    public SupplierIdentifierTypes value;

    /**
     * Internal API, use the {@link #value()} method or the {@link #value} field instead
     */
    @Override
    public SupplierIdentifierTypes __v() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final SupplierIDType EMPTY = new SupplierIDType();

    public SupplierIDType() {
        exists = false;
    }

    public SupplierIDType(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcename = JPU.getAttribute(element, "sourcename");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));

        value = SupplierIdentifierTypes.byCode(JPU.getContentAsString(element));
    }

    /**
     * @return whether this tag (&lt;SupplierIDType&gt; or &lt;j345&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<SupplierIDType> action) {
        if (exists) {
            action.accept(this);
        }
    }

    public String codeOrNull() {
        return value == null ? null : value.code;
    }

    public String descriptionOrNull() {
        return value == null ? null : value.description;
    }
}
