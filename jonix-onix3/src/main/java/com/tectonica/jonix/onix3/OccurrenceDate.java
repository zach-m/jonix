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

package com.tectonica.jonix.onix3;

import com.tectonica.jonix.common.JPU;
import com.tectonica.jonix.common.OnixComposite.OnixDataCompositeWithKey;
import com.tectonica.jonix.common.codelist.EventOccurrenceDateRoles;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixOccurrenceDate;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Event occurrence date composite</h1>
 * <p>
 * A group of data elements which together specify a date associated with the event occurrence. At least the date (and
 * typically also the time) the event occurrence begins must be specified, and other dates related to the event
 * occurrence can be sent in further repeats of the composite.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;OccurrenceDate&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;occurrencedate&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>1&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link EventOccurrence}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈ {@link EventOccurrence} ⯈
 * {@link OccurrenceDate}</li>
 * </ul>
 *
 * @since Onix-3.07
 */
public class OccurrenceDate
    implements OnixDataCompositeWithKey<JonixOccurrenceDate, EventOccurrenceDateRoles>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "OccurrenceDate";
    public static final String shortname = "occurrencedate";

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
    public static final OccurrenceDate EMPTY = new OccurrenceDate();

    public OccurrenceDate() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public OccurrenceDate(org.w3c.dom.Element element) {
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
                case OccurrenceDateRole.refname:
                case OccurrenceDateRole.shortname:
                    occurrenceDateRole = new OccurrenceDateRole(e);
                    break;
                case Date.refname:
                case Date.shortname:
                    date = new Date(e);
                    break;
                case DateFormat.refname:
                case DateFormat.shortname:
                    dateFormat = new DateFormat(e);
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;OccurrenceDate&gt; or &lt;occurrencedate&gt;) is explicitly provided in the ONIX
     *         XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<OccurrenceDate> action) {
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

    private OccurrenceDateRole occurrenceDateRole = OccurrenceDateRole.EMPTY;

    /**
     * <p>
     * An ONIX code indicating the significance of the date, <i>eg</i> the date of the occurrence, last date of ticket
     * availability <i>etc</i>. Mandatory in each instance of the &lt;OccurrenceDate&gt; composite, and non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public OccurrenceDateRole occurrenceDateRole() {
        _initialize();
        return occurrenceDateRole;
    }

    private Date date = Date.EMPTY;

    /**
     * <p>
     * The date specified in the &lt;OccurrenceDateRole&gt; field. Mandatory in each occurrence of the
     * &lt;OccurrenceDate&gt; composite, and non-repeating. &lt;Date&gt; may carry a <i>dateformat</i> attribute: if the
     * attribute is missing, then &lt;DateFormat&gt; indicates the format of the date; if both <i>dateformat</i>
     * attribute and &lt;DateFormat&gt; element are missing, the default format is YYYYMMDDThhmm (local time at the
     * venue). Note that this date format may include a time zone offset (Z for times in UTC, or ±hhmm), and this should
     * always be included where there is any doubt, <i>eg</i> when the event is available online.
     * </p>
     * Jonix-Comment: this field is required
     */
    public Date date() {
        _initialize();
        return date;
    }

    private DateFormat dateFormat = DateFormat.EMPTY;

    /**
     * <p>
     * An ONIX code indicating the format in which the date is given in &lt;Date&gt;. Optional and not repeatable.
     * Deprecated – where possible, use the <i>dateformat</i> attribute instead.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public DateFormat dateFormat() {
        _initialize();
        return dateFormat;
    }

    @Override
    public JonixOccurrenceDate asStruct() {
        _initialize();
        JonixOccurrenceDate struct = new JonixOccurrenceDate();
        struct.occurrenceDateRole = occurrenceDateRole.value;
        struct.dateFormat = dateFormat.value;
        struct.date = date.value;
        return struct;
    }

    @Override
    public EventOccurrenceDateRoles structKey() {
        return occurrenceDateRole().value;
    }
}
