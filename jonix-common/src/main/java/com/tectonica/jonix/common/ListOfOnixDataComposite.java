/*
 * Copyright (C) 2012-2020 Zach Melamed
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

package com.tectonica.jonix.common;

import com.tectonica.jonix.common.OnixComposite.OnixDataComposite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class ListOfOnixDataComposite<C extends OnixDataComposite<S>, S extends JonixStruct> extends ArrayList<C> {
    private static final long serialVersionUID = 1L;

    private List<S> cachedStructs = null;

    /**
     * returns a list of the items inside this list, transformed into Jonix structs
     *
     * @return a non-null, possibly empty, list of the structs
     */
    public List<S> asStructs() {
        if (cachedStructs == null) {
            return cachedStructs = structsInto(new ArrayList<>(this.size()));
        }
        return cachedStructs;
    }

    public <L extends Collection<S>> L structsInto(L collection) {
        forEach(item -> collection.add(item.asStruct()));
        return collection;
    }

    public Optional<C> first() {
        return (size() == 0) ? Optional.empty() : Optional.of(get(0));
    }

    public Optional<S> firstAsStruct() {
        return first().map(OnixDataComposite::asStruct);
    }

    private static final ListOfOnixDataComposite<OnixDataComposite<JonixStruct>, JonixStruct> EMPTY =
        new ListOfOnixDataComposite<>();

    @SuppressWarnings("unchecked")
    public static <C extends OnixDataComposite<S>, S extends JonixStruct> ListOfOnixDataComposite<C, S> empty() {
        return (ListOfOnixDataComposite<C, S>) EMPTY;
    }
}