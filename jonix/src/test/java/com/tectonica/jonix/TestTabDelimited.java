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

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import static com.tectonica.jonix.tabulate.JonixTSV.toTSV;

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

        int[] totalCount = new int[3];
        totalCount[0] = 0;
        totalCount[1] = 0;

        JonixRecords jonix = Jonix
            .source(new File(samples, "onix-3"), "*.onix", false)  // ONIX3 files
            .source(new File(samples, "onix-3"), "*.xml", true)  // ONIX3 files from EDItEUR
            .source(new File(samples, "onix-2/BK"), "*.xml", false) // ONIX2 files
            .source(new File(samples, "onix-2/SB/SB_short.xml")) // short-references ONIX2 file
            .source(new File(samples, "onix-2/MY/MY.xml")) // improper ONIX2 file (has some syntactic bugs)
            .onSourceStart(src -> System.err.println("Opening " + src.onixVersion + " file: " + src.getSourceName()))
            .onSourceEnd(src -> {
                totalCount[0] += src.productsProcessedCount();
                System.err.println(" .. Read " + src.productsProcessedCount() + " records");
            })
            .configure("jonix.stream.failOnInvalidFile", Boolean.FALSE);

        File targetFile = new File("target", "Catalog.tsv");
        totalCount[2] = jonix.streamUnified()
            .peek(r -> totalCount[1]++)
            .collect(toTSV(targetFile, BaseTabulation.ALL));

        System.err.println("Written " + Arrays.toString(totalCount) + " records to " + targetFile.getAbsolutePath());

        Assert.assertEquals(totalCount[0], totalCount[1]);
        Assert.assertEquals(totalCount[0], totalCount[2]);
    }
}
