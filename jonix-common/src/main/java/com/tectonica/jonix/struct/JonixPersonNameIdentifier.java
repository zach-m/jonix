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
import com.tectonica.jonix.codelist.PersonNameIdentifierTypes;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

@SuppressWarnings("serial")
public class JonixPersonNameIdentifier implements JonixKeyedStruct<PersonNameIdentifierTypes>, Serializable {
    public static JonixPersonNameIdentifier EMPTY = new JonixPersonNameIdentifier();

    /**
     * the key of this struct (by which it can be looked up)
     */
    public PersonNameIdentifierTypes personNameIDType;

    /**
     * Raw Format: Free text, suggested maximum length 50 characters
     * <p>
     * (type: NonEmptyString)
     */
    public String idTypeName;

    /**
     * Raw Format: According to the identifier type specified in &lt;ProductIDType&gt;
     * <p>
     * (type: NonEmptyString)
     */
    public String idValue;

    @Override
    public PersonNameIdentifierTypes key() {
        return personNameIDType;
    }
}
