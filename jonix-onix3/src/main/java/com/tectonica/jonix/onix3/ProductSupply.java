/*
 * Copyright (C) 2012-2023 Zach Melamed
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
import com.tectonica.jonix.common.ListOfOnixComposite;
import com.tectonica.jonix.common.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Product supply composite</h1>
 * <p>
 * The product supply block covers data Groups P.24 to P.26, specifying a market, the publishing status and
 * representation detail of the product in that market, and the supply arrangements for the product in that market. The
 * &lt;ProductSupply&gt; composite is repeatable within the block to describe multiple markets. At least one occurrence
 * is expected in a &lt;Product&gt; record unless the &lt;NotificationType&gt; in Group&nbsp;P.1 indicates that the
 * record is a partial update notice which carries only those blocks in which changes have occurred.
 * </p>
 * <p>
 * Note that for many products with simple supply arrangements and a single market, many details of that market are
 * ‘inherited’ from Block&nbsp;4 and need not be repeated.
 * </p>
 * <p>
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
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Product}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductSupply}</li>
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
                case MarketReference.refname:
                case MarketReference.shortname:
                    marketReference = new MarketReference(e);
                    break;
                case MarketPublishingDetail.refname:
                case MarketPublishingDetail.shortname:
                    marketPublishingDetail = new MarketPublishingDetail(e);
                    break;
                case Market.refname:
                case Market.shortname:
                    markets = JPU.addToList(markets, new Market(e));
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

    /**
     * @return whether this tag (&lt;ProductSupply&gt; or &lt;productsupply&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    @Override
    public org.w3c.dom.Element getXmlElement() {
        return element;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private MarketReference marketReference = MarketReference.EMPTY;

    /**
     * <p>
     * For every market, a single market reference which will uniquely identify the &lt;ProductSupply&gt; composite
     * which describes the market within this Product record, and which will remain as its permanent identifier every
     * time you send an update.
     * </p>
     * <p>
     * The Market reference is optional and non-repeating, but it is strongly recommended unless there is only a single
     * market. It is intended to be used to label each repeat of &lt;ProductSupply&gt; for use in subsequent partial
     * updates and reporting.
     * </p>
     * <p>
     * Note that the scope of the Market reference is limited to a single Product record –&nbsp;a geographically
     * identical market for a different product may have a different Market reference, and a geographically different
     * market in another Product record may use the same reference.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public MarketReference marketReference() {
        _initialize();
        return marketReference;
    }

    private MarketPublishingDetail marketPublishingDetail = MarketPublishingDetail.EMPTY;

    /**
     * <p>
     * A group of data elements which together give details of the publishing status of a product within a specified
     * market. Optional and non-repeating within an occurrence of the &lt;ProductSupply&gt; block.
     * </p>
     * Jonix-Comment: this field is optional
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
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixComposite<Market> markets() {
        _initialize();
        return markets;
    }

    private ListOfOnixComposite<SupplyDetail> supplyDetails = JPU.emptyListOfOnixComposite(SupplyDetail.class);

    /**
     * <p>
     * A group of data elements which together give details of a supply source, and price and availability from that
     * source. Mandatory in each ordinary occurrence of the &lt;ProductSupply&gt; block, and repeatable to give details
     * of multiple supply sources.
     * </p>
     * <p>
     * Exceptionally, &lt;SupplyDetail&gt; may be omitted only within a partial or ‘block update’ (Notification or
     * update type 04, see P.1.2) where a &lt;MarketReference&gt; is supplied, when the intention is to remove all
     * previously-supplied Supply details for the referenced market (for example when one market is being merged into
     * another).
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixComposite<SupplyDetail> supplyDetails() {
        _initialize();
        return supplyDetails;
    }
}
