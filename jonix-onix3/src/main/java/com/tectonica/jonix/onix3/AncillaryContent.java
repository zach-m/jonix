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
import com.tectonica.jonix.common.codelist.IllustrationAndOtherContentTypes;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixAncillaryContent;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Ancillary content composite</h1>
 * <p>
 * A group of data elements which together specify the number of illustrations or other content items of a stated type
 * which the product carries. Use of the &lt;AncillaryContent&gt; composite is optional, but is repeatable if necessary
 * to specify different types of content items.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;AncillaryContent&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;ancillarycontent&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;AncillaryContent&gt; from the schema author:
 *
 * Details of illustrations, maps, table of contents, index, bibliography or other ancillary content of a product
 * &#9679; Modified cardinality of &lt;AncillaryContentDescription&gt; at revision 3.0.1
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link DescriptiveDetail}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link AncillaryContent}</li>
 * </ul>
 */
public class AncillaryContent
    implements OnixDataCompositeWithKey<JonixAncillaryContent, IllustrationAndOtherContentTypes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "AncillaryContent";
    public static final String shortname = "ancillarycontent";

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
    public static final AncillaryContent EMPTY = new AncillaryContent();

    public AncillaryContent() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public AncillaryContent(org.w3c.dom.Element element) {
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
                case AncillaryContentType.refname:
                case AncillaryContentType.shortname:
                    ancillaryContentType = new AncillaryContentType(e);
                    break;
                case Number.refname:
                case Number.shortname:
                    number = new Number(e);
                    break;
                case AncillaryContentDescription.refname:
                case AncillaryContentDescription.shortname:
                    ancillaryContentDescriptions =
                        JPU.addToList(ancillaryContentDescriptions, new AncillaryContentDescription(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;AncillaryContent&gt; or &lt;ancillarycontent&gt;) is explicitly provided in the
     *         ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<AncillaryContent> action) {
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

    private AncillaryContentType ancillaryContentType = AncillaryContentType.EMPTY;

    /**
     * <p>
     * An ONIX code which identifies the type of illustration or other content to which an occurrence of the composite
     * refers. Mandatory in each occurrence of the &lt;AncillaryContent&gt; composite, and non-repeating.
     * </p>
     * JONIX adds: this field is required
     */
    public AncillaryContentType ancillaryContentType() {
        _initialize();
        return ancillaryContentType;
    }

    private Number number = Number.EMPTY;

    /**
     * <p>
     * The number of illustrations or other content items of the type specified in &lt;AncillaryContentType&gt;.
     * Optional and non-repeating.
     * </p>
     * JONIX adds: this field is optional
     */
    public Number number() {
        _initialize();
        return number;
    }

    private ListOfOnixElement<AncillaryContentDescription, String> ancillaryContentDescriptions =
        ListOfOnixElement.empty();

    /**
     * <p>
     * Text describing the type of illustration or other content to which an occurrence of the composite refers, when a
     * code is insufficient. Optional, and repeatable if parallel descriptive text is provided in multiple languages.
     * Required when &lt;AncillaryContentType&gt; carries the value 00. The <i>language</i> attribute is optional for a
     * single instance of &lt;AncillaryContentDescription&gt;, but must be included in each instance if
     * &lt;AncillaryContentDescription&gt; is repeated.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixElement<AncillaryContentDescription, String> ancillaryContentDescriptions() {
        _initialize();
        return ancillaryContentDescriptions;
    }

    @Override
    public JonixAncillaryContent asStruct() {
        _initialize();
        JonixAncillaryContent struct = new JonixAncillaryContent();
        struct.ancillaryContentType = ancillaryContentType.value;
        struct.ancillaryContentDescriptions = ancillaryContentDescriptions.values();
        struct.number = number.value;
        return struct;
    }

    @Override
    public IllustrationAndOtherContentTypes structKey() {
        return ancillaryContentType().value;
    }
}
