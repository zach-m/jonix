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
import com.tectonica.jonix.common.OnixComposite.OnixDataCompositeWithKey;
import com.tectonica.jonix.common.codelist.Languages;
import com.tectonica.jonix.common.codelist.ProductIdentifierTypes;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.TextCaseFlags;
import com.tectonica.jonix.common.codelist.TextFormats;
import com.tectonica.jonix.common.codelist.TransliterationSchemes;
import com.tectonica.jonix.common.struct.JonixProductIdentifier;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Product identifier composite</h1>
 * <p>
 * A repeatable group of data elements which together define the identifier of a product in accordance with a specified
 * scheme, allowing new types of product identifier to be included without defining additional data elements. In
 * particular, the composite allows proprietary identifiers (SKUs) assigned by wholesalers or vendors to be sent as part
 * of the ONIX record.
 * </p>
 * <p>
 * To support the transition from ten-character ISBNs to 13-digit ISBNs, effective from 1 January 2007, there are
 * distinct &lt;ProductIDType&gt; codes for ISBN-10 and ISBN-13, as well as for EAN.UCC-13.
 * </p>
 * <p>
 * ISBN-13 numbers in their unhyphenated form constitute a range of EAN.UCC-13 numbers that has been reserved for the
 * international book trade. It has been agreed by ONIX national groups that it will be mandatory in an ONIX
 * &lt;Product&gt; record for any item carrying an ISBN-13 to include the ISBN-13 labelled as an EAN.UCC number
 * (ProductIDType code 03), since this is how the ISBN-13 will be universally used in trading transactions. For many
 * ONIX applications this will also be sufficient.
 * </p>
 * <p>
 * For some ONIX applications, however, particularly when data is to be supplied to the library sector, there may be
 * reasons why the ISBN-13 must also be sent labelled distinctively as an ISBN-13 (ProductIDType code 15); or, if the
 * item also has an ISBN-10, why it may still be desirable to send the ISBN-10 even after the end of 2006. Users should
 * consult national “good practice” guidelines and/or discuss with their trading partners.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;ProductIdentifier&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;productidentifier&gt;</tt></td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;Product&gt;</li>
 * <li>&lt;ContainedItem&gt;</li>
 * <li>&lt;NotForSale&gt;</li>
 * <li>&lt;RelatedProduct&gt;</li>
 * <li>&lt;Set&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>ONIXMessage ⯈ Product ⯈ ProductIdentifier</li>
 * <li>ONIXMessage ⯈ Product ⯈ ContainedItem ⯈ ProductIdentifier</li>
 * <li>ONIXMessage ⯈ Product ⯈ NotForSale ⯈ ProductIdentifier</li>
 * <li>ONIXMessage ⯈ Product ⯈ RelatedProduct ⯈ ProductIdentifier</li>
 * <li>ONIXMessage ⯈ Product ⯈ Set ⯈ ProductIdentifier</li>
 * </ul>
 */
public class ProductIdentifier
    implements OnixDataCompositeWithKey<JonixProductIdentifier, ProductIdentifierTypes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "ProductIdentifier";
    public static final String shortname = "productidentifier";

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
    public static final ProductIdentifier EMPTY = new ProductIdentifier();

    public ProductIdentifier() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public ProductIdentifier(org.w3c.dom.Element element) {
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
                case ProductIDType.refname:
                case ProductIDType.shortname:
                    productIDType = new ProductIDType(e);
                    break;
                case IDTypeName.refname:
                case IDTypeName.shortname:
                    idTypeName = new IDTypeName(e);
                    break;
                case IDValue.refname:
                case IDValue.shortname:
                    idValue = new IDValue(e);
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;ProductIdentifier&gt; or &lt;productidentifier&gt;) is explicitly provided in the
     * ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private ProductIDType productIDType = ProductIDType.EMPTY;

    /**
     * <p>
     * An ONIX code identifying the scheme from which the identifier in the &lt;IDValue&gt; element is taken. Mandatory
     * in each occurrence of the &lt;ProductIdentifier&gt; composite, and non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public ProductIDType productIDType() {
        _initialize();
        return productIDType;
    }

    private IDTypeName idTypeName = IDTypeName.EMPTY;

    /**
     * <p>
     * A name which identifies a proprietary identifier scheme when, and only when, the code in the
     * &lt;ProductIDType&gt; element indicates a proprietary scheme, <em>eg</em> a wholesaler’s own code. Optional and
     * non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public IDTypeName idTypeName() {
        _initialize();
        return idTypeName;
    }

    private IDValue idValue = IDValue.EMPTY;

    /**
     * <p>
     * An identifier of the type specified in the &lt;ProductIDType&gt; element. Mandatory in each occurrence of the
     * &lt;ProductIdentifier&gt; composite, and non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public IDValue idValue() {
        _initialize();
        return idValue;
    }

    @Override
    public JonixProductIdentifier asStruct() {
        _initialize();
        JonixProductIdentifier struct = new JonixProductIdentifier();
        struct.productIDType = productIDType.value;
        struct.idTypeName = idTypeName.value;
        struct.idValue = idValue.value;
        return struct;
    }

    @Override
    public ProductIdentifierTypes structKey() {
        return productIDType().value;
    }
}
