/*
 * Copyright (C) 2012-2026 Zach Melamed
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
 * marker interface to assist in IDE navigation to code-list 99 (Special cover material)
 */
interface CodeList99 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 99</b>
 * <p>
 * Description: Special cover material
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href="https://ns.editeur.org/onix/en/">ONIX online Codelist browser</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_75.html#codelist99">ONIX
 *      Codelist 99 in Reference Guide</a>
 */
public enum SpecialCoverMaterials implements OnixCodelist, CodeList99 {
    Pigskin("26", "Pigskin"),

    Goatskin("27", "Goatskin"),

    Calfskin("02", "Calfskin"),

    Cowhide("13", "Cowhide"),

    /**
     * Or sheepskin. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Lambskin("30", "Lambskin"),

    /**
     * Vegetable-tanned goatskin
     */
    Morocco("04", "Morocco"),

    /**
     * Usually hagfish skin
     */
    Eelskin("14", "Eelskin"),

    /**
     * Calf split or sheep split, textured to resembe goatskin
     */
    French_Morocco("03", "French Morocco"),

    /**
     * Calfskin leather, textured to resemble ostrich leg skin
     */
    Ostraleg("09", "Ostraleg"),

    /**
     * Pigskin, textured to resemble calfskin
     */
    Berkshire_leather("01", "Berkshire leather"),

    /**
     * Leather, (usually chromium-) tanned to feel smooth, soft and flexible
     */
    Softhide_leather("18", "Softhide leather"),

    /**
     * Leather binding material constructed from shredded leather fibers bonded with polyurethane or latex, textured to
     * resemble real leather
     */
    Bonded_leather("12", "Bonded leather"),

    Bonded_buffalo_grain("05", "Bonded buffalo grain"),

    Bonded_calf_grain("06", "Bonded calf grain"),

    /**
     * Bonded leather, textured to resemble authentic Cordovan leather (a type of high-quality horsehide)
     */
    Bonded_Cordova("07", "Bonded Cordova"),

    Bonded_eelskin("08", "Bonded eelskin"),

    /**
     * Bonded leather, textured to resemble ostrich leg grain
     */
    Bonded_ostrich("10", "Bonded ostrich"),

    Bonded_reptile_grain("11", "Bonded reptile grain"),

    /**
     * An imitation made of any non-leather material
     */
    Imitation_leather("25", "Imitation leather"),

    /**
     * Imitation leather binding material, cellulose-based, coated in polyurethane or vinyl
     */
    Leatherflex("16", "Leatherflex"),

    /**
     * Proprietary imitation leather binding material, cellulose-based with latex, usually embossed / textured
     */
    Kivar("15", "Kivar"),

    /**
     * Proprietary imitation leather binding material, cellulose-based, usually embossed / textured
     */
    Guaflex_Skivertex("24", "Guaflex / Skivertex"),

    /**
     * Textile, linen or cotton. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Cloth("31", "Cloth"),

    /**
     * Cloth binding material with a brushed pile surface texture
     */
    Moleskin("17", "Moleskin"),

    /**
     * (de: 'Samt')
     */
    Velvet("20", "Velvet"),

    /**
     * Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Padded_or_quilted_fabric("29", "Padded or quilted fabric"),

    /**
     * Proprietary imitation cloth binding material, cellulose-based, usually embossed / textured
     */
    Geltex_Wibalin("23", "Géltex / Wibalin"),

    Metal("19", "Metal"),

    /**
     * (es: 'n&#225;car')
     */
    Mother_of_pearl("21", "Mother-of-pearl"),

    Papyrus("22", "Papyrus"),

    /**
     * Smooth or textured synthetic rubber. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Rubber("28", "Rubber");

    public final String code;
    public final String description;

    SpecialCoverMaterials(String code, String description) {
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

    private static volatile Map<String, SpecialCoverMaterials> map;

    private static Map<String, SpecialCoverMaterials> map() {
        Map<String, SpecialCoverMaterials> result = map;
        if (result == null) {
            synchronized (SpecialCoverMaterials.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (SpecialCoverMaterials e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static SpecialCoverMaterials byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }

    public static Optional<SpecialCoverMaterials> byCodeOptional(String code) {
        return Optional.ofNullable(byCode(code));
    }

    public static String codeToDesciption(String code) {
        return byCodeOptional(code).map(c -> c.description).orElse(null);
    }
}
