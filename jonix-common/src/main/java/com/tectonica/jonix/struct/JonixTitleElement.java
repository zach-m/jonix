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

package com.tectonica.jonix.struct;

import com.tectonica.jonix.JonixStruct;
import com.tectonica.jonix.codelist.TitleElementLevels;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

@SuppressWarnings("serial")
public class JonixTitleElement implements JonixStruct, Serializable {
    public static JonixTitleElement EMPTY = new JonixTitleElement();

    /**
     * Raw Format: Variable-length integer, 1, 2, 3 etc, suggested maximum length 3 digits <p> (type:
     * dt.StrictPositiveInteger)
     */
    public Integer sequenceNumber;

    public TitleElementLevels titleElementLevel;

    /**
     * Raw Format: Variable-length text, suggested maximum 20 characters <p> (type: dt.NonEmptyString)
     */
    public String partNumber;

    /**
     * Raw Format: Year or range of years, in the format YYYY or YYYY-YYYY <p> (type: dt.YearOrYearRange)
     */
    public String yearOfAnnual;

    /**
     * Raw Format: Variable-length text, suggested maximum 20 characters <p> (type: dt.NonEmptyString)
     */
    public String titlePrefix;

    /**
     * (optional flag)
     */
    public boolean isNoPrefix;

    /**
     * Raw Format: Variable-length text, suggested maximum 300 characters <p> (type: dt.NonEmptyString)
     */
    public String titleWithoutPrefix;

    /**
     * Raw Format: Variable-length text, suggested maximum 300 characters <p> (type: dt.NonEmptyString)
     */
    public String titleText;

    /**
     * Raw Format: Variable-length text, suggested maximum 300 characters <p> (type: dt.NonEmptyString)
     */
    public String subtitle;
}
