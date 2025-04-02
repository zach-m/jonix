/*
 * Copyright (C) 2012-2025 Zach Melamed
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

import java.util.Optional;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * marker interface to assist in IDE navigation to code-list 222 (Message status date role)
 */
interface CodeList222 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 222</b>
 * <p>
 * Description: Message status date role
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href="https://ns.editeur.org/onix/en/">ONIX online Codelist browser</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_69.html#codelist222">ONIX
 *      Codelist 222 in Reference Guide</a>
 */
public enum MessageStatusDateRoles implements OnixCodelist, CodeList222 {
    /**
     * Expected or actual date of processing and ingestion of data to recipient's system
     */
    Ingest_date("01", "Ingest date"),

    /**
     * Expected or actual date for data to be available from the recipient's system to downstream supply chain partners
     * (or where the recipient is a retailer, to consumers)
     */
    Export_date("02", "Export date");

    public final String code;
    public final String description;

    MessageStatusDateRoles(String code, String description) {
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

    public static MessageStatusDateRoles byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        for (MessageStatusDateRoles e : values()) {
            if (e.code.equals(code)) {
                return e;
            }
        }
        return null;
    }

    public static Optional<MessageStatusDateRoles> byCodeOptional(String code) {
        return Optional.ofNullable(byCode(code));
    }

    public static String codeToDesciption(String code) {
        return byCodeOptional(code).map(c -> c.description).orElse(null);
    }
}
