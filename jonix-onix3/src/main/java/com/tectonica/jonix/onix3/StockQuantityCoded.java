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
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.StockQuantityCodeTypes;
import com.tectonica.jonix.struct.JonixStockQuantityCoded;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Stock quantity coded composite</h1><p>A group of data elements which together specify coded stock level without
 * stating the exact quantity of stock. Either &lt;StockQuantityCoded&gt; or &lt;OnHand&gt; is mandatory in each
 * occurrence of the &lt;Stock&gt; composite, even if the quantity on hand is zero. Repeatable, so that it is possible
 * to provide quantities on hand, quantities on order <i>etc</i> separately.</p><table border='1'
 * cellpadding='3'><tr><td>Reference name</td><td>&lt;StockQuantityCoded&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;stockquantitycoded&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;n</td></tr></table>
 */
public class StockQuantityCoded
    implements OnixDataCompositeWithKey<JonixStockQuantityCoded, StockQuantityCodeTypes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "StockQuantityCoded";
    public static final String shortname = "stockquantitycoded";

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
    public static final StockQuantityCoded EMPTY = new StockQuantityCoded();

    public StockQuantityCoded() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public StockQuantityCoded(org.w3c.dom.Element element) {
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
            if (name.equals(StockQuantityCodeType.refname) || name.equals(StockQuantityCodeType.shortname)) {
                stockQuantityCodeType = new StockQuantityCodeType(e);
            } else if (name.equals(StockQuantityCodeTypeName.refname) ||
                name.equals(StockQuantityCodeTypeName.shortname)) {
                stockQuantityCodeTypeName = new StockQuantityCodeTypeName(e);
            } else if (name.equals(StockQuantityCode.refname) || name.equals(StockQuantityCode.shortname)) {
                stockQuantityCode = new StockQuantityCode(e);
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

    private StockQuantityCodeType stockQuantityCodeType = StockQuantityCodeType.EMPTY;

    /**
     * (this field is required)
     */
    public StockQuantityCodeType stockQuantityCodeType() {
        initialize();
        return stockQuantityCodeType;
    }

    private StockQuantityCodeTypeName stockQuantityCodeTypeName = StockQuantityCodeTypeName.EMPTY;

    /**
     * (this field is optional)
     */
    public StockQuantityCodeTypeName stockQuantityCodeTypeName() {
        initialize();
        return stockQuantityCodeTypeName;
    }

    private StockQuantityCode stockQuantityCode = StockQuantityCode.EMPTY;

    /**
     * (this field is required)
     */
    public StockQuantityCode stockQuantityCode() {
        initialize();
        return stockQuantityCode;
    }

    @Override
    public JonixStockQuantityCoded asStruct() {
        initialize();
        JonixStockQuantityCoded struct = new JonixStockQuantityCoded();
        struct.stockQuantityCodeType = stockQuantityCodeType.value;
        struct.stockQuantityCode = stockQuantityCode.value;
        struct.stockQuantityCodeTypeName = stockQuantityCodeTypeName.value;
        return struct;
    }

    @Override
    public StockQuantityCodeTypes structKey() {
        return stockQuantityCodeType().value;
    }
}
