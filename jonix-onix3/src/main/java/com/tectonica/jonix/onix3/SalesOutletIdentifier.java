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
import com.tectonica.jonix.common.OnixComposite.OnixDataCompositeWithKey;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.SalesOutletIdentifierTypes;
import com.tectonica.jonix.common.struct.JonixSalesOutletIdentifier;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Sales outlet identifier composite</h1>
 * <p>
 * An optional group of data elements which together represent a coded identification of an organization, used here to
 * identify a sales outlet. Repeatable in order to specify multiple identifiers for the same sales outlet.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;SalesOutletIdentifier&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;salesoutletidentifier&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;SalesOutletIdentifier&gt; from the schema author:
 *
 * Identifier for a specific retail outlet, eg one associated with sales exclusivity
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link SalesOutlet}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link SupplementManifest} ⯈
 * {@link SalesOutlet} ⯈ {@link SalesOutletIdentifier}</li>
 * <li>{@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link SupplementManifest} ⯈
 * {@link CoverManifest} ⯈ {@link CoverResource} ⯈ {@link SalesOutlet} ⯈ {@link SalesOutletIdentifier}</li>
 * <li>{@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link CoverManifest} ⯈
 * {@link CoverResource} ⯈ {@link SalesOutlet} ⯈ {@link SalesOutletIdentifier}</li>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link Market} ⯈ {@link SalesRestriction} ⯈ {@link SalesOutlet} ⯈
 * {@link SalesOutletIdentifier}</li>
 * <li>{@link Product} ⯈ {@link PublishingDetail} ⯈ {@link SalesRights} ⯈ {@link SalesRestriction} ⯈ {@link SalesOutlet}
 * ⯈ {@link SalesOutletIdentifier}</li>
 * <li>{@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link SupplementManifest} ⯈
 * {@link InsertManifest} ⯈ {@link InsertResource} ⯈ {@link SalesOutlet} ⯈ {@link SalesOutletIdentifier}</li>
 * <li>{@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link InsertManifest} ⯈
 * {@link InsertResource} ⯈ {@link SalesOutlet} ⯈ {@link SalesOutletIdentifier}</li>
 * </ul>
 *
 * @since Onix-3.02
 */
public class SalesOutletIdentifier
    implements OnixDataCompositeWithKey<JonixSalesOutletIdentifier, SalesOutletIdentifierTypes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "SalesOutletIdentifier";
    public static final String shortname = "salesoutletidentifier";

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
    public static final SalesOutletIdentifier EMPTY = new SalesOutletIdentifier();

    public SalesOutletIdentifier() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public SalesOutletIdentifier(org.w3c.dom.Element element) {
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
                case SalesOutletIDType.refname:
                case SalesOutletIDType.shortname:
                    salesOutletIDType = new SalesOutletIDType(e);
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
     * @return whether this tag (&lt;SalesOutletIdentifier&gt; or &lt;salesoutletidentifier&gt;) is explicitly provided
     *         in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<SalesOutletIdentifier> action) {
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

    private SalesOutletIDType salesOutletIDType = SalesOutletIDType.EMPTY;

    /**
     * <p>
     * An ONIX code which identifies the scheme from which the value in the &lt;IDValue&gt; element is taken. Mandatory
     * in each occurrence of the &lt;SalesOutletIdentifier&gt; composite, and non-repeating.
     * </p>
     * JONIX adds: this field is required
     */
    public SalesOutletIDType salesOutletIDType() {
        _initialize();
        return salesOutletIDType;
    }

    private IDValue idValue = IDValue.EMPTY;

    /**
     * <p>
     * A code value taken from the scheme specified in the &lt;SalesOutletIDType&gt; element. Mandatory in each
     * occurrence of the &lt;SalesOutletIdentifier&gt; composite, and non-repeating.
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
     * A name which identifies a proprietary identifier scheme (<i>ie</i>&nbsp;a scheme which is not a standard and for
     * which there is no individual ID type code). Must be included when, and only when, the code in the
     * &lt;SalesOutletIDType&gt; element indicates a proprietary scheme. Optional and non-repeating.
     * </p>
     * JONIX adds: this field is optional
     */
    public IDTypeName idTypeName() {
        _initialize();
        return idTypeName;
    }

    @Override
    public JonixSalesOutletIdentifier asStruct() {
        _initialize();
        JonixSalesOutletIdentifier struct = new JonixSalesOutletIdentifier();
        struct.salesOutletIDType = salesOutletIDType.value;
        struct.idTypeName = idTypeName.value;
        struct.idValue = idValue.value;
        return struct;
    }

    @Override
    public SalesOutletIdentifierTypes structKey() {
        return salesOutletIDType().value;
    }
}
