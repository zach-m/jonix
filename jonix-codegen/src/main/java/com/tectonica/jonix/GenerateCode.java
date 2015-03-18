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

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.tectonica.jonix.codegen.OnixClassGen;
import com.tectonica.jonix.codegen.OnixEnumGen;
import com.tectonica.jonix.metadata.OnixContentClass;
import com.tectonica.jonix.metadata.OnixFlagClass;
import com.tectonica.jonix.metadata.OnixMetadata;
import com.tectonica.jonix.metadata.OnixSimpleType;
import com.tectonica.jonix.metadata.OnixValueClass;
import com.tectonica.jonix.util.ParseUtil;

public class GenerateCode
{
	public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException
	{
		// //////////////////////////////////////////////////////////////////////////////////////
		// ONIX 2
		// //////////////////////////////////////////////////////////////////////////////////////

		final String onix2home = new File("..").getAbsolutePath() + "/jonix-onix2";
		if (!new File(onix2home).exists())
			throw new RuntimeException("couldn't find jonix-onix2 project at " + onix2home);

		final OnixMetadata ref2 = ParseUtil.parse(ParseUtil.RES_REF_2, ParseUtil.RES_CODELIST_2);
		final String baseFolderOnix2 = onix2home + "/src/main/java/com/tectonica/jonix/onix2";
		final String basePackageOnix2 = "com.tectonica.jonix.onix2";

		System.out.println("Generating " + basePackageOnix2 + "..");
		generateModel(basePackageOnix2, baseFolderOnix2, ref2);
		generateCodelists(basePackageOnix2, baseFolderOnix2, ref2);

		// //////////////////////////////////////////////////////////////////////////////////////
		// ONIX 3
		// //////////////////////////////////////////////////////////////////////////////////////

		final String onix3home = new File("..").getAbsolutePath() + "/jonix-onix3";
		if (!new File(onix3home).exists())
			throw new RuntimeException("couldn't find jonix-onix3 project at " + onix3home);

		final OnixMetadata ref3 = ParseUtil.parse(ParseUtil.RES_REF_3, ParseUtil.RES_CODELIST_3);
		final String baseFolderOnix3 = onix3home + "/src/main/java/com/tectonica/jonix/onix3";
		final String basePackageOnix3 = "com.tectonica.jonix.onix3";
		System.out.println("Generating " + basePackageOnix3 + "..");

		generateModel(basePackageOnix3, baseFolderOnix3, ref3);
		generateCodelists(basePackageOnix3, baseFolderOnix3, ref3);

		System.out.println("DONE");
	}

	private static void generateModel(String basePackage, String baseFolder, OnixMetadata ref)
	{
		final OnixClassGen ccg = new OnixClassGen(basePackage, baseFolder, ref);

		for (OnixContentClass occ : ref.contentClasses)
			ccg.generate("model", occ);

		for (OnixValueClass ovc : ref.valueClasses)
			ccg.generate("model", ovc);

		for (OnixFlagClass ofc : ref.flagClasses)
			ccg.generate("model", ofc);
	}

	private static void generateCodelists(String basePackage, String baseFolder, OnixMetadata ref)
	{
		OnixEnumGen oeg = new OnixEnumGen(basePackage, baseFolder, ref);

		for (OnixSimpleType enumType : ref.enums)
			if (enumType.aliasFor == null)
				oeg.generate("codelist", enumType);
	}

//	private static void generateUnified(final OnixClassGen ccg, OnixMetadata ref2, OnixMetadata ref3)
//	{
//		ListDiff.compare(ref2.contentClasses, ref3.contentClasses, new CompareListener<OnixContentClass>()
//		{
//			final String FMT = "%25s <==> %s \n";
//
//			@Override
//			public void onDiff(OnixContentClass itemL, OnixContentClass itemR)
//			{
//				if (itemL != null && itemR != null)
//					System.out.printf(FMT, itemL.name, itemR.name);
//				else if (itemL != null)
//					System.out.printf(FMT, itemL.name, "");
//				else
//					System.out.printf(FMT, "", itemR.name);
//			}
//		});
//
//		System.out.println("---------------------------------------------------------------------------------------");
//
//		ListDiff.compare(ref2.valueClasses, ref3.valueClasses, new CompareListener<OnixValueClass>()
//		{
//			final String FMT = "%25s <==> %s \n";
//
//			@Override
//			public void onDiff(OnixValueClass itemL, OnixValueClass itemR)
//			{
//				if (itemL != null && itemR != null)
//					System.out.printf(FMT, itemL.name, itemR.name);
//				else if (itemL != null)
//					System.out.printf(FMT, itemL.name, "");
//				else
//					System.out.printf(FMT, "", itemR.name);
//			}
//		});
//
//		System.out.println("---------------------------------------------------------------------------------------");
//
//		ListDiff.compare(ref2.flagClasses, ref3.flagClasses, new CompareListener<OnixFlagClass>()
//		{
//			final String FMT = "%25s <==> %s \n";
//
//			@Override
//			public void onDiff(OnixFlagClass itemL, OnixFlagClass itemR)
//			{
//				if (itemL != null && itemR != null)
//					System.out.printf(FMT, itemL.name, itemR.name);
//				else if (itemL != null)
//				{
//					System.out.printf(FMT, itemL.name, "");
//					ccg.generate("onix2", itemL);
//				}
//				else
//				{
//					System.out.printf(FMT, "", itemR.name);
//					ccg.generate("onix3", itemR);
//				}
//			}
//		});
//	}
}
