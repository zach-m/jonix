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

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.ListOfOnixDataComposite;
import com.tectonica.jonix.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.codelist.LanguageCodes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TextItemIdentifierTypes;
import com.tectonica.jonix.codelist.TransliterationSchemes;
import com.tectonica.jonix.struct.JonixPageRun;
import com.tectonica.jonix.struct.JonixTextItemIdentifier;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Text item composite</h1><p>A group of data elements which are specific to text content. The composite must occur
 * once and only once in a &lt;ContentItem&gt; composite which describes a text content item. (Similar composites are
 * being defined for other media, and the occurrence of one of them will be mandatory in any &lt;ContentItem&gt;
 * composite.)</p><table border='1' cellpadding='3'><tr><td>Reference name</td><td>&lt;TextItem&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;textitem&gt;</td></tr></table>
 */
public class TextItem implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "TextItem";
    public static final String shortname = "textitem";

    /////////////////////////////////////////////////////////////////////////////////
    // ATTRIBUTES
    /////////////////////////////////////////////////////////////////////////////////

    public TextFormats textformat;

    public TextCaseFlags textcase;

    public LanguageCodes language;

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

        textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));
        textcase = TextCaseFlags.byCode(JPU.getAttribute(element, "textcase"));
        language = LanguageCodes.byCode(JPU.getAttribute(element, "language"));
        transliteration = TransliterationSchemes.byCode(JPU.getAttribute(element, "transliteration"));
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        JPU.forElementsOf(element, e -> {
            final String name = e.getNodeName();
            switch (name) {
                case TextItemType.refname:
                case TextItemType.shortname:
                    textItemType = new TextItemType(e);
                    break;
                case TextItemIdentifier.refname:
                case TextItemIdentifier.shortname:
                    textItemIdentifiers = JPU.addToList(textItemIdentifiers, new TextItemIdentifier(e));
                    break;
                case FirstPageNumber.refname:
                case FirstPageNumber.shortname:
                    firstPageNumber = new FirstPageNumber(e);
                    break;
                case LastPageNumber.refname:
                case LastPageNumber.shortname:
                    lastPageNumber = new LastPageNumber(e);
                    break;
                case PageRun.refname:
                case PageRun.shortname:
                    pageRuns = JPU.addToList(pageRuns, new PageRun(e));
                    break;
                case NumberOfPages.refname:
                case NumberOfPages.shortname:
                    numberOfPages = new NumberOfPages(e);
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

    private FirstPageNumber firstPageNumber = FirstPageNumber.EMPTY;

    /**
     * (this field is required)
     */
    public FirstPageNumber firstPageNumber() {
        initialize();
        return firstPageNumber;
    }

    private LastPageNumber lastPageNumber = LastPageNumber.EMPTY;

    /**
     * (this field is optional)
     */
    public LastPageNumber lastPageNumber() {
        initialize();
        return lastPageNumber;
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
