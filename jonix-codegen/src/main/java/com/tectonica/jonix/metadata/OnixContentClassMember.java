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

@JsonPropertyOrder({ "onixType", "cardinality" })
public class OnixContentClassMember implements Comparable<OnixContentClassMember>
{
	@JsonProperty("onixType")
	public String onixTypeName;
	@JsonProperty("cardinality")
	public Multiplicity multiplicity;

	@Override
	public int compareTo(OnixContentClassMember o)
	{
		return onixTypeName.compareTo(o.onixTypeName);
	}

	@Override
	public String toString()
	{
		return onixTypeName + " [" + multiplicity + "]";
	}

	public static OnixContentClassMember create(String onixTypeName, Multiplicity multiplicity)
	{
		OnixContentClassMember ocm = new OnixContentClassMember();
		ocm.onixTypeName = onixTypeName;
		ocm.multiplicity = multiplicity;
		return ocm;
	}
}