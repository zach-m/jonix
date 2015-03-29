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

package com.tectonica.jonix.metadata;

import java.util.ArrayList;
import java.util.List;

public class OnixStruct implements Comparable<OnixStruct>
{
	public final OnixContentClass containingClass;
	public OnixContentClassMember key = null;
	public List<OnixContentClassMember> members = new ArrayList<>();

	public OnixStruct(OnixContentClass containingClass)
	{
		this.containingClass = containingClass;
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("struct " + containingClass.name).append("\n");
		OnixValueClassMember km = ((OnixValueClass) key.onixClass).valueMember;
		sb.append("   [key] - ").append(km.simpleType.enumName).append("\n");
		for (OnixContentClassMember m : members)
		{
			OnixValueClassMember vm = ((OnixValueClass) m.onixClass).valueMember;
			final OnixSimpleType simpleType = vm.simpleType;
			String javaType = (simpleType.enumName != null) ? simpleType.enumName : simpleType.primitiveType.javaType;
			if (!m.cardinality.singular)
				javaType = "List<" + javaType + ">";
			sb.append("         - ").append(javaType).append("\n");
		}
		return sb.toString();
	}

	public OnixSimpleType keyEnumType()
	{
		return ((OnixValueClass) key.onixClass).valueMember.simpleType;
	}

	@Override
	public int compareTo(OnixStruct o)
	{
		return containingClass.name.compareTo(o.containingClass.name);
//		return keyEnumType().enumName.compareTo(o.keyEnumType().enumName);
	}
}