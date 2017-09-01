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
import java.util.Collections;
import java.util.List;

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

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

public class Product implements OnixSuperComposite, Serializable
{
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

	public Product()
	{
		exists = false;
		element = null;
		initialized = true; // so that no further processing will be done on this intentionally-empty object
	}

	public Product(org.w3c.dom.Element element)
	{
		exists = true;
		initialized = false;
		this.element = element;
	}

	private void initialize()
	{
		if (initialized)
			return;
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
			if (name.equals(RecordReference.refname) || name.equals(RecordReference.shortname))
				recordReference = new RecordReference(e);
			else if (name.equals(NotificationType.refname) || name.equals(NotificationType.shortname))
				notificationType = new NotificationType(e);
			else if (name.equals(DeletionCode.refname) || name.equals(DeletionCode.shortname))
				deletionCode = new DeletionCode(e);
			else if (name.equals(DeletionText.refname) || name.equals(DeletionText.shortname))
				deletionText = new DeletionText(e);
			else if (name.equals(RecordSourceType.refname) || name.equals(RecordSourceType.shortname))
				recordSourceType = new RecordSourceType(e);
			else if (name.equals(RecordSourceIdentifierType.refname)
					|| name.equals(RecordSourceIdentifierType.shortname))
				recordSourceIdentifierType = new RecordSourceIdentifierType(e);
			else if (name.equals(RecordSourceIdentifier.refname) || name.equals(RecordSourceIdentifier.shortname))
				recordSourceIdentifier = new RecordSourceIdentifier(e);
			else if (name.equals(RecordSourceName.refname) || name.equals(RecordSourceName.shortname))
				recordSourceName = new RecordSourceName(e);
			else if (name.equals(ISBN.refname) || name.equals(ISBN.shortname))
				isbn = new ISBN(e);
			else if (name.equals(EAN13.refname) || name.equals(EAN13.shortname))
				ean13 = new EAN13(e);
			else if (name.equals(UPC.refname) || name.equals(UPC.shortname))
				upc = new UPC(e);
			else if (name.equals(PublisherProductNo.refname) || name.equals(PublisherProductNo.shortname))
				publisherProductNo = new PublisherProductNo(e);
			else if (name.equals(ISMN.refname) || name.equals(ISMN.shortname))
				ismn = new ISMN(e);
			else if (name.equals(DOI.refname) || name.equals(DOI.shortname))
				doi = new DOI(e);
			else if (name.equals(ProductIdentifier.refname) || name.equals(ProductIdentifier.shortname))
				productIdentifiers = JPU.addToList(productIdentifiers, new ProductIdentifier(e));
			else if (name.equals(Barcode.refname) || name.equals(Barcode.shortname))
				barcodes = JPU.addToList(barcodes, new Barcode(e));
			else if (name.equals(ReplacesISBN.refname) || name.equals(ReplacesISBN.shortname))
				replacesISBN = new ReplacesISBN(e);
			else if (name.equals(ReplacesEAN13.refname) || name.equals(ReplacesEAN13.shortname))
				replacesEAN13 = new ReplacesEAN13(e);
			else if (name.equals(ProductForm.refname) || name.equals(ProductForm.shortname))
				productForm = new ProductForm(e);
			else if (name.equals(ProductFormDetail.refname) || name.equals(ProductFormDetail.shortname))
				productFormDetails = JPU.addToList(productFormDetails, new ProductFormDetail(e));
			else if (name.equals(ProductFormFeature.refname) || name.equals(ProductFormFeature.shortname))
				productFormFeatures = JPU.addToList(productFormFeatures, new ProductFormFeature(e));
			else if (name.equals(BookFormDetail.refname) || name.equals(BookFormDetail.shortname))
				bookFormDetails = JPU.addToList(bookFormDetails, new BookFormDetail(e));
			else if (name.equals(ProductPackaging.refname) || name.equals(ProductPackaging.shortname))
				productPackaging = new ProductPackaging(e);
			else if (name.equals(ProductFormDescription.refname) || name.equals(ProductFormDescription.shortname))
				productFormDescription = new ProductFormDescription(e);
			else if (name.equals(NumberOfPieces.refname) || name.equals(NumberOfPieces.shortname))
				numberOfPieces = new NumberOfPieces(e);
			else if (name.equals(TradeCategory.refname) || name.equals(TradeCategory.shortname))
				tradeCategory = new TradeCategory(e);
			else if (name.equals(ProductContentType.refname) || name.equals(ProductContentType.shortname))
				productContentTypes = JPU.addToList(productContentTypes, new ProductContentType(e));
			else if (name.equals(ContainedItem.refname) || name.equals(ContainedItem.shortname))
				containedItems = JPU.addToList(containedItems, new ContainedItem(e));
			else if (name.equals(ProductClassification.refname) || name.equals(ProductClassification.shortname))
				productClassifications = JPU.addToList(productClassifications, new ProductClassification(e));
			else if (name.equals(EpubType.refname) || name.equals(EpubType.shortname))
				epubType = new EpubType(e);
			else if (name.equals(EpubTypeVersion.refname) || name.equals(EpubTypeVersion.shortname))
				epubTypeVersion = new EpubTypeVersion(e);
			else if (name.equals(EpubTypeDescription.refname) || name.equals(EpubTypeDescription.shortname))
				epubTypeDescription = new EpubTypeDescription(e);
			else if (name.equals(EpubFormat.refname) || name.equals(EpubFormat.shortname))
				epubFormat = new EpubFormat(e);
			else if (name.equals(EpubFormatVersion.refname) || name.equals(EpubFormatVersion.shortname))
				epubFormatVersion = new EpubFormatVersion(e);
			else if (name.equals(EpubFormatDescription.refname) || name.equals(EpubFormatDescription.shortname))
				epubFormatDescription = new EpubFormatDescription(e);
			else if (name.equals(EpubSource.refname) || name.equals(EpubSource.shortname))
				epubSource = new EpubSource(e);
			else if (name.equals(EpubSourceVersion.refname) || name.equals(EpubSourceVersion.shortname))
				epubSourceVersion = new EpubSourceVersion(e);
			else if (name.equals(EpubSourceDescription.refname) || name.equals(EpubSourceDescription.shortname))
				epubSourceDescription = new EpubSourceDescription(e);
			else if (name.equals(EpubTypeNote.refname) || name.equals(EpubTypeNote.shortname))
				epubTypeNote = new EpubTypeNote(e);
			else if (name.equals(Series.refname) || name.equals(Series.shortname))
				seriess = JPU.addToList(seriess, new Series(e));
			else if (name.equals(NoSeries.refname) || name.equals(NoSeries.shortname))
				noSeries = new NoSeries(e);
			else if (name.equals(Set.refname) || name.equals(Set.shortname))
				sets = JPU.addToList(sets, new Set(e));
			else if (name.equals(TextCaseFlag.refname) || name.equals(TextCaseFlag.shortname))
				textCaseFlag = new TextCaseFlag(e);
			else if (name.equals(DistinctiveTitle.refname) || name.equals(DistinctiveTitle.shortname))
				distinctiveTitle = new DistinctiveTitle(e);
			else if (name.equals(TitlePrefix.refname) || name.equals(TitlePrefix.shortname))
				titlePrefix = new TitlePrefix(e);
			else if (name.equals(TitleWithoutPrefix.refname) || name.equals(TitleWithoutPrefix.shortname))
				titleWithoutPrefix = new TitleWithoutPrefix(e);
			else if (name.equals(Subtitle.refname) || name.equals(Subtitle.shortname))
				subtitle = new Subtitle(e);
			else if (name.equals(TranslationOfTitle.refname) || name.equals(TranslationOfTitle.shortname))
				translationOfTitle = new TranslationOfTitle(e);
			else if (name.equals(FormerTitle.refname) || name.equals(FormerTitle.shortname))
				formerTitles = JPU.addToList(formerTitles, new FormerTitle(e));
			else if (name.equals(Title.refname) || name.equals(Title.shortname))
				titles = JPU.addToList(titles, new Title(e));
			else if (name.equals(WorkIdentifier.refname) || name.equals(WorkIdentifier.shortname))
				workIdentifiers = JPU.addToList(workIdentifiers, new WorkIdentifier(e));
			else if (name.equals(Website.refname) || name.equals(Website.shortname))
				websites = JPU.addToList(websites, new Website(e));
			else if (name.equals(ThesisType.refname) || name.equals(ThesisType.shortname))
				thesisType = new ThesisType(e);
			else if (name.equals(ThesisPresentedTo.refname) || name.equals(ThesisPresentedTo.shortname))
				thesisPresentedTo = new ThesisPresentedTo(e);
			else if (name.equals(ThesisYear.refname) || name.equals(ThesisYear.shortname))
				thesisYear = new ThesisYear(e);
			else if (name.equals(Contributor.refname) || name.equals(Contributor.shortname))
				contributors = JPU.addToList(contributors, new Contributor(e));
			else if (name.equals(ContributorStatement.refname) || name.equals(ContributorStatement.shortname))
				contributorStatement = new ContributorStatement(e);
			else if (name.equals(NoContributor.refname) || name.equals(NoContributor.shortname))
				noContributor = new NoContributor(e);
			else if (name.equals(ConferenceDescription.refname) || name.equals(ConferenceDescription.shortname))
				conferenceDescription = new ConferenceDescription(e);
			else if (name.equals(ConferenceRole.refname) || name.equals(ConferenceRole.shortname))
				conferenceRole = new ConferenceRole(e);
			else if (name.equals(ConferenceName.refname) || name.equals(ConferenceName.shortname))
				conferenceName = new ConferenceName(e);
			else if (name.equals(ConferenceNumber.refname) || name.equals(ConferenceNumber.shortname))
				conferenceNumber = new ConferenceNumber(e);
			else if (name.equals(ConferenceDate.refname) || name.equals(ConferenceDate.shortname))
				conferenceDate = new ConferenceDate(e);
			else if (name.equals(ConferencePlace.refname) || name.equals(ConferencePlace.shortname))
				conferencePlace = new ConferencePlace(e);
			else if (name.equals(Conference.refname) || name.equals(Conference.shortname))
				conferences = JPU.addToList(conferences, new Conference(e));
			else if (name.equals(EditionTypeCode.refname) || name.equals(EditionTypeCode.shortname))
				editionTypeCodes = JPU.addToList(editionTypeCodes, new EditionTypeCode(e));
			else if (name.equals(EditionNumber.refname) || name.equals(EditionNumber.shortname))
				editionNumber = new EditionNumber(e);
			else if (name.equals(EditionVersionNumber.refname) || name.equals(EditionVersionNumber.shortname))
				editionVersionNumber = new EditionVersionNumber(e);
			else if (name.equals(EditionStatement.refname) || name.equals(EditionStatement.shortname))
				editionStatement = new EditionStatement(e);
			else if (name.equals(NoEdition.refname) || name.equals(NoEdition.shortname))
				noEdition = new NoEdition(e);
			else if (name.equals(ReligiousText.refname) || name.equals(ReligiousText.shortname))
				religiousText = new ReligiousText(e);
			else if (name.equals(LanguageOfText.refname) || name.equals(LanguageOfText.shortname))
				languageOfTexts = JPU.addToList(languageOfTexts, new LanguageOfText(e));
			else if (name.equals(OriginalLanguage.refname) || name.equals(OriginalLanguage.shortname))
				originalLanguage = new OriginalLanguage(e);
			else if (name.equals(Language.refname) || name.equals(Language.shortname))
				languages = JPU.addToList(languages, new Language(e));
			else if (name.equals(NumberOfPages.refname) || name.equals(NumberOfPages.shortname))
				numberOfPages = new NumberOfPages(e);
			else if (name.equals(PagesRoman.refname) || name.equals(PagesRoman.shortname))
				pagesRoman = new PagesRoman(e);
			else if (name.equals(PagesArabic.refname) || name.equals(PagesArabic.shortname))
				pagesArabic = new PagesArabic(e);
			else if (name.equals(Extent.refname) || name.equals(Extent.shortname))
				extents = JPU.addToList(extents, new Extent(e));
			else if (name.equals(NumberOfIllustrations.refname) || name.equals(NumberOfIllustrations.shortname))
				numberOfIllustrations = new NumberOfIllustrations(e);
			else if (name.equals(IllustrationsNote.refname) || name.equals(IllustrationsNote.shortname))
				illustrationsNote = new IllustrationsNote(e);
			else if (name.equals(Illustrations.refname) || name.equals(Illustrations.shortname))
				illustrationss = JPU.addToList(illustrationss, new Illustrations(e));
			else if (name.equals(MapScale.refname) || name.equals(MapScale.shortname))
				mapScales = JPU.addToList(mapScales, new MapScale(e));
			else if (name.equals(BASICMainSubject.refname) || name.equals(BASICMainSubject.shortname))
				basicMainSubject = new BASICMainSubject(e);
			else if (name.equals(BASICVersion.refname) || name.equals(BASICVersion.shortname))
				basicVersion = new BASICVersion(e);
			else if (name.equals(BICMainSubject.refname) || name.equals(BICMainSubject.shortname))
				bicMainSubject = new BICMainSubject(e);
			else if (name.equals(BICVersion.refname) || name.equals(BICVersion.shortname))
				bicVersion = new BICVersion(e);
			else if (name.equals(MainSubject.refname) || name.equals(MainSubject.shortname))
				mainSubjects = JPU.addToList(mainSubjects, new MainSubject(e));
			else if (name.equals(Subject.refname) || name.equals(Subject.shortname))
				subjects = JPU.addToList(subjects, new Subject(e));
			else if (name.equals(PersonAsSubject.refname) || name.equals(PersonAsSubject.shortname))
				personAsSubjects = JPU.addToList(personAsSubjects, new PersonAsSubject(e));
			else if (name.equals(CorporateBodyAsSubject.refname) || name.equals(CorporateBodyAsSubject.shortname))
				corporateBodyAsSubjects = JPU.addToList(corporateBodyAsSubjects, new CorporateBodyAsSubject(e));
			else if (name.equals(PlaceAsSubject.refname) || name.equals(PlaceAsSubject.shortname))
				placeAsSubjects = JPU.addToList(placeAsSubjects, new PlaceAsSubject(e));
			else if (name.equals(AudienceCode.refname) || name.equals(AudienceCode.shortname))
				audienceCodes = JPU.addToList(audienceCodes, new AudienceCode(e));
			else if (name.equals(Audience.refname) || name.equals(Audience.shortname))
				audiences = JPU.addToList(audiences, new Audience(e));
			else if (name.equals(USSchoolGrade.refname) || name.equals(USSchoolGrade.shortname))
				usSchoolGrade = new USSchoolGrade(e);
			else if (name.equals(InterestAge.refname) || name.equals(InterestAge.shortname))
				interestAge = new InterestAge(e);
			else if (name.equals(AudienceRange.refname) || name.equals(AudienceRange.shortname))
				audienceRanges = JPU.addToList(audienceRanges, new AudienceRange(e));
			else if (name.equals(AudienceDescription.refname) || name.equals(AudienceDescription.shortname))
				audienceDescription = new AudienceDescription(e);
			else if (name.equals(Complexity.refname) || name.equals(Complexity.shortname))
				complexitys = JPU.addToList(complexitys, new Complexity(e));
			else if (name.equals(Annotation.refname) || name.equals(Annotation.shortname))
				annotation = new Annotation(e);
			else if (name.equals(MainDescription.refname) || name.equals(MainDescription.shortname))
				mainDescription = new MainDescription(e);
			else if (name.equals(OtherText.refname) || name.equals(OtherText.shortname))
				otherTexts = JPU.addToList(otherTexts, new OtherText(e));
			else if (name.equals(ReviewQuote.refname) || name.equals(ReviewQuote.shortname))
				reviewQuotes = JPU.addToList(reviewQuotes, new ReviewQuote(e));
			else if (name.equals(CoverImageFormatCode.refname) || name.equals(CoverImageFormatCode.shortname))
				coverImageFormatCode = new CoverImageFormatCode(e);
			else if (name.equals(CoverImageLinkTypeCode.refname) || name.equals(CoverImageLinkTypeCode.shortname))
				coverImageLinkTypeCode = new CoverImageLinkTypeCode(e);
			else if (name.equals(CoverImageLink.refname) || name.equals(CoverImageLink.shortname))
				coverImageLink = new CoverImageLink(e);
			else if (name.equals(MediaFile.refname) || name.equals(MediaFile.shortname))
				mediaFiles = JPU.addToList(mediaFiles, new MediaFile(e));
			else if (name.equals(ProductWebsite.refname) || name.equals(ProductWebsite.shortname))
				productWebsites = JPU.addToList(productWebsites, new ProductWebsite(e));
			else if (name.equals(PrizesDescription.refname) || name.equals(PrizesDescription.shortname))
				prizesDescription = new PrizesDescription(e);
			else if (name.equals(Prize.refname) || name.equals(Prize.shortname))
				prizes = JPU.addToList(prizes, new Prize(e));
			else if (name.equals(ContentItem.refname) || name.equals(ContentItem.shortname))
				contentItems = JPU.addToList(contentItems, new ContentItem(e));
			else if (name.equals(ImprintName.refname) || name.equals(ImprintName.shortname))
				imprintName = new ImprintName(e);
			else if (name.equals(Imprint.refname) || name.equals(Imprint.shortname))
				imprints = JPU.addToList(imprints, new Imprint(e));
			else if (name.equals(PublisherName.refname) || name.equals(PublisherName.shortname))
				publisherName = new PublisherName(e);
			else if (name.equals(Publisher.refname) || name.equals(Publisher.shortname))
				publishers = JPU.addToList(publishers, new Publisher(e));
			else if (name.equals(CityOfPublication.refname) || name.equals(CityOfPublication.shortname))
				cityOfPublications = JPU.addToList(cityOfPublications, new CityOfPublication(e));
			else if (name.equals(CountryOfPublication.refname) || name.equals(CountryOfPublication.shortname))
				countryOfPublication = new CountryOfPublication(e);
			else if (name.equals(CopublisherName.refname) || name.equals(CopublisherName.shortname))
				copublisherNames = JPU.addToList(copublisherNames, new CopublisherName(e));
			else if (name.equals(SponsorName.refname) || name.equals(SponsorName.shortname))
				sponsorNames = JPU.addToList(sponsorNames, new SponsorName(e));
			else if (name.equals(OriginalPublisher.refname) || name.equals(OriginalPublisher.shortname))
				originalPublisher = new OriginalPublisher(e);
			else if (name.equals(PublishingStatus.refname) || name.equals(PublishingStatus.shortname))
				publishingStatus = new PublishingStatus(e);
			else if (name.equals(PublishingStatusNote.refname) || name.equals(PublishingStatusNote.shortname))
				publishingStatusNote = new PublishingStatusNote(e);
			else if (name.equals(AnnouncementDate.refname) || name.equals(AnnouncementDate.shortname))
				announcementDate = new AnnouncementDate(e);
			else if (name.equals(TradeAnnouncementDate.refname) || name.equals(TradeAnnouncementDate.shortname))
				tradeAnnouncementDate = new TradeAnnouncementDate(e);
			else if (name.equals(PublicationDate.refname) || name.equals(PublicationDate.shortname))
				publicationDate = new PublicationDate(e);
			else if (name.equals(CopyrightStatement.refname) || name.equals(CopyrightStatement.shortname))
				copyrightStatements = JPU.addToList(copyrightStatements, new CopyrightStatement(e));
			else if (name.equals(CopyrightYear.refname) || name.equals(CopyrightYear.shortname))
				copyrightYear = new CopyrightYear(e);
			else if (name.equals(YearFirstPublished.refname) || name.equals(YearFirstPublished.shortname))
				yearFirstPublished = new YearFirstPublished(e);
			else if (name.equals(SalesRights.refname) || name.equals(SalesRights.shortname))
				salesRightss = JPU.addToList(salesRightss, new SalesRights(e));
			else if (name.equals(NotForSale.refname) || name.equals(NotForSale.shortname))
				notForSales = JPU.addToList(notForSales, new NotForSale(e));
			else if (name.equals(SalesRestriction.refname) || name.equals(SalesRestriction.shortname))
				salesRestrictions = JPU.addToList(salesRestrictions, new SalesRestriction(e));
			else if (name.equals(Height.refname) || name.equals(Height.shortname))
				height = new Height(e);
			else if (name.equals(Width.refname) || name.equals(Width.shortname))
				width = new Width(e);
			else if (name.equals(Thickness.refname) || name.equals(Thickness.shortname))
				thickness = new Thickness(e);
			else if (name.equals(Weight.refname) || name.equals(Weight.shortname))
				weight = new Weight(e);
			else if (name.equals(Measure.refname) || name.equals(Measure.shortname))
				measures = JPU.addToList(measures, new Measure(e));
			else if (name.equals(Dimensions.refname) || name.equals(Dimensions.shortname))
				dimensions = new Dimensions(e);
			else if (name.equals(ReplacedByISBN.refname) || name.equals(ReplacedByISBN.shortname))
				replacedByISBN = new ReplacedByISBN(e);
			else if (name.equals(ReplacedByEAN13.refname) || name.equals(ReplacedByEAN13.shortname))
				replacedByEAN13 = new ReplacedByEAN13(e);
			else if (name.equals(AlternativeFormatISBN.refname) || name.equals(AlternativeFormatISBN.shortname))
				alternativeFormatISBN = new AlternativeFormatISBN(e);
			else if (name.equals(AlternativeFormatEAN13.refname) || name.equals(AlternativeFormatEAN13.shortname))
				alternativeFormatEAN13 = new AlternativeFormatEAN13(e);
			else if (name.equals(AlternativeProductISBN.refname) || name.equals(AlternativeProductISBN.shortname))
				alternativeProductISBN = new AlternativeProductISBN(e);
			else if (name.equals(AlternativeProductEAN13.refname) || name.equals(AlternativeProductEAN13.shortname))
				alternativeProductEAN13 = new AlternativeProductEAN13(e);
			else if (name.equals(RelatedProduct.refname) || name.equals(RelatedProduct.shortname))
				relatedProducts = JPU.addToList(relatedProducts, new RelatedProduct(e));
			else if (name.equals(OutOfPrintDate.refname) || name.equals(OutOfPrintDate.shortname))
				outOfPrintDate = new OutOfPrintDate(e);
			else if (name.equals(SupplyDetail.refname) || name.equals(SupplyDetail.shortname))
				supplyDetails = JPU.addToList(supplyDetails, new SupplyDetail(e));
			else if (name.equals(MarketRepresentation.refname) || name.equals(MarketRepresentation.shortname))
				marketRepresentations = JPU.addToList(marketRepresentations, new MarketRepresentation(e));
			else if (name.equals(PromotionCampaign.refname) || name.equals(PromotionCampaign.shortname))
				promotionCampaign = new PromotionCampaign(e);
			else if (name.equals(PromotionContact.refname) || name.equals(PromotionContact.shortname))
				promotionContact = new PromotionContact(e);
			else if (name.equals(InitialPrintRun.refname) || name.equals(InitialPrintRun.shortname))
				initialPrintRun = new InitialPrintRun(e);
			else if (name.equals(ReprintDetail.refname) || name.equals(ReprintDetail.shortname))
				reprintDetails = JPU.addToList(reprintDetails, new ReprintDetail(e));
			else if (name.equals(CopiesSold.refname) || name.equals(CopiesSold.shortname))
				copiesSold = new CopiesSold(e);
			else if (name.equals(BookClubAdoption.refname) || name.equals(BookClubAdoption.shortname))
				bookClubAdoption = new BookClubAdoption(e);
		});
	}

	@Override
	public boolean exists()
	{
		return exists;
	}

	/////////////////////////////////////////////////////////////////////////////////
	// MEMBERS
	/////////////////////////////////////////////////////////////////////////////////

	private RecordReference recordReference = RecordReference.EMPTY;

	/**
	 * (this field is required)
	 */
	public RecordReference recordReference()
	{
		initialize();
		return recordReference;
	}

	private NotificationType notificationType = NotificationType.EMPTY;

	/**
	 * (this field is required)
	 */
	public NotificationType notificationType()
	{
		initialize();
		return notificationType;
	}

	private DeletionCode deletionCode = DeletionCode.EMPTY;

	/**
	 * (this field is optional)
	 */
	public DeletionCode deletionCode()
	{
		initialize();
		return deletionCode;
	}

	private DeletionText deletionText = DeletionText.EMPTY;

	/**
	 * (this field is optional)
	 */
	public DeletionText deletionText()
	{
		initialize();
		return deletionText;
	}

	private RecordSourceType recordSourceType = RecordSourceType.EMPTY;

	/**
	 * (this field is optional)
	 */
	public RecordSourceType recordSourceType()
	{
		initialize();
		return recordSourceType;
	}

	private RecordSourceIdentifierType recordSourceIdentifierType = RecordSourceIdentifierType.EMPTY;

	/**
	 * (this field is optional)
	 */
	public RecordSourceIdentifierType recordSourceIdentifierType()
	{
		initialize();
		return recordSourceIdentifierType;
	}

	private RecordSourceIdentifier recordSourceIdentifier = RecordSourceIdentifier.EMPTY;

	/**
	 * (this field is optional)
	 */
	public RecordSourceIdentifier recordSourceIdentifier()
	{
		initialize();
		return recordSourceIdentifier;
	}

	private RecordSourceName recordSourceName = RecordSourceName.EMPTY;

	/**
	 * (this field is optional)
	 */
	public RecordSourceName recordSourceName()
	{
		initialize();
		return recordSourceName;
	}

	private ISBN isbn = ISBN.EMPTY;

	/**
	 * (this field is required)
	 */
	public ISBN isbn()
	{
		initialize();
		return isbn;
	}

	private EAN13 ean13 = EAN13.EMPTY;

	/**
	 * (this field is optional)
	 */
	public EAN13 ean13()
	{
		initialize();
		return ean13;
	}

	private UPC upc = UPC.EMPTY;

	/**
	 * (this field is optional)
	 */
	public UPC upc()
	{
		initialize();
		return upc;
	}

	private PublisherProductNo publisherProductNo = PublisherProductNo.EMPTY;

	/**
	 * (this field is optional)
	 */
	public PublisherProductNo publisherProductNo()
	{
		initialize();
		return publisherProductNo;
	}

	private ISMN ismn = ISMN.EMPTY;

	/**
	 * (this field is optional)
	 */
	public ISMN ismn()
	{
		initialize();
		return ismn;
	}

	private DOI doi = DOI.EMPTY;

	/**
	 * (this field is optional)
	 */
	public DOI doi()
	{
		initialize();
		return doi;
	}

	private ListOfOnixDataCompositeWithKey<ProductIdentifier, JonixProductIdentifier, ProductIdentifierTypes> productIdentifiers = ListOfOnixDataCompositeWithKey
			.emptyKeyed();

	/**
	 * (this list may be empty)
	 */
	public ListOfOnixDataCompositeWithKey<ProductIdentifier, JonixProductIdentifier, ProductIdentifierTypes> productIdentifiers()
	{
		initialize();
		return productIdentifiers;
	}

	private ListOfOnixElement<Barcode, BarcodeIndicators> barcodes = ListOfOnixElement.empty();

	/**
	 * (this list may be empty)
	 */
	public ListOfOnixElement<Barcode, BarcodeIndicators> barcodes()
	{
		initialize();
		return barcodes;
	}

	private ReplacesISBN replacesISBN = ReplacesISBN.EMPTY;

	/**
	 * (this field is optional)
	 */
	public ReplacesISBN replacesISBN()
	{
		initialize();
		return replacesISBN;
	}

	private ReplacesEAN13 replacesEAN13 = ReplacesEAN13.EMPTY;

	/**
	 * (this field is optional)
	 */
	public ReplacesEAN13 replacesEAN13()
	{
		initialize();
		return replacesEAN13;
	}

	private ProductForm productForm = ProductForm.EMPTY;

	/**
	 * (this field is optional)
	 */
	public ProductForm productForm()
	{
		initialize();
		return productForm;
	}

	private ListOfOnixElement<ProductFormDetail, ProductFormDetails> productFormDetails = ListOfOnixElement.empty();

	/**
	 * (this list may be empty)
	 */
	public ListOfOnixElement<ProductFormDetail, ProductFormDetails> productFormDetails()
	{
		initialize();
		return productFormDetails;
	}

	private ListOfOnixDataCompositeWithKey<ProductFormFeature, JonixProductFormFeature, ProductFormFeatureTypes> productFormFeatures = ListOfOnixDataCompositeWithKey
			.emptyKeyed();

	/**
	 * (this list may be empty)
	 */
	public ListOfOnixDataCompositeWithKey<ProductFormFeature, JonixProductFormFeature, ProductFormFeatureTypes> productFormFeatures()
	{
		initialize();
		return productFormFeatures;
	}

	private ListOfOnixElement<BookFormDetail, BookFormDetails> bookFormDetails = ListOfOnixElement.empty();

	/**
	 * (this list may be empty)
	 */
	public ListOfOnixElement<BookFormDetail, BookFormDetails> bookFormDetails()
	{
		initialize();
		return bookFormDetails;
	}

	private ProductPackaging productPackaging = ProductPackaging.EMPTY;

	/**
	 * (this field is optional)
	 */
	public ProductPackaging productPackaging()
	{
		initialize();
		return productPackaging;
	}

	private ProductFormDescription productFormDescription = ProductFormDescription.EMPTY;

	/**
	 * (this field is optional)
	 */
	public ProductFormDescription productFormDescription()
	{
		initialize();
		return productFormDescription;
	}

	private NumberOfPieces numberOfPieces = NumberOfPieces.EMPTY;

	/**
	 * (this field is optional)
	 */
	public NumberOfPieces numberOfPieces()
	{
		initialize();
		return numberOfPieces;
	}

	private TradeCategory tradeCategory = TradeCategory.EMPTY;

	/**
	 * (this field is optional)
	 */
	public TradeCategory tradeCategory()
	{
		initialize();
		return tradeCategory;
	}

	private ListOfOnixElement<ProductContentType, ProductContentTypes> productContentTypes = ListOfOnixElement.empty();

	/**
	 * (this list may be empty)
	 */
	public ListOfOnixElement<ProductContentType, ProductContentTypes> productContentTypes()
	{
		initialize();
		return productContentTypes;
	}

	private List<ContainedItem> containedItems = Collections.emptyList();

	/**
	 * (this list may be empty)
	 */
	public List<ContainedItem> containedItems()
	{
		initialize();
		return containedItems;
	}

	private ListOfOnixDataCompositeWithKey<ProductClassification, JonixProductClassification, ProductClassificationTypes> productClassifications = ListOfOnixDataCompositeWithKey
			.emptyKeyed();

	/**
	 * (this list may be empty)
	 */
	public ListOfOnixDataCompositeWithKey<ProductClassification, JonixProductClassification, ProductClassificationTypes> productClassifications()
	{
		initialize();
		return productClassifications;
	}

	private EpubType epubType = EpubType.EMPTY;

	/**
	 * (this field is optional)
	 */
	public EpubType epubType()
	{
		initialize();
		return epubType;
	}

	private EpubTypeVersion epubTypeVersion = EpubTypeVersion.EMPTY;

	/**
	 * (this field is optional)
	 */
	public EpubTypeVersion epubTypeVersion()
	{
		initialize();
		return epubTypeVersion;
	}

	private EpubTypeDescription epubTypeDescription = EpubTypeDescription.EMPTY;

	/**
	 * (this field is optional)
	 */
	public EpubTypeDescription epubTypeDescription()
	{
		initialize();
		return epubTypeDescription;
	}

	private EpubFormat epubFormat = EpubFormat.EMPTY;

	/**
	 * (this field is optional)
	 */
	public EpubFormat epubFormat()
	{
		initialize();
		return epubFormat;
	}

	private EpubFormatVersion epubFormatVersion = EpubFormatVersion.EMPTY;

	/**
	 * (this field is optional)
	 */
	public EpubFormatVersion epubFormatVersion()
	{
		initialize();
		return epubFormatVersion;
	}

	private EpubFormatDescription epubFormatDescription = EpubFormatDescription.EMPTY;

	/**
	 * (this field is optional)
	 */
	public EpubFormatDescription epubFormatDescription()
	{
		initialize();
		return epubFormatDescription;
	}

	private EpubSource epubSource = EpubSource.EMPTY;

	/**
	 * (this field is optional)
	 */
	public EpubSource epubSource()
	{
		initialize();
		return epubSource;
	}

	private EpubSourceVersion epubSourceVersion = EpubSourceVersion.EMPTY;

	/**
	 * (this field is optional)
	 */
	public EpubSourceVersion epubSourceVersion()
	{
		initialize();
		return epubSourceVersion;
	}

	private EpubSourceDescription epubSourceDescription = EpubSourceDescription.EMPTY;

	/**
	 * (this field is optional)
	 */
	public EpubSourceDescription epubSourceDescription()
	{
		initialize();
		return epubSourceDescription;
	}

	private EpubTypeNote epubTypeNote = EpubTypeNote.EMPTY;

	/**
	 * (this field is optional)
	 */
	public EpubTypeNote epubTypeNote()
	{
		initialize();
		return epubTypeNote;
	}

	private List<Series> seriess = Collections.emptyList();

	/**
	 * (this list may be empty)
	 */
	public List<Series> seriess()
	{
		initialize();
		return seriess;
	}

	private NoSeries noSeries = NoSeries.EMPTY;

	/**
	 * (this field is optional)
	 */
	public NoSeries noSeries()
	{
		initialize();
		return noSeries;
	}

	public boolean isNoSeries()
	{
		return (noSeries().exists());
	}

	private List<Set> sets = Collections.emptyList();

	/**
	 * (this list may be empty)
	 */
	public List<Set> sets()
	{
		initialize();
		return sets;
	}

	private TextCaseFlag textCaseFlag = TextCaseFlag.EMPTY;

	/**
	 * (this field is optional)
	 */
	public TextCaseFlag textCaseFlag()
	{
		initialize();
		return textCaseFlag;
	}

	private DistinctiveTitle distinctiveTitle = DistinctiveTitle.EMPTY;

	/**
	 * (this field is required)
	 */
	public DistinctiveTitle distinctiveTitle()
	{
		initialize();
		return distinctiveTitle;
	}

	private TitlePrefix titlePrefix = TitlePrefix.EMPTY;

	/**
	 * (this field is optional)
	 */
	public TitlePrefix titlePrefix()
	{
		initialize();
		return titlePrefix;
	}

	private TitleWithoutPrefix titleWithoutPrefix = TitleWithoutPrefix.EMPTY;

	/**
	 * (this field is optional)
	 */
	public TitleWithoutPrefix titleWithoutPrefix()
	{
		initialize();
		return titleWithoutPrefix;
	}

	private Subtitle subtitle = Subtitle.EMPTY;

	/**
	 * (this field is optional)
	 */
	public Subtitle subtitle()
	{
		initialize();
		return subtitle;
	}

	private TranslationOfTitle translationOfTitle = TranslationOfTitle.EMPTY;

	/**
	 * (this field is optional)
	 */
	public TranslationOfTitle translationOfTitle()
	{
		initialize();
		return translationOfTitle;
	}

	private ListOfOnixElement<FormerTitle, String> formerTitles = ListOfOnixElement.empty();

	/**
	 * (this list may be empty)
	 */
	public ListOfOnixElement<FormerTitle, String> formerTitles()
	{
		initialize();
		return formerTitles;
	}

	private ListOfOnixDataCompositeWithKey<Title, JonixTitle, TitleTypes> titles = ListOfOnixDataCompositeWithKey
			.emptyKeyed();

	/**
	 * (this list may be empty)
	 */
	public ListOfOnixDataCompositeWithKey<Title, JonixTitle, TitleTypes> titles()
	{
		initialize();
		return titles;
	}

	private ListOfOnixDataCompositeWithKey<WorkIdentifier, JonixWorkIdentifier, WorkIdentifierTypes> workIdentifiers = ListOfOnixDataCompositeWithKey
			.emptyKeyed();

	/**
	 * (this list may be empty)
	 */
	public ListOfOnixDataCompositeWithKey<WorkIdentifier, JonixWorkIdentifier, WorkIdentifierTypes> workIdentifiers()
	{
		initialize();
		return workIdentifiers;
	}

	private ListOfOnixDataComposite<Website, JonixWebsite> websites = ListOfOnixDataComposite.empty();

	/**
	 * (this list may be empty)
	 */
	public ListOfOnixDataComposite<Website, JonixWebsite> websites()
	{
		initialize();
		return websites;
	}

	private ThesisType thesisType = ThesisType.EMPTY;

	/**
	 * (this field is optional)
	 */
	public ThesisType thesisType()
	{
		initialize();
		return thesisType;
	}

	private ThesisPresentedTo thesisPresentedTo = ThesisPresentedTo.EMPTY;

	/**
	 * (this field is optional)
	 */
	public ThesisPresentedTo thesisPresentedTo()
	{
		initialize();
		return thesisPresentedTo;
	}

	private ThesisYear thesisYear = ThesisYear.EMPTY;

	/**
	 * (this field is optional)
	 */
	public ThesisYear thesisYear()
	{
		initialize();
		return thesisYear;
	}

	private List<Contributor> contributors = Collections.emptyList();

	/**
	 * (this list is required to contain at least one item)
	 */
	public List<Contributor> contributors()
	{
		initialize();
		return contributors;
	}

	private ContributorStatement contributorStatement = ContributorStatement.EMPTY;

	/**
	 * (this field is optional)
	 */
	public ContributorStatement contributorStatement()
	{
		initialize();
		return contributorStatement;
	}

	private NoContributor noContributor = NoContributor.EMPTY;

	/**
	 * (this field is optional)
	 */
	public NoContributor noContributor()
	{
		initialize();
		return noContributor;
	}

	public boolean isNoContributor()
	{
		return (noContributor().exists());
	}

	private ConferenceDescription conferenceDescription = ConferenceDescription.EMPTY;

	/**
	 * (this field is optional)
	 */
	public ConferenceDescription conferenceDescription()
	{
		initialize();
		return conferenceDescription;
	}

	private ConferenceRole conferenceRole = ConferenceRole.EMPTY;

	/**
	 * (this field is optional)
	 */
	public ConferenceRole conferenceRole()
	{
		initialize();
		return conferenceRole;
	}

	private ConferenceName conferenceName = ConferenceName.EMPTY;

	/**
	 * (this field is required)
	 */
	public ConferenceName conferenceName()
	{
		initialize();
		return conferenceName;
	}

	private ConferenceNumber conferenceNumber = ConferenceNumber.EMPTY;

	/**
	 * (this field is optional)
	 */
	public ConferenceNumber conferenceNumber()
	{
		initialize();
		return conferenceNumber;
	}

	private ConferenceDate conferenceDate = ConferenceDate.EMPTY;

	/**
	 * (this field is optional)
	 */
	public ConferenceDate conferenceDate()
	{
		initialize();
		return conferenceDate;
	}

	private ConferencePlace conferencePlace = ConferencePlace.EMPTY;

	/**
	 * (this field is optional)
	 */
	public ConferencePlace conferencePlace()
	{
		initialize();
		return conferencePlace;
	}

	private List<Conference> conferences = Collections.emptyList();

	/**
	 * (this list may be empty)
	 */
	public List<Conference> conferences()
	{
		initialize();
		return conferences;
	}

	private ListOfOnixElement<EditionTypeCode, EditionTypes> editionTypeCodes = ListOfOnixElement.empty();

	/**
	 * (this list may be empty)
	 */
	public ListOfOnixElement<EditionTypeCode, EditionTypes> editionTypeCodes()
	{
		initialize();
		return editionTypeCodes;
	}

	private EditionNumber editionNumber = EditionNumber.EMPTY;

	/**
	 * (this field is optional)
	 */
	public EditionNumber editionNumber()
	{
		initialize();
		return editionNumber;
	}

	private EditionVersionNumber editionVersionNumber = EditionVersionNumber.EMPTY;

	/**
	 * (this field is optional)
	 */
	public EditionVersionNumber editionVersionNumber()
	{
		initialize();
		return editionVersionNumber;
	}

	private EditionStatement editionStatement = EditionStatement.EMPTY;

	/**
	 * (this field is optional)
	 */
	public EditionStatement editionStatement()
	{
		initialize();
		return editionStatement;
	}

	private NoEdition noEdition = NoEdition.EMPTY;

	/**
	 * (this field is optional)
	 */
	public NoEdition noEdition()
	{
		initialize();
		return noEdition;
	}

	public boolean isNoEdition()
	{
		return (noEdition().exists());
	}

	private ReligiousText religiousText = ReligiousText.EMPTY;

	/**
	 * (this field is optional)
	 */
	public ReligiousText religiousText()
	{
		initialize();
		return religiousText;
	}

	private ListOfOnixElement<LanguageOfText, LanguageCodes> languageOfTexts = ListOfOnixElement.empty();

	/**
	 * (this list may be empty)
	 */
	public ListOfOnixElement<LanguageOfText, LanguageCodes> languageOfTexts()
	{
		initialize();
		return languageOfTexts;
	}

	private OriginalLanguage originalLanguage = OriginalLanguage.EMPTY;

	/**
	 * (this field is optional)
	 */
	public OriginalLanguage originalLanguage()
	{
		initialize();
		return originalLanguage;
	}

	private ListOfOnixDataCompositeWithKey<Language, JonixLanguage, LanguageRoles> languages = ListOfOnixDataCompositeWithKey
			.emptyKeyed();

	/**
	 * (this list may be empty)
	 */
	public ListOfOnixDataCompositeWithKey<Language, JonixLanguage, LanguageRoles> languages()
	{
		initialize();
		return languages;
	}

	private NumberOfPages numberOfPages = NumberOfPages.EMPTY;

	/**
	 * (this field is optional)
	 */
	public NumberOfPages numberOfPages()
	{
		initialize();
		return numberOfPages;
	}

	private PagesRoman pagesRoman = PagesRoman.EMPTY;

	/**
	 * (this field is optional)
	 */
	public PagesRoman pagesRoman()
	{
		initialize();
		return pagesRoman;
	}

	private PagesArabic pagesArabic = PagesArabic.EMPTY;

	/**
	 * (this field is optional)
	 */
	public PagesArabic pagesArabic()
	{
		initialize();
		return pagesArabic;
	}

	private ListOfOnixDataCompositeWithKey<Extent, JonixExtent, ExtentTypes> extents = ListOfOnixDataCompositeWithKey
			.emptyKeyed();

	/**
	 * (this list may be empty)
	 */
	public ListOfOnixDataCompositeWithKey<Extent, JonixExtent, ExtentTypes> extents()
	{
		initialize();
		return extents;
	}

	private NumberOfIllustrations numberOfIllustrations = NumberOfIllustrations.EMPTY;

	/**
	 * (this field is optional)
	 */
	public NumberOfIllustrations numberOfIllustrations()
	{
		initialize();
		return numberOfIllustrations;
	}

	private IllustrationsNote illustrationsNote = IllustrationsNote.EMPTY;

	/**
	 * (this field is optional)
	 */
	public IllustrationsNote illustrationsNote()
	{
		initialize();
		return illustrationsNote;
	}

	private ListOfOnixDataCompositeWithKey<Illustrations, JonixIllustrations, IllustrationAndOtherContentTypes> illustrationss = ListOfOnixDataCompositeWithKey
			.emptyKeyed();

	/**
	 * (this list may be empty)
	 */
	public ListOfOnixDataCompositeWithKey<Illustrations, JonixIllustrations, IllustrationAndOtherContentTypes> illustrationss()
	{
		initialize();
		return illustrationss;
	}

	private ListOfOnixElement<MapScale, String> mapScales = ListOfOnixElement.empty();

	/**
	 * (this list may be empty)
	 */
	public ListOfOnixElement<MapScale, String> mapScales()
	{
		initialize();
		return mapScales;
	}

	private BASICMainSubject basicMainSubject = BASICMainSubject.EMPTY;

	/**
	 * (this field is optional)
	 */
	public BASICMainSubject basicMainSubject()
	{
		initialize();
		return basicMainSubject;
	}

	private BASICVersion basicVersion = BASICVersion.EMPTY;

	/**
	 * (this field is optional)
	 */
	public BASICVersion basicVersion()
	{
		initialize();
		return basicVersion;
	}

	private BICMainSubject bicMainSubject = BICMainSubject.EMPTY;

	/**
	 * (this field is optional)
	 */
	public BICMainSubject bicMainSubject()
	{
		initialize();
		return bicMainSubject;
	}

	private BICVersion bicVersion = BICVersion.EMPTY;

	/**
	 * (this field is optional)
	 */
	public BICVersion bicVersion()
	{
		initialize();
		return bicVersion;
	}

	private ListOfOnixDataComposite<MainSubject, JonixMainSubject> mainSubjects = ListOfOnixDataComposite.empty();

	/**
	 * (this list may be empty)
	 */
	public ListOfOnixDataComposite<MainSubject, JonixMainSubject> mainSubjects()
	{
		initialize();
		return mainSubjects;
	}

	private ListOfOnixDataComposite<Subject, JonixSubject> subjects = ListOfOnixDataComposite.empty();

	/**
	 * (this list may be empty)
	 */
	public ListOfOnixDataComposite<Subject, JonixSubject> subjects()
	{
		initialize();
		return subjects;
	}

	private List<PersonAsSubject> personAsSubjects = Collections.emptyList();

	/**
	 * (this list may be empty)
	 */
	public List<PersonAsSubject> personAsSubjects()
	{
		initialize();
		return personAsSubjects;
	}

	private ListOfOnixElement<CorporateBodyAsSubject, String> corporateBodyAsSubjects = ListOfOnixElement.empty();

	/**
	 * (this list may be empty)
	 */
	public ListOfOnixElement<CorporateBodyAsSubject, String> corporateBodyAsSubjects()
	{
		initialize();
		return corporateBodyAsSubjects;
	}

	private ListOfOnixElement<PlaceAsSubject, String> placeAsSubjects = ListOfOnixElement.empty();

	/**
	 * (this list may be empty)
	 */
	public ListOfOnixElement<PlaceAsSubject, String> placeAsSubjects()
	{
		initialize();
		return placeAsSubjects;
	}

	private ListOfOnixElement<AudienceCode, Audiences> audienceCodes = ListOfOnixElement.empty();

	/**
	 * (this list may be empty)
	 */
	public ListOfOnixElement<AudienceCode, Audiences> audienceCodes()
	{
		initialize();
		return audienceCodes;
	}

	private ListOfOnixDataCompositeWithKey<Audience, JonixAudience, AudienceCodeTypes> audiences = ListOfOnixDataCompositeWithKey
			.emptyKeyed();

	/**
	 * (this list may be empty)
	 */
	public ListOfOnixDataCompositeWithKey<Audience, JonixAudience, AudienceCodeTypes> audiences()
	{
		initialize();
		return audiences;
	}

	private USSchoolGrade usSchoolGrade = USSchoolGrade.EMPTY;

	/**
	 * (this field is optional)
	 */
	public USSchoolGrade usSchoolGrade()
	{
		initialize();
		return usSchoolGrade;
	}

	private InterestAge interestAge = InterestAge.EMPTY;

	/**
	 * (this field is optional)
	 */
	public InterestAge interestAge()
	{
		initialize();
		return interestAge;
	}

	private ListOfOnixDataComposite<AudienceRange, JonixAudienceRange> audienceRanges = ListOfOnixDataComposite.empty();

	/**
	 * (this list may be empty)
	 */
	public ListOfOnixDataComposite<AudienceRange, JonixAudienceRange> audienceRanges()
	{
		initialize();
		return audienceRanges;
	}

	private AudienceDescription audienceDescription = AudienceDescription.EMPTY;

	/**
	 * (this field is optional)
	 */
	public AudienceDescription audienceDescription()
	{
		initialize();
		return audienceDescription;
	}

	private ListOfOnixDataComposite<Complexity, JonixComplexity> complexitys = ListOfOnixDataComposite.empty();

	/**
	 * (this list may be empty)
	 */
	public ListOfOnixDataComposite<Complexity, JonixComplexity> complexitys()
	{
		initialize();
		return complexitys;
	}

	private Annotation annotation = Annotation.EMPTY;

	/**
	 * (this field is optional)
	 */
	public Annotation annotation()
	{
		initialize();
		return annotation;
	}

	private MainDescription mainDescription = MainDescription.EMPTY;

	/**
	 * (this field is optional)
	 */
	public MainDescription mainDescription()
	{
		initialize();
		return mainDescription;
	}

	private ListOfOnixDataCompositeWithKey<OtherText, JonixOtherText, OtherTextTypes> otherTexts = ListOfOnixDataCompositeWithKey
			.emptyKeyed();

	/**
	 * (this list may be empty)
	 */
	public ListOfOnixDataCompositeWithKey<OtherText, JonixOtherText, OtherTextTypes> otherTexts()
	{
		initialize();
		return otherTexts;
	}

	private ListOfOnixElement<ReviewQuote, String> reviewQuotes = ListOfOnixElement.empty();

	/**
	 * (this list may be empty)
	 */
	public ListOfOnixElement<ReviewQuote, String> reviewQuotes()
	{
		initialize();
		return reviewQuotes;
	}

	private CoverImageFormatCode coverImageFormatCode = CoverImageFormatCode.EMPTY;

	/**
	 * (this field is optional)
	 */
	public CoverImageFormatCode coverImageFormatCode()
	{
		initialize();
		return coverImageFormatCode;
	}

	private CoverImageLinkTypeCode coverImageLinkTypeCode = CoverImageLinkTypeCode.EMPTY;

	/**
	 * (this field is optional)
	 */
	public CoverImageLinkTypeCode coverImageLinkTypeCode()
	{
		initialize();
		return coverImageLinkTypeCode;
	}

	private CoverImageLink coverImageLink = CoverImageLink.EMPTY;

	/**
	 * (this field is optional)
	 */
	public CoverImageLink coverImageLink()
	{
		initialize();
		return coverImageLink;
	}

	private ListOfOnixDataCompositeWithKey<MediaFile, JonixMediaFile, ImageAudioVideoFileTypes> mediaFiles = ListOfOnixDataCompositeWithKey
			.emptyKeyed();

	/**
	 * (this list may be empty)
	 */
	public ListOfOnixDataCompositeWithKey<MediaFile, JonixMediaFile, ImageAudioVideoFileTypes> mediaFiles()
	{
		initialize();
		return mediaFiles;
	}

	private ListOfOnixDataComposite<ProductWebsite, JonixProductWebsite> productWebsites = ListOfOnixDataComposite
			.empty();

	/**
	 * (this list may be empty)
	 */
	public ListOfOnixDataComposite<ProductWebsite, JonixProductWebsite> productWebsites()
	{
		initialize();
		return productWebsites;
	}

	private PrizesDescription prizesDescription = PrizesDescription.EMPTY;

	/**
	 * (this field is optional)
	 */
	public PrizesDescription prizesDescription()
	{
		initialize();
		return prizesDescription;
	}

	private ListOfOnixDataComposite<Prize, JonixPrize> prizes = ListOfOnixDataComposite.empty();

	/**
	 * (this list may be empty)
	 */
	public ListOfOnixDataComposite<Prize, JonixPrize> prizes()
	{
		initialize();
		return prizes;
	}

	private List<ContentItem> contentItems = Collections.emptyList();

	/**
	 * (this list may be empty)
	 */
	public List<ContentItem> contentItems()
	{
		initialize();
		return contentItems;
	}

	private ImprintName imprintName = ImprintName.EMPTY;

	/**
	 * (this field is required)
	 */
	public ImprintName imprintName()
	{
		initialize();
		return imprintName;
	}

	private List<Imprint> imprints = Collections.emptyList();

	/**
	 * (this list may be empty)
	 */
	public List<Imprint> imprints()
	{
		initialize();
		return imprints;
	}

	private PublisherName publisherName = PublisherName.EMPTY;

	/**
	 * (this field is optional)
	 */
	public PublisherName publisherName()
	{
		initialize();
		return publisherName;
	}

	private List<Publisher> publishers = Collections.emptyList();

	/**
	 * (this list may be empty)
	 */
	public List<Publisher> publishers()
	{
		initialize();
		return publishers;
	}

	private ListOfOnixElement<CityOfPublication, String> cityOfPublications = ListOfOnixElement.empty();

	/**
	 * (this list may be empty)
	 */
	public ListOfOnixElement<CityOfPublication, String> cityOfPublications()
	{
		initialize();
		return cityOfPublications;
	}

	private CountryOfPublication countryOfPublication = CountryOfPublication.EMPTY;

	/**
	 * (this field is optional)
	 */
	public CountryOfPublication countryOfPublication()
	{
		initialize();
		return countryOfPublication;
	}

	private ListOfOnixElement<CopublisherName, String> copublisherNames = ListOfOnixElement.empty();

	/**
	 * (this list may be empty)
	 */
	public ListOfOnixElement<CopublisherName, String> copublisherNames()
	{
		initialize();
		return copublisherNames;
	}

	private ListOfOnixElement<SponsorName, String> sponsorNames = ListOfOnixElement.empty();

	/**
	 * (this list may be empty)
	 */
	public ListOfOnixElement<SponsorName, String> sponsorNames()
	{
		initialize();
		return sponsorNames;
	}

	private OriginalPublisher originalPublisher = OriginalPublisher.EMPTY;

	/**
	 * (this field is optional)
	 */
	public OriginalPublisher originalPublisher()
	{
		initialize();
		return originalPublisher;
	}

	private PublishingStatus publishingStatus = PublishingStatus.EMPTY;

	/**
	 * (this field is optional)
	 */
	public PublishingStatus publishingStatus()
	{
		initialize();
		return publishingStatus;
	}

	private PublishingStatusNote publishingStatusNote = PublishingStatusNote.EMPTY;

	/**
	 * (this field is optional)
	 */
	public PublishingStatusNote publishingStatusNote()
	{
		initialize();
		return publishingStatusNote;
	}

	private AnnouncementDate announcementDate = AnnouncementDate.EMPTY;

	/**
	 * (this field is optional)
	 */
	public AnnouncementDate announcementDate()
	{
		initialize();
		return announcementDate;
	}

	private TradeAnnouncementDate tradeAnnouncementDate = TradeAnnouncementDate.EMPTY;

	/**
	 * (this field is optional)
	 */
	public TradeAnnouncementDate tradeAnnouncementDate()
	{
		initialize();
		return tradeAnnouncementDate;
	}

	private PublicationDate publicationDate = PublicationDate.EMPTY;

	/**
	 * (this field is optional)
	 */
	public PublicationDate publicationDate()
	{
		initialize();
		return publicationDate;
	}

	private List<CopyrightStatement> copyrightStatements = Collections.emptyList();

	/**
	 * (this list may be empty)
	 */
	public List<CopyrightStatement> copyrightStatements()
	{
		initialize();
		return copyrightStatements;
	}

	private CopyrightYear copyrightYear = CopyrightYear.EMPTY;

	/**
	 * (this field is optional)
	 */
	public CopyrightYear copyrightYear()
	{
		initialize();
		return copyrightYear;
	}

	private YearFirstPublished yearFirstPublished = YearFirstPublished.EMPTY;

	/**
	 * (this field is optional)
	 */
	public YearFirstPublished yearFirstPublished()
	{
		initialize();
		return yearFirstPublished;
	}

	private List<SalesRights> salesRightss = Collections.emptyList();

	/**
	 * (this list may be empty)
	 */
	public List<SalesRights> salesRightss()
	{
		initialize();
		return salesRightss;
	}

	private List<NotForSale> notForSales = Collections.emptyList();

	/**
	 * (this list may be empty)
	 */
	public List<NotForSale> notForSales()
	{
		initialize();
		return notForSales;
	}

	private List<SalesRestriction> salesRestrictions = Collections.emptyList();

	/**
	 * (this list may be empty)
	 */
	public List<SalesRestriction> salesRestrictions()
	{
		initialize();
		return salesRestrictions;
	}

	private Height height = Height.EMPTY;

	/**
	 * (this field is required)
	 */
	public Height height()
	{
		initialize();
		return height;
	}

	private Width width = Width.EMPTY;

	/**
	 * (this field is optional)
	 */
	public Width width()
	{
		initialize();
		return width;
	}

	private Thickness thickness = Thickness.EMPTY;

	/**
	 * (this field is optional)
	 */
	public Thickness thickness()
	{
		initialize();
		return thickness;
	}

	private Weight weight = Weight.EMPTY;

	/**
	 * (this field is optional)
	 */
	public Weight weight()
	{
		initialize();
		return weight;
	}

	private ListOfOnixDataCompositeWithKey<Measure, JonixMeasure, MeasureTypes> measures = ListOfOnixDataCompositeWithKey
			.emptyKeyed();

	/**
	 * (this list may be empty)
	 */
	public ListOfOnixDataCompositeWithKey<Measure, JonixMeasure, MeasureTypes> measures()
	{
		initialize();
		return measures;
	}

	private Dimensions dimensions = Dimensions.EMPTY;

	/**
	 * (this field is optional)
	 */
	public Dimensions dimensions()
	{
		initialize();
		return dimensions;
	}

	private ReplacedByISBN replacedByISBN = ReplacedByISBN.EMPTY;

	/**
	 * (this field is optional)
	 */
	public ReplacedByISBN replacedByISBN()
	{
		initialize();
		return replacedByISBN;
	}

	private ReplacedByEAN13 replacedByEAN13 = ReplacedByEAN13.EMPTY;

	/**
	 * (this field is optional)
	 */
	public ReplacedByEAN13 replacedByEAN13()
	{
		initialize();
		return replacedByEAN13;
	}

	private AlternativeFormatISBN alternativeFormatISBN = AlternativeFormatISBN.EMPTY;

	/**
	 * (this field is optional)
	 */
	public AlternativeFormatISBN alternativeFormatISBN()
	{
		initialize();
		return alternativeFormatISBN;
	}

	private AlternativeFormatEAN13 alternativeFormatEAN13 = AlternativeFormatEAN13.EMPTY;

	/**
	 * (this field is optional)
	 */
	public AlternativeFormatEAN13 alternativeFormatEAN13()
	{
		initialize();
		return alternativeFormatEAN13;
	}

	private AlternativeProductISBN alternativeProductISBN = AlternativeProductISBN.EMPTY;

	/**
	 * (this field is optional)
	 */
	public AlternativeProductISBN alternativeProductISBN()
	{
		initialize();
		return alternativeProductISBN;
	}

	private AlternativeProductEAN13 alternativeProductEAN13 = AlternativeProductEAN13.EMPTY;

	/**
	 * (this field is optional)
	 */
	public AlternativeProductEAN13 alternativeProductEAN13()
	{
		initialize();
		return alternativeProductEAN13;
	}

	private List<RelatedProduct> relatedProducts = Collections.emptyList();

	/**
	 * (this list may be empty)
	 */
	public List<RelatedProduct> relatedProducts()
	{
		initialize();
		return relatedProducts;
	}

	private OutOfPrintDate outOfPrintDate = OutOfPrintDate.EMPTY;

	/**
	 * (this field is optional)
	 */
	public OutOfPrintDate outOfPrintDate()
	{
		initialize();
		return outOfPrintDate;
	}

	private List<SupplyDetail> supplyDetails = Collections.emptyList();

	/**
	 * (this list may be empty)
	 */
	public List<SupplyDetail> supplyDetails()
	{
		initialize();
		return supplyDetails;
	}

	private List<MarketRepresentation> marketRepresentations = Collections.emptyList();

	/**
	 * (this list may be empty)
	 */
	public List<MarketRepresentation> marketRepresentations()
	{
		initialize();
		return marketRepresentations;
	}

	private PromotionCampaign promotionCampaign = PromotionCampaign.EMPTY;

	/**
	 * (this field is optional)
	 */
	public PromotionCampaign promotionCampaign()
	{
		initialize();
		return promotionCampaign;
	}

	private PromotionContact promotionContact = PromotionContact.EMPTY;

	/**
	 * (this field is optional)
	 */
	public PromotionContact promotionContact()
	{
		initialize();
		return promotionContact;
	}

	private InitialPrintRun initialPrintRun = InitialPrintRun.EMPTY;

	/**
	 * (this field is optional)
	 */
	public InitialPrintRun initialPrintRun()
	{
		initialize();
		return initialPrintRun;
	}

	private ListOfOnixElement<ReprintDetail, String> reprintDetails = ListOfOnixElement.empty();

	/**
	 * (this list may be empty)
	 */
	public ListOfOnixElement<ReprintDetail, String> reprintDetails()
	{
		initialize();
		return reprintDetails;
	}

	private CopiesSold copiesSold = CopiesSold.EMPTY;

	/**
	 * (this field is optional)
	 */
	public CopiesSold copiesSold()
	{
		initialize();
		return copiesSold;
	}

	private BookClubAdoption bookClubAdoption = BookClubAdoption.EMPTY;

	/**
	 * (this field is optional)
	 */
	public BookClubAdoption bookClubAdoption()
	{
		initialize();
		return bookClubAdoption;
	}
}
