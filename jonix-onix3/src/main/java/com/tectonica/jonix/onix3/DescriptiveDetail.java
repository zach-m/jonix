/*
 * Copyright (C) 2012-2023 Zach Melamed
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
import com.tectonica.jonix.common.codelist.AudienceCodeTypes;
import com.tectonica.jonix.common.codelist.EditionTypes;
import com.tectonica.jonix.common.codelist.EpublicationTechnicalProtections;
import com.tectonica.jonix.common.codelist.ExtentTypes;
import com.tectonica.jonix.common.codelist.IllustrationAndOtherContentTypes;
import com.tectonica.jonix.common.codelist.LanguageRoles;
import com.tectonica.jonix.common.codelist.MeasureTypes;
import com.tectonica.jonix.common.codelist.ProductClassificationTypes;
import com.tectonica.jonix.common.codelist.ProductContentTypes;
import com.tectonica.jonix.common.codelist.ProductFormDetails;
import com.tectonica.jonix.common.codelist.ProductFormFeatureTypes;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixAncillaryContent;
import com.tectonica.jonix.common.struct.JonixAudience;
import com.tectonica.jonix.common.struct.JonixAudienceRange;
import com.tectonica.jonix.common.struct.JonixComplexity;
import com.tectonica.jonix.common.struct.JonixExtent;
import com.tectonica.jonix.common.struct.JonixLanguage;
import com.tectonica.jonix.common.struct.JonixMeasure;
import com.tectonica.jonix.common.struct.JonixProductClassification;
import com.tectonica.jonix.common.struct.JonixProductFormFeature;
import com.tectonica.jonix.common.struct.JonixSubject;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Descriptive detail composite</h1>
 * <p>
 * The descriptive detail block covers data Groups P.3 to P.13, all of which are essentially part of the factual
 * description of the form and content of a product. The block as a whole is non-repeating. It is mandatory in any
 * &lt;Product&gt; record unless the &lt;NotificationType&gt; in Group&nbsp;P.1 indicates that the record is an update
 * notice which carries only those blocks in which changes have occurred.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;DescriptiveDetail&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;descriptivedetail&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;1</td>
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
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link DescriptiveDetail}</li>
 * </ul>
 */
public class DescriptiveDetail implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "DescriptiveDetail";
    public static final String shortname = "descriptivedetail";

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
    public static final DescriptiveDetail EMPTY = new DescriptiveDetail();

    public DescriptiveDetail() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public DescriptiveDetail(org.w3c.dom.Element element) {
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
                case ProductComposition.refname:
                case ProductComposition.shortname:
                    productComposition = new ProductComposition(e);
                    break;
                case ProductForm.refname:
                case ProductForm.shortname:
                    productForm = new ProductForm(e);
                    break;
                case TitleDetail.refname:
                case TitleDetail.shortname:
                    titleDetails = JPU.addToList(titleDetails, new TitleDetail(e));
                    break;
                case Contributor.refname:
                case Contributor.shortname:
                    contributors = JPU.addToList(contributors, new Contributor(e));
                    break;
                case ProductPackaging.refname:
                case ProductPackaging.shortname:
                    productPackaging = new ProductPackaging(e);
                    break;
                case TradeCategory.refname:
                case TradeCategory.shortname:
                    tradeCategory = new TradeCategory(e);
                    break;
                case PrimaryContentType.refname:
                case PrimaryContentType.shortname:
                    primaryContentType = new PrimaryContentType(e);
                    break;
                case CountryOfManufacture.refname:
                case CountryOfManufacture.shortname:
                    countryOfManufacture = new CountryOfManufacture(e);
                    break;
                case NoCollection.refname:
                case NoCollection.shortname:
                    noCollection = new NoCollection(e);
                    break;
                case ThesisType.refname:
                case ThesisType.shortname:
                    thesisType = new ThesisType(e);
                    break;
                case ThesisPresentedTo.refname:
                case ThesisPresentedTo.shortname:
                    thesisPresentedTo = new ThesisPresentedTo(e);
                    break;
                case ThesisYear.refname:
                case ThesisYear.shortname:
                    thesisYear = new ThesisYear(e);
                    break;
                case NoContributor.refname:
                case NoContributor.shortname:
                    noContributor = new NoContributor(e);
                    break;
                case EditionNumber.refname:
                case EditionNumber.shortname:
                    editionNumber = new EditionNumber(e);
                    break;
                case EditionVersionNumber.refname:
                case EditionVersionNumber.shortname:
                    editionVersionNumber = new EditionVersionNumber(e);
                    break;
                case NoEdition.refname:
                case NoEdition.shortname:
                    noEdition = new NoEdition(e);
                    break;
                case ReligiousText.refname:
                case ReligiousText.shortname:
                    religiousText = new ReligiousText(e);
                    break;
                case Illustrated.refname:
                case Illustrated.shortname:
                    illustrated = new Illustrated(e);
                    break;
                case NumberOfIllustrations.refname:
                case NumberOfIllustrations.shortname:
                    numberOfIllustrations = new NumberOfIllustrations(e);
                    break;
                case ProductFormDetail.refname:
                case ProductFormDetail.shortname:
                    productFormDetails = JPU.addToList(productFormDetails, new ProductFormDetail(e));
                    break;
                case ProductFormFeature.refname:
                case ProductFormFeature.shortname:
                    productFormFeatures = JPU.addToList(productFormFeatures, new ProductFormFeature(e));
                    break;
                case ProductFormDescription.refname:
                case ProductFormDescription.shortname:
                    productFormDescriptions = JPU.addToList(productFormDescriptions, new ProductFormDescription(e));
                    break;
                case ProductContentType.refname:
                case ProductContentType.shortname:
                    productContentTypes = JPU.addToList(productContentTypes, new ProductContentType(e));
                    break;
                case Measure.refname:
                case Measure.shortname:
                    measures = JPU.addToList(measures, new Measure(e));
                    break;
                case EpubTechnicalProtection.refname:
                case EpubTechnicalProtection.shortname:
                    epubTechnicalProtections = JPU.addToList(epubTechnicalProtections, new EpubTechnicalProtection(e));
                    break;
                case EpubUsageConstraint.refname:
                case EpubUsageConstraint.shortname:
                    epubUsageConstraints = JPU.addToList(epubUsageConstraints, new EpubUsageConstraint(e));
                    break;
                case EpubLicenseWithDate.refname:
                case EpubLicenseWithDate.shortname:
                    epubLicenses = JPU.addToList(epubLicenses, new EpubLicenseWithDate(e));
                    break;
                case MapScale.refname:
                case MapScale.shortname:
                    mapScales = JPU.addToList(mapScales, new MapScale(e));
                    break;
                case ProductClassification.refname:
                case ProductClassification.shortname:
                    productClassifications = JPU.addToList(productClassifications, new ProductClassification(e));
                    break;
                case ProductPart.refname:
                case ProductPart.shortname:
                    productParts = JPU.addToList(productParts, new ProductPart(e));
                    break;
                case Collection.refname:
                case Collection.shortname:
                    collections = JPU.addToList(collections, new Collection(e));
                    break;
                case ContributorStatement.refname:
                case ContributorStatement.shortname:
                    contributorStatements = JPU.addToList(contributorStatements, new ContributorStatement(e));
                    break;
                case Event.refname:
                case Event.shortname:
                    events = JPU.addToList(events, new Event(e));
                    break;
                case EditionType.refname:
                case EditionType.shortname:
                    editionTypes = JPU.addToList(editionTypes, new EditionType(e));
                    break;
                case EditionStatement.refname:
                case EditionStatement.shortname:
                    editionStatements = JPU.addToList(editionStatements, new EditionStatement(e));
                    break;
                case Language.refname:
                case Language.shortname:
                    languages = JPU.addToList(languages, new Language(e));
                    break;
                case Extent.refname:
                case Extent.shortname:
                    extents = JPU.addToList(extents, new Extent(e));
                    break;
                case IllustrationsNote.refname:
                case IllustrationsNote.shortname:
                    illustrationsNotes = JPU.addToList(illustrationsNotes, new IllustrationsNote(e));
                    break;
                case AncillaryContent.refname:
                case AncillaryContent.shortname:
                    ancillaryContents = JPU.addToList(ancillaryContents, new AncillaryContent(e));
                    break;
                case Subject.refname:
                case Subject.shortname:
                    subjects = JPU.addToList(subjects, new Subject(e));
                    break;
                case NameAsSubject.refname:
                case NameAsSubject.shortname:
                    nameAsSubjects = JPU.addToList(nameAsSubjects, new NameAsSubject(e));
                    break;
                case Audience.refname:
                case Audience.shortname:
                    audiences = JPU.addToList(audiences, new Audience(e));
                    break;
                case AudienceRange.refname:
                case AudienceRange.shortname:
                    audienceRanges = JPU.addToList(audienceRanges, new AudienceRange(e));
                    break;
                case AudienceDescription.refname:
                case AudienceDescription.shortname:
                    audienceDescriptions = JPU.addToList(audienceDescriptions, new AudienceDescription(e));
                    break;
                case Complexity.refname:
                case Complexity.shortname:
                    complexitys = JPU.addToList(complexitys, new Complexity(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;DescriptiveDetail&gt; or &lt;descriptivedetail&gt;) is explicitly provided in the
     *         ONIX XML
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

    private ProductComposition productComposition = ProductComposition.EMPTY;

    /**
     * <p>
     * An ONIX code which indicates whether a product consists of a single item or multiple items or components.
     * Mandatory in an occurrence of &lt;DescriptiveDetail&gt;, and non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public ProductComposition productComposition() {
        _initialize();
        return productComposition;
    }

    private ProductForm productForm = ProductForm.EMPTY;

    /**
     * <p>
     * An ONIX code which indicates the primary form of a product. Mandatory in an occurrence of
     * &lt;DescriptiveDetail&gt;, and non-repeating.
     * </p>
     * <p>
     * Note that in ONIX&nbsp;3.0 and later, the handling of multiple-item and multi-component products requires that
     * the form of the contained items or components is specified only in the &lt;ProductPart&gt; composite (equivalent
     * to &lt;Contained Item&gt; in earlier releases of ONIX). &lt;ProductPart&gt; forms Group&nbsp;P.4 and
     * <em>must</em> be included for full description of any multiple-item or multi-component product.
     * </p>
     * Jonix-Comment: this field is required
     */
    public ProductForm productForm() {
        _initialize();
        return productForm;
    }

    private List<TitleDetail> titleDetails = Collections.emptyList();

    /**
     * <p>
     * A group of data elements which together give the text of a title and specify its type. At least one title detail
     * element is mandatory in each occurrence of the &lt;DescriptiveDetail&gt; composite, to give the primary form of
     * the product title. The composite is repeatable with different title types.
     * </p>
     * Jonix-Comment: this list is required to contain at least one item
     */
    public List<TitleDetail> titleDetails() {
        _initialize();
        return titleDetails;
    }

    private List<Contributor> contributors = Collections.emptyList();

    /**
     * <p>
     * A group of data elements which together describe a personal or corporate contributor to the product. Optional,
     * and repeatable to describe multiple contributors.
     * </p>
     * Jonix-Comment: this list is required to contain at least one item
     */
    public List<Contributor> contributors() {
        _initialize();
        return contributors;
    }

    private ProductPackaging productPackaging = ProductPackaging.EMPTY;

    /**
     * <p>
     * An ONIX code which indicates the type of outer packaging used for the product. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public ProductPackaging productPackaging() {
        _initialize();
        return productPackaging;
    }

    private TradeCategory tradeCategory = TradeCategory.EMPTY;

    /**
     * <p>
     * An ONIX code which indicates a trade category which is somewhat related to, but not properly an attribute of,
     * product form. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public TradeCategory tradeCategory() {
        _initialize();
        return tradeCategory;
    }

    private PrimaryContentType primaryContentType = PrimaryContentType.EMPTY;

    /**
     * <p>
     * An ONIX code which indicates the primary or only content type included in a product. The element is intended to
     * be used in particular for digital products, when the sender wishes to make it clear that one of a number of
     * content types (<i>eg</i> text, audio, video) is the primary type for the product. Other content types may be
     * specified in the &lt;ProductContentType&gt;. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public PrimaryContentType primaryContentType() {
        _initialize();
        return primaryContentType;
    }

    private CountryOfManufacture countryOfManufacture = CountryOfManufacture.EMPTY;

    /**
     * <p>
     * An ONIX code identifying the country of manufacture of a single-item product, or of a multiple-item product when
     * all items are manufactured in the same country. This information is needed in some countries to meet regulatory
     * requirements. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public CountryOfManufacture countryOfManufacture() {
        _initialize();
        return countryOfManufacture;
    }

    private NoCollection noCollection = NoCollection.EMPTY;

    /**
     * <p>
     * An empty element that provides a positive indication that a product does not belong to a collection (a ‘set’ or
     * ‘series’). This element is intended to be used in an ONIX accreditation scheme to confirm that collection
     * information is being consistently supplied in publisher ONIX feeds. Optional and non-repeating. Must only be sent
     * in a record that has no instances of the &lt;Collection&gt; composite <em>and</em> has no collection level title
     * elements in Group&nbsp;P.6.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public NoCollection noCollection() {
        _initialize();
        return noCollection;
    }

    public boolean isNoCollection() {
        return (noCollection().exists());
    }

    private ThesisType thesisType = ThesisType.EMPTY;

    /**
     * <p>
     * An ONIX code identifying a thesis type, when the ONIX record describes an item which was originally presented as
     * an academic thesis or dissertation. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public ThesisType thesisType() {
        _initialize();
        return thesisType;
    }

    private ThesisPresentedTo thesisPresentedTo = ThesisPresentedTo.EMPTY;

    /**
     * <p>
     * The name of an academic institution to which a thesis was presented. Optional and non-repeating, but if this
     * element is present, &lt;ThesisType&gt; must also be present.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public ThesisPresentedTo thesisPresentedTo() {
        _initialize();
        return thesisPresentedTo;
    }

    private ThesisYear thesisYear = ThesisYear.EMPTY;

    /**
     * <p>
     * The year in which a thesis was presented. Optional and non-repeating, but if this element is present,
     * &lt;ThesisType&gt; must also be present.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public ThesisYear thesisYear() {
        _initialize();
        return thesisYear;
    }

    private NoContributor noContributor = NoContributor.EMPTY;

    /**
     * <p>
     * An empty element that provides a positive indication that a product has no stated authorship. Intended to be used
     * in an ONIX accreditation scheme to confirm that author information is being consistently supplied in publisher
     * ONIX feeds. Optional and non-repeating. Must only be sent in a record that has no other elements from
     * Group&nbsp;P.7.
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

    private EditionNumber editionNumber = EditionNumber.EMPTY;

    /**
     * <p>
     * The number of a numbered edition. Optional and non-repeating. Normally sent only for the second and subsequent
     * editions, but by agreement between parties to an ONIX exchange or when a first and a subsequent edition are
     * available at the same time, a first edition may be explicitly numbered.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public EditionNumber editionNumber() {
        _initialize();
        return editionNumber;
    }

    private EditionVersionNumber editionVersionNumber = EditionVersionNumber.EMPTY;

    /**
     * <p>
     * The number of a numbered revision within an edition number. To be used only where a publisher uses such two-level
     * numbering to indicate revisions which do not constitute a new edition under a new ISBN or other distinctive
     * product identifier. Optional and non-repeating. If this field is used, an &lt;EditionNumber&gt; must also be
     * present.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public EditionVersionNumber editionVersionNumber() {
        _initialize();
        return editionVersionNumber;
    }

    private NoEdition noEdition = NoEdition.EMPTY;

    /**
     * <p>
     * An empty element that provides a positive indication that a product does not carry any edition information.
     * Intended to be used in an ONIX accreditation scheme to confirm that edition information is being consistently
     * supplied in publisher ONIX feeds. Optional and non-repeating. Must only be sent in a record that has no instances
     * of any of the four preceding Edition elements.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public NoEdition noEdition() {
        _initialize();
        return noEdition;
    }

    public boolean isNoEdition() {
        return (noEdition().exists());
    }

    private ReligiousText religiousText = ReligiousText.EMPTY;

    /**
     * <p>
     * An optional, non-repeating, group of data elements which together describe features of the content of an edition
     * of a religious text, and intended to meet the special needs of religious publishers and booksellers. The
     * &lt;ReligiousText&gt; composite may carry <em>either</em> a &lt;Bible&gt; composite <em>or</em> a
     * &lt;ReligiousTextIdentifier&gt; element accompanied by multiple repeats of the &lt;ReligiousTextFeature&gt;
     * composite. This approach is adopted to enable other devotional texts to be included if need arises without
     * requiring a new ONIX release.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public ReligiousText religiousText() {
        _initialize();
        return religiousText;
    }

    private Illustrated illustrated = Illustrated.EMPTY;

    /**
     * <p>
     * An ONIX code indicating whether a book or other textual (usually printed) product has illustrations. The more
     * informative free text field &lt;IllustrationsNote&gt; and/or the &lt;AncillaryContent&gt; composite are strongly
     * preferred. This element has been added specifically to cater for a situation where a sender of product
     * information maintains only a yes/no flag, and it should not otherwise be used. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public Illustrated illustrated() {
        _initialize();
        return illustrated;
    }

    private NumberOfIllustrations numberOfIllustrations = NumberOfIllustrations.EMPTY;

    /**
     * <p>
     * The total number of illustrations in a book or other printed product. The more informative free text field
     * &lt;IllustrationsNote&gt; and/or the &lt;AncillaryContent&gt; composite are strongly preferred, but where a
     * sender of product information maintains only a simple numeric field, the &lt;NumberOfIllustrations&gt; element
     * may be used. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public NumberOfIllustrations numberOfIllustrations() {
        _initialize();
        return numberOfIllustrations;
    }

    private ListOfOnixElement<ProductFormDetail, ProductFormDetails> productFormDetails = ListOfOnixElement.empty();

    /**
     * <p>
     * An ONIX code which provides added detail of the medium and/or format of the product. Optional, and repeatable in
     * order to provide multiple additional details.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<ProductFormDetail, ProductFormDetails> productFormDetails() {
        _initialize();
        return productFormDetails;
    }

    private ListOfOnixDataCompositeWithKey<ProductFormFeature, JonixProductFormFeature,
        ProductFormFeatureTypes> productFormFeatures = ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * <p>
     * An optional group of data elements which together describe an aspect of product form that is too specific to be
     * covered in the &lt;ProductForm&gt; and &lt;ProductFormDetail&gt; elements. Repeatable in order to describe
     * different aspects of the product form.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<ProductFormFeature, JonixProductFormFeature, ProductFormFeatureTypes>
        productFormFeatures() {
        _initialize();
        return productFormFeatures;
    }

    private ListOfOnixElement<ProductFormDescription, String> productFormDescriptions = ListOfOnixElement.empty();

    /**
     * <p>
     * If product form codes do not adequately describe the product, a short text description may be added to give a
     * more detailed specification of the product form. The field is optional, and repeatable to provide parallel
     * descriptions in multiple languages. The <i>language</i> attribute is optional for a single instance of
     * &lt;ProductFormDescription&gt;, but must be included in each instance if &lt;ProductFormDescription&gt; is
     * repeated to provide parallel descriptions in multiple languages.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<ProductFormDescription, String> productFormDescriptions() {
        _initialize();
        return productFormDescriptions;
    }

    private ListOfOnixElement<ProductContentType, ProductContentTypes> productContentTypes = ListOfOnixElement.empty();

    /**
     * <p>
     * An ONIX code which indicates a content type included in a product. The element is intended to be used in
     * particular for digital products, to specify content types other than the primary type, or to list content types
     * when none is singled out as the primary type. Optional, and repeatable to list multiple content types.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<ProductContentType, ProductContentTypes> productContentTypes() {
        _initialize();
        return productContentTypes;
    }

    private ListOfOnixDataCompositeWithKey<Measure, JonixMeasure, MeasureTypes> measures =
        ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * <p>
     * An optional group of data elements which together identify a measurement and the units in which it is expressed;
     * used to specify the overall dimensions of a physical product including its packaging (if any). Repeatable to
     * provide multiple combinations of dimension and unit.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<Measure, JonixMeasure, MeasureTypes> measures() {
        _initialize();
        return measures;
    }

    private ListOfOnixElement<EpubTechnicalProtection, EpublicationTechnicalProtections> epubTechnicalProtections =
        ListOfOnixElement.empty();

    /**
     * <p>
     * An ONIX code specifying whether a digital product has DRM or other technical protection features. Optional, and
     * repeatable if a product has two or more kinds of protection (<i>ie</i> different parts of a product are protected
     * in different ways).
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<EpubTechnicalProtection, EpublicationTechnicalProtections> epubTechnicalProtections() {
        _initialize();
        return epubTechnicalProtections;
    }

    private List<EpubUsageConstraint> epubUsageConstraints = Collections.emptyList();

    /**
     * <p>
     * An optional group of data elements which together describe a usage constraint on a digital product (or the
     * absence of such a constraint), whether enforced by DRM technical protection, inherent in the platform used, or
     * specified by license agreement. Repeatable in order to describe multiple constraints on usage.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public List<EpubUsageConstraint> epubUsageConstraints() {
        _initialize();
        return epubUsageConstraints;
    }

    private List<EpubLicenseWithDate> epubLicenses = Collections.emptyList();

    /**
     * Jonix-Comment: this list may be empty
     */
    public List<EpubLicenseWithDate> epubLicenses() {
        _initialize();
        return epubLicenses;
    }

    private ListOfOnixElement<MapScale, Integer> mapScales = ListOfOnixElement.empty();

    /**
     * <p>
     * The scale of a map, expressed as a ratio 1:nnnnn; only the number nnnnn is carried in the data element, without
     * spaces or punctuation. Optional, and repeatable if a product comprises maps with two or more different scales.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<MapScale, Integer> mapScales() {
        _initialize();
        return mapScales;
    }

    private ListOfOnixDataCompositeWithKey<ProductClassification, JonixProductClassification,
        ProductClassificationTypes> productClassifications = ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * <p>
     * An optional group of data elements which together define a product classification (<em>not</em> to be confused
     * with a subject classification). The intended use is to enable national or international trade classifications
     * (also known as commodity codes) to be carried in an ONIX record. The composite is repeatable if parts of the
     * product are classified differently within a single product classification scheme, or to provide classification
     * codes from multiple classification schemes.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<ProductClassification, JonixProductClassification, ProductClassificationTypes>
        productClassifications() {
        _initialize();
        return productClassifications;
    }

    private List<ProductPart> productParts = Collections.emptyList();

    /**
     * <p>
     * A group of data elements which together describe an item which is part of or contained within a
     * multiple-component or multiple-item product or a trade pack. The composite must be used with all multi-component
     * or multi-item products and packs to specify (for example) the item(s) and item quantities included in a combined
     * book plus audiobook product, a multi-volume set, a filled dumpbin, or a classroom pack. In other cases, where
     * parts are not individually identified, it is used to state the product form(s) and the quantity or quantities of
     * each form contained within the product. The composite must be repeated for each individually-identified item or
     * component, or for each unidentified type of item or component.
     * </p>
     * <p>
     * Each instance of the &lt;ProductPart&gt; composite must carry a &lt;ProductForm&gt; code and a quantity, even if
     * the quantity is ‘1’. If the composite refers to a number of copies of a single item, the quantity must be sent as
     * &lt;NumberOfCopies&gt;, normally accompanied by a &lt;ProductIdentifier&gt;. If the composite refers to a number
     * of <em>different</em> items of the same form, without identifying them individually, the quantity must be sent as
     * &lt;NumberOfItemsOfThisForm&gt;.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public List<ProductPart> productParts() {
        _initialize();
        return productParts;
    }

    private List<Collection> collections = Collections.emptyList();

    /**
     * <p>
     * An optional group of data elements which carry attributes of a collection of which the product is part. (For a
     * publisher collection, these attributes may or may not include the collection title.) The composite is repeatable,
     * to provide details when the product belongs to multiple collections.
     * </p>
     * <p>
     * Collection-related data elements within a &lt;Collection&gt; composite that does not carry collection title
     * information must relate to a publisher collection whose title is included in Group&nbsp;P.6.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public List<Collection> collections() {
        _initialize();
        return collections;
    }

    private ListOfOnixElement<ContributorStatement, String> contributorStatements = ListOfOnixElement.empty();

    /**
     * <p>
     * Free text showing how the authorship should be described in an online display, when a standard concatenation of
     * individual contributor elements would not give a satisfactory presentation. Optional, and repeatable if parallel
     * text is provided in multiple languages. The <i>language</i> attribute is optional for a single instance of
     * &lt;ContributorStatement&gt;, but must be included in each instance if &lt;ContributorStatement&gt; is repeated.
     * When the &lt;ContributorStatement&gt; field is sent, the receiver should use it to replace all name detail sent
     * in the &lt;Contributor&gt; composite <em>for display purposes only</em>. It does not replace the
     * &lt;BiographicalNote&gt; element. The individual name detail <em>must</em> also be sent in the
     * &lt;Contributor&gt; composite for indexing and retrieval purposes.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<ContributorStatement, String> contributorStatements() {
        _initialize();
        return contributorStatements;
    }

    private List<Event> events = Collections.emptyList();

    /**
     * <p>
     * A group of data elements which together describe an event to which the product is related. Optional, and
     * repeatable if the product contains material from or is related to two or more events.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public List<Event> events() {
        _initialize();
        return events;
    }

    private ListOfOnixElement<EditionType, EditionTypes> editionTypes = ListOfOnixElement.empty();

    /**
     * <p>
     * An ONIX code, indicating the type of a version or edition. Optional, and repeatable if the product has
     * characteristics of two or more types (<i>eg</i> ‘revised’ and ‘annotated’).
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<EditionType, EditionTypes> editionTypes() {
        _initialize();
        return editionTypes;
    }

    private ListOfOnixElement<EditionStatement, String> editionStatements = ListOfOnixElement.empty();

    /**
     * <p>
     * A short free-text description of a version or edition. Optional, and repeatable if parallel text is provided in
     * multiple languages. The <i>language</i> attribute is optional for a single instance of &lt;EditionStatement&gt;,
     * but must be included in each instance if &lt;EditionStatement&gt; is repeated. When used, an
     * &lt;EditionStatement&gt; must be complete in itself, <i>ie</i> it should not be treated as merely supplementary
     * to an &lt;EditionType&gt; or an &lt;EditionNumber&gt;, nor as a replacement for them. Appropriate edition type
     * and number must also be sent, for indexing and retrieval. An &lt;EditionStatement&gt; should be strictly limited
     * to describing features of the content of the edition, and should <em>not</em> include aspects such as rights or
     * market restrictions which are properly covered elsewhere in the ONIX record.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<EditionStatement, String> editionStatements() {
        _initialize();
        return editionStatements;
    }

    private ListOfOnixDataCompositeWithKey<Language, JonixLanguage, LanguageRoles> languages =
        ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * <p>
     * A group of data elements which together represent a language, and specify its role and, where required, whether
     * it is a country variant. Optional, and repeatable to specify multiple languages and their various roles.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<Language, JonixLanguage, LanguageRoles> languages() {
        _initialize();
        return languages;
    }

    private ListOfOnixDataCompositeWithKey<Extent, JonixExtent, ExtentTypes> extents =
        ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * <p>
     * A group of data elements which together describe an extent pertaining to the product. Optional, but in practice
     * required for most products, <i>eg</i> to give the number of pages in a printed book or paginated e‑book, or to
     * give the running time of an audiobook. Repeatable to specify different extent types or units.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<Extent, JonixExtent, ExtentTypes> extents() {
        _initialize();
        return extents;
    }

    private ListOfOnixElement<IllustrationsNote, String> illustrationsNotes = ListOfOnixElement.empty();

    /**
     * <p>
     * For books or other text media only, this data element carries text stating the number and type of illustrations.
     * The text may also include other content items, <i>eg</i> maps, bibliography, tables, index <i>etc</i>. Optional,
     * and repeatable if parallel notes are provided in multiple languages. The <i>language</i> attribute is optional
     * for a single instance of &lt;IllustrationsNote&gt;, but must be included in each instance if
     * &lt;IllustrationsNote&gt; is repeated.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<IllustrationsNote, String> illustrationsNotes() {
        _initialize();
        return illustrationsNotes;
    }

    private ListOfOnixDataCompositeWithKey<AncillaryContent, JonixAncillaryContent,
        IllustrationAndOtherContentTypes> ancillaryContents = ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * <p>
     * A group of data elements which together specify the number of illustrations or other content items of a stated
     * type which the product carries. Use of the &lt;AncillaryContent&gt; composite is optional, but is repeatable if
     * necessary to specify different types of content items.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<AncillaryContent, JonixAncillaryContent, IllustrationAndOtherContentTypes>
        ancillaryContents() {
        _initialize();
        return ancillaryContents;
    }

    private ListOfOnixDataComposite<Subject, JonixSubject> subjects = ListOfOnixDataComposite.empty();

    /**
     * <p>
     * An optional group of data elements which together specify a subject classification, category or subject heading.
     * Repeatable, both to express multiple subject categories or headings in a scheme, and to specify subjects using
     * multiple schemes.
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
     * An optional group of data elements which together represent the name of a person or organization – real or
     * fictional – that is part of the subject of a product. Repeatable in order to name multiple persons or
     * organizations.
     * </p>
     * <p>
     * Each instance of the composite must contain <em>either</em>:
     * </p>
     * <ul>
     * <li>one or more of the forms of representation of a person name, with or without an occurrence of the
     * &lt;NameIdentifier&gt; composite; <em>or</em></li>
     * <li>one or more of the forms of representation of a corporate name, with or without an occurrence of the
     * &lt;NameIdentifier&gt; composite; <em>or</em></li>
     * <li>an occurrence of the &lt;NameIdentifier&gt; composite without any accompanying name element(s).</li>
     * </ul>
     * <p>
     * The name of a person (not of a corporation) may optionally be followed by details of that person’s professional
     * affiliation.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public List<NameAsSubject> nameAsSubjects() {
        _initialize();
        return nameAsSubjects;
    }

    private ListOfOnixDataCompositeWithKey<Audience, JonixAudience, AudienceCodeTypes> audiences =
        ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * <p>
     * An optional group of data elements which together describe an audience to which the product is directed.
     * Repeatable, both to specify multiple distinct audiences, and to express audiences using multiple schemes.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<Audience, JonixAudience, AudienceCodeTypes> audiences() {
        _initialize();
        return audiences;
    }

    private ListOfOnixDataComposite<AudienceRange, JonixAudienceRange> audienceRanges = ListOfOnixDataComposite.empty();

    /**
     * <p>
     * An optional group of data elements which together describe an audience or readership range for which a product is
     * intended. The composite can carry a single value <em>from</em>, <em>to</em>, or <em>exact</em>, or a pair of
     * values with an explicit <em>from</em> and <em>to</em>. Repeatable to specify the audience range with different
     * qualifiers.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataComposite<AudienceRange, JonixAudienceRange> audienceRanges() {
        _initialize();
        return audienceRanges;
    }

    private ListOfOnixElement<AudienceDescription, String> audienceDescriptions = ListOfOnixElement.empty();

    /**
     * <p>
     * Free text describing the audience for which a product is intended. Optional, and repeatable if parallel
     * descriptive text is provided in multiple languages. The <i>language</i> attribute is optional for a single
     * instance of &lt;AudienceDescription&gt;, but must be included in each instance if &lt;AudienceDescription&gt; is
     * repeated.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<AudienceDescription, String> audienceDescriptions() {
        _initialize();
        return audienceDescriptions;
    }

    private ListOfOnixDataComposite<Complexity, JonixComplexity> complexitys = ListOfOnixDataComposite.empty();

    /**
     * <p>
     * An optional group of data elements which together describe the level of complexity of a text. Repeatable to
     * specify the complexity using different schemes.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataComposite<Complexity, JonixComplexity> complexitys() {
        _initialize();
        return complexitys;
    }
}
