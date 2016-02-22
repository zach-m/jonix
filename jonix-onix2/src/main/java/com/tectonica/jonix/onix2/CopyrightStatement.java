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
import java.util.ArrayList;
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

/**
 * <h1>Copyright statement composite</h1>
 * <p>
 * An optional and repeatable group of data elements which together represent a structured copyright statement for the
 * product. Either a structured copyright statement or statements, or a copyright year in the separate
 * &lt;CopyrightYear&gt; element which follows the composite, but not both, may be sent.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;CopyrightStatement&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;copyrightstatement&gt;</td>
 * </tr>
 * </table>
 */
public class CopyrightStatement implements OnixSuperComposite, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "CopyrightStatement";
	public static final String shortname = "copyrightstatement";

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
	 * (this list is required to contain at least one item)
	 */
	public List<CopyrightYear> copyrightYears;

	/**
	 * (this list is required to contain at least one item)
	 */
	public List<CopyrightOwner> copyrightOwners;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public CopyrightStatement()
	{}

	public CopyrightStatement(org.w3c.dom.Element element)
	{
		textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));
		textcase = TextCaseFlags.byCode(JPU.getAttribute(element, "textcase"));
		language = LanguageCodes.byCode(JPU.getAttribute(element, "language"));
		transliteration = TransliterationSchemes.byCode(JPU.getAttribute(element, "transliteration"));
		datestamp = JPU.getAttribute(element, "datestamp");
		sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
		sourcename = JPU.getAttribute(element, "sourcename");

		JPU.forElementsOf(element, new JPU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(CopyrightYear.refname) || name.equals(CopyrightYear.shortname))
					copyrightYears = JPU.addToList(copyrightYears, new CopyrightYear(element));
				else if (name.equals(CopyrightOwner.refname) || name.equals(CopyrightOwner.shortname))
					copyrightOwners = JPU.addToList(copyrightOwners, new CopyrightOwner(element));
			}
		});
	}

	/**
	 * Raw Format: Date as year only (YYYY)
	 */
	public List<String> getCopyrightYearValues()
	{
		if (copyrightYears != null)
		{
			List<String> list = new ArrayList<>();
			for (CopyrightYear i : copyrightYears)
				list.add(i.value);
			return list;
		}
		return null;
	}
}
