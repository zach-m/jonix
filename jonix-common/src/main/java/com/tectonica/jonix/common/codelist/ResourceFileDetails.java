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
 * marker interface to assist in IDE navigation to code-list 252 (Resource file detail code)
 */
interface CodeList252 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 252</b>
 * <p>
 * Description: Resource file detail code
 * <p>
 * Jonix-Comment: Introduced in Onix3
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_64.html#codelist252">ONIX
 *      Codelist 252 in Reference Guide</a>
 */
public enum ResourceFileDetails implements OnixCodelist, CodeList252 {
    /**
     * Includes 'stereo' where channels are identical
     */
    Mono("A410", "Mono"),

    _22_05kHz("A411", "22.05kHz"),

    /**
     * 44,100 samples per channel per second (CD-quality)
     */
    _44_1kHz("A412", "44.1kHz"),

    _48kHz("A413", "48kHz"),

    _88_2kHz("A414", "88.2kHz"),

    _96kHz("A415", "96kHz"),

    /**
     * Bit depth, 16 bits per sample (CD-quality)
     */
    _16_bits_per_sample("A416", "16-bits per sample"),

    _20_bits_per_sample("A417", "20-bits per sample"),

    _24_bits_per_sample("A418", "24-bits per sample"),

    _32_bits_per_sample_FP("A419", "32-bits per sample (FP)"),

    /**
     * Includes 'joint stereo'
     */
    Stereo("A420", "Stereo"),

    Stereo_2_1("A421", "Stereo 2.1"),

    /**
     * Includes v1.1
     */
    ID3v1("A422", "ID3v1"),

    ID3v2("A423", "ID3v2"),

    /**
     * Five-channel audio (including low-frequency channel)
     */
    Surround_4_1("A441", "Surround 4.1"),

    /**
     * Six-channel audio (including low-frequency channel)
     */
    Surround_5_1("A451", "Surround 5.1"),

    With_crop_marks("B001", "With crop marks"),

    /**
     * If page size of the resource file is not equal to final trimmed page size of the product (in &lt;Measure&gt;,
     * then text or image area should be centred on final pages. Note that content may not bleed to the trimmed page
     * edge
     */
    Without_crop_marks("B002", "Without crop marks"),

    Monochrome("B003", "Monochrome"),

    /**
     * Two pages in the resource file represent a single page in the product
     */
    Preseparated_2_channels("B004", "Preseparated – 2 channels"),

    Preseparated_3_channels("B005", "Preseparated – 3 channels"),

    /**
     * For example, preseparated CMYK
     */
    Preseparated_4_channels("B006", "Preseparated – 4 channels"),

    Composite_CMYK("B010", "Composite (CMYK)"),

    Composite_RGB("B011", "Composite (RGB)");

    public final String code;
    public final String description;

    ResourceFileDetails(String code, String description) {
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

    private static volatile Map<String, ResourceFileDetails> map;

    private static Map<String, ResourceFileDetails> map() {
        Map<String, ResourceFileDetails> result = map;
        if (result == null) {
            synchronized (ResourceFileDetails.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (ResourceFileDetails e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static ResourceFileDetails byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }

    public static Optional<ResourceFileDetails> byCodeOptional(String code) {
        return Optional.ofNullable(byCode(code));
    }

    public static String codeToDesciption(String code) {
        return byCodeOptional(code).map(c -> c.description).orElse(null);
    }
}
