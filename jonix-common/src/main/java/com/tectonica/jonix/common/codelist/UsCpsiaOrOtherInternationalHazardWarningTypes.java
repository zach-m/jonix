/*
 * Copyright (C) 2012-2020 Zach Melamed
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
 * marker interface to assist in IDE navigation to code-list 143 (US CPSIA or other international hazard warning type)
 */
interface CodeList143 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 143</b>
 * <p>
 * Description: US CPSIA or other international hazard warning type
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_58.html#codelist143">ONIX
 *      Codelist 143 in Reference Guide</a>
 */
public enum UsCpsiaOrOtherInternationalHazardWarningTypes implements OnixCodelist, CodeList143 {
    /**
     * Required on applicable products sold in the US
     */
    WARNING_CHOKING_HAZARD_Small_parts_Not_for_children_under_3_yrs_("01",
        "WARNING: CHOKING HAZARD – Small parts | Not for children under 3 yrs."),

    /**
     * Required on applicable products sold in the US
     */
    // CHECKSTYLE:OFF
    WARNING_CHOKING_HAZARD_Children_under_8_yrs_can_choke_or_suffocate_on_uninflated_or_broken_balloons_Adult_supervision_required_Keep_uninflated_balloons_from_children_Discard_broken_balloons_at_once_(
        "02",
        "WARNING: CHOKING HAZARD – Children under 8 yrs. can choke or suffocate on uninflated or broken balloons. Adult supervision required | Keep uninflated balloons from children. Discard broken balloons at once."),
    // CHECKSTYLE:ON

    /**
     * Required on applicable products sold in the US
     */
    WARNING_CHOKING_HAZARD_This_toy_is_a_small_ball_Not_for_children_under_3_yrs_("03",
        "WARNING: CHOKING HAZARD – This toy is a small ball | Not for children under 3 yrs."),

    /**
     * Required on applicable products sold in the US
     */
    WARNING_CHOKING_HAZARD_Toy_contains_a_small_ball_Not_for_children_under_3_yrs_("04",
        "WARNING: CHOKING HAZARD – Toy contains a small ball | Not for children under 3 yrs."),

    /**
     * Required on applicable products sold in the US
     */
    WARNING_CHOKING_HAZARD_This_toy_is_a_marble_Not_for_children_under_3_yrs_("05",
        "WARNING: CHOKING HAZARD – This toy is a marble | Not for children under 3 yrs."),

    /**
     * Required on applicable products sold in the US
     */
    WARNING_CHOKING_HAZARD_Toy_contains_a_marble_Not_for_children_under_3_yrs_("06",
        "WARNING: CHOKING HAZARD – Toy contains a marble | Not for children under 3 yrs."),

    /**
     * To be used when a supplier wishes to make a clear statement that no such warning is applicable to product
     */
    No_choking_hazard_warning_necessary("07", "No choking hazard warning necessary"),

    /**
     * Required on applicable products sold in the US
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    WARNING_STRANGULATION_HAZARD_Long_cord_Not_for_children_under_3_yrs_("08",
        "WARNING: STRANGULATION HAZARD – Long cord | Not for children under 3 yrs."),

    /**
     * To be used when a supplier wishes to make a clear statement that no such warning is applicable to product
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    No_strangulation_hazard_warning_necessary("09", "No strangulation hazard warning necessary"),

    /**
     * Required on applicable products sold in the US. Should be accompanied by additional text: Swallowed magnets can
     * stick together across intestines causing serious infections and death. Seek immediate medical attention if
     * magnet(s) are swallowed or inhaled
     */
    WARNING_MAGNET_HAZARD_Product_contains_a("11", "WARNING: MAGNET HAZARD – Product contains (a) small magnet(s)"),

    /**
     * To be used when a supplier wishes to make a clear statement that no such warning is applicable to product
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    No_magnet_hazard_warning_necessary("12", "No magnet hazard warning necessary"),

    /**
     * Product flashes, flickers or includes high-contrast static or moving patterns which may cause discomfort or
     * seizures in people with photosensitive epilepsy
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    WARNING_Flashing_hazard("13", "WARNING – Flashing hazard"),

    /**
     * To be used when a supplier wishes to make a clear statement that no such warning is applicable to product
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    No_flashing_hazard_warning_necessary("14", "No flashing hazard warning necessary"),

    /**
     * Product makes loud, sudden, repetitive or other sounds which may trigger seizures in sensitive people
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    WARNING_Sound_hazard("15", "WARNING – Sound hazard"),

    /**
     * To be used when a supplier wishes to make a clear statement that no such warning is applicable to product
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    No_sound_hazard_warning_necessary("16", "No sound hazard warning necessary"),

    /**
     * Products simulates (via visual effects) the experience of motion, which may cause nausea in sensitive people
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    WARNING_Motion_simulation_hazard("17", "WARNING – Motion simulation hazard"),

    /**
     * To be used when a supplier wishes to make a clear statement that no such warning is applicable to product
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    No_motion_simulation_hazard_warning_necessary("18", "No motion simulation hazard warning necessary"),

    /**
     * Required on applicable products sold in California. Must be accompanied in &lt;ProductFormFeatureDescription&gt;
     * by specific additional text as displayed on product or packaging. For example, &#8220;WARNING: This product can
     * expose you to chemicals including [chemical name], which is known to the State of California to cause cancer. For
     * more information, go to www.P65Warnings.ca.gov&#8221;. Note long-form warnings should be used here, even if a
     * short form warning is used on the product or packaging
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    // CHECKSTYLE:OFF
    WARNING_California_Proposition_65_carcinogenic_teratogenic_or_other_reproductively_harmful_chemical_hazard("21",
        "WARNING – California Proposition 65 carcinogenic, teratogenic or other reproductively harmful chemical hazard"),
    // CHECKSTYLE:ON

    /**
     * To be used when a supplier wishes to make a clear statement that no such warning is applicable to product
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    No_California_Proposition_65_hazard_warning_necessary("22",
        "No California Proposition 65 hazard warning necessary"),

    /**
     * &lt;ProductFormFeatureDescripton&gt; carries the name of chemical that is the subject of a warning, taken from
     * the list at www.p65warnings.ca.gov/chemicals
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    California_Proposition_65_chemical_name("23", "California Proposition 65 chemical name");

    public final String code;
    public final String description;

    UsCpsiaOrOtherInternationalHazardWarningTypes(String code, String description) {
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

    private static volatile Map<String, UsCpsiaOrOtherInternationalHazardWarningTypes> map;

    private static Map<String, UsCpsiaOrOtherInternationalHazardWarningTypes> map() {
        Map<String, UsCpsiaOrOtherInternationalHazardWarningTypes> result = map;
        if (result == null) {
            synchronized (UsCpsiaOrOtherInternationalHazardWarningTypes.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (UsCpsiaOrOtherInternationalHazardWarningTypes e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static UsCpsiaOrOtherInternationalHazardWarningTypes byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }
}
