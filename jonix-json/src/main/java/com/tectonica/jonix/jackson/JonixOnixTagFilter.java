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

package com.tectonica.jonix.jackson;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.PropertyWriter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.tectonica.jonix.common.OnixComposite;
import com.tectonica.jonix.common.OnixTag;

import java.util.List;

public class JonixOnixTagFilter extends SimpleBeanPropertyFilter {
    public static final String FILTER_NAME = "OnixTag";

    @JsonFilter(FILTER_NAME)
    public interface OnixTagMixIn {
    }

    @Override
    public void serializeAsField(Object pojo, JsonGenerator jgen, SerializerProvider provider,
                                 PropertyWriter writer) throws Exception {
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
                // eagerly populate the fields in the items of this (lazy) list of composites
                List<OnixComposite> compositeList = (List<OnixComposite>) memberObject;
                compositeList.forEach(OnixComposite::_initialize);
            }
        }
        super.serializeAsField(pojo, jgen, provider, writer);
    }
}
