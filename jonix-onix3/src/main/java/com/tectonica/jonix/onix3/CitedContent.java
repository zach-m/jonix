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
import com.tectonica.jonix.common.ListOfOnixCodelist;
import com.tectonica.jonix.common.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.common.ListOfOnixElement;
import com.tectonica.jonix.common.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.common.codelist.ContentAudiences;
import com.tectonica.jonix.common.codelist.ContentDateRoles;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixContentDate;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Cited content composite</h1>
 * <p>
 * An optional group of data elements which together describe a piece of cited content. The composite is repeatable to
 * describe and link to multiple items of cited material.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;CitedContent&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;citedcontent&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link ContentItem}&gt;</li>
 * <li>&lt;{@link CollateralDetail}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link CitedContent}</li>
 * <li>{@link Product} ⯈ {@link CollateralDetail} ⯈ {@link CitedContent}</li>
 * </ul>
 */
public class CitedContent implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "CitedContent";
    public static final String shortname = "citedcontent";

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
    public static final CitedContent EMPTY = new CitedContent();

    public CitedContent() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public CitedContent(org.w3c.dom.Element element) {
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
                case CitedContentType.refname:
                case CitedContentType.shortname:
                    citedContentType = new CitedContentType(e);
                    break;
                case ReviewRating.refname:
                case ReviewRating.shortname:
                    reviewRating = new ReviewRating(e);
                    break;
                case SourceTitle.refname:
                case SourceTitle.shortname:
                    sourceTitles = JPU.addToList(sourceTitles, new SourceTitle(e));
                    break;
                case SequenceNumber.refname:
                case SequenceNumber.shortname:
                    sequenceNumber = new SequenceNumber(e);
                    break;
                case Territory.refname:
                case Territory.shortname:
                    territory = new Territory(e);
                    break;
                case SourceType.refname:
                case SourceType.shortname:
                    sourceType = new SourceType(e);
                    break;
                case PositionOnList.refname:
                case PositionOnList.shortname:
                    positionOnList = new PositionOnList(e);
                    break;
                case ContentAudience.refname:
                case ContentAudience.shortname:
                    contentAudiences = JPU.addToList(contentAudiences, new ContentAudience(e));
                    break;
                case ListName.refname:
                case ListName.shortname:
                    listNames = JPU.addToList(listNames, new ListName(e));
                    break;
                case CitationNote.refname:
                case CitationNote.shortname:
                    citationNotes = JPU.addToList(citationNotes, new CitationNote(e));
                    break;
                case ResourceLink.refname:
                case ResourceLink.shortname:
                    resourceLinks = JPU.addToList(resourceLinks, new ResourceLink(e));
                    break;
                case ContentDate.refname:
                case ContentDate.shortname:
                    contentDates = JPU.addToList(contentDates, new ContentDate(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;CitedContent&gt; or &lt;citedcontent&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<CitedContent> action) {
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

    private CitedContentType citedContentType = CitedContentType.EMPTY;

    /**
     * <p>
     * An ONIX code indicating the type of content which is being cited. Mandatory in each occurrence of the
     * &lt;CitedContent&gt; composite, and non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public CitedContentType citedContentType() {
        _initialize();
        return citedContentType;
    }

    private ReviewRating reviewRating = ReviewRating.EMPTY;

    /**
     * <p>
     * An optional group of data elements which together specify a ‘star rating’ awarded as part of a review of the
     * publication, used where &lt;CitedContentType&gt; indicates the cited content is a review. Not repeatable.
     * </p>
     * Jonix-Comment: this field is required
     */
    public ReviewRating reviewRating() {
        _initialize();
        return reviewRating;
    }

    private ListOfOnixElement<SourceTitle, String> sourceTitles = ListOfOnixElement.empty();

    /**
     * <p>
     * The title, name or short description of a publication, broadcast, website or other source of cited content.
     * Optional, and repeatable; required unless the cited content refers to a bestseller list, and &lt;ListName&gt; is
     * present. &lt;SourceTitle&gt; may be repeated to provide the title in multiple languages. The <i>language</i>
     * attribute is optional for a single instance of &lt;SourceTitle&gt;, but must be included in each instance if
     * &lt;SourceTitle&gt; is repeated.
     * </p>
     * Jonix-Comment: this list is required to contain at least one item
     */
    public ListOfOnixElement<SourceTitle, String> sourceTitles() {
        _initialize();
        return sourceTitles;
    }

    private SequenceNumber sequenceNumber = SequenceNumber.EMPTY;

    /**
     * <p>
     * A number which specifies a single overall sequence of cited content. Optional and non-repeating. It is strongly
     * recommended that if <em>any</em> occurrence of the &lt;CitedContent&gt; composite of a specific
     * &lt;CitedContentType&gt; carries a &lt;SequenceNumber&gt;, then all of that type should carry a
     * &lt;SequenceNumber&gt; – though there is no requirement to number cited content where there is a single instance
     * of that type.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public SequenceNumber sequenceNumber() {
        _initialize();
        return sequenceNumber;
    }

    private Territory territory = Territory.EMPTY;

    /**
     * <p>
     * A group of data elements which together define a territory for which the cited content is specifically intended.
     * Optional in each occurrence of the &lt;CitedContent&gt; composite, and non-repeating. If omitted, the content is
     * intended to be cited (linked to) wherever the product may be sold (see Territorial sales rights in
     * <a href="#onixmessage_product_publishingdetail_p21">Group&nbsp;P.21</a>). If included, the content should be
     * cited by recipients in the specified territory only, and in preference to any cited content that lacks a
     * specified territory.
     * </p>
     * <p>
     * For valid combinations of &lt;CountriesIncluded&gt;, &lt;RegionsIncluded&gt; <i>etc</i> within &lt;Territory&gt;,
     * see the notes describing the use of &lt;Territory&gt; within Group&nbsp;P.21.
     * </p>
     * <p>
     * Care should be taken to avoid ambiguities (for example two different citations of the same type marked for use in
     * the same country or region), and to ensure that appropriate citations are supplied for all countries and regions
     * where the product may be sold. The simplest way to accomplish the latter is to ensure at least one version of the
     * citation does not have a territory specified. Where multiple citations of the same type are provided, those
     * without specific &lt;Territory&gt; composites are intended for use only where no appropriate targeted citation is
     * present.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public Territory territory() {
        _initialize();
        return territory;
    }

    private SourceType sourceType = SourceType.EMPTY;

    /**
     * <p>
     * An ONIX code indicating the type of source from which the cited material originated, <i>eg</i> radio, TV.
     * Optional, and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public SourceType sourceType() {
        _initialize();
        return sourceType;
    }

    private PositionOnList positionOnList = PositionOnList.EMPTY;

    /**
     * <p>
     * The position that a product has reached on a bestseller list specified in &lt;ListName&gt;. Optional and
     * non-repeating. The &lt;ListName&gt; element must also be present if &lt;PositionOnList&gt; is included.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public PositionOnList positionOnList() {
        _initialize();
        return positionOnList;
    }

    private ListOfOnixCodelist<ContentAudience, ContentAudiences> contentAudiences = ListOfOnixCodelist.emptyList();

    /**
     * <p>
     * An ONIX code which identifies the audience for which a piece of cited content is intended. Optional and
     * repeatable.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixCodelist<ContentAudience, ContentAudiences> contentAudiences() {
        _initialize();
        return contentAudiences;
    }

    private ListOfOnixElement<ListName, String> listNames = ListOfOnixElement.empty();

    /**
     * <p>
     * The name of a bestseller list, when the &lt;CitedContent&gt; composite is used to refer to a position which a
     * product has reached on such a list. Optional, and repeatable to provide a parallel list name in multiple
     * languages. The <i>language</i> attribute is optional for a single instance of &lt;ListName&gt;, but must be
     * included in each instance if &lt;ListName&gt; is repeated.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<ListName, String> listNames() {
        _initialize();
        return listNames;
    }

    private ListOfOnixElement<CitationNote, String> citationNotes = ListOfOnixElement.empty();

    /**
     * <p>
     * A free text note giving any additional information about cited content, for example a detailed volume, issue and
     * page reference to content cited from a periodical. Optional, and repeatable when parallel text is provided in
     * multiple languages. The <i>language</i> attribute is optional for a single instance of &lt;CitationNote&gt;, but
     * must be included in each instance if &lt;CitationNote&gt; is repeated.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<CitationNote, String> citationNotes() {
        _initialize();
        return citationNotes;
    }

    private ListOfOnixElement<ResourceLink, String> resourceLinks = ListOfOnixElement.empty();

    /**
     * <p>
     * A URL which provides a link to cited content which is accessible in digital form. Optional, and repeatable if the
     * resource can be linked in more than one way, <i>eg</i> by URL or DOI, or where a cited resource is available in
     * multiple parallel languages. Where multiple languages are used, all repeats must carry the <i>language</i>
     * attribute.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<ResourceLink, String> resourceLinks() {
        _initialize();
        return resourceLinks;
    }

    private ListOfOnixDataCompositeWithKey<ContentDate, JonixContentDate, ContentDateRoles> contentDates =
        JPU.emptyListOfOnixDataCompositeWithKey(ContentDate.class);

    /**
     * <p>
     * An optional and repeatable group of data elements which together specify a date associated with cited content,
     * <i>eg</i> date on which it was published or broadcast.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<ContentDate, JonixContentDate, ContentDateRoles> contentDates() {
        _initialize();
        return contentDates;
    }
}
