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

package com.tectonica.jonix.codegen.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ListDiff {
    public interface CompareListener<T> {
        boolean onDiff(T itemL, T itemR);
    }

    /**
     * compares two <strong>sorted</strong> lists
     */
    public static <T extends Comparable<? super T>> boolean compare(List<T> listL, List<T> listR,
                                                                    CompareListener<T> listener) {
        final Iterator<T> iterL = (listL == null) ? null : listL.iterator();
        final Iterator<T> iterR = (listR == null) ? null : listR.iterator();
        T itemL = null;
        T itemR = null;
        boolean iterLbehind = (listL != null);
        boolean iterRbehind = (listR != null);
        boolean doContinue = true;
        while (doContinue) {
            if (iterLbehind) {
                itemL = iterL.hasNext() ? iterL.next() : null;
            }
            if (iterRbehind) {
                itemR = iterR.hasNext() ? iterR.next() : null;
            }

            if (itemL == null && itemR == null) {
                break;
            }

            iterLbehind = (itemL != null) && (itemR == null || (itemL.compareTo(itemR) <= 0));
            iterRbehind = (itemR != null) && (itemL == null || (itemR.compareTo(itemL) <= 0));

            if (iterLbehind && iterRbehind) {
                doContinue = listener.onDiff(itemL, itemR);
            } else if (iterLbehind) {
                doContinue = listener.onDiff(itemL, null);
            } else {
                if (!iterRbehind) {
                    throw new RuntimeException("Internal error");
                }
                doContinue = listener.onDiff(null, itemR);
            }
        }
        return doContinue;
    }

    /**
     * compares two <strong>unsorted</strong> collections
     */
    public static <T extends Comparable<? super T>> boolean sortAndCompare(Collection<T> listL, Collection<T> listR,
                                                                           CompareListener<T> listener) {
        final List<T> sortedL = new ArrayList<>(listL);
        final List<T> sortedR = new ArrayList<>(listR);
        Collections.sort(sortedL);
        Collections.sort(sortedR);
        return compare(sortedL, sortedR, listener);
    }
}
