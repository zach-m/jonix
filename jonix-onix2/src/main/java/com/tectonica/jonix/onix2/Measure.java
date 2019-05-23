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
import com.tectonica.jonix.OnixComposite.OnixDataCompositeWithKey;
import com.tectonica.jonix.codelist.Languages;
import com.tectonica.jonix.codelist.MeasureTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;
import com.tectonica.jonix.struct.JonixMeasure;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Measure composite</h1><p>An optional and repeatable group of data elements which together identify a measurement
 * and the units in which it is expressed.</p><table border='1' cellpadding='3'><tr><td>Reference
 * name</td><td><tt>&lt;Measure&gt;</tt></td></tr><tr><td>Short tag</td><td><tt>&lt;measure&gt;</tt></td></tr></table>
 * <p>&nbsp;</p>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;Product&gt;</li>
 * </ul>
 * <p>&nbsp;</p>
 * Possible placements within ONIX message:
 * <ul>
 * <li>ONIXMessage ⯈ Product ⯈ Measure</li>
 * </ul>
 */
public class Measure implements OnixDataCompositeWithKey<JonixMeasure, MeasureTypes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Measure";
    public static final String shortname = "measure";

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
    public static final Measure EMPTY = new Measure();

    public Measure() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public Measure(org.w3c.dom.Element element) {
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
                case MeasureTypeCode.refname:
                case MeasureTypeCode.shortname:
                    measureTypeCode = new MeasureTypeCode(e);
                    break;
                case Measurement.refname:
                case Measurement.shortname:
                    measurement = new Measurement(e);
                    break;
                case MeasureUnitCode.refname:
                case MeasureUnitCode.shortname:
                    measureUnitCode = new MeasureUnitCode(e);
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;Measure&gt; or &lt;measure&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private MeasureTypeCode measureTypeCode = MeasureTypeCode.EMPTY;

    /**
     * <p>An ONIX code indicating the dimension which is specified by an occurrence of the measure composite. Mandatory
     * in each occurrence of the &lt;Measure&gt; composite, and non-repeating.</p>
     * Jonix-Comment: this field is required
     */
    public MeasureTypeCode measureTypeCode() {
        _initialize();
        return measureTypeCode;
    }

    private Measurement measurement = Measurement.EMPTY;

    /**
     * <p>The number which represents the dimension specified in &lt;MeasureTypeCode&gt; in the measure units specified
     * in &lt;MeasureUnitCode&gt;. Mandatory in each occurrence of the &lt;Measure&gt; composite, and
     * non-repeating.</p>
     * Jonix-Comment: this field is required
     */
    public Measurement measurement() {
        _initialize();
        return measurement;
    }

    private MeasureUnitCode measureUnitCode = MeasureUnitCode.EMPTY;

    /**
     * <p>An ONIX code indicating the measure unit in which dimensions are given. Mandatory in each occurrence of the
     * &lt;Measure&gt; composite, and non-repeating. This element must follow the dimension to which the measure unit
     * applies. See example below.</p>
     * Jonix-Comment: this field is required
     */
    public MeasureUnitCode measureUnitCode() {
        _initialize();
        return measureUnitCode;
    }

    @Override
    public JonixMeasure asStruct() {
        _initialize();
        JonixMeasure struct = new JonixMeasure();
        struct.measureType = measureTypeCode.value;
        struct.measureUnitCode = measureUnitCode.value;
        struct.measurement = JPU.convertStringToDouble(measurement.value);
        return struct;
    }

    @Override
    public MeasureTypes structKey() {
        return measureTypeCode().value;
    }
}
