/*
 * Copyright (C) 2012-2025 Zach Melamed
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
import com.tectonica.jonix.common.struct.JonixTimeRun;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Time run composite</h1>
 * <p>
 * A repeatable group of data elements which together define the time period which an AV item takes up. The composite is
 * optional, but may be repeated where the AV item covers two or more separate periods of time.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;TimeRun&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;timerun&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;TimeRun&gt; from the schema author:
 *
 * Details of the start and end times of an audiovisual content item &#9679; Added at revision 3.0.5
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link AVItem}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link AVItem} ⯈ {@link TimeRun}</li>
 * </ul>
 *
 * @since Onix-3.05
 */
public class TimeRun implements OnixDataComposite<JonixTimeRun>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "TimeRun";
    public static final String shortname = "timerun";

    /////////////////////////////////////////////////////////////////////////////////
    // ATTRIBUTES
    /////////////////////////////////////////////////////////////////////////////////

    /**
     * (type: dt.DateOrDateTime)
     */
    public String datestamp;

    /**
     * (type: dt.NonEmptyString)
     */
    public String sourcename;

    public RecordSourceTypes sourcetype;

    /////////////////////////////////////////////////////////////////////////////////
    // CONSTRUCTION
    /////////////////////////////////////////////////////////////////////////////////

    private boolean initialized;
    private final boolean exists;
    private final org.w3c.dom.Element element;
    public static final TimeRun EMPTY = new TimeRun();

    public TimeRun() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public TimeRun(org.w3c.dom.Element element) {
        exists = true;
        initialized = false;
        this.element = element;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcename = JPU.getAttribute(element, "sourcename");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
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
                case StartTime.refname:
                case StartTime.shortname:
                    startTime = new StartTime(e);
                    break;
                case EndTime.refname:
                case EndTime.shortname:
                    endTime = new EndTime(e);
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;TimeRun&gt; or &lt;timerun&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<TimeRun> action) {
        if (exists) {
            action.accept(this);
        }
    }

    @Override
    public org.w3c.dom.Element getXmlElement() {
        return element;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private StartTime startTime = StartTime.EMPTY;

    /**
     * <p>
     * The time (relative to the beginning of the product’s audio or audiovisual content) of the beginning of a
     * continuous sequence of audiovisual content. Mandatory in each occurrence of the &lt;TimeRun&gt; composite, and
     * non-repeating.
     * </p>
     * JONIX adds: this field is required
     */
    public StartTime startTime() {
        _initialize();
        return startTime;
    }

    private EndTime endTime = EndTime.EMPTY;

    /**
     * <p>
     * The time (relative to the beginning of the product’s audio or audiovisual content) of the end of a continuous
     * sequence of audio or audiovisual content. Optional in each occurrence of the &lt;TimeRun&gt; composite, and
     * non-repeating.
     * </p>
     * JONIX adds: this field is optional
     */
    public EndTime endTime() {
        _initialize();
        return endTime;
    }

    @Override
    public JonixTimeRun asStruct() {
        _initialize();
        JonixTimeRun struct = new JonixTimeRun();
        struct.startTime = startTime.value;
        struct.endTime = endTime.value;
        return struct;
    }
}
