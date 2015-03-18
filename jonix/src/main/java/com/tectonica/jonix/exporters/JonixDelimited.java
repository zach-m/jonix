package com.tectonica.jonix.exporters;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import com.tectonica.jonix.JonixHeader;
import com.tectonica.jonix.JonixPackages;
import com.tectonica.jonix.JonixParser.OnJonixItemListener;
import com.tectonica.jonix.JonixProduct;
import com.tectonica.jonix.codelists.ContributorRoles;
import com.tectonica.jonix.codelists.LanguageRoles;
import com.tectonica.jonix.codelists.PriceTypes;
import com.tectonica.jonix.codelists.ProductIDTypes;
import com.tectonica.jonix.codelists.SalesRightsTypes;
import com.tectonica.jonix.codelists.SubjectSchemeIdentifiers;
import com.tectonica.jonix.codelists.TextTypes;
import com.tectonica.jonix.codelists.TitleTypes;
import com.tectonica.jonix.composites.Contributors.Contributor;
import com.tectonica.jonix.composites.Languages.Language;
import com.tectonica.jonix.composites.OtherTexts.OtherText;
import com.tectonica.jonix.composites.Prices.Price;
import com.tectonica.jonix.composites.ProductIdentifiers.ProductIdentifier;
import com.tectonica.jonix.composites.SalesRightss.SalesRights;
import com.tectonica.jonix.composites.Subjects.Subject;
import com.tectonica.jonix.composites.SupplyDetails.SupplyDetail;
import com.tectonica.jonix.composites.Titles.Title;
import org.xml.sax.SAXException;

public class JonixDelimited extends JonixBaseExporter
{
	public static enum Field
	{
		ISBN13("ISBN13", 1),

		Title(new String[]
			{ "Title", "SubTitle" }, 1),

		SeriesTitle("SeriesTitle", 1),

		Author("Author", 3),

		Editor("Editor", 2),

		Language("Language", 1),

		NumOfPages("NumOfPages", 1),

		Publisher("Publisher", 1),

		PublicationDate("PublicationDate", 1),

		Dewey("Dewey", 1),

		BISAC("BISAC", 5),

		BIC("BIC", 5),

		Keywords("Keywords", 1),

		PriceAmount(new String[]
			{ "PriceType", "PriceAmount", "CurrencyCode" }, 3),

		SalesAllowedIn("SalesAllowed", 3),

		SalesBannedIn("SalesBanned", 3),

		Description(new String[]
			{ "Description", "DescriptionFormat" }, 1),

		ShortDescription(new String[]
			{ "ShortDescription", "ShortDescriptionFormat" }, 1);

		public final int repetition;
		public final String[] subColumnNames;

		private Field(String columnName, int repetition)
		{
			this(new String[]
				{ columnName }, repetition);
		}

		private Field(String[] subColumnNames, int repetition)
		{
			this.subColumnNames = subColumnNames;
			this.repetition = repetition;
		}

		public static final Field[] values = values();
	}

	private PrintStream output;
	private PrintStream log;

	public JonixDelimited(JonixPackages jonixPackage, PrintStream output, PrintStream log)
	{
		super(jonixPackage);
		this.output = (output == null) ? System.out : output;
		this.log = (log == null) ? System.err : log;

		log.println("Initializing..");
		initializeParser();
	}

	@Override
	public void export(List<String> files)
	{
		log.println("Parsing " + files.size() + " files");

		output.println(generateHeaderRow());
		for (String fileName : files)
		{
			try
			{
				log.println("opening " + fileName + ".. ");
				parser.parse(fileName, onJonixItemListener);
			}
			catch (IOException e)
			{
				e.printStackTrace(log);
				// we move on to the next file
			}
			catch (SAXException e)
			{
				log.println("aborting");
				e.printStackTrace(log);
				break;
			}
		}

		output.flush();
	}

	private String generateHeaderRow()
	{
		StringBuilder sb = new StringBuilder();
		for (Field field : Field.values)
		{
			for (int i = 0; i < field.repetition; i++)
			{
				for (int j = 0; j < field.subColumnNames.length; j++)
				{
					sb.append(field.subColumnNames[j]);
					if (field.repetition > 1)
						sb.append(".").append(i + 1);
					sb.append("\t");
				}
			}
		}
		return sb.toString();
	}

	private OnJonixItemListener onJonixItemListener = new OnJonixItemListener()
	{
		@Override
		public void onHeader(JonixHeader header)
		{
			log.println("-----------------------------------------------------------\n");
			log.println(header.toString());
			log.println("-----------------------------------------------------------\n");
		}

		private JonixProduct product;

		@Override
		public void onProduct(JonixProduct product, int index)
		{
			// show a log message about the product being successfully parsed
			String productLabel = product.recordReference;
			if (product.titles.size() > 0)
				productLabel = product.titles.get(0).titleText;
			log.println("parsed product #" + index + " - " + productLabel);

			// export a single tab-delimited row representing the product
			this.product = product;
			output.println(generateProductRow());
		}

		private String generateProductRow()
		{
			// prepare the resulting jagged-array of values
			String[][] result = new String[Field.values.length][];

			// populate it by extracting information from the 'product' object
			for (Field field : Field.values)
			{
				String[] fieldData = result[field.ordinal()] = new String[field.repetition * field.subColumnNames.length];
				extractField(field, fieldData);
			}

			// generate the tab-delimited row of text from the jagged-array
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < result.length; i++)
			{
				for (int j = 0; j < result[i].length; j++)
				{
					String item = result[i][j];
					if (item == null)
						sb.append("");
					else
						sb.append(item.replaceAll("\\t|\\n|\\r", " "));
					sb.append("\t");
				}
			}
			return sb.toString();
		}

		private void extractField(Field field, String[] fieldData)
		{
			switch (field)
			{
				case ISBN13:
					extractProductId(fieldData, ProductIDTypes.ISBN13);
					break;

				case Title:
					extractTitle(fieldData, TitleTypes.Distinctive);
					break;

				case SeriesTitle:
					if (product.serieses.size() > 0)
						fieldData[0] = product.serieses.get(0).titleOfSeries;
					// NOTE: we should probably drill down to the 'titles' member of the series if 'titleOfSeries' is blank
					break;

				case Author:
					extractContributors(fieldData, ContributorRoles.By);
					break;

				case Editor:
					extractContributors(fieldData, ContributorRoles.Edited_by);
					break;

				case Language:
					extractLanguage(fieldData, LanguageRoles.Language_of_text);
					break;

				case NumOfPages:
					fieldData[0] = product.numberOfPages;
					break;

				case Publisher:
					if (product.publishers.size() > 0)
						fieldData[0] = product.publishers.get(0).publisherName;
					// NOTE: maybe we should look at the 'publisherRole' as well?
					break;

				case PublicationDate:
					fieldData[0] = product.publicationDate;
					break;

				case Dewey:
					extractSubjects(fieldData, SubjectSchemeIdentifiers.Dewey);
					break;

				case BISAC:
					extractSubjects(fieldData, SubjectSchemeIdentifiers.BISAC_Subject_Heading);
					break;

				case BIC:
					extractSubjects(fieldData, SubjectSchemeIdentifiers.BIC_subject_category);
					break;

				case Keywords:
					extractSubjects(fieldData, SubjectSchemeIdentifiers.Keywords);
					break;

				case PriceAmount:
					extractPrices(fieldData, RECOMMENDED_RETAIL_PRICES);
					break;

				case SalesAllowedIn:
					extractSalesRights(fieldData, UNRESTRICTED_SALES_RIGHTS);
					break;

				case SalesBannedIn:
					extractSalesRights(fieldData, NO_SALES_RIGHTS);
					break;

				case Description:
					extractOtherText(fieldData, TextTypes.Main_description);
					break;

				case ShortDescription:
					extractOtherText(fieldData, TextTypes.Short_description);
					break;
			}
		}

		private void extractProductId(String[] fieldData, ProductIDTypes requestedType)
		{
			for (ProductIdentifier prodId : product.productIdentifiers)
			{
				if (prodId.productIDType == requestedType)
				{
					fieldData[0] = prodId.idValue;
					break;
				}
			}
		}

		private void extractTitle(String[] fieldData, TitleTypes requestedType)
		{
			for (Title title : product.titles)
			{
				if (title.titleType == requestedType)
				{
					fieldData[0] = title.titleText;
					fieldData[1] = title.subtitle;
					break;
				}
			}
		}

		private void extractLanguage(String[] fieldData, LanguageRoles requestedType)
		{
			for (Language language : product.languages)
			{
				if (language.languageRole == requestedType)
				{
					fieldData[0] = language.languageCode;
					break;
				}
			}
		}

		private void extractContributors(String[] fieldData, ContributorRoles requestedRole)
		{
			int pos = 0;
			for (Contributor contributor : product.contributors)
			{
				if (contributor.contributorRole == requestedRole)
				{
					fieldData[pos] = contributor.personName;
					if (++pos == fieldData.length)
						break;
				}
			}
		}

		private void extractSubjects(String[] fieldData, SubjectSchemeIdentifiers requestedScheme)
		{
			int pos = 0;
			for (Subject subject : product.mainSubjects)
			{
				if (subject.subjectSchemeIdentifier == requestedScheme)
				{
					fieldData[pos] = (subject.subjectCode != null) ? subject.subjectCode : subject.subjectHeadingText;
					if (++pos == fieldData.length)
						return; // important: not 'break'
				}
			}
			for (Subject subject : product.subjects)
			{
				if (subject.subjectSchemeIdentifier == requestedScheme)
				{
					fieldData[pos] = (subject.subjectCode != null) ? subject.subjectCode : subject.subjectHeadingText;
					if (++pos == fieldData.length)
						break;
				}
			}
		}

		private void extractPrices(String[] fieldData, List<PriceTypes> requestedTypes)
		{
			int pos = 0;
			for (SupplyDetail supplyDetail : product.supplyDetails)
			{
				for (Price price : supplyDetail.prices)
				{
					if (requestedTypes.contains(price.priceType))
					{
						fieldData[pos + 0] = price.priceType.name();
						fieldData[pos + 1] = price.priceAmount;
						fieldData[pos + 2] = price.currencyCode;
						pos += 3;
						if (pos >= fieldData.length)
							break;
					}
				}
			}
		}

		private void extractSalesRights(String[] fieldData, List<SalesRightsTypes> requestedTypes)
		{
			int pos = 0;
			for (SalesRights salesRights : product.salesRightss)
			{
				if (requestedTypes.contains(salesRights.salesRightsType))
				{
					String out = "";
					if (salesRights.rightsTerritories != null)
						out = salesRights.rightsTerritories.toString();
					if (salesRights.rightsCountries != null)
						out += (out.isEmpty() ? "" : "; ") + salesRights.rightsCountries.toString();
					if (salesRights.rightsRegion != null)
						out += (out.isEmpty() ? "" : "; ") + salesRights.rightsRegion;
					fieldData[0] = out;
					if (++pos == fieldData.length)
						break;
				}
			}
		}

		private void extractOtherText(String[] fieldData, TextTypes requestedType)
		{
			for (OtherText otherText : product.otherTexts)
			{
				if (otherText.textType == requestedType)
				{
					fieldData[0] = otherText.text;
					if (otherText.textFormat != null)
						fieldData[1] = otherText.textFormat.name();
					break;
				}
			}
		}
	};

	private static final List<PriceTypes> RECOMMENDED_RETAIL_PRICES = Arrays.asList(new PriceTypes[]
		{ PriceTypes.RRP_including_tax, PriceTypes.RRP_excluding_tax });

	private static final List<SalesRightsTypes> NO_SALES_RIGHTS = Arrays.asList(new SalesRightsTypes[]
		{ SalesRightsTypes.Not_for_sale_in_the_specified_countries_or_territories_reason_unspecified,
				SalesRightsTypes.Not_for_sale_in_the_specified_countries_but_publisher_holds_exclusive_rights_in_those_countries_or_territories,
				SalesRightsTypes.Not_for_sale_in_the_specified_countries_publisher_holds_non_exclusive_rights_in_those_countries_or_territories,
				SalesRightsTypes.Not_for_sale_in_the_specified_countries_because_publisher_does_not_hold_rights_in_those_countries_or_territories });

	private static final List<SalesRightsTypes> UNRESTRICTED_SALES_RIGHTS = Arrays.asList(new SalesRightsTypes[]
		{ SalesRightsTypes.For_unrestricted_sale_with_exclusive_rights_in_the_specified_countries_or_territories,
				SalesRightsTypes.For_unrestricted_sale_with_non_exclusive_rights_in_the_specified_countries_or_territories,
				SalesRightsTypes.For_sale_with_exclusive_rights_in_the_specified_countries_or_territories_sales_restriction_applies,
				SalesRightsTypes.For_sale_with_non_exclusive_rights_in_the_specified_countries_or_territories_sales_restriction_applies });
}
