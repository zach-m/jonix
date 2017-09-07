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

import com.tectonica.jonix.unify.tabulate.BaseColumn;
import com.tectonica.jonix.util.GlobScanner;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static com.tectonica.jonix.util.JonixTSV.toTSV;

public class Jonix {
    public static JonixIterable source(InputStream inputStream) {
        return new JonixIterable(inputStream);
    }

    public static JonixIterable source(List<File> files) {
        return new JonixIterable(files);
    }

    public static JonixIterable source(File file) {
        return new JonixIterable(Collections.singletonList(Objects.requireNonNull(file)));
    }

    public static JonixIterable source(File folder, String glob, boolean recursive) throws IOException {
        return new JonixIterable(GlobScanner.scan(folder, glob, recursive));
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////

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

    private static void p(String s) {
        System.out.println(s);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////

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
                System.err.println("couldn't find " + inputFile.getAbsolutePath());
                return;
            }

            final JonixIterable jonix;
            if (!inputFile.isDirectory()) {
                jonix = Jonix.source(inputFile);
            } else {
                String pattern = (args.length < 3) ? "*.xml" : args[2];
                jonix = Jonix.source(inputFile, pattern, true);
            }

            jonix.streamUnified().map(r -> r.product).collect(toTSV(new File(outputFile), BaseColumn.ALL));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
