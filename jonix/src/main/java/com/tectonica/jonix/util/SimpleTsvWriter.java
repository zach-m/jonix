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

package com.tectonica.jonix.util;

import com.tectonica.jonix.unify.tabulate.JonixColumn;
import com.tectonica.jonix.unify.tabulate.JonixTabulator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimpleTsvWriter {
    public static <P> void write(Stream<P> productsStream, File targetFile,
                                 List<? extends JonixColumn<P>> targetColumns) throws FileNotFoundException {
        try {
            try (PrintStream out = new PrintStream(targetFile, "UTF-8")) {
                JonixTabulator<P> tabulator = new JonixTabulator<>(targetColumns);
                out.println(tsvLineOf(tabulator.header()));
                productsStream.map(tabulator::row).map(SimpleTsvWriter::tsvLineOf).forEach(out::println);
            }
        } catch (UnsupportedEncodingException e) {
            // impossible, using hard-coded UTF-8
        }
    }

    private static String tsvLineOf(List<String> line) {
        return line.stream().map(s -> s == null ? "" : s.replaceAll("[\\t\\n\\r]", " "))
            .collect(Collectors.joining("\t"));
    }
}
