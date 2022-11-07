/*
 * Copyright (C) 2012-2022 Zach Melamed
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
 * marker interface to assist in IDE navigation to code-list 1 (Notification or update type)
 */
interface CodeList1 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 1</b>
 * <p>
 * Description: Notification or update type
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_59.html#codelist1">ONIX
 *      Codelist 1 in Reference Guide</a>
 */
public enum NotificationOrUpdateTypes implements OnixCodelist, CodeList1 {
    /**
     * Use for a complete record issued earlier than approximately six months before publication
     */
    Early_notification("01", "Early notification"),

    /**
     * Use for a complete record issued to confirm advance information approximately six months before publication; or
     * for a complete record issued after that date and before information has been confirmed from the book-in-hand
     */
    Advance_notification_confirmed("02", "Advance notification (confirmed)"),

    /**
     * Use for a complete record issued to confirm advance information at or just before actual publication date,
     * usually from the book-in-hand, or for a complete record issued at any later date
     */
    Notification_confirmed_on_publication("03", "Notification confirmed on publication"),

    /**
     * In ONIX 3.0 only, use when sending a 'block update' record. A block update implies using the supplied block(s) to
     * update the existing record for the product, replacing only the blocks included in the block update, and leaving
     * other blocks unchanged - for example, replacing old information from Blocks 4 and 6 with the newly-received data
     * while retailing information from Blocks 1-3 and 5 untouched. In previous ONIX releases, and for ONIX 3.0 using
     * other notification types, updating is by replacing the complete record with the newly-received data
     */
    Update_partial("04", "Update (partial)"),

    /**
     * Use when sending an instruction to delete a record which was previously issued. Note that a Delete instruction
     * should NOT be used when a product is cancelled, put out of print, or otherwise withdrawn from sale: this should
     * be handled as a change of Publishing status, leaving the receiver to decide whether to retain or delete the
     * record. A Delete instruction is used ONLY when there is a particular reason to withdraw a record completely, eg
     * because it was issued in error
     */
    Delete("05", "Delete"),

    /**
     * Notice of sale of a product, from one publisher to another: sent by the publisher disposing of the product
     */
    Notice_of_sale("08", "Notice of sale"),

    /**
     * Notice of acquisition of a product, by one publisher from another: sent by the acquiring publisher
     */
    Notice_of_acquisition("09", "Notice of acquisition"),

    /**
     * ONIX 3.0 only. Record may be processed for test purposes, but data should be discarded when testing is complete.
     * Sender must ensure the &lt;RecordReference&gt; matches a previously-sent Test record
     */
    Test_update_Partial("88", "Test update (Partial)"),

    /**
     * Record may be processed for test purposes, but data should be discarded when testing is complete. Sender must
     * ensure the &lt;RecordReference&gt; does not match any previously-sent live product record
     */
    Test_record("89", "Test record"),

    /**
     * ONIX Books 2.1 supply update - &lt;SupplyDetail&gt; only (not used in ONIX 3.0)
     * <p>
     * Jonix-Comment: Deprecated in Onix3
     */
    Update_SupplyDetail_only("12", "Update – SupplyDetail only"),

    /**
     * ONIX Books 2.1 supply update - &lt;MarketRepresentation&gt; only (not used in ONIX 3.0)
     * <p>
     * Jonix-Comment: Deprecated in Onix3
     */
    Update_MarketRepresentation_only("13", "Update – MarketRepresentation only"),

    /**
     * ONIX Books 2.1 supply update - both &lt;SupplyDetail&gt; and &lt;MarketRepresentation&gt; (not used in ONIX 3.0)
     * <p>
     * Jonix-Comment: Deprecated in Onix3
     */
    Update_SupplyDetail_and_MarketRepresentation("14", "Update – SupplyDetail and MarketRepresentation");

    public final String code;
    public final String description;

    NotificationOrUpdateTypes(String code, String description) {
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

    private static volatile Map<String, NotificationOrUpdateTypes> map;

    private static Map<String, NotificationOrUpdateTypes> map() {
        Map<String, NotificationOrUpdateTypes> result = map;
        if (result == null) {
            synchronized (NotificationOrUpdateTypes.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (NotificationOrUpdateTypes e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static NotificationOrUpdateTypes byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }
}
