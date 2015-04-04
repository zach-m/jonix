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

import com.tectonica.jonix.codegen.GenUtil.FieldInfo;
import com.tectonica.jonix.codegen.GenUtil.TypeInfo;
import com.tectonica.jonix.metadata.OnixAttribute;
import com.tectonica.jonix.metadata.OnixClass;
import com.tectonica.jonix.metadata.OnixConst;
import com.tectonica.jonix.metadata.OnixCompositeDef;
import com.tectonica.jonix.metadata.OnixCompositeMember;
import com.tectonica.jonix.metadata.OnixFlagDef;
import com.tectonica.jonix.metadata.OnixMetadata;
import com.tectonica.jonix.metadata.OnixStruct;
import com.tectonica.jonix.metadata.OnixElementDef;

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

	public void generate(OnixClass onixClass)
	{
		try
		{
			String fileName = folderName + "\\" + onixClass.name + ".java";

			try (PrintStream p = new PrintStream(fileName, "UTF-8"))
			{
				if (onixClass instanceof OnixCompositeDef)
					writeCompositeClass((OnixCompositeDef) onixClass, p);
				else if (onixClass instanceof OnixElementDef)
					writeElementClass((OnixElementDef) onixClass, p);
				else if (onixClass instanceof OnixFlagDef)
					writeFlagClass((OnixFlagDef) onixClass, p);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	private void writeCompositeClass(OnixCompositeDef composite, PrintStream p)
	{
		p.println(Comments.Copyright);
		p.printf("package %s;\n", packageName);
		p.println();
		p.println("import java.io.Serializable;");
		p.println("import java.util.List;");
		p.println("import java.util.ArrayList;");
		p.println();
		p.printf("import %s.JPU;\n", GenUtil.COMMON_PACKAGE);
		p.printf("import %s.OnixComposite;\n", GenUtil.COMMON_PACKAGE);
		p.printf("import %s.codelist.*;\n", GenUtil.COMMON_PACKAGE);
		p.printf("import %s.struct.*;\n", GenUtil.COMMON_PACKAGE);
		p.println();
		p.println(Comments.AutoGen);
		p.printf("@SuppressWarnings(\"serial\")\n");
		p.printf("public class %s implements OnixComposite, Serializable\n", composite.name);
		p.printf("{\n");

		declareConstsAndAttributes(p, composite);

		// declare members
		p.println();
		for (OnixCompositeMember member : composite.members)
		{
			final FieldInfo fi = GenUtil.fieldInfoOf(member);
			p.printf("   public %s %s; // %s\n", fi.type, fi.name, fi.comment);
		}

		// default-constructor
		p.println();
		p.printf("   public %s()\n", composite.name);
		p.printf("   {}\n");

		// constructor
		p.println();
		p.printf("   public %s(org.w3c.dom.Element element)\n", composite.name);
		p.printf("   {\n");

		extractAttributes(composite, p);

		p.println();
		p.printf("      JPU.forElementsOf(element, new JPU.ElementListener()\n");
		p.printf("      {\n");
		p.printf("         @Override\n");
		p.printf("         public void onElement(org.w3c.dom.Element element)\n");
		p.printf("         {\n");
		p.printf("            final String name = element.getNodeName();\n");
		boolean first = true;
		for (OnixCompositeMember m : composite.members)
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

		// declare direct value getters for element-members
		for (OnixCompositeMember m : composite.members)
		{
			final OnixElementDef element = ref.elementByName(m.className);
			if (element != null)
			{
				final TypeInfo ti = GenUtil.typeInfoOf(element.valueMember.simpleType);
				final String field = GenUtil.fieldOf(m.className);
				String javaType = ti.javaType;
				if (element.isSpaceable)
					javaType = "java.util.Set<" + javaType + ">";
				if (m.cardinality.singular)
				{
					final String caption = element.isSpaceable ? "Set" : "Value";
					p.println();
					p.printf("   public %s get%s%s()\n", javaType, m.className, caption);
					p.printf("   {\n");
					p.printf("      return (%s == null) ? null : %s.value;\n", field, field);
					p.printf("   }\n");
				}
				else
				{
					final String caption = element.isSpaceable ? "Sets" : "Values";
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

		// declare struct finder for keyed, repeatable elements
		for (OnixCompositeMember m : composite.members)
		{
			if (!m.cardinality.singular)
			{
				final OnixStruct struct = ref.unifiedStructs.get(m.className);
				if (struct != null && struct.isKeyed())
				{
					final String structName = "Jonix" + m.className;
					final OnixElementDef keyClass = (OnixElementDef) struct.keyMember.onixClass;
					final TypeInfo kti = GenUtil.typeInfoOf(keyClass.valueMember.simpleType);
					final String keyClassName = struct.keyMember.className;
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
					p.printf("               return x.as%s();\n", structName);
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
					p.printf("               matches.add(x.as%s());\n", structName);
					p.printf("         }\n");
					p.printf("         return matches;\n", structName);
					p.printf("      }\n");
					p.printf("      return null;\n");
					p.printf("   }\n");
				}
			}
		}

		// declare struct provider on composites that can be represented as one
		final OnixStruct struct = ref.unifiedStructs.get(composite.name);
		if (struct != null)
		{
			final String structName = "Jonix" + composite.name;

			p.println();
			p.printf("   public %s as%s()\n", structName, structName);
			p.printf("   {\n");
			p.printf("      %s x = new %s();\n", structName, structName);

			for (OnixCompositeMember member : struct.allMembers())
			{
				String field = GenUtil.fieldOf(member.className);
				String caption = ((OnixElementDef) member.onixClass).isSpaceable ? "Set" : "Value";
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

	private void writeElementClass(OnixElementDef element, PrintStream p)
	{
		p.println(Comments.Copyright);
		p.printf("package %s;\n", packageName);
		p.println();
		p.println("import java.io.Serializable;");
		p.printf("import %s.JPU;\n", GenUtil.COMMON_PACKAGE);
		p.printf("import %s.OnixElement;\n", GenUtil.COMMON_PACKAGE);
		p.printf("import %s.codelist.*;\n", GenUtil.COMMON_PACKAGE);
		p.println();
		p.println(Comments.AutoGen);
		p.printf("@SuppressWarnings(\"serial\")\n");
		p.printf("public class %s implements OnixElement, Serializable\n", element.name);
		p.printf("{\n");

		declareConstsAndAttributes(p, element);

		// declare value
		final TypeInfo ti = GenUtil.typeInfoOf(element.valueMember.simpleType);
		p.println();
		if (!element.isSpaceable)
			p.printf("   public %s value;%s\n", ti.javaType, ti.comment);
		else
			p.printf("   public java.util.Set<%s> value;%s\n", ti.javaType, ti.comment);

		// default-constructor
		p.println();
		p.printf("   public %s()\n", element.name);
		p.printf("   {}\n");

		// constructor
		p.println();
		p.printf("   public %s(org.w3c.dom.Element element)\n", element.name);
		p.printf("   {\n");

		extractAttributes(element, p);

		p.println();
		if (ti.isXHTML)
			p.printf("      value = JPU.getChildXHTML(element, true);\n");
		else if (!element.isSpaceable)
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

	private void writeFlagClass(OnixFlagDef clz, PrintStream p)
	{
		p.println(Comments.Copyright);
		p.printf("package %s;\n", packageName);
		p.println();
		p.println("import java.io.Serializable;");
		p.printf("import %s.JPU;\n", GenUtil.COMMON_PACKAGE);
		p.printf("import %s.OnixFlag;\n", GenUtil.COMMON_PACKAGE);
		p.printf("import %s.codelist.*;\n", GenUtil.COMMON_PACKAGE);
		p.println();
		p.println(Comments.AutoGen);
		p.printf("@SuppressWarnings(\"serial\")\n");
		p.printf("public class %s implements OnixFlag, Serializable\n", clz.name);
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
