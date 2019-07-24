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

import com.tectonica.jonix.common.JPU;
import com.tectonica.jonix.common.OnixComposite.OnixDataComposite;
import com.tectonica.jonix.common.codelist.Languages;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.TextCaseFlags;
import com.tectonica.jonix.common.codelist.TextFormats;
import com.tectonica.jonix.common.codelist.TransliterationSchemes;
import com.tectonica.jonix.common.struct.JonixWebsite;

import java.io.Serializable;
import java.util.Arrays;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Website composite</h1>
 * <p>
 * A repeatable group of data elements which together identify and provide pointers to a website which is related to the
 * work identified in an occurrence of the &lt;WorkIdentifier&gt; composite.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;Website&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;website&gt;</tt></td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Product}&gt;</li>
 * <li>&lt;{@link Conference}&gt;</li>
 * <li>&lt;{@link SupplyDetail}&gt;</li>
 * <li>&lt;{@link MarketRepresentation}&gt;</li>
 * <li>&lt;{@link RelatedProduct}&gt;</li>
 * <li>&lt;{@link ContentItem}&gt;</li>
 * <li>&lt;{@link Contributor}&gt;</li>
 * <li>&lt;{@link Publisher}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link Website}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link Conference} ⯈ {@link Website}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link SupplyDetail} ⯈ {@link Website}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link MarketRepresentation} ⯈ {@link Website}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link RelatedProduct} ⯈ {@link Website}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ContentItem} ⯈ {@link Website}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link Contributor} ⯈ {@link Website}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ContentItem} ⯈ {@link Contributor} ⯈ {@link Website}</li>
 * <li>{@link ONIXMessage} ⯈ {@link SubSeriesRecord} ⯈ {@link Contributor} ⯈ {@link Website}</li>
 * <li>{@link ONIXMessage} ⯈ {@link MainSeriesRecord} ⯈ {@link Contributor} ⯈ {@link Website}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link Series} ⯈ {@link Contributor} ⯈ {@link Website}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link Publisher} ⯈ {@link Website}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link RelatedProduct} ⯈ {@link Publisher} ⯈ {@link Website}</li>
 * <li>{@link ONIXMessage} ⯈ {@link SubSeriesRecord} ⯈ {@link Publisher} ⯈ {@link Website}</li>
 * <li>{@link ONIXMessage} ⯈ {@link MainSeriesRecord} ⯈ {@link Publisher} ⯈ {@link Website}</li>
 * </ul>
 *
 * @since Onix-2.1
 */
public class Website implements OnixDataComposite<JonixWebsite>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Website";
    public static final String shortname = "website";

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
    // CONSTRUCTION
    /////////////////////////////////////////////////////////////////////////////////

    private boolean initialized;
    private final boolean exists;
    private final org.w3c.dom.Element element;
    public static final Website EMPTY = new Website();

    public Website() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public Website(org.w3c.dom.Element element) {
        exists = true;
        initialized = false;
        this.element = element;
        textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));
        textcase = TextCaseFlags.byCode(JPU.getAttribute(element, "textcase"));
        language = Languages.byCode(JPU.getAttribute(element, "language"));
        transliteration = TransliterationSchemes.byCode(JPU.getAttribute(element, "transliteration"));
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
                case WebsiteLink.refname:
                case WebsiteLink.shortname:
                    websiteLink = new WebsiteLink(e);
                    break;
                case WebsiteRole.refname:
                case WebsiteRole.shortname:
                    websiteRole = new WebsiteRole(e);
                    break;
                case WebsiteDescription.refname:
                case WebsiteDescription.shortname:
                    websiteDescription = new WebsiteDescription(e);
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;Website&gt; or &lt;website&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private WebsiteLink websiteLink = WebsiteLink.EMPTY;

    /**
     * <p>
     * The URL for the website. Mandatory in each occurrence of the &lt;Website&gt; composite, and non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public WebsiteLink websiteLink() {
        _initialize();
        return websiteLink;
    }

    private WebsiteRole websiteRole = WebsiteRole.EMPTY;

    /**
     * <p>
     * An ONIX code which identifies the role or purpose of the website which is linked through the &lt;WebsiteLink&gt;
     * element. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public WebsiteRole websiteRole() {
        _initialize();
        return websiteRole;
    }

    private WebsiteDescription websiteDescription = WebsiteDescription.EMPTY;

    /**
     * <p>
     * Free text describing the nature of the website which is linked through the &lt;WebsiteLink&gt; element. Optional
     * and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public WebsiteDescription websiteDescription() {
        _initialize();
        return websiteDescription;
    }

    @Override
    public JonixWebsite asStruct() {
        _initialize();
        JonixWebsite struct = new JonixWebsite();
        struct.websiteDescriptions = Arrays.asList(websiteDescription.value);
        struct.websiteLinks = Arrays.asList(websiteLink.value);
        struct.websiteRole = websiteRole.value;
        return struct;
    }
}
