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

import java.io.File;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;

import com.tectonica.jonix.codegen.metadata.OnixEnumValue;
import com.tectonica.jonix.codegen.metadata.OnixSimpleType;

public class OnixEnumGen
{
	private static final int MIN_FOR_MAP = 8;

	private final String packageName;
	private final String folderName;

	public OnixEnumGen(String basePackage, String baseFolder, String subfolder)
	{
		packageName = basePackage + "." + subfolder;
		folderName = baseFolder + "\\" + subfolder;
		new File(folderName).mkdirs();
	}

	public void generate(OnixSimpleType enumType)
	{
		if (enumType.enumAliasFor != null)
//			return;
			throw new RuntimeException("Alias enum was passed: " + enumType.name + " ==> " + enumType.enumAliasFor);

		if (!enumType.isEnum())
			throw new RuntimeException("Non-enum: " + enumType);

		try
		{
			String fileName = folderName + "\\" + enumType.enumName + ".java";

			try (PrintStream p = new PrintStream(fileName, "UTF-8"))
			{
				writeEnumClass(enumType, p);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	private void writeEnumClass(OnixSimpleType enumType, PrintStream p)
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
		p.printf("/**\n");
		p.printf(" * Enum that corresponds to ONIX's <b>Code%s</b>\n", enumType.name);
		if (enumType.comment != null)
		{
			p.printf(" * <p>\n");
			p.printf(" * %s\n", enumType.comment);
		}
		String link = "http://www.editeur.org/14/code-lists";
		p.printf(" * \n");
		p.printf(" * @see <a href=\"%s\">%s</a>\n", link, link);
		p.printf(" */\n");

		p.println("public enum " + enumType.enumName);
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
				p.printf("   /**\n");
				p.printf("    * %s\n", ev.description);
				p.printf("    */\n");
			}
			p.printf("   %s(\"%s\")", token, ev.value);
		}
		p.print(";\n");

		p.println();
		p.printf("   public final String value;\n");
		p.println();
		p.printf("   private %s(String value)\n", enumType.enumName);
		p.printf("   {\n");
		p.printf("      this.value = value;\n");
		p.printf("   }\n");

		if (enumType.enumValues.size() < MIN_FOR_MAP)
		{
			p.println();
			p.printf("   public static %s byValue(String value)\n", enumType.enumName);
			p.printf("   {\n");
			p.printf("      if (value == null || value.isEmpty())\n");
			p.printf("         return null;\n");
			p.printf("      for (%s e : values())\n", enumType.enumName);
			p.printf("         if (e.value.equals(value))\n");
			p.printf("            return e;\n");
			p.printf("      return null;\n");
			p.printf("   }\n");
		}
		else
		{
			p.println();
			p.printf("   private static Map<String, %s> map;\n", enumType.enumName);
			p.println();
			p.printf("   private static Map<String, %s> map()\n", enumType.enumName);
			p.printf("   {\n");
			p.printf("      if (map == null)\n");
			p.printf("      {\n");
			p.printf("         map = new HashMap<>();\n");
			p.printf("         for (%s e : values())\n", enumType.enumName);
			p.printf("            map.put(e.value, e);\n");
			p.printf("      }\n");
			p.printf("      return map;\n");
			p.printf("   }\n");
			p.println();
			p.printf("   public static %s byValue(String value)\n", enumType.enumName);
			p.printf("   {\n");
			p.printf("      if (value == null || value.isEmpty())\n");
			p.printf("         return null;\n");
			p.printf("      return map().get(value);\n");
			p.printf("   }\n");
		}

		p.println("}");
	}

	public String enumNameOf(String rawName)
	{
		return rawName.replaceAll("(.+?)\\)(.*)", "$1").trim().replaceAll("[^a-zA-Z0-9_]+", "_")
				.replaceAll("^([0-9].*)", "_$1");
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
