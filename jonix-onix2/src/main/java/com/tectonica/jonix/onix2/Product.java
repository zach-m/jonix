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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.codelist.AudienceCodeTypes;
import com.tectonica.jonix.codelist.Audiences;
import com.tectonica.jonix.codelist.BarcodeIndicators;
import com.tectonica.jonix.codelist.BookFormDetails;
import com.tectonica.jonix.codelist.CountryCodes;
import com.tectonica.jonix.codelist.EditionTypes;
import com.tectonica.jonix.codelist.EpublicationFormats;
import com.tectonica.jonix.codelist.EpublicationTypes;
import com.tectonica.jonix.codelist.ExtentTypes;
import com.tectonica.jonix.codelist.FrontCoverImageFileFormats;
import com.tectonica.jonix.codelist.FrontCoverImageFileLinkTypes;
import com.tectonica.jonix.codelist.IllustrationAndOtherContentTypes;
import com.tectonica.jonix.codelist.ImageAudioVideoFileTypes;
import com.tectonica.jonix.codelist.LanguageCodes;
import com.tectonica.jonix.codelist.LanguageRoles;
import com.tectonica.jonix.codelist.MeasureTypes;
import com.tectonica.jonix.codelist.NameCodeTypes;
import com.tectonica.jonix.codelist.NotificationOrUpdateTypes;
import com.tectonica.jonix.codelist.OtherTextTypes;
import com.tectonica.jonix.codelist.ProductClassificationTypes;
import com.tectonica.jonix.codelist.ProductCompositions;
import com.tectonica.jonix.codelist.ProductContentTypes;
import com.tectonica.jonix.codelist.ProductFormDetails;
import com.tectonica.jonix.codelist.ProductFormFeatureTypes;
import com.tectonica.jonix.codelist.ProductForms;
import com.tectonica.jonix.codelist.ProductIdentifierTypes;
import com.tectonica.jonix.codelist.ProductPackagingTypes;
import com.tectonica.jonix.codelist.PublishingStatuss;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.ThesisTypes;
import com.tectonica.jonix.codelist.TitleTypes;
import com.tectonica.jonix.codelist.TradeCategorys;
import com.tectonica.jonix.codelist.TransliterationSchemes;
import com.tectonica.jonix.codelist.WorkIdentifierTypes;
import com.tectonica.jonix.struct.JonixAudience;
import com.tectonica.jonix.struct.JonixExtent;
import com.tectonica.jonix.struct.JonixIllustrations;
import com.tectonica.jonix.struct.JonixLanguage;
import com.tectonica.jonix.struct.JonixMeasure;
import com.tectonica.jonix.struct.JonixMediaFile;
import com.tectonica.jonix.struct.JonixOtherText;
import com.tectonica.jonix.struct.JonixProductClassification;
import com.tectonica.jonix.struct.JonixProductFormFeature;
import com.tectonica.jonix.struct.JonixProductIdentifier;
import com.tectonica.jonix.struct.JonixTitle;
import com.tectonica.jonix.struct.JonixWorkIdentifier;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

public class Product implements OnixSuperComposite, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "Product";
	public static final String shortname = "product";

	// ///////////////////////////////////////////////////////////////////////////////
	// ATTRIBUTES
	// ///////////////////////////////////////////////////////////////////////////////

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

	// ///////////////////////////////////////////////////////////////////////////////
	// MEMBERS
	// ///////////////////////////////////////////////////////////////////////////////

	/**
	 * (this field is required)
	 */
	public RecordReference recordReference;

	/**
	 * (this field is required)
	 */
	public NotificationType notificationType;

	/**
	 * (this field is optional)
	 */
	public DeletionCode deletionCode;

	/**
	 * (this field is optional)
	 */
	public DeletionText deletionText;

	/**
	 * (this field is optional)
	 */
	public RecordSourceType recordSourceType;

	/**
	 * (this field is optional)
	 */
	public RecordSourceIdentifierType recordSourceIdentifierType;

	/**
	 * (this field is optional)
	 */
	public RecordSourceIdentifier recordSourceIdentifier;

	/**
	 * (this field is optional)
	 */
	public RecordSourceName recordSourceName;

	/**
	 * (this field is required)
	 */
	public ISBN isbn;

	/**
	 * (this field is optional)
	 */
	public EAN13 ean13;

	/**
	 * (this field is optional)
	 */
	public UPC upc;

	/**
	 * (this field is optional)
	 */
	public PublisherProductNo publisherProductNo;

	/**
	 * (this field is optional)
	 */
	public ISMN ismn;

	/**
	 * (this field is optional)
	 */
	public DOI doi;

	/**
	 * (this list may be empty)
	 */
	public List<ProductIdentifier> productIdentifiers;

	/**
	 * (this list may be empty)
	 */
	public List<Barcode> barcodes;

	/**
	 * (this field is optional)
	 */
	public ReplacesISBN replacesISBN;

	/**
	 * (this field is optional)
	 */
	public ReplacesEAN13 replacesEAN13;

	/**
	 * (this field is optional)
	 */
	public ProductForm productForm;

	/**
	 * (this list may be empty)
	 */
	public List<ProductFormDetail> productFormDetails;

	/**
	 * (this list may be empty)
	 */
	public List<ProductFormFeature> productFormFeatures;

	/**
	 * (this list may be empty)
	 */
	public List<BookFormDetail> bookFormDetails;

	/**
	 * (this field is optional)
	 */
	public ProductPackaging productPackaging;

	/**
	 * (this field is optional)
	 */
	public ProductFormDescription productFormDescription;

	/**
	 * (this field is optional)
	 */
	public NumberOfPieces numberOfPieces;

	/**
	 * (this field is optional)
	 */
	public TradeCategory tradeCategory;

	/**
	 * (this list may be empty)
	 */
	public List<ProductContentType> productContentTypes;

	/**
	 * (this list may be empty)
	 */
	public List<ContainedItem> containedItems;

	/**
	 * (this list may be empty)
	 */
	public List<ProductClassification> productClassifications;

	/**
	 * (this field is optional)
	 */
	public EpubType epubType;

	/**
	 * (this field is optional)
	 */
	public EpubTypeVersion epubTypeVersion;

	/**
	 * (this field is optional)
	 */
	public EpubTypeDescription epubTypeDescription;

	/**
	 * (this field is optional)
	 */
	public EpubFormat epubFormat;

	/**
	 * (this field is optional)
	 */
	public EpubFormatVersion epubFormatVersion;

	/**
	 * (this field is optional)
	 */
	public EpubFormatDescription epubFormatDescription;

	/**
	 * (this field is optional)
	 */
	public EpubSource epubSource;

	/**
	 * (this field is optional)
	 */
	public EpubSourceVersion epubSourceVersion;

	/**
	 * (this field is optional)
	 */
	public EpubSourceDescription epubSourceDescription;

	/**
	 * (this field is optional)
	 */
	public EpubTypeNote epubTypeNote;

	/**
	 * (this list may be empty)
	 */
	public List<Series> seriess;

	/**
	 * (this field is optional)
	 */
	public NoSeries noSeries;

	/**
	 * (this list may be empty)
	 */
	public List<Set> sets;

	/**
	 * (this field is optional)
	 */
	public TextCaseFlag textCaseFlag;

	/**
	 * (this field is required)
	 */
	public DistinctiveTitle distinctiveTitle;

	/**
	 * (this field is optional)
	 */
	public TitlePrefix titlePrefix;

	/**
	 * (this field is optional)
	 */
	public TitleWithoutPrefix titleWithoutPrefix;

	/**
	 * (this field is optional)
	 */
	public Subtitle subtitle;

	/**
	 * (this field is optional)
	 */
	public TranslationOfTitle translationOfTitle;

	/**
	 * (this list may be empty)
	 */
	public List<FormerTitle> formerTitles;

	/**
	 * (this list may be empty)
	 */
	public List<Title> titles;

	/**
	 * (this list may be empty)
	 */
	public List<WorkIdentifier> workIdentifiers;

	/**
	 * (this list may be empty)
	 */
	public List<Website> websites;

	/**
	 * (this field is optional)
	 */
	public ThesisType thesisType;

	/**
	 * (this field is optional)
	 */
	public ThesisPresentedTo thesisPresentedTo;

	/**
	 * (this field is optional)
	 */
	public ThesisYear thesisYear;

	/**
	 * (this list is required to contain at least one item)
	 */
	public List<Contributor> contributors;

	/**
	 * (this field is optional)
	 */
	public ContributorStatement contributorStatement;

	/**
	 * (this field is optional)
	 */
	public NoContributor noContributor;

	/**
	 * (this field is optional)
	 */
	public ConferenceDescription conferenceDescription;

	/**
	 * (this field is optional)
	 */
	public ConferenceRole conferenceRole;

	/**
	 * (this field is required)
	 */
	public ConferenceName conferenceName;

	/**
	 * (this field is optional)
	 */
	public ConferenceNumber conferenceNumber;

	/**
	 * (this field is optional)
	 */
	public ConferenceDate conferenceDate;

	/**
	 * (this field is optional)
	 */
	public ConferencePlace conferencePlace;

	/**
	 * (this list may be empty)
	 */
	public List<Conference> conferences;

	/**
	 * (this list may be empty)
	 */
	public List<EditionTypeCode> editionTypeCodes;

	/**
	 * (this field is optional)
	 */
	public EditionNumber editionNumber;

	/**
	 * (this field is optional)
	 */
	public EditionVersionNumber editionVersionNumber;

	/**
	 * (this field is optional)
	 */
	public EditionStatement editionStatement;

	/**
	 * (this field is optional)
	 */
	public NoEdition noEdition;

	/**
	 * (this field is optional)
	 */
	public ReligiousText religiousText;

	/**
	 * (this list may be empty)
	 */
	public List<LanguageOfText> languageOfTexts;

	/**
	 * (this field is optional)
	 */
	public OriginalLanguage originalLanguage;

	/**
	 * (this list may be empty)
	 */
	public List<Language> languages;

	/**
	 * (this field is optional)
	 */
	public NumberOfPages numberOfPages;

	/**
	 * (this field is optional)
	 */
	public PagesRoman pagesRoman;

	/**
	 * (this field is optional)
	 */
	public PagesArabic pagesArabic;

	/**
	 * (this list may be empty)
	 */
	public List<Extent> extents;

	/**
	 * (this field is optional)
	 */
	public NumberOfIllustrations numberOfIllustrations;

	/**
	 * (this field is optional)
	 */
	public IllustrationsNote illustrationsNote;

	/**
	 * (this list may be empty)
	 */
	public List<Illustrations> illustrationss;

	/**
	 * (this list may be empty)
	 */
	public List<MapScale> mapScales;

	/**
	 * (this field is optional)
	 */
	public BASICMainSubject basicMainSubject;

	/**
	 * (this field is optional)
	 */
	public BASICVersion basicVersion;

	/**
	 * (this field is optional)
	 */
	public BICMainSubject bicMainSubject;

	/**
	 * (this field is optional)
	 */
	public BICVersion bicVersion;

	/**
	 * (this list may be empty)
	 */
	public List<MainSubject> mainSubjects;

	/**
	 * (this list may be empty)
	 */
	public List<Subject> subjects;

	/**
	 * (this list may be empty)
	 */
	public List<PersonAsSubject> personAsSubjects;

	/**
	 * (this list may be empty)
	 */
	public List<CorporateBodyAsSubject> corporateBodyAsSubjects;

	/**
	 * (this list may be empty)
	 */
	public List<PlaceAsSubject> placeAsSubjects;

	/**
	 * (this list may be empty)
	 */
	public List<AudienceCode> audienceCodes;

	/**
	 * (this list may be empty)
	 */
	public List<Audience> audiences;

	/**
	 * (this field is optional)
	 */
	public USSchoolGrade usSchoolGrade;

	/**
	 * (this field is optional)
	 */
	public InterestAge interestAge;

	/**
	 * (this list may be empty)
	 */
	public List<AudienceRange> audienceRanges;

	/**
	 * (this field is optional)
	 */
	public AudienceDescription audienceDescription;

	/**
	 * (this list may be empty)
	 */
	public List<Complexity> complexitys;

	/**
	 * (this field is optional)
	 */
	public Annotation annotation;

	/**
	 * (this field is optional)
	 */
	public MainDescription mainDescription;

	/**
	 * (this list may be empty)
	 */
	public List<OtherText> otherTexts;

	/**
	 * (this list may be empty)
	 */
	public List<ReviewQuote> reviewQuotes;

	/**
	 * (this field is optional)
	 */
	public CoverImageFormatCode coverImageFormatCode;

	/**
	 * (this field is optional)
	 */
	public CoverImageLinkTypeCode coverImageLinkTypeCode;

	/**
	 * (this field is optional)
	 */
	public CoverImageLink coverImageLink;

	/**
	 * (this list may be empty)
	 */
	public List<MediaFile> mediaFiles;

	/**
	 * (this list may be empty)
	 */
	public List<ProductWebsite> productWebsites;

	/**
	 * (this field is optional)
	 */
	public PrizesDescription prizesDescription;

	/**
	 * (this list may be empty)
	 */
	public List<Prize> prizes;

	/**
	 * (this list may be empty)
	 */
	public List<ContentItem> contentItems;

	/**
	 * (this field is required)
	 */
	public ImprintName imprintName;

	/**
	 * (this list may be empty)
	 */
	public List<Imprint> imprints;

	/**
	 * (this field is optional)
	 */
	public PublisherName publisherName;

	/**
	 * (this list may be empty)
	 */
	public List<Publisher> publishers;

	/**
	 * (this list may be empty)
	 */
	public List<CityOfPublication> cityOfPublications;

	/**
	 * (this field is optional)
	 */
	public CountryOfPublication countryOfPublication;

	/**
	 * (this list may be empty)
	 */
	public List<CopublisherName> copublisherNames;

	/**
	 * (this list may be empty)
	 */
	public List<SponsorName> sponsorNames;

	/**
	 * (this field is optional)
	 */
	public OriginalPublisher originalPublisher;

	/**
	 * (this field is optional)
	 */
	public PublishingStatus publishingStatus;

	/**
	 * (this field is optional)
	 */
	public PublishingStatusNote publishingStatusNote;

	/**
	 * (this field is optional)
	 */
	public AnnouncementDate announcementDate;

	/**
	 * (this field is optional)
	 */
	public TradeAnnouncementDate tradeAnnouncementDate;

	/**
	 * (this field is optional)
	 */
	public PublicationDate publicationDate;

	/**
	 * (this list may be empty)
	 */
	public List<CopyrightStatement> copyrightStatements;

	/**
	 * (this field is optional)
	 */
	public CopyrightYear copyrightYear;

	/**
	 * (this field is optional)
	 */
	public YearFirstPublished yearFirstPublished;

	/**
	 * (this list may be empty)
	 */
	public List<SalesRights> salesRightss;

	/**
	 * (this list may be empty)
	 */
	public List<NotForSale> notForSales;

	/**
	 * (this list may be empty)
	 */
	public List<SalesRestriction> salesRestrictions;

	/**
	 * (this field is required)
	 */
	public Height height;

	/**
	 * (this field is optional)
	 */
	public Width width;

	/**
	 * (this field is optional)
	 */
	public Thickness thickness;

	/**
	 * (this field is optional)
	 */
	public Weight weight;

	/**
	 * (this list may be empty)
	 */
	public List<Measure> measures;

	/**
	 * (this field is optional)
	 */
	public Dimensions dimensions;

	/**
	 * (this field is optional)
	 */
	public ReplacedByISBN replacedByISBN;

	/**
	 * (this field is optional)
	 */
	public ReplacedByEAN13 replacedByEAN13;

	/**
	 * (this field is optional)
	 */
	public AlternativeFormatISBN alternativeFormatISBN;

	/**
	 * (this field is optional)
	 */
	public AlternativeFormatEAN13 alternativeFormatEAN13;

	/**
	 * (this field is optional)
	 */
	public AlternativeProductISBN alternativeProductISBN;

	/**
	 * (this field is optional)
	 */
	public AlternativeProductEAN13 alternativeProductEAN13;

	/**
	 * (this list may be empty)
	 */
	public List<RelatedProduct> relatedProducts;

	/**
	 * (this field is optional)
	 */
	public OutOfPrintDate outOfPrintDate;

	/**
	 * (this list may be empty)
	 */
	public List<SupplyDetail> supplyDetails;

	/**
	 * (this list may be empty)
	 */
	public List<MarketRepresentation> marketRepresentations;

	/**
	 * (this field is optional)
	 */
	public PromotionCampaign promotionCampaign;

	/**
	 * (this field is optional)
	 */
	public PromotionContact promotionContact;

	/**
	 * (this field is optional)
	 */
	public InitialPrintRun initialPrintRun;

	/**
	 * (this list may be empty)
	 */
	public List<ReprintDetail> reprintDetails;

	/**
	 * (this field is optional)
	 */
	public CopiesSold copiesSold;

	/**
	 * (this field is optional)
	 */
	public BookClubAdoption bookClubAdoption;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public Product()
	{}

	public Product(org.w3c.dom.Element element)
	{
		textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));
		textcase = TextCaseFlags.byCode(JPU.getAttribute(element, "textcase"));
		language = LanguageCodes.byCode(JPU.getAttribute(element, "language"));
		transliteration = TransliterationSchemes.byCode(JPU.getAttribute(element, "transliteration"));
		datestamp = JPU.getAttribute(element, "datestamp");
		sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
		sourcename = JPU.getAttribute(element, "sourcename");

		JPU.forElementsOf(element, new JPU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(RecordReference.refname) || name.equals(RecordReference.shortname))
					recordReference = new RecordReference(element);
				else if (name.equals(NotificationType.refname) || name.equals(NotificationType.shortname))
					notificationType = new NotificationType(element);
				else if (name.equals(DeletionCode.refname) || name.equals(DeletionCode.shortname))
					deletionCode = new DeletionCode(element);
				else if (name.equals(DeletionText.refname) || name.equals(DeletionText.shortname))
					deletionText = new DeletionText(element);
				else if (name.equals(RecordSourceType.refname) || name.equals(RecordSourceType.shortname))
					recordSourceType = new RecordSourceType(element);
				else if (name.equals(RecordSourceIdentifierType.refname)
						|| name.equals(RecordSourceIdentifierType.shortname))
					recordSourceIdentifierType = new RecordSourceIdentifierType(element);
				else if (name.equals(RecordSourceIdentifier.refname) || name.equals(RecordSourceIdentifier.shortname))
					recordSourceIdentifier = new RecordSourceIdentifier(element);
				else if (name.equals(RecordSourceName.refname) || name.equals(RecordSourceName.shortname))
					recordSourceName = new RecordSourceName(element);
				else if (name.equals(ISBN.refname) || name.equals(ISBN.shortname))
					isbn = new ISBN(element);
				else if (name.equals(EAN13.refname) || name.equals(EAN13.shortname))
					ean13 = new EAN13(element);
				else if (name.equals(UPC.refname) || name.equals(UPC.shortname))
					upc = new UPC(element);
				else if (name.equals(PublisherProductNo.refname) || name.equals(PublisherProductNo.shortname))
					publisherProductNo = new PublisherProductNo(element);
				else if (name.equals(ISMN.refname) || name.equals(ISMN.shortname))
					ismn = new ISMN(element);
				else if (name.equals(DOI.refname) || name.equals(DOI.shortname))
					doi = new DOI(element);
				else if (name.equals(ProductIdentifier.refname) || name.equals(ProductIdentifier.shortname))
					productIdentifiers = JPU.addToList(productIdentifiers, new ProductIdentifier(element));
				else if (name.equals(Barcode.refname) || name.equals(Barcode.shortname))
					barcodes = JPU.addToList(barcodes, new Barcode(element));
				else if (name.equals(ReplacesISBN.refname) || name.equals(ReplacesISBN.shortname))
					replacesISBN = new ReplacesISBN(element);
				else if (name.equals(ReplacesEAN13.refname) || name.equals(ReplacesEAN13.shortname))
					replacesEAN13 = new ReplacesEAN13(element);
				else if (name.equals(ProductForm.refname) || name.equals(ProductForm.shortname))
					productForm = new ProductForm(element);
				else if (name.equals(ProductFormDetail.refname) || name.equals(ProductFormDetail.shortname))
					productFormDetails = JPU.addToList(productFormDetails, new ProductFormDetail(element));
				else if (name.equals(ProductFormFeature.refname) || name.equals(ProductFormFeature.shortname))
					productFormFeatures = JPU.addToList(productFormFeatures, new ProductFormFeature(element));
				else if (name.equals(BookFormDetail.refname) || name.equals(BookFormDetail.shortname))
					bookFormDetails = JPU.addToList(bookFormDetails, new BookFormDetail(element));
				else if (name.equals(ProductPackaging.refname) || name.equals(ProductPackaging.shortname))
					productPackaging = new ProductPackaging(element);
				else if (name.equals(ProductFormDescription.refname) || name.equals(ProductFormDescription.shortname))
					productFormDescription = new ProductFormDescription(element);
				else if (name.equals(NumberOfPieces.refname) || name.equals(NumberOfPieces.shortname))
					numberOfPieces = new NumberOfPieces(element);
				else if (name.equals(TradeCategory.refname) || name.equals(TradeCategory.shortname))
					tradeCategory = new TradeCategory(element);
				else if (name.equals(ProductContentType.refname) || name.equals(ProductContentType.shortname))
					productContentTypes = JPU.addToList(productContentTypes, new ProductContentType(element));
				else if (name.equals(ContainedItem.refname) || name.equals(ContainedItem.shortname))
					containedItems = JPU.addToList(containedItems, new ContainedItem(element));
				else if (name.equals(ProductClassification.refname) || name.equals(ProductClassification.shortname))
					productClassifications = JPU.addToList(productClassifications, new ProductClassification(element));
				else if (name.equals(EpubType.refname) || name.equals(EpubType.shortname))
					epubType = new EpubType(element);
				else if (name.equals(EpubTypeVersion.refname) || name.equals(EpubTypeVersion.shortname))
					epubTypeVersion = new EpubTypeVersion(element);
				else if (name.equals(EpubTypeDescription.refname) || name.equals(EpubTypeDescription.shortname))
					epubTypeDescription = new EpubTypeDescription(element);
				else if (name.equals(EpubFormat.refname) || name.equals(EpubFormat.shortname))
					epubFormat = new EpubFormat(element);
				else if (name.equals(EpubFormatVersion.refname) || name.equals(EpubFormatVersion.shortname))
					epubFormatVersion = new EpubFormatVersion(element);
				else if (name.equals(EpubFormatDescription.refname) || name.equals(EpubFormatDescription.shortname))
					epubFormatDescription = new EpubFormatDescription(element);
				else if (name.equals(EpubSource.refname) || name.equals(EpubSource.shortname))
					epubSource = new EpubSource(element);
				else if (name.equals(EpubSourceVersion.refname) || name.equals(EpubSourceVersion.shortname))
					epubSourceVersion = new EpubSourceVersion(element);
				else if (name.equals(EpubSourceDescription.refname) || name.equals(EpubSourceDescription.shortname))
					epubSourceDescription = new EpubSourceDescription(element);
				else if (name.equals(EpubTypeNote.refname) || name.equals(EpubTypeNote.shortname))
					epubTypeNote = new EpubTypeNote(element);
				else if (name.equals(Series.refname) || name.equals(Series.shortname))
					seriess = JPU.addToList(seriess, new Series(element));
				else if (name.equals(NoSeries.refname) || name.equals(NoSeries.shortname))
					noSeries = new NoSeries(element);
				else if (name.equals(Set.refname) || name.equals(Set.shortname))
					sets = JPU.addToList(sets, new Set(element));
				else if (name.equals(TextCaseFlag.refname) || name.equals(TextCaseFlag.shortname))
					textCaseFlag = new TextCaseFlag(element);
				else if (name.equals(DistinctiveTitle.refname) || name.equals(DistinctiveTitle.shortname))
					distinctiveTitle = new DistinctiveTitle(element);
				else if (name.equals(TitlePrefix.refname) || name.equals(TitlePrefix.shortname))
					titlePrefix = new TitlePrefix(element);
				else if (name.equals(TitleWithoutPrefix.refname) || name.equals(TitleWithoutPrefix.shortname))
					titleWithoutPrefix = new TitleWithoutPrefix(element);
				else if (name.equals(Subtitle.refname) || name.equals(Subtitle.shortname))
					subtitle = new Subtitle(element);
				else if (name.equals(TranslationOfTitle.refname) || name.equals(TranslationOfTitle.shortname))
					translationOfTitle = new TranslationOfTitle(element);
				else if (name.equals(FormerTitle.refname) || name.equals(FormerTitle.shortname))
					formerTitles = JPU.addToList(formerTitles, new FormerTitle(element));
				else if (name.equals(Title.refname) || name.equals(Title.shortname))
					titles = JPU.addToList(titles, new Title(element));
				else if (name.equals(WorkIdentifier.refname) || name.equals(WorkIdentifier.shortname))
					workIdentifiers = JPU.addToList(workIdentifiers, new WorkIdentifier(element));
				else if (name.equals(Website.refname) || name.equals(Website.shortname))
					websites = JPU.addToList(websites, new Website(element));
				else if (name.equals(ThesisType.refname) || name.equals(ThesisType.shortname))
					thesisType = new ThesisType(element);
				else if (name.equals(ThesisPresentedTo.refname) || name.equals(ThesisPresentedTo.shortname))
					thesisPresentedTo = new ThesisPresentedTo(element);
				else if (name.equals(ThesisYear.refname) || name.equals(ThesisYear.shortname))
					thesisYear = new ThesisYear(element);
				else if (name.equals(Contributor.refname) || name.equals(Contributor.shortname))
					contributors = JPU.addToList(contributors, new Contributor(element));
				else if (name.equals(ContributorStatement.refname) || name.equals(ContributorStatement.shortname))
					contributorStatement = new ContributorStatement(element);
				else if (name.equals(NoContributor.refname) || name.equals(NoContributor.shortname))
					noContributor = new NoContributor(element);
				else if (name.equals(ConferenceDescription.refname) || name.equals(ConferenceDescription.shortname))
					conferenceDescription = new ConferenceDescription(element);
				else if (name.equals(ConferenceRole.refname) || name.equals(ConferenceRole.shortname))
					conferenceRole = new ConferenceRole(element);
				else if (name.equals(ConferenceName.refname) || name.equals(ConferenceName.shortname))
					conferenceName = new ConferenceName(element);
				else if (name.equals(ConferenceNumber.refname) || name.equals(ConferenceNumber.shortname))
					conferenceNumber = new ConferenceNumber(element);
				else if (name.equals(ConferenceDate.refname) || name.equals(ConferenceDate.shortname))
					conferenceDate = new ConferenceDate(element);
				else if (name.equals(ConferencePlace.refname) || name.equals(ConferencePlace.shortname))
					conferencePlace = new ConferencePlace(element);
				else if (name.equals(Conference.refname) || name.equals(Conference.shortname))
					conferences = JPU.addToList(conferences, new Conference(element));
				else if (name.equals(EditionTypeCode.refname) || name.equals(EditionTypeCode.shortname))
					editionTypeCodes = JPU.addToList(editionTypeCodes, new EditionTypeCode(element));
				else if (name.equals(EditionNumber.refname) || name.equals(EditionNumber.shortname))
					editionNumber = new EditionNumber(element);
				else if (name.equals(EditionVersionNumber.refname) || name.equals(EditionVersionNumber.shortname))
					editionVersionNumber = new EditionVersionNumber(element);
				else if (name.equals(EditionStatement.refname) || name.equals(EditionStatement.shortname))
					editionStatement = new EditionStatement(element);
				else if (name.equals(NoEdition.refname) || name.equals(NoEdition.shortname))
					noEdition = new NoEdition(element);
				else if (name.equals(ReligiousText.refname) || name.equals(ReligiousText.shortname))
					religiousText = new ReligiousText(element);
				else if (name.equals(LanguageOfText.refname) || name.equals(LanguageOfText.shortname))
					languageOfTexts = JPU.addToList(languageOfTexts, new LanguageOfText(element));
				else if (name.equals(OriginalLanguage.refname) || name.equals(OriginalLanguage.shortname))
					originalLanguage = new OriginalLanguage(element);
				else if (name.equals(Language.refname) || name.equals(Language.shortname))
					languages = JPU.addToList(languages, new Language(element));
				else if (name.equals(NumberOfPages.refname) || name.equals(NumberOfPages.shortname))
					numberOfPages = new NumberOfPages(element);
				else if (name.equals(PagesRoman.refname) || name.equals(PagesRoman.shortname))
					pagesRoman = new PagesRoman(element);
				else if (name.equals(PagesArabic.refname) || name.equals(PagesArabic.shortname))
					pagesArabic = new PagesArabic(element);
				else if (name.equals(Extent.refname) || name.equals(Extent.shortname))
					extents = JPU.addToList(extents, new Extent(element));
				else if (name.equals(NumberOfIllustrations.refname) || name.equals(NumberOfIllustrations.shortname))
					numberOfIllustrations = new NumberOfIllustrations(element);
				else if (name.equals(IllustrationsNote.refname) || name.equals(IllustrationsNote.shortname))
					illustrationsNote = new IllustrationsNote(element);
				else if (name.equals(Illustrations.refname) || name.equals(Illustrations.shortname))
					illustrationss = JPU.addToList(illustrationss, new Illustrations(element));
				else if (name.equals(MapScale.refname) || name.equals(MapScale.shortname))
					mapScales = JPU.addToList(mapScales, new MapScale(element));
				else if (name.equals(BASICMainSubject.refname) || name.equals(BASICMainSubject.shortname))
					basicMainSubject = new BASICMainSubject(element);
				else if (name.equals(BASICVersion.refname) || name.equals(BASICVersion.shortname))
					basicVersion = new BASICVersion(element);
				else if (name.equals(BICMainSubject.refname) || name.equals(BICMainSubject.shortname))
					bicMainSubject = new BICMainSubject(element);
				else if (name.equals(BICVersion.refname) || name.equals(BICVersion.shortname))
					bicVersion = new BICVersion(element);
				else if (name.equals(MainSubject.refname) || name.equals(MainSubject.shortname))
					mainSubjects = JPU.addToList(mainSubjects, new MainSubject(element));
				else if (name.equals(Subject.refname) || name.equals(Subject.shortname))
					subjects = JPU.addToList(subjects, new Subject(element));
				else if (name.equals(PersonAsSubject.refname) || name.equals(PersonAsSubject.shortname))
					personAsSubjects = JPU.addToList(personAsSubjects, new PersonAsSubject(element));
				else if (name.equals(CorporateBodyAsSubject.refname) || name.equals(CorporateBodyAsSubject.shortname))
					corporateBodyAsSubjects = JPU.addToList(corporateBodyAsSubjects,
							new CorporateBodyAsSubject(element));
				else if (name.equals(PlaceAsSubject.refname) || name.equals(PlaceAsSubject.shortname))
					placeAsSubjects = JPU.addToList(placeAsSubjects, new PlaceAsSubject(element));
				else if (name.equals(AudienceCode.refname) || name.equals(AudienceCode.shortname))
					audienceCodes = JPU.addToList(audienceCodes, new AudienceCode(element));
				else if (name.equals(Audience.refname) || name.equals(Audience.shortname))
					audiences = JPU.addToList(audiences, new Audience(element));
				else if (name.equals(USSchoolGrade.refname) || name.equals(USSchoolGrade.shortname))
					usSchoolGrade = new USSchoolGrade(element);
				else if (name.equals(InterestAge.refname) || name.equals(InterestAge.shortname))
					interestAge = new InterestAge(element);
				else if (name.equals(AudienceRange.refname) || name.equals(AudienceRange.shortname))
					audienceRanges = JPU.addToList(audienceRanges, new AudienceRange(element));
				else if (name.equals(AudienceDescription.refname) || name.equals(AudienceDescription.shortname))
					audienceDescription = new AudienceDescription(element);
				else if (name.equals(Complexity.refname) || name.equals(Complexity.shortname))
					complexitys = JPU.addToList(complexitys, new Complexity(element));
				else if (name.equals(Annotation.refname) || name.equals(Annotation.shortname))
					annotation = new Annotation(element);
				else if (name.equals(MainDescription.refname) || name.equals(MainDescription.shortname))
					mainDescription = new MainDescription(element);
				else if (name.equals(OtherText.refname) || name.equals(OtherText.shortname))
					otherTexts = JPU.addToList(otherTexts, new OtherText(element));
				else if (name.equals(ReviewQuote.refname) || name.equals(ReviewQuote.shortname))
					reviewQuotes = JPU.addToList(reviewQuotes, new ReviewQuote(element));
				else if (name.equals(CoverImageFormatCode.refname) || name.equals(CoverImageFormatCode.shortname))
					coverImageFormatCode = new CoverImageFormatCode(element);
				else if (name.equals(CoverImageLinkTypeCode.refname) || name.equals(CoverImageLinkTypeCode.shortname))
					coverImageLinkTypeCode = new CoverImageLinkTypeCode(element);
				else if (name.equals(CoverImageLink.refname) || name.equals(CoverImageLink.shortname))
					coverImageLink = new CoverImageLink(element);
				else if (name.equals(MediaFile.refname) || name.equals(MediaFile.shortname))
					mediaFiles = JPU.addToList(mediaFiles, new MediaFile(element));
				else if (name.equals(ProductWebsite.refname) || name.equals(ProductWebsite.shortname))
					productWebsites = JPU.addToList(productWebsites, new ProductWebsite(element));
				else if (name.equals(PrizesDescription.refname) || name.equals(PrizesDescription.shortname))
					prizesDescription = new PrizesDescription(element);
				else if (name.equals(Prize.refname) || name.equals(Prize.shortname))
					prizes = JPU.addToList(prizes, new Prize(element));
				else if (name.equals(ContentItem.refname) || name.equals(ContentItem.shortname))
					contentItems = JPU.addToList(contentItems, new ContentItem(element));
				else if (name.equals(ImprintName.refname) || name.equals(ImprintName.shortname))
					imprintName = new ImprintName(element);
				else if (name.equals(Imprint.refname) || name.equals(Imprint.shortname))
					imprints = JPU.addToList(imprints, new Imprint(element));
				else if (name.equals(PublisherName.refname) || name.equals(PublisherName.shortname))
					publisherName = new PublisherName(element);
				else if (name.equals(Publisher.refname) || name.equals(Publisher.shortname))
					publishers = JPU.addToList(publishers, new Publisher(element));
				else if (name.equals(CityOfPublication.refname) || name.equals(CityOfPublication.shortname))
					cityOfPublications = JPU.addToList(cityOfPublications, new CityOfPublication(element));
				else if (name.equals(CountryOfPublication.refname) || name.equals(CountryOfPublication.shortname))
					countryOfPublication = new CountryOfPublication(element);
				else if (name.equals(CopublisherName.refname) || name.equals(CopublisherName.shortname))
					copublisherNames = JPU.addToList(copublisherNames, new CopublisherName(element));
				else if (name.equals(SponsorName.refname) || name.equals(SponsorName.shortname))
					sponsorNames = JPU.addToList(sponsorNames, new SponsorName(element));
				else if (name.equals(OriginalPublisher.refname) || name.equals(OriginalPublisher.shortname))
					originalPublisher = new OriginalPublisher(element);
				else if (name.equals(PublishingStatus.refname) || name.equals(PublishingStatus.shortname))
					publishingStatus = new PublishingStatus(element);
				else if (name.equals(PublishingStatusNote.refname) || name.equals(PublishingStatusNote.shortname))
					publishingStatusNote = new PublishingStatusNote(element);
				else if (name.equals(AnnouncementDate.refname) || name.equals(AnnouncementDate.shortname))
					announcementDate = new AnnouncementDate(element);
				else if (name.equals(TradeAnnouncementDate.refname) || name.equals(TradeAnnouncementDate.shortname))
					tradeAnnouncementDate = new TradeAnnouncementDate(element);
				else if (name.equals(PublicationDate.refname) || name.equals(PublicationDate.shortname))
					publicationDate = new PublicationDate(element);
				else if (name.equals(CopyrightStatement.refname) || name.equals(CopyrightStatement.shortname))
					copyrightStatements = JPU.addToList(copyrightStatements, new CopyrightStatement(element));
				else if (name.equals(CopyrightYear.refname) || name.equals(CopyrightYear.shortname))
					copyrightYear = new CopyrightYear(element);
				else if (name.equals(YearFirstPublished.refname) || name.equals(YearFirstPublished.shortname))
					yearFirstPublished = new YearFirstPublished(element);
				else if (name.equals(SalesRights.refname) || name.equals(SalesRights.shortname))
					salesRightss = JPU.addToList(salesRightss, new SalesRights(element));
				else if (name.equals(NotForSale.refname) || name.equals(NotForSale.shortname))
					notForSales = JPU.addToList(notForSales, new NotForSale(element));
				else if (name.equals(SalesRestriction.refname) || name.equals(SalesRestriction.shortname))
					salesRestrictions = JPU.addToList(salesRestrictions, new SalesRestriction(element));
				else if (name.equals(Height.refname) || name.equals(Height.shortname))
					height = new Height(element);
				else if (name.equals(Width.refname) || name.equals(Width.shortname))
					width = new Width(element);
				else if (name.equals(Thickness.refname) || name.equals(Thickness.shortname))
					thickness = new Thickness(element);
				else if (name.equals(Weight.refname) || name.equals(Weight.shortname))
					weight = new Weight(element);
				else if (name.equals(Measure.refname) || name.equals(Measure.shortname))
					measures = JPU.addToList(measures, new Measure(element));
				else if (name.equals(Dimensions.refname) || name.equals(Dimensions.shortname))
					dimensions = new Dimensions(element);
				else if (name.equals(ReplacedByISBN.refname) || name.equals(ReplacedByISBN.shortname))
					replacedByISBN = new ReplacedByISBN(element);
				else if (name.equals(ReplacedByEAN13.refname) || name.equals(ReplacedByEAN13.shortname))
					replacedByEAN13 = new ReplacedByEAN13(element);
				else if (name.equals(AlternativeFormatISBN.refname) || name.equals(AlternativeFormatISBN.shortname))
					alternativeFormatISBN = new AlternativeFormatISBN(element);
				else if (name.equals(AlternativeFormatEAN13.refname) || name.equals(AlternativeFormatEAN13.shortname))
					alternativeFormatEAN13 = new AlternativeFormatEAN13(element);
				else if (name.equals(AlternativeProductISBN.refname) || name.equals(AlternativeProductISBN.shortname))
					alternativeProductISBN = new AlternativeProductISBN(element);
				else if (name.equals(AlternativeProductEAN13.refname) || name.equals(AlternativeProductEAN13.shortname))
					alternativeProductEAN13 = new AlternativeProductEAN13(element);
				else if (name.equals(RelatedProduct.refname) || name.equals(RelatedProduct.shortname))
					relatedProducts = JPU.addToList(relatedProducts, new RelatedProduct(element));
				else if (name.equals(OutOfPrintDate.refname) || name.equals(OutOfPrintDate.shortname))
					outOfPrintDate = new OutOfPrintDate(element);
				else if (name.equals(SupplyDetail.refname) || name.equals(SupplyDetail.shortname))
					supplyDetails = JPU.addToList(supplyDetails, new SupplyDetail(element));
				else if (name.equals(MarketRepresentation.refname) || name.equals(MarketRepresentation.shortname))
					marketRepresentations = JPU.addToList(marketRepresentations, new MarketRepresentation(element));
				else if (name.equals(PromotionCampaign.refname) || name.equals(PromotionCampaign.shortname))
					promotionCampaign = new PromotionCampaign(element);
				else if (name.equals(PromotionContact.refname) || name.equals(PromotionContact.shortname))
					promotionContact = new PromotionContact(element);
				else if (name.equals(InitialPrintRun.refname) || name.equals(InitialPrintRun.shortname))
					initialPrintRun = new InitialPrintRun(element);
				else if (name.equals(ReprintDetail.refname) || name.equals(ReprintDetail.shortname))
					reprintDetails = JPU.addToList(reprintDetails, new ReprintDetail(element));
				else if (name.equals(CopiesSold.refname) || name.equals(CopiesSold.shortname))
					copiesSold = new CopiesSold(element);
				else if (name.equals(BookClubAdoption.refname) || name.equals(BookClubAdoption.shortname))
					bookClubAdoption = new BookClubAdoption(element);
			}
		});
	}

	/**
	 * Raw Format: Variable-length, alphanumeric, suggested maximum length 32 characters.
	 */
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

	/**
	 * Raw Format: Variable-length text, suggested maximum length 100 characters
	 */
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

	/**
	 * Raw Format: Defined by the identifier scheme specified in &lt;RecordSourceIdentifierType&gt;
	 */
	public String getRecordSourceIdentifierValue()
	{
		return (recordSourceIdentifier == null) ? null : recordSourceIdentifier.value;
	}

	/**
	 * Raw Format: Variable-length text, suggested maximum length 100 characters
	 */
	public String getRecordSourceNameValue()
	{
		return (recordSourceName == null) ? null : recordSourceName.value;
	}

	/**
	 * Raw Format: Fixed-length, 10 characters, all numeric except last character, which may be letter X.
	 */
	public String getISBNValue()
	{
		return (isbn == null) ? null : isbn.value;
	}

	/**
	 * Raw Format: Fixed-length, 13 numeric digits.
	 */
	public String getEAN13Value()
	{
		return (ean13 == null) ? null : ean13.value;
	}

	/**
	 * Raw Format: Fixed-length, 12 numeric digits. The last digit is a modulus-10 check digit. For more information see
	 * http://www.uc-council.org/main/ID_Numbers_and_Bar_Codes.html
	 */
	public String getUPCValue()
	{
		return (upc == null) ? null : upc.value;
	}

	/**
	 * Raw Format: Variable-length text, suggested maximum length 35 characters.
	 */
	public String getPublisherProductNoValue()
	{
		return (publisherProductNo == null) ? null : publisherProductNo.value;
	}

	/**
	 * Raw Format: Fixed-length, letter M followed by nine numeric digits, the last of which is a check character
	 * calculated according to rules given at http://www.nlc-bnc.ca/ismn/s12-200-e.html
	 */
	public String getISMNValue()
	{
		return (ismn == null) ? null : ismn.value;
	}

	/**
	 * Raw Format: Variable-length text, suggested maximum length 300 characters.
	 */
	public String getDOIValue()
	{
		return (doi == null) ? null : doi.value;
	}

	public List<BarcodeIndicators> getBarcodeValues()
	{
		if (barcodes != null)
		{
			List<BarcodeIndicators> list = new ArrayList<>();
			for (Barcode i : barcodes)
				list.add(i.value);
			return list;
		}
		return null;
	}

	/**
	 * Raw Format: Fixed-length, 10 characters, all numeric except last character, which may be letter X.
	 */
	public String getReplacesISBNValue()
	{
		return (replacesISBN == null) ? null : replacesISBN.value;
	}

	/**
	 * Raw Format: Fixed-length, 13 numeric digits.
	 */
	public String getReplacesEAN13Value()
	{
		return (replacesEAN13 == null) ? null : replacesEAN13.value;
	}

	public ProductForms getProductFormValue()
	{
		return (productForm == null) ? null : productForm.value;
	}

	public List<ProductFormDetails> getProductFormDetailValues()
	{
		if (productFormDetails != null)
		{
			List<ProductFormDetails> list = new ArrayList<>();
			for (ProductFormDetail i : productFormDetails)
				list.add(i.value);
			return list;
		}
		return null;
	}

	public List<BookFormDetails> getBookFormDetailValues()
	{
		if (bookFormDetails != null)
		{
			List<BookFormDetails> list = new ArrayList<>();
			for (BookFormDetail i : bookFormDetails)
				list.add(i.value);
			return list;
		}
		return null;
	}

	public ProductPackagingTypes getProductPackagingValue()
	{
		return (productPackaging == null) ? null : productPackaging.value;
	}

	/**
	 * Raw Format: Variable-length text, suggested maximum length 200 characters.
	 */
	public String getProductFormDescriptionValue()
	{
		return (productFormDescription == null) ? null : productFormDescription.value;
	}

	/**
	 * Raw Format: Variable-length integer, suggested maximum length 4 digits.
	 */
	public String getNumberOfPiecesValue()
	{
		return (numberOfPieces == null) ? null : numberOfPieces.value;
	}

	public TradeCategorys getTradeCategoryValue()
	{
		return (tradeCategory == null) ? null : tradeCategory.value;
	}

	public List<ProductContentTypes> getProductContentTypeValues()
	{
		if (productContentTypes != null)
		{
			List<ProductContentTypes> list = new ArrayList<>();
			for (ProductContentType i : productContentTypes)
				list.add(i.value);
			return list;
		}
		return null;
	}

	public EpublicationTypes getEpubTypeValue()
	{
		return (epubType == null) ? null : epubType.value;
	}

	/**
	 * Raw Format: Variable-length text, suggested maximum 10 characters
	 */
	public String getEpubTypeVersionValue()
	{
		return (epubTypeVersion == null) ? null : epubTypeVersion.value;
	}

	/**
	 * Raw Format: Variable-length text, suggested maximum 200 characters
	 */
	public String getEpubTypeDescriptionValue()
	{
		return (epubTypeDescription == null) ? null : epubTypeDescription.value;
	}

	public EpublicationFormats getEpubFormatValue()
	{
		return (epubFormat == null) ? null : epubFormat.value;
	}

	/**
	 * Raw Format: Variable-length text, suggested maximum 10 characters
	 */
	public String getEpubFormatVersionValue()
	{
		return (epubFormatVersion == null) ? null : epubFormatVersion.value;
	}

	/**
	 * Raw Format: Variable-length text, suggested maximum 200 characters
	 */
	public String getEpubFormatDescriptionValue()
	{
		return (epubFormatDescription == null) ? null : epubFormatDescription.value;
	}

	public EpublicationFormats getEpubSourceValue()
	{
		return (epubSource == null) ? null : epubSource.value;
	}

	/**
	 * Raw Format: Variable-length text, suggested maximum 10 characters
	 */
	public String getEpubSourceVersionValue()
	{
		return (epubSourceVersion == null) ? null : epubSourceVersion.value;
	}

	/**
	 * Raw Format: Variable-length text, suggested maximum 200 characters
	 */
	public String getEpubSourceDescriptionValue()
	{
		return (epubSourceDescription == null) ? null : epubSourceDescription.value;
	}

	/**
	 * Raw Format: Variable-length text, suggested maximum 200 characters
	 */
	public String getEpubTypeNoteValue()
	{
		return (epubTypeNote == null) ? null : epubTypeNote.value;
	}

	public boolean isNoSeries()
	{
		return (noSeries != null);
	}

	public TextCaseFlags getTextCaseFlagValue()
	{
		return (textCaseFlag == null) ? null : textCaseFlag.value;
	}

	/**
	 * Raw Format: Variable-length alphanumeric, suggested maximum length 300 characters
	 */
	public String getDistinctiveTitleValue()
	{
		return (distinctiveTitle == null) ? null : distinctiveTitle.value;
	}

	/**
	 * Raw Format: Variable-length text, suggested maximum length 20 characters
	 */
	public String getTitlePrefixValue()
	{
		return (titlePrefix == null) ? null : titlePrefix.value;
	}

	/**
	 * Raw Format: Variable-length text, suggested maximum length 300 characters
	 */
	public String getTitleWithoutPrefixValue()
	{
		return (titleWithoutPrefix == null) ? null : titleWithoutPrefix.value;
	}

	/**
	 * Raw Format: Variable-length text, suggested maximum 300 characters
	 */
	public String getSubtitleValue()
	{
		return (subtitle == null) ? null : subtitle.value;
	}

	/**
	 * Raw Format: Variable-length text, suggested maximum length 300 characters
	 */
	public String getTranslationOfTitleValue()
	{
		return (translationOfTitle == null) ? null : translationOfTitle.value;
	}

	/**
	 * Raw Format: Variable-length text, suggested maximum length 300 characters
	 */
	public List<String> getFormerTitleValues()
	{
		if (formerTitles != null)
		{
			List<String> list = new ArrayList<>();
			for (FormerTitle i : formerTitles)
				list.add(i.value);
			return list;
		}
		return null;
	}

	public ThesisTypes getThesisTypeValue()
	{
		return (thesisType == null) ? null : thesisType.value;
	}

	/**
	 * Raw Format: Free text, suggested maximum length 300 characters
	 */
	public String getThesisPresentedToValue()
	{
		return (thesisPresentedTo == null) ? null : thesisPresentedTo.value;
	}

	/**
	 * Raw Format: Fixed-length, four numeric digits
	 */
	public String getThesisYearValue()
	{
		return (thesisYear == null) ? null : thesisYear.value;
	}

	/**
	 * Raw Format: Variable-length text, suggested maximum length 1000 characters
	 */
	public String getContributorStatementValue()
	{
		return (contributorStatement == null) ? null : contributorStatement.value;
	}

	public boolean isNoContributor()
	{
		return (noContributor != null);
	}

	/**
	 * Raw Format: Variable-length text, suggested maximum length 300 characters
	 */
	public String getConferenceDescriptionValue()
	{
		return (conferenceDescription == null) ? null : conferenceDescription.value;
	}

	/**
	 * Raw Format: Fixed-length, two numeric digits
	 */
	public String getConferenceRoleValue()
	{
		return (conferenceRole == null) ? null : conferenceRole.value;
	}

	/**
	 * Raw Format: Variable-length text, suggested maximum length 200 characters.
	 */
	public String getConferenceNameValue()
	{
		return (conferenceName == null) ? null : conferenceName.value;
	}

	/**
	 * Raw Format: Variable-length integer, suggested maximum length 4 characters
	 */
	public String getConferenceNumberValue()
	{
		return (conferenceNumber == null) ? null : conferenceNumber.value;
	}

	/**
	 * Raw Format: Date as year (YYYY) or month and year (YYYYMM).
	 */
	public String getConferenceDateValue()
	{
		return (conferenceDate == null) ? null : conferenceDate.value;
	}

	/**
	 * Raw Format: Variable-length text, suggested maximum length 100 characters
	 */
	public String getConferencePlaceValue()
	{
		return (conferencePlace == null) ? null : conferencePlace.value;
	}

	public List<EditionTypes> getEditionTypeCodeValues()
	{
		if (editionTypeCodes != null)
		{
			List<EditionTypes> list = new ArrayList<>();
			for (EditionTypeCode i : editionTypeCodes)
				list.add(i.value);
			return list;
		}
		return null;
	}

	/**
	 * Raw Format: Variable-length integer, suggested maximum length 4 digits.
	 */
	public String getEditionNumberValue()
	{
		return (editionNumber == null) ? null : editionNumber.value;
	}

	/**
	 * Raw Format: Free form, suggested maximum length 20 characters.
	 */
	public String getEditionVersionNumberValue()
	{
		return (editionVersionNumber == null) ? null : editionVersionNumber.value;
	}

	/**
	 * Raw Format: Variable-length text, suggested maximum length 100 characters.
	 */
	public String getEditionStatementValue()
	{
		return (editionStatement == null) ? null : editionStatement.value;
	}

	public boolean isNoEdition()
	{
		return (noEdition != null);
	}

	public List<LanguageCodes> getLanguageOfTextValues()
	{
		if (languageOfTexts != null)
		{
			List<LanguageCodes> list = new ArrayList<>();
			for (LanguageOfText i : languageOfTexts)
				list.add(i.value);
			return list;
		}
		return null;
	}

	public LanguageCodes getOriginalLanguageValue()
	{
		return (originalLanguage == null) ? null : originalLanguage.value;
	}

	/**
	 * Raw Format: Variable length integer, suggested maximum length 6 digits.
	 */
	public String getNumberOfPagesValue()
	{
		return (numberOfPages == null) ? null : numberOfPages.value;
	}

	/**
	 * Raw Format: Variable length alphabetic, suggested maximum length 10 characters.
	 */
	public String getPagesRomanValue()
	{
		return (pagesRoman == null) ? null : pagesRoman.value;
	}

	/**
	 * Raw Format: Variable length numeric, suggested maximum length 6 characters.
	 */
	public String getPagesArabicValue()
	{
		return (pagesArabic == null) ? null : pagesArabic.value;
	}

	/**
	 * Raw Format: Variable length integer, suggested maximum length 6 digits.
	 */
	public String getNumberOfIllustrationsValue()
	{
		return (numberOfIllustrations == null) ? null : numberOfIllustrations.value;
	}

	/**
	 * Raw Format: Variable length text, suggested maximum length 200 characters.
	 */
	public String getIllustrationsNoteValue()
	{
		return (illustrationsNote == null) ? null : illustrationsNote.value;
	}

	/**
	 * Raw Format: Variable length integer, suggested maximum length 6 digits.
	 */
	public List<String> getMapScaleValues()
	{
		if (mapScales != null)
		{
			List<String> list = new ArrayList<>();
			for (MapScale i : mapScales)
				list.add(i.value);
			return list;
		}
		return null;
	}

	/**
	 * Raw Format: Fixed-length, three upper-case letters and six numeric digits.
	 */
	public String getBASICMainSubjectValue()
	{
		return (basicMainSubject == null) ? null : basicMainSubject.value;
	}

	/**
	 * Raw Format: Free form - in practise expected to be an integer or a decimal number such as &#8220;2.01&#8221;.
	 * Suggested maximum length 10 characters, for consistency with other version number elements.
	 */
	public String getBASICVersionValue()
	{
		return (basicVersion == null) ? null : basicVersion.value;
	}

	/**
	 * Raw Format: Variable-length alphanumeric, suggested maximum length 10 characters to allow for expansion.
	 */
	public String getBICMainSubjectValue()
	{
		return (bicMainSubject == null) ? null : bicMainSubject.value;
	}

	/**
	 * Raw Format: Free form - in practise expected to be an integer. Suggested maximum length 10 characters, for
	 * consistency with other version number elements.
	 */
	public String getBICVersionValue()
	{
		return (bicVersion == null) ? null : bicVersion.value;
	}

	/**
	 * Raw Format: Variable-length text, suggested maximum 200 characters.
	 */
	public List<String> getCorporateBodyAsSubjectValues()
	{
		if (corporateBodyAsSubjects != null)
		{
			List<String> list = new ArrayList<>();
			for (CorporateBodyAsSubject i : corporateBodyAsSubjects)
				list.add(i.value);
			return list;
		}
		return null;
	}

	/**
	 * Raw Format: Variable-length text, suggested maximum 100 characters.
	 */
	public List<String> getPlaceAsSubjectValues()
	{
		if (placeAsSubjects != null)
		{
			List<String> list = new ArrayList<>();
			for (PlaceAsSubject i : placeAsSubjects)
				list.add(i.value);
			return list;
		}
		return null;
	}

	public List<Audiences> getAudienceCodeValues()
	{
		if (audienceCodes != null)
		{
			List<Audiences> list = new ArrayList<>();
			for (AudienceCode i : audienceCodes)
				list.add(i.value);
			return list;
		}
		return null;
	}

	/**
	 * Raw Format: Variable length text, maximum 15 characters.
	 */
	public String getUSSchoolGradeValue()
	{
		return (usSchoolGrade == null) ? null : usSchoolGrade.value;
	}

	/**
	 * Raw Format: Variable length text, maximum 15 characters.
	 */
	public String getInterestAgeValue()
	{
		return (interestAge == null) ? null : interestAge.value;
	}

	/**
	 * Raw Format: Free text, suggested maximum length 1000 characters.
	 */
	public String getAudienceDescriptionValue()
	{
		return (audienceDescription == null) ? null : audienceDescription.value;
	}

	/**
	 * Raw Format: Variable-length text, maximum 350 characters
	 */
	public String getAnnotationValue()
	{
		return (annotation == null) ? null : annotation.value;
	}

	/**
	 * Raw Format: Variable-length text, suggested maximum 2,000 characters (XHTML is enabled in this element - see ONIX
	 * for Books - Product Information Message - XML Message Specification, Section 7)
	 */
	public String getMainDescriptionValue()
	{
		return (mainDescription == null) ? null : mainDescription.value;
	}

	/**
	 * Raw Format: Variable-length text, suggested maximum length 500 characters (XHTML is enabled in this element - see
	 * ONIX for Books - Product Information Message - XML Message Specification, Section 7)
	 */
	public List<String> getReviewQuoteValues()
	{
		if (reviewQuotes != null)
		{
			List<String> list = new ArrayList<>();
			for (ReviewQuote i : reviewQuotes)
				list.add(i.value);
			return list;
		}
		return null;
	}

	public FrontCoverImageFileFormats getCoverImageFormatCodeValue()
	{
		return (coverImageFormatCode == null) ? null : coverImageFormatCode.value;
	}

	public FrontCoverImageFileLinkTypes getCoverImageLinkTypeCodeValue()
	{
		return (coverImageLinkTypeCode == null) ? null : coverImageLinkTypeCode.value;
	}

	/**
	 * Raw Format: Variable-length text, suggested maximum length 300 characters
	 */
	public String getCoverImageLinkValue()
	{
		return (coverImageLink == null) ? null : coverImageLink.value;
	}

	/**
	 * Raw Format: Variable-length text, suggested maximum length 500 characters
	 */
	public String getPrizesDescriptionValue()
	{
		return (prizesDescription == null) ? null : prizesDescription.value;
	}

	/**
	 * Raw Format: Variable length text, suggested maximum length 100 characters.
	 */
	public String getImprintNameValue()
	{
		return (imprintName == null) ? null : imprintName.value;
	}

	/**
	 * Raw Format: Variable length text, suggested maximum length 100 characters.
	 */
	public String getPublisherNameValue()
	{
		return (publisherName == null) ? null : publisherName.value;
	}

	/**
	 * Raw Format: Free text, suggested maximum length 50 characters.
	 */
	public List<String> getCityOfPublicationValues()
	{
		if (cityOfPublications != null)
		{
			List<String> list = new ArrayList<>();
			for (CityOfPublication i : cityOfPublications)
				list.add(i.value);
			return list;
		}
		return null;
	}

	public CountryCodes getCountryOfPublicationValue()
	{
		return (countryOfPublication == null) ? null : countryOfPublication.value;
	}

	/**
	 * Raw Format: Variable length text, suggested maximum length 100 characters.
	 */
	public List<String> getCopublisherNameValues()
	{
		if (copublisherNames != null)
		{
			List<String> list = new ArrayList<>();
			for (CopublisherName i : copublisherNames)
				list.add(i.value);
			return list;
		}
		return null;
	}

	/**
	 * Raw Format: Variable length text, suggested maximum length 100 characters.
	 */
	public List<String> getSponsorNameValues()
	{
		if (sponsorNames != null)
		{
			List<String> list = new ArrayList<>();
			for (SponsorName i : sponsorNames)
				list.add(i.value);
			return list;
		}
		return null;
	}

	/**
	 * Raw Format: Variable length text, suggested maximum length 100 characters.
	 */
	public String getOriginalPublisherValue()
	{
		return (originalPublisher == null) ? null : originalPublisher.value;
	}

	public PublishingStatuss getPublishingStatusValue()
	{
		return (publishingStatus == null) ? null : publishingStatus.value;
	}

	/**
	 * Raw Format: Variable-length text, suggested maximum 300 characters.
	 */
	public String getPublishingStatusNoteValue()
	{
		return (publishingStatusNote == null) ? null : publishingStatusNote.value;
	}

	/**
	 * Raw Format: Date as year, month, day (YYYYMMDD)
	 */
	public String getAnnouncementDateValue()
	{
		return (announcementDate == null) ? null : announcementDate.value;
	}

	/**
	 * Raw Format: Date as year, month, day (YYYYMMDD)
	 */
	public String getTradeAnnouncementDateValue()
	{
		return (tradeAnnouncementDate == null) ? null : tradeAnnouncementDate.value;
	}

	/**
	 * Raw Format: Four, six or eight numeric digits (YYYY, YYYYMM, or YYYYMMDD).
	 */
	public String getPublicationDateValue()
	{
		return (publicationDate == null) ? null : publicationDate.value;
	}

	/**
	 * Raw Format: Date as year only (YYYY)
	 */
	public String getCopyrightYearValue()
	{
		return (copyrightYear == null) ? null : copyrightYear.value;
	}

	/**
	 * Raw Format: Date as year only (YYYY)
	 */
	public String getYearFirstPublishedValue()
	{
		return (yearFirstPublished == null) ? null : yearFirstPublished.value;
	}

	/**
	 * Raw Format: Variable length real number, with an explicit decimal point when required, suggested maximum length 6
	 * characters including a decimal point.
	 */
	public String getHeightValue()
	{
		return (height == null) ? null : height.value;
	}

	/**
	 * Raw Format: Variable length real number, with an explicit decimal point when required, suggested maximum length 6
	 * characters including a decimal point.
	 */
	public String getWidthValue()
	{
		return (width == null) ? null : width.value;
	}

	/**
	 * Raw Format: Variable length real number, with an explicit decimal point when required, suggested maximum length 6
	 * characters including a decimal point.
	 */
	public String getThicknessValue()
	{
		return (thickness == null) ? null : thickness.value;
	}

	/**
	 * Raw Format: Variable length real number, with an explicit decimal point when required, suggested maximum length 6
	 * characters including a decimal point.
	 */
	public String getWeightValue()
	{
		return (weight == null) ? null : weight.value;
	}

	/**
	 * Raw Format: Variable length text, suggested maximum length 100 characters.
	 */
	public String getDimensionsValue()
	{
		return (dimensions == null) ? null : dimensions.value;
	}

	/**
	 * Raw Format: Fixed-length, 10 characters, all numeric except last character, which may be letter X.
	 */
	public String getReplacedByISBNValue()
	{
		return (replacedByISBN == null) ? null : replacedByISBN.value;
	}

	/**
	 * Raw Format: Fixed-length, 13 numeric digits.
	 */
	public String getReplacedByEAN13Value()
	{
		return (replacedByEAN13 == null) ? null : replacedByEAN13.value;
	}

	/**
	 * Raw Format: Fixed-length, 10 characters, all numeric except last character, which may be letter X.
	 */
	public String getAlternativeFormatISBNValue()
	{
		return (alternativeFormatISBN == null) ? null : alternativeFormatISBN.value;
	}

	/**
	 * Raw Format: Fixed-length, 13 numeric digits.
	 */
	public String getAlternativeFormatEAN13Value()
	{
		return (alternativeFormatEAN13 == null) ? null : alternativeFormatEAN13.value;
	}

	/**
	 * Raw Format: Fixed-length, 10 characters, all numeric except last character, which may be letter X.
	 */
	public String getAlternativeProductISBNValue()
	{
		return (alternativeProductISBN == null) ? null : alternativeProductISBN.value;
	}

	/**
	 * Raw Format: Fixed-length, 13 numeric digits.
	 */
	public String getAlternativeProductEAN13Value()
	{
		return (alternativeProductEAN13 == null) ? null : alternativeProductEAN13.value;
	}

	/**
	 * Raw Format: Date as year, month, day (YYYYMMDD)
	 */
	public String getOutOfPrintDateValue()
	{
		return (outOfPrintDate == null) ? null : outOfPrintDate.value;
	}

	/**
	 * Raw Format: Variable-length text, suggested maximum length 1,000 characters
	 */
	public String getPromotionCampaignValue()
	{
		return (promotionCampaign == null) ? null : promotionCampaign.value;
	}

	/**
	 * Raw Format: Variable-length text, suggested maximum length 300 characters
	 */
	public String getPromotionContactValue()
	{
		return (promotionContact == null) ? null : promotionContact.value;
	}

	/**
	 * Raw Format: Variable-length text, suggested maximum length 200 characters
	 */
	public String getInitialPrintRunValue()
	{
		return (initialPrintRun == null) ? null : initialPrintRun.value;
	}

	/**
	 * Raw Format: Variable-length text, suggested maximum length 200 characters
	 */
	public List<String> getReprintDetailValues()
	{
		if (reprintDetails != null)
		{
			List<String> list = new ArrayList<>();
			for (ReprintDetail i : reprintDetails)
				list.add(i.value);
			return list;
		}
		return null;
	}

	/**
	 * Raw Format: Variable-length text, suggested maximum length 200 characters
	 */
	public String getCopiesSoldValue()
	{
		return (copiesSold == null) ? null : copiesSold.value;
	}

	/**
	 * Raw Format: Variable-length text, suggested maximum length 200 characters
	 */
	public String getBookClubAdoptionValue()
	{
		return (bookClubAdoption == null) ? null : bookClubAdoption.value;
	}

	public JonixProductIdentifier findProductIdentifier(ProductIdentifierTypes productIDType)
	{
		if (productIdentifiers != null)
		{
			for (ProductIdentifier x : productIdentifiers)
			{
				if (x.getProductIDTypeValue() == productIDType)
					return x.asJonixProductIdentifier();
			}
		}
		return null;
	}

	public List<JonixProductIdentifier> findProductIdentifiers(java.util.Set<ProductIdentifierTypes> productIDTypes)
	{
		if (productIdentifiers != null)
		{
			List<JonixProductIdentifier> matches = new ArrayList<>();
			for (ProductIdentifier x : productIdentifiers)
			{
				if (productIDTypes == null || productIDTypes.contains(x.getProductIDTypeValue()))
					matches.add(x.asJonixProductIdentifier());
			}
			return matches;
		}
		return null;
	}

	public JonixProductFormFeature findProductFormFeature(ProductFormFeatureTypes productFormFeatureType)
	{
		if (productFormFeatures != null)
		{
			for (ProductFormFeature x : productFormFeatures)
			{
				if (x.getProductFormFeatureTypeValue() == productFormFeatureType)
					return x.asJonixProductFormFeature();
			}
		}
		return null;
	}

	public List<JonixProductFormFeature> findProductFormFeatures(
			java.util.Set<ProductFormFeatureTypes> productFormFeatureTypes)
	{
		if (productFormFeatures != null)
		{
			List<JonixProductFormFeature> matches = new ArrayList<>();
			for (ProductFormFeature x : productFormFeatures)
			{
				if (productFormFeatureTypes == null
						|| productFormFeatureTypes.contains(x.getProductFormFeatureTypeValue()))
					matches.add(x.asJonixProductFormFeature());
			}
			return matches;
		}
		return null;
	}

	public JonixProductClassification findProductClassification(ProductClassificationTypes productClassificationType)
	{
		if (productClassifications != null)
		{
			for (ProductClassification x : productClassifications)
			{
				if (x.getProductClassificationTypeValue() == productClassificationType)
					return x.asJonixProductClassification();
			}
		}
		return null;
	}

	public List<JonixProductClassification> findProductClassifications(
			java.util.Set<ProductClassificationTypes> productClassificationTypes)
	{
		if (productClassifications != null)
		{
			List<JonixProductClassification> matches = new ArrayList<>();
			for (ProductClassification x : productClassifications)
			{
				if (productClassificationTypes == null
						|| productClassificationTypes.contains(x.getProductClassificationTypeValue()))
					matches.add(x.asJonixProductClassification());
			}
			return matches;
		}
		return null;
	}

	public JonixTitle findTitle(TitleTypes titleType)
	{
		if (titles != null)
		{
			for (Title x : titles)
			{
				if (x.getTitleTypeValue() == titleType)
					return x.asJonixTitle();
			}
		}
		return null;
	}

	public List<JonixTitle> findTitles(java.util.Set<TitleTypes> titleTypes)
	{
		if (titles != null)
		{
			List<JonixTitle> matches = new ArrayList<>();
			for (Title x : titles)
			{
				if (titleTypes == null || titleTypes.contains(x.getTitleTypeValue()))
					matches.add(x.asJonixTitle());
			}
			return matches;
		}
		return null;
	}

	public JonixWorkIdentifier findWorkIdentifier(WorkIdentifierTypes workIDType)
	{
		if (workIdentifiers != null)
		{
			for (WorkIdentifier x : workIdentifiers)
			{
				if (x.getWorkIDTypeValue() == workIDType)
					return x.asJonixWorkIdentifier();
			}
		}
		return null;
	}

	public List<JonixWorkIdentifier> findWorkIdentifiers(java.util.Set<WorkIdentifierTypes> workIDTypes)
	{
		if (workIdentifiers != null)
		{
			List<JonixWorkIdentifier> matches = new ArrayList<>();
			for (WorkIdentifier x : workIdentifiers)
			{
				if (workIDTypes == null || workIDTypes.contains(x.getWorkIDTypeValue()))
					matches.add(x.asJonixWorkIdentifier());
			}
			return matches;
		}
		return null;
	}

	public JonixLanguage findLanguage(LanguageRoles languageRole)
	{
		if (languages != null)
		{
			for (Language x : languages)
			{
				if (x.getLanguageRoleValue() == languageRole)
					return x.asJonixLanguage();
			}
		}
		return null;
	}

	public List<JonixLanguage> findLanguages(java.util.Set<LanguageRoles> languageRoles)
	{
		if (languages != null)
		{
			List<JonixLanguage> matches = new ArrayList<>();
			for (Language x : languages)
			{
				if (languageRoles == null || languageRoles.contains(x.getLanguageRoleValue()))
					matches.add(x.asJonixLanguage());
			}
			return matches;
		}
		return null;
	}

	public JonixExtent findExtent(ExtentTypes extentType)
	{
		if (extents != null)
		{
			for (Extent x : extents)
			{
				if (x.getExtentTypeValue() == extentType)
					return x.asJonixExtent();
			}
		}
		return null;
	}

	public List<JonixExtent> findExtents(java.util.Set<ExtentTypes> extentTypes)
	{
		if (extents != null)
		{
			List<JonixExtent> matches = new ArrayList<>();
			for (Extent x : extents)
			{
				if (extentTypes == null || extentTypes.contains(x.getExtentTypeValue()))
					matches.add(x.asJonixExtent());
			}
			return matches;
		}
		return null;
	}

	public JonixIllustrations findIllustrations(IllustrationAndOtherContentTypes illustrationType)
	{
		if (illustrationss != null)
		{
			for (Illustrations x : illustrationss)
			{
				if (x.getIllustrationTypeValue() == illustrationType)
					return x.asJonixIllustrations();
			}
		}
		return null;
	}

	public List<JonixIllustrations> findIllustrationss(java.util.Set<IllustrationAndOtherContentTypes> illustrationTypes)
	{
		if (illustrationss != null)
		{
			List<JonixIllustrations> matches = new ArrayList<>();
			for (Illustrations x : illustrationss)
			{
				if (illustrationTypes == null || illustrationTypes.contains(x.getIllustrationTypeValue()))
					matches.add(x.asJonixIllustrations());
			}
			return matches;
		}
		return null;
	}

	public JonixAudience findAudience(AudienceCodeTypes audienceCodeType)
	{
		if (audiences != null)
		{
			for (Audience x : audiences)
			{
				if (x.getAudienceCodeTypeValue() == audienceCodeType)
					return x.asJonixAudience();
			}
		}
		return null;
	}

	public List<JonixAudience> findAudiences(java.util.Set<AudienceCodeTypes> audienceCodeTypes)
	{
		if (audiences != null)
		{
			List<JonixAudience> matches = new ArrayList<>();
			for (Audience x : audiences)
			{
				if (audienceCodeTypes == null || audienceCodeTypes.contains(x.getAudienceCodeTypeValue()))
					matches.add(x.asJonixAudience());
			}
			return matches;
		}
		return null;
	}

	public JonixOtherText findOtherText(OtherTextTypes textTypeCode)
	{
		if (otherTexts != null)
		{
			for (OtherText x : otherTexts)
			{
				if (x.getTextTypeCodeValue() == textTypeCode)
					return x.asJonixOtherText();
			}
		}
		return null;
	}

	public List<JonixOtherText> findOtherTexts(java.util.Set<OtherTextTypes> textTypeCodes)
	{
		if (otherTexts != null)
		{
			List<JonixOtherText> matches = new ArrayList<>();
			for (OtherText x : otherTexts)
			{
				if (textTypeCodes == null || textTypeCodes.contains(x.getTextTypeCodeValue()))
					matches.add(x.asJonixOtherText());
			}
			return matches;
		}
		return null;
	}

	public JonixMediaFile findMediaFile(ImageAudioVideoFileTypes mediaFileTypeCode)
	{
		if (mediaFiles != null)
		{
			for (MediaFile x : mediaFiles)
			{
				if (x.getMediaFileTypeCodeValue() == mediaFileTypeCode)
					return x.asJonixMediaFile();
			}
		}
		return null;
	}

	public List<JonixMediaFile> findMediaFiles(java.util.Set<ImageAudioVideoFileTypes> mediaFileTypeCodes)
	{
		if (mediaFiles != null)
		{
			List<JonixMediaFile> matches = new ArrayList<>();
			for (MediaFile x : mediaFiles)
			{
				if (mediaFileTypeCodes == null || mediaFileTypeCodes.contains(x.getMediaFileTypeCodeValue()))
					matches.add(x.asJonixMediaFile());
			}
			return matches;
		}
		return null;
	}

	public JonixMeasure findMeasure(MeasureTypes measureTypeCode)
	{
		if (measures != null)
		{
			for (Measure x : measures)
			{
				if (x.getMeasureTypeCodeValue() == measureTypeCode)
					return x.asJonixMeasure();
			}
		}
		return null;
	}

	public List<JonixMeasure> findMeasures(java.util.Set<MeasureTypes> measureTypeCodes)
	{
		if (measures != null)
		{
			List<JonixMeasure> matches = new ArrayList<>();
			for (Measure x : measures)
			{
				if (measureTypeCodes == null || measureTypeCodes.contains(x.getMeasureTypeCodeValue()))
					matches.add(x.asJonixMeasure());
			}
			return matches;
		}
		return null;
	}
}
