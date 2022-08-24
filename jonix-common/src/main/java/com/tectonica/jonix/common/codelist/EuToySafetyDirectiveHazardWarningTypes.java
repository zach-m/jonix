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

import java.util.HashMap;
import java.util.Map;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * marker interface to assist in IDE navigation to code-list 184 (EU Toy Safety Directive hazard warning type)
 */
interface CodeList184 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 184</b>
 * <p>
 * Description: EU Toy Safety Directive hazard warning type
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_58.html#codelist184">ONIX
 *      Codelist 184 in Reference Guide</a>
 */
public enum EuToySafetyDirectiveHazardWarningTypes implements OnixCodelist, CodeList184 {
    /**
     * Use to provide positive indication that no warnings are applicable
     */
    No_warning("00", "No warning"),

    Carries_CE_logo("01", "Carries ‘CE’ logo"),

    /**
     * Use to specify age (in years, or years and months). Provide specific wording in
     * &lt;ProductFormFeatureDescription&gt;
     */
    Carries_minimum_age_warning("02", "Carries minimum age warning"),

    /**
     * Carries logo, and must be accompanied by the default warning 'Not suitable for children under 36 months' (or its
     * approved equivalent in a language other than English, as appropriate), unless specific wording is provided in
     * &lt;ProductFormFeatureDescription&gt;. If specific alternative wording is carried in
     * &lt;ProductFormFeatureDescription&gt;, this must be used in place of the default text
     */
    Carries_EU_Toy_Safety_Directive_Unsuitable_for_children_ages_03_warning_logo("03",
        "Carries EU Toy Safety Directive ‘Unsuitable for children ages 0–3’ warning logo"),

    /**
     * Exact text of warning must be included in &lt;ProductFormFeatureDescription&gt;
     */
    Carries_EU_Toy_Safety_Directive_hazard_warning("04", "Carries EU Toy Safety Directive hazard warning"),

    /**
     * Exact text (not in itself a warning) must be included in &lt;ProductFormFeatureDescription&gt;. May be used
     * either without any warning, or as text additional to a warning. Note that if no warnings apply, code 00 can
     * provide positive indication of this. Example uses: 'Suitable for all ages' or 'Adult supervision required'
     */
    Carries_other_text_associated_with_toy_safety("05", "Carries other text associated with toy safety"),

    /**
     * Material Safety Data Sheet (a document required by the EU Toy Safety Directive) available online, typically as a
     * PDF file or similar. &lt;ProductFormFeatureDescription&gt; must carry the URL of the document
     */
    Material_Safety_Data_Sheet_available("06", "Material Safety Data Sheet available"),

    /**
     * Declaration of Conformity (the document that backs up the CE or CA mark) available online, typically as a PDF
     * file or similar. &lt;ProductFormFeatureDescription&gt; must carry the URL of the document
     */
    Declaration_of_Conformity_available("07", "Declaration of Conformity available"),

    /**
     * If specific alternative wording is carried in &lt;ProductFormFeatureDescription&gt;, this must be used in place
     * of the default 'Conforms to EN71' text. For use in ONIX 3.0 only.
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Carries_EN71_conformity_statement("08", "Carries EN71 conformity statement"),

    /**
     * UK Conformity Assessment mark. For use in ONIX 3.0 only
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Carries_UKCA_logo("09", "Carries ‘UKCA’ logo");

    public final String code;
    public final String description;

    EuToySafetyDirectiveHazardWarningTypes(String code, String description) {
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

    private static volatile Map<String, EuToySafetyDirectiveHazardWarningTypes> map;

    private static Map<String, EuToySafetyDirectiveHazardWarningTypes> map() {
        Map<String, EuToySafetyDirectiveHazardWarningTypes> result = map;
        if (result == null) {
            synchronized (EuToySafetyDirectiveHazardWarningTypes.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (EuToySafetyDirectiveHazardWarningTypes e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static EuToySafetyDirectiveHazardWarningTypes byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }
}
