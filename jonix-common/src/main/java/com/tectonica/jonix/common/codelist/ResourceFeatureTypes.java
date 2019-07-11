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
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_45.html#codelist160">ONIX
 *      Codelist 160 in Reference Guide</a>
 */
public enum ResourceFeatureTypes implements OnixCodelist, CodeList160 {
    /**
     * Credit that must be displayed when a resource is used (eg 'Photo Jerry Bauer' or '&#169; Magnum Photo'). Credit
     * text should be carried in &lt;FeatureNote&gt;
     */
    Required_credit("01", "Required credit"), //

    /**
     * Explanatory caption that may accompany a resource (eg use to identify an author in a photograph). Caption text
     * should be carried in &lt;FeatureNote&gt;
     */
    Caption("02", "Caption"), //

    /**
     * Copyright holder of resource (indicative only, as the resource can be used without consultation). Copyright text
     * should be carried in &lt;FeatureNote&gt;
     */
    Copyright_holder("03", "Copyright holder"), //

    /**
     * Approximate length in minutes of an audio or video resource. &lt;FeatureValue&gt; should contain the length of
     * time as an integer number of minutes
     */
    Length_in_minutes("04", "Length in minutes"), //

    /**
     * Use to link resource to a contributor unambiguously, for example with Resource Content types 04, 11-14 from List
     * 158, particularly where the product has more than a single contributor. &lt;FeatureValue&gt; contains the
     * 16-digit ISNI
     */
    ISNI_of_resource_contributor("05", "ISNI of resource contributor"), //

    /**
     * Use to link resource to a contributor unambiguously, for example with Resource Content types 04, 11-14 from List
     * 158, particularly where the product has more than a single contributor. &lt;FeatureValue&gt; contains the
     * proprietary ID, which must match a proprietary ID given in an instance of &lt;Contributor&gt;
     */
    Proprietary_ID_of_resource_contributor("06", "Proprietary ID of resource contributor");

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

    public static ResourceFeatureTypes byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        for (ResourceFeatureTypes e : values()) {
            if (e.code.equals(code)) {
                return e;
            }
        }
        return null;
    }
}
