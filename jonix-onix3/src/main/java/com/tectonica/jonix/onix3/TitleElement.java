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
import com.tectonica.jonix.OnixComposite.OnixDataComposite;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixTitleElement;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Title element composite</h1><p>A repeatable group of data elements which together represent an element of a
 * title. At least one title element is mandatory in each occurrence of the &lt;TitleDetail&gt; composite. An instance
 * of the &lt;TitleElement&gt; composite must include at least one of: &lt;PartNumber&gt;; &lt;YearOfAnnual&gt;;
 * &lt;TitleText&gt;, &lt;NoPrefix/&gt; together with &lt;TitleWithoutPrefix&gt;, or &lt;TitlePrefix&gt; together with
 * &lt;TitleWithoutPrefix&gt;. In other words it <em>must</em> carry <em>either</em> the text of a title <em>or</em> a
 * part or year designation, and it <em>may</em> carry both.</p><p>A title element must be designated as belonging to
 * product level, collection level, or subcollection level (the last-named only in the case of a multi-level
 * collection).</p><p>In the simplest case, a product title will consist of a single title element, at product level.
 * However, the composite structure in ONIX 3.0 allows complex titles to be correctly represented, in the sequence in
 * which the publisher wishes the elements to be displayed.</p><table border='1' cellpadding='3'><tr><td>Reference
 * name</td><td>&lt;TitleElement&gt;</td></tr><tr><td>Short tag</td><td>&lt;titleelement&gt;</td></tr><tr><td>Cardinality</td><td>1&#8230;n</td></tr></table>
 */
public class TitleElement implements OnixDataComposite<JonixTitleElement>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "TitleElement";
    public static final String shortname = "titleelement";

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
    public static final TitleElement EMPTY = new TitleElement();

    public TitleElement() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public TitleElement(org.w3c.dom.Element element) {
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
                case SequenceNumber.refname:
                case SequenceNumber.shortname:
                    sequenceNumber = new SequenceNumber(e);
                    break;
                case TitleElementLevel.refname:
                case TitleElementLevel.shortname:
                    titleElementLevel = new TitleElementLevel(e);
                    break;
                case PartNumber.refname:
                case PartNumber.shortname:
                    partNumber = new PartNumber(e);
                    break;
                case YearOfAnnual.refname:
                case YearOfAnnual.shortname:
                    yearOfAnnual = new YearOfAnnual(e);
                    break;
                case TitlePrefix.refname:
                case TitlePrefix.shortname:
                    titlePrefix = new TitlePrefix(e);
                    break;
                case NoPrefix.refname:
                case NoPrefix.shortname:
                    noPrefix = new NoPrefix(e);
                    break;
                case TitleWithoutPrefix.refname:
                case TitleWithoutPrefix.shortname:
                    titleWithoutPrefix = new TitleWithoutPrefix(e);
                    break;
                case TitleText.refname:
                case TitleText.shortname:
                    titleText = new TitleText(e);
                    break;
                case Subtitle.refname:
                case Subtitle.shortname:
                    subtitle = new Subtitle(e);
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

    private SequenceNumber sequenceNumber = SequenceNumber.EMPTY;

    /**
     * (this field is optional)
     */
    public SequenceNumber sequenceNumber() {
        initialize();
        return sequenceNumber;
    }

    private TitleElementLevel titleElementLevel = TitleElementLevel.EMPTY;

    /**
     * (this field is required)
     */
    public TitleElementLevel titleElementLevel() {
        initialize();
        return titleElementLevel;
    }

    private PartNumber partNumber = PartNumber.EMPTY;

    /**
     * (this field is required)
     */
    public PartNumber partNumber() {
        initialize();
        return partNumber;
    }

    private YearOfAnnual yearOfAnnual = YearOfAnnual.EMPTY;

    /**
     * (this field is optional)
     */
    public YearOfAnnual yearOfAnnual() {
        initialize();
        return yearOfAnnual;
    }

    private TitlePrefix titlePrefix = TitlePrefix.EMPTY;

    /**
     * (this field is optional)
     */
    public TitlePrefix titlePrefix() {
        initialize();
        return titlePrefix;
    }

    private NoPrefix noPrefix = NoPrefix.EMPTY;

    /**
     * (this field is optional)
     */
    public NoPrefix noPrefix() {
        initialize();
        return noPrefix;
    }

    public boolean isNoPrefix() {
        return (noPrefix().exists());
    }

    private TitleWithoutPrefix titleWithoutPrefix = TitleWithoutPrefix.EMPTY;

    /**
     * (this field is required)
     */
    public TitleWithoutPrefix titleWithoutPrefix() {
        initialize();
        return titleWithoutPrefix;
    }

    private TitleText titleText = TitleText.EMPTY;

    /**
     * (this field is optional)
     */
    public TitleText titleText() {
        initialize();
        return titleText;
    }

    private Subtitle subtitle = Subtitle.EMPTY;

    /**
     * (this field is optional)
     */
    public Subtitle subtitle() {
        initialize();
        return subtitle;
    }

    @Override
    public JonixTitleElement asStruct() {
        initialize();
        JonixTitleElement struct = new JonixTitleElement();
        struct.sequenceNumber = sequenceNumber.value;
        struct.titleElementLevel = titleElementLevel.value;
        struct.partNumber = partNumber.value;
        struct.yearOfAnnual = yearOfAnnual.value;
        struct.titlePrefix = titlePrefix.value;
        struct.isNoPrefix = isNoPrefix();
        struct.titleWithoutPrefix = titleWithoutPrefix.value;
        struct.titleText = titleText.value;
        struct.subtitle = subtitle.value;
        return struct;
    }
}
