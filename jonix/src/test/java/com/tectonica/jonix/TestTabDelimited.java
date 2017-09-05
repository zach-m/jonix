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
import com.tectonica.jonix.util.SimpleTsvWriter;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class TestTabDelimited {
    @Test
    @Ignore
    // this test is ignored by default, as it scans through many files, that exist only on the author's machine
    public void exportVariousOnixSourcesIntoTSV() throws IOException {
        File samples = new File("..", "samples");
        if (!samples.exists()) {
            System.err.println("Samples directory is missing: " + samples.getAbsolutePath());
            System.err.println("Skipping");
            return;
        }
        JonixProvider jonix = JonixProvider
            .source(new File(samples, "onix-3"), "*.onix", false)  // ONIX3 files
            .add(new File(samples, "onix-2/BK"), "*.xml", false) // ONIX2 files
            .add(new File(samples, "onix-2/SB/SB_short.xml")) // short-references ONIX2 file
            .add(new File(samples, "onix-2/MY/MY.xml")) // improper ONIX2 file (has some syntactic bugs)
            .onSource((name, header, version) -> System.err.println("Opening " + version + " file: " + name));

        File targetFile = new File("target", "Catalog.tsv");
        SimpleTsvWriter.write(jonix.streamUnified(), targetFile, BaseColumn.ALL);
        System.err.println("Written " + targetFile.getAbsolutePath());
    }
}
