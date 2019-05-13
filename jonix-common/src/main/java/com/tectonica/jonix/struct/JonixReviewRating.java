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

import java.io.Serializable;
import java.util.List;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

@SuppressWarnings("serial")
public class JonixReviewRating implements JonixStruct, Serializable {
    public static JonixReviewRating EMPTY = new JonixReviewRating();

    /**
     * Raw Format: Positive real number, with explicit decimal point when required, or zero, as appropriate for the
     * limit specified in &lt;RatingLimit&gt;. Suggested maximum length 7 characters <p> (type: dt.PositiveDecimal)
     */
    public Double rating;

    /**
     * Raw Format: Positive integer number, suggested maximum length 4 digits <p> (type: dt.PositiveInteger)
     */
    public Integer ratingLimit;

    /**
     * Raw Format: Variable length text, suggested maximum length 50 characters <p> (type: dt.NonEmptyString)
     */
    public List<String> ratingUnitss;
}
