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
import com.tectonica.jonix.common.codelist.TextCaseFlags;
import com.tectonica.jonix.common.codelist.TextScripts;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Title prefix</h1>
 * <p>
 * Text at the beginning of a title element which is to be ignored for alphabetical sorting. Optional and non-repeating;
 * can only be used when &lt;TitleText&gt; is omitted, and if the &lt;TitleWithoutPrefix&gt; element is also present.
 * These two elements may be used in combination in applications where it is necessary to distinguish an initial word or
 * character string which is to be ignored for filing purposes, <i>eg</i> in library systems and in some bookshop
 * databases.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Variable length text, suggested maximum 20 characters</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;TitlePrefix&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;b030&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;1</td>
 * </tr>
 * <tr>
 * <td>Attributes</td>
 * <td>collationkey, language, textscript, textcase</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td><tt>&lt;TitlePrefix language=&quot;eng&quot;&gt;The&lt;/TitlePrefix&gt;</tt></td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;TitlePrefix&gt; from the schema author:
 *
 * Prefix at the beginning of a title element which is ignored for sorting purposes, eg An, The &#9679; Added language
 * attribute at revision 3.0.2 &#9679; Added collationkey, textscript attributes at revision 3.0.1
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link TitleElement}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link TitleDetail} ⯈ {@link TitleElement} ⯈
 * {@link TitlePrefix}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link TitleDetail} ⯈ {@link TitleElement} ⯈
 * {@link TitlePrefix}</li>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Collection} ⯈ {@link TitleDetail} ⯈ {@link TitleElement} ⯈
 * {@link TitlePrefix}</li>
 * </ul>
 */
public class TitlePrefix implements OnixElement<String>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "TitlePrefix";
    public static final String shortname = "b030";

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

    /**
     * (type: dt.NonEmptyString)
     */
    public String collationkey;

    public Languages language;

    public TextScripts textscript;

    public TextCaseFlags textcase;

    /////////////////////////////////////////////////////////////////////////////////
    // VALUE MEMBER
    /////////////////////////////////////////////////////////////////////////////////

    /**
     * This is the raw content of TitlePrefix. Could be null if {@code exists() == false}. Use {@link #value()} instead
     * if you want to get this as an {@link java.util.Optional}.
     * <p>
     * Raw Format: Variable length text, suggested maximum 20 characters
     * <p>
     * (type: dt.NonEmptyString)
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
    public static final TitlePrefix EMPTY = new TitlePrefix();

    public TitlePrefix() {
        exists = false;
    }

    public TitlePrefix(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcename = JPU.getAttribute(element, "sourcename");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        collationkey = JPU.getAttribute(element, "collationkey");
        language = Languages.byCode(JPU.getAttribute(element, "language"));
        textscript = TextScripts.byCode(JPU.getAttribute(element, "textscript"));
        textcase = TextCaseFlags.byCode(JPU.getAttribute(element, "textcase"));

        value = JPU.getContentAsString(element);
    }

    /**
     * @return whether this tag (&lt;TitlePrefix&gt; or &lt;b030&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<TitlePrefix> action) {
        if (exists) {
            action.accept(this);
        }
    }
}
