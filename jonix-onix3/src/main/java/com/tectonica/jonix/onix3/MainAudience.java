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
 * <h1>Main audience flag</h1>
 * <p>
 * An empty element that identifies an instance of the &lt;Audience&gt; composite as representing the primary or main
 * audience for the product. The main audience may be expressed in more than one audience scheme, <i>ie</i>&nbsp;there
 * may be two or more instances of the &lt;Audience&gt; composite, using different schemes, each carrying the
 * &lt;MainAudience/&gt; flag, so long as there is only one main audience <em>per scheme</em> (<i>ie</i>&nbsp;per value
 * of &lt;AudienceCodeType&gt;). Optional and non-repeating in each occurrence of the &lt;Audience&gt; composite.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>XML empty element</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;MainAudience&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;x583&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;1</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td><tt>&lt;x583/&gt;</tt></td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;MainAudience&gt; from the schema author:
 *
 * Flag to indicate the primary audience (within a particular audience scheme), used when the product has more than one
 * audience code from that audience scheme &#9679; Added at release 3.1 &#9679; XML empty element - must not contain
 * data
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Audience}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Audience} ⯈ {@link MainAudience}</li>
 * </ul>
 *
 * @since Onix-3.10
 */
public class MainAudience implements OnixFlag, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "MainAudience";
    public static final String shortname = "x583";

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
    public static final MainAudience EMPTY = new MainAudience();

    public MainAudience() {
        exists = false;
    }

    public MainAudience(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcename = JPU.getAttribute(element, "sourcename");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
    }

    /**
     * @return whether this tag (&lt;MainAudience&gt; or &lt;x583&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<MainAudience> action) {
        if (exists) {
            action.accept(this);
        }
    }
}
