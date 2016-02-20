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
import com.tectonica.jonix.codelist.ReligiousTextFeatureTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;
import com.tectonica.jonix.struct.JonixReligiousTextFeature;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <h1>Religious text composite</h1>
 * <p>
 * An optional, non-repeating, group of data elements which together describe features of the content of an edition of a
 * religious text, and intended to meet the special needs of religious publishers and booksellers. The
 * &lt;ReligiousText&gt; composite may carry either a &lt;Bible&gt; composite or a &lt;ReligiousTextID&gt; element
 * accompanied by multiple repeats of the &lt;ReligiousTextFeature&gt; composite. This approach is adopted to enable
 * other devotional texts to be included if need arises without requiring a new ONIX release.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;ReligiousText&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;religioustext&gt;</td>
 * </tr>
 * </table>
 */
public class ReligiousText implements OnixSuperComposite, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "ReligiousText";
	public static final String shortname = "religioustext";

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
	public Bible bible;

	/**
	 * (this field is required)
	 */
	public ReligiousTextID religiousTextID;

	/**
	 * (this list is required to contain at least one item)
	 */
	public List<ReligiousTextFeature> religiousTextFeatures;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public ReligiousText()
	{}

	public ReligiousText(org.w3c.dom.Element element)
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
				if (name.equals(Bible.refname) || name.equals(Bible.shortname))
					bible = new Bible(element);
				else if (name.equals(ReligiousTextID.refname) || name.equals(ReligiousTextID.shortname))
					religiousTextID = new ReligiousTextID(element);
				else if (name.equals(ReligiousTextFeature.refname) || name.equals(ReligiousTextFeature.shortname))
					religiousTextFeatures = JPU.addToList(religiousTextFeatures, new ReligiousTextFeature(element));
			}
		});
	}

	/**
	 * Format: Fixed-length, two numeric digits
	 */
	public String getReligiousTextIDValue()
	{
		return (religiousTextID == null) ? null : religiousTextID.value;
	}

	public JonixReligiousTextFeature findReligiousTextFeature(ReligiousTextFeatureTypes religiousTextFeatureType)
	{
		if (religiousTextFeatures != null)
		{
			for (ReligiousTextFeature x : religiousTextFeatures)
			{
				if (x.getReligiousTextFeatureTypeValue() == religiousTextFeatureType)
					return x.asJonixReligiousTextFeature();
			}
		}
		return null;
	}

	public List<JonixReligiousTextFeature> findReligiousTextFeatures(
			java.util.Set<ReligiousTextFeatureTypes> religiousTextFeatureTypes)
	{
		if (religiousTextFeatures != null)
		{
			List<JonixReligiousTextFeature> matches = new ArrayList<>();
			for (ReligiousTextFeature x : religiousTextFeatures)
			{
				if (religiousTextFeatureTypes == null
						|| religiousTextFeatureTypes.contains(x.getReligiousTextFeatureTypeValue()))
					matches.add(x.asJonixReligiousTextFeature());
			}
			return matches;
		}
		return null;
	}
}
