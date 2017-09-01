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
import com.tectonica.jonix.ListOfOnixDataComposite;
import com.tectonica.jonix.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextItemIdentifierTypes;
import com.tectonica.jonix.struct.JonixPageRun;
import com.tectonica.jonix.struct.JonixTextItemIdentifier;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Text item composite</h1><p>A group of data elements which are specific to text content. The composite must occur
 * once and only once in a &lt;ContentItem&gt; composite which describes a text content item. (Similar composites may be
 * defined for other media, and the occurrence of one of them will be mandatory in any &lt;ContentItem&gt;
 * composite.)</p><table border='1' cellpadding='3'><tr><td>Reference name</td><td>&lt;TextItem&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;textitem&gt;</td></tr><tr><td>Cardinality</td><td>1</td></tr></table>
 */
public class TextItem implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "TextItem";
    public static final String shortname = "textitem";

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
    public static final TextItem EMPTY = new TextItem();

    public TextItem() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public TextItem(org.w3c.dom.Element element) {
        exists = true;
        initialized = false;
        this.element = element;
    }

    private void initialize() {
        if (initialized) {
            return;
        }
        initialized = true;

        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        JPU.forElementsOf(element, e -> {
            final String name = e.getNodeName();
            if (name.equals(TextItemType.refname) || name.equals(TextItemType.shortname)) {
                textItemType = new TextItemType(e);
            } else if (name.equals(TextItemIdentifier.refname) || name.equals(TextItemIdentifier.shortname)) {
                textItemIdentifiers = JPU.addToList(textItemIdentifiers, new TextItemIdentifier(e));
            } else if (name.equals(PageRun.refname) || name.equals(PageRun.shortname)) {
                pageRuns = JPU.addToList(pageRuns, new PageRun(e));
            } else if (name.equals(NumberOfPages.refname) || name.equals(NumberOfPages.shortname)) {
                numberOfPages = new NumberOfPages(e);
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

    private TextItemType textItemType = TextItemType.EMPTY;

    /**
     * (this field is required)
     */
    public TextItemType textItemType() {
        initialize();
        return textItemType;
    }

    private ListOfOnixDataCompositeWithKey<TextItemIdentifier, JonixTextItemIdentifier, TextItemIdentifierTypes>
        textItemIdentifiers = ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataCompositeWithKey<TextItemIdentifier, JonixTextItemIdentifier, TextItemIdentifierTypes> textItemIdentifiers() {
        initialize();
        return textItemIdentifiers;
    }

    private ListOfOnixDataComposite<PageRun, JonixPageRun> pageRuns = ListOfOnixDataComposite.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataComposite<PageRun, JonixPageRun> pageRuns() {
        initialize();
        return pageRuns;
    }

    private NumberOfPages numberOfPages = NumberOfPages.EMPTY;

    /**
     * (this field is optional)
     */
    public NumberOfPages numberOfPages() {
        initialize();
        return numberOfPages;
    }
}
