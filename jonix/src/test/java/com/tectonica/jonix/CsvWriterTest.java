package com.tectonica.jonix;

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