/*
 * Copyright (C) 2012-2023 Zach Melamed
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

import repackaged.com.csvreader.CsvWriter;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;

/**
 * Class that facilitates writing a char-delimited file where each line contains one ONIX Product.
 * The key for extracting flat list of values from an (tree-shaped) ONIX Product lies in the {@link Tabulation} object
 * which must be provided to this class. The {@link Tabulation} object also has all the header-related information.
 * <p>
 * Typically, this class is not accessed directly (unless for subclassing). Refer to the helper functions,
 * {@link #writeFile(File, char, Tabulation, Iterable)} and {@link #writeFile(File, char, Tabulation, Stream)}, or
 * alternatively, if using a stream of ONIX Products, consider the {@link Collector} returned by
 * {@link #toDelimitedFile(File, char, Tabulation)}.
 *
 * @param <P> the type of the ONIX Products to be written
 */
public class JonixDelimitedWriter<P> implements AutoCloseable {

    private final Tabulation<P> tabulation;
    protected CsvWriter out;
    protected int linesWritten = 0;

    public JonixDelimitedWriter(File targetFile, Tabulation<P> tabulation) {
        this(targetFile, ',', tabulation);
    }

    public JonixDelimitedWriter(File targetFile, char delimiter, Tabulation<P> tabulation) {
        this.tabulation = tabulation;
        initializeWriter(targetFile, delimiter);
    }

    protected void initializeWriter(File targetFile, char delimiter) {
        try {
            this.out = new CsvWriter(Files.newBufferedWriter(targetFile.toPath(), StandardCharsets.UTF_8), delimiter);
            writeHeader();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected void writeHeader() {
        writeRow(tabulation.header());
    }

    protected void writeProduct(P product) {
        try {
            writeRow(tabulation.row(product));
        } catch (Exception e) {
            throw new RuntimeException(product.toString(), e);
        }
        ++linesWritten;
    }

    protected void writeRow(List<String> row) {
        try {
            for (String cell : row) {
                out.write(cell, true);
            }
            out.endRecord();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
     * Returns a {@link Collector} for writing a stream of ONIX Products into a tab-separated file (with header)
     *
     * @param targetFile the destination (char-delimited) file
     * @param delimiter  the character to use as a delimiter in the output file, typically ','
     * @param tabulation a {@link Tabulation} object for to the type of the ONIX Products contained in the stream.
     *                   this object has all the information needed to extract and flatten data from each product.
     * @param <P>        the type of the ONIX Products contained in the stream
     * @return a {@link Collector} to be used in conjunction with {@link Stream#collect(Collector)}
     */
    public static <P> Collector<P, ?, Integer> toDelimitedFile(File targetFile, char delimiter,
                                                               Tabulation<P> tabulation) {
        return new Collector<P, JonixDelimitedWriter<P>, Integer>() {
            @Override
            public Supplier<JonixDelimitedWriter<P>> supplier() {
                return () -> new JonixDelimitedWriter<>(targetFile, delimiter, tabulation);
            }

            @Override
            public BiConsumer<JonixDelimitedWriter<P>, P> accumulator() {
                return JonixDelimitedWriter::writeProduct;
            }

            @Override
            public BinaryOperator<JonixDelimitedWriter<P>> combiner() {
                return null;
            }

            @Override
            public Function<JonixDelimitedWriter<P>, Integer> finisher() {
                return (writer) -> {
                    writer.close();
                    return writer.linesWritten;
                };
            }

            @Override
            public Set<Characteristics> characteristics() {
                return Collections.emptySet();
            }
        };
    }

    /**
     * Convenience method for writing a {@link Stream} of ONIX Products into a char-delimited file
     *
     * @param targetFile     the destination (char-delimited) file
     * @param delimiter      the character to use as a delimiter in the output file, typically ','
     * @param tabulation     a {@link Tabulation} object for to the type of the ONIX Products contained in the stream.
     *                       this object has all the information needed to extract and flatten data from each product.
     * @param <P>            the type of the ONIX Products contained in the iterable
     * @param productsStream {@link Stream} of ONIX Products
     */
    public static <P> void writeFile(File targetFile, char delimiter, Tabulation<P> tabulation,
                                     Stream<P> productsStream) {
        try (JonixDelimitedWriter<P> writer = new JonixDelimitedWriter<>(targetFile, delimiter, tabulation)) {
            productsStream.forEach(writer::writeProduct);
        }
    }

    /**
     * Convenience method for writing an {@link Iterable} of ONIX Products into a char-delimited file
     *
     * @param targetFile the destination (char-delimited) file
     * @param delimiter  the character to use as a delimiter in the output file, typically ','
     * @param tabulation a {@link Tabulation} object for to the type of the ONIX Products contained in the iterable.
     *                   this object has all the information needed to extract and flatten data from each product.
     * @param <P>        the type of the ONIX Products contained in the stream
     * @param products   an {@link Iterable} of ONIX Products
     */
    public static <P> void writeFile(File targetFile, char delimiter, Tabulation<P> tabulation, Iterable<P> products) {
        try (JonixDelimitedWriter<P> writer = new JonixDelimitedWriter<>(targetFile, delimiter, tabulation)) {
            products.forEach(writer::writeProduct);
        }
    }
}
