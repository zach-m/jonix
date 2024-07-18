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
 * <h1>Person name part 7: qualifications and honors after names</h1>
 * <p>
 * The seventh part of a structured name of a person who contributed to the creation of the product: qualifications and
 * honors following a person’s names, <em>eg</em> CBE FRS. Optional and non-repeating.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Variable-length text, suggested maximum length 100 characters</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;LettersAfterNames&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;b042&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td><tt>&lt;b042&gt;MB FRCS&lt;/b042&gt;</tt></td>
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
 * <li>{@link Product} ⯈ {@link Contributor} ⯈ {@link Name} ⯈ {@link LettersAfterNames}</li>
 * <li>{@link Product} ⯈ {@link ContentItem} ⯈ {@link Contributor} ⯈ {@link Name} ⯈ {@link LettersAfterNames}</li>
 * <li>{@link SubSeriesRecord} ⯈ {@link Contributor} ⯈ {@link Name} ⯈ {@link LettersAfterNames}</li>
 * <li>{@link MainSeriesRecord} ⯈ {@link Contributor} ⯈ {@link Name} ⯈ {@link LettersAfterNames}</li>
 * <li>{@link Product} ⯈ {@link Series} ⯈ {@link Contributor} ⯈ {@link Name} ⯈ {@link LettersAfterNames}</li>
 * <li>{@link Product} ⯈ {@link PersonAsSubject} ⯈ {@link Name} ⯈ {@link LettersAfterNames}</li>
 * <li>{@link Product} ⯈ {@link ContentItem} ⯈ {@link PersonAsSubject} ⯈ {@link Name} ⯈ {@link LettersAfterNames}</li>
 * <li>{@link Product} ⯈ {@link Contributor} ⯈ {@link LettersAfterNames}</li>
 * <li>{@link Product} ⯈ {@link ContentItem} ⯈ {@link Contributor} ⯈ {@link LettersAfterNames}</li>
 * <li>{@link SubSeriesRecord} ⯈ {@link Contributor} ⯈ {@link LettersAfterNames}</li>
 * <li>{@link MainSeriesRecord} ⯈ {@link Contributor} ⯈ {@link LettersAfterNames}</li>
 * <li>{@link Product} ⯈ {@link Series} ⯈ {@link Contributor} ⯈ {@link LettersAfterNames}</li>
 * <li>{@link Product} ⯈ {@link PersonAsSubject} ⯈ {@link LettersAfterNames}</li>
 * <li>{@link Product} ⯈ {@link ContentItem} ⯈ {@link PersonAsSubject} ⯈ {@link LettersAfterNames}</li>
 * </ul>
 */
public class LettersAfterNames implements OnixElement<String>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "LettersAfterNames";
    public static final String shortname = "b042";

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
     * This is the raw content of LettersAfterNames. Could be null if {@code exists() == false}. Use {@link #value()}
     * instead if you want to get this as an {@link java.util.Optional}.
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
    public static final LettersAfterNames EMPTY = new LettersAfterNames();

    public LettersAfterNames() {
        exists = false;
    }

    public LettersAfterNames(org.w3c.dom.Element element) {
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
     * @return whether this tag (&lt;LettersAfterNames&gt; or &lt;b042&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<LettersAfterNames> action) {
        if (exists) {
            action.accept(this);
        }
    }
}
