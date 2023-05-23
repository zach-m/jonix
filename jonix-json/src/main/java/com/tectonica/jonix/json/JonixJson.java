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

package com.tectonica.jonix.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tectonica.jonix.common.OnixComposite;
import com.tectonica.jonix.common.OnixProduct;
import com.tectonica.jonix.jackson.JonixProductObjectMapper;
import com.tectonica.jonix.jackson.JonixPublicFieldsObjectMapper;

import java.io.IOException;
import java.util.Objects;

/**
 * Helper class for JSON serialization service of Jonix objects.
 * <p>
 * The fundamental APIs are the generic {@link #objectToJson(Object)} and the very-specific
 * {@link #productToJson(OnixProduct)}.
 */
public class JonixJson {
    private static final ObjectMapper PRODUCT_OBJECT_MAPPER = new JonixProductObjectMapper(true);
    private static final ObjectMapper PRODUCT_OBJECT_MAPPER_NO_IDENT = new JonixProductObjectMapper(false);
    private static final ObjectMapper PUBLIC_FIELDS_MAPPER = new JonixPublicFieldsObjectMapper();

    /**
     * Creates a JSON representation of an object using either its public fields or its {@link OnixProduct} accessors,
     * depending on its actual type.
     * <p>
     * See {@link #productToJson(OnixProduct, boolean)} and {@link #objectToJson(Object)} for more details.
     *
     * @param object object to serialize as JSON using its public fields or its {@link OnixProduct} accessors
     * @param indent whether the returned JSON string should be indented ({@link OnixProduct} only)
     * @return JSON representation of the object
     */
    public static String toJson(Object object, boolean indent) {
        if (object instanceof OnixProduct) {
            return productToJson((OnixProduct) object, indent);
        }
        return objectToJson(object);
    }

    /**
     * @param object object to serialize as JSON using its public fields or its {@link OnixProduct} accessors
     * @return indented JSON representation of the object
     * @see #toJson(Object, boolean)
     */
    public static String toJson(Object object) {
        return toJson(object, true);
    }

    /**
     * Creates a JSON representation of an {@link OnixProduct} object (i.e. low-level xml-parsed ONIX Product record).
     * <p>
     * This JSON serializer is needed in addition to the more generic {@link #objectToJson(Object)} because
     * {@link OnixProduct}s are populated "lazily". In other words, their internal fields get populated with actual
     * values only when accessed explicitly (via accessor methods, that induce the population of the
     * {@link OnixComposite} they refer to). This is a design choice to make Jonix more performant and less memory
     * hungry. However, for the underlying JSON serialization framework ({@code Jackson} is this case), this laziness
     * presents a problem, as no accessors are explicitly invoked, and nothing triggers population of the (private)
     * fields that are accessed directly during serialization. Therefore, some advanced configuration of the
     * {@code Jackson} serializer is required, which is exactly what this API does.
     *
     * @param onixProduct an {@link OnixProduct} object to serialize as JSON
     * @param indent      whether the returned JSON should be indented
     * @return JSON representation of the product
     */
    public static String productToJson(OnixProduct onixProduct, boolean indent) {
        Objects.requireNonNull(onixProduct)._initialize();
        try {
            ObjectMapper mapper = indent ? PRODUCT_OBJECT_MAPPER : PRODUCT_OBJECT_MAPPER_NO_IDENT;
            return mapper.writeValueAsString(onixProduct);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param onixProduct an {@code OnixProduct} object to serialize as JSON
     * @return indented JSON representation of the product
     * @see #productToJson(OnixProduct, boolean)
     */
    public static String productToJson(OnixProduct onixProduct) {
        return productToJson(onixProduct, true);
    }

    /**
     * Creates a JSON representation of an object using its public fields (i.e. NOT its getters or similar), therefore
     * is suitable for the {@code BaseProduct} family.
     *
     * @param object Any Java object whose serializable values are stored in public fields
     * @return JSON representation of the object
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
