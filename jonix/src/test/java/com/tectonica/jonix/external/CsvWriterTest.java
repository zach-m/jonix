/*
 * Copyright (C) 2012-2024 Zach Melamed
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

package com.tectonica.jonix.external;

import org.junit.Test;
import repackaged.com.csvreader.CsvWriter;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;

/**
 * @author Zach Melamed
 * @since 1/23/2018
 */
public class CsvWriterTest {

    @Test
    public void testCsvWriter() throws IOException {
        StringWriter sw = new StringWriter();
        CsvWriter writer = new CsvWriter(sw, ',');
        writer.setRecordDelimiter('\r'); // to avoid Windows/Unix differences
        List<List<String>> rows = Arrays.asList(
            Arrays.asList("\"header\"1", "h,e,a,d,e,r2", "header:3"),
            Arrays.asList("regular", "with,comma", "with\r\nlinebreak"),
            Arrays.asList(" start-with-space", "end-of-space ", "withline\nbreak")
        );

        for (List<String> row : rows) {
            for (String cell : row) {
                writer.write(cell, true);
            }
            writer.endRecord();
        }

        org.junit.Assert.assertEquals(sw.toString().length(), 128);
    }
}