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

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
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

/**
 * Class that facilitates writing a tab-delimited file where each line contains one ONIX product.
 * The key for extracting flat list of values from an (tree-shaped) ONIX product lies in the {@link Tabulation} object
 * which must be provided to this class. The {@link Tabulation} object also has all the header-related information.
 * <p>
 * Typically, this class is not accessed directly (unless for subclassing). Refer to the helper functions,
 * {@link #writeTSV(Iterable, File, Tabulation)} and {@link #writeTSV(Stream, File, Tabulation)}, or alternatively,
 * if using a stream of ONIX products, consider the {@link Collector} returned by {@link #toTSV(File, Tabulation)}.
 *
 * @param <P> the type of the ONIX products to be written
 */
public class JonixTSV<P> implements AutoCloseable {

    private final PrintWriter out;
    private final Tabulation<P> tabulation;
    private int linesWritten = 0;

    public JonixTSV(File targetFile, Tabulation<P> tabulation) {
        try {
            this.out = new PrintWriter(Files.newBufferedWriter(targetFile.toPath()));
            this.tabulation = tabulation;
            writeHeader();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected void writeHeader() {
        out.println(tsvLineOf(tabulation.header()));
    }

    public void writeProduct(P product) {
        out.println(tsvLineOf(tabulation.row(product)));
        ++linesWritten;
    }

    protected String tsvLineOf(List<String> line) {
        return line.stream().map(s -> (s == null) ? "" : s.replaceAll("[\\t\\n\\r]", " "))
            .collect(Collectors.joining("\t"));
    }

    @Override
    public void close() {
        out.close();
    }

    public int getLinesWritten() {
        return linesWritten;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Returns a {@link Collector} for writing a stream of ONIX products into a tab-separated file (with header)
     *
     * @param targetFile the destination (tab-delimited) file
     * @param tabulation a {@link Tabulation} object for to the type of the ONIX products contained in the stream.
     *                   this object has all the information needed to extract and flatten data from each product.
     * @param <P>        the type of the ONIX products contained in the stream
     * @return a {@link Collector} to be used in conjunction with {@link Stream#collect(Collector)}
     */
    public static <P> Collector<P, ?, Integer> toTSV(File targetFile, Tabulation<P> tabulation) {
        return new Collector<P, JonixTSV<P>, Integer>() {
            @Override
            public Supplier<JonixTSV<P>> supplier() {
                return () -> new JonixTSV<>(targetFile, tabulation);
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
            public Function<JonixTSV<P>, Integer> finisher() {
                return (tsv) -> {
                    tsv.close();
                    return tsv.linesWritten;
                };
            }

            @Override
            public Set<Characteristics> characteristics() {
                return Collections.emptySet();
            }
        };
    }

    /**
     * Convenience method for writing a {@link Stream} of ONIX products into a tab-delimited file
     *
     * @param productsStream {@link Stream} of ONIX products
     * @param targetFile     the destination (tab-delimited) file
     * @param tabulation     a {@link Tabulation} object for to the type of the ONIX products contained in the stream.
     *                       this object has all the information needed to extract and flatten data from each product.
     * @param <P>            the type of the ONIX products contained in the iterable
     */
    public static <P> void writeTSV(Stream<P> productsStream, File targetFile, Tabulation<P> tabulation) {
        try (JonixTSV<P> writer = new JonixTSV<>(targetFile, tabulation)) {
            productsStream.forEach(writer::writeProduct);
        }
    }

    /**
     * Convenience method for writing an {@link Iterable} of ONIX products into a tab-delimited file
     *
     * @param products   an {@link Iterable} of ONIX products
     * @param targetFile the destination (tab-delimited) file
     * @param tabulation a {@link Tabulation} object for to the type of the ONIX products contained in the iterable.
     *                   this object has all the information needed to extract and flatten data from each product.
     * @param <P>        the type of the ONIX products contained in the stream
     */
    public static <P> void writeTSV(Iterable<P> products, File targetFile, Tabulation<P> tabulation) {
        try (JonixTSV<P> writer = new JonixTSV<>(targetFile, tabulation)) {
            products.forEach(writer::writeProduct);
        }
    }
}
