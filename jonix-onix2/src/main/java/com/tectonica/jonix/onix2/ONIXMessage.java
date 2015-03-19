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

import java.util.List;

import com.tectonica.jonix.DU;
import com.tectonica.jonix.codelist.LanguageCodeIso6392Bs;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

public class ONIXMessage
{
	public static final String refname = "ONIXMessage";
	public static final String shortname = "ONIXmessage";
	public static final String release = "2.1";

	public TextFormats textformat;
	public TextCaseFlags textcase;
	public LanguageCodeIso6392Bs language;
	public TransliterationSchemes transliteration;
	public String datestamp; // DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public Header header; // Optional
	public List<Product> products; // ZeroOrMore
	public List<MainSeriesRecord> mainSeriesRecords; // ZeroOrMore
	public List<SubSeriesRecord> subSeriesRecords; // ZeroOrMore

	public static ONIXMessage fromDoc(org.w3c.dom.Element element)
	{
		final ONIXMessage x = new ONIXMessage();

		x.textformat = TextFormats.byValue(DU.getAttribute(element, "textformat"));
		x.textcase = TextCaseFlags.byValue(DU.getAttribute(element, "textcase"));
		x.language = LanguageCodeIso6392Bs.byValue(DU.getAttribute(element, "language"));
		x.transliteration = TransliterationSchemes.byValue(DU.getAttribute(element, "transliteration"));
		x.datestamp = DU.getAttribute(element, "datestamp");
		x.sourcetype = RecordSourceTypes.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		DU.forElementsOf(element, new DU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(Header.refname) || name.equals(Header.shortname))
					x.header = Header.fromDoc(element);
				else if (name.equals(Product.refname) || name.equals(Product.shortname))
					x.products = DU.addToList(x.products, Product.fromDoc(element));
				else if (name.equals(MainSeriesRecord.refname) || name.equals(MainSeriesRecord.shortname))
					x.mainSeriesRecords = DU.addToList(x.mainSeriesRecords, MainSeriesRecord.fromDoc(element));
				else if (name.equals(SubSeriesRecord.refname) || name.equals(SubSeriesRecord.shortname))
					x.subSeriesRecords = DU.addToList(x.subSeriesRecords, SubSeriesRecord.fromDoc(element));
			}
		});

		return x;
	}
}
