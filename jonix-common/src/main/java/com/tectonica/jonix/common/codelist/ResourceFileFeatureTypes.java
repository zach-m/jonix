/*
 * Copyright (C) 2012-2020 Zach Melamed
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

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * marker interface to assist in IDE navigation to code-list 253 (Resource file feature type)
 */
interface CodeList253 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 253</b>
 * <p>
 * Description: Resource file feature type
 * <p>
 * Jonix-Comment: Introduced in Onix3
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_58.html#codelist253">ONIX
 *      Codelist 253 in Reference Guide</a>
 */
public enum ResourceFileFeatureTypes implements OnixCodelist, CodeList253 {
    /**
     * Resource File Feature Value carries a code from List 178
     */
    File_format("01", "File format"),

    /**
     * Resource File Feature Value carries the filename of the supporting resource, necessary only when it is different
     * from the last part of the path provided in &lt;ResourceFileLink&gt;
     */
    Filename("04", "Filename"),

    /**
     * Resource File Feature Value carries a decimal number only, suggested no more than 2 or 3 significant digits (eg
     * 1.7, not 1.7462 or 1.75MB)
     */
    Approximate_download_file_size_in_megabytes("05", "Approximate download file size in megabytes"),

    /**
     * MD5 hash value of the resource file. &lt;ResourceFileFeatureValue&gt; should contain the 128-bit digest value (as
     * 32 hexadecimal digits). Can be used as a cryptographic check on the integrity of a resource after it has been
     * retrieved
     */
    MD5_hash_value("06", "MD5 hash value"),

    /**
     * Resource File Feature Value carries a integer number only (eg 1831023)
     */
    Exact_download_file_size_in_bytes("07", "Exact download file size in bytes"),

    /**
     * SHA-256 hash value of the resource file. &lt;ResourceFileFeatureValue&gt; should contain the 256-bit digest value
     * (as 64 hexadecimal digits). Can be used as a cryptographic check on the integrity of a resource after it has been
     * retrieved
     */
    SHA_256_hash_value("08", "SHA-256 hash value"),

    /**
     * Resource File Feature Value is the loudness in LKFS (LUFS) used for audio normalisation - see ITU-R BS.1770
     */
    Audio_loudness("31", "Audio loudness");

    public final String code;
    public final String description;

    ResourceFileFeatureTypes(String code, String description) {
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

    public static ResourceFileFeatureTypes byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        for (ResourceFileFeatureTypes e : values()) {
            if (e.code.equals(code)) {
                return e;
            }
        }
        return null;
    }
}
