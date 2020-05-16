/*
 * Copyright (C) 2012 Zach Melamed
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

import java.util.Map;
import java.util.HashMap;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * marker interface to assist in IDE navigation to code-list 144 (E-publication technical protection)
 */
interface CodeList144 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 144</b>
 * <p>
 * Description: E-publication technical protection
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_45.html#codelist144">ONIX
 *      Codelist 144 in Reference Guide</a>
 */
public enum EpublicationTechnicalProtections implements OnixCodelist, CodeList144 {
    /**
     * Has no technical protection
     */
    None("00", "None"),

    /**
     * Has DRM protection
     */
    DRM("01", "DRM"),

    /**
     * Has digital watermarking
     */
    Digital_watermarking("02", "Digital watermarking"),

    /**
     * Has DRM protection applied by the Adobe CS4 Content Server Package or by the Adobe ADEPT hosted service
     */
    Adobe_DRM("03", "Adobe DRM"),

    /**
     * Has FairPlay DRM protection applied via Apple proprietary online store
     */
    Apple_DRM("04", "Apple DRM"),

    /**
     * Has OMA v2 DRM protection applied, as used to protect some mobile phone content
     */
    OMA_DRM("05", "OMA DRM"),

    /**
     * Has Licensed Content Protection DRM applied by a Readium License Server
     */
    Readium_LCP_DRM("06", "Readium LCP DRM"),

    /**
     * Has Sony DADC User Rights Management (URMS) DRM protection applied
     */
    Sony_DRM("07", "Sony DRM");

    public final String code;
    public final String description;

    EpublicationTechnicalProtections(String code, String description) {
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

    private static volatile Map<String, EpublicationTechnicalProtections> map;

    private static Map<String, EpublicationTechnicalProtections> map() {
        Map<String, EpublicationTechnicalProtections> result = map;
        if (result == null) {
            synchronized (EpublicationTechnicalProtections.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (EpublicationTechnicalProtections e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static EpublicationTechnicalProtections byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }
}
