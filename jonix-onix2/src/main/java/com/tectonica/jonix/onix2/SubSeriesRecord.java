/*
 * Copyright (C) 2012-2025 Zach Melamed
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
import com.tectonica.jonix.common.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.common.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.common.codelist.CollectionIdentifierTypes;
import com.tectonica.jonix.common.codelist.Languages;
import com.tectonica.jonix.common.codelist.OtherTextTypes;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.TextCaseFlags;
import com.tectonica.jonix.common.codelist.TextFormats;
import com.tectonica.jonix.common.codelist.TitleTypes;
import com.tectonica.jonix.common.codelist.TransliterationSchemes;
import com.tectonica.jonix.common.struct.JonixOtherText;
import com.tectonica.jonix.common.struct.JonixSeriesIdentifier;
import com.tectonica.jonix.common.struct.JonixTitle;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link ONIXMessage}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link SubSeriesRecord}</li>
 * </ul>
 */
public class SubSeriesRecord implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "SubSeriesRecord";
    public static final String shortname = "subseriesrecord";

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
    public static final SubSeriesRecord EMPTY = new SubSeriesRecord();

    public SubSeriesRecord() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public SubSeriesRecord(org.w3c.dom.Element element) {
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
                case RecordReference.refname:
                case RecordReference.shortname:
                    recordReference = new RecordReference(e);
                    break;
                case NotificationType.refname:
                case NotificationType.shortname:
                    notificationType = new NotificationType(e);
                    break;
                case ParentIdentifier.refname:
                case ParentIdentifier.shortname:
                    parentIdentifier = new ParentIdentifier(e);
                    break;
                case LevelSequenceNumber.refname:
                case LevelSequenceNumber.shortname:
                    levelSequenceNumber = new LevelSequenceNumber(e);
                    break;
                case SeriesIdentifier.refname:
                case SeriesIdentifier.shortname:
                    seriesIdentifiers = JPU.addToList(seriesIdentifiers, new SeriesIdentifier(e));
                    break;
                case Title.refname:
                case Title.shortname:
                    titles = JPU.addToList(titles, new Title(e));
                    break;
                case DeletionCode.refname:
                case DeletionCode.shortname:
                    deletionCode = new DeletionCode(e);
                    break;
                case DeletionText.refname:
                case DeletionText.shortname:
                    deletionText = new DeletionText(e);
                    break;
                case RecordSourceType.refname:
                case RecordSourceType.shortname:
                    recordSourceType = new RecordSourceType(e);
                    break;
                case RecordSourceIdentifierType.refname:
                case RecordSourceIdentifierType.shortname:
                    recordSourceIdentifierType = new RecordSourceIdentifierType(e);
                    break;
                case RecordSourceIdentifier.refname:
                case RecordSourceIdentifier.shortname:
                    recordSourceIdentifier = new RecordSourceIdentifier(e);
                    break;
                case RecordSourceName.refname:
                case RecordSourceName.shortname:
                    recordSourceName = new RecordSourceName(e);
                    break;
                case SeriesPartName.refname:
                case SeriesPartName.shortname:
                    seriesPartName = new SeriesPartName(e);
                    break;
                case NumberWithinSeries.refname:
                case NumberWithinSeries.shortname:
                    numberWithinSeries = new NumberWithinSeries(e);
                    break;
                case SubordinateEntries.refname:
                case SubordinateEntries.shortname:
                    subordinateEntries = new SubordinateEntries(e);
                    break;
                case Contributor.refname:
                case Contributor.shortname:
                    contributors = JPU.addToList(contributors, new Contributor(e));
                    break;
                case OtherText.refname:
                case OtherText.shortname:
                    otherTexts = JPU.addToList(otherTexts, new OtherText(e));
                    break;
                case Publisher.refname:
                case Publisher.shortname:
                    publishers = JPU.addToList(publishers, new Publisher(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;SubSeriesRecord&gt; or &lt;subseriesrecord&gt;) is explicitly provided in the ONIX
     *         XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<SubSeriesRecord> action) {
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

    private RecordReference recordReference = RecordReference.EMPTY;

    /**
     * <p>
     * For every product, you must choose a single number which will uniquely identify the Information record which you
     * send out about that product, and which will remain as its permanent identifier every time you send an update. It
     * doesn’t matter what number you choose, provided that it is unique and permanent. This number doesn’t really
     * identify the product – even though you may choose to use the ISBN or another product identifier – it identifies
     * your information record about the product, so that the person to whom you are sending an update can match it with
     * what you have previously sent. A good way of generating numbers which are not part of a recognized product
     * identification scheme but which can be guaranteed to be unique is to preface the number with an Internet domain
     * name which is registered to your organisation.
     * </p>
     * <p>
     * This field is mandatory and non-repeating.
     * </p>
     * JONIX adds: this field is required
     */
    public RecordReference recordReference() {
        _initialize();
        return recordReference;
    }

    private NotificationType notificationType = NotificationType.EMPTY;

    /**
     * <p>
     * An ONIX code which indicates the type of notification or update which you are sending. Mandatory and
     * non-repeating.
     * </p>
     * JONIX adds: this field is required
     */
    public NotificationType notificationType() {
        _initialize();
        return notificationType;
    }

    private ParentIdentifier parentIdentifier = ParentIdentifier.EMPTY;

    /**
     * JONIX adds: this field is required
     */
    public ParentIdentifier parentIdentifier() {
        _initialize();
        return parentIdentifier;
    }

    private LevelSequenceNumber levelSequenceNumber = LevelSequenceNumber.EMPTY;

    /**
     * JONIX adds: this field is required
     */
    public LevelSequenceNumber levelSequenceNumber() {
        _initialize();
        return levelSequenceNumber;
    }

    private ListOfOnixDataCompositeWithKey<SeriesIdentifier, JonixSeriesIdentifier,
        CollectionIdentifierTypes> seriesIdentifiers = JPU.emptyListOfOnixDataCompositeWithKey(SeriesIdentifier.class);

    /**
     * <p>
     * A repeatable group of data elements which together define an identifier of a series or subseries. The composite
     * is optional, and may only repeat if two or more identifiers of different types are sent. It is not permissible to
     * have two identifiers of the same type.
     * </p>
     * JONIX adds: this list is required to contain at least one item
     */
    public ListOfOnixDataCompositeWithKey<SeriesIdentifier, JonixSeriesIdentifier, CollectionIdentifierTypes>
        seriesIdentifiers() {
        _initialize();
        return seriesIdentifiers;
    }

    private ListOfOnixDataCompositeWithKey<Title, JonixTitle, TitleTypes> titles =
        JPU.emptyListOfOnixDataCompositeWithKey(Title.class);

    /**
     * JONIX adds: this list is required to contain at least one item
     */
    public ListOfOnixDataCompositeWithKey<Title, JonixTitle, TitleTypes> titles() {
        _initialize();
        return titles;
    }

    private DeletionCode deletionCode = DeletionCode.EMPTY;

    /**
     * <p>
     * An ONIX code which indicates the reason why an ONIX record is being deleted. Optional and non-repeating; and may
     * occur only when the &lt;NotificationType&gt; element carries the code value 05. Note that it refers to the reason
     * why the record is being deleted, not the reason why a product has been “deleted” (in industries which use this
     * terminology when a product is withdrawn).
     * </p>
     * JONIX adds: this field is optional
     */
    public DeletionCode deletionCode() {
        _initialize();
        return deletionCode;
    }

    private DeletionText deletionText = DeletionText.EMPTY;

    /**
     * <p>
     * Free text which indicates the reason why an ONIX record is being deleted. Optional and non-repeating; and may
     * occur only when the &lt;NotificationType&gt; element carries the code value 05. Note that it refers to the reason
     * why the record is being deleted, not the reason why a product has been “deleted” (in industries which use this
     * terminology when a product is withdrawn).
     * </p>
     * JONIX adds: this field is optional
     */
    public DeletionText deletionText() {
        _initialize();
        return deletionText;
    }

    private RecordSourceType recordSourceType = RecordSourceType.EMPTY;

    /**
     * <p>
     * An ONIX code which indicates the type of source which has issued the ONIX record. Optional and non-repeating,
     * independently of the occurrence of any other field.
     * </p>
     * JONIX adds: this field is optional
     */
    public RecordSourceType recordSourceType() {
        _initialize();
        return recordSourceType;
    }

    private RecordSourceIdentifierType recordSourceIdentifierType = RecordSourceIdentifierType.EMPTY;

    /**
     * <p>
     * An ONIX code identifying the scheme from which the identifier in the &lt;RecordSourceIdentifier&gt; element is
     * taken. Optional and non-repeating, but &lt;RecordSourceIdentifier&gt; must also be present if this field is
     * present.
     * </p>
     * JONIX adds: this field is optional
     */
    public RecordSourceIdentifierType recordSourceIdentifierType() {
        _initialize();
        return recordSourceIdentifierType;
    }

    private RecordSourceIdentifier recordSourceIdentifier = RecordSourceIdentifier.EMPTY;

    /**
     * <p>
     * An identifier for the party which issued the record, from the scheme specified in
     * &lt;RecordSourceIdentifierType&gt;. Optional and non-repeating, but &lt;RecordSourceIdentifierType&gt; must also
     * be present if this field is present.
     * </p>
     * JONIX adds: this field is optional
     */
    public RecordSourceIdentifier recordSourceIdentifier() {
        _initialize();
        return recordSourceIdentifier;
    }

    private RecordSourceName recordSourceName = RecordSourceName.EMPTY;

    /**
     * <p>
     * The name of the party which issued the record, as free text. Optional and non-repeating, independently of the
     * occurrence of any other field.
     * </p>
     * JONIX adds: this field is optional
     */
    public RecordSourceName recordSourceName() {
        _initialize();
        return recordSourceName;
    }

    private SeriesPartName seriesPartName = SeriesPartName.EMPTY;

    /**
     * JONIX adds: this field is optional
     */
    public SeriesPartName seriesPartName() {
        _initialize();
        return seriesPartName;
    }

    private NumberWithinSeries numberWithinSeries = NumberWithinSeries.EMPTY;

    /**
     * <p>
     * The distinctive enumeration of a product within a series. Optional and non-repeating.
     * </p>
     * JONIX adds: this field is optional
     */
    public NumberWithinSeries numberWithinSeries() {
        _initialize();
        return numberWithinSeries;
    }

    private SubordinateEntries subordinateEntries = SubordinateEntries.EMPTY;

    /**
     * JONIX adds: this field is optional
     */
    public SubordinateEntries subordinateEntries() {
        _initialize();
        return subordinateEntries;
    }

    private ListOfOnixComposite<Contributor> contributors = JPU.emptyListOfOnixComposite(Contributor.class);

    /**
     * JONIX adds: this list may be empty
     */
    public ListOfOnixComposite<Contributor> contributors() {
        _initialize();
        return contributors;
    }

    private ListOfOnixDataCompositeWithKey<OtherText, JonixOtherText, OtherTextTypes> otherTexts =
        JPU.emptyListOfOnixDataCompositeWithKey(OtherText.class);

    /**
     * JONIX adds: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<OtherText, JonixOtherText, OtherTextTypes> otherTexts() {
        _initialize();
        return otherTexts;
    }

    private ListOfOnixComposite<Publisher> publishers = JPU.emptyListOfOnixComposite(Publisher.class);

    /**
     * JONIX adds: this list may be empty
     */
    public ListOfOnixComposite<Publisher> publishers() {
        _initialize();
        return publishers;
    }
}
