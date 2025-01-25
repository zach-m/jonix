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
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.Consumer;

import com.tectonica.jonix.common.*;
import com.tectonica.jonix.common.OnixComposite.*;
import com.tectonica.jonix.common.codelist.*;
import com.tectonica.jonix.common.struct.*;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Language composite</h1>
 * <p>
 * A repeatable group of data elements which together represent a language, and specify its role and, where required,
 * whether it is a country variant.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;Language&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;language&gt;</tt></td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Product}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link Language}</li>
 * </ul>
 */
public class Language implements OnixDataCompositeWithKey<JonixLanguage, LanguageRoles>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Language";
    public static final String shortname = "language";

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
    // CONSTRUCTION
    /////////////////////////////////////////////////////////////////////////////////

    private boolean initialized;
    private final boolean exists;
    private final org.w3c.dom.Element element;
    public static final Language EMPTY = new Language();

    public Language() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public Language(org.w3c.dom.Element element) {
        exists = true;
        initialized = false;
        this.element = element;
        textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));
        textcase = TextCaseFlags.byCode(JPU.getAttribute(element, "textcase"));
        language = Languages.byCode(JPU.getAttribute(element, "language"));
        transliteration = TransliterationSchemes.byCode(JPU.getAttribute(element, "transliteration"));
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");
    }

    @Override
    public void _initialize() {
        if (initialized) {
            return;
        }
        initialized = true;

        JPU.forElementsOf(element, e -> {
            final String name = e.getNodeName();
            switch (name) {
                case LanguageRole.refname:
                case LanguageRole.shortname:
                    languageRole = new LanguageRole(e);
                    break;
                case LanguageCode.refname:
                case LanguageCode.shortname:
                    languageCode = new LanguageCode(e);
                    break;
                case CountryCode.refname:
                case CountryCode.shortname:
                    countryCode = new CountryCode(e);
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;Language&gt; or &lt;language&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<Language> action) {
        if (exists) {
            action.accept(this);
        }
    }

    @Override
    public org.w3c.dom.Element getXmlElement() {
        return element;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private LanguageRole languageRole = LanguageRole.EMPTY;

    /**
     * <p>
     * An ONIX code indicating the “role” of a language in the context of the ONIX record. Mandatory in each occurrence
     * of the &lt;Language&gt; composite, and non-repeating.
     * </p>
     * JONIX adds: this field is required
     */
    public LanguageRole languageRole() {
        _initialize();
        return languageRole;
    }

    private LanguageCode languageCode = LanguageCode.EMPTY;

    /**
     * <p>
     * An ISO code indicating a language. Mandatory in each occurrence of the &lt;Language&gt; composite, and
     * non-repeating.
     * </p>
     * JONIX adds: this field is required
     */
    public LanguageCode languageCode() {
        _initialize();
        return languageCode;
    }

    private CountryCode countryCode = CountryCode.EMPTY;

    /**
     * <p>
     * A code identifying the country when this specifies a variant of the language, <em>eg</em> US English. Optional
     * and non-repeating.
     * </p>
     * JONIX adds: this field is optional
     */
    public CountryCode countryCode() {
        _initialize();
        return countryCode;
    }

    @Override
    public JonixLanguage asStruct() {
        _initialize();
        JonixLanguage struct = new JonixLanguage();
        struct.languageRole = languageRole.value;
        struct.countryCode = countryCode.value;
        struct.languageCode = languageCode.value;
        return struct;
    }

    @Override
    public LanguageRoles structKey() {
        return languageRole().value;
    }
}
