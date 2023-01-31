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
 * <li>&lt;{@link WorkIdentifier}&gt;</li>
 * <li>&lt;{@link AgentIdentifier}&gt;</li>
 * <li>&lt;{@link ConferenceSponsorIdentifier}&gt;</li>
 * <li>&lt;{@link SeriesIdentifier}&gt;</li>
 * <li>&lt;{@link ProductIdentifier}&gt;</li>
 * <li>&lt;{@link LocationIdentifier}&gt;</li>
 * <li>&lt;{@link SenderIdentifier}&gt;</li>
 * <li>&lt;{@link CopyrightOwnerIdentifier}&gt;</li>
 * <li>&lt;{@link TextItemIdentifier}&gt;</li>
 * <li>&lt;{@link PersonNameIdentifier}&gt;</li>
 * <li>&lt;{@link SupplierIdentifier}&gt;</li>
 * <li>&lt;{@link SalesOutletIdentifier}&gt;</li>
 * <li>&lt;{@link ParentIdentifier}&gt;</li>
 * <li>&lt;{@link AddresseeIdentifier}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link WorkIdentifier} ⯈ {@link IDTypeName}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ContentItem} ⯈ {@link WorkIdentifier} ⯈ {@link IDTypeName}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link MarketRepresentation} ⯈ {@link AgentIdentifier} ⯈
 * {@link IDTypeName}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link Conference} ⯈ {@link ConferenceSponsor} ⯈
 * {@link ConferenceSponsorIdentifier} ⯈ {@link IDTypeName}</li>
 * <li>{@link ONIXMessage} ⯈ {@link SubSeriesRecord} ⯈ {@link SeriesIdentifier} ⯈ {@link IDTypeName}</li>
 * <li>{@link ONIXMessage} ⯈ {@link MainSeriesRecord} ⯈ {@link SeriesIdentifier} ⯈ {@link IDTypeName}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link Series} ⯈ {@link SeriesIdentifier} ⯈ {@link IDTypeName}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductIdentifier} ⯈ {@link IDTypeName}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ContainedItem} ⯈ {@link ProductIdentifier} ⯈
 * {@link IDTypeName}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link NotForSale} ⯈ {@link ProductIdentifier} ⯈ {@link IDTypeName}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link RelatedProduct} ⯈ {@link ProductIdentifier} ⯈
 * {@link IDTypeName}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link Set} ⯈ {@link ProductIdentifier} ⯈ {@link IDTypeName}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link SupplyDetail} ⯈ {@link Stock} ⯈ {@link LocationIdentifier} ⯈
 * {@link IDTypeName}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Header} ⯈ {@link SenderIdentifier} ⯈ {@link IDTypeName}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link CopyrightStatement} ⯈ {@link CopyrightOwner} ⯈
 * {@link CopyrightOwnerIdentifier} ⯈ {@link IDTypeName}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ContentItem} ⯈ {@link TextItem} ⯈ {@link TextItemIdentifier} ⯈
 * {@link IDTypeName}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link Contributor} ⯈ {@link Name} ⯈ {@link PersonNameIdentifier} ⯈
 * {@link IDTypeName}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ContentItem} ⯈ {@link Contributor} ⯈ {@link Name} ⯈
 * {@link PersonNameIdentifier} ⯈ {@link IDTypeName}</li>
 * <li>{@link ONIXMessage} ⯈ {@link SubSeriesRecord} ⯈ {@link Contributor} ⯈ {@link Name} ⯈ {@link PersonNameIdentifier}
 * ⯈ {@link IDTypeName}</li>
 * <li>{@link ONIXMessage} ⯈ {@link MainSeriesRecord} ⯈ {@link Contributor} ⯈ {@link Name} ⯈
 * {@link PersonNameIdentifier} ⯈ {@link IDTypeName}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link Series} ⯈ {@link Contributor} ⯈ {@link Name} ⯈
 * {@link PersonNameIdentifier} ⯈ {@link IDTypeName}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link PersonAsSubject} ⯈ {@link Name} ⯈ {@link PersonNameIdentifier} ⯈
 * {@link IDTypeName}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ContentItem} ⯈ {@link PersonAsSubject} ⯈ {@link Name} ⯈
 * {@link PersonNameIdentifier} ⯈ {@link IDTypeName}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link Contributor} ⯈ {@link PersonNameIdentifier} ⯈
 * {@link IDTypeName}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ContentItem} ⯈ {@link Contributor} ⯈ {@link PersonNameIdentifier}
 * ⯈ {@link IDTypeName}</li>
 * <li>{@link ONIXMessage} ⯈ {@link SubSeriesRecord} ⯈ {@link Contributor} ⯈ {@link PersonNameIdentifier} ⯈
 * {@link IDTypeName}</li>
 * <li>{@link ONIXMessage} ⯈ {@link MainSeriesRecord} ⯈ {@link Contributor} ⯈ {@link PersonNameIdentifier} ⯈
 * {@link IDTypeName}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link Series} ⯈ {@link Contributor} ⯈ {@link PersonNameIdentifier} ⯈
 * {@link IDTypeName}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link PersonAsSubject} ⯈ {@link PersonNameIdentifier} ⯈
 * {@link IDTypeName}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ContentItem} ⯈ {@link PersonAsSubject} ⯈
 * {@link PersonNameIdentifier} ⯈ {@link IDTypeName}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link SupplyDetail} ⯈ {@link SupplierIdentifier} ⯈
 * {@link IDTypeName}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link SupplyDetail} ⯈ {@link NewSupplier} ⯈ {@link SupplierIdentifier} ⯈
 * {@link IDTypeName}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link SalesRestriction} ⯈ {@link SalesOutlet} ⯈
 * {@link SalesOutletIdentifier} ⯈ {@link IDTypeName}</li>
 * <li>{@link ONIXMessage} ⯈ {@link SubSeriesRecord} ⯈ {@link ParentIdentifier} ⯈ {@link IDTypeName}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Header} ⯈ {@link AddresseeIdentifier} ⯈ {@link IDTypeName}</li>
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
     * This is the raw content of IDTypeName. Could be null if {@code exists() == false}. Use {@link #value()} instead
     * if you want to get this as an {@link java.util.Optional}.
     * <p>
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
