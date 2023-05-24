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

package com.tectonica.jonix.onix2;

import com.tectonica.jonix.common.JPU;
import com.tectonica.jonix.common.ListOfOnixCodelist;
import com.tectonica.jonix.common.ListOfOnixComposite;
import com.tectonica.jonix.common.ListOfOnixDataComposite;
import com.tectonica.jonix.common.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.common.ListOfOnixElement;
import com.tectonica.jonix.common.OnixProduct;
import com.tectonica.jonix.common.OnixVersion;
import com.tectonica.jonix.common.codelist.AudienceCodeTypes;
import com.tectonica.jonix.common.codelist.AudienceTypes;
import com.tectonica.jonix.common.codelist.BarcodeIndicatorsList6;
import com.tectonica.jonix.common.codelist.BookFormDetails;
import com.tectonica.jonix.common.codelist.EditionTypes;
import com.tectonica.jonix.common.codelist.ExtentTypes;
import com.tectonica.jonix.common.codelist.IllustrationAndOtherContentTypes;
import com.tectonica.jonix.common.codelist.ImageAudioVideoFileTypes;
import com.tectonica.jonix.common.codelist.LanguageRoles;
import com.tectonica.jonix.common.codelist.Languages;
import com.tectonica.jonix.common.codelist.MeasureTypes;
import com.tectonica.jonix.common.codelist.OtherTextTypes;
import com.tectonica.jonix.common.codelist.ProductClassificationTypes;
import com.tectonica.jonix.common.codelist.ProductContentTypes;
import com.tectonica.jonix.common.codelist.ProductFormDetailsList78;
import com.tectonica.jonix.common.codelist.ProductFormFeatureTypes;
import com.tectonica.jonix.common.codelist.ProductIdentifierTypes;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.TextCaseFlags;
import com.tectonica.jonix.common.codelist.TextFormats;
import com.tectonica.jonix.common.codelist.TitleTypes;
import com.tectonica.jonix.common.codelist.TransliterationSchemes;
import com.tectonica.jonix.common.codelist.WorkIdentifierTypes;
import com.tectonica.jonix.common.struct.JonixAudience;
import com.tectonica.jonix.common.struct.JonixAudienceRange;
import com.tectonica.jonix.common.struct.JonixComplexity;
import com.tectonica.jonix.common.struct.JonixExtent;
import com.tectonica.jonix.common.struct.JonixIllustrations;
import com.tectonica.jonix.common.struct.JonixLanguage;
import com.tectonica.jonix.common.struct.JonixMainSubject;
import com.tectonica.jonix.common.struct.JonixMeasure;
import com.tectonica.jonix.common.struct.JonixMediaFile;
import com.tectonica.jonix.common.struct.JonixOtherText;
import com.tectonica.jonix.common.struct.JonixPrize;
import com.tectonica.jonix.common.struct.JonixProductClassification;
import com.tectonica.jonix.common.struct.JonixProductFormFeature;
import com.tectonica.jonix.common.struct.JonixProductIdentifier;
import com.tectonica.jonix.common.struct.JonixProductWebsite;
import com.tectonica.jonix.common.struct.JonixSubject;
import com.tectonica.jonix.common.struct.JonixTitle;
import com.tectonica.jonix.common.struct.JonixWebsite;
import com.tectonica.jonix.common.struct.JonixWorkIdentifier;

import java.io.Serializable;
import java.util.function.Consumer;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Product record</h1>
 * <p>
 * A product is described by a group of data elements beginning with an XML label &lt;Product&gt; and ending with an XML
 * label &lt;/Product&gt;. The entire group of data elements which is enclosed between these two labels constitutes an
 * ONIX product record. The product record is the fundamental unit within an ONIX Product Information message. In almost
 * every case, each product record describes an individually tradable item.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;Product&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;product&gt;</tt></td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link ONIXMessage}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product}</li>
 * </ul>
 */
public class Product implements OnixProduct, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Product";
    public static final String shortname = "product";

    /////////////////////////////////////////////////////////////////////////////////
    // ATTRIBUTES
    /////////////////////////////////////////////////////////////////////////////////

    private final OnixVersion onixVersion;
    private final String onixRelease;

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

    /**
     * This constructor is for backward compatibility. For future proofing, it's recommended to use the other
     * constructor, passing onixRelease label.
     */
    public Product(org.w3c.dom.Element element) {
        this(element, null);
    }

    public Product(org.w3c.dom.Element element, String onixRelease) {
        exists = true;
        initialized = false;
        this.element = element;
        this.onixVersion = OnixVersion.ONIX2;
        this.onixRelease = onixRelease;
        textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));
        textcase = TextCaseFlags.byCode(JPU.getAttribute(element, "textcase"));
        language = Languages.byCode(JPU.getAttribute(element, "language"));
        transliteration = TransliterationSchemes.byCode(JPU.getAttribute(element, "transliteration"));
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");
    }

    @Override
    public OnixVersion onixVersion() {
        return onixVersion;
    }

    @Override
    public String onixRelease() {
        return onixRelease;
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
                case RecordReference.refname:
                case RecordReference.shortname:
                    recordReference = new RecordReference(e);
                    break;
                case NotificationType.refname:
                case NotificationType.shortname:
                    notificationType = new NotificationType(e);
                    break;
                case ISBN.refname:
                case ISBN.shortname:
                    isbn = new ISBN(e);
                    break;
                case DistinctiveTitle.refname:
                case DistinctiveTitle.shortname:
                    distinctiveTitle = new DistinctiveTitle(e);
                    break;
                case ConferenceName.refname:
                case ConferenceName.shortname:
                    conferenceName = new ConferenceName(e);
                    break;
                case ImprintName.refname:
                case ImprintName.shortname:
                    imprintName = new ImprintName(e);
                    break;
                case Height.refname:
                case Height.shortname:
                    height = new Height(e);
                    break;
                case Contributor.refname:
                case Contributor.shortname:
                    contributors = JPU.addToList(contributors, new Contributor(e));
                    break;
                case DeletionCode.refname:
                case DeletionCode.shortname:
                    deletionCode = new DeletionCode(e);
                    break;
                case DeletionText.refname:
                case DeletionText.shortname:
                    deletionText = new DeletionText(e);
                    break;
                case RecordSourceType.refname:
                case RecordSourceType.shortname:
                    recordSourceType = new RecordSourceType(e);
                    break;
                case RecordSourceIdentifierType.refname:
                case RecordSourceIdentifierType.shortname:
                    recordSourceIdentifierType = new RecordSourceIdentifierType(e);
                    break;
                case RecordSourceIdentifier.refname:
                case RecordSourceIdentifier.shortname:
                    recordSourceIdentifier = new RecordSourceIdentifier(e);
                    break;
                case RecordSourceName.refname:
                case RecordSourceName.shortname:
                    recordSourceName = new RecordSourceName(e);
                    break;
                case EAN13.refname:
                case EAN13.shortname:
                    ean13 = new EAN13(e);
                    break;
                case UPC.refname:
                case UPC.shortname:
                    upc = new UPC(e);
                    break;
                case PublisherProductNo.refname:
                case PublisherProductNo.shortname:
                    publisherProductNo = new PublisherProductNo(e);
                    break;
                case ISMN.refname:
                case ISMN.shortname:
                    ismn = new ISMN(e);
                    break;
                case DOI.refname:
                case DOI.shortname:
                    doi = new DOI(e);
                    break;
                case ReplacesISBN.refname:
                case ReplacesISBN.shortname:
                    replacesISBN = new ReplacesISBN(e);
                    break;
                case ReplacesEAN13.refname:
                case ReplacesEAN13.shortname:
                    replacesEAN13 = new ReplacesEAN13(e);
                    break;
                case ProductForm.refname:
                case ProductForm.shortname:
                    productForm = new ProductForm(e);
                    break;
                case ProductPackaging.refname:
                case ProductPackaging.shortname:
                    productPackaging = new ProductPackaging(e);
                    break;
                case ProductFormDescription.refname:
                case ProductFormDescription.shortname:
                    productFormDescription = new ProductFormDescription(e);
                    break;
                case NumberOfPieces.refname:
                case NumberOfPieces.shortname:
                    numberOfPieces = new NumberOfPieces(e);
                    break;
                case TradeCategory.refname:
                case TradeCategory.shortname:
                    tradeCategory = new TradeCategory(e);
                    break;
                case EpubType.refname:
                case EpubType.shortname:
                    epubType = new EpubType(e);
                    break;
                case EpubTypeVersion.refname:
                case EpubTypeVersion.shortname:
                    epubTypeVersion = new EpubTypeVersion(e);
                    break;
                case EpubTypeDescription.refname:
                case EpubTypeDescription.shortname:
                    epubTypeDescription = new EpubTypeDescription(e);
                    break;
                case EpubFormat.refname:
                case EpubFormat.shortname:
                    epubFormat = new EpubFormat(e);
                    break;
                case EpubFormatVersion.refname:
                case EpubFormatVersion.shortname:
                    epubFormatVersion = new EpubFormatVersion(e);
                    break;
                case EpubFormatDescription.refname:
                case EpubFormatDescription.shortname:
                    epubFormatDescription = new EpubFormatDescription(e);
                    break;
                case EpubSource.refname:
                case EpubSource.shortname:
                    epubSource = new EpubSource(e);
                    break;
                case EpubSourceVersion.refname:
                case EpubSourceVersion.shortname:
                    epubSourceVersion = new EpubSourceVersion(e);
                    break;
                case EpubSourceDescription.refname:
                case EpubSourceDescription.shortname:
                    epubSourceDescription = new EpubSourceDescription(e);
                    break;
                case EpubTypeNote.refname:
                case EpubTypeNote.shortname:
                    epubTypeNote = new EpubTypeNote(e);
                    break;
                case NoSeries.refname:
                case NoSeries.shortname:
                    noSeries = new NoSeries(e);
                    break;
                case TextCaseFlag.refname:
                case TextCaseFlag.shortname:
                    textCaseFlag = new TextCaseFlag(e);
                    break;
                case TitlePrefix.refname:
                case TitlePrefix.shortname:
                    titlePrefix = new TitlePrefix(e);
                    break;
                case TitleWithoutPrefix.refname:
                case TitleWithoutPrefix.shortname:
                    titleWithoutPrefix = new TitleWithoutPrefix(e);
                    break;
                case Subtitle.refname:
                case Subtitle.shortname:
                    subtitle = new Subtitle(e);
                    break;
                case TranslationOfTitle.refname:
                case TranslationOfTitle.shortname:
                    translationOfTitle = new TranslationOfTitle(e);
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
                case ContributorStatement.refname:
                case ContributorStatement.shortname:
                    contributorStatement = new ContributorStatement(e);
                    break;
                case NoContributor.refname:
                case NoContributor.shortname:
                    noContributor = new NoContributor(e);
                    break;
                case ConferenceDescription.refname:
                case ConferenceDescription.shortname:
                    conferenceDescription = new ConferenceDescription(e);
                    break;
                case ConferenceRole.refname:
                case ConferenceRole.shortname:
                    conferenceRole = new ConferenceRole(e);
                    break;
                case ConferenceNumber.refname:
                case ConferenceNumber.shortname:
                    conferenceNumber = new ConferenceNumber(e);
                    break;
                case ConferenceDate.refname:
                case ConferenceDate.shortname:
                    conferenceDate = new ConferenceDate(e);
                    break;
                case ConferencePlace.refname:
                case ConferencePlace.shortname:
                    conferencePlace = new ConferencePlace(e);
                    break;
                case EditionNumber.refname:
                case EditionNumber.shortname:
                    editionNumber = new EditionNumber(e);
                    break;
                case EditionVersionNumber.refname:
                case EditionVersionNumber.shortname:
                    editionVersionNumber = new EditionVersionNumber(e);
                    break;
                case EditionStatement.refname:
                case EditionStatement.shortname:
                    editionStatement = new EditionStatement(e);
                    break;
                case NoEdition.refname:
                case NoEdition.shortname:
                    noEdition = new NoEdition(e);
                    break;
                case ReligiousText.refname:
                case ReligiousText.shortname:
                    religiousText = new ReligiousText(e);
                    break;
                case OriginalLanguage.refname:
                case OriginalLanguage.shortname:
                    originalLanguage = new OriginalLanguage(e);
                    break;
                case NumberOfPages.refname:
                case NumberOfPages.shortname:
                    numberOfPages = new NumberOfPages(e);
                    break;
                case PagesRoman.refname:
                case PagesRoman.shortname:
                    pagesRoman = new PagesRoman(e);
                    break;
                case PagesArabic.refname:
                case PagesArabic.shortname:
                    pagesArabic = new PagesArabic(e);
                    break;
                case NumberOfIllustrations.refname:
                case NumberOfIllustrations.shortname:
                    numberOfIllustrations = new NumberOfIllustrations(e);
                    break;
                case IllustrationsNote.refname:
                case IllustrationsNote.shortname:
                    illustrationsNote = new IllustrationsNote(e);
                    break;
                case BASICMainSubject.refname:
                case BASICMainSubject.shortname:
                    basicMainSubject = new BASICMainSubject(e);
                    break;
                case BASICVersion.refname:
                case BASICVersion.shortname:
                    basicVersion = new BASICVersion(e);
                    break;
                case BICMainSubject.refname:
                case BICMainSubject.shortname:
                    bicMainSubject = new BICMainSubject(e);
                    break;
                case BICVersion.refname:
                case BICVersion.shortname:
                    bicVersion = new BICVersion(e);
                    break;
                case USSchoolGrade.refname:
                case USSchoolGrade.shortname:
                    usSchoolGrade = new USSchoolGrade(e);
                    break;
                case InterestAge.refname:
                case InterestAge.shortname:
                    interestAge = new InterestAge(e);
                    break;
                case AudienceDescription.refname:
                case AudienceDescription.shortname:
                    audienceDescription = new AudienceDescription(e);
                    break;
                case Annotation.refname:
                case Annotation.shortname:
                    annotation = new Annotation(e);
                    break;
                case MainDescription.refname:
                case MainDescription.shortname:
                    mainDescription = new MainDescription(e);
                    break;
                case CoverImageFormatCode.refname:
                case CoverImageFormatCode.shortname:
                    coverImageFormatCode = new CoverImageFormatCode(e);
                    break;
                case CoverImageLinkTypeCode.refname:
                case CoverImageLinkTypeCode.shortname:
                    coverImageLinkTypeCode = new CoverImageLinkTypeCode(e);
                    break;
                case CoverImageLink.refname:
                case CoverImageLink.shortname:
                    coverImageLink = new CoverImageLink(e);
                    break;
                case PrizesDescription.refname:
                case PrizesDescription.shortname:
                    prizesDescription = new PrizesDescription(e);
                    break;
                case PublisherName.refname:
                case PublisherName.shortname:
                    publisherName = new PublisherName(e);
                    break;
                case CountryOfPublication.refname:
                case CountryOfPublication.shortname:
                    countryOfPublication = new CountryOfPublication(e);
                    break;
                case OriginalPublisher.refname:
                case OriginalPublisher.shortname:
                    originalPublisher = new OriginalPublisher(e);
                    break;
                case PublishingStatus.refname:
                case PublishingStatus.shortname:
                    publishingStatus = new PublishingStatus(e);
                    break;
                case PublishingStatusNote.refname:
                case PublishingStatusNote.shortname:
                    publishingStatusNote = new PublishingStatusNote(e);
                    break;
                case AnnouncementDate.refname:
                case AnnouncementDate.shortname:
                    announcementDate = new AnnouncementDate(e);
                    break;
                case TradeAnnouncementDate.refname:
                case TradeAnnouncementDate.shortname:
                    tradeAnnouncementDate = new TradeAnnouncementDate(e);
                    break;
                case PublicationDate.refname:
                case PublicationDate.shortname:
                    publicationDate = new PublicationDate(e);
                    break;
                case CopyrightYear.refname:
                case CopyrightYear.shortname:
                    copyrightYear = new CopyrightYear(e);
                    break;
                case YearFirstPublished.refname:
                case YearFirstPublished.shortname:
                    yearFirstPublished = new YearFirstPublished(e);
                    break;
                case Width.refname:
                case Width.shortname:
                    width = new Width(e);
                    break;
                case Thickness.refname:
                case Thickness.shortname:
                    thickness = new Thickness(e);
                    break;
                case Weight.refname:
                case Weight.shortname:
                    weight = new Weight(e);
                    break;
                case Dimensions.refname:
                case Dimensions.shortname:
                    dimensions = new Dimensions(e);
                    break;
                case ReplacedByISBN.refname:
                case ReplacedByISBN.shortname:
                    replacedByISBN = new ReplacedByISBN(e);
                    break;
                case ReplacedByEAN13.refname:
                case ReplacedByEAN13.shortname:
                    replacedByEAN13 = new ReplacedByEAN13(e);
                    break;
                case AlternativeFormatISBN.refname:
                case AlternativeFormatISBN.shortname:
                    alternativeFormatISBN = new AlternativeFormatISBN(e);
                    break;
                case AlternativeFormatEAN13.refname:
                case AlternativeFormatEAN13.shortname:
                    alternativeFormatEAN13 = new AlternativeFormatEAN13(e);
                    break;
                case AlternativeProductISBN.refname:
                case AlternativeProductISBN.shortname:
                    alternativeProductISBN = new AlternativeProductISBN(e);
                    break;
                case AlternativeProductEAN13.refname:
                case AlternativeProductEAN13.shortname:
                    alternativeProductEAN13 = new AlternativeProductEAN13(e);
                    break;
                case OutOfPrintDate.refname:
                case OutOfPrintDate.shortname:
                    outOfPrintDate = new OutOfPrintDate(e);
                    break;
                case PromotionCampaign.refname:
                case PromotionCampaign.shortname:
                    promotionCampaign = new PromotionCampaign(e);
                    break;
                case PromotionContact.refname:
                case PromotionContact.shortname:
                    promotionContact = new PromotionContact(e);
                    break;
                case InitialPrintRun.refname:
                case InitialPrintRun.shortname:
                    initialPrintRun = new InitialPrintRun(e);
                    break;
                case CopiesSold.refname:
                case CopiesSold.shortname:
                    copiesSold = new CopiesSold(e);
                    break;
                case BookClubAdoption.refname:
                case BookClubAdoption.shortname:
                    bookClubAdoption = new BookClubAdoption(e);
                    break;
                case ProductIdentifier.refname:
                case ProductIdentifier.shortname:
                    productIdentifiers = JPU.addToList(productIdentifiers, new ProductIdentifier(e));
                    break;
                case Barcode.refname:
                case Barcode.shortname:
                    barcodes = JPU.addToList(barcodes, new Barcode(e));
                    break;
                case ProductFormDetail.refname:
                case ProductFormDetail.shortname:
                    productFormDetails = JPU.addToList(productFormDetails, new ProductFormDetail(e));
                    break;
                case ProductFormFeature.refname:
                case ProductFormFeature.shortname:
                    productFormFeatures = JPU.addToList(productFormFeatures, new ProductFormFeature(e));
                    break;
                case BookFormDetail.refname:
                case BookFormDetail.shortname:
                    bookFormDetails = JPU.addToList(bookFormDetails, new BookFormDetail(e));
                    break;
                case ProductContentType.refname:
                case ProductContentType.shortname:
                    productContentTypes = JPU.addToList(productContentTypes, new ProductContentType(e));
                    break;
                case ContainedItem.refname:
                case ContainedItem.shortname:
                    containedItems = JPU.addToList(containedItems, new ContainedItem(e));
                    break;
                case ProductClassification.refname:
                case ProductClassification.shortname:
                    productClassifications = JPU.addToList(productClassifications, new ProductClassification(e));
                    break;
                case Series.refname:
                case Series.shortname:
                    seriess = JPU.addToList(seriess, new Series(e));
                    break;
                case Set.refname:
                case Set.shortname:
                    sets = JPU.addToList(sets, new Set(e));
                    break;
                case FormerTitle.refname:
                case FormerTitle.shortname:
                    formerTitles = JPU.addToList(formerTitles, new FormerTitle(e));
                    break;
                case Title.refname:
                case Title.shortname:
                    titles = JPU.addToList(titles, new Title(e));
                    break;
                case WorkIdentifier.refname:
                case WorkIdentifier.shortname:
                    workIdentifiers = JPU.addToList(workIdentifiers, new WorkIdentifier(e));
                    break;
                case Website.refname:
                case Website.shortname:
                    websites = JPU.addToList(websites, new Website(e));
                    break;
                case Conference.refname:
                case Conference.shortname:
                    conferences = JPU.addToList(conferences, new Conference(e));
                    break;
                case EditionTypeCode.refname:
                case EditionTypeCode.shortname:
                    editionTypeCodes = JPU.addToList(editionTypeCodes, new EditionTypeCode(e));
                    break;
                case LanguageOfText.refname:
                case LanguageOfText.shortname:
                    languageOfTexts = JPU.addToList(languageOfTexts, new LanguageOfText(e));
                    break;
                case Language.refname:
                case Language.shortname:
                    languages = JPU.addToList(languages, new Language(e));
                    break;
                case Extent.refname:
                case Extent.shortname:
                    extents = JPU.addToList(extents, new Extent(e));
                    break;
                case Illustrations.refname:
                case Illustrations.shortname:
                    illustrationss = JPU.addToList(illustrationss, new Illustrations(e));
                    break;
                case MapScale.refname:
                case MapScale.shortname:
                    mapScales = JPU.addToList(mapScales, new MapScale(e));
                    break;
                case MainSubject.refname:
                case MainSubject.shortname:
                    mainSubjects = JPU.addToList(mainSubjects, new MainSubject(e));
                    break;
                case Subject.refname:
                case Subject.shortname:
                    subjects = JPU.addToList(subjects, new Subject(e));
                    break;
                case PersonAsSubject.refname:
                case PersonAsSubject.shortname:
                    personAsSubjects = JPU.addToList(personAsSubjects, new PersonAsSubject(e));
                    break;
                case CorporateBodyAsSubject.refname:
                case CorporateBodyAsSubject.shortname:
                    corporateBodyAsSubjects = JPU.addToList(corporateBodyAsSubjects, new CorporateBodyAsSubject(e));
                    break;
                case PlaceAsSubject.refname:
                case PlaceAsSubject.shortname:
                    placeAsSubjects = JPU.addToList(placeAsSubjects, new PlaceAsSubject(e));
                    break;
                case AudienceCode.refname:
                case AudienceCode.shortname:
                    audienceCodes = JPU.addToList(audienceCodes, new AudienceCode(e));
                    break;
                case Audience.refname:
                case Audience.shortname:
                    audiences = JPU.addToList(audiences, new Audience(e));
                    break;
                case AudienceRange.refname:
                case AudienceRange.shortname:
                    audienceRanges = JPU.addToList(audienceRanges, new AudienceRange(e));
                    break;
                case Complexity.refname:
                case Complexity.shortname:
                    complexitys = JPU.addToList(complexitys, new Complexity(e));
                    break;
                case OtherText.refname:
                case OtherText.shortname:
                    otherTexts = JPU.addToList(otherTexts, new OtherText(e));
                    break;
                case ReviewQuote.refname:
                case ReviewQuote.shortname:
                    reviewQuotes = JPU.addToList(reviewQuotes, new ReviewQuote(e));
                    break;
                case MediaFile.refname:
                case MediaFile.shortname:
                    mediaFiles = JPU.addToList(mediaFiles, new MediaFile(e));
                    break;
                case ProductWebsite.refname:
                case ProductWebsite.shortname:
                    productWebsites = JPU.addToList(productWebsites, new ProductWebsite(e));
                    break;
                case Prize.refname:
                case Prize.shortname:
                    prizes = JPU.addToList(prizes, new Prize(e));
                    break;
                case ContentItem.refname:
                case ContentItem.shortname:
                    contentItems = JPU.addToList(contentItems, new ContentItem(e));
                    break;
                case Imprint.refname:
                case Imprint.shortname:
                    imprints = JPU.addToList(imprints, new Imprint(e));
                    break;
                case Publisher.refname:
                case Publisher.shortname:
                    publishers = JPU.addToList(publishers, new Publisher(e));
                    break;
                case CityOfPublication.refname:
                case CityOfPublication.shortname:
                    cityOfPublications = JPU.addToList(cityOfPublications, new CityOfPublication(e));
                    break;
                case CopublisherName.refname:
                case CopublisherName.shortname:
                    copublisherNames = JPU.addToList(copublisherNames, new CopublisherName(e));
                    break;
                case SponsorName.refname:
                case SponsorName.shortname:
                    sponsorNames = JPU.addToList(sponsorNames, new SponsorName(e));
                    break;
                case CopyrightStatement.refname:
                case CopyrightStatement.shortname:
                    copyrightStatements = JPU.addToList(copyrightStatements, new CopyrightStatement(e));
                    break;
                case SalesRights.refname:
                case SalesRights.shortname:
                    salesRightss = JPU.addToList(salesRightss, new SalesRights(e));
                    break;
                case NotForSale.refname:
                case NotForSale.shortname:
                    notForSales = JPU.addToList(notForSales, new NotForSale(e));
                    break;
                case SalesRestriction.refname:
                case SalesRestriction.shortname:
                    salesRestrictions = JPU.addToList(salesRestrictions, new SalesRestriction(e));
                    break;
                case Measure.refname:
                case Measure.shortname:
                    measures = JPU.addToList(measures, new Measure(e));
                    break;
                case RelatedProduct.refname:
                case RelatedProduct.shortname:
                    relatedProducts = JPU.addToList(relatedProducts, new RelatedProduct(e));
                    break;
                case SupplyDetail.refname:
                case SupplyDetail.shortname:
                    supplyDetails = JPU.addToList(supplyDetails, new SupplyDetail(e));
                    break;
                case MarketRepresentation.refname:
                case MarketRepresentation.shortname:
                    marketRepresentations = JPU.addToList(marketRepresentations, new MarketRepresentation(e));
                    break;
                case ReprintDetail.refname:
                case ReprintDetail.shortname:
                    reprintDetails = JPU.addToList(reprintDetails, new ReprintDetail(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;Product&gt; or &lt;product&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<Product> action) {
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

    private RecordReference recordReference = RecordReference.EMPTY;

    /**
     * <p>
     * For every product, you must choose a single number which will uniquely identify the Information record which you
     * send out about that product, and which will remain as its permanent identifier every time you send an update. It
     * doesn’t matter what number you choose, provided that it is unique and permanent. This number doesn’t really
     * identify the product – even though you may choose to use the ISBN or another product identifier – it identifies
     * your information record about the product, so that the person to whom you are sending an update can match it with
     * what you have previously sent. A good way of generating numbers which are not part of a recognized product
     * identification scheme but which can be guaranteed to be unique is to preface the number with an Internet domain
     * name which is registered to your organisation.
     * </p>
     * <p>
     * This field is mandatory and non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public RecordReference recordReference() {
        _initialize();
        return recordReference;
    }

    private NotificationType notificationType = NotificationType.EMPTY;

    /**
     * <p>
     * An ONIX code which indicates the type of notification or update which you are sending. Mandatory and
     * non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public NotificationType notificationType() {
        _initialize();
        return notificationType;
    }

    private ISBN isbn = ISBN.EMPTY;

    /**
     * <p>
     * The 10-character International Standard Book Number, the recognized standard identifier for books and certain
     * other non-serial publications up to 31 December 2006. Optional and non-repeating. <strong>The
     * &lt;ProductIdentifier&gt; composite on a later page provides a more general method of handling this and other
     * product codes, and is to be preferred. The &lt;ISBN&gt; element is on no account to be used to carry a 13-digit
     * ISBN.</strong>
     * </p>
     * Jonix-Comment: this field is required
     */
    public ISBN isbn() {
        _initialize();
        return isbn;
    }

    private DistinctiveTitle distinctiveTitle = DistinctiveTitle.EMPTY;

    /**
     * <p>
     * The full text of the distinctive title of the product, without abbreviation or abridgement, but excluding the
     * subtitle (if any). Where the title alone is not distinctive, elements may be taken from a set or series title and
     * part number <em>etc</em> to create a distinctive title. Where the product is an omnibus edition containing two or
     * more works by the same author, and there is no separate product title, a product title may be constructed by
     * concatenating the individual titles, with suitable punctuation, as in the second example below. (If, however,
     * there is a separate product title, or if more description of each individual work is required, the
     * &lt;ContentItem&gt; composite can be used for the individual works – see Group&nbsp;PR.18.) Optional and
     * non-repeating. <strong>The &lt;Title&gt; composite on a later page provides a more general method of handling all
     * forms of title, and is to be preferred.</strong>
     * </p>
     * Jonix-Comment: this field is required
     */
    public DistinctiveTitle distinctiveTitle() {
        _initialize();
        return distinctiveTitle;
    }

    private ConferenceName conferenceName = ConferenceName.EMPTY;

    /**
     * <p>
     * The name of a conference or conference series to which the product is related. This element is mandatory unless
     * the &lt;ConferenceDescription&gt; element or the &lt;Conference&gt; composite is used, and is non-repeating.
     * <strong>The &lt;Conference&gt; composite on a later page provides a more general method of handling conference
     * detail, and is to be preferred.</strong>
     * </p>
     * Jonix-Comment: this field is required
     */
    public ConferenceName conferenceName() {
        _initialize();
        return conferenceName;
    }

    private ImprintName imprintName = ImprintName.EMPTY;

    /**
     * <p>
     * The full name of the imprint or brand under which the product is issued, as it appears on the title page of a
     * book or in a corresponding position on a non-book product. Optional and non-repeating; and should not be used if
     * the &lt;Imprint&gt; composite is used.
     * </p>
     * <p>
     * <strong>The &lt;Imprint&gt; composite below provides a more general method of handling imprint identities, and is
     * to be preferred.</strong>
     * </p>
     * Jonix-Comment: this field is required
     */
    public ImprintName imprintName() {
        _initialize();
        return imprintName;
    }

    private Height height = Height.EMPTY;

    /**
     * <p>
     * The overall height of the product: in the case of a book, the spine height, in the units specified in the message
     * header, &lt;DefaultLinearUnit&gt; field, defined in the <cite>ONIX for Books – Product Information Message – XML
     * Message Specification</cite>. Optional and non-repeating; but required if either &lt;Width&gt; or
     * &lt;Thickness&gt; is present. <strong>The &lt;Measure&gt; composite on a previous page provides a more general
     * method of handling measurements, and is to be preferred.</strong>
     * </p>
     * Jonix-Comment: this field is required
     */
    public Height height() {
        _initialize();
        return height;
    }

    private ListOfOnixComposite<Contributor> contributors = JPU.emptyListOfOnixComposite(Contributor.class);

    /**
     * <p>
     * A repeatable group of data elements which together describe a personal or corporate contributor to the product.
     * </p>
     * Jonix-Comment: this list is required to contain at least one item
     */
    public ListOfOnixComposite<Contributor> contributors() {
        _initialize();
        return contributors;
    }

    private DeletionCode deletionCode = DeletionCode.EMPTY;

    /**
     * <p>
     * An ONIX code which indicates the reason why an ONIX record is being deleted. Optional and non-repeating; and may
     * occur only when the &lt;NotificationType&gt; element carries the code value 05. Note that it refers to the reason
     * why the record is being deleted, not the reason why a product has been “deleted” (in industries which use this
     * terminology when a product is withdrawn).
     * </p>
     * Jonix-Comment: this field is optional
     */
    public DeletionCode deletionCode() {
        _initialize();
        return deletionCode;
    }

    private DeletionText deletionText = DeletionText.EMPTY;

    /**
     * <p>
     * Free text which indicates the reason why an ONIX record is being deleted. Optional and non-repeating; and may
     * occur only when the &lt;NotificationType&gt; element carries the code value 05. Note that it refers to the reason
     * why the record is being deleted, not the reason why a product has been “deleted” (in industries which use this
     * terminology when a product is withdrawn).
     * </p>
     * Jonix-Comment: this field is optional
     */
    public DeletionText deletionText() {
        _initialize();
        return deletionText;
    }

    private RecordSourceType recordSourceType = RecordSourceType.EMPTY;

    /**
     * <p>
     * An ONIX code which indicates the type of source which has issued the ONIX record. Optional and non-repeating,
     * independently of the occurrence of any other field.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public RecordSourceType recordSourceType() {
        _initialize();
        return recordSourceType;
    }

    private RecordSourceIdentifierType recordSourceIdentifierType = RecordSourceIdentifierType.EMPTY;

    /**
     * <p>
     * An ONIX code identifying the scheme from which the identifier in the &lt;RecordSourceIdentifier&gt; element is
     * taken. Optional and non-repeating, but &lt;RecordSourceIdentifier&gt; must also be present if this field is
     * present.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public RecordSourceIdentifierType recordSourceIdentifierType() {
        _initialize();
        return recordSourceIdentifierType;
    }

    private RecordSourceIdentifier recordSourceIdentifier = RecordSourceIdentifier.EMPTY;

    /**
     * <p>
     * An identifier for the party which issued the record, from the scheme specified in
     * &lt;RecordSourceIdentifierType&gt;. Optional and non-repeating, but &lt;RecordSourceIdentifierType&gt; must also
     * be present if this field is present.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public RecordSourceIdentifier recordSourceIdentifier() {
        _initialize();
        return recordSourceIdentifier;
    }

    private RecordSourceName recordSourceName = RecordSourceName.EMPTY;

    /**
     * <p>
     * The name of the party which issued the record, as free text. Optional and non-repeating, independently of the
     * occurrence of any other field.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public RecordSourceName recordSourceName() {
        _initialize();
        return recordSourceName;
    }

    private EAN13 ean13 = EAN13.EMPTY;

    /**
     * <p>
     * The cross-industry product code administered by EAN International and its member agencies worldwide, in
     * association with UCC in the US. Optional and non-repeating. For books, an EAN number can be derived from a
     * ten-character ISBN by (a) prefixing it with the three digits 978, (b) deleting the ISBN check character, and (c)
     * attaching a new check digit calculated according to EAN rules. <strong>The &lt;ProductIdentifier&gt; composite on
     * a later page provides a more general method of handling this and other product codes, and is to be
     * preferred.</strong>
     * </p>
     * Jonix-Comment: this field is optional
     */
    public EAN13 ean13() {
        _initialize();
        return ean13;
    }

    private UPC upc = UPC.EMPTY;

    /**
     * <p>
     * Universal Product Code, the cross-industry product numbering and bar-coding system administered in the USA by the
     * Uniform Code Council. Optional and non-repeating. In the US book trade, required for mass-market editions sold in
     * supermarkets and other non-book-trade outlets. <strong>The &lt;ProductIdentifier&gt; composite on a later page
     * provides a more general method of handling this and other product codes, and is to be preferred.</strong>
     * </p>
     * Jonix-Comment: this field is optional
     */
    public UPC upc() {
        _initialize();
        return upc;
    }

    private PublisherProductNo publisherProductNo = PublisherProductNo.EMPTY;

    /**
     * <p>
     * A product code assigned by the publisher of a product, not taken from a recognized standard numbering scheme.
     * Optional and non-repeating. To be used only when the product does not have a number from a recognized industry
     * standard scheme (<em>eg</em> ISBN or ISMN), but may occur together with an EAN-13 number. <strong>The
     * &lt;ProductIdentifier&gt; composite on a later page provides a more general method of handling this and other
     * product codes, and is to be preferred.</strong>
     * </p>
     * Jonix-Comment: this field is optional
     */
    public PublisherProductNo publisherProductNo() {
        _initialize();
        return publisherProductNo;
    }

    private ISMN ismn = ISMN.EMPTY;

    /**
     * <p>
     * International Standard Music Number, the recognized standard identifier for printed music. Optional and
     * non-repeating. <strong>The &lt;ProductIdentifier&gt; composite on a later page provides a more general method of
     * handling this and other product codes, and is to be preferred.</strong>
     * </p>
     * Jonix-Comment: this field is optional
     */
    public ISMN ismn() {
        _initialize();
        return ismn;
    }

    private DOI doi = DOI.EMPTY;

    /**
     * <p>
     * Digital Object Identifier. The international identifier for intellectual property in the digital environment. See
     * <a href="http://www.doi.org/" target="_blank">http://www.doi.org/</a> Optional and non-repeating. <strong>The
     * &lt;ProductIdentifier&gt; composite below provides a more general method of handling this and other product
     * codes, and is to be preferred.</strong>
     * </p>
     * Jonix-Comment: this field is optional
     */
    public DOI doi() {
        _initialize();
        return doi;
    }

    private ReplacesISBN replacesISBN = ReplacesISBN.EMPTY;

    /**
     * <p>
     * 10-character International Standard Book Number of a former product which the current product replaces. Optional
     * and non-repeating. <strong>Note, however, that the &lt;RelatedProduct&gt; composite in Group&nbsp;PR.23 provides
     * a more general method of handling this type of link. This is now the preferred ONIX approach. The
     * &lt;ReplacesISBN&gt; element is retained only for upwards compatibility. This element is on no account to be used
     * to carry a 13-digit ISBN.</strong>
     * </p>
     * Jonix-Comment: this field is optional
     */
    public ReplacesISBN replacesISBN() {
        _initialize();
        return replacesISBN;
    }

    private ReplacesEAN13 replacesEAN13 = ReplacesEAN13.EMPTY;

    /**
     * <p>
     * The EAN.UCC-13 article number of a former product which the current product replaces. Optional and non-repeating.
     * <strong>Note, however, that the &lt;RelatedProduct&gt; composite in Group&nbsp;PR.23 provides a more general
     * method of handling this type of link. This is now the preferred ONIX approach. The &lt;ReplacesISBN&gt; element
     * is retained only for upwards compatibility.</strong>
     * </p>
     * Jonix-Comment: this field is optional
     */
    public ReplacesEAN13 replacesEAN13() {
        _initialize();
        return replacesEAN13;
    }

    private ProductForm productForm = ProductForm.EMPTY;

    /**
     * <p>
     * An ONIX code which indicates the primary form of the product. Mandatory and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public ProductForm productForm() {
        _initialize();
        return productForm;
    }

    private ProductPackaging productPackaging = ProductPackaging.EMPTY;

    /**
     * <p>
     * An ONIX code which indicates the type of packaging used for the product. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public ProductPackaging productPackaging() {
        _initialize();
        return productPackaging;
    }

    private ProductFormDescription productFormDescription = ProductFormDescription.EMPTY;

    /**
     * <p>
     * If product form codes do not adequately describe the product, a short text description may be added to give a
     * more detailed specification of the product form. The field is optional and non-repeating. <strong>Although this
     * element was originally included to allow the number and type of pieces contained in a multiple product to be
     * stated, as in the example below, the correct method of describing mixed media products in Release 2.1 is to use
     * two or more occurrences of the &lt;ContainedItem&gt; composite to give a properly structured specification of
     * each media type.</strong>
     * </p>
     * Jonix-Comment: this field is optional
     */
    public ProductFormDescription productFormDescription() {
        _initialize();
        return productFormDescription;
    }

    private NumberOfPieces numberOfPieces = NumberOfPieces.EMPTY;

    /**
     * <p>
     * If the product is homogeneous (<em>ie</em> all items or pieces which constitute the product have the same form),
     * the number of items or pieces may be included here. If the product consists of a number of items or pieces of
     * different forms (<em>eg</em> books and audio cassettes), the &lt;ContainedItem&gt; composite should be used – see
     * below. This field is optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public NumberOfPieces numberOfPieces() {
        _initialize();
        return numberOfPieces;
    }

    private TradeCategory tradeCategory = TradeCategory.EMPTY;

    /**
     * <p>
     * An ONIX code which indicates a trade category which is somewhat related to but not properly an attribute of
     * product form. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public TradeCategory tradeCategory() {
        _initialize();
        return tradeCategory;
    }

    private EpubType epubType = EpubType.EMPTY;

    /**
     * <p>
     * An ONIX code identifying the type of an epublication. This element is mandatory if and only if the
     * &lt;ProductForm&gt; code for the product is DG; and non-repeating.
     * </p>
     * <p>
     * In general, an &lt;EpubType&gt; code identifies a particular form in which an epublication is traded. The
     * exception to this is that code 000 identifies a “content package” which is published electronically in a number
     * of different forms. This value is used when the ONIX record describes and identifies the content package
     * independently of the forms in which it is made available. Each available form can then be described by using the
     * &lt;RelatedProduct&gt; composite in Group&nbsp;PR.23.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public EpubType epubType() {
        _initialize();
        return epubType;
    }

    private EpubTypeVersion epubTypeVersion = EpubTypeVersion.EMPTY;

    /**
     * <p>
     * A version number which applies to a specific epublication type. Optional and non-repeating, and can occur only if
     * the &lt;EpubType&gt; field is present.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public EpubTypeVersion epubTypeVersion() {
        _initialize();
        return epubTypeVersion;
    }

    private EpubTypeDescription epubTypeDescription = EpubTypeDescription.EMPTY;

    /**
     * <p>
     * A free text description of an epublication type. Optional and non-repeating, and can occur only if the
     * &lt;EpubType&gt; field is present.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public EpubTypeDescription epubTypeDescription() {
        _initialize();
        return epubTypeDescription;
    }

    private EpubFormat epubFormat = EpubFormat.EMPTY;

    /**
     * <p>
     * An ONIX code identifying the underlying format of an epublication. Optional and non-repeating, and can occur only
     * if the &lt;EpubType&gt; field is present. Note that where the epublication type is wholly defined by the delivery
     * format, this element effectively duplicates the &lt;EpubType&gt; field.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public EpubFormat epubFormat() {
        _initialize();
        return epubFormat;
    }

    private EpubFormatVersion epubFormatVersion = EpubFormatVersion.EMPTY;

    /**
     * <p>
     * A version number which applies to an epublication format. Optional and non-repeating, and can occur only if the
     * &lt;EpubFormat&gt; field is present.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public EpubFormatVersion epubFormatVersion() {
        _initialize();
        return epubFormatVersion;
    }

    private EpubFormatDescription epubFormatDescription = EpubFormatDescription.EMPTY;

    /**
     * <p>
     * A free text description of an epublication format. Optional and non-repeating, and can occur only if the
     * &lt;EpubType&gt; field is present, but it does not require the presence of the &lt;EpubFormat&gt; field.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public EpubFormatDescription epubFormatDescription() {
        _initialize();
        return epubFormatDescription;
    }

    private EpubSource epubSource = EpubSource.EMPTY;

    /**
     * <p>
     * An ONIX code identifying the source file format of an epublication when shipped by a publisher to an intermediary
     * for conversion to one or more forms of deliverable. Optional and non-repeating, and can occur only if the
     * &lt;EpubType&gt; field is present.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public EpubSource epubSource() {
        _initialize();
        return epubSource;
    }

    private EpubSourceVersion epubSourceVersion = EpubSourceVersion.EMPTY;

    /**
     * <p>
     * A version number which applies to an epublication source file format. Optional and non-repeating, and can occur
     * only if the &lt;EpubSource&gt; field is present.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public EpubSourceVersion epubSourceVersion() {
        _initialize();
        return epubSourceVersion;
    }

    private EpubSourceDescription epubSourceDescription = EpubSourceDescription.EMPTY;

    /**
     * <p>
     * A free text description of an epublication source file format. Optional and non-repeating, and can occur only if
     * the &lt;EpubType&gt; field is present, but it does not require the presence of the &lt;EpubSource&gt; field.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public EpubSourceDescription epubSourceDescription() {
        _initialize();
        return epubSourceDescription;
    }

    private EpubTypeNote epubTypeNote = EpubTypeNote.EMPTY;

    /**
     * <p>
     * A free text description of features of a product which are specific to its appearance as a particular
     * epublication type. Optional and non-repeatable, and can occur only if the &lt;EpubType&gt; field is present.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public EpubTypeNote epubTypeNote() {
        _initialize();
        return epubTypeNote;
    }

    private NoSeries noSeries = NoSeries.EMPTY;

    /**
     * <p>
     * An empty element that provides a positive indication that a product does not belong to a series. Intended to be
     * used in an ONIX accreditation scheme to confirm that series information is being consistently supplied in
     * publisher ONIX feeds. Optional and non-repeating. Must only be sent in a record that has no instances of the
     * &lt;Series&gt; composite.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public NoSeries noSeries() {
        _initialize();
        return noSeries;
    }

    public boolean isNoSeries() {
        return (noSeries().exists());
    }

    private TextCaseFlag textCaseFlag = TextCaseFlag.EMPTY;

    /**
     * <p>
     * An ONIX code indicating the case in which the title elements are sent. The default is “unspecified”. Optional and
     * non-repeating. <strong>Text case can now be indicated by an XML attribute on any text element, and this method is
     * preferred. See <cite>ONIX for Books – Product Information Message – XML Message Specification</cite>, Section
     * 4.</strong>
     * </p>
     * Jonix-Comment: this field is optional
     */
    public TextCaseFlag textCaseFlag() {
        _initialize();
        return textCaseFlag;
    }

    private TitlePrefix titlePrefix = TitlePrefix.EMPTY;

    /**
     * <p>
     * Text at the beginning of the distinctive title of the product which is to be ignored for alphabetical sorting.
     * Optional and non-repeating; can only be used if the &lt;TitleWithoutPrefix&gt; element is also present. These two
     * elements may be used in combination in applications where it is necessary to distinguish an initial word or
     * character string which is to be ignored for filing purposes, <em>eg</em> in library systems and in some bookshop
     * databases. <strong>The &lt;Title&gt; composite on a later page provides a more general method of handling all
     * forms of title, and is to be preferred.</strong>
     * </p>
     * Jonix-Comment: this field is optional
     */
    public TitlePrefix titlePrefix() {
        _initialize();
        return titlePrefix;
    }

    private TitleWithoutPrefix titleWithoutPrefix = TitleWithoutPrefix.EMPTY;

    /**
     * <p>
     * Full text of the distinctive title of the product, without abbreviation or abridgement, and without the title
     * prefix. Optional and non-repeating; can only be used if the &lt;TitlePrefix&gt; element is also present.
     * <strong>The &lt;Title&gt; composite on a later page provides a more general method of handling all forms of
     * title, and is to be preferred.</strong>
     * </p>
     * Jonix-Comment: this field is optional
     */
    public TitleWithoutPrefix titleWithoutPrefix() {
        _initialize();
        return titleWithoutPrefix;
    }

    private Subtitle subtitle = Subtitle.EMPTY;

    /**
     * <p>
     * The full text of the subtitle of the product, if any. “Subtitle” means any added words which appear with the
     * title of the product and which amplify and explain the title, but which are not considered to be part of the
     * distinctive title. Optional and non-repeating. <strong>The &lt;Title&gt; composite on a later page provides a
     * more general method of handling all forms of title, and is to be preferred.</strong>
     * </p>
     * Jonix-Comment: this field is optional
     */
    public Subtitle subtitle() {
        _initialize();
        return subtitle;
    }

    private TranslationOfTitle translationOfTitle = TranslationOfTitle.EMPTY;

    /**
     * <p>
     * Title of a work from which the product is translated, without abbreviation or abridgement. Optional and
     * non-repeating. <strong>The &lt;Title&gt; composite on a later page provides a more general method of handling all
     * forms of title, and is to be preferred.</strong>
     * </p>
     * Jonix-Comment: this field is optional
     */
    public TranslationOfTitle translationOfTitle() {
        _initialize();
        return translationOfTitle;
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

    private ContributorStatement contributorStatement = ContributorStatement.EMPTY;

    /**
     * <p>
     * Free text showing how the authorship should be described in an online display, when a standard concatenation of
     * individual contributor elements would not give a satisfactory presentation. When this field is sent, the receiver
     * should use it to replace all name detail sent in the &lt;Contributor&gt; composite for display purposes only. It
     * does not replace the &lt;BiographicalNote&gt; element. The individual name detail must also be sent in the
     * &lt;Contributor&gt; composite for indexing and retrieval.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public ContributorStatement contributorStatement() {
        _initialize();
        return contributorStatement;
    }

    private NoContributor noContributor = NoContributor.EMPTY;

    /**
     * <p>
     * An empty element that provides a positive indication that a product has no stated authorship. Intended to be used
     * in an ONIX accreditation scheme to confirm that author information is being consistently supplied in publisher
     * ONIX feeds. Optional and non-repeating. Must only be sent in a record that has no other elements from
     * Group&nbsp;PR.8.
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

    private ConferenceDescription conferenceDescription = ConferenceDescription.EMPTY;

    /**
     * <p>
     * Free text detailing all relevant information about a conference to which the product is related. If this element
     * is sent, no other fields from Group&nbsp;PR.9 must be sent. <strong>The &lt;Conference&gt; composite on a later
     * page provides a more general method of handling conference detail, and is to be preferred.</strong>
     * </p>
     * Jonix-Comment: this field is optional
     */
    public ConferenceDescription conferenceDescription() {
        _initialize();
        return conferenceDescription;
    }

    private ConferenceRole conferenceRole = ConferenceRole.EMPTY;

    /**
     * <p>
     * An ONIX code which indicates the relationship between the product and a conference to which it is related,
     * <em>eg</em> Proceedings of / Selected papers from / Developed from. Optional and non-repeating. <strong>The
     * &lt;Conference&gt; composite on a later page provides a more general method of handling conference detail, and is
     * to be preferred.</strong>
     * </p>
     * Jonix-Comment: this field is optional
     */
    public ConferenceRole conferenceRole() {
        _initialize();
        return conferenceRole;
    }

    private ConferenceNumber conferenceNumber = ConferenceNumber.EMPTY;

    /**
     * <p>
     * The number of a conference to which the product is related, within a conference series. Optional and
     * non-repeating. <strong>The &lt;Conference&gt; composite below provides a more general method of handling
     * conference detail, and is to be preferred.</strong>
     * </p>
     * Jonix-Comment: this field is optional
     */
    public ConferenceNumber conferenceNumber() {
        _initialize();
        return conferenceNumber;
    }

    private ConferenceDate conferenceDate = ConferenceDate.EMPTY;

    /**
     * <p>
     * The date of a conference to which the product is related. Optional and non-repeating. <strong>The
     * &lt;Conference&gt; composite below provides a more general method of handling conference detail, and is to be
     * preferred.</strong>
     * </p>
     * Jonix-Comment: this field is optional
     */
    public ConferenceDate conferenceDate() {
        _initialize();
        return conferenceDate;
    }

    private ConferencePlace conferencePlace = ConferencePlace.EMPTY;

    /**
     * <p>
     * The place of a conference to which the product is related. Optional and non-repeating. <strong>The
     * &lt;Conference&gt; composite below provides a more general method of handling conference detail, and is to be
     * preferred.</strong>
     * </p>
     * Jonix-Comment: this field is optional
     */
    public ConferencePlace conferencePlace() {
        _initialize();
        return conferencePlace;
    }

    private EditionNumber editionNumber = EditionNumber.EMPTY;

    /**
     * <p>
     * The number of a numbered edition. Optional and non-repeating. Normally sent only for the second and subsequent
     * editions of a work, but by agreement between parties to an ONIX exchange a first edition may be explicitly
     * numbered.
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

    private EditionStatement editionStatement = EditionStatement.EMPTY;

    /**
     * <p>
     * A short free-text description of a version or edition. Optional and non-repeating. When used, the
     * &lt;EditionStatement&gt; must carry a complete description of the nature of the edition, <em>ie</em> it should
     * not be treated as merely supplementary to an &lt;EditionTypeCode&gt; or an &lt;EditionNumber&gt;. The
     * &lt;EditionStatement&gt; should be strictly limited to describing features of the content of the edition, and
     * should not include aspects such as rights or market restrictions which are properly covered elsewhere in the ONIX
     * record.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public EditionStatement editionStatement() {
        _initialize();
        return editionStatement;
    }

    private NoEdition noEdition = NoEdition.EMPTY;

    /**
     * <p>
     * An empty element that provides a positive indication that a product does not carry any edition information.
     * Intended to be used an ONIX accreditation scheme to confirm that edition information is being consistently
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
     * &lt;ReligiousText&gt; composite may carry either a &lt;Bible&gt; composite or a &lt;ReligiousTextID&gt; element
     * accompanied by multiple repeats of the &lt;ReligiousTextFeature&gt; composite. This approach is adopted to enable
     * other devotional texts to be included if need arises without requiring a new ONIX release.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public ReligiousText religiousText() {
        _initialize();
        return religiousText;
    }

    private OriginalLanguage originalLanguage = OriginalLanguage.EMPTY;

    /**
     * <p>
     * A code indicating the language from which the text of the product was translated. Optional and non-repeating.
     * <strong>The &lt;Language&gt; composite on the next page provides a more general method of handling language
     * detail, and is to be preferred.</strong>
     * </p>
     * Jonix-Comment: this field is optional
     */
    public OriginalLanguage originalLanguage() {
        _initialize();
        return originalLanguage;
    }

    private NumberOfPages numberOfPages = NumberOfPages.EMPTY;

    /**
     * <p>
     * An indication of the total number of pages in a book or other printed product. This is not intended to represent
     * a precise count of numbered and unnumbered pages. It is usually sufficient to take the number from the last
     * numbered page. If there are two or more separate numbering sequences (<em>eg</em> xviii + 344), the numbers in
     * each sequence may be added together to make an overall total (in this case 362), but do not count unnumbered
     * pages except if the book does not have numbered pages at all.
     * </p>
     * <p>
     * For multi-volume books, enter the total for all the volumes combined.
     * </p>
     * <p>
     * This field is optional, but it is normally required for a printed book unless the &lt;PagesRoman&gt; and
     * &lt;PagesArabic&gt; elements are used, and is non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public NumberOfPages numberOfPages() {
        _initialize();
        return numberOfPages;
    }

    private PagesRoman pagesRoman = PagesRoman.EMPTY;

    /**
     * <p>
     * The number of pages numbered in roman numerals. The &lt;PagesRoman&gt; and &lt;PagesArabic&gt; elements together
     * represent an alternative to &lt;NumberOfPages&gt; where there is a requirement to specify these numbering
     * sequences separately. For most ONIX applications, however, &lt;NumberOfPages&gt; will be preferred. Optional and
     * non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public PagesRoman pagesRoman() {
        _initialize();
        return pagesRoman;
    }

    private PagesArabic pagesArabic = PagesArabic.EMPTY;

    /**
     * <p>
     * The number of pages numbered in Arabic numerals. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public PagesArabic pagesArabic() {
        _initialize();
        return pagesArabic;
    }

    private NumberOfIllustrations numberOfIllustrations = NumberOfIllustrations.EMPTY;

    /**
     * <p>
     * The total number of illustrations in a book or other printed product. The more informative free text field
     * &lt;IllustrationsNote&gt; or the &lt;Illustrations&gt; composite are preferred, but where the sender of the
     * product information maintains only a simple numeric field, the &lt;NumberOfIllustrations&gt; element may be used.
     * Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public NumberOfIllustrations numberOfIllustrations() {
        _initialize();
        return numberOfIllustrations;
    }

    private IllustrationsNote illustrationsNote = IllustrationsNote.EMPTY;

    /**
     * <p>
     * For books or other text media only, this data element carries text stating the number and type of illustrations.
     * The text may also include other content items, <em>eg</em> maps, bibliography, tables, index <em>etc</em>.
     * Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public IllustrationsNote illustrationsNote() {
        _initialize();
        return illustrationsNote;
    }

    private BASICMainSubject basicMainSubject = BASICMainSubject.EMPTY;

    /**
     * <p>
     * A BISAC subject category code which identifies the main subject of the product. Optional and non-repeating.
     * Additional BISAC subject category codes may be sent using the &lt;Subject&gt; composite. <em>Note that the data
     * element reference name was assigned during a period when the BISAC name had been changed to “BASIC”. The name has
     * now officially reverted to “BISAC”, but the ONIX data element name cannot be changed for reasons of upwards
     * compatibility.</em>
     * </p>
     * Jonix-Comment: this field is optional
     */
    public BASICMainSubject basicMainSubject() {
        _initialize();
        return basicMainSubject;
    }

    private BASICVersion basicVersion = BASICVersion.EMPTY;

    /**
     * <p>
     * A number identifying the version of the BISAC subject categories used in &lt;BASICMainSubject&gt;. Optional and
     * non-repeating, and may only occur when &lt;BASICMainSubject&gt; is also present.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public BASICVersion basicVersion() {
        _initialize();
        return basicVersion;
    }

    private BICMainSubject bicMainSubject = BICMainSubject.EMPTY;

    /**
     * <p>
     * A BIC subject category code which identifies the main subject of the product. Optional and non-repeating.
     * Additional BIC subject category codes may be sent using the &lt;Subject&gt; composite.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public BICMainSubject bicMainSubject() {
        _initialize();
        return bicMainSubject;
    }

    private BICVersion bicVersion = BICVersion.EMPTY;

    /**
     * <p>
     * A number identifying the version of the BIC subject category scheme used in &lt;BICMainSubject&gt;. Optional and
     * non-repeating, and may only occur when &lt;BICMainSubject&gt; is also present.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public BICVersion bicVersion() {
        _initialize();
        return bicVersion;
    }

    private USSchoolGrade usSchoolGrade = USSchoolGrade.EMPTY;

    /**
     * <p>
     * A text element specifying a US school Grade or range of Grades, which should be entered strictly according to the
     * conventions defined below. Optional and non-repeating. <strong>The &lt;AudienceRange&gt; composite on the next
     * page provides a more general method of handling grade and other ranges, and is to be preferred.</strong>
     * </p>
     * Jonix-Comment: this field is optional
     */
    public USSchoolGrade usSchoolGrade() {
        _initialize();
        return usSchoolGrade;
    }

    private InterestAge interestAge = InterestAge.EMPTY;

    /**
     * <p>
     * A text element specifying a target interest age of range of ages. which should be entered strictly according to
     * the conventions defined below. Optional and non-repeating. <strong>The &lt;AudienceRange&gt; composite on the
     * next page provides a more general method of handling interest age and other ranges, and is to be
     * preferred.</strong>
     * </p>
     * Jonix-Comment: this field is optional
     */
    public InterestAge interestAge() {
        _initialize();
        return interestAge;
    }

    private AudienceDescription audienceDescription = AudienceDescription.EMPTY;

    /**
     * <p>
     * Free text describing the audience for which a product is intended. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public AudienceDescription audienceDescription() {
        _initialize();
        return audienceDescription;
    }

    private Annotation annotation = Annotation.EMPTY;

    /**
     * <p>
     * A brief descriptive paragraph about the product, length strictly limited to 350 characters. Optional and
     * non-repeating. <strong>The &lt;OtherText&gt; composite on the next page provides a more general method of
     * handling annotations, and is to be preferred.</strong>
     * </p>
     * <p>
     * The &lt;Annotation&gt; element may carry any of the following ONIX attributes: <i>textformat, language,
     * transliteration, textcase</i>.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public Annotation annotation() {
        _initialize();
        return annotation;
    }

    private MainDescription mainDescription = MainDescription.EMPTY;

    /**
     * <p>
     * Descriptive text about the product, audience unspecified. Optional and non-repeating.
     * </p>
     * <p>
     * <strong>The &lt;OtherText&gt; composite on the next page provides a more general method of handling descriptions,
     * and is to be preferred.</strong>
     * </p>
     * <p>
     * The &lt;MainDescription&gt; element may carry any of the following ONIX attributes: <i>textformat, language,
     * transliteration, textcase</i>.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public MainDescription mainDescription() {
        _initialize();
        return mainDescription;
    }

    private CoverImageFormatCode coverImageFormatCode = CoverImageFormatCode.EMPTY;

    /**
     * <p>
     * An ONIX code which specifies the image file format used for the front cover image. JPEG, GIF and TIF are
     * supported. The data element group consisting of &lt;CoverImageFormatCode&gt;, &lt;CoverImageLinkTypeCode&gt;, and
     * &lt;CoverImageLink&gt; is optional and non-repeating, but if any one of the three elements is present, all three
     * must be present.
     * </p>
     * <p>
     * <strong>The &lt;MediaFile&gt; composite on the next page provides a more general method of handling cover images,
     * and is to be preferred.</strong>
     * </p>
     * Jonix-Comment: this field is optional
     */
    public CoverImageFormatCode coverImageFormatCode() {
        _initialize();
        return coverImageFormatCode;
    }

    private CoverImageLinkTypeCode coverImageLinkTypeCode = CoverImageLinkTypeCode.EMPTY;

    /**
     * <p>
     * An ONIX code which identifies the type of link which is given in &lt;CoverImageLink&gt;.
     * </p>
     * <p>
     * The &lt;MediaFile&gt; composite on the next page provides a more general method of handling cover images, and is
     * to be preferred.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public CoverImageLinkTypeCode coverImageLinkTypeCode() {
        _initialize();
        return coverImageLinkTypeCode;
    }

    private CoverImageLink coverImageLink = CoverImageLink.EMPTY;

    /**
     * <p>
     * A link to a front cover image file, using the link type specified in &lt;CoverImageLinkTypeCode&gt;.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public CoverImageLink coverImageLink() {
        _initialize();
        return coverImageLink;
    }

    private PrizesDescription prizesDescription = PrizesDescription.EMPTY;

    /**
     * <p>
     * Free text describing prizes or awards which the product has received. Optional and non-repeating. If this field
     * is used, the &lt;Prize&lt; composite must not be used; and vice versa.
     * </p>
     * <p>
     * <strong>The &lt;Prize&gt; composite below provides a more general method of handling prizes, and is to be
     * preferred.</strong>
     * </p>
     * Jonix-Comment: this field is optional
     */
    public PrizesDescription prizesDescription() {
        _initialize();
        return prizesDescription;
    }

    private PublisherName publisherName = PublisherName.EMPTY;

    /**
     * <p>
     * The full name of the publisher who issues the product, in the form in which the publisher wishes to be
     * identified, and controlled by the publisher to maintain consistency across products. Optional and non-repeating;
     * and should not be used if the &lt;Publisher&gt; composite is used. Except where they are essential to the
     * recognized form of the name, it is recommended that suffixes denoting incorporation (“Co”, “Inc”, “Ltd”, “SA”,
     * “GmbH”) should be omitted.
     * </p>
     * <p>
     * <strong>The &lt;Publisher&gt; composite below provides a more general method of handling publisher identities,
     * and is to be preferred.</strong>
     * </p>
     * Jonix-Comment: this field is optional
     */
    public PublisherName publisherName() {
        _initialize();
        return publisherName;
    }

    private CountryOfPublication countryOfPublication = CountryOfPublication.EMPTY;

    /**
     * <p>
     * A code identifying the country where the product is issued. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public CountryOfPublication countryOfPublication() {
        _initialize();
        return countryOfPublication;
    }

    private OriginalPublisher originalPublisher = OriginalPublisher.EMPTY;

    /**
     * <p>
     * The name of the publisher of the original-language version of a translated work. Except where they are essential
     * to the recognized form of the name, it is recommended that suffixes denoting incorporation (“Co”, “Inc”, “Ltd”,
     * “SA”, “GmbH”) should be omitted. Optional and non-repeating.
     * </p>
     * <p>
     * <strong>The &lt;Publisher&gt; composite on preceding pages provides a more general method of handling publisher
     * identities, and is to be preferred.</strong>
     * </p>
     * Jonix-Comment: this field is optional
     */
    public OriginalPublisher originalPublisher() {
        _initialize();
        return originalPublisher;
    }

    private PublishingStatus publishingStatus = PublishingStatus.EMPTY;

    /**
     * <p>
     * An ONIX code which identifies the status of a published product. Optional and non-repeating, <strong>but it is
     * very strongly recommended that this element should be included in all ONIX Books Product records, and it is
     * possible that it may be made mandatory in a future release, or that it will be treated as mandatory in national
     * ONIX accreditation schemes.</strong>
     * </p>
     * <p>
     * Where the element is sent by a sender who is not the publisher, based on information that has been previously
     * supplied by the publisher, it is strongly recommended that the element should carry a datestamp attribute to
     * indicate its likely reliability. See <cite>ONIX for Books – Product Information Message – XML Message
     * Specification</cite>, Section 4, for details of the datestamp attribute.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public PublishingStatus publishingStatus() {
        _initialize();
        return publishingStatus;
    }

    private PublishingStatusNote publishingStatusNote = PublishingStatusNote.EMPTY;

    /**
     * <p>
     * Free text that describes the status of a published product, when the code in &lt;PublishingStatus&gt; is
     * insufficient. Optional and non-repeating, but must be accompanied by the &lt;PublishingStatus&gt; element.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public PublishingStatusNote publishingStatusNote() {
        _initialize();
        return publishingStatusNote;
    }

    private AnnouncementDate announcementDate = AnnouncementDate.EMPTY;

    /**
     * <p>
     * Date when information about the product can be issued to the general public. (Some publishers issue advance
     * information under embargo.) Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public AnnouncementDate announcementDate() {
        _initialize();
        return announcementDate;
    }

    private TradeAnnouncementDate tradeAnnouncementDate = TradeAnnouncementDate.EMPTY;

    /**
     * <p>
     * Date when information about the product can be issued to the book trade, while remaining embargoed for the
     * general public. (Some publishers issue advance information under embargo.) Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public TradeAnnouncementDate tradeAnnouncementDate() {
        _initialize();
        return tradeAnnouncementDate;
    }

    private PublicationDate publicationDate = PublicationDate.EMPTY;

    /**
     * <p>
     * The date of first publication of this product in the home market of the publisher named in PR.19 (that is, under
     * the current ISBN or other identifier, as distinct from the date of first publication of the work, which may be
     * given in &lt;YearFirstPublished&gt; on the next page). In advance information, this will be an expected date,
     * which should be replaced by the actual date of publication when known. The date should be given as precisely as
     * possible, but in early notifications a month and year are sufficient; and for backlist titles the year of
     * publication is sufficient.
     * </p>
     * <p>
     * Note that in advance information this date must not be interpreted as the date when the product will first be
     * available in a territory other than the publisher’s home market. See the &lt;SupplyDetail&gt; and
     * &lt;MarketRepresentation&gt; composites, Groups PR.24 and PR.25, for other market-specific detail.
     * </p>
     * <p>
     * Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public PublicationDate publicationDate() {
        _initialize();
        return publicationDate;
    }

    private CopyrightYear copyrightYear = CopyrightYear.EMPTY;

    /**
     * <p>
     * The copyright year as it appears in a copyright statement on the product. If several years are listed, use the
     * most recent. Optional and non-repeating, and may not occur if the &lt;CopyrightStatement&gt; composite is
     * present.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public CopyrightYear copyrightYear() {
        _initialize();
        return copyrightYear;
    }

    private YearFirstPublished yearFirstPublished = YearFirstPublished.EMPTY;

    /**
     * <p>
     * The year when the work first appeared in any language or edition, if different from the copyright year. Optional
     * and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public YearFirstPublished yearFirstPublished() {
        _initialize();
        return yearFirstPublished;
    }

    private Width width = Width.EMPTY;

    /**
     * <p>
     * The overall width of the product: in the case of a book, the cover or case width, in the units specified in the
     * message header, &lt;DefaultLinearUnit&gt; field, defined in the <cite>ONIX for Books – Product Information
     * Message – XML Message Specification</cite>. Optional and non-repeating. <strong>The &lt;Measure&gt; composite on
     * a previous page provides a more general method of handling measurements, and is to be preferred.</strong>
     * </p>
     * Jonix-Comment: this field is optional
     */
    public Width width() {
        _initialize();
        return width;
    }

    private Thickness thickness = Thickness.EMPTY;

    /**
     * <p>
     * The overall thickness of the product: in the case of a book, the spine thickness, in the units specified in the
     * message header, &lt;DefaultLinearUnit&gt; field, defined in the <cite>ONIX for Books – Product Information
     * Message – XML Message Specification</cite>. Optional and non-repeating. <strong>The &lt;Measure&gt; composite on
     * a previous page provides a more general method of handling measurements, and is to be preferred.</strong>
     * </p>
     * Jonix-Comment: this field is optional
     */
    public Thickness thickness() {
        _initialize();
        return thickness;
    }

    private Weight weight = Weight.EMPTY;

    /**
     * <p>
     * The weight of a single unit of the product, in the units specified in the message header,
     * &lt;DefaultWeightUnit&gt; field, defined in the <cite>ONIX for Books – Product Information Message – XML Message
     * Specification</cite>. Optional and non-repeating. <strong>The &lt;Measure&gt; composite on a previous page
     * provides a more general method of handling weights, and is to be preferred.</strong>
     * </p>
     * Jonix-Comment: this field is optional
     */
    public Weight weight() {
        _initialize();
        return weight;
    }

    private Dimensions dimensions = Dimensions.EMPTY;

    /**
     * <p>
     * Where a legacy system has no structured data for product dimensions, but has a free text statement, this field
     * allows such a statement to be sent. However, this practise is deprecated: structured information is always
     * greatly to be preferred. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public Dimensions dimensions() {
        _initialize();
        return dimensions;
    }

    private ReplacedByISBN replacedByISBN = ReplacedByISBN.EMPTY;

    /**
     * <p>
     * International Standard Book Number identifying a new product which replaces the current product. Optional and
     * non-repeating. <strong>The &lt;RelatedProduct&gt; composite on a later page provides a more general method of
     * handling related items, and is to be preferred.</strong>
     * </p>
     * Jonix-Comment: this field is optional
     */
    public ReplacedByISBN replacedByISBN() {
        _initialize();
        return replacedByISBN;
    }

    private ReplacedByEAN13 replacedByEAN13 = ReplacedByEAN13.EMPTY;

    /**
     * <p>
     * The EAN-13 article number of a new product which replaces the current product. Optional and non-repeating.
     * <strong>The &lt;RelatedProduct&gt; composite on a later page provides a more general method of handling related
     * items, and is to be preferred.</strong>
     * </p>
     * Jonix-Comment: this field is optional
     */
    public ReplacedByEAN13 replacedByEAN13() {
        _initialize();
        return replacedByEAN13;
    }

    private AlternativeFormatISBN alternativeFormatISBN = AlternativeFormatISBN.EMPTY;

    /**
     * <p>
     * International Standard Book Number identifying an alternative format in which the product is available. Optional
     * and non-repeating. <strong>The &lt;RelatedProduct&gt; composite on a later page provides a more general method of
     * handling related items, and is to be preferred.</strong>
     * </p>
     * Jonix-Comment: this field is optional
     */
    public AlternativeFormatISBN alternativeFormatISBN() {
        _initialize();
        return alternativeFormatISBN;
    }

    private AlternativeFormatEAN13 alternativeFormatEAN13 = AlternativeFormatEAN13.EMPTY;

    /**
     * <p>
     * EAN-13 article number identifying an alternative format in which the product is available. Optional and
     * non-repeating. <strong>The &lt;RelatedProduct&gt; composite on a later page provides a more general method of
     * handling related items, and is to be preferred.</strong>
     * </p>
     * Jonix-Comment: this field is optional
     */
    public AlternativeFormatEAN13 alternativeFormatEAN13() {
        _initialize();
        return alternativeFormatEAN13;
    }

    private AlternativeProductISBN alternativeProductISBN = AlternativeProductISBN.EMPTY;

    /**
     * <p>
     * International Standard Book Number identifying another product which is available and which the publisher
     * suggests as an alternative. This element is used when the suggested alternative is neither a direct successor
     * (new edition) nor the same product in an alternative format. Optional and non-repeating. <strong>The
     * &lt;RelatedProduct&gt; composite on a later page provides a more general method of handling related items, and is
     * to be preferred.</strong>
     * </p>
     * Jonix-Comment: this field is optional
     */
    public AlternativeProductISBN alternativeProductISBN() {
        _initialize();
        return alternativeProductISBN;
    }

    private AlternativeProductEAN13 alternativeProductEAN13 = AlternativeProductEAN13.EMPTY;

    /**
     * <p>
     * EAN-13 article number identifying another product which is available and which the publisher suggests as an
     * alternative. This element is used when the suggested alternative is neither a direct successor (new edition) nor
     * the same product in an alternative format. Optional and non-repeating. <strong>The &lt;RelatedProduct&gt;
     * composite on a later page provides a more general method of handling related items, and is to be
     * preferred.</strong>
     * </p>
     * Jonix-Comment: this field is optional
     */
    public AlternativeProductEAN13 alternativeProductEAN13() {
        _initialize();
        return alternativeProductEAN13;
    }

    private OutOfPrintDate outOfPrintDate = OutOfPrintDate.EMPTY;

    /**
     * <p>
     * The date on which the publisher put the current product out-of-print. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public OutOfPrintDate outOfPrintDate() {
        _initialize();
        return outOfPrintDate;
    }

    private PromotionCampaign promotionCampaign = PromotionCampaign.EMPTY;

    /**
     * <p>
     * Free text describing the promotion and adverting campaign for the product. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public PromotionCampaign promotionCampaign() {
        _initialize();
        return promotionCampaign;
    }

    private PromotionContact promotionContact = PromotionContact.EMPTY;

    /**
     * <p>
     * Free text giving the name, department, phone number, email address <em>etc</em> for a promotional contact person
     * for the product. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public PromotionContact promotionContact() {
        _initialize();
        return promotionContact;
    }

    private InitialPrintRun initialPrintRun = InitialPrintRun.EMPTY;

    /**
     * <p>
     * In advance information about a new book, free text detailing the number of copies which will be printed and any
     * related aspects of the initial publishing effort. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public InitialPrintRun initialPrintRun() {
        _initialize();
        return initialPrintRun;
    }

    private CopiesSold copiesSold = CopiesSold.EMPTY;

    /**
     * <p>
     * Free text detailing the number of copies already sold, <em>eg</em> for a new paperback, the copies sold in
     * hardback. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public CopiesSold copiesSold() {
        _initialize();
        return copiesSold;
    }

    private BookClubAdoption bookClubAdoption = BookClubAdoption.EMPTY;

    /**
     * <p>
     * Free text describing the adoption of the product as a book club selection. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public BookClubAdoption bookClubAdoption() {
        _initialize();
        return bookClubAdoption;
    }

    private ListOfOnixDataCompositeWithKey<ProductIdentifier, JonixProductIdentifier,
        ProductIdentifierTypes> productIdentifiers = JPU.emptyListOfOnixDataCompositeWithKey(ProductIdentifier.class);

    /**
     * <p>
     * A repeatable group of data elements which together define the identifier of a product in accordance with a
     * specified scheme, allowing new types of product identifier to be included without defining additional data
     * elements. In particular, the composite allows proprietary identifiers (SKUs) assigned by wholesalers or vendors
     * to be sent as part of the ONIX record.
     * </p>
     * <p>
     * To support the transition from ten-character ISBNs to 13-digit ISBNs, effective from 1 January 2007, there are
     * distinct &lt;ProductIDType&gt; codes for ISBN-10 and ISBN-13, as well as for EAN.UCC-13.
     * </p>
     * <p>
     * ISBN-13 numbers in their unhyphenated form constitute a range of EAN.UCC-13 numbers that has been reserved for
     * the international book trade. It has been agreed by ONIX national groups that it will be mandatory in an ONIX
     * &lt;Product&gt; record for any item carrying an ISBN-13 to include the ISBN-13 labelled as an EAN.UCC number
     * (ProductIDType code 03), since this is how the ISBN-13 will be universally used in trading transactions. For many
     * ONIX applications this will also be sufficient.
     * </p>
     * <p>
     * For some ONIX applications, however, particularly when data is to be supplied to the library sector, there may be
     * reasons why the ISBN-13 must also be sent labelled distinctively as an ISBN-13 (ProductIDType code 15); or, if
     * the item also has an ISBN-10, why it may still be desirable to send the ISBN-10 even after the end of 2006. Users
     * should consult national “good practice” guidelines and/or discuss with their trading partners.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<ProductIdentifier, JonixProductIdentifier, ProductIdentifierTypes>
        productIdentifiers() {
        _initialize();
        return productIdentifiers;
    }

    private ListOfOnixCodelist<Barcode, BarcodeIndicatorsList6> barcodes = ListOfOnixCodelist.emptyList();

    /**
     * <p>
     * An ONIX code indicating whether a product is bar-coded. Optional, and repeatable if the product carries two or
     * more barcodes from different schemes. The absence of this field does NOT mean that a product is not bar-coded.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixCodelist<Barcode, BarcodeIndicatorsList6> barcodes() {
        _initialize();
        return barcodes;
    }

    private ListOfOnixCodelist<ProductFormDetail, ProductFormDetailsList78> productFormDetails =
        ListOfOnixCodelist.emptyList();

    /**
     * <p>
     * An ONIX code which provides added detail of the medium and/or format of the product. Optional and repeatable.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixCodelist<ProductFormDetail, ProductFormDetailsList78> productFormDetails() {
        _initialize();
        return productFormDetails;
    }

    private ListOfOnixDataCompositeWithKey<ProductFormFeature, JonixProductFormFeature,
        ProductFormFeatureTypes> productFormFeatures =
            JPU.emptyListOfOnixDataCompositeWithKey(ProductFormFeature.class);

    /**
     * <p>
     * A repeatable group of data elements which together describe an aspect of product form that is too specific to be
     * covered in the &lt;ProductForm&gt; and &lt;ProductFormDetail&gt; elements. Optional.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<ProductFormFeature, JonixProductFormFeature, ProductFormFeatureTypes>
        productFormFeatures() {
        _initialize();
        return productFormFeatures;
    }

    private ListOfOnixCodelist<BookFormDetail, BookFormDetails> bookFormDetails = ListOfOnixCodelist.emptyList();

    /**
     * <p>
     * An ONIX code specifying more detail of the product format when the product is a book. Repeatable when two or more
     * coded characteristics apply. This field is optional, but must only be included when the code in the
     * &lt;ProductForm&gt; element begins with letter B. <strong>This field will be superseded by the new element
     * &lt;ProductFormDetail&gt;, and the code list will not be further developed. The field is retained only for
     * purposes of upwards compatibility, and its use is now to be deprecated.</strong>
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixCodelist<BookFormDetail, BookFormDetails> bookFormDetails() {
        _initialize();
        return bookFormDetails;
    }

    private ListOfOnixCodelist<ProductContentType, ProductContentTypes> productContentTypes =
        ListOfOnixCodelist.emptyList();

    /**
     * <p>
     * An ONIX code which indicates certain types of content which are closely related to but not strictly an attribute
     * of product form, <em>eg</em> audiobook. Optional and repeatable. The element is intended to be used with products
     * where content is delivered in the form of a digital or analogue recording. It is not expected to be used for
     * books.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixCodelist<ProductContentType, ProductContentTypes> productContentTypes() {
        _initialize();
        return productContentTypes;
    }

    private ListOfOnixComposite<ContainedItem> containedItems = JPU.emptyListOfOnixComposite(ContainedItem.class);

    /**
     * <p>
     * A repeatable group of data elements which together describe an item which is part of or contained within the
     * current product. The composite may be used to specify the item(s) and item quantity/ies carried in a dumpbin, or
     * included in (eg) a classroom pack, or simply to state the product forms contained within a mixed media product,
     * without specifying their identifiers or quantity. The composite is used only when the product form coding for the
     * product as a whole indicates that the product includes two or more different items, or multiple copies of the
     * same item.
     * </p>
     * <p>
     * Each instance of the &lt;ContainedItem&gt; composite must carry at least either a product identifier, or a
     * product form code, or both. In other words, it is valid to send an instance of the composite with an identifier
     * and no product form code, or with a product form code and no identifier.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixComposite<ContainedItem> containedItems() {
        _initialize();
        return containedItems;
    }

    private ListOfOnixDataCompositeWithKey<ProductClassification, JonixProductClassification,
        ProductClassificationTypes> productClassifications =
            JPU.emptyListOfOnixDataCompositeWithKey(ProductClassification.class);

    /**
     * <p>
     * A repeatable group of data elements which together define a product classification (NOT to be confused with a
     * subject classification). The intended use is to enable national or international trade classifications (aka
     * commodity codes) to be carried in an ONIX record.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<ProductClassification, JonixProductClassification, ProductClassificationTypes>
        productClassifications() {
        _initialize();
        return productClassifications;
    }

    private ListOfOnixComposite<Series> seriess = JPU.emptyListOfOnixComposite(Series.class);

    /**
     * <p>
     * A repeatable group of data elements which together describe a series of which the product is part.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixComposite<Series> seriess() {
        _initialize();
        return seriess;
    }

    private ListOfOnixComposite<Set> sets = JPU.emptyListOfOnixComposite(Set.class);

    /**
     * <p>
     * A repeatable group of data elements which together describe a set of which the product is part.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixComposite<Set> sets() {
        _initialize();
        return sets;
    }

    private ListOfOnixElement<FormerTitle, String> formerTitles = ListOfOnixElement.empty();

    /**
     * <p>
     * A different title under which the work was previously published, without abbreviation or abridgement. Optional,
     * and repeatable if the work has had more than one former title. <strong>The &lt;Title&gt; composite below provides
     * a more general method of handling all forms of title, and is to be preferred.</strong>
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<FormerTitle, String> formerTitles() {
        _initialize();
        return formerTitles;
    }

    private ListOfOnixDataCompositeWithKey<Title, JonixTitle, TitleTypes> titles =
        JPU.emptyListOfOnixDataCompositeWithKey(Title.class);

    /**
     * <p>
     * A repeatable group of data elements which together give the text of a title and specify its type. The composite
     * may also be used to send a title which has been abbreviated where necessary to keep it within a specified maximum
     * length. Any occurrence of the &lt;Title&gt; composite must include one of the following: &lt;TitleText&gt; only,
     * &lt;TitlePrefix&gt; with &lt;TitleWithoutPrefix&gt;, &lt;TitleText&gt; and &lt;TitlePrefix&gt; with
     * &lt;TitleWithoutPrefix&gt;. If there is a subtitle, it should not be sent as part of the title text, but as a
     * separate &lt;Subtitle&gt; element, The &lt;Title&gt; element may carry any of the following ONIX attributes:
     * <i>textformat, language, transliteration, textcase,</i> where these are shared by all text elements within the
     * composite.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<Title, JonixTitle, TitleTypes> titles() {
        _initialize();
        return titles;
    }

    private ListOfOnixDataCompositeWithKey<WorkIdentifier, JonixWorkIdentifier, WorkIdentifierTypes> workIdentifiers =
        JPU.emptyListOfOnixDataCompositeWithKey(WorkIdentifier.class);

    /**
     * <p>
     * A group of data elements which together define the identifier of a work which is manifested in the product
     * described by an ONIX &lt;Product&gt; record. Optional and repeatable.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<WorkIdentifier, JonixWorkIdentifier, WorkIdentifierTypes> workIdentifiers() {
        _initialize();
        return workIdentifiers;
    }

    private ListOfOnixDataComposite<Website, JonixWebsite> websites = JPU.emptyListOfOnixDataComposite(Website.class);

    /**
     * <p>
     * A repeatable group of data elements which together identify and provide pointers to a website which is related to
     * the work identified in an occurrence of the &lt;WorkIdentifier&gt; composite.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataComposite<Website, JonixWebsite> websites() {
        _initialize();
        return websites;
    }

    private ListOfOnixComposite<Conference> conferences = JPU.emptyListOfOnixComposite(Conference.class);

    /**
     * <p>
     * A group of data elements which together describe a conference to which the product is related. Repeatable if the
     * product contains material from two or more conferences.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixComposite<Conference> conferences() {
        _initialize();
        return conferences;
    }

    private ListOfOnixCodelist<EditionTypeCode, EditionTypes> editionTypeCodes = ListOfOnixCodelist.emptyList();

    /**
     * <p>
     * An ONIX code, indicating the type of a version or edition. Optional, and repeatable if the product has
     * characteristics of two or more types (<em>eg</em> revised and annotated).
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixCodelist<EditionTypeCode, EditionTypes> editionTypeCodes() {
        _initialize();
        return editionTypeCodes;
    }

    private ListOfOnixCodelist<LanguageOfText, Languages> languageOfTexts = ListOfOnixCodelist.emptyList();

    /**
     * <p>
     * A code indicating a language in which the text of the product is written: optional, and repeatable if the text is
     * in two or more languages. <strong>The &lt;Language&gt; composite on the next page provides a more general method
     * of handling language detail, and is to be preferred.</strong>
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixCodelist<LanguageOfText, Languages> languageOfTexts() {
        _initialize();
        return languageOfTexts;
    }

    private ListOfOnixDataCompositeWithKey<Language, JonixLanguage, LanguageRoles> languages =
        JPU.emptyListOfOnixDataCompositeWithKey(Language.class);

    /**
     * <p>
     * A repeatable group of data elements which together represent a language, and specify its role and, where
     * required, whether it is a country variant.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<Language, JonixLanguage, LanguageRoles> languages() {
        _initialize();
        return languages;
    }

    private ListOfOnixDataCompositeWithKey<Extent, JonixExtent, ExtentTypes> extents =
        JPU.emptyListOfOnixDataCompositeWithKey(Extent.class);

    /**
     * <p>
     * A repeatable group of data elements which together describe an extent pertaining to the product.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<Extent, JonixExtent, ExtentTypes> extents() {
        _initialize();
        return extents;
    }

    private ListOfOnixDataCompositeWithKey<Illustrations, JonixIllustrations,
        IllustrationAndOtherContentTypes> illustrationss = JPU.emptyListOfOnixDataCompositeWithKey(Illustrations.class);

    /**
     * <p>
     * A repeatable group of data elements which together specify the number of illustrations or other content items of
     * a stated type which the product carries. Use of the &lt;Illustrations&gt; composite is optional.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<Illustrations, JonixIllustrations, IllustrationAndOtherContentTypes>
        illustrationss() {
        _initialize();
        return illustrationss;
    }

    private ListOfOnixElement<MapScale, String> mapScales = ListOfOnixElement.empty();

    /**
     * <p>
     * The scale of a map, expressed as a ratio 1:nnnnn; only the number nnnnn is carried in the data element, without
     * spaces or punctuation. Optional, and repeatable if the product comprises maps with two or more different scales.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<MapScale, String> mapScales() {
        _initialize();
        return mapScales;
    }

    private ListOfOnixDataComposite<MainSubject, JonixMainSubject> mainSubjects =
        JPU.emptyListOfOnixDataComposite(MainSubject.class);

    /**
     * <p>
     * An optional and repeatable group of data elements which together describe a main subject classification or
     * subject heading which is taken from a recognized scheme other than BISAC or BIC.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataComposite<MainSubject, JonixMainSubject> mainSubjects() {
        _initialize();
        return mainSubjects;
    }

    private ListOfOnixDataComposite<Subject, JonixSubject> subjects = JPU.emptyListOfOnixDataComposite(Subject.class);

    /**
     * <p>
     * An optional and repeatable group of data elements which together describe a subject classification or subject
     * heading which is additional to the BISAC, BIC or other main subject category.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataComposite<Subject, JonixSubject> subjects() {
        _initialize();
        return subjects;
    }

    private ListOfOnixComposite<PersonAsSubject> personAsSubjects = JPU.emptyListOfOnixComposite(PersonAsSubject.class);

    /**
     * <p>
     * An optional and repeatable group of data elements which together represent the name of a person who is part of
     * the subject of a product.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixComposite<PersonAsSubject> personAsSubjects() {
        _initialize();
        return personAsSubjects;
    }

    private ListOfOnixElement<CorporateBodyAsSubject, String> corporateBodyAsSubjects = ListOfOnixElement.empty();

    /**
     * <p>
     * The name of a corporate body which is part of the subject of the product. Optional, and repeatable if more than
     * one corporate body is involved.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<CorporateBodyAsSubject, String> corporateBodyAsSubjects() {
        _initialize();
        return corporateBodyAsSubjects;
    }

    private ListOfOnixElement<PlaceAsSubject, String> placeAsSubjects = ListOfOnixElement.empty();

    /**
     * <p>
     * The name of a place or region or geographical entity which is part of the subject of the product. Optional, and
     * repeatable if the subject of the product includes more than one place.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<PlaceAsSubject, String> placeAsSubjects() {
        _initialize();
        return placeAsSubjects;
    }

    private ListOfOnixCodelist<AudienceCode, AudienceTypes> audienceCodes = ListOfOnixCodelist.emptyList();

    /**
     * <p>
     * An ONIX code, derived from BISAC and BIC lists, which identifies the broad audience or readership for whom a
     * product is intended. Optional, and repeatable if the product is intended for two or more groups.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixCodelist<AudienceCode, AudienceTypes> audienceCodes() {
        _initialize();
        return audienceCodes;
    }

    private ListOfOnixDataCompositeWithKey<Audience, JonixAudience, AudienceCodeTypes> audiences =
        JPU.emptyListOfOnixDataCompositeWithKey(Audience.class);

    /**
     * <p>
     * A repeatable group of data elements which together describe an audience to which the product is directed.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<Audience, JonixAudience, AudienceCodeTypes> audiences() {
        _initialize();
        return audiences;
    }

    private ListOfOnixDataComposite<AudienceRange, JonixAudienceRange> audienceRanges =
        JPU.emptyListOfOnixDataComposite(AudienceRange.class);

    /**
     * <p>
     * An optional and repeatable group of data elements which together describe an audience or readership range for
     * which a product is intended. The composite can carry a single value from, to, or exact, or a pair of values with
     * an explicit from and to. See examples below.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataComposite<AudienceRange, JonixAudienceRange> audienceRanges() {
        _initialize();
        return audienceRanges;
    }

    private ListOfOnixDataComposite<Complexity, JonixComplexity> complexitys =
        JPU.emptyListOfOnixDataComposite(Complexity.class);

    /**
     * <p>
     * An optional and repeatable group of data elements which together describe the level of complexity of a text.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataComposite<Complexity, JonixComplexity> complexitys() {
        _initialize();
        return complexitys;
    }

    private ListOfOnixDataCompositeWithKey<OtherText, JonixOtherText, OtherTextTypes> otherTexts =
        JPU.emptyListOfOnixDataCompositeWithKey(OtherText.class);

    /**
     * <p>
     * An optional and repeatable group of data elements which together identify and either include, or provide pointers
     * to, text related to the product.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<OtherText, JonixOtherText, OtherTextTypes> otherTexts() {
        _initialize();
        return otherTexts;
    }

    private ListOfOnixElement<ReviewQuote, String> reviewQuotes = ListOfOnixElement.empty();

    /**
     * <p>
     * A free text excerpt from a review. Optional and repeatable. At the end of the text of the quote, the authorship,
     * source title, and date (if known) should always be included.
     * </p>
     * <p>
     * <strong>The &lt;OtherText&gt; composite on preceding pages provides a more general method of handling review
     * quotes, and is to be preferred.</strong>
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<ReviewQuote, String> reviewQuotes() {
        _initialize();
        return reviewQuotes;
    }

    private ListOfOnixDataCompositeWithKey<MediaFile, JonixMediaFile, ImageAudioVideoFileTypes> mediaFiles =
        JPU.emptyListOfOnixDataCompositeWithKey(MediaFile.class);

    /**
     * <p>
     * A repeatable group of data elements which together identify and provide pointers to, an image, audio or video
     * file related to the product.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<MediaFile, JonixMediaFile, ImageAudioVideoFileTypes> mediaFiles() {
        _initialize();
        return mediaFiles;
    }

    private ListOfOnixDataComposite<ProductWebsite, JonixProductWebsite> productWebsites =
        JPU.emptyListOfOnixDataComposite(ProductWebsite.class);

    /**
     * <p>
     * An optional and repeatable group of data elements which together identify and provide pointers to a website which
     * is related to the product.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataComposite<ProductWebsite, JonixProductWebsite> productWebsites() {
        _initialize();
        return productWebsites;
    }

    private ListOfOnixDataComposite<Prize, JonixPrize> prizes = JPU.emptyListOfOnixDataComposite(Prize.class);

    /**
     * <p>
     * A repeatable group of data elements which together describe a prize or award won by the product.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataComposite<Prize, JonixPrize> prizes() {
        _initialize();
        return prizes;
    }

    private ListOfOnixComposite<ContentItem> contentItems = JPU.emptyListOfOnixComposite(ContentItem.class);

    /**
     * <p>
     * A repeatable group of data elements which together describe a content item within a product.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixComposite<ContentItem> contentItems() {
        _initialize();
        return contentItems;
    }

    private ListOfOnixComposite<Imprint> imprints = JPU.emptyListOfOnixComposite(Imprint.class);

    /**
     * <p>
     * A repeatable group of data elements which together identify an imprint or brand under which the product is
     * marketed. The composite must carry either a name code or a name or both.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixComposite<Imprint> imprints() {
        _initialize();
        return imprints;
    }

    private ListOfOnixComposite<Publisher> publishers = JPU.emptyListOfOnixComposite(Publisher.class);

    /**
     * <p>
     * A repeatable group of data elements which together identify an entity which is associated with the publishing of
     * a product. The composite will allow additional publishing roles to be introduced without adding new fields. Each
     * occurrence of the composite must carry either a name code or a name or both.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixComposite<Publisher> publishers() {
        _initialize();
        return publishers;
    }

    private ListOfOnixElement<CityOfPublication, String> cityOfPublications = ListOfOnixElement.empty();

    /**
     * <p>
     * The name of a city or town associated with the imprint or publisher. Optional, and repeatable if the imprint
     * carries two or more cities of publication.
     * </p>
     * <p>
     * A place of publication is normally given in the form in which it appears on the title page. If the place name
     * appears in more than one language, use the language of the title carried in the ONIX record. If this criterion
     * does not apply, use the form that appears first. Alternatively, some ONIX applications may follow their own
     * “house style”.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<CityOfPublication, String> cityOfPublications() {
        _initialize();
        return cityOfPublications;
    }

    private ListOfOnixElement<CopublisherName, String> copublisherNames = ListOfOnixElement.empty();

    /**
     * <p>
     * The name of a co-publisher of the product, in the form in which the co-publisher wishes to be identified, and
     * controlled to maintain consistency across products. Except where they are essential to the recognized form of the
     * name, it is recommended that suffixes denoting incorporation (“Co”, “Inc”, “Ltd”, “SA”, “GmbH”) should be
     * omitted. Optional, and repeatable if there are two or more co-publishers.
     * </p>
     * <p>
     * <strong>The &lt;Publisher&gt; composite on preceding pages provides a more general method of handling publisher
     * identities, and is to be preferred.</strong>
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<CopublisherName, String> copublisherNames() {
        _initialize();
        return copublisherNames;
    }

    private ListOfOnixElement<SponsorName, String> sponsorNames = ListOfOnixElement.empty();

    /**
     * <p>
     * The name of a sponsor of the product, in the form in which the sponsor wishes to be identified. Except where they
     * are essential to the recognized form of the name, it is recommended that suffixes denoting incorporation (“Co”,
     * “Inc”, “Ltd”, “SA”, “GmbH”) should be omitted. Optional, and repeatable if there are two or more sponsors.
     * </p>
     * <p>
     * <strong>The &lt;Publisher&gt; composite on preceding pages provides a more general method of handling publisher
     * identities, and is to be preferred.</strong>
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<SponsorName, String> sponsorNames() {
        _initialize();
        return sponsorNames;
    }

    private ListOfOnixComposite<CopyrightStatement> copyrightStatements =
        JPU.emptyListOfOnixComposite(CopyrightStatement.class);

    /**
     * <p>
     * An optional and repeatable group of data elements which together represent a structured copyright statement for
     * the product. Either a structured copyright statement or statements, or a copyright year in the separate
     * &lt;CopyrightYear&gt; element which follows the composite, but not both, may be sent.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixComposite<CopyrightStatement> copyrightStatements() {
        _initialize();
        return copyrightStatements;
    }

    private ListOfOnixComposite<SalesRights> salesRightss = JPU.emptyListOfOnixComposite(SalesRights.class);

    /**
     * <p>
     * A repeatable group of data elements which together identify territorial sales rights which a publisher chooses to
     * exercise in a product. The &lt;SalesRights&gt; composite may occur once for each value of &lt;b089&gt;. See
     * examples at the end of Group&nbsp;PR.21.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixComposite<SalesRights> salesRightss() {
        _initialize();
        return salesRightss;
    }

    private ListOfOnixComposite<NotForSale> notForSales = JPU.emptyListOfOnixComposite(NotForSale.class);

    /**
     * <p>
     * A repeatable group of data elements which together identify a country or countries in which the product is not
     * for sale, together with the ISBN and/or other product identifier and/or the name of the publisher of the same
     * work in the specified country/ies.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixComposite<NotForSale> notForSales() {
        _initialize();
        return notForSales;
    }

    private ListOfOnixComposite<SalesRestriction> salesRestrictions =
        JPU.emptyListOfOnixComposite(SalesRestriction.class);

    /**
     * <p>
     * A group of data elements which together identify a non-territorial sales restriction which a publisher applies to
     * a product. Optional and repeatable.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixComposite<SalesRestriction> salesRestrictions() {
        _initialize();
        return salesRestrictions;
    }

    private ListOfOnixDataCompositeWithKey<Measure, JonixMeasure, MeasureTypes> measures =
        JPU.emptyListOfOnixDataCompositeWithKey(Measure.class);

    /**
     * <p>
     * An optional and repeatable group of data elements which together identify a measurement and the units in which it
     * is expressed.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<Measure, JonixMeasure, MeasureTypes> measures() {
        _initialize();
        return measures;
    }

    private ListOfOnixComposite<RelatedProduct> relatedProducts = JPU.emptyListOfOnixComposite(RelatedProduct.class);

    /**
     * <p>
     * A repeatable group of data elements which together describe a product which has a specified relationship to the
     * product which is described in the ONIX record. Although for reasons of upwards compatibility the composite
     * includes individual fields for ISBN and EAN-13 number, use of the nested &lt;ProductIdentifier&gt; composite is
     * to be preferred, since it allows any recognized identifier scheme (<em>eg</em> DOI) to be used.
     * </p>
     * <p>
     * The minimum required content of an occurrence of the &lt;RelatedProduct&gt; composite is a &lt;RelationCode&gt;
     * and either a product identifier or a &lt;ProductForm&gt; value. In other words, it is valid to list related
     * products by relationship and identifier only, or by relationship and form only.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixComposite<RelatedProduct> relatedProducts() {
        _initialize();
        return relatedProducts;
    }

    private ListOfOnixComposite<SupplyDetail> supplyDetails = JPU.emptyListOfOnixComposite(SupplyDetail.class);

    /**
     * <p>
     * A repeatable group of data elements which together give details of a trade supply source and the product price
     * and availability from that source.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixComposite<SupplyDetail> supplyDetails() {
        _initialize();
        return supplyDetails;
    }

    private ListOfOnixComposite<MarketRepresentation> marketRepresentations =
        JPU.emptyListOfOnixComposite(MarketRepresentation.class);

    /**
     * <p>
     * A group of data elements which together specify a territorial market and the identity of a sales agent or local
     * publisher responsible for marketing the product therein. Optional and repeatable.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixComposite<MarketRepresentation> marketRepresentations() {
        _initialize();
        return marketRepresentations;
    }

    private ListOfOnixElement<ReprintDetail, String> reprintDetails = ListOfOnixElement.empty();

    /**
     * <p>
     * Free text used to give details of the reprint history as part of the promotion of a book. Optional, and
     * repeatable to give information about successive reprintings.
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<ReprintDetail, String> reprintDetails() {
        _initialize();
        return reprintDetails;
    }
}
