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

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.ListOfOnixDataComposite;
import com.tectonica.jonix.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.ListOfOnixElement;
import com.tectonica.jonix.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.codelist.AudienceCodeTypes;
import com.tectonica.jonix.codelist.Audiences;
import com.tectonica.jonix.codelist.BarcodeIndicators;
import com.tectonica.jonix.codelist.BookFormDetails;
import com.tectonica.jonix.codelist.EditionTypes;
import com.tectonica.jonix.codelist.ExtentTypes;
import com.tectonica.jonix.codelist.IllustrationAndOtherContentTypes;
import com.tectonica.jonix.codelist.ImageAudioVideoFileTypes;
import com.tectonica.jonix.codelist.LanguageCodes;
import com.tectonica.jonix.codelist.LanguageRoles;
import com.tectonica.jonix.codelist.MeasureTypes;
import com.tectonica.jonix.codelist.OtherTextTypes;
import com.tectonica.jonix.codelist.ProductClassificationTypes;
import com.tectonica.jonix.codelist.ProductContentTypes;
import com.tectonica.jonix.codelist.ProductFormDetails;
import com.tectonica.jonix.codelist.ProductFormFeatureTypes;
import com.tectonica.jonix.codelist.ProductIdentifierTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TitleTypes;
import com.tectonica.jonix.codelist.TransliterationSchemes;
import com.tectonica.jonix.codelist.WorkIdentifierTypes;
import com.tectonica.jonix.struct.JonixAudience;
import com.tectonica.jonix.struct.JonixAudienceRange;
import com.tectonica.jonix.struct.JonixComplexity;
import com.tectonica.jonix.struct.JonixExtent;
import com.tectonica.jonix.struct.JonixIllustrations;
import com.tectonica.jonix.struct.JonixLanguage;
import com.tectonica.jonix.struct.JonixMainSubject;
import com.tectonica.jonix.struct.JonixMeasure;
import com.tectonica.jonix.struct.JonixMediaFile;
import com.tectonica.jonix.struct.JonixOtherText;
import com.tectonica.jonix.struct.JonixPrize;
import com.tectonica.jonix.struct.JonixProductClassification;
import com.tectonica.jonix.struct.JonixProductFormFeature;
import com.tectonica.jonix.struct.JonixProductIdentifier;
import com.tectonica.jonix.struct.JonixProductWebsite;
import com.tectonica.jonix.struct.JonixSubject;
import com.tectonica.jonix.struct.JonixTitle;
import com.tectonica.jonix.struct.JonixWebsite;
import com.tectonica.jonix.struct.JonixWorkIdentifier;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

public class Product implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Product";
    public static final String shortname = "product";

    /////////////////////////////////////////////////////////////////////////////////
    // ATTRIBUTES
    /////////////////////////////////////////////////////////////////////////////////

    public TextFormats textformat;

    public TextCaseFlags textcase;

    public LanguageCodes language;

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
    public static final Product EMPTY = new Product();

    public Product() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public Product(org.w3c.dom.Element element) {
        exists = true;
        initialized = false;
        this.element = element;
    }

    private void initialize() {
        if (initialized) {
            return;
        }
        initialized = true;

        textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));
        textcase = TextCaseFlags.byCode(JPU.getAttribute(element, "textcase"));
        language = LanguageCodes.byCode(JPU.getAttribute(element, "language"));
        transliteration = TransliterationSchemes.byCode(JPU.getAttribute(element, "transliteration"));
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

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
                case ISBN.refname:
                case ISBN.shortname:
                    isbn = new ISBN(e);
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
                case ProductIdentifier.refname:
                case ProductIdentifier.shortname:
                    productIdentifiers = JPU.addToList(productIdentifiers, new ProductIdentifier(e));
                    break;
                case Barcode.refname:
                case Barcode.shortname:
                    barcodes = JPU.addToList(barcodes, new Barcode(e));
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
                case Series.refname:
                case Series.shortname:
                    seriess = JPU.addToList(seriess, new Series(e));
                    break;
                case NoSeries.refname:
                case NoSeries.shortname:
                    noSeries = new NoSeries(e);
                    break;
                case Set.refname:
                case Set.shortname:
                    sets = JPU.addToList(sets, new Set(e));
                    break;
                case TextCaseFlag.refname:
                case TextCaseFlag.shortname:
                    textCaseFlag = new TextCaseFlag(e);
                    break;
                case DistinctiveTitle.refname:
                case DistinctiveTitle.shortname:
                    distinctiveTitle = new DistinctiveTitle(e);
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
                case Contributor.refname:
                case Contributor.shortname:
                    contributors = JPU.addToList(contributors, new Contributor(e));
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
                case ConferenceName.refname:
                case ConferenceName.shortname:
                    conferenceName = new ConferenceName(e);
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
                case Conference.refname:
                case Conference.shortname:
                    conferences = JPU.addToList(conferences, new Conference(e));
                    break;
                case EditionTypeCode.refname:
                case EditionTypeCode.shortname:
                    editionTypeCodes = JPU.addToList(editionTypeCodes, new EditionTypeCode(e));
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
                case LanguageOfText.refname:
                case LanguageOfText.shortname:
                    languageOfTexts = JPU.addToList(languageOfTexts, new LanguageOfText(e));
                    break;
                case OriginalLanguage.refname:
                case OriginalLanguage.shortname:
                    originalLanguage = new OriginalLanguage(e);
                    break;
                case Language.refname:
                case Language.shortname:
                    languages = JPU.addToList(languages, new Language(e));
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
                case Extent.refname:
                case Extent.shortname:
                    extents = JPU.addToList(extents, new Extent(e));
                    break;
                case NumberOfIllustrations.refname:
                case NumberOfIllustrations.shortname:
                    numberOfIllustrations = new NumberOfIllustrations(e);
                    break;
                case IllustrationsNote.refname:
                case IllustrationsNote.shortname:
                    illustrationsNote = new IllustrationsNote(e);
                    break;
                case Illustrations.refname:
                case Illustrations.shortname:
                    illustrationss = JPU.addToList(illustrationss, new Illustrations(e));
                    break;
                case MapScale.refname:
                case MapScale.shortname:
                    mapScales = JPU.addToList(mapScales, new MapScale(e));
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
                case USSchoolGrade.refname:
                case USSchoolGrade.shortname:
                    usSchoolGrade = new USSchoolGrade(e);
                    break;
                case InterestAge.refname:
                case InterestAge.shortname:
                    interestAge = new InterestAge(e);
                    break;
                case AudienceRange.refname:
                case AudienceRange.shortname:
                    audienceRanges = JPU.addToList(audienceRanges, new AudienceRange(e));
                    break;
                case AudienceDescription.refname:
                case AudienceDescription.shortname:
                    audienceDescription = new AudienceDescription(e);
                    break;
                case Complexity.refname:
                case Complexity.shortname:
                    complexitys = JPU.addToList(complexitys, new Complexity(e));
                    break;
                case Annotation.refname:
                case Annotation.shortname:
                    annotation = new Annotation(e);
                    break;
                case MainDescription.refname:
                case MainDescription.shortname:
                    mainDescription = new MainDescription(e);
                    break;
                case OtherText.refname:
                case OtherText.shortname:
                    otherTexts = JPU.addToList(otherTexts, new OtherText(e));
                    break;
                case ReviewQuote.refname:
                case ReviewQuote.shortname:
                    reviewQuotes = JPU.addToList(reviewQuotes, new ReviewQuote(e));
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
                case MediaFile.refname:
                case MediaFile.shortname:
                    mediaFiles = JPU.addToList(mediaFiles, new MediaFile(e));
                    break;
                case ProductWebsite.refname:
                case ProductWebsite.shortname:
                    productWebsites = JPU.addToList(productWebsites, new ProductWebsite(e));
                    break;
                case PrizesDescription.refname:
                case PrizesDescription.shortname:
                    prizesDescription = new PrizesDescription(e);
                    break;
                case Prize.refname:
                case Prize.shortname:
                    prizes = JPU.addToList(prizes, new Prize(e));
                    break;
                case ContentItem.refname:
                case ContentItem.shortname:
                    contentItems = JPU.addToList(contentItems, new ContentItem(e));
                    break;
                case ImprintName.refname:
                case ImprintName.shortname:
                    imprintName = new ImprintName(e);
                    break;
                case Imprint.refname:
                case Imprint.shortname:
                    imprints = JPU.addToList(imprints, new Imprint(e));
                    break;
                case PublisherName.refname:
                case PublisherName.shortname:
                    publisherName = new PublisherName(e);
                    break;
                case Publisher.refname:
                case Publisher.shortname:
                    publishers = JPU.addToList(publishers, new Publisher(e));
                    break;
                case CityOfPublication.refname:
                case CityOfPublication.shortname:
                    cityOfPublications = JPU.addToList(cityOfPublications, new CityOfPublication(e));
                    break;
                case CountryOfPublication.refname:
                case CountryOfPublication.shortname:
                    countryOfPublication = new CountryOfPublication(e);
                    break;
                case CopublisherName.refname:
                case CopublisherName.shortname:
                    copublisherNames = JPU.addToList(copublisherNames, new CopublisherName(e));
                    break;
                case SponsorName.refname:
                case SponsorName.shortname:
                    sponsorNames = JPU.addToList(sponsorNames, new SponsorName(e));
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
                case CopyrightStatement.refname:
                case CopyrightStatement.shortname:
                    copyrightStatements = JPU.addToList(copyrightStatements, new CopyrightStatement(e));
                    break;
                case CopyrightYear.refname:
                case CopyrightYear.shortname:
                    copyrightYear = new CopyrightYear(e);
                    break;
                case YearFirstPublished.refname:
                case YearFirstPublished.shortname:
                    yearFirstPublished = new YearFirstPublished(e);
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
                case Height.refname:
                case Height.shortname:
                    height = new Height(e);
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
                case Measure.refname:
                case Measure.shortname:
                    measures = JPU.addToList(measures, new Measure(e));
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
                case RelatedProduct.refname:
                case RelatedProduct.shortname:
                    relatedProducts = JPU.addToList(relatedProducts, new RelatedProduct(e));
                    break;
                case OutOfPrintDate.refname:
                case OutOfPrintDate.shortname:
                    outOfPrintDate = new OutOfPrintDate(e);
                    break;
                case SupplyDetail.refname:
                case SupplyDetail.shortname:
                    supplyDetails = JPU.addToList(supplyDetails, new SupplyDetail(e));
                    break;
                case MarketRepresentation.refname:
                case MarketRepresentation.shortname:
                    marketRepresentations = JPU.addToList(marketRepresentations, new MarketRepresentation(e));
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
                case ReprintDetail.refname:
                case ReprintDetail.shortname:
                    reprintDetails = JPU.addToList(reprintDetails, new ReprintDetail(e));
                    break;
                case CopiesSold.refname:
                case CopiesSold.shortname:
                    copiesSold = new CopiesSold(e);
                    break;
                case BookClubAdoption.refname:
                case BookClubAdoption.shortname:
                    bookClubAdoption = new BookClubAdoption(e);
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

    private RecordReference recordReference = RecordReference.EMPTY;

    /**
     * (this field is required)
     */
    public RecordReference recordReference() {
        initialize();
        return recordReference;
    }

    private NotificationType notificationType = NotificationType.EMPTY;

    /**
     * (this field is required)
     */
    public NotificationType notificationType() {
        initialize();
        return notificationType;
    }

    private DeletionCode deletionCode = DeletionCode.EMPTY;

    /**
     * (this field is optional)
     */
    public DeletionCode deletionCode() {
        initialize();
        return deletionCode;
    }

    private DeletionText deletionText = DeletionText.EMPTY;

    /**
     * (this field is optional)
     */
    public DeletionText deletionText() {
        initialize();
        return deletionText;
    }

    private RecordSourceType recordSourceType = RecordSourceType.EMPTY;

    /**
     * (this field is optional)
     */
    public RecordSourceType recordSourceType() {
        initialize();
        return recordSourceType;
    }

    private RecordSourceIdentifierType recordSourceIdentifierType = RecordSourceIdentifierType.EMPTY;

    /**
     * (this field is optional)
     */
    public RecordSourceIdentifierType recordSourceIdentifierType() {
        initialize();
        return recordSourceIdentifierType;
    }

    private RecordSourceIdentifier recordSourceIdentifier = RecordSourceIdentifier.EMPTY;

    /**
     * (this field is optional)
     */
    public RecordSourceIdentifier recordSourceIdentifier() {
        initialize();
        return recordSourceIdentifier;
    }

    private RecordSourceName recordSourceName = RecordSourceName.EMPTY;

    /**
     * (this field is optional)
     */
    public RecordSourceName recordSourceName() {
        initialize();
        return recordSourceName;
    }

    private ISBN isbn = ISBN.EMPTY;

    /**
     * (this field is required)
     */
    public ISBN isbn() {
        initialize();
        return isbn;
    }

    private EAN13 ean13 = EAN13.EMPTY;

    /**
     * (this field is optional)
     */
    public EAN13 ean13() {
        initialize();
        return ean13;
    }

    private UPC upc = UPC.EMPTY;

    /**
     * (this field is optional)
     */
    public UPC upc() {
        initialize();
        return upc;
    }

    private PublisherProductNo publisherProductNo = PublisherProductNo.EMPTY;

    /**
     * (this field is optional)
     */
    public PublisherProductNo publisherProductNo() {
        initialize();
        return publisherProductNo;
    }

    private ISMN ismn = ISMN.EMPTY;

    /**
     * (this field is optional)
     */
    public ISMN ismn() {
        initialize();
        return ismn;
    }

    private DOI doi = DOI.EMPTY;

    /**
     * (this field is optional)
     */
    public DOI doi() {
        initialize();
        return doi;
    }

    private ListOfOnixDataCompositeWithKey<ProductIdentifier, JonixProductIdentifier, ProductIdentifierTypes>
        productIdentifiers = ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataCompositeWithKey<ProductIdentifier, JonixProductIdentifier, ProductIdentifierTypes> productIdentifiers() {
        initialize();
        return productIdentifiers;
    }

    private ListOfOnixElement<Barcode, BarcodeIndicators> barcodes = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<Barcode, BarcodeIndicators> barcodes() {
        initialize();
        return barcodes;
    }

    private ReplacesISBN replacesISBN = ReplacesISBN.EMPTY;

    /**
     * (this field is optional)
     */
    public ReplacesISBN replacesISBN() {
        initialize();
        return replacesISBN;
    }

    private ReplacesEAN13 replacesEAN13 = ReplacesEAN13.EMPTY;

    /**
     * (this field is optional)
     */
    public ReplacesEAN13 replacesEAN13() {
        initialize();
        return replacesEAN13;
    }

    private ProductForm productForm = ProductForm.EMPTY;

    /**
     * (this field is optional)
     */
    public ProductForm productForm() {
        initialize();
        return productForm;
    }

    private ListOfOnixElement<ProductFormDetail, ProductFormDetails> productFormDetails = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<ProductFormDetail, ProductFormDetails> productFormDetails() {
        initialize();
        return productFormDetails;
    }

    private ListOfOnixDataCompositeWithKey<ProductFormFeature, JonixProductFormFeature, ProductFormFeatureTypes>
        productFormFeatures = ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataCompositeWithKey<ProductFormFeature, JonixProductFormFeature, ProductFormFeatureTypes> productFormFeatures() {
        initialize();
        return productFormFeatures;
    }

    private ListOfOnixElement<BookFormDetail, BookFormDetails> bookFormDetails = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<BookFormDetail, BookFormDetails> bookFormDetails() {
        initialize();
        return bookFormDetails;
    }

    private ProductPackaging productPackaging = ProductPackaging.EMPTY;

    /**
     * (this field is optional)
     */
    public ProductPackaging productPackaging() {
        initialize();
        return productPackaging;
    }

    private ProductFormDescription productFormDescription = ProductFormDescription.EMPTY;

    /**
     * (this field is optional)
     */
    public ProductFormDescription productFormDescription() {
        initialize();
        return productFormDescription;
    }

    private NumberOfPieces numberOfPieces = NumberOfPieces.EMPTY;

    /**
     * (this field is optional)
     */
    public NumberOfPieces numberOfPieces() {
        initialize();
        return numberOfPieces;
    }

    private TradeCategory tradeCategory = TradeCategory.EMPTY;

    /**
     * (this field is optional)
     */
    public TradeCategory tradeCategory() {
        initialize();
        return tradeCategory;
    }

    private ListOfOnixElement<ProductContentType, ProductContentTypes> productContentTypes = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<ProductContentType, ProductContentTypes> productContentTypes() {
        initialize();
        return productContentTypes;
    }

    private List<ContainedItem> containedItems = Collections.emptyList();

    /**
     * (this list may be empty)
     */
    public List<ContainedItem> containedItems() {
        initialize();
        return containedItems;
    }

    private ListOfOnixDataCompositeWithKey<ProductClassification, JonixProductClassification, ProductClassificationTypes>
        productClassifications = ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataCompositeWithKey<ProductClassification, JonixProductClassification, ProductClassificationTypes> productClassifications() {
        initialize();
        return productClassifications;
    }

    private EpubType epubType = EpubType.EMPTY;

    /**
     * (this field is optional)
     */
    public EpubType epubType() {
        initialize();
        return epubType;
    }

    private EpubTypeVersion epubTypeVersion = EpubTypeVersion.EMPTY;

    /**
     * (this field is optional)
     */
    public EpubTypeVersion epubTypeVersion() {
        initialize();
        return epubTypeVersion;
    }

    private EpubTypeDescription epubTypeDescription = EpubTypeDescription.EMPTY;

    /**
     * (this field is optional)
     */
    public EpubTypeDescription epubTypeDescription() {
        initialize();
        return epubTypeDescription;
    }

    private EpubFormat epubFormat = EpubFormat.EMPTY;

    /**
     * (this field is optional)
     */
    public EpubFormat epubFormat() {
        initialize();
        return epubFormat;
    }

    private EpubFormatVersion epubFormatVersion = EpubFormatVersion.EMPTY;

    /**
     * (this field is optional)
     */
    public EpubFormatVersion epubFormatVersion() {
        initialize();
        return epubFormatVersion;
    }

    private EpubFormatDescription epubFormatDescription = EpubFormatDescription.EMPTY;

    /**
     * (this field is optional)
     */
    public EpubFormatDescription epubFormatDescription() {
        initialize();
        return epubFormatDescription;
    }

    private EpubSource epubSource = EpubSource.EMPTY;

    /**
     * (this field is optional)
     */
    public EpubSource epubSource() {
        initialize();
        return epubSource;
    }

    private EpubSourceVersion epubSourceVersion = EpubSourceVersion.EMPTY;

    /**
     * (this field is optional)
     */
    public EpubSourceVersion epubSourceVersion() {
        initialize();
        return epubSourceVersion;
    }

    private EpubSourceDescription epubSourceDescription = EpubSourceDescription.EMPTY;

    /**
     * (this field is optional)
     */
    public EpubSourceDescription epubSourceDescription() {
        initialize();
        return epubSourceDescription;
    }

    private EpubTypeNote epubTypeNote = EpubTypeNote.EMPTY;

    /**
     * (this field is optional)
     */
    public EpubTypeNote epubTypeNote() {
        initialize();
        return epubTypeNote;
    }

    private List<Series> seriess = Collections.emptyList();

    /**
     * (this list may be empty)
     */
    public List<Series> seriess() {
        initialize();
        return seriess;
    }

    private NoSeries noSeries = NoSeries.EMPTY;

    /**
     * (this field is optional)
     */
    public NoSeries noSeries() {
        initialize();
        return noSeries;
    }

    public boolean isNoSeries() {
        return (noSeries().exists());
    }

    private List<Set> sets = Collections.emptyList();

    /**
     * (this list may be empty)
     */
    public List<Set> sets() {
        initialize();
        return sets;
    }

    private TextCaseFlag textCaseFlag = TextCaseFlag.EMPTY;

    /**
     * (this field is optional)
     */
    public TextCaseFlag textCaseFlag() {
        initialize();
        return textCaseFlag;
    }

    private DistinctiveTitle distinctiveTitle = DistinctiveTitle.EMPTY;

    /**
     * (this field is required)
     */
    public DistinctiveTitle distinctiveTitle() {
        initialize();
        return distinctiveTitle;
    }

    private TitlePrefix titlePrefix = TitlePrefix.EMPTY;

    /**
     * (this field is optional)
     */
    public TitlePrefix titlePrefix() {
        initialize();
        return titlePrefix;
    }

    private TitleWithoutPrefix titleWithoutPrefix = TitleWithoutPrefix.EMPTY;

    /**
     * (this field is optional)
     */
    public TitleWithoutPrefix titleWithoutPrefix() {
        initialize();
        return titleWithoutPrefix;
    }

    private Subtitle subtitle = Subtitle.EMPTY;

    /**
     * (this field is optional)
     */
    public Subtitle subtitle() {
        initialize();
        return subtitle;
    }

    private TranslationOfTitle translationOfTitle = TranslationOfTitle.EMPTY;

    /**
     * (this field is optional)
     */
    public TranslationOfTitle translationOfTitle() {
        initialize();
        return translationOfTitle;
    }

    private ListOfOnixElement<FormerTitle, String> formerTitles = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<FormerTitle, String> formerTitles() {
        initialize();
        return formerTitles;
    }

    private ListOfOnixDataCompositeWithKey<Title, JonixTitle, TitleTypes> titles =
        ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataCompositeWithKey<Title, JonixTitle, TitleTypes> titles() {
        initialize();
        return titles;
    }

    private ListOfOnixDataCompositeWithKey<WorkIdentifier, JonixWorkIdentifier, WorkIdentifierTypes> workIdentifiers =
        ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataCompositeWithKey<WorkIdentifier, JonixWorkIdentifier, WorkIdentifierTypes> workIdentifiers() {
        initialize();
        return workIdentifiers;
    }

    private ListOfOnixDataComposite<Website, JonixWebsite> websites = ListOfOnixDataComposite.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataComposite<Website, JonixWebsite> websites() {
        initialize();
        return websites;
    }

    private ThesisType thesisType = ThesisType.EMPTY;

    /**
     * (this field is optional)
     */
    public ThesisType thesisType() {
        initialize();
        return thesisType;
    }

    private ThesisPresentedTo thesisPresentedTo = ThesisPresentedTo.EMPTY;

    /**
     * (this field is optional)
     */
    public ThesisPresentedTo thesisPresentedTo() {
        initialize();
        return thesisPresentedTo;
    }

    private ThesisYear thesisYear = ThesisYear.EMPTY;

    /**
     * (this field is optional)
     */
    public ThesisYear thesisYear() {
        initialize();
        return thesisYear;
    }

    private List<Contributor> contributors = Collections.emptyList();

    /**
     * (this list is required to contain at least one item)
     */
    public List<Contributor> contributors() {
        initialize();
        return contributors;
    }

    private ContributorStatement contributorStatement = ContributorStatement.EMPTY;

    /**
     * (this field is optional)
     */
    public ContributorStatement contributorStatement() {
        initialize();
        return contributorStatement;
    }

    private NoContributor noContributor = NoContributor.EMPTY;

    /**
     * (this field is optional)
     */
    public NoContributor noContributor() {
        initialize();
        return noContributor;
    }

    public boolean isNoContributor() {
        return (noContributor().exists());
    }

    private ConferenceDescription conferenceDescription = ConferenceDescription.EMPTY;

    /**
     * (this field is optional)
     */
    public ConferenceDescription conferenceDescription() {
        initialize();
        return conferenceDescription;
    }

    private ConferenceRole conferenceRole = ConferenceRole.EMPTY;

    /**
     * (this field is optional)
     */
    public ConferenceRole conferenceRole() {
        initialize();
        return conferenceRole;
    }

    private ConferenceName conferenceName = ConferenceName.EMPTY;

    /**
     * (this field is required)
     */
    public ConferenceName conferenceName() {
        initialize();
        return conferenceName;
    }

    private ConferenceNumber conferenceNumber = ConferenceNumber.EMPTY;

    /**
     * (this field is optional)
     */
    public ConferenceNumber conferenceNumber() {
        initialize();
        return conferenceNumber;
    }

    private ConferenceDate conferenceDate = ConferenceDate.EMPTY;

    /**
     * (this field is optional)
     */
    public ConferenceDate conferenceDate() {
        initialize();
        return conferenceDate;
    }

    private ConferencePlace conferencePlace = ConferencePlace.EMPTY;

    /**
     * (this field is optional)
     */
    public ConferencePlace conferencePlace() {
        initialize();
        return conferencePlace;
    }

    private List<Conference> conferences = Collections.emptyList();

    /**
     * (this list may be empty)
     */
    public List<Conference> conferences() {
        initialize();
        return conferences;
    }

    private ListOfOnixElement<EditionTypeCode, EditionTypes> editionTypeCodes = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<EditionTypeCode, EditionTypes> editionTypeCodes() {
        initialize();
        return editionTypeCodes;
    }

    private EditionNumber editionNumber = EditionNumber.EMPTY;

    /**
     * (this field is optional)
     */
    public EditionNumber editionNumber() {
        initialize();
        return editionNumber;
    }

    private EditionVersionNumber editionVersionNumber = EditionVersionNumber.EMPTY;

    /**
     * (this field is optional)
     */
    public EditionVersionNumber editionVersionNumber() {
        initialize();
        return editionVersionNumber;
    }

    private EditionStatement editionStatement = EditionStatement.EMPTY;

    /**
     * (this field is optional)
     */
    public EditionStatement editionStatement() {
        initialize();
        return editionStatement;
    }

    private NoEdition noEdition = NoEdition.EMPTY;

    /**
     * (this field is optional)
     */
    public NoEdition noEdition() {
        initialize();
        return noEdition;
    }

    public boolean isNoEdition() {
        return (noEdition().exists());
    }

    private ReligiousText religiousText = ReligiousText.EMPTY;

    /**
     * (this field is optional)
     */
    public ReligiousText religiousText() {
        initialize();
        return religiousText;
    }

    private ListOfOnixElement<LanguageOfText, LanguageCodes> languageOfTexts = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<LanguageOfText, LanguageCodes> languageOfTexts() {
        initialize();
        return languageOfTexts;
    }

    private OriginalLanguage originalLanguage = OriginalLanguage.EMPTY;

    /**
     * (this field is optional)
     */
    public OriginalLanguage originalLanguage() {
        initialize();
        return originalLanguage;
    }

    private ListOfOnixDataCompositeWithKey<Language, JonixLanguage, LanguageRoles> languages =
        ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataCompositeWithKey<Language, JonixLanguage, LanguageRoles> languages() {
        initialize();
        return languages;
    }

    private NumberOfPages numberOfPages = NumberOfPages.EMPTY;

    /**
     * (this field is optional)
     */
    public NumberOfPages numberOfPages() {
        initialize();
        return numberOfPages;
    }

    private PagesRoman pagesRoman = PagesRoman.EMPTY;

    /**
     * (this field is optional)
     */
    public PagesRoman pagesRoman() {
        initialize();
        return pagesRoman;
    }

    private PagesArabic pagesArabic = PagesArabic.EMPTY;

    /**
     * (this field is optional)
     */
    public PagesArabic pagesArabic() {
        initialize();
        return pagesArabic;
    }

    private ListOfOnixDataCompositeWithKey<Extent, JonixExtent, ExtentTypes> extents =
        ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataCompositeWithKey<Extent, JonixExtent, ExtentTypes> extents() {
        initialize();
        return extents;
    }

    private NumberOfIllustrations numberOfIllustrations = NumberOfIllustrations.EMPTY;

    /**
     * (this field is optional)
     */
    public NumberOfIllustrations numberOfIllustrations() {
        initialize();
        return numberOfIllustrations;
    }

    private IllustrationsNote illustrationsNote = IllustrationsNote.EMPTY;

    /**
     * (this field is optional)
     */
    public IllustrationsNote illustrationsNote() {
        initialize();
        return illustrationsNote;
    }

    private ListOfOnixDataCompositeWithKey<Illustrations, JonixIllustrations, IllustrationAndOtherContentTypes>
        illustrationss = ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataCompositeWithKey<Illustrations, JonixIllustrations, IllustrationAndOtherContentTypes> illustrationss() {
        initialize();
        return illustrationss;
    }

    private ListOfOnixElement<MapScale, String> mapScales = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<MapScale, String> mapScales() {
        initialize();
        return mapScales;
    }

    private BASICMainSubject basicMainSubject = BASICMainSubject.EMPTY;

    /**
     * (this field is optional)
     */
    public BASICMainSubject basicMainSubject() {
        initialize();
        return basicMainSubject;
    }

    private BASICVersion basicVersion = BASICVersion.EMPTY;

    /**
     * (this field is optional)
     */
    public BASICVersion basicVersion() {
        initialize();
        return basicVersion;
    }

    private BICMainSubject bicMainSubject = BICMainSubject.EMPTY;

    /**
     * (this field is optional)
     */
    public BICMainSubject bicMainSubject() {
        initialize();
        return bicMainSubject;
    }

    private BICVersion bicVersion = BICVersion.EMPTY;

    /**
     * (this field is optional)
     */
    public BICVersion bicVersion() {
        initialize();
        return bicVersion;
    }

    private ListOfOnixDataComposite<MainSubject, JonixMainSubject> mainSubjects = ListOfOnixDataComposite.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataComposite<MainSubject, JonixMainSubject> mainSubjects() {
        initialize();
        return mainSubjects;
    }

    private ListOfOnixDataComposite<Subject, JonixSubject> subjects = ListOfOnixDataComposite.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataComposite<Subject, JonixSubject> subjects() {
        initialize();
        return subjects;
    }

    private List<PersonAsSubject> personAsSubjects = Collections.emptyList();

    /**
     * (this list may be empty)
     */
    public List<PersonAsSubject> personAsSubjects() {
        initialize();
        return personAsSubjects;
    }

    private ListOfOnixElement<CorporateBodyAsSubject, String> corporateBodyAsSubjects = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<CorporateBodyAsSubject, String> corporateBodyAsSubjects() {
        initialize();
        return corporateBodyAsSubjects;
    }

    private ListOfOnixElement<PlaceAsSubject, String> placeAsSubjects = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<PlaceAsSubject, String> placeAsSubjects() {
        initialize();
        return placeAsSubjects;
    }

    private ListOfOnixElement<AudienceCode, Audiences> audienceCodes = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<AudienceCode, Audiences> audienceCodes() {
        initialize();
        return audienceCodes;
    }

    private ListOfOnixDataCompositeWithKey<Audience, JonixAudience, AudienceCodeTypes> audiences =
        ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataCompositeWithKey<Audience, JonixAudience, AudienceCodeTypes> audiences() {
        initialize();
        return audiences;
    }

    private USSchoolGrade usSchoolGrade = USSchoolGrade.EMPTY;

    /**
     * (this field is optional)
     */
    public USSchoolGrade usSchoolGrade() {
        initialize();
        return usSchoolGrade;
    }

    private InterestAge interestAge = InterestAge.EMPTY;

    /**
     * (this field is optional)
     */
    public InterestAge interestAge() {
        initialize();
        return interestAge;
    }

    private ListOfOnixDataComposite<AudienceRange, JonixAudienceRange> audienceRanges = ListOfOnixDataComposite.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataComposite<AudienceRange, JonixAudienceRange> audienceRanges() {
        initialize();
        return audienceRanges;
    }

    private AudienceDescription audienceDescription = AudienceDescription.EMPTY;

    /**
     * (this field is optional)
     */
    public AudienceDescription audienceDescription() {
        initialize();
        return audienceDescription;
    }

    private ListOfOnixDataComposite<Complexity, JonixComplexity> complexitys = ListOfOnixDataComposite.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataComposite<Complexity, JonixComplexity> complexitys() {
        initialize();
        return complexitys;
    }

    private Annotation annotation = Annotation.EMPTY;

    /**
     * (this field is optional)
     */
    public Annotation annotation() {
        initialize();
        return annotation;
    }

    private MainDescription mainDescription = MainDescription.EMPTY;

    /**
     * (this field is optional)
     */
    public MainDescription mainDescription() {
        initialize();
        return mainDescription;
    }

    private ListOfOnixDataCompositeWithKey<OtherText, JonixOtherText, OtherTextTypes> otherTexts =
        ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataCompositeWithKey<OtherText, JonixOtherText, OtherTextTypes> otherTexts() {
        initialize();
        return otherTexts;
    }

    private ListOfOnixElement<ReviewQuote, String> reviewQuotes = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<ReviewQuote, String> reviewQuotes() {
        initialize();
        return reviewQuotes;
    }

    private CoverImageFormatCode coverImageFormatCode = CoverImageFormatCode.EMPTY;

    /**
     * (this field is optional)
     */
    public CoverImageFormatCode coverImageFormatCode() {
        initialize();
        return coverImageFormatCode;
    }

    private CoverImageLinkTypeCode coverImageLinkTypeCode = CoverImageLinkTypeCode.EMPTY;

    /**
     * (this field is optional)
     */
    public CoverImageLinkTypeCode coverImageLinkTypeCode() {
        initialize();
        return coverImageLinkTypeCode;
    }

    private CoverImageLink coverImageLink = CoverImageLink.EMPTY;

    /**
     * (this field is optional)
     */
    public CoverImageLink coverImageLink() {
        initialize();
        return coverImageLink;
    }

    private ListOfOnixDataCompositeWithKey<MediaFile, JonixMediaFile, ImageAudioVideoFileTypes> mediaFiles =
        ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataCompositeWithKey<MediaFile, JonixMediaFile, ImageAudioVideoFileTypes> mediaFiles() {
        initialize();
        return mediaFiles;
    }

    private ListOfOnixDataComposite<ProductWebsite, JonixProductWebsite> productWebsites =
        ListOfOnixDataComposite.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataComposite<ProductWebsite, JonixProductWebsite> productWebsites() {
        initialize();
        return productWebsites;
    }

    private PrizesDescription prizesDescription = PrizesDescription.EMPTY;

    /**
     * (this field is optional)
     */
    public PrizesDescription prizesDescription() {
        initialize();
        return prizesDescription;
    }

    private ListOfOnixDataComposite<Prize, JonixPrize> prizes = ListOfOnixDataComposite.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataComposite<Prize, JonixPrize> prizes() {
        initialize();
        return prizes;
    }

    private List<ContentItem> contentItems = Collections.emptyList();

    /**
     * (this list may be empty)
     */
    public List<ContentItem> contentItems() {
        initialize();
        return contentItems;
    }

    private ImprintName imprintName = ImprintName.EMPTY;

    /**
     * (this field is required)
     */
    public ImprintName imprintName() {
        initialize();
        return imprintName;
    }

    private List<Imprint> imprints = Collections.emptyList();

    /**
     * (this list may be empty)
     */
    public List<Imprint> imprints() {
        initialize();
        return imprints;
    }

    private PublisherName publisherName = PublisherName.EMPTY;

    /**
     * (this field is optional)
     */
    public PublisherName publisherName() {
        initialize();
        return publisherName;
    }

    private List<Publisher> publishers = Collections.emptyList();

    /**
     * (this list may be empty)
     */
    public List<Publisher> publishers() {
        initialize();
        return publishers;
    }

    private ListOfOnixElement<CityOfPublication, String> cityOfPublications = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<CityOfPublication, String> cityOfPublications() {
        initialize();
        return cityOfPublications;
    }

    private CountryOfPublication countryOfPublication = CountryOfPublication.EMPTY;

    /**
     * (this field is optional)
     */
    public CountryOfPublication countryOfPublication() {
        initialize();
        return countryOfPublication;
    }

    private ListOfOnixElement<CopublisherName, String> copublisherNames = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<CopublisherName, String> copublisherNames() {
        initialize();
        return copublisherNames;
    }

    private ListOfOnixElement<SponsorName, String> sponsorNames = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<SponsorName, String> sponsorNames() {
        initialize();
        return sponsorNames;
    }

    private OriginalPublisher originalPublisher = OriginalPublisher.EMPTY;

    /**
     * (this field is optional)
     */
    public OriginalPublisher originalPublisher() {
        initialize();
        return originalPublisher;
    }

    private PublishingStatus publishingStatus = PublishingStatus.EMPTY;

    /**
     * (this field is optional)
     */
    public PublishingStatus publishingStatus() {
        initialize();
        return publishingStatus;
    }

    private PublishingStatusNote publishingStatusNote = PublishingStatusNote.EMPTY;

    /**
     * (this field is optional)
     */
    public PublishingStatusNote publishingStatusNote() {
        initialize();
        return publishingStatusNote;
    }

    private AnnouncementDate announcementDate = AnnouncementDate.EMPTY;

    /**
     * (this field is optional)
     */
    public AnnouncementDate announcementDate() {
        initialize();
        return announcementDate;
    }

    private TradeAnnouncementDate tradeAnnouncementDate = TradeAnnouncementDate.EMPTY;

    /**
     * (this field is optional)
     */
    public TradeAnnouncementDate tradeAnnouncementDate() {
        initialize();
        return tradeAnnouncementDate;
    }

    private PublicationDate publicationDate = PublicationDate.EMPTY;

    /**
     * (this field is optional)
     */
    public PublicationDate publicationDate() {
        initialize();
        return publicationDate;
    }

    private List<CopyrightStatement> copyrightStatements = Collections.emptyList();

    /**
     * (this list may be empty)
     */
    public List<CopyrightStatement> copyrightStatements() {
        initialize();
        return copyrightStatements;
    }

    private CopyrightYear copyrightYear = CopyrightYear.EMPTY;

    /**
     * (this field is optional)
     */
    public CopyrightYear copyrightYear() {
        initialize();
        return copyrightYear;
    }

    private YearFirstPublished yearFirstPublished = YearFirstPublished.EMPTY;

    /**
     * (this field is optional)
     */
    public YearFirstPublished yearFirstPublished() {
        initialize();
        return yearFirstPublished;
    }

    private List<SalesRights> salesRightss = Collections.emptyList();

    /**
     * (this list may be empty)
     */
    public List<SalesRights> salesRightss() {
        initialize();
        return salesRightss;
    }

    private List<NotForSale> notForSales = Collections.emptyList();

    /**
     * (this list may be empty)
     */
    public List<NotForSale> notForSales() {
        initialize();
        return notForSales;
    }

    private List<SalesRestriction> salesRestrictions = Collections.emptyList();

    /**
     * (this list may be empty)
     */
    public List<SalesRestriction> salesRestrictions() {
        initialize();
        return salesRestrictions;
    }

    private Height height = Height.EMPTY;

    /**
     * (this field is required)
     */
    public Height height() {
        initialize();
        return height;
    }

    private Width width = Width.EMPTY;

    /**
     * (this field is optional)
     */
    public Width width() {
        initialize();
        return width;
    }

    private Thickness thickness = Thickness.EMPTY;

    /**
     * (this field is optional)
     */
    public Thickness thickness() {
        initialize();
        return thickness;
    }

    private Weight weight = Weight.EMPTY;

    /**
     * (this field is optional)
     */
    public Weight weight() {
        initialize();
        return weight;
    }

    private ListOfOnixDataCompositeWithKey<Measure, JonixMeasure, MeasureTypes> measures =
        ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataCompositeWithKey<Measure, JonixMeasure, MeasureTypes> measures() {
        initialize();
        return measures;
    }

    private Dimensions dimensions = Dimensions.EMPTY;

    /**
     * (this field is optional)
     */
    public Dimensions dimensions() {
        initialize();
        return dimensions;
    }

    private ReplacedByISBN replacedByISBN = ReplacedByISBN.EMPTY;

    /**
     * (this field is optional)
     */
    public ReplacedByISBN replacedByISBN() {
        initialize();
        return replacedByISBN;
    }

    private ReplacedByEAN13 replacedByEAN13 = ReplacedByEAN13.EMPTY;

    /**
     * (this field is optional)
     */
    public ReplacedByEAN13 replacedByEAN13() {
        initialize();
        return replacedByEAN13;
    }

    private AlternativeFormatISBN alternativeFormatISBN = AlternativeFormatISBN.EMPTY;

    /**
     * (this field is optional)
     */
    public AlternativeFormatISBN alternativeFormatISBN() {
        initialize();
        return alternativeFormatISBN;
    }

    private AlternativeFormatEAN13 alternativeFormatEAN13 = AlternativeFormatEAN13.EMPTY;

    /**
     * (this field is optional)
     */
    public AlternativeFormatEAN13 alternativeFormatEAN13() {
        initialize();
        return alternativeFormatEAN13;
    }

    private AlternativeProductISBN alternativeProductISBN = AlternativeProductISBN.EMPTY;

    /**
     * (this field is optional)
     */
    public AlternativeProductISBN alternativeProductISBN() {
        initialize();
        return alternativeProductISBN;
    }

    private AlternativeProductEAN13 alternativeProductEAN13 = AlternativeProductEAN13.EMPTY;

    /**
     * (this field is optional)
     */
    public AlternativeProductEAN13 alternativeProductEAN13() {
        initialize();
        return alternativeProductEAN13;
    }

    private List<RelatedProduct> relatedProducts = Collections.emptyList();

    /**
     * (this list may be empty)
     */
    public List<RelatedProduct> relatedProducts() {
        initialize();
        return relatedProducts;
    }

    private OutOfPrintDate outOfPrintDate = OutOfPrintDate.EMPTY;

    /**
     * (this field is optional)
     */
    public OutOfPrintDate outOfPrintDate() {
        initialize();
        return outOfPrintDate;
    }

    private List<SupplyDetail> supplyDetails = Collections.emptyList();

    /**
     * (this list may be empty)
     */
    public List<SupplyDetail> supplyDetails() {
        initialize();
        return supplyDetails;
    }

    private List<MarketRepresentation> marketRepresentations = Collections.emptyList();

    /**
     * (this list may be empty)
     */
    public List<MarketRepresentation> marketRepresentations() {
        initialize();
        return marketRepresentations;
    }

    private PromotionCampaign promotionCampaign = PromotionCampaign.EMPTY;

    /**
     * (this field is optional)
     */
    public PromotionCampaign promotionCampaign() {
        initialize();
        return promotionCampaign;
    }

    private PromotionContact promotionContact = PromotionContact.EMPTY;

    /**
     * (this field is optional)
     */
    public PromotionContact promotionContact() {
        initialize();
        return promotionContact;
    }

    private InitialPrintRun initialPrintRun = InitialPrintRun.EMPTY;

    /**
     * (this field is optional)
     */
    public InitialPrintRun initialPrintRun() {
        initialize();
        return initialPrintRun;
    }

    private ListOfOnixElement<ReprintDetail, String> reprintDetails = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<ReprintDetail, String> reprintDetails() {
        initialize();
        return reprintDetails;
    }

    private CopiesSold copiesSold = CopiesSold.EMPTY;

    /**
     * (this field is optional)
     */
    public CopiesSold copiesSold() {
        initialize();
        return copiesSold;
    }

    private BookClubAdoption bookClubAdoption = BookClubAdoption.EMPTY;

    /**
     * (this field is optional)
     */
    public BookClubAdoption bookClubAdoption() {
        initialize();
        return bookClubAdoption;
    }
}
