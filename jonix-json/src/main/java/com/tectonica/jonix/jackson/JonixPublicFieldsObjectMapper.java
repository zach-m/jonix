package com.tectonica.jonix.jackson;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

/**
 * @author Zach Melamed
 * @since 9/4/2017
 */
public class JonixPublicFieldsObjectMapper extends ObjectMapper {
    public JonixPublicFieldsObjectMapper() {
        // configure to use public fields only, consistent with Jonix design
        setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.PUBLIC_ONLY);
        setVisibility(PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
        setVisibility(PropertyAccessor.SETTER, JsonAutoDetect.Visibility.NONE);

        // general configuration
        setSerializationInclusion(JsonInclude.Include.NON_NULL);
        enable(SerializationFeature.INDENT_OUTPUT);

        enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        setDateFormat(sdf);
    }
}
