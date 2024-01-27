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
 * marker interface to assist in IDE navigation to code-list 9 (Product classification type)
 */
interface CodeList9 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 9</b>
 * <p>
 * Description: Product classification type
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_64.html#codelist9">ONIX
 *      Codelist 9 in Reference Guide</a>
 */
public enum ProductClassificationTypes implements OnixCodelist, CodeList9 {
    /**
     * World Customs Organization Harmonized Commodity Coding and Description System, the basis of most other commodity
     * code schemes. Use 6 digits, without punctuation. See
     * https://www.wcoomd.org/en/topics/nomenclature/instrument-and-tools/hs-nomenclature-2022-edition.aspx and
     * https://www.wcotradetools.org/en/harmonized-system
     */
    WCO_Harmonized_System("01", "WCO Harmonized System"),

    /**
     * UN Standard Product and Service Classification, including national versions adopted without any additions or
     * changes to the codes or their meaning. Use 8 (or occasionally 10) digits, without punctuation
     */
    UNSPSC("02", "UNSPSC"),

    /**
     * UK Revenue and Customs classifications, based on the Harmonized System (8 or 10 digits, without punctuation, for
     * exports from and imports into the UK respectively). See https://www.gov.uk/trade-tariff
     */
    HMRC("03", "HMRC"),

    /**
     * German export trade classification, based on the Harmonised System
     */
    Warenverzeichnis_fur_die_Auenhandelsstatistik("04", "Warenverzeichnis für die Außenhandelsstatistik"),

    /**
     * EU TARIC codes, an extended version of the Harmonized System primarily for imports into the EU. Use 10 digits,
     * without punctuation. See
     * https://taxation-customs.ec.europa.eu/customs-4/calculation-customs-duties/customs-tariff/eu-customs-tariff-taric_en
     */
    TARIC("05", "TARIC"),

    /**
     * Centraal Boekhuis free classification field for publishers
     */
    Fondsgroep("06", "Fondsgroep"),

    /**
     * A product category (not a subject classification) assigned by the sender
     */
    Senders_product_category("07", "Sender’s product category"),

    /**
     * Product classification maintained by the Chinese General Administration of Press and Publication
     * (http://www.gapp.gov.cn)
     */
    GAPP_Product_Class("08", "GAPP Product Class"),

    /**
     * Statistical Classification of Products by Activity in the European Economic Community, see
     * http://ec.europa.eu/eurostat/ramon/nomenclatures/index.cfm?TargetUrl=LST_NOM_DTL&amp;StrNom=CPA_2008. Use 6
     * digits, without punctuation. For example, printed children's books are '58.11.13', but the periods are normally
     * ommited in ONIX
     */
    CPA("09", "CPA"),

    /**
     * Mercosur/Mercosul Common Nomenclature, based on the Harmonised System. Use 8 digits, without punctuation
     */
    NCM("10", "NCM"),

    /**
     * Common Procurement Vocabulary, uses to describe requirements for tender for public tendering and procurement
     * within the EU. Code is a nine digit number (including the check digit). See
     * http://eur-lex.europa.eu/legal-content/EN/TXT/?uri=URISERV:l22008
     */
    CPV("11", "CPV"),

    /**
     * Polish Classification of Products and Services (2015). Use a single letter followed by 2 to 7 digits, without
     * punctuation. Only for use in ONIX 3.0 or later
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    PKWiU("12", "PKWiU"),

    /**
     * US HTS (or HTSA) commodity codes for import of goods into USA (10 digits, without punctuation). Only for use in
     * ONIX 3.0 or later. See https://hts.usitc.gov/current
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    HTSUS("13", "HTSUS"),

    /**
     * US Schedule B commodity codes for export from USA (10 digits, without punctuation). Only for use in ONIX 3.0 or
     * later. See http://uscensus.prod.3ceonline.com
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    US_Schedule_B("14", "US Schedule B"),

    /**
     * Mexican SAT classification, based on UN SPSC with later modifications (8 digits, without punctuation). Only for
     * use in ONIX 3.0 or later. See https://www.sat.gob.mx/consultas/53693/catalogo-de-productos-y-servicios
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Clave_SAT("15", "Clave SAT"),

    /**
     * EU Combined Nomenclature commodity codes, an extended version of the Harmonized System primarily for exports from
     * the EU. Use 8 digits, without punctuation. Only for use in ONIX 3.0 or later. See
     * https://trade.ec.europa.eu/access-to-markets/en/content/combined-nomenclature-0
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    CN("16", "CN"),

    /**
     * Canadian Customs Tariff scheme, 8 or 10 digits for imports into and exports from Canada. Only for use in ONIX 3.0
     * or later. See https://www.cbsa-asfc.gc.ca/trade-commerce/tariff-tarif/menu-eng.html
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    CCT("17", "CCT"),

    /**
     * Australian 'Working tariff'. Combined Australian Customs Tariff Nomenclature and Statistical Classification. Only
     * for use in ONIX 3.0 or later. See
     * https://www.abf.gov.au/importing-exporting-and-manufacturing/tariff-classification
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    CACT("18", "CACT"),

    /**
     * Mexican N&#250;mero de Identificaci&#243;n Comercial, 10 digits for imports into and exports from Mexico. Only
     * for use in ONIX 3.0 or later. See https://www.snice.gob.mx/cs/avi/snice/nico.ligie.html
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    NICO("19", "NICO"),

    /**
     * Typologie de march&#233; g&#233;r&#233; par Electre (Market segment code maintained by Electre)
     */
    Electre_genre("50", "Electre genre");

    public final String code;
    public final String description;

    ProductClassificationTypes(String code, String description) {
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

    private static volatile Map<String, ProductClassificationTypes> map;

    private static Map<String, ProductClassificationTypes> map() {
        Map<String, ProductClassificationTypes> result = map;
        if (result == null) {
            synchronized (ProductClassificationTypes.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (ProductClassificationTypes e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static ProductClassificationTypes byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }

    public static Optional<ProductClassificationTypes> byCodeOptional(String code) {
        return Optional.ofNullable(byCode(code));
    }

    public static String codeToDesciption(String code) {
        return byCodeOptional(code).map(c -> c.description).orElse(null);
    }
}
