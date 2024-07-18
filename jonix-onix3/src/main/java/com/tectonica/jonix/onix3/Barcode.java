/*
 * Copyright (C) 2012-2024 Zach Melamed
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
import com.tectonica.jonix.common.OnixComposite.OnixDataComposite;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixBarcode;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Barcode composite</h1>
 * <p>
 * A group of data elements which together specify a barcode type and its position on a product. Optional: expected to
 * be used only in North America. Repeatable if more than one type of barcode is carried on a single product. The
 * absence of this composite does <em>not</em> mean that a product is not bar-coded.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;Barcode&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;barcode&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;Barcode&gt; from the schema author:
 *
 * Details of a barcode symbology and position
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Product}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link Barcode}</li>
 * </ul>
 */
public class Barcode implements OnixDataComposite<JonixBarcode>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Barcode";
    public static final String shortname = "barcode";

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
    // CONSTRUCTION
    /////////////////////////////////////////////////////////////////////////////////

    private boolean initialized;
    private final boolean exists;
    private final org.w3c.dom.Element element;
    public static final Barcode EMPTY = new Barcode();

    public Barcode() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public Barcode(org.w3c.dom.Element element) {
        exists = true;
        initialized = false;
        this.element = element;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcename = JPU.getAttribute(element, "sourcename");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
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
                case BarcodeType.refname:
                case BarcodeType.shortname:
                    barcodeType = new BarcodeType(e);
                    break;
                case PositionOnProduct.refname:
                case PositionOnProduct.shortname:
                    positionOnProduct = new PositionOnProduct(e);
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;Barcode&gt; or &lt;barcode&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<Barcode> action) {
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

    private BarcodeType barcodeType = BarcodeType.EMPTY;

    /**
     * <p>
     * An ONIX code indicating whether, and in what form, a barcode is carried on a product. Mandatory in any instance
     * of the &lt;Barcode&gt; composite, and non-repeating.
     * </p>
     * JONIX adds: this field is required
     */
    public BarcodeType barcodeType() {
        _initialize();
        return barcodeType;
    }

    private PositionOnProduct positionOnProduct = PositionOnProduct.EMPTY;

    /**
     * <p>
     * An ONIX code indicating a position on a product; in this case, the position in which a barcode appears. Required
     * if the &lt;BarcodeType&gt; element indicates that the barcode appears on the product, even if the position is
     * ‘unknown’. Omitted if the &lt;BarcodeType&gt; element specifies that the product does not carry a barcode.
     * Non-repeating.
     * </p>
     * JONIX adds: this field is optional
     */
    public PositionOnProduct positionOnProduct() {
        _initialize();
        return positionOnProduct;
    }

    @Override
    public JonixBarcode asStruct() {
        _initialize();
        JonixBarcode struct = new JonixBarcode();
        struct.barcodeType = barcodeType.value;
        struct.positionOnProduct = positionOnProduct.value;
        return struct;
    }
}
