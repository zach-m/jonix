package com.tectonica.jonix.mappers.v21.shorts;

import org.editeur.onix.v21.shorts.A001;
import org.editeur.onix.v21.shorts.A002;
import org.editeur.onix.v21.shorts.Audience;
import org.editeur.onix.v21.shorts.B003;
import org.editeur.onix.v21.shorts.B012;
import org.editeur.onix.v21.shorts.B016;
import org.editeur.onix.v21.shorts.B018;
import org.editeur.onix.v21.shorts.B029;
import org.editeur.onix.v21.shorts.B031;
import org.editeur.onix.v21.shorts.B035;
import org.editeur.onix.v21.shorts.B036;
import org.editeur.onix.v21.shorts.B044;
import org.editeur.onix.v21.shorts.B056;
import org.editeur.onix.v21.shorts.B057;
import org.editeur.onix.v21.shorts.B061;
import org.editeur.onix.v21.shorts.B064;
import org.editeur.onix.v21.shorts.B067;
import org.editeur.onix.v21.shorts.B069;
import org.editeur.onix.v21.shorts.B070;
import org.editeur.onix.v21.shorts.B079;
import org.editeur.onix.v21.shorts.B081;
import org.editeur.onix.v21.shorts.B083;
import org.editeur.onix.v21.shorts.B089;
import org.editeur.onix.v21.shorts.B090;
import org.editeur.onix.v21.shorts.B091;
import org.editeur.onix.v21.shorts.B191;
import org.editeur.onix.v21.shorts.B202;
import org.editeur.onix.v21.shorts.B203;
import org.editeur.onix.v21.shorts.B209;
import org.editeur.onix.v21.shorts.B211;
import org.editeur.onix.v21.shorts.B291;
import org.editeur.onix.v21.shorts.B388;
import org.editeur.onix.v21.shorts.Contributor;
import org.editeur.onix.v21.shorts.Imprint;
import org.editeur.onix.v21.shorts.J137;
import org.editeur.onix.v21.shorts.J141;
import org.editeur.onix.v21.shorts.J148;
import org.editeur.onix.v21.shorts.J151;
import org.editeur.onix.v21.shorts.J152;
import org.editeur.onix.v21.shorts.J292;
import org.editeur.onix.v21.shorts.Language;
import org.editeur.onix.v21.shorts.List17;
import org.editeur.onix.v21.shorts.List21;
import org.editeur.onix.v21.shorts.List54;
import org.editeur.onix.v21.shorts.List91;
import org.editeur.onix.v21.shorts.List96;
import org.editeur.onix.v21.shorts.Mainsubject;
import org.editeur.onix.v21.shorts.Othertext;
import org.editeur.onix.v21.shorts.Price;
import org.editeur.onix.v21.shorts.Product;
import org.editeur.onix.v21.shorts.Productidentifier;
import org.editeur.onix.v21.shorts.Publisher;
import org.editeur.onix.v21.shorts.Salesrights;
import org.editeur.onix.v21.shorts.Series;
import org.editeur.onix.v21.shorts.Seriesidentifier;
import org.editeur.onix.v21.shorts.Subject;
import org.editeur.onix.v21.shorts.Supplydetail;
import org.editeur.onix.v21.shorts.Title;
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
				else if (parent instanceof Mainsubject && grandParent instanceof Product)
					consumeMainSubjectMember(o);
				else if (parent instanceof Subject && grandParent instanceof Product)
					consumeSubjectMember(o);
				else if (parent instanceof Publisher && grandParent instanceof Product)
					consumePublisherMember(o);
				else if (parent instanceof Supplydetail && grandParent instanceof Product)
					consumeSupplyDetailMember(o);
				else if (parent instanceof Price && grandParent instanceof Supplydetail)
					consumePriceMember(o);
				else if (parent instanceof Salesrights && grandParent instanceof Product)
					consumeSalesRightsMember(o);
				else if (parent instanceof Imprint && grandParent instanceof Product)
					consumeImprintMember(o);
			}

			return true;
		}

		private boolean consumeOnixComposite(Object o)
		{
			if (o instanceof Productidentifier)
				createProductIdentifier(product, (Productidentifier) o);
			else if (o instanceof Title)
				product.titles.startNewItem();
			else if (o instanceof Contributor)
				product.contributors.startNewItem();
			else if (o instanceof Series)
				product.serieses.startNewItem();
			else if (o instanceof Language)
				createLanguage(product, (Language) o);
			else if (o instanceof Mainsubject)
				product.mainSubjects.startNewItem();
			else if (o instanceof Subject)
				product.subjects.startNewItem();
			if (o instanceof Audience)
				createAudience(product, (Audience) o);
			else if (o instanceof Othertext)
				createOtherText(product, (Othertext) o);
			else if (o instanceof Publisher)
				product.publishers.startNewItem();
			else if (o instanceof Supplydetail)
				product.supplyDetails.startNewItem();
			else if (o instanceof Salesrights)
				product.salesRightss.startNewItem();
			else
				return false;
			return true;
		}

		private void consumeOnixElement(Object o)
		{
			if (o instanceof A001)
				product.recordReference = ((A001) o).getValue();
			else if (o instanceof A002)
				product.notificationType = NotificationTypes.fromCode(((A002) o).getValue());
			else if (o instanceof B012)
				product.productForm = ProductForms.fromCode(((B012) o).getValue());
			else if (o instanceof B211)
				product.epubType = EpubTypes.fromCode(((B211) o).getValue());
			else if (o instanceof B056)
			{
				List21 enumObj = ((B056) o).getValue();
				if (enumObj != null)
					product.editionType = EditionTypes.fromCode(enumObj.name());
			}
			else if (o instanceof B057)
				product.editionNumber = ((B057) o).getValue();
			else if (o instanceof B083)
			{
				List91 enumObj = ((B083) o).getValue();
				if (enumObj != null)
					product.countryOfPublication = enumObj.name();
			}
			else if (o instanceof B209)
				product.cityOfPublication = ((B209) o).getValue();
			else if (o instanceof B003)
				product.publicationDate = ((B003) o).getValue();
			else if (o instanceof B061)
				product.numberOfPages = ((B061) o).getValue();
			else if (o instanceof B064)
				product.basicMainSubject = ((B064) o).getValue();
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
				if (o instanceof B202)
					titles.item().titleType = TitleTypes.fromCode(((B202) o).getValue());
				else if (o instanceof B203)
					titles.item().titleText = ((B203) o).getValue();
				else if (o instanceof B031)
					titles.item().titleWithoutPrefix = ((B031) o).getValue();
				else if (o instanceof B029)
					titles.item().subtitle = ((B029) o).getValue();
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
				if (o instanceof B035)
				{
					List17 enumObj = ((B035) o).getValue();
					if (enumObj != null)
						contributors.item().contributorRole = ContributorRoles.fromCode(enumObj.value());
				}
				else if (o instanceof B036)
					contributors.item().personName = ((B036) o).getValue();
				else if (o instanceof B044)
					contributors.item().biographicalNote = JonixUtils.contentToString(o);
			}
		}

		private void consumeSeriesMember(Object o)
		{
			if (o instanceof B018)
				product.serieses.item().titleOfSeries = ((B018) o).getValue();
			else if (o instanceof B016)
				product.serieses.item().seriesISSN = ((B016) o).getValue();
			else if (o instanceof Seriesidentifier)
				createSeriesIdentifier(product, (Seriesidentifier) o);
			else if (o instanceof Title)
				product.serieses.item().titles.startNewItem();
			else if (o instanceof Contributor)
				product.serieses.item().contributors.startNewItem();
		}

		private void consumeMainSubjectMember(Object o)
		{
			if (o instanceof B191)
				product.mainSubjects.item().subjectSchemeIdentifier = SubjectSchemeIdentifiers.fromCode(((B191) o).getValue());
			else if (o instanceof B069)
				product.mainSubjects.item().subjectCode = ((B069) o).getValue();
			else if (o instanceof B070)
				product.mainSubjects.item().subjectHeadingText = ((B070) o).getValue();
		}

		private void consumeSubjectMember(Object o)
		{
			if (o instanceof B067)
				product.subjects.item().subjectSchemeIdentifier = SubjectSchemeIdentifiers.fromCode(((B067) o).getValue());
			else if (o instanceof B069)
				product.subjects.item().subjectCode = ((B069) o).getValue();
			else if (o instanceof B070)
				product.subjects.item().subjectHeadingText = ((B070) o).getValue();
		}

		private void consumePublisherMember(Object o)
		{
			if (o instanceof B291)
				product.publishers.item().publishingRole = PublishingRoles.fromCode(((B291) o).getValue());
			else if (o instanceof B081)
				product.publishers.item().publisherName = ((B081) o).getValue();
		}

		private void consumeSupplyDetailMember(Object o)
		{
			if (o instanceof J292)
				product.supplyDetails.item().supplierRole = SupplierRoles.fromCode(((J292) o).getValue());
			else if (o instanceof J137)
				product.supplyDetails.item().supplierName = ((J137) o).getValue();
			else if (o instanceof J141)
			{
				List54 enumObj = ((J141) o).getValue();
				if (enumObj != null)
					product.supplyDetails.item().availability = Availabilities.fromCode(enumObj.name());
			}
			else if (o instanceof Price)
				product.supplyDetails.item().prices.startNewItem();
		}

		private void consumePriceMember(Object o)
		{
			if (o instanceof J148)
				product.supplyDetails.item().prices.item().priceType = PriceTypes.fromCode(((J148) o).getValue());
			else if (o instanceof J151)
				product.supplyDetails.item().prices.item().priceAmount = ((J151) o).getValue();
			else if (o instanceof J152)
			{
				List96 enumObj = ((J152) o).getValue();
				if (enumObj != null)
					product.supplyDetails.item().prices.item().currencyCode = enumObj.value();
			}
		}

		private void consumeSalesRightsMember(Object o)
		{
			if (o instanceof B089)
				product.salesRightss.item().salesRightsType = SalesRightsTypes.fromCode(((B089) o).getValue());
			else if (o instanceof B388)
				product.salesRightss.item().rightsTerritories = JonixUtils.enumListToStringArray(((B388) o).getValue(), true);
			else if (o instanceof B090)
				product.salesRightss.item().rightsCountries = JonixUtils.enumListToStringArray(((B090) o).getValue(), false);
			else if (o instanceof B091)
				product.salesRightss.item().rightsRegion = ((B091) o).getValue();
		}

		private void consumeImprintMember(Object o)
		{
			if (o instanceof B079)
				product.imprintName = ((B079) o).getValue();
		}

		private void createProductIdentifier(final JonixProduct product, Productidentifier oo)
		{
			String productIDTypeCode = (oo.getB221() == null) ? null : oo.getB221().getValue();
			String idTypeName = (oo.getB233() == null) ? null : oo.getB233().getValue();
			String idValue = (oo.getB244() == null) ? null : oo.getB244().getValue();
			product.productIdentifiers.setNewItem(productIDTypeCode, idTypeName, idValue);
		}

		private void createSeriesIdentifier(final JonixProduct product, Seriesidentifier oo)
		{
			String seriesIDTypeCode = (oo.getB273() == null) ? null : oo.getB273().getValue();
			String idTypeName = (oo.getB233() == null) ? null : oo.getB233().getValue();
			String idValue = (oo.getB244() == null) ? null : oo.getB244().getValue();
			product.serieses.item().seriesIdentifiers.setNewItem(seriesIDTypeCode, idTypeName, idValue);
		}

		private void createLanguage(final JonixProduct product, Language oo)
		{
			String languageRoleCode = (oo.getB253() == null) ? null : oo.getB253().getValue();
			String languageCode = (oo.getB252() == null || oo.getB252().getValue() == null) ? null : oo.getB252().getValue().value();
			product.languages.setNewItem(languageRoleCode, languageCode);
		}

		private void createAudience(final JonixProduct product, Audience oo)
		{
			String audienceCodeTypeCode = (oo.getB204() == null) ? null : oo.getB204().getValue();
			String audienceCodeTypeName = (oo.getB205() == null) ? null : oo.getB205().getValue();
			String audienceCodeValue = (oo.getB206() == null) ? null : oo.getB206().getValue();
			product.audiences.setNewItem(audienceCodeTypeCode, audienceCodeTypeName, audienceCodeValue);
		}

		private void createOtherText(final JonixProduct product, Othertext oo)
		{
			String textTypeCode = (oo.getD102() == null) ? null : oo.getD102().getValue();
			String textFormatCode = (oo.getD103() == null) ? null : oo.getD103().getValue();
			String text = null;
			if (oo.getD104() != null)
			{
				if (textFormatCode == null)
					textFormatCode = oo.getD104().getTextformat();
				text = JonixUtils.contentToString(oo.getD104());
			}
			product.otherTexts.setNewItem(textTypeCode, textFormatCode, text);
		}
	};
}
