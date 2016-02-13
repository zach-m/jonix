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

import java.io.Serializable;
import java.util.List;

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.codelist.LanguageCodes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

@SuppressWarnings("serial")
public class ONIXMessage implements OnixSuperComposite, Serializable
{
	public static final String refname = "ONIXMessage";
	public static final String shortname = "ONIXmessage";
	public static final String release = "2.1";

	// ///////////////////////////////////////////////////////////////////////////////
	// ATTRIBUTES
	// ///////////////////////////////////////////////////////////////////////////////

	public TextFormats textformat;

	public TextCaseFlags textcase;

	public LanguageCodes language;

	public TransliterationSchemes transliteration;

	/**
	 * (type: DateOrDateTime)
	 */
	public String datestamp;

	public RecordSourceTypes sourcetype;

	public String sourcename;

	// ///////////////////////////////////////////////////////////////////////////////
	// MEMBERS
	// ///////////////////////////////////////////////////////////////////////////////

	/**
	 * (this field is optional)
	 */
	public Header header;

	/**
	 * (this list may be empty)
	 */
	public List<Product> products;

	/**
	 * (this list may be empty)
	 */
	public List<MainSeriesRecord> mainSeriesRecords;

	/**
	 * (this list may be empty)
	 */
	public List<SubSeriesRecord> subSeriesRecords;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public ONIXMessage()
	{}

	public ONIXMessage(org.w3c.dom.Element element)
	{
		textformat = TextFormats.byValue(JPU.getAttribute(element, "textformat"));
		textcase = TextCaseFlags.byValue(JPU.getAttribute(element, "textcase"));
		language = LanguageCodes.byValue(JPU.getAttribute(element, "language"));
		transliteration = TransliterationSchemes.byValue(JPU.getAttribute(element, "transliteration"));
		datestamp = JPU.getAttribute(element, "datestamp");
		sourcetype = RecordSourceTypes.byValue(JPU.getAttribute(element, "sourcetype"));
		sourcename = JPU.getAttribute(element, "sourcename");

		JPU.forElementsOf(element, new JPU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(Header.refname) || name.equals(Header.shortname))
					header = new Header(element);
				else if (name.equals(Product.refname) || name.equals(Product.shortname))
					products = JPU.addToList(products, new Product(element));
				else if (name.equals(MainSeriesRecord.refname) || name.equals(MainSeriesRecord.shortname))
					mainSeriesRecords = JPU.addToList(mainSeriesRecords, new MainSeriesRecord(element));
				else if (name.equals(SubSeriesRecord.refname) || name.equals(SubSeriesRecord.shortname))
					subSeriesRecords = JPU.addToList(subSeriesRecords, new SubSeriesRecord(element));
			}
		});
	}
}
