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

import com.tectonica.jonix.JonixKeyedStruct;
import com.tectonica.jonix.codelist.ReligiousTextFeatureTypes;
import com.tectonica.jonix.codelist.ReligiousTextFeatures;

import java.io.Serializable;
import java.util.List;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

@SuppressWarnings("serial")
public class JonixReligiousTextFeature implements JonixKeyedStruct<ReligiousTextFeatureTypes>, Serializable {
    public static JonixReligiousTextFeature EMPTY = new JonixReligiousTextFeature();

    /**
     * the key of this struct (by which it can be looked up)
     */
    public ReligiousTextFeatureTypes religiousTextFeatureType;

    public ReligiousTextFeatures religiousTextFeatureCode;

    /**
     * Raw Format: Variable-length text, suggested maximum 100 characters. XHTML is enabled in this element - see Using
     * XHTML, HTML or XML with ONIX text fields <p> (type: XHTML)
     */
    public List<String> religiousTextFeatureDescriptions;

    @Override
    public ReligiousTextFeatureTypes key() {
        return religiousTextFeatureType;
    }
}
