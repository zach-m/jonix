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

package com.tectonica.jonix.onix2;

import com.tectonica.jonix.common.JPU;
import com.tectonica.jonix.common.OnixElement;
import com.tectonica.jonix.common.codelist.Languages;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.TextCaseFlags;
import com.tectonica.jonix.common.codelist.TextFormats;
import com.tectonica.jonix.common.codelist.TransliterationSchemes;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Text accompanying download</h1>
 * <p>
 * Unstructured text associated with a file which is available for download, and intended to be displayed whenever the
 * file content is used. Optional and non-repeating. Text may include credits, copyright notice, <em>etc</em>. If this
 * field is sent, the individual elements &lt;DownloadCaption&gt;, &lt;DownloadCredit&gt;, and
 * &lt;DownloadCopyrightNotice&gt; must not be sent, and vice versa.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Variable-length text, suggested maximum length 1,000 characters (XHTML is enabled in this element - see ONIX for
 * Books - Product Information Message - XML Message Specification, Section 7)</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;TextWithDownload&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;f118&gt;</tt></td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link MediaFile}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link MediaFile} ⯈ {@link TextWithDownload}</li>
 * <li>{@link Product} ⯈ {@link ContentItem} ⯈ {@link MediaFile} ⯈ {@link TextWithDownload}</li>
 * <li>{@link Product} ⯈ {@link SupplyDetail} ⯈ {@link Reissue} ⯈ {@link MediaFile} ⯈ {@link TextWithDownload}</li>
 * </ul>
 */
public class TextWithDownload implements OnixElement<String>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "TextWithDownload";
    public static final String shortname = "f118";

    /////////////////////////////////////////////////////////////////////////////////
    // ATTRIBUTES
    /////////////////////////////////////////////////////////////////////////////////

    public TextFormats textformat;

    public TextCaseFlags textcase;

    public Languages language;

    public TransliterationSchemes transliteration;

    /**
     * (type: DateOrDateTime)
     */
    public String datestamp;

    public RecordSourceTypes sourcetype;

    public String sourcename;

    /////////////////////////////////////////////////////////////////////////////////
    // VALUE MEMBER
    /////////////////////////////////////////////////////////////////////////////////

    /**
     * This is the raw content of TextWithDownload. Could be null if {@code exists() == false}. Use {@link #value()}
     * instead if you want to get this as an {@link java.util.Optional}.
     * <p>
     * Raw Format: Variable-length text, suggested maximum length 1,000 characters (XHTML is enabled in this element -
     * see ONIX for Books - Product Information Message - XML Message Specification, Section 7)
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
    public static final TextWithDownload EMPTY = new TextWithDownload();

    public TextWithDownload() {
        exists = false;
    }

    public TextWithDownload(org.w3c.dom.Element element) {
        exists = true;
        textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));
        textcase = TextCaseFlags.byCode(JPU.getAttribute(element, "textcase"));
        language = Languages.byCode(JPU.getAttribute(element, "language"));
        transliteration = TransliterationSchemes.byCode(JPU.getAttribute(element, "transliteration"));
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        value = JPU.getChildXHTML(element, true);
    }

    /**
     * @return whether this tag (&lt;TextWithDownload&gt; or &lt;f118&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<TextWithDownload> action) {
        if (exists) {
            action.accept(this);
        }
    }
}
