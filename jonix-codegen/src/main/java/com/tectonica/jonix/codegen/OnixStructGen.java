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
import com.tectonica.jonix.metadata.OnixContentClassMember;
import com.tectonica.jonix.metadata.OnixValueClass;
import com.tectonica.jonix.metadata.OnixValueStruct;

public class OnixStructGen
{
	private static final String COMMON_PACKAGE = "com.tectonica.jonix";

	private final String packageName;
	private final String folderName;

	public OnixStructGen(String basePackage, String baseFolder, String subfolder)
	{
		packageName = basePackage + "." + subfolder;
		folderName = baseFolder + "\\" + subfolder;
		new File(folderName).mkdirs();
	}

	public void generate(OnixValueStruct struct)
	{
		try
		{
			final String structName = "Jonix" + struct.containingClass.name;
			String fileName = folderName + "\\" + structName + ".java";

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

	private void writeStruct(OnixValueStruct struct, String structName, PrintStream p)
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
		final OnixValueClass keyClass = (OnixValueClass) struct.key.onixClass;
		final TypeInfo keyTypeInfo = GenUtil.typeInfoOf(keyClass.valueMember.simpleType);
		final String keyField = GenUtil.fieldOf(struct.key.className);
		p.printf("   public %s %s;%s\n", keyTypeInfo.javaType, keyField, keyTypeInfo.comment);

		// declare members
		p.println();
		for (OnixContentClassMember member : struct.members)
		{
			final OnixValueClass memberClass = (OnixValueClass) member.onixClass;
			final TypeInfo ti = GenUtil.typeInfoOf(memberClass.valueMember.simpleType);
			final String field = GenUtil.fieldOf(member.className);
			String javaType = ti.javaType;
			if (memberClass.isSpaceable)
				javaType = "java.util.Set<" + javaType + ">";
			if (member.cardinality.singular)
				p.printf("   public %s %s;%s\n", javaType, field, ti.comment);
			else
				p.printf("   public List<%s> %ss;%s\n", javaType, field, ti.comment);
		}

		// default-constructor
		p.println();
		p.printf("   public %s()\n", structName);
		p.printf("   {}\n");

		p.println("}");
	}
}
