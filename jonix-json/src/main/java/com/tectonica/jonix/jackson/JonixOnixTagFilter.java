package com.tectonica.jonix.jackson;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.PropertyWriter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.tectonica.jonix.OnixComposite;
import com.tectonica.jonix.OnixTag;

import java.util.List;

/**
 * @author Zach Melamed
 * @since 9/5/2017
 */
public class JonixOnixTagFilter extends SimpleBeanPropertyFilter {
    public static final String FILTER_NAME = "OnixTag";

    @JsonFilter(FILTER_NAME)
    public interface OnixTagMixIn {
    }

    @Override
    public void serializeAsField(Object pojo, JsonGenerator jgen, SerializerProvider provider,
                                 PropertyWriter writer)
        throws Exception {
        Class<?> memberType = writer.getMember().getRawType();
        Object memberObject = writer.getMember().getValue(pojo);
        if (OnixTag.class.isAssignableFrom(memberType)) {
            OnixTag tag = (OnixTag) memberObject;
            if (!tag.exists()) {
                return; // skip, don't serialize an empty braces for this member
            }
            if (OnixComposite.class.isAssignableFrom(memberType)) {
                // eagerly populate the fields of this (lazy) composite object before it gets serialized
                OnixComposite composite = (OnixComposite) memberObject;
                composite._initialize();
            }
        } else if (List.class.isAssignableFrom(memberType)) {
            List<OnixTag> tagList = (List<OnixTag>) memberObject;
            if (tagList.isEmpty()) {
                return;
            }
            if (tagList.get(0) instanceof OnixComposite) {
                // eagerly populate the fields in the items of of this (lazy) list of composites
                List<OnixComposite> compositeList = (List<OnixComposite>) memberObject;
                compositeList.forEach(OnixComposite::_initialize);
            }
        }
        super.serializeAsField(pojo, jgen, provider, writer);
    }
}
