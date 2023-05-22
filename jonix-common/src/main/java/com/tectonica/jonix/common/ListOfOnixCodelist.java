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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * Stores a list of {@link OnixCodelist}s, each of which is a Java {@link Enum} containing a {@code code} and a
 * {@code description}. It is used with {@link OnixElement}s that are repeatable, i.e. can indicate more than one
 * codelist (for example &lt;ProductFormDetail&gt;).
 *
 * @param <E> the type of the {@link OnixElement} containing the {@link OnixCodelist}
 * @param <V> the type of the {@link OnixCodelist} enum
 */
public class ListOfOnixCodelist<E extends OnixElement<V>, V extends OnixCodelist> extends ListOfOnixElement<E, V> {
    private static final long serialVersionUID = 1L;

    private List<OnixCodelist.Pair> cachedPairs = null;
    private Map<String, String> cachedPairsMap = null;

    /**
     * Given the {@link OnixCodelist}s stored in this container, this method returns a {@code String}-based
     * {@code (code,description)} list of tuples. It is a "type-free" representation of the codelists, suitable for
     * cross-comparisons.
     *
     * @return a non-null, possibly empty, list of code+description pairs
     */
    public List<OnixCodelist.Pair> pairs() {
        if (cachedPairs == null) {
            cachedPairs = pairsInto(new ArrayList<>(this.size()));
        }
        return cachedPairs;
    }

    /**
     * Given the {@link OnixCodelist}s stored in this container, this method returns a {@code String}-based map of
     * {@code (code -> description)} entries. It is a "type-free" representation of the codelists, suitable for
     * cross-comparisons.
     *
     * @return a non-null, possibly empty, map of code->description
     */
    public Map<String, String> pairsMap() {
        if (cachedPairsMap == null) {
            cachedPairsMap = new HashMap<>();
            forEach(item -> cachedPairsMap.put(item.__v().getCode(), item.__v().getDescription()));
        }
        return cachedPairsMap;
    }

    /**
     * @return a non-null, possibly empty, set of the {@code code} field of the {@link OnixCodelist}s stored in this
     *         container
     */
    public Set<String> codes() {
        return pairsMap().keySet();
    }

    /**
     * @return a non-null, possibly empty, collection of the {@code description} field of the {@link OnixCodelist}s
     *         stored in this container
     */
    public Collection<String> descriptions() {
        return pairsMap().values();
    }

    /**
     * stores into a given {@link Collection} the {@code (String,String)} code-description pairs stored within the
     * elements of this list
     *
     * @return the same passed collection, after being populated
     */
    public <C extends Collection<OnixCodelist.Pair>> C pairsInto(C collection) {
        forEach(item -> collection.add(item.__v().pair()));
        return collection;
    }

    public Optional<OnixCodelist.Pair> firstPair() {
        return (size() == 0) ? Optional.empty() : Optional.of(get(0).__v().pair());
    }

    private static final ListOfOnixElement<OnixElement<OnixCodelist>, OnixCodelist> EMPTY = new ListOfOnixCodelist<>();

    @SuppressWarnings("unchecked")
    public static <X extends OnixElement<Y>, Y extends OnixCodelist> ListOfOnixCodelist<X, Y> emptyList() {
        return (ListOfOnixCodelist<X, Y>) EMPTY;
    }
}