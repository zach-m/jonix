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

package com.tectonica.jonix.onix2;

import com.tectonica.jonix.DU;
import com.tectonica.jonix.codelist.DiscountCodeTypes;
import com.tectonica.jonix.codelist.LanguageCodeIso6392Bs;
import com.tectonica.jonix.codelist.RecordSourceTypeCodes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormatCodes;
import com.tectonica.jonix.codelist.TransliterationSchemeCodes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

public class DiscountCoded
{
	public static final String refname = "DiscountCoded";
	public static final String shortname = "discountcoded";

	public TextFormatCodes textformat;
	public TextCaseFlags textcase;
	public LanguageCodeIso6392Bs language;
	public TransliterationSchemeCodes transliteration;
	public String datestamp; // DateOrDateTime
	public RecordSourceTypeCodes sourcetype;
	public String sourcename;

	public DiscountCodeType discountCodeType; // Required
	public DiscountCodeTypeName discountCodeTypeName; // Optional
	public DiscountCode discountCode; // Required

	public static DiscountCoded fromDoc(org.w3c.dom.Element element)
	{
		final DiscountCoded x = new DiscountCoded();

		x.textformat = TextFormatCodes.byValue(DU.getAttribute(element, "textformat"));
		x.textcase = TextCaseFlags.byValue(DU.getAttribute(element, "textcase"));
		x.language = LanguageCodeIso6392Bs.byValue(DU.getAttribute(element, "language"));
		x.transliteration = TransliterationSchemeCodes.byValue(DU.getAttribute(element, "transliteration"));
		x.datestamp = DU.getAttribute(element, "datestamp");
		x.sourcetype = RecordSourceTypeCodes.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		DU.forElementsOf(element, new DU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(DiscountCodeType.refname) || name.equals(DiscountCodeType.shortname))
					x.discountCodeType = DiscountCodeType.fromDoc(element);
				else if (name.equals(DiscountCodeTypeName.refname) || name.equals(DiscountCodeTypeName.shortname))
					x.discountCodeTypeName = DiscountCodeTypeName.fromDoc(element);
				else if (name.equals(DiscountCode.refname) || name.equals(DiscountCode.shortname))
					x.discountCode = DiscountCode.fromDoc(element);
			}
		});

		return x;
	}

	public DiscountCodeTypes getDiscountCodeTypeValue()
	{
		return (discountCodeType == null) ? null : discountCodeType.value;
	}

	public String getDiscountCodeTypeNameValue()
	{
		return (discountCodeTypeName == null) ? null : discountCodeTypeName.value;
	}

	public String getDiscountCodeValue()
	{
		return (discountCode == null) ? null : discountCode.value;
	}
}
