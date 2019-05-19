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

package com.tectonica.jonix.codegen;

import com.tectonica.jonix.codegen.metadata.OnixMetadata;
import com.tectonica.jonix.codegen.metadata.OnixSimpleType;
import com.tectonica.jonix.codegen.util.JSON;
import com.tectonica.jonix.codegen.util.OnixSpecs;
import com.tectonica.jonix.codegen.util.ParseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.tectonica.jonix.codegen.GenerateCode.unifyCodelists;
import static com.tectonica.jonix.codegen.util.OnixSpecs.SPECS_2_1_03_REF;
import static com.tectonica.jonix.codegen.util.OnixSpecs.SPECS_2_1_03_SHORT;
import static com.tectonica.jonix.codegen.util.OnixSpecs.SPECS_3_0_01_REF;
import static com.tectonica.jonix.codegen.util.OnixSpecs.SPECS_3_0_02_REF;
import static com.tectonica.jonix.codegen.util.OnixSpecs.SPECS_3_0_03_REF;
import static com.tectonica.jonix.codegen.util.OnixSpecs.SPECS_3_0_04_REF;
import static com.tectonica.jonix.codegen.util.OnixSpecs.SPECS_3_0_05_REF;
import static com.tectonica.jonix.codegen.util.OnixSpecs.SPECS_3_0_06_REF;
import static com.tectonica.jonix.codegen.util.OnixSpecs.SPECS_3_0_06_SHORT;

public class MetadataDump {
    private static final Logger LOGGER = LoggerFactory.getLogger(MetadataDump.class);

    private static final File DUMP_FOLDER = new File("meta");

    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
        LOGGER.info("Parsing Onix2..");
        parse2();

        LOGGER.info("Parsing Onix3..");
        parse3();

        LOGGER.info("Parsing Onix3 History..");
        parse3_all_ref();

        LOGGER.info("DONE");
    }

    private static void parse2() throws IOException, ParserConfigurationException, SAXException {
        File parent = new File(DUMP_FOLDER, "onix2");
        saveMetadata(SPECS_2_1_03_REF, new File(parent, "reference"));
        saveMetadata(SPECS_2_1_03_SHORT, new File(parent, "short"));
    }

    private static void parse3() throws IOException, ParserConfigurationException, SAXException {
        File parent = new File(DUMP_FOLDER, "onix3");
        saveMetadata(SPECS_3_0_06_REF, new File(parent, "reference"));
        saveMetadata(SPECS_3_0_06_SHORT, new File(parent, "short"));
    }

    private static void parse3_all_ref() throws IOException, ParserConfigurationException, SAXException {
        File parent = new File(DUMP_FOLDER, "onix3-history");
        saveMetadata(SPECS_2_1_03_REF, SPECS_3_0_01_REF, new File(parent, "3.0.1"));
        saveMetadata(SPECS_2_1_03_REF, SPECS_3_0_02_REF, new File(parent, "3.0.2"));
        saveMetadata(SPECS_2_1_03_REF, SPECS_3_0_03_REF, new File(parent, "3.0.3"));
        saveMetadata(SPECS_2_1_03_REF, SPECS_3_0_04_REF, new File(parent, "3.0.4"));
        saveMetadata(SPECS_2_1_03_REF, SPECS_3_0_05_REF, new File(parent, "3.0.5"));
        saveMetadata(SPECS_2_1_03_REF, SPECS_3_0_06_REF, new File(parent, "3.0.6"));
    }

    // ///////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void saveMetadata(OnixSpecs specs, File dir)
        throws ParserConfigurationException, SAXException, IOException {
        OnixMetadata metadata = ParseUtil.parse(specs);
        saveMetadata(metadata, metadata.getEnums(), dir);
    }

    public static void saveMetadata(OnixSpecs specs2Ref, OnixSpecs specs3Ref, File dir)
        throws IOException, ParserConfigurationException, SAXException {
        OnixMetadata ref2 = ParseUtil.parse(specs2Ref);
        OnixMetadata ref3 = ParseUtil.parse(specs3Ref);
        saveMetadata(ref3, unifyCodelists(ref2, ref3).values(), dir);
    }

    private static void saveMetadata(OnixMetadata metadata, Collection<OnixSimpleType> enums, File dir) {
        ensureDir(dir);

        String folder = dir.getAbsolutePath();

        saveAsJson(folder + "/types.txt", metadata.onixTypes.values());

        ensureDir(new File(folder + "/composites"));
        //occ.sortInternally();
        metadata.getComposites()
            .forEach(composite -> saveAsJson(folder + "/composites/" + composite.name + ".txt", composite));

        ensureDir(new File(folder + "/elements"));
        //ovc.sortInternally();
        metadata.getElements()
            .forEach(element -> saveAsJson(folder + "/elements/" + element.name + ".txt", element));

        ensureDir(new File(folder + "/flags"));
        //ofc.sortInternally();
        metadata.getFlags()
            .forEach(flag -> saveAsJson(folder + "/flags/" + flag.name + ".txt", flag));

        ensureDir(new File(folder + "/enums"));
        metadata.getEnums()
            .forEach(ost -> saveAsJson(folder + "/enums/" + ost.name + ".txt", ost));

        ensureDir(new File(folder + "/structs"));
        metadata.getStructs()
            .forEach(os -> saveAsJson(folder + "/structs/" + os.containingComposite.name + ".txt", os));

        List<OnixSimpleType> codelists = enums.stream()
            .filter(ost -> ost.enumAliasFor == null)
            .map(OnixSimpleType::cloneFrom)
            .peek(ost -> ost.enumValues = null) // for cleaner presentation in a single file
            .collect(Collectors.toList());
        saveAsJson(folder + "/codelists.txt", codelists);

        LOGGER.info("saved results to " + folder);
    }

    private static void ensureDir(File dir) {
        if (dir.exists()) {
            try {
                deleteDir(dir);
            } catch (IOException e) {
                throw new RuntimeException((e));
            }
        }
        if (!dir.mkdirs()) {
            throw new RuntimeException(String.format("Couldn't create directory %s", dir.getAbsolutePath()));
        }
    }

    private static void deleteDir(File dir) throws IOException {
        Files.walk(dir.toPath())
            .sorted(Comparator.reverseOrder())
            .map(Path::toFile)
            .forEach(File::delete);
    }

    private static void saveAsJson(final String fileName, final Object obj) {
        JSON.saveAsJson(new File(fileName), obj);
    }
}
