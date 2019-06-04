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
import com.tectonica.jonix.common.OnixElement;
import com.tectonica.jonix.common.codelist.Languages;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.TextCaseFlags;
import com.tectonica.jonix.common.codelist.TextFormats;
import com.tectonica.jonix.common.codelist.TransliterationSchemes;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Identifier type name</h1>
 * <p>
 * A name which identifies a proprietary identifier scheme when, and only when, the code in the &lt;ProductIDType&gt;
 * element indicates a proprietary scheme, <em>eg</em> a wholesaler’s own code. Optional and non-repeating.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Free text, suggested maximum length 50 characters</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;IDTypeName&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;b233&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td><tt>&lt;b233&gt;KNO&lt;/b233&gt;</tt></td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;WorkIdentifier&gt;</li>
 * <li>&lt;AgentIdentifier&gt;</li>
 * <li>&lt;ConferenceSponsorIdentifier&gt;</li>
 * <li>&lt;SeriesIdentifier&gt;</li>
 * <li>&lt;ProductIdentifier&gt;</li>
 * <li>&lt;LocationIdentifier&gt;</li>
 * <li>&lt;SenderIdentifier&gt;</li>
 * <li>&lt;CopyrightOwnerIdentifier&gt;</li>
 * <li>&lt;TextItemIdentifier&gt;</li>
 * <li>&lt;PersonNameIdentifier&gt;</li>
 * <li>&lt;SupplierIdentifier&gt;</li>
 * <li>&lt;SalesOutletIdentifier&gt;</li>
 * <li>&lt;ParentIdentifier&gt;</li>
 * <li>&lt;AddresseeIdentifier&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>ONIXMessage ⯈ Product ⯈ WorkIdentifier ⯈ IDTypeName</li>
 * <li>ONIXMessage ⯈ Product ⯈ ContentItem ⯈ WorkIdentifier ⯈ IDTypeName</li>
 * <li>ONIXMessage ⯈ Product ⯈ MarketRepresentation ⯈ AgentIdentifier ⯈ IDTypeName</li>
 * <li>ONIXMessage ⯈ Product ⯈ Conference ⯈ ConferenceSponsor ⯈ ConferenceSponsorIdentifier ⯈ IDTypeName</li>
 * <li>ONIXMessage ⯈ SubSeriesRecord ⯈ SeriesIdentifier ⯈ IDTypeName</li>
 * <li>ONIXMessage ⯈ MainSeriesRecord ⯈ SeriesIdentifier ⯈ IDTypeName</li>
 * <li>ONIXMessage ⯈ Product ⯈ Series ⯈ SeriesIdentifier ⯈ IDTypeName</li>
 * <li>ONIXMessage ⯈ Product ⯈ ProductIdentifier ⯈ IDTypeName</li>
 * <li>ONIXMessage ⯈ Product ⯈ ContainedItem ⯈ ProductIdentifier ⯈ IDTypeName</li>
 * <li>ONIXMessage ⯈ Product ⯈ NotForSale ⯈ ProductIdentifier ⯈ IDTypeName</li>
 * <li>ONIXMessage ⯈ Product ⯈ RelatedProduct ⯈ ProductIdentifier ⯈ IDTypeName</li>
 * <li>ONIXMessage ⯈ Product ⯈ Set ⯈ ProductIdentifier ⯈ IDTypeName</li>
 * <li>ONIXMessage ⯈ Product ⯈ SupplyDetail ⯈ Stock ⯈ LocationIdentifier ⯈ IDTypeName</li>
 * <li>ONIXMessage ⯈ Header ⯈ SenderIdentifier ⯈ IDTypeName</li>
 * <li>ONIXMessage ⯈ Product ⯈ CopyrightStatement ⯈ CopyrightOwner ⯈ CopyrightOwnerIdentifier ⯈ IDTypeName</li>
 * <li>ONIXMessage ⯈ Product ⯈ ContentItem ⯈ TextItem ⯈ TextItemIdentifier ⯈ IDTypeName</li>
 * <li>ONIXMessage ⯈ Product ⯈ Contributor ⯈ Name ⯈ PersonNameIdentifier ⯈ IDTypeName</li>
 * <li>ONIXMessage ⯈ Product ⯈ ContentItem ⯈ Contributor ⯈ Name ⯈ PersonNameIdentifier ⯈ IDTypeName</li>
 * <li>ONIXMessage ⯈ SubSeriesRecord ⯈ Contributor ⯈ Name ⯈ PersonNameIdentifier ⯈ IDTypeName</li>
 * <li>ONIXMessage ⯈ MainSeriesRecord ⯈ Contributor ⯈ Name ⯈ PersonNameIdentifier ⯈ IDTypeName</li>
 * <li>ONIXMessage ⯈ Product ⯈ Series ⯈ Contributor ⯈ Name ⯈ PersonNameIdentifier ⯈ IDTypeName</li>
 * <li>ONIXMessage ⯈ Product ⯈ PersonAsSubject ⯈ Name ⯈ PersonNameIdentifier ⯈ IDTypeName</li>
 * <li>ONIXMessage ⯈ Product ⯈ ContentItem ⯈ PersonAsSubject ⯈ Name ⯈ PersonNameIdentifier ⯈ IDTypeName</li>
 * <li>ONIXMessage ⯈ Product ⯈ Contributor ⯈ PersonNameIdentifier ⯈ IDTypeName</li>
 * <li>ONIXMessage ⯈ Product ⯈ ContentItem ⯈ Contributor ⯈ PersonNameIdentifier ⯈ IDTypeName</li>
 * <li>ONIXMessage ⯈ SubSeriesRecord ⯈ Contributor ⯈ PersonNameIdentifier ⯈ IDTypeName</li>
 * <li>ONIXMessage ⯈ MainSeriesRecord ⯈ Contributor ⯈ PersonNameIdentifier ⯈ IDTypeName</li>
 * <li>ONIXMessage ⯈ Product ⯈ Series ⯈ Contributor ⯈ PersonNameIdentifier ⯈ IDTypeName</li>
 * <li>ONIXMessage ⯈ Product ⯈ PersonAsSubject ⯈ PersonNameIdentifier ⯈ IDTypeName</li>
 * <li>ONIXMessage ⯈ Product ⯈ ContentItem ⯈ PersonAsSubject ⯈ PersonNameIdentifier ⯈ IDTypeName</li>
 * <li>ONIXMessage ⯈ Product ⯈ SupplyDetail ⯈ SupplierIdentifier ⯈ IDTypeName</li>
 * <li>ONIXMessage ⯈ Product ⯈ SupplyDetail ⯈ NewSupplier ⯈ SupplierIdentifier ⯈ IDTypeName</li>
 * <li>ONIXMessage ⯈ Product ⯈ SalesRestriction ⯈ SalesOutlet ⯈ SalesOutletIdentifier ⯈ IDTypeName</li>
 * <li>ONIXMessage ⯈ SubSeriesRecord ⯈ ParentIdentifier ⯈ IDTypeName</li>
 * <li>ONIXMessage ⯈ Header ⯈ AddresseeIdentifier ⯈ IDTypeName</li>
 * </ul>
 */
public class IDTypeName implements OnixElement<String>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "IDTypeName";
    public static final String shortname = "b233";

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

    /**
     * Raw Format: Free text, suggested maximum length 50 characters
     * <p>
     * (type: NonEmptyString)
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
    public static final IDTypeName EMPTY = new IDTypeName();

    public IDTypeName() {
        exists = false;
    }

    public IDTypeName(org.w3c.dom.Element element) {
        exists = true;
        textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));
        textcase = TextCaseFlags.byCode(JPU.getAttribute(element, "textcase"));
        language = Languages.byCode(JPU.getAttribute(element, "language"));
        transliteration = TransliterationSchemes.byCode(JPU.getAttribute(element, "transliteration"));
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        value = JPU.getContentAsString(element);
    }

    /**
     * @return whether this tag (&lt;IDTypeName&gt; or &lt;b233&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }
}
