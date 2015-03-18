package com.tectonica.jonix;

import com.tectonica.jonix.codelists.EditionTypes;
import com.tectonica.jonix.codelists.EpubTypes;
import com.tectonica.jonix.codelists.NotificationTypes;
import com.tectonica.jonix.codelists.ProductForms;
import com.tectonica.jonix.composites.Audiences;
import com.tectonica.jonix.composites.Contributors;
import com.tectonica.jonix.composites.Languages;
import com.tectonica.jonix.composites.MainSubjects;
import com.tectonica.jonix.composites.OtherTexts;
import com.tectonica.jonix.composites.ProductIdentifiers;
import com.tectonica.jonix.composites.Publishers;
import com.tectonica.jonix.composites.SalesRightss;
import com.tectonica.jonix.composites.Serieses;
import com.tectonica.jonix.composites.Subjects;
import com.tectonica.jonix.composites.SupplyDetails;
import com.tectonica.jonix.composites.Titles;
import com.tectonica.jonix.mappers.IProductMapper;

/**
 * Container for an ONIX's <code>PRODUCT</code> tag, consisting of only the fields considered important by Jonix. This object is being populated by a
 * package-dependent implementation of {@link IProductMapper}. Its members are divided into two groups, following ONIX terminology - <b>Elements</b> and
 * <b>Composites</b>:
 * <ul>
 * <li>Elements are single-value tags, typically located directly under <code>PRODUCT</code>, and they are represented by a Java primitive
 * <li>Composites are basically <code>List</code>s of objects, some of which may also be lists. They represent repeatable ONIX tags.
 * </ul>
 * In order to prevent this already-cumbersome structure from becoming even more cumbersome to use, getters and setters are not used, and members are accessible
 * directly. This does not create a risk, as once this object is populated, it's in the sole hands of the user to read and write.
 * 
 * @author Zach Melamed
 * 
 */
public class JonixProduct
{
	// elements
	public String recordReference;
	public NotificationTypes notificationType;
	public ProductForms productForm;
	public EpubTypes epubType;
	public EditionTypes editionType;
	public String editionNumber;
	public String countryOfPublication;
	public String cityOfPublication;
	public String publicationDate;
	public String numberOfPages;
	public String basicMainSubject;
	public String imprintName;

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
	public final SupplyDetails supplyDetails = new SupplyDetails();
	public final SalesRightss salesRightss = new SalesRightss();

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		appendElements(sb);
		appendComposites(sb);
		return sb.toString();
	}

	private void appendElements(StringBuilder sb)
	{
		if (recordReference != null)
			sb.append("RecordReference: ").append(recordReference).append("\n");
		if (notificationType != null)
			sb.append("NotificationType: ").append(notificationType.name()).append("\n");
		if (productForm != null)
			sb.append("ProductForm: ").append(productForm.name()).append("\n");
		if (epubType != null)
			sb.append("EpubType: ").append(epubType.name()).append("\n");
		if (editionType != null)
			sb.append("EditionType: ").append(editionType.name()).append("\n");
		if (editionNumber != null)
			sb.append("EditionNumber: ").append(editionNumber).append("\n");
		if (countryOfPublication != null)
			sb.append("CountryOfPublication: ").append(countryOfPublication).append("\n");
		if (cityOfPublication != null)
			sb.append("CityOfPublication: ").append(cityOfPublication).append("\n");
		if (publicationDate != null)
			sb.append("PublicationDate: ").append(publicationDate).append("\n");
		if (numberOfPages != null)
			sb.append("NumberOfPages: ").append(numberOfPages).append("\n");
		if (basicMainSubject != null)
			sb.append("BASICMainSubject: ").append(basicMainSubject).append("\n");
		if (imprintName != null)
			sb.append("ImprintName: ").append(imprintName).append("\n");
	}

	private void appendComposites(StringBuilder sb)
	{
		for (ProductIdentifiers.ProductIdentifier item : productIdentifiers)
			sb.append(item.toString()).append("\n");
		for (Titles.Title item : titles)
			sb.append(item.toString()).append("\n");
		for (Contributors.Contributor item : contributors)
			sb.append(item.toString()).append("\n");
		for (Serieses.Series item : serieses)
			sb.append(item.toString()).append("\n");
		for (Languages.Language item : languages)
			sb.append(item.toString()).append("\n");
		for (MainSubjects.Subject item : mainSubjects)
			sb.append(item.toString()).append("\n");
		for (Subjects.Subject item : subjects)
			sb.append(item.toString()).append("\n");
		for (Audiences.Audience item : audiences)
			sb.append(item.toString()).append("\n");
		for (OtherTexts.OtherText item : otherTexts)
			sb.append(item.toString()).append("\n");
		for (Publishers.Publisher item : publishers)
			sb.append(item.toString()).append("\n");
		for (SupplyDetails.SupplyDetail item : supplyDetails)
			sb.append(item.toString()).append("\n");
		for (SalesRightss.SalesRights item : salesRightss)
			sb.append(item.toString()).append("\n");
	}
}
