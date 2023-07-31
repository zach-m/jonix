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

package com.tectonica.jonix.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class ListOfOnixComposite<C extends OnixComposite> extends ArrayList<C> {
    private static final long serialVersionUID = 1L;
    final Class<C> clazz;

    ListOfOnixComposite(Class<C> clazz) {
        this.clazz = clazz;
    }

    /**
     * @return the {@link Class} of the items in this {@link List}
     */
    public Class<C> itemClass() {
        return clazz;
    }

    /**
     * @return an {@link Optional} of the first {@link OnixComposite} listed, if any
     */
    public Optional<C> first() {
        return (size() == 0) ? Optional.empty() : Optional.of(get(0));
    }

    /**
     * @return the first {@link OnixComposite} listed, if any, or an "empty" instance (whose
     *         {@link OnixComposite#exists()} is {@code false}), which can be further traversed by your code (as if it
     *         exists in the ONIX source), with all underlying data fields eventually yielding "non-existing" value
     */
    public C firstOrEmpty() {
        return (size() == 0) ? JPU.emptyInstance(clazz) : get(0);
    }

    /**
     * Given this list of {@link OnixComposite}s, this method creates a new list containing only a subset of items, or
     * none, conforming to the condition passed in the {@link Predicate} object.
     * <p>
     * Note that this method is different from {@code .stream().filter()} in that it returns a list of the same original
     * type (i.e. {@link ListOfOnixComposite}), and not a generic Java {@link List}. This allows the caller to apply
     * methods such as {@link #firstOrEmpty()} on the returned list.
     *
     * @return a non-null, possibly empty, sublist of items meeting the predicate condition
     */
    public ListOfOnixComposite<C> filter(Predicate<C> predicate) {
        ListOfOnixComposite<C> matches = new ListOfOnixComposite<>(clazz);
        this.stream().filter(predicate).forEach(matches::add);
        return matches;
    }
}