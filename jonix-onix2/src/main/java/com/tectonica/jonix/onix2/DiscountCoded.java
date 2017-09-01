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

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.OnixComposite.OnixDataCompositeWithKey;
import com.tectonica.jonix.codelist.DiscountCodeTypes;
import com.tectonica.jonix.codelist.LanguageCodes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;
import com.tectonica.jonix.struct.JonixDiscountCoded;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Discount code composite</h1><p>A repeatable group of data elements which together define a discount code from a
 * specified scheme, and allowing different discount code schemes to be supported without defining additional data
 * elements. Optional.</p><table border='1' cellpadding='3'><tr><td>Reference name</td><td>&lt;DiscountCoded&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;discountcoded&gt;</td></tr></table>
 */
public class DiscountCoded implements OnixDataCompositeWithKey<JonixDiscountCoded, DiscountCodeTypes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "DiscountCoded";
    public static final String shortname = "discountcoded";

    /////////////////////////////////////////////////////////////////////////////////
    // ATTRIBUTES
    /////////////////////////////////////////////////////////////////////////////////

    public TextFormats textformat;

    public TextCaseFlags textcase;

    public LanguageCodes language;

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
    public static final DiscountCoded EMPTY = new DiscountCoded();

    public DiscountCoded() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public DiscountCoded(org.w3c.dom.Element element) {
        exists = true;
        initialized = false;
        this.element = element;
    }

    private void initialize() {
        if (initialized) {
            return;
        }
        initialized = true;

        textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));
        textcase = TextCaseFlags.byCode(JPU.getAttribute(element, "textcase"));
        language = LanguageCodes.byCode(JPU.getAttribute(element, "language"));
        transliteration = TransliterationSchemes.byCode(JPU.getAttribute(element, "transliteration"));
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        JPU.forElementsOf(element, e -> {
            final String name = e.getNodeName();
            switch (name) {
                case DiscountCodeType.refname:
                case DiscountCodeType.shortname:
                    discountCodeType = new DiscountCodeType(e);
                    break;
                case DiscountCodeTypeName.refname:
                case DiscountCodeTypeName.shortname:
                    discountCodeTypeName = new DiscountCodeTypeName(e);
                    break;
                case DiscountCode.refname:
                case DiscountCode.shortname:
                    discountCode = new DiscountCode(e);
                    break;
                default:
                    break;
            }
        });
    }

    @Override
    public boolean exists() {
        return exists;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private DiscountCodeType discountCodeType = DiscountCodeType.EMPTY;

    /**
     * (this field is required)
     */
    public DiscountCodeType discountCodeType() {
        initialize();
        return discountCodeType;
    }

    private DiscountCodeTypeName discountCodeTypeName = DiscountCodeTypeName.EMPTY;

    /**
     * (this field is optional)
     */
    public DiscountCodeTypeName discountCodeTypeName() {
        initialize();
        return discountCodeTypeName;
    }

    private DiscountCode discountCode = DiscountCode.EMPTY;

    /**
     * (this field is required)
     */
    public DiscountCode discountCode() {
        initialize();
        return discountCode;
    }

    @Override
    public JonixDiscountCoded asStruct() {
        initialize();
        JonixDiscountCoded struct = new JonixDiscountCoded();
        struct.discountCodeType = discountCodeType.value;
        struct.discountCode = discountCode.value;
        struct.discountCodeTypeName = discountCodeTypeName.value;
        return struct;
    }

    @Override
    public DiscountCodeTypes structKey() {
        return discountCodeType().value;
    }
}
