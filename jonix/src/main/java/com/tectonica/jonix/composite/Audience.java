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

package com.tectonica.jonix.composite;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.tectonica.jonix.codelist.AudienceCodeTypes;
import com.tectonica.jonix.codelist.Audiences;

@SuppressWarnings("serial")
public class Audience implements Serializable
{
	public final AudienceCodeTypes audienceCodeType;
	public final String audienceCodeTypeName;
	public final String audienceCodeValue;

	public Audience(AudienceCodeTypes audienceCodeType, String audienceCodeTypeName, String audienceCodeValue)
	{
		this.audienceCodeType = audienceCodeType;
		this.audienceCodeTypeName = audienceCodeTypeName;
		this.audienceCodeValue = audienceCodeValue;
	}

	@Override
	public String toString()
	{
		String audienceCodeTypeStr = (audienceCodeType == null) ? null : audienceCodeType.name();
		String audienceCodeValueStr = (audienceCodeType == AudienceCodeTypes.ONIX_audience_codes) ? Audiences.byValue(audienceCodeValue)
				.name() : audienceCodeValue;
		return String.format("Audience [%s/%s]: %s", audienceCodeTypeStr, audienceCodeTypeName, audienceCodeValueStr);
	}

	public static List<Audience> listFrom(com.tectonica.jonix.onix2.Product product)
	{
		if (product.audiences != null)
		{
			List<Audience> result = new ArrayList<>();
			for (com.tectonica.jonix.onix2.Audience i : product.audiences)
				result.add(new Audience(i.getAudienceCodeTypeValue(), i.getAudienceCodeTypeNameValue(), i.getAudienceCodeValueValue()));
			return result;
		}
		return Collections.emptyList();
	}
}