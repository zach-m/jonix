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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.tectonica.jonix.codegen.generator.Parser.OnixVersion;

@JsonPropertyOrder({ "dataMember" })
public class OnixStructMember implements Comparable<OnixStructMember>
{
	/**
	 * either an Element-member or a Flag-member
	 */
	public OnixCompositeMember dataMember;

	public static enum TransformationType
	{
		SingularToMultiple, ChangeClassName, //
		StringToInteger, StringToDouble;
	}

	@JsonIgnore
	public OnixVersion transformationNeededInVersion;
	@JsonIgnore
	public TransformationType transformationType;
	@JsonIgnore
	public String transformationHint;

	public OnixStructMember(OnixCompositeMember dataMember)
	{
		if (dataMember == null)
			throw new NullPointerException("dataMember");

		final boolean isDataMember = (dataMember.onixClass instanceof OnixElementDef)
				|| (dataMember.onixClass instanceof OnixFlagDef);
		if (!isDataMember)
			throw new RuntimeException("passed member is neither an Element nor a Flag");

		this.dataMember = dataMember;
	}

	@Override
	public int compareTo(OnixStructMember other)
	{
		return dataMember.compareTo(other.dataMember);
	}

	@Override
	public String toString()
	{
		return dataMember.toString();
	}
}