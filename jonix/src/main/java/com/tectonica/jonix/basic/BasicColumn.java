package com.tectonica.jonix.basic;

import java.util.Arrays;
import java.util.List;

import com.tectonica.jonix.JonixColumn;
import com.tectonica.jonix.codelist.ContributorRoles;
import com.tectonica.jonix.codelist.LanguageRoles;
import com.tectonica.jonix.codelist.PriceTypes;
import com.tectonica.jonix.codelist.ProductIdTypes;
import com.tectonica.jonix.codelist.SalesRightsTypes;
import com.tectonica.jonix.codelist.SubjectSchemeIds;
import com.tectonica.jonix.codelist.TextTypes;
import com.tectonica.jonix.codelist.TitleTypes;
import com.tectonica.jonix.composite.Contributors.Contributor;
import com.tectonica.jonix.composite.Languages.Language;
import com.tectonica.jonix.composite.OtherTexts.OtherText;
import com.tectonica.jonix.composite.Prices.Price;
import com.tectonica.jonix.composite.ProductIdentifiers.ProductIdentifier;
import com.tectonica.jonix.composite.SalesRightss.SalesRights;
import com.tectonica.jonix.composite.Subjects.Subject;
import com.tectonica.jonix.composite.Titles.Title;

/**
 * An Enum defining which columns are to be extracted (and possibly exported) from a {@link BasicProduct} object, in what order, and how many columns to
 * allocate for each type of field in a tab-delimited formatting scenario. The enum does not provide the actual methodology, however, of how to extract the
 * field value from a given product record (that's the job of {@link BasicExtractor}). Its main purpose, then, is to facilitate standard transformation of the
 * complex, tree-based ONIX structure into a linear, array-based structure.
 * <p>
 * For example, an Author is an ONIX field (composite) to which this enum dictates allocation of 3 columns. The reason is that we expect this field to show up
 * several times in ONIX records pertaining to multi-author titles.
 * <p>
 * The reason we want to define a set amount of columns per field is to maintain a tabular structure of the output. In doing so we may lose some data (e.g. the
 * 4th author) and/or receive a fairly sparse output (i.e. with many blanks), but this is a toll we have to bear when converting an XML format into table.
 * 
 * @author Zach Melamed
 * 
 */
public enum BasicColumn implements JonixColumn<BasicProduct>
{
	ISBN13("ISBN13", 1)
	{
		@Override
		public boolean extractTo(String[] fieldData, BasicProduct product)
		{
			return extractProductId(fieldData, ProductIdTypes.ISBN13, product);
		}
	},

	Title(new String[]
		{ "Title", "SubTitle" }, 1)
	{
		@Override
		public boolean extractTo(String[] fieldData, BasicProduct product)
		{
			return extractTitle(fieldData, TitleTypes.Distinctive_title_book, product);
		}
	},

	SeriesTitle("SeriesTitle", 1)
	{
		@Override
		public boolean extractTo(String[] fieldData, BasicProduct product)
		{
			if (product.serieses.size() > 0)
			{
				fieldData[0] = product.serieses.get(0).titleOfSeries;
				return true;
			}
			// NOTE: we should probably drill down to the 'titles' member of the series if 'titleOfSeries' is blank
			return false;
		}
	},

	Author("Author", 3)
	{
		@Override
		public boolean extractTo(String[] fieldData, BasicProduct product)
		{
			return extractContributors(fieldData, ContributorRoles.By_author, product);
		}
	},

	Editor("Editor", 2) {
		@Override
		public boolean extractTo(String[] fieldData, BasicProduct product) {
		    if (!extractContributors(fieldData, ContributorRoles.Edited_by, product)) {
                if (!extractContributors(fieldData, ContributorRoles.Volume_editor, product)) {
                    if(!extractContributors(fieldData, ContributorRoles.Series_edited_by, product)) {
                    	if(!extractContributors(fieldData, ContributorRoles.Editorinchief, product)) {
                    		if(!extractContributors(fieldData, ContributorRoles.Managing_editor, product)) {
                    			return extractContributors(fieldData, ContributorRoles.Guest_editor, product);                                	                               
                            }	
                        }	
                    }
                }
            }
            return true;
		}
	},

	Language("Language", 1)
	{
		@Override
		public boolean extractTo(String[] fieldData, BasicProduct product)
		{
			return extractLanguage(fieldData, LanguageRoles.Language_of_text, product);
		}
	},

	NumOfPages("NumOfPages", 1)
	{
		@Override
		public boolean extractTo(String[] fieldData, BasicProduct product)
		{
			fieldData[0] = product.numberOfPages.getValue();
			return true;
		}
	},

	Publisher("Publisher", 1)
	{
		@Override
		public boolean extractTo(String[] fieldData, BasicProduct product)
		{
			if (product.publishers.size() > 0)
			{
				fieldData[0] = product.publishers.get(0).publisherName;
				return true;
			}
			// NOTE: maybe we should look at the 'publisherRole' as well?
			return false;
		}
	},

	PublicationDate("PublicationDate", 1)
	{
		@Override
		public boolean extractTo(String[] fieldData, BasicProduct product)
		{
			fieldData[0] = product.publicationDate.getValue();
			return true;
		}
	},

	Dewey("Dewey", 1)
	{
		@Override
		public boolean extractTo(String[] fieldData, BasicProduct product)
		{
			return extractSubjects(fieldData, SubjectSchemeIds.Dewey, product);
		}
	},

	BISAC("BISAC", 5)
	{
		@Override
		public boolean extractTo(String[] fieldData, BasicProduct product)
		{
			return extractSubjects(fieldData, SubjectSchemeIds.BISAC_Subject_Heading, product);
		}
	},

	BIC("BIC", 5)
	{
		@Override
		public boolean extractTo(String[] fieldData, BasicProduct product)
		{
			return extractSubjects(fieldData, SubjectSchemeIds.BIC_subject_category, product);
		}
	},

	Keywords("Keywords", 1)
	{
		@Override
		public boolean extractTo(String[] fieldData, BasicProduct product)
		{
			return extractSubjects(fieldData, SubjectSchemeIds.Keywords, product);
		}
	},

	PriceAmount(new String[]
		{ "PriceType", "PriceAmount", "CurrencyCode" }, 3)
	{
		@Override
		public boolean extractTo(String[] fieldData, BasicProduct product)
		{
			return extractPrices(fieldData, RECOMMENDED_RETAIL_PRICES, product);
		}
	},

	SalesAllowedIn("SalesAllowed", 3)
	{
		@Override
		public boolean extractTo(String[] fieldData, BasicProduct product)
		{
			return extractSalesRights(fieldData, UNRESTRICTED_SALES_RIGHTS, product);
		}
	},

	SalesBannedIn("SalesBanned", 3)
	{
		@Override
		public boolean extractTo(String[] fieldData, BasicProduct product)
		{
			return extractSalesRights(fieldData, NO_SALES_RIGHTS, product);
		}
	},

	Description(new String[]
		{ "Description", "DescriptionFormat" }, 1)
	{
		@Override
		public boolean extractTo(String[] fieldData, BasicProduct product)
		{
			return extractOtherText(fieldData, TextTypes.Senderdefined_text /* Description? */, product);
		}
	},

	ShortDescription(new String[]
		{ "ShortDescription", "ShortDescriptionFormat" }, 1)
	{
		@Override
		public boolean extractTo(String[] fieldData, BasicProduct product)
		{
			return extractOtherText(fieldData, TextTypes.Short_description_annotation, product);
		}
	};

	private final int repetition;
	private final String[] subColumnNames;

	private BasicColumn(String columnName, int repetition)
	{
		this(new String[]
			{ columnName }, repetition);
	}
	
	@Override
	public int getRepetitions()
	{
		return repetition;
	}
	
	@Override
	public String[] getSubColumnNames()
	{
		return subColumnNames;
	}

	private BasicColumn(String[] subColumnNames, int repetition)
	{
		this.subColumnNames = subColumnNames;
		this.repetition = repetition;
	}

	public static final JonixColumn<BasicProduct>[] all = values();

	////////////////////////////////////////////////////////////////////////////////////////////////

	private static boolean extractProductId(String[] fieldData, ProductIdTypes stdType, BasicProduct product)
	{
		ProductIdentifier prodId = product.findProductId(stdType);
		if (prodId != null)
		{
			fieldData[0] = prodId.idValue;
			return true;
		}
		return false;
	}

	private static boolean extractTitle(String[] fieldData, TitleTypes stdType, BasicProduct product)
	{
		Title title = product.findTitle(stdType);
		if (title != null)
		{
			fieldData[0] = title.titleText;
			fieldData[1] = title.subtitle;
			return true;
		}
		return false;
	}

	private static boolean extractLanguage(String[] fieldData, LanguageRoles stdType, BasicProduct product)
	{
		Language language = product.findLanguage(stdType);
		if (language != null)
		{
			fieldData[0] = language.languageCode;
			return true;
		}
		return false;
	}

	private static boolean extractContributors(String[] fieldData, ContributorRoles stdRole, BasicProduct product)
	{
		List<Contributor> contributors = product.findContributors(stdRole);
		int pos = 0;
		for (Contributor contributor : contributors)
		{
			String displayName = contributor.displayName();
			if (displayName == null)
				continue;
			fieldData[pos] = displayName;
			if (++pos == fieldData.length)
				break;
		}
		return pos > 0;
	}

	private static boolean extractSubjects(String[] fieldData, SubjectSchemeIds stdScheme, BasicProduct product)
	{
		List<Subject> subjects = product.findSubjects(stdScheme);
		int pos = 0;
		for (Subject subject : subjects)
		{
			fieldData[pos] = (subject.subjectCode != null) ? subject.subjectCode : subject.subjectHeadingText;
			if (++pos == fieldData.length)
				break;
		}
		return pos > 0;
	}

	private static boolean extractPrices(String[] fieldData, List<PriceTypes> stdTypes, BasicProduct product)
	{
		List<Price> prices = product.findPrices(stdTypes);
		int pos = 0;
		for (Price price : prices)
		{
			fieldData[pos + 0] = price.priceType.name();
			fieldData[pos + 1] = price.priceAmount;
			fieldData[pos + 2] = price.currencyCode;
			pos += 3;
			if (pos >= fieldData.length)
				break;
		}
		return pos > 0;
	}

	private static boolean extractSalesRights(String[] fieldData, List<SalesRightsTypes> stdTypes, BasicProduct product)
	{
		List<SalesRights> salesRightss = product.findSalesRightss(stdTypes);
		int pos = 0;
		for (SalesRights salesRights : salesRightss)
		{
			StringBuffer sb = new StringBuffer();
			if (salesRights.rightsTerritories != null)
				for (String s : salesRights.rightsTerritories)
					sb.append(s).append(",");
			sb.append("|");
			if (salesRights.rightsCountries != null)
				for (String s : salesRights.rightsCountries)
					sb.append(s).append(";");
			sb.append("|");
			if (salesRights.rightsRegion != null)
				sb.append(salesRights.rightsRegion).append("#");
			fieldData[0] = sb.toString().toUpperCase();
			if (++pos == fieldData.length)
				break;
		}
		return pos > 0;
	}

	private static boolean extractOtherText(String[] fieldData, TextTypes stdType, BasicProduct product)
	{
		OtherText otherText = product.findOtherText(stdType);
		if (otherText != null)
		{
			fieldData[0] = otherText.text;
			if (otherText.textFormat != null)
				fieldData[1] = otherText.textFormat.name();
			return true;
		}
		return false;
	}

	private static final List<PriceTypes> RECOMMENDED_RETAIL_PRICES = Arrays.asList(new PriceTypes[]
		{ PriceTypes.RRP_including_tax, PriceTypes.RRP_excluding_tax });

	private static final List<SalesRightsTypes> NO_SALES_RIGHTS = Arrays.asList(new SalesRightsTypes[]
		{ SalesRightsTypes.Not_for_sale_in_the_specified_countries_or_territories_reason_unspecified,
				SalesRightsTypes.Not_for_sale_in_the_specified_countries_but_publisher_holds_exclusive_rights_in_those_countries_or_territories,
				SalesRightsTypes.Not_for_sale_in_the_specified_countries_publisher_holds_nonexclusive_rights_in_those_countries_or_territories,
				SalesRightsTypes.Not_for_sale_in_the_specified_countries_because_publisher_does_not_hold_rights_in_those_countries_or_territories });

	private static final List<SalesRightsTypes> UNRESTRICTED_SALES_RIGHTS = Arrays.asList(new SalesRightsTypes[]
		{ SalesRightsTypes.For_unrestricted_sale_with_exclusive_rights_in_the_specified_countries_or_territories,
				SalesRightsTypes.For_unrestricted_sale_with_nonexclusive_rights_in_the_specified_countries_or_territories,
				SalesRightsTypes.For_sale_with_exclusive_rights_in_the_specified_countries_or_territories_sales_restriction_applies,
				SalesRightsTypes.For_sale_with_nonexclusive_rights_in_the_specified_countries_or_territories_sales_restriction_applies });
}
