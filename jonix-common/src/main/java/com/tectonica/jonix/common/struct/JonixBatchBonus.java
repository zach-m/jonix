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

package com.tectonica.jonix.common.struct;

import com.tectonica.jonix.common.JonixStruct;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * This class is a {@link JonixStruct} that represents both Onix2 <code>&lt;BatchBonus></code> and Onix3
 * <code>&lt;BatchBonus></code>.
 * <p>
 * It can be retrieved from the composite by invoking its <code>asStruct()</code> method.
 */
@SuppressWarnings("serial")
public class JonixBatchBonus implements JonixStruct, Serializable {
    public static final JonixBatchBonus EMPTY = new JonixBatchBonus();

    /**
     * Raw Format: Positive integer, suggested maximum length 4 digits
     * <p>
     * (type: dt.StrictPositiveInteger)
     */
    public Integer batchQuantity;

    /**
     * Raw Format: Positive integer, suggested maximum length 4 digits
     * <p>
     * (type: dt.StrictPositiveInteger)
     */
    public Integer freeQuantity;
}
