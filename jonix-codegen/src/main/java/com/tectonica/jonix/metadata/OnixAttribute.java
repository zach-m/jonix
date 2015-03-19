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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "name", "type", "onixType", "enumName" })
public class OnixAttribute implements Comparable<OnixAttribute>
{
	public String name;
	@JsonProperty("type")
	public Primitive dataType;
	@JsonProperty("onixType")
	public String onixSimpleTypeName;
	public String enumName;

	private OnixAttribute()
	{}

	public static OnixAttribute create(String name, Primitive dataType, String onixSimpleTypeName, String enumName)
	{
		OnixAttribute ova = new OnixAttribute();
		ova.name = name;
		ova.dataType = dataType;
		ova.onixSimpleTypeName = onixSimpleTypeName;
		ova.enumName = enumName;
		return ova;
	}

	@Override
	public String toString()
	{
		return name + "(" + dataType.name() + " / " + onixSimpleTypeName + " / " + enumName + ")";
	}

	@Override
	public int compareTo(OnixAttribute o)
	{
		return name.compareTo(o.name);
	}
}