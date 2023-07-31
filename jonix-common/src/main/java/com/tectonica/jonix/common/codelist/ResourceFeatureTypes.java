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
 * marker interface to assist in IDE navigation to code-list 160 (Resource feature type)
 */
interface CodeList160 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 160</b>
 * <p>
 * Description: Resource feature type
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_62.html#codelist160">ONIX
 *      Codelist 160 in Reference Guide</a>
 */
public enum ResourceFeatureTypes implements OnixCodelist, CodeList160 {
    /**
     * Credit that must be displayed when a resource is used (eg 'Photo Jerry Bauer' or '&#169; Magnum Photo'). Credit
     * text should be carried in &lt;FeatureNote&gt;
     */
    Required_credit("01", "Required credit"),

    /**
     * Explanatory caption that may accompany a resource (eg use to identify an author in a photograph). Caption text
     * should be carried in &lt;FeatureNote&gt;
     */
    Caption("02", "Caption"),

    /**
     * Copyright holder of resource (indicative only, as the resource can be used without consultation). Copyright text
     * should be carried in &lt;FeatureNote&gt;
     */
    Copyright_holder("03", "Copyright holder"),

    /**
     * Approximate length in minutes of an audio or video resource. &lt;FeatureValue&gt; should contain the length of
     * time as an integer number of minutes
     */
    Length_in_minutes("04", "Length in minutes"),

    /**
     * Use to link resource to a contributor unambiguously, for example with Resource Content types 04, 11-14 from List
     * 158, particularly where the product has more than a single contributor. &lt;FeatureValue&gt; contains the
     * 16-digit ISNI, which must match an ISNI given in an instance of &lt;Contributor&gt;
     */
    ISNI_of_resource_contributor("05", "ISNI of resource contributor"),

    /**
     * Use to link resource to a contributor unambiguously, for example with Resource Content types 04, 11-14 from List
     * 158, particularly where the product has more than a single contributor. &lt;FeatureValue&gt; contains the
     * proprietary ID, which must match a proprietary ID given in an instance of &lt;Contributor&gt;
     */
    Proprietary_ID_of_resource_contributor("06", "Proprietary ID of resource contributor"),

    /**
     * &lt;FeatureNote&gt; is Alternative text for the resource, which might be presented to visually-impaired readers
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Resource_alternative_text("07", "Resource alternative text"),

    /**
     * &lt;FeatureValue&gt; is a 24-bit RGB or 32-bit RBGA color in hexadecimal, eg fff2de for an opaque warm cream.
     * Used when the resource - for example a 3D image of the product - includes a background, or if used with an alpha
     * channel, when the image is irregularly shaped or contains a semi-transparent shadow thrown against a background
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Background_color_of_image_resource("08", "Background color of image resource"),

    /**
     * &lt;FeatureValue&gt; is an ONIX code from List 256 that describes an attribute of a product image resource (eg
     * perspective, content)
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Attribute_of_product_image_resource("09", "Attribute of product image resource"),

    /**
     * &lt;FeatureValue&gt; is a 24-bit RGB color in hexadecimal, eg ffc300 for a rich yellow-orange, used when the
     * resource supplier requests a specific background color be displayed behind the resource on a web page
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Background_color_of_page("10", "Background color of page");

    public final String code;
    public final String description;

    ResourceFeatureTypes(String code, String description) {
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

    private static volatile Map<String, ResourceFeatureTypes> map;

    private static Map<String, ResourceFeatureTypes> map() {
        Map<String, ResourceFeatureTypes> result = map;
        if (result == null) {
            synchronized (ResourceFeatureTypes.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (ResourceFeatureTypes e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static ResourceFeatureTypes byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }

    public static Optional<ResourceFeatureTypes> byCodeOptional(String code) {
        return Optional.ofNullable(byCode(code));
    }

    public static String codeToDesciption(String code) {
        return byCodeOptional(code).map(c -> c.description).orElse(null);
    }
}
