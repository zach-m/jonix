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
 * marker interface to assist in IDE navigation to code-list 92 (Supplier identifier type)
 */
interface CodeList92 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 92</b>
 * <p>
 * Description: Supplier identifier type
 *
 * @see <a href="http://www.editeur.org/14/code-lists">About ONIX Codelists</a>
 * @see <a href="http://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_32.html#codelist92">ONIX
 * Codelist 92 in Reference Guide</a>
 */
public enum SupplierIdentifierTypes implements OnixCodelist, CodeList92 {
    Proprietary("01", "Proprietary"), //

    /**
     * DEPRECATED - use 01
     */
    Proprietary_("02", "Proprietary"), //

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
     * Flemish supplier code
     */
    Distributeurscode_Boekenbank("12", "Distributeurscode Boekenbank"), //

    /**
     * Flemish publisher code
     */
    Fondscode_Boekenbank("13", "Fondscode Boekenbank"), //

    /**
     * Identifier for a business organization for VAT purposes, eg within the EU's VIES system. See
     * http://ec.europa.eu/taxation_customs/vies/faqvies.do for EU VAT ID formats, which vary from country to country.
     * Generally these consist of a two-letter country code followed by the 8-12 digits of the national VAT ID. Some
     * countries include one or two letters within their VAT ID. See http://en.wikipedia.org/wiki/VAT_identification_number
     * for non-EU countries that maintain similar identifiers. Spaces, dashes etc should be omitted
     */
    VAT_Identity_Number("23", "VAT Identity Number");

    public final String code;
    public final String description;

    private SupplierIdentifierTypes(String code, String description) {
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

    private static volatile Map<String, SupplierIdentifierTypes> map;

    private static Map<String, SupplierIdentifierTypes> map() {
        Map<String, SupplierIdentifierTypes> result = map;
        if (result == null) {
            synchronized (SupplierIdentifierTypes.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (SupplierIdentifierTypes e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static SupplierIdentifierTypes byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }
}
