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
import com.tectonica.jonix.OnixComposite.OnixDataCompositeWithKey;
import com.tectonica.jonix.codelist.ExtentTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixExtent;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Extent composite</h1><p>A repeatable group of data elements which together describe an extent pertaining to the
 * product. Optional, but in practice required for most products, <i>eg</i> to give the number of pages in a printed
 * book or paginated e-book, or to give the running time of an audiobook.</p><table border='1'
 * cellpadding='3'><tr><td>Reference name</td><td>&lt;Extent&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;extent&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;n</td></tr></table>
 */
public class Extent implements OnixDataCompositeWithKey<JonixExtent, ExtentTypes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Extent";
    public static final String shortname = "extent";

    /////////////////////////////////////////////////////////////////////////////////
    // ATTRIBUTES
    /////////////////////////////////////////////////////////////////////////////////

    /**
     * (type: dt.DateOrDateTime)
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
    }

    private void initialize() {
        if (initialized) {
            return;
        }
        initialized = true;

        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

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
                case ExtentValueRoman.refname:
                case ExtentValueRoman.shortname:
                    extentValueRoman = new ExtentValueRoman(e);
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

    @Override
    public boolean exists() {
        return exists;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private ExtentType extentType = ExtentType.EMPTY;

    /**
     * (this field is required)
     */
    public ExtentType extentType() {
        initialize();
        return extentType;
    }

    private ExtentValue extentValue = ExtentValue.EMPTY;

    /**
     * (this field is required)
     */
    public ExtentValue extentValue() {
        initialize();
        return extentValue;
    }

    private ExtentValueRoman extentValueRoman = ExtentValueRoman.EMPTY;

    /**
     * (this field is optional)
     */
    public ExtentValueRoman extentValueRoman() {
        initialize();
        return extentValueRoman;
    }

    private ExtentUnit extentUnit = ExtentUnit.EMPTY;

    /**
     * (this field is required)
     */
    public ExtentUnit extentUnit() {
        initialize();
        return extentUnit;
    }

    @Override
    public JonixExtent asStruct() {
        initialize();
        JonixExtent struct = new JonixExtent();
        struct.extentType = extentType.value;
        struct.extentUnit = extentUnit.value;
        struct.extentValue = extentValue.value;
        return struct;
    }

    @Override
    public ExtentTypes structKey() {
        return extentType().value;
    }
}
