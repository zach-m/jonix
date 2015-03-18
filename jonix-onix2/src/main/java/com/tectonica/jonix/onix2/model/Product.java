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

package com.tectonica.jonix.onix2.model;

import java.util.List;

import com.tectonica.jonix.onix2.DU;
import com.tectonica.jonix.onix2.codelist.List138;
import com.tectonica.jonix.onix2.codelist.List14;
import com.tectonica.jonix.onix2.codelist.List3;
import com.tectonica.jonix.onix2.codelist.List34;
import com.tectonica.jonix.onix2.codelist.List74;

public class Product
{
	public static final String refname = "Product";
	public static final String shortname = "product";

	public List34 textformat;
	public List14 textcase;
	public List74 language;
	public List138 transliteration;
	public String datestamp; // DateOrDateTime
	public List3 sourcetype;
	public String sourcename;

	public RecordReference recordReference; // Required
	public NotificationType notificationType; // Required
	public DeletionCode deletionCode; // Optional
	public DeletionText deletionText; // Optional
	public RecordSourceType recordSourceType; // Optional
	public RecordSourceIdentifierType recordSourceIdentifierType; // Optional
	public RecordSourceIdentifier recordSourceIdentifier; // Optional
	public RecordSourceName recordSourceName; // Optional
	public ISBN isbN; // Required
	public EAN13 ean13; // Optional
	public UPC upC; // Optional
	public PublisherProductNo publisherProductNo; // Optional
	public ISMN ismN; // Optional
	public DOI doI; // Optional
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

		x.textformat = List34.byValue(DU.getAttribute(element, "textformat"));
		x.textcase = List14.byValue(DU.getAttribute(element, "textcase"));
		x.language = List74.byValue(DU.getAttribute(element, "language"));
		x.transliteration = List138.byValue(DU.getAttribute(element, "transliteration"));
		x.datestamp = DU.getAttribute(element, "datestamp");
		x.sourcetype = List3.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		DU.forElementsOf(element, new DU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equalsIgnoreCase(RecordReference.refname) || name.equalsIgnoreCase(RecordReference.shortname))
					x.recordReference = RecordReference.fromDoc(element);
				else if (name.equalsIgnoreCase(NotificationType.refname) || name.equalsIgnoreCase(NotificationType.shortname))
					x.notificationType = NotificationType.fromDoc(element);
				else if (name.equalsIgnoreCase(DeletionCode.refname) || name.equalsIgnoreCase(DeletionCode.shortname))
					x.deletionCode = DeletionCode.fromDoc(element);
				else if (name.equalsIgnoreCase(DeletionText.refname) || name.equalsIgnoreCase(DeletionText.shortname))
					x.deletionText = DeletionText.fromDoc(element);
				else if (name.equalsIgnoreCase(RecordSourceType.refname) || name.equalsIgnoreCase(RecordSourceType.shortname))
					x.recordSourceType = RecordSourceType.fromDoc(element);
				else if (name.equalsIgnoreCase(RecordSourceIdentifierType.refname)
						|| name.equalsIgnoreCase(RecordSourceIdentifierType.shortname))
					x.recordSourceIdentifierType = RecordSourceIdentifierType.fromDoc(element);
				else if (name.equalsIgnoreCase(RecordSourceIdentifier.refname) || name.equalsIgnoreCase(RecordSourceIdentifier.shortname))
					x.recordSourceIdentifier = RecordSourceIdentifier.fromDoc(element);
				else if (name.equalsIgnoreCase(RecordSourceName.refname) || name.equalsIgnoreCase(RecordSourceName.shortname))
					x.recordSourceName = RecordSourceName.fromDoc(element);
				else if (name.equalsIgnoreCase(ISBN.refname) || name.equalsIgnoreCase(ISBN.shortname))
					x.isbN = ISBN.fromDoc(element);
				else if (name.equalsIgnoreCase(EAN13.refname) || name.equalsIgnoreCase(EAN13.shortname))
					x.ean13 = EAN13.fromDoc(element);
				else if (name.equalsIgnoreCase(UPC.refname) || name.equalsIgnoreCase(UPC.shortname))
					x.upC = UPC.fromDoc(element);
				else if (name.equalsIgnoreCase(PublisherProductNo.refname) || name.equalsIgnoreCase(PublisherProductNo.shortname))
					x.publisherProductNo = PublisherProductNo.fromDoc(element);
				else if (name.equalsIgnoreCase(ISMN.refname) || name.equalsIgnoreCase(ISMN.shortname))
					x.ismN = ISMN.fromDoc(element);
				else if (name.equalsIgnoreCase(DOI.refname) || name.equalsIgnoreCase(DOI.shortname))
					x.doI = DOI.fromDoc(element);
				else if (name.equalsIgnoreCase(ProductIdentifier.refname) || name.equalsIgnoreCase(ProductIdentifier.shortname))
					x.productIdentifiers = DU.addToList(x.productIdentifiers, ProductIdentifier.fromDoc(element));
				else if (name.equalsIgnoreCase(Barcode.refname) || name.equalsIgnoreCase(Barcode.shortname))
					x.barcodes = DU.addToList(x.barcodes, Barcode.fromDoc(element));
				else if (name.equalsIgnoreCase(ReplacesISBN.refname) || name.equalsIgnoreCase(ReplacesISBN.shortname))
					x.replacesISBN = ReplacesISBN.fromDoc(element);
				else if (name.equalsIgnoreCase(ReplacesEAN13.refname) || name.equalsIgnoreCase(ReplacesEAN13.shortname))
					x.replacesEAN13 = ReplacesEAN13.fromDoc(element);
				else if (name.equalsIgnoreCase(ProductForm.refname) || name.equalsIgnoreCase(ProductForm.shortname))
					x.productForm = ProductForm.fromDoc(element);
				else if (name.equalsIgnoreCase(ProductFormDetail.refname) || name.equalsIgnoreCase(ProductFormDetail.shortname))
					x.productFormDetails = DU.addToList(x.productFormDetails, ProductFormDetail.fromDoc(element));
				else if (name.equalsIgnoreCase(ProductFormFeature.refname) || name.equalsIgnoreCase(ProductFormFeature.shortname))
					x.productFormFeatures = DU.addToList(x.productFormFeatures, ProductFormFeature.fromDoc(element));
				else if (name.equalsIgnoreCase(BookFormDetail.refname) || name.equalsIgnoreCase(BookFormDetail.shortname))
					x.bookFormDetails = DU.addToList(x.bookFormDetails, BookFormDetail.fromDoc(element));
				else if (name.equalsIgnoreCase(ProductPackaging.refname) || name.equalsIgnoreCase(ProductPackaging.shortname))
					x.productPackaging = ProductPackaging.fromDoc(element);
				else if (name.equalsIgnoreCase(ProductFormDescription.refname) || name.equalsIgnoreCase(ProductFormDescription.shortname))
					x.productFormDescription = ProductFormDescription.fromDoc(element);
				else if (name.equalsIgnoreCase(NumberOfPieces.refname) || name.equalsIgnoreCase(NumberOfPieces.shortname))
					x.numberOfPieces = NumberOfPieces.fromDoc(element);
				else if (name.equalsIgnoreCase(TradeCategory.refname) || name.equalsIgnoreCase(TradeCategory.shortname))
					x.tradeCategory = TradeCategory.fromDoc(element);
				else if (name.equalsIgnoreCase(ProductContentType.refname) || name.equalsIgnoreCase(ProductContentType.shortname))
					x.productContentTypes = DU.addToList(x.productContentTypes, ProductContentType.fromDoc(element));
				else if (name.equalsIgnoreCase(ContainedItem.refname) || name.equalsIgnoreCase(ContainedItem.shortname))
					x.containedItems = DU.addToList(x.containedItems, ContainedItem.fromDoc(element));
				else if (name.equalsIgnoreCase(ProductClassification.refname) || name.equalsIgnoreCase(ProductClassification.shortname))
					x.productClassifications = DU.addToList(x.productClassifications, ProductClassification.fromDoc(element));
				else if (name.equalsIgnoreCase(EpubType.refname) || name.equalsIgnoreCase(EpubType.shortname))
					x.epubType = EpubType.fromDoc(element);
				else if (name.equalsIgnoreCase(EpubTypeVersion.refname) || name.equalsIgnoreCase(EpubTypeVersion.shortname))
					x.epubTypeVersion = EpubTypeVersion.fromDoc(element);
				else if (name.equalsIgnoreCase(EpubTypeDescription.refname) || name.equalsIgnoreCase(EpubTypeDescription.shortname))
					x.epubTypeDescription = EpubTypeDescription.fromDoc(element);
				else if (name.equalsIgnoreCase(EpubFormat.refname) || name.equalsIgnoreCase(EpubFormat.shortname))
					x.epubFormat = EpubFormat.fromDoc(element);
				else if (name.equalsIgnoreCase(EpubFormatVersion.refname) || name.equalsIgnoreCase(EpubFormatVersion.shortname))
					x.epubFormatVersion = EpubFormatVersion.fromDoc(element);
				else if (name.equalsIgnoreCase(EpubFormatDescription.refname) || name.equalsIgnoreCase(EpubFormatDescription.shortname))
					x.epubFormatDescription = EpubFormatDescription.fromDoc(element);
				else if (name.equalsIgnoreCase(EpubSource.refname) || name.equalsIgnoreCase(EpubSource.shortname))
					x.epubSource = EpubSource.fromDoc(element);
				else if (name.equalsIgnoreCase(EpubSourceVersion.refname) || name.equalsIgnoreCase(EpubSourceVersion.shortname))
					x.epubSourceVersion = EpubSourceVersion.fromDoc(element);
				else if (name.equalsIgnoreCase(EpubSourceDescription.refname) || name.equalsIgnoreCase(EpubSourceDescription.shortname))
					x.epubSourceDescription = EpubSourceDescription.fromDoc(element);
				else if (name.equalsIgnoreCase(EpubTypeNote.refname) || name.equalsIgnoreCase(EpubTypeNote.shortname))
					x.epubTypeNote = EpubTypeNote.fromDoc(element);
				else if (name.equalsIgnoreCase(Series.refname) || name.equalsIgnoreCase(Series.shortname))
					x.seriess = DU.addToList(x.seriess, Series.fromDoc(element));
				else if (name.equalsIgnoreCase(NoSeries.refname) || name.equalsIgnoreCase(NoSeries.shortname))
					x.noSeries = NoSeries.fromDoc(element);
				else if (name.equalsIgnoreCase(Set.refname) || name.equalsIgnoreCase(Set.shortname))
					x.sets = DU.addToList(x.sets, Set.fromDoc(element));
				else if (name.equalsIgnoreCase(TextCaseFlag.refname) || name.equalsIgnoreCase(TextCaseFlag.shortname))
					x.textCaseFlag = TextCaseFlag.fromDoc(element);
				else if (name.equalsIgnoreCase(DistinctiveTitle.refname) || name.equalsIgnoreCase(DistinctiveTitle.shortname))
					x.distinctiveTitle = DistinctiveTitle.fromDoc(element);
				else if (name.equalsIgnoreCase(TitlePrefix.refname) || name.equalsIgnoreCase(TitlePrefix.shortname))
					x.titlePrefix = TitlePrefix.fromDoc(element);
				else if (name.equalsIgnoreCase(TitleWithoutPrefix.refname) || name.equalsIgnoreCase(TitleWithoutPrefix.shortname))
					x.titleWithoutPrefix = TitleWithoutPrefix.fromDoc(element);
				else if (name.equalsIgnoreCase(Subtitle.refname) || name.equalsIgnoreCase(Subtitle.shortname))
					x.subtitle = Subtitle.fromDoc(element);
				else if (name.equalsIgnoreCase(TranslationOfTitle.refname) || name.equalsIgnoreCase(TranslationOfTitle.shortname))
					x.translationOfTitle = TranslationOfTitle.fromDoc(element);
				else if (name.equalsIgnoreCase(FormerTitle.refname) || name.equalsIgnoreCase(FormerTitle.shortname))
					x.formerTitles = DU.addToList(x.formerTitles, FormerTitle.fromDoc(element));
				else if (name.equalsIgnoreCase(Title.refname) || name.equalsIgnoreCase(Title.shortname))
					x.titles = DU.addToList(x.titles, Title.fromDoc(element));
				else if (name.equalsIgnoreCase(WorkIdentifier.refname) || name.equalsIgnoreCase(WorkIdentifier.shortname))
					x.workIdentifiers = DU.addToList(x.workIdentifiers, WorkIdentifier.fromDoc(element));
				else if (name.equalsIgnoreCase(Website.refname) || name.equalsIgnoreCase(Website.shortname))
					x.websites = DU.addToList(x.websites, Website.fromDoc(element));
				else if (name.equalsIgnoreCase(ThesisType.refname) || name.equalsIgnoreCase(ThesisType.shortname))
					x.thesisType = ThesisType.fromDoc(element);
				else if (name.equalsIgnoreCase(ThesisPresentedTo.refname) || name.equalsIgnoreCase(ThesisPresentedTo.shortname))
					x.thesisPresentedTo = ThesisPresentedTo.fromDoc(element);
				else if (name.equalsIgnoreCase(ThesisYear.refname) || name.equalsIgnoreCase(ThesisYear.shortname))
					x.thesisYear = ThesisYear.fromDoc(element);
				else if (name.equalsIgnoreCase(Contributor.refname) || name.equalsIgnoreCase(Contributor.shortname))
					x.contributors = DU.addToList(x.contributors, Contributor.fromDoc(element));
				else if (name.equalsIgnoreCase(ContributorStatement.refname) || name.equalsIgnoreCase(ContributorStatement.shortname))
					x.contributorStatement = ContributorStatement.fromDoc(element);
				else if (name.equalsIgnoreCase(NoContributor.refname) || name.equalsIgnoreCase(NoContributor.shortname))
					x.noContributor = NoContributor.fromDoc(element);
				else if (name.equalsIgnoreCase(ConferenceDescription.refname) || name.equalsIgnoreCase(ConferenceDescription.shortname))
					x.conferenceDescription = ConferenceDescription.fromDoc(element);
				else if (name.equalsIgnoreCase(ConferenceRole.refname) || name.equalsIgnoreCase(ConferenceRole.shortname))
					x.conferenceRole = ConferenceRole.fromDoc(element);
				else if (name.equalsIgnoreCase(ConferenceName.refname) || name.equalsIgnoreCase(ConferenceName.shortname))
					x.conferenceName = ConferenceName.fromDoc(element);
				else if (name.equalsIgnoreCase(ConferenceNumber.refname) || name.equalsIgnoreCase(ConferenceNumber.shortname))
					x.conferenceNumber = ConferenceNumber.fromDoc(element);
				else if (name.equalsIgnoreCase(ConferenceDate.refname) || name.equalsIgnoreCase(ConferenceDate.shortname))
					x.conferenceDate = ConferenceDate.fromDoc(element);
				else if (name.equalsIgnoreCase(ConferencePlace.refname) || name.equalsIgnoreCase(ConferencePlace.shortname))
					x.conferencePlace = ConferencePlace.fromDoc(element);
				else if (name.equalsIgnoreCase(Conference.refname) || name.equalsIgnoreCase(Conference.shortname))
					x.conferences = DU.addToList(x.conferences, Conference.fromDoc(element));
				else if (name.equalsIgnoreCase(EditionTypeCode.refname) || name.equalsIgnoreCase(EditionTypeCode.shortname))
					x.editionTypeCodes = DU.addToList(x.editionTypeCodes, EditionTypeCode.fromDoc(element));
				else if (name.equalsIgnoreCase(EditionNumber.refname) || name.equalsIgnoreCase(EditionNumber.shortname))
					x.editionNumber = EditionNumber.fromDoc(element);
				else if (name.equalsIgnoreCase(EditionVersionNumber.refname) || name.equalsIgnoreCase(EditionVersionNumber.shortname))
					x.editionVersionNumber = EditionVersionNumber.fromDoc(element);
				else if (name.equalsIgnoreCase(EditionStatement.refname) || name.equalsIgnoreCase(EditionStatement.shortname))
					x.editionStatement = EditionStatement.fromDoc(element);
				else if (name.equalsIgnoreCase(NoEdition.refname) || name.equalsIgnoreCase(NoEdition.shortname))
					x.noEdition = NoEdition.fromDoc(element);
				else if (name.equalsIgnoreCase(ReligiousText.refname) || name.equalsIgnoreCase(ReligiousText.shortname))
					x.religiousText = ReligiousText.fromDoc(element);
				else if (name.equalsIgnoreCase(LanguageOfText.refname) || name.equalsIgnoreCase(LanguageOfText.shortname))
					x.languageOfTexts = DU.addToList(x.languageOfTexts, LanguageOfText.fromDoc(element));
				else if (name.equalsIgnoreCase(OriginalLanguage.refname) || name.equalsIgnoreCase(OriginalLanguage.shortname))
					x.originalLanguage = OriginalLanguage.fromDoc(element);
				else if (name.equalsIgnoreCase(Language.refname) || name.equalsIgnoreCase(Language.shortname))
					x.languages = DU.addToList(x.languages, Language.fromDoc(element));
				else if (name.equalsIgnoreCase(NumberOfPages.refname) || name.equalsIgnoreCase(NumberOfPages.shortname))
					x.numberOfPages = NumberOfPages.fromDoc(element);
				else if (name.equalsIgnoreCase(PagesRoman.refname) || name.equalsIgnoreCase(PagesRoman.shortname))
					x.pagesRoman = PagesRoman.fromDoc(element);
				else if (name.equalsIgnoreCase(PagesArabic.refname) || name.equalsIgnoreCase(PagesArabic.shortname))
					x.pagesArabic = PagesArabic.fromDoc(element);
				else if (name.equalsIgnoreCase(Extent.refname) || name.equalsIgnoreCase(Extent.shortname))
					x.extents = DU.addToList(x.extents, Extent.fromDoc(element));
				else if (name.equalsIgnoreCase(NumberOfIllustrations.refname) || name.equalsIgnoreCase(NumberOfIllustrations.shortname))
					x.numberOfIllustrations = NumberOfIllustrations.fromDoc(element);
				else if (name.equalsIgnoreCase(IllustrationsNote.refname) || name.equalsIgnoreCase(IllustrationsNote.shortname))
					x.illustrationsNote = IllustrationsNote.fromDoc(element);
				else if (name.equalsIgnoreCase(Illustrations.refname) || name.equalsIgnoreCase(Illustrations.shortname))
					x.illustrationss = DU.addToList(x.illustrationss, Illustrations.fromDoc(element));
				else if (name.equalsIgnoreCase(MapScale.refname) || name.equalsIgnoreCase(MapScale.shortname))
					x.mapScales = DU.addToList(x.mapScales, MapScale.fromDoc(element));
				else if (name.equalsIgnoreCase(BASICMainSubject.refname) || name.equalsIgnoreCase(BASICMainSubject.shortname))
					x.basicMainSubject = BASICMainSubject.fromDoc(element);
				else if (name.equalsIgnoreCase(BASICVersion.refname) || name.equalsIgnoreCase(BASICVersion.shortname))
					x.basicVersion = BASICVersion.fromDoc(element);
				else if (name.equalsIgnoreCase(BICMainSubject.refname) || name.equalsIgnoreCase(BICMainSubject.shortname))
					x.bicMainSubject = BICMainSubject.fromDoc(element);
				else if (name.equalsIgnoreCase(BICVersion.refname) || name.equalsIgnoreCase(BICVersion.shortname))
					x.bicVersion = BICVersion.fromDoc(element);
				else if (name.equalsIgnoreCase(MainSubject.refname) || name.equalsIgnoreCase(MainSubject.shortname))
					x.mainSubjects = DU.addToList(x.mainSubjects, MainSubject.fromDoc(element));
				else if (name.equalsIgnoreCase(Subject.refname) || name.equalsIgnoreCase(Subject.shortname))
					x.subjects = DU.addToList(x.subjects, Subject.fromDoc(element));
				else if (name.equalsIgnoreCase(PersonAsSubject.refname) || name.equalsIgnoreCase(PersonAsSubject.shortname))
					x.personAsSubjects = DU.addToList(x.personAsSubjects, PersonAsSubject.fromDoc(element));
				else if (name.equalsIgnoreCase(CorporateBodyAsSubject.refname) || name.equalsIgnoreCase(CorporateBodyAsSubject.shortname))
					x.corporateBodyAsSubjects = DU.addToList(x.corporateBodyAsSubjects, CorporateBodyAsSubject.fromDoc(element));
				else if (name.equalsIgnoreCase(PlaceAsSubject.refname) || name.equalsIgnoreCase(PlaceAsSubject.shortname))
					x.placeAsSubjects = DU.addToList(x.placeAsSubjects, PlaceAsSubject.fromDoc(element));
				else if (name.equalsIgnoreCase(AudienceCode.refname) || name.equalsIgnoreCase(AudienceCode.shortname))
					x.audienceCodes = DU.addToList(x.audienceCodes, AudienceCode.fromDoc(element));
				else if (name.equalsIgnoreCase(Audience.refname) || name.equalsIgnoreCase(Audience.shortname))
					x.audiences = DU.addToList(x.audiences, Audience.fromDoc(element));
				else if (name.equalsIgnoreCase(USSchoolGrade.refname) || name.equalsIgnoreCase(USSchoolGrade.shortname))
					x.usSchoolGrade = USSchoolGrade.fromDoc(element);
				else if (name.equalsIgnoreCase(InterestAge.refname) || name.equalsIgnoreCase(InterestAge.shortname))
					x.interestAge = InterestAge.fromDoc(element);
				else if (name.equalsIgnoreCase(AudienceRange.refname) || name.equalsIgnoreCase(AudienceRange.shortname))
					x.audienceRanges = DU.addToList(x.audienceRanges, AudienceRange.fromDoc(element));
				else if (name.equalsIgnoreCase(AudienceDescription.refname) || name.equalsIgnoreCase(AudienceDescription.shortname))
					x.audienceDescription = AudienceDescription.fromDoc(element);
				else if (name.equalsIgnoreCase(Complexity.refname) || name.equalsIgnoreCase(Complexity.shortname))
					x.complexitys = DU.addToList(x.complexitys, Complexity.fromDoc(element));
				else if (name.equalsIgnoreCase(Annotation.refname) || name.equalsIgnoreCase(Annotation.shortname))
					x.annotation = Annotation.fromDoc(element);
				else if (name.equalsIgnoreCase(MainDescription.refname) || name.equalsIgnoreCase(MainDescription.shortname))
					x.mainDescription = MainDescription.fromDoc(element);
				else if (name.equalsIgnoreCase(OtherText.refname) || name.equalsIgnoreCase(OtherText.shortname))
					x.otherTexts = DU.addToList(x.otherTexts, OtherText.fromDoc(element));
				else if (name.equalsIgnoreCase(ReviewQuote.refname) || name.equalsIgnoreCase(ReviewQuote.shortname))
					x.reviewQuotes = DU.addToList(x.reviewQuotes, ReviewQuote.fromDoc(element));
				else if (name.equalsIgnoreCase(CoverImageFormatCode.refname) || name.equalsIgnoreCase(CoverImageFormatCode.shortname))
					x.coverImageFormatCode = CoverImageFormatCode.fromDoc(element);
				else if (name.equalsIgnoreCase(CoverImageLinkTypeCode.refname) || name.equalsIgnoreCase(CoverImageLinkTypeCode.shortname))
					x.coverImageLinkTypeCode = CoverImageLinkTypeCode.fromDoc(element);
				else if (name.equalsIgnoreCase(CoverImageLink.refname) || name.equalsIgnoreCase(CoverImageLink.shortname))
					x.coverImageLink = CoverImageLink.fromDoc(element);
				else if (name.equalsIgnoreCase(MediaFile.refname) || name.equalsIgnoreCase(MediaFile.shortname))
					x.mediaFiles = DU.addToList(x.mediaFiles, MediaFile.fromDoc(element));
				else if (name.equalsIgnoreCase(ProductWebsite.refname) || name.equalsIgnoreCase(ProductWebsite.shortname))
					x.productWebsites = DU.addToList(x.productWebsites, ProductWebsite.fromDoc(element));
				else if (name.equalsIgnoreCase(PrizesDescription.refname) || name.equalsIgnoreCase(PrizesDescription.shortname))
					x.prizesDescription = PrizesDescription.fromDoc(element);
				else if (name.equalsIgnoreCase(Prize.refname) || name.equalsIgnoreCase(Prize.shortname))
					x.prizes = DU.addToList(x.prizes, Prize.fromDoc(element));
				else if (name.equalsIgnoreCase(ContentItem.refname) || name.equalsIgnoreCase(ContentItem.shortname))
					x.contentItems = DU.addToList(x.contentItems, ContentItem.fromDoc(element));
				else if (name.equalsIgnoreCase(ImprintName.refname) || name.equalsIgnoreCase(ImprintName.shortname))
					x.imprintName = ImprintName.fromDoc(element);
				else if (name.equalsIgnoreCase(Imprint.refname) || name.equalsIgnoreCase(Imprint.shortname))
					x.imprints = DU.addToList(x.imprints, Imprint.fromDoc(element));
				else if (name.equalsIgnoreCase(PublisherName.refname) || name.equalsIgnoreCase(PublisherName.shortname))
					x.publisherName = PublisherName.fromDoc(element);
				else if (name.equalsIgnoreCase(Publisher.refname) || name.equalsIgnoreCase(Publisher.shortname))
					x.publishers = DU.addToList(x.publishers, Publisher.fromDoc(element));
				else if (name.equalsIgnoreCase(CityOfPublication.refname) || name.equalsIgnoreCase(CityOfPublication.shortname))
					x.cityOfPublications = DU.addToList(x.cityOfPublications, CityOfPublication.fromDoc(element));
				else if (name.equalsIgnoreCase(CountryOfPublication.refname) || name.equalsIgnoreCase(CountryOfPublication.shortname))
					x.countryOfPublication = CountryOfPublication.fromDoc(element);
				else if (name.equalsIgnoreCase(CopublisherName.refname) || name.equalsIgnoreCase(CopublisherName.shortname))
					x.copublisherNames = DU.addToList(x.copublisherNames, CopublisherName.fromDoc(element));
				else if (name.equalsIgnoreCase(SponsorName.refname) || name.equalsIgnoreCase(SponsorName.shortname))
					x.sponsorNames = DU.addToList(x.sponsorNames, SponsorName.fromDoc(element));
				else if (name.equalsIgnoreCase(OriginalPublisher.refname) || name.equalsIgnoreCase(OriginalPublisher.shortname))
					x.originalPublisher = OriginalPublisher.fromDoc(element);
				else if (name.equalsIgnoreCase(PublishingStatus.refname) || name.equalsIgnoreCase(PublishingStatus.shortname))
					x.publishingStatus = PublishingStatus.fromDoc(element);
				else if (name.equalsIgnoreCase(PublishingStatusNote.refname) || name.equalsIgnoreCase(PublishingStatusNote.shortname))
					x.publishingStatusNote = PublishingStatusNote.fromDoc(element);
				else if (name.equalsIgnoreCase(AnnouncementDate.refname) || name.equalsIgnoreCase(AnnouncementDate.shortname))
					x.announcementDate = AnnouncementDate.fromDoc(element);
				else if (name.equalsIgnoreCase(TradeAnnouncementDate.refname) || name.equalsIgnoreCase(TradeAnnouncementDate.shortname))
					x.tradeAnnouncementDate = TradeAnnouncementDate.fromDoc(element);
				else if (name.equalsIgnoreCase(PublicationDate.refname) || name.equalsIgnoreCase(PublicationDate.shortname))
					x.publicationDate = PublicationDate.fromDoc(element);
				else if (name.equalsIgnoreCase(CopyrightStatement.refname) || name.equalsIgnoreCase(CopyrightStatement.shortname))
					x.copyrightStatements = DU.addToList(x.copyrightStatements, CopyrightStatement.fromDoc(element));
				else if (name.equalsIgnoreCase(CopyrightYear.refname) || name.equalsIgnoreCase(CopyrightYear.shortname))
					x.copyrightYear = CopyrightYear.fromDoc(element);
				else if (name.equalsIgnoreCase(YearFirstPublished.refname) || name.equalsIgnoreCase(YearFirstPublished.shortname))
					x.yearFirstPublished = YearFirstPublished.fromDoc(element);
				else if (name.equalsIgnoreCase(SalesRights.refname) || name.equalsIgnoreCase(SalesRights.shortname))
					x.salesRightss = DU.addToList(x.salesRightss, SalesRights.fromDoc(element));
				else if (name.equalsIgnoreCase(NotForSale.refname) || name.equalsIgnoreCase(NotForSale.shortname))
					x.notForSales = DU.addToList(x.notForSales, NotForSale.fromDoc(element));
				else if (name.equalsIgnoreCase(SalesRestriction.refname) || name.equalsIgnoreCase(SalesRestriction.shortname))
					x.salesRestrictions = DU.addToList(x.salesRestrictions, SalesRestriction.fromDoc(element));
				else if (name.equalsIgnoreCase(Height.refname) || name.equalsIgnoreCase(Height.shortname))
					x.height = Height.fromDoc(element);
				else if (name.equalsIgnoreCase(Width.refname) || name.equalsIgnoreCase(Width.shortname))
					x.width = Width.fromDoc(element);
				else if (name.equalsIgnoreCase(Thickness.refname) || name.equalsIgnoreCase(Thickness.shortname))
					x.thickness = Thickness.fromDoc(element);
				else if (name.equalsIgnoreCase(Weight.refname) || name.equalsIgnoreCase(Weight.shortname))
					x.weight = Weight.fromDoc(element);
				else if (name.equalsIgnoreCase(Measure.refname) || name.equalsIgnoreCase(Measure.shortname))
					x.measures = DU.addToList(x.measures, Measure.fromDoc(element));
				else if (name.equalsIgnoreCase(Dimensions.refname) || name.equalsIgnoreCase(Dimensions.shortname))
					x.dimensions = Dimensions.fromDoc(element);
				else if (name.equalsIgnoreCase(ReplacedByISBN.refname) || name.equalsIgnoreCase(ReplacedByISBN.shortname))
					x.replacedByISBN = ReplacedByISBN.fromDoc(element);
				else if (name.equalsIgnoreCase(ReplacedByEAN13.refname) || name.equalsIgnoreCase(ReplacedByEAN13.shortname))
					x.replacedByEAN13 = ReplacedByEAN13.fromDoc(element);
				else if (name.equalsIgnoreCase(AlternativeFormatISBN.refname) || name.equalsIgnoreCase(AlternativeFormatISBN.shortname))
					x.alternativeFormatISBN = AlternativeFormatISBN.fromDoc(element);
				else if (name.equalsIgnoreCase(AlternativeFormatEAN13.refname) || name.equalsIgnoreCase(AlternativeFormatEAN13.shortname))
					x.alternativeFormatEAN13 = AlternativeFormatEAN13.fromDoc(element);
				else if (name.equalsIgnoreCase(AlternativeProductISBN.refname) || name.equalsIgnoreCase(AlternativeProductISBN.shortname))
					x.alternativeProductISBN = AlternativeProductISBN.fromDoc(element);
				else if (name.equalsIgnoreCase(AlternativeProductEAN13.refname) || name.equalsIgnoreCase(AlternativeProductEAN13.shortname))
					x.alternativeProductEAN13 = AlternativeProductEAN13.fromDoc(element);
				else if (name.equalsIgnoreCase(RelatedProduct.refname) || name.equalsIgnoreCase(RelatedProduct.shortname))
					x.relatedProducts = DU.addToList(x.relatedProducts, RelatedProduct.fromDoc(element));
				else if (name.equalsIgnoreCase(OutOfPrintDate.refname) || name.equalsIgnoreCase(OutOfPrintDate.shortname))
					x.outOfPrintDate = OutOfPrintDate.fromDoc(element);
				else if (name.equalsIgnoreCase(SupplyDetail.refname) || name.equalsIgnoreCase(SupplyDetail.shortname))
					x.supplyDetails = DU.addToList(x.supplyDetails, SupplyDetail.fromDoc(element));
				else if (name.equalsIgnoreCase(MarketRepresentation.refname) || name.equalsIgnoreCase(MarketRepresentation.shortname))
					x.marketRepresentations = DU.addToList(x.marketRepresentations, MarketRepresentation.fromDoc(element));
				else if (name.equalsIgnoreCase(PromotionCampaign.refname) || name.equalsIgnoreCase(PromotionCampaign.shortname))
					x.promotionCampaign = PromotionCampaign.fromDoc(element);
				else if (name.equalsIgnoreCase(PromotionContact.refname) || name.equalsIgnoreCase(PromotionContact.shortname))
					x.promotionContact = PromotionContact.fromDoc(element);
				else if (name.equalsIgnoreCase(InitialPrintRun.refname) || name.equalsIgnoreCase(InitialPrintRun.shortname))
					x.initialPrintRun = InitialPrintRun.fromDoc(element);
				else if (name.equalsIgnoreCase(ReprintDetail.refname) || name.equalsIgnoreCase(ReprintDetail.shortname))
					x.reprintDetails = DU.addToList(x.reprintDetails, ReprintDetail.fromDoc(element));
				else if (name.equalsIgnoreCase(CopiesSold.refname) || name.equalsIgnoreCase(CopiesSold.shortname))
					x.copiesSold = CopiesSold.fromDoc(element);
				else if (name.equalsIgnoreCase(BookClubAdoption.refname) || name.equalsIgnoreCase(BookClubAdoption.shortname))
					x.bookClubAdoption = BookClubAdoption.fromDoc(element);
			}
		});

		return x;
	}
}
