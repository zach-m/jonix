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

package com.tectonica.jonix.onix2;

import com.tectonica.jonix.common.JPU;
import com.tectonica.jonix.common.ListOfOnixComposite;
import com.tectonica.jonix.common.ListOfOnixDataComposite;
import com.tectonica.jonix.common.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.common.ListOfOnixElement;
import com.tectonica.jonix.common.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.common.codelist.ImageAudioVideoFileTypes;
import com.tectonica.jonix.common.codelist.Languages;
import com.tectonica.jonix.common.codelist.OtherTextTypes;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.TextCaseFlags;
import com.tectonica.jonix.common.codelist.TextFormats;
import com.tectonica.jonix.common.codelist.TitleTypes;
import com.tectonica.jonix.common.codelist.TransliterationSchemes;
import com.tectonica.jonix.common.codelist.WorkIdentifierTypes;
import com.tectonica.jonix.common.struct.JonixMediaFile;
import com.tectonica.jonix.common.struct.JonixOtherText;
import com.tectonica.jonix.common.struct.JonixSubject;
import com.tectonica.jonix.common.struct.JonixTitle;
import com.tectonica.jonix.common.struct.JonixWebsite;
import com.tectonica.jonix.common.struct.JonixWorkIdentifier;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Content item composite</h1>
 * <p>
 * A repeatable group of data elements which together describe a content item within a product.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;ContentItem&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;contentitem&gt;</tt></td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Product}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link ContentItem}</li>
 * </ul>
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

    public Languages language;

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
        language = Languages.byCode(JPU.getAttribute(element, "language"));
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
                case TextItem.refname:
                case TextItem.shortname:
                    textItem = new TextItem(e);
                    break;
                case ComponentTypeName.refname:
                case ComponentTypeName.shortname:
                    componentTypeName = new ComponentTypeName(e);
                    break;
                case LevelSequenceNumber.refname:
                case LevelSequenceNumber.shortname:
                    levelSequenceNumber = new LevelSequenceNumber(e);
                    break;
                case ComponentNumber.refname:
                case ComponentNumber.shortname:
                    componentNumber = new ComponentNumber(e);
                    break;
                case DistinctiveTitle.refname:
                case DistinctiveTitle.shortname:
                    distinctiveTitle = new DistinctiveTitle(e);
                    break;
                case ContributorStatement.refname:
                case ContributorStatement.shortname:
                    contributorStatement = new ContributorStatement(e);
                    break;
                case Website.refname:
                case Website.shortname:
                    websites = JPU.addToList(websites, new Website(e));
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

    /**
     * @return whether this tag (&lt;ContentItem&gt; or &lt;contentitem&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<ContentItem> action) {
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

    private TextItem textItem = TextItem.EMPTY;

    /**
     * <p>
     * A group of data elements which are specific to text content. The composite must occur once and only once in a
     * &lt;ContentItem&gt; composite which describes a text content item. (Similar composites are being defined for
     * other media, and the occurrence of one of them will be mandatory in any &lt;ContentItem&gt; composite.)
     * </p>
     * Jonix-Comment: this field is required
     */
    public TextItem textItem() {
        _initialize();
        return textItem;
    }

    private ComponentTypeName componentTypeName = ComponentTypeName.EMPTY;

    /**
     * <p>
     * The generic name (if any) which is given in the product to the type of section which the content item represents,
     * <em>eg</em> Chapter, Part, Track. Optional and non-repeating; but either this field or a title (in
     * &lt;DistinctiveTitle&gt; or in a &lt;Title&gt; composite) or both must be present in any occurrence of the
     * &lt;ContentItem&gt; composite.
     * </p>
     * Jonix-Comment: this field is required
     */
    public ComponentTypeName componentTypeName() {
        _initialize();
        return componentTypeName;
    }

    private LevelSequenceNumber levelSequenceNumber = LevelSequenceNumber.EMPTY;

    /**
     * <p>
     * A number which specifies the position of a content item in a multi-level hierarchy of such items. Numbering
     * starts at the top level in the hierarchy, which may represent (eg) chapters in a printed book, and the first item
     * at the top level is numbered 1. Numbers should be assigned solely with a view to the logic of the ONIX
     * description and not in relation to any other characteristics of the items being numbered (such as their
     * typographical layout in a printed table of contents). &lt;LevelSequenceNumber&gt; is not a required field, but it
     * is strongly recommended for structured tables of contents. If used, it must occur once and only once in each
     * occurrence of the &lt;ContentItem&gt; composite.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public LevelSequenceNumber levelSequenceNumber() {
        _initialize();
        return levelSequenceNumber;
    }

    private ComponentNumber componentNumber = ComponentNumber.EMPTY;

    /**
     * <p>
     * The number (if any) which is given to the content item in the product, in the form (<em>eg</em> Arabic or roman)
     * in which it is given in the product. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public ComponentNumber componentNumber() {
        _initialize();
        return componentNumber;
    }

    private DistinctiveTitle distinctiveTitle = DistinctiveTitle.EMPTY;

    /**
     * <p>
     * The distinctive title of a content item. Optional and non-repeating; but either this field (or a title in a
     * &lt;Title&gt;composite) or a &lt;ComponentTypeName&gt; must be present in any occurrence of the
     * &lt;ContentItem&gt; composite. <strong>The &lt;Title&gt; composite provides a more general method of handling all
     * forms of title, and is to be preferred.</strong>
     * </p>
     * Jonix-Comment: this field is optional
     */
    public DistinctiveTitle distinctiveTitle() {
        _initialize();
        return distinctiveTitle;
    }

    private ContributorStatement contributorStatement = ContributorStatement.EMPTY;

    /**
     * <p>
     * Free text showing exactly how the authorship should be described in an online display, when a standard
     * concatenation of individual contributor elements would not give a satisfactory presentation. When this field is
     * sent, the receiving party is expected to use it to replace all names sent in the &lt;Contributor&gt; composite
     * for display purposes only. It does not replace any biographical notes sent in the composite. The individual
     * contributor elements must also be sent for indexing and retrieval.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public ContributorStatement contributorStatement() {
        _initialize();
        return contributorStatement;
    }

    private ListOfOnixDataComposite<Website, JonixWebsite> websites = JPU.emptyListOfOnixDataComposite(Website.class);

    /**
     * <p>
     * A repeatable group of data elements which together identify and provide pointers to a website which is related to
     * a content item.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataComposite<Website, JonixWebsite> websites() {
        _initialize();
        return websites;
    }

    private ListOfOnixDataCompositeWithKey<Title, JonixTitle, TitleTypes> titles =
        JPU.emptyListOfOnixDataCompositeWithKey(Title.class);

    /**
     * <p>
     * A repeatable group of data elements which together give the text of a title of a content item and specify its
     * type, used here to give alternate forms of title for a content item. <strong>Please see Group&nbsp;PR.7 for
     * details.</strong>
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<Title, JonixTitle, TitleTypes> titles() {
        _initialize();
        return titles;
    }

    private ListOfOnixDataCompositeWithKey<WorkIdentifier, JonixWorkIdentifier, WorkIdentifierTypes> workIdentifiers =
        JPU.emptyListOfOnixDataCompositeWithKey(WorkIdentifier.class);

    /**
     * <p>
     * A group of data elements which together define the identifier of a work which is manifested in the content item.
     * Optional and repeatable. <strong>Please see Group&nbsp;PR.7 for details.</strong>
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<WorkIdentifier, JonixWorkIdentifier, WorkIdentifierTypes> workIdentifiers() {
        _initialize();
        return workIdentifiers;
    }

    private ListOfOnixComposite<Contributor> contributors = JPU.emptyListOfOnixComposite(Contributor.class);

    /**
     * <p>
     * A group of data elements which together describe a personal or corporate contributor to a content item. Optional
     * and repeatable. <strong>Please see Group&nbsp;PR.8 for details.</strong>
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixComposite<Contributor> contributors() {
        _initialize();
        return contributors;
    }

    private ListOfOnixDataComposite<Subject, JonixSubject> subjects = JPU.emptyListOfOnixDataComposite(Subject.class);

    /**
     * <p>
     * A repeatable group of data elements which together describe a subject of a content item. <strong>Please see
     * Group&nbsp;PR.13 for details.</strong>
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataComposite<Subject, JonixSubject> subjects() {
        _initialize();
        return subjects;
    }

    private ListOfOnixComposite<PersonAsSubject> personAsSubjects = JPU.emptyListOfOnixComposite(PersonAsSubject.class);

    /**
     * <p>
     * A repeatable group of data elements which together identify a person as a subject of a content item.
     * <strong>Please see Group&nbsp;PR.13 for details.</strong>
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixComposite<PersonAsSubject> personAsSubjects() {
        _initialize();
        return personAsSubjects;
    }

    private ListOfOnixElement<CorporateBodyAsSubject, String> corporateBodyAsSubjects = ListOfOnixElement.empty();

    /**
     * <p>
     * The name of a corporate body which is part of the subject of the content item. Optional, and repeatable if more
     * than one corporate body is involved.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<CorporateBodyAsSubject, String> corporateBodyAsSubjects() {
        _initialize();
        return corporateBodyAsSubjects;
    }

    private ListOfOnixElement<PlaceAsSubject, String> placeAsSubjects = ListOfOnixElement.empty();

    /**
     * <p>
     * The name of a place or region or geographical entity which is part of the subject of the content item. Optional,
     * and repeatable if the subject of the content item includes more than one place.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<PlaceAsSubject, String> placeAsSubjects() {
        _initialize();
        return placeAsSubjects;
    }

    private ListOfOnixDataCompositeWithKey<OtherText, JonixOtherText, OtherTextTypes> otherTexts =
        JPU.emptyListOfOnixDataCompositeWithKey(OtherText.class);

    /**
     * <p>
     * A repeatable group of data elements which together identify, and either include or provide pointers to, text
     * related to a content item. <strong>Please see Group&nbsp;PR.15 for details.</strong>
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<OtherText, JonixOtherText, OtherTextTypes> otherTexts() {
        _initialize();
        return otherTexts;
    }

    private ListOfOnixDataCompositeWithKey<MediaFile, JonixMediaFile, ImageAudioVideoFileTypes> mediaFiles =
        JPU.emptyListOfOnixDataCompositeWithKey(MediaFile.class);

    /**
     * <p>
     * A repeatable group of data elements which together identify and provide pointers to an image, audio or video file
     * related to a content item. <strong>Please see Group&nbsp;PR.16 for details.</strong>
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<MediaFile, JonixMediaFile, ImageAudioVideoFileTypes> mediaFiles() {
        _initialize();
        return mediaFiles;
    }
}
