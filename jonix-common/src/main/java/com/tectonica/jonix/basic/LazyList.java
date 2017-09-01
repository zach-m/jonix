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

package com.tectonica.jonix.basic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@SuppressWarnings("serial")
public abstract class LazyList<T> implements List<T>, Serializable {
    private volatile List<T> list;

    protected abstract List<T> initialize();

    /**
     * lazily initializes this list (if needed) in a thread-safe manner
     */
    private void ensure() {
        List<T> l = list;
        if (l == null) {
            synchronized (this) {
                l = list;
                if (l == null) {
                    l = initialize();
                    if (l == null) {
                        list = Collections.emptyList();
                    } else {
                        list = Collections.synchronizedList(l);
                    }
                }
            }
        }
    }

    // ///////////////////////////////////////////////////////////////////////////////////////////////////

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
        return list.toString();
    }

    // ///////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public int size() {
        ensure();
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        ensure();
        return list.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        ensure();
        return list.contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        ensure();
        return list.iterator();
    }

    @Override
    public Object[] toArray() {
        ensure();
        return list.toArray();
    }

    @Override
    public <E> E[] toArray(E[] a) {
        ensure();
        return list.toArray(a);
    }

    @Override
    public boolean add(T e) {
        ensure();
        return add(e);
    }

    @Override
    public void add(int index, T element) {
        ensure();
        list.add(index, element);
    }

    @Override
    public boolean remove(Object o) {
        ensure();
        return remove(o);
    }

    @Override
    public T remove(int index) {
        ensure();
        return list.remove(index);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        ensure();
        return containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        ensure();
        return addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        ensure();
        return addAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        ensure();
        return removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        ensure();
        return retainAll(c);
    }

    @Override
    public void clear() {
        ensure();
        list.clear();
    }

    @Override
    public T get(int index) {
        ensure();
        return list.get(index);
    }

    @Override
    public T set(int index, T element) {
        ensure();
        return list.set(index, element);
    }

    @Override
    public int indexOf(Object o) {
        ensure();
        return list.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        ensure();
        return list.lastIndexOf(o);
    }

    @Override
    public ListIterator<T> listIterator() {
        ensure();
        return list.listIterator();
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        ensure();
        return list.listIterator(index);
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        ensure();
        return list.subList(fromIndex, toIndex);
    }

    // ///////////////////////////////////////////////////////////////////////////////////////////////////

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        LazyList<String> list = new LazyList<String>() {
            private static final long serialVersionUID = 1L;

            @Override
            protected List<String> initialize() {
                return Arrays.asList("Hi", "There", "Boss");
            }
        };
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        try (ObjectOutputStream oos = new ObjectOutputStream(buffer)) {
            oos.writeObject(list);
        }
        byte[] byteArray = buffer.toByteArray();
        System.out.println("byteArray.length=" + byteArray.length);
        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(byteArray))) {
            @SuppressWarnings("unchecked")
            LazyList<String> obj = (LazyList<String>) ois.readObject();
            System.out.println(obj.getClass().getName());
            if (obj.list == null) {
                System.out.println("null");
            } else {
                System.out.println(obj.list.getClass().getName());
                System.out.println(obj.toString());
            }
        }
    }
}
