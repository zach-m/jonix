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

import java.util.Optional;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * marker interface to assist in IDE navigation to code-list 243 (Dangerous goods regulations)
 */
interface CodeList243 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 243</b>
 * <p>
 * Description: Dangerous goods regulations
 * <p>
 * Jonix-Comment: Introduced in Onix3
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_61.html#codelist243">ONIX
 *      Codelist 243 in Reference Guide</a>
 */
public enum DangerousGoodsRegulationss implements OnixCodelist, CodeList243 {
    /**
     * The product is not classed as dangerous goods. The default if information is omitted
     */
    Inapplicable("00", "Inapplicable"),

    /**
     * Indicates if the product is generally classed as a hazardous substance. &lt;ProductFormFeatureDescription&gt;
     * must contain a Hazard Class [eg &#8220;Irritant (Category 2)&#8221;] using the Globally Harmonized System of
     * Classification and Labelling of Chemicals
     * (http://www.unece.org/fileadmin/DAM/trans/danger/publi/ghs/ghs_rev08/ST-SG-AC10-30-Rev8e.pdf - Annex 1 contains a
     * list of hazard classes and categories). The text is usually available on the Safety Data Sheet, along with
     * equivalent GHS Hazard Pictograms, and may also be on the product or packaging. Must be accompanied by a Safety
     * Data Sheet URL (see code 06), and is usually accompanied by one or more of codes 02-05 listing the specific
     * chemlcal hazard
     */
    GHS("01", "GHS"),

    /**
     * Indicates the product is classed as a hazardous substance for transportation purposes.
     * &lt;ProductFormFeatureDescription&gt; must contain a 'UN number' (or UNID, 'UN' plus four digits from the list of
     * at http://www.unece.org/fileadmin/DAM/trans/danger/publi/unrec/English/index.pdf) specifying the specific
     * chemical hazard, eg UN1203 is gasoline
     */
    Transport("02", "Transport"),

    /**
     * Indicates the product is classed as a hazardous substance for storage purposes.
     * &lt;ProductFormFeatureDescription&gt; must contain a 'UN number' (or UNID, 'UN' plus four digits from the list of
     * at http://www.unece.org/fileadmin/DAM/trans/danger/publi/unrec/English/index.pdf) specifying the specific
     * chemical hazard, eg UN1203 is gasoline
     */
    Storage("03", "Storage"),

    /**
     * Indicates the product is classed as a hazardous substance for disposal purposes.
     * &lt;ProductFormFeatureDescription&gt; must contain a 'UN number' (or UNID, 'UN' plus four digits from the list of
     * at http://www.unece.org/fileadmin/DAM/trans/danger/publi/unrec/English/index.pdf) specifying the specific
     * chemical hazard, eg UN1203 is gasoline
     */
    Waste("04", "Waste"),

    /**
     * Indicates the product is classed as a hazardous substance for purposes not covered by other codes.
     * &lt;ProductFormFeatureDescription&gt; must contain a 'UN number' (or UNID, 'UN' plus four digits from the list of
     * at http://www.unece.org/fileadmin/DAM/trans/danger/publi/unrec/English/index.pdf) specifying the specific
     * chemical hazard, eg UN1203 is gasoline. Must be accompanied by a Safety Data Sheet URL (see code 06)
     */
    Other("05", "Other"),

    /**
     * (Material) Safety Data Sheet available for the product. &lt;ProductFormFeatureDescription&gt; must contain the
     * URL of documentation
     */
    Safety_data_sheet_available("06", "Safety data sheet available");

    public final String code;
    public final String description;

    DangerousGoodsRegulationss(String code, String description) {
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

    public static DangerousGoodsRegulationss byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        for (DangerousGoodsRegulationss e : values()) {
            if (e.code.equals(code)) {
                return e;
            }
        }
        return null;
    }

    public static Optional<DangerousGoodsRegulationss> byCodeOptional(String code) {
        return Optional.ofNullable(byCode(code));
    }

    public static String codeToDesciption(String code) {
        return byCodeOptional(code).map(c -> c.description).orElse(null);
    }
}
