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
import com.tectonica.jonix.codelist.PriceIdentifierTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixPriceIdentifier;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Price identifier composite</h1><p>An optional and repeatable group of elements that provide an identifier for a
 * particular price. For products that may be available at potentially many different prices, to different groups of
 * purchasers or under different terms and conditions, this identifier may then be used in subsequent revenue reporting
 * to specify which price the product was traded at.</p><p>Note that the price identifier will always be proprietary and
 * must be unique across multiple pricing options for one product, but need not be unique across all products, nor need
 * it be the same across all products offered at the same price point or under the same terms.</p><table border='1'
 * cellpadding='3'><tr><td>Reference name</td><td>&lt;PriceIdentifier&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;priceidentifier&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;n</td></tr></table>
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

    public RecordSourceTypes sourcetype;

    public String sourcename;

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
            if (name.equals(PriceIDType.refname) || name.equals(PriceIDType.shortname)) {
                priceIDType = new PriceIDType(e);
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

    private PriceIDType priceIDType = PriceIDType.EMPTY;

    /**
     * (this field is required)
     */
    public PriceIDType priceIDType() {
        initialize();
        return priceIDType;
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
    public JonixPriceIdentifier asStruct() {
        initialize();
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
