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
import com.tectonica.jonix.codelist.LanguageCodes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.SeriesIdentifierTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TitleTypes;
import com.tectonica.jonix.codelist.TransliterationSchemes;
import com.tectonica.jonix.struct.JonixSeriesIdentifier;
import com.tectonica.jonix.struct.JonixTitle;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Series composite</h1><p>A repeatable group of data elements which together describe a series of which the product
 * is part.</p><table border='1' cellpadding='3'><tr><td>Reference name</td><td>&lt;Series&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;series&gt;</td></tr></table>
 */
public class Series implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Series";
    public static final String shortname = "series";

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
    public static final Series EMPTY = new Series();

    public Series() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public Series(org.w3c.dom.Element element) {
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
            if (name.equals(SeriesISSN.refname) || name.equals(SeriesISSN.shortname)) {
                seriesISSN = new SeriesISSN(e);
            } else if (name.equals(PublisherSeriesCode.refname) || name.equals(PublisherSeriesCode.shortname)) {
                publisherSeriesCode = new PublisherSeriesCode(e);
            } else if (name.equals(SeriesIdentifier.refname) || name.equals(SeriesIdentifier.shortname)) {
                seriesIdentifiers = JPU.addToList(seriesIdentifiers, new SeriesIdentifier(e));
            } else if (name.equals(TitleOfSeries.refname) || name.equals(TitleOfSeries.shortname)) {
                titleOfSeries = new TitleOfSeries(e);
            } else if (name.equals(Title.refname) || name.equals(Title.shortname)) {
                titles = JPU.addToList(titles, new Title(e));
            } else if (name.equals(Contributor.refname) || name.equals(Contributor.shortname)) {
                contributors = JPU.addToList(contributors, new Contributor(e));
            } else if (name.equals(NumberWithinSeries.refname) || name.equals(NumberWithinSeries.shortname)) {
                numberWithinSeries = new NumberWithinSeries(e);
            } else if (name.equals(YearOfAnnual.refname) || name.equals(YearOfAnnual.shortname)) {
                yearOfAnnual = new YearOfAnnual(e);
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

    private SeriesISSN seriesISSN = SeriesISSN.EMPTY;

    /**
     * (this field is optional)
     */
    public SeriesISSN seriesISSN() {
        initialize();
        return seriesISSN;
    }

    private PublisherSeriesCode publisherSeriesCode = PublisherSeriesCode.EMPTY;

    /**
     * (this field is optional)
     */
    public PublisherSeriesCode publisherSeriesCode() {
        initialize();
        return publisherSeriesCode;
    }

    private ListOfOnixDataCompositeWithKey<SeriesIdentifier, JonixSeriesIdentifier, SeriesIdentifierTypes>
        seriesIdentifiers = ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataCompositeWithKey<SeriesIdentifier, JonixSeriesIdentifier, SeriesIdentifierTypes> seriesIdentifiers() {
        initialize();
        return seriesIdentifiers;
    }

    private TitleOfSeries titleOfSeries = TitleOfSeries.EMPTY;

    /**
     * (this field is required)
     */
    public TitleOfSeries titleOfSeries() {
        initialize();
        return titleOfSeries;
    }

    private ListOfOnixDataCompositeWithKey<Title, JonixTitle, TitleTypes> titles =
        ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataCompositeWithKey<Title, JonixTitle, TitleTypes> titles() {
        initialize();
        return titles;
    }

    private List<Contributor> contributors = Collections.emptyList();

    /**
     * (this list may be empty)
     */
    public List<Contributor> contributors() {
        initialize();
        return contributors;
    }

    private NumberWithinSeries numberWithinSeries = NumberWithinSeries.EMPTY;

    /**
     * (this field is optional)
     */
    public NumberWithinSeries numberWithinSeries() {
        initialize();
        return numberWithinSeries;
    }

    private YearOfAnnual yearOfAnnual = YearOfAnnual.EMPTY;

    /**
     * (this field is optional)
     */
    public YearOfAnnual yearOfAnnual() {
        initialize();
        return yearOfAnnual;
    }
}
