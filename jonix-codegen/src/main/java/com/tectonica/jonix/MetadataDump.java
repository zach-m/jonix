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

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.tectonica.jonix.metadata.OnixContentClass;
import com.tectonica.jonix.metadata.OnixFlagClass;
import com.tectonica.jonix.metadata.OnixMetadata;
import com.tectonica.jonix.metadata.OnixSimpleType;
import com.tectonica.jonix.metadata.OnixValueClass;
import com.tectonica.jonix.util.JSON;
import com.tectonica.jonix.util.ParseUtil;

public class MetadataDump
{
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
		final OnixMetadata ref2 = ParseUtil.parse(ParseUtil.RES_REF_2, ParseUtil.RES_CODELIST_2);
		final OnixMetadata short2 = ParseUtil.parse(ParseUtil.RES_SHORT_2, ParseUtil.RES_CODELIST_2);

		saveMetadata(ref2, "/onix2/reference");
		saveMetadata(short2, "/onix2/short");
	}

	private static void parse3() throws IOException, ParserConfigurationException, SAXException
	{
		final OnixMetadata ref3 = ParseUtil.parse(ParseUtil.RES_REF_3, ParseUtil.RES_CODELIST_3);
		final OnixMetadata short3 = ParseUtil.parse(ParseUtil.RES_SHORT_3, ParseUtil.RES_CODELIST_3);

		saveMetadata(ref3, "/onix3/reference");
		saveMetadata(short3, "/onix3/short");
	}

	// ///////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void saveMetadata(OnixMetadata metadata, String prefix) throws IOException
	{
		final String folder = "C:/Users/zach/Desktop" + prefix;
		new File(folder).mkdirs();

//		saveAsJson(metadata.contentClasses, folder + "/contentClasses.txt");
//		saveAsJson(metadata.valueClasses, folder + "/valueClasses.txt");
//		saveAsJson(metadata.flagClasses, folder + "/flagClasses.txt");
//		saveAsJson(metadata.enums, folder + "/enums.txt");
		saveAsJson(metadata.types, folder + "/types.txt");

		new File(folder + "/contentClasses").mkdirs();
		for (OnixContentClass occ : metadata.contentClasses)
			saveAsJson(occ, folder + "/contentClasses/" + occ.name + ".txt");

		new File(folder + "/valueClasses").mkdirs();
		for (OnixValueClass ovc : metadata.valueClasses)
			saveAsJson(ovc, folder + "/valueClasses/" + ovc.name + ".txt");

		new File(folder + "/flagClasses").mkdirs();
		for (OnixFlagClass ofc : metadata.flagClasses)
			saveAsJson(ofc, folder + "/flagClasses/" + ofc.name + ".txt");

		new File(folder + "/enums").mkdirs();
		for (OnixSimpleType ost : metadata.enums)
			saveAsJson(ost, folder + "/enums/" + ost.name + ".txt");

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
