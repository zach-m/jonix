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
import com.tectonica.jonix.common.OnixElement;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.Regions;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Region code</h1>
 * <p>
 * An ONIX code identifying a region with which a contributor is particularly associated. Optional and non-repeatable.
 * There must be an occurrence of either the &lt;CountryCode&gt; or the &lt;RegionCode&gt; elements in each occurrence
 * of &lt;ContributorPlace&gt;. A region is an area which is not a country, but which is precisely defined in
 * geographical terms, <i>eg</i> Northern Ireland, Australian Capital Territory. If both country and region are
 * specified, the region must be within the country. Note that US States have region codes, while US overseas
 * territories have distinct ISO Country Codes.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Variable length code, consisting of upper case letters, with or without a hyphen and further upper case letters
 * or digits. Suggested maximum length 8 characters</td>
 * </tr>
 * <tr>
 * <td>Codelist</td>
 * <td>List 49 Where possible and appropriate, country subdivision codes are derived from the UN LOCODE scheme based on
 * ISO 3166-2</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;RegionCode&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;b398&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;1</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td><tt>&lt;RegionCode&gt;CA-NL&lt;/RegionCode&gt;</tt> (Newfoundland and Labrador)</td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link ContributorPlace}&gt;</li>
 * <li>&lt;{@link EventOccurrence}&gt;</li>
 * <li>&lt;{@link Language}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Contributor} ⯈ {@link ContributorPlace} ⯈
 * {@link RegionCode}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link Contributor} ⯈ {@link ContributorPlace} ⯈
 * {@link RegionCode}</li>
 * <li>{@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈ {@link Contributor} ⯈
 * {@link ContributorPlace} ⯈ {@link RegionCode}</li>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Collection} ⯈ {@link Contributor} ⯈ {@link ContributorPlace}
 * ⯈ {@link RegionCode}</li>
 * <li>{@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈ {@link EventOccurrence} ⯈
 * {@link RegionCode}</li>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Language} ⯈ {@link RegionCode}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link Language} ⯈ {@link RegionCode}</li>
 * </ul>
 */
public class RegionCode implements OnixElement<Regions>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "RegionCode";
    public static final String shortname = "b398";

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
    // VALUE MEMBER
    /////////////////////////////////////////////////////////////////////////////////

    public Regions value;

    /**
     * Internal API, use the {@link #value()} method or the {@link #value} field instead
     */
    @Override
    public Regions __v() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final RegionCode EMPTY = new RegionCode();

    public RegionCode() {
        exists = false;
    }

    public RegionCode(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcename = JPU.getAttribute(element, "sourcename");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));

        value = Regions.byCode(JPU.getContentAsString(element));
    }

    /**
     * @return whether this tag (&lt;RegionCode&gt; or &lt;b398&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<RegionCode> action) {
        if (exists) {
            action.accept(this);
        }
    }
}
