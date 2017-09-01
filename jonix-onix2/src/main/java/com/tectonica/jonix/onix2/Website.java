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

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.OnixComposite.OnixDataComposite;
import com.tectonica.jonix.codelist.LanguageCodes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;
import com.tectonica.jonix.struct.JonixWebsite;

import java.io.Serializable;
import java.util.Arrays;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Website composite</h1><p>An optional and repeatable group of data elements which together identify and provide
 * pointers to a website which is related to the agent or local publisher identified in an occurrence of the
 * &lt;MarketRepresentation&gt; composite.</p><table border='1' cellpadding='3'><tr><td>Reference
 * name</td><td>&lt;Website&gt;</td></tr><tr><td>Short tag</td><td>&lt;website&gt;</td></tr></table>
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

    public LanguageCodes language;

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
    }

    private void initialize() {
        if (initialized) {
            return;
        }
        initialized = true;

        textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));
        textcase = TextCaseFlags.byCode(JPU.getAttribute(element, "textcase"));
        language = LanguageCodes.byCode(JPU.getAttribute(element, "language"));
        transliteration = TransliterationSchemes.byCode(JPU.getAttribute(element, "transliteration"));
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        JPU.forElementsOf(element, e -> {
            final String name = e.getNodeName();
            switch (name) {
                case WebsiteRole.refname:
                case WebsiteRole.shortname:
                    websiteRole = new WebsiteRole(e);
                    break;
                case WebsiteDescription.refname:
                case WebsiteDescription.shortname:
                    websiteDescription = new WebsiteDescription(e);
                    break;
                case WebsiteLink.refname:
                case WebsiteLink.shortname:
                    websiteLink = new WebsiteLink(e);
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

    private WebsiteRole websiteRole = WebsiteRole.EMPTY;

    /**
     * (this field is optional)
     */
    public WebsiteRole websiteRole() {
        initialize();
        return websiteRole;
    }

    private WebsiteDescription websiteDescription = WebsiteDescription.EMPTY;

    /**
     * (this field is optional)
     */
    public WebsiteDescription websiteDescription() {
        initialize();
        return websiteDescription;
    }

    private WebsiteLink websiteLink = WebsiteLink.EMPTY;

    /**
     * (this field is required)
     */
    public WebsiteLink websiteLink() {
        initialize();
        return websiteLink;
    }

    @Override
    public JonixWebsite asStruct() {
        initialize();
        JonixWebsite struct = new JonixWebsite();
        struct.websiteDescriptions = Arrays.asList(websiteDescription.value);
        struct.websiteLink = websiteLink.value;
        struct.websiteRole = websiteRole.value;
        return struct;
    }
}
