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
import com.tectonica.jonix.struct.JonixCopyrightOwnerIdentifier;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <h1>Copyright owner composite</h1>
 * <p>
 * A repeatable group of data elements which together name a copyright owner. Optional, so that a copyright statement
 * can be limited to &lt;CopyrightYear&gt;. Each occurrence of the &lt;CopyrightOwner&gt; composite must carry a single
 * name (personal or corporate), or an identifier, or both.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;CopyrightOwner&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;copyrightowner&gt;</td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 */
public class CopyrightOwner implements OnixSuperComposite, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "CopyrightOwner";
	public static final String shortname = "copyrightowner";

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
	public List<CopyrightOwnerIdentifier> copyrightOwnerIdentifiers;

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

	public CopyrightOwner()
	{}

	public CopyrightOwner(org.w3c.dom.Element element)
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
				if (name.equals(CopyrightOwnerIdentifier.refname) || name.equals(CopyrightOwnerIdentifier.shortname))
					copyrightOwnerIdentifiers = JPU.addToList(copyrightOwnerIdentifiers, new CopyrightOwnerIdentifier(
							element));
				else if (name.equals(PersonName.refname) || name.equals(PersonName.shortname))
					personName = new PersonName(element);
				else if (name.equals(CorporateName.refname) || name.equals(CorporateName.shortname))
					corporateName = new CorporateName(element);
			}
		});
	}

	/**
	 * Raw Format: Variable-length text, suggested maximum length 100 characters
	 */
	public String getPersonNameValue()
	{
		return (personName == null) ? null : personName.value;
	}

	/**
	 * Raw Format: Variable-length text, suggested maximum length 200 characters
	 */
	public String getCorporateNameValue()
	{
		return (corporateName == null) ? null : corporateName.value;
	}

	public JonixCopyrightOwnerIdentifier findCopyrightOwnerIdentifier(NameCodeTypes copyrightOwnerIDType)
	{
		if (copyrightOwnerIdentifiers != null)
		{
			for (CopyrightOwnerIdentifier x : copyrightOwnerIdentifiers)
			{
				if (x.getCopyrightOwnerIDTypeValue() == copyrightOwnerIDType)
					return x.asJonixCopyrightOwnerIdentifier();
			}
		}
		return null;
	}

	public List<JonixCopyrightOwnerIdentifier> findCopyrightOwnerIdentifiers(
			java.util.Set<NameCodeTypes> copyrightOwnerIDTypes)
	{
		if (copyrightOwnerIdentifiers != null)
		{
			List<JonixCopyrightOwnerIdentifier> matches = new ArrayList<>();
			for (CopyrightOwnerIdentifier x : copyrightOwnerIdentifiers)
			{
				if (copyrightOwnerIDTypes == null || copyrightOwnerIDTypes.contains(x.getCopyrightOwnerIDTypeValue()))
					matches.add(x.asJonixCopyrightOwnerIdentifier());
			}
			return matches;
		}
		return null;
	}
}
