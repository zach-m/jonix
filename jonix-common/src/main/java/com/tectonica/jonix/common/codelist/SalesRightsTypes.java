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
 * marker interface to assist in IDE navigation to code-list 46 (Sales rights type)
 */
interface CodeList46 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 46</b>
 * <p>
 * Description: Sales rights type
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_45.html#codelist46">ONIX
 *      Codelist 46 in Reference Guide</a>
 */
public enum SalesRightsTypes implements OnixCodelist, CodeList46 {
    /**
     * May only be used with the ONIX 3 &lt;ROWSalesRightsType&gt; element
     */
    Sales_rights_unknown_or_unstated_for_any_reason("00", "Sales rights unknown or unstated for any reason"), //

    For_sale_with_exclusive_rights_in_the_specified_countries_or_territories("01",
        "For sale with exclusive rights in the specified countries or territories"), //

    For_sale_with_non_exclusive_rights_in_the_specified_countries_or_territories("02",
        "For sale with non-exclusive rights in the specified countries or territories"), //

    Not_for_sale_in_the_specified_countries_or_territories_reason_unspecified("03",
        "Not for sale in the specified countries or territories (reason unspecified)"), //

    Not_for_sale_in_the_specified_countries_but_publisher_holds_exclusive_rights_in_those_countries_or_territories("04",
        "Not for sale in the specified countries (but publisher holds exclusive rights in those countries or territories)"), //

    Not_for_sale_in_the_specified_countries_publisher_holds_non_exclusive_rights_in_those_countries_or_territories("05",
        "Not for sale in the specified countries (publisher holds non-exclusive rights in those countries or territories)"), //

    Not_for_sale_in_the_specified_countries_because_publisher_does_not_hold_rights_in_those_countries_or_territories(
        "06",
        "Not for sale in the specified countries (because publisher does not hold rights in those countries or territories)"), //

    /**
     * Only for use with ONIX 3. Deprecated
     */
    For_sale_with_exclusive_rights_in_the_specified_countries_or_territories_sales_restriction_applies("07",
        "For sale with exclusive rights in the specified countries or territories (sales restriction applies)"), //

    /**
     * Only for use with ONIX 3. Deprecated
     */
    For_sale_with_non_exclusive_rights_in_the_specified_countries_or_territories_sales_restriction_applies("08",
        "For sale with non-exclusive rights in the specified countries or territories (sales restriction applies)");

    public final String code;
    public final String description;

    SalesRightsTypes(String code, String description) {
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

    private static volatile Map<String, SalesRightsTypes> map;

    private static Map<String, SalesRightsTypes> map() {
        Map<String, SalesRightsTypes> result = map;
        if (result == null) {
            synchronized (SalesRightsTypes.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (SalesRightsTypes e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static SalesRightsTypes byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }
}
