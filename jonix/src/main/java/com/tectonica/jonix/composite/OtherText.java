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

import com.tectonica.jonix.codelist.OtherTextTypes;
import com.tectonica.jonix.codelist.TextFormats;

@SuppressWarnings("serial")
public class OtherText implements Serializable
{
	public final OtherTextTypes textType;
	public final TextFormats textFormat;
	public final String text;

	public OtherText(OtherTextTypes textType, TextFormats textFormat, String text)
	{
		this.textType = textType;
		this.textFormat = textFormat;
		this.text = text;
	}

	@Override
	public String toString()
	{
		return String.format("OtherText [%s/%s]: %s", (textType == null) ? null : textType.name(),
				(textFormat == null) ? null : textFormat.name(), text);
	}

	public static List<OtherText> listFrom(com.tectonica.jonix.onix2.Product product)
	{
		if (product.otherTexts != null)
		{
			List<OtherText> result = new ArrayList<>();
			for (com.tectonica.jonix.onix2.OtherText i : product.otherTexts)
			{
				OtherTextTypes textTypeCode = i.getTextTypeCodeValue();
				TextFormats textFormatCode = i.getTextFormatValue();

				String text = i.getTextValue();
				if (text != null)
				{
					if (textFormatCode == null)
						textFormatCode = i.text.textformat;
				}
				result.add(new OtherText(textTypeCode, textFormatCode, text));
			}
			return result;
		}
		return Collections.emptyList();
	}
}