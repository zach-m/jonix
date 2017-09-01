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
 * <h1>Cited content composite</h1><p>A group of data elements which together describe a piece of cited content.
 * Optional and repeatable.</p><table border='1' cellpadding='3'><tr><td>Reference
 * name</td><td>&lt;CitedContent&gt;</td></tr><tr><td>Short tag</td><td>&lt;citedcontent&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;n</td></tr></table>
 */
public class CitedContent implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "CitedContent";
    public static final String shortname = "citedcontent";

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
    public static final CitedContent EMPTY = new CitedContent();

    public CitedContent() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public CitedContent(org.w3c.dom.Element element) {
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
            switch (name) {
                case CitedContentType.refname:
                case CitedContentType.shortname:
                    citedContentType = new CitedContentType(e);
                    break;
                case ContentAudience.refname:
                case ContentAudience.shortname:
                    contentAudiences = JPU.addToList(contentAudiences, new ContentAudience(e));
                    break;
                case SourceType.refname:
                case SourceType.shortname:
                    sourceType = new SourceType(e);
                    break;
                case SourceTitle.refname:
                case SourceTitle.shortname:
                    sourceTitles = JPU.addToList(sourceTitles, new SourceTitle(e));
                    break;
                case ListName.refname:
                case ListName.shortname:
                    listNames = JPU.addToList(listNames, new ListName(e));
                    break;
                case PositionOnList.refname:
                case PositionOnList.shortname:
                    positionOnList = new PositionOnList(e);
                    break;
                case CitationNote.refname:
                case CitationNote.shortname:
                    citationNotes = JPU.addToList(citationNotes, new CitationNote(e));
                    break;
                case ResourceLink.refname:
                case ResourceLink.shortname:
                    resourceLinks = JPU.addToList(resourceLinks, new ResourceLink(e));
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

    private CitedContentType citedContentType = CitedContentType.EMPTY;

    /**
     * (this field is required)
     */
    public CitedContentType citedContentType() {
        initialize();
        return citedContentType;
    }

    private ListOfOnixElement<ContentAudience, ContentAudiences> contentAudiences = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<ContentAudience, ContentAudiences> contentAudiences() {
        initialize();
        return contentAudiences;
    }

    private SourceType sourceType = SourceType.EMPTY;

    /**
     * (this field is optional)
     */
    public SourceType sourceType() {
        initialize();
        return sourceType;
    }

    private ListOfOnixElement<SourceTitle, String> sourceTitles = ListOfOnixElement.empty();

    /**
     * (this list is required to contain at least one item)
     */
    public ListOfOnixElement<SourceTitle, String> sourceTitles() {
        initialize();
        return sourceTitles;
    }

    private ListOfOnixElement<ListName, String> listNames = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<ListName, String> listNames() {
        initialize();
        return listNames;
    }

    private PositionOnList positionOnList = PositionOnList.EMPTY;

    /**
     * (this field is optional)
     */
    public PositionOnList positionOnList() {
        initialize();
        return positionOnList;
    }

    private ListOfOnixElement<CitationNote, String> citationNotes = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<CitationNote, String> citationNotes() {
        initialize();
        return citationNotes;
    }

    private ListOfOnixElement<ResourceLink, String> resourceLinks = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<ResourceLink, String> resourceLinks() {
        initialize();
        return resourceLinks;
    }

    private ListOfOnixDataCompositeWithKey<ContentDate, JonixContentDate, ContentDateRoles> contentDates =
        ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataCompositeWithKey<ContentDate, JonixContentDate, ContentDateRoles> contentDates() {
        initialize();
        return contentDates;
    }
}
