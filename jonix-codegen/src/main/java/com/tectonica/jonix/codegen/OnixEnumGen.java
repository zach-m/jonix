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
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;

import com.tectonica.jonix.metadata.OnixEnumValue;
import com.tectonica.jonix.metadata.OnixMetadata;
import com.tectonica.jonix.metadata.OnixSimpleType;

public class OnixEnumGen
{
	private static final int MIN_FOR_MAP = 8;

	private final String basePackage;
	private final String baseFolder;

	@SuppressWarnings("unused")
	private final OnixMetadata ref;

	public OnixEnumGen(String basePackage, String baseFolder, OnixMetadata ref)
	{
		this.basePackage = basePackage;
		this.baseFolder = baseFolder;
		this.ref = ref;
	}

	public void generate(String subfolder, OnixSimpleType enumType)
	{
		if (enumType.enumValues == null)
			throw new RuntimeException("Non-enum: " + enumType);

		try
		{
			final String folder = baseFolder + "\\" + subfolder;
			new File(folder).mkdirs();
			String fileName = folder + "\\" + enumType.name + ".java";
			String packageName = basePackage + "." + subfolder;

			try (PrintStream p = new PrintStream(fileName, "UTF-8"))
			{
				writeEnumClass(enumType, packageName, p);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	private void writeEnumClass(OnixSimpleType enumType, String packageName, PrintStream p)
	{
		p.println(Comments.Copyright);
		p.printf("package %s;\n", packageName);

		p.println();
		if (enumType.enumValues.size() >= MIN_FOR_MAP)
		{
			p.println("import java.util.Map;");
			p.println("import java.util.HashMap;");
		}

		p.println();
		p.println(Comments.AutoGen);
		if (enumType.comment != null)
		{
			p.printf("/**\n");
			p.printf(" * %s\n", enumType.comment);
			p.printf(" */\n");
		}
		p.println("public enum " + enumType.name);
		p.println("{");

		Set<String> tokens = new HashSet<>();
		boolean first = true;
		for (OnixEnumValue ev : enumType.enumValues)
		{
			String token = enumNameOf(ev.name);
			while (!tokens.add(token))
				token += "_";

			if (first)
				first = false;
			else
				p.print(", //\n\n");
			if (ev.description != null)
			{
				p.printf("\t" + "/**\n");
				p.printf("\t" + " * %s\n", ev.description);
				p.printf("\t" + " */\n");
			}
			p.printf("\t" + "%s(\"%s\")", token, ev.value);
		}
		p.print(";\n");

		p.println();
		p.printf("\t" + "public final String value;\n");
		p.println();
		p.printf("\t" + "private %s(String value)\n", enumType.name);
		p.printf("\t" + "{\n");
		p.printf("\t\t" + "this.value = value;\n");
		p.printf("\t" + "}\n");

		if (enumType.enumValues.size() < MIN_FOR_MAP)
		{
			p.println();
			p.printf("\t" + "public static %s byValue(String value)\n", enumType.name);
			p.printf("\t" + "{\n");
			p.printf("\t\t" + "if (value == null || value.isEmpty())\n");
			p.printf("\t\t\t" + "return null;\n");
			p.printf("\t\t" + "for (%s e : values())\n", enumType.name);
			p.printf("\t\t\t" + "if (e.value.equals(value))\n");
			p.printf("\t\t\t\t" + "return e;\n");
			p.printf("\t\t" + "return null;\n");
			p.printf("\t" + "}\n");
		}
		else
		{
			p.println();
			p.printf("\t" + "private static Map<String, %s> map;\n", enumType.name);
			p.println();
			p.printf("\t" + "private static Map<String, %s> map()\n", enumType.name);
			p.printf("\t" + "{\n");
			p.printf("\t\t" + "if (map == null)\n");
			p.printf("\t\t" + "{\n");
			p.printf("\t\t\t" + "map = new HashMap<>();\n");
			p.printf("\t\t\t" + "for (%s e : values())\n", enumType.name);
			p.printf("\t\t\t\t" + "map.put(e.value, e);\n");
			p.printf("\t\t" + "}\n");
			p.printf("\t\t" + "return map;\n");
			p.printf("\t" + "}\n");
			p.println();
			p.printf("\t" + "public static %s byValue(String value)\n", enumType.name);
			p.printf("\t" + "{\n");
			p.printf("\t\t" + "if (value == null || value.isEmpty())\n");
			p.printf("\t\t\t" + "return null;\n");
			p.printf("\t\t" + "return map().get(value);\n");
			p.printf("\t" + "}\n");
		}

		p.println("}");
	}

	public String enumNameOf(String rawName)
	{
		return rawName.replaceAll("(.+?)\\)(.*)", "$1").trim().replaceAll("[^a-zA-Z0-9_]+", "_").replaceAll("^([0-9].*)", "_$1");
	}

	public static void main(String[] args)
	{
		final OnixEnumGen aux = new OnixEnumGen(null, null, null);
		String s;

		s = "By (photographer)";
		System.out.println(s + " --> " + aux.enumNameOf(s));

		s = "Tagalog (Baybayin, Alibata)";
		System.out.println(s + " --> " + aux.enumNameOf(s));

		s = "16:10";
		System.out.println(s + " --> " + aux.enumNameOf(s));
		
		s = "Distinctive title (book); Cover title (serial); Title on item (serial content item or reviewed resource)";
		System.out.println(s + " --> " + aux.enumNameOf(s));
	}
}
