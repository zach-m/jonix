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

import com.tectonica.jonix.common.JPU;
import com.tectonica.jonix.common.ListOfOnixDataComposite;
import com.tectonica.jonix.common.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.common.ListOfOnixElement;
import com.tectonica.jonix.common.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.common.codelist.LanguageRoles;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixLanguage;
import com.tectonica.jonix.common.struct.JonixSubject;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Content item composite</h1>
 * <p>
 * A group of data elements which together describe a content item within a product. Optional in any occurrence of the
 * &lt;ContentDetail&gt; composite, but it may be omitted only within a partial or ‘block update’ (Notification or
 * update type 04, see P.1.2) when the intention is to remove all previously supplied content detail. When used
 * normally, it is repeatable for each content item within the product.
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
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link ContentDetail}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem}</li>
 * </ul>
 */
public class ContentItem implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "ContentItem";
    public static final String shortname = "contentitem";

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
                case LevelSequenceNumber.refname:
                case LevelSequenceNumber.shortname:
                    levelSequenceNumber = new LevelSequenceNumber(e);
                    break;
                case TextItem.refname:
                case TextItem.shortname:
                    textItem = new TextItem(e);
                    break;
                case AVItem.refname:
                case AVItem.shortname:
                    avItem = new AVItem(e);
                    break;
                case ComponentTypeName.refname:
                case ComponentTypeName.shortname:
                    componentTypeName = new ComponentTypeName(e);
                    break;
                case ComponentNumber.refname:
                case ComponentNumber.shortname:
                    componentNumber = new ComponentNumber(e);
                    break;
                case TitleDetail.refname:
                case TitleDetail.shortname:
                    titleDetails = JPU.addToList(titleDetails, new TitleDetail(e));
                    break;
                case Contributor.refname:
                case Contributor.shortname:
                    contributors = JPU.addToList(contributors, new Contributor(e));
                    break;
                case ContributorStatement.refname:
                case ContributorStatement.shortname:
                    contributorStatements = JPU.addToList(contributorStatements, new ContributorStatement(e));
                    break;
                case NoContributor.refname:
                case NoContributor.shortname:
                    noContributor = new NoContributor(e);
                    break;
                case Language.refname:
                case Language.shortname:
                    languages = JPU.addToList(languages, new Language(e));
                    break;
                case Subject.refname:
                case Subject.shortname:
                    subjects = JPU.addToList(subjects, new Subject(e));
                    break;
                case NameAsSubject.refname:
                case NameAsSubject.shortname:
                    nameAsSubjects = JPU.addToList(nameAsSubjects, new NameAsSubject(e));
                    break;
                case TextContent.refname:
                case TextContent.shortname:
                    textContents = JPU.addToList(textContents, new TextContent(e));
                    break;
                case CitedContent.refname:
                case CitedContent.shortname:
                    citedContents = JPU.addToList(citedContents, new CitedContent(e));
                    break;
                case SupportingResource.refname:
                case SupportingResource.shortname:
                    supportingResources = JPU.addToList(supportingResources, new SupportingResource(e));
                    break;
                case RelatedWork.refname:
                case RelatedWork.shortname:
                    relatedWorks = JPU.addToList(relatedWorks, new RelatedWork(e));
                    break;
                case RelatedProduct.refname:
                case RelatedProduct.shortname:
                    relatedProducts = JPU.addToList(relatedProducts, new RelatedProduct(e));
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

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private LevelSequenceNumber levelSequenceNumber = LevelSequenceNumber.EMPTY;

    /**
     * <p>
     * A number which specifies the position of a content item in a multi-level hierarchy of such items. Numbering
     * starts at the top level in the hierarchy, which may represent (<i>eg</i>) chapters in a printed book, and the
     * first item at the top level is numbered 1. Numbers should be assigned solely with a view to the logic of the ONIX
     * description and not in relation to any other characteristics of the items being numbered (such as their actual
     * numbering or their typographical layout in a printed table of contents). So for example, Chapter&nbsp;2 could
     * have a level sequence number of&nbsp;3, and the second sub-section within Chapter&nbsp;2 could be
     * numbered&nbsp;3.2. &lt;LevelSequenceNumber&gt; is <em>not</em> a required field, but it is strongly recommended
     * for structured tables of contents. If used, it must occur once and only once in each occurrence of the
     * &lt;ContentItem&gt; composite.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public LevelSequenceNumber levelSequenceNumber() {
        _initialize();
        return levelSequenceNumber;
    }

    private TextItem textItem = TextItem.EMPTY;

    /**
     * <p>
     * A group of data elements which are specific to text content. Optional, but exactly one of either the
     * &lt;TextItem&gt; composite or the similar &lt;AVItem&gt; composite must occur in a &lt;ContentItem&gt; composite
     * which describes a particular content item. (Similar composites may be defined for other media, and the occurrence
     * of one of them will be mandatory in any &lt;ContentItem&gt; composite.)
     * </p>
     * Jonix-Comment: this field is optional
     */
    public TextItem textItem() {
        _initialize();
        return textItem;
    }

    private AVItem avItem = AVItem.EMPTY;

    /**
     * <p>
     * An optional group of data elements which are specific to audio or audiovisual (<i>ie</i> time-based) content.
     * Exactly one of either the &lt;AVItem&gt; composite or the similar &lt;TextItem&gt; composite must occur in a
     * &lt;ContentItem&gt; composite which describes a content item.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public AVItem avItem() {
        _initialize();
        return avItem;
    }

    private ComponentTypeName componentTypeName = ComponentTypeName.EMPTY;

    /**
     * <p>
     * The generic name (if any) which is given in the product to the type of section which the content item represents,
     * <i>eg</i> Chapter, Part, Track. Optional and non-repeating; but either this field or a title (in the
     * &lt;TitleDetail&gt; composite), or both, must be present in each occurrence of the &lt;ContentItem&gt;.
     * </p>
     * Jonix-Comment: this field is required
     */
    public ComponentTypeName componentTypeName() {
        _initialize();
        return componentTypeName;
    }

    private ComponentNumber componentNumber = ComponentNumber.EMPTY;

    /**
     * <p>
     * The number (if any) which is given to the content item in the product, in the form (<i>eg</i> Arabic or Roman) in
     * which it is given in the product. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public ComponentNumber componentNumber() {
        _initialize();
        return componentNumber;
    }

    private List<TitleDetail> titleDetails = Collections.emptyList();

    /**
     * <p>
     * A repeatable group of data elements which together give the text of a title of a content item and specify its
     * type. Optional.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public List<TitleDetail> titleDetails() {
        _initialize();
        return titleDetails;
    }

    private List<Contributor> contributors = Collections.emptyList();

    /**
     * <p>
     * A group of data elements which together describe a personal or corporate contributor to a content item. Optional
     * and repeatable.
     * </p>
     * Jonix-Comment: this list is required to contain at least one item
     */
    public List<Contributor> contributors() {
        _initialize();
        return contributors;
    }

    private ListOfOnixElement<ContributorStatement, String> contributorStatements = ListOfOnixElement.empty();

    /**
     * <p>
     * Free text showing how the authorship of a content item should be described in an online display, when a standard
     * concatenation of individual contributor elements would not give a satisfactory presentation. Optional, and
     * repeatable if parallel text is provided in multiple languages. The language attribute is optional for a single
     * instance of &lt;ContributorStatement&gt;, but must be included in each instance if &lt;ContributorStatement&gt;
     * is repeated. When the &lt;ContributorStatement&gt; field is sent, the receiver should use it to replace all name
     * detail (though not the biographical, date or place details) sent in the &lt;Contributor&gt; composite for display
     * purposes only. The individual name detail must also be sent in the &lt;Contributor&gt; composite for indexing and
     * retrieval.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<ContributorStatement, String> contributorStatements() {
        _initialize();
        return contributorStatements;
    }

    private NoContributor noContributor = NoContributor.EMPTY;

    /**
     * <p>
     * An empty element that provides a positive indication that a content item has no stated authorship. Optional and
     * non-repeating. Must only be sent in a &lt;ContentItem&gt; composite that has no &lt;Contributor&gt; elements.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public NoContributor noContributor() {
        _initialize();
        return noContributor;
    }

    public boolean isNoContributor() {
        return (noContributor().exists());
    }

    private ListOfOnixDataCompositeWithKey<Language, JonixLanguage, LanguageRoles> languages =
        ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * <p>
     * An optional and repeatable group of data elements which together represent a language, and specify its role and,
     * where required, whether it is a country variant.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<Language, JonixLanguage, LanguageRoles> languages() {
        _initialize();
        return languages;
    }

    private ListOfOnixDataComposite<Subject, JonixSubject> subjects = ListOfOnixDataComposite.empty();

    /**
     * <p>
     * A group of data elements which together specify a subject classification or a subject heading relating to a
     * content item. Optional and repeatable.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataComposite<Subject, JonixSubject> subjects() {
        _initialize();
        return subjects;
    }

    private List<NameAsSubject> nameAsSubjects = Collections.emptyList();

    /**
     * <p>
     * An optional and repeatable group of data elements which together represent the name of a person or organization –
     * real or fictional – that is part of the subject of a content item.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public List<NameAsSubject> nameAsSubjects() {
        _initialize();
        return nameAsSubjects;
    }

    private List<TextContent> textContents = Collections.emptyList();

    /**
     * <p>
     * A group of data elements which together carry text related to a content item. Optional and repeatable.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public List<TextContent> textContents() {
        _initialize();
        return textContents;
    }

    private List<CitedContent> citedContents = Collections.emptyList();

    /**
     * <p>
     * A group of data elements which together describe a piece of cited content. Optional and repeatable.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public List<CitedContent> citedContents() {
        _initialize();
        return citedContents;
    }

    private List<SupportingResource> supportingResources = Collections.emptyList();

    /**
     * <p>
     * A group of data elements which together describe a supporting resource. Optional and repeatable.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public List<SupportingResource> supportingResources() {
        _initialize();
        return supportingResources;
    }

    private List<RelatedWork> relatedWorks = Collections.emptyList();

    /**
     * <p>
     * A group of data elements which together describe a work which has a specified relationship to a content item.
     * Optional and repeatable.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public List<RelatedWork> relatedWorks() {
        _initialize();
        return relatedWorks;
    }

    private List<RelatedProduct> relatedProducts = Collections.emptyList();

    /**
     * <p>
     * A group of data elements which together describe a product which has a specified relationship to a content item.
     * Optional and repeatable.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public List<RelatedProduct> relatedProducts() {
        _initialize();
        return relatedProducts;
    }
}
