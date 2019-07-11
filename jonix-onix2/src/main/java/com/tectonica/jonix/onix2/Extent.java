/*
 * Copyright (C) 2012 Zach Melamed
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
import com.tectonica.jonix.common.codelist.ExtentTypes;
import com.tectonica.jonix.common.codelist.Languages;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.TextCaseFlags;
import com.tectonica.jonix.common.codelist.TextFormats;
import com.tectonica.jonix.common.codelist.TransliterationSchemes;
import com.tectonica.jonix.common.struct.JonixExtent;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Extent composite</h1>
 * <p>
 * A repeatable group of data elements which together describe an extent pertaining to the product.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;Extent&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;extent&gt;</tt></td>
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
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link Extent}</li>
 * </ul>
 */
public class Extent implements OnixDataCompositeWithKey<JonixExtent, ExtentTypes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Extent";
    public static final String shortname = "extent";

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
    public static final Extent EMPTY = new Extent();

    public Extent() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public Extent(org.w3c.dom.Element element) {
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
                case ExtentType.refname:
                case ExtentType.shortname:
                    extentType = new ExtentType(e);
                    break;
                case ExtentValue.refname:
                case ExtentValue.shortname:
                    extentValue = new ExtentValue(e);
                    break;
                case ExtentUnit.refname:
                case ExtentUnit.shortname:
                    extentUnit = new ExtentUnit(e);
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;Extent&gt; or &lt;extent&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private ExtentType extentType = ExtentType.EMPTY;

    /**
     * <p>
     * An ONIX code which identifies the type of extent carried in the composite, <em>eg</em> running time for an audio
     * or video product. Mandatory in each occurrence of the &lt;Extent&gt; composite, and non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public ExtentType extentType() {
        _initialize();
        return extentType;
    }

    private ExtentValue extentValue = ExtentValue.EMPTY;

    /**
     * <p>
     * The numeric value of the extent specified in &lt;ExtentType&gt;. Mandatory in each occurrence of the
     * &lt;Extent&gt; composite, and non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public ExtentValue extentValue() {
        _initialize();
        return extentValue;
    }

    private ExtentUnit extentUnit = ExtentUnit.EMPTY;

    /**
     * <p>
     * An ONIX code indicating the unit used for the &lt;ExtentValue&gt; and the format in which the value is presented.
     * Mandatory in each occurrence of the &lt;Extent&gt; composite, and non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public ExtentUnit extentUnit() {
        _initialize();
        return extentUnit;
    }

    @Override
    public JonixExtent asStruct() {
        _initialize();
        JonixExtent struct = new JonixExtent();
        struct.extentType = extentType.value;
        struct.extentUnit = extentUnit.value;
        struct.extentValue = JPU.convertStringToDouble(extentValue.value);
        return struct;
    }

    @Override
    public ExtentTypes structKey() {
        return extentType().value;
    }
}
