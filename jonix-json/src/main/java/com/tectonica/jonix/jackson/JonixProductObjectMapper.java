package com.tectonica.jonix.jackson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.tectonica.jonix.OnixTag;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

/**
 * @author Zach Melamed
 * @since 9/4/2017
 */
public class JonixProductObjectMapper extends ObjectMapper {
    public JonixProductObjectMapper() {
        addMixIn(OnixTag.class, JonixOnixTagFilter.OnixTagMixIn.class);
        setFilterProvider(
            new SimpleFilterProvider().addFilter(JonixOnixTagFilter.FILTER_NAME, new JonixOnixTagFilter()));

        setVisibility(new JonixVisibilityChecker());

        // general configuration
        setSerializationInclusion(JsonInclude.Include.NON_NULL);
        enable(SerializationFeature.INDENT_OUTPUT);
        enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        setDateFormat(sdf);
    }
}
