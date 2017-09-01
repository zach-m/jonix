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
import com.tectonica.jonix.OnixElement;
import com.tectonica.jonix.codelist.RecordSourceTypes;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Resource version feature value</h1><p>A controlled value that describes a resource version feature. Presence or
 * absence of this element depends on the &lt;ResourceVersionFeatureType&gt;, since some features may not require an
 * accompanying value, while others may require free text in &lt;FeatureNote&gt;, and others may have both a value and
 * free text. Non-repeating.</p><table border='1' cellpadding='3'><tr><td>Format</td><td>Dependent on the feature
 * specified in &lt;ResourceVersionFeatureType&gt;; the feature value may or may not be taken from a code
 * list</td></tr><tr><td>Codelist</td><td>Dependent on the feature specified in &lt;ResourceVersionFeatureType&gt;</td></tr><tr><td></td><td>For
 * file format, use List 178</td></tr><tr><td>Reference name</td><td>&lt;FeatureValue&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;x439&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;1</td></tr><tr><td>Example</td><td>&lt;FeatureValue&gt;250&lt;/FeatureValue&gt;</td></tr></table>
 */
public class FeatureValue implements OnixElement<String>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "FeatureValue";
    public static final String shortname = "x439";

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
    // VALUE MEMBER
    /////////////////////////////////////////////////////////////////////////////////

    /**
     * Raw Format: Dependent on the feature specified in &lt;ResourceVersionFeatureType&gt;; the feature value may or
     * may not be taken from a code list<p> (type: dt.NonEmptyString)
     */
    public String value;

    /**
     * Internal API, use the {@link #value} field instead
     */
    @Override
    public String _value() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final FeatureValue EMPTY = new FeatureValue();

    public FeatureValue() {
        exists = false;
    }

    public FeatureValue(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        value = JPU.getContentAsString(element);
    }

    @Override
    public boolean exists() {
        return exists;
    }
}
