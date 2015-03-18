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

@JsonPropertyOrder({ "type", "onixType" })
public class OnixValueClassMember implements Comparable<OnixValueClassMember>
{
	@JsonProperty("type")
	public Primitive dataType;
	@JsonProperty("onixType")
	public String onixSimpleTypeName;

	@Override
	public int compareTo(OnixValueClassMember o)
	{
		return onixSimpleTypeName.compareTo(o.onixSimpleTypeName);
	}

	@Override
	public String toString()
	{
		return dataType + " (" + onixSimpleTypeName + ")";
	}

	public static OnixValueClassMember create(OnixSimpleType simpleType)
	{
		OnixValueClassMember ovcm = new OnixValueClassMember();
		ovcm.dataType = simpleType.dataType;
		ovcm.onixSimpleTypeName = simpleType.name;
		return ovcm;
	}
}
