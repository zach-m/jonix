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
 * marker interface to assist in IDE navigation to code-list 19 (Unnamed person(s))
 */
interface CodeList19 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 19</b>
 * <p>
 * Description: Unnamed person(s)
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href="https://ns.editeur.org/onix/en/">ONIX online Codelist browser</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_69.html#codelist19">ONIX
 *      Codelist 19 in Reference Guide</a>
 */
public enum UnnamedPersonss implements OnixCodelist, CodeList19 {
    Unknown("01", "Unknown"),

    /**
     * Note that Anonymous can be interpreted as singular or plural. A real name can be provided using
     * &lt;AlternativeName&gt; where it is generally known
     */
    Anonymous("02", "Anonymous"),

    /**
     * And others. Use when some but not all contributors are listed individually, perhaps because the complete
     * contributor list is impractically long
     */
    et_al("03", "et al"),

    /**
     * When there are multiple contributors, and none are listed individually. Use for example when the product is a
     * pack of books by different authors
     */
    Various("04", "Various"),

    /**
     * Use for example with Contributor role code E07 'read by' for audio books with digital narration having a
     * male-inflected tone. 'Brand name' of voice may be provided in &lt;AlternativeName&gt;
     */
    Synthesised_voice_male("05", "Synthesised voice – male"),

    /**
     * Use for example with Contributor role code E07 'read by' for audio books with digital narration having a
     * female-inflected tone. 'Brand name' of voice may be provided in &lt;AlternativeName&gt;
     */
    Synthesized_voice_female("06", "Synthesized voice – female"),

    /**
     * Use for example with Contributor role code E07 'read by' for audio books with digital narration
     */
    Synthesized_voice_unspecified("07", "Synthesized voice – unspecified"),

    /**
     * Sometimes termed an 'Authorized Voice Replica'. Use for exanple with Contributor role code E07 'read by' for
     * audio books with digital narration, and provide name of voice actor in &lt;AlternativeName&gt;. Only for use in
     * ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Synthesized_voice_based_on_real_voice_actor("08", "Synthesized voice – based on real voice actor"),

    /**
     * Use when the creator (of text, of images etc) is a generative AI model or technique. Note, can also be combined
     * with the role 'assisted by'. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    AI_Artificial_intelligence("09", "AI (Artificial intelligence)");

    public final String code;
    public final String description;

    UnnamedPersonss(String code, String description) {
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

    private static volatile Map<String, UnnamedPersonss> map;

    private static Map<String, UnnamedPersonss> map() {
        Map<String, UnnamedPersonss> result = map;
        if (result == null) {
            synchronized (UnnamedPersonss.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (UnnamedPersonss e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static UnnamedPersonss byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }

    public static Optional<UnnamedPersonss> byCodeOptional(String code) {
        return Optional.ofNullable(byCode(code));
    }

    public static String codeToDesciption(String code) {
        return byCodeOptional(code).map(c -> c.description).orElse(null);
    }
}
