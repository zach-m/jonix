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
 * <h1>“No supplement” indicator</h1>
 * <p>
 * An empty element that provides a positive indication there is no alternative ‘generic’ supplement to be used in cases
 * where there is a vendor-specific supplement (indicated using &lt;SalesOutlet&gt; with the same &lt;SequenceNumber&gt;
 * specified within the Supplement manifest). The empty &lt;NoSupplement/&gt; must be used – and must only be used –
 * when no &lt;BodyManifest&gt; is present within the Supplement manifest.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>XML empty element</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;NoSupplement&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;x579&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;1</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td><tt>&lt;NoSupplement/&gt;</tt></td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;NoSupplement&gt; from the schema author:
 *
 * Positive indication that there is no generic equivalent to a vendor-specific supplement to the product &#9679; XML
 * empty element - must not contain data &#9679; Added at revision 3.0.8
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link SupplementManifest}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link SupplementManifest} ⯈
 * {@link NoSupplement}</li>
 * </ul>
 *
 * @since Onix-3.08
 */
public class NoSupplement implements OnixFlag, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "NoSupplement";
    public static final String shortname = "x579";

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
    public static final NoSupplement EMPTY = new NoSupplement();

    public NoSupplement() {
        exists = false;
    }

    public NoSupplement(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcename = JPU.getAttribute(element, "sourcename");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
    }

    /**
     * @return whether this tag (&lt;NoSupplement&gt; or &lt;x579&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<NoSupplement> action) {
        if (exists) {
            action.accept(this);
        }
    }
}
