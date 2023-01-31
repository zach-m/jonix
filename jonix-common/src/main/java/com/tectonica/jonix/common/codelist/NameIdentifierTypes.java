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

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * marker interface to assist in IDE navigation to code-list 44 (Name identifier type)
 */
interface CodeList44 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 44</b>
 * <p>
 * Description: Name identifier type
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_60.html#codelist44">ONIX
 *      Codelist 44 in Reference Guide</a>
 */
public enum NameIdentifierTypes implements OnixCodelist, CodeList44 {
    /**
     * Note that &lt;IDTypeName&gt; is required with proprietary identifiers
     */
    Proprietary("01", "Proprietary"),

    /**
     * DEPRECATED - use 01
     */
    Proprietary_("02", "Proprietary"),

    /**
     * Deutsche Nationalbibliothek publisher identifier
     */
    DNB_publisher_identifier("03", "DNB publisher identifier"),

    Borsenverein_Verkehrsnummer("04", "Börsenverein Verkehrsnummer"),

    German_ISBN_Agency_publisher_identifier("05", "German ISBN Agency publisher identifier"),

    /**
     * GS1 global location number (formerly EAN location number)
     */
    GLN("06", "GLN"),

    /**
     * Book trade Standard Address Number - US, UK etc
     */
    SAN("07", "SAN"),

    /**
     * MARC code list for organizations - see http://www.loc.gov/marc/organizations/orgshome.html
     */
    MARC_organization_code("08", "MARC organization code"),

    /**
     * Trading party identifier used in the Netherlands
     */
    Centraal_Boekhuis_Relatie_ID("10", "Centraal Boekhuis Relatie ID"),

    /**
     * Flemish supplier code. For use in ONIX 3.0 only
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Distributeurscode_Boekenbank("12", "Distributeurscode Boekenbank"),

    /**
     * Flemish publisher code
     */
    Fondscode_Boekenbank("13", "Fondscode Boekenbank"),

    /**
     * Business Identity Code (Finland). See http://www.ytj.fi/ (in Finnish)
     */
    Y_tunnus("15", "Y-tunnus"),

    /**
     * International Standard Name Identifier. A sixteen digit number. Usually presented with spaces or hyphens dividing
     * the number into four groups of four digits, but in ONIX the spaces or hyphens should be omitted. See
     * https://isni.org/
     */
    ISNI("16", "ISNI"),

    /**
     * Personennamendatei - person name authority file used by Deutsche Nationalbibliothek and in other German-speaking
     * countries. See http://www.dnb.de/standardisierung/normdateien/pnd.htm (German) or
     * http://www.dnb.de/eng/standardisierung/normdateien/pnd.htm (English). DEPRECATED in favor of the GND
     */
    PND("17", "PND"),

    /**
     * A control number assigned to a Library of Congress Control Number (LCCN) Name Authority / NACO record
     */
    NACO("18", "NACO"),

    /**
     * Publisher identifier administered by Japanese ISBN Agency
     */
    Japanese_Publisher_identifier("19", "Japanese Publisher identifier"),

    /**
     * Gemeinsame K&#246;rperschaftsdatei - Corporate Body Authority File in the German-speaking countries. See
     * http://www.dnb.de/standardisierung/normdateien/gkd.htm (German) or
     * http://www.dnb.de/eng/standardisierung/normdateien/gkd.htm (English). DEPRECATED in favor of the GND
     */
    GKD("20", "GKD"),

    /**
     * Open Researcher and Contributor ID. A sixteen digit number. Usually presented with hyphens dividing the number
     * into four groups of four digits, but in ONIX the hyphens should be omitted. See http://www.orcid.org/
     */
    ORCID("21", "ORCID"),

    /**
     * Publisher identifier maintained by the Chinese ISBN Agency (GAPP)
     */
    GAPP_Publisher_Identifier("22", "GAPP Publisher Identifier"),

    /**
     * Identifier for a business organization for VAT purposes, eg within the EU's VIES system. See
     * http://ec.europa.eu/taxation_customs/vies/faqvies.do for EU VAT ID formats, which vary from country to country.
     * Generally these consist of a two-letter country code followed by the 8-12 digits of the national VAT ID. Some
     * countries include one or two letters within their VAT ID. See
     * http://en.wikipedia.org/wiki/VAT_identification_number for non-EU countries that maintain similar identifiers.
     * Spaces, dashes etc should be omitted
     */
    VAT_Identity_Number("23", "VAT Identity Number"),

    /**
     * 4-digit business organization identifier controlled by the Japanese Publication Wholesalers Association
     */
    JP_Distribution_Identifier("24", "JP Distribution Identifier"),

    /**
     * Gemeinsame Normdatei - Joint Authority File in the German-speaking countries. See http://www.dnb.de/EN/gnd
     * (English). Combines the PND, SWD and GKD into a single authority file, and should be used in preference
     */
    GND("25", "GND"),

    /**
     * Dunn and Bradstreet Universal Numbering System, see http://www.dnb.co.uk/dandb-duns-number
     */
    DUNS("26", "DUNS"),

    /**
     * Ringgold organizational identifier, see http://www.ringgold.com/identify.html
     */
    Ringgold_ID("27", "Ringgold ID"),

    /**
     * French Electre publisher identifier
     */
    Identifiant_Editeur_Electre("28", "Identifiant Editeur Electre"),

    /**
     * DOI used in EIDR party registry, for example '10.5237/C9F6-F41F' (Sam Raimi). See http://eidr.org
     */
    EIDR_Party_DOI("29", "EIDR Party DOI"),

    /**
     * French Electre imprint Identifier
     */
    Identifiant_Marque_Electre("30", "Identifiant Marque Electre"),

    /**
     * Virtual Internet Authority File. &lt;IDValue&gt; should be a number. The URI form of the identifier can be
     * created by prefixing the number with 'https://viaf.org/viaf/'. See https://viaf.org
     */
    VIAF_ID("31", "VIAF ID"),

    /**
     * DOI used in CrossRef's Open Funder Registry list of academic research funding bodies, for example
     * '10.13039/100004440' (Wellcome Trust). See http://www.crossref.org/fundingdata/registry.html
     */
    FundRef_DOI("32", "FundRef DOI"),

    /**
     * Control number assigned to a Name Authority record by the Biblioteca Nacional de Espa&#241;a
     */
    BNE_CN("33", "BNE CN"),

    /**
     * Num&#233;ro de la notice de personne BNF
     */
    BNF_Control_Number("34", "BNF Control Number"),

    /**
     * Archival Resource Key, as a URL (including the address of the ARK resolver provided by eg a national library)
     */
    ARK("35", "ARK"),

    /**
     * Nasjonalt autoritetsregister for navn - Norwegian national authority file for personal and corporate names. For
     * use in ONIX 3.0 only
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Nasjonalt_autoritetsregister("36", "Nasjonalt autoritetsregister"),

    /**
     * Global Research Identifier Database ID (see https://www.grid.ac). For use in ONIX 3.0 only. Deprecated - ROR is
     * now generally preferred
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    GRID("37", "GRID"),

    /**
     * Party ID from Identifiers and Standards for Higher Education and Research (fr: Identifiants et
     * R&#233;f&#233;rentiels pour l'enseignement sup&#233;rieur et la recherche). For use in ONIX 3.0 only. See
     * https://www.idref.fr
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    IDRef("38", "IDRef"),

    /**
     * Party ID from CISAC's proprietary Interested Party Information scheme, used primarily in rights and royalies
     * administration. For use in ONIX 3.0 only
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    IPI("39", "IPI"),

    /**
     * Research organisation registry identifier (see https://ror.org), leading 0 followed by 8 alphanumeric characters
     * (including 2-digit checksum). For use in ONIX 3.0 only
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    ROR("40", "ROR"),

    /**
     * Economic Operators Registration and Identification, identifier for businesses that import into or export from the
     * EU. For use in ONIX 3.0 only
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    EORI("41", "EORI");

    public final String code;
    public final String description;

    NameIdentifierTypes(String code, String description) {
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

    private static volatile Map<String, NameIdentifierTypes> map;

    private static Map<String, NameIdentifierTypes> map() {
        Map<String, NameIdentifierTypes> result = map;
        if (result == null) {
            synchronized (NameIdentifierTypes.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (NameIdentifierTypes e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static NameIdentifierTypes byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }
}
