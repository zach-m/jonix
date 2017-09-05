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

package com.tectonica.jonix;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tectonica.jonix.jackson.JonixProductObjectMapper;
import com.tectonica.jonix.jackson.JonixPublicFieldsObjectMapper;

import java.io.IOException;
import java.util.Objects;

public class JonixJson {
    private static final ObjectMapper PRODUCT_OBJECT_MAPPER = new JonixProductObjectMapper();
    private static final ObjectMapper PUBLIC_FIELDS_MAPPER = new JonixPublicFieldsObjectMapper();

    public static String productToJson(OnixProduct onixProduct) {
        Objects.requireNonNull(onixProduct)._initialize();
        try {
            return PRODUCT_OBJECT_MAPPER.writeValueAsString(onixProduct);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * returns a JSON string, based on the given Object's public fields (suitable for BaseProduct family)
     */
    public static String objectToJson(Object object) {
        Objects.requireNonNull(object);
        try {
            return PUBLIC_FIELDS_MAPPER.writeValueAsString(object);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
