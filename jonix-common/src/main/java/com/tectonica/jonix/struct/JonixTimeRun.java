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

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

@SuppressWarnings("serial")
public class JonixTimeRun implements JonixStruct, Serializable {
    public static JonixTimeRun EMPTY = new JonixTimeRun();

    /**
     * Raw Format: Hours, minutes and seconds in the form HHHMMSS or HHHMMSScc (hundredths of a second)
     * <p>
     * (type: dt.TimeOrDuration)
     */
    public String startTime;

    /**
     * Raw Format: Hours, minutes and seconds in the form HHHMMSS or HHHMMSScc (hundredths of a second)
     * <p>
     * (type: dt.TimeOrDuration)
     */
    public String endTime;
}
