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
import com.tectonica.jonix.common.codelist.Languages;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.TextFormats;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Collection title statement</h1>
 * <p>
 * Free text showing how the collection title should be presented in any display, particularly when a standard
 * concatenation of individual title elements from Group&nbsp;P.5 (in the order specified by the &lt;SequenceNumber&gt;
 * data elements) would not give a satisfactory result. Optional and non-repeating. When this field is sent, the
 * recipient should use it to replace all collection title detail sent in Group&nbsp;P.5 for display purposes only. The
 * individual collection title element detail <em>must</em> also be sent, for indexing and retrieval purposes.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Variable length text, suggested maximum length 1000 characters. XHTML is enabled in this element - see Using
 * XHTML, HTML or XML with ONIX text fields</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;TitleStatement&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;x478&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;1</td>
 * </tr>
 * <tr>
 * <td>Attributes</td>
 * <td>language, textformat</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;TitleStatement&gt; from the schema author:
 *
 * Text showing how the title details should be arranged for display purposes (note that all title elements must also be
 * provided separate) &#9679; Added at revision 3.0.1
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link TitleDetail}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link TitleDetail} ⯈ {@link TitleStatement}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link TitleDetail} ⯈ {@link TitleStatement}</li>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Collection} ⯈ {@link TitleDetail} ⯈
 * {@link TitleStatement}</li>
 * </ul>
 *
 * @since Onix-3.01
 */
public class TitleStatement implements OnixElement<String>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "TitleStatement";
    public static final String shortname = "x478";

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

    public Languages language;

    public TextFormats textformat;

    /////////////////////////////////////////////////////////////////////////////////
    // VALUE MEMBER
    /////////////////////////////////////////////////////////////////////////////////

    /**
     * This is the raw content of TitleStatement. Could be null if {@code exists() == false}. Use {@link #value()}
     * instead if you want to get this as an {@link java.util.Optional}.
     * <p>
     * Raw Format: Variable length text, suggested maximum length 1000 characters. XHTML is enabled in this element -
     * see Using XHTML, HTML or XML with ONIX text fields
     * <p>
     * (type: XHTML)
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
    public static final TitleStatement EMPTY = new TitleStatement();

    public TitleStatement() {
        exists = false;
    }

    public TitleStatement(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcename = JPU.getAttribute(element, "sourcename");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        language = Languages.byCode(JPU.getAttribute(element, "language"));
        textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));

        value = JPU.getChildXHTML(element, true);
    }

    /**
     * @return whether this tag (&lt;TitleStatement&gt; or &lt;x478&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<TitleStatement> action) {
        if (exists) {
            action.accept(this);
        }
    }
}
