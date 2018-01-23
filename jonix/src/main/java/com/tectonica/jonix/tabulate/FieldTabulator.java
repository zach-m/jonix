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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * An interface that represents a group of logical field within an ONIX Product (e.g. ISBN + Price, etc.), including
 * their headers (for output purposes) and their <i>tabulation</i> functions (in {@link FieldTabulator#rowSupplier()}).
 * The amount of values returned by {@link #header()} determines the length of the row passed to
 * {@link FieldRowSupplier#setRowFromProduct(List, Object)}.
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
