/*
 * Copyright (C) 2012-2025 Zach Melamed
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

import com.tectonica.jonix.common.JPU;
import com.tectonica.jonix.common.OnixElement;
import com.tectonica.jonix.common.codelist.Languages;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Default language of text</h1>
 * <p>
 * An ONIX code indicating the default language which is assumed for the text content of products listed in the message,
 * unless the language is explicitly stated by sending a ‘language of text’ in Group&nbsp;P.10 of each Product record.
 * Optional and non-repeating. To avoid any possible ambiguity, use of this default is deprecated, but any default
 * supplied will be assumed for all Product records which do not specify the language of the text explicitly in
 * Group&nbsp;P.10. It is strongly recommended that the language of the text should be specified in the &lt;Language&gt;
 * composite for each product.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Fixed length, three lower-case letters, based on ISO 639-2/B. Note that ISO 639 specifies that these codes should
 * always be in lower-case</td>
 * </tr>
 * <tr>
 * <td>Codelist</td>
 * <td>List 74</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;DefaultLanguageOfText&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;m184&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;1</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td><tt>&lt;m184&gt;eng&lt;/m184&gt;</tt></td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;DefaultLanguageOfText&gt; from the schema author:
 *
 * Default language of the text in the product, when an explicit language of text is omitted from any products in the
 * message. Not recommended for use &#9679; Deprecated from release 3.1 - use explicit &lt;Language&gt; with role 01
 * instead
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Header}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Header} ⯈ {@link DefaultLanguageOfText}</li>
 * </ul>
 *
 * @deprecated
 */
@Deprecated
public class DefaultLanguageOfText implements OnixElement<Languages>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "DefaultLanguageOfText";
    public static final String shortname = "m184";

    /////////////////////////////////////////////////////////////////////////////////
    // ATTRIBUTES
    /////////////////////////////////////////////////////////////////////////////////

    /**
     * (type: dt.DateOrDateTime)
     */
    public String datestamp;

    /**
     * (type: dt.NonEmptyString)
     */
    public String sourcename;

    public RecordSourceTypes sourcetype;

    /////////////////////////////////////////////////////////////////////////////////
    // VALUE MEMBER
    /////////////////////////////////////////////////////////////////////////////////

    public Languages value;

    /**
     * Internal API, use the {@link #value()} method or the {@link #value} field instead
     */
    @Override
    public Languages __v() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final DefaultLanguageOfText EMPTY = new DefaultLanguageOfText();

    public DefaultLanguageOfText() {
        exists = false;
    }

    public DefaultLanguageOfText(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcename = JPU.getAttribute(element, "sourcename");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));

        value = Languages.byCode(JPU.getContentAsString(element));
    }

    /**
     * @return whether this tag (&lt;DefaultLanguageOfText&gt; or &lt;m184&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<DefaultLanguageOfText> action) {
        if (exists) {
            action.accept(this);
        }
    }

    public String codeOrNull() {
        return value == null ? null : value.code;
    }

    public String descriptionOrNull() {
        return value == null ? null : value.description;
    }
}
