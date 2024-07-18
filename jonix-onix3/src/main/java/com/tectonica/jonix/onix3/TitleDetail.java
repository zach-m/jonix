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

package com.tectonica.jonix.onix3;

import com.tectonica.jonix.common.JPU;
import com.tectonica.jonix.common.ListOfOnixDataComposite;
import com.tectonica.jonix.common.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixTitleElement;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Title detail composite (collection)</h1>
 * <p>
 * A group of data elements which together give the text of a collection title and specify its type. Optional, but the
 * composite is required unless the only collection title is carried in full, and word-for-word, as an integral part of
 * the product title in P.6, in which case it should not be repeated in&nbsp;P.5. The composite is repeatable with
 * different title types.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;TitleDetail&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;titledetail&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;TitleDetail&gt; from the schema author:
 *
 * Details of a title of a product (or a collection of products, or of a content item) &#9679; Added
 * &lt;TitleStatement&gt; at revision 3.0.1
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link DescriptiveDetail}&gt;</li>
 * <li>&lt;{@link ContentItem}&gt;</li>
 * <li>&lt;{@link Collection}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link TitleDetail}</li>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link TitleDetail}</li>
 * <li>{@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Collection} ⯈ {@link TitleDetail}</li>
 * </ul>
 */
public class TitleDetail implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "TitleDetail";
    public static final String shortname = "titledetail";

    /////////////////////////////////////////////////////////////////////////////////
    // ATTRIBUTES
    /////////////////////////////////////////////////////////////////////////////////

    /**
     * (type: dt.DateOrDateTime)
     */
    public String datestamp;

    /**
     * (type: dt.NonEmptyString)
     */
    public String sourcename;

    public RecordSourceTypes sourcetype;

    /////////////////////////////////////////////////////////////////////////////////
    // CONSTRUCTION
    /////////////////////////////////////////////////////////////////////////////////

    private boolean initialized;
    private final boolean exists;
    private final org.w3c.dom.Element element;
    public static final TitleDetail EMPTY = new TitleDetail();

    public TitleDetail() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public TitleDetail(org.w3c.dom.Element element) {
        exists = true;
        initialized = false;
        this.element = element;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcename = JPU.getAttribute(element, "sourcename");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
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
                case TitleType.refname:
                case TitleType.shortname:
                    titleType = new TitleType(e);
                    break;
                case TitleElement.refname:
                case TitleElement.shortname:
                    titleElements = JPU.addToList(titleElements, new TitleElement(e));
                    break;
                case TitleStatement.refname:
                case TitleStatement.shortname:
                    titleStatement = new TitleStatement(e);
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;TitleDetail&gt; or &lt;titledetail&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<TitleDetail> action) {
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

    private TitleType titleType = TitleType.EMPTY;

    /**
     * <p>
     * An ONIX code indicating the type of a title. Mandatory in each occurrence of the &lt;TitleDetail&gt; composite,
     * and non-repeating.
     * </p>
     * JONIX adds: this field is required
     */
    public TitleType titleType() {
        _initialize();
        return titleType;
    }

    private ListOfOnixDataComposite<TitleElement, JonixTitleElement> titleElements =
        JPU.emptyListOfOnixDataComposite(TitleElement.class);

    /**
     * <p>
     * A group of data elements which together represent an element of a collection title. At least one title element is
     * mandatory in each occurrence of the &lt;TitleDetail&gt; composite. The composite is repeatable with different
     * sequence numbers and/or title element levels. An instance of the &lt;TitleElement&gt; composite must include at
     * least one of: &lt;PartNumber&gt;; &lt;YearOfAnnual&gt;; &lt;TitleText&gt;, &lt;NoPrefix/&gt; together with
     * &lt;TitleWithoutPrefix&gt;, or &lt;TitlePrefix&gt; together with &lt;TitleWithoutPrefix&gt;. In other words, it
     * <em>must</em> carry <em>either</em> the text of a title element <em>or</em> a part or year designation, and it
     * <em>may</em> carry both.
     * </p>
     * <p>
     * A title element must be designated as belonging to <em>product level</em>, <em>collection level</em>, or
     * <em>subcollection level</em> (the first of these may not occur in a title element representing a
     * <em>collective</em> identity, and the last-named may only occur in the case of a multi-level collection).
     * </p>
     * <p>
     * In the simplest case, title detail sent in a &lt;Collection&gt; composite will consist of a single title element,
     * at collection level. However, the composite structure in ONIX&nbsp;3.0 allows more complex combinations of titles
     * and part designations in multi-level collections to be correctly represented.
     * </p>
     * JONIX adds: this list is required to contain at least one item
     */
    public ListOfOnixDataComposite<TitleElement, JonixTitleElement> titleElements() {
        _initialize();
        return titleElements;
    }

    private TitleStatement titleStatement = TitleStatement.EMPTY;

    /**
     * <p>
     * Free text showing how the collection title should be presented in any display, particularly when a standard
     * concatenation of individual title elements from Group&nbsp;P.5 (in the order specified by the
     * &lt;SequenceNumber&gt; data elements) would not give a satisfactory result. Optional and non-repeating. When this
     * field is sent, the recipient should use it to replace all collection title detail sent in Group&nbsp;P.5 for
     * display purposes only. The individual collection title element detail <em>must</em> also be sent, for indexing
     * and retrieval purposes.
     * </p>
     * JONIX adds: this field is optional
     */
    public TitleStatement titleStatement() {
        _initialize();
        return titleStatement;
    }
}
