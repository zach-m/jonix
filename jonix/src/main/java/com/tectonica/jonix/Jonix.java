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

package com.tectonica.jonix;

import com.tectonica.jonix.common.OnixHeader;
import com.tectonica.jonix.common.OnixProduct;
import com.tectonica.jonix.common.OnixVersion;
import com.tectonica.jonix.unify.BaseRecord;
import com.tectonica.jonix.unify.BaseTabulation;
import com.tectonica.jonix.unify.JonixUnifier;
import com.tectonica.jonix.unify.base.BaseHeader;
import com.tectonica.jonix.unify.base.BaseProduct;
import com.tectonica.jonix.util.GlobScanner;

import java.io.File;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static com.tectonica.jonix.tabulate.JonixDelimitedWriter.toDelimitedFile;

public class Jonix {
    /**
     * Initializes a {@link JonixRecords} from an {@link InputStream} of an ONIX source. This source is expected to
     * contain valid XML content, conforming to either of the ONIX standards (the deprecated
     * <a href="http://www.editeur.org/15/Archived-Previous-Releases/#Release 2.1">Onix2</a> or the current
     * <a href="http://www.editeur.org/93/Release-3.0-Downloads">Onix3</a>). The resulting {@link JonixRecords} can be
     * used to iterate over the ONIX records contained in the source.
     * <p>
     * NOTE: only one {@link InputStream} is allowed in a {@link JonixRecords}. It is possible, however, to add files as
     * additional ONIX sources before starting iteration.
     *
     * @param inputStream non-null {@link InputStream} with ONIX content
     * @return a {@link JonixRecords} for iterating over the ONIX content
     */
    public static JonixRecords source(InputStream inputStream) {
        return new JonixRecords(inputStream);
    }

    /**
     * Initializes a {@link JonixRecords} from an ONIX {@link File}. This file is expected to contain valid XML content,
     * conforming to either of the ONIX standards (the deprecated
     * <a href="http://www.editeur.org/15/Archived-Previous-Releases/#Release 2.1">Onix2</a> or the current
     * <a href="http://www.editeur.org/93/Release-3.0-Downloads">Onix3</a>). The resulting {@link JonixRecords} can be
     * used to iterate over the ONIX records contained in the file.
     * <p>
     * If needed, before starting iteration, more files can be added as sources, using the various <code>source()</code>
     * methods of {@link JonixRecords}.
     *
     * @param file non-null {@link File} containing ONIX content
     * @return a {@link JonixRecords} for iterating over the ONIX content
     */
    public static JonixRecords source(File file) {
        return new JonixRecords(Collections.singletonList(Objects.requireNonNull(file)));
    }

    /**
     * Initializes a {@link JonixRecords} from a group of ONIX {@link File}s. Each of these files is expected to contain
     * valid XML content, conforming to either of the ONIX standards (the deprecated
     * <a href="http://www.editeur.org/15/Archived-Previous-Releases/#Release 2.1">Onix2</a> or the current
     * <a href="http://www.editeur.org/93/Release-3.0-Downloads">Onix3</a>). The resulting {@link JonixRecords} can be
     * used to iterate over the ONIX records contained in these files.
     * <p>
     * If needed, before starting iteration, more files can be added as sources, using the various <code>source()</code>
     * methods of {@link JonixRecords}.
     *
     * @param files non-null list of {@link File}s containing ONIX content
     * @return a {@link JonixRecords} for iterating over the ONIX content
     */
    public static JonixRecords source(List<File> files) {
        return new JonixRecords(files);
    }

    /**
     * Initializes a {@link JonixRecords} from a group of ONIX {@link File}s, created by scanning folder. Each of these
     * files is expected to contain valid XML content, conforming to either of the ONIX standards (the deprecated
     * <a href="http://www.editeur.org/15/Archived-Previous-Releases/#Release 2.1">Onix2</a> or the current
     * <a href="http://www.editeur.org/93/Release-3.0-Downloads">Onix3</a>). The resulting {@link JonixRecords} can be
     * used to iterate over the ONIX records contained in these files.
     * <p>
     * If needed, before starting iteration, more files can be added as sources, using the various <code>source()</code>
     * methods of {@link JonixRecords}.
     *
     * @param folder    the parent folder in which to look for ONIX files
     * @param glob      a <a href="https://docs.oracle.com/javase/tutorial/essential/io/fileOps.html#glob">glob</a>
     *                  expression for determining which files within the folder is relevant
     * @param recursive whether or not to scan the sub-folders in the parent folder recursively
     * @return a {@link JonixRecords} for iterating over the ONIX content
     */
    public static JonixRecords source(File folder, String glob, boolean recursive) {
        return new JonixRecords(GlobScanner.scan(folder, glob, recursive));
    }

    /**
     * Convenience method to assist in casting a &lt;Product&gt; object (as returned in a {@link JonixRecords}
     * {@code stream}) into an ONIX-2 class (i.e {@link com.tectonica.jonix.onix2.Product})
     *
     * @param onixProduct concrete {@link OnixProduct} object, which requires casting for further processing
     * @return ONIX-2 type-casted object
     */
    public static com.tectonica.jonix.onix2.Product toProduct2(OnixProduct onixProduct) {
        assert onixProduct.onixVersion() == OnixVersion.ONIX2;
        assert onixProduct instanceof com.tectonica.jonix.onix2.Product;
        return (com.tectonica.jonix.onix2.Product) onixProduct;
    }

    /**
     * Convenience method to assist in casting a &lt;Product&gt; object (as returned in a {@link JonixRecords}
     * {@code stream}) into an ONIX-2 class (i.e {@link com.tectonica.jonix.onix2.Product})
     *
     * @param jonixRecord a {@link JonixRecord} holding a concrete {@link OnixProduct} object, which requires casting
     *                    for further processing
     * @return ONIX-2 type-casted object
     */
    public static com.tectonica.jonix.onix2.Product toProduct2(JonixRecord jonixRecord) {
        return toProduct2(jonixRecord.product);
    }

    /**
     * Convenience method to assist in casting a &lt;Product&gt; object (as returned in a {@link JonixRecords}
     * {@code stream}) into an ONIX-3 class (i.e {@link com.tectonica.jonix.onix3.Product})
     *
     * @param onixProduct concrete {@link OnixProduct} object, which requires casting for further processing
     * @return ONIX-3 type-casted object
     */
    public static com.tectonica.jonix.onix3.Product toProduct3(OnixProduct onixProduct) {
        assert onixProduct.onixVersion() == OnixVersion.ONIX3;
        assert onixProduct instanceof com.tectonica.jonix.onix3.Product;
        return (com.tectonica.jonix.onix3.Product) onixProduct;
    }

    /**
     * Convenience method to assist in casting a &lt;Product&gt; object (as returned in a {@link JonixRecords}
     * {@code stream}) into an ONIX-3 class (i.e {@link com.tectonica.jonix.onix3.Product})
     *
     * @param jonixRecord a {@link JonixRecord} holding a concrete {@link OnixProduct} object, which requires casting
     *                    for further processing
     * @return ONIX-3 type-casted object
     */
    public static com.tectonica.jonix.onix3.Product toProduct3(JonixRecord jonixRecord) {
        return toProduct3(jonixRecord.product);
    }

    /**
     * Convenience method to assist in casting a &lt;Header&gt; object (e.g. as passed in
     * {@link JonixRecords#onSourceStart(JonixRecords.OnSourceEvent)}) into an ONIX-2 class (i.e
     * {@link com.tectonica.jonix.onix2.Header})
     *
     * @param onixHeader concrete {@link OnixHeader} object, which requires casting for further processing
     * @return ONIX-2 type-casted object
     */
    public static com.tectonica.jonix.onix2.Header toHeader2(OnixHeader onixHeader) {
        assert onixHeader.onixVersion() == OnixVersion.ONIX2;
        assert onixHeader instanceof com.tectonica.jonix.onix2.Header;
        return (com.tectonica.jonix.onix2.Header) onixHeader;
    }

    /**
     * Convenience method to assist in casting a &lt;Header&gt; object (e.g. as passed in
     * {@link JonixRecords#onSourceStart(JonixRecords.OnSourceEvent)}) into an ONIX-3 class (i.e
     * {@link com.tectonica.jonix.onix3.Header})
     *
     * @param onixHeader concrete {@link OnixHeader} object, which requires casting for further processing
     * @return ONIX-3 type-casted object
     */
    public static com.tectonica.jonix.onix3.Header toHeader3(OnixHeader onixHeader) {
        assert onixHeader.onixVersion() == OnixVersion.ONIX3;
        assert onixHeader instanceof com.tectonica.jonix.onix3.Header;
        return (com.tectonica.jonix.onix3.Header) onixHeader;
    }

    public static BaseRecord toBaseRecord(JonixRecord jonixRecord) {
        return JonixUnifier.unifyRecord(jonixRecord);
    }

    public static BaseProduct toBaseProduct(OnixProduct onixProduct) {
        return JonixUnifier.unifyProduct(onixProduct);
    }

    public static BaseProduct toBaseProduct(JonixRecord jonixRecord) {
        return toBaseProduct(jonixRecord.product);
    }

    public static BaseHeader toBaseHeader(OnixHeader onixHeader) {
        return JonixUnifier.unifyHeader(onixHeader);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private static void usage() {
        print("Usage:");
        print("        java -jar jonix.jar OUTPUT [DIRECTORY] [PATTERN]");
        print("or:     java -jar jonix.jar OUTPUT INPUT");
        print("");
        print("Creates a comma-delimited file named OUTPUT, listing all the ONIX records found in either:");
        print("- any file in or below DIRECTORY (default is current) whose name matches PATTERN (default is *.xml)");
        print("- the single file INPUT");
        print("");
    }

    private static void print(String s) {
        System.out.println(s);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Creates a comma-delimited file named OUTPUT, listing all the ONIX records found in either:
     * <ul>
     * <li>any file in or below DIRECTORY (default is current) whose name matches PATTERN (default is *.xml)</li>
     * <li>the single file INPUT</li>
     * </ul>
     *
     * @param args OUTPUT INPUT or OUTPUT [DIRECTORY] [PATTERN]
     */
    public static void main(String[] args) {
        if (args.length < 1 || args.length > 3) {
            usage();
            return;
        }

        try {
            final String outputFileName = args[0];

            final String input = (args.length < 2) ? "." : args[1];
            final File inputFile = new File(input);
            if (!inputFile.exists()) {
                System.err.println("couldn't find " + inputFile.getAbsolutePath());
                return;
            }

            final JonixRecords jonix;
            if (!inputFile.isDirectory()) {
                jonix = Jonix.source(inputFile);
            } else {
                String pattern = (args.length < 3) ? "*.xml" : args[2];
                jonix = Jonix.source(inputFile, pattern, true);
            }

            File outputFile = new File(outputFileName);
            int linesWritten = jonix.streamUnified().collect(toDelimitedFile(outputFile, ',', BaseTabulation.ALL));

            System.out.printf("Written %,d records to %s%n", linesWritten, outputFile.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
