package com.tectonica.jonix.basic;

import java.util.ArrayList;
import java.util.List;

import com.tectonica.jonix.JonixColumn;
import com.tectonica.jonix.JonixConsumer;
import com.tectonica.jonix.JonixElement;
import com.tectonica.jonix.JonixTagColumnable;
import com.tectonica.jonix.JonixTag;
import com.tectonica.jonix.codelist.ContributorRoles;
import com.tectonica.jonix.codelist.EditionTypes;
import com.tectonica.jonix.codelist.EpubTypes;
import com.tectonica.jonix.codelist.LanguageRoles;
import com.tectonica.jonix.codelist.NotificationTypes;
import com.tectonica.jonix.codelist.PriceTypes;
import com.tectonica.jonix.codelist.ProductForms;
import com.tectonica.jonix.codelist.ProductIdTypes;
import com.tectonica.jonix.codelist.SalesRightsTypes;
import com.tectonica.jonix.codelist.SubjectSchemeIds;
import com.tectonica.jonix.codelist.TextTypes;
import com.tectonica.jonix.codelist.TitleTypes;
import com.tectonica.jonix.composite.Audiences;
import com.tectonica.jonix.composite.Contributors;
import com.tectonica.jonix.composite.Contributors.Contributor;
import com.tectonica.jonix.composite.Imprints;
import com.tectonica.jonix.composite.Languages;
import com.tectonica.jonix.composite.Languages.Language;
import com.tectonica.jonix.composite.MainSubjects;
import com.tectonica.jonix.composite.OtherTexts;
import com.tectonica.jonix.composite.OtherTexts.OtherText;
import com.tectonica.jonix.composite.Prices.Price;
import com.tectonica.jonix.composite.ProductIdentifiers;
import com.tectonica.jonix.composite.ProductIdentifiers.ProductIdentifier;
import com.tectonica.jonix.composite.Publishers;
import com.tectonica.jonix.composite.SalesRightss;
import com.tectonica.jonix.composite.SalesRightss.SalesRights;
import com.tectonica.jonix.composite.Serieses;
import com.tectonica.jonix.composite.Subjects;
import com.tectonica.jonix.composite.Subjects.Subject;
import com.tectonica.jonix.composite.SupplyDetails;
import com.tectonica.jonix.composite.SupplyDetails.SupplyDetail;
import com.tectonica.jonix.composite.Titles;
import com.tectonica.jonix.composite.Titles.Title;
import com.tectonica.jonix.element.CountryOfPublicationElement;
import com.tectonica.jonix.element.EditionTypeElement;
import com.tectonica.jonix.element.EpubTypeElement;
import com.tectonica.jonix.element.GenericStringElement;
import com.tectonica.jonix.element.NotificationTypeElement;
import com.tectonica.jonix.element.ProductFormElement;
import com.tectonica.jonix.resolve.JonixResolver;
import com.tectonica.jonix.resolve.ONIX;

/**
 * Container for an ONIX's <code>PRODUCT</code> tag, consisting of only the fields considered basic by Jonix. This object extends
 * {@link JonixTag}, which means it's being populated with by {@link JonixTag#process(Object)}, which goes over all of its registered
 * {@link JonixConsumer}s, and let them populate themselves by consuming the ONIX tag that they represent. The members of this class are
 * divided into two groups, following ONIX terminology -
 * <b>Elements</b> and <b>Composites</b>:
 * <ul>
 * <li>Elements are single-value tags, typically located directly under <code>PRODUCT</code>, and they are typically represented by a String
 * or an Enum. Examples include: Number-Of-Pages, Publication-Date, etc.
 * <li>Composites are basically <code>List</code>s of objects, some of which may themselves be lists. They represent repeatable ONIX tags.
 * Examples include: Contributors, Subjects, etc.
 * </ul>
 * In order to prevent this already-cumbersome structure from becoming even more cumbersome to use, getters and setters are not used, and
 * members are accessible directly. This does not create a risk, as once this object is populated, it's in the sole hands of the user to
 * read and modify.
 * <p>
 * The class also provides lookup services for most composites, given a lookup criteria.
 * 
 * @author Zach Melamed
 * 
 */
public class BasicProduct extends JonixTagColumnable
{
	// generic string elements
	public final GenericStringElement recordReference = new GenericStringElement(ONIX.RecordReference);
	public final GenericStringElement editionNumber = new GenericStringElement(ONIX.EditionNumber);
	public final GenericStringElement cityOfPublication = new GenericStringElement(ONIX.CityOfPublication);
	public final GenericStringElement publicationDate = new GenericStringElement(ONIX.PublicationDate);
	public final GenericStringElement numberOfPages = new GenericStringElement(ONIX.NumberOfPages);
	public final GenericStringElement bisacMainSubject = new GenericStringElement(ONIX.BASICMainSubject);
	public final GenericStringElement bicMainSubject = new GenericStringElement(ONIX.BICMainSubject);

	// custom elements
	public final JonixElement<NotificationTypes> notificationType = new NotificationTypeElement();
	public final JonixElement<ProductForms> productForm = new ProductFormElement();
	public final JonixElement<EpubTypes> epubType = new EpubTypeElement();
	public final JonixElement<EditionTypes> editionType = new EditionTypeElement();
	public final JonixElement<String> countryOfPublication = new CountryOfPublicationElement();

	// composites
	public final ProductIdentifiers productIdentifiers = new ProductIdentifiers();
	public final Titles titles = new Titles();
	public final Contributors contributors = new Contributors();
	public final Serieses serieses = new Serieses();
	public final Languages languages = new Languages();
	public final MainSubjects mainSubjects = new MainSubjects();
	public final Subjects subjects = new Subjects();
	public final Audiences audiences = new Audiences();
	public final OtherTexts otherTexts = new OtherTexts();
	public final Publishers publishers = new Publishers();
	public final Imprints imprints = new Imprints();
	public final SupplyDetails supplyDetails = new SupplyDetails();
	public final SalesRightss salesRightss = new SalesRightss();

	public BasicProduct(JonixResolver resolver)
	{
		super(resolver);
	}

	@Override
	public String getLabel()
	{
		return (titles.size() > 0) ? titles.get(0).titleText : recordReference.getValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <P extends JonixTagColumnable> JonixColumn<P> getDefaultIdColumn()
	{
		return (JonixColumn<P>) BasicColumn.ISBN13;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <P extends JonixTagColumnable> JonixColumn<P>[] getDefaultColumns()
	{
		return (JonixColumn<P>[]) BasicColumn.all;
	}

	// LOOKUP CONVENIENCE SERVICES

	public ProductIdentifier findProductId(ProductIdTypes requestedType)
	{
		for (ProductIdentifier prodId : productIdentifiers)
		{
			if (prodId.productIDType == requestedType)
				return prodId;
		}
		return null;
	}

	public Title findTitle(TitleTypes requestedType)
	{
		for (Title title : titles)
		{
			if (title.titleType == requestedType)
				return title;
		}
		return null;
	}

	public List<Contributor> findContributors(ContributorRoles requestedRole)
	{
		List<Contributor> matches = new ArrayList<Contributor>();
		for (Contributor contributor : contributors)
		{
			if (contributor.contributorRole == requestedRole)
				matches.add(contributor);
		}
		return matches;
	}

	public Language findLanguage(LanguageRoles requestedType)
	{
		for (Language language : languages)
		{
			if (language.languageRole == requestedType)
				return language;
		}
		return null;
	}

	public List<Subject> findSubjects(SubjectSchemeIds requestedScheme)
	{
		List<Subject> matches = new ArrayList<Subject>();

		if (requestedScheme == SubjectSchemeIds.BISAC_Subject_Heading)
		{
			if (bisacMainSubject.getValue() != null && !bisacMainSubject.getValue().isEmpty())
				matches.add(new Subject(SubjectSchemeIds.BISAC_Subject_Heading, bisacMainSubject.getValue()));
		}
		else if (requestedScheme == SubjectSchemeIds.BIC_subject_category)
		{
			if (bicMainSubject.getValue() != null && !bicMainSubject.getValue().isEmpty())
				matches.add(new Subject(SubjectSchemeIds.BIC_subject_category, bicMainSubject.getValue()));
		}

		for (Subject subject : mainSubjects)
		{
			if (subject.subjectSchemeIdentifier == requestedScheme)
				matches.add(subject);
		}
		for (Subject subject : subjects)
		{
			if (subject.subjectSchemeIdentifier == requestedScheme)
				matches.add(subject);
		}
		return matches;
	}

	public OtherText findOtherText(TextTypes requestedType)
	{
		for (OtherText otherText : otherTexts)
		{
			if (otherText.textType == requestedType)
				return otherText;
		}
		return null;
	}

	public List<Price> findPrices(List<PriceTypes> requestedTypes)
	{
		List<Price> matches = new ArrayList<Price>();
		for (SupplyDetail supplyDetail : supplyDetails)
		{
			for (Price price : supplyDetail.prices)
			{
				if (requestedTypes.contains(price.priceType))
					matches.add(price);
			}
		}
		return matches;
	}

	public List<SalesRights> findSalesRightss(List<SalesRightsTypes> requestedTypes)
	{
		List<SalesRights> matches = new ArrayList<SalesRights>();
		for (SalesRights salesRights : salesRightss)
		{
			if (requestedTypes.contains(salesRights.salesRightsType))
				matches.add(salesRights);
		}
		return matches;
	}

	// TODO: findPrices() by currencyCode and/or tax-status
	// TODO: findSeries()
	// TODO: findAudience()
	// TODO: findPublished()
}
