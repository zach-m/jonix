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

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * marker interface to assist in IDE navigation to code-list 164 (Work relation)
 */
interface CodeList164 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 164</b>
 * <p>
 * Description: Work relation
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_58.html#codelist164">ONIX
 *      Codelist 164 in Reference Guide</a>
 */
public enum WorkRelations implements OnixCodelist, CodeList164 {
    /**
     * Product X is or includes a manifestation of work Y. (There is a direct parent-child relation between work Y and
     * the product)
     */
    Manifestation_of("01", "Manifestation of"),

    /**
     * Product X is or includes a manifestation of a work derived (directly) from related work Y in one or more of the
     * ways specified in ISTC rules. (There is a relationship between a grandparent work Y and a parent work Z, and
     * between that parent work and the product.) This relation type is intended to enable products with a common
     * 'grandparent' work to be linked without specifying the precise nature of their derivation, and without
     * necessarily assigning an identifier to the product's parent
     */
    Derived_from("02", "Derived from"),

    /**
     * Product X is a manifestation of a work from which related work Y is (directly) derived in one or more of the ways
     * specified in ISTC rules. (There is a relationship between a parent work and a child work Y, and between the
     * parent work and the product)
     */
    Related_work_is_derived_from_this("03", "Related work is derived from this"),

    /**
     * Product X is a manifestation of a work in the same collection as related work Y
     */
    Other_work_in_same_collection("04", "Other work in same collection"),

    /**
     * Product X is a manifestation of a work by the same contributor(s) as related work Y
     */
    Other_work_by_same_contributor("05", "Other work by same contributor");

    public final String code;
    public final String description;

    WorkRelations(String code, String description) {
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

    public static WorkRelations byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        for (WorkRelations e : values()) {
            if (e.code.equals(code)) {
                return e;
            }
        }
        return null;
    }
}
