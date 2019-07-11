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
 * marker interface to assist in IDE navigation to code-list 204 (ONIX Returns conditions)
 */
interface CodeList204 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 204</b>
 * <p>
 * Description: ONIX Returns conditions
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_45.html#codelist204">ONIX
 *      Codelist 204 in Reference Guide</a>
 */
public enum OnixReturnsConditionss implements OnixCodelist, CodeList204 {
    /**
     * Unspecified, contact supplier for details
     */
    Unspecified("00", "Unspecified"), //

    /**
     * The retailer pays for goods only after they are sold by the retailer to an end consumer, and may return excess
     * unsold inventory to the supplier at any time. The goods remain the property of the supplier until they are paid
     * for, even while they are physically located at the retailer
     */
    Consignment("01", "Consignment"), //

    /**
     * The retailer is invoiced and pays immediately as in the sale or return model, but any excess unsold inventory
     * cannot be returned to the supplier
     */
    Firm_sale("02", "Firm sale"), //

    /**
     * Contact supplier for applicable returns authorization process. The retailer is invoiced immediately for the goods
     * and pays within the specified credit period, but can return excess unsold inventory to the supplier for full
     * credit at a later date (some kind of returns authorisation process is normally required and returns must be in
     * saleable conditon, except when return of stripped covers or proof of destruction may be allowed instead)
     */
    Sale_or_return("03", "Sale or return"), //

    /**
     * The retailer pays for goods only after they are sold by the retailer to an end consumer, but all inventory
     * remains physically located at the supplier (thus there can be no returns of unsold inventory). When ordered by
     * the retailer, the goods are delivered direct to the consumer
     */
    Direct_fulfillment("04", "Direct fulfillment");

    public final String code;
    public final String description;

    OnixReturnsConditionss(String code, String description) {
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

    public static OnixReturnsConditionss byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        for (OnixReturnsConditionss e : values()) {
            if (e.code.equals(code)) {
                return e;
            }
        }
        return null;
    }
}
