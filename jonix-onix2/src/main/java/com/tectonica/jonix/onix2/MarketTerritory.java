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

package com.tectonica.jonix.onix2;

import com.tectonica.jonix.common.JPU;
import com.tectonica.jonix.common.OnixElement;
import com.tectonica.jonix.common.codelist.Languages;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.TextCaseFlags;
import com.tectonica.jonix.common.codelist.TextFormats;
import com.tectonica.jonix.common.codelist.TransliterationSchemes;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Market territory</h1>
 * <p>
 * One or more ONIX codes identifying a territory which is not a country, but which is precisely defined in geographical
 * terms, <em>eg</em> World, Northern Ireland, Australian Capital Territory. Successive codes are separated by spaces.
 * Thus the element can carry an unlimited number of territory codes. Optional, but each occurrence of the
 * &lt;MarketRepresentation&gt; composite must carry either an occurrence of &lt;MarketCountry&gt; or an occurrence of
 * &lt;MarketTerritory&gt;, to specify the market concerned. Non-repeating.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>One or more variable-length codes, each consisting of upper case letters with or without a hyphen, successive
 * codes being separated by spaces. Suggested maximum length 100 characters.</td>
 * </tr>
 * <tr>
 * <td>Codelist</td>
 * <td>List 49 Where possible and appropriate, country subdivision codes are derived from the UN LOCODE scheme based on
 * ISO 3166.</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;MarketTerritory&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;j404&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td><tt>&lt;MarketTerritory&gt;WORLD&lt;/MarketTerritory&gt;</tt> Whole world</td>
 * </tr>
 * <tr>
 * <td></td>
 * <td><tt>&lt;MarketTerritory&gt;GB-EWS&lt;/MarketTerritory&gt;</tt> UK excluding Northern Ireland</td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link MarketRepresentation}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link MarketRepresentation} ⯈ {@link MarketTerritory}</li>
 * </ul>
 *
 * @since Onix-2.12
 */
public class MarketTerritory implements OnixElement<java.util.Set<String>>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "MarketTerritory";
    public static final String shortname = "j404";

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
     * This is the raw content of MarketTerritory. Could be null if {@code exists() == false}. Use {@link #value()}
     * instead if you want to get this as an {@link java.util.Optional}.
     * <p>
     * Raw Format: One or more variable-length codes, each consisting of upper case letters with or without a hyphen,
     * successive codes being separated by spaces. Suggested maximum length 100 characters.
     * <p>
     * (type: NonEmptyString)
     */
    public java.util.Set<String> value;

    /**
     * Internal API, use the {@link #value()} method or the {@link #value} field instead
     */
    @Override
    public java.util.Set<String> __v() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final MarketTerritory EMPTY = new MarketTerritory();

    public MarketTerritory() {
        exists = false;
    }

    public MarketTerritory(org.w3c.dom.Element element) {
        exists = true;
        textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));
        textcase = TextCaseFlags.byCode(JPU.getAttribute(element, "textcase"));
        language = Languages.byCode(JPU.getAttribute(element, "language"));
        transliteration = TransliterationSchemes.byCode(JPU.getAttribute(element, "transliteration"));
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        value = new java.util.HashSet<>();
        for (String split : JPU.getContentAsString(element).split(" +")) {
            value.add(String.valueOf(split));
        }
    }

    /**
     * @return whether this tag (&lt;MarketTerritory&gt; or &lt;j404&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<MarketTerritory> action) {
        if (exists) {
            action.accept(this);
        }
    }
}
