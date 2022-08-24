/*
 * Copyright (C) 2012-2022 Zach Melamed
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

import com.tectonica.jonix.common.codelist.ContributorRoles;
import com.tectonica.jonix.common.codelist.Countrys;
import com.tectonica.jonix.common.codelist.LanguageRoles;
import com.tectonica.jonix.common.codelist.PriceTypes;
import com.tectonica.jonix.common.codelist.ProductIdentifierTypes;
import com.tectonica.jonix.common.codelist.RightsRegions;
import com.tectonica.jonix.common.codelist.SalesRightsTypes;
import com.tectonica.jonix.common.codelist.SubjectSchemeIdentifiers;
import com.tectonica.jonix.common.codelist.TextTypes;
import com.tectonica.jonix.common.codelist.TitleTypes;
import com.tectonica.jonix.common.struct.JonixLanguage;
import com.tectonica.jonix.common.struct.JonixProductIdentifier;
import com.tectonica.jonix.tabulate.FieldTabulatorFactory;
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

public class BaseFieldTabulator {

    // CHECKSTYLE:OFF
    public static final Set<PriceTypes> RECOMMENDED_RETAIL_PRICES = new HashSet<>(Arrays.asList(
        PriceTypes.RRP_including_tax,
        PriceTypes.RRP_excluding_tax
    ));

    public static final Set<SalesRightsTypes> NO_SALES_RIGHTS = new HashSet<>(Arrays.asList(
        SalesRightsTypes.Not_for_sale_in_the_specified_countries_or_territories_reason_unspecified,
        SalesRightsTypes.Not_for_sale_in_the_specified_countries_but_publisher_holds_exclusive_rights_in_those_countries_or_territories,
        SalesRightsTypes.Not_for_sale_in_the_specified_countries_publisher_holds_non_exclusive_rights_in_those_countries_or_territories,
        SalesRightsTypes.Not_for_sale_in_the_specified_countries_because_publisher_does_not_hold_rights_in_those_countries_or_territories
    ));

    public static final Set<SalesRightsTypes> UNRESTRICTED_SALES_RIGHTS = new HashSet<>(Arrays.asList(
        SalesRightsTypes.For_sale_with_exclusive_rights_in_the_specified_countries_or_territories,
        SalesRightsTypes.For_sale_with_non_exclusive_rights_in_the_specified_countries_or_territories,
        SalesRightsTypes.For_sale_with_exclusive_rights_in_the_specified_countries_or_territories_sales_restriction_applies,
        SalesRightsTypes.For_sale_with_non_exclusive_rights_in_the_specified_countries_or_territories_sales_restriction_applies
    ));
    // CHECKSTYLE:ON

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static final FieldTabulatorFactory.Singular<BaseRecord> ISBN13 =
        new FieldTabulatorFactory.Singular<>("ISBN13",
            (row, record) -> extractProductId(record.product, row, ProductIdentifierTypes.ISBN_13));

    public static final FieldTabulatorFactory.Singular<BaseRecord> Title =
        new FieldTabulatorFactory.Singular<>(Arrays.asList("Title", "Subtitle"),
            (row, record) -> extractTitle(record.product, row, TitleTypes.Distinctive_title_book));

    public static final FieldTabulatorFactory.Singular<BaseRecord> SeriesTitle =
        new FieldTabulatorFactory.Singular<>("SeriesTitle",
            (row, record) -> extractSeriesTitle(record.product, row));

    public static final FieldTabulatorFactory.Plural<BaseRecord> Author =
        new FieldTabulatorFactory.Plural<>("Author",
            (row, record) -> extractContributors(record.product, row, ContributorRoles.By_author));

    public static final FieldTabulatorFactory.Plural<BaseRecord> Editor =
        new FieldTabulatorFactory.Plural<>("Editor",
            (row, record) -> {
                if (!extractContributors(record.product, row, ContributorRoles.Edited_by)) {
                    if (!extractContributors(record.product, row, ContributorRoles.Volume_editor)) {
                        if (!extractContributors(record.product, row, ContributorRoles.Series_edited_by)) {
                            if (!extractContributors(record.product, row, ContributorRoles.Editor_in_chief)) {
                                if (!extractContributors(record.product, row, ContributorRoles.Managing_editor)) {
                                    return extractContributors(record.product, row, ContributorRoles.Guest_editor);
                                }
                            }
                        }
                    }
                }
                return true;
            });

    public static final FieldTabulatorFactory.Singular<BaseRecord> Language =
        new FieldTabulatorFactory.Singular<>("Language",
            (row, record) -> extractLanguage(record.product, row, LanguageRoles.Language_of_text));

    public static final FieldTabulatorFactory.Singular<BaseRecord> NumOfPages =
        new FieldTabulatorFactory.Singular<>("NumOfPages",
            (row, record) -> {
                row.set(0, record.product.description.numberOfPages);
                return true;
            });

    public static final FieldTabulatorFactory.Singular<BaseRecord> Publisher =
        new FieldTabulatorFactory.Singular<>("Publisher",
            (row, record) -> extractPublisher(record.product, row));

    public static final FieldTabulatorFactory.Singular<BaseRecord> PublicationDate =
        new FieldTabulatorFactory.Singular<>("PublicationDate",
            (row, record) -> {
                row.set(0, record.product.publishingDetails.publicationDate);
                return true;
            });

    public static final FieldTabulatorFactory.Singular<BaseRecord> Dewey =
        new FieldTabulatorFactory.Singular<>("Dewey",
            (row, record) -> extractSubjects(record.product, row, SubjectSchemeIdentifiers.Dewey));

    public static final FieldTabulatorFactory.Plural<BaseRecord> BISAC =
        new FieldTabulatorFactory.Plural<>("BISAC",
            (row, record) -> extractSubjects(record.product, row, SubjectSchemeIdentifiers.BISAC_Subject_Heading));

    public static final FieldTabulatorFactory.Plural<BaseRecord> BIC = new FieldTabulatorFactory.Plural<>("BIC",
        (row, record) -> extractSubjects(record.product, row, SubjectSchemeIdentifiers.BIC_subject_category));

    public static final FieldTabulatorFactory.Singular<BaseRecord> Keywords =
        new FieldTabulatorFactory.Singular<>("Keywords",
            (row, record) -> extractSubjects(record.product, row, SubjectSchemeIdentifiers.Keywords));

    public static final FieldTabulatorFactory.Plural<BaseRecord> PriceAmount =
        new FieldTabulatorFactory.Plural<>(Arrays.asList("PriceType", "PriceAmount", "CurrencyCode"),
            (row, record) -> extractPrices(record.product, row, RECOMMENDED_RETAIL_PRICES));

    public static final FieldTabulatorFactory.Plural<BaseRecord> SalesAllowedIn =
        new FieldTabulatorFactory.Plural<>("SalesAllowed",
            (row, record) -> extractSalesRights(record.product, row, UNRESTRICTED_SALES_RIGHTS));

    public static final FieldTabulatorFactory.Plural<BaseRecord> SalesBannedIn =
        new FieldTabulatorFactory.Plural<>("SalesBanned",
            (row, record) -> extractSalesRights(record.product, row, NO_SALES_RIGHTS));

    public static final FieldTabulatorFactory.Singular<BaseRecord> Description =
        new FieldTabulatorFactory.Singular<>(Arrays.asList("Description", "DescriptionFormat"),
            (row, record) -> extractOtherText(record.product, row, TextTypes.Description));

    public static final FieldTabulatorFactory.Singular<BaseRecord> ShortDescription =
        new FieldTabulatorFactory.Singular<>(Arrays.asList("ShortDescription", "ShortDescriptionFormat"),
            (row, record) -> extractOtherText(record.product, row, TextTypes.Short_description_annotation));

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private static boolean extractProductId(BaseProduct product, List<String> row, ProductIdentifierTypes stdType) {
        JonixProductIdentifier prodId = product.info.findJonixProductId(stdType);
        if (prodId != null) {
            row.set(0, prodId.idValue);
            return true;
        }
        return false;
    }

    private static boolean extractTitle(BaseProduct product, List<String> row, TitleTypes stdType) {
        BaseTitle title = product.titles.findTitle(stdType);
        if (title != null) {
            row.set(0, title.titleText);
            row.set(1, title.subtitle);
            return true;
        }
        return false;
    }

    private static boolean extractSeriesTitle(BaseProduct product, List<String> row) {
        if (product.collections.size() > 0) {
            // we take the first (typically the only) series tag listed
            row.set(0, product.collections.get(0).mainTitle);
            return true;
        }
        // NOTE: we should probably drill down to the 'titles' member of the series if 'titleOfSeries' is blank
        return false;
    }

    private static boolean extractLanguage(BaseProduct product, List<String> row, LanguageRoles stdType) {
        JonixLanguage language = product.description.findJonixLanguage(stdType);
        if (language != null) {
            row.set(0, language.languageCode.description);
            return true;
        }
        return false;
    }

    private static boolean extractPublisher(BaseProduct product, List<String> row) {
        if (product.publishers.size() > 0) {
            row.set(0, product.publishers.get(0).publisherName);
            return true;
        }
        // NOTE: maybe we should look at the 'publisherRole' as well?
        return false;
    }

    private static boolean extractPrices(BaseProduct product, List<String> row, Set<PriceTypes> stdTypes) {
        List<BasePrice> prices = product.supplyDetails.findPrices(stdTypes);
        int pos = 0;
        for (BasePrice price : prices) {
            row.set(pos + 0, price.priceType.name());
            row.set(pos + 1, price.priceAmountAsStr);
            row.set(pos + 2, price.currencyCode == null ? null : price.currencyCode.name());
            pos += 3;
            if (pos >= row.size()) {
                break;
            }
        }
        return pos > 0;
    }

    private static boolean extractContributors(BaseProduct product, List<String> row, ContributorRoles stdRole) {
        List<BaseContributor> contributors = product.contributors.findByRole(stdRole);
        int pos = 0;
        for (BaseContributor contributor : contributors) {
            String displayName = contributor.getDisplayName();
            if (displayName == null) {
                continue;
            }
            row.set(pos, displayName);
            if (++pos == row.size()) {
                break;
            }
        }
        return pos > 0;
    }

    private static boolean extractSubjects(BaseProduct product, List<String> row, SubjectSchemeIdentifiers stdScheme) {
        List<BaseSubject> subjects = product.subjects.findSubjects(stdScheme);
        int pos = 0;
        for (BaseSubject subject : subjects) {
            row.set(pos, (subject.subjectCode != null) ? subject.subjectCode : subject.subjectHeadingText);
            if (++pos == row.size()) {
                break;
            }
        }
        return pos > 0;
    }

    private static boolean extractSalesRights(BaseProduct product, List<String> row, Set<SalesRightsTypes> stdTypes) {
        List<BaseSalesRights> salesRightss = product.salesRightss.findSalesRights(stdTypes);
        int pos = 0;
        for (BaseSalesRights salesRights : salesRightss) {
            StringBuilder sb = new StringBuilder();
            if (salesRights.regions != null) {
                sb.append(salesRights.regions).append("#");
            }
            sb.append("|");
            if (salesRights.countries != null) {
                for (Set<Countrys> cc : salesRights.countries) {
                    sb.append(cc).append(";");
                }
            }
            sb.append("|");
            if (salesRights.rightRegions != null) {
                for (RightsRegions rr : salesRights.rightRegions) {
                    sb.append(rr.name()).append(",");
                }
            }
            row.set(0, sb.toString()); // .toUpperCase();
            if (++pos == row.size()) {
                break;
            }
        }
        return pos > 0;
    }

    private static boolean extractOtherText(BaseProduct product, List<String> row, TextTypes stdType) {
        BaseText otherText = product.texts.findText(stdType);
        if (otherText != null) {
            row.set(0, otherText.text);
            if (otherText.textFormat != null) {
                row.set(1, otherText.textFormat.name());
            }
            return true;
        }
        return false;
    }
}
