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

package com.tectonica.jonix.unify;

import com.tectonica.jonix.codelist.ContributorRoles;
import com.tectonica.jonix.codelist.CountryCodes;
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
import com.tectonica.jonix.unify.base.BaseContributor;
import com.tectonica.jonix.unify.base.BasePrice;
import com.tectonica.jonix.unify.base.BaseProduct;
import com.tectonica.jonix.unify.base.BaseSalesRights;
import com.tectonica.jonix.unify.base.BaseSubject;
import com.tectonica.jonix.unify.base.BaseText;
import com.tectonica.jonix.unify.base.BaseTitle;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A base class for all the {@link JonixColumn}s provided by the 'basic' suite of classes. Deriving from it are the
 * columns themselves - {@link #ISBN13}, {@link #Author}, etc. - all intended to be presented in a tabular format.
 *
 * @author Zach Melamed
 */
public abstract class BaseColumn implements JonixColumn<BaseProduct> {
    protected final int repetition;
    protected final String[] subColumnNames;

    @Override
    public int getRepetitions() {
        return repetition;
    }

    @Override
    public String[] getSubColumnNames() {
        return subColumnNames;
    }

    protected BaseColumn(String[] subColumnNames, int repetition) {
        this.subColumnNames = subColumnNames;
        this.repetition = repetition;
    }

    protected BaseColumn(String columnName, int repetition) {
        this(new String[] {columnName}, repetition);
    }

    // //////////////////////////////////////////////////////////////////////////////////////////////

    public static BaseColumn ISBN13 = new BaseColumn("ISBN13", 1) {
        @Override
        public boolean extractFrom(BaseProduct product, String[] columnBuffer) {
            return extractProductId(product, columnBuffer, ProductIdentifierTypes.ISBN_13);
        }
    };

    public static BaseColumn Title = new BaseColumn(new String[] {"Title", "Subtitle"}, 1) {
        @Override
        public boolean extractFrom(BaseProduct product, String[] columnBuffer) {
            return extractTitle(product, columnBuffer, TitleTypes.Distinctive_title_book);
        }
    };

    public static BaseColumn SeriesTitle = new BaseColumn("SeriesTitle", 1) {
        @Override
        public boolean extractFrom(BaseProduct product, String[] columnBuffer) {
            return extractSeriesTitle(product, columnBuffer);
        }
    };

    public static BaseColumn Author = new BaseColumn("Author", 3) {
        @Override
        public boolean extractFrom(BaseProduct product, String[] columnBuffer) {
            return extractContributors(product, columnBuffer, ContributorRoles.By_author);
        }
    };

    public static BaseColumn Editor = new BaseColumn("Editor", 2) {
        @Override
        public boolean extractFrom(BaseProduct product, String[] columnBuffer) {
            if (!extractContributors(product, columnBuffer, ContributorRoles.Edited_by)) {
                if (!extractContributors(product, columnBuffer, ContributorRoles.Volume_editor)) {
                    if (!extractContributors(product, columnBuffer, ContributorRoles.Series_edited_by)) {
                        if (!extractContributors(product, columnBuffer, ContributorRoles.Editor_in_chief)) {
                            if (!extractContributors(product, columnBuffer, ContributorRoles.Managing_editor)) {
                                return extractContributors(product, columnBuffer, ContributorRoles.Guest_editor);
                            }
                        }
                    }
                }
            }
            return true;
        }
    };

    public static BaseColumn Language = new BaseColumn("Language", 1) {
        @Override
        public boolean extractFrom(BaseProduct product, String[] columnBuffer) {
            return extractLanguage(product, columnBuffer, LanguageRoles.Language_of_text);
        }
    };

    public static BaseColumn NumOfPages = new BaseColumn("NumOfPages", 1) {
        @Override
        public boolean extractFrom(BaseProduct product, String[] columnBuffer) {
            columnBuffer[0] = product.description.numberOfPages;
            return true;
        }
    };

    public static BaseColumn Publisher = new BaseColumn("Publisher", 1) {
        @Override
        public boolean extractFrom(BaseProduct product, String[] columnBuffer) {
            return extractPublisher(product, columnBuffer);
        }
    };

    public static BaseColumn PublicationDate = new BaseColumn("PublicationDate", 1) {
        @Override
        public boolean extractFrom(BaseProduct product, String[] columnBuffer) {
            columnBuffer[0] = product.publishingDetails.publicationDate;
            return true;
        }
    };

    public static BaseColumn Dewey = new BaseColumn("Dewey", 1) {
        @Override
        public boolean extractFrom(BaseProduct product, String[] columnBuffer) {
            return extractSubjects(product, columnBuffer, SubjectSchemeIdentifiers.Dewey);
        }
    };

    public static BaseColumn BISAC = new BaseColumn("BISAC", 5) {
        @Override
        public boolean extractFrom(BaseProduct product, String[] columnBuffer) {
            return extractSubjects(product, columnBuffer, SubjectSchemeIdentifiers.BISAC_Subject_Heading);
        }
    };

    public static BaseColumn BIC = new BaseColumn("BIC", 5) {
        @Override
        public boolean extractFrom(BaseProduct product, String[] columnBuffer) {
            return extractSubjects(product, columnBuffer, SubjectSchemeIdentifiers.BIC_subject_category);
        }
    };

    public static BaseColumn Keywords = new BaseColumn("Keywords", 1) {
        @Override
        public boolean extractFrom(BaseProduct product, String[] columnBuffer) {
            return extractSubjects(product, columnBuffer, SubjectSchemeIdentifiers.Keywords);
        }
    };

    public static BaseColumn PriceAmount = new BaseColumn(
        new String[] {"PriceType", "PriceAmount", "CurrencyCode"}, 3) {
        @Override
        public boolean extractFrom(BaseProduct product, String[] columnBuffer) {
            return extractPrices(product, columnBuffer, RECOMMENDED_RETAIL_PRICES);
        }
    };

    public static BaseColumn SalesAllowedIn = new BaseColumn("SalesAllowed", 3) {
        @Override
        public boolean extractFrom(BaseProduct product, String[] columnBuffer) {
            return extractSalesRights(product, columnBuffer, UNRESTRICTED_SALES_RIGHTS);
        }
    };

    public static BaseColumn SalesBannedIn = new BaseColumn("SalesBanned", 3) {
        @Override
        public boolean extractFrom(BaseProduct product, String[] columnBuffer) {
            return extractSalesRights(product, columnBuffer, NO_SALES_RIGHTS);
        }
    };

    public static BaseColumn Description = new BaseColumn(new String[] {"Description", "DescriptionFormat"}, 1) {
        @Override
        public boolean extractFrom(BaseProduct product, String[] columnBuffer) {
            return extractOtherText(product, columnBuffer, TextTypes.Description);
        }
    };

    public static BaseColumn ShortDescription = new BaseColumn(new String[] {"ShortDescription",
        "ShortDescriptionFormat"}, 1) {
        @Override
        public boolean extractFrom(BaseProduct product, String[] columnBuffer) {
            return extractOtherText(product, columnBuffer, TextTypes.Short_description_annotation);
        }
    };

    // //////////////////////////////////////////////////////////////////////////////////////////////

    private static boolean extractProductId(BaseProduct product, String[] columnBuffer,
                                            ProductIdentifierTypes stdType) {
        JonixProductIdentifier prodId = product.info.findJonixProductId(stdType);
        if (prodId != null) {
            columnBuffer[0] = prodId.idValue;
            return true;
        }
        return false;
    }

    private static boolean extractTitle(BaseProduct product, String[] columnBuffer,
                                        TitleTypes stdType) {
        BaseTitle title = product.titles.findTitle(stdType);
        if (title != null) {
            columnBuffer[0] = title.titleText;
            columnBuffer[1] = title.subtitle;
            return true;
        }
        return false;
    }

    private static boolean extractSeriesTitle(BaseProduct product, String[] columnBuffer) {
        if (product.collections.size() > 0) {
            // we take the first (typically the only) series tag listed
            columnBuffer[0] = product.collections.get(0).mainTitle;
            return true;
        }
        // NOTE: we should probably drill down to the 'titles' member of the series if 'titleOfSeries' is blank
        return false;
    }

    private static boolean extractLanguage(BaseProduct product, String[] columnBuffer,
                                           LanguageRoles stdType) {
        JonixLanguage language = product.description.findJonixLanguage(stdType);
        if (language != null) {
            columnBuffer[0] = language.languageCode.description;
            return true;
        }
        return false;
    }

    private static boolean extractPublisher(BaseProduct product, String[] columnBuffer) {
        if (product.publishers.size() > 0) {
            columnBuffer[0] = product.publishers.get(0).publisherName;
            return true;
        }
        // NOTE: maybe we should look at the 'publisherRole' as well?
        return false;
    }

    private static boolean extractPrices(BaseProduct product, String[] columnBuffer,
                                         Set<PriceTypes> stdTypes) {
        List<BasePrice> prices = product.supplyDetails.findPrices(stdTypes);
        int pos = 0;
        for (BasePrice price : prices) {
            columnBuffer[pos + 0] = price.priceType.name();
            columnBuffer[pos + 1] = price.priceAmountAsStr;
            columnBuffer[pos + 2] = price.currencyCode.name();
            pos += 3;
            if (pos >= columnBuffer.length) {
                break;
            }
        }
        return pos > 0;
    }

    private static boolean extractContributors(BaseProduct product, String[] columnBuffer,
                                               ContributorRoles stdRole) {
        List<BaseContributor> contributors = product.contributors.findByRole(stdRole);
        int pos = 0;
        for (BaseContributor contributor : contributors) {
            String displayName = contributor.getDisplayName();
            if (displayName == null) {
                continue;
            }
            columnBuffer[pos] = displayName;
            if (++pos == columnBuffer.length) {
                break;
            }
        }
        return pos > 0;
    }

    private static boolean extractSubjects(BaseProduct product, String[] columnBuffer,
                                           SubjectSchemeIdentifiers stdScheme) {
        List<BaseSubject> subjects = product.subjects.findSubjects(stdScheme);
        int pos = 0;
        for (BaseSubject subject : subjects) {
            columnBuffer[pos] = (subject.subjectCode != null) ? subject.subjectCode : subject.subjectHeadingText;
            if (++pos == columnBuffer.length) {
                break;
            }
        }
        return pos > 0;
    }

    private static boolean extractSalesRights(BaseProduct product, String[] columnBuffer,
                                              Set<SalesRightsTypes> stdTypes) {
        List<BaseSalesRights> salesRightss = product.salesRightss.findSalesRights(stdTypes);
        int pos = 0;
        for (BaseSalesRights salesRights : salesRightss) {
            StringBuffer sb = new StringBuffer();
            if (salesRights.regions != null) {
                sb.append(salesRights.regions).append("#");
            }
            sb.append("|");
            if (salesRights.countries != null) {
                for (Set<CountryCodes> cc : salesRights.countries) {
                    sb.append(cc).append(";");
                }
            }
            sb.append("|");
            if (salesRights.rightRegions != null) {
                for (RightsRegions rr : salesRights.rightRegions) {
                    sb.append(rr.name()).append(",");
                }
            }
            columnBuffer[0] = sb.toString(); // .toUpperCase();
            if (++pos == columnBuffer.length) {
                break;
            }
        }
        return pos > 0;
    }

    private static boolean extractOtherText(BaseProduct product, String[] columnBuffer,
                                            TextTypes stdType) {
        BaseText otherText = product.texts.findText(stdType);
        if (otherText != null) {
            columnBuffer[0] = otherText.text;
            if (otherText.textFormat != null) {
                columnBuffer[1] = otherText.textFormat.name();
            }
            return true;
        }
        return false;
    }

    // //////////////////////////////////////////////////////////////////////////////////////////////

    public static final BaseColumn[] ALL_COLUMNS = {BaseColumn.ISBN13, //
        BaseColumn.Title, //
        BaseColumn.SeriesTitle, //
        BaseColumn.Author, //
        BaseColumn.Editor, //
        BaseColumn.Language, //
        BaseColumn.NumOfPages, //
        BaseColumn.Publisher, //
        BaseColumn.PublicationDate, //
        BaseColumn.Dewey, //
        BaseColumn.BISAC, //
        BaseColumn.BIC, //
        BaseColumn.Keywords, //
        BaseColumn.PriceAmount, //
        BaseColumn.SalesAllowedIn, //
        BaseColumn.SalesBannedIn, //
        BaseColumn.Description, //
        BaseColumn.ShortDescription //
    };

    protected static final Set<PriceTypes> RECOMMENDED_RETAIL_PRICES = new HashSet<>(Arrays.asList(
        PriceTypes.RRP_including_tax,
        PriceTypes.RRP_excluding_tax
    ));

    // CHECKSTYLE:OFF
    protected static final Set<SalesRightsTypes> NO_SALES_RIGHTS = new HashSet<>(Arrays.asList(
        SalesRightsTypes.Not_for_sale_in_the_specified_countries_or_territories_reason_unspecified,
        SalesRightsTypes.Not_for_sale_in_the_specified_countries_but_publisher_holds_exclusive_rights_in_those_countries_or_territories,
        SalesRightsTypes.Not_for_sale_in_the_specified_countries_publisher_holds_non_exclusive_rights_in_those_countries_or_territories,
        SalesRightsTypes.Not_for_sale_in_the_specified_countries_because_publisher_does_not_hold_rights_in_those_countries_or_territories
    ));

    protected static final Set<SalesRightsTypes> UNRESTRICTED_SALES_RIGHTS = new HashSet<>(Arrays.asList(
        SalesRightsTypes.For_sale_with_exclusive_rights_in_the_specified_countries_or_territories,
        SalesRightsTypes.For_sale_with_non_exclusive_rights_in_the_specified_countries_or_territories,
        SalesRightsTypes.For_sale_with_exclusive_rights_in_the_specified_countries_or_territories_sales_restriction_applies,
        SalesRightsTypes.For_sale_with_non_exclusive_rights_in_the_specified_countries_or_territories_sales_restriction_applies
    ));
    // CHECKSTYLE:ON
}
