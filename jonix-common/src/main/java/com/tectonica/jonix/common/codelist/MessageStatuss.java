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

import java.util.Optional;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * marker interface to assist in IDE navigation to code-list 221 (Message status)
 */
interface CodeList221 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 221</b>
 * <p>
 * Description: Message status
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_61.html#codelist221">ONIX
 *      Codelist 221 in Reference Guide</a>
 */
public enum MessageStatuss implements OnixCodelist, CodeList221 {
    /**
     * Message received but not yet parsed (Acknowledgement must contain neither &lt;MessageStatusDetail&gt; nor
     * &lt;RecordStatusSummary&gt;, and should include &lt;NoProduct/&gt;). There is no particular implication that the
     * acknowledgement message is valid - the status is based solely on receipt of a file and minimal parsing of the
     * original ONIX message header to ascertain &lt;MessageNumber&gt; etc. The Acknowledgement message MAY give a date
     * when parsing is planned
     */
    Message_received("00", "Message received"),

    /**
     * Entire original ONIX message rejected (ie NONE of the data records have been ingested). The status of any
     * recognisable records MAY be summarised in the remainder of the Acknowledgement Message
     */
    Message_rejected("01", "Message rejected"),

    /**
     * Original ONIX message partially parsed (ie at least SOME of the data records have been ingested, in whole or in
     * part). Records processed to date MUST be summarised in the remainder of the Acknowledgement Message
     */
    Message_part_processed("02", "Message part-processed"),

    /**
     * Original ONIX message parsed and processed in full, and at least SOME of the data records have been ingested, in
     * whole or in part), Results MUST be summarised in the remainder of the Acknowledgement Message
     */
    Message_processed("03", "Message processed");

    public final String code;
    public final String description;

    MessageStatuss(String code, String description) {
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

    public static MessageStatuss byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        for (MessageStatuss e : values()) {
            if (e.code.equals(code)) {
                return e;
            }
        }
        return null;
    }

    public static Optional<MessageStatuss> byCodeOptional(String code) {
        return Optional.ofNullable(byCode(code));
    }

    public static String codeToDesciption(String code) {
        return byCodeOptional(code).map(c -> c.description).orElse(null);
    }
}
