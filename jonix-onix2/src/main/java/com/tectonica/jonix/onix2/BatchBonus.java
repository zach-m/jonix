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
import com.tectonica.jonix.common.struct.JonixBatchBonus;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Batch bonus composite</h1>
 * <p>
 * A repeatable group of data elements which together specify a batch bonus, <em>ie</em> a quantity of free copies which
 * are supplied with a certain order quantity. The &lt;BatchBonus&gt; composite is optional.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;BatchBonus&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;batchbonus&gt;</tt></td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Price}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link SupplyDetail} ⯈ {@link Price} ⯈ {@link BatchBonus}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link SupplyDetail} ⯈ {@link Reissue} ⯈ {@link Price} ⯈
 * {@link BatchBonus}</li>
 * </ul>
 */
public class BatchBonus implements OnixDataComposite<JonixBatchBonus>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "BatchBonus";
    public static final String shortname = "batchbonus";

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
    public static final BatchBonus EMPTY = new BatchBonus();

    public BatchBonus() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public BatchBonus(org.w3c.dom.Element element) {
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
                case BatchQuantity.refname:
                case BatchQuantity.shortname:
                    batchQuantity = new BatchQuantity(e);
                    break;
                case FreeQuantity.refname:
                case FreeQuantity.shortname:
                    freeQuantity = new FreeQuantity(e);
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;BatchBonus&gt; or &lt;batchbonus&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private BatchQuantity batchQuantity = BatchQuantity.EMPTY;

    /**
     * <p>
     * The number of copies which must be ordered to obtain the free copies specified in &lt;FreeQuantity&gt;. Mandatory
     * in each occurrence of the &lt;BatchBonus&gt; composite, and non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public BatchQuantity batchQuantity() {
        _initialize();
        return batchQuantity;
    }

    private FreeQuantity freeQuantity = FreeQuantity.EMPTY;

    /**
     * <p>
     * The number of free copies which will be supplied with an order for the batch quantity specified in the
     * &lt;BatchQuantity&gt; field. Mandatory in each occurrence of the &lt;BatchBonus&gt; composite, and non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public FreeQuantity freeQuantity() {
        _initialize();
        return freeQuantity;
    }

    @Override
    public JonixBatchBonus asStruct() {
        _initialize();
        JonixBatchBonus struct = new JonixBatchBonus();
        struct.batchQuantity = JPU.convertStringToInteger(batchQuantity.value);
        struct.freeQuantity = JPU.convertStringToInteger(freeQuantity.value);
        return struct;
    }
}
