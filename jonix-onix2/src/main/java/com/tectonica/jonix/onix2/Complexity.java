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
import com.tectonica.jonix.codelist.ComplexitySchemeIdentifiers;
import com.tectonica.jonix.codelist.LanguageCodes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;
import com.tectonica.jonix.struct.JonixComplexity;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

@SuppressWarnings("serial")
public class Complexity implements OnixDataComposite, Serializable
{
	public static final String refname = "Complexity";
	public static final String shortname = "complexity";

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
	public ComplexitySchemeIdentifier complexitySchemeIdentifier;

	/**
	 * (this field is required)
	 */
	public ComplexityCode complexityCode;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public Complexity()
	{}

	public Complexity(org.w3c.dom.Element element)
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
				if (name.equals(ComplexitySchemeIdentifier.refname)
						|| name.equals(ComplexitySchemeIdentifier.shortname))
					complexitySchemeIdentifier = new ComplexitySchemeIdentifier(element);
				else if (name.equals(ComplexityCode.refname) || name.equals(ComplexityCode.shortname))
					complexityCode = new ComplexityCode(element);
			}
		});
	}

	public ComplexitySchemeIdentifiers getComplexitySchemeIdentifierValue()
	{
		return (complexitySchemeIdentifier == null) ? null : complexitySchemeIdentifier.value;
	}

	public String getComplexityCodeValue()
	{
		return (complexityCode == null) ? null : complexityCode.value;
	}

	public JonixComplexity asJonixComplexity()
	{
		JonixComplexity x = new JonixComplexity();
		x.complexityCode = getComplexityCodeValue();
		x.complexitySchemeIdentifier = getComplexitySchemeIdentifierValue();
		return x;
	}
}
