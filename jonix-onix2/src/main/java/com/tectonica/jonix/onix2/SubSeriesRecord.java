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
import com.tectonica.jonix.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.codelist.Languages;
import com.tectonica.jonix.codelist.OtherTextTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.SeriesIdentifierTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TitleTypes;
import com.tectonica.jonix.codelist.TransliterationSchemes;
import com.tectonica.jonix.struct.JonixOtherText;
import com.tectonica.jonix.struct.JonixSeriesIdentifier;
import com.tectonica.jonix.struct.JonixTitle;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
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
                case SeriesIdentifier.refname:
                case SeriesIdentifier.shortname:
                    seriesIdentifiers = JPU.addToList(seriesIdentifiers, new SeriesIdentifier(e));
                    break;
                case ParentIdentifier.refname:
                case ParentIdentifier.shortname:
                    parentIdentifier = new ParentIdentifier(e);
                    break;
                case LevelSequenceNumber.refname:
                case LevelSequenceNumber.shortname:
                    levelSequenceNumber = new LevelSequenceNumber(e);
                    break;
                case SeriesPartName.refname:
                case SeriesPartName.shortname:
                    seriesPartName = new SeriesPartName(e);
                    break;
                case NumberWithinSeries.refname:
                case NumberWithinSeries.shortname:
                    numberWithinSeries = new NumberWithinSeries(e);
                    break;
                case Title.refname:
                case Title.shortname:
                    titles = JPU.addToList(titles, new Title(e));
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
                case SubordinateEntries.refname:
                case SubordinateEntries.shortname:
                    subordinateEntries = new SubordinateEntries(e);
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

    private RecordReference recordReference = RecordReference.EMPTY;

    /**
     * (this field is required)
     */
    public RecordReference recordReference() {
        _initialize();
        return recordReference;
    }

    private NotificationType notificationType = NotificationType.EMPTY;

    /**
     * (this field is required)
     */
    public NotificationType notificationType() {
        _initialize();
        return notificationType;
    }

    private DeletionCode deletionCode = DeletionCode.EMPTY;

    /**
     * (this field is optional)
     */
    public DeletionCode deletionCode() {
        _initialize();
        return deletionCode;
    }

    private DeletionText deletionText = DeletionText.EMPTY;

    /**
     * (this field is optional)
     */
    public DeletionText deletionText() {
        _initialize();
        return deletionText;
    }

    private RecordSourceType recordSourceType = RecordSourceType.EMPTY;

    /**
     * (this field is optional)
     */
    public RecordSourceType recordSourceType() {
        _initialize();
        return recordSourceType;
    }

    private RecordSourceIdentifierType recordSourceIdentifierType = RecordSourceIdentifierType.EMPTY;

    /**
     * (this field is optional)
     */
    public RecordSourceIdentifierType recordSourceIdentifierType() {
        _initialize();
        return recordSourceIdentifierType;
    }

    private RecordSourceIdentifier recordSourceIdentifier = RecordSourceIdentifier.EMPTY;

    /**
     * (this field is optional)
     */
    public RecordSourceIdentifier recordSourceIdentifier() {
        _initialize();
        return recordSourceIdentifier;
    }

    private RecordSourceName recordSourceName = RecordSourceName.EMPTY;

    /**
     * (this field is optional)
     */
    public RecordSourceName recordSourceName() {
        _initialize();
        return recordSourceName;
    }

    private ListOfOnixDataCompositeWithKey<SeriesIdentifier, JonixSeriesIdentifier, SeriesIdentifierTypes>
        seriesIdentifiers = ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * (this list is required to contain at least one item)
     */
    public ListOfOnixDataCompositeWithKey<SeriesIdentifier, JonixSeriesIdentifier, SeriesIdentifierTypes> seriesIdentifiers() {
        _initialize();
        return seriesIdentifiers;
    }

    private ParentIdentifier parentIdentifier = ParentIdentifier.EMPTY;

    /**
     * (this field is required)
     */
    public ParentIdentifier parentIdentifier() {
        _initialize();
        return parentIdentifier;
    }

    private LevelSequenceNumber levelSequenceNumber = LevelSequenceNumber.EMPTY;

    /**
     * (this field is required)
     */
    public LevelSequenceNumber levelSequenceNumber() {
        _initialize();
        return levelSequenceNumber;
    }

    private SeriesPartName seriesPartName = SeriesPartName.EMPTY;

    /**
     * (this field is optional)
     */
    public SeriesPartName seriesPartName() {
        _initialize();
        return seriesPartName;
    }

    private NumberWithinSeries numberWithinSeries = NumberWithinSeries.EMPTY;

    /**
     * (this field is optional)
     */
    public NumberWithinSeries numberWithinSeries() {
        _initialize();
        return numberWithinSeries;
    }

    private ListOfOnixDataCompositeWithKey<Title, JonixTitle, TitleTypes> titles =
        ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * (this list is required to contain at least one item)
     */
    public ListOfOnixDataCompositeWithKey<Title, JonixTitle, TitleTypes> titles() {
        _initialize();
        return titles;
    }

    private List<Contributor> contributors = Collections.emptyList();

    /**
     * (this list may be empty)
     */
    public List<Contributor> contributors() {
        _initialize();
        return contributors;
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

    private List<Publisher> publishers = Collections.emptyList();

    /**
     * (this list may be empty)
     */
    public List<Publisher> publishers() {
        _initialize();
        return publishers;
    }

    private SubordinateEntries subordinateEntries = SubordinateEntries.EMPTY;

    /**
     * (this field is optional)
     */
    public SubordinateEntries subordinateEntries() {
        _initialize();
        return subordinateEntries;
    }
}
