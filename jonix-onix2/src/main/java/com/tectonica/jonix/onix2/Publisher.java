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
import com.tectonica.jonix.common.ListOfOnixDataComposite;
import com.tectonica.jonix.common.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.common.codelist.Languages;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.TextCaseFlags;
import com.tectonica.jonix.common.codelist.TextFormats;
import com.tectonica.jonix.common.codelist.TransliterationSchemes;
import com.tectonica.jonix.common.struct.JonixWebsite;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Publisher composite</h1>
 * <p>
 * A repeatable group of data elements which together identify an entity which is associated with the publishing of a
 * product. The composite will allow additional publishing roles to be introduced without adding new fields. Each
 * occurrence of the composite must carry either a name code or a name or both.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;Publisher&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;publisher&gt;</tt></td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Product}&gt;</li>
 * <li>&lt;{@link RelatedProduct}&gt;</li>
 * <li>&lt;{@link SubSeriesRecord}&gt;</li>
 * <li>&lt;{@link MainSeriesRecord}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link Publisher}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link RelatedProduct} ⯈ {@link Publisher}</li>
 * <li>{@link ONIXMessage} ⯈ {@link SubSeriesRecord} ⯈ {@link Publisher}</li>
 * <li>{@link ONIXMessage} ⯈ {@link MainSeriesRecord} ⯈ {@link Publisher}</li>
 * </ul>
 */
public class Publisher implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Publisher";
    public static final String shortname = "publisher";

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
    public static final Publisher EMPTY = new Publisher();

    public Publisher() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public Publisher(org.w3c.dom.Element element) {
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
                case NameCodeType.refname:
                case NameCodeType.shortname:
                    nameCodeType = new NameCodeType(e);
                    break;
                case NameCodeValue.refname:
                case NameCodeValue.shortname:
                    nameCodeValue = new NameCodeValue(e);
                    break;
                case PublishingRole.refname:
                case PublishingRole.shortname:
                    publishingRole = new PublishingRole(e);
                    break;
                case PublisherName.refname:
                case PublisherName.shortname:
                    publisherName = new PublisherName(e);
                    break;
                case NameCodeTypeName.refname:
                case NameCodeTypeName.shortname:
                    nameCodeTypeName = new NameCodeTypeName(e);
                    break;
                case Website.refname:
                case Website.shortname:
                    websites = JPU.addToList(websites, new Website(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;Publisher&gt; or &lt;publisher&gt;) is explicitly provided in the ONIX XML
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

    private NameCodeType nameCodeType = NameCodeType.EMPTY;

    /**
     * <p>
     * An ONIX code which identifies the scheme from which the value in the &lt;NameCodeValue&gt; element is taken.
     * Optional and non-repeating, but mandatory if the &lt;Publisher&gt; composite does not carry a
     * &lt;PublisherName&gt;.
     * </p>
     * Jonix-Comment: this field is required
     */
    public NameCodeType nameCodeType() {
        _initialize();
        return nameCodeType;
    }

    private NameCodeValue nameCodeValue = NameCodeValue.EMPTY;

    /**
     * <p>
     * A code value taken from the scheme specified in &lt;NameCodeType&gt;. Mandatory if and only if
     * &lt;NameCodeType&gt; is present, and non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public NameCodeValue nameCodeValue() {
        _initialize();
        return nameCodeValue;
    }

    private PublishingRole publishingRole = PublishingRole.EMPTY;

    /**
     * <p>
     * An ONIX code which identifies a role played by an entity in the publishing of a product. Optional and
     * non-repeating. The default if the element is omitted is “publisher”.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public PublishingRole publishingRole() {
        _initialize();
        return publishingRole;
    }

    private PublisherName publisherName = PublisherName.EMPTY;

    /**
     * <p>
     * The name of an entity associated with the publishing of a product. Mandatory if there is no name code in an
     * occurrence of the &lt;Publisher&gt; composite, and optional if a name code is included. Non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public PublisherName publisherName() {
        _initialize();
        return publisherName;
    }

    private NameCodeTypeName nameCodeTypeName = NameCodeTypeName.EMPTY;

    /**
     * <p>
     * A name which identifies a proprietary name code when the code in &lt;NameCodeType&gt; indicates a proprietary
     * scheme, <em>eg</em> a bibliographic agency’s own code. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public NameCodeTypeName nameCodeTypeName() {
        _initialize();
        return nameCodeTypeName;
    }

    private ListOfOnixDataComposite<Website, JonixWebsite> websites = ListOfOnixDataComposite.empty();

    /**
     * <p>
     * A repeatable group of data elements which together identify and provide pointers to a website which is related to
     * the publisher identified in an occurrence of the &lt;Publisher&gt; composite.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataComposite<Website, JonixWebsite> websites() {
        _initialize();
        return websites;
    }
}
