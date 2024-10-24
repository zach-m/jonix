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
 * marker interface to assist in IDE navigation to code-list 147 (Unit of usage)
 */
interface CodeList147 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 147</b>
 * <p>
 * Description: Unit of usage
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href="https://ns.editeur.org/onix/en/">ONIX online Codelist browser</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_67.html#codelist147">ONIX
 *      Codelist 147 in Reference Guide</a>
 */
public enum UnitOfUsages implements OnixCodelist, CodeList147 {
    /**
     * Maximum number of copies that may be made of a permitted extract
     */
    Copies("01", "Copies"),

    /**
     * Maximum number of characters in a permitted extract for a specified usage
     */
    Characters("02", "Characters"),

    /**
     * Maximum number of words in a permitted extract for a specified usage
     */
    Words("03", "Words"),

    /**
     * Maximum number of pages in a permitted extract for a specified usage
     */
    Pages("04", "Pages"),

    /**
     * Maximum percentage of total content in a permitted extract for a specified usage
     */
    Percentage("05", "Percentage"),

    /**
     * Maximum number of devices in 'share group'
     */
    Devices("06", "Devices"),

    /**
     * Maximum number of concurrent users. NB where the number of concurrent users is specifically not limited, set the
     * number of concurrent users to zero
     */
    Concurrent_users("07", "Concurrent users"),

    /**
     * Maximum number of licensed individual users, independent of concurrency of use
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Users("15", "Users"),

    /**
     * Maximum number of licensed concurrent classes of user. A 'class' is a group of learners attending a specific
     * course or lesson and generally taught as a group
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Concurrent_classes("19", "Concurrent classes"),

    /**
     * Maximum number of licensed classes of learners, independent of concurrency of use and the number of users per
     * class
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Classes("20", "Classes"),

    /**
     * Maximum number of licensed institutions, independend of concurrency of use and the number of classes or
     * individuals per institution
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Institutions("31", "Institutions"),

    /**
     * Maximum percentage of total content which may be used in a specified usage per time period; the time period being
     * specified as another &lt;EpubUsageLimit&gt; Quantity
     */
    Percentage_per_time_period("08", "Percentage per time period"),

    /**
     * Maximum time period in days (beginning from product purchase or activation)
     */
    Days("09", "Days"),

    /**
     * Maximum time period in weeks
     */
    Weeks("13", "Weeks"),

    /**
     * Maximum time period in months
     */
    Months("14", "Months"),

    /**
     * Maximum amount of time in hours, minutes and seconds allowed in a permitted extract for a specified usage, in the
     * format HHHMMSS (7 digits, with leading zeros if necessary)
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Hours_minutes_and_seconds("16", "Hours minutes and seconds"),

    /**
     * Maximum time period in days (beginning from the product publication date). In effect, this defines a fixed end
     * date for the license independent of the purchase or activation date
     */
    Days_fixed_start("27", "Days (fixed start)"),

    /**
     * Maximum time period in weeks
     */
    Weeks_fixed_start("28", "Weeks (fixed start)"),

    /**
     * Maximum time period in months
     */
    Months_fixed_start("29", "Months (fixed start)"),

    /**
     * Maximum number of times a specified usage event may occur (in the lifetime of the product)
     */
    Times("10", "Times"),

    /**
     * Maximum frequency a specified usage event may occur (per day)
     */
    Times_per_day("22", "Times per day"),

    /**
     * Maximum frequency a specified usage event may occur (per month)
     */
    Times_per_month("23", "Times per month"),

    /**
     * Maximum frequency a specified usage event may occur (per year)
     */
    Times_per_year("24", "Times per year"),

    /**
     * Maximum resolution of printed or copy/pasted extracts
     */
    Dots_per_inch("21", "Dots per inch"),

    /**
     * Maximum resolution of printed or copy/pasted extracts
     */
    Dots_per_cm("26", "Dots per cm"),

    /**
     * Page number where allowed usage begins. &lt;Quantity&gt; should contain an absolute page number, counting the
     * cover as page 1. (This type of page numbering should not be used where the e-publication has no fixed
     * pagination). Use with (max number of) Pages, Percentage of content, or End page to specify pages allowed in
     * Preview
     */
    Allowed_usage_start_page("11", "Allowed usage start page"),

    /**
     * Page number at which allowed usage ends. &lt;Quantity&gt; should contain an absolute page number, counting the
     * cover as page 1. (This type of page numbering should not be used where the e-publication has no fixed
     * pagination). Use with Start page to specify pages allowed in a preview
     */
    Allowed_usage_end_page("12", "Allowed usage end page"),

    /**
     * Time at which allowed usage begins. &lt;Quantity&gt; should contain an absolute time, counting from the beginning
     * of an audio or video product, in the format HHHMMSS or HHHMMSScc. Use with Time, Percentage of content, or End
     * time to specify time-based extract allowed in Preview
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Allowed_usage_start_time("17", "Allowed usage start time"),

    /**
     * Time at which allowed usage ends. &lt;Quantity&gt; should contain an absolute time, counting from the beginning
     * of an audio or video product, in the format HHHMMSS or HHHMMSScc. Use with Start time to specify time-based
     * extract allowed in Preview
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Allowed_usage_end_time("18", "Allowed usage end time"),

    /**
     * The date from which the usage constraint applies. &lt;Quantity&gt; is in the format YYYYMMDD
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Valid_from("98", "Valid from"),

    /**
     * The date until which the usage constraint applies. &lt;Quantity&gt; is in the format YYYYMMDD
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Valid_to("99", "Valid to");

    public final String code;
    public final String description;

    UnitOfUsages(String code, String description) {
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

    private static volatile Map<String, UnitOfUsages> map;

    private static Map<String, UnitOfUsages> map() {
        Map<String, UnitOfUsages> result = map;
        if (result == null) {
            synchronized (UnitOfUsages.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (UnitOfUsages e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static UnitOfUsages byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }

    public static Optional<UnitOfUsages> byCodeOptional(String code) {
        return Optional.ofNullable(byCode(code));
    }

    public static String codeToDesciption(String code) {
        return byCodeOptional(code).map(c -> c.description).orElse(null);
    }
}
