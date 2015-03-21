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

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "contentClasses", "valueClasses", "flagClasses", "types", "enums", "structs" })
public class OnixMetadata
{
	@JsonIgnore
	public Map<String, OnixContentClass> contentClassesMap = new HashMap<>();
	@JsonIgnore
	public Map<String, OnixValueClass> valueClassesMap = new HashMap<>();
	@JsonIgnore
	public Map<String, OnixFlagClass> flagClassesMap = new HashMap<>();
	@JsonIgnore
	public Map<String, OnixSimpleType> typesMap = new HashMap<>();
	@JsonIgnore
	public Map<String, OnixSimpleType> enumsMap = new HashMap<>();
	@JsonIgnore
	public Map<String, OnixValueStruct> structsMap = new HashMap<>();

	public Collection<OnixContentClass> getContentClasses()
	{
		return contentClassesMap.values();
	}

	public Collection<OnixValueClass> getValueClasses()
	{
		return valueClassesMap.values();
	}

	public Collection<OnixFlagClass> getFlagClasses()
	{
		return flagClassesMap.values();
	}

	public Collection<OnixSimpleType> getTypes()
	{
		return typesMap.values();
	}

	public Collection<OnixSimpleType> getEnums()
	{
		return enumsMap.values();
	}

	public Collection<OnixValueStruct> getStructs()
	{
		return structsMap.values();
	}

	public OnixSimpleType typeByName(String name)
	{
		OnixSimpleType type = typesMap.get(name);
		if (type == null)
			type = enumsMap.get(name);
		return type;
	}

	public OnixClass classByName(String name)
	{
		OnixClass onixClass = contentClassesMap.get(name);
		if (onixClass == null)
		{
			onixClass = valueClassesMap.get(name);
			if (onixClass == null)
				onixClass = flagClassesMap.get(name);
		}
		return onixClass;
	}

	public OnixValueClass valueClassByName(String name)
	{
		return valueClassesMap.get(name);
	}
}
