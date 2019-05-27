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
import com.tectonica.jonix.OnixElement;
import com.tectonica.jonix.codelist.DateFormats;
import com.tectonica.jonix.codelist.RecordSourceTypes;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Date format</h1>
 * <p>
 * An ONIX code indicating the format in which the date is given in &lt;Date&gt;. Optional and not repeatable.
 * Deprecated – where possible, use the <i>dateformat</i> attribute instead.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Fixed length, two digits</td>
 * </tr>
 * <tr>
 * <td>Codelist</td>
 * <td>List 55</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;DateFormat&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;j260&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;1</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td><tt>&lt;DateFormat&gt;05&lt;/DateFormat&gt;</tt> (YYYY)</td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;PublishingDate&gt;</li>
 * <li>&lt;SupplyDate&gt;</li>
 * <li>&lt;MarketDate&gt;</li>
 * <li>&lt;ContributorDate&gt;</li>
 * <li>&lt;ContentDate&gt;</li>
 * <li>&lt;SubjectDate&gt;</li>
 * <li>&lt;PriceDate&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>ONIXMessage ⯈ Product ⯈ PublishingDetail ⯈ PublishingDate ⯈ DateFormat</li>
 * <li>ONIXMessage ⯈ Product ⯈ ProductSupply ⯈ SupplyDetail ⯈ SupplyDate ⯈ DateFormat</li>
 * <li>ONIXMessage ⯈ Product ⯈ ProductSupply ⯈ MarketPublishingDetail ⯈ MarketDate ⯈ DateFormat</li>
 * <li>ONIXMessage ⯈ Product ⯈ DescriptiveDetail ⯈ Contributor ⯈ ContributorDate ⯈ DateFormat</li>
 * <li>ONIXMessage ⯈ Product ⯈ ContentDetail ⯈ ContentItem ⯈ Contributor ⯈ ContributorDate ⯈ DateFormat</li>
 * <li>ONIXMessage ⯈ Product ⯈ DescriptiveDetail ⯈ Collection ⯈ Contributor ⯈ ContributorDate ⯈ DateFormat</li>
 * <li>ONIXMessage ⯈ Product ⯈ ContentDetail ⯈ ContentItem ⯈ TextContent ⯈ ContentDate ⯈ DateFormat</li>
 * <li>ONIXMessage ⯈ Product ⯈ CollateralDetail ⯈ TextContent ⯈ ContentDate ⯈ DateFormat</li>
 * <li>ONIXMessage ⯈ Product ⯈ ContentDetail ⯈ ContentItem ⯈ CitedContent ⯈ ContentDate ⯈ DateFormat</li>
 * <li>ONIXMessage ⯈ Product ⯈ CollateralDetail ⯈ CitedContent ⯈ ContentDate ⯈ DateFormat</li>
 * <li>ONIXMessage ⯈ Product ⯈ ContentDetail ⯈ ContentItem ⯈ SupportingResource ⯈ ResourceVersion ⯈ ContentDate ⯈
 * DateFormat</li>
 * <li>ONIXMessage ⯈ Product ⯈ CollateralDetail ⯈ SupportingResource ⯈ ResourceVersion ⯈ ContentDate ⯈ DateFormat</li>
 * <li>ONIXMessage ⯈ Product ⯈ ProductSupply ⯈ SupplyDetail ⯈ Reissue ⯈ SupportingResource ⯈ ResourceVersion ⯈
 * ContentDate ⯈ DateFormat</li>
 * <li>ONIXMessage ⯈ Product ⯈ DescriptiveDetail ⯈ NameAsSubject ⯈ SubjectDate ⯈ DateFormat</li>
 * <li>ONIXMessage ⯈ Product ⯈ ContentDetail ⯈ ContentItem ⯈ NameAsSubject ⯈ SubjectDate ⯈ DateFormat</li>
 * <li>ONIXMessage ⯈ Product ⯈ ProductSupply ⯈ SupplyDetail ⯈ Reissue ⯈ Price ⯈ PriceDate ⯈ DateFormat</li>
 * <li>ONIXMessage ⯈ Product ⯈ ProductSupply ⯈ SupplyDetail ⯈ Price ⯈ PriceDate ⯈ DateFormat</li>
 * </ul>
 */
public class DateFormat implements OnixElement<DateFormats>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "DateFormat";
    public static final String shortname = "j260";

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
    // VALUE MEMBER
    /////////////////////////////////////////////////////////////////////////////////

    public DateFormats value;

    /**
     * Internal API, use the {@link #value()} method or the {@link #value} field instead
     */
    @Override
    public DateFormats _value() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final DateFormat EMPTY = new DateFormat();

    public DateFormat() {
        exists = false;
    }

    public DateFormat(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        value = DateFormats.byCode(JPU.getContentAsString(element));
    }

    /**
     * @return whether this tag (&lt;DateFormat&gt; or &lt;j260&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }
}
