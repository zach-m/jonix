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

package com.tectonica.jonix.common;

import com.tectonica.jonix.common.OnixComposite.OnixDataComposite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class ListOfOnixDataComposite<C extends OnixDataComposite<S>, S extends JonixStruct> extends ArrayList<C> {
    private static final long serialVersionUID = 1L;

    final Class<C> clazz;

    private List<S> cachedStructs = null;

    public ListOfOnixDataComposite(Class<C> clazz) {
        this.clazz = clazz;
    }

    /**
     * @return the {@link Class} of the items in this {@link List}
     */
    public Class<C> itemClass() {
        return clazz;
    }

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

    /**
     * @return the first {@link OnixDataComposite} listed, if any, or an "empty" instance (whose
     *         {@link OnixDataComposite#exists()} is {@code false}), which can be further traversed by your code (as if
     *         it exists in the ONIX source), with all underlying data fields eventually yielding "non-existing" value
     */
    public C firstOrEmpty() {
        return (size() == 0) ? JPU.emptyInstance(clazz) : get(0);
    }

    /**
     * @return same as {@link #firstOrEmpty()} but wraps this {@link OnixDataComposite} as a {@link JonixStruct}
     */
    public S firstOrEmptyAsStruct() {
        return firstOrEmpty().asStruct();
    }

    /**
     * Given this list of {@link OnixDataComposite}s, this method creates a new list containing only a subset of items,
     * or none, conforming to the condition passed in the {@link Predicate} object.
     * <p>
     * Note that this method is different from {@code .stream().filter()} in that it returns a list of the same original
     * type (i.e. {@link ListOfOnixDataComposite}), and not a generic Java {@link List}. This allows the caller to apply
     * methods such as {@link #firstOrEmpty()} on the returned list.
     *
     * @return a non-null, possibly empty, sublist of items meeting the predicate condition
     */
    public ListOfOnixDataComposite<C, S> filter(Predicate<C> predicate) {
        ListOfOnixDataComposite<C, S> matches = new ListOfOnixDataComposite<>(clazz);
        this.stream().filter(predicate).forEach(matches::add);
        return matches;
    }
}