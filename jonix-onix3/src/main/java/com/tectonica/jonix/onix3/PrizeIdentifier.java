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
import com.tectonica.jonix.common.OnixComposite.OnixDataCompositeWithKey;
import com.tectonica.jonix.common.codelist.PrizeIdentifierTypes;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixPrizeIdentifier;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Prize identifier composite</h1>
 * <p>
 * A group of data elements which together specify an identifier for the Prize. The composite is optional, and
 * repeatable if more than one identifier for the same prize is sent.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;PrizeIdentifier&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;prizeidentifier&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;PrizeIdentifier&gt; from the schema author:
 *
 * An identifier which uniquely identifies the prize, eg an ISNI or a proprietary identifier &#9679; Added at revision
 * 3.1.1
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Prize}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link CollateralDetail} ⯈ {@link Prize} ⯈ {@link PrizeIdentifier}</li>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Contributor} ⯈ {@link Prize} ⯈ {@link PrizeIdentifier}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link Contributor} ⯈ {@link Prize} ⯈
 * {@link PrizeIdentifier}</li>
 * <li>{@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈ {@link Contributor} ⯈ {@link Prize} ⯈
 * {@link PrizeIdentifier}</li>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Collection} ⯈ {@link Contributor} ⯈ {@link Prize} ⯈
 * {@link PrizeIdentifier}</li>
 * </ul>
 *
 * @since Onix-3.11
 */
public class PrizeIdentifier
    implements OnixDataCompositeWithKey<JonixPrizeIdentifier, PrizeIdentifierTypes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "PrizeIdentifier";
    public static final String shortname = "prizeidentifier";

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
    public static final PrizeIdentifier EMPTY = new PrizeIdentifier();

    public PrizeIdentifier() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public PrizeIdentifier(org.w3c.dom.Element element) {
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
                case PrizeIDType.refname:
                case PrizeIDType.shortname:
                    prizeIDType = new PrizeIDType(e);
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
     * @return whether this tag (&lt;PrizeIdentifier&gt; or &lt;prizeidentifier&gt;) is explicitly provided in the ONIX
     *         XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<PrizeIdentifier> action) {
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

    private PrizeIDType prizeIDType = PrizeIDType.EMPTY;

    /**
     * <p>
     * An ONIX code identifying a scheme from which an identifier in the &lt;IDValue&gt; element is taken. Mandatory in
     * each occurrence of the &lt;PrizeIdentifier&gt; composite, and non-repeating.
     * </p>
     * JONIX adds: this field is required
     */
    public PrizeIDType prizeIDType() {
        _initialize();
        return prizeIDType;
    }

    private IDValue idValue = IDValue.EMPTY;

    /**
     * <p>
     * An identifier of the type specified in the &lt;PrizeIDType&gt; element. Mandatory in each occurrence of the
     * &lt;PrizeIdentifier&gt; composite, and non-repeating.
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
     * there is no individual ID type code). Must be included when, and only when, the code in the &lt;PrizeIDType&gt;
     * element indicates a proprietary scheme. Optional and non-repeating.
     * </p>
     * JONIX adds: this field is optional
     */
    public IDTypeName idTypeName() {
        _initialize();
        return idTypeName;
    }

    @Override
    public JonixPrizeIdentifier asStruct() {
        _initialize();
        JonixPrizeIdentifier struct = new JonixPrizeIdentifier();
        struct.prizeIDType = prizeIDType.value;
        struct.idTypeName = idTypeName.value;
        struct.idValue = idValue.value;
        return struct;
    }

    @Override
    public PrizeIdentifierTypes structKey() {
        return prizeIDType().value;
    }
}
