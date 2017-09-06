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
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JonixTSV<P> implements AutoCloseable {

    private final PrintStream out;
    private final JonixTabulator<P> tabulator;

    public JonixTSV(File targetFile, List<? extends JonixColumn<P>> targetColumns) {
        try {
            out = new PrintStream(targetFile, "UTF-8");
            tabulator = new JonixTabulator<>(targetColumns);
            writeHeader();
        } catch (UnsupportedEncodingException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    protected void writeHeader() {
        out.println(tsvLineOf(tabulator.header()));
    }

    public void writeProduct(P product) {
        out.println(tsvLineOf(tabulator.row(product)));
    }

    protected String tsvLineOf(List<String> line) {
        return defaultTsvLineOf(line);
    }

    public static String defaultTsvLineOf(List<String> line) {
        return line.stream().map(s -> s == null ? "" : s.replaceAll("[\\t\\n\\r]", " "))
            .collect(Collectors.joining("\t"));
    }

    @Override
    public void close() {
        out.close();
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static <P> Collector<P, ?, ?> toTSV(File targetFile,
                                               List<? extends JonixColumn<P>> targetColumns) {
        return new Collector<P, JonixTSV<P>, Void>() {
            @Override
            public Supplier<JonixTSV<P>> supplier() {
                return () -> new JonixTSV<P>(targetFile, targetColumns);
            }

            @Override
            public BiConsumer<JonixTSV<P>, P> accumulator() {
                return JonixTSV::writeProduct;
            }

            @Override
            public BinaryOperator<JonixTSV<P>> combiner() {
                return null;
            }

            @Override
            public Function<JonixTSV<P>, Void> finisher() {
                return (writer) -> {
                    writer.close();
                    return null;
                };
            }

            @Override
            public Set<Characteristics> characteristics() {
                return Collections.emptySet();
            }
        };
    }

    public static <P> void writeTSV(Stream<P> productsStream, File targetFile,
                                    List<? extends JonixColumn<P>> targetColumns) {
        try (JonixTSV<P> writer = new JonixTSV<>(targetFile, targetColumns)) {
            productsStream.forEach(writer::writeProduct);
        }
    }
}
