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
import com.tectonica.jonix.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.codelist.RecordSourceTypes;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>null</h1><h4 class="nobreak">Product supply composite</h4><p>The product supply block covers data element Groups
 * P.24 to P.26, specifying a market, the publishing status of the product in that market, and the supply arrangements
 * for the product in that market. The block is repeatable to describe multiple markets. At least one occurrence is
 * expected in a &lt;Product&gt; record unless the &lt;NotificationType&gt; in Group&nbsp;P.1 indicates that the record
 * is an update notice which carries only those blocks in which changes have occurred.</p><table border='1'
 * cellpadding='3'><tr><td>Reference name</td><td>&lt;ProductSupply&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;productsupply&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;n</td></tr></table>
 */
public class ProductSupply implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "ProductSupply";
    public static final String shortname = "productsupply";

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
    public static final ProductSupply EMPTY = new ProductSupply();

    public ProductSupply() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public ProductSupply(org.w3c.dom.Element element) {
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
                case Market.refname:
                case Market.shortname:
                    markets = JPU.addToList(markets, new Market(e));
                    break;
                case MarketPublishingDetail.refname:
                case MarketPublishingDetail.shortname:
                    marketPublishingDetail = new MarketPublishingDetail(e);
                    break;
                case SupplyDetail.refname:
                case SupplyDetail.shortname:
                    supplyDetails = JPU.addToList(supplyDetails, new SupplyDetail(e));
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

    private List<Market> markets = Collections.emptyList();

    /**
     * (this list may be empty)
     */
    public List<Market> markets() {
        initialize();
        return markets;
    }

    private MarketPublishingDetail marketPublishingDetail = MarketPublishingDetail.EMPTY;

    /**
     * (this field is optional)
     */
    public MarketPublishingDetail marketPublishingDetail() {
        initialize();
        return marketPublishingDetail;
    }

    private List<SupplyDetail> supplyDetails = Collections.emptyList();

    /**
     * (this list is required to contain at least one item)
     */
    public List<SupplyDetail> supplyDetails() {
        initialize();
        return supplyDetails;
    }
}
