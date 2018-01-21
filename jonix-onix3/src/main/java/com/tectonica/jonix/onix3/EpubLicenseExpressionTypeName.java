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
import com.tectonica.jonix.codelist.LanguageCodes;
import com.tectonica.jonix.codelist.RecordSourceTypes;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>License expression type name</h1><p>A short free-text name for a license expression type, when the code in
 * &lt;EpubLicenseExpressionType&gt; provides insufficient detail – for example when a machine-readable license is
 * expressed using a particular proprietary encoding scheme. Optional and non-repeating, and must be included when (and
 * only when) the &lt;EpubLicenseExpressionType&gt; element indicates the expression is encoded in a proprietary
 * way.</p><table border='1' cellpadding='3'><tr><td>Format</td><td>Variable-length text, suggested maximum length 50
 * characters</td></tr><tr><td>Reference name</td><td>&lt;EpubLicenseExpressionTypeName&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;x509&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;1</td></tr><tr><td>Attributes</td><td>language</td></tr><tr><td>Example</td><td>&lt;x509&gt;ABC-XML&lt;/x509&gt;</td></tr></table>
 */
public class EpubLicenseExpressionTypeName implements OnixElement<String>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "EpubLicenseExpressionTypeName";
    public static final String shortname = "x509";

    /////////////////////////////////////////////////////////////////////////////////
    // ATTRIBUTES
    /////////////////////////////////////////////////////////////////////////////////

    /**
     * (type: dt.DateOrDateTime)
     */
    public String datestamp;

    public RecordSourceTypes sourcetype;

    public String sourcename;

    public LanguageCodes language;

    /////////////////////////////////////////////////////////////////////////////////
    // VALUE MEMBER
    /////////////////////////////////////////////////////////////////////////////////

    /**
     * Raw Format: Variable-length text, suggested maximum length 50 characters<p> (type: dt.NonEmptyString)
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
    public static final EpubLicenseExpressionTypeName EMPTY = new EpubLicenseExpressionTypeName();

    public EpubLicenseExpressionTypeName() {
        exists = false;
    }

    public EpubLicenseExpressionTypeName(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");
        language = LanguageCodes.byCode(JPU.getAttribute(element, "language"));

        value = JPU.getContentAsString(element);
    }

    @Override
    public boolean exists() {
        return exists;
    }
}
