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

import java.util.Optional;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * marker interface to assist in IDE navigation to code-list 140 (US CPSIA choking hazard warning code)
 */
interface CodeList140 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 140</b>
 * <p>
 * Description: US CPSIA choking hazard warning code
 * <p>
 * JONIX adds: Deprecated in Onix3
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href="https://ns.editeur.org/onix/en/">ONIX online Codelist browser</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_36.html#codelist140">ONIX
 *      Codelist 140 in Reference Guide</a>
 */
public enum UsCpsiaChokingHazardWarnings implements OnixCodelist, CodeList140 {
    /**
     * List withdrawn - use List 143
     */
    WARNING_CHOKING_HAZARD_Small_parts_Not_for_children_under_3_yrs_("01",
        "WARNING: CHOKING HAZARD – Small parts | Not for children under 3 yrs."),

    /**
     * List withdrawn - use List 143
     */
    WARNING_CHOKING_HAZARD_This_toy_is_a_small_ball_Not_for_children_under_3_yrs_("02",
        "WARNING: CHOKING HAZARD – This toy is a small ball | Not for children under 3 yrs."),

    /**
     * List withdrawn - use List 143
     */
    WARNING_CHOKING_HAZARD_Toy_contains_a_small_ball_Not_for_children_under_3_yrs_("03",
        "WARNING: CHOKING HAZARD – Toy contains a small ball | Not for children under 3 yrs."),

    /**
     * List withdrawn - use List 143
     */
    // CHECKSTYLE:OFF
    WARNING_CHOKING_HAZARD_Children_under_8_yrs_can_choke_or_suffocate_on_uninflated_or_broken_balloons_Adult_supervision_required_Keep_uninflated_balloons_from_children_Discard_broken_balloons_at_once_(
        "04",
        "WARNING: CHOKING HAZARD – Children under 8 yrs. can choke or suffocate on uninflated or broken balloons. Adult supervision required | Keep uninflated balloons from children. Discard broken balloons at once."),
    // CHECKSTYLE:ON

    /**
     * List withdrawn - use List 143
     */
    WARNING_CHOKING_HAZARD_This_toy_is_a_marble_Not_for_children_under_3_yrs_("05",
        "WARNING: CHOKING HAZARD – This toy is a marble | Not for children under 3 yrs."),

    /**
     * List withdrawn - use List 143
     */
    WARNING_CHOKING_HAZARD_Toy_contains_a_marble_Not_for_children_under_3_yrs_("06",
        "WARNING: CHOKING HAZARD – Toy contains a marble | Not for children under 3 yrs."),

    /**
     * List withdrawn - use List 143
     */
    No_choking_hazard_warning_necessary("07", "No choking hazard warning necessary");

    public final String code;
    public final String description;

    UsCpsiaChokingHazardWarnings(String code, String description) {
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

    public static UsCpsiaChokingHazardWarnings byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        for (UsCpsiaChokingHazardWarnings e : values()) {
            if (e.code.equals(code)) {
                return e;
            }
        }
        return null;
    }

    public static Optional<UsCpsiaChokingHazardWarnings> byCodeOptional(String code) {
        return Optional.ofNullable(byCode(code));
    }

    public static String codeToDesciption(String code) {
        return byCodeOptional(code).map(c -> c.description).orElse(null);
    }
}
