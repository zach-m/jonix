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

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.tectonica.jonix.codegen.generator.Parser.OnixVersion;
import com.tectonica.jonix.codegen.metadata.OnixCompositeDef;
import com.tectonica.jonix.codegen.metadata.OnixElementDef;
import com.tectonica.jonix.codegen.metadata.OnixFlagDef;
import com.tectonica.jonix.codegen.metadata.OnixMetadata;
import com.tectonica.jonix.codegen.metadata.OnixSimpleType;
import com.tectonica.jonix.codegen.metadata.OnixStruct;
import com.tectonica.jonix.codegen.util.JSON;
import com.tectonica.jonix.codegen.util.ParseUtil;

public class MetadataDump
{
	private static final String DUMP_FOLDER = "C:/Users/zach/Desktop";

	public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException
	{
		System.out.println("Parsing Onix2..");
		parse2();

		System.out.println("Parsing Onix3..");
		parse3();

		System.out.println("DONE");
	}

	private static void parse2() throws IOException, ParserConfigurationException, SAXException
	{
		final OnixMetadata ref2 = ParseUtil.parse(OnixVersion.Ver2_1_03, ParseUtil.RES_REF_2, ParseUtil.RES_CODELIST_2,
				ParseUtil.SPACEABLE_REF_2);
		final OnixMetadata short2 = ParseUtil.parse(OnixVersion.Ver2_1_03, ParseUtil.RES_SHORT_2,
				ParseUtil.RES_CODELIST_2, ParseUtil.SPACEABLE_SHORT_2);

		saveMetadata(ref2, "/onix2/reference");
		saveMetadata(short2, "/onix2/short");
	}

	private static void parse3() throws IOException, ParserConfigurationException, SAXException
	{
		final OnixMetadata ref3 = ParseUtil.parse(OnixVersion.Ver3_0_02, ParseUtil.RES_REF_3, ParseUtil.RES_CODELIST_3,
				ParseUtil.SPACEABLE_REF_3);
		final OnixMetadata short3 = ParseUtil.parse(OnixVersion.Ver3_0_02, ParseUtil.RES_SHORT_3,
				ParseUtil.RES_CODELIST_3, ParseUtil.SPACEABLE_SHORT_3);

		saveMetadata(ref3, "/onix3/reference");
		saveMetadata(short3, "/onix3/short");
	}

	// ///////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void saveMetadata(OnixMetadata metadata, String prefix) throws IOException
	{
		final String folder = DUMP_FOLDER + prefix;
		new File(folder).mkdirs();

//		saveAsJson(metadata.onixComposites.values(), folder + "/composites.txt");
//		saveAsJson(metadata.onixElements.values(), folder + "/elements.txt");
//		saveAsJson(metadata.onixFlags.values(), folder + "/flags.txt");
//		saveAsJson(metadata.onixEnums.values(), folder + "/enums.txt");
		saveAsJson(metadata.onixTypes.values(), folder + "/types.txt");

		new File(folder + "/composites").mkdirs();
		for (OnixCompositeDef composite : metadata.onixComposites.values())
		{
//			occ.sortInternally();
			saveAsJson(composite, folder + "/composites/" + composite.name + ".txt");
		}

		new File(folder + "/elements").mkdirs();
		for (OnixElementDef element : metadata.onixElements.values())
		{
//			ovc.sortInternally();
			saveAsJson(element, folder + "/elements/" + element.name + ".txt");
		}

		new File(folder + "/flags").mkdirs();
		for (OnixFlagDef flag : metadata.onixFlags.values())
		{
//			ofc.sortInternally();
			saveAsJson(flag, folder + "/flags/" + flag.name + ".txt");
		}

		new File(folder + "/enums").mkdirs();
		for (OnixSimpleType ost : metadata.onixEnums.values())
			saveAsJson(ost, folder + "/enums/" + ost.name + ".txt");

		new File(folder + "/structs").mkdirs();
		for (OnixStruct os : metadata.jonixStructs.values())
			saveAsJson(os, folder + "/structs/" + os.containingComposite.name + ".txt");

		System.out.println("saved results to " + folder);
	}

	private static String saveAsJson(final Object obj, final String fileName) throws IOException
	{
		final String json = JSON.toJson(obj);
		try (FileWriter fw = new FileWriter(fileName))
		{
			fw.write(json);
		}
		return json;
	}
}
