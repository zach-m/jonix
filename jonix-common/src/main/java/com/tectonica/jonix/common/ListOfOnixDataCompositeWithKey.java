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

import com.tectonica.jonix.common.OnixComposite.OnixDataCompositeWithKey;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

// CHECKSTYLE:OFF
public class ListOfOnixDataCompositeWithKey<C extends OnixDataCompositeWithKey<S, K>, S extends JonixKeyedStruct<K>,
    K extends Enum<K> & OnixCodelist> extends ListOfOnixDataComposite<C, S> {
    private static final long serialVersionUID = 1L;

    final Class<C> clazz;

    public ListOfOnixDataCompositeWithKey(Class<C> clazz) {
        super(clazz);
        this.clazz = clazz;
    }

    /**
     * @return the {@link Class} of the items in this {@link List}
     */
    public Class<C> itemClass() {
        return clazz;
    }

    /**
     * Scans the items (i.e. Data Composites) in this list, searching for the one that has the given key
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
     * Same as {@link #find(Enum)}, but returns a {@link JonixStruct} rather than the raw ONIX composite
     */
    public Optional<S> findAsStruct(K structKey) {
        return find(structKey).map(OnixComposite.OnixDataComposite::asStruct);
    }

    /**
     * Scans the items (i.e. Data Composites) in this list, searching for an arbitrary one whose key is included in the
     * provided set
     *
     * @param structKeys set of the requested keys, as a {@link Set} object
     * @return an {@link Optional} with the found item (or empty Optional if none exists)
     */
    public Optional<C> findAny(Set<K> structKeys) {
        for (C item : this) {
            if (structKeys == null || structKeys.contains(item.structKey())) {
                return Optional.of(item);
            }
        }
        return Optional.empty();
    }

    /**
     * Scans the items (i.e. Data Composites) in this list, searching for an arbitrary one whose key is included in the
     * provided set
     *
     * @param structKeys set of the requested keys, as arguments list
     * @return an {@link Optional} with the found item (or empty Optional if none exists)
     */
    @SafeVarargs
    public final Optional<C> findAny(K... structKeys) {
        return findAny(new HashSet<>(Arrays.asList(structKeys)));
    }

    /**
     * Same as {@link #findAny(Set)}, but returns a {@link JonixStruct} rather than the raw ONIX composite
     */
    public Optional<S> findAnyAsStruct(Set<K> structKeys) {
        return findAny(structKeys).map(OnixComposite.OnixDataComposite::asStruct);
    }

    /**
     * @return the first {@link OnixDataCompositeWithKey} listed, if any, or an "empty" instance (whose
     *         {@link OnixDataCompositeWithKey#exists()} is {@code false}), which can be further traversed by your code
     *         (as if it exists in the ONIX source), with all underlying data fields eventually yielding "non-existing"
     *         value
     */
    public C findOrEmpty(K structKey) {
        return find(structKey).orElse(JPU.emptyInstance(clazz));
    }

    /**
     * Given this list of {@link OnixDataCompositeWithKey}s, this method creates a new list containing only a subset of
     * items, or none, conforming to the condition passed in the {@link Predicate} object.
     * <p>
     * Note that this method is different from {@code .stream().filter()} in that it returns a list of the same original
     * type (i.e. {@link ListOfOnixDataCompositeWithKey}), and not a generic Java {@link List}. This allows the caller
     * to apply methods such as {@link #firstOrEmpty()} on the returned list.
     *
     * @return a non-null, possibly empty, sublist of items meeting the predicate condition
     */
    public ListOfOnixDataCompositeWithKey<C, S, K> filter(Predicate<C> predicate) {
        ListOfOnixDataCompositeWithKey<C, S, K> matches = new ListOfOnixDataCompositeWithKey<>(clazz);
        this.stream().filter(predicate).forEach(matches::add);
        return matches;
    }

    /**
     * Scans the items (i.e. Data Composites) in this list, searching for all of those whose key is included in the
     * provided set
     * <p>
     * Note that this method is different from {@code .stream().filter()} in that it returns a list of the same original
     * type (i.e. {@link ListOfOnixDataCompositeWithKey}), and not a generic Java {@link List}. This allows the caller
     * to apply methods such as {@link #firstOrEmpty()} on the returned list.
     *
     * @param structKeys set of the requested keys, as a {@link Set} object
     * @return an {@link Optional} with the found item (or empty Optional if none exists)
     */
    public ListOfOnixDataCompositeWithKey<C, S, K> findAll(Set<K> structKeys) {
        return filter(c -> structKeys.contains(c.structKey()));
    }

    /**
     * Same as {@link #findAll(Set)}, but returns a {@link JonixStruct}s rather than the raw ONIX composites
     */
    public List<S> findAllAsStructs(Set<K> structKeys) {
        return findAll(structKeys).stream().map(OnixComposite.OnixDataComposite::asStruct).collect(Collectors.toList());
    }

    /**
     * Scans the items (i.e. Data Composites) in this list, searching for all of those whose key is included in the
     * provided set
     *
     * @param structKeys set of the requested keys, as argument list
     * @return an {@link Optional} with the found item (or empty Optional if none exists)
     */
    @SuppressWarnings("unchecked")
    public ListOfOnixDataCompositeWithKey<C, S, K> findAll(K... structKeys) {
        return findAll(new HashSet<>(Arrays.asList(structKeys)));
    }

    /**
     * Same as {@link #findAll(Enum[])}, but returns a {@link JonixStruct} rather than the raw ONIX composite
     */
    public List<S> findAllAsStructs(K... structKeys) {
        return findAll(structKeys).stream().map(OnixComposite.OnixDataComposite::asStruct).collect(Collectors.toList());
    }
}
// CHECKSTYLE:ON
