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

package com.tectonica.jonix;

import com.tectonica.jonix.export.JonixTabDelimitedExporter;
import com.tectonica.jonix.extract.JonixInMemExtractor;
import com.tectonica.jonix.stream.JonixFilesStreamer;
import com.tectonica.jonix.unify.BaseColumn;
import com.tectonica.jonix.unify.JonixUnifier;
import com.tectonica.jonix.unify.base.BaseHeader;
import com.tectonica.jonix.unify.base.BaseProduct;
import com.tectonica.jonix.unify.base.onix2.BaseHeader2;
import com.tectonica.jonix.unify.base.onix2.BaseProduct2;
import com.tectonica.jonix.unify.base.onix3.BaseHeader3;
import com.tectonica.jonix.unify.base.onix3.BaseProduct3;

import java.io.File;
import java.io.PrintStream;
import java.util.List;

public class Jonix {
    private static void usage() {
        p("Usage:");
        p("        java -jar jonix.jar OUTPUT [DIRECTORY] [PATTERN]");
        p("or:     java -jar jonix.jar OUTPUT INPUT");
        p("");
        p("Creates a tab-delimited file named OUTPUT, listing all the ONIX records found in either:");
        p("- any file in or below DIRECTORY (default is current) whose name matches PATTERN (default is *.xml)");
        p("- the single file INPUT");
        p("");
    }

    /**
     * Creates a tab-delimited file named OUTPUT, listing all the ONIX records found in either: <ul> <li>any file in or
     * below DIRECTORY (default is current) whose name matches PATTERN (default is *.xml) <li>the single file INPUT
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
            final String outputFile = args[0];

            final String input = (args.length < 2) ? "." : args[1];
            final File inputFile = new File(input);
            if (!inputFile.exists()) {
                System.err.println("couldn't find " + input);
                return;
            }

            final String pattern;
            if (!inputFile.isDirectory()) {
                pattern = "*";
            } else {
                pattern = (args.length < 3) ? "*.xml" : args[2];
            }

            PrintStream out = new PrintStream(outputFile);

            createBaseTabDelimitedStreamer(out).readFolder(input, pattern);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void p(String s) {
        System.out.println(s);
    }

    // /////////////////////////////////////////////////////////////////////////////////////////

    public static final JonixUnifier<BaseHeader, BaseProduct> BASIC_UNIFIER =
        new JonixUnifier<BaseHeader, BaseProduct>() {
            @Override
            public BaseHeader createFrom(com.tectonica.jonix.onix2.Header header) {
                return new BaseHeader2(header);
            }

            @Override
            public BaseHeader createFrom(com.tectonica.jonix.onix3.Header header) {
                return new BaseHeader3(header);
            }

            @Override
            public BaseProduct createFrom(com.tectonica.jonix.onix2.Product product) {
                return new BaseProduct2(product);
            }

            @Override
            public BaseProduct createFrom(com.tectonica.jonix.onix3.Product product) {
                return new BaseProduct3(product);
            }

            @Override
            public String labelOf(BaseProduct product) {
                return product.getLabel();
            }
        };

    // /////////////////////////////////////////////////////////////////////////////////////////

    public static JonixFilesStreamer createBaseTabDelimitedStreamer(PrintStream out) {
        return new JonixFilesStreamer(new JonixTabDelimitedExporter<BaseHeader, BaseProduct>(BASIC_UNIFIER,
            BaseColumn.ALL_COLUMNS).setOut(out));
    }

    public static JonixFilesStreamer createBaseInMemStreamer(List<BaseProduct> collection) {
        return new JonixFilesStreamer(new JonixInMemExtractor<BaseHeader, BaseProduct>(BASIC_UNIFIER, collection));
    }
}
