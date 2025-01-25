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

import com.tectonica.jonix.common.JPU;
import com.tectonica.jonix.common.OnixComposite.OnixDataComposite;
import com.tectonica.jonix.common.codelist.Languages;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.TextCaseFlags;
import com.tectonica.jonix.common.codelist.TextFormats;
import com.tectonica.jonix.common.codelist.TransliterationSchemes;
import com.tectonica.jonix.common.struct.JonixProductWebsite;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Product website composite</h1>
 * <p>
 * An optional and repeatable group of data elements which together identify and provide pointers to a website which is
 * related to the product.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;ProductWebsite&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;productwebsite&gt;</tt></td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Product}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link ProductWebsite}</li>
 * </ul>
 */
public class ProductWebsite implements OnixDataComposite<JonixProductWebsite>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "ProductWebsite";
    public static final String shortname = "productwebsite";

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
    public static final ProductWebsite EMPTY = new ProductWebsite();

    public ProductWebsite() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public ProductWebsite(org.w3c.dom.Element element) {
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
                case ProductWebsiteLink.refname:
                case ProductWebsiteLink.shortname:
                    productWebsiteLink = new ProductWebsiteLink(e);
                    break;
                case WebsiteRole.refname:
                case WebsiteRole.shortname:
                    websiteRole = new WebsiteRole(e);
                    break;
                case ProductWebsiteDescription.refname:
                case ProductWebsiteDescription.shortname:
                    productWebsiteDescription = new ProductWebsiteDescription(e);
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;ProductWebsite&gt; or &lt;productwebsite&gt;) is explicitly provided in the ONIX
     *         XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<ProductWebsite> action) {
        if (exists) {
            action.accept(this);
        }
    }

    @Override
    public org.w3c.dom.Element getXmlElement() {
        return element;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private ProductWebsiteLink productWebsiteLink = ProductWebsiteLink.EMPTY;

    /**
     * <p>
     * A URL for a website carrying additional information related to the product, which is available to be viewed for
     * promotional purposes. Mandatory in each occurrence of the &lt;ProductWebsite&gt; composite, and non-repeating.
     * </p>
     * JONIX adds: this field is required
     */
    public ProductWebsiteLink productWebsiteLink() {
        _initialize();
        return productWebsiteLink;
    }

    private WebsiteRole websiteRole = WebsiteRole.EMPTY;

    /**
     * <p>
     * An ONIX code which identifies the role or purpose of the website which is linked through
     * &lt;ProductWebsiteLink&gt;. Optional and non-repeating.
     * </p>
     * JONIX adds: this field is optional
     */
    public WebsiteRole websiteRole() {
        _initialize();
        return websiteRole;
    }

    private ProductWebsiteDescription productWebsiteDescription = ProductWebsiteDescription.EMPTY;

    /**
     * <p>
     * Free text describing the nature of the website which is linked through &lt;ProductWebsiteLink&gt;. Optional and
     * non-repeating.
     * </p>
     * JONIX adds: this field is optional
     */
    public ProductWebsiteDescription productWebsiteDescription() {
        _initialize();
        return productWebsiteDescription;
    }

    @Override
    public JonixProductWebsite asStruct() {
        _initialize();
        JonixProductWebsite struct = new JonixProductWebsite();
        struct.websiteRole = websiteRole.value;
        struct.productWebsiteDescription = productWebsiteDescription.value;
        struct.productWebsiteLink = productWebsiteLink.value;
        return struct;
    }
}
