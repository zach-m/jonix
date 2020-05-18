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
import com.tectonica.jonix.common.codelist.AvItemIdentifierTypes;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixAVItemIdentifier;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>AV item identifier composite</h1>
 * <p>
 * A group of data elements which together define an identifier of an audio or audiovisual content item in accordance
 * with a specified identifier scheme. The composite is optional, and repeatable in order to provide multiple
 * identifiers for the content item.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;AVItemIdentifier&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;avitemidentifier&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link AVItem}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link AVItem} ⯈
 * {@link AVItemIdentifier}</li>
 * </ul>
 *
 * @since Onix-3.05
 */
public class AVItemIdentifier
    implements OnixDataCompositeWithKey<JonixAVItemIdentifier, AvItemIdentifierTypes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "AVItemIdentifier";
    public static final String shortname = "avitemidentifier";

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
    public static final AVItemIdentifier EMPTY = new AVItemIdentifier();

    public AVItemIdentifier() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public AVItemIdentifier(org.w3c.dom.Element element) {
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
                case AVItemIDType.refname:
                case AVItemIDType.shortname:
                    avItemIDType = new AVItemIDType(e);
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
     * @return whether this tag (&lt;AVItemIdentifier&gt; or &lt;avitemidentifier&gt;) is explicitly provided in the
     *         ONIX XML
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

    private AVItemIDType avItemIDType = AVItemIDType.EMPTY;

    /**
     * <p>
     * An ONIX code identifying the scheme from which the identifier in &lt;IDValue&gt; is taken. Mandatory in each
     * occurrence of the &lt;AVItemIdentifier&gt; composite, and non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public AVItemIDType avItemIDType() {
        _initialize();
        return avItemIDType;
    }

    private IDValue idValue = IDValue.EMPTY;

    /**
     * <p>
     * An identifier of the type specified in &lt;AVItemIDType&gt;. Mandatory in each occurrence of the
     * &lt;AVItemIdentifier&gt; composite, and non-repeating.
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
     * there is no individual ID type code). Must be used when, and only when, the code in &lt;AVItemIDType&gt;
     * indicates a proprietary scheme, <i>eg</i> a publisher’s own code. Optional and non-repeating
     * </p>
     * Jonix-Comment: this field is optional
     */
    public IDTypeName idTypeName() {
        _initialize();
        return idTypeName;
    }

    @Override
    public JonixAVItemIdentifier asStruct() {
        _initialize();
        JonixAVItemIdentifier struct = new JonixAVItemIdentifier();
        struct.avItemIDType = avItemIDType.value;
        struct.idTypeName = idTypeName.value;
        struct.idValue = idValue.value;
        return struct;
    }

    @Override
    public AvItemIdentifierTypes structKey() {
        return avItemIDType().value;
    }
}
