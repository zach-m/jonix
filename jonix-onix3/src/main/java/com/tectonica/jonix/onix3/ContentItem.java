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
import com.tectonica.jonix.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixSubject;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Content item composite</h1><p>A repeatable group of data elements which together describe a content item within a
 * product. Mandatory in any occurrence of the &lt;ContentDetail&gt; composite.</p><table border='1'
 * cellpadding='3'><tr><td>Reference name</td><td>&lt;ContentItem&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;contentitem&gt;</td></tr><tr><td>Cardinality</td><td>1&#8230;n</td></tr></table>
 */
public class ContentItem implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "ContentItem";
    public static final String shortname = "contentitem";

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
    public static final ContentItem EMPTY = new ContentItem();

    public ContentItem() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public ContentItem(org.w3c.dom.Element element) {
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
            if (name.equals(LevelSequenceNumber.refname) || name.equals(LevelSequenceNumber.shortname)) {
                levelSequenceNumber = new LevelSequenceNumber(e);
            } else if (name.equals(TextItem.refname) || name.equals(TextItem.shortname)) {
                textItem = new TextItem(e);
            } else if (name.equals(ComponentTypeName.refname) || name.equals(ComponentTypeName.shortname)) {
                componentTypeName = new ComponentTypeName(e);
            } else if (name.equals(ComponentNumber.refname) || name.equals(ComponentNumber.shortname)) {
                componentNumber = new ComponentNumber(e);
            } else if (name.equals(TitleDetail.refname) || name.equals(TitleDetail.shortname)) {
                titleDetails = JPU.addToList(titleDetails, new TitleDetail(e));
            } else if (name.equals(Contributor.refname) || name.equals(Contributor.shortname)) {
                contributors = JPU.addToList(contributors, new Contributor(e));
            } else if (name.equals(Subject.refname) || name.equals(Subject.shortname)) {
                subjects = JPU.addToList(subjects, new Subject(e));
            } else if (name.equals(NameAsSubject.refname) || name.equals(NameAsSubject.shortname)) {
                nameAsSubjects = JPU.addToList(nameAsSubjects, new NameAsSubject(e));
            } else if (name.equals(TextContent.refname) || name.equals(TextContent.shortname)) {
                textContents = JPU.addToList(textContents, new TextContent(e));
            } else if (name.equals(CitedContent.refname) || name.equals(CitedContent.shortname)) {
                citedContents = JPU.addToList(citedContents, new CitedContent(e));
            } else if (name.equals(SupportingResource.refname) || name.equals(SupportingResource.shortname)) {
                supportingResources = JPU.addToList(supportingResources, new SupportingResource(e));
            } else if (name.equals(RelatedWork.refname) || name.equals(RelatedWork.shortname)) {
                relatedWorks = JPU.addToList(relatedWorks, new RelatedWork(e));
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

    private LevelSequenceNumber levelSequenceNumber = LevelSequenceNumber.EMPTY;

    /**
     * (this field is optional)
     */
    public LevelSequenceNumber levelSequenceNumber() {
        initialize();
        return levelSequenceNumber;
    }

    private TextItem textItem = TextItem.EMPTY;

    /**
     * (this field is required)
     */
    public TextItem textItem() {
        initialize();
        return textItem;
    }

    private ComponentTypeName componentTypeName = ComponentTypeName.EMPTY;

    /**
     * (this field is required)
     */
    public ComponentTypeName componentTypeName() {
        initialize();
        return componentTypeName;
    }

    private ComponentNumber componentNumber = ComponentNumber.EMPTY;

    /**
     * (this field is optional)
     */
    public ComponentNumber componentNumber() {
        initialize();
        return componentNumber;
    }

    private List<TitleDetail> titleDetails = Collections.emptyList();

    /**
     * (this list may be empty)
     */
    public List<TitleDetail> titleDetails() {
        initialize();
        return titleDetails;
    }

    private List<Contributor> contributors = Collections.emptyList();

    /**
     * (this list may be empty)
     */
    public List<Contributor> contributors() {
        initialize();
        return contributors;
    }

    private ListOfOnixDataComposite<Subject, JonixSubject> subjects = ListOfOnixDataComposite.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataComposite<Subject, JonixSubject> subjects() {
        initialize();
        return subjects;
    }

    private List<NameAsSubject> nameAsSubjects = Collections.emptyList();

    /**
     * (this list may be empty)
     */
    public List<NameAsSubject> nameAsSubjects() {
        initialize();
        return nameAsSubjects;
    }

    private List<TextContent> textContents = Collections.emptyList();

    /**
     * (this list may be empty)
     */
    public List<TextContent> textContents() {
        initialize();
        return textContents;
    }

    private List<CitedContent> citedContents = Collections.emptyList();

    /**
     * (this list may be empty)
     */
    public List<CitedContent> citedContents() {
        initialize();
        return citedContents;
    }

    private List<SupportingResource> supportingResources = Collections.emptyList();

    /**
     * (this list may be empty)
     */
    public List<SupportingResource> supportingResources() {
        initialize();
        return supportingResources;
    }

    private List<RelatedWork> relatedWorks = Collections.emptyList();

    /**
     * (this list may be empty)
     */
    public List<RelatedWork> relatedWorks() {
        initialize();
        return relatedWorks;
    }
}
