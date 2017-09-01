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
import com.tectonica.jonix.codelist.LanguageCodes;
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
 * name</td><td>&lt;Measure&gt;</td></tr><tr><td>Short tag</td><td>&lt;measure&gt;</td></tr></table>
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

    public LanguageCodes language;

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
    }

    private void initialize() {
        if (initialized) {
            return;
        }
        initialized = true;

        textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));
        textcase = TextCaseFlags.byCode(JPU.getAttribute(element, "textcase"));
        language = LanguageCodes.byCode(JPU.getAttribute(element, "language"));
        transliteration = TransliterationSchemes.byCode(JPU.getAttribute(element, "transliteration"));
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        JPU.forElementsOf(element, e -> {
            final String name = e.getNodeName();
            if (name.equals(MeasureTypeCode.refname) || name.equals(MeasureTypeCode.shortname)) {
                measureTypeCode = new MeasureTypeCode(e);
            } else if (name.equals(Measurement.refname) || name.equals(Measurement.shortname)) {
                measurement = new Measurement(e);
            } else if (name.equals(MeasureUnitCode.refname) || name.equals(MeasureUnitCode.shortname)) {
                measureUnitCode = new MeasureUnitCode(e);
            }
        });
    }

    @Override
    public boolean exists() {
        return exists;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private MeasureTypeCode measureTypeCode = MeasureTypeCode.EMPTY;

    /**
     * (this field is required)
     */
    public MeasureTypeCode measureTypeCode() {
        initialize();
        return measureTypeCode;
    }

    private Measurement measurement = Measurement.EMPTY;

    /**
     * (this field is required)
     */
    public Measurement measurement() {
        initialize();
        return measurement;
    }

    private MeasureUnitCode measureUnitCode = MeasureUnitCode.EMPTY;

    /**
     * (this field is required)
     */
    public MeasureUnitCode measureUnitCode() {
        initialize();
        return measureUnitCode;
    }

    @Override
    public JonixMeasure asStruct() {
        initialize();
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
