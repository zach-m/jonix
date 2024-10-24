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

import java.util.Optional;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * marker interface to assist in IDE navigation to code-list 262 (Carbon/GHG emissions certification scheme)
 */
interface CodeList262 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 262</b>
 * <p>
 * Description: Carbon/GHG emissions certification scheme
 * <p>
 * JONIX adds: Not included in Onix2
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href="https://ns.editeur.org/onix/en/">ONIX online Codelist browser</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_67.html#codelist262">ONIX
 *      Codelist 262 in Reference Guide</a>
 */
public enum CarbonGhgEmissionsCertificationSchemes implements OnixCodelist, CodeList262 {
    /**
     * Product carries - or is eligible to carry - Blue Angel labelling. See https://www.blauer-engel.de
     */
    Blue_Angel("101", "Blue Angel"),

    /**
     * Product carries - or is eligible to carry - C2C labelling. Has bronze, silver, gold and platinum levels. See
     * c2ccertified.org
     */
    Cradle_to_Cradle("102", "Cradle to Cradle"),

    /**
     * See https://www.nordic-swan-ecolabel.org
     */
    Nordic_Swan("103", "Nordic Swan"),

    /**
     * See https://www.climatepartner.com/en/take-action/measure-carbon-footprints/product-carbon-footprint-pcf
     */
    ClimatePartner("104", "ClimatePartner"),

    /**
     * See www.ecolabel.eu
     */
    EU_Ecolabel("105", "EU Ecolabel"),

    /**
     * Indicates the product is certified as vegan (does not use animal products, for example in binding or adhesives).
     * See v-label.com
     */
    V_Label("501", "V-Label");

    public final String code;
    public final String description;

    CarbonGhgEmissionsCertificationSchemes(String code, String description) {
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

    public static CarbonGhgEmissionsCertificationSchemes byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        for (CarbonGhgEmissionsCertificationSchemes e : values()) {
            if (e.code.equals(code)) {
                return e;
            }
        }
        return null;
    }

    public static Optional<CarbonGhgEmissionsCertificationSchemes> byCodeOptional(String code) {
        return Optional.ofNullable(byCode(code));
    }

    public static String codeToDesciption(String code) {
        return byCodeOptional(code).map(c -> c.description).orElse(null);
    }
}
