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
 * marker interface to assist in IDE navigation to code-list 41 (Prize or award achievement)
 */
interface CodeList41 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 41</b>
 * <p>
 * Description: Prize or award achievement
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href="https://ns.editeur.org/onix/en/">ONIX online Codelist browser</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_65.html#codelist41">ONIX
 *      Codelist 41 in Reference Guide</a>
 */
public enum PrizeOrAwardAchievements implements OnixCodelist, CodeList41 {
    Winner("01", "Winner"),

    /**
     * Named as being in second place
     */
    Runner_up("02", "Runner-up"),

    /**
     * Cited as being worthy of special attention at the final stage of the judging process, but not named specifically
     * as winner or runner-up. Possible terminology used by a particular prize includes 'specially commended' or
     * 'honored'
     */
    Commended("03", "Commended"),

    /**
     * Title named by the judging process to be one of the final list of candidates, such as a 'short-list' from which
     * the winner is selected, or a title named as 'finalist'
     */
    Short_listed("04", "Short-listed"),

    /**
     * Title named by the judging process to be one of the preliminary list of candidates, such as a 'long-list' from
     * which first a shorter list or set of finalists is selected, and then the winner is announced
     */
    Long_listed("05", "Long-listed"),

    /**
     * Or co-winner
     */
    Joint_winner("06", "Joint winner"),

    /**
     * Selected by judging panel or an official nominating process for final consideration for a prize, award or honour
     * for which no 'short-list' or 'long list' exists
     */
    Nominated("07", "Nominated");

    public final String code;
    public final String description;

    PrizeOrAwardAchievements(String code, String description) {
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

    public static PrizeOrAwardAchievements byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        for (PrizeOrAwardAchievements e : values()) {
            if (e.code.equals(code)) {
                return e;
            }
        }
        return null;
    }

    public static Optional<PrizeOrAwardAchievements> byCodeOptional(String code) {
        return Optional.ofNullable(byCode(code));
    }

    public static String codeToDesciption(String code) {
        return byCodeOptional(code).map(c -> c.description).orElse(null);
    }
}
