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

import com.tectonica.jonix.common.JPU;
import com.tectonica.jonix.common.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;

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
    public static final String release = "3.0";

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
                case NoProduct.refname:
                case NoProduct.shortname:
                    noProduct = new NoProduct(e);
                    break;
                case Product.refname:
                case Product.shortname:
                    products = JPU.addToList(products, new Product(e));
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
     * A group of data elements which together constitute a message header. Mandatory in any ONIX for Books message, and
     * non-repeating. In ONIX&nbsp;3.0, a number of redundant elements have been deleted, and the Sender and Addressee
     * structures and the name and format of the &lt;SentDateTime&gt; element have been made consistent with other
     * current ONIX formats.
     * </p>
     * Jonix-Comment: this field is required
     */
    public Header header() {
        _initialize();
        return header;
    }

    private NoProduct noProduct = NoProduct.EMPTY;

    /**
     * <p>
     * An empty element that provides a positive indication that a message does not carry any Product records. Intended
     * to be used only in empty ‘delta’ update messages to provide confirmation that there have been no updates since
     * the previous message. Optional and non-repeating, but must be used in an ONIX message that contains no
     * &lt;Product&gt; composites.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public NoProduct noProduct() {
        _initialize();
        return noProduct;
    }

    public boolean isNoProduct() {
        return (noProduct().exists());
    }

    private List<Product> products = Collections.emptyList();

    /**
     * <p>
     * A product is described by a group of data elements beginning with an XML label &lt;Product&gt; and ending with an
     * XML label &lt;/Product&gt;. The entire group of data elements which is enclosed between these two labels
     * constitutes an ONIX product record. The product record is the fundamental unit within an ONIX Product Information
     * message. In almost every case, each product record describes an individually tradable item; and in all
     * circumstances, each tradable item identified by a recognized product identifier should be described by one, and
     * only one, ONIX product record.
     * </p>
     * <p>
     * In ONIX&nbsp;3.0, a &lt;Product&gt; record has a mandatory ‘preamble’ comprising data Groups P.1 and P.2, and
     * carrying data that identifies the record and the product to which it refers. This is followed by up to seven
     * ‘blocks’, each optional, some of which are repeatable.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public List<Product> products() {
        _initialize();
        return products;
    }
}
