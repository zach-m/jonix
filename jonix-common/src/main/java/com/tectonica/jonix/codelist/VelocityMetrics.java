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

package com.tectonica.jonix.codelist;

import com.tectonica.jonix.OnixCodelist;

import java.util.HashMap;
import java.util.Map;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * marker interface to assist in IDE navigation to code-list 216 (Velocity metric)
 */
interface CodeList216 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 216</b>
 * <p>
 * Description: Velocity metric
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href="https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_45.html#codelist216">ONIX
 * Codelist 216 in Reference Guide</a>
 */
public enum VelocityMetrics implements OnixCodelist, CodeList216 {
    /**
     * Typically measured over most recent 1 month period
     */
    Mean_daily_sale("01", "Mean daily sale"), //

    /**
     * Typically measured over most recent 1 month period
     */
    Maximum_daily_sale("02", "Maximum daily sale"), //

    /**
     * Typically measured over most recent 1 month period
     */
    Minimum_daily_sale("03", "Minimum daily sale"), //

    /**
     * Typically measured over most recent rolling 12 week period
     */
    Mean_weekly_sale("04", "Mean weekly sale"), //

    /**
     * Typically measured over most recent rolling 12 week period
     */
    Maximum_weekly_sale("05", "Maximum weekly sale"), //

    /**
     * Typically measured over most recent rolling 12 week period
     */
    Minimum_weekly_sale("06", "Minimum weekly sale"), //

    /**
     * Typically measured over most recent rolling 6 month period
     */
    Mean_monthly_sale("07", "Mean monthly sale"), //

    /**
     * Typically measured over the most recent rolling 6 month period
     */
    Maximum_monthly_sale("08", "Maximum monthly sale"), //

    /**
     * Typically measured over the most recent rolling 6 month period
     */
    Minimum_monthly_sale("09", "Minimum monthly sale");

    public final String code;
    public final String description;

    VelocityMetrics(String code, String description) {
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

    private static volatile Map<String, VelocityMetrics> map;

    private static Map<String, VelocityMetrics> map() {
        Map<String, VelocityMetrics> result = map;
        if (result == null) {
            synchronized (VelocityMetrics.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (VelocityMetrics e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static VelocityMetrics byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }
}
