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
 * marker interface to assist in IDE navigation to code-list 198 (Product contact role)
 */
interface CodeList198 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 198</b>
 * <p>
 * Description: Product contact role
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_65.html#codelist198">ONIX
 *      Codelist 198 in Reference Guide</a>
 */
public enum ProductContactRoles implements OnixCodelist, CodeList198 {
    /**
     * For queries and feedback concerning the metadata record itself
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Metadata_contact("00", "Metadata contact"),

    /**
     * Eg for requests for supply of mutable digital files for conversion to other formats
     */
    Accessibility_request_contact("01", "Accessibility request contact"),

    /**
     * Eg for requests relating to interviews, author events
     */
    Promotional_contact("02", "Promotional contact"),

    /**
     * Eg for co-op advertising
     */
    Advertising_contact("03", "Advertising contact"),

    /**
     * Eg for requests for review copies
     */
    Review_copy_contact("04", "Review copy contact"),

    /**
     * Eg for requests for approval or evaluation copies (particularly within education)
     */
    Evaluation_copy_contact("05", "Evaluation copy contact"),

    /**
     * Eg for requests to reproduce or repurpose parts of the publication
     */
    Permissions_contact("06", "Permissions contact"),

    /**
     * Eg for use where authorisation must be gained from the publisher rather than the distributor or wholesaler
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Return_authorisation_contact("07", "Return authorisation contact"),

    /**
     * Eg for legal deposit or long-term preservation
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    CIP_Legal_deposit_contact("08", "CIP / Legal deposit contact"),

    /**
     * Eg for subrights licensing, collective licensing
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Rights_and_licensing_contact("09", "Rights and licensing contact");

    public final String code;
    public final String description;

    ProductContactRoles(String code, String description) {
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

    private static volatile Map<String, ProductContactRoles> map;

    private static Map<String, ProductContactRoles> map() {
        Map<String, ProductContactRoles> result = map;
        if (result == null) {
            synchronized (ProductContactRoles.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (ProductContactRoles e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static ProductContactRoles byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }

    public static Optional<ProductContactRoles> byCodeOptional(String code) {
        return Optional.ofNullable(byCode(code));
    }

    public static String codeToDesciption(String code) {
        return byCodeOptional(code).map(c -> c.description).orElse(null);
    }
}
