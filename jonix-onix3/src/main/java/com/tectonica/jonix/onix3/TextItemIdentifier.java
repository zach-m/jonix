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
import com.tectonica.jonix.common.OnixComposite.OnixDataCompositeWithKey;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.TextItemIdentifierTypes;
import com.tectonica.jonix.common.struct.JonixTextItemIdentifier;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Text item identifier composite</h1>
 * <p>
 * A repeatable group of data elements which together define an identifier of a text item in accordance with a specified
 * scheme. The composite is optional.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;TextItemIdentifier&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;textitemidentifier&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link TextItem}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link TextItem} ⯈
 * {@link TextItemIdentifier}</li>
 * </ul>
 */
public class TextItemIdentifier
    implements OnixDataCompositeWithKey<JonixTextItemIdentifier, TextItemIdentifierTypes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "TextItemIdentifier";
    public static final String shortname = "textitemidentifier";

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
    public static final TextItemIdentifier EMPTY = new TextItemIdentifier();

    public TextItemIdentifier() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public TextItemIdentifier(org.w3c.dom.Element element) {
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
                case TextItemIDType.refname:
                case TextItemIDType.shortname:
                    textItemIDType = new TextItemIDType(e);
                    break;
                case IDValue.refname:
                case IDValue.shortname:
                    idValue = new IDValue(e);
                    break;
                case IDTypeName.refname:
                case IDTypeName.shortname:
                    idTypeName = new IDTypeName(e);
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;TextItemIdentifier&gt; or &lt;textitemidentifier&gt;) is explicitly provided in the
     *         ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private TextItemIDType textItemIDType = TextItemIDType.EMPTY;

    /**
     * <p>
     * An ONIX code identifying the scheme from which the identifier in &lt;IDValue&gt; is taken. Mandatory in each
     * occurrence of the &lt;TextItemIdentifier&gt; composite, and non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public TextItemIDType textItemIDType() {
        _initialize();
        return textItemIDType;
    }

    private IDValue idValue = IDValue.EMPTY;

    /**
     * <p>
     * An identifier of the type specified in &lt;TextItemIDType&gt;. Mandatory in each occurrence of the
     * &lt;TextItemIdentifier&gt; composite, and non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public IDValue idValue() {
        _initialize();
        return idValue;
    }

    private IDTypeName idTypeName = IDTypeName.EMPTY;

    /**
     * <p>
     * A name which identifies a proprietary identifier scheme (<i>ie</i> a scheme which is not a standard and for which
     * there is no individual ID type code). Must be included when, and only when, the code in &lt;TextItemIDType&gt;
     * indicates a proprietary scheme, <i>eg</i> a publisher’s own code. Optional and non-repeating
     * </p>
     * Jonix-Comment: this field is optional
     */
    public IDTypeName idTypeName() {
        _initialize();
        return idTypeName;
    }

    @Override
    public JonixTextItemIdentifier asStruct() {
        _initialize();
        JonixTextItemIdentifier struct = new JonixTextItemIdentifier();
        struct.textItemIDType = textItemIDType.value;
        struct.idTypeName = idTypeName.value;
        struct.idValue = idValue.value;
        return struct;
    }

    @Override
    public TextItemIdentifierTypes structKey() {
        return textItemIDType().value;
    }
}
