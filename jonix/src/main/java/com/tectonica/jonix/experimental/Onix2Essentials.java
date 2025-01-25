/*
 * Copyright (C) 2012-2025 Zach Melamed
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

package com.tectonica.jonix.experimental;

import com.tectonica.jonix.common.JPU;
import com.tectonica.jonix.common.codelist.AudienceRangePrecisions;
import com.tectonica.jonix.common.codelist.AudienceRangeQualifiers;
import com.tectonica.jonix.common.codelist.ContributorRoles;
import com.tectonica.jonix.common.codelist.CurrencyCodes;
import com.tectonica.jonix.common.codelist.LanguageRoles;
import com.tectonica.jonix.common.codelist.MeasureTypes;
import com.tectonica.jonix.common.codelist.MeasureUnits;
import com.tectonica.jonix.common.codelist.OtherTextTypes;
import com.tectonica.jonix.common.codelist.PriceTypes;
import com.tectonica.jonix.common.codelist.ProductFormFeatureTypes;
import com.tectonica.jonix.common.codelist.ProductIdentifierTypes;
import com.tectonica.jonix.common.codelist.PublishingRoles;
import com.tectonica.jonix.common.codelist.TextFormats;
import com.tectonica.jonix.common.codelist.TitleTypes;
import com.tectonica.jonix.common.struct.JonixOtherText;
import com.tectonica.jonix.onix2.AudienceRange;
import com.tectonica.jonix.onix2.Contributor;
import com.tectonica.jonix.onix2.ContributorRole;
import com.tectonica.jonix.onix2.Measure;
import com.tectonica.jonix.onix2.OtherText;
import com.tectonica.jonix.onix2.Price;
import com.tectonica.jonix.onix2.Product;
import com.tectonica.jonix.onix2.Publisher;
import com.tectonica.jonix.onix2.Series;
import com.tectonica.jonix.onix2.SupplyDetail;
import com.tectonica.jonix.util.JonixUtil;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class Onix2Essentials implements JonixEssentials {
    private final Product product;

    public Onix2Essentials(Product product) {
        this.product = product;
    }

    @Override
    public String get(TextFields fieldType) {
        switch (fieldType) {
            case Isbn13:
                return getProductIdentifier(ProductIdentifierTypes.ISBN_13);

            case Isbn10:
                return getProductIdentifier(ProductIdentifierTypes.ISBN_10);

            case UPC:
                return getProductIdentifier(ProductIdentifierTypes.UPC);

            case Title:
            case Subtitle:
                return getTitle(TitleTypes.Distinctive_title_book, fieldType == TextFields.Subtitle);

            case TitleInOriginalLanguage:
            case SubtitleInOriginalLanguage:
                return getTitle(TitleTypes.Title_in_original_language,
                    fieldType == TextFields.SubtitleInOriginalLanguage);

            case TitleOfSeries:
            case NumberWithinSeries:
                List<Series> seriess = product.seriess();
                if (!seriess.isEmpty()) {
                    // we pick the first (and normally the only) series tag
                    Series series = seriess.get(0);
                    if (fieldType == TextFields.TitleOfSeries) {
                        return series.titleOfSeries().value;
                    }
                    return series.numberWithinSeries().value;
                }
                return null;

            case Language:
                return product.languages().findAsStruct(LanguageRoles.Language_of_text)
                    .map(s -> s.languageCode.description).orElse(null);

            case Audience:
                // we pick the first audience, as in practice it's very rare to see more than one
                return product.audienceCodes().firstValue().map(s -> s.description).orElse(null);

            case PackQuantity:
                if (!product.supplyDetails().isEmpty()) {
                    return product.supplyDetails().get(0).packQuantity().value;
                }
                return null;

            case Annotation:
                JonixOtherText annotationTag = findOtherText(product, OtherTextTypes.Main_description);
                if (annotationTag == null) {
                    annotationTag = findOtherText(product, OtherTextTypes.Long_description);
                }
                return (annotationTag == null) ? null : annotationTag.text;

            case BackCover:
                JonixOtherText backCoverTag = findOtherText(product, OtherTextTypes.Back_cover_copy);
                return (backCoverTag == null) ? null : backCoverTag.text;

            case BiographicalNote:
                JonixOtherText bioTag = findOtherText(product, OtherTextTypes.Biographical_note);
                return (bioTag == null) ? null : bioTag.text;

            case Endorsement:
                JonixOtherText endorsementTag = findOtherText(product, OtherTextTypes.Unpublished_endorsement);
                return (endorsementTag == null) ? null : endorsementTag.text;

            case NumOfPages:
                return product.numberOfPages().value;

            case ShippingWeightLB:
                List<Measure> weights = product.measures().findAll(MeasureTypes.Unit_weight);
                if (!weights.isEmpty()) {
                    if (weights.get(0).measureUnitCode().value == MeasureUnits.Ounces_US) {
                        Double oz = JPU.convertStringToDouble(weights.get(0).measurement().value);
                        return String.valueOf(oz * 0.0625);
                    } else {
                        return weights.get(0).measurement().value; // presumably, in Pounds_US
                    }
                }
                return null;

            case FontSize:
                return product.productFormFeatures().findAsStruct(ProductFormFeatureTypes.Text_font)
                    .filter(tf -> !tf.productFormFeatureDescriptions.isEmpty())
                    .map(tf -> tf.productFormFeatureDescriptions.get(0))
                    .orElse(null);

            case Publisher:
                Publisher candidatePublisher = null;
                for (Publisher publisher : product.publishers()) {
                    // first we look for the main publisher by its role
                    PublishingRoles role = publisher.publishingRole().value;
                    if (role == PublishingRoles.Publisher) {
                        return publisher.publisherName().value;
                    }
                    if (role == null && candidatePublisher == null) {
                        candidatePublisher = publisher;
                    }
                }
                // if no designated publisher found, we return the first un-designated
                if (candidatePublisher != null) {
                    return candidatePublisher.publisherName().value;
                }
                return null;

            case UsdRetailPriceIncTax:
            case UsdRetailPriceExcTax:
                boolean includingTax = (fieldType == TextFields.UsdRetailPriceIncTax);
                return getRetailPrice(CurrencyCodes.US_Dollar, includingTax);

            default:
                throw new IllegalStateException();
        }
    }

    /**
     * NOTE: never returns a null, only empty lists
     */
    @Override
    public List<String> get(ListFields fieldType) {
        switch (fieldType) {
            case Contributors:
                return getContributors();

            case Authors:
                return getContributors(ContributorRoles.By_author);

            case Editors:
                return getContributors(ContributorRoles.Edited_by);

            case AudienceAgeRange:
                Integer[] ageRange = getAudienceAgeRange();
                return Arrays
                    .asList(ageRange[0] == null ? null : ageRange[0].toString(),
                        ageRange[1] == null ? null : ageRange[1].toString());

            case Measurements:
                List<String> wht = new ArrayList<>();
                List<Measure> widthHeight = product.measures().findAll(MeasureTypes.Width, MeasureTypes.Height);
                if (widthHeight.size() == 2) {
                    String mv0 = widthHeight.get(0).measurement().value;
                    String mv1 = widthHeight.get(1).measurement().value;
                    boolean mv0IsWidth = (widthHeight.get(0).measureTypeCode().value == MeasureTypes.Width);
                    wht.add(mv0IsWidth ? mv0 : mv1);
                    wht.add(mv0IsWidth ? mv1 : mv0);

                    List<Measure> thickness = product.measures().findAll(MeasureTypes.Thickness);
                    if (!thickness.isEmpty()) {
                        wht.add(thickness.get(0).measurement().value);
                    }
                }
                return wht;

            default:
                throw new IllegalStateException();
        }
    }

    private String getRetailPrice(CurrencyCodes currency, boolean includingTax) {
        if (!product.supplyDetails().isEmpty()) {
            SupplyDetail supplyDetail = product.supplyDetails().get(0);
            for (Price price : supplyDetail.prices()) {
                PriceTypes type = price.priceTypeCode().value;
                boolean correctType = (includingTax && type == PriceTypes.RRP_including_tax)
                    || (!includingTax && type == PriceTypes.RRP_excluding_tax);
                if (correctType && (price.currencyCode().value == currency)) {
                    return price.priceAmount().value;
                }
            }
        }
        return null;
    }

    public String getProductIdentifier(ProductIdentifierTypes idType) {
        //return product.productIdentifiers().find(idType).map(pi -> pi.idValue().value).orElse(null);
        return product.productIdentifiers().findAsStruct(idType).map(pi -> pi.idValue).orElse(null);
    }

    private String getTitle(TitleTypes titleType, boolean returnSubtitle) {
        return product.titles().findAsStruct(titleType)
            .map(titleTag -> returnSubtitle ? titleTag.subtitle : titleTag.titleText)
            .orElse(null);
    }

    public List<Contributor> findContributors(ContributorRoles... requestedRoles) {
        List<Contributor> result = new ArrayList<>();

        if (requestedRoles == null || requestedRoles.length == 0) {
            // if no filtering by role is required, we take all contributors and avoid unnecessary search
            // copying is needed so that consequent sorting won't affect the original
            result.addAll(product.contributors());
        } else {
            // we perform a search according to the roles filter
            Set<ContributorRoles> rolesSet = JonixUtil.setOf(requestedRoles);
            for (Contributor contributor : product.contributors()) {
                for (ContributorRole role : contributor.contributorRoles()) {
                    if (rolesSet.contains(role.value)) {
                        result.add(contributor);
                    }
                }
            }
        }

        sortContributuresBySequence(result);

        return result;
    }

    public static void sortContributuresBySequence(List<Contributor> contributors) {
        // run a quick test to see if the list is at all sequenced. If it is, then this loop should really stop after
        // one iteration. The only reason to run a loop (rather than examining the first item) is that we want to
        // support a hybrid, ill-posed sequencing, where only SOME of the items are sequenced
        boolean isSequenced = false;
        for (Contributor contributor : contributors) {
            if (contributor.sequenceNumber().exists()) {
                isSequenced = true;
                break;
            }
        }

        if (!isSequenced) {
            return;
        }

        contributors.sort(Comparator.comparingInt(o -> {
            try {
                return Integer.parseInt(o.sequenceNumber().value);
            } catch (NumberFormatException nfe) {
                return Integer.MAX_VALUE; // i.e. unsequenced items in an hybrid list go to the end
            }
        }));
    }

    public List<String> getContributors(ContributorRoles... requestedRoles) {
        List<String> result = new ArrayList<>();

        for (Contributor c : findContributors(requestedRoles)) {
            String displayName = JonixUtil.contributorDisplayName(c.personName().value, c.keyNames().value,
                c.namesBeforeKey().value, c.personNameInverted().value, c.corporateName().value);
            result.add(displayName);
        }

        return result;
    }

    public static String[] getContributorNameParts(Contributor contributor) {
        String inverted = contributor.personNameInverted().value;
        if (inverted != null) {
            String[] splits = inverted.split(",");
            String[] names = new String[splits.length];
            for (int i = 0; i < splits.length; i++) {
                names[i] = splits[splits.length - 1 - i].trim();
            }
            return names;
        }

        String straight = contributor.personName().value;
        if (straight != null) {
            String[] names = straight.split(" ");
            for (int i = 0; i < names.length; i++) {
                names[i] = names[i].trim();
            }
            return names;
        }

        return new String[0];
    }

    public Integer[] getAudienceAgeRange() {
        Integer[] ageRange = new Integer[] {null, null};
        if (!product.audienceRanges().isEmpty()) {
            AudienceRange audienceRange = product.audienceRanges().get(0);
            AudienceRangeQualifiers qualifier = audienceRange.audienceRangeQualifier().value;
            if (qualifier == AudienceRangeQualifiers.Interest_age_years) {
                List<AudienceRangePrecisions> precisions = audienceRange.audienceRangePrecisions().values();
                List<String> values = audienceRange.audienceRangeValues().values();
                if (precisions.size() != values.size()) {
                    // TODO: invalid ONIX
                } else {
                    for (int i = 0; i < precisions.size(); i++) {
                        Integer value = Integer.valueOf(values.get(i));
                        switch (precisions.get(i)) {
                            case From:
                                ageRange[0] = value;
                                break;

                            case To:
                                ageRange[1] = value;
                                break;

                            case Exact:
                                ageRange[0] = value;
                                ageRange[1] = value;
                                break;

                            default:
                                throw new IllegalStateException();
                        }
                    }
                }
            }
        }
        return ageRange;
    }

    public JonixOtherText findOtherText(Product product, OtherTextTypes textTypeCode) {
        for (OtherText x : product.otherTexts()) {
            if (x.textTypeCode().value == textTypeCode) {
                JonixOtherText jonixOtherText = x.asStruct();
                if ((jonixOtherText.textFormat == null) && (x.text().exists())) {
                    jonixOtherText.textFormat = x.text().textformat;
                    if ((jonixOtherText.textFormat == TextFormats.XHTML)
                        || (jonixOtherText.textFormat == TextFormats.XML)
                        || (jonixOtherText.textFormat == TextFormats.HTML)) {
                        try {
                            jonixOtherText.text = unescape(jonixOtherText.text);
                        } catch (XMLStreamException e) {
                            // ignore
                        }
                    }
                }
                return jonixOtherText;
            }
        }
        return null;
    }

    private static final XMLInputFactory inputFactory;

    static {
        inputFactory = XMLInputFactory.newInstance();

        // no need to validate, or even try to access, the remote DTD file
        inputFactory.setProperty(XMLInputFactory.SUPPORT_DTD, Boolean.FALSE);

        // no need to validate internal entities - this is important because ONIX files are designed to contain HTML
        // sections inside them. these sections may include entities (such as '&nbsp;') that aren't XML-compatible
        inputFactory.setProperty(XMLInputFactory.IS_REPLACING_ENTITY_REFERENCES, false);
    }

    public static String unescape(String escaped) throws XMLStreamException {
        XMLStreamReader reader = inputFactory.createXMLStreamReader(new StringReader("<xml>" + escaped + "</xml>"));
        StringWriter sw = new StringWriter(escaped.length());
        while (reader.hasNext()) {
            reader.next();
            if (reader.hasText()) {
                sw.append(reader.getText());
            }
        }
        return sw.toString();
    }
}
