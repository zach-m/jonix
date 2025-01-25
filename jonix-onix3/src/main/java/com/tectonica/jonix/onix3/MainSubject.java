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
import com.tectonica.jonix.common.OnixFlag;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Main subject flag</h1>
 * <p>
 * An empty element that identifies an instance of the &lt;Subject&gt; composite as representing the main subject
 * category for the product. The main category may be expressed in more than one subject scheme, <i>ie</i> there may be
 * two or more instances of the &lt;Subject&gt; composite, using different schemes, each carrying the
 * &lt;MainSubject/&gt; flag, so long as there is only one main category <em>per scheme</em>. Optional and non-repeating
 * in each occurrence of the &lt;Subject&gt; composite.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>XML empty element</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;MainSubject&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;x425&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;1</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td><tt>&lt;MainSubject/&gt;</tt></td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;MainSubject&gt; from the schema author:
 *
 * Flag to indicate the primary subject (within a particular subject scheme), used when the product has more than one
 * subject code from that subject scheme &#9679; XML empty element - must not contain data
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Subject}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Subject} ⯈ {@link MainSubject}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link Subject} ⯈ {@link MainSubject}</li>
 * </ul>
 */
public class MainSubject implements OnixFlag, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "MainSubject";
    public static final String shortname = "x425";

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
    // CONSTRUCTORS
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final MainSubject EMPTY = new MainSubject();

    public MainSubject() {
        exists = false;
    }

    public MainSubject(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcename = JPU.getAttribute(element, "sourcename");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
    }

    /**
     * @return whether this tag (&lt;MainSubject&gt; or &lt;x425&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<MainSubject> action) {
        if (exists) {
            action.accept(this);
        }
    }
}
