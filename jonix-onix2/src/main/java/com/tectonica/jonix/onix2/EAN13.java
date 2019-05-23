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
 * <h1>EAN.UCC-13 article number</h1><p>The cross-industry product code administered by EAN International and its member
 * agencies worldwide, in association with UCC in the US. Optional and non-repeating. For books, an EAN number can be
 * derived from a ten-character ISBN by (a) prefixing it with the three digits 978, (b) deleting the ISBN check
 * character, and (c) attaching a new check digit calculated according to EAN rules. <strong>The
 * &lt;ProductIdentifier&gt; composite on a later page provides a more general method of handling this and other product
 * codes, and is to be preferred.</strong></p><table border='1' cellpadding='3'><tr><td>Format</td><td>Fixed-length, 13
 * numeric digits. The last digit is a modulus-10 check digit calculated in accordance with the rules given at
 * http://www.ean-int.org/cdcalcul.html</td></tr><tr><td>Reference name</td><td><tt>&lt;EAN13&gt;</tt></td></tr><tr><td>Short
 * tag</td><td><tt>&lt;b005&gt;</tt></td></tr><tr><td>Example</td><td><tt>&lt;b005&gt;9788474339796&lt;/b005&gt;</tt></td></tr></table>
 * <p>&nbsp;</p>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;Product&gt;</li>
 * <li>&lt;ContainedItem&gt;</li>
 * <li>&lt;NotForSale&gt;</li>
 * <li>&lt;RelatedProduct&gt;</li>
 * </ul>
 * <p>&nbsp;</p>
 * Possible placements within ONIX message:
 * <ul>
 * <li>ONIXMessage ⯈ Product ⯈ EAN13</li>
 * <li>ONIXMessage ⯈ Product ⯈ ContainedItem ⯈ EAN13</li>
 * <li>ONIXMessage ⯈ Product ⯈ NotForSale ⯈ EAN13</li>
 * <li>ONIXMessage ⯈ Product ⯈ RelatedProduct ⯈ EAN13</li>
 * </ul>
 */
public class EAN13 implements OnixElement<String>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "EAN13";
    public static final String shortname = "b005";

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
     * Raw Format: Fixed-length, 13 numeric digits. The last digit is a modulus-10 check digit calculated in accordance
     * with the rules given at http://www.ean-int.org/cdcalcul.html<p> (type: NonEmptyString)
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
    public static final EAN13 EMPTY = new EAN13();

    public EAN13() {
        exists = false;
    }

    public EAN13(org.w3c.dom.Element element) {
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
     * @return whether this tag (&lt;EAN13&gt; or &lt;b005&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }
}
