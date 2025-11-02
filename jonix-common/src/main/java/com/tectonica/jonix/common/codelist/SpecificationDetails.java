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
 * marker interface to assist in IDE navigation to code-list 248 (Specification detail code)
 */
interface CodeList248 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 248</b>
 * <p>
 * Description: Specification detail code
 * <p>
 * JONIX adds: Not included in Onix2
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href="https://ns.editeur.org/onix/en/">ONIX online Codelist browser</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_71.html#codelist248">ONIX
 *      Codelist 248 in Reference Guide</a>
 */
public enum SpecificationDetails implements OnixCodelist, CodeList248 {
    _22_05kHz("A411", "22.05kHz"),

    /**
     * 44,100 samples per channel per second (CD quality)
     */
    _44_1kHz("A412", "44.1kHz"),

    _48kHz("A413", "48kHz"),

    /**
     * Bit depth, 16 bits per sample (CD-quality)
     */
    _16_bits_per_sample("A416", "16-bits per sample"),

    _24_bits_per_sample("A418", "24-bits per sample"),

    /**
     * Includes v1.1
     */
    ID3v1("A424", "ID3v1"),

    ID3v2("A425", "ID3v2"),

    /**
     * Grain of paper parallel to spine
     */
    Printed_long_grain("B001", "Printed long grain"),

    /**
     * Grain of paper perpendicular to spine
     */
    Printed_short_grain("B002", "Printed short grain"),

    /**
     * Usually B/W
     */
    Printed_monochrome("B003", "Printed monochrome"),

    Printed_CMYK("B004", "Printed CMYK"),

    /**
     * Printed 'premium' or high-fidelity / high resolution CMYK (where different from 'Printed CMYK', and the
     * manufacturer offers two quality settings)
     */
    Printed_higher_quality_CMYK("B005", "Printed higher-quality CMYK"),

    /**
     * At least some content bleeds to or beyond trimmed page edge
     */
    Printed_with_bleed("B006", "Printed with bleed"),

    /**
     * Printed 'premium' or high-fidelity / high resolution monochrome (where different from 'Printed monochrome', and
     * the manufacturer offers two quality settings)
     */
    Printed_higher_quality_monochrome("B007", "Printed higher-quality monochrome");

    public final String code;
    public final String description;

    SpecificationDetails(String code, String description) {
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

    private static volatile Map<String, SpecificationDetails> map;

    private static Map<String, SpecificationDetails> map() {
        Map<String, SpecificationDetails> result = map;
        if (result == null) {
            synchronized (SpecificationDetails.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (SpecificationDetails e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static SpecificationDetails byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }

    public static Optional<SpecificationDetails> byCodeOptional(String code) {
        return Optional.ofNullable(byCode(code));
    }

    public static String codeToDesciption(String code) {
        return byCodeOptional(code).map(c -> c.description).orElse(null);
    }
}
