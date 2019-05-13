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
import com.tectonica.jonix.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.codelist.Languages;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

public class ONIXMessage implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "ONIXMessage";
    public static final String shortname = "ONIXmessage";
    public static final String release = "2.1";

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
    public static final ONIXMessage EMPTY = new ONIXMessage();

    public ONIXMessage() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public ONIXMessage(org.w3c.dom.Element element) {
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
                case Header.refname:
                case Header.shortname:
                    header = new Header(e);
                    break;
                case Product.refname:
                case Product.shortname:
                    products = JPU.addToList(products, new Product(e));
                    break;
                case MainSeriesRecord.refname:
                case MainSeriesRecord.shortname:
                    mainSeriesRecords = JPU.addToList(mainSeriesRecords, new MainSeriesRecord(e));
                    break;
                case SubSeriesRecord.refname:
                case SubSeriesRecord.shortname:
                    subSeriesRecords = JPU.addToList(subSeriesRecords, new SubSeriesRecord(e));
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

    private Header header = Header.EMPTY;

    /**
     * (this field is optional)
     */
    public Header header() {
        _initialize();
        return header;
    }

    private List<Product> products = Collections.emptyList();

    /**
     * (this list may be empty)
     */
    public List<Product> products() {
        _initialize();
        return products;
    }

    private List<MainSeriesRecord> mainSeriesRecords = Collections.emptyList();

    /**
     * (this list may be empty)
     */
    public List<MainSeriesRecord> mainSeriesRecords() {
        _initialize();
        return mainSeriesRecords;
    }

    private List<SubSeriesRecord> subSeriesRecords = Collections.emptyList();

    /**
     * (this list may be empty)
     */
    public List<SubSeriesRecord> subSeriesRecords() {
        _initialize();
        return subSeriesRecords;
    }
}
