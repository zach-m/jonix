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
import com.tectonica.jonix.common.ListOfOnixElement;
import com.tectonica.jonix.common.OnixComposite.OnixDataCompositeWithKey;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.ReturnsConditionsCodeTypes;
import com.tectonica.jonix.common.struct.JonixReturnsConditions;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Returns conditions composite</h1>
 * <p>
 * An optional and repeatable group of data elements which together allow the supplier’s returns conditions to be
 * specified in coded form.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;ReturnsConditions&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;returnsconditions&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;ReturnsConditions&gt; from the schema author:
 * 
 * <pre>
 * Details of the supplier's returns conditions
 * &#9679; Added &lt;ReturnsNote&gt; at revision 3.0.3
 * </pre>
 * 
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link SupplyDetail}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link ReturnsConditions}</li>
 * </ul>
 */
public class ReturnsConditions
    implements OnixDataCompositeWithKey<JonixReturnsConditions, ReturnsConditionsCodeTypes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "ReturnsConditions";
    public static final String shortname = "returnsconditions";

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
    public static final ReturnsConditions EMPTY = new ReturnsConditions();

    public ReturnsConditions() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public ReturnsConditions(org.w3c.dom.Element element) {
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
                case ReturnsCodeType.refname:
                case ReturnsCodeType.shortname:
                    returnsCodeType = new ReturnsCodeType(e);
                    break;
                case ReturnsCode.refname:
                case ReturnsCode.shortname:
                    returnsCode = new ReturnsCode(e);
                    break;
                case ReturnsCodeTypeName.refname:
                case ReturnsCodeTypeName.shortname:
                    returnsCodeTypeName = new ReturnsCodeTypeName(e);
                    break;
                case ReturnsNote.refname:
                case ReturnsNote.shortname:
                    returnsNotes = JPU.addToList(returnsNotes, new ReturnsNote(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;ReturnsConditions&gt; or &lt;returnsconditions&gt;) is explicitly provided in the
     *         ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<ReturnsConditions> action) {
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

    private ReturnsCodeType returnsCodeType = ReturnsCodeType.EMPTY;

    /**
     * <p>
     * An ONIX code identifying the scheme from which the returns conditions code in &lt;ReturnsCode&gt; is taken.
     * Mandatory in each occurrence of the &lt;ReturnsConditions&gt; composite, and non-repeating.
     * </p>
     * JONIX adds: this field is required
     */
    public ReturnsCodeType returnsCodeType() {
        _initialize();
        return returnsCodeType;
    }

    private ReturnsCode returnsCode = ReturnsCode.EMPTY;

    /**
     * <p>
     * A returns conditions code from the scheme specified in &lt;ReturnsCodeType&gt;. Mandatory in each occurrence of
     * the &lt;ReturnsConditions&gt; composite, and non-repeating.
     * </p>
     * JONIX adds: this field is required
     */
    public ReturnsCode returnsCode() {
        _initialize();
        return returnsCode;
    }

    private ReturnsCodeTypeName returnsCodeTypeName = ReturnsCodeTypeName.EMPTY;

    /**
     * <p>
     * A name which identifies a proprietary returns code scheme. Must be used when, and only when, the code in the
     * &lt;ReturnsCodeType&gt; element indicates a proprietary scheme, <i>eg</i> a wholesaler’s own code. Optional and
     * non-repeating.
     * </p>
     * JONIX adds: this field is optional
     */
    public ReturnsCodeTypeName returnsCodeTypeName() {
        _initialize();
        return returnsCodeTypeName;
    }

    private ListOfOnixElement<ReturnsNote, String> returnsNotes = ListOfOnixElement.empty();

    /**
     * <p>
     * Free text note explaining the returns conditions or special returns instructions, where the code alone is not
     * sufficient. Optional, and repeatable if parallel text is provided in multiple languages. The <i>language</i>
     * attribute is optional for a single instance of &lt;ReturnsNote&gt;, but must be included in each instance if
     * &lt;ReturnsNote&gt; is repeated.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixElement<ReturnsNote, String> returnsNotes() {
        _initialize();
        return returnsNotes;
    }

    @Override
    public JonixReturnsConditions asStruct() {
        _initialize();
        JonixReturnsConditions struct = new JonixReturnsConditions();
        struct.returnsCodeType = returnsCodeType.value;
        struct.returnsCodeTypeName = returnsCodeTypeName.value;
        struct.returnsCode = returnsCode.value;
        struct.returnsNotes = returnsNotes.values();
        return struct;
    }

    @Override
    public ReturnsConditionsCodeTypes structKey() {
        return returnsCodeType().value;
    }
}
