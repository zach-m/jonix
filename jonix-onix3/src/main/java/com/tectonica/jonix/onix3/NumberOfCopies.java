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
import com.tectonica.jonix.common.OnixElement;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Number of copies (product part)</h1>
 * <p>
 * When product parts are listed as a specified number of copies of a single item, usually identified by a
 * &lt;ProductIdentifier&gt;, &lt;NumberOfCopies&gt; must be used to specify the quantity, even if the number is ‘1’. It
 * must be used when a multiple-item product or pack contains (a) a quantity of a single item; or (b) one of each of
 * several different items (as in a multi-volume set); or (c) one or more of each of several different items (as in a
 * dumpbin carrying copies of two different books, or a classroom pack containing a teacher’s text and twenty student
 * texts). Consequently the element is mandatory, and non-repeating, in an occurrence of the &lt;ProductPart&gt;
 * composite if &lt;NumberOfItemsOfThisForm&gt; is not present. It is normally accompanied by a
 * &lt;ProductIdentifier&gt;; but in exceptional circumstances, if the sender’s system is unable to provide an
 * identifier at this level, it may be sent with product form coding and without an ID.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Positive integer, suggested maximum length 4 digits</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;NumberOfCopies&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;x323&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;1</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td><tt>&lt;x323&gt;24&lt;/x323&gt;</tt> (24 copies of a single item in eg a classroom pack of textbooks)</td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link ProductPart}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link ProductPart} ⯈ {@link NumberOfCopies}</li>
 * </ul>
 */
public class NumberOfCopies implements OnixElement<Integer>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "NumberOfCopies";
    public static final String shortname = "x323";

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
     * This is the raw content of NumberOfCopies. Could be null if {@code exists() == false}. Use {@link #value()}
     * instead if you want to get this as an {@link java.util.Optional}.
     * <p>
     * Raw Format: Positive integer, suggested maximum length 4 digits
     * <p>
     * (type: dt.StrictPositiveInteger)
     */
    public Integer value;

    /**
     * Internal API, use the {@link #value()} method or the {@link #value} field instead
     */
    @Override
    public Integer __v() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final NumberOfCopies EMPTY = new NumberOfCopies();

    public NumberOfCopies() {
        exists = false;
    }

    public NumberOfCopies(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcename = JPU.getAttribute(element, "sourcename");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));

        value = JPU.getContentAsInteger(element);
    }

    /**
     * @return whether this tag (&lt;NumberOfCopies&gt; or &lt;x323&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<NumberOfCopies> action) {
        if (exists) {
            action.accept(this);
        }
    }
}
