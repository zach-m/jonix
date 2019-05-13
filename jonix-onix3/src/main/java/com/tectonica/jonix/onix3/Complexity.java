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
import com.tectonica.jonix.struct.JonixComplexity;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Complexity composite</h1><p>An optional group of data elements which together describe the level of complexity of
 * a text. Repeatable to specify the complexity using different schemes.</p><table border='1'
 * cellpadding='3'><tr><td>Reference name</td><td>&lt;Complexity&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;complexity&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;n</td></tr></table>
 */
public class Complexity implements OnixDataComposite<JonixComplexity>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Complexity";
    public static final String shortname = "complexity";

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
    public static final Complexity EMPTY = new Complexity();

    public Complexity() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public Complexity(org.w3c.dom.Element element) {
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
                case ComplexitySchemeIdentifier.refname:
                case ComplexitySchemeIdentifier.shortname:
                    complexitySchemeIdentifier = new ComplexitySchemeIdentifier(e);
                    break;
                case ComplexityCode.refname:
                case ComplexityCode.shortname:
                    complexityCode = new ComplexityCode(e);
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

    private ComplexitySchemeIdentifier complexitySchemeIdentifier = ComplexitySchemeIdentifier.EMPTY;

    /**
     * (this field is required)
     */
    public ComplexitySchemeIdentifier complexitySchemeIdentifier() {
        _initialize();
        return complexitySchemeIdentifier;
    }

    private ComplexityCode complexityCode = ComplexityCode.EMPTY;

    /**
     * (this field is required)
     */
    public ComplexityCode complexityCode() {
        _initialize();
        return complexityCode;
    }

    @Override
    public JonixComplexity asStruct() {
        _initialize();
        JonixComplexity struct = new JonixComplexity();
        struct.complexityCode = complexityCode.value;
        struct.complexitySchemeIdentifier = complexitySchemeIdentifier.value;
        return struct;
    }
}
