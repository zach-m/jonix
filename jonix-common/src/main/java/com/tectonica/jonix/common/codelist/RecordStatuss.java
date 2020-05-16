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
 * marker interface to assist in IDE navigation to code-list 226 (Record status)
 */
interface CodeList226 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 226</b>
 * <p>
 * Description: Record status
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_45.html#codelist226">ONIX
 *      Codelist 226 in Reference Guide</a>
 */
public enum RecordStatuss implements OnixCodelist, CodeList226 {
    /**
     * Entire record parsed and ingested without errors, record may have a Product record in the Acknowledgement which
     * itself may have a &lt;RecordStatusNote&gt; or &lt;RecordStatusDetail&gt; to convey information, editorial queries
     * or warnings
     */
    No_record_errors("00", "No record errors"),

    /**
     * Entire record parsed and ingested without errors, record MUST have a Product record in the Acknowledgement with a
     * &lt;RecordStatusNote&gt; or at least one &lt;RecordStatusDetail&gt; to convey errors in associated media files
     * (and possibly supplementary editorial queries)
     */
    No_record_errors_errors_in_collateral("01", "No record errors – errors in collateral"),

    /**
     * Record parsed and ingested with errors, record MUST have a Product record in the Acknowledgement with a
     * &lt;RecordStatusNote&gt; or at least one &lt;RecordStatusDetail&gt; to convey errors (and possibly supplementary
     * information, editorial queries or warnings). At least SOME of the data in the original Product record has been
     * ingested. There may also be errors in associated media files
     */
    Record_with_errors("02", "Record with errors"),

    /**
     * Entire record rejected, record MUST have a Product record in the Acknowedgemet, with a &lt;RecordStatusNote&gt;
     * or at least one &lt;RecordStatusDetail&gt; to convey errors (and possibly supplementary information, editorial
     * queries or warnings). NONE of the data in the original Product record has been ingested
     */
    Record_rejected("03", "Record rejected"),

    /**
     * Record status reported in an earlier Acknowledgement message, based on partial processing of ONIX message. The
     * record MUST NOT have a Product record in this Acknowledgement. Code not valid in &lt;RecordStatusDetail&gt;
     */
    Reported_previously("09", "Reported previously");

    public final String code;
    public final String description;

    RecordStatuss(String code, String description) {
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

    public static RecordStatuss byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        for (RecordStatuss e : values()) {
            if (e.code.equals(code)) {
                return e;
            }
        }
        return null;
    }
}
