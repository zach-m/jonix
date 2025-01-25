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
 * marker interface to assist in IDE navigation to code-list 80 (Product packaging type)
 */
interface CodeList80 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 80</b>
 * <p>
 * Description: Product packaging type
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href="https://ns.editeur.org/onix/en/">ONIX online Codelist browser</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_68.html#codelist80">ONIX
 *      Codelist 80 in Reference Guide</a>
 */
public enum ProductPackagingTypes implements OnixCodelist, CodeList80 {
    /**
     * No packaging, or all smaller items enclosed inside largest item
     */
    No_outer_packaging("00", "No outer packaging"),

    /**
     * Thin card or soft plastic sleeve, much less rigid than a slip case
     */
    Slip_sleeve("01", "Slip-sleeve"),

    /**
     * Packaging consisting of formed plastic sealed around each side of the product. Not to be confused with
     * single-sided Blister pack
     */
    Clamshell("02", "Clamshell"),

    /**
     * Typical DVD-style packaging, sometimes known as an 'Amaray' case
     */
    Keep_case("03", "Keep case"),

    /**
     * Typical CD-style packaging
     */
    Jewel_case("05", "Jewel case"),

    /**
     * Common CD-style packaging, a card folder with one or more panels incorporating a tray, hub or pocket to hold the
     * disc(s)
     */
    Digipak("06", "Digipak"),

    /**
     * Use for products or product bundles supplied for retail sale in shrink-wrapped packaging, where the shrink-wrap
     * film is biodegradable. For non-degradable film, see code 21. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Shrink_wrapped_biodegradable("08", "Shrink-wrapped (biodegradable)"),

    /**
     * Individual item, items or set in card box with separate or hinged lid: not to be confused with the commonly-used
     * 'boxed set' which is more likely to be packaged in a slip case
     */
    In_box_with_lid("09", "In box (with lid)"),

    /**
     * Slip-case for single item only (de: 'Schuber')
     */
    Slip_cased("10", "Slip-cased"),

    /**
     * Slip-case for multi-volume set, also commonly referred to as 'boxed set' (de: 'Kassette')
     */
    Slip_cased_set("11", "Slip-cased set"),

    /**
     * Rolled in tube or cylinder: eg sheet map or poster
     */
    Tube("12", "Tube"),

    /**
     * Use for miscellaneous items such as slides, microfiche, when presented in a binder
     */
    Binder("13", "Binder"),

    /**
     * Use for miscellaneous items such as slides, microfiche, when presented in a wallet or folder
     */
    In_wallet_or_folder("14", "In wallet or folder"),

    /**
     * Long package with triangular cross-section used for rolled sheet maps, posters etc
     */
    Long_triangular_package("15", "Long triangular package"),

    /**
     * Long package with square cross-section used for rolled sheet maps, posters, etc
     */
    Long_square_package("16", "Long square package"),

    Softbox_for_DVD("17", "Softbox (for DVD)"),

    /**
     * In pouch, eg teaching materials in a plastic bag or pouch
     */
    Pouch("18", "Pouch"),

    /**
     * In duroplastic or other rigid plastic case, eg for a class set
     */
    Rigid_plastic_case("19", "Rigid plastic case"),

    /**
     * In cardboard case, eg for a class set
     */
    Cardboard_case("20", "Cardboard case"),

    /**
     * Use for products or product bundles supplied for retail sale in shrink-wrapped packaging. For biodegradable
     * shrink-wrap film, prefer code 08. For shrink-wrapped packs of multiple products for trade supply only, see code
     * XL in List 7
     */
    Shrink_wrapped("21", "Shrink-wrapped"),

    /**
     * A pack comprising a pre-formed plastic blister and a printed card with a heat-seal coating
     */
    Blister_pack("22", "Blister pack"),

    /**
     * A case with carrying handle, typically for a set of educational books and/or learning materials
     */
    Carry_case("23", "Carry case"),

    /**
     * Individual item, items or set in metal box or can with separate or hinged lid
     */
    In_tin("24", "In tin"),

    /**
     * (ja: koguchi tome) Peelable sticker or tape sealing the foredge of a book to prevent pre-purchase reading of the
     * content. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    With_browse_prevention_tape("25", "With browse-prevention tape");

    public final String code;
    public final String description;

    ProductPackagingTypes(String code, String description) {
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

    private static volatile Map<String, ProductPackagingTypes> map;

    private static Map<String, ProductPackagingTypes> map() {
        Map<String, ProductPackagingTypes> result = map;
        if (result == null) {
            synchronized (ProductPackagingTypes.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (ProductPackagingTypes e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static ProductPackagingTypes byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }

    public static Optional<ProductPackagingTypes> byCodeOptional(String code) {
        return Optional.ofNullable(byCode(code));
    }

    public static String codeToDesciption(String code) {
        return byCodeOptional(code).map(c -> c.description).orElse(null);
    }
}
