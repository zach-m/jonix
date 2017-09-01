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

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * marker interface to assist in IDE navigation to code-list 57 (Unpriced item type code)
 */
interface CodeList57 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 57</b>
 * <p>
 * Description: Unpriced item type code
 *
 * @see <a href="http://www.editeur.org/14/code-lists">About ONIX Codelists</a>
 * @see <a href="http://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_32.html#codelist57">ONIX
 * Codelist 57 in Reference Guide</a>
 */
public enum UnpricedItemTypes implements OnixCodelist, CodeList57 {
    Free_of_charge("01", "Free of charge"), //

    Price_to_be_announced("02", "Price to be announced"), //

    /**
     * Not sold separately at retail
     */
    Not_sold_separately("03", "Not sold separately"), //

    /**
     * May be used for books that do not carry a recommended retail price; when goods can only be ordered 'in person'
     * from a sales representative; when an ONIX file is 'broadcast' rather than sent one-to-one to a single trading
     * partner; or for digital products offered on subscription or with pricing which is too complex to specify in ONIX
     */
    Contact_supplier("04", "Contact supplier"), //

    /**
     * When a collection that is not sold as a set nevertheless has its own ONIX record
     */
    Not_sold_as_set("05", "Not sold as set"), //

    /**
     * Unpriced, but available via a pre-determined revenue share agreement &lt;p&gt;NOTE: Introduced in Onix3
     */
    Revenue_share("06", "Revenue share");

    public final String code;
    public final String description;

    private UnpricedItemTypes(String code, String description) {
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

    public static UnpricedItemTypes byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        for (UnpricedItemTypes e : values()) {
            if (e.code.equals(code)) {
                return e;
            }
        }
        return null;
    }
}
