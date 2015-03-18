package com.tectonica.jonix.mappers.v21.references;

import org.editeur.onix.v21.references.Audience;
import org.editeur.onix.v21.references.AvailabilityCode;
import org.editeur.onix.v21.references.BASICMainSubject;
import org.editeur.onix.v21.references.BiographicalNote;
import org.editeur.onix.v21.references.CityOfPublication;
import org.editeur.onix.v21.references.Contributor;
import org.editeur.onix.v21.references.ContributorRole;
import org.editeur.onix.v21.references.CountryOfPublication;
import org.editeur.onix.v21.references.CurrencyCode;
import org.editeur.onix.v21.references.EditionNumber;
import org.editeur.onix.v21.references.EditionTypeCode;
import org.editeur.onix.v21.references.EpubType;
import org.editeur.onix.v21.references.Imprint;
import org.editeur.onix.v21.references.ImprintName;
import org.editeur.onix.v21.references.Language;
import org.editeur.onix.v21.references.List17;
import org.editeur.onix.v21.references.List21;
import org.editeur.onix.v21.references.List54;
import org.editeur.onix.v21.references.List91;
import org.editeur.onix.v21.references.List96;
import org.editeur.onix.v21.references.MainSubject;
import org.editeur.onix.v21.references.MainSubjectSchemeIdentifier;
import org.editeur.onix.v21.references.NotificationType;
import org.editeur.onix.v21.references.NumberOfPages;
import org.editeur.onix.v21.references.OtherText;
import org.editeur.onix.v21.references.PersonName;
import org.editeur.onix.v21.references.Price;
import org.editeur.onix.v21.references.PriceAmount;
import org.editeur.onix.v21.references.PriceTypeCode;
import org.editeur.onix.v21.references.Product;
import org.editeur.onix.v21.references.ProductForm;
import org.editeur.onix.v21.references.ProductIdentifier;
import org.editeur.onix.v21.references.PublicationDate;
import org.editeur.onix.v21.references.Publisher;
import org.editeur.onix.v21.references.PublisherName;
import org.editeur.onix.v21.references.PublishingRole;
import org.editeur.onix.v21.references.RecordReference;
import org.editeur.onix.v21.references.RightsCountry;
import org.editeur.onix.v21.references.RightsRegion;
import org.editeur.onix.v21.references.RightsTerritory;
import org.editeur.onix.v21.references.SalesRights;
import org.editeur.onix.v21.references.SalesRightsType;
import org.editeur.onix.v21.references.Series;
import org.editeur.onix.v21.references.SeriesISSN;
import org.editeur.onix.v21.references.SeriesIdentifier;
import org.editeur.onix.v21.references.Subject;
import org.editeur.onix.v21.references.SubjectCode;
import org.editeur.onix.v21.references.SubjectHeadingText;
import org.editeur.onix.v21.references.SubjectSchemeIdentifier;
import org.editeur.onix.v21.references.Subtitle;
import org.editeur.onix.v21.references.SupplierName;
import org.editeur.onix.v21.references.SupplierRole;
import org.editeur.onix.v21.references.SupplyDetail;
import org.editeur.onix.v21.references.Title;
import org.editeur.onix.v21.references.TitleOfSeries;
import org.editeur.onix.v21.references.TitleText;
import org.editeur.onix.v21.references.TitleType;
import org.editeur.onix.v21.references.TitleWithoutPrefix;
import com.tectonica.jonix.JonixProduct;
import com.tectonica.jonix.JonixUtils;
import com.tectonica.jonix.JonixUtils.OnixObjectHandler;
import com.tectonica.jonix.codelists.Availabilities;
import com.tectonica.jonix.codelists.ContributorRoles;
import com.tectonica.jonix.codelists.EditionTypes;
import com.tectonica.jonix.codelists.EpubTypes;
import com.tectonica.jonix.codelists.NotificationTypes;
import com.tectonica.jonix.codelists.PriceTypes;
import com.tectonica.jonix.codelists.ProductForms;
import com.tectonica.jonix.codelists.PublishingRoles;
import com.tectonica.jonix.codelists.SalesRightsTypes;
import com.tectonica.jonix.codelists.SubjectSchemeIdentifiers;
import com.tectonica.jonix.codelists.SupplierRoles;
import com.tectonica.jonix.codelists.TitleTypes;
import com.tectonica.jonix.composites.Contributors;
import com.tectonica.jonix.composites.Titles;
import com.tectonica.jonix.mappers.IProductMapper;

public class ProductMapper implements IProductMapper
{
	private ProductHandler handler = new ProductHandler();
	private JonixProduct product;

	public JonixProduct execute(Object o)
	{
		product = new JonixProduct();
		JonixUtils.forEach(o, null, true, 0, handler);
		return product;
	}

	private class ProductHandler implements OnixObjectHandler
	{
		@Override
		public boolean handleOnixObject(Object o, Object parent, Object grandParent, int depth)
		{
			if (parent instanceof Product && grandParent == null)
			{
				// deal with tags directly below <Product>, either composites or elements
				if (!consumeOnixComposite(o))
					consumeOnixElement(o);
			}
			else
			{
				// deal with members of composites, i.e. all tags indirectly below <Product>
				if (parent instanceof Title)
					consumeTitleMember(o, grandParent);
				else if (parent instanceof Contributor)
					consumeContributorMember(o, grandParent);
				else if (parent instanceof Series && grandParent instanceof Product)
					consumeSeriesMember(o);
				else if (parent instanceof MainSubject && grandParent instanceof Product)
					consumeMainSubjectMember(o);
				else if (parent instanceof Subject && grandParent instanceof Product)
					consumeSubjectMember(o);
				else if (parent instanceof Publisher && grandParent instanceof Product)
					consumePublisherMember(o);
				else if (parent instanceof SupplyDetail && grandParent instanceof Product)
					consumeSupplyDetailMember(o);
				else if (parent instanceof Price && grandParent instanceof SupplyDetail)
					consumePriceMember(o);
				else if (parent instanceof SalesRights && grandParent instanceof Product)
					consumeSalesRightsMember(o);
				else if (parent instanceof Imprint && grandParent instanceof Product)
					consumeImprintMember(o);
			}

			return true;
		}

		private boolean consumeOnixComposite(Object o)
		{
			if (o instanceof ProductIdentifier)
				createProductIdentifier(product, (ProductIdentifier) o);
			else if (o instanceof Title)
				product.titles.startNewItem();
			else if (o instanceof Contributor)
				product.contributors.startNewItem();
			else if (o instanceof Series)
				product.serieses.startNewItem();
			else if (o instanceof Language)
				createLanguage(product, (Language) o);
			else if (o instanceof MainSubject)
				product.mainSubjects.startNewItem();
			else if (o instanceof Subject)
				product.subjects.startNewItem();
			if (o instanceof Audience)
				createAudience(product, (Audience) o);
			else if (o instanceof OtherText)
				createOtherText(product, (OtherText) o);
			else if (o instanceof Publisher)
				product.publishers.startNewItem();
			else if (o instanceof SupplyDetail)
				product.supplyDetails.startNewItem();
			else if (o instanceof SalesRights)
				product.salesRightss.startNewItem();
			else
				return false;
			return true;
		}

		private void consumeOnixElement(Object o)
		{
			if (o instanceof RecordReference)
				product.recordReference = ((RecordReference) o).getValue();
			else if (o instanceof NotificationType)
				product.notificationType = NotificationTypes.fromCode(((NotificationType) o).getValue());
			else if (o instanceof ProductForm)
				product.productForm = ProductForms.fromCode(((ProductForm) o).getValue());
			else if (o instanceof EpubType)
				product.epubType = EpubTypes.fromCode(((EpubType) o).getValue());
			else if (o instanceof EditionTypeCode)
			{
				List21 enumObj = ((EditionTypeCode) o).getValue();
				if (enumObj != null)
					product.editionType = EditionTypes.fromCode(enumObj.name());
			}
			else if (o instanceof EditionNumber)
				product.editionNumber = ((EditionNumber) o).getValue();
			else if (o instanceof CountryOfPublication)
			{
				List91 enumObj = ((CountryOfPublication) o).getValue();
				if (enumObj != null)
					product.countryOfPublication = enumObj.name();
			}
			else if (o instanceof CityOfPublication)
				product.cityOfPublication = ((CityOfPublication) o).getValue();
			else if (o instanceof PublicationDate)
				product.publicationDate = ((PublicationDate) o).getValue();
			else if (o instanceof NumberOfPages)
				product.numberOfPages = ((NumberOfPages) o).getValue();
			else if (o instanceof BASICMainSubject)
				product.basicMainSubject = ((BASICMainSubject) o).getValue();
		}

		private void consumeTitleMember(Object o, Object grandParent)
		{
			// Note: <Title> could be under <Product>, <Series>, <Set> and <ContentItem>
			Titles titles = null;
			if (grandParent instanceof Product)
				titles = product.titles;
			else if (grandParent instanceof Series)
				titles = product.serieses.item().titles;
			if (titles != null)
			{
				if (o instanceof TitleType)
					titles.item().titleType = TitleTypes.fromCode(((TitleType) o).getValue());
				else if (o instanceof TitleText)
					titles.item().titleText = ((TitleText) o).getValue();
				else if (o instanceof TitleWithoutPrefix)
					titles.item().titleWithoutPrefix = ((TitleWithoutPrefix) o).getValue();
				else if (o instanceof Subtitle)
					titles.item().subtitle = ((Subtitle) o).getValue();
			}
		}

		private void consumeContributorMember(Object o, Object grandParent)
		{
			// Note: <Contributor> could be under <Product>, <Series>, <Set> and <ContentItem>
			Contributors contributors = null;
			if (grandParent instanceof Product)
				contributors = product.contributors;
			else if (grandParent instanceof Series)
				contributors = product.serieses.item().contributors;
			if (contributors != null)
			{
				if (o instanceof ContributorRole)
				{
					List17 enumObj = ((ContributorRole) o).getValue();
					if (enumObj != null)
						contributors.item().contributorRole = ContributorRoles.fromCode(enumObj.value());
				}
				else if (o instanceof PersonName)
					contributors.item().personName = ((PersonName) o).getValue();
				else if (o instanceof BiographicalNote)
					contributors.item().biographicalNote = JonixUtils.contentToString(o);
			}
		}

		private void consumeSeriesMember(Object o)
		{
			if (o instanceof TitleOfSeries)
				product.serieses.item().titleOfSeries = ((TitleOfSeries) o).getValue();
			else if (o instanceof SeriesISSN)
				product.serieses.item().seriesISSN = ((SeriesISSN) o).getValue();
			else if (o instanceof SeriesIdentifier)
				createSeriesIdentifier(product, (SeriesIdentifier) o);
			else if (o instanceof Title)
				product.serieses.item().titles.startNewItem();
			else if (o instanceof Contributor)
				product.serieses.item().contributors.startNewItem();
		}

		private void consumeMainSubjectMember(Object o)
		{
			if (o instanceof MainSubjectSchemeIdentifier)
				product.mainSubjects.item().subjectSchemeIdentifier = SubjectSchemeIdentifiers.fromCode(((MainSubjectSchemeIdentifier) o).getValue());
			else if (o instanceof SubjectCode)
				product.mainSubjects.item().subjectCode = ((SubjectCode) o).getValue();
			else if (o instanceof SubjectHeadingText)
				product.mainSubjects.item().subjectHeadingText = ((SubjectHeadingText) o).getValue();
		}

		private void consumeSubjectMember(Object o)
		{
			if (o instanceof SubjectSchemeIdentifier)
				product.subjects.item().subjectSchemeIdentifier = SubjectSchemeIdentifiers.fromCode(((SubjectSchemeIdentifier) o).getValue());
			else if (o instanceof SubjectCode)
				product.subjects.item().subjectCode = ((SubjectCode) o).getValue();
			else if (o instanceof SubjectHeadingText)
				product.subjects.item().subjectHeadingText = ((SubjectHeadingText) o).getValue();
		}

		private void consumePublisherMember(Object o)
		{
			if (o instanceof PublishingRole)
				product.publishers.item().publishingRole = PublishingRoles.fromCode(((PublishingRole) o).getValue());
			else if (o instanceof PublisherName)
				product.publishers.item().publisherName = ((PublisherName) o).getValue();
		}

		private void consumeSupplyDetailMember(Object o)
		{
			if (o instanceof SupplierRole)
				product.supplyDetails.item().supplierRole = SupplierRoles.fromCode(((SupplierRole) o).getValue());
			else if (o instanceof SupplierName)
				product.supplyDetails.item().supplierName = ((SupplierName) o).getValue();
			else if (o instanceof AvailabilityCode)
			{
				List54 enumObj = ((AvailabilityCode) o).getValue();
				if (enumObj != null)
					product.supplyDetails.item().availability = Availabilities.fromCode(enumObj.name());
			}
			else if (o instanceof Price)
				product.supplyDetails.item().prices.startNewItem();
		}

		private void consumePriceMember(Object o)
		{
			if (o instanceof PriceTypeCode)
				product.supplyDetails.item().prices.item().priceType = PriceTypes.fromCode(((PriceTypeCode) o).getValue());
			else if (o instanceof PriceAmount)
				product.supplyDetails.item().prices.item().priceAmount = ((PriceAmount) o).getValue();
			else if (o instanceof CurrencyCode)
			{
				List96 enumObj = ((CurrencyCode) o).getValue();
				if (enumObj != null)
					product.supplyDetails.item().prices.item().currencyCode = enumObj.value();
			}
		}

		private void consumeSalesRightsMember(Object o)
		{
			if (o instanceof SalesRightsType)
				product.salesRightss.item().salesRightsType = SalesRightsTypes.fromCode(((SalesRightsType) o).getValue());
			else if (o instanceof RightsTerritory)
				product.salesRightss.item().rightsTerritories = JonixUtils.enumListToStringArray(((RightsTerritory) o).getValue(), true);
			else if (o instanceof RightsCountry)
				product.salesRightss.item().rightsCountries = JonixUtils.enumListToStringArray(((RightsCountry) o).getValue(), false);
			else if (o instanceof RightsRegion)
				product.salesRightss.item().rightsRegion = ((RightsRegion) o).getValue();
		}

		private void consumeImprintMember(Object o)
		{
			if (o instanceof ImprintName)
				product.imprintName = ((ImprintName) o).getValue();
		}

		private void createProductIdentifier(final JonixProduct product, ProductIdentifier oo)
		{
			String productIDTypeCode = (oo.getProductIDType() == null) ? null : oo.getProductIDType().getValue();
			String idTypeName = (oo.getIDTypeName() == null) ? null : oo.getIDTypeName().getValue();
			String idValue = (oo.getIDValue() == null) ? null : oo.getIDValue().getValue();
			product.productIdentifiers.setNewItem(productIDTypeCode, idTypeName, idValue);
		}

		private void createSeriesIdentifier(final JonixProduct product, SeriesIdentifier oo)
		{
			String seriesIDTypeCode = (oo.getSeriesIDType() == null) ? null : oo.getSeriesIDType().getValue();
			String idTypeName = (oo.getIDTypeName() == null) ? null : oo.getIDTypeName().getValue();
			String idValue = (oo.getIDValue() == null) ? null : oo.getIDValue().getValue();
			product.serieses.item().seriesIdentifiers.setNewItem(seriesIDTypeCode, idTypeName, idValue);
		}

		private void createLanguage(final JonixProduct product, Language oo)
		{
			String languageRoleCode = (oo.getLanguageRole() == null) ? null : oo.getLanguageRole().getValue();
			String languageCode = (oo.getLanguageCode() == null || oo.getLanguageCode().getValue() == null) ? null : oo.getLanguageCode().getValue().value();
			product.languages.setNewItem(languageRoleCode, languageCode);
		}

		private void createAudience(final JonixProduct product, Audience oo)
		{
			String audienceCodeTypeCode = (oo.getAudienceCodeType() == null) ? null : oo.getAudienceCodeType().getValue();
			String audienceCodeTypeName = (oo.getAudienceCodeTypeName() == null) ? null : oo.getAudienceCodeTypeName().getValue();
			String audienceCodeValue = (oo.getAudienceCodeValue() == null) ? null : oo.getAudienceCodeValue().getValue();
			product.audiences.setNewItem(audienceCodeTypeCode, audienceCodeTypeName, audienceCodeValue);
		}

		private void createOtherText(final JonixProduct product, OtherText oo)
		{
			String textTypeCode = (oo.getTextTypeCode() == null) ? null : oo.getTextTypeCode().getValue();
			String textFormatCode = (oo.getTextFormat() == null) ? null : oo.getTextFormat().getValue();
			String text = null;
			if (oo.getText() != null)
			{
				if (textFormatCode == null)
					textFormatCode = oo.getText().getTextformat();
				text = JonixUtils.contentToString(oo.getText());
			}
			product.otherTexts.setNewItem(textTypeCode, textFormatCode, text);
		}
	};
}
