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
import com.tectonica.jonix.codelist.LicenseExpressionTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>License expression type</h1><p>An ONIX code identifying the nature or format of the license expression specified
 * in the &lt;EpubLicenseExpressionLink&gt; element. Mandatory within the &lt;EpubLicenseExpression&gt; composite, and
 * non-repeating.</p><table border='1' cellpadding='3'><tr><td>Format</td><td>Fixed-length text, two
 * digits</td></tr><tr><td>Codelist</td><td>List 218</td></tr><tr><td>Reference name</td><td>&lt;EpubLicenseExpressionType&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;x508&gt;</td></tr><tr><td>Cardinality</td><td>1</td></tr><tr><td>Example</td><td>&lt;x508&gt;10&lt;/x508&gt;
 * (ONIX-PL license expression)</td></tr></table>
 */
public class EpubLicenseExpressionType implements OnixElement<LicenseExpressionTypes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "EpubLicenseExpressionType";
    public static final String shortname = "x508";

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
    // VALUE MEMBER
    /////////////////////////////////////////////////////////////////////////////////

    public LicenseExpressionTypes value;

    /**
     * Internal API, use the {@link #value} field instead
     */
    @Override
    public LicenseExpressionTypes _value() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final EpubLicenseExpressionType EMPTY = new EpubLicenseExpressionType();

    public EpubLicenseExpressionType() {
        exists = false;
    }

    public EpubLicenseExpressionType(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        value = LicenseExpressionTypes.byCode(JPU.getContentAsString(element));
    }

    @Override
    public boolean exists() {
        return exists;
    }
}
