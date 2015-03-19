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
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "contentClasses", "valueClasses", "flagClasses", "types", "enums" })
public class OnixMetadata
{
	public List<OnixContentClass> contentClasses = new ArrayList<>();
	public List<OnixValueClass> valueClasses = new ArrayList<>();
	public List<OnixFlagClass> flagClasses = new ArrayList<>();
	public List<OnixSimpleType> types = new ArrayList<>();
	public List<OnixSimpleType> enums = new ArrayList<>();

//	private Map<String, OnixSimpleType> typesMap;
//
//	private Map<String, OnixSimpleType> typesMap()
//	{
//		if (typesMap == null)
//		{
//			typesMap = new HashMap<>();
//			for (OnixSimpleType ost : types)
//				typesMap.put(ost.name, ost);
//			for (OnixSimpleType ost : enums)
//				typesMap.put(ost.name, ost);
//		}
//		return typesMap;
//	}
//
//	public OnixSimpleType typeByName(String value)
//	{
//		return typesMap().get(value);
//	}

	public void sort()
	{
		Collections.sort(contentClasses);
		Collections.sort(valueClasses);
		Collections.sort(flagClasses);
		Collections.sort(types);
		Collections.sort(enums);
		for (OnixContentClass occ : contentClasses)
			occ.sortInternally();
		for (OnixValueClass ovc : valueClasses)
			ovc.sortInternally();
		for (OnixFlagClass ovc : flagClasses)
			ovc.sortInternally();
	}
}
