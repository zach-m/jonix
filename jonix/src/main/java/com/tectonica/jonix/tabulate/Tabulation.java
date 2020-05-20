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

package com.tectonica.jonix.tabulate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class contains a collection of {@link FieldTabulator}s which together hold all the information needed to flatten
 * an ONIX Product (which is a tree-like structure by its nature) into a flat-list of values (containing one or more
 * logical fields). It also provides a header (i.e. list of column-names) for each of these values, in case the context
 * requires a header (e.g. when writing to a file).
 * <p>
 * While users are likely to define their own {@link FieldTabulator}s and {@link Tabulation}s, Jonix offers a ready-made
 * set for your convenience, as part of the <code>Unification</code> services.
 *
 * @see FieldTabulator
 * @see com.tectonica.jonix.unify.BaseTabulation
 */
public class Tabulation<P> {

    private List<FieldTabulator<P>> tabulators = new ArrayList<>();
    private List<String> header = new ArrayList<>();

    public static <P> Tabulation<P> create() {
        return new Tabulation<>();
    }

    public Tabulation<P> add(FieldTabulator<P> tabulator) {
        tabulators.add(tabulator);
        header.addAll(tabulator.header());
        return this;
    }

    public List<String> header() {
        return header;
    }

    public List<String> row(P product) {
        List<String> row = new ArrayList<>(Collections.nCopies(header.size(), null));
        int from = 0;
        for (FieldTabulator<P> tabulator : tabulators) {
            int to = from + tabulator.header().size();
            tabulator.rowSupplier().setRowFromProduct(row.subList(from, to), product);
            from = to;
        }
        return row;
    }
}
