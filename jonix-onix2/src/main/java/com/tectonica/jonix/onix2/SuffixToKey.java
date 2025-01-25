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

import java.io.Serializable;
import java.util.function.Consumer;
import com.tectonica.jonix.common.JPU;
import com.tectonica.jonix.common.OnixElement;
import com.tectonica.jonix.common.codelist.*;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Person name part 6: suffix after key names</h1>
 * <p>
 * The sixth part of a structured name of a person who contributed to the creation of the product: a suffix following a
 * person’s key name(s), <em>eg</em> Jr or III. Optional and non-repeating.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Variable-length text, suggested maximum length 100 characters</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;SuffixToKey&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;b248&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td><tt>&lt;b248&gt;Jr&lt;/b248&gt;</tt></td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Name}&gt;</li>
 * <li>&lt;{@link Contributor}&gt;</li>
 * <li>&lt;{@link PersonAsSubject}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link Contributor} ⯈ {@link Name} ⯈ {@link SuffixToKey}</li>
 * <li>{@link Product} ⯈ {@link ContentItem} ⯈ {@link Contributor} ⯈ {@link Name} ⯈ {@link SuffixToKey}</li>
 * <li>{@link SubSeriesRecord} ⯈ {@link Contributor} ⯈ {@link Name} ⯈ {@link SuffixToKey}</li>
 * <li>{@link MainSeriesRecord} ⯈ {@link Contributor} ⯈ {@link Name} ⯈ {@link SuffixToKey}</li>
 * <li>{@link Product} ⯈ {@link Series} ⯈ {@link Contributor} ⯈ {@link Name} ⯈ {@link SuffixToKey}</li>
 * <li>{@link Product} ⯈ {@link PersonAsSubject} ⯈ {@link Name} ⯈ {@link SuffixToKey}</li>
 * <li>{@link Product} ⯈ {@link ContentItem} ⯈ {@link PersonAsSubject} ⯈ {@link Name} ⯈ {@link SuffixToKey}</li>
 * <li>{@link Product} ⯈ {@link Contributor} ⯈ {@link SuffixToKey}</li>
 * <li>{@link Product} ⯈ {@link ContentItem} ⯈ {@link Contributor} ⯈ {@link SuffixToKey}</li>
 * <li>{@link SubSeriesRecord} ⯈ {@link Contributor} ⯈ {@link SuffixToKey}</li>
 * <li>{@link MainSeriesRecord} ⯈ {@link Contributor} ⯈ {@link SuffixToKey}</li>
 * <li>{@link Product} ⯈ {@link Series} ⯈ {@link Contributor} ⯈ {@link SuffixToKey}</li>
 * <li>{@link Product} ⯈ {@link PersonAsSubject} ⯈ {@link SuffixToKey}</li>
 * <li>{@link Product} ⯈ {@link ContentItem} ⯈ {@link PersonAsSubject} ⯈ {@link SuffixToKey}</li>
 * </ul>
 */
public class SuffixToKey implements OnixElement<String>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "SuffixToKey";
    public static final String shortname = "b248";

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
     * This is the raw content of SuffixToKey. Could be null if {@code exists() == false}. Use {@link #value()} instead
     * if you want to get this as an {@link java.util.Optional}.
     * <p>
     * Raw Format: Variable-length text, suggested maximum length 100 characters
     * <p>
     * (type: NonEmptyString)
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
    public static final SuffixToKey EMPTY = new SuffixToKey();

    public SuffixToKey() {
        exists = false;
    }

    public SuffixToKey(org.w3c.dom.Element element) {
        exists = true;
        textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));
        textcase = TextCaseFlags.byCode(JPU.getAttribute(element, "textcase"));
        language = Languages.byCode(JPU.getAttribute(element, "language"));
        transliteration = TransliterationSchemes.byCode(JPU.getAttribute(element, "transliteration"));
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        value = JPU.getContentAsString(element);
    }

    /**
     * @return whether this tag (&lt;SuffixToKey&gt; or &lt;b248&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<SuffixToKey> action) {
        if (exists) {
            action.accept(this);
        }
    }
}
