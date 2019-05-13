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
import com.tectonica.jonix.codelist.ProductFormDetails;
import com.tectonica.jonix.codelist.RecordSourceTypes;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Related product form detail</h1><p>An ONIX code which provides added detail of the medium and/or format of a
 * related product. Optional and repeatable.</p><table border='1' cellpadding='3'><tr><td>Format</td><td>Fixed length,
 * four characters: one letter followed by three digits</td></tr><tr><td>Codelist</td><td>List
 * 175</td></tr><tr><td>Reference name</td><td>&lt;ProductFormDetail&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;b333&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;n</td></tr><tr><td>Example</td><td>&lt;b333&gt;B206&lt;/b333&gt;
 * (Pop-up book)</td></tr></table>
 */
public class ProductFormDetail implements OnixElement<ProductFormDetails>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "ProductFormDetail";
    public static final String shortname = "b333";

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

    public ProductFormDetails value;

    /**
     * Internal API, use the {@link #value} field instead
     */
    @Override
    public ProductFormDetails _value() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final ProductFormDetail EMPTY = new ProductFormDetail();

    public ProductFormDetail() {
        exists = false;
    }

    public ProductFormDetail(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        value = ProductFormDetails.byCode(JPU.getContentAsString(element));
    }

    @Override
    public boolean exists() {
        return exists;
    }
}
