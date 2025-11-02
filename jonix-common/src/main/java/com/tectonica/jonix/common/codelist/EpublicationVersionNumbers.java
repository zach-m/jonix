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
 * marker interface to assist in IDE navigation to code-list 220 (E-publication version number)
 */
interface CodeList220 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 220</b>
 * <p>
 * Description: E-publication version number
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href="https://ns.editeur.org/onix/en/">ONIX online Codelist browser</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_71.html#codelist220">ONIX
 *      Codelist 220 in Reference Guide</a>
 */
public enum EpublicationVersionNumbers implements OnixCodelist, CodeList220 {
    /**
     * Use only with &lt;ProductFormDetail&gt; codes E101 or E102
     */
    EPUB_2_0_1("101A", "EPUB 2.0.1"),

    /**
     * Use only with &lt;ProductFormDetail&gt; code E101
     */
    EPUB_3_0("101B", "EPUB 3.0"),

    /**
     * Use only with &lt;ProductFormDetail&gt; code E101
     */
    EPUB_3_0_1("101C", "EPUB 3.0.1"),

    /**
     * Use only with &lt;ProductFormDetail&gt; code E101
     */
    EPUB_3_1("101D", "EPUB 3.1"),

    /**
     * Use only with &lt;ProductFormDetail&gt; code E101
     * <p>
     * JONIX adds: Not included in Onix2
     */
    EPUB_3_2("101E", "EPUB 3.2"),

    /**
     * Use only with &lt;ProductFormDetail&gt; code E101
     * <p>
     * JONIX adds: Not included in Onix2
     */
    EPUB_3_3("101F", "EPUB 3.3"),

    /**
     * Use only with &lt;ProductFormDetail&gt; E107 or E108
     * <p>
     * JONIX adds: Not included in Onix2
     */
    PDF_1_3("107C", "PDF 1.3"),

    /**
     * Use only with &lt;ProductFormDetail&gt; E107 or E108
     * <p>
     * JONIX adds: Not included in Onix2
     */
    PDF_1_4("107D", "PDF 1.4"),

    /**
     * Use only with &lt;ProductFormDetail&gt; E107 or E108
     * <p>
     * JONIX adds: Not included in Onix2
     */
    PDF_1_6("107F", "PDF 1.6"),

    /**
     * Use only with &lt;ProductFormDetail&gt; E107 or E108
     * <p>
     * JONIX adds: Not included in Onix2
     */
    PDF_1_7("107G", "PDF 1.7"),

    /**
     * Use only with &lt;ProductFormDetail&gt; E107 or E108
     * <p>
     * JONIX adds: Not included in Onix2
     */
    PDF_2_0("107J", "PDF 2.0"),

    /**
     * Use only with &lt;ProductFormDetail&gt; codes E116 or E127
     */
    Kindle_mobi_7("116A", "Kindle mobi 7"),

    /**
     * Use only with &lt;ProductFormDetail&gt; code E116
     */
    Kindle_KF8("116B", "Kindle KF8"),

    /**
     * Use only with &lt;ProductFormDetail&gt; code E116
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Kindle_KFX("116C", "Kindle KFX");

    public final String code;
    public final String description;

    EpublicationVersionNumbers(String code, String description) {
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

    private static volatile Map<String, EpublicationVersionNumbers> map;

    private static Map<String, EpublicationVersionNumbers> map() {
        Map<String, EpublicationVersionNumbers> result = map;
        if (result == null) {
            synchronized (EpublicationVersionNumbers.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (EpublicationVersionNumbers e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static EpublicationVersionNumbers byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }

    public static Optional<EpublicationVersionNumbers> byCodeOptional(String code) {
        return Optional.ofNullable(byCode(code));
    }

    public static String codeToDesciption(String code) {
        return byCodeOptional(code).map(c -> c.description).orElse(null);
    }
}
