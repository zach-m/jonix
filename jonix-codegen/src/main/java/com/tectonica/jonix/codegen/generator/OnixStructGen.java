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

import com.tectonica.jonix.codegen.generator.GenUtil.TypeInfo;
import com.tectonica.jonix.codegen.metadata.OnixCompositeMember;
import com.tectonica.jonix.codegen.metadata.OnixElementDef;
import com.tectonica.jonix.codegen.metadata.OnixStruct;
import com.tectonica.jonix.codegen.metadata.OnixStructMember;

public class OnixStructGen
{
	private static final String COMMON_PACKAGE = "com.tectonica.jonix";

	private final String packageName;
	private final String folderName;

	public OnixStructGen(String basePackage, String baseFolder, String subfolder)
	{
		packageName = basePackage + "." + subfolder;
		folderName = baseFolder + "/" + subfolder;
		new File(folderName).mkdirs();
	}

	public void generate(OnixStruct struct)
	{
		try
		{
			final String structName = "Jonix" + struct.containingComposite.name;
			String fileName = folderName + "/" + structName + ".java";

			try (PrintStream p = new PrintStream(fileName, "UTF-8"))
			{
				writeStruct(struct, structName, p);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	private void writeStruct(OnixStruct struct, String structName, PrintStream p)
	{
		p.println(Comments.Copyright);
		p.printf("package %s;\n", packageName);
		p.println();
		p.println("import java.io.Serializable;");
		p.println("import java.util.List;");
		p.println();
		p.printf("import %s.codelist.*;\n", COMMON_PACKAGE);
		p.println();
		p.println(Comments.AutoGen);
		p.printf("@SuppressWarnings(\"serial\")\n");
		p.printf("public class %s implements Serializable\n", structName);
		p.printf("{\n");

		// declare key
		if (struct.isKeyed())
		{
			final OnixCompositeMember keyMember = struct.keyMember.dataMember;
			final OnixElementDef keyClass = (OnixElementDef) keyMember.onixClass;
			final TypeInfo keyTypeInfo = GenUtil.typeInfoOf(keyClass.valueMember.simpleType);
			final String keyField = GenUtil.fieldOf(keyMember.className);
			p.printf("   /**\n");
			p.printf("    * The key of this struct\n");
			if (keyTypeInfo.comment != null)
				p.printf("    * <p>%s\n", keyTypeInfo.comment);
			p.printf("    */\n");
			p.printf("   public %s %s;\n", keyTypeInfo.javaType, keyField);
			p.println();
		}

		// declare members
		boolean firstField = true;
		for (OnixStructMember structMember : struct.members)
		{
			final OnixCompositeMember member = structMember.dataMember;
			final String field;
			String javaType;
			final String comment;
			if (member.onixClass instanceof OnixElementDef)
			{
				final OnixElementDef memberClass = (OnixElementDef) member.onixClass;
				final TypeInfo ti = GenUtil.typeInfoOf(memberClass.valueMember.simpleType);
				field = GenUtil.fieldOf(member.className);
				javaType = ti.javaType;
				if (memberClass.isSpaceable)
					javaType = "java.util.Set<" + javaType + ">";
				comment = ti.comment;
			}
			else
			// i.e. (member.onixClass instanceof OnixFlagDef)
			{
				field = "is" + member.className;
				javaType = "boolean";
				comment = "(optional flag)";
			}

			if (!firstField)
				p.println();
			else
				firstField = false;
			if (comment != null)
			{
				p.printf("   /**\n");
				p.printf("    * %s\n", comment);
				p.printf("    */\n");
			}
			if (member.cardinality.singular)
				p.printf("   public %s %s;\n", javaType, field);
			else
				p.printf("   public List<%s> %ss;\n", javaType, field);
		}

		// default-constructor
//		p.println();
//		p.printf("   public %s()\n", structName);
//		p.printf("   {}\n");

		p.println("}");
	}
}
