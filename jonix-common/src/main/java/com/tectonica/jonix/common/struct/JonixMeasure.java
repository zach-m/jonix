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

import com.tectonica.jonix.common.JonixKeyedStruct;
import com.tectonica.jonix.common.JonixStruct;
import com.tectonica.jonix.common.codelist.MeasureTypes;
import com.tectonica.jonix.common.codelist.MeasureUnits;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * This class is a {@link JonixStruct} that represents both Onix2 <code>&lt;Measure></code> and Onix3
 * <code>&lt;Measure></code>.
 * <p>
 * It can be retrieved from the composite by invoking its <code>asStruct()</code> method.
 */
@SuppressWarnings("serial")
public class JonixMeasure implements JonixKeyedStruct<MeasureTypes>, Serializable {
    public static final JonixMeasure EMPTY = new JonixMeasure();

    /**
     * the key of this struct (by which it can be looked up)
     */
    public MeasureTypes measureType;

    public MeasureUnits measureUnitCode;

    /**
     * Raw Format: Positive real number, with explicit decimal point when required, suggested maximum length 6
     * characters
     * <p>
     * (type: dt.StrictPositiveDecimal)
     */
    public Double measurement;

    @Override
    public MeasureTypes key() {
        return measureType;
    }
}
