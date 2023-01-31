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
 * marker interface to assist in IDE navigation to code-list 57 (Unpriced item type)
 */
interface CodeList57 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 57</b>
 * <p>
 * Description: Unpriced item type
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_60.html#codelist57">ONIX
 *      Codelist 57 in Reference Guide</a>
 */
public enum UnpricedItemTypes implements OnixCodelist, CodeList57 {
    Free_of_charge("01", "Free of charge"),

    Price_to_be_announced("02", "Price to be announced"),

    /**
     * Not sold separately at retail
     */
    Not_sold_separately("03", "Not sold separately"),

    /**
     * May be used for books that do not carry a recommended retail price; when goods can only be ordered 'in person'
     * from a sales representative; when an ONIX file is 'broadcast' rather than sent one-to-one to a single trading
     * partner; or for digital products offered on subscription or with pricing which is too complex to specify in ONIX
     */
    Contact_supplier("04", "Contact supplier"),

    /**
     * When a collection that is not sold as a set nevertheless has its own ONIX record
     */
    Not_sold_as_set("05", "Not sold as set"),

    /**
     * Unpriced, but available via a pre-determined revenue share agreement
     */
    Revenue_share("06", "Revenue share"),

    /**
     * Price calculated as sum of individual prices of components listed as Product parts. For use in ONIX 3.0 only
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Calculated_from_contents("07", "Calculated from contents"),

    /**
     * The supplier does not operate, or does not offer this product, in this part of the market as indicated by
     * &lt;territory&gt;?. Use when other prices apply in different parts of the market (eg when the market is global,
     * but the particular supplier does not operate outside its domestic territory). Use code 04 when the supplier does
     * supply but has not set a price for part of the market. For use in ONIX 3.0 only
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Supplier_does_not_supply("08", "Supplier does not supply");

    public final String code;
    public final String description;

    UnpricedItemTypes(String code, String description) {
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

    private static volatile Map<String, UnpricedItemTypes> map;

    private static Map<String, UnpricedItemTypes> map() {
        Map<String, UnpricedItemTypes> result = map;
        if (result == null) {
            synchronized (UnpricedItemTypes.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (UnpricedItemTypes e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static UnpricedItemTypes byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }
}
