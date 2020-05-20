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

package com.tectonica.jonix.util;

import java.util.List;

public class Comparators {

    public static <T extends Comparable<T>> int compareArray(T[] a, T[] b) {
        if (a == b) { // also covers the case of two null arrays. those are considered 'equal'
            return 0;
        }

        // arbitrary: non-null array is considered 'greater than' null array
        if (a == null) {
            return -1; // "a < b"
        } else if (b == null) {
            return 1; // "a > b"
        }

        // now the item-by-item comparison - the loop runs as long as items in both arrays are equal
        int last = Math.min(a.length, b.length);
        for (int i = 0; i < last; i++) {
            T ai = a[i];
            T bi = b[i];

            if (ai == null && bi == null) {
                continue; // two null items are assumed 'equal'
            } else if (ai == null) { // arbitrary: non-null item is considered 'greater than' null item
                return -1; // "a < b"
            } else if (bi == null) {
                return 1; // "a > b"
            }

            int comp = ai.compareTo(bi);
            if (comp != 0) {
                return comp;
            }
        }

        // shorter array whose items are all equal to the first items of a longer array is considered 'less than'
        if (a.length < b.length) {
            return -1; // "a < b"
        } else if (a.length > b.length) {
            return 1; // "a > b"
        }

        // i.e. (a.length == b.length)
        return 0; // "a = b", same length, all items equal
    }

    public static <T extends Comparable<T>> int compareList(List<T> a, List<T> b) {
        if (a == b) { // also covers the case of two null arrays. those are considered 'equal'
            return 0;
        }

        // arbitrary: non-null array is considered 'greater than' null array
        if (a == null) {
            return -1; // "a < b"
        } else if (b == null) {
            return 1; // "a > b"
        }

        // now the item-by-item comparison - the loop runs as long as items in both arrays are equal
        int last = Math.min(a.size(), b.size());
        for (int i = 0; i < last; i++) {
            T ai = a.get(i);
            T bi = b.get(i);

            if (ai == null && bi == null) {
                continue; // two null items are assumed 'equal'
            } else if (ai == null) { // arbitrary: non-null item is considered 'greater than' null item
                return -1; // "a < b"
            } else if (bi == null) {
                return 1; // "a > b"
            }

            int comp = ai.compareTo(bi);
            if (comp != 0) {
                return comp;
            }
        }

        // shorter array whose items are all equal to the first items of a longer array is considered 'less than'
        if (a.size() < b.size()) {
            return -1; // "a < b"
        } else if (a.size() > b.size()) {
            return 1; // "a > b"
        }

        // i.e. (a.length == b.length)
        return 0; // "a = b", same length, all items equal
    }
}
