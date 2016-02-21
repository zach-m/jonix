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

package com.tectonica.jonix.onix3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.OnixComposite.OnixDataComposite;
import com.tectonica.jonix.codelist.IllustrationAndOtherContentTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixAncillaryContent;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <h1>Ancillary content composite</h1>
 * <p>
 * A repeatable group of data elements which together specify the number of illustrations or other content items of a
 * stated type which the product carries. Use of the &lt;AncillaryContent&gt; composite is optional.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;AncillaryContent&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;ancillarycontent&gt;</td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 */
public class AncillaryContent implements OnixDataComposite, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "AncillaryContent";
	public static final String shortname = "ancillarycontent";

	// ///////////////////////////////////////////////////////////////////////////////
	// ATTRIBUTES
	// ///////////////////////////////////////////////////////////////////////////////

	/**
	 * (type: dt.DateOrDateTime)
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
	public AncillaryContentType ancillaryContentType;

	/**
	 * (this list may be empty)
	 */
	public List<AncillaryContentDescription> ancillaryContentDescriptions;

	/**
	 * (this field is optional)
	 */
	public Number number;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public AncillaryContent()
	{}

	public AncillaryContent(org.w3c.dom.Element element)
	{
		datestamp = JPU.getAttribute(element, "datestamp");
		sourcetype = RecordSourceTypes.byValue(JPU.getAttribute(element, "sourcetype"));
		sourcename = JPU.getAttribute(element, "sourcename");

		JPU.forElementsOf(element, new JPU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(AncillaryContentType.refname) || name.equals(AncillaryContentType.shortname))
					ancillaryContentType = new AncillaryContentType(element);
				else if (name.equals(AncillaryContentDescription.refname)
						|| name.equals(AncillaryContentDescription.shortname))
					ancillaryContentDescriptions = JPU.addToList(ancillaryContentDescriptions,
							new AncillaryContentDescription(element));
				else if (name.equals(Number.refname) || name.equals(Number.shortname))
					number = new Number(element);
			}
		});
	}

	public IllustrationAndOtherContentTypes getAncillaryContentTypeValue()
	{
		return (ancillaryContentType == null) ? null : ancillaryContentType.value;
	}

	/**
	 * Raw Format: Variable-length text, suggested maximum length 100 characters. XHTML is enabled in this element - see
	 * Using XHTML, HTML or XML with ONIX text fields
	 */
	public List<String> getAncillaryContentDescriptionValues()
	{
		if (ancillaryContentDescriptions != null)
		{
			List<String> list = new ArrayList<>();
			for (AncillaryContentDescription i : ancillaryContentDescriptions)
				list.add(i.value);
			return list;
		}
		return null;
	}

	/**
	 * Raw Format: Variable-length integer, suggested maximum length 6 digits
	 */
	public Integer getNumberValue()
	{
		return (number == null) ? null : number.value;
	}

	public JonixAncillaryContent asJonixAncillaryContent()
	{
		JonixAncillaryContent x = new JonixAncillaryContent();
		x.ancillaryContentType = getAncillaryContentTypeValue();
		x.ancillaryContentDescriptions = getAncillaryContentDescriptionValues();
		x.number = getNumberValue();
		return x;
	}
}
