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

package com.tectonica.jonix.onix2;

import com.tectonica.jonix.common.JPU;
import com.tectonica.jonix.common.OnixComposite.OnixDataCompositeWithKey;
import com.tectonica.jonix.common.codelist.DiscountCodeTypes;
import com.tectonica.jonix.common.codelist.Languages;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.TextCaseFlags;
import com.tectonica.jonix.common.codelist.TextFormats;
import com.tectonica.jonix.common.codelist.TransliterationSchemes;
import com.tectonica.jonix.common.struct.JonixDiscountCoded;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Discount code composite</h1>
 * <p>
 * A repeatable group of data elements which together define a discount code from a specified scheme, and allowing
 * different discount code schemes to be supported without defining additional data elements. Optional.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;DiscountCoded&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;discountcoded&gt;</tt></td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Price}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link SupplyDetail} ⯈ {@link Price} ⯈ {@link DiscountCoded}</li>
 * <li>{@link Product} ⯈ {@link SupplyDetail} ⯈ {@link Reissue} ⯈ {@link Price} ⯈ {@link DiscountCoded}</li>
 * </ul>
 *
 * @since Onix-2.1
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
                case DiscountCodeType.refname:
                case DiscountCodeType.shortname:
                    discountCodeType = new DiscountCodeType(e);
                    break;
                case DiscountCode.refname:
                case DiscountCode.shortname:
                    discountCode = new DiscountCode(e);
                    break;
                case DiscountCodeTypeName.refname:
                case DiscountCodeTypeName.shortname:
                    discountCodeTypeName = new DiscountCodeTypeName(e);
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;DiscountCoded&gt; or &lt;discountcoded&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<DiscountCoded> action) {
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

    private DiscountCodeType discountCodeType = DiscountCodeType.EMPTY;

    /**
     * <p>
     * An ONIX code identifying the scheme from which the value in the &lt;DiscountCode&gt; element is taken. Mandatory
     * in each occurrence of the &lt;DiscountCoded&gt; composite, and non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public DiscountCodeType discountCodeType() {
        _initialize();
        return discountCodeType;
    }

    private DiscountCode discountCode = DiscountCode.EMPTY;

    /**
     * <p>
     * A discount code from the scheme specified in the &lt;DiscountCodeType&gt; element. Mandatory in each occurrence
     * of the &lt;DiscountCoded&gt; composite, and non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public DiscountCode discountCode() {
        _initialize();
        return discountCode;
    }

    private DiscountCodeTypeName discountCodeTypeName = DiscountCodeTypeName.EMPTY;

    /**
     * <p>
     * A name which identifies a proprietary discount code when the code in the &lt;DiscountCodeType&gt; element
     * indicates a proprietary scheme, <em>eg</em> a wholesaler’s own code. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public DiscountCodeTypeName discountCodeTypeName() {
        _initialize();
        return discountCodeTypeName;
    }

    @Override
    public JonixDiscountCoded asStruct() {
        _initialize();
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
