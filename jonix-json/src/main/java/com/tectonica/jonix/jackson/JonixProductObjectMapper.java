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

package com.tectonica.jonix.jackson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.tectonica.jonix.common.OnixTag;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class JonixProductObjectMapper extends ObjectMapper {

    public JonixProductObjectMapper(boolean indent) {
        addMixIn(OnixTag.class, JonixOnixTagFilter.OnixTagMixIn.class);
        setFilterProvider(
            new SimpleFilterProvider().addFilter(JonixOnixTagFilter.FILTER_NAME, new JonixOnixTagFilter()));

        setVisibility(new JonixVisibilityChecker());

        // general configuration
        setSerializationInclusion(JsonInclude.Include.NON_NULL);
        enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        if (indent) {
            enable(SerializationFeature.INDENT_OUTPUT);
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        setDateFormat(sdf);
    }

}
