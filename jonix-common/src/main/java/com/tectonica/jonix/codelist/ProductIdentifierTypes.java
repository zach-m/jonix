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
 * marker interface to assist in IDE navigation to code-list 5 (Product identifier type)
 */
interface CodeList5 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 5</b>
 * <p>
 * Description: Product identifier type
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href="https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_45.html#codelist5">ONIX
 * Codelist 5 in Reference Guide</a>
 */
public enum ProductIdentifierTypes implements OnixCodelist, CodeList5 {
    /**
     * For example, a publisher's or wholesaler's product number or SKU. Note that &lt;IDTypeName&gt; is required with
     * proprietary identifiers
     */
    Proprietary("01", "Proprietary"), //

    /**
     * International Standard Book Number, pre-2007 (10 digits, or 9 digits plus X, without spaces or hyphens) - now
     * DEPRECATED in ONIX for Books, except where providing historical information for compatibility with legacy
     * systems. It should only be used in relation to products published before 2007 - when ISBN-13 superseded it - and
     * should never be used as the ONLY identifier (it should always be accompanied by the correct GTIN-13 / ISBN-13)
     */
    ISBN_10("02", "ISBN-10"), //

    /**
     * GS1 Global Trade Item Number, formerly known as EAN article number (13 digits, without spaces or hyphens)
     */
    GTIN_13("03", "GTIN-13"), //

    /**
     * UPC product number (12 digits, without spaces or hyphens)
     */
    UPC("04", "UPC"), //

    /**
     * International Standard Music Number, pre-2008 (M plus nine digits, without spaces or hyphens) - now DEPRECATED in
     * ONIX for Books, except where providing historical information for compatibility with legacy systems. It should
     * only be used in relation to products published before 2008 - when ISMN-13 superseded it - and should never be
     * used as the ONLY identifier (it should always be accompanied by the correct GTIN-12 / ISMN-13)
     */
    ISMN_10("05", "ISMN-10"), //

    /**
     * Digital Object Identifier (variable length and character set beginning '10.', and without https://doi.org/ or the
     * older http://dx.doi.org/)
     */
    DOI("06", "DOI"), //

    /**
     * Library of Congress Control Number in normalized form (up to 12 characters, alphanumeric)
     */
    LCCN("13", "LCCN"), //

    /**
     * GS1 Global Trade Item Number (14 digits, without spaces or hyphens)
     */
    GTIN_14("14", "GTIN-14"), //

    /**
     * International Standard Book Number, from 2007 (13 digits starting 978 or 9791-9799, without spaces or hypens)
     */
    ISBN_13("15", "ISBN-13"), //

    /**
     * The number assigned to a publication as part of a national legal deposit process
     */
    Legal_deposit_number("17", "Legal deposit number"), //

    /**
     * Uniform Resource Name: note that in trade applications an ISBN must be sent as a GTIN-13 and, where required, as
     * an ISBN-13 - it should not be sent as a URN
     */
    URN("22", "URN"), //

    /**
     * A unique number assigned to a bibliographic item by OCLC
     */
    OCLC_number("23", "OCLC number"), //

    /**
     * An ISBN-13 assigned by a co-publisher. The 'main' ISBN sent with &lt;ProductIDType&gt; codes 03 and/or 15 should
     * always be the ISBN that is used for ordering from the supplier identified in &lt;SupplyDetail&gt;. However, ISBN
     * rules allow a co-published title to carry more than one ISBN. The co-publisher should be identified in an
     * instance of the &lt;Publisher&gt; composite, with the applicable &lt;PublishingRole&gt; code
     */
    Co_publisher_s_ISBN_13("24", "Co-publisher’s ISBN-13"), //

    /**
     * International Standard Music Number, from 2008 (13-digit number starting 9790, without spaces or hyphens)
     */
    ISMN_13("25", "ISMN-13"), //

    /**
     * Actionable ISBN, in fact a special DOI incorporating the ISBN-13 within the DOI syntax. Begins '10.978.' or
     * '10.979.' and includes a / character between the registrant element (publisher prefix) and publication element of
     * the ISBN, eg 10.978.000/1234567. Note the ISBN-A should always be accompanied by the ISBN itself, using
     * &lt;ProductIDType&gt; codes 03 and/or 15
     */
    ISBN_A("26", "ISBN-A"), //

    /**
     * E-publication identifier controlled by JPOIID's Committee for Research and Management of Electronic Publishing
     * Codes
     */
    JP_e_code("27", "JP e-code"), //

    /**
     * Unique number assigned by the Chinese Online Library Cataloging Center (see http://olcc.nlc.gov.cn)
     */
    OLCC_number("28", "OLCC number"), //

    /**
     * Japanese magazine identifier, similar in scope to ISSN but identifying a specific issue of a serial publication.
     * Five digits to identify the periodical, plus a hyphen and two digits to identify the issue
     */
    JP_Magazine_ID("29", "JP Magazine ID"), //

    /**
     * Used only with comic books and other products which use the UPC extension to identify individual issues or
     * products. Do not use where the UPC12 itself identifies the specific product, irrespective of any 5-digit
     * extension - use code 04 instead
     */
    UPC12_5("30", "UPC12+5"), //

    /**
     * Num&#233;ro de la notice bibliographique BNF
     */
    BNF_Control_number("31", "BNF Control number"), //

    /**
     * Archival Resource Key, as a URL (including the address of the ARK resolver provided by eg a national library)
     */
    ARK("35", "ARK");

    public final String code;
    public final String description;

    ProductIdentifierTypes(String code, String description) {
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

    private static volatile Map<String, ProductIdentifierTypes> map;

    private static Map<String, ProductIdentifierTypes> map() {
        Map<String, ProductIdentifierTypes> result = map;
        if (result == null) {
            synchronized (ProductIdentifierTypes.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (ProductIdentifierTypes e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static ProductIdentifierTypes byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }
}
