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
import com.tectonica.jonix.common.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.common.ListOfOnixElement;
import com.tectonica.jonix.common.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.common.codelist.ContentAudiences;
import com.tectonica.jonix.common.codelist.ContentDateRoles;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixContentDate;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Text content composite</h1>
 * <p>
 * An optional group of data elements which together carry text related to the product, repeatable in order to deliver
 * multiple texts (often of different types, though for some text types there many be multiple instances of that type).
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;TextContent&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;textcontent&gt;</tt></td>
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
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link TextContent}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link CollateralDetail} ⯈ {@link TextContent}</li>
 * </ul>
 */
public class TextContent implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "TextContent";
    public static final String shortname = "textcontent";

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
    public static final TextContent EMPTY = new TextContent();

    public TextContent() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public TextContent(org.w3c.dom.Element element) {
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
                case TextType.refname:
                case TextType.shortname:
                    textType = new TextType(e);
                    break;
                case ContentAudience.refname:
                case ContentAudience.shortname:
                    contentAudiences = JPU.addToList(contentAudiences, new ContentAudience(e));
                    break;
                case Text.refname:
                case Text.shortname:
                    texts = JPU.addToList(texts, new Text(e));
                    break;
                case Territory.refname:
                case Territory.shortname:
                    territory = new Territory(e);
                    break;
                case ReviewRating.refname:
                case ReviewRating.shortname:
                    reviewRating = new ReviewRating(e);
                    break;
                case TextSourceCorporate.refname:
                case TextSourceCorporate.shortname:
                    textSourceCorporate = new TextSourceCorporate(e);
                    break;
                case TextAuthor.refname:
                case TextAuthor.shortname:
                    textAuthors = JPU.addToList(textAuthors, new TextAuthor(e));
                    break;
                case TextSourceDescription.refname:
                case TextSourceDescription.shortname:
                    textSourceDescriptions = JPU.addToList(textSourceDescriptions, new TextSourceDescription(e));
                    break;
                case SourceTitle.refname:
                case SourceTitle.shortname:
                    sourceTitles = JPU.addToList(sourceTitles, new SourceTitle(e));
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
     * @return whether this tag (&lt;TextContent&gt; or &lt;textcontent&gt;) is explicitly provided in the ONIX XML
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

    private TextType textType = TextType.EMPTY;

    /**
     * <p>
     * An ONIX code which identifies the type of text which is sent in the &lt;Text&gt; element. Mandatory in each
     * occurrence of the &lt;TextContent&gt; composite, and non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public TextType textType() {
        _initialize();
        return textType;
    }

    private ListOfOnixElement<ContentAudience, ContentAudiences> contentAudiences = ListOfOnixElement.empty();

    /**
     * <p>
     * An ONIX code which identifies the audience for which the text in the &lt;Text&gt; element is intended. Mandatory
     * in each occurrence of the &lt;TextContent&gt; composite, and repeatable.
     * </p>
     * Jonix-Comment: this list is required to contain at least one item
     */
    public ListOfOnixElement<ContentAudience, ContentAudiences> contentAudiences() {
        _initialize();
        return contentAudiences;
    }

    private ListOfOnixElement<Text, String> texts = ListOfOnixElement.empty();

    /**
     * <p>
     * The text specified in the &lt;TextType&gt; element. Mandatory in each occurrence of the &lt;TextContent&gt;
     * composite, and repeatable when essentially identical text is supplied in multiple languages. The <i>language</i>
     * attribute is optional for a single instance of &lt;Text&gt;, but must be included in each instance if
     * &lt;Text&gt; is repeated.
     * </p>
     * Jonix-Comment: this list is required to contain at least one item
     */
    public ListOfOnixElement<Text, String> texts() {
        _initialize();
        return texts;
    }

    private Territory territory = Territory.EMPTY;

    /**
     * <p>
     * A group of data elements which together define a territory for which the text in the &lt;Text&gt; element is
     * specifically intended. Optional in each occurrence of the &lt;TextContent&gt; composite, and non-repeating. If
     * omitted, the text is intended for use wherever the product may be sold (see
     * <a href="#onixmessage_product_publishingdetail_p21">Group&nbsp;P.21</a>). If included, the text should be used by
     * recipients in the specified territory in preference to any text that lacks a specified territory.
     * </p>
     * <p>
     * Care should be taken to avoid ambiguities (for example two different ‘short descriptions’ – without
     * <i>language</i> attributes or with the same <i>language</i> attribute – marked for use in the same country or
     * region), and to ensure that appropriate descriptions and supporting text are supplied for all countries and
     * regions where the product may be sold. The simplest way to accomplish the latter is to ensure at least one
     * version of the text does not have a territory specified. Where multiple texts of the same type are provided,
     * those without specific &lt;Territory&gt; composites are intended for use only where no appropriate targeted text
     * is present.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public Territory territory() {
        _initialize();
        return territory;
    }

    private ReviewRating reviewRating = ReviewRating.EMPTY;

    /**
     * <p>
     * An optional group of data elements which together specify a ‘star rating’ awarded as part of a review of the
     * publication, used when &lt;TextType&gt; indicates the text is a review. Not repeatable.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public ReviewRating reviewRating() {
        _initialize();
        return reviewRating;
    }

    private TextSourceCorporate textSourceCorporate = TextSourceCorporate.EMPTY;

    /**
     * <p>
     * The name of a company or corporate body responsible for the text sent in the &lt;Text&gt; element. Optional and
     * non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public TextSourceCorporate textSourceCorporate() {
        _initialize();
        return textSourceCorporate;
    }

    private ListOfOnixElement<TextAuthor, String> textAuthors = ListOfOnixElement.empty();

    /**
     * <p>
     * The name of an author of text sent in the &lt;Text&gt; element, <i>eg</i> if it is a review or promotional quote.
     * Optional, and repeatable if the text is jointly authored.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<TextAuthor, String> textAuthors() {
        _initialize();
        return textAuthors;
    }

    private ListOfOnixElement<TextSourceDescription, String> textSourceDescriptions = ListOfOnixElement.empty();

    /**
     * <p>
     * Brief text describing or providing context for the text author or corporate source, at the publisher’s
     * discretion, and intended to be used in addition to &lt;TextAuthor&gt; or &lt;TextSourceCorporate&gt;. Optional,
     * and repeatable to provide parallel descriptions in multiple languages. The <i>language</i> attribute is optional
     * for a single instance of &lt;TextSourceDescription&gt;, but must be included in each instance if
     * &lt;TextSourceDescription&gt; is repeated. The description may be used with either a person or corporate name, to
     * draw attention to any aspect of the text source’s background which provides context for the text in &lt;Text&gt;.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<TextSourceDescription, String> textSourceDescriptions() {
        _initialize();
        return textSourceDescriptions;
    }

    private ListOfOnixElement<SourceTitle, String> sourceTitles = ListOfOnixElement.empty();

    /**
     * <p>
     * The title of a publication from which the text sent in the &lt;Text&gt; element was taken, <i>eg</i> if it is a
     * review quote. Optional, and repeatable to provide the title in multiple languages. The <i>language</i> attribute
     * is optional for a single instance of &lt;SourceTitle&gt;, but must be included in each instance if
     * &lt;SourceTitle&gt; is repeated.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<SourceTitle, String> sourceTitles() {
        _initialize();
        return sourceTitles;
    }

    private ListOfOnixDataCompositeWithKey<ContentDate, JonixContentDate, ContentDateRoles> contentDates =
        ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * <p>
     * An optional group of data elements which together specify a date associated with the text carried in an
     * occurrence of the &lt;TextContent&gt; composite, <i>eg</i> date when quoted text was published. Repeatable to
     * specify different dates with their various roles.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<ContentDate, JonixContentDate, ContentDateRoles> contentDates() {
        _initialize();
        return contentDates;
    }
}
