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
 * <h1>Copyright statement text (content item)</h1>
 * <p>
 * Free text showing how the copyright of the content item should be described, when a standard concatenation of
 * individual copyright statements would not give a satisfactory presentation. Optional but must only be used if one or
 * more instances of &lt;CopyrightStatement&gt; are present, and repeatable if parallel text is provided in multiple
 * languages. The <i>language</i> attribute is optional for a single instance of &lt;CopyrightStatementText&gt;, but
 * must be included in each instance if &lt;CopyrightStatementText&gt; is repeated. When the
 * &lt;CopyrightStatementText&gt; field is sent, the receiver should use it to replace all detail for the content item
 * sent in the &lt;CopyrightStatement&gt; composite <em>for display purposes only</em>. It does not replace the
 * &lt;CopyrightStatement&gt; element. The individual rightsholder detail <em>must</em> also be sent in one or more
 * &lt;CopyrightStatement&gt; composites for indexing and retrieval purposes.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Variable length text, suggested maximum length 500 characters. XHTML is enabled in this element - see Using
 * XHTML, HTML, XML, JSON within ONIX text fields</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;CopyrightStatementText&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;x588&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * <tr>
 * <td>Attributes</td>
 * <td>language, textformat</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td><tt>&lt;CopyrightStatementText textformat=&quot;05&quot;&gt;&lt;p&gt;Text &#169; 2023 Amelia Winstanley, music &#169; and &#8471; 2021 Three sisters&lt;/p&gt;&lt;/CopyrightStatementText&gt;</tt></td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;CopyrightStatementText&gt; from the schema author:
 *
 * Text showing how the copyright details should be arranged for display purposes &#9679; Added at revision 3.1.1
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link ContentItem}&gt;</li>
 * <li>&lt;{@link PublishingDetail}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link CopyrightStatementText}</li>
 * <li>{@link Product} ⯈ {@link PublishingDetail} ⯈ {@link CopyrightStatementText}</li>
 * </ul>
 *
 * @since Onix-3.11
 */
public class CopyrightStatementText implements OnixElement<String>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "CopyrightStatementText";
    public static final String shortname = "x588";

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
     * This is the raw content of CopyrightStatementText. Could be null if {@code exists() == false}. Use
     * {@link #value()} instead if you want to get this as an {@link java.util.Optional}.
     * <p>
     * Raw Format: Variable length text, suggested maximum length 500 characters. XHTML is enabled in this element - see
     * Using XHTML, HTML, XML, JSON within ONIX text fields
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
    public static final CopyrightStatementText EMPTY = new CopyrightStatementText();

    public CopyrightStatementText() {
        exists = false;
    }

    public CopyrightStatementText(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcename = JPU.getAttribute(element, "sourcename");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        language = Languages.byCode(JPU.getAttribute(element, "language"));
        textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));

        value = JPU.getChildXHTML(element, true);
    }

    /**
     * @return whether this tag (&lt;CopyrightStatementText&gt; or &lt;x588&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<CopyrightStatementText> action) {
        if (exists) {
            action.accept(this);
        }
    }
}
