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

package com.tectonica.jonix.tabulate;

import java.util.List;

/**
 * an interface that corresponds a single logical field within an ONIX product (e.g. ISBN, Price, etc.), and implements
 * a <i>tabulation</i> of that field - i.e. a string-array representation (as opposed to a tree-structure of
 * varied-type values) capturing the values (e.g. PriceType, PriceAmount and CurrencyCode) of a <b>single</b> occurrence
 * of the field represented. In case there are several occurrences, they're accounted for at a higher level abstractions
 * such as {@link FieldTabulator}.
 */
@FunctionalInterface
public interface FieldRowSupplier<P> {
    /**
     * takes an ONIX product object and flattens it into a list of values
     *
     * @param row     null-initialized <code>List</code> of <code>String</code>s, which is expected to be fully
     *                populated by this function. The list's size gives a clue as to how much information is expected.
     * @param product the ONIX product object from which the values should be extracted.
     * @return <code>true</code> if the field was extracted successfully, <code>false</code> otherwise
     */
    boolean setRowFromProduct(List<String> row, P product);
}
