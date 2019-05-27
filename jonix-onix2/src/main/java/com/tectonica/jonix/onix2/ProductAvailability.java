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

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.OnixElement;
import com.tectonica.jonix.codelist.Languages;
import com.tectonica.jonix.codelist.ProductAvailabilitys;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Product availability</h1>
 * <p>
 * An ONIX code indicating the availability of a product from a supplier. This element has been added as a preferred
 * successor to the &lt;AvailabilityCode&gt; element, and is intended to be used both by publishers (who should also
 * include the new &lt;PublishingStatus&gt; element in PR.20) and by intermediary suppliers (who may also include
 * &lt;PublishingStatus&gt; if they are in a position to do so. Each occurrence of the &lt;SupplyDetail&gt; composite
 * must carry either &lt;AvailabilityCode&gt; or &lt;ProductAvailability&gt;, or both. The element is non-repeating.
 * Recommended practise is in future to use this new element, and, where possible and appropriate, to include the
 * &lt;PublishingStatus&gt; element in PR.20. It is likely that the &lt;AvailabilityCode&gt; element will be
 * “deprecated” in due course in a future release.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Fixed-length, two numeric digits</td>
 * </tr>
 * <tr>
 * <td>Codelist</td>
 * <td>List 65</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;ProductAvailability&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;j396&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td><tt>&lt;j396&gt;41&lt;/j396&gt;</tt> Replaced by new product</td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;SupplyDetail&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>ONIXMessage ⯈ Product ⯈ SupplyDetail ⯈ ProductAvailability</li>
 * </ul>
 */
public class ProductAvailability implements OnixElement<ProductAvailabilitys>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "ProductAvailability";
    public static final String shortname = "j396";

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
    // VALUE MEMBER
    /////////////////////////////////////////////////////////////////////////////////

    public ProductAvailabilitys value;

    /**
     * Internal API, use the {@link #value()} method or the {@link #value} field instead
     */
    @Override
    public ProductAvailabilitys _value() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final ProductAvailability EMPTY = new ProductAvailability();

    public ProductAvailability() {
        exists = false;
    }

    public ProductAvailability(org.w3c.dom.Element element) {
        exists = true;
        textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));
        textcase = TextCaseFlags.byCode(JPU.getAttribute(element, "textcase"));
        language = Languages.byCode(JPU.getAttribute(element, "language"));
        transliteration = TransliterationSchemes.byCode(JPU.getAttribute(element, "transliteration"));
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        value = ProductAvailabilitys.byCode(JPU.getContentAsString(element));
    }

    /**
     * @return whether this tag (&lt;ProductAvailability&gt; or &lt;j396&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }
}
