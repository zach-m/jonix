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

import com.tectonica.jonix.metadata.OnixAttribute;
import com.tectonica.jonix.metadata.OnixClass;
import com.tectonica.jonix.metadata.OnixConst;
import com.tectonica.jonix.metadata.OnixContentClass;
import com.tectonica.jonix.metadata.OnixContentClassMember;
import com.tectonica.jonix.metadata.OnixFlagClass;
import com.tectonica.jonix.metadata.OnixMetadata;
import com.tectonica.jonix.metadata.OnixSimpleType;
import com.tectonica.jonix.metadata.OnixValueClass;

public class OnixClassGen
{
	private static final String EQUALS = "equals"; // turn to "equalsIgnoreCase" to assume case-insensitive XML

	private final String basePackage;
	private final String baseFolder;
	private final OnixMetadata ref;

	public OnixClassGen(String basePackage, String baseFolder, OnixMetadata ref)
	{
		this.basePackage = basePackage;
		this.baseFolder = baseFolder;
		this.ref = ref;
	}

	public void generate(String subfolder, OnixClass clz)
	{
		try
		{
			final String folder = baseFolder + "\\" + subfolder;
			new File(folder).mkdirs();
			String fileName = folder + "\\" + clz.name + ".java";

			try (PrintStream p = new PrintStream(fileName, "UTF-8"))
			{
				if (clz instanceof OnixContentClass)
					writeContentClass((OnixContentClass) clz, basePackage, subfolder, p);
				else if (clz instanceof OnixValueClass)
					writeValueClass((OnixValueClass) clz, basePackage, subfolder, p);
				else if (clz instanceof OnixFlagClass)
					writeFlagClass((OnixFlagClass) clz, basePackage, subfolder, p);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	private void writeContentClass(OnixContentClass clz, String basePackage, String subfolder, PrintStream p)
	{
		p.println(Comments.Copyright);
		p.printf("package %s;\n", basePackage + "." + subfolder);
		p.println();
		p.println("import java.io.Serializable;");
		p.println("import java.util.List;");
		p.println("import java.util.ArrayList;");
		p.println();
		p.printf("import %s.JPU;\n", basePackage);
		p.printf("import %s.codelist.*;\n", basePackage);
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
			final String field = fieldOf(m.className);
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
			final String field = fieldOf(className);
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
				final TypeInfo ti = typeInfoOf(ovc.valueMember.simpleType);
				final String field = fieldOf(m.className);
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
					p.printf("      { \n", field, field);
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

		p.println("}");
	}

	private void writeValueClass(OnixValueClass clz, String basePackage, String subfolder, PrintStream p)
	{
		p.println(Comments.Copyright);
		p.printf("package %s;\n", basePackage + "." + subfolder);
		p.println();
		p.println("import java.io.Serializable;");
		p.printf("import %s.JPU;\n", basePackage);
		p.printf("import %s.codelist.*;\n", basePackage);
		p.println();
		p.println(Comments.AutoGen);
		p.printf("@SuppressWarnings(\"serial\")\n");
		p.printf("public class %s implements Serializable\n", clz.name);
		p.printf("{\n");

		declareConstsAndAttributes(p, clz);

		// declare value
		final TypeInfo ti = typeInfoOf(clz.valueMember.simpleType);
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

	private void writeFlagClass(OnixFlagClass clz, String basePackage, String subfolder, PrintStream p)
	{
		p.println(Comments.Copyright);
		p.printf("package %s;\n", basePackage + "." + subfolder);
		p.println();
		p.println("import java.io.Serializable;");
		p.printf("import %s.JPU;\n", basePackage);
		p.printf("import %s.codelist.*;\n", basePackage);
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
			final TypeInfo ti = typeInfoOf(a);
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

	private class TypeInfo
	{
		String javaType;
		String comment;
		boolean isPrimitive;
		boolean isXHTML;
	}

	private TypeInfo typeInfoOf(OnixSimpleType simpleType)
	{
		return typeInfoOf(simpleType.name, simpleType.primitiveType.javaType, simpleType.enumName);
	}

	private TypeInfo typeInfoOf(OnixAttribute attt)
	{
		return typeInfoOf(attt.getSimpleTypeName(), attt.primitiveType.javaType, attt.getEnumName());
	}

	private TypeInfo typeInfoOf(String onixSimpleTypeName, String javaType, String enumName)
	{
		TypeInfo result = new TypeInfo();
		result.isXHTML = (onixSimpleTypeName == null) ? false : onixSimpleTypeName.equals(OnixSimpleType.XHTML.name);
		result.javaType = result.isXHTML ? null : enumName;
		result.isPrimitive = (result.javaType == null);
		result.comment = "";
		if (result.javaType == null)
		{
			result.javaType = javaType;
			if ((onixSimpleTypeName != null))
				result.comment = " // " + onixSimpleTypeName;
		}
		return result;
	}

	public String fieldOf(String propertyName)
	{
		// find the first lower-case character
		int i = 0;
		for (; i < propertyName.length(); i++)
			if (Character.isLowerCase(propertyName.charAt(i)))
				break;

		// "text" --> "text" (nothing to do)
		if (i == 0)
			return propertyName;

		// "TextFormat" --> "textFormat"
		if (i == 1)
			return propertyName.substring(0, 1).toLowerCase() + propertyName.substring(1);

		// "ISBN" --> "isbn"
		if (i == propertyName.length())
			return propertyName.toLowerCase();

		// "IDTypeName" --> "idTypeName"
		return propertyName.substring(0, i - 1).toLowerCase() + propertyName.substring(i - 1);
	}

	public static void main(String[] args)
	{
		final OnixClassGen ocg = new OnixClassGen(null, null, null);

		System.out.println(ocg.fieldOf("text"));
		System.out.println(ocg.fieldOf("TextFormat"));
		System.out.println(ocg.fieldOf("ISBN"));
		System.out.println(ocg.fieldOf("IDTypeName"));
	}
}
