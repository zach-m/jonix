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
import com.tectonica.jonix.ListOfOnixElement;
import com.tectonica.jonix.OnixComposite.OnixDataCompositeWithKey;
import com.tectonica.jonix.codelist.IllustrationAndOtherContentTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixAncillaryContent;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Ancillary content composite</h1><p>A repeatable group of data elements which together specify the number of
 * illustrations or other content items of a stated type which the product carries. Use of the &lt;AncillaryContent&gt;
 * composite is optional.</p><table border='1' cellpadding='3'><tr><td>Reference name</td><td>&lt;AncillaryContent&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;ancillarycontent&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;n</td></tr></table>
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

    public RecordSourceTypes sourcetype;

    public String sourcename;

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
                case AncillaryContentType.refname:
                case AncillaryContentType.shortname:
                    ancillaryContentType = new AncillaryContentType(e);
                    break;
                case AncillaryContentDescription.refname:
                case AncillaryContentDescription.shortname:
                    ancillaryContentDescriptions =
                        JPU.addToList(ancillaryContentDescriptions, new AncillaryContentDescription(e));
                    break;
                case Number.refname:
                case Number.shortname:
                    number = new Number(e);
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

    private AncillaryContentType ancillaryContentType = AncillaryContentType.EMPTY;

    /**
     * (this field is required)
     */
    public AncillaryContentType ancillaryContentType() {
        _initialize();
        return ancillaryContentType;
    }

    private ListOfOnixElement<AncillaryContentDescription, String> ancillaryContentDescriptions =
        ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<AncillaryContentDescription, String> ancillaryContentDescriptions() {
        _initialize();
        return ancillaryContentDescriptions;
    }

    private Number number = Number.EMPTY;

    /**
     * (this field is optional)
     */
    public Number number() {
        _initialize();
        return number;
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
