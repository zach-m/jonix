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
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class ListOfOnixElement<E extends OnixElement<V>, V> extends ArrayList<E> {
    private static final long serialVersionUID = 1L;

    private List<V> cachedValues = null;

    /**
     * returns a list of the values stored within the elements of this list (as opposed to the elements themselves, each
     * of which also contains attributes, which are usually not interesting)
     *
     * @return a non-null, possibly empty, list of the values
     */
    public List<V> values() {
        if (cachedValues == null) {
            return cachedValues = valuesInto(new ArrayList<>(this.size()));
        }
        return cachedValues;
    }

    /**
     * stores into a given {@link Collection} the values stored within the elements of this list (as opposed to the
     * elements themselves, each of which also contains attributes, which are usually not interesting)
     *
     * @return the same passed collection, after being populated
     */
    public <C extends Collection<V>> C valuesInto(C collection) {
        forEach(item -> collection.add(item.__v()));
        return collection;
    }

    /**
     * @return an {@link Optional} of the first {@link OnixElement} listed, if any. Since {@link OnixElement} contains a
     *     {@code value} and some (less-interesting) attributes, a more typical API is {@link #firstValue()}.
     */
    public Optional<E> first() {
        return (size() == 0) ? Optional.empty() : Optional.of(get(0));
    }

    /**
     * @return an {@link Optional} of the {@code value} in the first {@link OnixElement} listed, if any
     */
    public Optional<V> firstValue() {
        return (size() == 0) ? Optional.empty() : Optional.of(get(0).__v());
    }

    /**
     * @return the {@code value} in the first {@link OnixElement} listed, or {@code null} it the none is listed
     */
    public V firstValueOrNull() {
        return (size() == 0) ? null : get(0).__v();
    }

    private static final ListOfOnixElement<OnixElement<Object>, Object> EMPTY = new ListOfOnixElement<>();

    @SuppressWarnings("unchecked")
    public static <X extends OnixElement<Y>, Y> ListOfOnixElement<X, Y> empty() {
        return (ListOfOnixElement<X, Y>) EMPTY;
    }
}