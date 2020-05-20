/*
 * Copyright (C) 2012-2020 Zach Melamed
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
import com.tectonica.jonix.common.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.common.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.ReligiousTextFeatureTypes;
import com.tectonica.jonix.common.struct.JonixReligiousTextFeature;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Religious text composite</h1>
 * <p>
 * An optional, non-repeating, group of data elements which together describe features of the content of an edition of a
 * religious text, and intended to meet the special needs of religious publishers and booksellers. The
 * &lt;ReligiousText&gt; composite may carry <em>either</em> a &lt;Bible&gt; composite <em>or</em> a
 * &lt;ReligiousTextIdentifier&gt; element accompanied by multiple repeats of the &lt;ReligiousTextFeature&gt;
 * composite. This approach is adopted to enable other devotional texts to be included if need arises without requiring
 * a new ONIX release.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;ReligiousText&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;religioustext&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;1</td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link DescriptiveDetail}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link ReligiousText}</li>
 * </ul>
 */
public class ReligiousText implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "ReligiousText";
    public static final String shortname = "religioustext";

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
    public static final ReligiousText EMPTY = new ReligiousText();

    public ReligiousText() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public ReligiousText(org.w3c.dom.Element element) {
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
                case ReligiousTextIdentifier.refname:
                case ReligiousTextIdentifier.shortname:
                    religiousTextIdentifier = new ReligiousTextIdentifier(e);
                    break;
                case ReligiousTextFeature.refname:
                case ReligiousTextFeature.shortname:
                    religiousTextFeatures = JPU.addToList(religiousTextFeatures, new ReligiousTextFeature(e));
                    break;
                case Bible.refname:
                case Bible.shortname:
                    bible = new Bible(e);
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;ReligiousText&gt; or &lt;religioustext&gt;) is explicitly provided in the ONIX XML
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

    private ReligiousTextIdentifier religiousTextIdentifier = ReligiousTextIdentifier.EMPTY;

    /**
     * <p>
     * An ONIX code indicating a religious text other than the Bible. Mandatory in each occurrence of the
     * &lt;ReligiousText&gt; composite that does <em>not</em> include a &lt;Bible&gt; composite, and non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public ReligiousTextIdentifier religiousTextIdentifier() {
        _initialize();
        return religiousTextIdentifier;
    }

    private ListOfOnixDataCompositeWithKey<ReligiousTextFeature, JonixReligiousTextFeature,
        ReligiousTextFeatureTypes> religiousTextFeatures = ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * <p>
     * A repeatable group of data elements which together specify and describe a feature of a religious text. Mandatory
     * if and only if &lt;ReligiousTextIdentifier&gt; is present.
     * </p>
     * Jonix-Comment: this list is required to contain at least one item
     */
    public ListOfOnixDataCompositeWithKey<ReligiousTextFeature, JonixReligiousTextFeature, ReligiousTextFeatureTypes>
        religiousTextFeatures() {
        _initialize();
        return religiousTextFeatures;
    }

    private Bible bible = Bible.EMPTY;

    /**
     * <p>
     * A group of data elements which together describe features of an edition of the Bible or of a selected Biblical
     * text. Mandatory in each occurrence of the &lt;ReligiousText&gt; composite that does <em>not</em> include a
     * &lt;ReligiousTextIdentifier&gt; element, and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public Bible bible() {
        _initialize();
        return bible;
    }
}
