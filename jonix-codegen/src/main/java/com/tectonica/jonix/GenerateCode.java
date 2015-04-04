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
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.tectonica.jonix.codegen.GenUtil;
import com.tectonica.jonix.codegen.ListDiff;
import com.tectonica.jonix.codegen.ListDiff.CompareListener;
import com.tectonica.jonix.codegen.OnixClassGen;
import com.tectonica.jonix.codegen.OnixEnumGen;
import com.tectonica.jonix.codegen.OnixStructGen;
import com.tectonica.jonix.codegen.Parser.OnixVersion;
import com.tectonica.jonix.metadata.OnixCompositeDef;
import com.tectonica.jonix.metadata.OnixCompositeMember;
import com.tectonica.jonix.metadata.OnixElementDef;
import com.tectonica.jonix.metadata.OnixElementMember;
import com.tectonica.jonix.metadata.OnixEnumValue;
import com.tectonica.jonix.metadata.OnixFlagDef;
import com.tectonica.jonix.metadata.OnixMetadata;
import com.tectonica.jonix.metadata.OnixSimpleType;
import com.tectonica.jonix.metadata.OnixStruct;
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

		final OnixMetadata ref2 = ParseUtil.parse(OnixVersion.Ver2_1_03, ParseUtil.RES_REF_2, ParseUtil.RES_CODELIST_2,
				ParseUtil.SPACEABLE_REF_2);
		final OnixMetadata ref3 = ParseUtil.parse(OnixVersion.Ver3_0_02, ParseUtil.RES_REF_3, ParseUtil.RES_CODELIST_3,
				ParseUtil.SPACEABLE_REF_3);

		final List<OnixSimpleType> unifiedCodelists = unifyCodelists(ref2, ref3);
		final Map<String, OnixStruct> unifiedStructs = unifyStructs(ref2, ref3);
//		unifyInterfaces(ref2, ref3);

		// Generate source code
		generateCodelists(basePackage, basePath, relativePath, unifiedCodelists);
		generateStructs(basePackage, basePath, relativePath, unifiedStructs.values());
		generateOnix2(basePackage, basePath, relativePath, ref2);
		generateOnix3(basePackage, basePath, relativePath, ref3);

		System.out.println("DONE");
	}

	private static void generateCodelists(final String basePackage, final String basePath, final String relativePath,
			final List<OnixSimpleType> unifiedCodelists)
	{
		final String codelistHome = basePath + "/jonix-common";
		if (!new File(codelistHome).exists())
			throw new RuntimeException("couldn't find jonix-common project at " + codelistHome);

		System.out.println("Generating unified codelists..");

		final OnixEnumGen oeg = new OnixEnumGen(basePackage, codelistHome + relativePath, "codelist");
		for (OnixSimpleType codelist : unifiedCodelists)
			oeg.generate(codelist);
	}

	private static void generateStructs(final String basePackage, final String basePath, final String relativePath,
			final Collection<OnixStruct> unifiedStructs)
	{
		final String codelistHome = basePath + "/jonix-common";
		if (!new File(codelistHome).exists())
			throw new RuntimeException("couldn't find jonix-common project at " + codelistHome);

		System.out.println("Generating unified structs..");

		final OnixStructGen osg = new OnixStructGen(basePackage, codelistHome + relativePath, "struct");
		for (OnixStruct struct : unifiedStructs)
			osg.generate(struct);
	}

	private static void generateOnix2(final String basePackage, final String basePath, final String relativePath, final OnixMetadata ref2)
	{
		final String onix2home = basePath + "/jonix-onix2";
		if (!new File(onix2home).exists())
			throw new RuntimeException("couldn't find jonix-onix2 project at " + onix2home);

		System.out.println("Generating code for Onix2..");
		generateModel(basePackage, onix2home + relativePath, "onix2", ref2);
	}

	private static void generateOnix3(final String basePackage, final String basePath, final String relativePath, final OnixMetadata ref3)
	{
		final String onix3home = basePath + "/jonix-onix3";
		if (!new File(onix3home).exists())
			throw new RuntimeException("couldn't find jonix-onix3 project at " + onix3home);

		System.out.println("Generating code for Onix3..");
		generateModel(basePackage, onix3home + relativePath, "onix3", ref3);
	}

	private static void generateModel(String basePackage, String baseFolder, String subfolder, OnixMetadata ref)
	{
		final OnixClassGen ccg = new OnixClassGen(basePackage, baseFolder, subfolder, ref);

		for (OnixCompositeDef composite : ref.onixComposites.values())
			ccg.generate(composite);

		for (OnixElementDef element : ref.onixElements.values())
			ccg.generate(element);

		for (OnixFlagDef flag : ref.onixFlags.values())
			ccg.generate(flag);
	}

	// /////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private static List<OnixSimpleType> unifyCodelists(OnixMetadata ref2, OnixMetadata ref3)
	{
		final List<OnixSimpleType> unifiedCodelists = new ArrayList<>();

		ListDiff.sortAndCompare(ref2.getEnums(), ref3.getEnums(), new CompareListener<OnixSimpleType>()
		{
			@Override
			public boolean onDiff(OnixSimpleType enum2, OnixSimpleType enum3)
			{
				// ignore aliases, we'll generate code out of the types they point to
				if (enum2 != null && enum2.enumAliasFor != null)
					return true;
				if (enum3 != null && enum3.enumAliasFor != null)
					return true;

				if (enum2 != null && enum3 != null)
				{
//					System.out.println("                                         Common: " + enum2.enumName);
					final OnixSimpleType unified = unifiedCodelist(enum2, enum3);
					unifiedCodelists.add(unified);
				}
				else if (enum2 != null)
				{
//					System.out.println("Unique to Onix2: " + enum2.enumName);
					enum2.comment += "\n<p>" + "NOTE: Deprecated in Onix3";
					unifiedCodelists.add(enum2);
				}
				else
				{
//					System.out.println("Unique to Onix3: " + enum3.enumName);
					enum3.comment += "\n<p>" + "NOTE: Introduced in Onix3";
					unifiedCodelists.add(enum3);
				}
				return true;
			}
		});

		return unifiedCodelists;
	}

	private static OnixSimpleType unifiedCodelist(final OnixSimpleType enum2, final OnixSimpleType enum3)
	{
		final OnixSimpleType result = OnixSimpleType.cloneFrom(enum3);
		ListDiff.compare(enum2.enumValues, enum3.enumValues, new CompareListener<OnixEnumValue>()
		{
			@Override
			public boolean onDiff(OnixEnumValue enumValue2, OnixEnumValue enumValue3)
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
				return true;
			}
		});
		return result;
	}

	// /////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private static Map<String, OnixStruct> unifyStructs(final OnixMetadata ref2, final OnixMetadata ref3)
	{
		final Map<String, OnixStruct> unifiedStructs = new HashMap<>();

		ListDiff.sortAndCompare(ref2.getStructs(), ref3.getStructs(), new CompareListener<OnixStruct>()
		{
			@Override
			public boolean onDiff(final OnixStruct struct2, final OnixStruct struct3)
			{
				if (struct2 != null && struct3 != null)
				{
					final OnixStruct unified = unifiedStruct(struct2, struct3);
					if (unified != null)
						unifiedStructs.put(struct3.containingComposite.name, unified);
				}
				else if (struct2 != null)
				{
					unifiedStructs.put(struct2.containingComposite.name, struct2);
				}
				else
				{
					unifiedStructs.put(struct3.containingComposite.name, struct3);
				}
				return true;
			}
		});

		ref2.unifiedStructs = unifiedStructs;
		ref3.unifiedStructs = unifiedStructs;

		return unifiedStructs;
	}

	private static OnixStruct unifiedStruct(final OnixStruct struct2, final OnixStruct struct3)
	{
		final String className = struct3.containingComposite.name;
		final OnixStruct unified = new OnixStruct(struct3.containingComposite);

		if (struct2.isKeyed() != struct3.isKeyed())
			throw new RuntimeException("Class " + className
					+ ", can't be unified into struct as keys are of different searchability: Onix2=" + struct2.isKeyed() + " Onix3="
					+ struct3.isKeyed());

		if (struct3.keyMember != null)
		{
			final String enumName2 = struct2.keyEnumType().enumName;
			final String enumName3 = struct3.keyEnumType().enumName;
			if (!enumName2.equals(enumName3))
				throw new RuntimeException("Class " + className + ", can't be unified into struct as keys are of different types: Onix2="
						+ enumName2 + " Onix3=" + enumName3);

			unified.keyMember = struct3.keyMember;
		}

		unified.members = new ArrayList<>();

		boolean completed = ListDiff.sortAndCompare(struct2.members, struct3.members, new CompareListener<OnixCompositeMember>()
		{
			@Override
			public boolean onDiff(OnixCompositeMember m2, OnixCompositeMember m3)
			{
				if (m2 != null && m3 != null)
				{
					final String memberClassName = m2.className; // = m3.className
					OnixElementMember vm2 = ((OnixElementDef) m2.onixClass).valueMember;
					OnixElementMember vm3 = ((OnixElementDef) m3.onixClass).valueMember;
					final String javaType2 = vm2.simpleType.primitiveType.javaType;
					final String javaType3 = vm3.simpleType.primitiveType.javaType;
					if (!javaType2.equals(javaType3))
					{
						System.err.println("<" + className + "> can't be unified into struct: type mismatch in '" + memberClassName
								+ "': Onix2=" + javaType2 + " vs Onix3=" + javaType3);
						return false; // can't unify, we cancel the scanning of the remaining members
					}
					if (m2.cardinality != m3.cardinality)
					{
						System.err.println("<" + className + "> can't be unified into struct: cardinality mismatch in '" + memberClassName
								+ "': Onix2=" + m2.cardinality + " vs Onix3=" + m3.cardinality);
						return false; // can't unify, we cancel the scanning of the remaining members
					}
					unified.members.add(m3);
				}
				else if (m2 != null)
				{
					unified.members.add(m2);
//					OnixElementClassMember vm2 = ((OnixElementClass) m2.onixClass).valueMember;
//					System.out.println(m2.className + ": " + vm2.simpleType.name + "(" + vm2.simpleType.primitiveType + ")");
				}
				else
				{
					unified.members.add(m3);
//					OnixElementClassMember vm3 = ((OnixElementClass) m3.onixClass).valueMember;
//					System.out.println(m3.className + ":                            " + vm3.simpleType.name + "("
//							+ vm3.simpleType.primitiveType + ")");
				}
				return true;
			}
		});
		return (completed ? unified : null);
	}

	// /////////////////////////////////////////////////////////////////////////////////////////////////////////////

//	private static List<OnixCompositeDef> unifyInterfaces(final OnixMetadata ref2, final OnixMetadata ref3)
//	{
//		final List<OnixCompositeDef> unifiedInterfaces = new ArrayList<>();
//
//		ListDiff.sortAndCompare(ref2.getIntfs(), ref3.getIntfs(), new CompareListener<OnixCompositeDef>()
//		{
//			@Override
//			public boolean onDiff(final OnixCompositeDef composite2, final OnixCompositeDef composite3)
//			{
//				if (composite2 != null && composite3 != null)
//				{
//					System.err.println("Shared non-struct: " + composite2.name);
//				}
//				else if (composite2 != null)
//				{
//					System.out.println("                             Onix2 non-struct: " + composite2.name);
//				}
//				else
//				{
//					System.out.println("                                                           Onix3 non-struct: " + composite3.name);
//				}
//				return true;
//			}
//		});
//
//		return unifiedInterfaces;
//	}
}
