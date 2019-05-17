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

import com.tectonica.jonix.unify.BaseTabulation;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import static com.tectonica.jonix.tabulate.JonixDelimitedWriter.toDelimitedFile;

public class TestTabDelimited {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestTabDelimited.class);

    @Test
    @Ignore
    // this test is ignored by default, as it scans through many files, that exist only on the author's machine
    public void exportVariousOnixSourcesIntoTSV() throws IOException {
        File samples = new File("..", "samples");
        if (!samples.exists()) {
            LOGGER.warn("Samples directory is missing: " + samples.getAbsolutePath());
            LOGGER.warn("Skipping");
            return;
        }

        int[] totalCount = new int[3];

        long encodedSourceCount = Jonix.source(new File(samples, "onix-2-iso"), "*.xml", false)
            .encoding("iso-8859-1")
            .stream().count();
        Assert.assertEquals(1101, encodedSourceCount);

        // prepare to read from various sources
        JonixRecords records = Jonix
            .source(new File(samples, "onix-3"), "*.onix", false)
            .source(new File(samples, "onix-3"), "*.xml", true)
            .source(new File(samples, "onix-2"), "*.xml", true)
            .onSourceStart(src -> LOGGER.debug("Opening {} file: {}", src.onixVersion, src.sourceName()))
            .onSourceEnd(src -> {
                totalCount[0] += src.productsProcessedCount();
                LOGGER.debug(" .. Read {} records", src.productsProcessedCount());
            })
            .configure("jonix.stream.failOnInvalidFile", Boolean.FALSE);

        // start streaming the records, from their files into a single comma-delimited file
        File targetFile = new File("target", "Catalog.csv");
        totalCount[2] = records.streamUnified()
            .peek(r -> totalCount[1]++)
            .collect(toDelimitedFile(targetFile, ',', BaseTabulation.ALL));

        LOGGER.debug("Written " + Arrays.toString(totalCount) + " records to " + targetFile.getAbsolutePath());

        Assert.assertEquals(totalCount[0], totalCount[1]);
        Assert.assertEquals(totalCount[0], totalCount[2]);
    }
}
