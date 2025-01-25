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
 * <h1>Product supply composite</h1>
 * <p>
 * The product supply block covers data Groups P.24 to P.26, specifying a market, the publishing status of the product
 * in that market, and the supply arrangements for the product in that market. The block is repeatable to describe
 * multiple markets. At least one occurrence is expected in a &lt;Product&gt; record unless the &lt;NotificationType&gt;
 * in Group&nbsp;P.1 indicates that the record is a partial update notice which carries only those blocks in which
 * changes have occurred.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;ProductSupply&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;productsupply&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;ProductSupply&gt; from the schema author:
 *
 * Container for data describing a market, and specific publishing and supply details of the product in that market.
 * Note Block 6 consists of all &lt;ProductSupply&gt; containers together &#9679; Modified cardinality of
 * &lt;SupplyDetail at revision 3.0 (2010)
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Product}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link ProductSupply}</li>
 * </ul>
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
                case SupplyDetail.refname:
                case SupplyDetail.shortname:
                    supplyDetails = JPU.addToList(supplyDetails, new SupplyDetail(e));
                    break;
                case MarketPublishingDetail.refname:
                case MarketPublishingDetail.shortname:
                    marketPublishingDetail = new MarketPublishingDetail(e);
                    break;
                case Market.refname:
                case Market.shortname:
                    markets = JPU.addToList(markets, new Market(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;ProductSupply&gt; or &lt;productsupply&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<ProductSupply> action) {
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

    private ListOfOnixComposite<SupplyDetail> supplyDetails = JPU.emptyListOfOnixComposite(SupplyDetail.class);

    /**
     * <p>
     * A group of data elements which together give details of a supply source, and price and availability from that
     * source. Mandatory in each occurrence of the &lt;ProductSupply&gt; block and repeatable to give details of
     * multiple supply sources.
     * </p>
     * JONIX adds: this list is required to contain at least one item
     */
    public ListOfOnixComposite<SupplyDetail> supplyDetails() {
        _initialize();
        return supplyDetails;
    }

    private MarketPublishingDetail marketPublishingDetail = MarketPublishingDetail.EMPTY;

    /**
     * <p>
     * A group of data elements which together give details of the publishing status of a product within a specified
     * market. Optional and non-repeating within an occurrence of the &lt;ProductSupply&gt; block.
     * </p>
     * JONIX adds: this field is optional
     */
    public MarketPublishingDetail marketPublishingDetail() {
        _initialize();
        return marketPublishingDetail;
    }

    private ListOfOnixComposite<Market> markets = JPU.emptyListOfOnixComposite(Market.class);

    /**
     * <p>
     * A group of data elements which together give details of a geographical territory and any non-geographical sales
     * restrictions that apply within it. Optional in terms of the schema definitions, but required in most ONIX
     * applications. If omitted, the geographical extent of the market must be assumed to be the area defined by the
     * sales rights.
     * </p>
     * <p>
     * The &lt;Market&gt; composite is repeatable, but in almost all cases only a single instance is required. It may be
     * repeated if a non-geographical sales restriction applies only to a <em>part</em> of a geographically-defined
     * market – for example where a product is sold throughout the European Union, but exclusive to a single retailer in
     * France.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixComposite<Market> markets() {
        _initialize();
        return markets;
    }
}
