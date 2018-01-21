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

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.OnixComposite.OnixDataCompositeWithKey;
import com.tectonica.jonix.codelist.NameCodeTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixImprintIdentifier;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Imprint identifier composite</h1><p>A group of data elements which together define the identifier of an imprint
 * name. Optional and repeatable, but mandatory if the &lt;Imprint&gt; composite does not carry an
 * &lt;ImprintName&gt;.</p><table border='1' cellpadding='3'><tr><td>Reference name</td><td>&lt;ImprintIdentifier&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;imprintidentifier&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;n</td></tr></table>
 */
public class ImprintIdentifier
    implements OnixDataCompositeWithKey<JonixImprintIdentifier, NameCodeTypes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "ImprintIdentifier";
    public static final String shortname = "imprintidentifier";

    /////////////////////////////////////////////////////////////////////////////////
    // ATTRIBUTES
    /////////////////////////////////////////////////////////////////////////////////

    /**
     * (type: dt.DateOrDateTime)
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
    public static final ImprintIdentifier EMPTY = new ImprintIdentifier();

    public ImprintIdentifier() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public ImprintIdentifier(org.w3c.dom.Element element) {
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
                case ImprintIDType.refname:
                case ImprintIDType.shortname:
                    imprintIDType = new ImprintIDType(e);
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

    @Override
    public boolean exists() {
        return exists;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private ImprintIDType imprintIDType = ImprintIDType.EMPTY;

    /**
     * (this field is required)
     */
    public ImprintIDType imprintIDType() {
        _initialize();
        return imprintIDType;
    }

    private IDTypeName idTypeName = IDTypeName.EMPTY;

    /**
     * (this field is optional)
     */
    public IDTypeName idTypeName() {
        _initialize();
        return idTypeName;
    }

    private IDValue idValue = IDValue.EMPTY;

    /**
     * (this field is required)
     */
    public IDValue idValue() {
        _initialize();
        return idValue;
    }

    @Override
    public JonixImprintIdentifier asStruct() {
        _initialize();
        JonixImprintIdentifier struct = new JonixImprintIdentifier();
        struct.imprintIDType = imprintIDType.value;
        struct.idTypeName = idTypeName.value;
        struct.idValue = idValue.value;
        return struct;
    }

    @Override
    public NameCodeTypes structKey() {
        return imprintIDType().value;
    }
}
