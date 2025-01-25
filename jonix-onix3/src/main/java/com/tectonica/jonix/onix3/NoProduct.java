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
 * <h1>“No product” indicator</h1>
 * <p>
 * An empty element that provides a positive indication that a message does not carry any Product records. Intended to
 * be used only in empty ‘delta’ update messages to provide confirmation that there have been no updates since the
 * previous message. Optional and non-repeating, but must be used in an ONIX message that contains no &lt;Product&gt;
 * composites.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>XML empty element</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;NoProduct&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;x507&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;1</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td><tt>&lt;x507/&gt;</tt></td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;NoProduct&gt; from the schema author:
 *
 * Positive indication that there are no product records in the message &#9679; XML empty element - must not contain
 * data &#9679; Added at revision 3.0.2
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link ONIXMessage}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link NoProduct}</li>
 * </ul>
 *
 * @since Onix-3.02
 */
public class NoProduct implements OnixFlag, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "NoProduct";
    public static final String shortname = "x507";

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
    public static final NoProduct EMPTY = new NoProduct();

    public NoProduct() {
        exists = false;
    }

    public NoProduct(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcename = JPU.getAttribute(element, "sourcename");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
    }

    /**
     * @return whether this tag (&lt;NoProduct&gt; or &lt;x507&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<NoProduct> action) {
        if (exists) {
            action.accept(this);
        }
    }
}
