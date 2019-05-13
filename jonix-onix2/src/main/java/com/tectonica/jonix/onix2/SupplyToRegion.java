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
import com.tectonica.jonix.codelist.SupplytoRegions;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Supply-to region</h1><p>An ONIX code for a region to which the supplier is able to supply. A full code list is
 * yet to be defined. A provisional coding, for UK use only, is given for Open Market supply. <strong>This element will
 * not be further developed, and is superseded by &lt;SupplyToTerritory&gt; above. It is retained for purposes of
 * upwards compatibility only. Note that Open Market distribution rights should be specified, like any others, by
 * listing countries and territories.</strong></p><table border='1' cellpadding='3'><tr><td>Format</td><td>Fixed-length,
 * three numeric digits</td></tr><tr><td>Codelist</td><td>List 52</td></tr><tr><td>Reference
 * name</td><td>&lt;SupplyToRegion&gt;</td></tr><tr><td>Short tag</td><td>&lt;j139&gt;</td></tr><tr><td>Example</td><td>&lt;SupplyToRegion&gt;004&lt;/SupplyToRegion&gt;
 * UK 'open market'</td></tr></table>
 */
public class SupplyToRegion implements OnixElement<SupplytoRegions>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "SupplyToRegion";
    public static final String shortname = "j139";

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

    public SupplytoRegions value;

    /**
     * Internal API, use the {@link #value} field instead
     */
    @Override
    public SupplytoRegions _value() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final SupplyToRegion EMPTY = new SupplyToRegion();

    public SupplyToRegion() {
        exists = false;
    }

    public SupplyToRegion(org.w3c.dom.Element element) {
        exists = true;
        textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));
        textcase = TextCaseFlags.byCode(JPU.getAttribute(element, "textcase"));
        language = Languages.byCode(JPU.getAttribute(element, "language"));
        transliteration = TransliterationSchemes.byCode(JPU.getAttribute(element, "transliteration"));
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        value = SupplytoRegions.byCode(JPU.getContentAsString(element));
    }

    @Override
    public boolean exists() {
        return exists;
    }
}
