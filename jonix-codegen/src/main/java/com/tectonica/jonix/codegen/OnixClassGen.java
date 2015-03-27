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

import com.tectonica.jonix.codegen.GenUtil.TypeInfo;
import com.tectonica.jonix.metadata.OnixAttribute;
import com.tectonica.jonix.metadata.OnixClass;
import com.tectonica.jonix.metadata.OnixConst;
import com.tectonica.jonix.metadata.OnixContentClass;
import com.tectonica.jonix.metadata.OnixContentClassMember;
import com.tectonica.jonix.metadata.OnixFlagClass;
import com.tectonica.jonix.metadata.OnixMetadata;
import com.tectonica.jonix.metadata.OnixValueClass;
import com.tectonica.jonix.metadata.OnixValueStruct;

public class OnixClassGen
{
	private static final String EQUALS = "equals"; // turn to "equalsIgnoreCase" to assume case-insensitive XML

	private final String packageName;
	private final String folderName;

	private final OnixMetadata ref;

	public OnixClassGen(String basePackage, String baseFolder, String subfolder, OnixMetadata ref)
	{
		packageName = basePackage + "." + subfolder;
		folderName = baseFolder + "\\" + subfolder;
		this.ref = ref;
		new File(folderName).mkdirs();
	}

	public void generate(OnixClass clz)
	{
		try
		{
			String fileName = folderName + "\\" + clz.name + ".java";

			try (PrintStream p = new PrintStream(fileName, "UTF-8"))
			{
				if (clz instanceof OnixContentClass)
					writeContentClass((OnixContentClass) clz, p);
				else if (clz instanceof OnixValueClass)
					writeValueClass((OnixValueClass) clz, p);
				else if (clz instanceof OnixFlagClass)
					writeFlagClass((OnixFlagClass) clz, p);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	private void writeContentClass(OnixContentClass clz, PrintStream p)
	{
		p.println(Comments.Copyright);
		p.printf("package %s;\n", packageName);
		p.println();
		p.println("import java.io.Serializable;");
		p.println("import java.util.List;");
		p.println("import java.util.ArrayList;");
		p.println();
		p.printf("import %s.JPU;\n", GenUtil.COMMON_PACKAGE);
		p.printf("import %s.codelist.*;\n", GenUtil.COMMON_PACKAGE);
		p.printf("import %s.struct.*;\n", GenUtil.COMMON_PACKAGE);
		p.println();
		p.println(Comments.AutoGen);
		p.printf("@SuppressWarnings(\"serial\")\n");
		p.printf("public class %s implements Serializable\n", clz.name);
		p.printf("{\n");

		declareConstsAndAttributes(p, clz);

		// declare members
		p.println();
		for (OnixContentClassMember m : clz.members)
		{
			final String field = GenUtil.fieldOf(m.className);
			if (m.cardinality.singular)
				p.printf("   public %s %s; // %s\n", m.className, field, m.cardinality.name());
			else
				p.printf("   public List<%s> %ss; // %s\n", m.className, field, m.cardinality.name());
		}

		// default-constructor
		p.println();
		p.printf("   public %s()\n", clz.name);
		p.printf("   {}\n");

		// constructor
		p.println();
		p.printf("   public %s(org.w3c.dom.Element element)\n", clz.name);
		p.printf("   {\n");

		extractAttributes(clz, p);

		p.println();
		p.printf("      JPU.forElementsOf(element, new JPU.ElementListener()\n");
		p.printf("      {\n");
		p.printf("         @Override\n");
		p.printf("         public void onElement(org.w3c.dom.Element element)\n");
		p.printf("         {\n");
		p.printf("            final String name = element.getNodeName();\n");
		boolean first = true;
		for (OnixContentClassMember m : clz.members)
		{
			final String className = m.className;
			final String field = GenUtil.fieldOf(className);
			p.print("            ");
			if (first)
				first = false;
			else
				p.print("else ");
			p.printf("if (name.%s(%s.refname) || name.%s(%s.shortname))\n", EQUALS, className, EQUALS, className);
			if (m.cardinality.singular)
				p.printf("               %s = new %s(element);\n", field, className);
			else
				p.printf("               %ss = JPU.addToList(%ss, new %s(element));\n", field, field, className);
		}
		p.printf("         }\n");
		p.printf("      });\n");

		p.printf("   }\n");

		// declare value getters
		for (OnixContentClassMember m : clz.members)
		{
			final OnixValueClass ovc = ref.valueClassByName(m.className);
			if (ovc != null)
			{
				final TypeInfo ti = GenUtil.typeInfoOf(ovc.valueMember.simpleType);
				final String field = GenUtil.fieldOf(m.className);
				String javaType = ti.javaType;
				if (ovc.isSpaceable)
					javaType = "java.util.Set<" + javaType + ">";
				if (m.cardinality.singular)
				{
					final String caption = ovc.isSpaceable ? "Set" : "Value";
					p.println();
					p.printf("   public %s get%s%s()\n", javaType, m.className, caption);
					p.printf("   {\n");
					p.printf("      return (%s == null) ? null : %s.value;\n", field, field);
					p.printf("   }\n");
				}
				else
				{
					final String caption = ovc.isSpaceable ? "Sets" : "Values";
					p.println();
					p.printf("   public List<%s> get%s%s()\n", javaType, m.className, caption);
					p.printf("   {\n");
					p.printf("      if (%ss != null) \n", field);
					p.printf("      { \n");
					p.printf("         List<%s> list = new ArrayList<>(); \n", javaType);
					p.printf("         for (%s i : %ss) \n", m.className, field);
					p.printf("            list.add(i.value); \n");
					p.printf("         return list; \n");
					p.printf("      } \n");
					p.printf("      return null;\n");
					p.printf("   }\n");
				}
			}
		}

		// declare struct finder for Lists
		for (OnixContentClassMember m : clz.members)
		{
			if (!m.cardinality.singular)
			{
				final OnixValueStruct struct = ref.structsMap.get(m.className);
				if (struct != null)
				{
					final String structName = "Jonix" + m.className;
					final OnixValueClass keyClass = (OnixValueClass) struct.key.onixClass;
					final TypeInfo kti = GenUtil.typeInfoOf(keyClass.valueMember.simpleType);
					final String keyClassName = struct.key.className;
					final String keyField = GenUtil.fieldOf(keyClassName);
					final String memberfield = GenUtil.fieldOf(m.className) + "s";
					final String caption = keyClass.isSpaceable ? "Set" : "Value";

					p.println();
					p.printf("   public %s find%s(%s %s)\n", structName, m.className, kti.javaType, keyField);
					p.printf("   {\n");
					p.printf("      if (%s != null)\n", memberfield);
					p.printf("      {\n");
					p.printf("         for (%s x : %s)\n", m.className, memberfield);
					p.printf("         {\n");
					p.printf("            if (x.get%s%s() == %s)\n", keyClassName, caption, keyField);
					p.printf("               return x.asStruct();\n");
					p.printf("         }\n");
					p.printf("      }\n");
					p.printf("      return null;\n");
					p.printf("   }\n");

					p.println();
					p.printf("   public List<%s> find%ss(java.util.Set<%s> %ss)\n", structName, m.className, kti.javaType, keyField);
					p.printf("   {\n");
					p.printf("      if (%s != null)\n", memberfield);
					p.printf("      {\n");
					p.printf("         List<%s> matches = new ArrayList<>();\n", structName);
					p.printf("         for (%s x : %s)\n", m.className, memberfield);
					p.printf("         {\n");
					p.printf("            if (%ss == null || %ss.contains(x.get%s%s()))\n", keyField, keyField, keyClassName, caption);
					p.printf("               matches.add(x.asStruct());\n");
					p.printf("         }\n");
					p.printf("         return matches;\n", structName);
					p.printf("      }\n");
					p.printf("      return null;\n");
					p.printf("   }\n");
				}
			}
		}

		// declare struct provider
		final OnixValueStruct struct = ref.structsMap.get(clz.name);
		if (struct != null)
		{
			final String structName = "Jonix" + clz.name;

			p.println();
			p.printf("   public %s asStruct()\n", structName);
			p.printf("   {\n");
			p.printf("      %s x = new %s();\n", structName, structName);

			for (OnixContentClassMember member : struct.members)
			{
				String field = GenUtil.fieldOf(member.className);
				String caption = ((OnixValueClass) member.onixClass).isSpaceable ? "Set" : "Value";
				if (!member.cardinality.singular)
				{
					field += "s";
					caption += "s";
				}
				p.printf("      x.%s = get%s%s();\n", field, member.className, caption);
			}

			p.printf("      return x;\n");
			p.printf("   }\n");
		}

		p.println("}");
	}

	private void writeValueClass(OnixValueClass clz, PrintStream p)
	{
		p.println(Comments.Copyright);
		p.printf("package %s;\n", packageName);
		p.println();
		p.println("import java.io.Serializable;");
		p.printf("import %s.JPU;\n", GenUtil.COMMON_PACKAGE);
		p.printf("import %s.codelist.*;\n", GenUtil.COMMON_PACKAGE);
		p.println();
		p.println(Comments.AutoGen);
		p.printf("@SuppressWarnings(\"serial\")\n");
		p.printf("public class %s implements Serializable\n", clz.name);
		p.printf("{\n");

		declareConstsAndAttributes(p, clz);

		// declare value
		final TypeInfo ti = GenUtil.typeInfoOf(clz.valueMember.simpleType);
		p.println();
		if (!clz.isSpaceable)
			p.printf("   public %s value;%s\n", ti.javaType, ti.comment);
		else
			p.printf("   public java.util.Set<%s> value;%s\n", ti.javaType, ti.comment);

		// default-constructor
		p.println();
		p.printf("   public %s()\n", clz.name);
		p.printf("   {}\n");

		// constructor
		p.println();
		p.printf("   public %s(org.w3c.dom.Element element)\n", clz.name);
		p.printf("   {\n");

		extractAttributes(clz, p);

		p.println();
		if (ti.isXHTML)
			p.printf("      value = JPU.getChildXHTML(element, true);\n");
		else if (!clz.isSpaceable)
		{
			if (ti.isPrimitive)
				p.printf("      value = JPU.getContentAs%s(element);\n", ti.javaType);
			else
				p.printf("      value = %s.byValue(JPU.getContentAsString(element));\n", ti.javaType);
		}
		else
		{
			p.printf("      value = new java.util.HashSet<>();\n");
			p.printf("      for (String split : JPU.getContentAsString(element).trim().split(\" +\"))\n");
			if (ti.isPrimitive)
				p.printf("         value.add(%s.valueOf(split));\n", ti.javaType);
			else
				p.printf("         value.add(%s.byValue(split));\n", ti.javaType);
		}

		p.printf("   }\n");

		p.println("}");
	}

	private void writeFlagClass(OnixFlagClass clz, PrintStream p)
	{
		p.println(Comments.Copyright);
		p.printf("package %s;\n", packageName);
		p.println();
		p.println("import java.io.Serializable;");
		p.printf("import %s.JPU;\n", GenUtil.COMMON_PACKAGE);
		p.printf("import %s.codelist.*;\n", GenUtil.COMMON_PACKAGE);
		p.println();
		p.println(Comments.AutoGen);
		p.printf("@SuppressWarnings(\"serial\")\n");
		p.printf("public class %s implements Serializable\n", clz.name);
		p.printf("{\n");

		declareConstsAndAttributes(p, clz);

		// default-constructor
		p.println();
		p.printf("   public %s()\n", clz.name);
		p.printf("   {}\n");

		// constructor
		p.println();
		p.printf("   public %s(org.w3c.dom.Element element)\n", clz.name);
		p.printf("   {\n");

		extractAttributes(clz, p);

		p.printf("   }\n");

		p.println("}");
	}

	private void declareConstsAndAttributes(PrintStream p, OnixClass clz)
	{
		for (OnixConst c : clz.consts)
			p.printf("   public static final String %s = \"%s\";\n", c.name, c.value);

		p.println();
		for (OnixAttribute a : clz.attributes)
		{
			final TypeInfo ti = GenUtil.typeInfoOf(a);
			p.printf("   public %s %s;%s\n", ti.javaType, a.name, ti.comment);
		}
	}

	private void extractAttributes(OnixClass clz, PrintStream p)
	{
		for (OnixAttribute a : clz.attributes)
		{
			String enumType = a.getEnumName();

			if (enumType == null)
				p.printf("      this.%s = JPU.getAttribute(element, \"%s\");\n", a.name, a.name);
			else
				p.printf("      this.%s = %s.byValue(JPU.getAttribute(element, \"%s\"));\n", a.name, enumType, a.name);
		}
	}
}
