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

package com.tectonica.jonix.common;

import com.tectonica.jonix.common.OnixComposite.OnixDataCompositeWithKey;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class ListOfOnixDataCompositeWithKey
    <C extends OnixDataCompositeWithKey<S, K>, S extends JonixKeyedStruct<K>, K extends Enum<K> & OnixCodelist>
    extends ListOfOnixDataComposite<C, S> {
    private static final long serialVersionUID = 1L;

    /**
     * Scans the items (i.e. Data Composite) in this list, searching for the one that has the given key
     *
     * @param structKey the requested key
     * @return an {@link Optional} with the found item (or empty Optional if none exists)
     */
    public Optional<C> find(K structKey) {
        for (C item : this) {
            if (item.structKey() == structKey) {
                return Optional.of(item);
            }
        }
        return Optional.empty();
    }

    /**
     * Scans the items (i.e. Data Composite) in this list, searching for the one that has the given key.
     * If such item exists, it's converted into its corresponding {@link JonixStruct}.
     *
     * @param structKey the requested key
     * @return an {@link Optional} with the found item as a {@link JonixStruct} (or empty Optional if none exists)
     */
    public Optional<S> findAsStruct(K structKey) {
        return find(structKey).map(OnixComposite.OnixDataComposite::asStruct);
    }

    public ListOfOnixDataCompositeWithKey<C,S,K> findAll(Set<K> structKeys) {
        ListOfOnixDataCompositeWithKey<C,S,K> matches = new ListOfOnixDataCompositeWithKey<>();
        forEach(item -> {
            if (structKeys == null || structKeys.contains(item.structKey())) {
                matches.add(item);
            }
        });
        return matches;
    }

    @SuppressWarnings("unchecked")
    public ListOfOnixDataCompositeWithKey<C,S,K> findAll(K... structKeys) {
        return findAll(new HashSet<>(Arrays.asList(structKeys)));
    }

    public List<S> findAllAsStructs(Set<K> structKeys) {
        return findAll(structKeys).stream().map(OnixComposite.OnixDataComposite::asStruct).collect(Collectors.toList());
    }

    public Optional<C> findAny(Set<K> structKeys) {
        for (C item : this) {
            if (structKeys == null || structKeys.contains(item.structKey())) {
                return Optional.of(item);
            }
        }
        return Optional.empty();
    }

    @SafeVarargs
    public final Optional<C> findAny(K... structKeys) {
        return findAny(new HashSet<>(Arrays.asList(structKeys)));
    }

    public Optional<S> findAnyAsStructs(Set<K> structKeys) {
        return findAny(structKeys).map(OnixComposite.OnixDataComposite::asStruct);
    }

    private static final ListOfOnixDataCompositeWithKey<?, ?, ?> EMPTY = new ListOfOnixDataCompositeWithKey<>();

    @SuppressWarnings("unchecked")
    public static <C extends OnixDataCompositeWithKey<S, K>,
        S extends JonixKeyedStruct<K>,
        K extends Enum<K> & OnixCodelist> ListOfOnixDataCompositeWithKey<C, S, K> emptyKeyed() {
        return (ListOfOnixDataCompositeWithKey<C, S, K>) EMPTY;
    }
}