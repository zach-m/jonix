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
 * marker interface to assist in IDE navigation to code-list 50 (Measure unit)
 */
interface CodeList50 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 50</b>
 * <p>
 * Description: Measure unit
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href="https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_45.html#codelist50">ONIX
 * Codelist 50 in Reference Guide</a>
 */
public enum MeasureUnits implements OnixCodelist, CodeList50 {
    /**
     * Millimeters are the preferred metric unit of length
     */
    Centimeters("cm", "Centimeters"), //

    Grams("gr", "Grams"), //

    Inches_US("in", "Inches (US)"), //

    /**
     * Grams are the preferred metric unit of weight
     */
    Kilograms("kg", "Kilograms"), //

    Pounds_US("lb", "Pounds (US)"), //

    Millimeters("mm", "Millimeters"), //

    Ounces_US("oz", "Ounces (US)"), //

    Pixels("px", "Pixels");

    public final String code;
    public final String description;

    MeasureUnits(String code, String description) {
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

    private static volatile Map<String, MeasureUnits> map;

    private static Map<String, MeasureUnits> map() {
        Map<String, MeasureUnits> result = map;
        if (result == null) {
            synchronized (MeasureUnits.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (MeasureUnits e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static MeasureUnits byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }
}
