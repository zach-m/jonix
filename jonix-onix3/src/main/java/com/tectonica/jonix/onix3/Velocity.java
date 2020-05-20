/*
 * Copyright (C) 2012-2020 Zach Melamed
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
import com.tectonica.jonix.common.OnixComposite.OnixDataComposite;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixVelocity;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Velocity composite</h1>
 * <p>
 * An optional group of data elements which together specify the rate of stock depletion – or equally, a rate of
 * accumulation of backorders. Repeatable if the rate of depletion is specified using more than one metric (<i>eg</i>
 * specifying both a minimum and maximum daily sale).
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;Velocity&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;velocity&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Stock}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Stock} ⯈
 * {@link Velocity}</li>
 * </ul>
 *
 * @since Onix-3.02
 */
public class Velocity implements OnixDataComposite<JonixVelocity>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Velocity";
    public static final String shortname = "velocity";

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
    public static final Velocity EMPTY = new Velocity();

    public Velocity() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public Velocity(org.w3c.dom.Element element) {
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
                case VelocityMetric.refname:
                case VelocityMetric.shortname:
                    velocityMetric = new VelocityMetric(e);
                    break;
                case Rate.refname:
                case Rate.shortname:
                    rate = new Rate(e);
                    break;
                case Proximity.refname:
                case Proximity.shortname:
                    proximity = new Proximity(e);
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;Velocity&gt; or &lt;velocity&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    @Override
    public org.w3c.dom.Element getXmlElement() {
        return element;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private VelocityMetric velocityMetric = VelocityMetric.EMPTY;

    /**
     * <p>
     * An ONIX code that specifies how the rate of stock depletion is measured. Mandatory within the &lt;Velocity&gt;
     * composite, and non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public VelocityMetric velocityMetric() {
        _initialize();
        return velocityMetric;
    }

    private Rate rate = Rate.EMPTY;

    /**
     * <p>
     * The stock depletion rate (as a number of copies, rounded to the nearest integer), measured according to the
     * metric in &lt;VelocityMetric&gt;.
     * </p>
     * Jonix-Comment: this field is required
     */
    public Rate rate() {
        _initialize();
        return rate;
    }

    private Proximity proximity = Proximity.EMPTY;

    /**
     * <p>
     * An ONIX code which specifies the precision of the rate of stock depletion. Optional, and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public Proximity proximity() {
        _initialize();
        return proximity;
    }

    @Override
    public JonixVelocity asStruct() {
        _initialize();
        JonixVelocity struct = new JonixVelocity();
        struct.velocityMetric = velocityMetric.value;
        struct.rate = rate.value;
        struct.proximity = proximity.value;
        return struct;
    }
}
