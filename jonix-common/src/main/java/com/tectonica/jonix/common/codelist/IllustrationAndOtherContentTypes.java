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
 * marker interface to assist in IDE navigation to code-list 25 (Illustration and other content type)
 */
interface CodeList25 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 25</b>
 * <p>
 * Description: Illustration and other content type
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href="https://ns.editeur.org/onix/en/">ONIX online Codelist browser</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_69.html#codelist25">ONIX
 *      Codelist 25 in Reference Guide</a>
 */
public enum IllustrationAndOtherContentTypes implements OnixCodelist, CodeList25 {
    /**
     * See description in the &lt;AncillaryContentDescription&gt; element
     */
    Unspecified_see_description("00", "Unspecified, see description"),

    Illustrations_black_and_white("01", "Illustrations, black and white"),

    Illustrations_color("02", "Illustrations, color"),

    /**
     * Including black and white photographs
     */
    Halftones_black_and_white("03", "Halftones, black and white"),

    /**
     * Including color photographs
     */
    Halftones_color("04", "Halftones, color"),

    Line_drawings_black_and_white("05", "Line drawings, black and white"),

    Line_drawings_color("06", "Line drawings, color"),

    Tables_black_and_white("07", "Tables, black and white"),

    Tables_color("08", "Tables, color"),

    Illustrations_unspecified("09", "Illustrations, unspecified"),

    /**
     * Including photographs
     */
    Halftones_unspecified("10", "Halftones, unspecified"),

    Tables_unspecified("11", "Tables, unspecified"),

    Line_drawings_unspecified("12", "Line drawings, unspecified"),

    Halftones_duotone("13", "Halftones, duotone"),

    Maps("14", "Maps"),

    Frontispiece("15", "Frontispiece"),

    Diagrams("16", "Diagrams"),

    Figures("17", "Figures"),

    Charts("18", "Charts"),

    /**
     * Recorded music extracts or examples, or complete recorded work(s), accompanying textual or other content
     */
    Recorded_music_items("19", "Recorded music items"),

    /**
     * Printed music extracts or examples, or complete music score(s), accompanying textual or other content
     */
    Printed_music_items("20", "Printed music items"),

    /**
     * To be used in the mathematical sense of a diagram that represents numerical values plotted against an origin and
     * axes, cf codes 16 and 18
     */
    Graphs("21", "Graphs"),

    /**
     * 'Plates' means illustrations that are on separate pages bound into the body of a book
     */
    Plates_unspecified("22", "Plates, unspecified"),

    /**
     * 'Plates' means illustrations that are on separate pages bound into the body of a book
     */
    Plates_black_and_white("23", "Plates, black and white"),

    /**
     * 'Plates' means illustrations that are on separate pages bound into the body of a book
     */
    Plates_color("24", "Plates, color"),

    Index("25", "Index"),

    Bibliography("26", "Bibliography"),

    /**
     * Larger-scale inset maps of places or features of interest included in a map product
     */
    Inset_maps("27", "Inset maps"),

    /**
     * GPS grids included in a map product
     */
    GPS_grids("28", "GPS grids"),

    Glossary("29", "Glossary"),

    /**
     * Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Table_of_contents("30", "Table of contents"),

    /**
     * Geographical index. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Gazetteer("31", "Gazetteer");

    public final String code;
    public final String description;

    IllustrationAndOtherContentTypes(String code, String description) {
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

    private static volatile Map<String, IllustrationAndOtherContentTypes> map;

    private static Map<String, IllustrationAndOtherContentTypes> map() {
        Map<String, IllustrationAndOtherContentTypes> result = map;
        if (result == null) {
            synchronized (IllustrationAndOtherContentTypes.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (IllustrationAndOtherContentTypes e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static IllustrationAndOtherContentTypes byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }

    public static Optional<IllustrationAndOtherContentTypes> byCodeOptional(String code) {
        return Optional.ofNullable(byCode(code));
    }

    public static String codeToDesciption(String code) {
        return byCodeOptional(code).map(c -> c.description).orElse(null);
    }
}
