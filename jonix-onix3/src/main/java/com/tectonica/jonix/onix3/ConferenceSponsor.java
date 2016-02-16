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
import com.tectonica.jonix.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.codelist.NameCodeTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixConferenceSponsorIdentifier;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <h1>Conference sponsor composite</h1>
 * <p>
 * An optional and repeatable group of data elements which together identify a sponsor of a conference. <em>Either</em>
 * an identifier, <em>or</em> one or other of &lt;PersonName&gt; or &lt;CorporateName&gt;, <em>or</em> both an
 * identifier and a name, must be present in each occurrence of the composite.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;ConferenceSponsor&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;conferencesponsor&gt;</td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 */
public class ConferenceSponsor implements OnixSuperComposite, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "ConferenceSponsor";
	public static final String shortname = "conferencesponsor";

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
	 * (this list is required to contain at least one item)
	 */
	public List<ConferenceSponsorIdentifier> conferenceSponsorIdentifiers;

	/**
	 * (this field is optional)
	 */
	public PersonName personName;

	/**
	 * (this field is optional)
	 */
	public CorporateName corporateName;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public ConferenceSponsor()
	{}

	public ConferenceSponsor(org.w3c.dom.Element element)
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
				if (name.equals(ConferenceSponsorIdentifier.refname)
						|| name.equals(ConferenceSponsorIdentifier.shortname))
					conferenceSponsorIdentifiers = JPU.addToList(conferenceSponsorIdentifiers,
							new ConferenceSponsorIdentifier(element));
				else if (name.equals(PersonName.refname) || name.equals(PersonName.shortname))
					personName = new PersonName(element);
				else if (name.equals(CorporateName.refname) || name.equals(CorporateName.shortname))
					corporateName = new CorporateName(element);
			}
		});
	}

	public String getPersonNameValue()
	{
		return (personName == null) ? null : personName.value;
	}

	public String getCorporateNameValue()
	{
		return (corporateName == null) ? null : corporateName.value;
	}

	public JonixConferenceSponsorIdentifier findConferenceSponsorIdentifier(NameCodeTypes conferenceSponsorIDType)
	{
		if (conferenceSponsorIdentifiers != null)
		{
			for (ConferenceSponsorIdentifier x : conferenceSponsorIdentifiers)
			{
				if (x.getConferenceSponsorIDTypeValue() == conferenceSponsorIDType)
					return x.asJonixConferenceSponsorIdentifier();
			}
		}
		return null;
	}

	public List<JonixConferenceSponsorIdentifier> findConferenceSponsorIdentifiers(
			java.util.Set<NameCodeTypes> conferenceSponsorIDTypes)
	{
		if (conferenceSponsorIdentifiers != null)
		{
			List<JonixConferenceSponsorIdentifier> matches = new ArrayList<>();
			for (ConferenceSponsorIdentifier x : conferenceSponsorIdentifiers)
			{
				if (conferenceSponsorIDTypes == null
						|| conferenceSponsorIDTypes.contains(x.getConferenceSponsorIDTypeValue()))
					matches.add(x.asJonixConferenceSponsorIdentifier());
			}
			return matches;
		}
		return null;
	}
}
