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
import com.tectonica.jonix.unify.BaseTabulation;
import com.tectonica.jonix.util.GlobScanner;

import java.io.File;
import java.io.IOException;
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
    public static JonixRecords source(File folder, String glob, boolean recursive) throws IOException {
        return new JonixRecords(GlobScanner.scan(folder, glob, recursive));
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private static void usage() {
        p("Usage:");
        p("        java -jar jonix.jar OUTPUT [DIRECTORY] [PATTERN]");
        p("or:     java -jar jonix.jar OUTPUT INPUT");
        p("");
        p("Creates a comma-delimited file named OUTPUT, listing all the ONIX records found in either:");
        p("- any file in or below DIRECTORY (default is current) whose name matches PATTERN (default is *.xml)");
        p("- the single file INPUT");
        p("");
    }

    private static void p(String s) {
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

    public static com.tectonica.jonix.onix2.Product toProduct2(OnixProduct onixProduct) {
        assert onixProduct instanceof com.tectonica.jonix.onix2.Product;
        return (com.tectonica.jonix.onix2.Product) onixProduct;
    }

    public static com.tectonica.jonix.onix3.Product toProduct3(OnixProduct onixProduct) {
        assert onixProduct instanceof com.tectonica.jonix.onix3.Product;
        return (com.tectonica.jonix.onix3.Product) onixProduct;
    }

    public static com.tectonica.jonix.onix2.Header toHeader2(OnixHeader onixHeader) {
        assert onixHeader instanceof com.tectonica.jonix.onix2.Header;
        return (com.tectonica.jonix.onix2.Header) onixHeader;
    }

    public static com.tectonica.jonix.onix3.Header toHeader3(OnixHeader onixHeader) {
        assert onixHeader instanceof com.tectonica.jonix.onix3.Header;
        return (com.tectonica.jonix.onix3.Header) onixHeader;
    }
}
