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

package com.tectonica.jonix.codegen.metadata;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public enum Primitive
{
	String("String", "xs:string", "xs:token", "xs:NMTOKEN"), //
	AnyURI("String", "xs:anyURI"), //
	Int("Integer", "xs:int"), //
	Decimal("Double", "xs:decimal");

	public final String javaType;
	public final Set<String> xsdTokens;

	private Primitive(String javaType, String... xsdTokens)
	{
		this.javaType = javaType;
		this.xsdTokens = new HashSet<String>(Arrays.asList(xsdTokens));
	}

	public static Primitive fromXsdToken(String xsdToken)
	{
		for (Primitive primitive : values())
			if (primitive.xsdTokens.contains(xsdToken))
				return primitive;
		return null;
	}
}