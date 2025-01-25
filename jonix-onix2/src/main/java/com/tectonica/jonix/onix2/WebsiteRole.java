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

package com.tectonica.jonix.onix2;

import java.io.Serializable;
import java.util.function.Consumer;
import com.tectonica.jonix.common.JPU;
import com.tectonica.jonix.common.OnixElement;
import com.tectonica.jonix.common.codelist.*;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Website purpose</h1>
 * <p>
 * An ONIX code which identifies the role or purpose of the website which is linked through the &lt;WebsiteLink&gt;
 * element. Optional and non-repeating.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Fixed-length, two numeric digits</td>
 * </tr>
 * <tr>
 * <td>Codelist</td>
 * <td>List 73</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;WebsiteRole&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;b367&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td><tt>&lt;WebsiteRole&gt;05&lt;/WebsiteRole&gt;</tt> Online resource contents page</td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link ProductWebsite}&gt;</li>
 * <li>&lt;{@link Website}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link ProductWebsite} ⯈ {@link WebsiteRole}</li>
 * <li>{@link Product} ⯈ {@link Website} ⯈ {@link WebsiteRole}</li>
 * <li>{@link Product} ⯈ {@link Conference} ⯈ {@link Website} ⯈ {@link WebsiteRole}</li>
 * <li>{@link Product} ⯈ {@link SupplyDetail} ⯈ {@link Website} ⯈ {@link WebsiteRole}</li>
 * <li>{@link Product} ⯈ {@link MarketRepresentation} ⯈ {@link Website} ⯈ {@link WebsiteRole}</li>
 * <li>{@link Product} ⯈ {@link RelatedProduct} ⯈ {@link Website} ⯈ {@link WebsiteRole}</li>
 * <li>{@link Product} ⯈ {@link ContentItem} ⯈ {@link Website} ⯈ {@link WebsiteRole}</li>
 * <li>{@link Product} ⯈ {@link Contributor} ⯈ {@link Website} ⯈ {@link WebsiteRole}</li>
 * <li>{@link Product} ⯈ {@link ContentItem} ⯈ {@link Contributor} ⯈ {@link Website} ⯈ {@link WebsiteRole}</li>
 * <li>{@link SubSeriesRecord} ⯈ {@link Contributor} ⯈ {@link Website} ⯈ {@link WebsiteRole}</li>
 * <li>{@link MainSeriesRecord} ⯈ {@link Contributor} ⯈ {@link Website} ⯈ {@link WebsiteRole}</li>
 * <li>{@link Product} ⯈ {@link Series} ⯈ {@link Contributor} ⯈ {@link Website} ⯈ {@link WebsiteRole}</li>
 * <li>{@link Product} ⯈ {@link Publisher} ⯈ {@link Website} ⯈ {@link WebsiteRole}</li>
 * <li>{@link Product} ⯈ {@link RelatedProduct} ⯈ {@link Publisher} ⯈ {@link Website} ⯈ {@link WebsiteRole}</li>
 * <li>{@link SubSeriesRecord} ⯈ {@link Publisher} ⯈ {@link Website} ⯈ {@link WebsiteRole}</li>
 * <li>{@link MainSeriesRecord} ⯈ {@link Publisher} ⯈ {@link Website} ⯈ {@link WebsiteRole}</li>
 * </ul>
 *
 * @since Onix-2.1
 */
public class WebsiteRole implements OnixElement<WebsiteRoles>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "WebsiteRole";
    public static final String shortname = "b367";

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
    // VALUE MEMBER
    /////////////////////////////////////////////////////////////////////////////////

    public WebsiteRoles value;

    /**
     * Internal API, use the {@link #value()} method or the {@link #value} field instead
     */
    @Override
    public WebsiteRoles __v() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final WebsiteRole EMPTY = new WebsiteRole();

    public WebsiteRole() {
        exists = false;
    }

    public WebsiteRole(org.w3c.dom.Element element) {
        exists = true;
        textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));
        textcase = TextCaseFlags.byCode(JPU.getAttribute(element, "textcase"));
        language = Languages.byCode(JPU.getAttribute(element, "language"));
        transliteration = TransliterationSchemes.byCode(JPU.getAttribute(element, "transliteration"));
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        value = WebsiteRoles.byCode(JPU.getContentAsString(element));
    }

    /**
     * @return whether this tag (&lt;WebsiteRole&gt; or &lt;b367&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<WebsiteRole> action) {
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
