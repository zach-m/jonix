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

package com.tectonica.jonix.codelist;

import com.tectonica.jonix.OnixCodelist;

import java.util.HashMap;
import java.util.Map;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * marker interface to assist in IDE navigation to code-list 44 (Name code type)
 */
interface CodeList44 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 44</b>
 * <p>
 * Description: Name code type
 *
 * @see <a href="http://www.editeur.org/14/code-lists">About ONIX Codelists</a>
 * @see <a href="http://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_32.html#codelist44">ONIX
 * Codelist 44 in Reference Guide</a>
 */
public enum NameCodeTypes implements OnixCodelist, CodeList44 {
    Proprietary("01", "Proprietary"), //

    /**
     * DEPRECATED - use 01
     */
    Proprietary_("02", "Proprietary"), //

    /**
     * Deutsche Nationalbibliothek publisher identifier
     */
    DNB_publisher_identifier("03", "DNB publisher identifier"), //

    B_rsenverein_Verkehrsnummer("04", "Börsenverein Verkehrsnummer"), //

    German_ISBN_Agency_publisher_identifier("05", "German ISBN Agency publisher identifier"), //

    /**
     * GS1 global location number (formerly EAN location number)
     */
    GLN("06", "GLN"), //

    /**
     * Book trade Standard Address Number - US, UK etc
     */
    SAN("07", "SAN"), //

    /**
     * MARC code list for organizations - see http://www.loc.gov/marc/organizations/orgshome.html &lt;p&gt;NOTE:
     * Introduced in Onix3
     */
    MARC_organization_code("08", "MARC organization code"), //

    /**
     * Trading party identifier used in the Netherlands
     */
    Centraal_Boekhuis_Relatie_ID("10", "Centraal Boekhuis Relatie ID"), //

    /**
     * Flemish publisher code
     */
    Fondscode_Boekenbank("13", "Fondscode Boekenbank"), //

    /**
     * Business Identity Code (Finland). See http://www.ytj.fi/ (in Finnish)
     */
    Y_tunnus("15", "Y-tunnus"), //

    /**
     * International Standard Name Identifier. See http://www.isni.org/
     */
    ISNI("16", "ISNI"), //

    /**
     * Personennamendatei - person name authority file used by Deutsche Nationalbibliothek and in other German-speaking
     * countries. See http://www.d-nb.de/standardisierung/normdateien/pnd.htm (German) or
     * http://www.d-nb.de/eng/standardisierung/normdateien/pnd.htm (English). DEPRECATED in favour of the GND
     */
    PND("17", "PND"), //

    /**
     * A control number assigned to a Library of Congress Name Authority record
     */
    LCCN("18", "LCCN"), //

    /**
     * Publisher identifier administered by Japanese ISBN Agency
     */
    Japanese_Publisher_identifier("19", "Japanese Publisher identifier"), //

    /**
     * Gemeinsame K&#246;rperschaftsdatei - Corporate Body Authority File in the German-speaking countries. See
     * http://www.d-nb.de/standardisierung/normdateien/gkd.htm (German) or http://www.d-nb.de/eng/standardisierung/normdateien/gkd.htm
     * (English). DEPRECATED in favour of the GND
     */
    GKD("20", "GKD"), //

    /**
     * Open Researcher and Contributor ID. See http://www.orcid.org/
     */
    ORCID("21", "ORCID"), //

    /**
     * Publisher identifier maintained by the Chinese ISBN Agency (GAPP)
     */
    GAPP_Publisher_Identifier("22", "GAPP Publisher Identifier"), //

    /**
     * Identifier for a business organization for VAT purposes, eg within the EU's VIES system. See
     * http://ec.europa.eu/taxation_customs/vies/faqvies.do for EU VAT ID formats, which vary from country to country.
     * Generally these consist of a two-letter country code followed by the 8-12 digits of the national VAT ID. Some
     * countries include one or two letters within their VAT ID. See http://en.wikipedia.org/wiki/VAT_identification_number
     * for non-EU countries that maintain similar identifiers. Spaces, dashes etc should be omitted
     */
    VAT_Identity_Number("23", "VAT Identity Number"), //

    /**
     * 4-digit business organization identifier controlled by the Japanese Publication Wholesalers Association
     */
    JP_Distribution_Identifier("24", "JP Distribution Identifier"), //

    /**
     * Gemeinsame Normdatei - Joint Authority File in the German-speaking countries. See http://www.dnb.de/EN/gnd
     * (English). Combines the PND, SWD and GKD into a single authority file, and should be used in preference
     */
    GND("25", "GND"), //

    /**
     * Dunn and Bradstreet Universal Numbering System, see http://www.dnb.co.uk/dandb-duns-number
     */
    DUNS("26", "DUNS"), //

    /**
     * Ringgold organizational identifier, see http://www.ringgold.com/pages/identify.html
     */
    Ringgold_ID("27", "Ringgold ID"), //

    /**
     * French Electre publisher identifier
     */
    Identifiant_Editeur_Electre("28", "Identifiant Editeur Electre"), //

    /**
     * DOI used in EIDR party registry, for example '10.5237/C9F6-F41F' (Sam Raimi). See http://eidr.org &lt;p&gt;NOTE:
     * Introduced in Onix3
     */
    EIDR_Party_DOI("29", "EIDR Party DOI"), //

    /**
     * French Electre imprint Identifier
     */
    Identifiant_Marque_Electre("30", "Identifiant Marque Electre"), //

    /**
     * Virtual Internet Authority File. &lt;IDValue&gt; should be a number. The URI form of the identifier can be
     * created by prefixing the number with 'https://viaf.org/viaf/'. See https://viaf.org &lt;p&gt;NOTE: Introduced in
     * Onix3
     */
    VIAF_ID("31", "VIAF ID"), //

    /**
     * DOI used in CrossRef's Fundref list of academic research funding bodies, for example '10.13039/100004440'
     * (Wellcome Trust). See http://www.crossref.org/fundref/fundref_registry.html
     */
    FundRef_DOI("32", "FundRef DOI");

    public final String code;
    public final String description;

    private NameCodeTypes(String code, String description) {
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

    private static volatile Map<String, NameCodeTypes> map;

    private static Map<String, NameCodeTypes> map() {
        Map<String, NameCodeTypes> result = map;
        if (result == null) {
            synchronized (NameCodeTypes.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (NameCodeTypes e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static NameCodeTypes byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }
}
