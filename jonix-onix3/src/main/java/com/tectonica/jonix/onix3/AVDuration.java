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

import java.io.Serializable;
import java.util.function.Consumer;
import com.tectonica.jonix.common.JPU;
import com.tectonica.jonix.common.OnixElement;
import com.tectonica.jonix.common.codelist.*;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Duration of AV item</h1>
 * <p>
 * The duration of an audio or audiovisual item within the time-based content of a product. Optional and non-repeating,
 * but normally expected when the AV content item is being referenced as part of a structured table of contents.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Hours, minutes and seconds in the form HHHMMSS or HHHMMSScc (hundredths of a second)</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;AVDuration&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;x544&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;1</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td><tt>&lt;AVDuration&gt;0002948&lt;/AVDuration&gt;</tt> (29 minutes and 48 seconds)</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;AVDuration&gt; from the schema author:
 *
 * The duration of an audiovisual content item (eg a chapter) &#9679; Added at revision 3.0.5
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link AVItem}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link AVItem} ⯈ {@link AVDuration}</li>
 * </ul>
 *
 * @since Onix-3.05
 */
public class AVDuration implements OnixElement<String>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "AVDuration";
    public static final String shortname = "x544";

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
    // VALUE MEMBER
    /////////////////////////////////////////////////////////////////////////////////

    /**
     * This is the raw content of AVDuration. Could be null if {@code exists() == false}. Use {@link #value()} instead
     * if you want to get this as an {@link java.util.Optional}.
     * <p>
     * Raw Format: Hours, minutes and seconds in the form HHHMMSS or HHHMMSScc (hundredths of a second)
     * <p>
     * (type: dt.TimeOrDuration)
     */
    public String value;

    /**
     * Internal API, use the {@link #value()} method or the {@link #value} field instead
     */
    @Override
    public String __v() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final AVDuration EMPTY = new AVDuration();

    public AVDuration() {
        exists = false;
    }

    public AVDuration(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcename = JPU.getAttribute(element, "sourcename");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));

        value = JPU.getContentAsString(element);
    }

    /**
     * @return whether this tag (&lt;AVDuration&gt; or &lt;x544&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<AVDuration> action) {
        if (exists) {
            action.accept(this);
        }
    }
}
