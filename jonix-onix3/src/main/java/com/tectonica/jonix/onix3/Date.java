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
 * <h1>Date</h1>
 * <p>
 * The date specified in the &lt;ContributorDateRole&gt; field. Mandatory in each occurrence of the
 * &lt;ContributorDate&gt; composite, and non-repeating. &lt;Date&gt; may carry a <i>dateformat</i> attribute: if the
 * attribute is missing, then &lt;DateFormat&gt; indicates the format of the date; if both <i>dateformat</i> attribute
 * and &lt;DateFormat&gt; element are missing, the default format is YYYYMMDD.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>As specified by the value in the dateformat attribute, in &lt;DateFormat&gt;, or the default YYYYMMDD</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;Date&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;b306&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>1</td>
 * </tr>
 * <tr>
 * <td>Attributes</td>
 * <td>dateformat</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td><tt>&lt;Date&gt;20010106&lt;/Date&gt;</tt></td>
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
 * <li>ONIXMessage ⯈ Product ⯈ PublishingDetail ⯈ PublishingDate ⯈ Date</li>
 * <li>ONIXMessage ⯈ Product ⯈ ProductSupply ⯈ SupplyDetail ⯈ SupplyDate ⯈ Date</li>
 * <li>ONIXMessage ⯈ Product ⯈ ProductSupply ⯈ MarketPublishingDetail ⯈ MarketDate ⯈ Date</li>
 * <li>ONIXMessage ⯈ Product ⯈ DescriptiveDetail ⯈ Contributor ⯈ ContributorDate ⯈ Date</li>
 * <li>ONIXMessage ⯈ Product ⯈ ContentDetail ⯈ ContentItem ⯈ Contributor ⯈ ContributorDate ⯈ Date</li>
 * <li>ONIXMessage ⯈ Product ⯈ DescriptiveDetail ⯈ Collection ⯈ Contributor ⯈ ContributorDate ⯈ Date</li>
 * <li>ONIXMessage ⯈ Product ⯈ ContentDetail ⯈ ContentItem ⯈ TextContent ⯈ ContentDate ⯈ Date</li>
 * <li>ONIXMessage ⯈ Product ⯈ CollateralDetail ⯈ TextContent ⯈ ContentDate ⯈ Date</li>
 * <li>ONIXMessage ⯈ Product ⯈ ContentDetail ⯈ ContentItem ⯈ CitedContent ⯈ ContentDate ⯈ Date</li>
 * <li>ONIXMessage ⯈ Product ⯈ CollateralDetail ⯈ CitedContent ⯈ ContentDate ⯈ Date</li>
 * <li>ONIXMessage ⯈ Product ⯈ ContentDetail ⯈ ContentItem ⯈ SupportingResource ⯈ ResourceVersion ⯈ ContentDate ⯈
 * Date</li>
 * <li>ONIXMessage ⯈ Product ⯈ CollateralDetail ⯈ SupportingResource ⯈ ResourceVersion ⯈ ContentDate ⯈ Date</li>
 * <li>ONIXMessage ⯈ Product ⯈ ProductSupply ⯈ SupplyDetail ⯈ Reissue ⯈ SupportingResource ⯈ ResourceVersion ⯈
 * ContentDate ⯈ Date</li>
 * <li>ONIXMessage ⯈ Product ⯈ DescriptiveDetail ⯈ NameAsSubject ⯈ SubjectDate ⯈ Date</li>
 * <li>ONIXMessage ⯈ Product ⯈ ContentDetail ⯈ ContentItem ⯈ NameAsSubject ⯈ SubjectDate ⯈ Date</li>
 * <li>ONIXMessage ⯈ Product ⯈ ProductSupply ⯈ SupplyDetail ⯈ Reissue ⯈ Price ⯈ PriceDate ⯈ Date</li>
 * <li>ONIXMessage ⯈ Product ⯈ ProductSupply ⯈ SupplyDetail ⯈ Price ⯈ PriceDate ⯈ Date</li>
 * </ul>
 */
public class Date implements OnixElement<String>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Date";
    public static final String shortname = "b306";

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

    public DateFormats dateformat;

    /////////////////////////////////////////////////////////////////////////////////
    // VALUE MEMBER
    /////////////////////////////////////////////////////////////////////////////////

    /**
     * Raw Format: As specified by the value in the dateformat attribute, in &lt;DateFormat&gt;, or the default
     * YYYYMMDD
     * <p>
     * (type: dt.NonEmptyString)
     */
    public String value;

    /**
     * Internal API, use the {@link #value()} method or the {@link #value} field instead
     */
    @Override
    public String _value() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final Date EMPTY = new Date();

    public Date() {
        exists = false;
    }

    public Date(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");
        dateformat = DateFormats.byCode(JPU.getAttribute(element, "dateformat"));

        value = JPU.getContentAsString(element);
    }

    /**
     * @return whether this tag (&lt;Date&gt; or &lt;b306&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }
}
