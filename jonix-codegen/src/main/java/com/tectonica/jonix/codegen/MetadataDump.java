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

import com.tectonica.jonix.codegen.metadata.OnixCompositeDef;
import com.tectonica.jonix.codegen.metadata.OnixElementDef;
import com.tectonica.jonix.codegen.metadata.OnixFlagDef;
import com.tectonica.jonix.codegen.metadata.OnixMetadata;
import com.tectonica.jonix.codegen.metadata.OnixSimpleType;
import com.tectonica.jonix.codegen.metadata.OnixStruct;
import com.tectonica.jonix.codegen.util.JSON;
import com.tectonica.jonix.codegen.util.OnixSpecs;
import com.tectonica.jonix.codegen.util.ParseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

import static com.tectonica.jonix.codegen.util.OnixSpecs.SPECS_2_1_03_REF;
import static com.tectonica.jonix.codegen.util.OnixSpecs.SPECS_2_1_03_SHORT;

public class MetadataDump {
    private static final File DUMP_FOLDER = new File("parsed");
    private static final Logger LOGGER = LoggerFactory.getLogger(MetadataDump.class);

    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
        LOGGER.info("Parsing Onix2..");
        parse2();

        LOGGER.info("Parsing Onix3..");
        parse3();

        LOGGER.info("DONE");
    }

    private static void parse2() throws IOException, ParserConfigurationException, SAXException {
        final OnixMetadata ref2 = ParseUtil.parse(SPECS_2_1_03_REF);
        final OnixMetadata short2 = ParseUtil.parse(SPECS_2_1_03_SHORT);

        File parent = new File(DUMP_FOLDER, "onix2");
        saveMetadata(ref2, new File(parent, "reference"));
        saveMetadata(short2, new File(parent, "short"));
    }

    private static void parse3() throws IOException, ParserConfigurationException, SAXException {
        final OnixMetadata ref3 = ParseUtil.parse(OnixSpecs.SPECS_3_0_06_REF);
        final OnixMetadata short3 = ParseUtil.parse(OnixSpecs.SPECS_3_0_06_SHORT);

        File parent = new File(DUMP_FOLDER, "onix3");
        saveMetadata(ref3, new File(parent, "reference"));
        saveMetadata(short3, new File(parent, "short"));
    }

    // ///////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void saveMetadata(OnixMetadata metadata, File dir) throws IOException {
        dir.mkdirs();

        String folder = dir.getAbsolutePath();

        //saveAsJson(metadata.onixComposites.values(), folder + "/composites.txt");
        //saveAsJson(metadata.onixElements.values(), folder + "/elements.txt");
        //saveAsJson(metadata.onixFlags.values(), folder + "/flags.txt");
        //saveAsJson(metadata.onixEnums.values(), folder + "/enums.txt");
        saveAsJson(folder + "/types.txt", metadata.onixTypes.values());

        new File(folder + "/composites").mkdirs();
        for (OnixCompositeDef composite : metadata.onixComposites.values()) {
            //occ.sortInternally();
            saveAsJson(folder + "/composites/" + composite.name + ".txt", composite);
        }

        new File(folder + "/elements").mkdirs();
        for (OnixElementDef element : metadata.onixElements.values()) {
            //ovc.sortInternally();
            saveAsJson(folder + "/elements/" + element.name + ".txt", element);
        }

        new File(folder + "/flags").mkdirs();
        for (OnixFlagDef flag : metadata.onixFlags.values()) {
            //ofc.sortInternally();
            saveAsJson(folder + "/flags/" + flag.name + ".txt", flag);
        }

        new File(folder + "/enums").mkdirs();
        for (OnixSimpleType ost : metadata.onixEnums.values()) {
            saveAsJson(folder + "/enums/" + ost.name + ".txt", ost);
        }

        new File(folder + "/structs").mkdirs();
        for (OnixStruct os : metadata.jonixStructs.values()) {
            saveAsJson(folder + "/structs/" + os.containingComposite.name + ".txt", os);
        }

        LOGGER.info("saved results to " + folder);
    }

    private static void saveAsJson(final String fileName, final Object obj) {
        JSON.saveAsJson(new File(fileName), obj);
    }
}
