/*
 * Copyright (C) 2012-2022 Zach Melamed
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

package com.tectonica.jonix.unify.base.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

@SuppressWarnings("serial")
public abstract class LazyMap<K, V> implements Map<K, V>, Serializable {
    private Map<K, V> map;

    protected abstract Map<K, V> initialize();

    /**
     * lazily initializes this map (if needed) in a thread-safe manner
     */
    private void ensure() {
        Map<K, V> m = map;
        if (m == null) {
            synchronized (this) {
                m = map;
                if (m == null) {
                    m = initialize();
                    if (m == null) {
                        map = Collections.emptyMap();
                    } else {
                        map = Collections.synchronizedMap(m);
                    }
                }
            }
        }
    }

    // //////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void writeObject(ObjectOutputStream out) throws IOException {
        ensure();
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
    }

    @Override
    public String toString() {
        ensure();
        return map.toString();
    }

    // //////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public int size() {
        ensure();
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        ensure();
        return map.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        ensure();
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        ensure();
        return map.containsValue(value);
    }

    @Override
    public V get(Object key) {
        ensure();
        return map.get(key);
    }

    @Override
    public V put(K key, V value) {
        ensure();
        return map.put(key, value);
    }

    @Override
    public V remove(Object key) {
        ensure();
        return map.remove(key);
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        ensure();
        map.putAll(m);
    }

    @Override
    public void clear() {
        ensure();
        map.clear();
    }

    @Override
    public Set<K> keySet() {
        ensure();
        return map.keySet();
    }

    @Override
    public Collection<V> values() {
        ensure();
        return map.values();
    }

    @Override
    public Set<java.util.Map.Entry<K, V>> entrySet() {
        ensure();
        return map.entrySet();
    }
}
