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

package com.tectonica.jonix.onix3;

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.OnixComposite.OnixDataComposite;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixEpubUsageLimit;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Usage limit composite (digital products)</h1><p>An optional group of data elements which together specify a
 * quantitative limit on a particular type of usage of a digital product. Repeatable in order to specify two or more
 * limits on the usage type.</p><table border='1' cellpadding='3'><tr><td>Reference
 * name</td><td>&lt;EpubUsageLimit&gt;</td></tr><tr><td>Short tag</td><td>&lt;epubusagelimit&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;n</td></tr></table>
 */
public class EpubUsageLimit implements OnixDataComposite<JonixEpubUsageLimit>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "EpubUsageLimit";
    public static final String shortname = "epubusagelimit";

    /////////////////////////////////////////////////////////////////////////////////
    // ATTRIBUTES
    /////////////////////////////////////////////////////////////////////////////////

    /**
     * (type: dt.DateOrDateTime)
     */
    public String datestamp;

    public RecordSourceTypes sourcetype;

    /**
     * (type: dt.NonEmptyString)
     */
    public String sourcename;

    /////////////////////////////////////////////////////////////////////////////////
    // CONSTRUCTION
    /////////////////////////////////////////////////////////////////////////////////

    private boolean initialized;
    private final boolean exists;
    private final org.w3c.dom.Element element;
    public static final EpubUsageLimit EMPTY = new EpubUsageLimit();

    public EpubUsageLimit() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public EpubUsageLimit(org.w3c.dom.Element element) {
        exists = true;
        initialized = false;
        this.element = element;
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
                case Quantity.refname:
                case Quantity.shortname:
                    quantity = new Quantity(e);
                    break;
                case EpubUsageUnit.refname:
                case EpubUsageUnit.shortname:
                    epubUsageUnit = new EpubUsageUnit(e);
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

    private Quantity quantity = Quantity.EMPTY;

    /**
     * (this field is required)
     */
    public Quantity quantity() {
        _initialize();
        return quantity;
    }

    private EpubUsageUnit epubUsageUnit = EpubUsageUnit.EMPTY;

    /**
     * (this field is required)
     */
    public EpubUsageUnit epubUsageUnit() {
        _initialize();
        return epubUsageUnit;
    }

    @Override
    public JonixEpubUsageLimit asStruct() {
        _initialize();
        JonixEpubUsageLimit struct = new JonixEpubUsageLimit();
        struct.quantity = quantity.value;
        struct.epubUsageUnit = epubUsageUnit.value;
        return struct;
    }
}
