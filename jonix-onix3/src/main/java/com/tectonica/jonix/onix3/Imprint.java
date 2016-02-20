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
import com.tectonica.jonix.struct.JonixImprintIdentifier;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <h1>Imprint or brand composite</h1>
 * <p>
 * A repeatable group of data elements which together identify an imprint or brand under which the product is marketed.
 * The composite must carry either a name identifier or a name or both.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;Imprint&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;imprint&gt;</td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 */
public class Imprint implements OnixSuperComposite, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "Imprint";
	public static final String shortname = "imprint";

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
	public List<ImprintIdentifier> imprintIdentifiers;

	/**
	 * (this field is optional)
	 */
	public ImprintName imprintName;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public Imprint()
	{}

	public Imprint(org.w3c.dom.Element element)
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
				if (name.equals(ImprintIdentifier.refname) || name.equals(ImprintIdentifier.shortname))
					imprintIdentifiers = JPU.addToList(imprintIdentifiers, new ImprintIdentifier(element));
				else if (name.equals(ImprintName.refname) || name.equals(ImprintName.shortname))
					imprintName = new ImprintName(element);
			}
		});
	}

	/**
	 * Format: Variable length text, suggested maximum length 100 characters
	 */
	public String getImprintNameValue()
	{
		return (imprintName == null) ? null : imprintName.value;
	}

	public JonixImprintIdentifier findImprintIdentifier(NameCodeTypes imprintIDType)
	{
		if (imprintIdentifiers != null)
		{
			for (ImprintIdentifier x : imprintIdentifiers)
			{
				if (x.getImprintIDTypeValue() == imprintIDType)
					return x.asJonixImprintIdentifier();
			}
		}
		return null;
	}

	public List<JonixImprintIdentifier> findImprintIdentifiers(java.util.Set<NameCodeTypes> imprintIDTypes)
	{
		if (imprintIdentifiers != null)
		{
			List<JonixImprintIdentifier> matches = new ArrayList<>();
			for (ImprintIdentifier x : imprintIdentifiers)
			{
				if (imprintIDTypes == null || imprintIDTypes.contains(x.getImprintIDTypeValue()))
					matches.add(x.asJonixImprintIdentifier());
			}
			return matches;
		}
		return null;
	}
}
