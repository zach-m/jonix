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
import com.tectonica.jonix.common.OnixComposite.OnixDataCompositeWithKey;
import com.tectonica.jonix.common.codelist.Languages;
import com.tectonica.jonix.common.codelist.PersonDateRoles;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.TextCaseFlags;
import com.tectonica.jonix.common.codelist.TextFormats;
import com.tectonica.jonix.common.codelist.TransliterationSchemes;
import com.tectonica.jonix.common.struct.JonixPersonDate;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Person date composite</h1>
 * <p>
 * A repeatable group of data elements which together specify a date associated with the person identified in an
 * occurrence of the &lt;Contributor&gt; composite, <em>eg</em> birth or death.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;PersonDate&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;persondate&gt;</tt></td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Contributor}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link Contributor} ⯈ {@link PersonDate}</li>
 * <li>{@link Product} ⯈ {@link ContentItem} ⯈ {@link Contributor} ⯈ {@link PersonDate}</li>
 * <li>{@link SubSeriesRecord} ⯈ {@link Contributor} ⯈ {@link PersonDate}</li>
 * <li>{@link MainSeriesRecord} ⯈ {@link Contributor} ⯈ {@link PersonDate}</li>
 * <li>{@link Product} ⯈ {@link Series} ⯈ {@link Contributor} ⯈ {@link PersonDate}</li>
 * </ul>
 *
 * @since Onix-2.1
 */
public class PersonDate implements OnixDataCompositeWithKey<JonixPersonDate, PersonDateRoles>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "PersonDate";
    public static final String shortname = "persondate";

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
    public static final PersonDate EMPTY = new PersonDate();

    public PersonDate() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public PersonDate(org.w3c.dom.Element element) {
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
                case PersonDateRole.refname:
                case PersonDateRole.shortname:
                    personDateRole = new PersonDateRole(e);
                    break;
                case Date.refname:
                case Date.shortname:
                    date = new Date(e);
                    break;
                case DateFormat.refname:
                case DateFormat.shortname:
                    dateFormat = new DateFormat(e);
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;PersonDate&gt; or &lt;persondate&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<PersonDate> action) {
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

    private PersonDateRole personDateRole = PersonDateRole.EMPTY;

    /**
     * <p>
     * An ONIX code indicating the significance of the date in relation to the contributor name. Mandatory in each
     * occurrence of the &lt;PersonDate&gt; composite.
     * </p>
     * JONIX adds: this field is required
     */
    public PersonDateRole personDateRole() {
        _initialize();
        return personDateRole;
    }

    private Date date = Date.EMPTY;

    /**
     * <p>
     * The date specified in the &lt;PersonDateRole&gt; field. Mandatory in each occurrence of the &lt;PersonDate&gt;
     * composite.
     * </p>
     * JONIX adds: this field is required
     */
    public Date date() {
        _initialize();
        return date;
    }

    private DateFormat dateFormat = DateFormat.EMPTY;

    /**
     * <p>
     * An ONIX code indicating the format in which the date is given in &lt;Date&gt;. Optional and non-repeating. When
     * omitted, the format is assumed to be YYYYMMDD.
     * </p>
     * JONIX adds: this field is optional
     */
    public DateFormat dateFormat() {
        _initialize();
        return dateFormat;
    }

    @Override
    public JonixPersonDate asStruct() {
        _initialize();
        JonixPersonDate struct = new JonixPersonDate();
        struct.personDateRole = personDateRole.value;
        struct.dateFormat = dateFormat.value;
        struct.date = date.value;
        return struct;
    }

    @Override
    public PersonDateRoles structKey() {
        return personDateRole().value;
    }
}
