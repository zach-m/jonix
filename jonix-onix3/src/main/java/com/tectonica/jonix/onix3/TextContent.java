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
import com.tectonica.jonix.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.ListOfOnixElement;
import com.tectonica.jonix.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.codelist.ContentAudiences;
import com.tectonica.jonix.codelist.ContentDateRoles;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixContentDate;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Text content composite</h1><p>A group of data elements which together carry text related to a content item.
 * Optional and repeatable.</p><table border='1' cellpadding='3'><tr><td>Reference
 * name</td><td>&lt;TextContent&gt;</td></tr><tr><td>Short tag</td><td>&lt;textcontent&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;n</td></tr></table>
 */
public class TextContent implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "TextContent";
    public static final String shortname = "textcontent";

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
    public static final TextContent EMPTY = new TextContent();

    public TextContent() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public TextContent(org.w3c.dom.Element element) {
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
                case TextType.refname:
                case TextType.shortname:
                    textType = new TextType(e);
                    break;
                case ContentAudience.refname:
                case ContentAudience.shortname:
                    contentAudiences = JPU.addToList(contentAudiences, new ContentAudience(e));
                    break;
                case Text.refname:
                case Text.shortname:
                    texts = JPU.addToList(texts, new Text(e));
                    break;
                case TextAuthor.refname:
                case TextAuthor.shortname:
                    textAuthors = JPU.addToList(textAuthors, new TextAuthor(e));
                    break;
                case TextSourceCorporate.refname:
                case TextSourceCorporate.shortname:
                    textSourceCorporate = new TextSourceCorporate(e);
                    break;
                case SourceTitle.refname:
                case SourceTitle.shortname:
                    sourceTitles = JPU.addToList(sourceTitles, new SourceTitle(e));
                    break;
                case ContentDate.refname:
                case ContentDate.shortname:
                    contentDates = JPU.addToList(contentDates, new ContentDate(e));
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

    private TextType textType = TextType.EMPTY;

    /**
     * (this field is required)
     */
    public TextType textType() {
        _initialize();
        return textType;
    }

    private ListOfOnixElement<ContentAudience, ContentAudiences> contentAudiences = ListOfOnixElement.empty();

    /**
     * (this list is required to contain at least one item)
     */
    public ListOfOnixElement<ContentAudience, ContentAudiences> contentAudiences() {
        _initialize();
        return contentAudiences;
    }

    private ListOfOnixElement<Text, String> texts = ListOfOnixElement.empty();

    /**
     * (this list is required to contain at least one item)
     */
    public ListOfOnixElement<Text, String> texts() {
        _initialize();
        return texts;
    }

    private ListOfOnixElement<TextAuthor, String> textAuthors = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<TextAuthor, String> textAuthors() {
        _initialize();
        return textAuthors;
    }

    private TextSourceCorporate textSourceCorporate = TextSourceCorporate.EMPTY;

    /**
     * (this field is optional)
     */
    public TextSourceCorporate textSourceCorporate() {
        _initialize();
        return textSourceCorporate;
    }

    private ListOfOnixElement<SourceTitle, String> sourceTitles = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<SourceTitle, String> sourceTitles() {
        _initialize();
        return sourceTitles;
    }

    private ListOfOnixDataCompositeWithKey<ContentDate, JonixContentDate, ContentDateRoles> contentDates =
        ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataCompositeWithKey<ContentDate, JonixContentDate, ContentDateRoles> contentDates() {
        _initialize();
        return contentDates;
    }
}
