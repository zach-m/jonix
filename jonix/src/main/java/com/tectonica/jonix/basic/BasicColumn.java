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
import com.tectonica.jonix.codelist.OtherTextTypes;
import com.tectonica.jonix.codelist.PriceTypes;
import com.tectonica.jonix.codelist.ProductIdentifierTypes;
import com.tectonica.jonix.codelist.RightsRegions;
import com.tectonica.jonix.codelist.SalesRightsTypes;
import com.tectonica.jonix.codelist.SubjectSchemeIdentifiers;
import com.tectonica.jonix.codelist.TitleTypes;
import com.tectonica.jonix.composite.Contributor;
import com.tectonica.jonix.composite.OtherText;
import com.tectonica.jonix.composite.Price;
import com.tectonica.jonix.composite.SalesRights;
import com.tectonica.jonix.composite.Subject;
import com.tectonica.jonix.struct.JonixLanguage;
import com.tectonica.jonix.struct.JonixProductIdentifier;
import com.tectonica.jonix.struct.JonixTitle;

public enum BasicColumn implements JonixColumn
{
	ISBN13("ISBN13", 1)
	{
		@Override
		public boolean extractTo(String[] fieldData, BasicProduct2 product)
		{
			return extractProductId(fieldData, ProductIdentifierTypes.ISBN_13, product);
		}
	},

	Title(new String[] { "Title", "SubTitle" }, 1)
	{
		@Override
		public boolean extractTo(String[] fieldData, BasicProduct2 product)
		{
			return extractTitle(fieldData, TitleTypes.Distinctive_title_book, product);
		}
	},

	SeriesTitle("SeriesTitle", 1)
	{
		@Override
		public boolean extractTo(String[] fieldData, BasicProduct2 product)
		{
			if (product.seriess.size() > 0)
			{
				fieldData[0] = product.seriess.get(0).titleOfSeries;
				return true;
			}
			// NOTE: we should probably drill down to the 'titles' member of the series if 'titleOfSeries' is blank
			return false;
		}
	},

	Author("Author", 3)
	{
		@Override
		public boolean extractTo(String[] fieldData, BasicProduct2 product)
		{
			return extractContributors(fieldData, ContributorRoles.By_author, product);
		}
	},

	Editor("Editor", 2)
	{
		@Override
		public boolean extractTo(String[] fieldData, BasicProduct2 product)
		{
			if (!extractContributors(fieldData, ContributorRoles.Edited_by, product))
			{
				if (!extractContributors(fieldData, ContributorRoles.Volume_editor, product))
				{
					if (!extractContributors(fieldData, ContributorRoles.Series_edited_by, product))
					{
						if (!extractContributors(fieldData, ContributorRoles.Editor_in_chief, product))
						{
							if (!extractContributors(fieldData, ContributorRoles.Managing_editor, product))
							{
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
		public boolean extractTo(String[] fieldData, BasicProduct2 product)
		{
			return extractLanguage(fieldData, LanguageRoles.Language_of_text, product);
		}
	},

	NumOfPages("NumOfPages", 1)
	{
		@Override
		public boolean extractTo(String[] fieldData, BasicProduct2 product)
		{
			fieldData[0] = product.numberOfPages;
			return true;
		}
	},

	Publisher("Publisher", 1)
	{
		@Override
		public boolean extractTo(String[] fieldData, BasicProduct2 product)
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
		public boolean extractTo(String[] fieldData, BasicProduct2 product)
		{
			fieldData[0] = product.publicationDate;
			return true;
		}
	},

	Dewey("Dewey", 1)
	{
		@Override
		public boolean extractTo(String[] fieldData, BasicProduct2 product)
		{
			return extractSubjects(fieldData, SubjectSchemeIdentifiers.Dewey, product);
		}
	},

	BISAC("BISAC", 5)
	{
		@Override
		public boolean extractTo(String[] fieldData, BasicProduct2 product)
		{
			return extractSubjects(fieldData, SubjectSchemeIdentifiers.BISAC_Subject_Heading, product);
		}
	},

	BIC("BIC", 5)
	{
		@Override
		public boolean extractTo(String[] fieldData, BasicProduct2 product)
		{
			return extractSubjects(fieldData, SubjectSchemeIdentifiers.BIC_subject_category, product);
		}
	},

	Keywords("Keywords", 1)
	{
		@Override
		public boolean extractTo(String[] fieldData, BasicProduct2 product)
		{
			return extractSubjects(fieldData, SubjectSchemeIdentifiers.Keywords, product);
		}
	},

	PriceAmount(new String[] { "PriceType", "PriceAmount", "CurrencyCode" }, 3)
	{
		@Override
		public boolean extractTo(String[] fieldData, BasicProduct2 product)
		{
			return extractPrices(fieldData, RECOMMENDED_RETAIL_PRICES, product);
		}
	},

	SalesAllowedIn("SalesAllowed", 3)
	{
		@Override
		public boolean extractTo(String[] fieldData, BasicProduct2 product)
		{
			return extractSalesRights(fieldData, UNRESTRICTED_SALES_RIGHTS, product);
		}
	},

	SalesBannedIn("SalesBanned", 3)
	{
		@Override
		public boolean extractTo(String[] fieldData, BasicProduct2 product)
		{
			return extractSalesRights(fieldData, NO_SALES_RIGHTS, product);
		}
	},

	Description(new String[] { "Description", "DescriptionFormat" }, 1)
	{
		@Override
		public boolean extractTo(String[] fieldData, BasicProduct2 product)
		{
			return extractOtherText(fieldData, OtherTextTypes.Main_description, product);
		}
	},

	ShortDescription(new String[] { "ShortDescription", "ShortDescriptionFormat" }, 1)
	{
		@Override
		public boolean extractTo(String[] fieldData, BasicProduct2 product)
		{
			return extractOtherText(fieldData, OtherTextTypes.Short_description_annotation, product);
		}
	};

	private final int repetition;
	private final String[] subColumnNames;

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

	private BasicColumn(String columnName, int repetition)
	{
		this(new String[] { columnName }, repetition);
	}

	public static final JonixColumn[] all = values();

	// //////////////////////////////////////////////////////////////////////////////////////////////

	private static boolean extractProductId(String[] fieldData, ProductIdentifierTypes stdType, BasicProduct2 product)
	{
		JonixProductIdentifier prodId = product.findProductId(stdType);
		if (prodId != null)
		{
			fieldData[0] = prodId.idValue;
			return true;
		}
		return false;
	}

	private static boolean extractTitle(String[] fieldData, TitleTypes stdType, BasicProduct2 product)
	{
		JonixTitle title = product.findTitle(stdType);
		if (title != null)
		{
			fieldData[0] = title.titleText;
			fieldData[1] = title.subtitle;
			return true;
		}
		return false;
	}

	private static boolean extractLanguage(String[] fieldData, LanguageRoles stdType, BasicProduct2 product)
	{
		JonixLanguage language = product.findLanguage(stdType);
		if (language != null)
		{
			fieldData[0] = language.languageCode.name();
			return true;
		}
		return false;
	}

	private static boolean extractContributors(String[] fieldData, ContributorRoles stdRole, BasicProduct2 product)
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

	private static boolean extractSubjects(String[] fieldData, SubjectSchemeIdentifiers stdScheme, BasicProduct2 product)
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

	private static boolean extractPrices(String[] fieldData, Set<PriceTypes> stdTypes, BasicProduct2 product)
	{
		List<Price> prices = product.findPrices(stdTypes);
		int pos = 0;
		for (Price price : prices)
		{
			fieldData[pos + 0] = price.priceType.name();
			fieldData[pos + 1] = price.priceAmount;
			fieldData[pos + 2] = price.currencyCode.name();
			pos += 3;
			if (pos >= fieldData.length)
				break;
		}
		return pos > 0;
	}

	private static boolean extractSalesRights(String[] fieldData, Set<SalesRightsTypes> stdTypes, BasicProduct2 product)
	{
		List<SalesRights> salesRightss = product.findSalesRightss(stdTypes);
		int pos = 0;
		for (SalesRights salesRights : salesRightss)
		{
			StringBuffer sb = new StringBuffer();
			if (salesRights.rightsTerritory != null)
				sb.append(salesRights.rightsTerritory).append("#");
			sb.append("|");
			if (salesRights.rightsCountries != null)
				for (Set<CountryCodeIso31661s> cc : salesRights.rightsCountries)
					sb.append(cc).append(";");
			sb.append("|");
			if (salesRights.rightsRegions != null)
				for (RightsRegions rr : salesRights.rightsRegions)
					sb.append(rr.name()).append(",");
			fieldData[0] = sb.toString(); // .toUpperCase();
			if (++pos == fieldData.length)
				break;
		}
		return pos > 0;
	}

	private static boolean extractOtherText(String[] fieldData, OtherTextTypes stdType, BasicProduct2 product)
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

	private static final Set<PriceTypes> RECOMMENDED_RETAIL_PRICES = new HashSet<>(Arrays.asList(new PriceTypes[] {
			PriceTypes.RRP_including_tax, PriceTypes.RRP_excluding_tax }));

	private static final Set<SalesRightsTypes> NO_SALES_RIGHTS = new HashSet<>(
			Arrays.asList(new SalesRightsTypes[] {
					SalesRightsTypes.Not_for_sale_in_the_specified_countries_or_territories_reason_unspecified,
					SalesRightsTypes.Not_for_sale_in_the_specified_countries_but_publisher_holds_exclusive_rights_in_those_countries_or_territories,
					SalesRightsTypes.Not_for_sale_in_the_specified_countries_publisher_holds_non_exclusive_rights_in_those_countries_or_territories,
					SalesRightsTypes.Not_for_sale_in_the_specified_countries_because_publisher_does_not_hold_rights_in_those_countries_or_territories }));

	private static final Set<SalesRightsTypes> UNRESTRICTED_SALES_RIGHTS = new HashSet<>(
			Arrays.asList(new SalesRightsTypes[] {
					SalesRightsTypes.For_sale_with_exclusive_rights_in_the_specified_countries_or_territories,
					SalesRightsTypes.For_sale_with_non_exclusive_rights_in_the_specified_countries_or_territories,
					SalesRightsTypes.For_sale_with_exclusive_rights_in_the_specified_countries_or_territories_sales_restriction_applies,
					SalesRightsTypes.For_sale_with_non_exclusive_rights_in_the_specified_countries_or_territories_sales_restriction_applies }));
}
