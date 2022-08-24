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

package com.tectonica.jonix.common.struct;

import com.tectonica.jonix.common.JonixKeyedStruct;
import com.tectonica.jonix.common.JonixStruct;
import com.tectonica.jonix.common.codelist.AudienceCodeTypes;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * This class is a {@link JonixStruct} that represents both Onix2 <code>&lt;Audience></code> and Onix3
 * <code>&lt;Audience></code>.
 * <p>
 * It can be retrieved from the composite by invoking its <code>asStruct()</code> method.
 */
@SuppressWarnings("serial")
public class JonixAudience implements JonixKeyedStruct<AudienceCodeTypes>, Serializable {
    public static final JonixAudience EMPTY = new JonixAudience();

    /**
     * the key of this struct (by which it can be looked up)
     */
    public AudienceCodeTypes audienceCodeType;

    /**
     * Raw Format: Variable length text, suggested maximum length 50 characters
     * <p>
     * (type: dt.NonEmptyString)
     */
    public String audienceCodeTypeName;

    /**
     * Raw Format: Determined by the scheme specified in &lt;AudienceCodeType&gt;
     * <p>
     * (type: dt.NonEmptyString)
     */
    public String audienceCodeValue;

    @Override
    public AudienceCodeTypes key() {
        return audienceCodeType;
    }
}
