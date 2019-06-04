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
import com.tectonica.jonix.common.OnixComposite.OnixDataComposite;
import com.tectonica.jonix.common.codelist.Languages;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.TextCaseFlags;
import com.tectonica.jonix.common.codelist.TextFormats;
import com.tectonica.jonix.common.codelist.TransliterationSchemes;
import com.tectonica.jonix.common.struct.JonixPrize;

import java.io.Serializable;
import java.util.Arrays;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Prize or award composite</h1>
 * <p>
 * A repeatable group of data elements which together describe a prize or award won by the product.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;Prize&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;prize&gt;</tt></td>
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
 * <li>ONIXMessage ⯈ Product ⯈ Prize</li>
 * </ul>
 */
public class Prize implements OnixDataComposite<JonixPrize>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Prize";
    public static final String shortname = "prize";

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
    public static final Prize EMPTY = new Prize();

    public Prize() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public Prize(org.w3c.dom.Element element) {
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
                case PrizeName.refname:
                case PrizeName.shortname:
                    prizeName = new PrizeName(e);
                    break;
                case PrizeYear.refname:
                case PrizeYear.shortname:
                    prizeYear = new PrizeYear(e);
                    break;
                case PrizeCountry.refname:
                case PrizeCountry.shortname:
                    prizeCountry = new PrizeCountry(e);
                    break;
                case PrizeCode.refname:
                case PrizeCode.shortname:
                    prizeCode = new PrizeCode(e);
                    break;
                case PrizeJury.refname:
                case PrizeJury.shortname:
                    prizeJury = new PrizeJury(e);
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;Prize&gt; or &lt;prize&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private PrizeName prizeName = PrizeName.EMPTY;

    /**
     * <p>
     * The name of a prize or award which the product has received. Mandatory in each occurrence of the &lt;Prize&gt;
     * composite, and non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public PrizeName prizeName() {
        _initialize();
        return prizeName;
    }

    private PrizeYear prizeYear = PrizeYear.EMPTY;

    /**
     * <p>
     * The year in which a prize or award was given. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public PrizeYear prizeYear() {
        _initialize();
        return prizeYear;
    }

    private PrizeCountry prizeCountry = PrizeCountry.EMPTY;

    /**
     * <p>
     * An ISO standard code identifying the country in which a prize or award is given. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public PrizeCountry prizeCountry() {
        _initialize();
        return prizeCountry;
    }

    private PrizeCode prizeCode = PrizeCode.EMPTY;

    /**
     * <p>
     * An ONIX code indicating the achievement of the product in relation to a prize or award, <em>eg</em> winner,
     * runner-up, shortlisted. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public PrizeCode prizeCode() {
        _initialize();
        return prizeCode;
    }

    private PrizeJury prizeJury = PrizeJury.EMPTY;

    /**
     * <p>
     * Free text listing members of the jury that awarded the prize. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public PrizeJury prizeJury() {
        _initialize();
        return prizeJury;
    }

    @Override
    public JonixPrize asStruct() {
        _initialize();
        JonixPrize struct = new JonixPrize();
        struct.prizeCode = prizeCode.value;
        struct.prizeCountry = prizeCountry.value;
        struct.prizeJurys = Arrays.asList(prizeJury.value);
        struct.prizeNames = Arrays.asList(prizeName.value);
        struct.prizeYear = prizeYear.value;
        return struct;
    }
}
