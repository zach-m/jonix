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
import com.tectonica.jonix.codelist.PublishingDateRoles;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixMarketDate;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Market date composite</h1><p>A group of data elements which together specify a date associated with the
 * publishing status of the product in a specified market, <i>eg</i> ‘local publication date’. Optional, but if known, a
 * date of publication <em>must</em> be specified either here as a ‘local pubdate’ or in P.20. Other dates relating to
 * the publication of the product in the specific market may be sent in further repeats of the composite.</p><table
 * border='1' cellpadding='3'><tr><td>Reference name</td><td><tt>&lt;MarketDate&gt;</tt></td></tr><tr><td>Short
 * tag</td><td><tt>&lt;marketdate&gt;</tt></td></tr><tr><td>Cardinality</td><td>0&#8230;n</td></tr></table>
 * <p>&nbsp;</p>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;MarketPublishingDetail&gt;</li>
 * </ul>
 * <p>&nbsp;</p>
 * Possible placements within ONIX message:
 * <ul>
 * <li>ONIXMessage ⯈ Product ⯈ ProductSupply ⯈ MarketPublishingDetail ⯈ MarketDate</li>
 * </ul>
 */
public class MarketDate implements OnixDataCompositeWithKey<JonixMarketDate, PublishingDateRoles>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "MarketDate";
    public static final String shortname = "marketdate";

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
    public static final MarketDate EMPTY = new MarketDate();

    public MarketDate() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public MarketDate(org.w3c.dom.Element element) {
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
                case MarketDateRole.refname:
                case MarketDateRole.shortname:
                    marketDateRole = new MarketDateRole(e);
                    break;
                case DateFormat.refname:
                case DateFormat.shortname:
                    dateFormat = new DateFormat(e);
                    break;
                case Date.refname:
                case Date.shortname:
                    date = new Date(e);
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;MarketDate&gt; or &lt;marketdate&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private MarketDateRole marketDateRole = MarketDateRole.EMPTY;

    /**
     * <p>An ONIX code indicating the significance of the date. Mandatory in each occurrence of the &lt;MarketDate&gt;
     * composite, and non-repeating.</p>
     * Jonix-Comment: this field is required
     */
    public MarketDateRole marketDateRole() {
        _initialize();
        return marketDateRole;
    }

    private DateFormat dateFormat = DateFormat.EMPTY;

    /**
     * <p>An ONIX code indicating the format in which the date is given in &lt;Date&gt;. Optional in each occurrence of
     * the &lt;MarketDate&gt; composite, and non-repeating. Deprecated – where possible, use the <i>dateformat</i>
     * attribute instead.</p>
     * Jonix-Comment: this field is optional
     */
    public DateFormat dateFormat() {
        _initialize();
        return dateFormat;
    }

    private Date date = Date.EMPTY;

    /**
     * <p>The date specified in the &lt;MarketDateRole&gt; field. Mandatory in each occurrence of the &lt;MarketDate&gt;
     * composite, and non-repeating. &lt;Date&gt; may carry a <i>dateformat</i> attribute: if the attribute is missing,
     * then &lt;DateFormat&gt; indicates the format of the date; if both <i>dateformat</i> attribute and
     * &lt;DateFormat&gt; element are missing, the default format is YYYYMMDD.</p>
     * Jonix-Comment: this field is required
     */
    public Date date() {
        _initialize();
        return date;
    }

    @Override
    public JonixMarketDate asStruct() {
        _initialize();
        JonixMarketDate struct = new JonixMarketDate();
        struct.marketDateRole = marketDateRole.value;
        struct.date = date.value;
        struct.dateFormat = dateFormat.value;
        return struct;
    }

    @Override
    public PublishingDateRoles structKey() {
        return marketDateRole().value;
    }
}
