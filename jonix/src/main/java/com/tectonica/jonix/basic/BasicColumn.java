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

package com.tectonica.jonix.basic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.tectonica.jonix.JonixColumn;
import com.tectonica.jonix.codelist.ContributorRoles;
import com.tectonica.jonix.codelist.CountryCodeIso31661s;
import com.tectonica.jonix.codelist.LanguageRoles;
import com.tectonica.jonix.codelist.PriceTypes;
import com.tectonica.jonix.codelist.ProductIdentifierTypes;
import com.tectonica.jonix.codelist.RightsRegions;
import com.tectonica.jonix.codelist.SalesRightsTypes;
import com.tectonica.jonix.codelist.SubjectSchemeIdentifiers;
import com.tectonica.jonix.codelist.TextTypes;
import com.tectonica.jonix.codelist.TitleTypes;
import com.tectonica.jonix.struct.JonixLanguage;
import com.tectonica.jonix.struct.JonixProductIdentifier;

public abstract class BasicColumn implements JonixColumn<BasicProduct>
{
	protected final int repetition;
	protected final String[] subColumnNames;

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

	protected BasicColumn(String[] subColumnNames, int repetition)
	{
		this.subColumnNames = subColumnNames;
		this.repetition = repetition;
	}

	protected BasicColumn(String columnName, int repetition)
	{
		this(new String[] { columnName }, repetition);
	}

	// //////////////////////////////////////////////////////////////////////////////////////////////

	public static BasicColumn ISBN13 = new BasicColumn("ISBN13", 1)
	{
		@Override
		public boolean extractFrom(BasicProduct product, String[] columnBuffer)
		{
			return extractProductId(product, columnBuffer, ProductIdentifierTypes.ISBN_13);
		}
	};

	public static BasicColumn Title = new BasicColumn(new String[] { "Title", "SubTitle" }, 1)
	{
		@Override
		public boolean extractFrom(BasicProduct product, String[] columnBuffer)
		{
			return extractTitle(product, columnBuffer, TitleTypes.Distinctive_title_book);
		}
	};

	public static BasicColumn SeriesTitle = new BasicColumn("SeriesTitle", 1)
	{
		@Override
		public boolean extractFrom(BasicProduct product, String[] columnBuffer)
		{
			return extractSeriesTitle(product, columnBuffer);
		}
	};

	public static BasicColumn Author = new BasicColumn("Author", 3)
	{
		@Override
		public boolean extractFrom(BasicProduct product, String[] columnBuffer)
		{
			return extractContributors(product, columnBuffer, ContributorRoles.By_author);
		}
	};

	public static BasicColumn Editor = new BasicColumn("Editor", 2)
	{
		@Override
		public boolean extractFrom(BasicProduct product, String[] columnBuffer)
		{
			if (!extractContributors(product, columnBuffer, ContributorRoles.Edited_by))
				if (!extractContributors(product, columnBuffer, ContributorRoles.Volume_editor))
					if (!extractContributors(product, columnBuffer, ContributorRoles.Series_edited_by))
						if (!extractContributors(product, columnBuffer, ContributorRoles.Editor_in_chief))
							if (!extractContributors(product, columnBuffer, ContributorRoles.Managing_editor))
								return extractContributors(product, columnBuffer, ContributorRoles.Guest_editor);
			return true;
		}
	};

	public static BasicColumn Language = new BasicColumn("Language", 1)
	{
		@Override
		public boolean extractFrom(BasicProduct product, String[] columnBuffer)
		{
			return extractLanguage(product, columnBuffer, LanguageRoles.Language_of_text);
		}
	};

	public static BasicColumn NumOfPages = new BasicColumn("NumOfPages", 1)
	{
		@Override
		public boolean extractFrom(BasicProduct product, String[] columnBuffer)
		{
			columnBuffer[0] = product.description.numberOfPages;
			return true;
		}
	};

	public static BasicColumn Publisher = new BasicColumn("Publisher", 1)
	{
		@Override
		public boolean extractFrom(BasicProduct product, String[] columnBuffer)
		{
			return extractPublisher(product, columnBuffer);
		}
	};

	public static BasicColumn PublicationDate = new BasicColumn("PublicationDate", 1)
	{
		@Override
		public boolean extractFrom(BasicProduct product, String[] columnBuffer)
		{
			columnBuffer[0] = product.publishingDetails.publicationDate;
			return true;
		}
	};

	public static BasicColumn Dewey = new BasicColumn("Dewey", 1)
	{
		@Override
		public boolean extractFrom(BasicProduct product, String[] columnBuffer)
		{
			return extractSubjects(product, columnBuffer, SubjectSchemeIdentifiers.Dewey);
		}
	};

	public static BasicColumn BISAC = new BasicColumn("BISAC", 5)
	{
		@Override
		public boolean extractFrom(BasicProduct product, String[] columnBuffer)
		{
			return extractSubjects(product, columnBuffer, SubjectSchemeIdentifiers.BISAC_Subject_Heading);
		}
	};

	public static BasicColumn BIC = new BasicColumn("BIC", 5)
	{
		@Override
		public boolean extractFrom(BasicProduct product, String[] columnBuffer)
		{
			return extractSubjects(product, columnBuffer, SubjectSchemeIdentifiers.BIC_subject_category);
		}
	};

	public static BasicColumn Keywords = new BasicColumn("Keywords", 1)
	{
		@Override
		public boolean extractFrom(BasicProduct product, String[] columnBuffer)
		{
			return extractSubjects(product, columnBuffer, SubjectSchemeIdentifiers.Keywords);
		}
	};

	public static BasicColumn PriceAmount = new BasicColumn(
			new String[] { "PriceType", "PriceAmount", "CurrencyCode" }, 3)
	{
		@Override
		public boolean extractFrom(BasicProduct product, String[] columnBuffer)
		{
			return extractPrices(product, columnBuffer, RECOMMENDED_RETAIL_PRICES);
		}
	};

	public static BasicColumn SalesAllowedIn = new BasicColumn("SalesAllowed", 3)
	{
		@Override
		public boolean extractFrom(BasicProduct product, String[] columnBuffer)
		{
			return extractSalesRights(product, columnBuffer, UNRESTRICTED_SALES_RIGHTS);
		}
	};

	public static BasicColumn SalesBannedIn = new BasicColumn("SalesBanned", 3)
	{
		@Override
		public boolean extractFrom(BasicProduct product, String[] columnBuffer)
		{
			return extractSalesRights(product, columnBuffer, NO_SALES_RIGHTS);
		}
	};

	public static BasicColumn Description = new BasicColumn(new String[] { "Description", "DescriptionFormat" }, 1)
	{
		@Override
		public boolean extractFrom(BasicProduct product, String[] columnBuffer)
		{
			return extractOtherText(product, columnBuffer, TextTypes.Description);
		}
	};

	public static BasicColumn ShortDescription = new BasicColumn(new String[] { "ShortDescription",
			"ShortDescriptionFormat" }, 1)
	{
		@Override
		public boolean extractFrom(BasicProduct product, String[] columnBuffer)
		{
			return extractOtherText(product, columnBuffer, TextTypes.Short_description_annotation);
		}
	};

	// //////////////////////////////////////////////////////////////////////////////////////////////

	private static boolean extractProductId(BasicProduct product, String[] columnBuffer, ProductIdentifierTypes stdType)
	{
		JonixProductIdentifier prodId = product.info.findProductId(stdType);
		if (prodId != null)
		{
			columnBuffer[0] = prodId.idValue;
			return true;
		}
		return false;
	}

	private static boolean extractTitle(BasicProduct product, String[] columnBuffer, TitleTypes stdType)
	{
		BasicTitle title = product.titles.findTitle(stdType);
		if (title != null)
		{
			columnBuffer[0] = title.titleText;
			columnBuffer[1] = title.subtitle;
			return true;
		}
		return false;
	}

	private static boolean extractSeriesTitle(BasicProduct product, String[] columnBuffer)
	{
		if (product.collections.size() > 0)
		{
			columnBuffer[0] = product.collections.get(0).mainTitle;
			return true;
		}
		// NOTE: we should probably drill down to the 'titles' member of the series if 'titleOfSeries' is blank
		return false;
	}

	private static boolean extractLanguage(BasicProduct product, String[] columnBuffer, LanguageRoles stdType)
	{
		JonixLanguage language = product.description.findLanguage(stdType);
		if (language != null)
		{
			columnBuffer[0] = language.languageCode.name();
			return true;
		}
		return false;
	}

	private static boolean extractPublisher(BasicProduct product, String[] columnBuffer)
	{
		if (product.publishers.size() > 0)
		{
			columnBuffer[0] = product.publishers.get(0).publisherName;
			return true;
		}
		// NOTE: maybe we should look at the 'publisherRole' as well?
		return false;
	}

	private static boolean extractPrices(BasicProduct product, String[] columnBuffer, Set<PriceTypes> stdTypes)
	{
		List<BasicPrice> prices = product.supplyDetails.findPrices(stdTypes);
		int pos = 0;
		for (BasicPrice price : prices)
		{
			columnBuffer[pos + 0] = price.priceType.name();
			columnBuffer[pos + 1] = price.priceAmountAsStr;
			columnBuffer[pos + 2] = price.currencyCode.name();
			pos += 3;
			if (pos >= columnBuffer.length)
				break;
		}
		return pos > 0;
	}

	private static boolean extractContributors(BasicProduct product, String[] columnBuffer, ContributorRoles stdRole)
	{
		List<BasicContributor> contributors = product.contributors.findContributors(stdRole);
		int pos = 0;
		for (BasicContributor contributor : contributors)
		{
			String displayName = contributor.displayName;
			if (displayName == null)
				continue;
			columnBuffer[pos] = displayName;
			if (++pos == columnBuffer.length)
				break;
		}
		return pos > 0;
	}

	private static boolean extractSubjects(BasicProduct product, String[] columnBuffer,
			SubjectSchemeIdentifiers stdScheme)
	{
		List<BasicSubject> subjects = product.subjects.findSubjects(stdScheme);
		int pos = 0;
		for (BasicSubject subject : subjects)
		{
			columnBuffer[pos] = (subject.subjectCode != null) ? subject.subjectCode : subject.subjectHeadingText;
			if (++pos == columnBuffer.length)
				break;
		}
		return pos > 0;
	}

	private static boolean extractSalesRights(BasicProduct product, String[] columnBuffer,
			Set<SalesRightsTypes> stdTypes)
	{
		List<BasicSalesRights> salesRightss = product.salesRightss.findSalesRights(stdTypes);
		int pos = 0;
		for (BasicSalesRights salesRights : salesRightss)
		{
			StringBuffer sb = new StringBuffer();
			if (salesRights.regions != null)
				sb.append(salesRights.regions).append("#");
			sb.append("|");
			if (salesRights.countries != null)
				for (Set<CountryCodeIso31661s> cc : salesRights.countries)
					sb.append(cc).append(";");
			sb.append("|");
			if (salesRights.rightRegions != null)
				for (RightsRegions rr : salesRights.rightRegions)
					sb.append(rr.name()).append(",");
			columnBuffer[0] = sb.toString(); // .toUpperCase();
			if (++pos == columnBuffer.length)
				break;
		}
		return pos > 0;
	}

	private static boolean extractOtherText(BasicProduct product, String[] columnBuffer, TextTypes stdType)
	{
		BasicText otherText = product.texts.findText(stdType);
		if (otherText != null)
		{
			columnBuffer[0] = otherText.text;
			if (otherText.textFormat != null)
				columnBuffer[1] = otherText.textFormat.name();
			return true;
		}
		return false;
	}

	// //////////////////////////////////////////////////////////////////////////////////////////////

	public static final BasicColumn[] ALL_COLUMNS = { BasicColumn.ISBN13, //
			BasicColumn.Title, //
			BasicColumn.SeriesTitle, //
			BasicColumn.Author, //
			BasicColumn.Editor, //
			BasicColumn.Language, //
			BasicColumn.NumOfPages, //
			BasicColumn.Publisher, //
			BasicColumn.PublicationDate, //
			BasicColumn.Dewey, //
			BasicColumn.BISAC, //
			BasicColumn.BIC, //
			BasicColumn.Keywords, //
			BasicColumn.PriceAmount, //
			BasicColumn.SalesAllowedIn, //
			BasicColumn.SalesBannedIn, //
			BasicColumn.Description, //
			BasicColumn.ShortDescription //
	};

	protected static final Set<PriceTypes> RECOMMENDED_RETAIL_PRICES = new HashSet<>(Arrays.asList(new PriceTypes[] {
			PriceTypes.RRP_including_tax, PriceTypes.RRP_excluding_tax }));

	protected static final Set<SalesRightsTypes> NO_SALES_RIGHTS = new HashSet<>(
			Arrays.asList(new SalesRightsTypes[] {
					SalesRightsTypes.Not_for_sale_in_the_specified_countries_or_territories_reason_unspecified,
					SalesRightsTypes.Not_for_sale_in_the_specified_countries_but_publisher_holds_exclusive_rights_in_those_countries_or_territories,
					SalesRightsTypes.Not_for_sale_in_the_specified_countries_publisher_holds_non_exclusive_rights_in_those_countries_or_territories,
					SalesRightsTypes.Not_for_sale_in_the_specified_countries_because_publisher_does_not_hold_rights_in_those_countries_or_territories }));

	protected static final Set<SalesRightsTypes> UNRESTRICTED_SALES_RIGHTS = new HashSet<>(
			Arrays.asList(new SalesRightsTypes[] {
					SalesRightsTypes.For_sale_with_exclusive_rights_in_the_specified_countries_or_territories,
					SalesRightsTypes.For_sale_with_non_exclusive_rights_in_the_specified_countries_or_territories,
					SalesRightsTypes.For_sale_with_exclusive_rights_in_the_specified_countries_or_territories_sales_restriction_applies,
					SalesRightsTypes.For_sale_with_non_exclusive_rights_in_the_specified_countries_or_territories_sales_restriction_applies }));
}
