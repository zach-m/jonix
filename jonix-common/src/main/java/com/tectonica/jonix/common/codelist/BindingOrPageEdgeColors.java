/*
 * Copyright (C) 2012-2023 Zach Melamed
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
 * marker interface to assist in IDE navigation to code-list 98 (Binding or page edge color)
 */
interface CodeList98 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 98</b>
 * <p>
 * Description: Binding or page edge color
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_62.html#codelist98">ONIX
 *      Codelist 98 in Reference Guide</a>
 */
public enum BindingOrPageEdgeColors implements OnixCodelist, CodeList98 {
    Black("BLK", "Black"),

    Blue("BLU", "Blue"),

    Brown("BRN", "Brown"),

    Burgundy_Maroon("BUR", "Burgundy/Maroon"),

    /**
     * Only for use in ONIX 3.0 or later
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Celadon_Pale_green("CEL", "Celadon/Pale green"),

    /**
     * Only for use in ONIX 3.0 or later
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Copper("CPR", "Copper"),

    Cream("CRE", "Cream"),

    /**
     * Use &lt;ProductFormFeatureDescription&gt; to add brief details if required
     */
    Four_color("FCO", "Four-color"),

    /**
     * Use &lt;ProductFormFeatureDescription&gt; to add brief details if required
     */
    Four_color_and_spot_color("FCS", "Four-color and spot-color"),

    Gold("GLD", "Gold"),

    Green("GRN", "Green"),

    Grey("GRY", "Grey"),

    /**
     * Use &lt;ProductFormFeatureDescription&gt; to add brief details if required
     */
    Multicolor("MUL", "Multicolor"),

    Navy_Dark_blue("NAV", "Navy/Dark blue"),

    Orange("ORG", "Orange"),

    Pink("PNK", "Pink"),

    Purple("PUR", "Purple"),

    Red("RED", "Red"),

    Sky_Pale_blue("SKY", "Sky/Pale blue"),

    Silver("SLV", "Silver"),

    Tan_Light_brown("TAN", "Tan/Light brown"),

    Teal_Turquoise_green("TEA", "Teal/Turquoise green"),

    White("WHI", "White"),

    Yellow("YEL", "Yellow"),

    /**
     * Use &lt;ProductFormFeatureDescription&gt; to add brief details if required
     */
    Other("ZZZ", "Other");

    public final String code;
    public final String description;

    BindingOrPageEdgeColors(String code, String description) {
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

    private static volatile Map<String, BindingOrPageEdgeColors> map;

    private static Map<String, BindingOrPageEdgeColors> map() {
        Map<String, BindingOrPageEdgeColors> result = map;
        if (result == null) {
            synchronized (BindingOrPageEdgeColors.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (BindingOrPageEdgeColors e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static BindingOrPageEdgeColors byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }

    public static Optional<BindingOrPageEdgeColors> byCodeOptional(String code) {
        return Optional.ofNullable(byCode(code));
    }

    public static String codeToDesciption(String code) {
        return byCodeOptional(code).map(c -> c.description).orElse(null);
    }
}
