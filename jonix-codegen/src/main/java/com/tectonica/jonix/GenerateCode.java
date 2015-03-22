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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.tectonica.jonix.codegen.GenUtil;
import com.tectonica.jonix.codegen.ListDiff;
import com.tectonica.jonix.codegen.ListDiff.CompareListener;
import com.tectonica.jonix.codegen.OnixClassGen;
import com.tectonica.jonix.codegen.OnixEnumGen;
import com.tectonica.jonix.codegen.OnixStructGen;
import com.tectonica.jonix.metadata.OnixContentClass;
import com.tectonica.jonix.metadata.OnixContentClassMember;
import com.tectonica.jonix.metadata.OnixEnumValue;
import com.tectonica.jonix.metadata.OnixFlagClass;
import com.tectonica.jonix.metadata.OnixMetadata;
import com.tectonica.jonix.metadata.OnixSimpleType;
import com.tectonica.jonix.metadata.OnixValueClass;
import com.tectonica.jonix.metadata.OnixValueClassMember;
import com.tectonica.jonix.metadata.OnixValueStruct;
import com.tectonica.jonix.util.ParseUtil;

public class GenerateCode
{
	public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException
	{
		final String basePackage = GenUtil.COMMON_PACKAGE;
		final String basePath = new File("..").getAbsolutePath();
		final String relativePath = "/src/main/java/com/tectonica/jonix";

		if (!new File(basePath).exists())
			throw new RuntimeException("couldn't find base folder for projects at " + basePath);

		final OnixMetadata ref2 = ParseUtil.parse(ParseUtil.RES_REF_2, ParseUtil.RES_CODELIST_2, ParseUtil.SPACEABLE_REF_2);
		final OnixMetadata ref3 = ParseUtil.parse(ParseUtil.RES_REF_3, ParseUtil.RES_CODELIST_3, ParseUtil.SPACEABLE_REF_3);

		// //////////////////////////////////////////////////////////////////////////////////////
		// UNIFIED CODELISTS + STRUCTS
		// //////////////////////////////////////////////////////////////////////////////////////

		final String codelistHome = basePath + "/jonix-common";
		if (!new File(codelistHome).exists())
			throw new RuntimeException("couldn't find jonix-common project at " + codelistHome);

		System.out.println("Generating unified codelists..");
		generateCodelists(basePackage, codelistHome + relativePath, "codelist", ref2, ref3);

		System.out.println("Generating unified structs..");
		generateStructs(basePackage, codelistHome + relativePath, "struct", ref2, ref3);

		// //////////////////////////////////////////////////////////////////////////////////////
		// ONIX 2
		// //////////////////////////////////////////////////////////////////////////////////////

		final String onix2home = basePath + "/jonix-onix2";
		if (!new File(onix2home).exists())
			throw new RuntimeException("couldn't find jonix-onix2 project at " + onix2home);

		System.out.println("Generating code for Onix2..");
		generateModel(basePackage, onix2home + relativePath, "onix2", ref2);

		// //////////////////////////////////////////////////////////////////////////////////////
		// ONIX 3
		// //////////////////////////////////////////////////////////////////////////////////////

		final String onix3home = basePath + "/jonix-onix3";
		if (!new File(onix3home).exists())
			throw new RuntimeException("couldn't find jonix-onix3 project at " + onix3home);

		System.out.println("Generating code for Onix3..");

		generateModel(basePackage, onix3home + relativePath, "onix3", ref3);

		// //////////////////////////////////////////////////////////////////////////////////////
		// FINISHED
		// //////////////////////////////////////////////////////////////////////////////////////

		System.out.println("DONE");
	}

	private static void generateModel(String basePackage, String baseFolder, String subfolder, OnixMetadata ref)
	{
		final OnixClassGen ccg = new OnixClassGen(basePackage, baseFolder, subfolder, ref);

		for (OnixContentClass occ : ref.contentClassesMap.values())
			ccg.generate(occ);

		for (OnixValueClass ovc : ref.valueClassesMap.values())
			ccg.generate(ovc);

		for (OnixFlagClass ofc : ref.flagClassesMap.values())
			ccg.generate(ofc);
	}

	private static void generateCodelists(String basePackage, String baseFolder, String subfolder, OnixMetadata ref2, OnixMetadata ref3)
	{
		final OnixEnumGen oeg = new OnixEnumGen(basePackage, baseFolder, subfolder);

		final List<OnixSimpleType> enums2 = new ArrayList<>(ref2.enumsMap.values());
		final List<OnixSimpleType> enums3 = new ArrayList<>(ref3.enumsMap.values());

		removeAliases(enums2);
		removeAliases(enums3);

		Collections.sort(enums2);
		Collections.sort(enums3);

		ListDiff.compare(enums2, enums3, new CompareListener<OnixSimpleType>()
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

	private static void removeAliases(List<OnixSimpleType> enums)
	{
		for (ListIterator<OnixSimpleType> iter = enums.listIterator(); iter.hasNext();)
		{
			final OnixSimpleType next = iter.next();
			if (next.enumAliasFor != null)
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

	private static void generateStructs(String basePackage, String baseFolder, String subfolder, final OnixMetadata ref2,
			final OnixMetadata ref3)
	{
		final OnixStructGen osg = new OnixStructGen(basePackage, baseFolder, subfolder);

		final List<OnixValueStruct> structs2 = new ArrayList<>(ref2.getStructs());
		final List<OnixValueStruct> structs3 = new ArrayList<>(ref3.getStructs());

		Collections.sort(structs2);
		Collections.sort(structs3);

		ListDiff.compare(structs2, structs3, new CompareListener<OnixValueStruct>()
		{
			@Override
			public void onDiff(final OnixValueStruct struct2, final OnixValueStruct struct3)
			{
				if (struct2 != null && struct3 != null)
				{
					final OnixValueStruct u = unifiedStruct(struct2, struct3);
					if (u == null)
					{
						ref2.structsMap.remove(struct2.containingClass.name);
						ref3.structsMap.remove(struct3.containingClass.name);
					}
					else
						osg.generate(u);
				}
				else if (struct2 != null)
				{
					osg.generate(struct2);
				}
				else
				{
					osg.generate(struct3);
				}
			}
		});
	}

	private static OnixValueStruct unifiedStruct(final OnixValueStruct struct2, final OnixValueStruct struct3)
	{
		final String className = struct3.containingClass.name;
		final OnixValueStruct unified = new OnixValueStruct(struct3.containingClass);

		final String enumName2 = struct2.keyEnumType().enumName;
		final String enumName3 = struct3.keyEnumType().enumName;
		if (!enumName2.equals(enumName3))
			throw new RuntimeException("In " + className + ", Can't reconcile when keys are of different types: Onix2=" + enumName2
					+ " Onix3=" + enumName3);

		unified.key = struct3.key;
		unified.members = new ArrayList<>();

		final List<OnixContentClassMember> members2 = new ArrayList<>(struct2.members);
		final List<OnixContentClassMember> members3 = new ArrayList<>(struct3.members);

		Collections.sort(members2);
		Collections.sort(members3);

		ListDiff.compare(members2, members3, new CompareListener<OnixContentClassMember>()
		{
			@Override
			public void onDiff(OnixContentClassMember m2, OnixContentClassMember m3)
			{
				if (m2 != null && m3 != null)
				{
					final String memberClassName = m2.className; // = m3.className
					OnixValueClassMember vm2 = ((OnixValueClass) m2.onixClass).valueMember;
					OnixValueClassMember vm3 = ((OnixValueClass) m3.onixClass).valueMember;
					final String javaType2 = vm2.simpleType.primitiveType.javaType;
					final String javaType3 = vm3.simpleType.primitiveType.javaType;
					if (!javaType2.equals(javaType3))
					{
						System.err.println("In " + className + ", type mismatch in " + memberClassName + ": Onix2=" + javaType2
								+ " vs Onix3=" + javaType3);
						unified.key = null; // cancels the unification
					}
					if (m2.cardinality != m3.cardinality)
					{
						System.err.println("In " + className + ", cardinality mismatch in " + memberClassName + ": Onix2=" + m2.cardinality
								+ " vs Onix3=" + m3.cardinality);
						unified.key = null; // cancels the unification
					}
					unified.members.add(m3);
				}
				else if (m2 != null)
				{
					unified.members.add(m2);
//					OnixValueClassMember vm2 = ((OnixValueClass) m2.onixClass).valueMember;
//					System.out.println(m2.className + ": " + vm2.simpleType.name + "(" + vm2.simpleType.primitiveType + ")");
				}
				else
				{
					unified.members.add(m3);
//					OnixValueClassMember vm3 = ((OnixValueClass) m3.onixClass).valueMember;
//					System.out.println(m3.className + ":                            " + vm3.simpleType.name + "("
//							+ vm3.simpleType.primitiveType + ")");
				}
			}
		});
		return (unified.key == null) ? null : unified;
	}
}
