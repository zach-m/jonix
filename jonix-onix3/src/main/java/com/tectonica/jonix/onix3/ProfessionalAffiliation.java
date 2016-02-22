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
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixProfessionalAffiliation;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <h1>Professional affiliation composite</h1>
 * <p>
 * A repeatable group of data elements which together identify a contributor’s professional position and/or affiliation,
 * allowing multiple positions and affiliations to be specified.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;ProfessionalAffiliation&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;professionalaffiliation&gt;</td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 */
public class ProfessionalAffiliation implements OnixDataComposite, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "ProfessionalAffiliation";
	public static final String shortname = "professionalaffiliation";

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
	public List<ProfessionalPosition> professionalPositions;

	/**
	 * (this field is optional)
	 */
	public Affiliation affiliation;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public ProfessionalAffiliation()
	{}

	public ProfessionalAffiliation(org.w3c.dom.Element element)
	{
		datestamp = JPU.getAttribute(element, "datestamp");
		sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
		sourcename = JPU.getAttribute(element, "sourcename");

		JPU.forElementsOf(element, new JPU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(ProfessionalPosition.refname) || name.equals(ProfessionalPosition.shortname))
					professionalPositions = JPU.addToList(professionalPositions, new ProfessionalPosition(element));
				else if (name.equals(Affiliation.refname) || name.equals(Affiliation.shortname))
					affiliation = new Affiliation(element);
			}
		});
	}

	/**
	 * Raw Format: Variable-length text, suggested maximum length 100 characters
	 */
	public List<String> getProfessionalPositionValues()
	{
		if (professionalPositions != null)
		{
			List<String> list = new ArrayList<>();
			for (ProfessionalPosition i : professionalPositions)
				list.add(i.value);
			return list;
		}
		return null;
	}

	/**
	 * Raw Format: Variable-length text, suggested maximum length 200 characters
	 */
	public String getAffiliationValue()
	{
		return (affiliation == null) ? null : affiliation.value;
	}

	public JonixProfessionalAffiliation asJonixProfessionalAffiliation()
	{
		JonixProfessionalAffiliation x = new JonixProfessionalAffiliation();
		x.affiliation = getAffiliationValue();
		x.professionalPositions = getProfessionalPositionValues();
		return x;
	}
}
