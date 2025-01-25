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
import com.tectonica.jonix.common.OnixComposite.OnixDataCompositeUncommon;
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
 * <h1>Imprint or brand composite</h1>
 * <p>
 * A repeatable group of data elements which together identify an imprint or brand under which the product is marketed.
 * The composite must carry either a name code or a name or both.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;Imprint&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;imprint&gt;</tt></td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Product}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link Imprint}</li>
 * </ul>
 */
public class Imprint implements OnixDataCompositeUncommon, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Imprint";
    public static final String shortname = "imprint";

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
    public static final Imprint EMPTY = new Imprint();

    public Imprint() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public Imprint(org.w3c.dom.Element element) {
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
                case NameCodeType.refname:
                case NameCodeType.shortname:
                    nameCodeType = new NameCodeType(e);
                    break;
                case NameCodeValue.refname:
                case NameCodeValue.shortname:
                    nameCodeValue = new NameCodeValue(e);
                    break;
                case ImprintName.refname:
                case ImprintName.shortname:
                    imprintName = new ImprintName(e);
                    break;
                case NameCodeTypeName.refname:
                case NameCodeTypeName.shortname:
                    nameCodeTypeName = new NameCodeTypeName(e);
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;Imprint&gt; or &lt;imprint&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<Imprint> action) {
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

    private NameCodeType nameCodeType = NameCodeType.EMPTY;

    /**
     * <p>
     * An ONIX code which identifies the scheme from which the value in the &lt;NameCodeValue&gt; element is taken.
     * Optional and non-repeating, but mandatory if the &lt;Imprint&gt; composite does not carry an &lt;ImprintName&gt;.
     * </p>
     * JONIX adds: this field is required
     */
    public NameCodeType nameCodeType() {
        _initialize();
        return nameCodeType;
    }

    private NameCodeValue nameCodeValue = NameCodeValue.EMPTY;

    /**
     * <p>
     * A code value taken from the scheme specified in &lt;NameCodeType&gt;. Mandatory if and only if
     * &lt;NameCodeType&gt; is present, and non-repeating.
     * </p>
     * JONIX adds: this field is required
     */
    public NameCodeValue nameCodeValue() {
        _initialize();
        return nameCodeValue;
    }

    private ImprintName imprintName = ImprintName.EMPTY;

    /**
     * <p>
     * The name of an imprint or brand under which the product is issued, as it appears on the product. Mandatory if
     * there is no name code in an occurrence of the &lt;Imprint&gt; composite, and optional if a name code is included.
     * Non-repeating.
     * </p>
     * JONIX adds: this field is optional
     */
    public ImprintName imprintName() {
        _initialize();
        return imprintName;
    }

    private NameCodeTypeName nameCodeTypeName = NameCodeTypeName.EMPTY;

    /**
     * <p>
     * A name which identifies a proprietary name code when the code in &lt;NameCodeType&gt; indicates a proprietary
     * scheme, <em>eg</em> a bibliographic agency’s own code. Optional and non-repeating.
     * </p>
     * JONIX adds: this field is optional
     */
    public NameCodeTypeName nameCodeTypeName() {
        _initialize();
        return nameCodeTypeName;
    }
}
