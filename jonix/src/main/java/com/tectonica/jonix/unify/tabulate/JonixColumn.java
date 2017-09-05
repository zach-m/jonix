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

package com.tectonica.jonix.unify.tabulate;

/**
 * An interface for representing a specific ONIX information (e.g. title, ISBN, description) in a fixed-size String
 * array. In practice, many ONIX fields may repeat anywhere from 0 to N in a given product, making this attempt to
 * fixate their length is somewhat awkward (this is why the data is presented as an XML and not as, say, a table).
 * However, in many real-world scenarios, the variability in the fields repetitions makes it very hard to deal with the
 * data. Many tools are tabular and schema-based in nature (database tables, spreadsheets, etc). Therefore, this
 * interface is a compromise between the need for tabulation and the nature of ONIX sources.
 * <p>
 * One of the things that this interface facilitates is the ability to represent a looked-up value. For instance, one of
 * the basic information coming from ONIX is the list of a book's identifiers (ISBN, GTIN, proprietary, etc.). A typical
 * product object will have a member, containing a list of identifiers, and a straightforward API to iterate through
 * them. It would be easy to ask for the first identifier, or the amount of identifiers. However, asking for the ISBN
 * identifier would require a lookup. By creating a column that represents an ISBN, the user's code becomes free from
 * further lookups.
 * <p>
 * Each column may have sub-columns (this is entirely at the implementor hands to decide whether grouping of several
 * values makes sense). For example a column named 'price' may include the sub-columns 'amount' and 'currency'.
 * <p>
 * And finally, each column can specify how many repetitions it expects. When tabulating a source, it's crucial to know
 * the amount of values each column would actually generate, to know where to place the values of the next column. If
 * not all are used, the generated table will include empty cells. The choice of repetitions is derived from the nature
 * of the data represented by the column. For example, a 'title' is expected to appear only once, whereas 'subject' is
 * very likely to have more than one value. Choosing a large number of repetitions may result in a very sparse output
 * table, whereas choosing a small number may not be enough to accurately represent the ONIX record. Choose wisely.
 * <p>
 * In the output table, the actual number of columns that this JonixColumn would take equals to the number of
 * sub-columns times the repetitions.
 *
 * @author Zach Melamed
 */
public interface JonixColumn<P> {
    int getRepetitions();

    String[] getSubColumnNames();

    boolean extractFrom(P product, String[] columnBuffer);

    default String[] newBuffer() {
        return new String[getRepetitions() * getSubColumnNames().length];
    }
}
