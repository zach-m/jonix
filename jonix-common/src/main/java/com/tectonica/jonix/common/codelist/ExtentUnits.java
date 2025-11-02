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

package com.tectonica.jonix.common.codelist;

import com.tectonica.jonix.common.OnixCodelist;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * marker interface to assist in IDE navigation to code-list 24 (Extent unit)
 */
interface CodeList24 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 24</b>
 * <p>
 * Description: Extent unit
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href="https://ns.editeur.org/onix/en/">ONIX online Codelist browser</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_71.html#codelist24">ONIX
 *      Codelist 24 in Reference Guide</a>
 */
public enum ExtentUnits implements OnixCodelist, CodeList24 {
    /**
     * Unbound sheets or leaves, where 'pages' is not appropriate. For example a count of the individual number of cards
     * in a pack. Only for use in ONIX 3.0 or later. For number of pieces in eg a jigsaw, kit, board game, see
     * &lt;ProductFormFeature&gt; and code 22 from list 79
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Physical_pieces("00", "Physical pieces"),

    /**
     * Approximate number of characters (including spaces) of natural language text. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Characters("01", "Characters"),

    /**
     * Approximate number of words of natural language text
     */
    Words("02", "Words"),

    Pages("03", "Pages"),

    Hours_integer_and_decimals("04", "Hours (integer and decimals)"),

    Minutes_integer_and_decimals("05", "Minutes (integer and decimals)"),

    Seconds_integer_only("06", "Seconds (integer only)"),

    /**
     * Of an audiobook on CD (or a similarly divided selection of audio files). Conventionally, each track is 3-6
     * minutes of running time, and track counts are misleading and inappropriate if the average track duration is
     * significantly more or less than this. Note that track breaks are not necessarily aligned with structural breaks
     * in the text (eg chapter breaks)
     */
    Tracks("11", "Tracks"),

    /**
     * Of an audiobook on multiple Red Book audio CDs. Conventionally, each disc is 60-70 minutes of running time, and
     * disc counts are misleading and inappropriate if the average disc duration is significantly more or less than this
     * (for example if the discs are Yellow Book CDs containing mp3 files). Note that disc breaks are not necessarily
     * aligned with structural breaks in the text (eg chapter breaks). Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Discs("12", "Discs"),

    /**
     * Fill with leading zeroes if any elements are missing
     */
    Hours_HHH("14", "Hours HHH"),

    /**
     * Fill with leading zeroes if any elements are missing
     */
    Hours_and_minutes_HHHMM("15", "Hours and minutes HHHMM"),

    /**
     * Fill with leading zeroes if any elements are missing. If centisecond precision is required, use HHHMMSScc. Only
     * for use in ONIX 3.0 or later
     */
    Hours_minutes_seconds_HHHMMSS("16", "Hours minutes seconds HHHMMSS"),

    Bytes("17", "Bytes"),

    Kbytes("18", "Kbytes"),

    Mbytes("19", "Mbytes"),

    /**
     * Number of chapters (or other similar subdivisions) of the content. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Chapters("31", "Chapters");

    public final String code;
    public final String description;

    ExtentUnits(String code, String description) {
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

    private static volatile Map<String, ExtentUnits> map;

    private static Map<String, ExtentUnits> map() {
        Map<String, ExtentUnits> result = map;
        if (result == null) {
            synchronized (ExtentUnits.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (ExtentUnits e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static ExtentUnits byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }

    public static Optional<ExtentUnits> byCodeOptional(String code) {
        return Optional.ofNullable(byCode(code));
    }

    public static String codeToDesciption(String code) {
        return byCodeOptional(code).map(c -> c.description).orElse(null);
    }
}
