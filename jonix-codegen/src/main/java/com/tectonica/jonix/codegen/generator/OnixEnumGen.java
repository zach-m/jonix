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

import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;

import com.tectonica.jonix.codegen.metadata.OnixEnumValue;
import com.tectonica.jonix.codegen.metadata.OnixSimpleType;
import com.tectonica.jonix.codegen.util.XML;

public class OnixEnumGen
{
	private static final int MIN_FOR_MAP = 8;

	private final String packageName;
	private final String folderName;

	public OnixEnumGen(String basePackage, String baseFolder, String subfolder)
	{
		packageName = basePackage + "." + subfolder;
		folderName = baseFolder + "/" + subfolder;
		GenUtil.prepareOutputFolder(folderName);
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
			String fileName = folderName + "/" + enumType.enumName + ".java";

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
		p.println("import com.tectonica.jonix.OnixCodelist;");
		if (enumType.enumValues.size() >= MIN_FOR_MAP)
		{
			p.println();
			p.println("import java.util.Map;");
			p.println("import java.util.HashMap;");
		}

		p.println();
		p.println(Comments.AutoGen);
		p.printf("/**\n");
		String codelistNum = enumType.name.substring("List".length());
		p.printf(" * <code>Enum</code> that corresponds to ONIX <b>Codelist %s</b>\n", codelistNum);
		if (enumType.comment != null)
		{
			p.printf(" * <p>\n");
			p.printf(" * Description: %s\n", XML.escape(enumType.comment));
		}
		String linkGeneral = "http://www.editeur.org/14/code-lists";
		String link = "http://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_32.html#codelist"
				+ codelistNum;
		p.printf(" * \n");
		p.printf(" * @see <a href=\"%s\">About ONIX Codelists</a>\n", linkGeneral);
		p.printf(" * @see <a href=\"%s\">ONIX Codelist %s in Reference Guide</a>\n", link, codelistNum);
		p.printf(" */\n");

		p.println("public enum " + enumType.enumName + " implements OnixCodelist");
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
				p.printf("    * %s\n", XML.escape(ev.description));
				p.printf("    */\n");
			}
			p.printf("   %s(\"%s\", \"%s\")", token, ev.value, ev.name);
		}
		p.print(";\n");

		p.println();
		p.printf("   public final String code;\n");
		p.printf("   public final String description;\n");
		p.println();
		p.printf("   private %s(String code, String description)\n", enumType.enumName);
		p.printf("   {\n");
		p.printf("      this.code = code;\n");
		p.printf("      this.description = description;\n");
		p.printf("   }\n");

		p.println();
		p.println("   @Override");
		p.println("   public String getCode()");
		p.println("   {");
		p.println("      return code;");
		p.println("   }");
		p.println();
		p.println("   @Override");
		p.println("   public String getDescription()");
		p.println("   {");
		p.println("      return description;");
		p.println("   }");

		if (enumType.enumValues.size() < MIN_FOR_MAP)
		{
			p.println();
			p.printf("   public static %s byCode(String code)\n", enumType.enumName);
			p.printf("   {\n");
			p.printf("      if (code == null || code.isEmpty())\n");
			p.printf("         return null;\n");
			p.printf("      for (%s e : values())\n", enumType.enumName);
			p.printf("         if (e.code.equals(code))\n");
			p.printf("            return e;\n");
			p.printf("      return null;\n");
			p.printf("   }\n");
		}
		else
		{
			p.println();
			p.printf("   private static Map<String, %s> map;\n", enumType.enumName);
			p.println();
			p.printf("   private synchronized static Map<String, %s> map()\n", enumType.enumName);
			p.printf("   {\n");
			p.printf("      if (map == null)\n");
			p.printf("      {\n");
			p.printf("         map = new HashMap<>();\n");
			p.printf("         for (%s e : values())\n", enumType.enumName);
			p.printf("            map.put(e.code, e);\n");
			p.printf("      }\n");
			p.printf("      return map;\n");
			p.printf("   }\n");
			p.println();
			p.printf("   public static %s byCode(String code)\n", enumType.enumName);
			p.printf("   {\n");
			p.printf("      if (code == null || code.isEmpty())\n");
			p.printf("         return null;\n");
			p.printf("      return map().get(code);\n");
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
