/*
 * Copyright (C) 2012-2024 Zach Melamed
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
import java.util.Optional;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * marker interface to assist in IDE navigation to code-list 3 (Record source type)
 */
interface CodeList3 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 3</b>
 * <p>
 * Description: Record source type
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_64.html#codelist3">ONIX
 *      Codelist 3 in Reference Guide</a>
 */
public enum RecordSourceTypes implements OnixCodelist, CodeList3 {
    Unspecified("00", "Unspecified"),

    Publisher("01", "Publisher"),

    /**
     * Use to designate a distributor providing primary warehousing and fulfillment for a publisher or for a publisher's
     * sales agent, as distinct from a wholesaler
     */
    Publishers_distributor("02", "Publisher’s distributor"),

    Wholesaler("03", "Wholesaler"),

    /**
     * Bibliographic data aggregator
     */
    Bibliographic_agency("04", "Bibliographic agency"),

    /**
     * Library supplier. Bookseller selling to libraries (including academic libraries)
     */
    Library_bookseller("05", "Library bookseller"),

    /**
     * Use for a publisher's sales agent responsible for marketing the publisher's products within a territory, as
     * opposed to a publisher's distributor who fulfills orders but does not market
     */
    Publishers_sales_agent("06", "Publisher’s sales agent"),

    /**
     * Downstream provider of e-publication format conversion services (who might also be a distributor or retailer of
     * the converted e-publication), supplying metadata on behalf of the publisher. The assigned ISBN is taken from the
     * publisher's ISBN prefix
     */
    Publishers_conversion_service_provider("07", "Publisher’s conversion service provider"),

    /**
     * Downstream provider of e-publication format conversion services (who might also be a distributor or retailer of
     * the converted e-publication), supplying metadata on behalf of the publisher. The assigned ISBN is taken from the
     * service provider's prefix (whether or not the service provider dedicates that prefix to a particular publisher)
     */
    Conversion_service_provider("08", "Conversion service provider"),

    ISBN_Registration_Agency("09", "ISBN Registration Agency"),

    ISTC_Registration_Agency("10", "ISTC Registration Agency"),

    /**
     * Bookseller selling primarily to consumers
     */
    Retail_bookseller("11", "Retail bookseller"),

    /**
     * Bookseller selling primarily to educational institutions
     */
    Education_bookseller("12", "Education bookseller"),

    /**
     * Library service providing enhanced metadata to publishers or other parties
     */
    Library("13", "Library");

    public final String code;
    public final String description;

    RecordSourceTypes(String code, String description) {
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

    private static volatile Map<String, RecordSourceTypes> map;

    private static Map<String, RecordSourceTypes> map() {
        Map<String, RecordSourceTypes> result = map;
        if (result == null) {
            synchronized (RecordSourceTypes.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (RecordSourceTypes e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static RecordSourceTypes byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }

    public static Optional<RecordSourceTypes> byCodeOptional(String code) {
        return Optional.ofNullable(byCode(code));
    }

    public static String codeToDesciption(String code) {
        return byCodeOptional(code).map(c -> c.description).orElse(null);
    }
}
