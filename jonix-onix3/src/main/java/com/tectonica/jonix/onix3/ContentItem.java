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

package com.tectonica.jonix.onix3;

import com.tectonica.jonix.common.JPU;
import com.tectonica.jonix.common.ListOfOnixComposite;
import com.tectonica.jonix.common.ListOfOnixDataComposite;
import com.tectonica.jonix.common.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.common.ListOfOnixElement;
import com.tectonica.jonix.common.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.common.codelist.LanguageRoles;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixLanguage;
import com.tectonica.jonix.common.struct.JonixSubject;

import java.io.Serializable;
import java.util.function.Consumer;

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
 * Technical notes about &lt;ContentItem&gt; from the schema author:
 *
 * Details of a textual content item (eg a chapter) &#9679; Added &lt;CopyrightStatementText&gt; at revision 3.1.1
 * &#9679; Added &lt;EpubUsageConstraint&gt;, extended &lt;EpubLicense&gt;, &lt;Publisher&gt; and
 * &lt;CopyrightStatement&gt; at release 3.1 &#9679; Added &lt;AVItem&gt; at revision 3.0.5 &#9679; Added
 * &lt;ContributorStatement&gt;, &lt;NoContributor&gt; (in gp.authorship), &lt;Language&gt; at revision 3.0.4 &#9679;
 * Added &lt;RelatedProduct&gt; at revision 3.0.3 &#9679; Modified cardinality of &lt;ContributorStatement&gt; at
 * revision 3.0.1
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link ContentDetail}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem}</li>
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
                case ComponentTypeName.refname:
                case ComponentTypeName.shortname:
                    componentTypeName = new ComponentTypeName(e);
                    break;
                case Contributor.refname:
                case Contributor.shortname:
                    contributors = JPU.addToList(contributors, new Contributor(e));
                    break;
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
                case ComponentNumber.refname:
                case ComponentNumber.shortname:
                    componentNumber = new ComponentNumber(e);
                    break;
                case NoContributor.refname:
                case NoContributor.shortname:
                    noContributor = new NoContributor(e);
                    break;
                case EpubUsageConstraint.refname:
                case EpubUsageConstraint.shortname:
                    epubUsageConstraints = JPU.addToList(epubUsageConstraints, new EpubUsageConstraint(e));
                    break;
                case EpubLicenseWithDateType.refname:
                case EpubLicenseWithDateType.shortname:
                    epubLicenses = JPU.addToList(epubLicenses, new EpubLicenseWithDateType(e));
                    break;
                case TitleDetail.refname:
                case TitleDetail.shortname:
                    titleDetails = JPU.addToList(titleDetails, new TitleDetail(e));
                    break;
                case ContributorStatement.refname:
                case ContributorStatement.shortname:
                    contributorStatements = JPU.addToList(contributorStatements, new ContributorStatement(e));
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
                case Publisher.refname:
                case Publisher.shortname:
                    publishers = JPU.addToList(publishers, new Publisher(e));
                    break;
                case CopyrightStatement.refname:
                case CopyrightStatement.shortname:
                    copyrightStatements = JPU.addToList(copyrightStatements, new CopyrightStatement(e));
                    break;
                case CopyrightStatementText.refname:
                case CopyrightStatementText.shortname:
                    copyrightStatementTexts = JPU.addToList(copyrightStatementTexts, new CopyrightStatementText(e));
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

    public void ifExists(Consumer<ContentItem> action) {
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

    private ComponentTypeName componentTypeName = ComponentTypeName.EMPTY;

    /**
     * <p>
     * The generic name (if any) which is given in the product to the type of section which the content item represents,
     * <i>eg</i>&nbsp;Chapter, Part, Track. Optional and non-repeating; but either this field or a title (in the
     * &lt;TitleDetail&gt; composite), or both, must be present in each occurrence of the &lt;ContentItem&gt;.
     * </p>
     * JONIX adds: this field is required
     */
    public ComponentTypeName componentTypeName() {
        _initialize();
        return componentTypeName;
    }

    private ListOfOnixComposite<Contributor> contributors = JPU.emptyListOfOnixComposite(Contributor.class);

    /**
     * <p>
     * A group of data elements which together describe a personal or corporate contributor to a content item. Optional
     * and repeatable.
     * </p>
     * JONIX adds: this list is required to contain at least one item
     */
    public ListOfOnixComposite<Contributor> contributors() {
        _initialize();
        return contributors;
    }

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
     * JONIX adds: this field is optional
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
     * JONIX adds: this field is optional
     */
    public TextItem textItem() {
        _initialize();
        return textItem;
    }

    private AVItem avItem = AVItem.EMPTY;

    /**
     * <p>
     * An optional group of data elements which are specific to audio or audiovisual (<i>ie</i>&nbsp;time-based)
     * content. Exactly one of either the &lt;AVItem&gt; composite or the similar &lt;TextItem&gt; composite must occur
     * in a &lt;ContentItem&gt; composite which describes a content item.
     * </p>
     * JONIX adds: this field is optional
     */
    public AVItem avItem() {
        _initialize();
        return avItem;
    }

    private ComponentNumber componentNumber = ComponentNumber.EMPTY;

    /**
     * <p>
     * The number (if any) which is given to the content item in the product, in the form (<i>eg</i>&nbsp;Arabic or
     * Roman) in which it is given in the product. Optional and non-repeating.
     * </p>
     * JONIX adds: this field is optional
     */
    public ComponentNumber componentNumber() {
        _initialize();
        return componentNumber;
    }

    private NoContributor noContributor = NoContributor.EMPTY;

    /**
     * <p>
     * An empty element that provides a positive indication that a content item has no stated authorship. Optional and
     * non-repeating. Must only be sent in a &lt;ContentItem&gt; composite that has no &lt;Contributor&gt; elements.
     * </p>
     * JONIX adds: this field is optional
     */
    public NoContributor noContributor() {
        _initialize();
        return noContributor;
    }

    public boolean isNoContributor() {
        return (noContributor().exists());
    }

    private ListOfOnixComposite<EpubUsageConstraint> epubUsageConstraints =
        JPU.emptyListOfOnixComposite(EpubUsageConstraint.class);

    /**
     * <p>
     * An optional group of data elements which together describe a usage constraint on a content item within a digital
     * product (or the absence of such a constraint), whether enforced by DRM technical protection, inherent in the
     * platform used, or specified by license agreement. Repeatable in order to describe multiple constraints on usage.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixComposite<EpubUsageConstraint> epubUsageConstraints() {
        _initialize();
        return epubUsageConstraints;
    }

    private ListOfOnixComposite<EpubLicenseWithDateType> epubLicenses =
        JPU.emptyListOfOnixComposite(EpubLicenseWithDateType.class);

    /**
     * JONIX adds: this list may be empty
     */
    public ListOfOnixComposite<EpubLicenseWithDateType> epubLicenses() {
        _initialize();
        return epubLicenses;
    }

    private ListOfOnixComposite<TitleDetail> titleDetails = JPU.emptyListOfOnixComposite(TitleDetail.class);

    /**
     * <p>
     * A repeatable group of data elements which together give the text of a title of a content item and specify its
     * type. Optional.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixComposite<TitleDetail> titleDetails() {
        _initialize();
        return titleDetails;
    }

    private ListOfOnixElement<ContributorStatement, String> contributorStatements = ListOfOnixElement.empty();

    /**
     * <p>
     * Free text showing how the authorship of a content item should be described in an online display, when a standard
     * concatenation of individual contributor elements would not give a satisfactory presentation. Optional, and
     * repeatable if parallel text is provided in multiple languages. The <i>language</i> attribute is optional for a
     * single instance of &lt;ContributorStatement&gt;, but must be included in each instance if
     * &lt;ContributorStatement&gt; is repeated. When the &lt;ContributorStatement&gt; field is sent, the receiver
     * should use it to replace all name detail (though not the biographical, date or place details) sent in the
     * &lt;Contributor&gt; composite for display purposes only. The individual name detail must also be sent in the
     * &lt;Contributor&gt; composite for indexing and retrieval.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixElement<ContributorStatement, String> contributorStatements() {
        _initialize();
        return contributorStatements;
    }

    private ListOfOnixDataCompositeWithKey<Language, JonixLanguage, LanguageRoles> languages =
        JPU.emptyListOfOnixDataCompositeWithKey(Language.class);

    /**
     * <p>
     * An optional and repeatable group of data elements which together represent a language, and specify its role and,
     * where required, whether it is a country variant.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<Language, JonixLanguage, LanguageRoles> languages() {
        _initialize();
        return languages;
    }

    private ListOfOnixDataComposite<Subject, JonixSubject> subjects = JPU.emptyListOfOnixDataComposite(Subject.class);

    /**
     * <p>
     * A group of data elements which together specify a subject classification or a subject heading relating to a
     * content item. Optional and repeatable.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixDataComposite<Subject, JonixSubject> subjects() {
        _initialize();
        return subjects;
    }

    private ListOfOnixComposite<NameAsSubject> nameAsSubjects = JPU.emptyListOfOnixComposite(NameAsSubject.class);

    /**
     * <p>
     * An optional and repeatable group of data elements which together represent the name of a person or
     * organization&nbsp;– real or fictional&nbsp;– that is part of the subject of a content item.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixComposite<NameAsSubject> nameAsSubjects() {
        _initialize();
        return nameAsSubjects;
    }

    private ListOfOnixComposite<TextContent> textContents = JPU.emptyListOfOnixComposite(TextContent.class);

    /**
     * <p>
     * A group of data elements which together carry text related to a content item. Optional and repeatable.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixComposite<TextContent> textContents() {
        _initialize();
        return textContents;
    }

    private ListOfOnixComposite<CitedContent> citedContents = JPU.emptyListOfOnixComposite(CitedContent.class);

    /**
     * <p>
     * A group of data elements which together describe a piece of cited content. Optional and repeatable.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixComposite<CitedContent> citedContents() {
        _initialize();
        return citedContents;
    }

    private ListOfOnixComposite<SupportingResource> supportingResources =
        JPU.emptyListOfOnixComposite(SupportingResource.class);

    /**
     * <p>
     * A group of data elements which together describe a supporting resource. Optional and repeatable.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixComposite<SupportingResource> supportingResources() {
        _initialize();
        return supportingResources;
    }

    private ListOfOnixComposite<Publisher> publishers = JPU.emptyListOfOnixComposite(Publisher.class);

    /**
     * <p>
     * A group of data elements which together identify an entity which is associated with the publishing of a content
     * item, included here to allow roles such as Funder, Sponsor to be associated with a specific content item rather
     * than the product as a whole. The composite allows additional publishing roles to be introduced without adding new
     * fields. Each occurrence of the composite must carry a publishing role code and either a name identifier or a name
     * or both. Optional, and repeatable in order to identify multiple entities.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixComposite<Publisher> publishers() {
        _initialize();
        return publishers;
    }

    private ListOfOnixComposite<CopyrightStatement> copyrightStatements =
        JPU.emptyListOfOnixComposite(CopyrightStatement.class);

    /**
     * <p>
     * An optional and repeatable group of data elements which together represent a copyright or neighboring right
     * statement for the content item. At least one &lt;CopyrightYear&gt; or one instance of the &lt;CopyrightOwner&gt;
     * composite must be sent within an instance of the composite, but it is recommended that all elements in the
     * composite are explicitly populated. The Copyright statement may be repeated to provide a full structured rights
     * statement listing year(s) and rights holder(s).
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixComposite<CopyrightStatement> copyrightStatements() {
        _initialize();
        return copyrightStatements;
    }

    private ListOfOnixElement<CopyrightStatementText, String> copyrightStatementTexts = ListOfOnixElement.empty();

    /**
     * JONIX adds: this list may be empty
     */
    public ListOfOnixElement<CopyrightStatementText, String> copyrightStatementTexts() {
        _initialize();
        return copyrightStatementTexts;
    }

    private ListOfOnixComposite<RelatedWork> relatedWorks = JPU.emptyListOfOnixComposite(RelatedWork.class);

    /**
     * <p>
     * A group of data elements which together describe a work which has a specified relationship to a content item.
     * Optional and repeatable.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixComposite<RelatedWork> relatedWorks() {
        _initialize();
        return relatedWorks;
    }

    private ListOfOnixComposite<RelatedProduct> relatedProducts = JPU.emptyListOfOnixComposite(RelatedProduct.class);

    /**
     * <p>
     * A group of data elements which together describe a product which has a specified relationship to a content item.
     * Optional and repeatable.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixComposite<RelatedProduct> relatedProducts() {
        _initialize();
        return relatedProducts;
    }
}
