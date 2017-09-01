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
import com.tectonica.jonix.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.codelist.LanguageCodes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Sales restriction composite</h1><p>A group of data elements which together identify a non-territorial sales
 * restriction which a publisher applies to a product. Optional and repeatable.</p><table border='1'
 * cellpadding='3'><tr><td>Reference name</td><td>&lt;SalesRestriction&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;salesrestriction&gt;</td></tr></table>
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
            if (name.equals(SalesRestrictionType.refname) || name.equals(SalesRestrictionType.shortname)) {
                salesRestrictionType = new SalesRestrictionType(e);
            } else if (name.equals(SalesOutlet.refname) || name.equals(SalesOutlet.shortname)) {
                salesOutlets = JPU.addToList(salesOutlets, new SalesOutlet(e));
            } else if (name.equals(SalesRestrictionDetail.refname) || name.equals(SalesRestrictionDetail.shortname)) {
                salesRestrictionDetail = new SalesRestrictionDetail(e);
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

    private SalesRestrictionType salesRestrictionType = SalesRestrictionType.EMPTY;

    /**
     * (this field is required)
     */
    public SalesRestrictionType salesRestrictionType() {
        initialize();
        return salesRestrictionType;
    }

    private List<SalesOutlet> salesOutlets = Collections.emptyList();

    /**
     * (this list may be empty)
     */
    public List<SalesOutlet> salesOutlets() {
        initialize();
        return salesOutlets;
    }

    private SalesRestrictionDetail salesRestrictionDetail = SalesRestrictionDetail.EMPTY;

    /**
     * (this field is optional)
     */
    public SalesRestrictionDetail salesRestrictionDetail() {
        initialize();
        return salesRestrictionDetail;
    }
}
