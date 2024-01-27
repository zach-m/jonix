/*
 * Copyright (C) 2012-2024 Zach Melamed
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

package com.tectonica.jonix.common.struct;

import com.tectonica.jonix.common.JonixStruct;
import com.tectonica.jonix.common.codelist.AudienceRangePrecisions;
import com.tectonica.jonix.common.codelist.AudienceRangeQualifiers;

import java.io.Serializable;
import java.util.List;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * This class is a {@link JonixStruct} that represents both Onix2 <code>&lt;AudienceRange></code> and Onix3
 * <code>&lt;AudienceRange></code>.
 * <p>
 * It can be retrieved from the composite by invoking its <code>asStruct()</code> method.
 */
@SuppressWarnings("serial")
public class JonixAudienceRange implements JonixStruct, Serializable {
    public static final JonixAudienceRange EMPTY = new JonixAudienceRange();

    public List<AudienceRangePrecisions> audienceRangePrecisions;

    public AudienceRangeQualifiers audienceRangeQualifier;

    /**
     * Raw Format: Variable length string, suggested maximum 10 characters, according to the scheme specified in
     * &lt;AudienceRangeQualifier&gt;. (This element was originally defined as a variable-length integer, but its
     * definition was extended in ONIX 2.1 to enable non-numeric values to be carried. For values that BISAC has defined
     * for US school grades and pre-school levels, see List 77)
     * <p>
     * (type: dt.NonEmptyString)
     */
    public List<String> audienceRangeValues;
}
