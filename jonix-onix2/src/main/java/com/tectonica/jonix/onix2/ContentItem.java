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
import com.tectonica.jonix.ListOfOnixElement;
import com.tectonica.jonix.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.codelist.ImageAudioVideoFileTypes;
import com.tectonica.jonix.codelist.LanguageCodes;
import com.tectonica.jonix.codelist.OtherTextTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TitleTypes;
import com.tectonica.jonix.codelist.TransliterationSchemes;
import com.tectonica.jonix.codelist.WorkIdentifierTypes;
import com.tectonica.jonix.struct.JonixMediaFile;
import com.tectonica.jonix.struct.JonixOtherText;
import com.tectonica.jonix.struct.JonixSubject;
import com.tectonica.jonix.struct.JonixTitle;
import com.tectonica.jonix.struct.JonixWebsite;
import com.tectonica.jonix.struct.JonixWorkIdentifier;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Content item composite</h1><p>A repeatable group of data elements which together describe a content item within a
 * product.</p><table border='1' cellpadding='3'><tr><td>Reference name</td><td>&lt;ContentItem&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;contentitem&gt;</td></tr></table>
 */
public class ContentItem implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "ContentItem";
    public static final String shortname = "contentitem";

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
        textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));
        textcase = TextCaseFlags.byCode(JPU.getAttribute(element, "textcase"));
        language = LanguageCodes.byCode(JPU.getAttribute(element, "language"));
        transliteration = TransliterationSchemes.byCode(JPU.getAttribute(element, "transliteration"));
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
                case LevelSequenceNumber.refname:
                case LevelSequenceNumber.shortname:
                    levelSequenceNumber = new LevelSequenceNumber(e);
                    break;
                case TextItem.refname:
                case TextItem.shortname:
                    textItem = new TextItem(e);
                    break;
                case Website.refname:
                case Website.shortname:
                    websites = JPU.addToList(websites, new Website(e));
                    break;
                case ComponentTypeName.refname:
                case ComponentTypeName.shortname:
                    componentTypeName = new ComponentTypeName(e);
                    break;
                case ComponentNumber.refname:
                case ComponentNumber.shortname:
                    componentNumber = new ComponentNumber(e);
                    break;
                case DistinctiveTitle.refname:
                case DistinctiveTitle.shortname:
                    distinctiveTitle = new DistinctiveTitle(e);
                    break;
                case Title.refname:
                case Title.shortname:
                    titles = JPU.addToList(titles, new Title(e));
                    break;
                case WorkIdentifier.refname:
                case WorkIdentifier.shortname:
                    workIdentifiers = JPU.addToList(workIdentifiers, new WorkIdentifier(e));
                    break;
                case Contributor.refname:
                case Contributor.shortname:
                    contributors = JPU.addToList(contributors, new Contributor(e));
                    break;
                case ContributorStatement.refname:
                case ContributorStatement.shortname:
                    contributorStatement = new ContributorStatement(e);
                    break;
                case Subject.refname:
                case Subject.shortname:
                    subjects = JPU.addToList(subjects, new Subject(e));
                    break;
                case PersonAsSubject.refname:
                case PersonAsSubject.shortname:
                    personAsSubjects = JPU.addToList(personAsSubjects, new PersonAsSubject(e));
                    break;
                case CorporateBodyAsSubject.refname:
                case CorporateBodyAsSubject.shortname:
                    corporateBodyAsSubjects = JPU.addToList(corporateBodyAsSubjects, new CorporateBodyAsSubject(e));
                    break;
                case PlaceAsSubject.refname:
                case PlaceAsSubject.shortname:
                    placeAsSubjects = JPU.addToList(placeAsSubjects, new PlaceAsSubject(e));
                    break;
                case OtherText.refname:
                case OtherText.shortname:
                    otherTexts = JPU.addToList(otherTexts, new OtherText(e));
                    break;
                case MediaFile.refname:
                case MediaFile.shortname:
                    mediaFiles = JPU.addToList(mediaFiles, new MediaFile(e));
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

    private LevelSequenceNumber levelSequenceNumber = LevelSequenceNumber.EMPTY;

    /**
     * (this field is optional)
     */
    public LevelSequenceNumber levelSequenceNumber() {
        _initialize();
        return levelSequenceNumber;
    }

    private TextItem textItem = TextItem.EMPTY;

    /**
     * (this field is required)
     */
    public TextItem textItem() {
        _initialize();
        return textItem;
    }

    private ListOfOnixDataComposite<Website, JonixWebsite> websites = ListOfOnixDataComposite.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataComposite<Website, JonixWebsite> websites() {
        _initialize();
        return websites;
    }

    private ComponentTypeName componentTypeName = ComponentTypeName.EMPTY;

    /**
     * (this field is required)
     */
    public ComponentTypeName componentTypeName() {
        _initialize();
        return componentTypeName;
    }

    private ComponentNumber componentNumber = ComponentNumber.EMPTY;

    /**
     * (this field is optional)
     */
    public ComponentNumber componentNumber() {
        _initialize();
        return componentNumber;
    }

    private DistinctiveTitle distinctiveTitle = DistinctiveTitle.EMPTY;

    /**
     * (this field is optional)
     */
    public DistinctiveTitle distinctiveTitle() {
        _initialize();
        return distinctiveTitle;
    }

    private ListOfOnixDataCompositeWithKey<Title, JonixTitle, TitleTypes> titles =
        ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataCompositeWithKey<Title, JonixTitle, TitleTypes> titles() {
        _initialize();
        return titles;
    }

    private ListOfOnixDataCompositeWithKey<WorkIdentifier, JonixWorkIdentifier, WorkIdentifierTypes> workIdentifiers =
        ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataCompositeWithKey<WorkIdentifier, JonixWorkIdentifier, WorkIdentifierTypes> workIdentifiers() {
        _initialize();
        return workIdentifiers;
    }

    private List<Contributor> contributors = Collections.emptyList();

    /**
     * (this list may be empty)
     */
    public List<Contributor> contributors() {
        _initialize();
        return contributors;
    }

    private ContributorStatement contributorStatement = ContributorStatement.EMPTY;

    /**
     * (this field is optional)
     */
    public ContributorStatement contributorStatement() {
        _initialize();
        return contributorStatement;
    }

    private ListOfOnixDataComposite<Subject, JonixSubject> subjects = ListOfOnixDataComposite.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataComposite<Subject, JonixSubject> subjects() {
        _initialize();
        return subjects;
    }

    private List<PersonAsSubject> personAsSubjects = Collections.emptyList();

    /**
     * (this list may be empty)
     */
    public List<PersonAsSubject> personAsSubjects() {
        _initialize();
        return personAsSubjects;
    }

    private ListOfOnixElement<CorporateBodyAsSubject, String> corporateBodyAsSubjects = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<CorporateBodyAsSubject, String> corporateBodyAsSubjects() {
        _initialize();
        return corporateBodyAsSubjects;
    }

    private ListOfOnixElement<PlaceAsSubject, String> placeAsSubjects = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<PlaceAsSubject, String> placeAsSubjects() {
        _initialize();
        return placeAsSubjects;
    }

    private ListOfOnixDataCompositeWithKey<OtherText, JonixOtherText, OtherTextTypes> otherTexts =
        ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataCompositeWithKey<OtherText, JonixOtherText, OtherTextTypes> otherTexts() {
        _initialize();
        return otherTexts;
    }

    private ListOfOnixDataCompositeWithKey<MediaFile, JonixMediaFile, ImageAudioVideoFileTypes> mediaFiles =
        ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataCompositeWithKey<MediaFile, JonixMediaFile, ImageAudioVideoFileTypes> mediaFiles() {
        _initialize();
        return mediaFiles;
    }
}
