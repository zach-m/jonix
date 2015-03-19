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
import java.io.IOException;
import java.util.Collections;
import java.util.ListIterator;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.tectonica.jonix.codegen.ListDiff;
import com.tectonica.jonix.codegen.ListDiff.CompareListener;
import com.tectonica.jonix.codegen.OnixClassGen;
import com.tectonica.jonix.codegen.OnixEnumGen;
import com.tectonica.jonix.metadata.OnixContentClass;
import com.tectonica.jonix.metadata.OnixEnumValue;
import com.tectonica.jonix.metadata.OnixFlagClass;
import com.tectonica.jonix.metadata.OnixMetadata;
import com.tectonica.jonix.metadata.OnixSimpleType;
import com.tectonica.jonix.metadata.OnixValueClass;
import com.tectonica.jonix.util.ParseUtil;

public class GenerateCode
{
	public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException
	{
		final String basePackage = "com.tectonica.jonix";
		final String relativePath = "/src/main/java/com/tectonica/jonix";

		// //////////////////////////////////////////////////////////////////////////////////////
		// ONIX 2
		// //////////////////////////////////////////////////////////////////////////////////////

		final String onix2home = new File("..").getAbsolutePath() + "/jonix-onix2";
		if (!new File(onix2home).exists())
			throw new RuntimeException("couldn't find jonix-onix2 project at " + onix2home);

		final OnixMetadata ref2 = ParseUtil.parse(ParseUtil.RES_REF_2, ParseUtil.RES_CODELIST_2);
		System.out.println("Generating code for Onix2..");
		generateModel(basePackage, onix2home + relativePath, "onix2", ref2);

		// //////////////////////////////////////////////////////////////////////////////////////
		// ONIX 3
		// //////////////////////////////////////////////////////////////////////////////////////

		final String onix3home = new File("..").getAbsolutePath() + "/jonix-onix3";
		if (!new File(onix3home).exists())
			throw new RuntimeException("couldn't find jonix-onix3 project at " + onix3home);

		final OnixMetadata ref3 = ParseUtil.parse(ParseUtil.RES_REF_3, ParseUtil.RES_CODELIST_3);
		System.out.println("Generating code for Onix3..");

		generateModel(basePackage, onix3home + relativePath, "onix3", ref3);

		// //////////////////////////////////////////////////////////////////////////////////////
		// UNIFIED CODELISTS
		// //////////////////////////////////////////////////////////////////////////////////////

		final String codelistHome = new File("..").getAbsolutePath() + "/jonix-codelist";
		if (!new File(codelistHome).exists())
			throw new RuntimeException("couldn't find jonix-codelist project at " + codelistHome);

		System.out.println("Generating unified codelists (for both Onix2 and Onix3)..");
		generateCodelists(basePackage, codelistHome + relativePath, "codelist", ref2, ref3);

		System.out.println("DONE");
	}

	private static void generateModel(String basePackage, String baseFolder, String subfolder, OnixMetadata ref)
	{
		final OnixClassGen ccg = new OnixClassGen(basePackage, baseFolder, ref);

		for (OnixContentClass occ : ref.contentClasses)
			ccg.generate(subfolder, occ);

		for (OnixValueClass ovc : ref.valueClasses)
			ccg.generate(subfolder, ovc);

		for (OnixFlagClass ofc : ref.flagClasses)
			ccg.generate(subfolder, ofc);
	}

	private static void generateCodelists(String basePackage, String baseFolder, String subfolder, OnixMetadata ref2, OnixMetadata ref3)
	{
		final OnixEnumGen oeg = new OnixEnumGen(basePackage, baseFolder, subfolder);

		removeAliases(ref2);
		removeAliases(ref3);

		Collections.sort(ref2.enums);
		Collections.sort(ref3.enums);

		ListDiff.compare(ref2.enums, ref3.enums, new CompareListener<OnixSimpleType>()
		{
			@Override
			public void onDiff(OnixSimpleType enum2, OnixSimpleType enum3)
			{
				if (enum2 != null && enum3 != null)
				{
//					System.out.println("                                         Common: " + enum2.enumName);
					oeg.generate(unifiedEnum(enum2, enum3));
				}
				else if (enum2 != null)
				{
//					System.out.println("Unique to Onix2: " + enum2.enumName);
					enum2.comment += "\n<p>" + "NOTE: Deprecated in Onix3";
					oeg.generate(enum2);
				}
				else
				{
//					System.out.println("Unique to Onix3: " + enum3.enumName);
					enum3.comment += "\n<p>" + "NOTE: Introduced in Onix3";
					oeg.generate(enum3);
				}
			}
		});
	}

	private static void removeAliases(OnixMetadata ref)
	{
		for (ListIterator<OnixSimpleType> iter = ref.enums.listIterator(); iter.hasNext();)
		{
			final OnixSimpleType next = iter.next();
			if (next.aliasFor != null)
				iter.remove();
		}
	}

	private static OnixSimpleType unifiedEnum(final OnixSimpleType enum2, final OnixSimpleType enum3)
	{
		final OnixSimpleType result = OnixSimpleType.cloneFrom(enum3);
		ListDiff.compare(enum2.enumValues, enum3.enumValues, new CompareListener<OnixEnumValue>()
		{
			@Override
			public void onDiff(OnixEnumValue enumValue2, OnixEnumValue enumValue3)
			{
				if (enumValue2 != null && enumValue3 != null)
				{
//					if (!enumValue2.name.equals(enumValue3.name))
//					{
//						System.out.println("DIFF - ONIX2 - " + enum2.enumName + ": "+ enumValue2.name);
//						System.out.println("DIFF - ONIX3 - " + enum3.enumName + ": "+ enumValue3.name);
//					}
				}
				else if (enumValue2 != null)
				{
//					System.out.println("Unique to Onix2: " + enum2.enumName + "." + enumValue2);
					enumValue2.description += "\n<p>" + "NOTE: Deprecated in Onix3";
					result.add(enumValue2);
				}
				else
				{
//					System.out.println("Unique to Onix3: " + enum3.enumName + "." + enumValue3);
					enumValue3.description += "\n<p>" + "NOTE: Introduced in Onix3";
				}
			}
		});
		return result;
	}
}
