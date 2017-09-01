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

import com.tectonica.jonix.codegen.generator.GenUtil.FieldInfo;
import com.tectonica.jonix.codegen.generator.GenUtil.TypeInfo;
import com.tectonica.jonix.codegen.metadata.OnixAttribute;
import com.tectonica.jonix.codegen.metadata.OnixClass;
import com.tectonica.jonix.codegen.metadata.OnixCompositeDef;
import com.tectonica.jonix.codegen.metadata.OnixCompositeMember;
import com.tectonica.jonix.codegen.metadata.OnixConst;
import com.tectonica.jonix.codegen.metadata.OnixDoc;
import com.tectonica.jonix.codegen.metadata.OnixElementDef;
import com.tectonica.jonix.codegen.metadata.OnixFlagDef;
import com.tectonica.jonix.codegen.metadata.OnixMetadata;
import com.tectonica.jonix.codegen.metadata.OnixStruct;
import com.tectonica.jonix.codegen.metadata.OnixStructMember;

public class OnixClassGen
{
	private static final String EQUALS = "equals"; // turn to "equalsIgnoreCase" to assume case-insensitive XML

	private final String packageName;
	private final File folder;

	private final OnixMetadata ref;

	public OnixClassGen(String basePackage, String baseFolder, String subfolder, OnixMetadata ref)
	{
		this.ref = ref;
		packageName = basePackage + "." + subfolder;
		folder = new File(baseFolder, subfolder);
		GenUtil.prepareOutputFolder(folder);
	}

	public void generate(OnixClass onixClass)
	{
		try
		{
			File javaFile = new File(folder, onixClass.name + ".java");

			try (PrintStream p = new PrintStream(javaFile, "UTF-8"))
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
		final String markerInterfaceName;

		final boolean isDataComposite = ref.jonixStructs.containsKey(composite.name);
		final OnixStruct struct = ref.unifiedStructs.get(composite.name);
		if (isDataComposite)
		{
			if (struct == null)
			{
				markerInterfaceName = "OnixDataCompositeUncommon";
			}
			else
			{
				final String structName = "Jonix" + composite.name;

				if (struct.isKeyed())
				{
					OnixCompositeMember keyMember = struct.keyMember.dataMember;
					OnixElementDef keyClass = (OnixElementDef) keyMember.onixClass;
					TypeInfo keyTypeInfo = GenUtil.typeInfoOf(keyClass.valueMember.simpleType);
					markerInterfaceName = String.format("OnixDataCompositeWithKey<%s,%s>", structName,
							keyTypeInfo.javaType);
				}
				else
				{
					markerInterfaceName = String.format("OnixDataComposite<%s>", structName);
				}
			}
		}
		else
		{
			markerInterfaceName = "OnixSuperComposite";
		}

		p.println(Comments.Copyright);
		p.printf("package %s;\n", packageName);
		p.println();
		p.println("import java.io.Serializable;");
		p.println("import java.util.List;");
		p.println("import java.util.ArrayList;");
		p.println("import java.util.Arrays;");
		p.println("import java.util.Collections;");
		p.println();
		p.printf("import %s.*;\n", GenUtil.COMMON_PACKAGE);
		p.printf("import %s.OnixComposite.*;\n", GenUtil.COMMON_PACKAGE);
		p.printf("import %s.codelist.*;\n", GenUtil.COMMON_PACKAGE);
		p.printf("import %s.struct.*;\n", GenUtil.COMMON_PACKAGE);
		p.println();
		p.println(Comments.AutoGen);

		printOnixDoc(p, composite.onixDoc);
		p.printf("public class %s implements %s, Serializable\n", composite.name, markerInterfaceName);
		p.printf("{\n");

		declareConstsAndAttributes(p, composite);

		/////////////////////////////////////////////////////////////////////////////////
		// CONSTRUCTION
		/////////////////////////////////////////////////////////////////////////////////

		p.println();
		printCaptionComment(p, "CONSTRUCTION");

		p.println();
		p.printf("   private boolean initialized;\n");
		p.printf("   private final boolean exists;\n");
		p.printf("   private final org.w3c.dom.Element element;\n");
		p.printf("   public static final %s EMPTY = new %s();\n", composite.name, composite.name);

		// default-constructor
		p.println();
		p.printf("   public %s()\n", composite.name);
		p.printf("   {\n");
		p.printf("      exists = false;\n");
		p.printf("      element = null;\n");
		p.printf("      initialized = true; "
				+ "// so that no further processing will be done on this intentionally-empty object\n");
		p.printf("   }\n");

		// constructor
		p.println();
		p.printf("   public %s(org.w3c.dom.Element element)\n", composite.name);
		p.printf("   {\n");
		p.printf("      exists = true;\n");
		p.printf("      initialized = false;\n");
		p.printf("      this.element = element;\n");
		p.printf("   }\n");

		p.println();
		p.printf("   private void initialize()\n", composite.name);
		p.printf("   {\n");
		p.printf("      if (initialized) return;\n");
		p.printf("      initialized = true;\n");

		p.println();
		setInitializers(composite, p);

		p.println();
		p.printf("      JPU.forElementsOf(element, e -> {\n");
		p.printf("         final String name = e.getNodeName();\n");
		boolean first = true;
		for (OnixCompositeMember m : composite.members)
		{
			final String className = m.className;
			String field = GenUtil.fieldOf(className);
			if (!m.cardinality.singular)
				field += "s";
			p.print("         ");
			if (first)
				first = false;
			else
				p.print("else ");
			p.printf("if (name.%s(%s.refname) || name.%s(%s.shortname))\n", EQUALS, className, EQUALS, className);
			if (m.cardinality.singular)
				p.printf("            %s = new %s(e);\n", field, className);
			else
				p.printf("            %s = JPU.addToList(%s, new %s(e));\n", field, field, className);
		}
		p.printf("      });\n");

		p.printf("   }\n");

		p.println();
		p.printf("   @Override\n");
		p.printf("   public boolean exists()\n");
		p.printf("   {\n");
		p.printf("      return exists;\n");
		p.printf("   }\n");

		/////////////////////////////////////////////////////////////////////////////////
		// MEMBERS
		/////////////////////////////////////////////////////////////////////////////////

		p.println();
		printCaptionComment(p, "MEMBERS");

		for (OnixCompositeMember member : composite.members)
		{
			final FieldInfo fi = GenUtil.fieldInfoOf(member, ref);

			// declare member in a private field
			p.println();
			p.printf("   private %s %s = %s;\n", fi.type, fi.name, fi.emptyPhrase);

			// declare public accessor to the member
			p.println();
			p.printf("   /**\n");
			p.printf("    * %s\n", fi.comment);
			p.printf("    */\n");
			p.printf("   public %s %s()\n", fi.type, fi.name);
			p.printf("   {\n");
			p.printf("      initialize();\n");
			p.printf("      return %s;\n", fi.name);
			p.printf("   }\n");

			// declare direct boolean getter for flag-members
			final OnixFlagDef flag = ref.onixFlags.get(member.className);
			if (flag != null)
			{
				if (!member.cardinality.singular)
				{
					// TODO: this is not the right place to make this validation. move to parsing.
					throw new RuntimeException("can't handle multiple flags");
				}

				p.println();
				p.printf("   public boolean is%s()\n", member.className);
				p.printf("   {\n");
				p.printf("      return (%s().exists());\n", fi.name);
				p.printf("   }\n");
			}

			// declare struct finder for keyed, repeatable elements
//			if (!member.cardinality.singular)
//			{
//				final OnixStruct struct = ref.unifiedStructs.get(member.className);
//				if (struct != null && struct.isKeyed())
//				{
//					// keyed struct means that it has a mandatory key field which is of enum type
//					final String structName = "Jonix" + member.className;
//					final OnixCompositeMember keyMember = struct.keyMember.dataMember;
//					final OnixElementDef keyClass = (OnixElementDef) keyMember.onixClass;
//					final TypeInfo kti = GenUtil.typeInfoOf(keyClass.valueMember.simpleType);
//					String keyClassName = keyMember.className;
//					if (struct.keyMember.transformationNeededInVersion == ref.onixVersion
//							&& struct.keyMember.transformationType == TransformationType.ChangeClassName)
//					{
//						// we need to adapt the field name to the one of the struct (which based on another onix
//						// version)
//						// an (only) example is currently: MeasureType (onix2) --> MeasureTypeCode (onix3)
//						keyClassName = struct.keyMember.transformationHint;
//					}
//					final String keyField = GenUtil.fieldOf(keyClassName);
//					final String memberfield = GenUtil.fieldOf(member.className);
//
//					p.println();
//					p.printf("   public %s %sStructOf(%s key)\n", structName, memberfield, kti.javaType);
//					p.printf("   {\n");
//					p.printf("      for (%s item : %ss())\n", member.className, memberfield);
//					p.printf("      {\n");
//					p.printf("         if (item.%s().value == key)\n", keyField);
//					p.printf("            return item.struct();\n");
//					p.printf("      }\n");
//					p.printf("      return %s.EMPTY;\n", structName);
//					p.printf("   }\n");
//
//					p.println();
//					p.printf("   public List<%s> %sStructs()\n", structName, memberfield, kti.javaType);
//					p.printf("   {\n");
//					p.printf("      return %sStructsOf(null);\n", memberfield);
//					p.printf("   }\n");
//
//					p.println();
//					p.printf("   public List<%s> %sStructsOf(java.util.Set<%s> keys)\n", structName, memberfield,
//							kti.javaType);
//					p.printf("   {\n");
//					p.printf("      List<%s> matches = new ArrayList<>();\n", structName);
//					p.printf("      for (%s item : %ss())\n", member.className, memberfield);
//					p.printf("      {\n");
//					p.printf("         if (keys == null || keys.contains(item.%s().value))\n", keyField);
//					p.printf("            matches.add(item.struct());\n");
//					p.printf("      }\n");
//					p.printf("      return matches;\n");
//					p.printf("   }\n");
//				}
//			}
		}

		// declare struct provider on composites that can be represented as one
		if (struct != null)
		{
			final String structName = "Jonix" + composite.name;

			p.println();
			p.printf("   @Override\n");
			p.printf("   public %s asStruct()\n", structName);
			p.printf("   {\n");
			p.printf("      initialize();\n", structName, structName);
			p.printf("      %s struct = new %s();\n", structName, structName);

			for (OnixStructMember structMember : struct.allMembers())
			{
				final OnixCompositeMember member = structMember.dataMember;
				if (member.onixClass instanceof OnixElementDef)
				{
					String targetField = GenUtil.fieldOf(member.className);
					String field = targetField;
					if (!member.cardinality.singular)
						field += "s";
					boolean transformationNeeded = (structMember.transformationNeededInVersion == ref.onixVersion);
					if (transformationNeeded)
					{
						switch (structMember.transformationType)
						{
						case SingularToMultiple:
							p.printf("      struct.%s = Arrays.asList(%s.value);\n", field, targetField);
							break;
						case ChangeClassName:
							p.printf("      struct.%s = %s.value;\n", field,
									GenUtil.fieldOf(structMember.transformationHint));
							break;
						default:
							p.printf("      struct.%s = JPU.convert%s(%s.value);\n", field,
									structMember.transformationType.name(), field);
						}
					}
					else
					{
						String caption = (member.cardinality.singular) ? "value" : "values()";
						p.printf("      struct.%s = %s.%s;\n", field, field, caption);
					}
				}
				else
				// i.e. (member.onixClass instanceof OnixFlagDef)
				{
					p.printf("      struct.is%s = is%s();\n", member.className, member.className);
				}
			}

			p.printf("      return struct;\n");
			p.printf("   }\n");

			if (struct.isKeyed())
			{
				OnixCompositeMember keyMember = struct.keyMember.dataMember;
				OnixElementDef keyClass = (OnixElementDef) keyMember.onixClass;
				TypeInfo keyTypeInfo = GenUtil.typeInfoOf(keyClass.valueMember.simpleType);
				String field = GenUtil.fieldOf(keyMember.className);
				boolean transformationNeeded = (struct.keyMember.transformationNeededInVersion == ref.onixVersion);
				if (transformationNeeded)
				{
					switch (struct.keyMember.transformationType)
					{
					case ChangeClassName:
						field = GenUtil.fieldOf(struct.keyMember.transformationHint);
						break;
					default:
						throw new UnsupportedOperationException("Still not handling key-transofmration other than ChangeClassName");
					}
				}
				p.println();
				p.printf("   @Override\n");
				p.printf("   public %s structKey()\n", keyTypeInfo.javaType);
				p.printf("   {\n");
				p.printf("      return %s().value;\n", field);
				p.printf("   }\n");
			}
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

		// analyze the main value of the element
		final TypeInfo ti = GenUtil.typeInfoOf(element.valueMember.simpleType);
		String valueType = element.isSpaceable ? String.format("java.util.Set<%s>", ti.javaType) : ti.javaType;

		printOnixDoc(p, element.onixDoc);
		p.printf("public class %s implements OnixElement<%s>, Serializable\n", element.name, valueType);
		p.printf("{\n");

		declareConstsAndAttributes(p, element);

		p.println();
		printCaptionComment(p, "VALUE MEMBER");

		// declare value
		p.println();
		if (ti.comment != null)
		{
			p.printf("   /**\n");
			if (element.onixDoc != null && element.onixDoc.format != null && !element.onixDoc.format.isEmpty())
				p.printf("   * Raw Format: %s<p>\n", element.onixDoc.format);
			p.printf("   * %s\n", ti.comment);
			p.printf("   */\n");
		}
		p.printf("   public %s value;\n", valueType);

		// declare internal accessor to value
		p.println();
		p.printf("   /**\n");
		p.printf("   * Internal API, use the {@link #value} field instead\n");
		p.printf("   */\n");
		p.printf("   @Override\n", valueType);
		p.printf("   public %s _value()\n", valueType);
		p.printf("   {\n", valueType);
		p.printf("      return value;\n", valueType);
		p.printf("   }\n", valueType);

		p.println();
		printCaptionComment(p, "SERVICES");

		p.println();
		p.printf("   private final boolean exists;\n");
		p.printf("   public static final %s EMPTY = new %s();\n", element.name, element.name);

		// default-constructor
		p.println();
		p.printf("   public %s()\n", element.name);
		p.printf("   {\n");
		p.printf("      exists = false;\n");
		p.printf("   }\n");

		// constructor
		p.println();
		p.printf("   public %s(org.w3c.dom.Element element)\n", element.name);
		p.printf("   {\n");
		p.printf("      exists = true;\n");

		setInitializers(element, p);

		p.println();
		if (ti.isXHTML)
			p.printf("      value = JPU.getChildXHTML(element, true);\n");
		else if (!element.isSpaceable)
		{
			if (ti.isPrimitive)
				p.printf("      value = JPU.getContentAs%s(element);\n", ti.javaType);
			else
				p.printf("      value = %s.byCode(JPU.getContentAsString(element));\n", ti.javaType);
		}
		else
		{
			p.printf("      value = new java.util.HashSet<>();\n");
			p.printf("      for (String split : JPU.getContentAsString(element).trim().split(\" +\"))\n");
			if (ti.isPrimitive)
				p.printf("         value.add(%s.valueOf(split));\n", ti.javaType);
			else
				p.printf("         value.add(%s.byCode(split));\n", ti.javaType);
		}

		p.printf("   }\n");

		p.println();
		p.printf("   @Override\n");
		p.printf("   public boolean exists()\n");
		p.printf("   {\n");
		p.printf("      return exists;\n");
		p.printf("   }\n");
		
		p.println("}");
	}

	private void writeFlagClass(OnixFlagDef flag, PrintStream p)
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

		printOnixDoc(p, flag.onixDoc);
		p.printf("public class %s implements OnixFlag, Serializable\n", flag.name);
		p.printf("{\n");

		declareConstsAndAttributes(p, flag);

		p.println();
		printCaptionComment(p, "CONSTRUCTORS");

		p.println();
		p.printf("   private final boolean exists;\n");
		p.printf("   public static final %s EMPTY = new %s();\n", flag.name, flag.name);

		// default-constructor
		p.println();
		p.printf("   public %s()\n", flag.name);
		p.printf("   {\n");
		p.printf("      exists = false;\n");
		p.printf("   }\n");

		// constructor
		p.println();
		p.printf("   public %s(org.w3c.dom.Element element)\n", flag.name);
		p.printf("   {\n");
		p.printf("      exists = true;\n");

		setInitializers(flag, p);

		p.printf("   }\n");

		p.println();
		p.printf("   @Override\n");
		p.printf("   public boolean exists()\n");
		p.printf("   {\n");
		p.printf("      return exists;\n");
		p.printf("   }\n");

		p.println("}");
	}

	private void printOnixDoc(PrintStream p, OnixDoc onixDoc)
	{
		if (onixDoc != null)
		{
			p.printf("/**\n");
			p.printf(" * %s\n", onixDoc.toHtml());
			p.printf(" */\n");
		}
	}

	private void declareConstsAndAttributes(PrintStream p, OnixClass clz)
	{
		p.printf("   private static final long serialVersionUID = 1L;\n\n");

		for (OnixConst c : clz.consts)
			p.printf("   public static final String %s = \"%s\";\n", c.name, c.value);

		p.println();
		printCaptionComment(p, "ATTRIBUTES");
		for (OnixAttribute a : clz.attributes)
		{
			final TypeInfo ti = GenUtil.typeInfoOf(a);
			p.println();
			if (ti.comment != null)
			{
				p.printf("   /**\n");
				p.printf("    * %s\n", ti.comment);
				p.printf("    */\n");
			}
			p.printf("   public %s %s;\n", ti.javaType, a.name);
		}
	}

	private void setInitializers(OnixClass clz, PrintStream p)
	{
		for (OnixAttribute a : clz.attributes)
		{
			String enumName = a.getEnumName();

			if (enumName == null)
			{
				// EXAMPLE: datestamp = JPU.getAttribute(element, "datestamp");
				p.printf("      %s = JPU.getAttribute(element, \"%s\");\n", a.name, a.name);
			}
			else
			{
				// EXAMPLE: textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));
				p.printf("      %s = %s.byCode(JPU.getAttribute(element, \"%s\"));\n", a.name, enumName, a.name);
			}
		}
	}

	private void printCaptionComment(PrintStream p, String caption)
	{
		p.println("   /////////////////////////////////////////////////////////////////////////////////");
		p.println("   // " + caption);
		p.println("   /////////////////////////////////////////////////////////////////////////////////");
	}
}
