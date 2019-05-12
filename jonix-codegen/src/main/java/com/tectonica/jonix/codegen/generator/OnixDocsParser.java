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

package com.tectonica.jonix.codegen.generator;

import com.tectonica.jonix.codegen.metadata.OnixDocs;
import com.tectonica.jonix.codegen.util.ParseUtil;
import org.jsoup.Jsoup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

public class OnixDocsParser {
    private static final Logger LOGGER = LoggerFactory.getLogger(OnixDocsParser.class);

    public static OnixDocs parse(String specHtml) throws IOException {
        return new OnixDocs(Jsoup.parse(OnixDocsParser.class.getResourceAsStream(specHtml), "UTF-8", "file://"));
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //TODO: turn into test
    public static void main(String[] args) throws IOException {
        File outDir = new File("parsed");
        outDir.mkdirs();
        parseAndSave(ParseUtil.RES_HTML_SPEC_2, new File(outDir, "Onix2.html"));
        parseAndSave(ParseUtil.RES_HTML_SPEC_3, new File(outDir, "Onix3.html"));
    }

    private static void parseAndSave(final String specHtml, File targetHtml) throws IOException {
        LOGGER.info("Parsing " + specHtml + " into " + targetHtml.getAbsolutePath());
        OnixDocs onixDocs = parse(specHtml);

        //JSON.saveAsJson(new File(targetHtml + ".json"), onixDocs);

        try (final PrintStream out = new PrintStream(targetHtml, "UTF-8")) {
            out.println(onixDocs.toHtml());
        }

        LOGGER.info(onixDocs.allTags.toString());
    }
}