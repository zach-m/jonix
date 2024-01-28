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
import com.tectonica.jonix.common.OnixComposite.OnixDataCompositeWithKey;
import com.tectonica.jonix.common.codelist.IllustrationAndOtherContentTypes;
import com.tectonica.jonix.common.codelist.Languages;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.TextCaseFlags;
import com.tectonica.jonix.common.codelist.TextFormats;
import com.tectonica.jonix.common.codelist.TransliterationSchemes;
import com.tectonica.jonix.common.struct.JonixIllustrations;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Illustrations and other content composite</h1>
 * <p>
 * A repeatable group of data elements which together specify the number of illustrations or other content items of a
 * stated type which the product carries. Use of the &lt;Illustrations&gt; composite is optional.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;Illustrations&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;illustrations&gt;</tt></td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Product}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link Illustrations}</li>
 * </ul>
 */
public class Illustrations
    implements OnixDataCompositeWithKey<JonixIllustrations, IllustrationAndOtherContentTypes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Illustrations";
    public static final String shortname = "illustrations";

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
    public static final Illustrations EMPTY = new Illustrations();

    public Illustrations() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public Illustrations(org.w3c.dom.Element element) {
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
                case IllustrationType.refname:
                case IllustrationType.shortname:
                    illustrationType = new IllustrationType(e);
                    break;
                case IllustrationTypeDescription.refname:
                case IllustrationTypeDescription.shortname:
                    illustrationTypeDescription = new IllustrationTypeDescription(e);
                    break;
                case Number.refname:
                case Number.shortname:
                    number = new Number(e);
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;Illustrations&gt; or &lt;illustrations&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<Illustrations> action) {
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

    private IllustrationType illustrationType = IllustrationType.EMPTY;

    /**
     * <p>
     * An ONIX code which identifies the type of illustration or other content to which an occurrence of the composite
     * refers. Mandatory in each occurrence of the &lt;Illustrations&gt; composite, and non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public IllustrationType illustrationType() {
        _initialize();
        return illustrationType;
    }

    private IllustrationTypeDescription illustrationTypeDescription = IllustrationTypeDescription.EMPTY;

    /**
     * <p>
     * Text describing the type of illustration or other content to which an occurrence of the composite refers, when a
     * code is insufficient. Optional and non-repeating. Required when &lt;IllustrationType&gt; carries the value 00.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public IllustrationTypeDescription illustrationTypeDescription() {
        _initialize();
        return illustrationTypeDescription;
    }

    private Number number = Number.EMPTY;

    /**
     * <p>
     * The number of illustrations or other content items of the type specified in &lt;IllustrationType&gt;. Optional
     * and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public Number number() {
        _initialize();
        return number;
    }

    @Override
    public JonixIllustrations asStruct() {
        _initialize();
        JonixIllustrations struct = new JonixIllustrations();
        struct.illustrationType = illustrationType.value;
        struct.illustrationTypeDescription = illustrationTypeDescription.value;
        struct.number = number.value;
        return struct;
    }

    @Override
    public IllustrationAndOtherContentTypes structKey() {
        return illustrationType().value;
    }
}
