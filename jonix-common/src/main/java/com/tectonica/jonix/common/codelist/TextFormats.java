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
 * marker interface to assist in IDE navigation to code-list 34 (Text format)
 */
interface CodeList34 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 34</b>
 * <p>
 * Description: Text format
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href="https://ns.editeur.org/onix/en/">ONIX online Codelist browser</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_70.html#codelist34">ONIX
 *      Codelist 34 in Reference Guide</a>
 */
public enum TextFormats implements OnixCodelist, CodeList34 {
    /**
     * Other than XHTML
     */
    HTML("02", "HTML"),

    /**
     * Other than XHTML
     */
    XML("03", "XML"),

    XHTML("05", "XHTML"),

    /**
     * Default: plain text containing no markup tags of any kind, except for the character entities &amp;amp; and
     * &amp;lt; that XML insists must be used to represent ampersand and less-than characters in textual data, and in
     * the encoding declared at the head of the message or in the XML default (UTF-8 or UTF-16) if there is no explicit
     * declaration
     */
    Default_text_format("06", "Default text format"),

    /**
     * Plain text containing no markup tags of any kind, except for the character entities &amp;amp; and &amp;lt; that
     * XML insists must be used to represent ampersand and less-than characters in textual data, and with the character
     * set limited to the ASCII range, i.e. valid characters whose Unicode character numbers lie between 32 (space) and
     * 126 (tilde)
     */
    Basic_ASCII_text("07", "Basic ASCII text"),

    /**
     * DEPRECATED: use code 06 or 07 as appropriate
     * <p>
     * JONIX adds: Deprecated in Onix3
     */
    ASCII_text("00", "ASCII text"),

    /**
     * JONIX adds: Deprecated in Onix3
     */
    SGML("01", "SGML"),

    /**
     * DEPRECATED: was formerly assigned both to PDF and to XHTML
     * <p>
     * JONIX adds: Deprecated in Onix3
     */
    PDF("04", "PDF"),

    /**
     * Replaces 04 for the &lt;TextFormat&gt; element, but cannot of course be used as a textformat attribute
     * <p>
     * JONIX adds: Deprecated in Onix3
     */
    PDF_("08", "PDF"),

    /**
     * JONIX adds: Deprecated in Onix3
     */
    Microsoft_rich_text_format_RTF("09", "Microsoft rich text format (RTF)"),

    /**
     * JONIX adds: Deprecated in Onix3
     */
    Microsoft_Word_binary_format_DOC("10", "Microsoft Word binary format (DOC)"),

    /**
     * Office Open XML file format / OOXML / DOCX
     * <p>
     * JONIX adds: Deprecated in Onix3
     */
    ECMA_376_WordprocessingML("11", "ECMA 376 WordprocessingML"),

    /**
     * ISO Open Document Format
     * <p>
     * JONIX adds: Deprecated in Onix3
     */
    ISO_26300_ODF("12", "ISO 26300 ODF"),

    /**
     * JONIX adds: Deprecated in Onix3
     */
    Corel_Wordperfect_binary_format_DOC("13", "Corel Wordperfect binary format (DOC)"),

    /**
     * The Open Publication Structure / OPS Container Format standard of the International Digital Publishing Forum
     * (IDPF) [File extension .epub]
     * <p>
     * JONIX adds: Deprecated in Onix3
     */
    EPUB("14", "EPUB"),

    /**
     * XML Paper Specification
     * <p>
     * JONIX adds: Deprecated in Onix3
     */
    XPS("15", "XPS");

    public final String code;
    public final String description;

    TextFormats(String code, String description) {
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

    private static volatile Map<String, TextFormats> map;

    private static Map<String, TextFormats> map() {
        Map<String, TextFormats> result = map;
        if (result == null) {
            synchronized (TextFormats.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (TextFormats e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static TextFormats byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }

    public static Optional<TextFormats> byCodeOptional(String code) {
        return Optional.ofNullable(byCode(code));
    }

    public static String codeToDesciption(String code) {
        return byCodeOptional(code).map(c -> c.description).orElse(null);
    }
}
