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

import com.tectonica.jonix.codelist.SeriesIdentifierTypes;

@SuppressWarnings("serial")
public class SeriesIdentifier implements Serializable
{
	public final SeriesIdentifierTypes seriesIDType;
	public final String idTypeName;
	public final String idValue;

	public SeriesIdentifier(SeriesIdentifierTypes seriesIDType, String idTypeName, String idValue)
	{
		this.seriesIDType = seriesIDType;
		this.idTypeName = idTypeName;
		this.idValue = idValue;
	}

	@Override
	public String toString()
	{
		return String.format("SeriesIdentifier [%s/%s]: %s", (seriesIDType == null) ? null : seriesIDType.name(), idTypeName, idValue);
	}

	public static List<SeriesIdentifier> listFrom(com.tectonica.jonix.onix2.Series series)
	{
		if (series.seriesIdentifiers != null)
		{
			List<SeriesIdentifier> result = new ArrayList<>();
			for (com.tectonica.jonix.onix2.SeriesIdentifier i : series.seriesIdentifiers)
				result.add(new SeriesIdentifier(i.getSeriesIDTypeValue(), i.getIDTypeNameValue(), i.getIDValueValue()));
			return result;
		}
		return Collections.emptyList();
	}
}