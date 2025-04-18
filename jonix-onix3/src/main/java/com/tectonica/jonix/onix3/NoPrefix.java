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
 * <h1>“No prefix” indicator</h1>
 * <p>
 * An empty element that provides a positive indication that a title element does not include any prefix that is ignored
 * for sorting purposes. Optional and non-repeating, and must only be used when &lt;TitleWithoutPrefix&gt; is used and
 * no &lt;TitlePrefix&gt; element is present.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>XML empty element</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;NoPrefix&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;x501&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;1</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td><tt>&lt;NoPrefix/&gt;</tt></td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;NoPrefix&gt; from the schema author:
 *
 * Positive indication that there is no prefix (eg A, The) at the beginning of a title element which is ignored for
 * sorting purposes &#9679; XML empty element - must not contain data &#9679; Added at revision 3.0.2
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link TitleElement}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link TitleDetail} ⯈ {@link TitleElement} ⯈ {@link NoPrefix}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link TitleDetail} ⯈ {@link TitleElement} ⯈
 * {@link NoPrefix}</li>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Collection} ⯈ {@link TitleDetail} ⯈ {@link TitleElement} ⯈
 * {@link NoPrefix}</li>
 * </ul>
 *
 * @since Onix-3.02
 */
public class NoPrefix implements OnixFlag, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "NoPrefix";
    public static final String shortname = "x501";

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
    public static final NoPrefix EMPTY = new NoPrefix();

    public NoPrefix() {
        exists = false;
    }

    public NoPrefix(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcename = JPU.getAttribute(element, "sourcename");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
    }

    /**
     * @return whether this tag (&lt;NoPrefix&gt; or &lt;x501&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<NoPrefix> action) {
        if (exists) {
            action.accept(this);
        }
    }
}
