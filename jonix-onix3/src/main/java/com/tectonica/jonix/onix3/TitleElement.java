/*
 * Copyright (C) 2012-2020 Zach Melamed
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

import com.tectonica.jonix.common.JPU;
import com.tectonica.jonix.common.OnixComposite.OnixDataComposite;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixTitleElement;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Title element composite</h1>
 * <p>
 * A group of data elements which together represent an element of a collection title. At least one title element is
 * mandatory in each occurrence of the &lt;TitleDetail&gt; composite. The composite is repeatable with different
 * sequence numbers and/or title element levels. An instance of the &lt;TitleElement&gt; composite must include at least
 * one of: &lt;PartNumber&gt;; &lt;YearOfAnnual&gt;; &lt;TitleText&gt;, &lt;NoPrefix/&gt; together with
 * &lt;TitleWithoutPrefix&gt;, or &lt;TitlePrefix&gt; together with &lt;TitleWithoutPrefix&gt;. In other words, it
 * <em>must</em> carry <em>either</em> the text of a title element <em>or</em> a part or year designation, and it
 * <em>may</em> carry both.
 * </p>
 * <p>
 * A title element must be designated as belonging to <em>product level</em>, <em>collection level</em>, or
 * <em>subcollection level</em> (the first of these may not occur in a title element representing a <em>collective</em>
 * identity, and the last-named may only occur in the case of a multi-level collection).
 * </p>
 * <p>
 * In the simplest case, title detail sent in a &lt;Collection&gt; composite will consist of a single title element, at
 * collection level. However, the composite structure in ONIX&nbsp;3.0 allows more complex combinations of titles and
 * part designations in multi-level collections to be correctly represented.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;TitleElement&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;titleelement&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>1&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link TitleDetail}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link TitleDetail} ⯈
 * {@link TitleElement}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link TitleDetail} ⯈
 * {@link TitleElement}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Collection} ⯈ {@link TitleDetail} ⯈
 * {@link TitleElement}</li>
 * </ul>
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

    /**
     * (type: dt.NonEmptyString)
     */
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
                case TitleElementLevel.refname:
                case TitleElementLevel.shortname:
                    titleElementLevel = new TitleElementLevel(e);
                    break;
                case PartNumber.refname:
                case PartNumber.shortname:
                    partNumber = new PartNumber(e);
                    break;
                case TitleWithoutPrefix.refname:
                case TitleWithoutPrefix.shortname:
                    titleWithoutPrefix = new TitleWithoutPrefix(e);
                    break;
                case SequenceNumber.refname:
                case SequenceNumber.shortname:
                    sequenceNumber = new SequenceNumber(e);
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

    /**
     * @return whether this tag (&lt;TitleElement&gt; or &lt;titleelement&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    @Override
    public org.w3c.dom.Element getXmlElement() {
        return element;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private TitleElementLevel titleElementLevel = TitleElementLevel.EMPTY;

    /**
     * <p>
     * An ONIX code indicating the level of a title element: collection level, subcollection level, or product level.
     * Mandatory in each occurrence of the &lt;TitleElement&gt; composite, and non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public TitleElementLevel titleElementLevel() {
        _initialize();
        return titleElementLevel;
    }

    private PartNumber partNumber = PartNumber.EMPTY;

    /**
     * <p>
     * When a title element includes a part designation within a larger whole (<i>eg</i> Part I, or Volume 3), this
     * field should be used to carry the number and its ‘caption’ as text. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public PartNumber partNumber() {
        _initialize();
        return partNumber;
    }

    private TitleWithoutPrefix titleWithoutPrefix = TitleWithoutPrefix.EMPTY;

    /**
     * <p>
     * The text of a title element without the title prefix; and excluding any subtitle. Optional and non-repeating; can
     * only be used if one of the &lt;NoPrefix/&gt; or &lt;TitlePrefix&gt; elements is also present.
     * </p>
     * Jonix-Comment: this field is required
     */
    public TitleWithoutPrefix titleWithoutPrefix() {
        _initialize();
        return titleWithoutPrefix;
    }

    private SequenceNumber sequenceNumber = SequenceNumber.EMPTY;

    /**
     * <p>
     * A number which specifies a single overall sequence of title elements, which is the preferred order for display of
     * the various title elements when constructing a complete title. Optional and non-repeating. It is strongly
     * recommended that each occurrence of the &lt;TitleElement&gt; composite should carry a &lt;SequenceNumber&gt;.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public SequenceNumber sequenceNumber() {
        _initialize();
        return sequenceNumber;
    }

    private YearOfAnnual yearOfAnnual = YearOfAnnual.EMPTY;

    /**
     * <p>
     * When the year of an annual is part of a title, this field should be used to carry the year (or, if required, a
     * spread of years such as 2009–2010). Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public YearOfAnnual yearOfAnnual() {
        _initialize();
        return yearOfAnnual;
    }

    private TitlePrefix titlePrefix = TitlePrefix.EMPTY;

    /**
     * <p>
     * Text at the beginning of a title element which is to be ignored for alphabetical sorting. Optional and
     * non-repeating; can only be used when &lt;TitleText&gt; is omitted, and if the &lt;TitleWithoutPrefix&gt; element
     * is also present. These two elements may be used in combination in applications where it is necessary to
     * distinguish an initial word or character string which is to be ignored for filing purposes, <i>eg</i> in library
     * systems and in some bookshop databases.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public TitlePrefix titlePrefix() {
        _initialize();
        return titlePrefix;
    }

    private NoPrefix noPrefix = NoPrefix.EMPTY;

    /**
     * <p>
     * An empty element that provides a positive indication that a title element does not include any prefix that is
     * ignored for sorting purposes. Optional and non-repeating, and must only be used when &lt;TitleWithoutPrefix&gt;
     * is used and no &lt;TitlePrefix&gt; element is present.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public NoPrefix noPrefix() {
        _initialize();
        return noPrefix;
    }

    public boolean isNoPrefix() {
        return (noPrefix().exists());
    }

    private TitleText titleText = TitleText.EMPTY;

    /**
     * <p>
     * The text of a title element, excluding any subtitle. Optional and non-repeating, may only be used where
     * &lt;TitlePrefix&gt;, &lt;NoPrefix/&gt; and &lt;TitleWithoutPrefix&gt; are not used.
     * </p>
     * <p>
     * This element is intended to be used only when the sending system cannot reliably provide prefixes that are
     * ignored for sorting purposes in a separate data element. If the system <em>can</em> reliably separate prefixes,
     * it should state whether a prefix is present (using &lt;TitlePrefix&gt; and &lt;TitleWithoutPrefix&gt;) or absent
     * (using &lt;NoPrefix/&gt; and &lt;TitleWithoutPrefix&gt;).
     * </p>
     * Jonix-Comment: this field is optional
     */
    public TitleText titleText() {
        _initialize();
        return titleText;
    }

    private Subtitle subtitle = Subtitle.EMPTY;

    /**
     * <p>
     * The text of a subtitle, if any. ‘Subtitle‘ means any added words which appear with the title element given in an
     * occurrence of the &lt;TitleElement&gt; composite, and which amplify and explain the title element, but which are
     * not considered to be part of the title element itself. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public Subtitle subtitle() {
        _initialize();
        return subtitle;
    }

    @Override
    public JonixTitleElement asStruct() {
        _initialize();
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
