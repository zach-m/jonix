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
import com.tectonica.jonix.common.codelist.PriceIdentifierTypes;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixPriceIdentifier;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Price identifier composite</h1>
 * <p>
 * An optional group of elements that provide an identifier for a particular price. For products that may be available
 * at potentially many different prices, to different groups of purchasers or under different terms and conditions, this
 * identifier may then be used in subsequent revenue reporting to specify which price the product was traded at.
 * </p>
 * <p>
 * Note that the price identifier will always be proprietary and must be unique across multiple pricing options for one
 * product, but need not be unique across all products, nor need it be the same across all products offered at the same
 * price point or under the same terms.
 * </p>
 * <p>
 * The composite is repeatable in order to provide multiple identifiers for the same price.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;PriceIdentifier&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;priceidentifier&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;PriceIdentifier&gt; from the schema author:
 *
 * Identifier for a specific price (usually a proprietary ID, used in subsequent revenue reporting) &#9679; Added at
 * revision 3.0.2
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Price}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Reissue} ⯈ {@link Price} ⯈
 * {@link PriceIdentifier}</li>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Price} ⯈ {@link PriceIdentifier}</li>
 * </ul>
 *
 * @since Onix-3.02
 */
public class PriceIdentifier
    implements OnixDataCompositeWithKey<JonixPriceIdentifier, PriceIdentifierTypes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "PriceIdentifier";
    public static final String shortname = "priceidentifier";

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
    public static final PriceIdentifier EMPTY = new PriceIdentifier();

    public PriceIdentifier() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public PriceIdentifier(org.w3c.dom.Element element) {
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
                case PriceIDType.refname:
                case PriceIDType.shortname:
                    priceIDType = new PriceIDType(e);
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
     * @return whether this tag (&lt;PriceIdentifier&gt; or &lt;priceidentifier&gt;) is explicitly provided in the ONIX
     *         XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<PriceIdentifier> action) {
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

    private PriceIDType priceIDType = PriceIDType.EMPTY;

    /**
     * <p>
     * An ONIX code identifying the scheme from which the identifier in the &lt;IDValue&gt; element is taken. Mandatory
     * in each occurrence of the &lt;PriceIdentifier&gt; composite, and non-repeating.
     * </p>
     * <p>
     * There is no particular public ‘standard’ for price identifiers, so at present only proprietary identifiers may be
     * specified.
     * </p>
     * JONIX adds: this field is required
     */
    public PriceIDType priceIDType() {
        _initialize();
        return priceIDType;
    }

    private IDValue idValue = IDValue.EMPTY;

    /**
     * <p>
     * An identifier of the type specified in the &lt;PriceIDType&gt; element. Mandatory in each occurrence of the
     * &lt;PriceIdentifier&gt; composite, and non-repeating.
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
     * A name which identifies a proprietary identifier scheme (<i>ie</i> a scheme which is not a standard and for which
     * there is no individual ID type code). Must be included when, and only when, the code in the &lt;PriceIDType&gt;
     * element indicates a proprietary scheme, <i>eg</i> a publisher’s own identifier scheme. Optional and
     * non-repeating.
     * </p>
     * JONIX adds: this field is optional
     */
    public IDTypeName idTypeName() {
        _initialize();
        return idTypeName;
    }

    @Override
    public JonixPriceIdentifier asStruct() {
        _initialize();
        JonixPriceIdentifier struct = new JonixPriceIdentifier();
        struct.priceIDType = priceIDType.value;
        struct.idTypeName = idTypeName.value;
        struct.idValue = idValue.value;
        return struct;
    }

    @Override
    public PriceIdentifierTypes structKey() {
        return priceIDType().value;
    }
}
