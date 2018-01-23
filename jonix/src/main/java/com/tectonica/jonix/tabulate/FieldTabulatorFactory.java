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
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Utility class, which acts as a base-class for {@link Singular} and {@link Plural}, both of which are user-facing
 * factories for creating {@link FieldTabulator} given the field's column names, tabulation function, and the amount
 * of required occurrences. When more than one occurrence is desired, this class will create a header with indexed
 * values of the column names (e.g. "Author" times 3 will become "Author1", "Author2", "Author3")
 * Users may subclass this class for similar purposes.
 *
 * @param <P> the class representing the ONIX Product record
 */
public class FieldTabulatorFactory<P> {

    protected Collection<String> columns;
    protected FieldRowSupplier<P> rowSupplier;

    protected FieldTabulatorFactory(String column, FieldRowSupplier<P> rowSupplier) {
        this(Collections.singletonList(Objects.requireNonNull(column)), rowSupplier);
    }

    protected FieldTabulatorFactory(Collection<String> columns, FieldRowSupplier<P> rowSupplier) {
        this.columns = Objects.requireNonNull(columns);
        this.rowSupplier = Objects.requireNonNull(rowSupplier);
    }

    protected List<String> createHeader(int numOfSets) {
        if (numOfSets == 1) {
            return new ArrayList<>(columns);
        } else if (numOfSets > 1) {
            List<String> header = new ArrayList<>(columns.size() * numOfSets);
            for (int i = 0; i < numOfSets; i++) {
                for (String column : columns) {
                    header.add(indexedColumnName(column, i));
                }
            }
            return header;
        } else {
            throw new IllegalArgumentException("numOfSets must be 1 or larger, not " + numOfSets);
        }
    }

    protected String indexedColumnName(String column, int setNumber) {
        return column + "." + setNumber;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * User-facing factory for creating a {@link FieldTabulator} given the field's column names and tabulation function.
     * This class is relevant for non-repeatable fields, i.e. those that have only one occurrence per ONIX Product (e.g.
     * ISBN, PublicationDate, etc.)
     * The factory function, {@link #tabulator()}, is the only API of this class.
     *
     * @param <P> the class representing the ONIX Product record
     */
    public static class Singular<P> extends FieldTabulatorFactory<P> {
        public Singular(String column, FieldRowSupplier<P> rowSupplier) {
            super(column, rowSupplier);
        }

        public Singular(List<String> columnSet, FieldRowSupplier<P> rowSupplier) {
            super(columnSet, rowSupplier);
        }

        public FieldTabulator<P> tabulator() {
            return new SimpleFieldTabulator<>(createHeader(1), rowSupplier);
        }
    }

    /**
     * User-facing factory for creating a {@link FieldTabulator} given the field's column names, tabulation function,
     * and the amount of required occurrences. This class is relevant for repeatable fields, i.e. those that may have
     * more than one occurrence per ONIX Product (e.g. Author, Price, etc.)
     * The factory function, {@link #tabulator(int)}, is the only API of this class.
     *
     * @param <P> the class representing the ONIX Product record
     */
    public static class Plural<P> extends FieldTabulatorFactory<P> {
        public Plural(String column, FieldRowSupplier<P> rowSupplier) {
            super(column, rowSupplier);
        }

        public Plural(List<String> columnSet, FieldRowSupplier<P> rowSupplier) {
            super(columnSet, rowSupplier);
        }

        public FieldTabulator<P> tabulator(int numOfSets) {
            return new SimpleFieldTabulator<>(createHeader(numOfSets), rowSupplier);
        }
    }
}
