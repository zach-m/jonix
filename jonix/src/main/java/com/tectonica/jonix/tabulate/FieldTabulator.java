/*
 * Copyright (C) 2012-2024 Zach Melamed
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * An interface for representing a logical field within an ONIX Product.
 * <p>
 * Such logical field may consist of a single column (e.g. ISBN field) or a set of connected columns (e.g. Price field,
 * which bundles together 3 columns: amount, currency and type).
 * <p>
 * In order to represent a field, an implementing class needs to return two things:
 * <ul>
 * <li>a {@link #header()}, which is a list of Strings, where each String gives the i-th column its display-name</li>
 * <li>a {@link #rowSupplier()}, which is function (i.e. {@link FunctionalInterface}), that, given an ONIX product,
 * knows how to extract data from it in the form of Strings list, whose length is equal to the amount of columns
 * returned by {@link #header()} (as each column-header pertains to exactly one column-value)</li>
 * </ul>
 * Initially {@link #header()} is obtained, then, if not empty, the {@link #rowSupplier()} is invoked to return a
 * {@link FieldRowSupplier} in which {@link FieldRowSupplier#setRowFromProduct(List, Object)} will be called repeatedly,
 * once per each ONIX Product, to get the values from that Product.
 * <p>
 * Note that for performance boosting, {@link FieldRowSupplier#setRowFromProduct(List, Object)} is actually being
 * called with a pre-initialized all-<code>null</code> list of Strings, which it needs to fill, rather than allocate
 * and return a new list.
 */
public interface FieldTabulator<P> {
    /**
     * returns a column header for each value that will be extracted from the ONIX Product by {@link #rowSupplier()}.
     * the length of the returned list determines the length of the (empty) row passed to
     * {@link FieldRowSupplier#setRowFromProduct(List, Object)}.
     */
    List<String> header();

    /**
     * returns a function to be executed in order to extract values from an ONIX Product. see {@link FieldRowSupplier}
     * for more information.
     */
    FieldRowSupplier<P> rowSupplier();

    /**
     * Canonical implementation for tabulating the field from an ONIX Product.
     * It is not recommended to use this implementation when extracting many fields from a single ONIX record.
     * See {@link Tabulation#row(Object)} for "batch-type" tabulation.
     */
    default List<String> extractFrom(P product) {
        int rowLength = header().size();
        if (rowLength == 0) {
            return null;
        }
        List<String> field = new ArrayList<>(Collections.nCopies(rowLength, null));
        boolean fieldWasSet = rowSupplier().setRowFromProduct(field, product);
        return fieldWasSet ? field : null;
    }
}
