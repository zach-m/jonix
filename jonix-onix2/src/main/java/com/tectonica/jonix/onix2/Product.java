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

import java.util.List;

import com.tectonica.jonix.DU;
import com.tectonica.jonix.codelist.CountryCodeIso31661s;
import com.tectonica.jonix.codelist.EpublicationFormats;
import com.tectonica.jonix.codelist.EpublicationTypes;
import com.tectonica.jonix.codelist.FrontCoverImageFileFormats;
import com.tectonica.jonix.codelist.FrontCoverImageFileLinkTypes;
import com.tectonica.jonix.codelist.LanguageCodeIso6392Bs;
import com.tectonica.jonix.codelist.NameCodeTypes;
import com.tectonica.jonix.codelist.NotificationOrUpdateTypes;
import com.tectonica.jonix.codelist.ProductCompositions;
import com.tectonica.jonix.codelist.ProductForms;
import com.tectonica.jonix.codelist.ProductPackagingTypes;
import com.tectonica.jonix.codelist.PublishingStatuss;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.ThesisTypes;
import com.tectonica.jonix.codelist.TradeCategorys;
import com.tectonica.jonix.codelist.TransliterationSchemes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

public class Product
{
	public static final String refname = "Product";
	public static final String shortname = "product";

	public TextFormats textformat;
	public TextCaseFlags textcase;
	public LanguageCodeIso6392Bs language;
	public TransliterationSchemes transliteration;
	public String datestamp; // DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public RecordReference recordReference; // Required
	public NotificationType notificationType; // Required
	public DeletionCode deletionCode; // Optional
	public DeletionText deletionText; // Optional
	public RecordSourceType recordSourceType; // Optional
	public RecordSourceIdentifierType recordSourceIdentifierType; // Optional
	public RecordSourceIdentifier recordSourceIdentifier; // Optional
	public RecordSourceName recordSourceName; // Optional
	public ISBN isbn; // Required
	public EAN13 ean13; // Optional
	public UPC upc; // Optional
	public PublisherProductNo publisherProductNo; // Optional
	public ISMN ismn; // Optional
	public DOI doi; // Optional
	public List<ProductIdentifier> productIdentifiers; // ZeroOrMore
	public List<Barcode> barcodes; // ZeroOrMore
	public ReplacesISBN replacesISBN; // Optional
	public ReplacesEAN13 replacesEAN13; // Optional
	public ProductForm productForm; // Optional
	public List<ProductFormDetail> productFormDetails; // ZeroOrMore
	public List<ProductFormFeature> productFormFeatures; // ZeroOrMore
	public List<BookFormDetail> bookFormDetails; // ZeroOrMore
	public ProductPackaging productPackaging; // Optional
	public ProductFormDescription productFormDescription; // Optional
	public NumberOfPieces numberOfPieces; // Optional
	public TradeCategory tradeCategory; // Optional
	public List<ProductContentType> productContentTypes; // ZeroOrMore
	public List<ContainedItem> containedItems; // ZeroOrMore
	public List<ProductClassification> productClassifications; // ZeroOrMore
	public EpubType epubType; // Optional
	public EpubTypeVersion epubTypeVersion; // Optional
	public EpubTypeDescription epubTypeDescription; // Optional
	public EpubFormat epubFormat; // Optional
	public EpubFormatVersion epubFormatVersion; // Optional
	public EpubFormatDescription epubFormatDescription; // Optional
	public EpubSource epubSource; // Optional
	public EpubSourceVersion epubSourceVersion; // Optional
	public EpubSourceDescription epubSourceDescription; // Optional
	public EpubTypeNote epubTypeNote; // Optional
	public List<Series> seriess; // ZeroOrMore
	public NoSeries noSeries; // Optional
	public List<Set> sets; // ZeroOrMore
	public TextCaseFlag textCaseFlag; // Optional
	public DistinctiveTitle distinctiveTitle; // Required
	public TitlePrefix titlePrefix; // Optional
	public TitleWithoutPrefix titleWithoutPrefix; // Optional
	public Subtitle subtitle; // Optional
	public TranslationOfTitle translationOfTitle; // Optional
	public List<FormerTitle> formerTitles; // ZeroOrMore
	public List<Title> titles; // ZeroOrMore
	public List<WorkIdentifier> workIdentifiers; // ZeroOrMore
	public List<Website> websites; // ZeroOrMore
	public ThesisType thesisType; // Optional
	public ThesisPresentedTo thesisPresentedTo; // Optional
	public ThesisYear thesisYear; // Optional
	public List<Contributor> contributors; // OneOrMore
	public ContributorStatement contributorStatement; // Optional
	public NoContributor noContributor; // Optional
	public ConferenceDescription conferenceDescription; // Optional
	public ConferenceRole conferenceRole; // Optional
	public ConferenceName conferenceName; // Required
	public ConferenceNumber conferenceNumber; // Optional
	public ConferenceDate conferenceDate; // Optional
	public ConferencePlace conferencePlace; // Optional
	public List<Conference> conferences; // ZeroOrMore
	public List<EditionTypeCode> editionTypeCodes; // ZeroOrMore
	public EditionNumber editionNumber; // Optional
	public EditionVersionNumber editionVersionNumber; // Optional
	public EditionStatement editionStatement; // Optional
	public NoEdition noEdition; // Optional
	public ReligiousText religiousText; // Optional
	public List<LanguageOfText> languageOfTexts; // ZeroOrMore
	public OriginalLanguage originalLanguage; // Optional
	public List<Language> languages; // ZeroOrMore
	public NumberOfPages numberOfPages; // Optional
	public PagesRoman pagesRoman; // Optional
	public PagesArabic pagesArabic; // Optional
	public List<Extent> extents; // ZeroOrMore
	public NumberOfIllustrations numberOfIllustrations; // Optional
	public IllustrationsNote illustrationsNote; // Optional
	public List<Illustrations> illustrationss; // ZeroOrMore
	public List<MapScale> mapScales; // ZeroOrMore
	public BASICMainSubject basicMainSubject; // Optional
	public BASICVersion basicVersion; // Optional
	public BICMainSubject bicMainSubject; // Optional
	public BICVersion bicVersion; // Optional
	public List<MainSubject> mainSubjects; // ZeroOrMore
	public List<Subject> subjects; // ZeroOrMore
	public List<PersonAsSubject> personAsSubjects; // ZeroOrMore
	public List<CorporateBodyAsSubject> corporateBodyAsSubjects; // ZeroOrMore
	public List<PlaceAsSubject> placeAsSubjects; // ZeroOrMore
	public List<AudienceCode> audienceCodes; // ZeroOrMore
	public List<Audience> audiences; // ZeroOrMore
	public USSchoolGrade usSchoolGrade; // Optional
	public InterestAge interestAge; // Optional
	public List<AudienceRange> audienceRanges; // ZeroOrMore
	public AudienceDescription audienceDescription; // Optional
	public List<Complexity> complexitys; // ZeroOrMore
	public Annotation annotation; // Optional
	public MainDescription mainDescription; // Optional
	public List<OtherText> otherTexts; // ZeroOrMore
	public List<ReviewQuote> reviewQuotes; // ZeroOrMore
	public CoverImageFormatCode coverImageFormatCode; // Optional
	public CoverImageLinkTypeCode coverImageLinkTypeCode; // Optional
	public CoverImageLink coverImageLink; // Optional
	public List<MediaFile> mediaFiles; // ZeroOrMore
	public List<ProductWebsite> productWebsites; // ZeroOrMore
	public PrizesDescription prizesDescription; // Optional
	public List<Prize> prizes; // ZeroOrMore
	public List<ContentItem> contentItems; // ZeroOrMore
	public ImprintName imprintName; // Required
	public List<Imprint> imprints; // ZeroOrMore
	public PublisherName publisherName; // Optional
	public List<Publisher> publishers; // ZeroOrMore
	public List<CityOfPublication> cityOfPublications; // ZeroOrMore
	public CountryOfPublication countryOfPublication; // Optional
	public List<CopublisherName> copublisherNames; // ZeroOrMore
	public List<SponsorName> sponsorNames; // ZeroOrMore
	public OriginalPublisher originalPublisher; // Optional
	public PublishingStatus publishingStatus; // Optional
	public PublishingStatusNote publishingStatusNote; // Optional
	public AnnouncementDate announcementDate; // Optional
	public TradeAnnouncementDate tradeAnnouncementDate; // Optional
	public PublicationDate publicationDate; // Optional
	public List<CopyrightStatement> copyrightStatements; // ZeroOrMore
	public CopyrightYear copyrightYear; // Optional
	public YearFirstPublished yearFirstPublished; // Optional
	public List<SalesRights> salesRightss; // ZeroOrMore
	public List<NotForSale> notForSales; // ZeroOrMore
	public List<SalesRestriction> salesRestrictions; // ZeroOrMore
	public Height height; // Required
	public Width width; // Optional
	public Thickness thickness; // Optional
	public Weight weight; // Optional
	public List<Measure> measures; // ZeroOrMore
	public Dimensions dimensions; // Optional
	public ReplacedByISBN replacedByISBN; // Optional
	public ReplacedByEAN13 replacedByEAN13; // Optional
	public AlternativeFormatISBN alternativeFormatISBN; // Optional
	public AlternativeFormatEAN13 alternativeFormatEAN13; // Optional
	public AlternativeProductISBN alternativeProductISBN; // Optional
	public AlternativeProductEAN13 alternativeProductEAN13; // Optional
	public List<RelatedProduct> relatedProducts; // ZeroOrMore
	public OutOfPrintDate outOfPrintDate; // Optional
	public List<SupplyDetail> supplyDetails; // ZeroOrMore
	public List<MarketRepresentation> marketRepresentations; // ZeroOrMore
	public PromotionCampaign promotionCampaign; // Optional
	public PromotionContact promotionContact; // Optional
	public InitialPrintRun initialPrintRun; // Optional
	public List<ReprintDetail> reprintDetails; // ZeroOrMore
	public CopiesSold copiesSold; // Optional
	public BookClubAdoption bookClubAdoption; // Optional

	public static Product fromDoc(org.w3c.dom.Element element)
	{
		final Product x = new Product();

		x.textformat = TextFormats.byValue(DU.getAttribute(element, "textformat"));
		x.textcase = TextCaseFlags.byValue(DU.getAttribute(element, "textcase"));
		x.language = LanguageCodeIso6392Bs.byValue(DU.getAttribute(element, "language"));
		x.transliteration = TransliterationSchemes.byValue(DU.getAttribute(element, "transliteration"));
		x.datestamp = DU.getAttribute(element, "datestamp");
		x.sourcetype = RecordSourceTypes.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		DU.forElementsOf(element, new DU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(RecordReference.refname) || name.equals(RecordReference.shortname))
					x.recordReference = RecordReference.fromDoc(element);
				else if (name.equals(NotificationType.refname) || name.equals(NotificationType.shortname))
					x.notificationType = NotificationType.fromDoc(element);
				else if (name.equals(DeletionCode.refname) || name.equals(DeletionCode.shortname))
					x.deletionCode = DeletionCode.fromDoc(element);
				else if (name.equals(DeletionText.refname) || name.equals(DeletionText.shortname))
					x.deletionText = DeletionText.fromDoc(element);
				else if (name.equals(RecordSourceType.refname) || name.equals(RecordSourceType.shortname))
					x.recordSourceType = RecordSourceType.fromDoc(element);
				else if (name.equals(RecordSourceIdentifierType.refname) || name.equals(RecordSourceIdentifierType.shortname))
					x.recordSourceIdentifierType = RecordSourceIdentifierType.fromDoc(element);
				else if (name.equals(RecordSourceIdentifier.refname) || name.equals(RecordSourceIdentifier.shortname))
					x.recordSourceIdentifier = RecordSourceIdentifier.fromDoc(element);
				else if (name.equals(RecordSourceName.refname) || name.equals(RecordSourceName.shortname))
					x.recordSourceName = RecordSourceName.fromDoc(element);
				else if (name.equals(ISBN.refname) || name.equals(ISBN.shortname))
					x.isbn = ISBN.fromDoc(element);
				else if (name.equals(EAN13.refname) || name.equals(EAN13.shortname))
					x.ean13 = EAN13.fromDoc(element);
				else if (name.equals(UPC.refname) || name.equals(UPC.shortname))
					x.upc = UPC.fromDoc(element);
				else if (name.equals(PublisherProductNo.refname) || name.equals(PublisherProductNo.shortname))
					x.publisherProductNo = PublisherProductNo.fromDoc(element);
				else if (name.equals(ISMN.refname) || name.equals(ISMN.shortname))
					x.ismn = ISMN.fromDoc(element);
				else if (name.equals(DOI.refname) || name.equals(DOI.shortname))
					x.doi = DOI.fromDoc(element);
				else if (name.equals(ProductIdentifier.refname) || name.equals(ProductIdentifier.shortname))
					x.productIdentifiers = DU.addToList(x.productIdentifiers, ProductIdentifier.fromDoc(element));
				else if (name.equals(Barcode.refname) || name.equals(Barcode.shortname))
					x.barcodes = DU.addToList(x.barcodes, Barcode.fromDoc(element));
				else if (name.equals(ReplacesISBN.refname) || name.equals(ReplacesISBN.shortname))
					x.replacesISBN = ReplacesISBN.fromDoc(element);
				else if (name.equals(ReplacesEAN13.refname) || name.equals(ReplacesEAN13.shortname))
					x.replacesEAN13 = ReplacesEAN13.fromDoc(element);
				else if (name.equals(ProductForm.refname) || name.equals(ProductForm.shortname))
					x.productForm = ProductForm.fromDoc(element);
				else if (name.equals(ProductFormDetail.refname) || name.equals(ProductFormDetail.shortname))
					x.productFormDetails = DU.addToList(x.productFormDetails, ProductFormDetail.fromDoc(element));
				else if (name.equals(ProductFormFeature.refname) || name.equals(ProductFormFeature.shortname))
					x.productFormFeatures = DU.addToList(x.productFormFeatures, ProductFormFeature.fromDoc(element));
				else if (name.equals(BookFormDetail.refname) || name.equals(BookFormDetail.shortname))
					x.bookFormDetails = DU.addToList(x.bookFormDetails, BookFormDetail.fromDoc(element));
				else if (name.equals(ProductPackaging.refname) || name.equals(ProductPackaging.shortname))
					x.productPackaging = ProductPackaging.fromDoc(element);
				else if (name.equals(ProductFormDescription.refname) || name.equals(ProductFormDescription.shortname))
					x.productFormDescription = ProductFormDescription.fromDoc(element);
				else if (name.equals(NumberOfPieces.refname) || name.equals(NumberOfPieces.shortname))
					x.numberOfPieces = NumberOfPieces.fromDoc(element);
				else if (name.equals(TradeCategory.refname) || name.equals(TradeCategory.shortname))
					x.tradeCategory = TradeCategory.fromDoc(element);
				else if (name.equals(ProductContentType.refname) || name.equals(ProductContentType.shortname))
					x.productContentTypes = DU.addToList(x.productContentTypes, ProductContentType.fromDoc(element));
				else if (name.equals(ContainedItem.refname) || name.equals(ContainedItem.shortname))
					x.containedItems = DU.addToList(x.containedItems, ContainedItem.fromDoc(element));
				else if (name.equals(ProductClassification.refname) || name.equals(ProductClassification.shortname))
					x.productClassifications = DU.addToList(x.productClassifications, ProductClassification.fromDoc(element));
				else if (name.equals(EpubType.refname) || name.equals(EpubType.shortname))
					x.epubType = EpubType.fromDoc(element);
				else if (name.equals(EpubTypeVersion.refname) || name.equals(EpubTypeVersion.shortname))
					x.epubTypeVersion = EpubTypeVersion.fromDoc(element);
				else if (name.equals(EpubTypeDescription.refname) || name.equals(EpubTypeDescription.shortname))
					x.epubTypeDescription = EpubTypeDescription.fromDoc(element);
				else if (name.equals(EpubFormat.refname) || name.equals(EpubFormat.shortname))
					x.epubFormat = EpubFormat.fromDoc(element);
				else if (name.equals(EpubFormatVersion.refname) || name.equals(EpubFormatVersion.shortname))
					x.epubFormatVersion = EpubFormatVersion.fromDoc(element);
				else if (name.equals(EpubFormatDescription.refname) || name.equals(EpubFormatDescription.shortname))
					x.epubFormatDescription = EpubFormatDescription.fromDoc(element);
				else if (name.equals(EpubSource.refname) || name.equals(EpubSource.shortname))
					x.epubSource = EpubSource.fromDoc(element);
				else if (name.equals(EpubSourceVersion.refname) || name.equals(EpubSourceVersion.shortname))
					x.epubSourceVersion = EpubSourceVersion.fromDoc(element);
				else if (name.equals(EpubSourceDescription.refname) || name.equals(EpubSourceDescription.shortname))
					x.epubSourceDescription = EpubSourceDescription.fromDoc(element);
				else if (name.equals(EpubTypeNote.refname) || name.equals(EpubTypeNote.shortname))
					x.epubTypeNote = EpubTypeNote.fromDoc(element);
				else if (name.equals(Series.refname) || name.equals(Series.shortname))
					x.seriess = DU.addToList(x.seriess, Series.fromDoc(element));
				else if (name.equals(NoSeries.refname) || name.equals(NoSeries.shortname))
					x.noSeries = NoSeries.fromDoc(element);
				else if (name.equals(Set.refname) || name.equals(Set.shortname))
					x.sets = DU.addToList(x.sets, Set.fromDoc(element));
				else if (name.equals(TextCaseFlag.refname) || name.equals(TextCaseFlag.shortname))
					x.textCaseFlag = TextCaseFlag.fromDoc(element);
				else if (name.equals(DistinctiveTitle.refname) || name.equals(DistinctiveTitle.shortname))
					x.distinctiveTitle = DistinctiveTitle.fromDoc(element);
				else if (name.equals(TitlePrefix.refname) || name.equals(TitlePrefix.shortname))
					x.titlePrefix = TitlePrefix.fromDoc(element);
				else if (name.equals(TitleWithoutPrefix.refname) || name.equals(TitleWithoutPrefix.shortname))
					x.titleWithoutPrefix = TitleWithoutPrefix.fromDoc(element);
				else if (name.equals(Subtitle.refname) || name.equals(Subtitle.shortname))
					x.subtitle = Subtitle.fromDoc(element);
				else if (name.equals(TranslationOfTitle.refname) || name.equals(TranslationOfTitle.shortname))
					x.translationOfTitle = TranslationOfTitle.fromDoc(element);
				else if (name.equals(FormerTitle.refname) || name.equals(FormerTitle.shortname))
					x.formerTitles = DU.addToList(x.formerTitles, FormerTitle.fromDoc(element));
				else if (name.equals(Title.refname) || name.equals(Title.shortname))
					x.titles = DU.addToList(x.titles, Title.fromDoc(element));
				else if (name.equals(WorkIdentifier.refname) || name.equals(WorkIdentifier.shortname))
					x.workIdentifiers = DU.addToList(x.workIdentifiers, WorkIdentifier.fromDoc(element));
				else if (name.equals(Website.refname) || name.equals(Website.shortname))
					x.websites = DU.addToList(x.websites, Website.fromDoc(element));
				else if (name.equals(ThesisType.refname) || name.equals(ThesisType.shortname))
					x.thesisType = ThesisType.fromDoc(element);
				else if (name.equals(ThesisPresentedTo.refname) || name.equals(ThesisPresentedTo.shortname))
					x.thesisPresentedTo = ThesisPresentedTo.fromDoc(element);
				else if (name.equals(ThesisYear.refname) || name.equals(ThesisYear.shortname))
					x.thesisYear = ThesisYear.fromDoc(element);
				else if (name.equals(Contributor.refname) || name.equals(Contributor.shortname))
					x.contributors = DU.addToList(x.contributors, Contributor.fromDoc(element));
				else if (name.equals(ContributorStatement.refname) || name.equals(ContributorStatement.shortname))
					x.contributorStatement = ContributorStatement.fromDoc(element);
				else if (name.equals(NoContributor.refname) || name.equals(NoContributor.shortname))
					x.noContributor = NoContributor.fromDoc(element);
				else if (name.equals(ConferenceDescription.refname) || name.equals(ConferenceDescription.shortname))
					x.conferenceDescription = ConferenceDescription.fromDoc(element);
				else if (name.equals(ConferenceRole.refname) || name.equals(ConferenceRole.shortname))
					x.conferenceRole = ConferenceRole.fromDoc(element);
				else if (name.equals(ConferenceName.refname) || name.equals(ConferenceName.shortname))
					x.conferenceName = ConferenceName.fromDoc(element);
				else if (name.equals(ConferenceNumber.refname) || name.equals(ConferenceNumber.shortname))
					x.conferenceNumber = ConferenceNumber.fromDoc(element);
				else if (name.equals(ConferenceDate.refname) || name.equals(ConferenceDate.shortname))
					x.conferenceDate = ConferenceDate.fromDoc(element);
				else if (name.equals(ConferencePlace.refname) || name.equals(ConferencePlace.shortname))
					x.conferencePlace = ConferencePlace.fromDoc(element);
				else if (name.equals(Conference.refname) || name.equals(Conference.shortname))
					x.conferences = DU.addToList(x.conferences, Conference.fromDoc(element));
				else if (name.equals(EditionTypeCode.refname) || name.equals(EditionTypeCode.shortname))
					x.editionTypeCodes = DU.addToList(x.editionTypeCodes, EditionTypeCode.fromDoc(element));
				else if (name.equals(EditionNumber.refname) || name.equals(EditionNumber.shortname))
					x.editionNumber = EditionNumber.fromDoc(element);
				else if (name.equals(EditionVersionNumber.refname) || name.equals(EditionVersionNumber.shortname))
					x.editionVersionNumber = EditionVersionNumber.fromDoc(element);
				else if (name.equals(EditionStatement.refname) || name.equals(EditionStatement.shortname))
					x.editionStatement = EditionStatement.fromDoc(element);
				else if (name.equals(NoEdition.refname) || name.equals(NoEdition.shortname))
					x.noEdition = NoEdition.fromDoc(element);
				else if (name.equals(ReligiousText.refname) || name.equals(ReligiousText.shortname))
					x.religiousText = ReligiousText.fromDoc(element);
				else if (name.equals(LanguageOfText.refname) || name.equals(LanguageOfText.shortname))
					x.languageOfTexts = DU.addToList(x.languageOfTexts, LanguageOfText.fromDoc(element));
				else if (name.equals(OriginalLanguage.refname) || name.equals(OriginalLanguage.shortname))
					x.originalLanguage = OriginalLanguage.fromDoc(element);
				else if (name.equals(Language.refname) || name.equals(Language.shortname))
					x.languages = DU.addToList(x.languages, Language.fromDoc(element));
				else if (name.equals(NumberOfPages.refname) || name.equals(NumberOfPages.shortname))
					x.numberOfPages = NumberOfPages.fromDoc(element);
				else if (name.equals(PagesRoman.refname) || name.equals(PagesRoman.shortname))
					x.pagesRoman = PagesRoman.fromDoc(element);
				else if (name.equals(PagesArabic.refname) || name.equals(PagesArabic.shortname))
					x.pagesArabic = PagesArabic.fromDoc(element);
				else if (name.equals(Extent.refname) || name.equals(Extent.shortname))
					x.extents = DU.addToList(x.extents, Extent.fromDoc(element));
				else if (name.equals(NumberOfIllustrations.refname) || name.equals(NumberOfIllustrations.shortname))
					x.numberOfIllustrations = NumberOfIllustrations.fromDoc(element);
				else if (name.equals(IllustrationsNote.refname) || name.equals(IllustrationsNote.shortname))
					x.illustrationsNote = IllustrationsNote.fromDoc(element);
				else if (name.equals(Illustrations.refname) || name.equals(Illustrations.shortname))
					x.illustrationss = DU.addToList(x.illustrationss, Illustrations.fromDoc(element));
				else if (name.equals(MapScale.refname) || name.equals(MapScale.shortname))
					x.mapScales = DU.addToList(x.mapScales, MapScale.fromDoc(element));
				else if (name.equals(BASICMainSubject.refname) || name.equals(BASICMainSubject.shortname))
					x.basicMainSubject = BASICMainSubject.fromDoc(element);
				else if (name.equals(BASICVersion.refname) || name.equals(BASICVersion.shortname))
					x.basicVersion = BASICVersion.fromDoc(element);
				else if (name.equals(BICMainSubject.refname) || name.equals(BICMainSubject.shortname))
					x.bicMainSubject = BICMainSubject.fromDoc(element);
				else if (name.equals(BICVersion.refname) || name.equals(BICVersion.shortname))
					x.bicVersion = BICVersion.fromDoc(element);
				else if (name.equals(MainSubject.refname) || name.equals(MainSubject.shortname))
					x.mainSubjects = DU.addToList(x.mainSubjects, MainSubject.fromDoc(element));
				else if (name.equals(Subject.refname) || name.equals(Subject.shortname))
					x.subjects = DU.addToList(x.subjects, Subject.fromDoc(element));
				else if (name.equals(PersonAsSubject.refname) || name.equals(PersonAsSubject.shortname))
					x.personAsSubjects = DU.addToList(x.personAsSubjects, PersonAsSubject.fromDoc(element));
				else if (name.equals(CorporateBodyAsSubject.refname) || name.equals(CorporateBodyAsSubject.shortname))
					x.corporateBodyAsSubjects = DU.addToList(x.corporateBodyAsSubjects, CorporateBodyAsSubject.fromDoc(element));
				else if (name.equals(PlaceAsSubject.refname) || name.equals(PlaceAsSubject.shortname))
					x.placeAsSubjects = DU.addToList(x.placeAsSubjects, PlaceAsSubject.fromDoc(element));
				else if (name.equals(AudienceCode.refname) || name.equals(AudienceCode.shortname))
					x.audienceCodes = DU.addToList(x.audienceCodes, AudienceCode.fromDoc(element));
				else if (name.equals(Audience.refname) || name.equals(Audience.shortname))
					x.audiences = DU.addToList(x.audiences, Audience.fromDoc(element));
				else if (name.equals(USSchoolGrade.refname) || name.equals(USSchoolGrade.shortname))
					x.usSchoolGrade = USSchoolGrade.fromDoc(element);
				else if (name.equals(InterestAge.refname) || name.equals(InterestAge.shortname))
					x.interestAge = InterestAge.fromDoc(element);
				else if (name.equals(AudienceRange.refname) || name.equals(AudienceRange.shortname))
					x.audienceRanges = DU.addToList(x.audienceRanges, AudienceRange.fromDoc(element));
				else if (name.equals(AudienceDescription.refname) || name.equals(AudienceDescription.shortname))
					x.audienceDescription = AudienceDescription.fromDoc(element);
				else if (name.equals(Complexity.refname) || name.equals(Complexity.shortname))
					x.complexitys = DU.addToList(x.complexitys, Complexity.fromDoc(element));
				else if (name.equals(Annotation.refname) || name.equals(Annotation.shortname))
					x.annotation = Annotation.fromDoc(element);
				else if (name.equals(MainDescription.refname) || name.equals(MainDescription.shortname))
					x.mainDescription = MainDescription.fromDoc(element);
				else if (name.equals(OtherText.refname) || name.equals(OtherText.shortname))
					x.otherTexts = DU.addToList(x.otherTexts, OtherText.fromDoc(element));
				else if (name.equals(ReviewQuote.refname) || name.equals(ReviewQuote.shortname))
					x.reviewQuotes = DU.addToList(x.reviewQuotes, ReviewQuote.fromDoc(element));
				else if (name.equals(CoverImageFormatCode.refname) || name.equals(CoverImageFormatCode.shortname))
					x.coverImageFormatCode = CoverImageFormatCode.fromDoc(element);
				else if (name.equals(CoverImageLinkTypeCode.refname) || name.equals(CoverImageLinkTypeCode.shortname))
					x.coverImageLinkTypeCode = CoverImageLinkTypeCode.fromDoc(element);
				else if (name.equals(CoverImageLink.refname) || name.equals(CoverImageLink.shortname))
					x.coverImageLink = CoverImageLink.fromDoc(element);
				else if (name.equals(MediaFile.refname) || name.equals(MediaFile.shortname))
					x.mediaFiles = DU.addToList(x.mediaFiles, MediaFile.fromDoc(element));
				else if (name.equals(ProductWebsite.refname) || name.equals(ProductWebsite.shortname))
					x.productWebsites = DU.addToList(x.productWebsites, ProductWebsite.fromDoc(element));
				else if (name.equals(PrizesDescription.refname) || name.equals(PrizesDescription.shortname))
					x.prizesDescription = PrizesDescription.fromDoc(element);
				else if (name.equals(Prize.refname) || name.equals(Prize.shortname))
					x.prizes = DU.addToList(x.prizes, Prize.fromDoc(element));
				else if (name.equals(ContentItem.refname) || name.equals(ContentItem.shortname))
					x.contentItems = DU.addToList(x.contentItems, ContentItem.fromDoc(element));
				else if (name.equals(ImprintName.refname) || name.equals(ImprintName.shortname))
					x.imprintName = ImprintName.fromDoc(element);
				else if (name.equals(Imprint.refname) || name.equals(Imprint.shortname))
					x.imprints = DU.addToList(x.imprints, Imprint.fromDoc(element));
				else if (name.equals(PublisherName.refname) || name.equals(PublisherName.shortname))
					x.publisherName = PublisherName.fromDoc(element);
				else if (name.equals(Publisher.refname) || name.equals(Publisher.shortname))
					x.publishers = DU.addToList(x.publishers, Publisher.fromDoc(element));
				else if (name.equals(CityOfPublication.refname) || name.equals(CityOfPublication.shortname))
					x.cityOfPublications = DU.addToList(x.cityOfPublications, CityOfPublication.fromDoc(element));
				else if (name.equals(CountryOfPublication.refname) || name.equals(CountryOfPublication.shortname))
					x.countryOfPublication = CountryOfPublication.fromDoc(element);
				else if (name.equals(CopublisherName.refname) || name.equals(CopublisherName.shortname))
					x.copublisherNames = DU.addToList(x.copublisherNames, CopublisherName.fromDoc(element));
				else if (name.equals(SponsorName.refname) || name.equals(SponsorName.shortname))
					x.sponsorNames = DU.addToList(x.sponsorNames, SponsorName.fromDoc(element));
				else if (name.equals(OriginalPublisher.refname) || name.equals(OriginalPublisher.shortname))
					x.originalPublisher = OriginalPublisher.fromDoc(element);
				else if (name.equals(PublishingStatus.refname) || name.equals(PublishingStatus.shortname))
					x.publishingStatus = PublishingStatus.fromDoc(element);
				else if (name.equals(PublishingStatusNote.refname) || name.equals(PublishingStatusNote.shortname))
					x.publishingStatusNote = PublishingStatusNote.fromDoc(element);
				else if (name.equals(AnnouncementDate.refname) || name.equals(AnnouncementDate.shortname))
					x.announcementDate = AnnouncementDate.fromDoc(element);
				else if (name.equals(TradeAnnouncementDate.refname) || name.equals(TradeAnnouncementDate.shortname))
					x.tradeAnnouncementDate = TradeAnnouncementDate.fromDoc(element);
				else if (name.equals(PublicationDate.refname) || name.equals(PublicationDate.shortname))
					x.publicationDate = PublicationDate.fromDoc(element);
				else if (name.equals(CopyrightStatement.refname) || name.equals(CopyrightStatement.shortname))
					x.copyrightStatements = DU.addToList(x.copyrightStatements, CopyrightStatement.fromDoc(element));
				else if (name.equals(CopyrightYear.refname) || name.equals(CopyrightYear.shortname))
					x.copyrightYear = CopyrightYear.fromDoc(element);
				else if (name.equals(YearFirstPublished.refname) || name.equals(YearFirstPublished.shortname))
					x.yearFirstPublished = YearFirstPublished.fromDoc(element);
				else if (name.equals(SalesRights.refname) || name.equals(SalesRights.shortname))
					x.salesRightss = DU.addToList(x.salesRightss, SalesRights.fromDoc(element));
				else if (name.equals(NotForSale.refname) || name.equals(NotForSale.shortname))
					x.notForSales = DU.addToList(x.notForSales, NotForSale.fromDoc(element));
				else if (name.equals(SalesRestriction.refname) || name.equals(SalesRestriction.shortname))
					x.salesRestrictions = DU.addToList(x.salesRestrictions, SalesRestriction.fromDoc(element));
				else if (name.equals(Height.refname) || name.equals(Height.shortname))
					x.height = Height.fromDoc(element);
				else if (name.equals(Width.refname) || name.equals(Width.shortname))
					x.width = Width.fromDoc(element);
				else if (name.equals(Thickness.refname) || name.equals(Thickness.shortname))
					x.thickness = Thickness.fromDoc(element);
				else if (name.equals(Weight.refname) || name.equals(Weight.shortname))
					x.weight = Weight.fromDoc(element);
				else if (name.equals(Measure.refname) || name.equals(Measure.shortname))
					x.measures = DU.addToList(x.measures, Measure.fromDoc(element));
				else if (name.equals(Dimensions.refname) || name.equals(Dimensions.shortname))
					x.dimensions = Dimensions.fromDoc(element);
				else if (name.equals(ReplacedByISBN.refname) || name.equals(ReplacedByISBN.shortname))
					x.replacedByISBN = ReplacedByISBN.fromDoc(element);
				else if (name.equals(ReplacedByEAN13.refname) || name.equals(ReplacedByEAN13.shortname))
					x.replacedByEAN13 = ReplacedByEAN13.fromDoc(element);
				else if (name.equals(AlternativeFormatISBN.refname) || name.equals(AlternativeFormatISBN.shortname))
					x.alternativeFormatISBN = AlternativeFormatISBN.fromDoc(element);
				else if (name.equals(AlternativeFormatEAN13.refname) || name.equals(AlternativeFormatEAN13.shortname))
					x.alternativeFormatEAN13 = AlternativeFormatEAN13.fromDoc(element);
				else if (name.equals(AlternativeProductISBN.refname) || name.equals(AlternativeProductISBN.shortname))
					x.alternativeProductISBN = AlternativeProductISBN.fromDoc(element);
				else if (name.equals(AlternativeProductEAN13.refname) || name.equals(AlternativeProductEAN13.shortname))
					x.alternativeProductEAN13 = AlternativeProductEAN13.fromDoc(element);
				else if (name.equals(RelatedProduct.refname) || name.equals(RelatedProduct.shortname))
					x.relatedProducts = DU.addToList(x.relatedProducts, RelatedProduct.fromDoc(element));
				else if (name.equals(OutOfPrintDate.refname) || name.equals(OutOfPrintDate.shortname))
					x.outOfPrintDate = OutOfPrintDate.fromDoc(element);
				else if (name.equals(SupplyDetail.refname) || name.equals(SupplyDetail.shortname))
					x.supplyDetails = DU.addToList(x.supplyDetails, SupplyDetail.fromDoc(element));
				else if (name.equals(MarketRepresentation.refname) || name.equals(MarketRepresentation.shortname))
					x.marketRepresentations = DU.addToList(x.marketRepresentations, MarketRepresentation.fromDoc(element));
				else if (name.equals(PromotionCampaign.refname) || name.equals(PromotionCampaign.shortname))
					x.promotionCampaign = PromotionCampaign.fromDoc(element);
				else if (name.equals(PromotionContact.refname) || name.equals(PromotionContact.shortname))
					x.promotionContact = PromotionContact.fromDoc(element);
				else if (name.equals(InitialPrintRun.refname) || name.equals(InitialPrintRun.shortname))
					x.initialPrintRun = InitialPrintRun.fromDoc(element);
				else if (name.equals(ReprintDetail.refname) || name.equals(ReprintDetail.shortname))
					x.reprintDetails = DU.addToList(x.reprintDetails, ReprintDetail.fromDoc(element));
				else if (name.equals(CopiesSold.refname) || name.equals(CopiesSold.shortname))
					x.copiesSold = CopiesSold.fromDoc(element);
				else if (name.equals(BookClubAdoption.refname) || name.equals(BookClubAdoption.shortname))
					x.bookClubAdoption = BookClubAdoption.fromDoc(element);
			}
		});

		return x;
	}

	public String getRecordReferenceValue()
	{
		return (recordReference == null) ? null : recordReference.value;
	}

	public NotificationOrUpdateTypes getNotificationTypeValue()
	{
		return (notificationType == null) ? null : notificationType.value;
	}

	public ProductCompositions getDeletionCodeValue()
	{
		return (deletionCode == null) ? null : deletionCode.value;
	}

	public String getDeletionTextValue()
	{
		return (deletionText == null) ? null : deletionText.value;
	}

	public RecordSourceTypes getRecordSourceTypeValue()
	{
		return (recordSourceType == null) ? null : recordSourceType.value;
	}

	public NameCodeTypes getRecordSourceIdentifierTypeValue()
	{
		return (recordSourceIdentifierType == null) ? null : recordSourceIdentifierType.value;
	}

	public String getRecordSourceIdentifierValue()
	{
		return (recordSourceIdentifier == null) ? null : recordSourceIdentifier.value;
	}

	public String getRecordSourceNameValue()
	{
		return (recordSourceName == null) ? null : recordSourceName.value;
	}

	public String getISBNValue()
	{
		return (isbn == null) ? null : isbn.value;
	}

	public String getEAN13Value()
	{
		return (ean13 == null) ? null : ean13.value;
	}

	public String getUPCValue()
	{
		return (upc == null) ? null : upc.value;
	}

	public String getPublisherProductNoValue()
	{
		return (publisherProductNo == null) ? null : publisherProductNo.value;
	}

	public String getISMNValue()
	{
		return (ismn == null) ? null : ismn.value;
	}

	public String getDOIValue()
	{
		return (doi == null) ? null : doi.value;
	}

	public String getReplacesISBNValue()
	{
		return (replacesISBN == null) ? null : replacesISBN.value;
	}

	public String getReplacesEAN13Value()
	{
		return (replacesEAN13 == null) ? null : replacesEAN13.value;
	}

	public ProductForms getProductFormValue()
	{
		return (productForm == null) ? null : productForm.value;
	}

	public ProductPackagingTypes getProductPackagingValue()
	{
		return (productPackaging == null) ? null : productPackaging.value;
	}

	public String getProductFormDescriptionValue()
	{
		return (productFormDescription == null) ? null : productFormDescription.value;
	}

	public String getNumberOfPiecesValue()
	{
		return (numberOfPieces == null) ? null : numberOfPieces.value;
	}

	public TradeCategorys getTradeCategoryValue()
	{
		return (tradeCategory == null) ? null : tradeCategory.value;
	}

	public EpublicationTypes getEpubTypeValue()
	{
		return (epubType == null) ? null : epubType.value;
	}

	public String getEpubTypeVersionValue()
	{
		return (epubTypeVersion == null) ? null : epubTypeVersion.value;
	}

	public String getEpubTypeDescriptionValue()
	{
		return (epubTypeDescription == null) ? null : epubTypeDescription.value;
	}

	public EpublicationFormats getEpubFormatValue()
	{
		return (epubFormat == null) ? null : epubFormat.value;
	}

	public String getEpubFormatVersionValue()
	{
		return (epubFormatVersion == null) ? null : epubFormatVersion.value;
	}

	public String getEpubFormatDescriptionValue()
	{
		return (epubFormatDescription == null) ? null : epubFormatDescription.value;
	}

	public EpublicationFormats getEpubSourceValue()
	{
		return (epubSource == null) ? null : epubSource.value;
	}

	public String getEpubSourceVersionValue()
	{
		return (epubSourceVersion == null) ? null : epubSourceVersion.value;
	}

	public String getEpubSourceDescriptionValue()
	{
		return (epubSourceDescription == null) ? null : epubSourceDescription.value;
	}

	public String getEpubTypeNoteValue()
	{
		return (epubTypeNote == null) ? null : epubTypeNote.value;
	}

	public TextCaseFlags getTextCaseFlagValue()
	{
		return (textCaseFlag == null) ? null : textCaseFlag.value;
	}

	public String getDistinctiveTitleValue()
	{
		return (distinctiveTitle == null) ? null : distinctiveTitle.value;
	}

	public String getTitlePrefixValue()
	{
		return (titlePrefix == null) ? null : titlePrefix.value;
	}

	public String getTitleWithoutPrefixValue()
	{
		return (titleWithoutPrefix == null) ? null : titleWithoutPrefix.value;
	}

	public String getSubtitleValue()
	{
		return (subtitle == null) ? null : subtitle.value;
	}

	public String getTranslationOfTitleValue()
	{
		return (translationOfTitle == null) ? null : translationOfTitle.value;
	}

	public ThesisTypes getThesisTypeValue()
	{
		return (thesisType == null) ? null : thesisType.value;
	}

	public String getThesisPresentedToValue()
	{
		return (thesisPresentedTo == null) ? null : thesisPresentedTo.value;
	}

	public String getThesisYearValue()
	{
		return (thesisYear == null) ? null : thesisYear.value;
	}

	public String getContributorStatementValue()
	{
		return (contributorStatement == null) ? null : contributorStatement.value;
	}

	public String getConferenceDescriptionValue()
	{
		return (conferenceDescription == null) ? null : conferenceDescription.value;
	}

	public String getConferenceRoleValue()
	{
		return (conferenceRole == null) ? null : conferenceRole.value;
	}

	public String getConferenceNameValue()
	{
		return (conferenceName == null) ? null : conferenceName.value;
	}

	public String getConferenceNumberValue()
	{
		return (conferenceNumber == null) ? null : conferenceNumber.value;
	}

	public String getConferenceDateValue()
	{
		return (conferenceDate == null) ? null : conferenceDate.value;
	}

	public String getConferencePlaceValue()
	{
		return (conferencePlace == null) ? null : conferencePlace.value;
	}

	public String getEditionNumberValue()
	{
		return (editionNumber == null) ? null : editionNumber.value;
	}

	public String getEditionVersionNumberValue()
	{
		return (editionVersionNumber == null) ? null : editionVersionNumber.value;
	}

	public String getEditionStatementValue()
	{
		return (editionStatement == null) ? null : editionStatement.value;
	}

	public LanguageCodeIso6392Bs getOriginalLanguageValue()
	{
		return (originalLanguage == null) ? null : originalLanguage.value;
	}

	public String getNumberOfPagesValue()
	{
		return (numberOfPages == null) ? null : numberOfPages.value;
	}

	public String getPagesRomanValue()
	{
		return (pagesRoman == null) ? null : pagesRoman.value;
	}

	public String getPagesArabicValue()
	{
		return (pagesArabic == null) ? null : pagesArabic.value;
	}

	public String getNumberOfIllustrationsValue()
	{
		return (numberOfIllustrations == null) ? null : numberOfIllustrations.value;
	}

	public String getIllustrationsNoteValue()
	{
		return (illustrationsNote == null) ? null : illustrationsNote.value;
	}

	public String getBASICMainSubjectValue()
	{
		return (basicMainSubject == null) ? null : basicMainSubject.value;
	}

	public String getBASICVersionValue()
	{
		return (basicVersion == null) ? null : basicVersion.value;
	}

	public String getBICMainSubjectValue()
	{
		return (bicMainSubject == null) ? null : bicMainSubject.value;
	}

	public String getBICVersionValue()
	{
		return (bicVersion == null) ? null : bicVersion.value;
	}

	public String getUSSchoolGradeValue()
	{
		return (usSchoolGrade == null) ? null : usSchoolGrade.value;
	}

	public String getInterestAgeValue()
	{
		return (interestAge == null) ? null : interestAge.value;
	}

	public String getAudienceDescriptionValue()
	{
		return (audienceDescription == null) ? null : audienceDescription.value;
	}

	public String getAnnotationValue()
	{
		return (annotation == null) ? null : annotation.value;
	}

	public String getMainDescriptionValue()
	{
		return (mainDescription == null) ? null : mainDescription.value;
	}

	public FrontCoverImageFileFormats getCoverImageFormatCodeValue()
	{
		return (coverImageFormatCode == null) ? null : coverImageFormatCode.value;
	}

	public FrontCoverImageFileLinkTypes getCoverImageLinkTypeCodeValue()
	{
		return (coverImageLinkTypeCode == null) ? null : coverImageLinkTypeCode.value;
	}

	public String getCoverImageLinkValue()
	{
		return (coverImageLink == null) ? null : coverImageLink.value;
	}

	public String getPrizesDescriptionValue()
	{
		return (prizesDescription == null) ? null : prizesDescription.value;
	}

	public String getImprintNameValue()
	{
		return (imprintName == null) ? null : imprintName.value;
	}

	public String getPublisherNameValue()
	{
		return (publisherName == null) ? null : publisherName.value;
	}

	public CountryCodeIso31661s getCountryOfPublicationValue()
	{
		return (countryOfPublication == null) ? null : countryOfPublication.value;
	}

	public String getOriginalPublisherValue()
	{
		return (originalPublisher == null) ? null : originalPublisher.value;
	}

	public PublishingStatuss getPublishingStatusValue()
	{
		return (publishingStatus == null) ? null : publishingStatus.value;
	}

	public String getPublishingStatusNoteValue()
	{
		return (publishingStatusNote == null) ? null : publishingStatusNote.value;
	}

	public String getAnnouncementDateValue()
	{
		return (announcementDate == null) ? null : announcementDate.value;
	}

	public String getTradeAnnouncementDateValue()
	{
		return (tradeAnnouncementDate == null) ? null : tradeAnnouncementDate.value;
	}

	public String getPublicationDateValue()
	{
		return (publicationDate == null) ? null : publicationDate.value;
	}

	public String getCopyrightYearValue()
	{
		return (copyrightYear == null) ? null : copyrightYear.value;
	}

	public String getYearFirstPublishedValue()
	{
		return (yearFirstPublished == null) ? null : yearFirstPublished.value;
	}

	public String getHeightValue()
	{
		return (height == null) ? null : height.value;
	}

	public String getWidthValue()
	{
		return (width == null) ? null : width.value;
	}

	public String getThicknessValue()
	{
		return (thickness == null) ? null : thickness.value;
	}

	public String getWeightValue()
	{
		return (weight == null) ? null : weight.value;
	}

	public String getDimensionsValue()
	{
		return (dimensions == null) ? null : dimensions.value;
	}

	public String getReplacedByISBNValue()
	{
		return (replacedByISBN == null) ? null : replacedByISBN.value;
	}

	public String getReplacedByEAN13Value()
	{
		return (replacedByEAN13 == null) ? null : replacedByEAN13.value;
	}

	public String getAlternativeFormatISBNValue()
	{
		return (alternativeFormatISBN == null) ? null : alternativeFormatISBN.value;
	}

	public String getAlternativeFormatEAN13Value()
	{
		return (alternativeFormatEAN13 == null) ? null : alternativeFormatEAN13.value;
	}

	public String getAlternativeProductISBNValue()
	{
		return (alternativeProductISBN == null) ? null : alternativeProductISBN.value;
	}

	public String getAlternativeProductEAN13Value()
	{
		return (alternativeProductEAN13 == null) ? null : alternativeProductEAN13.value;
	}

	public String getOutOfPrintDateValue()
	{
		return (outOfPrintDate == null) ? null : outOfPrintDate.value;
	}

	public String getPromotionCampaignValue()
	{
		return (promotionCampaign == null) ? null : promotionCampaign.value;
	}

	public String getPromotionContactValue()
	{
		return (promotionContact == null) ? null : promotionContact.value;
	}

	public String getInitialPrintRunValue()
	{
		return (initialPrintRun == null) ? null : initialPrintRun.value;
	}

	public String getCopiesSoldValue()
	{
		return (copiesSold == null) ? null : copiesSold.value;
	}

	public String getBookClubAdoptionValue()
	{
		return (bookClubAdoption == null) ? null : bookClubAdoption.value;
	}
}
