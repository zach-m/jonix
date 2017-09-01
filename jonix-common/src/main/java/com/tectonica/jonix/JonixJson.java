package com.tectonica.jonix;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class JonixJson {
    private static final ObjectMapper publicFieldsMapper = createPublicFieldsMapper();

    private static ObjectMapper createPublicFieldsMapper() {
        ObjectMapper mapper = new ObjectMapper();

        // configure to use public fields only, consistent with Jonix design
        mapper.setVisibility(PropertyAccessor.FIELD, Visibility.PUBLIC_ONLY);
        mapper.setVisibility(PropertyAccessor.GETTER, Visibility.NONE);
        mapper.setVisibility(PropertyAccessor.SETTER, Visibility.NONE);

        // general configuration
        mapper.setSerializationInclusion(Include.NON_NULL);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        mapper.setDateFormat(sdf);

        return mapper;
    }

    /**
     * returns a JSON string, based on the given Object's public fields
     */
    public static String toJson(Object o) {
        try {
            return publicFieldsMapper.writeValueAsString(o);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
