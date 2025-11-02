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
 * marker interface to assist in IDE navigation to code-list 82 (Bible contents)
 */
interface CodeList82 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 82</b>
 * <p>
 * Description: Bible contents
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href="https://ns.editeur.org/onix/en/">ONIX online Codelist browser</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_71.html#codelist82">ONIX
 *      Codelist 82 in Reference Guide</a>
 */
public enum BibleContentss implements OnixCodelist, CodeList82 {
    /**
     * The seven portions of the Apocrypha added to the Catholic canon at the Council of Trent in 1546: Tobit; Judith;
     * Wisdom of Solomon; Sirach (Ecclesiasticus); Baruch, including the Letter of Jeremiah; I and II Maccabees; Extra
     * portions of Esther and Daniel (Additions to Esther; the Prayer of Azariah; Song of the Three Jews; Susannah; Bel
     * and the Dragon). These are not generally included in the Protestant canon
     */
    Apocrypha_Catholic_canon("AP", "Apocrypha (Catholic canon)"),

    /**
     * A collection of Apocryphal texts, canon not specified
     */
    Apocrypha_canon_unspecified("AQ", "Apocrypha (canon unspecified)"),

    /**
     * I Esdras; Prayer of Manasseh; Psalm 151; III Maccabees
     */
    Additional_Apocryphal_texts_Greek_Orthodox_canon("AX", "Additional Apocryphal texts: Greek Orthodox canon"),

    /**
     * I and II Esdras; Prayer of Manasseh; Psalm 151; III and IV Maccabees
     */
    Additional_Apocryphal_texts_Slavonic_Orthodox_canon("AY", "Additional Apocryphal texts: Slavonic Orthodox canon"),

    /**
     * Additional Apocryphal texts included in some Bible versions: I and II Esdras; Prayer of Manasseh
     */
    Additional_Apocryphal_texts("AZ", "Additional Apocryphal texts"),

    /**
     * The 66 books included in the Protestant, Catholic and Orthodox canons, together with the seven portions of the
     * Apocrypha included in the Catholic canon. (Equivalent to OT plus NT plus AP)
     */
    General_canon_with_Apocrypha_Catholic_canon("GA", "General canon with Apocrypha (Catholic canon)"),

    /**
     * The 66 books included in the Protestant, Catholic and Orthodox canons, together with Apocryphal texts, canon not
     * specified. (Equivalent to OT plus NT plus AQ, 77 books in all)
     */
    General_canon_with_Apocryphal_texts_canon_unspecified("GC",
        "General canon with Apocryphal texts (canon unspecified)"),

    /**
     * The 66 books included in the Protestant, Catholic and Orthodox canons, 39 from the Old Testament and 27 from the
     * New Testament. The sequence of books may differ in different canons. (Equivalent to OT plus NT)
     */
    General_canon("GE", "General canon"),

    /**
     * The books of Matthew, Mark, Luke and John
     */
    Gospels("GS", "Gospels"),

    /**
     * Those 39 books which were included in the Jewish canon by the rabbinical academy established at Jamma in 90 CE.
     * Also known as the Jewish or Hebrew scriptures
     */
    Old_Testament("OT", "Old Testament"),

    /**
     * The 27 books included in the Christian canon through the Easter Letter of Athanasius, Bishop of Alexandria and
     * also by a general council of the Christian church held near the end of the 4th century CE
     */
    New_Testament("NT", "New Testament"),

    /**
     * Includes the 27 books of the New Testament plus Psalms and Proverbs from the Old Testament. Equivalent to NT plus
     * PP)
     */
    New_Testament_with_Psalms_and_Proverbs("NP", "New Testament with Psalms and Proverbs"),

    /**
     * The books containing the letters of Paul to the various early Christian churches
     */
    Pauls_Epistles("PE", "Paul’s Epistles"),

    /**
     * The book of Psalms and the book of Proverbs combined
     */
    Psalms_and_Proverbs("PP", "Psalms and Proverbs"),

    /**
     * The book of Psalms
     */
    Psalms("PS", "Psalms"),

    /**
     * The first five books of the Bible: Genesis, Exodus, Numbers, Leviticus, Deuteronomy. Also applied to the Torah
     */
    Pentateuch("PT", "Pentateuch"),

    /**
     * Selected books of either the OT or NT not otherwise noted
     */
    Other_portions("ZZ", "Other portions");

    public final String code;
    public final String description;

    BibleContentss(String code, String description) {
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

    private static volatile Map<String, BibleContentss> map;

    private static Map<String, BibleContentss> map() {
        Map<String, BibleContentss> result = map;
        if (result == null) {
            synchronized (BibleContentss.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (BibleContentss e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static BibleContentss byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }

    public static Optional<BibleContentss> byCodeOptional(String code) {
        return Optional.ofNullable(byCode(code));
    }

    public static String codeToDesciption(String code) {
        return byCodeOptional(code).map(c -> c.description).orElse(null);
    }
}
