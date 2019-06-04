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

package com.tectonica.jonix.onix2;

import com.tectonica.jonix.common.JPU;
import com.tectonica.jonix.common.ListOfOnixElement;
import com.tectonica.jonix.common.OnixComposite.OnixDataCompositeUncommon;
import com.tectonica.jonix.common.codelist.Countrys;
import com.tectonica.jonix.common.codelist.Languages;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.RightsRegions;
import com.tectonica.jonix.common.codelist.TextCaseFlags;
import com.tectonica.jonix.common.codelist.TextFormats;
import com.tectonica.jonix.common.codelist.TransliterationSchemes;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Sales rights composite</h1>
 * <p>
 * A repeatable group of data elements which together identify territorial sales rights which a publisher chooses to
 * exercise in a product. The &lt;SalesRights&gt; composite may occur once for each value of &lt;b089&gt;. See examples
 * at the end of Group&nbsp;PR.21.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;SalesRights&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;salesrights&gt;</tt></td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;Product&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>ONIXMessage ⯈ Product ⯈ SalesRights</li>
 * </ul>
 */
public class SalesRights implements OnixDataCompositeUncommon, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "SalesRights";
    public static final String shortname = "salesrights";

    /////////////////////////////////////////////////////////////////////////////////
    // ATTRIBUTES
    /////////////////////////////////////////////////////////////////////////////////

    public TextFormats textformat;

    public TextCaseFlags textcase;

    public Languages language;

    public TransliterationSchemes transliteration;

    /**
     * (type: DateOrDateTime)
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
    public static final SalesRights EMPTY = new SalesRights();

    public SalesRights() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public SalesRights(org.w3c.dom.Element element) {
        exists = true;
        initialized = false;
        this.element = element;
        textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));
        textcase = TextCaseFlags.byCode(JPU.getAttribute(element, "textcase"));
        language = Languages.byCode(JPU.getAttribute(element, "language"));
        transliteration = TransliterationSchemes.byCode(JPU.getAttribute(element, "transliteration"));
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
                case SalesRightsType.refname:
                case SalesRightsType.shortname:
                    salesRightsType = new SalesRightsType(e);
                    break;
                case RightsCountry.refname:
                case RightsCountry.shortname:
                    rightsCountrys = JPU.addToList(rightsCountrys, new RightsCountry(e));
                    break;
                case RightsTerritory.refname:
                case RightsTerritory.shortname:
                    rightsTerritory = new RightsTerritory(e);
                    break;
                case RightsRegion.refname:
                case RightsRegion.shortname:
                    rightsRegions = JPU.addToList(rightsRegions, new RightsRegion(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;SalesRights&gt; or &lt;salesrights&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private SalesRightsType salesRightsType = SalesRightsType.EMPTY;

    /**
     * <p>
     * An ONIX code which identifies the type of sales right or exclusion which applies in the territories which are
     * associated with it. Mandatory in each occurrence of the &lt;SalesRights&gt;composite, and non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public SalesRightsType salesRightsType() {
        _initialize();
        return salesRightsType;
    }

    private ListOfOnixElement<RightsCountry, java.util.Set<Countrys>> rightsCountrys = ListOfOnixElement.empty();

    /**
     * <p>
     * One or more ISO standard codes identifying a country. Successive codes may be separated by spaces. Thus, a single
     * occurrence of the element can carry an unlimited number of country codes, for countries that share the sales
     * rights specified in &lt;SalesRightsType&gt;. For upwards compatibility, the element remains repeatable, so that
     * multiple countries can also be listed as multiple occurrences of the whole element. At least one occurrence of
     * &lt;RightsCountry&gt; or &lt;RightsTerritory&gt; or &lt;RightsRegion&gt; is mandatory in any occurrence of
     * the&lt;SalesRights&gt; composite.
     * </p>
     * Jonix-Comment: this list is required to contain at least one item
     */
    public ListOfOnixElement<RightsCountry, java.util.Set<Countrys>> rightsCountrys() {
        _initialize();
        return rightsCountrys;
    }

    private RightsTerritory rightsTerritory = RightsTerritory.EMPTY;

    /**
     * <p>
     * One or more ONIX codes identifying a territory which is not a country, but which is precisely defined in
     * geographical terms, <em>eg</em> World, Northern Ireland, Australian National Territory. Successive codes are
     * separated by spaces, so that the element can carry an unlimited number of territory codes, for territories that
     * share the sales rights specified in &lt;SalesRightsType&gt;. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public RightsTerritory rightsTerritory() {
        _initialize();
        return rightsTerritory;
    }

    private ListOfOnixElement<RightsRegion, RightsRegions> rightsRegions = ListOfOnixElement.empty();

    /**
     * <p>
     * An ONIX code identifying a territorial market which cannot be described in terms of ISO country codes. Optional,
     * and repeatable for as many regions as share the sales rights specified in &lt;SalesRightsType&gt;.
     * <strong>Superseded by the new element &lt;RightsTerritory&gt; above, but retained for purposes of upwards
     * compatibility.</strong> See note on “Open Market” and “Airport” or “Airside” editions in the introduction to
     * Group&nbsp;PR.21.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<RightsRegion, RightsRegions> rightsRegions() {
        _initialize();
        return rightsRegions;
    }
}
