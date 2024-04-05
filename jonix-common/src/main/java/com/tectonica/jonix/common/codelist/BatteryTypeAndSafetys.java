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
 * marker interface to assist in IDE navigation to code-list 242 (Battery type and safety)
 */
interface CodeList242 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 242</b>
 * <p>
 * Description: Battery type and safety
 * <p>
 * JONIX adds: Not included in Onix2
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href="https://ns.editeur.org/onix/en/">ONIX online Codelist browser</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_65.html#codelist242">ONIX
 *      Codelist 242 in Reference Guide</a>
 */
public enum BatteryTypeAndSafetys implements OnixCodelist, CodeList242 {
    /**
     * The default if battery type and safety information is omitted
     */
    Batteries_not_required("00", "Batteries not required"),

    /**
     * Batteries built in or pre-installed in product, non-user replaceable. May use
     * &lt;ProductFormFeatureDesciption&gt; to provide further details
     */
    Batteries_built_in("01", "Batteries built in"),

    /**
     * Batteries pre-installed, user replaceable. Use &lt;ProductFormFeatureDescription&gt; to provide further details,
     * eg '2 x 1.2V LR6/AA rechargeable', with these details formatted as [integer] x [number]V [type or descriptive
     * text] and usually taken from the outer packaging
     */
    Batteries_pre_installed("02", "Batteries pre-installed"),

    /**
     * Batteries included with the product, but not pre-installed. Use &lt;ProductFormFeatureDescription&gt; to provide
     * further details, eg '2 x 1.2V LR6/AA rechargeable', with these details formatted as [integer] x [number]V [type
     * or descriptive text] and usually taken from the outer packaging
     */
    Batteries_supplied("03", "Batteries supplied"),

    /**
     * Batteries required for use, but not supplied with the product. May use &lt;ProductFormFeatureDescription&gt; to
     * provide further details, eg '2 x 1.2V LR6/AA rechargeable', with these details formatted as [integer] x [number]V
     * [type or descriptive text] and usually taken from the outer packaging
     */
    Batteries_required("04", "Batteries required"),

    /**
     * Spare batteries included with product, in addition to those specified using codes 02 or 03. May use
     * &lt;ProductFormFeatureDescription&gt; to provide further details
     */
    Batteries_supplied_spare("05", "Batteries supplied spare"),

    /**
     * (Material) Safety Data Sheet available for the product (including its batteries).
     * &lt;ProductFormFeatureDescription&gt; must be used to supply URL of documentation
     */
    Safety_data_sheet_available("06", "Safety data sheet available"),

    /**
     * Battery manufacturer's technical data sheet available. &lt;ProductFormFeatureDescription&gt; must be used to
     * supply URL of documentation
     */
    Technical_data_sheet_available("07", "Technical data sheet available"),

    /**
     * Independent of whether charger is supplied as part of the product. Note that this is largely dependent on battery
     * chemistry, but should be specified separately to avoid ambiguity
     */
    Rechargeable("08", "Rechargeable"),

    Non_rechargeable("09", "Non-rechargeable"),

    /**
     * &lt;ProductFormFeatureDescription&gt; contains battery safety-related warning text, generally taken from the
     * outer packaging (eg 'Warning - internal battery: product must not be pierced')
     */
    Battery_warning_text("10", "Battery warning text"),

    /**
     * &lt;ProductFormFeatureDescription&gt; must provide details of the battery chemistry (eg 'Sodium-Sulfur'). Use
     * ONLY where no suitable code exists for the specific chemistry used
     */
    Battery_chemistry("20", "Battery chemistry"),

    /**
     * For all specific battery chemistries, &lt;ProductFormFeatureDescription&gt; may optionally describe the battery
     * construction - for example the nunber of individual cells per battery and any other physical details, eg '4 x
     * pouch cells'
     */
    Lithium_ion("21", "Lithium-ion"),

    Lithium_polymer("22", "Lithium-polymer"),

    Lithium_metal("23", "Lithium-metal"),

    Nickel_metal_hydride("24", "Nickel-metal hydride"),

    Nickel_Cadmium("25", "Nickel-Cadmium"),

    /**
     * 'Alkaline battery'
     */
    Zinc_Manganese_dioxide("26", "Zinc-Manganese dioxide"),

    /**
     * Common 'dry cell' battery
     */
    Zinc_Carbon("27", "Zinc-Carbon"),

    Zinc_air("28", "Zinc-air"),

    Silver_oxide("29", "Silver oxide"),

    /**
     * &lt;ProductFormFeatureDescription&gt; may contain a full description of the batteries supplied (chemistry, cell
     * structure, battery size and weight, number, capacity etc). Use ONLY if the product (or a product part) contains
     * multiple different TYPES of battery that cannot be described with existing codes (eg a mix of battery chemistries
     * or batteries of different sizes, within a single product part)
     */
    Battery_description("99", "Battery description");

    public final String code;
    public final String description;

    BatteryTypeAndSafetys(String code, String description) {
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

    private static volatile Map<String, BatteryTypeAndSafetys> map;

    private static Map<String, BatteryTypeAndSafetys> map() {
        Map<String, BatteryTypeAndSafetys> result = map;
        if (result == null) {
            synchronized (BatteryTypeAndSafetys.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (BatteryTypeAndSafetys e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static BatteryTypeAndSafetys byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }

    public static Optional<BatteryTypeAndSafetys> byCodeOptional(String code) {
        return Optional.ofNullable(byCode(code));
    }

    public static String codeToDesciption(String code) {
        return byCodeOptional(code).map(c -> c.description).orElse(null);
    }
}
