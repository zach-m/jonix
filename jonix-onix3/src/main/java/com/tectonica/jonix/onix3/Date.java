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
import com.tectonica.jonix.common.OnixElement;
import com.tectonica.jonix.common.codelist.DateFormats;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Date</h1>
 * <p>
 * The date specified in the &lt;EpubLicenseDateRole&gt; field. Mandatory in each occurrence of the
 * &lt;EpubLicenseDate&gt; composite, and non-repeating. &lt;Date&gt; may carry a <i>dateformat</i> attribute: if the
 * attribute is missing, then the default format is YYYYMMDD.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>As specified by the value in the dateformat attribute, or the default YYYYMMDD</td>
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
 * <td><tt>&lt;Date&gt;20221028&lt;/Date&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Notes</td>
 * <td>Note that all dates are inclusive, so 'Valid from' is the first date on which the license is effective, and
 * 'Valid until' is the last date on which it is effective.</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;Date&gt; from the schema author:
 *
 * Date on which a particular event of the type specified in the preceding date role happens &#9679; Added dateformat
 * attribute at revision 3.0 (2010)
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link PublishingDate}&gt;</li>
 * <li>&lt;{@link SupplyDate}&gt;</li>
 * <li>&lt;{@link MarketDate}&gt;</li>
 * <li>&lt;{@link ContributorDate}&gt;</li>
 * <li>&lt;{@link ContentDate}&gt;</li>
 * <li>&lt;{@link SubjectDate}&gt;</li>
 * <li>&lt;{@link ResourceFileDate}&gt;</li>
 * <li>&lt;{@link PriceDate}&gt;</li>
 * <li>&lt;{@link OccurrenceDate}&gt;</li>
 * <li>&lt;{@link EpubLicenseDate}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link PublishingDetail} ⯈ {@link PublishingDate} ⯈ {@link Date}</li>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link SupplyDate} ⯈ {@link Date}</li>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link MarketPublishingDetail} ⯈ {@link MarketDate} ⯈ {@link Date}</li>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Contributor} ⯈ {@link ContributorDate} ⯈ {@link Date}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link Contributor} ⯈ {@link ContributorDate} ⯈
 * {@link Date}</li>
 * <li>{@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈ {@link Contributor} ⯈
 * {@link ContributorDate} ⯈ {@link Date}</li>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Collection} ⯈ {@link Contributor} ⯈ {@link ContributorDate}
 * ⯈ {@link Date}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link TextContent} ⯈ {@link ContentDate} ⯈
 * {@link Date}</li>
 * <li>{@link Product} ⯈ {@link CollateralDetail} ⯈ {@link TextContent} ⯈ {@link ContentDate} ⯈ {@link Date}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link CitedContent} ⯈ {@link ContentDate} ⯈
 * {@link Date}</li>
 * <li>{@link Product} ⯈ {@link CollateralDetail} ⯈ {@link CitedContent} ⯈ {@link ContentDate} ⯈ {@link Date}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link SupportingResource} ⯈
 * {@link ResourceVersion} ⯈ {@link ContentDate} ⯈ {@link Date}</li>
 * <li>{@link Product} ⯈ {@link CollateralDetail} ⯈ {@link SupportingResource} ⯈ {@link ResourceVersion} ⯈
 * {@link ContentDate} ⯈ {@link Date}</li>
 * <li>{@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈ {@link EventOccurrence} ⯈
 * {@link SupportingResource} ⯈ {@link ResourceVersion} ⯈ {@link ContentDate} ⯈ {@link Date}</li>
 * <li>{@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈ {@link SupportingResource} ⯈
 * {@link ResourceVersion} ⯈ {@link ContentDate} ⯈ {@link Date}</li>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link NameAsSubject} ⯈ {@link SubjectDate} ⯈ {@link Date}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link NameAsSubject} ⯈ {@link SubjectDate} ⯈
 * {@link Date}</li>
 * <li>{@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link SupplementManifest} ⯈
 * {@link CoverManifest} ⯈ {@link CoverResource} ⯈ {@link ResourceFileDate} ⯈ {@link Date}</li>
 * <li>{@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link CoverManifest} ⯈
 * {@link CoverResource} ⯈ {@link ResourceFileDate} ⯈ {@link Date}</li>
 * <li>{@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link SupplementManifest} ⯈
 * {@link BodyManifest} ⯈ {@link BodyResource} ⯈ {@link ResourceFileDate} ⯈ {@link Date}</li>
 * <li>{@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link BodyManifest} ⯈
 * {@link BodyResource} ⯈ {@link ResourceFileDate} ⯈ {@link Date}</li>
 * <li>{@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link SupplementManifest} ⯈
 * {@link InsertManifest} ⯈ {@link InsertResource} ⯈ {@link ResourceFileDate} ⯈ {@link Date}</li>
 * <li>{@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link InsertManifest} ⯈
 * {@link InsertResource} ⯈ {@link ResourceFileDate} ⯈ {@link Date}</li>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Price} ⯈ {@link PriceDate} ⯈
 * {@link Date}</li>
 * <li>{@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈ {@link EventOccurrence} ⯈
 * {@link OccurrenceDate} ⯈ {@link Date}</li>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link EpubLicenseWithDateType} ⯈ {@link EpubLicenseDate} ⯈
 * {@link Date}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link EpubLicenseWithDateType} ⯈
 * {@link EpubLicenseDate} ⯈ {@link Date}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link TextContent} ⯈
 * {@link EpubLicenseWithDateType} ⯈ {@link EpubLicenseDate} ⯈ {@link Date}</li>
 * <li>{@link Product} ⯈ {@link CollateralDetail} ⯈ {@link TextContent} ⯈ {@link EpubLicenseWithDateType} ⯈
 * {@link EpubLicenseDate} ⯈ {@link Date}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link SupportingResource} ⯈
 * {@link ResourceVersion} ⯈ {@link EpubLicenseWithDateType} ⯈ {@link EpubLicenseDate} ⯈ {@link Date}</li>
 * <li>{@link Product} ⯈ {@link CollateralDetail} ⯈ {@link SupportingResource} ⯈ {@link ResourceVersion} ⯈
 * {@link EpubLicenseWithDateType} ⯈ {@link EpubLicenseDate} ⯈ {@link Date}</li>
 * <li>{@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈ {@link EventOccurrence} ⯈
 * {@link SupportingResource} ⯈ {@link ResourceVersion} ⯈ {@link EpubLicenseWithDateType} ⯈ {@link EpubLicenseDate} ⯈
 * {@link Date}</li>
 * <li>{@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈ {@link SupportingResource} ⯈
 * {@link ResourceVersion} ⯈ {@link EpubLicenseWithDateType} ⯈ {@link EpubLicenseDate} ⯈ {@link Date}</li>
 * </ul>
 *
 * @since Onix-3.10
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

    /**
     * (type: dt.NonEmptyString)
     */
    public String sourcename;

    public RecordSourceTypes sourcetype;

    public DateFormats dateformat;

    /////////////////////////////////////////////////////////////////////////////////
    // VALUE MEMBER
    /////////////////////////////////////////////////////////////////////////////////

    /**
     * This is the raw content of Date. Could be null if {@code exists() == false}. Use {@link #value()} instead if you
     * want to get this as an {@link java.util.Optional}.
     * <p>
     * Raw Format: As specified by the value in the dateformat attribute, or the default YYYYMMDD
     * <p>
     * (type: dt.NonEmptyString)
     */
    public String value;

    /**
     * Internal API, use the {@link #value()} method or the {@link #value} field instead
     */
    @Override
    public String __v() {
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
        sourcename = JPU.getAttribute(element, "sourcename");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
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

    public void ifExists(Consumer<Date> action) {
        if (exists) {
            action.accept(this);
        }
    }
}
