/*
 * Copyright (C) 2012-2023 Zach Melamed
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
import com.tectonica.jonix.common.OnixComposite.OnixDataCompositeWithKey;
import com.tectonica.jonix.common.codelist.LanguageRoles;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixLanguage;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Language composite</h1>
 * <p>
 * A group of data elements which together represent a language, and specify its role and, where required, whether it is
 * a country variant. Optional, and repeatable to specify multiple languages and their various roles.
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
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link DescriptiveDetail}&gt;</li>
 * <li>&lt;{@link ContentItem}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Language}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link Language}</li>
 * </ul>
 */
public class Language implements OnixDataCompositeWithKey<JonixLanguage, LanguageRoles>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Language";
    public static final String shortname = "language";

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
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcename = JPU.getAttribute(element, "sourcename");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
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
                case RegionCode.refname:
                case RegionCode.shortname:
                    regionCode = new RegionCode(e);
                    break;
                case ScriptCode.refname:
                case ScriptCode.shortname:
                    scriptCode = new ScriptCode(e);
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
     * An ONIX code indicating the ‘role’ of a language in the context of the ONIX record. Mandatory in each occurrence
     * of the &lt;Language&gt; composite, and non-repeating.
     * </p>
     * Jonix-Comment: this field is required
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
     * Jonix-Comment: this field is required
     */
    public LanguageCode languageCode() {
        _initialize();
        return languageCode;
    }

    private CountryCode countryCode = CountryCode.EMPTY;

    /**
     * <p>
     * A code identifying the country when this specifies a variant of the language, <i>eg</i> US English. Optional and
     * non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public CountryCode countryCode() {
        _initialize();
        return countryCode;
    }

    private RegionCode regionCode = RegionCode.EMPTY;

    /**
     * <p>
     * An ONIX code identifying the region when this specifies a variant of the language <i>eg</i> Flemish – Dutch as
     * used in the Flemish region of Belgium. Optional and non-repeatable. A region is an area which is not a country
     * (in the sense that it does not have a distinct country code), but which is precisely defined in geographical
     * terms, <i>eg</i> Quebec, Scotland. If both country and region are specified, the region must be within the
     * country. Note that US States have region codes, while US overseas territories have distinct ISO Country Codes.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public RegionCode regionCode() {
        _initialize();
        return regionCode;
    }

    private ScriptCode scriptCode = ScriptCode.EMPTY;

    /**
     * <p>
     * A code identifying the script in which the language is represented. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public ScriptCode scriptCode() {
        _initialize();
        return scriptCode;
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
