/*
 * Copyright (C) 2012-2023 Zach Melamed
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
 * marker interface to assist in IDE navigation to code-list 256 (Resource feature code)
 */
interface CodeList256 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 256</b>
 * <p>
 * Description: Resource feature code
 * <p>
 * Jonix-Comment: Introduced in Onix3
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_61.html#codelist256">ONIX
 *      Codelist 256 in Reference Guide</a>
 */
public enum ResourceFeatures implements OnixCodelist, CodeList256 {
    /**
     * Image shows retail product only, in packaging
     */
    Image_shows_product_in_packaging("01", "Image shows product in packaging"),

    /**
     * Image shows retail product only, without packaging
     */
    Image_shows_product_without_packaging("02", "Image shows product (without packaging)"),

    /**
     * Image shows product (with or without packaging) and accessory items not included with product
     */
    Image_shows_product_and_accessories("03", "Image shows product and accessories"),

    /**
     * Image shows product in final form (eg an assembled toy or model, completed puzzle)
     */
    Image_shows_assembled_product("04", "Image shows assembled product"),

    /**
     * Image shows product in use by a person or people
     */
    Image_shows_product_in_use("05", "Image shows product in use"),

    /**
     * Image shows multiple copies of the product, or multiple related products
     */
    Image_shows_multiple_products("06", "Image shows multiple products"),

    /**
     * Image shows part of product, for example inside pages of a book or detail of part of a toy
     */
    Image_shows_detail_of_product("07", "Image shows detail of product"),

    /**
     * Shows front cover, spine and top edge of pages (or equivalent for non-book products or packaging)
     */
    _3D_perspective_front("21", "3D perspective ‘front’"),

    /**
     * Shows back cover, spine and top edge of pages (or equivalent for non-book products or packaging)
     */
    _3D_perspective_back("22", "3D perspective ‘back’"),

    /**
     * Shows front cover, foredge and top edge of pages (or equivalent for non-book products or packaging)
     */
    _3D_perspective_front_foredge("23", "3D perspective ‘front foredge’"),

    /**
     * Shows back cover, foredge and top edge of pages (or equivalent for non-book products or packaging)
     */
    _3D_perspective_back_foredge("24", "3D perspective ‘back foredge’"),

    /**
     * Shows front cover and spine (or equivalent for non-book products or packaging)
     */
    _3D_perspective_front_low("33", "3D perspective ‘front low’"),

    /**
     * Shows back cover and spine (or equivalent for non-book products or packaging)
     */
    _3D_perspective_back_low("34", "3D perspective ‘back low’"),

    /**
     * Shows front cover and foredge (or equivalent for non-book products or packaging)
     */
    _3D_perspective_front_foredge_low("35", "3D perspective ‘front foredge low’"),

    /**
     * Shows back cover and foredge (or equivalent for non-book products or packaging)
     */
    _3D_perspective_back_foredge_low("36", "3D perspective ‘back foredge low’"),

    /**
     * Shows front cover only (or equivalent for non-book products or packaging)
     */
    _2D_front("41", "2D front"),

    /**
     * Shows back cover only (or equivalent for non-book products or packaging)
     */
    _2D_back("42", "2D back"),

    /**
     * Shows spine only (or equivalent for non-book products or packaging)
     */
    _2D_spine("43", "2D spine"),

    /**
     * Product is horizontal (eg lying on table)
     */
    _3D_perspective_horizontal("47", "3D perspective ‘horizontal’"),

    /**
     * Product is vertical (eg standing on table)
     */
    _3D_perspective_vertical("48", "3D perspective ‘vertical’");

    public final String code;
    public final String description;

    ResourceFeatures(String code, String description) {
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

    private static volatile Map<String, ResourceFeatures> map;

    private static Map<String, ResourceFeatures> map() {
        Map<String, ResourceFeatures> result = map;
        if (result == null) {
            synchronized (ResourceFeatures.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (ResourceFeatures e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static ResourceFeatures byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }

    public static Optional<ResourceFeatures> byCodeOptional(String code) {
        return Optional.ofNullable(byCode(code));
    }

    public static String codeToDesciption(String code) {
        return byCodeOptional(code).map(c -> c.description).orElse(null);
    }
}
