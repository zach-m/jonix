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

public class ListOfOnixCodelist<E extends OnixElement<V>, V extends OnixCodelist> extends ListOfOnixElement<E, V> {
    private static final long serialVersionUID = 1L;

    private List<OnixCodelist.Pair> cachedPairs = null;

    /**
     * returns a list of the code+description pairs stored as elements of this list (as opposed to the elements
     * themselves, each of which also contains attributes, which are usually not interesting)
     *
     * @return a non-null, possibly empty, list of the pairs
     */
    public List<OnixCodelist.Pair> pairs() {
        if (cachedPairs == null) {
            return cachedPairs = pairsInto(new ArrayList<>(this.size()));
        }
        return cachedPairs;
    }

    /**
     * stores into a given {@link Collection} the pairs stored within the elements of this list (as opposed to the
     * elements themselves, each of which also contains attributes, which are usually not interesting)
     *
     * @return the same passed collection, after being populated
     */
    public <C extends Collection<OnixCodelist.Pair>> C pairsInto(C collection) {
        forEach(item -> collection.add(item._value().pair()));
        return collection;
    }

    public List<OnixCodelist.Pair> getCachedPairs() {
        return cachedPairs;
    }

    public Optional<OnixCodelist.Pair> firstPair() {
        return (size() == 0) ? Optional.empty() : Optional.of(get(0)._value().pair());
    }

    private static final ListOfOnixElement<OnixElement<OnixCodelist>, OnixCodelist> EMPTY = new ListOfOnixCodelist<>();

    @SuppressWarnings("unchecked")
    public static <X extends OnixElement<Y>, Y extends OnixCodelist> ListOfOnixCodelist<X, Y> emptyList() {
        return (ListOfOnixCodelist<X, Y>) EMPTY;
    }
}