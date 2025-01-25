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
 * marker interface to assist in IDE navigation to code-list 11 (Epublication format code)
 */
interface CodeList11 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 11</b>
 * <p>
 * Description: Epublication format code
 * <p>
 * JONIX adds: Deprecated in Onix3
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href="https://ns.editeur.org/onix/en/">ONIX online Codelist browser</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_36.html#codelist11">ONIX
 *      Codelist 11 in Reference Guide</a>
 */
public enum EpublicationFormats implements OnixCodelist, CodeList11 {
    HTML("01", "HTML"),

    PDF("02", "PDF"),

    /**
     * '.LIT' file format used by Microsoft Reader software
     */
    Microsoft_Reader("03", "Microsoft Reader"),

    RocketBook("04", "RocketBook"),

    Rich_text_format_RTF("05", "Rich text format (RTF)"),

    Open_Ebook_Publication_Structure_OEBPS("06", "Open Ebook Publication Structure (OEBPS) format standard"),

    XML("07", "XML"),

    SGML("08", "SGML"),

    /**
     * '.EXE' file format used when an epublication is delivered as a self-executing package of software and content
     */
    EXE("09", "EXE"),

    /**
     * '.TXT' file format
     */
    ASCII("10", "ASCII"),

    /**
     * Proprietary file format used for the MobiPocket reader software
     */
    MobiPocket_format("11", "MobiPocket format");

    public final String code;
    public final String description;

    EpublicationFormats(String code, String description) {
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

    private static volatile Map<String, EpublicationFormats> map;

    private static Map<String, EpublicationFormats> map() {
        Map<String, EpublicationFormats> result = map;
        if (result == null) {
            synchronized (EpublicationFormats.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (EpublicationFormats e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static EpublicationFormats byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }

    public static Optional<EpublicationFormats> byCodeOptional(String code) {
        return Optional.ofNullable(byCode(code));
    }

    public static String codeToDesciption(String code) {
        return byCodeOptional(code).map(c -> c.description).orElse(null);
    }
}
