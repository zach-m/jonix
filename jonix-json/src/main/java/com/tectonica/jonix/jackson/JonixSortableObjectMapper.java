/*
 * Copyright (C) 2012-2025 Zach Melamed
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

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.IOException;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class JonixSortableObjectMapper extends ObjectMapper {

    public JonixSortableObjectMapper(boolean sortSets) {
        if (sortSets) {
            SimpleModule module = new SimpleModule();
            module.addSerializer(Set.class, new JsonSerializer<Set>() {
                @Override
                public void serialize(Set set, JsonGenerator gen, SerializerProvider serializers) throws IOException {
                    if (set == null) {
                        gen.writeNull();
                        return;
                    }

                    gen.writeStartArray();
                    if (!set.isEmpty()) {
                        // create sorted set only if it itself is not already SortedSet
                        if (!SortedSet.class.isAssignableFrom(set.getClass())) {
                            Object item = set.iterator().next();
                            if (item != null && Comparable.class.isAssignableFrom(item.getClass())) {
                                // and only if items are Comparable
                                if (!set.contains(null)) {
                                    set = new TreeSet(set);
                                }
                            }
                        }
                        for (Object item : set) {
                            gen.writeObject(item);
                        }
                    }
                    gen.writeEndArray();
                }
            });
            registerModule(module);
        }
    }

}
