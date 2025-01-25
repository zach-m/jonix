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
 * marker interface to assist in IDE navigation to code-list 162 (Resource version feature type)
 */
interface CodeList162 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 162</b>
 * <p>
 * Description: Resource version feature type
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href="https://ns.editeur.org/onix/en/">ONIX online Codelist browser</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_68.html#codelist162">ONIX
 *      Codelist 162 in Reference Guide</a>
 */
public enum ResourceVersionFeatureTypes implements OnixCodelist, CodeList162 {
    /**
     * Resource Version Feature Value carries a code from List 178
     */
    File_format("01", "File format"),

    /**
     * Resource Version Feature Value carries an integer
     */
    Image_height_in_pixels("02", "Image height in pixels"),

    /**
     * Resource Version Feature Value carries an integer
     */
    Image_width_in_pixels("03", "Image width in pixels"),

    /**
     * Resource Version Feature Value carries the filename of the supporting resource, necessary only when it is
     * different from the last part of the path provided in &lt;ResourceLink&gt;
     */
    Filename("04", "Filename"),

    /**
     * Resource Version Feature Value carries a decimal number only, suggested no more than 2 or 3 significant digits
     * (eg 1.7, not 1.7462 or 1.75MB)
     */
    Approximate_download_file_size_in_megabytes("05", "Approximate download file size in megabytes"),

    /**
     * MD5 hash value of the resource file. &lt;ResourceVersionFeatureValue&gt; should contain the 128-bit digest value
     * (as 32 hexadecimal digits). Can be used as a cryptographic check on the integrity of a resource after it has been
     * retrieved
     */
    MD5_hash_value("06", "MD5 hash value"),

    /**
     * Resource Version Feature Value carries a integer number only (eg 1831023)
     */
    Exact_download_file_size_in_bytes("07", "Exact download file size in bytes"),

    /**
     * SHA-256 hash value of the resource file. &lt;ResourceVersionFeatureValue&gt; should contain the 256-bit digest
     * value (as 64 hexadecimal digits). Can be used as a cryptographic check on the integrity of a resource after it
     * has been retrieved
     */
    SHA_256_hash_value("08", "SHA-256 hash value"),

    /**
     * International Standard Content Code, a 'similarity hash' derived algorithmically from the resource content itself
     * (see https://iscc.codes). &lt;IDValue&gt; is the ISCC-CODE generated from a digital manifestation of the work, as
     * a variable-length case-insensitive alphanumeric string (or 55 characters including three hyphens if using ISCC
     * v1.0, but this is deprecated). Note alphabetic characters in v1.x ISCCs use Base32 encoding and are
     * conventionally upper case. The 'ISCC:' prefix is omitted
     * <p>
     * JONIX adds: Not included in Onix2
     */
    ISCC("09", "ISCC"),

    /**
     * &lt;ResourceVersionFeatureValue&gt; carries the previous filename of the supporting resource, necessary only when
     * it is different from the last part of the path provided in &lt;ResourceLink&gt; and from the filename provided
     * using &lt;ResourceVersionFeatureType&gt; code 04, and when the data sender suggests the recipient delete this old
     * file. Note that the 'trigger' to update the resource and delete the old file is provided by the Resource
     * version's &lt;ContentDate&gt;
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Previous_filename("10", "Previous filename");

    public final String code;
    public final String description;

    ResourceVersionFeatureTypes(String code, String description) {
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

    private static volatile Map<String, ResourceVersionFeatureTypes> map;

    private static Map<String, ResourceVersionFeatureTypes> map() {
        Map<String, ResourceVersionFeatureTypes> result = map;
        if (result == null) {
            synchronized (ResourceVersionFeatureTypes.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (ResourceVersionFeatureTypes e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static ResourceVersionFeatureTypes byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }

    public static Optional<ResourceVersionFeatureTypes> byCodeOptional(String code) {
        return Optional.ofNullable(byCode(code));
    }

    public static String codeToDesciption(String code) {
        return byCodeOptional(code).map(c -> c.description).orElse(null);
    }
}
