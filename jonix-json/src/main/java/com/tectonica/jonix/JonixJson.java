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
