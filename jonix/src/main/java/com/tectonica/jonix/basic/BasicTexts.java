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

package com.tectonica.jonix.basic;

import java.util.ArrayList;
import java.util.List;

import com.tectonica.jonix.codelist.TextTypes;

/**
 * A {@link List} containing the multiple instances of ONIX2 &lt;OtherText&gt; / ONIX3 &lt;TextContent&gt; that may
 * exist in a product
 * 
 * @author Zach Melamed
 */
public class BasicTexts extends ArrayList<BasicText>
{
	private static final long serialVersionUID = 1L;

	public BasicTexts(com.tectonica.jonix.onix2.Product product)
	{
		if (product.otherTexts != null)
		{
			for (com.tectonica.jonix.onix2.OtherText otherText : product.otherTexts)
				add(new BasicText(otherText));
		}
	}

	public BasicTexts(com.tectonica.jonix.onix3.Product product)
	{
		if (product.collateralDetail.textContents != null)
		{
			for (com.tectonica.jonix.onix3.TextContent textContent : product.collateralDetail.textContents)
				add(new BasicText(textContent));
		}
	}

	public BasicText findText(TextTypes requestedType)
	{
		// we don't use product.findOtherText() because we need the 'textFormat' attribute, not just the value
		for (BasicText text : this)
		{
			if (text.textType == requestedType)
				return text;
		}
		return null;
	}
}
