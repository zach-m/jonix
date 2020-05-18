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
import com.tectonica.jonix.common.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.common.codelist.Languages;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.TextCaseFlags;
import com.tectonica.jonix.common.codelist.TextFormats;
import com.tectonica.jonix.common.codelist.TransliterationSchemes;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage}</li>
 * </ul>
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

    /**
     * @return whether this tag (&lt;ONIXMessage&gt; or &lt;ONIXmessage&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    @Override
    public org.w3c.dom.Element getXmlElement() {
        return element;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private Header header = Header.EMPTY;

    /**
     * <p>
     * A group of data elements which together constitute a message header. The elements may alternatively be sent
     * without being grouped into a composite, but the composite approach is recommended since it makes it easier to
     * maintain a standard header “package” to drop into any new ONIX Product Information Message. <strong>Note that the
     * Sender and Addressee Identifier composites can only be used within the Header composite, and future extensions to
     * the Header will be defined only within the composite.</strong>
     * </p>
     * Jonix-Comment: this field is optional
     */
    public Header header() {
        _initialize();
        return header;
    }

    private List<Product> products = Collections.emptyList();

    /**
     * <p>
     * A product is described by a group of data elements beginning with an XML label &lt;Product&gt; and ending with an
     * XML label &lt;/Product&gt;. The entire group of data elements which is enclosed between these two labels
     * constitutes an ONIX product record. The product record is the fundamental unit within an ONIX Product Information
     * message. In almost every case, each product record describes an individually tradable item.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public List<Product> products() {
        _initialize();
        return products;
    }

    private List<MainSeriesRecord> mainSeriesRecords = Collections.emptyList();

    /**
     * Jonix-Comment: this list may be empty
     */
    public List<MainSeriesRecord> mainSeriesRecords() {
        _initialize();
        return mainSeriesRecords;
    }

    private List<SubSeriesRecord> subSeriesRecords = Collections.emptyList();

    /**
     * Jonix-Comment: this list may be empty
     */
    public List<SubSeriesRecord> subSeriesRecords() {
        _initialize();
        return subSeriesRecords;
    }
}
