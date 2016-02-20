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

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.OnixComposite.OnixDataComposite;
import com.tectonica.jonix.codelist.LanguageCodes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;
import com.tectonica.jonix.struct.JonixBatchBonus;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <h1>Batch bonus composite</h1>
 * <p>
 * A repeatable group of data elements which together specify a batch bonus, <em>ie</em> a quantity of free copies which
 * are supplied with a certain order quantity. The &lt;BatchBonus&gt; composite is optional.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;BatchBonus&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;batchbonus&gt;</td>
 * </tr>
 * </table>
 */
public class BatchBonus implements OnixDataComposite, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "BatchBonus";
	public static final String shortname = "batchbonus";

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
	 * (this field is required)
	 */
	public BatchQuantity batchQuantity;

	/**
	 * (this field is required)
	 */
	public FreeQuantity freeQuantity;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public BatchBonus()
	{}

	public BatchBonus(org.w3c.dom.Element element)
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
				if (name.equals(BatchQuantity.refname) || name.equals(BatchQuantity.shortname))
					batchQuantity = new BatchQuantity(element);
				else if (name.equals(FreeQuantity.refname) || name.equals(FreeQuantity.shortname))
					freeQuantity = new FreeQuantity(element);
			}
		});
	}

	/**
	 * Format: Variable-length integer, suggested maximum length 4 digits
	 */
	public String getBatchQuantityValue()
	{
		return (batchQuantity == null) ? null : batchQuantity.value;
	}

	/**
	 * Format: Variable-length integer, suggested maximum length 4 digits
	 */
	public String getFreeQuantityValue()
	{
		return (freeQuantity == null) ? null : freeQuantity.value;
	}

	public JonixBatchBonus asJonixBatchBonus()
	{
		JonixBatchBonus x = new JonixBatchBonus();
		x.batchQuantity = JPU.convertStringToInteger(getBatchQuantityValue());
		x.freeQuantity = JPU.convertStringToInteger(getFreeQuantityValue());
		return x;
	}
}
