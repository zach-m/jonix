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

import com.tectonica.jonix.metadata.OnixAttribute;
import com.tectonica.jonix.metadata.OnixCompositeMember;
import com.tectonica.jonix.metadata.OnixSimpleType;

public class GenUtil
{
	public static final String COMMON_PACKAGE = "com.tectonica.jonix";

	public static class TypeInfo
	{
		String javaType;
		String comment;
		boolean isPrimitive;
		boolean isXHTML;
	}

	public static TypeInfo typeInfoOf(OnixSimpleType simpleType)
	{
		return typeInfoOf(simpleType.name, simpleType.primitiveType.javaType, simpleType.enumName);
	}

	public static TypeInfo typeInfoOf(OnixAttribute attt)
	{
		return typeInfoOf(attt.getSimpleTypeName(), attt.primitiveType.javaType, attt.getEnumName());
	}

	public static TypeInfo typeInfoOf(String onixSimpleTypeName, String javaType, String enumName)
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

	public static class FieldInfo
	{
		String name;
		String type;
		String comment;
	}

	public static FieldInfo fieldInfoOf(OnixCompositeMember member)
	{
		FieldInfo result = new FieldInfo();
		result.name = fieldOf(member.className);
		result.type = member.className;
		result.comment = member.cardinality.name();
		if (!member.cardinality.singular)
		{
			result.name = String.format("%ss", result.name);
			result.type = String.format("List<%s>", result.type);
		}
		return result;
	}

	public static String fieldOf(String propertyName)
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
		System.out.println(fieldOf("text"));
		System.out.println(fieldOf("TextFormat"));
		System.out.println(fieldOf("ISBN"));
		System.out.println(fieldOf("IDTypeName"));
	}
}
