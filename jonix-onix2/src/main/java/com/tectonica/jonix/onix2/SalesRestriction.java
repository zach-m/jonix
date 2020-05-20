/*
 * Copyright (C) 2012-2020 Zach Melamed
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
import com.tectonica.jonix.common.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.common.codelist.Languages;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.TextCaseFlags;
import com.tectonica.jonix.common.codelist.TextFormats;
import com.tectonica.jonix.common.codelist.TransliterationSchemes;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Sales restriction composite</h1>
 * <p>
 * A group of data elements which together identify a non-territorial sales restriction which a publisher applies to a
 * product. Optional and repeatable.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;SalesRestriction&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;salesrestriction&gt;</tt></td>
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
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link SalesRestriction}</li>
 * </ul>
 *
 * @since Onix-2.1
 */
public class SalesRestriction implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "SalesRestriction";
    public static final String shortname = "salesrestriction";

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
    public static final SalesRestriction EMPTY = new SalesRestriction();

    public SalesRestriction() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public SalesRestriction(org.w3c.dom.Element element) {
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
                case SalesRestrictionType.refname:
                case SalesRestrictionType.shortname:
                    salesRestrictionType = new SalesRestrictionType(e);
                    break;
                case SalesRestrictionDetail.refname:
                case SalesRestrictionDetail.shortname:
                    salesRestrictionDetail = new SalesRestrictionDetail(e);
                    break;
                case SalesOutlet.refname:
                case SalesOutlet.shortname:
                    salesOutlets = JPU.addToList(salesOutlets, new SalesOutlet(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;SalesRestriction&gt; or &lt;salesrestriction&gt;) is explicitly provided in the
     *         ONIX XML
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

    private SalesRestrictionType salesRestrictionType = SalesRestrictionType.EMPTY;

    /**
     * <p>
     * An ONIX code which identifies a non-territorial sales restriction. Mandatory in each occurrence of the
     * &lt;SalesRestriction&gt; composite, and non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public SalesRestrictionType salesRestrictionType() {
        _initialize();
        return salesRestrictionType;
    }

    private SalesRestrictionDetail salesRestrictionDetail = SalesRestrictionDetail.EMPTY;

    /**
     * <p>
     * A free text field describing an “unspecified” restriction, or giving more explanation of a coded restriction
     * type. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public SalesRestrictionDetail salesRestrictionDetail() {
        _initialize();
        return salesRestrictionDetail;
    }

    private List<SalesOutlet> salesOutlets = Collections.emptyList();

    /**
     * <p>
     * An optional and repeatable group of data elements which together identify a sales outlet to which a restriction
     * is linked. Each occurrence of the composite must include a &lt;SalesOutletIdentifier&gt; composite or a
     * &lt;SalesOutletName&gt; or both.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public List<SalesOutlet> salesOutlets() {
        _initialize();
        return salesOutlets;
    }
}
