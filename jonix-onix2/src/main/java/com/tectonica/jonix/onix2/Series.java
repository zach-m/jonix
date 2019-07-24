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

import com.tectonica.jonix.common.JPU;
import com.tectonica.jonix.common.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.common.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.common.codelist.Languages;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.SeriesIdentifierTypes;
import com.tectonica.jonix.common.codelist.TextCaseFlags;
import com.tectonica.jonix.common.codelist.TextFormats;
import com.tectonica.jonix.common.codelist.TitleTypes;
import com.tectonica.jonix.common.codelist.TransliterationSchemes;
import com.tectonica.jonix.common.struct.JonixSeriesIdentifier;
import com.tectonica.jonix.common.struct.JonixTitle;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Series composite</h1>
 * <p>
 * A repeatable group of data elements which together describe a series of which the product is part.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;Series&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;series&gt;</tt></td>
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
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link Series}</li>
 * </ul>
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
                case TitleOfSeries.refname:
                case TitleOfSeries.shortname:
                    titleOfSeries = new TitleOfSeries(e);
                    break;
                case SeriesISSN.refname:
                case SeriesISSN.shortname:
                    seriesISSN = new SeriesISSN(e);
                    break;
                case PublisherSeriesCode.refname:
                case PublisherSeriesCode.shortname:
                    publisherSeriesCode = new PublisherSeriesCode(e);
                    break;
                case NumberWithinSeries.refname:
                case NumberWithinSeries.shortname:
                    numberWithinSeries = new NumberWithinSeries(e);
                    break;
                case YearOfAnnual.refname:
                case YearOfAnnual.shortname:
                    yearOfAnnual = new YearOfAnnual(e);
                    break;
                case SeriesIdentifier.refname:
                case SeriesIdentifier.shortname:
                    seriesIdentifiers = JPU.addToList(seriesIdentifiers, new SeriesIdentifier(e));
                    break;
                case Title.refname:
                case Title.shortname:
                    titles = JPU.addToList(titles, new Title(e));
                    break;
                case Contributor.refname:
                case Contributor.shortname:
                    contributors = JPU.addToList(contributors, new Contributor(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;Series&gt; or &lt;series&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private TitleOfSeries titleOfSeries = TitleOfSeries.EMPTY;

    /**
     * <p>
     * The full title of the series, without abbreviation or abridgement. Non-repeating. Either the
     * &lt;TitleOfSeries&gt; element or at least one occurrence of the &lt;Title&gt; composite must occur in each
     * occurrence of the &lt;Series&gt; composite. The &lt;Title&gt; composite provides a more comprehensive
     * representation of a series title, and allows alternative forms to be sent.
     * </p>
     * Jonix-Comment: this field is required
     */
    public TitleOfSeries titleOfSeries() {
        _initialize();
        return titleOfSeries;
    }

    private SeriesISSN seriesISSN = SeriesISSN.EMPTY;

    /**
     * <p>
     * International Standard Serial Number identifying a series of which the product forms part. ISSNs are the standard
     * numbering scheme for journals, and most publishers’ book series are not eligible to be identified by an ISSN.
     * ISSNs may be used, however, for established scholarly series such as Annual Reviews of… or Methods in… which are
     * shelved in libraries as if they were journals. The field is optional and non-repeating. <strong>The
     * &lt;SeriesIdentifier&gt; composite on the next page provides a more general method of handling this and other
     * series identifiers, and is to be preferred.</strong>
     * </p>
     * Jonix-Comment: this field is optional
     */
    public SeriesISSN seriesISSN() {
        _initialize();
        return seriesISSN;
    }

    private PublisherSeriesCode publisherSeriesCode = PublisherSeriesCode.EMPTY;

    /**
     * <p>
     * A code or mnemonic assigned by the publisher to designate a series (and therefore not guaranteed to be unique).
     * Optional and non-repeating. <strong>The &lt;SeriesIdentifier&gt; composite on the next page provides a more
     * general method of handling this and other series identifiers, and is to be preferred.</strong>
     * </p>
     * Jonix-Comment: this field is optional
     */
    public PublisherSeriesCode publisherSeriesCode() {
        _initialize();
        return publisherSeriesCode;
    }

    private NumberWithinSeries numberWithinSeries = NumberWithinSeries.EMPTY;

    /**
     * <p>
     * The distinctive enumeration of a product within a series. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public NumberWithinSeries numberWithinSeries() {
        _initialize();
        return numberWithinSeries;
    }

    private YearOfAnnual yearOfAnnual = YearOfAnnual.EMPTY;

    /**
     * <p>
     * The nominal year of an annual publication. May be entered as either a single year YYYY or a span of two
     * consecutive years YYYY-YYYY. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public YearOfAnnual yearOfAnnual() {
        _initialize();
        return yearOfAnnual;
    }

    private ListOfOnixDataCompositeWithKey<SeriesIdentifier, JonixSeriesIdentifier, SeriesIdentifierTypes> seriesIdentifiers = ListOfOnixDataCompositeWithKey
        .emptyKeyed();

    /**
     * <p>
     * A repeatable group of data elements which together define an identifier of a series or subseries. The composite
     * is optional, and may only repeat if two or more identifiers of different types are sent. It is not permissible to
     * have two identifiers of the same type.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<SeriesIdentifier, JonixSeriesIdentifier, SeriesIdentifierTypes> seriesIdentifiers() {
        _initialize();
        return seriesIdentifiers;
    }

    private ListOfOnixDataCompositeWithKey<Title, JonixTitle, TitleTypes> titles = ListOfOnixDataCompositeWithKey
        .emptyKeyed();

    /**
     * <p>
     * A repeatable group of data elements which together give the text of a title, including a subtitle where
     * applicable, and specify its type. <strong>Please see Group&nbsp;PR.7 for details.</strong>
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<Title, JonixTitle, TitleTypes> titles() {
        _initialize();
        return titles;
    }

    private List<Contributor> contributors = Collections.emptyList();

    /**
     * <p>
     * A repeatable group of data elements which together describe a personal or corporate contributor to the series.
     * The composite is optional in any occurrence of the &lt;Series&gt; composite. <strong>Please see Group&nbsp;PR.8
     * for details.</strong>
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public List<Contributor> contributors() {
        _initialize();
        return contributors;
    }
}
