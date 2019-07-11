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

package com.tectonica.jonix.onix3;

import com.tectonica.jonix.common.JPU;
import com.tectonica.jonix.common.OnixComposite.OnixDataCompositeWithKey;
import com.tectonica.jonix.common.codelist.MeasureTypes;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixMeasure;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Measure composite</h1>
 * <p>
 * An optional group of data elements which together identify a measurement and the units in which it is expressed; used
 * to specify the overall dimensions of a physical product including its packaging (if any). Repeatable to provide
 * multiple combinations of dimension and unit.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;Measure&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;measure&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link DescriptiveDetail}&gt;</li>
 * <li>&lt;{@link ProductPart}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Measure}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link ProductPart} ⯈ {@link Measure}</li>
 * </ul>
 */
public class Measure implements OnixDataCompositeWithKey<JonixMeasure, MeasureTypes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Measure";
    public static final String shortname = "measure";

    /////////////////////////////////////////////////////////////////////////////////
    // ATTRIBUTES
    /////////////////////////////////////////////////////////////////////////////////

    /**
     * (type: dt.DateOrDateTime)
     */
    public String datestamp;

    public RecordSourceTypes sourcetype;

    /**
     * (type: dt.NonEmptyString)
     */
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
                case MeasureType.refname:
                case MeasureType.shortname:
                    measureType = new MeasureType(e);
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

    private MeasureType measureType = MeasureType.EMPTY;

    /**
     * <p>
     * An ONIX code indicating the dimension which is specified by an occurrence of the measure composite. Mandatory in
     * each occurrence of the &lt;Measure&gt; composite, and non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public MeasureType measureType() {
        _initialize();
        return measureType;
    }

    private Measurement measurement = Measurement.EMPTY;

    /**
     * <p>
     * The number which represents the dimension specified in &lt;MeasureType&gt; in the measure units specified in
     * &lt;MeasureUnitCode&gt;. Mandatory in each occurrence of the &lt;Measure&gt; composite, and non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public Measurement measurement() {
        _initialize();
        return measurement;
    }

    private MeasureUnitCode measureUnitCode = MeasureUnitCode.EMPTY;

    /**
     * <p>
     * An ONIX code indicating the measure unit in which dimensions are given. Mandatory in each occurrence of the
     * &lt;Measure&gt; composite, and non-repeating. This element must follow the dimension to which the measure unit
     * applies. See example below.
     * </p>
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
        struct.measureType = measureType.value;
        struct.measureUnitCode = measureUnitCode.value;
        struct.measurement = measurement.value;
        return struct;
    }

    @Override
    public MeasureTypes structKey() {
        return measureType().value;
    }
}
