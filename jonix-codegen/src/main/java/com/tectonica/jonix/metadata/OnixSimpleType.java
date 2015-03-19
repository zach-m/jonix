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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "name", "type", "comment", "aliasFor", "enumName", "enumValues" })
public class OnixSimpleType implements Comparable<OnixSimpleType>
{
	public static final OnixSimpleType XHTML = OnixSimpleType.create("XHTML", Primitive.String, "Free XHTML content", null);

	public String name;
	@JsonProperty("type")
	public Primitive dataType;
	public String comment;
	public String aliasFor;
	public String enumName;
	public List<OnixEnumValue> enumValues;

	public static OnixSimpleType create(String name, Primitive dataType, String comment, List<OnixEnumValue> enumValues)
	{
		OnixSimpleType ost = new OnixSimpleType();
		ost.name = name;
		ost.dataType = dataType;
		ost.comment = comment;
		ost.enumValues = enumValues;
		return ost;
	}

	public void aliasFrom(OnixSimpleType other)
	{
		dataType = other.dataType;
		comment = other.comment;
		aliasFor = other.name;
		enumName = other.enumName;
		enumValues = other.enumValues;
	}

	public static OnixSimpleType cloneFrom(OnixSimpleType other)
	{
		OnixSimpleType ost = new OnixSimpleType();
		ost.name = other.name;
		ost.dataType = other.dataType;
		ost.comment = other.comment;
		ost.aliasFor = other.aliasFor;
		ost.enumName = other.enumName;
		ost.enumValues = new ArrayList<OnixEnumValue>(other.enumValues); //  new array, same items
		return ost;
	}

	public void add(OnixEnumValue onixEnumValue)
	{
		if (enumValues == null)
			enumValues = new ArrayList<>();
		enumValues.add(onixEnumValue);
	}

	@Override
	public String toString()
	{
		return name + " (" + dataType + ") = '" + comment + "', values=" + enumValues + "'";
	}

	@Override
	public int compareTo(OnixSimpleType o)
	{
		if (this.enumName != null && o.enumName != null)
			return enumName.compareTo(o.enumName);
		return name.compareTo(o.name);
	}
}