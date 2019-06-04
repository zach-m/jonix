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

package com.tectonica.jonix.common.codelist;

import com.tectonica.jonix.common.OnixCodelist;

import java.util.HashMap;
import java.util.Map;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * marker interface to assist in IDE navigation to code-list 45 (Publishing role)
 */
interface CodeList45 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 45</b>
 * <p>
 * Description: Publishing role
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href="https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_45.html#codelist45">ONIX
 * Codelist 45 in Reference Guide</a>
 */
public enum PublishingRoles implements OnixCodelist, CodeList45 {
    Publisher("01", "Publisher"), //

    /**
     * Use where two or more publishers co-publish the exact same product, either under a single ISBN (in which case
     * both publishers are co-publishers), or under different ISBNs (in which case the publisher of THIS ISBN is the
     * publisher and the publishers of OTHER ISBNs are co-publishers. Note this is different from publication of
     * 'co-editions'
     */
    Co_publisher("02", "Co-publisher"), //

    Sponsor("03", "Sponsor"), //

    /**
     * Of a translated work
     */
    Publisher_of_original_language_version("04", "Publisher of original-language version"), //

    Host_distributor_of_electronic_content("05", "Host/distributor of electronic content"), //

    Published_for_on_behalf_of("06", "Published for/on behalf of"), //

    /**
     * Use also for 'Published in cooperation with'
     */
    Published_in_association_with("07", "Published in association with"), //

    /**
     * DEPRECATED: use code 06
     */
    Published_on_behalf_of("08", "Published on behalf of"), //

    /**
     * When ownership of a product or title is transferred from one publisher to another
     */
    New_or_acquiring_publisher("09", "New or acquiring publisher"), //

    /**
     * The group to which a publisher (publishing role 01) belongs: use only if a publisher has been identified with
     * role code 01
     */
    Publishing_group("10", "Publishing group"), //

    /**
     * The publisher of the edition of which a product is a facsimile
     */
    Publisher_of_facsimile_original("11", "Publisher of facsimile original"), //

    /**
     * The repackager of a prebound edition that has been assigned its own identifier. (In the US, a 'prebound edition'
     * is a book that was previously bound, normally as a paperback, and has been rebound with a library-quality
     * hardcover binding by a supplier other than the original publisher.) Required when the &lt;EditionType&gt; is
     * coded PRB. The original publisher should be named as the 'publisher'
     */
    Repackager_of_prebound_edition("12", "Repackager of prebound edition"), //

    /**
     * When ownership of a product or title is transferred from one publisher to another (complement of code 09)
     */
    Former_publisher("13", "Former publisher"), //

    /**
     * Body funding publication fees, if different from the body funding the underlying research. Intended primarily for
     * use with open access publications
     */
    Publication_funder("14", "Publication funder"), //

    /**
     * Body funding the research on which publication is based, if different from the body funding the publication.
     * Intended primarily for use with open access publications
     */
    Research_funder("15", "Research funder"), //

    /**
     * Body funding research and publication. Intended primarily for use with open access publications
     */
    Funding_body("16", "Funding body"), //

    /**
     * Organisation responsible for printing a printed product. Supplied primarily to meet legal deposit requirements,
     * and may apply only to the first impression. The organisation may also be responsible for binding, when a separate
     * binder is not specified
     */
    Printer("17", "Printer"), //

    /**
     * Organisation responsible for binding a printed product (where distinct from the printer). Supplied primarily to
     * meet legal deposit requirements, and may apply only to the first impression
     */
    Binder("18", "Binder"), //

    /**
     * Organisation primarily responsible for physical manufacture of a product, when neither Printer nor Binder is
     * directly appropriate (for example, with disc or tape products, or digital products on a physical carrier)
     */
    Manufacturer("19", "Manufacturer");

    public final String code;
    public final String description;

    PublishingRoles(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getDescription() {
        return description;
    }

    private static volatile Map<String, PublishingRoles> map;

    private static Map<String, PublishingRoles> map() {
        Map<String, PublishingRoles> result = map;
        if (result == null) {
            synchronized (PublishingRoles.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (PublishingRoles e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static PublishingRoles byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }
}
