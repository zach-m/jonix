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
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Identifier value</h1><p>An identifier of the type specified in the &lt;ProductIDType&gt; element. Mandatory in
 * each occurrence of the &lt;ProductIdentifier&gt; composite, and non-repeating.</p><table border='1'
 * cellpadding='3'><tr><td>Format</td><td>According to the identifier type specified in
 * &lt;ProductIDType&gt;</td></tr><tr><td>Reference name</td><td><tt>&lt;IDValue&gt;</tt></td></tr><tr><td>Short
 * tag</td><td><tt>&lt;b244&gt;</tt></td></tr><tr><td>Example</td><td><tt>&lt;IDValue&gt;8474339790&lt;/IDValue&gt;</tt></td></tr></table>
 * <p>&nbsp;</p>
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
 * <p>&nbsp;</p>
 * Possible placements within ONIX message:
 * <ul>
 * <li>ONIXMessage ⯈ Product ⯈ WorkIdentifier ⯈ IDValue</li>
 * <li>ONIXMessage ⯈ Product ⯈ ContentItem ⯈ WorkIdentifier ⯈ IDValue</li>
 * <li>ONIXMessage ⯈ Product ⯈ MarketRepresentation ⯈ AgentIdentifier ⯈ IDValue</li>
 * <li>ONIXMessage ⯈ Product ⯈ Conference ⯈ ConferenceSponsor ⯈ ConferenceSponsorIdentifier ⯈ IDValue</li>
 * <li>ONIXMessage ⯈ SubSeriesRecord ⯈ SeriesIdentifier ⯈ IDValue</li>
 * <li>ONIXMessage ⯈ MainSeriesRecord ⯈ SeriesIdentifier ⯈ IDValue</li>
 * <li>ONIXMessage ⯈ Product ⯈ Series ⯈ SeriesIdentifier ⯈ IDValue</li>
 * <li>ONIXMessage ⯈ Product ⯈ ProductIdentifier ⯈ IDValue</li>
 * <li>ONIXMessage ⯈ Product ⯈ ContainedItem ⯈ ProductIdentifier ⯈ IDValue</li>
 * <li>ONIXMessage ⯈ Product ⯈ NotForSale ⯈ ProductIdentifier ⯈ IDValue</li>
 * <li>ONIXMessage ⯈ Product ⯈ RelatedProduct ⯈ ProductIdentifier ⯈ IDValue</li>
 * <li>ONIXMessage ⯈ Product ⯈ Set ⯈ ProductIdentifier ⯈ IDValue</li>
 * <li>ONIXMessage ⯈ Product ⯈ SupplyDetail ⯈ Stock ⯈ LocationIdentifier ⯈ IDValue</li>
 * <li>ONIXMessage ⯈ Header ⯈ SenderIdentifier ⯈ IDValue</li>
 * <li>ONIXMessage ⯈ Product ⯈ CopyrightStatement ⯈ CopyrightOwner ⯈ CopyrightOwnerIdentifier ⯈ IDValue</li>
 * <li>ONIXMessage ⯈ Product ⯈ ContentItem ⯈ TextItem ⯈ TextItemIdentifier ⯈ IDValue</li>
 * <li>ONIXMessage ⯈ Product ⯈ Contributor ⯈ Name ⯈ PersonNameIdentifier ⯈ IDValue</li>
 * <li>ONIXMessage ⯈ Product ⯈ ContentItem ⯈ Contributor ⯈ Name ⯈ PersonNameIdentifier ⯈ IDValue</li>
 * <li>ONIXMessage ⯈ SubSeriesRecord ⯈ Contributor ⯈ Name ⯈ PersonNameIdentifier ⯈ IDValue</li>
 * <li>ONIXMessage ⯈ MainSeriesRecord ⯈ Contributor ⯈ Name ⯈ PersonNameIdentifier ⯈ IDValue</li>
 * <li>ONIXMessage ⯈ Product ⯈ Series ⯈ Contributor ⯈ Name ⯈ PersonNameIdentifier ⯈ IDValue</li>
 * <li>ONIXMessage ⯈ Product ⯈ PersonAsSubject ⯈ Name ⯈ PersonNameIdentifier ⯈ IDValue</li>
 * <li>ONIXMessage ⯈ Product ⯈ ContentItem ⯈ PersonAsSubject ⯈ Name ⯈ PersonNameIdentifier ⯈ IDValue</li>
 * <li>ONIXMessage ⯈ Product ⯈ Contributor ⯈ PersonNameIdentifier ⯈ IDValue</li>
 * <li>ONIXMessage ⯈ Product ⯈ ContentItem ⯈ Contributor ⯈ PersonNameIdentifier ⯈ IDValue</li>
 * <li>ONIXMessage ⯈ SubSeriesRecord ⯈ Contributor ⯈ PersonNameIdentifier ⯈ IDValue</li>
 * <li>ONIXMessage ⯈ MainSeriesRecord ⯈ Contributor ⯈ PersonNameIdentifier ⯈ IDValue</li>
 * <li>ONIXMessage ⯈ Product ⯈ Series ⯈ Contributor ⯈ PersonNameIdentifier ⯈ IDValue</li>
 * <li>ONIXMessage ⯈ Product ⯈ PersonAsSubject ⯈ PersonNameIdentifier ⯈ IDValue</li>
 * <li>ONIXMessage ⯈ Product ⯈ ContentItem ⯈ PersonAsSubject ⯈ PersonNameIdentifier ⯈ IDValue</li>
 * <li>ONIXMessage ⯈ Product ⯈ SupplyDetail ⯈ SupplierIdentifier ⯈ IDValue</li>
 * <li>ONIXMessage ⯈ Product ⯈ SupplyDetail ⯈ NewSupplier ⯈ SupplierIdentifier ⯈ IDValue</li>
 * <li>ONIXMessage ⯈ Product ⯈ SalesRestriction ⯈ SalesOutlet ⯈ SalesOutletIdentifier ⯈ IDValue</li>
 * <li>ONIXMessage ⯈ SubSeriesRecord ⯈ ParentIdentifier ⯈ IDValue</li>
 * <li>ONIXMessage ⯈ Header ⯈ AddresseeIdentifier ⯈ IDValue</li>
 * </ul>
 */
public class IDValue implements OnixElement<String>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "IDValue";
    public static final String shortname = "b244";

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
     * Raw Format: According to the identifier type specified in &lt;ProductIDType&gt;<p> (type: NonEmptyString)
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
    public static final IDValue EMPTY = new IDValue();

    public IDValue() {
        exists = false;
    }

    public IDValue(org.w3c.dom.Element element) {
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
     * @return whether this tag (&lt;IDValue&gt; or &lt;b244&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }
}
